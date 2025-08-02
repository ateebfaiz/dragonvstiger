package e;

import android.text.TextUtils;
import i.g;
import w.d;

public class l {

    /* renamed from: b  reason: collision with root package name */
    public static final String f21110b = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final g f21111a;

    public l(g gVar) {
        this.f21111a = gVar;
    }

    public String a() {
        return this.f21111a.c("auth_fail_time_list", "");
    }

    public void b(long j10) {
        String f10 = f();
        if (!TextUtils.isEmpty(f10)) {
            c(f10);
        }
        this.f21111a.g("last_launch_auth_time", String.valueOf(j10));
    }

    public final void c(String str) {
        String c10 = this.f21111a.c("auth_fail_time_list", "");
        if (!TextUtils.isEmpty(c10)) {
            str = c10 + "," + str;
        }
        this.f21111a.g("auth_fail_time_list", str);
    }

    public int d() {
        return this.f21111a.a("auth_result", 2);
    }

    public final void e(String str) {
        this.f21111a.g("auth_fail_time_list", "");
        this.f21111a.g("last_launch_auth_time", "");
    }

    public String f() {
        return this.f21111a.c("last_launch_auth_time", "");
    }

    public void g() {
        this.f21111a.e("auth_result", 1);
    }

    public void h() {
        this.f21111a.e("auth_result", 0);
        e("auth success");
    }

    public void i() {
        this.f21111a.e("auth_result", 2);
        e("auth failure");
    }
}
