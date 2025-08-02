package bb;

import ab.v;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.g0;
import kotlin.jvm.internal.m;

public final class i extends b {

    /* renamed from: e  reason: collision with root package name */
    private final double f2643e;

    /* renamed from: f  reason: collision with root package name */
    private final float f2644f;

    /* renamed from: g  reason: collision with root package name */
    private final float f2645g;

    /* renamed from: h  reason: collision with root package name */
    private final double f2646h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(v vVar) {
        super(vVar);
        m.f(vVar, "handler");
        this.f2643e = vVar.W0();
        this.f2644f = vVar.U0();
        this.f2645g = vVar.V0();
        this.f2646h = vVar.X0();
    }

    public void a(WritableMap writableMap) {
        m.f(writableMap, "eventData");
        super.a(writableMap);
        writableMap.putDouble("rotation", this.f2643e);
        writableMap.putDouble("anchorX", (double) g0.b(this.f2644f));
        writableMap.putDouble("anchorY", (double) g0.b(this.f2645g));
        writableMap.putDouble("velocity", this.f2646h);
    }
}
