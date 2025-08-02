package com.sensorsdata.analytics.android.sdk.plugin.encrypt;

public interface StorePlugin {
    Boolean getBool(String str);

    Float getFloat(String str);

    Integer getInteger(String str);

    Long getLong(String str);

    String getString(String str);

    boolean isExists(String str);

    void remove(String str);

    void setBool(String str, boolean z10);

    void setFloat(String str, float f10);

    void setInteger(String str, int i10);

    void setLong(String str, long j10);

    void setString(String str, String str2);

    String type();

    void upgrade(StorePlugin storePlugin);
}
