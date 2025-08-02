package f2;

import com.alibaba.pdns.model.DomainUhfReportModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    /* renamed from: d  reason: collision with root package name */
    private static final Set f21503d = new CopyOnWriteArraySet();

    /* renamed from: e  reason: collision with root package name */
    public static final a f21504e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final List f21505a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21506b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21507c;

    public static final class a {
        private a() {
        }

        private final void a(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("k");
                    String optString2 = optJSONObject.optString(DomainUhfReportModel.ENCRYPTYPE);
                    m.e(optString, "k");
                    if (optString.length() != 0) {
                        Set a10 = c.a();
                        m.e(next, "key");
                        List v02 = j.v0(optString, new String[]{","}, false, 0, 6, (Object) null);
                        m.e(optString2, DomainUhfReportModel.ENCRYPTYPE);
                        a10.add(new c(next, v02, optString2, (DefaultConstructorMarker) null));
                    }
                }
            }
        }

        public final Set b() {
            HashSet hashSet = new HashSet();
            for (c c10 : c.a()) {
                hashSet.add(c10.c());
            }
            return hashSet;
        }

        public final Set c() {
            return new HashSet(c.a());
        }

        public final void d(String str) {
            m.f(str, "rulesFromServer");
            try {
                c.a().clear();
                a(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ c(String str, List list, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, str2);
    }

    public static final /* synthetic */ Set a() {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21503d;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public final List b() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            return new ArrayList(this.f21505a);
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public final String c() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            return this.f21506b;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public final String d() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            return this.f21507c;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    private c(String str, List list, String str2) {
        this.f21506b = str;
        this.f21507c = str2;
        this.f21505a = list;
    }
}
