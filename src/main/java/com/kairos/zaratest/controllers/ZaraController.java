package com.kairos.zaratest.controllers;

import com.kairos.zaratest.domain.PriceInformationResponse;
import com.kairos.zaratest.service.ZaraTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ZaraController {
    private ZaraTestService zaraTestService;

    @Autowired
    public ZaraController(ZaraTestService zaraTestService) {
        this.zaraTestService = zaraTestService;
    }

    @GetMapping(value = "/priceinfo")
    public ResponseEntity<PriceInformationResponse> getPriceInformation(
            HttpServletRequest httpRequest,
            String date,
            String productId,
            String stringId) {
        PriceInformationResponse response = zaraTestService.getPriceInformation();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
