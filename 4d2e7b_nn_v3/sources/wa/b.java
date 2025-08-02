package wa;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class b extends d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f13222b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f13223a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(int i10, String str) {
        super(i10);
        m.f(str, "mPageScrollState");
        this.f13223a = str;
    }

    private final WritableMap a() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("pageScrollState", this.f13223a);
        m.c(createMap);
        return createMap;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        m.f(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), a());
    }

    public String getEventName() {
        return "topPageScrollStateChanged";
    }
}
