package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import q5.p0;

public class r extends AsyncTask {

    /* renamed from: d  reason: collision with root package name */
    private static final String f20708d = r.class.getCanonicalName();

    /* renamed from: e  reason: collision with root package name */
    public static final a f20709e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private Exception f20710a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpURLConnection f20711b;

    /* renamed from: c  reason: collision with root package name */
    private final s f20712c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public r(HttpURLConnection httpURLConnection, s sVar) {
        m.f(sVar, "requests");
        this.f20711b = httpURLConnection;
        this.f20712c = sVar;
    }

    public List a(Void... voidArr) {
        List m10;
        if (v5.a.d(this)) {
            return null;
        }
        try {
            m.f(voidArr, "params");
            HttpURLConnection httpURLConnection = this.f20711b;
            if (httpURLConnection == null) {
                m10 = this.f20712c.f();
            } else {
                m10 = GraphRequest.f19541t.m(httpURLConnection, this.f20712c);
            }
            return m10;
        } catch (Exception e10) {
            this.f20710a = e10;
            return null;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void b(List list) {
        if (!v5.a.d(this)) {
            try {
                m.f(list, DbParams.KEY_CHANNEL_RESULT);
                super.onPostExecute(list);
                Exception exc = this.f20710a;
                if (exc != null) {
                    String str = f20708d;
                    b0 b0Var = b0.f709a;
                    String format = String.format("onPostExecute: exception encountered during request: %s", Arrays.copyOf(new Object[]{exc.getMessage()}, 1));
                    m.e(format, "java.lang.String.format(format, *args)");
                    p0.f0(str, format);
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            return a((Void[]) objArr);
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        if (!v5.a.d(this)) {
            try {
                b((List) obj);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void onPreExecute() {
        Handler handler;
        if (!v5.a.d(this)) {
            try {
                super.onPreExecute();
                if (o.x()) {
                    String str = f20708d;
                    b0 b0Var = b0.f709a;
                    String format = String.format("execute async task: %s", Arrays.copyOf(new Object[]{this}, 1));
                    m.e(format, "java.lang.String.format(format, *args)");
                    p0.f0(str, format);
                }
                if (this.f20712c.m() == null) {
                    if (Thread.currentThread() instanceof HandlerThread) {
                        handler = new Handler();
                    } else {
                        handler = new Handler(Looper.getMainLooper());
                    }
                    this.f20712c.x(handler);
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public String toString() {
        String str = "{RequestAsyncTask: " + " connection: " + this.f20711b + ", requests: " + this.f20712c + "}";
        m.e(str, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public r(s sVar) {
        this((HttpURLConnection) null, sVar);
        m.f(sVar, "requests");
    }
}
