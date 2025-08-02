package hc;

public abstract class a extends r {

    /* renamed from: a  reason: collision with root package name */
    protected final boolean f344a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f345b;

    /* renamed from: c  reason: collision with root package name */
    protected final byte[] f346c;

    a(boolean z10, int i10, byte[] bArr) {
        this.f344a = z10;
        this.f345b = i10;
        this.f346c = zd.a.e(bArr);
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof a)) {
            return false;
        }
        a aVar = (a) rVar;
        if (this.f344a == aVar.f344a && this.f345b == aVar.f345b && zd.a.a(this.f346c, aVar.f346c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f344a ^ this.f345b) ^ zd.a.m(this.f346c) ? 1 : 0;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.b(this.f345b) + v1.a(this.f346c.length) + this.f346c.length;
    }

    public boolean l() {
        return this.f344a;
    }

    public int o() {
        return this.f345b;
    }
}
