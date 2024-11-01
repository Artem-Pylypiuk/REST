package com.task.Rest.service;

import com.task.Rest.model.SalesAndTrafficByAsin;
import com.task.Rest.repository.SalesAndTrafficByAsinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesAndTrafficByAsinService {
    @Autowired
    private SalesAndTrafficByAsinRepo salesAndTrafficByAsinRepo;

    public List<SalesAndTrafficByAsin> findByAsin(String asin){
        return salesAndTrafficByAsinRepo.findBySalesAndTrafficByAsin_ParentAsin(asin);
    }

    public List<SalesAndTrafficByAsin> findByAsinRange(List<String> asin){
        return salesAndTrafficByAsinRepo.findBySalesAndTrafficByAsin_ParentAsinIn(asin);
    }
    public List<SalesAndTrafficByAsin> getAllStatisticAsin(){
        return salesAndTrafficByAsinRepo.findAll();
    }
}
