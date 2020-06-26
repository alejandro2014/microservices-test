package com.kairos.zaratest.service;

import com.kairos.zaratest.domain.PriceInformationResponse;
import com.kairos.zaratest.model.PriceInfo;
import com.kairos.zaratest.repository.ZaraTestRepository;
import com.kairos.zaratest.service.mappers.ZaraTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZaraTestService {
    private ZaraTestRepository zaraTestRepository;
    private ZaraTestMapper zaraTestMapper;

    @Autowired
    public ZaraTestService(ZaraTestRepository zaraTestRepository, ZaraTestMapper zaraTestMapper) {
        this.zaraTestRepository = zaraTestRepository;
        this.zaraTestMapper = zaraTestMapper;
    }

    public PriceInformationResponse getPriceInformation(String date, String productId, String stringId) {
        List<PriceInfo> all = (List<PriceInfo>) zaraTestRepository.findByProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(productId, date, date);

        PriceInfo first = all.get(0);

        return zaraTestMapper.entityToPriceInformationResponse(first, stringId);
    }
}
