package com.kairos.zaratest.service;

import com.kairos.zaratest.domain.PriceInformationResponse;
import com.kairos.zaratest.model.PriceInfo;
import com.kairos.zaratest.repository.ZaraTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZaraTestService {
    private ZaraTestRepository zaraTestRepository;

    @Autowired
    public ZaraTestService(ZaraTestRepository zaraTestRepository) {
        this.zaraTestRepository = zaraTestRepository;
    }

    public PriceInformationResponse getPriceInformation() {
        List<PriceInfo> all = (List<PriceInfo>) zaraTestRepository.findAll();

        System.out.println(all);

        return null;
    }
}
