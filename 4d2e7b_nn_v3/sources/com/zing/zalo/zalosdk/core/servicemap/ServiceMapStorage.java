package com.zing.zalo.zalosdk.core.servicemap;

import android.content.Context;
import com.zing.zalo.zalosdk.core.helper.Storage;

public class ServiceMapStorage extends Storage {
    private final String PREF_EXPIRE_TIME = "PREFERCE_EXPIRE_TIME";
    private final String PREF_KEY_URL_CENTRALIZED = "PREFERECE_KEY_URL_CENTRALIZED";
    private final String PREF_KEY_URL_GRAPH = "PREFERECE_KEY_URL_GRAPH";
    private final String PREF_KEY_URL_OAUTH = "PREFERECE_KEY_URL_OAUTH";

    public ServiceMapStorage(Context context) {
        super(context);
    }

    public long getExpireTime() {
        return getLong("PREFERCE_EXPIRE_TIME");
    }

    public String getKeyUrlCentralized() {
        return getString("PREFERECE_KEY_URL_CENTRALIZED");
    }

    public String getKeyUrlGraph() {
        return getString("PREFERECE_KEY_URL_GRAPH");
    }

    public String getKeyUrlOauth() {
        return getString("PREFERECE_KEY_URL_OAUTH");
    }

    public void setExpireTime(long j10) {
        setLong("PREFERCE_EXPIRE_TIME", j10);
    }

    public void setKeyUrlCentralized(String str) {
        setString("PREFERECE_KEY_URL_CENTRALIZED", str);
    }

    public void setKeyUrlGraph(String str) {
        setString("PREFERECE_KEY_URL_GRAPH", str);
    }

    public void setKeyUrlOauth(String str) {
        setString("PREFERECE_KEY_URL_OAUTH", str);
    }
}
