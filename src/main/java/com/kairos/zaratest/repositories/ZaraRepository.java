package com.kairos.zaratest.repositories;

import com.kairos.zaratest.model.PriceInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZaraRepository extends CrudRepository<PriceInfo, Integer> {
    Iterable<PriceInfo> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(String productId, Integer brandId, String date1, String date2);
}
