package com.task.Rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.Rest.model.SalesAndTrafficByAsin;
import com.task.Rest.model.SalesAndTrafficByDate;
import com.task.Rest.model.Statistics;
import com.task.Rest.repository.SalesAndTrafficByAsinRepo;
import com.task.Rest.repository.SalesAndTrafficByDateRepo;
import com.task.Rest.repository.StatisticsRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class StatisticsService {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsService.class);
    private final ObjectMapper objectMapper;
    private final StatisticsRepository statisticsRepository;
    @Autowired
    private  SalesAndTrafficByDateRepo salesAndTrafficByDateRepo;
    @Autowired
    private  SalesAndTrafficByAsinRepo salesAndTrafficByAsinRepo;

    @Autowired
    public StatisticsService(ObjectMapper objectMapper, StatisticsRepository statisticsRepository) {
        this.objectMapper = objectMapper;
        this.statisticsRepository = statisticsRepository;
    }

    @Async
    @Scheduled(initialDelay = 0, fixedRate = 300000)
    public void loadStatisticsFromJson() {
        String filename = "C:\\Users\\xika0\\Desktop\\test_report.json";
        try {
            Statistics statistics = objectMapper.readValue(new File(filename), Statistics.class);

            // Теперь можно сохранять данные, например:
            for (SalesAndTrafficByDate data : statistics.getSalesAndTrafficByDate()) {
                if (!salesAndTrafficByDateRepo.findBySalesAndTrafficByDate_Date(data.getDate()).isEmpty() && salesAndTrafficByDateRepo.findBySalesAndTrafficByDate_Date(data.getDate()).get(0).toString().equals(data.toString())) {
                    continue;
                }
                salesAndTrafficByDateRepo.save(data);
            }

            for (SalesAndTrafficByAsin data : statistics.getSalesAndTrafficByAsin()) {
                if(!salesAndTrafficByAsinRepo.findBySalesAndTrafficByAsin_ParentAsin(data.getParentAsin()).isEmpty()&& salesAndTrafficByAsinRepo.findBySalesAndTrafficByAsin_ParentAsin(data.getParentAsin()).get(0).toString().equals(data.toString())){
                    continue;
                }
                salesAndTrafficByAsinRepo.save(data);
            }

            logger.info("Data loaded successfully from JSON file.");
        } catch (IOException e) {
            logger.error("Error reading or saving statistics from JSON file: {}", e.getMessage());
        }
    }

    @PostConstruct
    public void init() {
        logger.info("Initializing data load on application startup...");
        loadStatisticsFromJson();
    }
}
