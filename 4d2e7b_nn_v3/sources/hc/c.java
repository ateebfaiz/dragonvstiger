package hc;

import zd.a;

public class c extends r {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f357b = {-1};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f358c = {0};

    /* renamed from: d  reason: collision with root package name */
    public static final c f359d = new c(false);

    /* renamed from: e  reason: collision with root package name */
    public static final c f360e = new c(true);

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f361a;

    c(byte[] bArr) {
        if (bArr.length == 1) {
            byte b10 = bArr[0];
            if (b10 == 0) {
                this.f361a = f358c;
            } else if ((b10 & 255) == 255) {
                this.f361a = f357b;
            } else {
                this.f361a = a.e(bArr);
            }
        } else {
            throw new IllegalArgumentException("byte value should have 1 byte in it");
        }
    }

    static c o(byte[] bArr) {
        if (bArr.length == 1) {
            byte b10 = bArr[0];
            if (b10 == 0) {
                return f359d;
            }
            if ((b10 & 255) == 255) {
                return f360e;
            }
            return new c(bArr);
        }
        throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
    }

    /* access modifiers changed from: protected */
    public boolean g(r rVar) {
        if (!(rVar instanceof c) || this.f361a[0] != ((c) rVar).f361a[0]) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f361a[0];
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.g(1, this.f361a);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return 3;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    public String toString() {
        if (this.f361a[0] != 0) {
            return "TRUE";
        }
        return "FALSE";
    }

    public c(boolean z10) {
        this.f361a = z10 ? f357b : f358c;
    }
}
