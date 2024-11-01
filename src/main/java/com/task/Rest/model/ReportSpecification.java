    package com.task.Rest.model;

    import lombok.Data;
    import org.springframework.data.mongodb.core.mapping.Document;

    import java.util.List;

    @Data
    @Document(collection = "ReportSpecification")
    public class ReportSpecification {
        private String reportType;
        private ReportOptions reportOptions;
        private String dataStartTime;
        private String dataEndTime;
        private List<String> marketplaceIds;
        @Data
        public static class ReportOptions {
            private String dateGranularity;
            private String asinGranularity;
        }
    }
