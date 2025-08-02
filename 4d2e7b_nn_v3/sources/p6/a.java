package p6;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.m;

public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f12888a;

    /* renamed from: b  reason: collision with root package name */
    private final WritableMap f12889b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(String str, WritableMap writableMap, int i10, int i11) {
        super(i10, i11);
        m.f(str, "eventName");
        this.f12888a = str;
        this.f12889b = writableMap;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return this.f12889b;
    }

    public String getEventName() {
        return this.f12888a;
    }
}
