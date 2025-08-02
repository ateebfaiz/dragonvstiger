package s7;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public static final C0156a f12975a = new C0156a((DefaultConstructorMarker) null);

    /* renamed from: s7.a$a  reason: collision with other inner class name */
    public static final class C0156a {
        private C0156a() {
        }

        public /* synthetic */ C0156a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(int i10, int i11) {
        super(i10, i11);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }

    public String getEventName() {
        return "topDrawerClose";
    }
}
