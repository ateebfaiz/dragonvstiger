package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

class a {

    /* renamed from: t  reason: collision with root package name */
    private static final boolean f7988t = true;

    /* renamed from: u  reason: collision with root package name */
    private static final boolean f7989u = false;

    /* renamed from: a  reason: collision with root package name */
    private final MaterialButton f7990a;

    /* renamed from: b  reason: collision with root package name */
    private ShapeAppearanceModel f7991b;

    /* renamed from: c  reason: collision with root package name */
    private int f7992c;

    /* renamed from: d  reason: collision with root package name */
    private int f7993d;

    /* renamed from: e  reason: collision with root package name */
    private int f7994e;

    /* renamed from: f  reason: collision with root package name */
    private int f7995f;

    /* renamed from: g  reason: collision with root package name */
    private int f7996g;

    /* renamed from: h  reason: collision with root package name */
    private int f7997h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuff.Mode f7998i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f7999j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f8000k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f8001l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f8002m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8003n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f8004o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f8005p = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f8006q;

    /* renamed from: r  reason: collision with root package name */
    private LayerDrawable f8007r;

    /* renamed from: s  reason: collision with root package name */
    private int f8008s;

    a(MaterialButton materialButton, ShapeAppearanceModel shapeAppearanceModel) {
        this.f7990a = materialButton;
        this.f7991b = shapeAppearanceModel;
    }

    private void E(int i10, int i11) {
        int paddingStart = ViewCompat.getPaddingStart(this.f7990a);
        int paddingTop = this.f7990a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f7990a);
        int paddingBottom = this.f7990a.getPaddingBottom();
        int i12 = this.f7994e;
        int i13 = this.f7995f;
        this.f7995f = i11;
        this.f7994e = i10;
        if (!this.f8004o) {
            F();
        }
        ViewCompat.setPaddingRelative(this.f7990a, paddingStart, (paddingTop + i10) - i12, paddingEnd, (paddingBottom + i11) - i13);
    }

    private void F() {
        this.f7990a.setInternalBackground(a());
        MaterialShapeDrawable f10 = f();
        if (f10 != null) {
            f10.setElevation((float) this.f8008s);
        }
    }

    private void G(ShapeAppearanceModel shapeAppearanceModel) {
        if (!f7989u || this.f8004o) {
            if (f() != null) {
                f().setShapeAppearanceModel(shapeAppearanceModel);
            }
            if (n() != null) {
                n().setShapeAppearanceModel(shapeAppearanceModel);
            }
            if (e() != null) {
                e().setShapeAppearanceModel(shapeAppearanceModel);
                return;
            }
            return;
        }
        int paddingStart = ViewCompat.getPaddingStart(this.f7990a);
        int paddingTop = this.f7990a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f7990a);
        int paddingBottom = this.f7990a.getPaddingBottom();
        F();
        ViewCompat.setPaddingRelative(this.f7990a, paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    private void H() {
        int i10;
        MaterialShapeDrawable f10 = f();
        MaterialShapeDrawable n10 = n();
        if (f10 != null) {
            f10.setStroke((float) this.f7997h, this.f8000k);
            if (n10 != null) {
                float f11 = (float) this.f7997h;
                if (this.f8003n) {
                    i10 = MaterialColors.getColor(this.f7990a, R.attr.colorSurface);
                } else {
                    i10 = 0;
                }
                n10.setStroke(f11, i10);
            }
        }
    }

    private InsetDrawable I(Drawable drawable) {
        return new InsetDrawable(drawable, this.f7992c, this.f7994e, this.f7993d, this.f7995f);
    }

    private Drawable a() {
        int i10;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.f7991b);
        materialShapeDrawable.initializeElevationOverlay(this.f7990a.getContext());
        DrawableCompat.setTintList(materialShapeDrawable, this.f7999j);
        PorterDuff.Mode mode = this.f7998i;
        if (mode != null) {
            DrawableCompat.setTintMode(materialShapeDrawable, mode);
        }
        materialShapeDrawable.setStroke((float) this.f7997h, this.f8000k);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.f7991b);
        materialShapeDrawable2.setTint(0);
        float f10 = (float) this.f7997h;
        if (this.f8003n) {
            i10 = MaterialColors.getColor(this.f7990a, R.attr.colorSurface);
        } else {
            i10 = 0;
        }
        materialShapeDrawable2.setStroke(f10, i10);
        if (f7988t) {
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.f7991b);
            this.f8002m = materialShapeDrawable3;
            DrawableCompat.setTint(materialShapeDrawable3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.f8001l), I(new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable})), this.f8002m);
            this.f8007r = rippleDrawable;
            return rippleDrawable;
        }
        RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.f7991b);
        this.f8002m = rippleDrawableCompat;
        DrawableCompat.setTintList(rippleDrawableCompat, RippleUtils.sanitizeRippleDrawableColor(this.f8001l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable, this.f8002m});
        this.f8007r = layerDrawable;
        return I(layerDrawable);
    }

    private MaterialShapeDrawable g(boolean z10) {
        LayerDrawable layerDrawable = this.f8007r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (f7988t) {
            return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.f8007r.getDrawable(0)).getDrawable()).getDrawable(z10 ^ true ? 1 : 0);
        }
        return (MaterialShapeDrawable) this.f8007r.getDrawable(z10 ^ true ? 1 : 0);
    }

    private MaterialShapeDrawable n() {
        return g(true);
    }

    /* access modifiers changed from: package-private */
    public void A(ColorStateList colorStateList) {
        if (this.f8000k != colorStateList) {
            this.f8000k = colorStateList;
            H();
        }
    }

    /* access modifiers changed from: package-private */
    public void B(int i10) {
        if (this.f7997h != i10) {
            this.f7997h = i10;
            H();
        }
    }

    /* access modifiers changed from: package-private */
    public void C(ColorStateList colorStateList) {
        if (this.f7999j != colorStateList) {
            this.f7999j = colorStateList;
            if (f() != null) {
                DrawableCompat.setTintList(f(), this.f7999j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void D(PorterDuff.Mode mode) {
        if (this.f7998i != mode) {
            this.f7998i = mode;
            if (f() != null && this.f7998i != null) {
                DrawableCompat.setTintMode(f(), this.f7998i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f7996g;
    }

    public int c() {
        return this.f7995f;
    }

    public int d() {
        return this.f7994e;
    }

    public Shapeable e() {
        LayerDrawable layerDrawable = this.f8007r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.f8007r.getNumberOfLayers() > 2) {
            return (Shapeable) this.f8007r.getDrawable(2);
        }
        return (Shapeable) this.f8007r.getDrawable(1);
    }

    /* access modifiers changed from: package-private */
    public MaterialShapeDrawable f() {
        return g(false);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList h() {
        return this.f8001l;
    }

    /* access modifiers changed from: package-private */
    public ShapeAppearanceModel i() {
        return this.f7991b;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList j() {
        return this.f8000k;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f7997h;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f7999j;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode m() {
        return this.f7998i;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return this.f8004o;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.f8006q;
    }

    /* access modifiers changed from: package-private */
    public void q(TypedArray typedArray) {
        this.f7992c = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.f7993d = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.f7994e = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.f7995f = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(R.styleable.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, -1);
            this.f7996g = dimensionPixelSize;
            y(this.f7991b.withCornerSize((float) dimensionPixelSize));
            this.f8005p = true;
        }
        this.f7997h = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.f7998i = ViewUtils.parseTintMode(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f7999j = MaterialResources.getColorStateList(this.f7990a.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.f8000k = MaterialResources.getColorStateList(this.f7990a.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.f8001l = MaterialResources.getColorStateList(this.f7990a.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.f8006q = typedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        this.f8008s = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        int paddingStart = ViewCompat.getPaddingStart(this.f7990a);
        int paddingTop = this.f7990a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f7990a);
        int paddingBottom = this.f7990a.getPaddingBottom();
        if (typedArray.hasValue(R.styleable.MaterialButton_android_background)) {
            s();
        } else {
            F();
        }
        ViewCompat.setPaddingRelative(this.f7990a, paddingStart + this.f7992c, paddingTop + this.f7994e, paddingEnd + this.f7993d, paddingBottom + this.f7995f);
    }

    /* access modifiers changed from: package-private */
    public void r(int i10) {
        if (f() != null) {
            f().setTint(i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        this.f8004o = true;
        this.f7990a.setSupportBackgroundTintList(this.f7999j);
        this.f7990a.setSupportBackgroundTintMode(this.f7998i);
    }

    /* access modifiers changed from: package-private */
    public void t(boolean z10) {
        this.f8006q = z10;
    }

    /* access modifiers changed from: package-private */
    public void u(int i10) {
        if (!this.f8005p || this.f7996g != i10) {
            this.f7996g = i10;
            this.f8005p = true;
            y(this.f7991b.withCornerSize((float) i10));
        }
    }

    public void v(int i10) {
        E(this.f7994e, i10);
    }

    public void w(int i10) {
        E(i10, this.f7995f);
    }

    /* access modifiers changed from: package-private */
    public void x(ColorStateList colorStateList) {
        if (this.f8001l != colorStateList) {
            this.f8001l = colorStateList;
            boolean z10 = f7988t;
            if (z10 && (this.f7990a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f7990a.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
            } else if (!z10 && (this.f7990a.getBackground() instanceof RippleDrawableCompat)) {
                ((RippleDrawableCompat) this.f7990a.getBackground()).setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void y(ShapeAppearanceModel shapeAppearanceModel) {
        this.f7991b = shapeAppearanceModel;
        G(shapeAppearanceModel);
    }

    /* access modifiers changed from: package-private */
    public void z(boolean z10) {
        this.f8003n = z10;
        H();
    }
}
