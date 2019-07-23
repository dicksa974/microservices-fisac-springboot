package com.egokia.banniere.service;

import com.egokia.composite.api.ReservationReader;
import com.egokia.composite.api.VenueReader;
import com.egokia.composite.model.BookingDetail;
import com.egokia.composite.model.PublishModel;
import com.egokia.composite.model.Reservation;
import com.egokia.composite.model.Venue;
import com.egokia.composite.publish.KafkaProducer;
import com.egokia.composite.util.JsonUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aniruth Parthasarathy
 */
@Service
@Slf4j
public class ServiceImpl {


    @Value("${spring.cloud.stream.bindings.output.destination}")
    private String TOPIC;

    @Autowired
    private ReservationReader reservationReader;

    @Autowired
    private VenueReader venueReader;

    @Autowired
    private KafkaProducer kafkaProducer;

    private BookingDetail bookingsError(long id, String token) {
        Venue v = new Venue();
        v.setVenueName("Dummy Venue");
        v.setReservationId(id);
        v.setBookingDate("2007-09-01 10:14:33");
        List<Venue> venues = new ArrayList<>();
        venues.add(v);
        Reservation reservation = new Reservation();
        reservation.setFirstName("Dummy");
        reservation.setLastName("Name");

        BookingDetail bd = new BookingDetail();
        bd.setReservation(reservation);
        bd.setVenues(venues);
        return bd;
    }

    @HystrixCommand(fallbackMethod = "bookingsError")
    @Cacheable(cacheNames = "bookings")
    public BookingDetail bookings(long id, String token) {
        Reservation reservation = this
                .reservationReader
                .findById(id, token)
                .getContent();
        log.info("Got the reservation " + reservation.toString());
        List<Venue> venues = this
                .venueReader
                .findByReservationId(id, token);
        log.info("Got the venues " + venues.toString());

        BookingDetail bd = new BookingDetail();
        bd.setReservation(reservation);
        bd.setVenues(venues);
        return bd;
    }

    @HystrixCommand(fallbackMethod = "bookingUpdateError")
    public ResponseEntity<Void> bookingUpdate(long id, Reservation reservation, String token) {
        log.info("Before Update.. For id = " + id + " ; " + reservation.toString());

        try {
            log.info("Got the reservation " + reservation.toString());
            Reservation updatedReservation = this
                    .reservationReader
                    .updateReservation(id, reservation, token)
                    .getContent();
            log.info("Updated reservation " + updatedReservation.toString());

            //We will update the reservationName in Venue service through Kafka Event
            PublishModel publishModel = new PublishModel();
            publishModel.setId(id);
            publishModel.setReservationName(reservation.getReservationName());
            kafkaProducer.sendMessage(TOPIC, JsonUtil.toJson(publishModel));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ResponseEntity<Void> bookingUpdateError(long id, Reservation reservation, String token) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
