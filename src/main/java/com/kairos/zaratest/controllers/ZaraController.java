package com.kairos.zaratest.controllers;

import com.kairos.zaratest.domain.PriceInformationResponse;
import com.kairos.zaratest.model.PriceInfo;
import com.kairos.zaratest.service.ZaraTestService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<PriceInfo> getPriceInformation(
            HttpServletRequest httpRequest,
            @RequestParam String date,
            @RequestParam String productId,
            @RequestParam String stringId) {
        PriceInfo response = zaraTestService.getPriceInformation(date, productId, stringId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
