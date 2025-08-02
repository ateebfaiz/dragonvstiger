package q5;

import android.util.Log;
import com.facebook.o;
import com.facebook.w;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class d0 {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap f23282e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public static final a f23283f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final w f23284a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23285b;

    /* renamed from: c  reason: collision with root package name */
    private StringBuilder f23286c;

    /* renamed from: d  reason: collision with root package name */
    private int f23287d = 3;

    public static final class a {
        private a() {
        }

        private final synchronized String f(String str) {
            String str2;
            str2 = str;
            for (Map.Entry entry : d0.f23282e.entrySet()) {
                str2 = j.z(str2, (String) entry.getKey(), (String) entry.getValue(), false, 4, (Object) null);
            }
            return str2;
        }

        public final void a(w wVar, int i10, String str, String str2) {
            m.f(wVar, "behavior");
            m.f(str, "tag");
            m.f(str2, "string");
            if (o.C(wVar)) {
                String f10 = f(str2);
                if (!j.F(str, "FacebookSDK.", false, 2, (Object) null)) {
                    str = "FacebookSDK." + str;
                }
                Log.println(i10, str, f10);
                if (wVar == w.DEVELOPER_ERRORS) {
                    new Exception().printStackTrace();
                }
            }
        }

        public final void b(w wVar, String str, String str2) {
            m.f(wVar, "behavior");
            m.f(str, "tag");
            m.f(str2, "string");
            a(wVar, 3, str, str2);
        }

        public final void c(w wVar, String str, String str2, Object... objArr) {
            m.f(wVar, "behavior");
            m.f(str, "tag");
            m.f(str2, "format");
            m.f(objArr, "args");
            if (o.C(wVar)) {
                b0 b0Var = b0.f709a;
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
                m.e(format, "java.lang.String.format(format, *args)");
                a(wVar, 3, str, format);
            }
        }

        public final synchronized void d(String str) {
            m.f(str, "accessToken");
            if (!o.C(w.INCLUDE_ACCESS_TOKENS)) {
                e(str, "ACCESS_TOKEN_REMOVED");
            }
        }

        public final synchronized void e(String str, String str2) {
            m.f(str, "original");
            m.f(str2, "replace");
            d0.f23282e.put(str, str2);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d0(w wVar, String str) {
        m.f(wVar, "behavior");
        m.f(str, "tag");
        this.f23284a = wVar;
        this.f23285b = "FacebookSDK." + q0.n(str, "tag");
        this.f23286c = new StringBuilder();
    }

    public static final void f(w wVar, int i10, String str, String str2) {
        f23283f.a(wVar, i10, str, str2);
    }

    public static final void g(w wVar, String str, String str2, Object... objArr) {
        f23283f.c(wVar, str, str2, objArr);
    }

    private final boolean i() {
        return o.C(this.f23284a);
    }

    public final void b(String str) {
        m.f(str, "string");
        if (i()) {
            this.f23286c.append(str);
        }
    }

    public final void c(String str, Object... objArr) {
        m.f(str, "format");
        m.f(objArr, "args");
        if (i()) {
            StringBuilder sb2 = this.f23286c;
            b0 b0Var = b0.f709a;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            String format = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
            m.e(format, "java.lang.String.format(format, *args)");
            sb2.append(format);
        }
    }

    public final void d(String str, Object obj) {
        m.f(str, "key");
        m.f(obj, "value");
        c("  %s:\t%s\n", str, obj);
    }

    public final void e() {
        String sb2 = this.f23286c.toString();
        m.e(sb2, "contents.toString()");
        h(sb2);
        this.f23286c = new StringBuilder();
    }

    public final void h(String str) {
        m.f(str, "string");
        f23283f.a(this.f23284a, this.f23287d, this.f23285b, str);
    }
}
