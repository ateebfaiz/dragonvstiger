package com.adjust.sdk;

import java.util.LinkedHashMap;
import java.util.Map;

public class AdjustEvent {
    private static ILogger logger = AdjustFactory.getLogger();
    public String callbackId;
    public Map<String, String> callbackParameters;
    public String currency;
    public String eventToken;
    public String orderId;
    public Map<String, String> partnerParameters;
    public Double revenue;

    public AdjustEvent(String str) {
        if (checkEventToken(str, logger)) {
            this.eventToken = str;
        }
    }

    private static boolean checkEventToken(String str, ILogger iLogger) {
        if (str == null) {
            iLogger.error("Missing Event Token", new Object[0]);
            return false;
        } else if (str.length() > 0) {
            return true;
        } else {
            iLogger.error("Event Token can't be empty", new Object[0]);
            return false;
        }
    }

    private boolean checkRevenue(Double d10, String str) {
        if (d10 != null) {
            if (d10.doubleValue() < 0.0d) {
                logger.error("Invalid amount %.5f", d10);
                return false;
            } else if (str == null) {
                logger.error("Currency must be set with revenue", new Object[0]);
                return false;
            } else if (str.equals("")) {
                logger.error("Currency is empty", new Object[0]);
                return false;
            }
        } else if (str != null) {
            logger.error("Revenue must be set with currency", new Object[0]);
            return false;
        }
        return true;
    }

    public void addCallbackParameter(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Callback") && Util.isValidParameter(str2, "value", "Callback")) {
            if (this.callbackParameters == null) {
                this.callbackParameters = new LinkedHashMap();
            }
            if (this.callbackParameters.put(str, str2) != null) {
                logger.warn("Key %s was overwritten", str);
            }
        }
    }

    public void addPartnerParameter(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Partner") && Util.isValidParameter(str2, "value", "Partner")) {
            if (this.partnerParameters == null) {
                this.partnerParameters = new LinkedHashMap();
            }
            if (this.partnerParameters.put(str, str2) != null) {
                logger.warn("Key %s was overwritten", str);
            }
        }
    }

    public boolean isValid() {
        return this.eventToken != null;
    }

    public void setCallbackId(String str) {
        this.callbackId = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setRevenue(double d10, String str) {
        if (checkRevenue(Double.valueOf(d10), str)) {
            this.revenue = Double.valueOf(d10);
            this.currency = str;
        }
    }
}
