package com.geetest.core;

import java.util.HashMap;
import org.json.JSONObject;

public class GeeGuardConfiguration {

    /* renamed from: a  reason: collision with root package name */
    public final String f5884a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5885b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5886c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, Object> f5887d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, JSONObject> f5888e;

    /* renamed from: f  reason: collision with root package name */
    public final int f5889f;

    /* renamed from: g  reason: collision with root package name */
    public final String f5890g;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f5891a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5892b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5893c = true;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, Object> f5894d = null;

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, JSONObject> f5895e = null;

        /* renamed from: f  reason: collision with root package name */
        public int f5896f = 1;

        /* renamed from: g  reason: collision with root package name */
        public String f5897g = null;

        public Builder addSignature(String str) {
            this.f5897g = str;
            return this;
        }

        public GeeGuardConfiguration build() {
            return new GeeGuardConfiguration(this);
        }

        public Builder setAlInfo(boolean z10) {
            this.f5892b = z10;
            return this;
        }

        public Builder setAppId(String str) {
            this.f5891a = str;
            return this;
        }

        public Builder setDevInfo(boolean z10) {
            this.f5893c = z10;
            return this;
        }

        public Builder setExtraInfo(HashMap<String, JSONObject> hashMap) {
            this.f5895e = hashMap;
            return this;
        }

        public Builder setLevel(int i10) {
            this.f5896f = i10;
            return this;
        }

        public Builder setOuterInfo(HashMap<String, Object> hashMap) {
            this.f5894d = hashMap;
            return this;
        }
    }

    public String getAppId() {
        return this.f5884a;
    }

    public String getContent() {
        return this.f5890g;
    }

    public HashMap<String, JSONObject> getExtraInfo() {
        return this.f5888e;
    }

    public int getLevel() {
        return this.f5889f;
    }

    public HashMap<String, Object> getOuterInfo() {
        return this.f5887d;
    }

    public boolean isAlInfo() {
        return this.f5885b;
    }

    public boolean isDevInfo() {
        return this.f5886c;
    }

    private GeeGuardConfiguration(Builder builder) {
        this.f5884a = builder.f5891a;
        this.f5885b = builder.f5892b;
        this.f5886c = builder.f5893c;
        this.f5887d = builder.f5894d;
        this.f5888e = builder.f5895e;
        this.f5889f = builder.f5896f;
        this.f5890g = builder.f5897g;
    }
}
