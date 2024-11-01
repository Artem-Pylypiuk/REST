package com.task.Rest.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "SalesAndTrafficByDate")
@Data
public class SalesAndTrafficByDate {
    private String date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;

    @Data
    public static class SalesByDate {
        private MonetaryAmount orderedProductSales;
        private MonetaryAmount orderedProductSalesB2B;
        private int unitsOrdered;
        private int unitsOrderedB2B;
        private int totalOrderItems;
        private int totalOrderItemsB2B;
        private double averageUnitsPerOrderItem;
        private double averageUnitsPerOrderItemB2B;
        private MonetaryAmount averageSalesPerOrderItem;
        private MonetaryAmount averageSalesPerOrderItemB2B;
        private MonetaryAmount averageSellingPrice;
        private MonetaryAmount averageSellingPriceB2B;
        private int unitsRefunded;
        private double refundRate;
        private MonetaryAmount claimsAmount;
        private MonetaryAmount shippedProductSales;
        private int unitsShipped;
        private int ordersShipped;
    }
    @Data
    public static class TrafficByDate {
        private int browserPageViews;
        private int browserPageViewsB2B;
        private int mobileAppPageViews;
        private int mobileAppPageViewsB2B;
        private int pageViews;
        private int pageViewsB2B;
        private int browserSessions;
        private int browserSessionsB2B;
        private int mobileAppSessions;
        private int mobileAppSessionsB2B;
        private int sessions;
        private int sessionsB2B;
        private double buyBoxPercentage;
        private double buyBoxPercentageB2B;
        private double orderItemSessionPercentage;
        private double orderItemSessionPercentageB2B;
        private double unitSessionPercentage;
        private double unitSessionPercentageB2B;
        private int averageOfferCount;
        private int averageParentItems;
        private int feedbackReceived;
        private int negativeFeedbackReceived;
        private double receivedNegativeFeedbackRate;
    }
    @Data
    public static class MonetaryAmount {
        private BigDecimal amount;
        private String currencyCode;
    }
}
