package com.task.Rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.Rest.model.Statistics;
import com.task.Rest.repository.StatisticsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class StatisticsService {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsService.class);
    private final ObjectMapper objectMapper;
    private final StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsService(ObjectMapper objectMapper, StatisticsRepository statisticsRepository) {
        this.objectMapper = objectMapper;
        this.statisticsRepository = statisticsRepository;
    }

    @Async
    @Scheduled(fixedRate = 300000)
    public void loadStatisticsFromJson() {
        String filename = "C:\\Users\\xika0\\Desktop\\test_report.json";
        try {
            List<Statistics> statisticsList = objectMapper.readValue(new File(filename), new TypeReference<List<Statistics>>() {});

            for (Statistics statistics : statisticsList) {
                statisticsRepository.save(statistics);
            }
        } catch (IOException e) {
            logger.error("Error reading or saving statistics from JSON file: {}", e.getMessage());
        }
    }
}
