package com.kairos.techincaltest.repositories;

import com.kairos.techincaltest.model.PriceInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TechnicalTestRepository extends CrudRepository<PriceInfo, Integer> {
    List<PriceInfo> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(String productId, Integer brandId, String date1, String date2);
}
