package com.kairos.techincaltest.service;

import com.kairos.techincaltest.domain.PriceInformationResponse;
import com.kairos.techincaltest.model.PriceInfo;
import com.kairos.techincaltest.repositories.TechnicalTestRepository;
import com.kairos.techincaltest.service.mappers.TechnicalTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalTestService {
    private TechnicalTestRepository technicalTestRepository;
    private TechnicalTestMapper technicalTestMapper;

    @Autowired
    public TechnicalTestService(TechnicalTestRepository technicalTestRepository, TechnicalTestMapper technicalTestMapper) {
        this.technicalTestRepository = technicalTestRepository;
        this.technicalTestMapper = technicalTestMapper;
    }

    public PriceInformationResponse getPriceInformation(String date, String productId, Integer brandId) {
        List<PriceInfo> all = (List<PriceInfo>) technicalTestRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(productId, brandId, date, date);

        PriceInfo first = all.get(0);

        return technicalTestMapper.entityToPriceInformationResponse(first);
    }
}
