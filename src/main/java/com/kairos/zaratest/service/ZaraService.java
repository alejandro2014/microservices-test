package com.kairos.zaratest.service;

import com.kairos.zaratest.domain.PriceInformationResponse;
import com.kairos.zaratest.model.PriceInfo;
import com.kairos.zaratest.repositories.ZaraRepository;
import com.kairos.zaratest.service.mappers.ZaraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZaraService {
    private ZaraRepository zaraRepository;
    private ZaraMapper zaraMapper;

    @Autowired
    public ZaraService(ZaraRepository zaraRepository, ZaraMapper zaraMapper) {
        this.zaraRepository = zaraRepository;
        this.zaraMapper = zaraMapper;
    }

    public PriceInformationResponse getPriceInformation(String date, String productId, Integer brandId) {
        List<PriceInfo> all = (List<PriceInfo>) zaraRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(productId, brandId, date, date);

        PriceInfo first = all.get(0);

        return zaraMapper.entityToPriceInformationResponse(first);
    }
}
