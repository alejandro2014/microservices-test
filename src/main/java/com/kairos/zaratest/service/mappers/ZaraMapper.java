package com.kairos.zaratest.service.mappers;

import com.kairos.zaratest.domain.PriceInformationResponse;
import com.kairos.zaratest.model.PriceInfo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ZaraMapper {
    private ModelMapper modelMapper;

    public ZaraMapper() {
        this.modelMapper = new ModelMapper();
    }

    public PriceInformationResponse entityToPriceInformationResponse(PriceInfo entity) {
        return modelMapper.map(entity, PriceInformationResponse.class);
    }
}
