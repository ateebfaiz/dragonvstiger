package va;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public static final C0158a f13168b = new C0158a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final WritableMap f13169a;

    /* renamed from: va.a$a  reason: collision with other inner class name */
    public static final class C0158a {
        private C0158a() {
        }

        public /* synthetic */ C0158a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(int i10, WritableMap writableMap) {
        super(i10);
        m.f(writableMap, "mEventData");
        this.f13169a = writableMap;
    }

    public boolean canCoalesce() {
        return false;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        m.f(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), this.f13169a);
    }

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return "topCustomMenuSelection";
    }
}
