package io.prometheus.client;

import java.util.Arrays;
import java.util.List;

class Environment {

    private static final String DISABLE_CREATED_SERIES = "PROMETHEUS_DISABLE_CREATED_SERIES";
    private static final String ENABLE_TOTAL_SERIES =
            "PROMETHEUS_ENABLE_TOTAL_SERIES";

    private static final List<String> DISABLE_CREATED_SERIES_TRUE = Arrays.asList("true", "1", "t");
    private static final boolean includeCreatedSeries = !isTrue(DISABLE_CREATED_SERIES);
    private static final boolean includeTotalSeries =
            isTrue(ENABLE_TOTAL_SERIES);

    static boolean includeCreatedSeries() {
        return includeCreatedSeries;
    }

    static boolean includeTotalSeries() {
        return includeTotalSeries;
    }

    private static boolean isTrue(String envVarName) {
        String stringValue = System.getenv(envVarName);
        if (stringValue != null) {
            return DISABLE_CREATED_SERIES_TRUE.contains(stringValue.toLowerCase());
        }
        return false;
    }
}
