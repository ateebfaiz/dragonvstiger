package cb;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class d extends com.facebook.react.uimanager.events.d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f2668b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f2669a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(int i10, int i11, int i12) {
        super(i10, i11);
        this.f2669a = i12;
    }

    public short getCoalescingKey() {
        return (short) this.f2669a;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("headerHeight", (double) this.f2669a);
        return createMap;
    }

    public String getEventName() {
        return "topHeaderHeightChange";
    }
}
