package bb;

import ab.b;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.g0;
import kotlin.jvm.internal.m;

public final class a extends b {

    /* renamed from: e  reason: collision with root package name */
    private final float f2611e;

    /* renamed from: f  reason: collision with root package name */
    private final float f2612f;

    /* renamed from: g  reason: collision with root package name */
    private final float f2613g;

    /* renamed from: h  reason: collision with root package name */
    private final float f2614h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(bVar);
        m.f(bVar, "handler");
        this.f2611e = bVar.J();
        this.f2612f = bVar.K();
        this.f2613g = bVar.H();
        this.f2614h = bVar.I();
    }

    public void a(WritableMap writableMap) {
        m.f(writableMap, "eventData");
        super.a(writableMap);
        writableMap.putDouble("x", (double) g0.b(this.f2611e));
        writableMap.putDouble("y", (double) g0.b(this.f2612f));
        writableMap.putDouble("absoluteX", (double) g0.b(this.f2613g));
        writableMap.putDouble("absoluteY", (double) g0.b(this.f2614h));
    }
}
