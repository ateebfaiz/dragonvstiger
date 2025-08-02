package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

public class PagerTabStrip extends PagerTitleStrip {
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 32;
    private static final int MIN_TEXT_SPACING = 64;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 32;
    private static final String TAG = "PagerTabStrip";
    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final Paint mTabPaint;
    private final Rect mTempRect;
    private int mTouchSlop;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.mPager;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.mPager;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean getDrawFullUnderline() {
        return this.mDrawFullUnderline;
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.mMinStripHeight);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.mIndicatorColor;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.mCurrText.getLeft() - this.mTabPadding;
        int right = this.mCurrText.getRight() + this.mTabPadding;
        this.mTabPaint.setColor((this.mTabAlpha << 24) | (this.mIndicatorColor & ViewCompat.MEASURED_SIZE_MASK));
        float f10 = (float) height;
        canvas.drawRect((float) left, (float) (height - this.mIndicatorHeight), (float) right, f10, this.mTabPaint);
        if (this.mDrawFullUnderline) {
            this.mTabPaint.setColor((this.mIndicatorColor & ViewCompat.MEASURED_SIZE_MASK) | ViewCompat.MEASURED_STATE_MASK);
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.mFullUnderlineHeight), (float) (getWidth() - getPaddingRight()), f10, this.mTabPaint);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.mIgnoreTap) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (action == 0) {
            this.mInitialMotionX = x10;
            this.mInitialMotionY = y10;
            this.mIgnoreTap = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x10 - this.mInitialMotionX) > ((float) this.mTouchSlop) || Math.abs(y10 - this.mInitialMotionY) > ((float) this.mTouchSlop))) {
                this.mIgnoreTap = true;
            }
        } else if (x10 < ((float) (this.mCurrText.getLeft() - this.mTabPadding))) {
            ViewPager viewPager = this.mPager;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x10 > ((float) (this.mCurrText.getRight() + this.mTabPadding))) {
            ViewPager viewPager2 = this.mPager;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    public void setBackgroundColor(@ColorInt int i10) {
        boolean z10;
        super.setBackgroundColor(i10);
        if (!this.mDrawFullUnderlineSet) {
            if ((i10 & ViewCompat.MEASURED_STATE_MASK) == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.mDrawFullUnderline = z10;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        boolean z10;
        super.setBackgroundDrawable(drawable);
        if (!this.mDrawFullUnderlineSet) {
            if (drawable == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.mDrawFullUnderline = z10;
        }
    }

    public void setBackgroundResource(@DrawableRes int i10) {
        boolean z10;
        super.setBackgroundResource(i10);
        if (!this.mDrawFullUnderlineSet) {
            if (i10 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.mDrawFullUnderline = z10;
        }
    }

    public void setDrawFullUnderline(boolean z10) {
        this.mDrawFullUnderline = z10;
        this.mDrawFullUnderlineSet = true;
        invalidate();
    }

    public void setPadding(int i10, int i11, int i12, int i13) {
        int i14 = this.mMinPaddingBottom;
        if (i13 < i14) {
            i13 = i14;
        }
        super.setPadding(i10, i11, i12, i13);
    }

    public void setTabIndicatorColor(@ColorInt int i10) {
        this.mIndicatorColor = i10;
        this.mTabPaint.setColor(i10);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i10) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i10));
    }

    public void setTextSpacing(int i10) {
        int i11 = this.mMinTextSpacing;
        if (i10 < i11) {
            i10 = i11;
        }
        super.setTextSpacing(i10);
    }

    /* access modifiers changed from: package-private */
    public void updateTextPositions(int i10, float f10, boolean z10) {
        Rect rect = this.mTempRect;
        int height = getHeight();
        int left = this.mCurrText.getLeft() - this.mTabPadding;
        int right = this.mCurrText.getRight() + this.mTabPadding;
        int i11 = height - this.mIndicatorHeight;
        rect.set(left, i11, right, height);
        super.updateTextPositions(i10, f10, z10);
        this.mTabAlpha = (int) (Math.abs(f10 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.mCurrText.getLeft() - this.mTabPadding, i11, this.mCurrText.getRight() + this.mTabPadding, height);
        invalidate(rect);
    }

    public PagerTabStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.mTabPaint = paint;
        this.mTempRect = new Rect();
        this.mTabAlpha = 255;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        int i10 = this.mTextColor;
        this.mIndicatorColor = i10;
        paint.setColor(i10);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.mIndicatorHeight = (int) ((3.0f * f10) + 0.5f);
        this.mMinPaddingBottom = (int) ((6.0f * f10) + 0.5f);
        this.mMinTextSpacing = (int) (64.0f * f10);
        this.mTabPadding = (int) ((16.0f * f10) + 0.5f);
        this.mFullUnderlineHeight = (int) ((1.0f * f10) + 0.5f);
        this.mMinStripHeight = (int) ((f10 * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.mPrevText.setFocusable(true);
        this.mPrevText.setOnClickListener(new a());
        this.mNextText.setFocusable(true);
        this.mNextText.setOnClickListener(new b());
        if (getBackground() == null) {
            this.mDrawFullUnderline = true;
        }
    }
}
