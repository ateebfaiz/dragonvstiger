package wa;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class a extends d {

    /* renamed from: c  reason: collision with root package name */
    public static final C0159a f13219c = new C0159a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f13220a;

    /* renamed from: b  reason: collision with root package name */
    private final float f13221b;

    /* renamed from: wa.a$a  reason: collision with other inner class name */
    public static final class C0159a {
        private C0159a() {
        }

        public /* synthetic */ C0159a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(int i10, int i11, float f10) {
        super(i10);
        this.f13220a = i11;
        this.f13221b = (Float.isInfinite(f10) || Float.isNaN(f10)) ? 0.0f : f10;
    }

    private final WritableMap a() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("position", this.f13220a);
        createMap.putDouble("offset", (double) this.f13221b);
        m.c(createMap);
        return createMap;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        m.f(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), a());
    }

    public String getEventName() {
        return "topPageScroll";
    }
}
