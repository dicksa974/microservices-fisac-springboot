package com.egokia.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by auth.c.parthasarathy on 11/3/16.
 */
@RestController
public class PrincipalRestController {
    @RequestMapping("/user")
    Principal principal (Principal principal) {
        return principal;
    }

}
