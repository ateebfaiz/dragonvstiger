package com.sensorsdata.analytics.android.sdk.core.business;

import java.util.HashMap;
import java.util.Map;

public class SAPropertyManager {
    private Map<String, String> mLimitKeys;

    static class Holder {
        public static SAPropertyManager INSTANCE = new SAPropertyManager();

        Holder() {
        }
    }

    public static SAPropertyManager getInstance() {
        return Holder.INSTANCE;
    }

    public String getLimitValue(String str) {
        Map<String, String> map = this.mLimitKeys;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public boolean isLimitKey(String str) {
        Map<String, String> map = this.mLimitKeys;
        if (map == null || !map.containsKey(str)) {
            return false;
        }
        return true;
    }

    public void registerLimitKeys(Map<String, String> map) {
        if (map != null) {
            this.mLimitKeys.putAll(map);
        }
    }

    private SAPropertyManager() {
        this.mLimitKeys = new HashMap();
    }
}
