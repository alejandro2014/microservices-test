package com.kairos.techincaltest.controllers;

import com.kairos.techincaltest.domain.PriceInformationResponse;
import com.kairos.techincaltest.service.TechnicalTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@Validated
public class TechnicalTestController {
    @Autowired
    private TechnicalTestService technicalTestService;

    @GetMapping(value = "/priceinfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceInformationResponse> getPriceInformation(
            HttpServletRequest httpRequest,
            @RequestParam String date,
            @RequestParam String productId,
            @RequestParam Integer brandId) {
        PriceInformationResponse response = technicalTestService.getPriceInformation(date, productId, brandId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
