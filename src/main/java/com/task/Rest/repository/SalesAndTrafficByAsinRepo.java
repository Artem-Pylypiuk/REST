package com.task.Rest.repository;

import com.task.Rest.model.SalesAndTrafficByAsin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SalesAndTrafficByAsinRepo extends MongoRepository<SalesAndTrafficByAsin,String> {
    @Query("{ 'parentAsin': ?0 }")
    List<SalesAndTrafficByAsin> findBySalesAndTrafficByAsin_ParentAsin(String asin);
    @Query("{ 'parentAsin': { $in: ?0 } }")
    List<SalesAndTrafficByAsin> findBySalesAndTrafficByAsin_ParentAsinIn(List<String> asins);
}
