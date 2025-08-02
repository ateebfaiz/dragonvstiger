package d;

import OooO0o0.OooO0O0;
import android.content.Context;
import android.content.SharedPreferences;
import g.c;
import h.g;
import x.l;

public class e implements c, l {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f21001a;

    public e(Context context) {
        this.f21001a = context.getSharedPreferences("com_mah_process_shared_config", 0);
    }

    public boolean a(g gVar) {
        SharedPreferences.Editor edit = this.f21001a.edit();
        boolean z10 = false;
        boolean z11 = this.f21001a.getBoolean("enable_anr_check", false);
        boolean z12 = gVar.O;
        boolean z13 = true;
        if (z11 != z12) {
            edit.putBoolean("enable_anr_check", z12);
            z10 = true;
        }
        boolean z14 = this.f21001a.getBoolean("enable_sdk", true);
        boolean z15 = gVar.f21781g;
        if (z14 != z15) {
            edit.putBoolean("enable_sdk", z15);
            z10 = true;
        }
        if (!gVar.B.equals(b())) {
            edit.putString("package_name_suffix", gVar.B);
            z10 = true;
        }
        String d10 = gVar.d();
        if (!d10.equals(c())) {
            edit.putString("log_report_url", d10);
        } else {
            z13 = z10;
        }
        if (z13) {
            edit.apply();
        }
        return z13;
    }

    public String b() {
        return this.f21001a.getString("package_name_suffix", "");
    }

    public String c() {
        return this.f21001a.getString("log_report_url", "");
    }

    public OooO0O0 f() {
        OooO0O0 oooO0O0 = new OooO0O0();
        oooO0O0.f13465a = this.f21001a.getBoolean("enable_sdk", true);
        oooO0O0.f13466b = b();
        oooO0O0.f13467c = c();
        oooO0O0.f13468d = this.f21001a.getBoolean("enable_anr_check", false);
        return oooO0O0;
    }
}
