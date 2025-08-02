package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;

public class BottomSheetDialog extends AppCompatDialog {
    /* access modifiers changed from: private */
    public BottomSheetBehavior<FrameLayout> behavior;
    /* access modifiers changed from: private */
    public FrameLayout bottomSheet;
    @NonNull
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    /* access modifiers changed from: private */
    public BottomSheetBehavior.BottomSheetCallback edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            if (BottomSheetDialog.this.edgeToEdgeCallback != null) {
                BottomSheetDialog.this.behavior.removeBottomSheetCallback(BottomSheetDialog.this.edgeToEdgeCallback);
            }
            if (windowInsetsCompat != null) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                BottomSheetBehavior.BottomSheetCallback unused = bottomSheetDialog.edgeToEdgeCallback = new f(bottomSheetDialog.bottomSheet, windowInsetsCompat, (a) null);
                BottomSheetDialog.this.behavior.addBottomSheetCallback(BottomSheetDialog.this.edgeToEdgeCallback);
            }
            return windowInsetsCompat;
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
            if (bottomSheetDialog.cancelable && bottomSheetDialog.isShowing() && BottomSheetDialog.this.shouldWindowCloseOnTouchOutside()) {
                BottomSheetDialog.this.cancel();
            }
        }
    }

    class c extends AccessibilityDelegateCompat {
        c() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (BottomSheetDialog.this.cancelable) {
                accessibilityNodeInfoCompat.addAction(1048576);
                accessibilityNodeInfoCompat.setDismissable(true);
                return;
            }
            accessibilityNodeInfoCompat.setDismissable(false);
        }

        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (i10 == 1048576) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.cancelable) {
                    bottomSheetDialog.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i10, bundle);
        }
    }

    class d implements View.OnTouchListener {
        d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    class e extends BottomSheetBehavior.BottomSheetCallback {
        e() {
        }

        public void onSlide(View view, float f10) {
        }

        public void onStateChanged(View view, int i10) {
            if (i10 == 5) {
                BottomSheetDialog.this.cancel();
            }
        }
    }

    private static class f extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f7975a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f7976b;

        /* renamed from: c  reason: collision with root package name */
        private final WindowInsetsCompat f7977c;

        /* synthetic */ f(View view, WindowInsetsCompat windowInsetsCompat, a aVar) {
            this(view, windowInsetsCompat);
        }

        private void a(View view) {
            if (view.getTop() < this.f7977c.getSystemWindowInsetTop()) {
                BottomSheetDialog.setLightStatusBar(view, this.f7975a);
                view.setPadding(view.getPaddingLeft(), this.f7977c.getSystemWindowInsetTop() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                BottomSheetDialog.setLightStatusBar(view, this.f7976b);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        /* access modifiers changed from: package-private */
        public void onLayout(View view) {
            a(view);
        }

        public void onSlide(View view, float f10) {
            a(view);
        }

        public void onStateChanged(View view, int i10) {
            a(view);
        }

        private f(View view, WindowInsetsCompat windowInsetsCompat) {
            ColorStateList colorStateList;
            this.f7977c = windowInsetsCompat;
            boolean z10 = (view.getSystemUiVisibility() & 8192) != 0;
            this.f7976b = z10;
            MaterialShapeDrawable materialShapeDrawable = BottomSheetBehavior.from(view).getMaterialShapeDrawable();
            if (materialShapeDrawable != null) {
                colorStateList = materialShapeDrawable.getFillColor();
            } else {
                colorStateList = ViewCompat.getBackgroundTintList(view);
            }
            if (colorStateList != null) {
                this.f7975a = MaterialColors.isColorLight(colorStateList.getDefaultColor());
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.f7975a = MaterialColors.isColorLight(((ColorDrawable) view.getBackground()).getColor());
            } else {
                this.f7975a = z10;
            }
        }
    }

    public BottomSheetDialog(@NonNull Context context) {
        this(context, 0);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, (ViewGroup) null);
            this.container = frameLayout;
            this.coordinator = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.container.findViewById(R.id.design_bottom_sheet);
            this.bottomSheet = frameLayout2;
            BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout2);
            this.behavior = from;
            from.addBottomSheetCallback(this.bottomSheetCallback);
            this.behavior.setHideable(this.cancelable);
        }
        return this.container;
    }

    private static int getThemeResId(@NonNull Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return R.style.Theme_Design_Light_BottomSheetDialog;
    }

    public static void setLightStatusBar(@NonNull View view, boolean z10) {
        int i10;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z10) {
            i10 = systemUiVisibility | 8192;
        } else {
            i10 = systemUiVisibility & -8193;
        }
        view.setSystemUiVisibility(i10);
    }

    private View wrapInBottomSheet(int i10, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        ensureContainerAndBehavior();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.container.findViewById(R.id.coordinator);
        if (i10 != 0 && view == null) {
            view = getLayoutInflater().inflate(i10, coordinatorLayout, false);
        }
        if (this.edgeToEdgeEnabled) {
            ViewCompat.setOnApplyWindowInsetsListener(this.bottomSheet, new a());
        }
        this.bottomSheet.removeAllViews();
        if (layoutParams == null) {
            this.bottomSheet.addView(view);
        } else {
            this.bottomSheet.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new b());
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new c());
        this.bottomSheet.setOnTouchListener(new d());
        return this.container;
    }

    public void cancel() {
        BottomSheetBehavior<FrameLayout> behavior2 = getBehavior();
        if (!this.dismissWithAnimation || behavior2.getState() == 5) {
            super.cancel();
        } else {
            behavior2.setState(5);
        }
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior == null) {
            ensureContainerAndBehavior();
        }
        return this.behavior;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    public void onAttachedToWindow() {
        boolean z10;
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            if (!this.edgeToEdgeEnabled || Color.alpha(window.getNavigationBarColor()) >= 255) {
                z10 = false;
            } else {
                z10 = true;
            }
            FrameLayout frameLayout = this.container;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z10);
            }
            CoordinatorLayout coordinatorLayout = this.coordinator;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z10);
            }
            if (z10) {
                window.getDecorView().setSystemUiVisibility(768);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior != null && bottomSheetBehavior.getState() == 5) {
            this.behavior.setState(4);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    public void setCancelable(boolean z10) {
        super.setCancelable(z10);
        if (this.cancelable != z10) {
            this.cancelable = z10;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z10);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z10) {
        super.setCanceledOnTouchOutside(z10);
        if (z10 && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z10;
        this.canceledOnTouchOutsideSet = true;
    }

    public void setContentView(@LayoutRes int i10) {
        super.setContentView(wrapInBottomSheet(i10, (View) null, (ViewGroup.LayoutParams) null));
    }

    public void setDismissWithAnimation(boolean z10) {
        this.dismissWithAnimation = z10;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }

    public void setContentView(View view) {
        super.setContentView(wrapInBottomSheet(0, view, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(wrapInBottomSheet(0, view, layoutParams));
    }

    public BottomSheetDialog(@NonNull Context context, @StyleRes int i10) {
        super(context, getThemeResId(context, i10));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new e();
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    protected BottomSheetDialog(@NonNull Context context, boolean z10, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z10, onCancelListener);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new e();
        supportRequestWindowFeature(1);
        this.cancelable = z10;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }
}
