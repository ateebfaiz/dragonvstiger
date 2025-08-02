package w8;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class d extends a {

    /* renamed from: b  reason: collision with root package name */
    private final String f13216b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(String str) {
        super(str, (DefaultConstructorMarker) null);
        m.f(str, "message");
        this.f13216b = str;
    }

    public String getMessage() {
        return this.f13216b;
    }
}
