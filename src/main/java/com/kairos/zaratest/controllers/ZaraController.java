package com.kairos.zaratest.controllers;

import com.kairos.zaratest.domain.PriceInformationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ZaraController {
    @GetMapping(value = "/")
    public ResponseEntity<PriceInformationResponse> getHola(
            HttpServletRequest httpRequest,
            String date,
            String productId,
            String stringId) {
        var response = new PriceInformationResponse();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
