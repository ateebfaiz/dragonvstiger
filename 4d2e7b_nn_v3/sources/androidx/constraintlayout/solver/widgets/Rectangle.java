package androidx.constraintlayout.solver.widgets;

public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x  reason: collision with root package name */
    public int f14717x;

    /* renamed from: y  reason: collision with root package name */
    public int f14718y;

    public boolean contains(int i10, int i11) {
        int i12;
        int i13 = this.f14717x;
        if (i10 < i13 || i10 >= i13 + this.width || i11 < (i12 = this.f14718y) || i11 >= i12 + this.height) {
            return false;
        }
        return true;
    }

    public int getCenterX() {
        return (this.f14717x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f14718y + this.height) / 2;
    }

    /* access modifiers changed from: package-private */
    public void grow(int i10, int i11) {
        this.f14717x -= i10;
        this.f14718y -= i11;
        this.width += i10 * 2;
        this.height += i11 * 2;
    }

    /* access modifiers changed from: package-private */
    public boolean intersects(Rectangle rectangle) {
        int i10;
        int i11;
        int i12 = this.f14717x;
        int i13 = rectangle.f14717x;
        if (i12 < i13 || i12 >= i13 + rectangle.width || (i10 = this.f14718y) < (i11 = rectangle.f14718y) || i10 >= i11 + rectangle.height) {
            return false;
        }
        return true;
    }

    public void setBounds(int i10, int i11, int i12, int i13) {
        this.f14717x = i10;
        this.f14718y = i11;
        this.width = i12;
        this.height = i13;
    }
}
