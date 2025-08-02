package oa;

import com.onesignal.y2;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static a f12885b;

    /* renamed from: a  reason: collision with root package name */
    private b f12886a;

    public a(y2 y2Var) {
        f12885b = this;
        if (y2Var.e(y2Var.f(), "PREFS_OS_LANGUAGE", (String) null) != null) {
            this.f12886a = new c(y2Var);
        } else {
            this.f12886a = new d();
        }
    }

    public static a a() {
        return f12885b;
    }

    public String b() {
        return this.f12886a.a();
    }
}
