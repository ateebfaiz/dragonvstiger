package cb;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class p extends d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f2686b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f2687a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public p(int i10, int i11, String str) {
        super(i10, i11);
        this.f2687a = str;
    }

    public short getCoalescingKey() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("text", this.f2687a);
        return createMap;
    }

    public String getEventName() {
        return "topSearchButtonPress";
    }
}
