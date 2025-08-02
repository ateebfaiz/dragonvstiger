package com.google.android.material.card;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

class a {

    /* renamed from: u  reason: collision with root package name */
    private static final double f8009u = Math.cos(Math.toRadians(45.0d));

    /* renamed from: v  reason: collision with root package name */
    private static final Drawable f8010v;

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f8011a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f8012b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private final MaterialShapeDrawable f8013c;

    /* renamed from: d  reason: collision with root package name */
    private final MaterialShapeDrawable f8014d;

    /* renamed from: e  reason: collision with root package name */
    private int f8015e;

    /* renamed from: f  reason: collision with root package name */
    private int f8016f;

    /* renamed from: g  reason: collision with root package name */
    private int f8017g;

    /* renamed from: h  reason: collision with root package name */
    private int f8018h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f8019i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f8020j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f8021k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f8022l;

    /* renamed from: m  reason: collision with root package name */
    private ShapeAppearanceModel f8023m;

    /* renamed from: n  reason: collision with root package name */
    private ColorStateList f8024n;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f8025o;

    /* renamed from: p  reason: collision with root package name */
    private LayerDrawable f8026p;

    /* renamed from: q  reason: collision with root package name */
    private MaterialShapeDrawable f8027q;

    /* renamed from: r  reason: collision with root package name */
    private MaterialShapeDrawable f8028r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f8029s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f8030t;

    /* renamed from: com.google.android.material.card.a$a  reason: collision with other inner class name */
    class C0091a extends InsetDrawable {
        C0091a(Drawable drawable, int i10, int i11, int i12, int i13) {
            super(drawable, i10, i11, i12, i13);
        }

        public int getMinimumHeight() {
            return -1;
        }

        public int getMinimumWidth() {
            return -1;
        }

        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    static {
        ColorDrawable colorDrawable;
        if (Build.VERSION.SDK_INT <= 28) {
            colorDrawable = new ColorDrawable();
        } else {
            colorDrawable = null;
        }
        f8010v = colorDrawable;
    }

    public a(MaterialCardView materialCardView, AttributeSet attributeSet, int i10, int i11) {
        this.f8011a = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i10, i11);
        this.f8013c = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(materialCardView.getContext());
        materialShapeDrawable.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R.styleable.CardView, i10, R.style.CardView);
        if (obtainStyledAttributes.hasValue(R.styleable.CardView_cardCornerRadius)) {
            builder.setAllCornerSizes(obtainStyledAttributes.getDimension(R.styleable.CardView_cardCornerRadius, 0.0f));
        }
        this.f8014d = new MaterialShapeDrawable();
        V(builder.build());
        obtainStyledAttributes.recycle();
    }

    private Drawable B(Drawable drawable) {
        int i10;
        int i11;
        if (this.f8011a.getUseCompatPadding()) {
            i10 = (int) Math.ceil((double) d());
            i11 = (int) Math.ceil((double) c());
        } else {
            i11 = 0;
            i10 = 0;
        }
        return new C0091a(drawable, i11, i10, i11, i10);
    }

    private boolean E() {
        if ((this.f8017g & 80) == 80) {
            return true;
        }
        return false;
    }

    private boolean F() {
        if ((this.f8017g & GravityCompat.END) == 8388613) {
            return true;
        }
        return false;
    }

    private boolean Z() {
        if (!this.f8011a.getPreventCornerOverlap() || e()) {
            return false;
        }
        return true;
    }

    private float a() {
        return Math.max(Math.max(b(this.f8023m.getTopLeftCorner(), this.f8013c.getTopLeftCornerResolvedSize()), b(this.f8023m.getTopRightCorner(), this.f8013c.getTopRightCornerResolvedSize())), Math.max(b(this.f8023m.getBottomRightCorner(), this.f8013c.getBottomRightCornerResolvedSize()), b(this.f8023m.getBottomLeftCorner(), this.f8013c.getBottomLeftCornerResolvedSize())));
    }

    private boolean a0() {
        if (!this.f8011a.getPreventCornerOverlap() || !e() || !this.f8011a.getUseCompatPadding()) {
            return false;
        }
        return true;
    }

    private float b(CornerTreatment cornerTreatment, float f10) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - f8009u) * ((double) f10));
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return f10 / 2.0f;
        }
        return 0.0f;
    }

    private float c() {
        float f10;
        float maxCardElevation = this.f8011a.getMaxCardElevation();
        if (a0()) {
            f10 = a();
        } else {
            f10 = 0.0f;
        }
        return maxCardElevation + f10;
    }

    private float d() {
        float f10;
        float maxCardElevation = this.f8011a.getMaxCardElevation() * 1.5f;
        if (a0()) {
            f10 = a();
        } else {
            f10 = 0.0f;
        }
        return maxCardElevation + f10;
    }

    private boolean e() {
        return this.f8013c.isRoundRect();
    }

    private void e0(Drawable drawable) {
        if (this.f8011a.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) this.f8011a.getForeground()).setDrawable(drawable);
        } else {
            this.f8011a.setForeground(B(drawable));
        }
    }

    private Drawable f() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        MaterialShapeDrawable h10 = h();
        this.f8027q = h10;
        h10.setFillColor(this.f8021k);
        stateListDrawable.addState(new int[]{16842919}, this.f8027q);
        return stateListDrawable;
    }

    private Drawable g() {
        if (!RippleUtils.USE_FRAMEWORK_RIPPLE) {
            return f();
        }
        this.f8028r = h();
        return new RippleDrawable(this.f8021k, (Drawable) null, this.f8028r);
    }

    private void g0() {
        Drawable drawable;
        if (!RippleUtils.USE_FRAMEWORK_RIPPLE || (drawable = this.f8025o) == null) {
            MaterialShapeDrawable materialShapeDrawable = this.f8027q;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setFillColor(this.f8021k);
                return;
            }
            return;
        }
        ((RippleDrawable) drawable).setColor(this.f8021k);
    }

    private MaterialShapeDrawable h() {
        return new MaterialShapeDrawable(this.f8023m);
    }

    private Drawable r() {
        if (this.f8025o == null) {
            this.f8025o = g();
        }
        if (this.f8026p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f8025o, this.f8014d, this.f8020j});
            this.f8026p = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.f8026p;
    }

    private float t() {
        if (!this.f8011a.getPreventCornerOverlap() || !this.f8011a.getUseCompatPadding()) {
            return 0.0f;
        }
        return (float) ((1.0d - f8009u) * ((double) this.f8011a.getCardViewRadius()));
    }

    /* access modifiers changed from: package-private */
    public Rect A() {
        return this.f8012b;
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        return this.f8029s;
    }

    /* access modifiers changed from: package-private */
    public boolean D() {
        return this.f8030t;
    }

    /* access modifiers changed from: package-private */
    public void G(TypedArray typedArray) {
        Drawable drawable;
        ColorStateList colorStateList = MaterialResources.getColorStateList(this.f8011a.getContext(), typedArray, R.styleable.MaterialCardView_strokeColor);
        this.f8024n = colorStateList;
        if (colorStateList == null) {
            this.f8024n = ColorStateList.valueOf(-1);
        }
        this.f8018h = typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z10 = typedArray.getBoolean(R.styleable.MaterialCardView_android_checkable, false);
        this.f8030t = z10;
        this.f8011a.setLongClickable(z10);
        this.f8022l = MaterialResources.getColorStateList(this.f8011a.getContext(), typedArray, R.styleable.MaterialCardView_checkedIconTint);
        N(MaterialResources.getDrawable(this.f8011a.getContext(), typedArray, R.styleable.MaterialCardView_checkedIcon));
        Q(typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconSize, 0));
        P(typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconMargin, 0));
        this.f8017g = typedArray.getInteger(R.styleable.MaterialCardView_checkedIconGravity, 8388661);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(this.f8011a.getContext(), typedArray, R.styleable.MaterialCardView_rippleColor);
        this.f8021k = colorStateList2;
        if (colorStateList2 == null) {
            this.f8021k = ColorStateList.valueOf(MaterialColors.getColor(this.f8011a, R.attr.colorControlHighlight));
        }
        K(MaterialResources.getColorStateList(this.f8011a.getContext(), typedArray, R.styleable.MaterialCardView_cardForegroundColor));
        g0();
        d0();
        h0();
        this.f8011a.setBackgroundInternal(B(this.f8013c));
        if (this.f8011a.isClickable()) {
            drawable = r();
        } else {
            drawable = this.f8014d;
        }
        this.f8019i = drawable;
        this.f8011a.setForeground(B(drawable));
    }

    /* access modifiers changed from: package-private */
    public void H(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        if (this.f8026p != null) {
            if (this.f8011a.getUseCompatPadding()) {
                i13 = (int) Math.ceil((double) (d() * 2.0f));
                i12 = (int) Math.ceil((double) (c() * 2.0f));
            } else {
                i13 = 0;
                i12 = 0;
            }
            if (F()) {
                i14 = ((i10 - this.f8015e) - this.f8016f) - i12;
            } else {
                i14 = this.f8015e;
            }
            if (E()) {
                i15 = this.f8015e;
            } else {
                i15 = ((i11 - this.f8015e) - this.f8016f) - i13;
            }
            int i20 = i15;
            if (F()) {
                i16 = this.f8015e;
            } else {
                i16 = ((i10 - this.f8015e) - this.f8016f) - i12;
            }
            if (E()) {
                i17 = ((i11 - this.f8015e) - this.f8016f) - i13;
            } else {
                i17 = this.f8015e;
            }
            int i21 = i17;
            if (ViewCompat.getLayoutDirection(this.f8011a) == 1) {
                i19 = i16;
                i18 = i14;
            } else {
                i18 = i16;
                i19 = i14;
            }
            this.f8026p.setLayerInset(2, i19, i21, i18, i20);
        }
    }

    /* access modifiers changed from: package-private */
    public void I(boolean z10) {
        this.f8029s = z10;
    }

    /* access modifiers changed from: package-private */
    public void J(ColorStateList colorStateList) {
        this.f8013c.setFillColor(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public void K(ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.f8014d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.setFillColor(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public void L(boolean z10) {
        this.f8030t = z10;
    }

    public void M(boolean z10) {
        int i10;
        Drawable drawable = this.f8020j;
        if (drawable != null) {
            if (z10) {
                i10 = 255;
            } else {
                i10 = 0;
            }
            drawable.setAlpha(i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void N(Drawable drawable) {
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.f8020j = mutate;
            DrawableCompat.setTintList(mutate, this.f8022l);
            M(this.f8011a.isChecked());
        } else {
            this.f8020j = f8010v;
        }
        LayerDrawable layerDrawable = this.f8026p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.f8020j);
        }
    }

    /* access modifiers changed from: package-private */
    public void O(int i10) {
        this.f8017g = i10;
        H(this.f8011a.getMeasuredWidth(), this.f8011a.getMeasuredHeight());
    }

    /* access modifiers changed from: package-private */
    public void P(int i10) {
        this.f8015e = i10;
    }

    /* access modifiers changed from: package-private */
    public void Q(int i10) {
        this.f8016f = i10;
    }

    /* access modifiers changed from: package-private */
    public void R(ColorStateList colorStateList) {
        this.f8022l = colorStateList;
        Drawable drawable = this.f8020j;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void S(float f10) {
        V(this.f8023m.withCornerSize(f10));
        this.f8019i.invalidateSelf();
        if (a0() || Z()) {
            c0();
        }
        if (a0()) {
            f0();
        }
    }

    /* access modifiers changed from: package-private */
    public void T(float f10) {
        this.f8013c.setInterpolation(f10);
        MaterialShapeDrawable materialShapeDrawable = this.f8014d;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(f10);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.f8028r;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setInterpolation(f10);
        }
    }

    /* access modifiers changed from: package-private */
    public void U(ColorStateList colorStateList) {
        this.f8021k = colorStateList;
        g0();
    }

    /* access modifiers changed from: package-private */
    public void V(ShapeAppearanceModel shapeAppearanceModel) {
        this.f8023m = shapeAppearanceModel;
        this.f8013c.setShapeAppearanceModel(shapeAppearanceModel);
        MaterialShapeDrawable materialShapeDrawable = this.f8013c;
        materialShapeDrawable.setShadowBitmapDrawingEnable(!materialShapeDrawable.isRoundRect());
        MaterialShapeDrawable materialShapeDrawable2 = this.f8014d;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.f8028r;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable4 = this.f8027q;
        if (materialShapeDrawable4 != null) {
            materialShapeDrawable4.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    /* access modifiers changed from: package-private */
    public void W(ColorStateList colorStateList) {
        if (this.f8024n != colorStateList) {
            this.f8024n = colorStateList;
            h0();
        }
    }

    /* access modifiers changed from: package-private */
    public void X(int i10) {
        if (i10 != this.f8018h) {
            this.f8018h = i10;
            h0();
        }
    }

    /* access modifiers changed from: package-private */
    public void Y(int i10, int i11, int i12, int i13) {
        this.f8012b.set(i10, i11, i12, i13);
        c0();
    }

    /* access modifiers changed from: package-private */
    public void b0() {
        Drawable drawable;
        Drawable drawable2 = this.f8019i;
        if (this.f8011a.isClickable()) {
            drawable = r();
        } else {
            drawable = this.f8014d;
        }
        this.f8019i = drawable;
        if (drawable2 != drawable) {
            e0(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void c0() {
        float f10;
        if (Z() || a0()) {
            f10 = a();
        } else {
            f10 = 0.0f;
        }
        int t10 = (int) (f10 - t());
        MaterialCardView materialCardView = this.f8011a;
        Rect rect = this.f8012b;
        materialCardView.setAncestorContentPadding(rect.left + t10, rect.top + t10, rect.right + t10, rect.bottom + t10);
    }

    /* access modifiers changed from: package-private */
    public void d0() {
        this.f8013c.setElevation(this.f8011a.getCardElevation());
    }

    /* access modifiers changed from: package-private */
    public void f0() {
        if (!C()) {
            this.f8011a.setBackgroundInternal(B(this.f8013c));
        }
        this.f8011a.setForeground(B(this.f8019i));
    }

    /* access modifiers changed from: package-private */
    public void h0() {
        this.f8014d.setStroke((float) this.f8018h, this.f8024n);
    }

    /* access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f8025o;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i10 = bounds.bottom;
            this.f8025o.setBounds(bounds.left, bounds.top, bounds.right, i10 - 1);
            this.f8025o.setBounds(bounds.left, bounds.top, bounds.right, i10);
        }
    }

    /* access modifiers changed from: package-private */
    public MaterialShapeDrawable j() {
        return this.f8013c;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList k() {
        return this.f8013c.getFillColor();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f8014d.getFillColor();
    }

    /* access modifiers changed from: package-private */
    public Drawable m() {
        return this.f8020j;
    }

    /* access modifiers changed from: package-private */
    public int n() {
        return this.f8017g;
    }

    /* access modifiers changed from: package-private */
    public int o() {
        return this.f8015e;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.f8016f;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList q() {
        return this.f8022l;
    }

    /* access modifiers changed from: package-private */
    public float s() {
        return this.f8013c.getTopLeftCornerResolvedSize();
    }

    /* access modifiers changed from: package-private */
    public float u() {
        return this.f8013c.getInterpolation();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList v() {
        return this.f8021k;
    }

    /* access modifiers changed from: package-private */
    public ShapeAppearanceModel w() {
        return this.f8023m;
    }

    /* access modifiers changed from: package-private */
    public int x() {
        ColorStateList colorStateList = this.f8024n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList y() {
        return this.f8024n;
    }

    /* access modifiers changed from: package-private */
    public int z() {
        return this.f8018h;
    }
}
