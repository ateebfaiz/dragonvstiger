package r5;

import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f23691a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f23692b;

    public a(String str, boolean z10) {
        m.f(str, "name");
        this.f23691a = str;
        this.f23692b = z10;
    }

    public final String a() {
        return this.f23691a;
    }

    public final boolean b() {
        return this.f23692b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!m.b(this.f23691a, aVar.f23691a) || this.f23692b != aVar.f23692b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        String str = this.f23691a;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int i11 = i10 * 31;
        boolean z10 = this.f23692b;
        if (z10) {
            z10 = true;
        }
        return i11 + (z10 ? 1 : 0);
    }

    public String toString() {
        return "GateKeeper(name=" + this.f23691a + ", value=" + this.f23692b + ")";
    }
}
