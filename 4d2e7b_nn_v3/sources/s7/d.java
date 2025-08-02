package s7;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class d extends com.facebook.react.uimanager.events.d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f12979b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f12980a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(int i10, int i11, int i12) {
        super(i10, i11);
        this.f12980a = i12;
    }

    public final int a() {
        return this.f12980a;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        m.e(createMap, "createMap(...)");
        createMap.putInt("drawerState", a());
        return createMap;
    }

    public String getEventName() {
        return "topDrawerStateChanged";
    }
}
