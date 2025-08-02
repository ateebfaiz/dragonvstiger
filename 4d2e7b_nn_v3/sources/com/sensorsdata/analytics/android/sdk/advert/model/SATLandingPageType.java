package com.sensorsdata.analytics.android.sdk.advert.model;

public enum SATLandingPageType {
    INTELLIGENCE("intelligence"),
    OTHER("other");
    
    private String mTypeName;

    private SATLandingPageType(String str) {
        this.mTypeName = str;
    }

    public String getTypeName() {
        return this.mTypeName;
    }
}
