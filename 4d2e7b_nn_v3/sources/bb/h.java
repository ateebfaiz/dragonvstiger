package bb;

import ab.s;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.g0;
import kotlin.jvm.internal.m;

public final class h extends b {

    /* renamed from: e  reason: collision with root package name */
    private final double f2639e;

    /* renamed from: f  reason: collision with root package name */
    private final float f2640f;

    /* renamed from: g  reason: collision with root package name */
    private final float f2641g;

    /* renamed from: h  reason: collision with root package name */
    private final double f2642h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(s sVar) {
        super(sVar);
        m.f(sVar, "handler");
        this.f2639e = sVar.Z0();
        this.f2640f = sVar.X0();
        this.f2641g = sVar.Y0();
        this.f2642h = sVar.a1();
    }

    public void a(WritableMap writableMap) {
        m.f(writableMap, "eventData");
        super.a(writableMap);
        writableMap.putDouble("scale", this.f2639e);
        writableMap.putDouble("focalX", (double) g0.b(this.f2640f));
        writableMap.putDouble("focalY", (double) g0.b(this.f2641g));
        writableMap.putDouble("velocity", this.f2642h);
    }
}
