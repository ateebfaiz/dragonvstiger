package cb;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public static final C0046a f2665a = new C0046a((DefaultConstructorMarker) null);

    /* renamed from: cb.a$a  reason: collision with other inner class name */
    public static final class C0046a {
        private C0046a() {
        }

        public /* synthetic */ C0046a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(int i10, int i11) {
        super(i10, i11);
    }

    public short getCoalescingKey() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }

    public String getEventName() {
        return "topAttached";
    }
}
