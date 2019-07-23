package com.egokia.venue.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by auth.c.parthasarathy on 10/18/16.
 */
@Data
public class Response {
    int totalPages;
    long totalRecords;

    List<Object> result = new ArrayList<Object>();

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<Object> getResult() {
        return result;
    }

    public void setResult(List<Object> result) {
        this.result = result;
    }
}
