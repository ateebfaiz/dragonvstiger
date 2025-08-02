package cb;

import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class h extends d {

    /* renamed from: e  reason: collision with root package name */
    public static final a f2673e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final float f2674a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2675b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2676c;

    /* renamed from: d  reason: collision with root package name */
    private final short f2677d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public h(int i10, int i11, float f10, boolean z10, boolean z11, short s10) {
        super(i10, i11);
        this.f2674a = f10;
        this.f2675b = z10;
        this.f2676c = z11;
        this.f2677d = s10;
    }

    public short getCoalescingKey() {
        return this.f2677d;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble(NotificationCompat.CATEGORY_PROGRESS, (double) this.f2674a);
        createMap.putInt("closing", this.f2675b ? 1 : 0);
        createMap.putInt("goingForward", this.f2676c ? 1 : 0);
        return createMap;
    }

    public String getEventName() {
        return "topTransitionProgress";
    }
}
