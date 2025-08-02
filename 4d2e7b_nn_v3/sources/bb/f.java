package bb;

import ab.o;
import com.facebook.react.bridge.WritableMap;
import kotlin.jvm.internal.m;

public final class f extends b {

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2629e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(o oVar) {
        super(oVar);
        m.f(oVar, "handler");
        this.f2629e = oVar.c0();
    }

    public void a(WritableMap writableMap) {
        m.f(writableMap, "eventData");
        super.a(writableMap);
        writableMap.putBoolean("pointerInside", this.f2629e);
    }
}
