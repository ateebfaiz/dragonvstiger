package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ViewUtils {

    public interface OnApplyWindowInsetsListener {
        WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, RelativePadding relativePadding);
    }

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f8336a;

        a(View view) {
            this.f8336a = view;
        }

        public void run() {
            ((InputMethodManager) this.f8336a.getContext().getSystemService("input_method")).showSoftInput(this.f8336a, 1);
        }
    }

    class b implements OnApplyWindowInsetsListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8337a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f8338b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f8339c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ OnApplyWindowInsetsListener f8340d;

        b(boolean z10, boolean z11, boolean z12, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            this.f8337a = z10;
            this.f8338b = z11;
            this.f8339c = z12;
            this.f8340d = onApplyWindowInsetsListener;
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, RelativePadding relativePadding) {
            if (this.f8337a) {
                relativePadding.bottom += windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(view);
            if (this.f8338b) {
                if (isLayoutRtl) {
                    relativePadding.end += windowInsetsCompat.getSystemWindowInsetLeft();
                } else {
                    relativePadding.start += windowInsetsCompat.getSystemWindowInsetLeft();
                }
            }
            if (this.f8339c) {
                if (isLayoutRtl) {
                    relativePadding.start += windowInsetsCompat.getSystemWindowInsetRight();
                } else {
                    relativePadding.end += windowInsetsCompat.getSystemWindowInsetRight();
                }
            }
            relativePadding.applyToView(view);
            OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f8340d;
            if (onApplyWindowInsetsListener != null) {
                return onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsetsCompat, relativePadding);
            }
            return windowInsetsCompat;
        }
    }

    class c implements androidx.core.view.OnApplyWindowInsetsListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OnApplyWindowInsetsListener f8341a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RelativePadding f8342b;

        c(OnApplyWindowInsetsListener onApplyWindowInsetsListener, RelativePadding relativePadding) {
            this.f8341a = onApplyWindowInsetsListener;
            this.f8342b = relativePadding;
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return this.f8341a.onApplyWindowInsets(view, windowInsetsCompat, new RelativePadding(this.f8342b));
        }
    }

    class d implements View.OnAttachStateChangeListener {
        d() {
        }

        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    private ViewUtils() {
    }

    public static void addOnGlobalLayoutListener(@Nullable View view, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void doOnApplyWindowInsets(@NonNull View view, @Nullable AttributeSet attributeSet, int i10, int i11) {
        doOnApplyWindowInsets(view, attributeSet, i10, i11, (OnApplyWindowInsetsListener) null);
    }

    public static float dpToPx(@NonNull Context context, @Dimension(unit = 0) int i10) {
        return TypedValue.applyDimension(1, (float) i10, context.getResources().getDisplayMetrics());
    }

    @Nullable
    public static Integer getBackgroundColor(@NonNull View view) {
        if (view.getBackground() instanceof ColorDrawable) {
            return Integer.valueOf(((ColorDrawable) view.getBackground()).getColor());
        }
        return null;
    }

    @Nullable
    public static ViewGroup getContentView(@Nullable View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(16908290);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    @Nullable
    public static ViewOverlayImpl getContentViewOverlay(@NonNull View view) {
        return getOverlay(getContentView(view));
    }

    @Nullable
    public static ViewOverlayImpl getOverlay(@Nullable View view) {
        if (view == null) {
            return null;
        }
        return new b(view);
    }

    public static float getParentAbsoluteElevation(@NonNull View view) {
        float f10 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f10 += ViewCompat.getElevation((View) parent);
        }
        return f10;
    }

    public static boolean isLayoutRtl(View view) {
        if (ViewCompat.getLayoutDirection(view) == 1) {
            return true;
        }
        return false;
    }

    public static PorterDuff.Mode parseTintMode(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void removeOnGlobalLayoutListener(@Nullable View view, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            removeOnGlobalLayoutListener(view.getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public static void requestApplyInsetsWhenAttached(@NonNull View view) {
        if (ViewCompat.isAttachedToWindow(view)) {
            ViewCompat.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new d());
        }
    }

    public static void requestFocusAndShowKeyboard(@NonNull View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    public static void doOnApplyWindowInsets(@NonNull View view, @Nullable AttributeSet attributeSet, int i10, int i11, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.Insets, i10, i11);
        boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z12 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingRightSystemWindowInsets, false);
        obtainStyledAttributes.recycle();
        doOnApplyWindowInsets(view, new b(z10, z11, z12, onApplyWindowInsetsListener));
    }

    public static void removeOnGlobalLayoutListener(@NonNull ViewTreeObserver viewTreeObserver, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static class RelativePadding {
        public int bottom;
        public int end;
        public int start;
        public int top;

        public RelativePadding(int i10, int i11, int i12, int i13) {
            this.start = i10;
            this.top = i11;
            this.end = i12;
            this.bottom = i13;
        }

        public void applyToView(View view) {
            ViewCompat.setPaddingRelative(view, this.start, this.top, this.end, this.bottom);
        }

        public RelativePadding(@NonNull RelativePadding relativePadding) {
            this.start = relativePadding.start;
            this.top = relativePadding.top;
            this.end = relativePadding.end;
            this.bottom = relativePadding.bottom;
        }
    }

    public static void doOnApplyWindowInsets(@NonNull View view, @NonNull OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new c(onApplyWindowInsetsListener, new RelativePadding(ViewCompat.getPaddingStart(view), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom())));
        requestApplyInsetsWhenAttached(view);
    }
}
