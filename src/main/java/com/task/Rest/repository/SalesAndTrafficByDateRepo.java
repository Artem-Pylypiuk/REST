package com.task.Rest.repository;

import com.task.Rest.model.SalesAndTrafficByDate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SalesAndTrafficByDateRepo extends MongoRepository<SalesAndTrafficByDate,String> {
    @Query("{ 'date': ?0 }")
    List<SalesAndTrafficByDate> findBySalesAndTrafficByDate_Date(String date);
    @Query("{ 'date': { $gte: ?0, $lte: ?1 } }")
    List<SalesAndTrafficByDate> findBySalesAndTrafficByDate_DateBetween(String startDate, String endDate);
}
