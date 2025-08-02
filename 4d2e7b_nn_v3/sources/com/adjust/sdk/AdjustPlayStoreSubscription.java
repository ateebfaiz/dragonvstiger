package com.adjust.sdk;

import java.util.LinkedHashMap;
import java.util.Map;

public class AdjustPlayStoreSubscription {
    private static ILogger logger = AdjustFactory.getLogger();
    private String billingStore = "GooglePlay";
    private Map<String, String> callbackParameters;
    private String currency;
    private String orderId;
    private Map<String, String> partnerParameters;
    private long price;
    private long purchaseTime = -1;
    private String purchaseToken;
    private String signature;
    private String sku;

    public AdjustPlayStoreSubscription(long j10, String str, String str2, String str3, String str4, String str5) {
        this.price = j10;
        this.currency = str;
        this.sku = str2;
        this.orderId = str3;
        this.signature = str4;
        this.purchaseToken = str5;
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

    public String getBillingStore() {
        return this.billingStore;
    }

    public Map<String, String> getCallbackParameters() {
        return this.callbackParameters;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public Map<String, String> getPartnerParameters() {
        return this.partnerParameters;
    }

    public long getPrice() {
        return this.price;
    }

    public long getPurchaseTime() {
        return this.purchaseTime;
    }

    public String getPurchaseToken() {
        return this.purchaseToken;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getSku() {
        return this.sku;
    }

    public void setPurchaseTime(long j10) {
        this.purchaseTime = j10;
    }
}
