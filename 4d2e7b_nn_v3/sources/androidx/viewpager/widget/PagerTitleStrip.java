package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.DecorView
public class PagerTitleStrip extends ViewGroup {
    private static final int[] ATTRS = {16842804, 16842901, 16842904, 16842927};
    private static final float SIDE_ALPHA = 0.6f;
    private static final int[] TEXT_ATTRS = {16843660};
    private static final int TEXT_SPACING = 16;
    TextView mCurrText;
    private int mGravity;
    private int mLastKnownCurrentPage;
    float mLastKnownPositionOffset;
    TextView mNextText;
    private int mNonPrimaryAlpha;
    private final a mPageListener;
    ViewPager mPager;
    TextView mPrevText;
    private int mScaledTextSpacing;
    int mTextColor;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;
    private WeakReference<PagerAdapter> mWatchingAdapter;

    private class a extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private int f16837a;

        a() {
        }

        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.updateAdapter(pagerAdapter, pagerAdapter2);
        }

        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f10 = pagerTitleStrip2.mLastKnownPositionOffset;
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f10, true);
        }

        public void onPageScrollStateChanged(int i10) {
            this.f16837a = i10;
        }

        public void onPageScrolled(int i10, float f10, int i11) {
            if (f10 > 0.5f) {
                i10++;
            }
            PagerTitleStrip.this.updateTextPositions(i10, f10, false);
        }

        public void onPageSelected(int i10) {
            if (this.f16837a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f10 = pagerTitleStrip2.mLastKnownPositionOffset;
                if (f10 < 0.0f) {
                    f10 = 0.0f;
                }
                pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f10, true);
            }
        }
    }

    private static class b extends SingleLineTransformationMethod {

        /* renamed from: a  reason: collision with root package name */
        private Locale f16839a;

        b(Context context) {
            this.f16839a = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f16839a);
            }
            return null;
        }
    }

    public PagerTitleStrip(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.mScaledTextSpacing;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        PagerAdapter pagerAdapter;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            PagerAdapter adapter = viewPager.getAdapter();
            viewPager.setInternalPageChangeListener(this.mPageListener);
            viewPager.addOnAdapterChangeListener(this.mPageListener);
            this.mPager = viewPager;
            WeakReference<PagerAdapter> weakReference = this.mWatchingAdapter;
            if (weakReference != null) {
                pagerAdapter = weakReference.get();
            } else {
                pagerAdapter = null;
            }
            updateAdapter(pagerAdapter, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            updateAdapter(viewPager.getAdapter(), (PagerAdapter) null);
            this.mPager.setInternalPageChangeListener((ViewPager.OnPageChangeListener) null);
            this.mPager.removeOnAdapterChangeListener(this.mPageListener);
            this.mPager = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.mPager != null) {
            float f10 = this.mLastKnownPositionOffset;
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            updateTextPositions(this.mLastKnownCurrentPage, f10, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int i12;
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i10);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, (int) (((float) size) * 0.2f), -2);
            this.mPrevText.measure(childMeasureSpec2, childMeasureSpec);
            this.mCurrText.measure(childMeasureSpec2, childMeasureSpec);
            this.mNextText.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i11) == 1073741824) {
                i12 = View.MeasureSpec.getSize(i11);
            } else {
                i12 = Math.max(getMinHeight(), this.mCurrText.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(i12, i11, this.mCurrText.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    public void requestLayout() {
        if (!this.mUpdatingText) {
            super.requestLayout();
        }
    }

    public void setGravity(int i10) {
        this.mGravity = i10;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        int i10 = ((int) (f10 * 255.0f)) & 255;
        this.mNonPrimaryAlpha = i10;
        int i11 = (i10 << 24) | (this.mTextColor & ViewCompat.MEASURED_SIZE_MASK);
        this.mPrevText.setTextColor(i11);
        this.mNextText.setTextColor(i11);
    }

    public void setTextColor(@ColorInt int i10) {
        this.mTextColor = i10;
        this.mCurrText.setTextColor(i10);
        int i11 = (this.mNonPrimaryAlpha << 24) | (this.mTextColor & ViewCompat.MEASURED_SIZE_MASK);
        this.mPrevText.setTextColor(i11);
        this.mNextText.setTextColor(i11);
    }

    public void setTextSize(int i10, float f10) {
        this.mPrevText.setTextSize(i10, f10);
        this.mCurrText.setTextSize(i10, f10);
        this.mNextText.setTextSize(i10, f10);
    }

    public void setTextSpacing(int i10) {
        this.mScaledTextSpacing = i10;
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void updateAdapter(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = new WeakReference<>(pagerAdapter2);
        }
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            this.mLastKnownCurrentPage = -1;
            this.mLastKnownPositionOffset = -1.0f;
            updateText(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void updateText(int i10, PagerAdapter pagerAdapter) {
        int i11;
        CharSequence charSequence;
        CharSequence charSequence2;
        if (pagerAdapter != null) {
            i11 = pagerAdapter.getCount();
        } else {
            i11 = 0;
        }
        this.mUpdatingText = true;
        CharSequence charSequence3 = null;
        if (i10 < 1 || pagerAdapter == null) {
            charSequence = null;
        } else {
            charSequence = pagerAdapter.getPageTitle(i10 - 1);
        }
        this.mPrevText.setText(charSequence);
        TextView textView = this.mCurrText;
        if (pagerAdapter == null || i10 >= i11) {
            charSequence2 = null;
        } else {
            charSequence2 = pagerAdapter.getPageTitle(i10);
        }
        textView.setText(charSequence2);
        int i12 = i10 + 1;
        if (i12 < i11 && pagerAdapter != null) {
            charSequence3 = pagerAdapter.getPageTitle(i12);
        }
        this.mNextText.setText(charSequence3);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.mPrevText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mCurrText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mNextText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mLastKnownCurrentPage = i10;
        if (!this.mUpdatingPositions) {
            updateTextPositions(i10, this.mLastKnownPositionOffset, false);
        }
        this.mUpdatingText = false;
    }

    /* access modifiers changed from: package-private */
    public void updateTextPositions(int i10, float f10, boolean z10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = i10;
        float f11 = f10;
        if (i15 != this.mLastKnownCurrentPage) {
            updateText(i15, this.mPager.getAdapter());
        } else if (!z10 && f11 == this.mLastKnownPositionOffset) {
            return;
        }
        this.mUpdatingPositions = true;
        int measuredWidth = this.mPrevText.getMeasuredWidth();
        int measuredWidth2 = this.mCurrText.getMeasuredWidth();
        int measuredWidth3 = this.mNextText.getMeasuredWidth();
        int i16 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i17 = paddingRight + i16;
        int i18 = (width - (paddingLeft + i16)) - i17;
        float f12 = 0.5f + f11;
        if (f12 > 1.0f) {
            f12 -= 1.0f;
        }
        int i19 = ((width - i17) - ((int) (((float) i18) * f12))) - i16;
        int i20 = measuredWidth2 + i19;
        int baseline = this.mPrevText.getBaseline();
        int baseline2 = this.mCurrText.getBaseline();
        int baseline3 = this.mNextText.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i21 = max - baseline;
        int i22 = max - baseline2;
        int i23 = max - baseline3;
        int i24 = measuredWidth3;
        int max2 = Math.max(Math.max(this.mPrevText.getMeasuredHeight() + i21, this.mCurrText.getMeasuredHeight() + i22), this.mNextText.getMeasuredHeight() + i23);
        int i25 = this.mGravity & 112;
        if (i25 == 16) {
            i14 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i25 != 80) {
            i13 = i21 + paddingTop;
            i11 = i22 + paddingTop;
            i12 = paddingTop + i23;
            TextView textView = this.mCurrText;
            textView.layout(i19, i11, i20, textView.getMeasuredHeight() + i11);
            int min = Math.min(paddingLeft, (i19 - this.mScaledTextSpacing) - measuredWidth);
            TextView textView2 = this.mPrevText;
            textView2.layout(min, i13, measuredWidth + min, textView2.getMeasuredHeight() + i13);
            int max3 = Math.max((width - paddingRight) - i24, i20 + this.mScaledTextSpacing);
            TextView textView3 = this.mNextText;
            textView3.layout(max3, i12, max3 + i24, textView3.getMeasuredHeight() + i12);
            this.mLastKnownPositionOffset = f10;
            this.mUpdatingPositions = false;
        } else {
            i14 = (height - paddingBottom) - max2;
        }
        i13 = i21 + i14;
        i11 = i22 + i14;
        i12 = i14 + i23;
        TextView textView4 = this.mCurrText;
        textView4.layout(i19, i11, i20, textView4.getMeasuredHeight() + i11);
        int min2 = Math.min(paddingLeft, (i19 - this.mScaledTextSpacing) - measuredWidth);
        TextView textView22 = this.mPrevText;
        textView22.layout(min2, i13, measuredWidth + min2, textView22.getMeasuredHeight() + i13);
        int max32 = Math.max((width - paddingRight) - i24, i20 + this.mScaledTextSpacing);
        TextView textView32 = this.mNextText;
        textView32.layout(max32, i12, max32 + i24, textView32.getMeasuredHeight() + i12);
        this.mLastKnownPositionOffset = f10;
        this.mUpdatingPositions = false;
    }

    public PagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        this.mPageListener = new a();
        TextView textView = new TextView(context);
        this.mPrevText = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.mCurrText = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.mNextText = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        boolean z10 = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.setTextAppearance(this.mPrevText, resourceId);
            TextViewCompat.setTextAppearance(this.mCurrText, resourceId);
            TextViewCompat.setTextAppearance(this.mNextText, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.mPrevText.setTextColor(color);
            this.mCurrText.setTextColor(color);
            this.mNextText.setTextColor(color);
        }
        this.mGravity = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(SIDE_ALPHA);
        TextView textView4 = this.mPrevText;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView4.setEllipsize(truncateAt);
        this.mCurrText.setEllipsize(truncateAt);
        this.mNextText.setEllipsize(truncateAt);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, TEXT_ATTRS);
            z10 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z10) {
            setSingleLineAllCaps(this.mPrevText);
            setSingleLineAllCaps(this.mCurrText);
            setSingleLineAllCaps(this.mNextText);
        } else {
            this.mPrevText.setSingleLine();
            this.mCurrText.setSingleLine();
            this.mNextText.setSingleLine();
        }
        this.mScaledTextSpacing = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
