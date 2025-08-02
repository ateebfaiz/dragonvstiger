package g1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.engagelab.privates.core.api.MTReporter;
import org.json.JSONObject;
import p1.a;
import u1.b;
import u1.m;

public class r {

    /* renamed from: c  reason: collision with root package name */
    public static volatile r f21607c;

    /* renamed from: a  reason: collision with root package name */
    public long f21608a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f21609b = 0;

    public static r a() {
        if (f21607c == null) {
            synchronized (r.class) {
                f21607c = new r();
            }
        }
        return f21607c;
    }

    public static String b(Context context, long j10) {
        StringBuilder sb2 = new StringBuilder();
        String b10 = a.b(context);
        if (!TextUtils.isEmpty(b10)) {
            sb2.append(b10);
        }
        String n10 = a.n(context);
        if (!TextUtils.isEmpty(n10)) {
            sb2.append(n10);
        }
        sb2.append(j10);
        return m.b(sb2.toString());
    }

    public static void d(Context context, long j10, long j11) {
        try {
            String a10 = f0.a(context);
            if (TextUtils.isEmpty(a10)) {
                s1.a.a("MTActiveBusiness", "session is null");
                return;
            }
            String b10 = b.b();
            String str = b10.split("_")[0];
            String str2 = b10.split("_")[1];
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("session_id", a10);
            jSONObject.put("date", str);
            jSONObject.put("time", str2);
            jSONObject.put("duration", (j10 - j11) / 1000);
            f0.n(context, jSONObject.toString());
        } catch (Throwable th) {
            s1.a.h("MTActiveBusiness", "processBackground failed " + th.getMessage());
        }
    }

    public static void f(Context context, long j10) {
        try {
            String j11 = f0.j(context);
            if (!TextUtils.isEmpty(j11)) {
                MTReporter c10 = new MTReporter().d("active_terminate").c(new JSONObject(j11).toString());
                Bundle bundle = new Bundle();
                bundle.putParcelable("protocol", c10);
                h1.a.j(context, 2233, bundle);
            }
            String b10 = b(context, j10);
            if (TextUtils.isEmpty(b10)) {
                s1.a.a("MTActiveBusiness", "session is null");
                return;
            }
            f0.h(context, b10);
            String b11 = b.b();
            String str = b11.split("_")[0];
            String str2 = b11.split("_")[1];
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("session_id", b10);
            jSONObject.put("date", str);
            jSONObject.put("time", str2);
            MTReporter c11 = new MTReporter().d("active_launch").c(jSONObject.toString());
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("protocol", c11);
            h1.a.j(context, 2233, bundle2);
        } catch (Throwable th) {
            s1.a.h("MTActiveBusiness", "processForeground failed " + th.getMessage());
        }
    }

    public void c(Context context) {
        if (0 == this.f21608a) {
            s1.a.h("MTActiveBusiness", "toBackground lastToForegroundTime is 0 ");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        d(context, currentTimeMillis, this.f21608a);
        this.f21609b = currentTimeMillis;
        f0.g(context, currentTimeMillis);
    }

    public void e(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f21609b == 0) {
            this.f21609b = f0.p(context);
        }
        if (currentTimeMillis - this.f21609b >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            this.f21608a = currentTimeMillis;
            f0.m(context, currentTimeMillis);
            f(context, currentTimeMillis);
        }
    }
}
