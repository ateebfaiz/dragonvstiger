package s7;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f12977b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final float f12978a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(int i10, int i11, float f10) {
        super(i10, i11);
        this.f12978a = f10;
    }

    public final float a() {
        return this.f12978a;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        m.e(createMap, "createMap(...)");
        createMap.putDouble("offset", (double) a());
        return createMap;
    }

    public String getEventName() {
        return "topDrawerSlide";
    }
}
