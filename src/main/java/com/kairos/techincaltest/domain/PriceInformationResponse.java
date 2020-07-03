package com.kairos.techincaltest.domain;

import lombok.Data;

@Data
public class PriceInformationResponse {
    private String productId;
    private String brandId;
    private Integer priceList;
    private String startDate;
    private String endDate;
}
