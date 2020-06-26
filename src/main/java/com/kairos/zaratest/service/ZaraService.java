package com.kairos.zaratest.service;

import com.kairos.zaratest.domain.PriceInformationResponse;
import com.kairos.zaratest.model.PriceInfo;
import com.kairos.zaratest.repository.ZaraTestRepository;
import com.kairos.zaratest.service.mappers.ZaraTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZaraService {
    private ZaraTestRepository zaraTestRepository;
    private ZaraTestMapper zaraTestMapper;

    @Autowired
    public ZaraService(ZaraTestRepository zaraTestRepository, ZaraTestMapper zaraTestMapper) {
        this.zaraTestRepository = zaraTestRepository;
        this.zaraTestMapper = zaraTestMapper;
    }

    public PriceInformationResponse getPriceInformation(String date, String productId, Integer brandId) {
        List<PriceInfo> all = (List<PriceInfo>) zaraTestRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(productId, brandId, date, date);

        PriceInfo first = all.get(0);

        return zaraTestMapper.entityToPriceInformationResponse(first);
    }
}
