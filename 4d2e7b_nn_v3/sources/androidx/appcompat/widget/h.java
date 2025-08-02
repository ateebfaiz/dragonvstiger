package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

class h extends f {

    /* renamed from: d  reason: collision with root package name */
    private final SeekBar f14329d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f14330e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f14331f = null;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f14332g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14333h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14334i = false;

    h(SeekBar seekBar) {
        super(seekBar);
        this.f14329d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f14330e;
        if (drawable == null) {
            return;
        }
        if (this.f14333h || this.f14334i) {
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            this.f14330e = wrap;
            if (this.f14333h) {
                DrawableCompat.setTintList(wrap, this.f14331f);
            }
            if (this.f14334i) {
                DrawableCompat.setTintMode(this.f14330e, this.f14332g);
            }
            if (this.f14330e.isStateful()) {
                this.f14330e.setState(this.f14329d.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i10) {
        super.c(attributeSet, i10);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f14329d.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i10, 0);
        SeekBar seekBar = this.f14329d;
        ViewCompat.saveAttributeDataForStyleable(seekBar, seekBar.getContext(), R.styleable.AppCompatSeekBar, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i10, 0);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableIfKnown != null) {
            this.f14329d.setThumb(drawableIfKnown);
        }
        j(obtainStyledAttributes.getDrawable(R.styleable.AppCompatSeekBar_tickMark));
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f14332g = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f14332g);
            this.f14334i = true;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f14331f = obtainStyledAttributes.getColorStateList(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.f14333h = true;
        }
        obtainStyledAttributes.recycle();
        f();
    }

    /* access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        int i10;
        if (this.f14330e != null) {
            int max = this.f14329d.getMax();
            int i11 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f14330e.getIntrinsicWidth();
                int intrinsicHeight = this.f14330e.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i10 = intrinsicWidth / 2;
                } else {
                    i10 = 1;
                }
                if (intrinsicHeight >= 0) {
                    i11 = intrinsicHeight / 2;
                }
                this.f14330e.setBounds(-i10, -i11, i10, i11);
                float width = ((float) ((this.f14329d.getWidth() - this.f14329d.getPaddingLeft()) - this.f14329d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f14329d.getPaddingLeft(), (float) (this.f14329d.getHeight() / 2));
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f14330e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f14330e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f14329d.getDrawableState())) {
            this.f14329d.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f14330e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    public void j(Drawable drawable) {
        Drawable drawable2 = this.f14330e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f14330e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f14329d);
            DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this.f14329d));
            if (drawable.isStateful()) {
                drawable.setState(this.f14329d.getDrawableState());
            }
            f();
        }
        this.f14329d.invalidate();
    }
}
