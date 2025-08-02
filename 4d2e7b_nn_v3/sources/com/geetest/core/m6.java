package com.geetest.core;

import android.net.Network;
import java.util.Map;
import org.json.JSONObject;

public abstract class m6<T> {

    /* renamed from: a  reason: collision with root package name */
    public final String f6081a;

    /* renamed from: b  reason: collision with root package name */
    public Network f6082b;

    /* renamed from: c  reason: collision with root package name */
    public int f6083c;

    public m6(String str) {
        this.f6081a = str;
    }

    public abstract Map<String, String> a();

    public abstract void a(String str, s6<T> s6Var);

    public abstract boolean b();

    public JSONObject c() throws Exception {
        throw new RuntimeException("Stub!");
    }

    public String d() {
        throw new RuntimeException("Stub!");
    }
}
