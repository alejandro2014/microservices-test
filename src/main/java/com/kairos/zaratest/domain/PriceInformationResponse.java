package com.kairos.zaratest.domain;

import lombok.Data;

@Data
public class PriceInformationResponse {
    private String productId;
    private String stringId;
    private Integer priceList;
    private String startDate;
    private String endDate;
}
