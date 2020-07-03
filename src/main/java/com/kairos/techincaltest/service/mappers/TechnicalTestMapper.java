package com.kairos.techincaltest.service.mappers;

import com.kairos.techincaltest.domain.PriceInformationResponse;
import com.kairos.techincaltest.model.PriceInfo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TechnicalTestMapper {
    private ModelMapper modelMapper;

    public TechnicalTestMapper() {
        this.modelMapper = new ModelMapper();
    }

    public PriceInformationResponse entityToPriceInformationResponse(PriceInfo entity) {
        return modelMapper.map(entity, PriceInformationResponse.class);
    }
}
