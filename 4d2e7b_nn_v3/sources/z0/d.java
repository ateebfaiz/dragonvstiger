package z0;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private float f24995a;

    /* renamed from: b  reason: collision with root package name */
    private float f24996b;

    public d(float f10, float f11) {
        this.f24995a = f10;
        this.f24996b = f11;
    }

    public boolean a(float f10, float f11) {
        if (this.f24995a == f10 && this.f24996b == f11) {
            return true;
        }
        return false;
    }

    public float b() {
        return this.f24995a;
    }

    public float c() {
        return this.f24996b;
    }

    public void d(float f10, float f11) {
        this.f24995a = f10;
        this.f24996b = f11;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public d() {
        this(1.0f, 1.0f);
    }
}
