package com.kairos.zaratest.repository;

import com.kairos.zaratest.model.PriceInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZaraTestRepository extends CrudRepository<PriceInfo, Integer> {
    Iterable<PriceInfo> findAll();
    Iterable<PriceInfo> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(String productId, Integer brandId, String date1, String date2);
}
