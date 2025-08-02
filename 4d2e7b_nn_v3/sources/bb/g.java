package bb;

import ab.r;
import ab.y;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.g0;
import kotlin.jvm.internal.m;

public final class g extends b {

    /* renamed from: e  reason: collision with root package name */
    private final float f2630e;

    /* renamed from: f  reason: collision with root package name */
    private final float f2631f;

    /* renamed from: g  reason: collision with root package name */
    private final float f2632g;

    /* renamed from: h  reason: collision with root package name */
    private final float f2633h;

    /* renamed from: i  reason: collision with root package name */
    private final float f2634i;

    /* renamed from: j  reason: collision with root package name */
    private final float f2635j;

    /* renamed from: k  reason: collision with root package name */
    private final float f2636k;

    /* renamed from: l  reason: collision with root package name */
    private final float f2637l;

    /* renamed from: m  reason: collision with root package name */
    private final y f2638m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(r rVar) {
        super(rVar);
        m.f(rVar, "handler");
        this.f2630e = rVar.J();
        this.f2631f = rVar.K();
        this.f2632g = rVar.H();
        this.f2633h = rVar.I();
        this.f2634i = rVar.V0();
        this.f2635j = rVar.W0();
        this.f2636k = rVar.X0();
        this.f2637l = rVar.Y0();
        this.f2638m = rVar.U0();
    }

    public void a(WritableMap writableMap) {
        m.f(writableMap, "eventData");
        super.a(writableMap);
        writableMap.putDouble("x", (double) g0.b(this.f2630e));
        writableMap.putDouble("y", (double) g0.b(this.f2631f));
        writableMap.putDouble("absoluteX", (double) g0.b(this.f2632g));
        writableMap.putDouble("absoluteY", (double) g0.b(this.f2633h));
        writableMap.putDouble("translationX", (double) g0.b(this.f2634i));
        writableMap.putDouble("translationY", (double) g0.b(this.f2635j));
        writableMap.putDouble("velocityX", (double) g0.b(this.f2636k));
        writableMap.putDouble("velocityY", (double) g0.b(this.f2637l));
        if (this.f2638m.a() != -1.0d) {
            writableMap.putMap("stylusData", this.f2638m.b());
        }
    }
}
