package e2;

import android.os.Bundle;
import com.alibaba.pdns.j;
import com.facebook.l;
import com.facebook.w;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.text.h;
import org.json.JSONException;
import org.json.JSONObject;
import q5.d0;
import q5.p0;

public final class c implements Serializable {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final HashSet f21131f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    public static final a f21132g = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f21133a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21134b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f21135c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21136d;

    /* renamed from: e  reason: collision with root package name */
    private final String f21137e;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final String c(String str) {
            try {
                MessageDigest instance = MessageDigest.getInstance(j.f17955b);
                Charset forName = Charset.forName("UTF-8");
                m.e(forName, "Charset.forName(charsetName)");
                if (str != null) {
                    byte[] bytes = str.getBytes(forName);
                    m.e(bytes, "(this as java.lang.String).getBytes(charset)");
                    instance.update(bytes, 0, bytes.length);
                    byte[] digest = instance.digest();
                    m.e(digest, "digest.digest()");
                    return l2.b.c(digest);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (NoSuchAlgorithmException e10) {
                p0.e0("Failed to generate checksum: ", e10);
                return "0";
            } catch (UnsupportedEncodingException e11) {
                p0.e0("Failed to generate checksum: ", e11);
                return "1";
            }
        }

        /* access modifiers changed from: private */
        public final void d(String str) {
            boolean contains;
            if (str == null || str.length() == 0 || str.length() > 40) {
                if (str == null) {
                    str = "<None Provided>";
                }
                b0 b0Var = b0.f709a;
                String format = String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", Arrays.copyOf(new Object[]{str, 40}, 2));
                m.e(format, "java.lang.String.format(locale, format, *args)");
                throw new l(format);
            }
            synchronized (c.f21131f) {
                contains = c.f21131f.contains(str);
                Unit unit = Unit.f12577a;
            }
            if (contains) {
                return;
            }
            if (new h("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$").c(str)) {
                synchronized (c.f21131f) {
                    c.f21131f.add(str);
                }
                return;
            }
            b0 b0Var2 = b0.f709a;
            String format2 = String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", Arrays.copyOf(new Object[]{str}, 1));
            m.e(format2, "java.lang.String.format(format, *args)");
            throw new l(format2);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements Serializable {

        /* renamed from: e  reason: collision with root package name */
        public static final a f21138e = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final String f21139a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f21140b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f21141c;

        /* renamed from: d  reason: collision with root package name */
        private final String f21142d;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(String str, boolean z10, boolean z11, String str2) {
            m.f(str, "jsonString");
            this.f21139a = str;
            this.f21140b = z10;
            this.f21141c = z11;
            this.f21142d = str2;
        }

        private final Object readResolve() throws JSONException, ObjectStreamException {
            return new c(this.f21139a, this.f21140b, this.f21141c, this.f21142d, (DefaultConstructorMarker) null);
        }
    }

    public /* synthetic */ c(String str, boolean z10, boolean z11, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z10, z11, str2);
    }

    private final String b() {
        a aVar = f21132g;
        String jSONObject = this.f21133a.toString();
        m.e(jSONObject, "jsonObject.toString()");
        return aVar.c(jSONObject);
    }

    private final JSONObject d(String str, String str2, Double d10, Bundle bundle, UUID uuid) {
        a aVar = f21132g;
        aVar.d(str2);
        JSONObject jSONObject = new JSONObject();
        String e10 = o2.a.e(str2);
        jSONObject.put("_eventName", e10);
        jSONObject.put("_eventName_md5", aVar.c(e10));
        jSONObject.put("_logTime", System.currentTimeMillis() / ((long) 1000));
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (bundle != null) {
            Map j10 = j(bundle);
            for (String str3 : j10.keySet()) {
                jSONObject.put(str3, j10.get(str3));
            }
        }
        if (d10 != null) {
            jSONObject.put("_valueToSum", d10.doubleValue());
        }
        if (this.f21135c) {
            jSONObject.put("_inBackground", "1");
        }
        if (this.f21134b) {
            jSONObject.put("_implicitlyLogged", "1");
        } else {
            d0.a aVar2 = d0.f23283f;
            w wVar = w.APP_EVENTS;
            String jSONObject2 = jSONObject.toString();
            m.e(jSONObject2, "eventObject.toString()");
            aVar2.c(wVar, "AppEvents", "Created app event '%s'", jSONObject2);
        }
        return jSONObject;
    }

    private final Map j(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String next : bundle.keySet()) {
            a aVar = f21132g;
            m.e(next, "key");
            aVar.d(next);
            Object obj = bundle.get(next);
            if ((obj instanceof String) || (obj instanceof Number)) {
                hashMap.put(next, obj.toString());
            } else {
                b0 b0Var = b0.f709a;
                String format = String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", Arrays.copyOf(new Object[]{obj, next}, 2));
                m.e(format, "java.lang.String.format(format, *args)");
                throw new l(format);
            }
        }
        k2.a.c(hashMap);
        o2.a.f(c0.d(hashMap), this.f21136d);
        i2.a.c(c0.d(hashMap), this.f21136d);
        return hashMap;
    }

    private final Object writeReplace() throws ObjectStreamException {
        String jSONObject = this.f21133a.toString();
        m.e(jSONObject, "jsonObject.toString()");
        return new b(jSONObject, this.f21134b, this.f21135c, this.f21137e);
    }

    public final boolean c() {
        return this.f21134b;
    }

    public final JSONObject e() {
        return this.f21133a;
    }

    public final String f() {
        return this.f21136d;
    }

    public final boolean h() {
        if (this.f21137e == null) {
            return true;
        }
        return m.b(b(), this.f21137e);
    }

    public final boolean i() {
        return this.f21134b;
    }

    public String toString() {
        b0 b0Var = b0.f709a;
        String format = String.format("\"%s\", implicit: %b, json: %s", Arrays.copyOf(new Object[]{this.f21133a.optString("_eventName"), Boolean.valueOf(this.f21134b), this.f21133a.toString()}, 3));
        m.e(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public c(String str, String str2, Double d10, Bundle bundle, boolean z10, boolean z11, UUID uuid) {
        m.f(str, "contextName");
        m.f(str2, "eventName");
        this.f21134b = z10;
        this.f21135c = z11;
        this.f21136d = str2;
        this.f21133a = d(str, str2, d10, bundle, uuid);
        this.f21137e = b();
    }

    private c(String str, boolean z10, boolean z11, String str2) {
        JSONObject jSONObject = new JSONObject(str);
        this.f21133a = jSONObject;
        this.f21134b = z10;
        String optString = jSONObject.optString("_eventName");
        m.e(optString, "jsonObject.optString(Con…nts.EVENT_NAME_EVENT_KEY)");
        this.f21136d = optString;
        this.f21137e = str2;
        this.f21135c = z11;
    }
}
