package com.kairos.techincaltest.repositories;

import com.kairos.techincaltest.model.PriceInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalTestRepository extends CrudRepository<PriceInfo, Integer> {
    Iterable<PriceInfo> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(String productId, Integer brandId, String date1, String date2);
}
