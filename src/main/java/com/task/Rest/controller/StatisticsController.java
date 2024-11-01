package com.task.Rest.controller;

import com.task.Rest.model.SalesAndTrafficByAsin;
import com.task.Rest.model.SalesAndTrafficByDate;
import com.task.Rest.service.SalesAndTrafficByAsinService;
import com.task.Rest.service.SalesAndTrafficByDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {
    @Autowired
    private SalesAndTrafficByAsinService salesAndTrafficByAsinService;
    @Autowired
    private SalesAndTrafficByDateService salesAndTrafficByDateService;

    @Cacheable("salesAndTrafficByDate")
    @GetMapping("/date/{date}")
    public List<SalesAndTrafficByDate> getSalesAndTrafficByDate(@PathVariable String date){
        return salesAndTrafficByDateService.findByDate(date);
    }

    @Cacheable("salesAndTrafficByAsin")
    @GetMapping("/asin/{asin}")
    public List<SalesAndTrafficByAsin> getSalesAndTrafficByAsin(@PathVariable String asin){
        return salesAndTrafficByAsinService.findByAsin(asin);
    }

    @Cacheable("salesAndTrafficByDate")
    @GetMapping("/date-range")
    public List<SalesAndTrafficByDate> getSalesAndTrafficByDateRange(@RequestParam String start, @RequestParam String end) {
        return salesAndTrafficByDateService.findByDateRange(start, end);
    }
    @Cacheable("salesAndTrafficByAsin")
    @GetMapping("/asins")
    public List<SalesAndTrafficByAsin> getSalesAndTrafficByAsinList(@RequestParam List<String> asins) {
        return salesAndTrafficByAsinService.findByAsinRange(asins);
    }

    @Cacheable("salesAndTrafficByDate")
    @GetMapping("/date/all")
    public List<SalesAndTrafficByDate> getDateAll(){
        return salesAndTrafficByDateService.getAllStatisticDate();
    }

    @Cacheable("salesAndTrafficByAsin")
    @GetMapping("/asin/all")
    public List<SalesAndTrafficByAsin> getAsinAll(){
        return salesAndTrafficByAsinService.getAllStatisticAsin();
    }


}
