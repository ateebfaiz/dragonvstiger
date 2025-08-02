package hb;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f12322a;

    /* renamed from: b  reason: collision with root package name */
    private int f12323b;

    /* renamed from: c  reason: collision with root package name */
    private int f12324c;

    public b(int i10, int i11, int i12) {
        this.f12322a = i10;
        this.f12323b = i11;
        this.f12324c = i12;
    }

    public int a() {
        return this.f12323b;
    }

    public int b() {
        return this.f12324c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f12322a != bVar.f12322a || this.f12323b != bVar.f12323b) {
            return false;
        }
        if (this.f12324c == bVar.f12324c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f12322a * 31) + this.f12323b) * 31) + this.f12324c;
    }
}
