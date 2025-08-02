package com.sensorsdata.analytics.android.sdk.plugin.encrypt;

import android.content.Context;
import android.content.SharedPreferences;
import com.sensorsdata.analytics.android.sdk.util.SASpUtils;
import java.util.List;

public abstract class DefaultStorePlugin implements StorePlugin {
    private final String mFileName;
    private final SharedPreferences mStoreSp;

    public DefaultStorePlugin(Context context, String str) {
        this.mStoreSp = SASpUtils.getSharedPreferences(context, str, 0);
        this.mFileName = str;
    }

    private String getKey(String str) {
        return str.replaceFirst(type(), "");
    }

    public Boolean getBool(String str) {
        if (isExists(str)) {
            return Boolean.valueOf(this.mStoreSp.getBoolean(getKey(str), false));
        }
        return null;
    }

    public Float getFloat(String str) {
        if (isExists(str)) {
            return Float.valueOf(this.mStoreSp.getFloat(getKey(str), 0.0f));
        }
        return null;
    }

    public Integer getInteger(String str) {
        if (isExists(str)) {
            return Integer.valueOf(this.mStoreSp.getInt(getKey(str), 0));
        }
        return null;
    }

    public Long getLong(String str) {
        if (isExists(str)) {
            return Long.valueOf(this.mStoreSp.getLong(getKey(str), 0));
        }
        return null;
    }

    public String getString(String str) {
        if (isExists(str)) {
            return this.mStoreSp.getString(getKey(str), (String) null);
        }
        return null;
    }

    public boolean isExists(String str) {
        return this.mStoreSp.contains(getKey(str));
    }

    public void remove(String str) {
        this.mStoreSp.edit().remove(getKey(str)).apply();
    }

    public void setBool(String str, boolean z10) {
        this.mStoreSp.edit().putBoolean(getKey(str), z10).apply();
    }

    public void setFloat(String str, float f10) {
        this.mStoreSp.edit().putFloat(getKey(str), f10).apply();
    }

    public void setInteger(String str, int i10) {
        this.mStoreSp.edit().putInt(getKey(str), i10).apply();
    }

    public void setLong(String str, long j10) {
        this.mStoreSp.edit().putLong(getKey(str), j10).apply();
    }

    public void setString(String str, String str2) {
        this.mStoreSp.edit().putString(getKey(str), str2).apply();
    }

    public abstract List<String> storeKeys();

    public String type() {
        return this.mFileName;
    }

    public void upgrade(StorePlugin storePlugin) {
    }
}
