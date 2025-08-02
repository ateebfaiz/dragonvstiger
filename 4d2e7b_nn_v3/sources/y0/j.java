package y0;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private float f24862a;

    /* renamed from: b  reason: collision with root package name */
    private int f24863b;

    public void a(float f10) {
        float f11 = this.f24862a + f10;
        this.f24862a = f11;
        int i10 = this.f24863b + 1;
        this.f24863b = i10;
        if (i10 == Integer.MAX_VALUE) {
            this.f24862a = f11 / 2.0f;
            this.f24863b = i10 / 2;
        }
    }
}
