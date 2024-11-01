package com.task.Rest.service;

import com.task.Rest.model.SalesAndTrafficByDate;
import com.task.Rest.repository.SalesAndTrafficByDateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesAndTrafficByDateService {
    @Autowired
    private SalesAndTrafficByDateRepo salesAndTrafficByDateRepo;

    public List<SalesAndTrafficByDate> findByDate(String date){
        return salesAndTrafficByDateRepo.findBySalesAndTrafficByDate_Date(date);
    }

    public List<SalesAndTrafficByDate> findByDateRange(String dateStart,String dateEnd){
        return salesAndTrafficByDateRepo.findBySalesAndTrafficByDate_DateBetween(dateStart,dateEnd);
    }
    public List<SalesAndTrafficByDate> getAllStatisticDate(){
        return salesAndTrafficByDateRepo.findAll();
    }
}
