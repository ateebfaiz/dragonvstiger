package va;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class j extends d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f13186b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final WritableMap f13187a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(int i10, WritableMap writableMap) {
        super(i10);
        m.f(writableMap, "mData");
        this.f13187a = writableMap;
        writableMap.putString("navigationType", "other");
        writableMap.putBoolean("isTopFrame", true);
    }

    public boolean canCoalesce() {
        return false;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        m.f(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(getViewTag(), "topShouldStartLoadWithRequest", this.f13187a);
    }

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return "topShouldStartLoadWithRequest";
    }
}
