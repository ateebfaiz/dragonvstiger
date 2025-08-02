package b8;

import android.content.Context;

public class d implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2506a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2507b;

    public d(Context context) {
        this.f2506a = context;
        a aVar = new a(5);
        this.f2507b = aVar;
        aVar.a(context.getApplicationInfo().sourceDir);
    }

    public f get() {
        return new c(new j(), new e(this.f2506a, this.f2507b), new h(), new i(), new j(), new b(this.f2506a, this.f2507b));
    }
}
