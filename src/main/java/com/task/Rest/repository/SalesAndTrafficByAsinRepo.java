package com.task.Rest.repository;

import com.task.Rest.model.SalesAndTrafficByAsin;
import com.task.Rest.model.Statistics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SalesAndTrafficByAsinRepo extends MongoRepository<SalesAndTrafficByAsin,String> {
    @Query("{ 'salesAndTrafficByAsin.parentAsin': ?0 }")
    List<SalesAndTrafficByAsin> findBySalesAndTrafficByAsin_ParentAsin(String asin);
    @Query("{ 'salesAndTrafficByAsin.parentAsin': { $in: ?0 } }")
    List<SalesAndTrafficByAsin> findBySalesAndTrafficByAsin_ParentAsinIn(List<String> asins);
}
