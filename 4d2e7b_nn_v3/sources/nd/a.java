package nd;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f1335a;

    /* renamed from: b  reason: collision with root package name */
    private int f1336b;

    /* renamed from: c  reason: collision with root package name */
    private int f1337c;

    /* renamed from: d  reason: collision with root package name */
    private short[][][] f1338d;

    /* renamed from: e  reason: collision with root package name */
    private short[][][] f1339e;

    /* renamed from: f  reason: collision with root package name */
    private short[][] f1340f;

    /* renamed from: g  reason: collision with root package name */
    private short[] f1341g;

    public a(byte b10, byte b11, short[][][] sArr, short[][][] sArr2, short[][] sArr3, short[] sArr4) {
        byte b12 = b10 & 255;
        this.f1335a = b12;
        byte b13 = b11 & 255;
        this.f1336b = b13;
        this.f1337c = b13 - b12;
        this.f1338d = sArr;
        this.f1339e = sArr2;
        this.f1340f = sArr3;
        this.f1341g = sArr4;
    }

    public short[][][] a() {
        return this.f1338d;
    }

    public short[][][] b() {
        return this.f1339e;
    }

    public short[] c() {
        return this.f1341g;
    }

    public short[][] d() {
        return this.f1340f;
    }

    public int e() {
        return this.f1337c;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f1335a != aVar.f() || this.f1336b != aVar.g() || this.f1337c != aVar.e() || !od.a.k(this.f1338d, aVar.a()) || !od.a.k(this.f1339e, aVar.b()) || !od.a.j(this.f1340f, aVar.d()) || !od.a.i(this.f1341g, aVar.c())) {
            return false;
        }
        return true;
    }

    public int f() {
        return this.f1335a;
    }

    public int g() {
        return this.f1336b;
    }

    public int hashCode() {
        return (((((((((((this.f1335a * 37) + this.f1336b) * 37) + this.f1337c) * 37) + zd.a.t(this.f1338d)) * 37) + zd.a.t(this.f1339e)) * 37) + zd.a.s(this.f1340f)) * 37) + zd.a.r(this.f1341g);
    }
}
