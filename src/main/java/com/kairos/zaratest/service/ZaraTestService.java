package com.kairos.zaratest.service;

import com.kairos.zaratest.domain.PriceInformationResponse;
import com.kairos.zaratest.repository.ZaraTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZaraTestService {
    @Autowired
    private ZaraTestRepository zaraTestRepository;

    public ZaraTestService() {

    }

    public PriceInformationResponse getPriceInformation() {
        return null;
    }
}
