package p2;

import android.os.Bundle;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.o;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import e2.m;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.text.j;
import m2.d;
import org.json.JSONException;
import org.json.JSONObject;
import q5.p0;

public final class f implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    private static final Set f23098e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public static final a f23099f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final View.OnClickListener f23100a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference f23101b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference f23102c;

    /* renamed from: d  reason: collision with root package name */
    private final String f23103d;

    public static final class a {

        /* renamed from: p2.f$a$a  reason: collision with other inner class name */
        static final class C0319a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f23104a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f23105b;

            C0319a(String str, String str2) {
                this.f23104a = str;
                this.f23105b = str2;
            }

            public final void run() {
                if (!v5.a.d(this)) {
                    try {
                        f.f23099f.d(this.f23104a, this.f23105b, new float[0]);
                    } catch (Throwable th) {
                        v5.a.b(th, this);
                    }
                }
            }
        }

        private a() {
        }

        /* access modifiers changed from: private */
        public final void d(String str, String str2, float[] fArr) {
            if (d.f(str)) {
                new m(o.f()).e(str, str2);
            } else if (d.e(str)) {
                f(str, str2, fArr);
            }
        }

        /* access modifiers changed from: private */
        public final boolean e(String str, String str2) {
            String d10 = b.d(str);
            if (d10 == null) {
                return false;
            }
            if (!kotlin.jvm.internal.m.b(d10, "other")) {
                p0.x0(new C0319a(d10, str2));
            }
            return true;
        }

        private final void f(String str, String str2, float[] fArr) {
            Bundle bundle = new Bundle();
            try {
                bundle.putString(DbParams.KEY_CHANNEL_EVENT_NAME, str);
                JSONObject jSONObject = new JSONObject();
                StringBuilder sb2 = new StringBuilder();
                for (float append : fArr) {
                    sb2.append(append);
                    sb2.append(",");
                }
                jSONObject.put("dense", sb2.toString());
                jSONObject.put("button_text", str2);
                bundle.putString("metadata", jSONObject.toString());
                GraphRequest.c cVar = GraphRequest.f19541t;
                b0 b0Var = b0.f709a;
                String format = String.format(Locale.US, "%s/suggested_events", Arrays.copyOf(new Object[]{o.g()}, 1));
                kotlin.jvm.internal.m.e(format, "java.lang.String.format(locale, format, *args)");
                GraphRequest x10 = cVar.x((AccessToken) null, format, (JSONObject) null, (GraphRequest.b) null);
                x10.F(bundle);
                x10.i();
            } catch (JSONException unused) {
            }
        }

        public final void c(View view, View view2, String str) {
            kotlin.jvm.internal.m.f(view, "hostView");
            kotlin.jvm.internal.m.f(view2, "rootView");
            kotlin.jvm.internal.m.f(str, "activityName");
            int hashCode = view.hashCode();
            if (!f.b().contains(Integer.valueOf(hashCode))) {
                h2.f.r(view, new f(view, view2, str, (DefaultConstructorMarker) null));
                f.b().add(Integer.valueOf(hashCode));
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f23106a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f23107b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f23108c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f23109d;

        b(f fVar, JSONObject jSONObject, String str, String str2) {
            this.f23106a = fVar;
            this.f23107b = jSONObject;
            this.f23108c = str;
            this.f23109d = str2;
        }

        public final void run() {
            String[] o10;
            if (!v5.a.d(this)) {
                try {
                    String u10 = p0.u(o.f());
                    if (u10 != null) {
                        String lowerCase = u10.toLowerCase();
                        kotlin.jvm.internal.m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                        float[] a10 = a.a(this.f23107b, lowerCase);
                        String c10 = a.c(this.f23108c, f.a(this.f23106a), lowerCase);
                        if (a10 != null && (o10 = d.o(d.a.MTML_APP_EVENT_PREDICTION, new float[][]{a10}, new String[]{c10})) != null) {
                            String str = o10[0];
                            b.a(this.f23109d, str);
                            if (true ^ kotlin.jvm.internal.m.b(str, "other")) {
                                f.f23099f.d(str, this.f23108c, a10);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                } catch (Exception unused) {
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    public /* synthetic */ f(View view, View view2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, view2, str);
    }

    public static final /* synthetic */ String a(f fVar) {
        Class<f> cls = f.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return fVar.f23103d;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Set b() {
        Class<f> cls = f.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f23098e;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private final void c(String str, String str2, JSONObject jSONObject) {
        if (!v5.a.d(this)) {
            try {
                p0.x0(new b(this, jSONObject, str2, str));
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void d() {
        if (!v5.a.d(this)) {
            try {
                View view = (View) this.f23101b.get();
                View view2 = (View) this.f23102c.get();
                if (view != null && view2 != null) {
                    try {
                        String d10 = c.d(view2);
                        String b10 = b.b(view2, d10);
                        if (b10 != null && !f23099f.e(b10, d10)) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("view", c.b(view, view2));
                            jSONObject.put("screenname", this.f23103d);
                            c(b10, d10, jSONObject);
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void onClick(View view) {
        if (!v5.a.d(this)) {
            try {
                kotlin.jvm.internal.m.f(view, "view");
                View.OnClickListener onClickListener = this.f23100a;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                d();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private f(View view, View view2, String str) {
        this.f23100a = h2.f.g(view);
        this.f23101b = new WeakReference(view2);
        this.f23102c = new WeakReference(view);
        if (str != null) {
            String lowerCase = str.toLowerCase();
            kotlin.jvm.internal.m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
            this.f23103d = j.z(lowerCase, "activity", "", false, 4, (Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
