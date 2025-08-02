package bb;

import ab.d;
import com.facebook.react.bridge.WritableMap;
import kotlin.jvm.internal.m;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f2615a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2616b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2617c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2618d;

    public b(d dVar) {
        m.f(dVar, "handler");
        this.f2615a = dVar.M();
        this.f2616b = dVar.R();
        this.f2617c = dVar.Q();
        this.f2618d = dVar.O();
    }

    public void a(WritableMap writableMap) {
        m.f(writableMap, "eventData");
        writableMap.putInt("numberOfPointers", this.f2615a);
        writableMap.putInt("handlerTag", this.f2616b);
        writableMap.putInt("state", this.f2617c);
        writableMap.putInt("pointerType", this.f2618d);
    }
}
