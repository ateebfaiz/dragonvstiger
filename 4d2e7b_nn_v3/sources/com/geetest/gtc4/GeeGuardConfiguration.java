package com.geetest.gtc4;

import java.util.HashMap;
import org.json.JSONObject;

public class GeeGuardConfiguration {

    /* renamed from: a  reason: collision with root package name */
    public final String f6239a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f6240b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6241c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, Object> f6242d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, JSONObject> f6243e;

    /* renamed from: f  reason: collision with root package name */
    public final int f6244f;

    /* renamed from: g  reason: collision with root package name */
    public final String f6245g;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f6246a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6247b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f6248c = true;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, Object> f6249d = null;

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, JSONObject> f6250e = null;

        /* renamed from: f  reason: collision with root package name */
        public int f6251f = 1;

        /* renamed from: g  reason: collision with root package name */
        public String f6252g = null;

        public Builder addSignature(String str) {
            this.f6252g = str;
            return this;
        }

        public GeeGuardConfiguration build() {
            return new GeeGuardConfiguration(this);
        }

        public Builder setAlInfo(boolean z10) {
            this.f6247b = z10;
            return this;
        }

        public Builder setAppId(String str) {
            this.f6246a = str;
            return this;
        }

        public Builder setDevInfo(boolean z10) {
            this.f6248c = z10;
            return this;
        }

        public Builder setExtraInfo(HashMap<String, JSONObject> hashMap) {
            this.f6250e = hashMap;
            return this;
        }

        public Builder setLevel(int i10) {
            this.f6251f = i10;
            return this;
        }

        public Builder setOuterInfo(HashMap<String, Object> hashMap) {
            this.f6249d = hashMap;
            return this;
        }
    }

    public String getAppId() {
        return this.f6239a;
    }

    public String getContent() {
        return this.f6245g;
    }

    public HashMap<String, JSONObject> getExtraInfo() {
        return this.f6243e;
    }

    public int getLevel() {
        return this.f6244f;
    }

    public HashMap<String, Object> getOuterInfo() {
        return this.f6242d;
    }

    public boolean isAlInfo() {
        return this.f6240b;
    }

    public boolean isDevInfo() {
        return this.f6241c;
    }

    private GeeGuardConfiguration(Builder builder) {
        this.f6239a = builder.f6246a;
        this.f6240b = builder.f6247b;
        this.f6241c = builder.f6248c;
        this.f6242d = builder.f6249d;
        this.f6243e = builder.f6250e;
        this.f6244f = builder.f6251f;
        this.f6245g = builder.f6252g;
    }
}
