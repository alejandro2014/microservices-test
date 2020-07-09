package com.kairos.techincaltest.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PriceInformationResponse {
    private String productId;
    private String brandId;
    private Integer priceList;
    private String startDate;
    private String endDate;
}
