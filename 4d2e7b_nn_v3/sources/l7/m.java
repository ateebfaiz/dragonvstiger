package l7;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class m extends Animation implements j {

    /* renamed from: a  reason: collision with root package name */
    private final View f12650a;

    /* renamed from: b  reason: collision with root package name */
    private float f12651b;

    /* renamed from: c  reason: collision with root package name */
    private float f12652c;

    /* renamed from: d  reason: collision with root package name */
    private float f12653d;

    /* renamed from: e  reason: collision with root package name */
    private float f12654e;

    /* renamed from: f  reason: collision with root package name */
    private int f12655f;

    /* renamed from: g  reason: collision with root package name */
    private int f12656g;

    /* renamed from: h  reason: collision with root package name */
    private int f12657h;

    /* renamed from: i  reason: collision with root package name */
    private int f12658i;

    public m(View view, int i10, int i11, int i12, int i13) {
        this.f12650a = view;
        b(i10, i11, i12, i13);
    }

    private void b(int i10, int i11, int i12, int i13) {
        this.f12651b = this.f12650a.getX() - this.f12650a.getTranslationX();
        this.f12652c = this.f12650a.getY() - this.f12650a.getTranslationY();
        this.f12655f = this.f12650a.getWidth();
        int height = this.f12650a.getHeight();
        this.f12656g = height;
        this.f12653d = ((float) i10) - this.f12651b;
        this.f12654e = ((float) i11) - this.f12652c;
        this.f12657h = i12 - this.f12655f;
        this.f12658i = i13 - height;
    }

    public void a(int i10, int i11, int i12, int i13) {
        b(i10, i11, i12, i13);
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f10, Transformation transformation) {
        float f11 = this.f12651b + (this.f12653d * f10);
        float f12 = this.f12652c + (this.f12654e * f10);
        this.f12650a.layout(Math.round(f11), Math.round(f12), Math.round(f11 + ((float) this.f12655f) + (((float) this.f12657h) * f10)), Math.round(f12 + ((float) this.f12656g) + (((float) this.f12658i) * f10)));
    }

    public boolean willChangeBounds() {
        return true;
    }
}
