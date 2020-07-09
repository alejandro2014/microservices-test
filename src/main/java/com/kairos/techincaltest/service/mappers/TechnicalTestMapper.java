package com.kairos.techincaltest.service.mappers;

import com.kairos.techincaltest.domain.PriceInformationResponse;
import com.kairos.techincaltest.model.PriceInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TechnicalTestMapper {
    private ModelMapper modelMapper;

    @Autowired
    public TechnicalTestMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PriceInformationResponse entityToPriceInformationResponse(PriceInfo entity) {
        return modelMapper.map(entity, PriceInformationResponse.class);
    }
}
