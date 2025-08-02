package bb;

import ab.a0;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.g0;
import kotlin.jvm.internal.m;

public final class j extends b {

    /* renamed from: e  reason: collision with root package name */
    private final float f2647e;

    /* renamed from: f  reason: collision with root package name */
    private final float f2648f;

    /* renamed from: g  reason: collision with root package name */
    private final float f2649g;

    /* renamed from: h  reason: collision with root package name */
    private final float f2650h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(a0 a0Var) {
        super(a0Var);
        m.f(a0Var, "handler");
        this.f2647e = a0Var.J();
        this.f2648f = a0Var.K();
        this.f2649g = a0Var.H();
        this.f2650h = a0Var.I();
    }

    public void a(WritableMap writableMap) {
        m.f(writableMap, "eventData");
        super.a(writableMap);
        writableMap.putDouble("x", (double) g0.b(this.f2647e));
        writableMap.putDouble("y", (double) g0.b(this.f2648f));
        writableMap.putDouble("absoluteX", (double) g0.b(this.f2649g));
        writableMap.putDouble("absoluteY", (double) g0.b(this.f2650h));
    }
}
