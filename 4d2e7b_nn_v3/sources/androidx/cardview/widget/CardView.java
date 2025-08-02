package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.cardview.R;

public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {16842801};
    private static final c IMPL;
    private final b mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private Drawable f14454a;

        a() {
        }

        public void a(Drawable drawable) {
            this.f14454a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        public boolean b() {
            return CardView.this.getPreventCornerOverlap();
        }

        public boolean c() {
            return CardView.this.getUseCompatPadding();
        }

        public Drawable d() {
            return this.f14454a;
        }

        public View e() {
            return CardView.this;
        }

        public void setShadowPadding(int i10, int i11, int i12, int i13) {
            CardView.this.mShadowBounds.set(i10, i11, i12, i13);
            CardView cardView = CardView.this;
            Rect rect = cardView.mContentPadding;
            CardView.super.setPadding(i10 + rect.left, i11 + rect.top, i12 + rect.right, i13 + rect.bottom);
        }
    }

    static {
        a aVar = new a();
        IMPL = aVar;
        aVar.j();
    }

    public CardView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return IMPL.h(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.c(this.mCardViewDelegate);
    }

    @Px
    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    @Px
    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    @Px
    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    @Px
    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.g(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return IMPL.d(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        c cVar = IMPL;
        if (!(cVar instanceof a)) {
            int mode = View.MeasureSpec.getMode(i10);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i10 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) cVar.l(this.mCardViewDelegate)), View.MeasureSpec.getSize(i10)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i11);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) cVar.k(this.mCardViewDelegate)), View.MeasureSpec.getSize(i11)), mode2);
            }
            super.onMeasure(i10, i11);
            return;
        }
        super.onMeasure(i10, i11);
    }

    public void setCardBackgroundColor(@ColorInt int i10) {
        IMPL.n(this.mCardViewDelegate, ColorStateList.valueOf(i10));
    }

    public void setCardElevation(float f10) {
        IMPL.f(this.mCardViewDelegate, f10);
    }

    public void setContentPadding(@Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        this.mContentPadding.set(i10, i11, i12, i13);
        IMPL.i(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f10) {
        IMPL.o(this.mCardViewDelegate, f10);
    }

    public void setMinimumHeight(int i10) {
        this.mUserSetMinHeight = i10;
        super.setMinimumHeight(i10);
    }

    public void setMinimumWidth(int i10) {
        this.mUserSetMinWidth = i10;
        super.setMinimumWidth(i10);
    }

    public void setPadding(int i10, int i11, int i12, int i13) {
    }

    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z10;
            IMPL.m(this.mCardViewDelegate);
        }
    }

    public void setRadius(float f10) {
        IMPL.b(this.mCardViewDelegate, f10);
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.mCompatPadding != z10) {
            this.mCompatPadding = z10;
            IMPL.e(this.mCardViewDelegate);
        }
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.cardViewStyle);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        IMPL.n(this.mCardViewDelegate, colorStateList);
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        int i11;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.mContentPadding = rect;
        this.mShadowBounds = new Rect();
        a aVar = new a();
        this.mCardViewDelegate = aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CardView, i10, R.style.CardView);
        if (obtainStyledAttributes.hasValue(R.styleable.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(R.styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i11 = getResources().getColor(R.color.cardview_light_background);
            } else {
                i11 = getResources().getColor(R.color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(i11);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R.styleable.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = obtainStyledAttributes.getBoolean(R.styleable.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = obtainStyledAttributes.getBoolean(R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPadding, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f10 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        IMPL.a(aVar, context, colorStateList, dimension, dimension2, f10);
    }
}
