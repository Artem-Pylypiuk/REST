package com.task.Rest.repository;

import com.task.Rest.model.Statistics;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatisticsRepository extends MongoRepository<Statistics,String> {

}
