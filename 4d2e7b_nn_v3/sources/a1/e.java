package a1;

public class e implements r {

    /* renamed from: a  reason: collision with root package name */
    private int f13597a;

    /* renamed from: b  reason: collision with root package name */
    private int f13598b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13599c;

    /* renamed from: d  reason: collision with root package name */
    private final float f13600d;

    public e() {
        this(2500, 1, 1.0f);
    }

    public int a() {
        return this.f13597a;
    }

    public void b(u uVar) {
        this.f13598b++;
        int i10 = this.f13597a;
        this.f13597a = (int) (((float) i10) + (((float) i10) * this.f13600d));
        if (!d()) {
            throw uVar;
        }
    }

    public int c() {
        return this.f13598b;
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        if (this.f13598b <= this.f13599c) {
            return true;
        }
        return false;
    }

    public e(int i10, int i11, float f10) {
        this.f13597a = i10;
        this.f13599c = i11;
        this.f13600d = f10;
    }
}
