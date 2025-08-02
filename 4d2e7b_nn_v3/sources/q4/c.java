package q4;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class c {

    /* renamed from: c  reason: collision with root package name */
    public static final a f23229c = new a((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    public static final c f23230d = new c("UNKNOWN", (String) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f23231a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23232b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        int a();

        c b(byte[] bArr, int i10);
    }

    public c(String str, String str2) {
        m.f(str, "name");
        this.f23231a = str;
        this.f23232b = str2;
    }

    public final String a() {
        return this.f23231a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (m.b(this.f23231a, cVar.f23231a) && m.b(this.f23232b, cVar.f23232b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = this.f23231a.hashCode() * 31;
        String str = this.f23232b;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return this.f23231a;
    }
}
