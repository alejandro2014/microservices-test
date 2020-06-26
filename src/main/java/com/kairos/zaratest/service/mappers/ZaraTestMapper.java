package com.kairos.zaratest.service.mappers;

import com.kairos.zaratest.domain.PriceInformationResponse;
import com.kairos.zaratest.model.PriceInfo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ZaraTestMapper {
    private ModelMapper modelMapper;

    public ZaraTestMapper() {
        this.modelMapper = new ModelMapper();
    }

    public PriceInformationResponse entityToPriceInformationResponse(PriceInfo entity, String stringId) {
        PriceInformationResponse result = modelMapper.map(entity, PriceInformationResponse.class);
        result.setStringId(stringId);

        return result;
    }
}
