package g;

import android.content.Context;
import com.mah.ndk.MahxServer;
import i.g;

public class m {

    /* renamed from: b  reason: collision with root package name */
    public static volatile m f21567b;

    /* renamed from: a  reason: collision with root package name */
    public final g f21568a;

    public m(Context context) {
        this.f21568a = new g(context, "mah_sdk_preference", MahxServer.OooO0o());
    }

    public static synchronized m a(Context context) {
        m mVar;
        synchronized (m.class) {
            try {
                if (f21567b == null) {
                    synchronized (m.class) {
                        if (f21567b == null) {
                            d(new m(context));
                        }
                    }
                }
                mVar = f21567b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    public static void d(m mVar) {
        f21567b = mVar;
        f21567b.getClass();
    }

    public String b() {
        return this.f21568a.c("domains", "");
    }

    public void c(long j10) {
        this.f21568a.f("sdk_start_time", j10);
    }

    public void e(String str) {
        this.f21568a.g("report_abnormal_log_time", str);
    }

    public void f(boolean z10) {
        this.f21568a.h("ndk_crash_mark", z10);
    }

    public void g(String str) {
        this.f21568a.g("domains", str);
    }

    public void h(boolean z10) {
        this.f21568a.h("report_abnormal_log_mark", z10);
    }

    public boolean i() {
        return this.f21568a.d("ndk_crash_mark", false);
    }

    public g j() {
        return this.f21568a;
    }

    public void k(String str) {
        this.f21568a.g("sdk_request_success_node_ip", str);
    }

    public void l(boolean z10) {
        this.f21568a.h("sdk_crash_mark", z10);
    }

    public boolean m() {
        return this.f21568a.d("report_abnormal_log_mark", false);
    }

    public boolean n() {
        return this.f21568a.d("sdk_crash_mark", false);
    }

    public String o() {
        return this.f21568a.c("report_abnormal_log_time", String.valueOf(System.currentTimeMillis()));
    }

    public String p() {
        return this.f21568a.c("sdk_request_success_node_ip", "");
    }

    public long q() {
        return this.f21568a.b("sdk_start_time", 0);
    }
}
