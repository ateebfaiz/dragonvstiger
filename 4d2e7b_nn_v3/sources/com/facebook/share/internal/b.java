package com.facebook.share.internal;

import com.facebook.share.model.CameraEffectArguments;
import java.util.HashMap;
import kotlin.collections.i0;
import kotlin.jvm.internal.m;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap f4417a = i0.g(t.a(String.class, new a()), t.a(String[].class, new C0062b()), t.a(JSONArray.class, new c()));

    /* renamed from: b  reason: collision with root package name */
    public static final b f4418b = new b();

    public static final class a implements d {
        a() {
        }

        public void a(JSONObject jSONObject, String str, Object obj) {
            m.f(jSONObject, "json");
            m.f(str, "key");
            jSONObject.put(str, obj);
        }
    }

    /* renamed from: com.facebook.share.internal.b$b  reason: collision with other inner class name */
    public static final class C0062b implements d {
        C0062b() {
        }

        public void a(JSONObject jSONObject, String str, Object obj) {
            m.f(jSONObject, "json");
            m.f(str, "key");
            JSONArray jSONArray = new JSONArray();
            if (obj != null) {
                for (String put : (String[]) obj) {
                    jSONArray.put(put);
                }
                jSONObject.put(str, jSONArray);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String?>");
        }
    }

    public static final class c implements d {
        c() {
        }

        public void a(JSONObject jSONObject, String str, Object obj) {
            m.f(jSONObject, "json");
            m.f(str, "key");
            throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
        }
    }

    private interface d {
        void a(JSONObject jSONObject, String str, Object obj);
    }

    private b() {
    }

    public static final JSONObject a(CameraEffectArguments cameraEffectArguments) {
        if (cameraEffectArguments == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : cameraEffectArguments.c()) {
            Object b10 = cameraEffectArguments.b(str);
            if (b10 != null) {
                m.e(b10, "arguments[key] ?: // Nul…orted.\n          continue");
                d dVar = (d) f4417a.get(b10.getClass());
                if (dVar != null) {
                    m.e(dVar, "SETTERS[value.javaClass]…ype: \" + value.javaClass)");
                    m.e(str, "key");
                    dVar.a(jSONObject, str, b10);
                } else {
                    throw new IllegalArgumentException("Unsupported type: " + b10.getClass());
                }
            }
        }
        return jSONObject;
    }
}
