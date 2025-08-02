package bb;

import ab.k;
import ab.y;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.g0;
import kotlin.jvm.internal.m;

public final class c extends b {

    /* renamed from: e  reason: collision with root package name */
    private final float f2619e;

    /* renamed from: f  reason: collision with root package name */
    private final float f2620f;

    /* renamed from: g  reason: collision with root package name */
    private final float f2621g;

    /* renamed from: h  reason: collision with root package name */
    private final float f2622h;

    /* renamed from: i  reason: collision with root package name */
    private final y f2623i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(k kVar) {
        super(kVar);
        m.f(kVar, "handler");
        this.f2619e = kVar.J();
        this.f2620f = kVar.K();
        this.f2621g = kVar.H();
        this.f2622h = kVar.I();
        this.f2623i = kVar.V0();
    }

    public void a(WritableMap writableMap) {
        m.f(writableMap, "eventData");
        super.a(writableMap);
        writableMap.putDouble("x", (double) g0.b(this.f2619e));
        writableMap.putDouble("y", (double) g0.b(this.f2620f));
        writableMap.putDouble("absoluteX", (double) g0.b(this.f2621g));
        writableMap.putDouble("absoluteY", (double) g0.b(this.f2622h));
        if (this.f2623i.a() != -1.0d) {
            writableMap.putMap("stylusData", this.f2623i.b());
        }
    }
}
