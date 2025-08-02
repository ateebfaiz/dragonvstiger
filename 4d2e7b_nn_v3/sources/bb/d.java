package bb;

import ab.m;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.g0;

public final class d extends b {

    /* renamed from: e  reason: collision with root package name */
    private final float f2624e;

    /* renamed from: f  reason: collision with root package name */
    private final float f2625f;

    /* renamed from: g  reason: collision with root package name */
    private final float f2626g;

    /* renamed from: h  reason: collision with root package name */
    private final float f2627h;

    /* renamed from: i  reason: collision with root package name */
    private final int f2628i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(m mVar) {
        super(mVar);
        kotlin.jvm.internal.m.f(mVar, "handler");
        this.f2624e = mVar.J();
        this.f2625f = mVar.K();
        this.f2626g = mVar.H();
        this.f2627h = mVar.I();
        this.f2628i = mVar.V0();
    }

    public void a(WritableMap writableMap) {
        kotlin.jvm.internal.m.f(writableMap, "eventData");
        super.a(writableMap);
        writableMap.putDouble("x", (double) g0.b(this.f2624e));
        writableMap.putDouble("y", (double) g0.b(this.f2625f));
        writableMap.putDouble("absoluteX", (double) g0.b(this.f2626g));
        writableMap.putDouble("absoluteY", (double) g0.b(this.f2627h));
        writableMap.putInt("duration", this.f2628i);
    }
}
