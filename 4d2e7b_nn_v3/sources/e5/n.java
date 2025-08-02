package e5;

public class n implements o {

    /* renamed from: d  reason: collision with root package name */
    public static final o f21287d = d(Integer.MAX_VALUE, true, true);

    /* renamed from: a  reason: collision with root package name */
    int f21288a;

    /* renamed from: b  reason: collision with root package name */
    boolean f21289b;

    /* renamed from: c  reason: collision with root package name */
    boolean f21290c;

    private n(int i10, boolean z10, boolean z11) {
        this.f21288a = i10;
        this.f21289b = z10;
        this.f21290c = z11;
    }

    public static o d(int i10, boolean z10, boolean z11) {
        return new n(i10, z10, z11);
    }

    public boolean a() {
        return this.f21290c;
    }

    public boolean b() {
        return this.f21289b;
    }

    public int c() {
        return this.f21288a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f21288a == nVar.f21288a && this.f21289b == nVar.f21289b && this.f21290c == nVar.f21290c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int i11 = this.f21288a;
        int i12 = 0;
        if (this.f21289b) {
            i10 = 4194304;
        } else {
            i10 = 0;
        }
        int i13 = i11 ^ i10;
        if (this.f21290c) {
            i12 = 8388608;
        }
        return i13 ^ i12;
    }
}
