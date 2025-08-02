package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.collection.SimpleArrayMap;
import androidx.core.R;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.autofill.AutofillIdCompat;
import androidx.core.view.contentcapture.ContentCaptureSessionCompat;
import androidx.webkit.ProxyConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class ViewCompat {
    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_AUTO = 0;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO = 2;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO_EXCLUDE_DESCENDANTS = 8;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES_EXCLUDE_DESCENDANTS = 4;
    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;
    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;
    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    @Deprecated
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    @Deprecated
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    @Deprecated
    public static final int LAYOUT_DIRECTION_LTR = 0;
    @Deprecated
    public static final int LAYOUT_DIRECTION_RTL = 1;
    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    @Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;
    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;
    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    private static final OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = new i0();
    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;
    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    private static boolean sAccessibilityDelegateCheckFailed;
    private static Field sAccessibilityDelegateField;
    private static final e sAccessibilityPaneVisibilityManager = new e();
    private static Method sChildrenDrawingOrderMethod;
    private static Method sDispatchFinishTemporaryDetach;
    private static Method sDispatchStartTemporaryDetach;
    private static boolean sTempDetachBound;
    private static ThreadLocal<Rect> sThreadLocalRect;
    private static WeakHashMap<View, String> sTransitionNameMap;
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusDirection {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRealDirection {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRelativeDirection {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NestedScrollType {
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(@NonNull View view, @NonNull KeyEvent keyEvent);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollAxis {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollIndicators {
    }

    class a extends f {
        a(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public Boolean c(View view) {
            return Boolean.valueOf(l.d(view));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void d(View view, Boolean bool) {
            l.j(view, bool.booleanValue());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    class b extends f {
        b(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public CharSequence c(View view) {
            return l.b(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void d(View view, CharSequence charSequence) {
            l.h(view, charSequence);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class c extends f {
        c(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public CharSequence c(View view) {
            return n.b(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void d(View view, CharSequence charSequence) {
            n.f(view, charSequence);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class d extends f {
        d(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public Boolean c(View view) {
            return Boolean.valueOf(l.c(view));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void d(View view, Boolean bool) {
            l.g(view, bool.booleanValue());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private final WeakHashMap f15162a = new WeakHashMap();

        e() {
        }

        private void b(Map.Entry entry) {
            boolean z10;
            int i10;
            View view = (View) entry.getKey();
            boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
            if (!view.isShown() || view.getWindowVisibility() != 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (booleanValue != z10) {
                if (z10) {
                    i10 = 16;
                } else {
                    i10 = 32;
                }
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, i10);
                entry.setValue(Boolean.valueOf(z10));
            }
        }

        private void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void e(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            boolean z10;
            WeakHashMap weakHashMap = this.f15162a;
            if (!view.isShown() || view.getWindowVisibility() != 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            weakHashMap.put(view, Boolean.valueOf(z10));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                c(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(View view) {
            this.f15162a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry b10 : this.f15162a.entrySet()) {
                    b(b10);
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        private final int f15163a;

        /* renamed from: b  reason: collision with root package name */
        private final Class f15164b;

        /* renamed from: c  reason: collision with root package name */
        private final int f15165c;

        /* renamed from: d  reason: collision with root package name */
        private final int f15166d;

        f(int i10, Class cls, int i11) {
            this(i10, cls, 0, i11);
        }

        private boolean b() {
            if (Build.VERSION.SDK_INT >= this.f15165c) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Boolean bool, Boolean bool2) {
            boolean z10;
            boolean z11;
            if (bool == null || !bool.booleanValue()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (bool2 == null || !bool2.booleanValue()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z10 == z11) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract Object c(View view);

        /* access modifiers changed from: package-private */
        public abstract void d(View view, Object obj);

        /* access modifiers changed from: package-private */
        public Object e(View view) {
            if (b()) {
                return c(view);
            }
            Object tag = view.getTag(this.f15163a);
            if (this.f15164b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void f(View view, Object obj) {
            if (b()) {
                d(view, obj);
            } else if (g(e(view), obj)) {
                ViewCompat.ensureAccessibilityDelegateCompat(view);
                view.setTag(this.f15163a, obj);
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, this.f15166d);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract boolean g(Object obj, Object obj2);

        f(int i10, Class cls, int i11, int i12) {
            this.f15163a = i10;
            this.f15164b = cls;
            this.f15166d = i11;
            this.f15165c = i12;
        }
    }

    static class g {
        @DoNotInline
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        @DoNotInline
        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        @DoNotInline
        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    private static class h {

        class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a  reason: collision with root package name */
            WindowInsetsCompat f15167a = null;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f15168b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ OnApplyWindowInsetsListener f15169c;

            a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
                this.f15168b = view;
                this.f15169c = onApplyWindowInsetsListener;
            }

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                int i10 = Build.VERSION.SDK_INT;
                if (i10 < 30) {
                    h.a(windowInsets, this.f15168b);
                    if (windowInsetsCompat.equals(this.f15167a)) {
                        return this.f15169c.onApplyWindowInsets(view, windowInsetsCompat).toWindowInsets();
                    }
                }
                this.f15167a = windowInsetsCompat;
                WindowInsetsCompat onApplyWindowInsets = this.f15169c.onApplyWindowInsets(view, windowInsetsCompat);
                if (i10 >= 30) {
                    return onApplyWindowInsets.toWindowInsets();
                }
                ViewCompat.requestApplyInsets(view);
                return onApplyWindowInsets.toWindowInsets();
            }
        }

        @DoNotInline
        static void a(@NonNull WindowInsets windowInsets, @NonNull View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        @DoNotInline
        static WindowInsetsCompat b(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        @DoNotInline
        static boolean c(@NonNull View view, float f10, float f11, boolean z10) {
            return view.dispatchNestedFling(f10, f11, z10);
        }

        @DoNotInline
        static boolean d(@NonNull View view, float f10, float f11) {
            return view.dispatchNestedPreFling(f10, f11);
        }

        @DoNotInline
        static boolean e(View view, int i10, int i11, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i10, i11, iArr, iArr2);
        }

        @DoNotInline
        static boolean f(View view, int i10, int i11, int i12, int i13, int[] iArr) {
            return view.dispatchNestedScroll(i10, i11, i12, i13, iArr);
        }

        @DoNotInline
        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        @DoNotInline
        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        @DoNotInline
        static float i(View view) {
            return view.getElevation();
        }

        @DoNotInline
        @Nullable
        public static WindowInsetsCompat j(@NonNull View view) {
            return WindowInsetsCompat.a.a(view);
        }

        @DoNotInline
        static String k(View view) {
            return view.getTransitionName();
        }

        @DoNotInline
        static float l(View view) {
            return view.getTranslationZ();
        }

        @DoNotInline
        static float m(@NonNull View view) {
            return view.getZ();
        }

        @DoNotInline
        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        @DoNotInline
        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        @DoNotInline
        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        @DoNotInline
        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        @DoNotInline
        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        @DoNotInline
        static void s(View view, float f10) {
            view.setElevation(f10);
        }

        @DoNotInline
        static void t(View view, boolean z10) {
            view.setNestedScrollingEnabled(z10);
        }

        @DoNotInline
        static void u(@NonNull View view, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, onApplyWindowInsetsListener));
            }
        }

        @DoNotInline
        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        @DoNotInline
        static void w(View view, float f10) {
            view.setTranslationZ(f10);
        }

        @DoNotInline
        static void x(@NonNull View view, float f10) {
            view.setZ(f10);
        }

        @DoNotInline
        static boolean y(View view, int i10) {
            return view.startNestedScroll(i10);
        }

        @DoNotInline
        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    private static class i {
        @Nullable
        public static WindowInsetsCompat a(@NonNull View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets);
            windowInsetsCompat.setRootWindowInsets(windowInsetsCompat);
            windowInsetsCompat.copyRootViewBounds(view.getRootView());
            return windowInsetsCompat;
        }

        @DoNotInline
        static int b(@NonNull View view) {
            return view.getScrollIndicators();
        }

        @DoNotInline
        static void c(@NonNull View view, int i10) {
            view.setScrollIndicators(i10);
        }

        @DoNotInline
        static void d(@NonNull View view, int i10, int i11) {
            view.setScrollIndicators(i10, i11);
        }
    }

    static class j {
        @DoNotInline
        static void a(@NonNull View view) {
            view.cancelDragAndDrop();
        }

        @DoNotInline
        static void b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        @DoNotInline
        static void c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        @DoNotInline
        static void d(@NonNull View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        @DoNotInline
        static boolean e(@NonNull View view, @Nullable ClipData clipData, @NonNull View.DragShadowBuilder dragShadowBuilder, @Nullable Object obj, int i10) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i10);
        }

        @DoNotInline
        static void f(@NonNull View view, @NonNull View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    static class k {
        @DoNotInline
        static void a(@NonNull View view, Collection<View> collection, int i10) {
            view.addKeyboardNavigationClusters(collection, i10);
        }

        @DoNotInline
        public static AutofillId b(View view) {
            return view.getAutofillId();
        }

        @DoNotInline
        static int c(View view) {
            return view.getImportantForAutofill();
        }

        @DoNotInline
        static int d(@NonNull View view) {
            return view.getNextClusterForwardId();
        }

        @DoNotInline
        static boolean e(@NonNull View view) {
            return view.hasExplicitFocusable();
        }

        @DoNotInline
        static boolean f(@NonNull View view) {
            return view.isFocusedByDefault();
        }

        @DoNotInline
        static boolean g(View view) {
            return view.isImportantForAutofill();
        }

        @DoNotInline
        static boolean h(@NonNull View view) {
            return view.isKeyboardNavigationCluster();
        }

        @DoNotInline
        static View i(@NonNull View view, View view2, int i10) {
            return view.keyboardNavigationClusterSearch(view2, i10);
        }

        @DoNotInline
        static boolean j(@NonNull View view) {
            return view.restoreDefaultFocus();
        }

        @DoNotInline
        static void k(@NonNull View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        @DoNotInline
        static void l(@NonNull View view, boolean z10) {
            view.setFocusedByDefault(z10);
        }

        @DoNotInline
        static void m(View view, int i10) {
            view.setImportantForAutofill(i10);
        }

        @DoNotInline
        static void n(@NonNull View view, boolean z10) {
            view.setKeyboardNavigationCluster(z10);
        }

        @DoNotInline
        static void o(View view, int i10) {
            view.setNextClusterForwardId(i10);
        }

        @DoNotInline
        static void p(@NonNull View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    static class l {
        @DoNotInline
        static void a(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.tag_unhandled_key_listeners);
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap();
                view.setTag(R.id.tag_unhandled_key_listeners, simpleArrayMap);
            }
            Objects.requireNonNull(onUnhandledKeyEventListenerCompat);
            j0 j0Var = new j0(onUnhandledKeyEventListenerCompat);
            simpleArrayMap.put(onUnhandledKeyEventListenerCompat, j0Var);
            view.addOnUnhandledKeyEventListener(j0Var);
        }

        @DoNotInline
        static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        @DoNotInline
        static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        @DoNotInline
        static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        @DoNotInline
        static void e(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.tag_unhandled_key_listeners);
            if (simpleArrayMap != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.get(onUnhandledKeyEventListenerCompat)) != null) {
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            }
        }

        @DoNotInline
        static <T> T f(View view, int i10) {
            return view.requireViewById(i10);
        }

        @DoNotInline
        static void g(View view, boolean z10) {
            view.setAccessibilityHeading(z10);
        }

        @DoNotInline
        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        @DoNotInline
        public static void i(View view, AutofillIdCompat autofillIdCompat) {
            AutofillId autofillId;
            if (autofillIdCompat == null) {
                autofillId = null;
            } else {
                autofillId = autofillIdCompat.toAutofillId();
            }
            view.setAutofillId(autofillId);
        }

        @DoNotInline
        static void j(View view, boolean z10) {
            view.setScreenReaderFocusable(z10);
        }
    }

    private static class m {
        @DoNotInline
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        @DoNotInline
        static ContentCaptureSession b(View view) {
            return view.getContentCaptureSession();
        }

        @DoNotInline
        static List<Rect> c(View view) {
            return view.getSystemGestureExclusionRects();
        }

        @DoNotInline
        static void d(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i10, int i11) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
        }

        @DoNotInline
        static void e(View view, ContentCaptureSessionCompat contentCaptureSessionCompat) {
            ContentCaptureSession contentCaptureSession;
            if (contentCaptureSessionCompat == null) {
                contentCaptureSession = null;
            } else {
                contentCaptureSession = contentCaptureSessionCompat.toContentCaptureSession();
            }
            view.setContentCaptureSession(contentCaptureSession);
        }

        @DoNotInline
        static void f(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    private static class n {
        @DoNotInline
        static int a(View view) {
            return view.getImportantForContentCapture();
        }

        @DoNotInline
        static CharSequence b(View view) {
            return view.getStateDescription();
        }

        @Nullable
        public static WindowInsetsControllerCompat c(@NonNull View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(windowInsetsController);
            }
            return null;
        }

        @DoNotInline
        static boolean d(View view) {
            return view.isImportantForContentCapture();
        }

        @DoNotInline
        static void e(View view, int i10) {
            view.setImportantForContentCapture(i10);
        }

        @DoNotInline
        static void f(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    private static final class o {
        @DoNotInline
        @Nullable
        public static String[] a(@NonNull View view) {
            return view.getReceiveContentMimeTypes();
        }

        @DoNotInline
        @Nullable
        public static ContentInfoCompat b(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
            ContentInfo contentInfo = contentInfoCompat.toContentInfo();
            ContentInfo performReceiveContent = view.performReceiveContent(contentInfo);
            if (performReceiveContent == null) {
                return null;
            }
            if (performReceiveContent == contentInfo) {
                return contentInfoCompat;
            }
            return ContentInfoCompat.toContentInfoCompat(performReceiveContent);
        }

        @DoNotInline
        public static void c(@NonNull View view, @Nullable String[] strArr, @Nullable OnReceiveContentListener onReceiveContentListener) {
            if (onReceiveContentListener == null) {
                view.setOnReceiveContentListener(strArr, (OnReceiveContentListener) null);
            } else {
                view.setOnReceiveContentListener(strArr, new p(onReceiveContentListener));
            }
        }
    }

    private static final class p implements OnReceiveContentListener {

        /* renamed from: a  reason: collision with root package name */
        private final OnReceiveContentListener f15170a;

        p(OnReceiveContentListener onReceiveContentListener) {
            this.f15170a = onReceiveContentListener;
        }

        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            ContentInfoCompat contentInfoCompat = ContentInfoCompat.toContentInfoCompat(contentInfo);
            ContentInfoCompat onReceiveContent = this.f15170a.onReceiveContent(view, contentInfoCompat);
            if (onReceiveContent == null) {
                return null;
            }
            if (onReceiveContent == contentInfoCompat) {
                return contentInfo;
            }
            return onReceiveContent.toContentInfo();
        }
    }

    static class q {

        /* renamed from: d  reason: collision with root package name */
        private static final ArrayList f15171d = new ArrayList();

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap f15172a = null;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray f15173b = null;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference f15174c = null;

        q() {
        }

        static q a(View view) {
            q qVar = (q) view.getTag(R.id.tag_unhandled_key_event_manager);
            if (qVar != null) {
                return qVar;
            }
            q qVar2 = new q();
            view.setTag(R.id.tag_unhandled_key_event_manager, qVar2);
            return qVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.f15172a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c10 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c10 != null) {
                            return c10;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray d() {
            if (this.f15173b == null) {
                this.f15173b = new SparseArray();
            }
            return this.f15173b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap weakHashMap = this.f15172a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = f15171d;
            if (!arrayList.isEmpty()) {
                synchronized (arrayList) {
                    try {
                        if (this.f15172a == null) {
                            this.f15172a = new WeakHashMap();
                        }
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            ArrayList arrayList2 = f15171d;
                            View view = (View) ((WeakReference) arrayList2.get(size)).get();
                            if (view == null) {
                                arrayList2.remove(size);
                            } else {
                                this.f15172a.put(view, Boolean.TRUE);
                                for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    this.f15172a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }

        static void h(View view) {
            ArrayList arrayList = f15171d;
            synchronized (arrayList) {
                try {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (((WeakReference) it.next()).get() == view) {
                            return;
                        }
                    }
                    f15171d.add(new WeakReference(view));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        static void i(View view) {
            synchronized (f15171d) {
                int i10 = 0;
                while (true) {
                    try {
                        ArrayList arrayList = f15171d;
                        if (i10 >= arrayList.size()) {
                            return;
                        }
                        if (((WeakReference) arrayList.get(i10)).get() == view) {
                            arrayList.remove(i10);
                            return;
                        }
                        i10++;
                    } finally {
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c10 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c10 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(c10));
                }
            }
            if (c10 != null) {
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.ref.WeakReference} */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean f(android.view.KeyEvent r6) {
            /*
                r5 = this;
                java.lang.ref.WeakReference r0 = r5.f15174c
                r1 = 0
                if (r0 == 0) goto L_0x000c
                java.lang.Object r0 = r0.get()
                if (r0 != r6) goto L_0x000c
                return r1
            L_0x000c:
                java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
                r0.<init>(r6)
                r5.f15174c = r0
                android.util.SparseArray r0 = r5.d()
                int r2 = r6.getAction()
                r3 = 1
                if (r2 != r3) goto L_0x0032
                int r2 = r6.getKeyCode()
                int r2 = r0.indexOfKey(r2)
                if (r2 < 0) goto L_0x0032
                java.lang.Object r4 = r0.valueAt(r2)
                java.lang.ref.WeakReference r4 = (java.lang.ref.WeakReference) r4
                r0.removeAt(r2)
                goto L_0x0033
            L_0x0032:
                r4 = 0
            L_0x0033:
                if (r4 != 0) goto L_0x0040
                int r2 = r6.getKeyCode()
                java.lang.Object r0 = r0.get(r2)
                r4 = r0
                java.lang.ref.WeakReference r4 = (java.lang.ref.WeakReference) r4
            L_0x0040:
                if (r4 == 0) goto L_0x0054
                java.lang.Object r0 = r4.get()
                android.view.View r0 = (android.view.View) r0
                if (r0 == 0) goto L_0x0053
                boolean r1 = r0.isAttachedToWindow()
                if (r1 == 0) goto L_0x0053
                r5.e(r0, r6)
            L_0x0053:
                return r3
            L_0x0054:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewCompat.q.f(android.view.KeyEvent):boolean");
        }
    }

    @Deprecated
    protected ViewCompat() {
    }

    private static f accessibilityHeadingProperty() {
        return new d(R.id.tag_accessibility_heading, Boolean.class, 28);
    }

    public static int addAccessibilityAction(@NonNull View view, @NonNull CharSequence charSequence, @NonNull AccessibilityViewCommand accessibilityViewCommand) {
        int availableActionIdFromResources = getAvailableActionIdFromResources(view, charSequence);
        if (availableActionIdFromResources != -1) {
            addAccessibilityAction(view, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(availableActionIdFromResources, charSequence, accessibilityViewCommand));
        }
        return availableActionIdFromResources;
    }

    public static void addKeyboardNavigationClusters(@NonNull View view, @NonNull Collection<View> collection, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            k.a(view, collection, i10);
        }
    }

    public static void addOnUnhandledKeyEventListener(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            l.a(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(R.id.tag_unhandled_key_listeners, arrayList);
        }
        arrayList.add(onUnhandledKeyEventListenerCompat);
        if (arrayList.size() == 1) {
            q.h(view);
        }
    }

    @NonNull
    @Deprecated
    public static ViewPropertyAnimatorCompat animate(@NonNull View view) {
        if (sViewPropertyAnimatorMap == null) {
            sViewPropertyAnimatorMap = new WeakHashMap<>();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = sViewPropertyAnimatorMap.get(view);
        if (viewPropertyAnimatorCompat != null) {
            return viewPropertyAnimatorCompat;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
        sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat2);
        return viewPropertyAnimatorCompat2;
    }

    private static void bindTempDetach() {
        Class<View> cls = View.class;
        try {
            sDispatchStartTemporaryDetach = cls.getDeclaredMethod("dispatchStartTemporaryDetach", (Class[]) null);
            sDispatchFinishTemporaryDetach = cls.getDeclaredMethod("dispatchFinishTemporaryDetach", (Class[]) null);
        } catch (NoSuchMethodException e10) {
            Log.e(TAG, "Couldn't find method", e10);
        }
        sTempDetachBound = true;
    }

    @Deprecated
    public static boolean canScrollHorizontally(View view, int i10) {
        return view.canScrollHorizontally(i10);
    }

    @Deprecated
    public static boolean canScrollVertically(View view, int i10) {
        return view.canScrollVertically(i10);
    }

    public static void cancelDragAndDrop(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            j.a(view);
        }
    }

    @Deprecated
    public static int combineMeasuredStates(int i10, int i11) {
        return View.combineMeasuredStates(i10, i11);
    }

    private static void compatOffsetLeftAndRight(View view, int i10) {
        view.offsetLeftAndRight(i10);
        if (view.getVisibility() == 0) {
            tickleInvalidationFlag(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    private static void compatOffsetTopAndBottom(View view, int i10) {
        view.offsetTopAndBottom(i10);
        if (view.getVisibility() == 0) {
            tickleInvalidationFlag(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    @NonNull
    public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
        return h.b(view, windowInsetsCompat, rect);
    }

    @NonNull
    public static WindowInsetsCompat dispatchApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets a10 = g.a(view, windowInsets);
            if (!a10.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(a10, view);
            }
        }
        return windowInsetsCompat;
    }

    public static void dispatchFinishTemporaryDetach(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            j.b(view);
            return;
        }
        if (!sTempDetachBound) {
            bindTempDetach();
        }
        Method method = sDispatchFinishTemporaryDetach;
        if (method != null) {
            try {
                method.invoke(view, (Object[]) null);
            } catch (Exception e10) {
                Log.d(TAG, "Error calling dispatchFinishTemporaryDetach", e10);
            }
        } else {
            view.onFinishTemporaryDetach();
        }
    }

    public static boolean dispatchNestedFling(@NonNull View view, float f10, float f11, boolean z10) {
        return h.c(view, f10, f11, z10);
    }

    public static boolean dispatchNestedPreFling(@NonNull View view, float f10, float f11) {
        return h.d(view, f10, f11);
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view, int i10, int i11, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return h.e(view, i10, i11, iArr, iArr2);
    }

    public static boolean dispatchNestedScroll(@NonNull View view, int i10, int i11, int i12, int i13, @Nullable int[] iArr) {
        return h.f(view, i10, i11, i12, i13, iArr);
    }

    public static void dispatchStartTemporaryDetach(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            j.c(view);
            return;
        }
        if (!sTempDetachBound) {
            bindTempDetach();
        }
        Method method = sDispatchStartTemporaryDetach;
        if (method != null) {
            try {
                method.invoke(view, (Object[]) null);
            } catch (Exception e10) {
                Log.d(TAG, "Error calling dispatchStartTemporaryDetach", e10);
            }
        } else {
            view.onStartTemporaryDetach();
        }
    }

    @UiThread
    static boolean dispatchUnhandledKeyEventBeforeCallback(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return q.a(view).b(view, keyEvent);
    }

    @UiThread
    static boolean dispatchUnhandledKeyEventBeforeHierarchy(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return q.a(view).f(keyEvent);
    }

    public static void enableAccessibleClickableSpanSupport(@NonNull View view) {
        ensureAccessibilityDelegateCompat(view);
    }

    static void ensureAccessibilityDelegateCompat(@NonNull View view) {
        AccessibilityDelegateCompat accessibilityDelegate = getAccessibilityDelegate(view);
        if (accessibilityDelegate == null) {
            accessibilityDelegate = new AccessibilityDelegateCompat();
        }
        setAccessibilityDelegate(view, accessibilityDelegate);
    }

    @Deprecated
    public static int generateViewId() {
        return View.generateViewId();
    }

    @Nullable
    public static AccessibilityDelegateCompat getAccessibilityDelegate(@NonNull View view) {
        View.AccessibilityDelegate accessibilityDelegateInternal = getAccessibilityDelegateInternal(view);
        if (accessibilityDelegateInternal == null) {
            return null;
        }
        if (accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.a) {
            return ((AccessibilityDelegateCompat.a) accessibilityDelegateInternal).f15142a;
        }
        return new AccessibilityDelegateCompat(accessibilityDelegateInternal);
    }

    @Nullable
    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return m.a(view);
        }
        return getAccessibilityDelegateThroughReflection(view);
    }

    @Nullable
    private static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(@NonNull View view) {
        if (sAccessibilityDelegateCheckFailed) {
            return null;
        }
        if (sAccessibilityDelegateField == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                sAccessibilityDelegateField = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                sAccessibilityDelegateCheckFailed = true;
                return null;
            }
        }
        try {
            Object obj = sAccessibilityDelegateField.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            sAccessibilityDelegateCheckFailed = true;
            return null;
        }
    }

    @Deprecated
    public static int getAccessibilityLiveRegion(@NonNull View view) {
        return view.getAccessibilityLiveRegion();
    }

    @Nullable
    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = view.getAccessibilityNodeProvider();
        if (accessibilityNodeProvider != null) {
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }

    @UiThread
    @Nullable
    public static CharSequence getAccessibilityPaneTitle(@NonNull View view) {
        return (CharSequence) paneTitleProperty().e(view);
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    @Deprecated
    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    @Nullable
    public static AutofillIdCompat getAutofillId(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return AutofillIdCompat.toAutofillIdCompat(k.b(view));
        }
        return null;
    }

    private static int getAvailableActionIdFromResources(View view, @NonNull CharSequence charSequence) {
        boolean z10;
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
        for (int i10 = 0; i10 < actionList.size(); i10++) {
            if (TextUtils.equals(charSequence, actionList.get(i10).getLabel())) {
                return actionList.get(i10).getId();
            }
        }
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[] iArr = ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
            if (i12 >= iArr.length || i11 != -1) {
                return i11;
            }
            int i13 = iArr[i12];
            boolean z11 = true;
            for (int i14 = 0; i14 < actionList.size(); i14++) {
                if (actionList.get(i14).getId() != i13) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 &= z10;
            }
            if (z11) {
                i11 = i13;
            }
            i12++;
        }
        return i11;
    }

    @Nullable
    public static ColorStateList getBackgroundTintList(@NonNull View view) {
        return h.g(view);
    }

    @Nullable
    public static PorterDuff.Mode getBackgroundTintMode(@NonNull View view) {
        return h.h(view);
    }

    @Deprecated
    @Nullable
    public static Rect getClipBounds(@NonNull View view) {
        return view.getClipBounds();
    }

    @Nullable
    public static ContentCaptureSessionCompat getContentCaptureSession(@NonNull View view) {
        ContentCaptureSession b10;
        if (Build.VERSION.SDK_INT < 29 || (b10 = m.b(view)) == null) {
            return null;
        }
        return ContentCaptureSessionCompat.toContentCaptureSessionCompat(b10, view);
    }

    @Deprecated
    @Nullable
    public static Display getDisplay(@NonNull View view) {
        return view.getDisplay();
    }

    public static float getElevation(@NonNull View view) {
        return h.i(view);
    }

    private static Rect getEmptyTempRect() {
        if (sThreadLocalRect == null) {
            sThreadLocalRect = new ThreadLocal<>();
        }
        Rect rect = sThreadLocalRect.get();
        if (rect == null) {
            rect = new Rect();
            sThreadLocalRect.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    private static OnReceiveContentViewBehavior getFallback(@NonNull View view) {
        if (view instanceof OnReceiveContentViewBehavior) {
            return (OnReceiveContentViewBehavior) view;
        }
        return NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    @Deprecated
    public static boolean getFitsSystemWindows(@NonNull View view) {
        return view.getFitsSystemWindows();
    }

    @Deprecated
    public static int getImportantForAccessibility(@NonNull View view) {
        return view.getImportantForAccessibility();
    }

    @SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return k.c(view);
        }
        return 0;
    }

    public static int getImportantForContentCapture(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return n.a(view);
        }
        return 0;
    }

    @Deprecated
    public static int getLabelFor(@NonNull View view) {
        return view.getLabelFor();
    }

    @Deprecated
    public static int getLayerType(View view) {
        return view.getLayerType();
    }

    @Deprecated
    public static int getLayoutDirection(@NonNull View view) {
        return view.getLayoutDirection();
    }

    @Deprecated
    @Nullable
    public static Matrix getMatrix(View view) {
        return view.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    @Deprecated
    public static int getMinimumHeight(@NonNull View view) {
        return view.getMinimumHeight();
    }

    @Deprecated
    public static int getMinimumWidth(@NonNull View view) {
        return view.getMinimumWidth();
    }

    public static int getNextClusterForwardId(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return k.d(view);
        }
        return -1;
    }

    @Nullable
    public static String[] getOnReceiveContentMimeTypes(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return o.a(view);
        }
        return (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    @Deprecated
    public static int getOverScrollMode(View view) {
        return view.getOverScrollMode();
    }

    @Px
    @Deprecated
    public static int getPaddingEnd(@NonNull View view) {
        return view.getPaddingEnd();
    }

    @Px
    @Deprecated
    public static int getPaddingStart(@NonNull View view) {
        return view.getPaddingStart();
    }

    @Deprecated
    @Nullable
    public static ViewParent getParentForAccessibility(@NonNull View view) {
        return view.getParentForAccessibility();
    }

    @Deprecated
    public static float getPivotX(View view) {
        return view.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View view) {
        return view.getPivotY();
    }

    @Nullable
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
        return i.a(view);
    }

    @Deprecated
    public static float getRotation(View view) {
        return view.getRotation();
    }

    @Deprecated
    public static float getRotationX(View view) {
        return view.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View view) {
        return view.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View view) {
        return view.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View view) {
        return view.getScaleY();
    }

    public static int getScrollIndicators(@NonNull View view) {
        return i.b(view);
    }

    @UiThread
    @Nullable
    public static CharSequence getStateDescription(@NonNull View view) {
        return (CharSequence) stateDescriptionProperty().e(view);
    }

    @NonNull
    public static List<Rect> getSystemGestureExclusionRects(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return m.c(view);
        }
        return Collections.emptyList();
    }

    @Nullable
    public static String getTransitionName(@NonNull View view) {
        return h.k(view);
    }

    @Deprecated
    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    public static float getTranslationZ(@NonNull View view) {
        return h.l(view);
    }

    @Deprecated
    @Nullable
    public static WindowInsetsControllerCompat getWindowInsetsController(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return n.c(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return WindowCompat.getInsetsController(window, view);
                }
                return null;
            }
        }
        return null;
    }

    @Deprecated
    public static int getWindowSystemUiVisibility(@NonNull View view) {
        return view.getWindowSystemUiVisibility();
    }

    @Deprecated
    public static float getX(View view) {
        return view.getX();
    }

    @Deprecated
    public static float getY(View view) {
        return view.getY();
    }

    public static float getZ(@NonNull View view) {
        return h.m(view);
    }

    public static boolean hasAccessibilityDelegate(@NonNull View view) {
        if (getAccessibilityDelegateInternal(view) != null) {
            return true;
        }
        return false;
    }

    public static boolean hasExplicitFocusable(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return k.e(view);
        }
        return view.hasFocusable();
    }

    public static boolean hasNestedScrollingParent(@NonNull View view) {
        return h.n(view);
    }

    @Deprecated
    public static boolean hasOnClickListeners(@NonNull View view) {
        return view.hasOnClickListeners();
    }

    @Deprecated
    public static boolean hasOverlappingRendering(@NonNull View view) {
        return view.hasOverlappingRendering();
    }

    @Deprecated
    public static boolean hasTransientState(@NonNull View view) {
        return view.hasTransientState();
    }

    @UiThread
    public static boolean isAccessibilityHeading(@NonNull View view) {
        Boolean bool = (Boolean) accessibilityHeadingProperty().e(view);
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static boolean isAttachedToWindow(@NonNull View view) {
        return view.isAttachedToWindow();
    }

    public static boolean isFocusedByDefault(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return k.f(view);
        }
        return false;
    }

    public static boolean isImportantForAccessibility(@NonNull View view) {
        return h.o(view);
    }

    public static boolean isImportantForAutofill(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return k.g(view);
        }
        return true;
    }

    public static boolean isImportantForContentCapture(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return n.d(view);
        }
        return false;
    }

    @Deprecated
    public static boolean isInLayout(@NonNull View view) {
        return view.isInLayout();
    }

    public static boolean isKeyboardNavigationCluster(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return k.h(view);
        }
        return false;
    }

    @Deprecated
    public static boolean isLaidOut(@NonNull View view) {
        return view.isLaidOut();
    }

    @Deprecated
    public static boolean isLayoutDirectionResolved(@NonNull View view) {
        return view.isLayoutDirectionResolved();
    }

    public static boolean isNestedScrollingEnabled(@NonNull View view) {
        return h.p(view);
    }

    @Deprecated
    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    @Deprecated
    public static boolean isPaddingRelative(@NonNull View view) {
        return view.isPaddingRelative();
    }

    @UiThread
    public static boolean isScreenReaderFocusable(@NonNull View view) {
        Boolean bool = (Boolean) screenReaderFocusableProperty().e(view);
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }

    @Nullable
    public static View keyboardNavigationClusterSearch(@NonNull View view, @Nullable View view2, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            return k.i(view, view2, i10);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ContentInfoCompat lambda$static$0(ContentInfoCompat contentInfoCompat) {
        return contentInfoCompat;
    }

    static void notifyViewAccessibilityStateChangedIfNeeded(View view, int i10) {
        boolean z10;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            if (getAccessibilityPaneTitle(view) == null || !view.isShown() || view.getWindowVisibility() != 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            int i11 = 32;
            if (view.getAccessibilityLiveRegion() != 0 || z10) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z10) {
                    i11 = 2048;
                }
                obtain.setEventType(i11);
                obtain.setContentChangeTypes(i10);
                if (z10) {
                    obtain.getText().add(getAccessibilityPaneTitle(view));
                    setImportantForAccessibilityIfNeeded(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i10 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i10);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(getAccessibilityPaneTitle(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i10);
                } catch (AbstractMethodError e10) {
                    Log.e(TAG, view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e10);
                }
            }
        }
    }

    public static void offsetLeftAndRight(@NonNull View view, int i10) {
        view.offsetLeftAndRight(i10);
    }

    public static void offsetTopAndBottom(@NonNull View view, int i10) {
        view.offsetTopAndBottom(i10);
    }

    @NonNull
    public static WindowInsetsCompat onApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets b10 = g.b(view, windowInsets);
            if (!b10.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(b10, view);
            }
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Deprecated
    public static void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    private static f paneTitleProperty() {
        return new b(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    @Deprecated
    public static boolean performAccessibilityAction(@NonNull View view, int i10, @Nullable Bundle bundle) {
        return view.performAccessibilityAction(i10, bundle);
    }

    public static boolean performHapticFeedback(@NonNull View view, int i10) {
        int feedbackConstantOrFallback = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(i10);
        if (feedbackConstantOrFallback == -1) {
            return false;
        }
        return view.performHapticFeedback(feedbackConstantOrFallback);
    }

    @Nullable
    public static ContentInfoCompat performReceiveContent(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "performReceiveContent: " + contentInfoCompat + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return o.b(view, contentInfoCompat);
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view.getTag(R.id.tag_on_receive_content_listener);
        if (onReceiveContentListener == null) {
            return getFallback(view).onReceiveContent(contentInfoCompat);
        }
        ContentInfoCompat onReceiveContent = onReceiveContentListener.onReceiveContent(view, contentInfoCompat);
        if (onReceiveContent == null) {
            return null;
        }
        return getFallback(view).onReceiveContent(onReceiveContent);
    }

    @Deprecated
    public static void postInvalidateOnAnimation(@NonNull View view) {
        view.postInvalidateOnAnimation();
    }

    @Deprecated
    public static void postOnAnimation(@NonNull View view, @NonNull Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    @SuppressLint({"LambdaLast"})
    @Deprecated
    public static void postOnAnimationDelayed(@NonNull View view, @NonNull Runnable runnable, long j10) {
        view.postOnAnimationDelayed(runnable, j10);
    }

    public static void removeAccessibilityAction(@NonNull View view, int i10) {
        removeActionWithId(i10, view);
        notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    private static void removeActionWithId(int i10, View view) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
        for (int i11 = 0; i11 < actionList.size(); i11++) {
            if (actionList.get(i11).getId() == i10) {
                actionList.remove(i11);
                return;
            }
        }
    }

    public static void removeOnUnhandledKeyEventListener(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            l.e(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList != null) {
            arrayList.remove(onUnhandledKeyEventListenerCompat);
            if (arrayList.size() == 0) {
                q.i(view);
            }
        }
    }

    public static void replaceAccessibilityAction(@NonNull View view, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, @Nullable CharSequence charSequence, @Nullable AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            removeAccessibilityAction(view, accessibilityActionCompat.getId());
        } else {
            addAccessibilityAction(view, accessibilityActionCompat.createReplacementAction(charSequence, accessibilityViewCommand));
        }
    }

    public static void requestApplyInsets(@NonNull View view) {
        g.c(view);
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull View view, @IdRes int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (View) l.f(view, i10);
        }
        T findViewById = view.findViewById(i10);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    @Deprecated
    public static int resolveSizeAndState(int i10, int i11, int i12) {
        return View.resolveSizeAndState(i10, i11, i12);
    }

    public static boolean restoreDefaultFocus(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return k.j(view);
        }
        return view.requestFocus();
    }

    public static void saveAttributeDataForStyleable(@NonNull View view, @SuppressLint({"ContextFirst"}) @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            m.d(view, context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    private static f screenReaderFocusableProperty() {
        return new a(R.id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static void setAccessibilityDelegate(@NonNull View view, @Nullable AccessibilityDelegateCompat accessibilityDelegateCompat) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (accessibilityDelegateCompat == null && (getAccessibilityDelegateInternal(view) instanceof AccessibilityDelegateCompat.a)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        setImportantForAccessibilityIfNeeded(view);
        if (accessibilityDelegateCompat == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = accessibilityDelegateCompat.getBridge();
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    @UiThread
    public static void setAccessibilityHeading(@NonNull View view, boolean z10) {
        accessibilityHeadingProperty().f(view, Boolean.valueOf(z10));
    }

    @Deprecated
    public static void setAccessibilityLiveRegion(@NonNull View view, int i10) {
        view.setAccessibilityLiveRegion(i10);
    }

    @UiThread
    public static void setAccessibilityPaneTitle(@NonNull View view, @Nullable CharSequence charSequence) {
        paneTitleProperty().f(view, charSequence);
        if (charSequence != null) {
            sAccessibilityPaneVisibilityManager.a(view);
        } else {
            sAccessibilityPaneVisibilityManager.d(view);
        }
    }

    @Deprecated
    public static void setActivated(View view, boolean z10) {
        view.setActivated(z10);
    }

    @Deprecated
    public static void setAlpha(View view, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        view.setAlpha(f10);
    }

    public static void setAutofillHints(@NonNull View view, @Nullable String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            k.k(view, strArr);
        }
    }

    public static void setAutofillId(@NonNull View view, @Nullable AutofillIdCompat autofillIdCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            l.i(view, autofillIdCompat);
        }
    }

    @Deprecated
    public static void setBackground(@NonNull View view, @Nullable Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void setBackgroundTintList(@NonNull View view, @Nullable ColorStateList colorStateList) {
        h.q(view, colorStateList);
    }

    public static void setBackgroundTintMode(@NonNull View view, @Nullable PorterDuff.Mode mode) {
        h.r(view, mode);
    }

    @SuppressLint({"BanUncheckedReflection"})
    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z10) {
        if (sChildrenDrawingOrderMethod == null) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                sChildrenDrawingOrderMethod = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException e10) {
                Log.e(TAG, "Unable to find childrenDrawingOrderEnabled", e10);
            }
            sChildrenDrawingOrderMethod.setAccessible(true);
        }
        try {
            sChildrenDrawingOrderMethod.invoke(viewGroup, new Object[]{Boolean.valueOf(z10)});
        } catch (IllegalAccessException e11) {
            Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e11);
        } catch (IllegalArgumentException e12) {
            Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e12);
        } catch (InvocationTargetException e13) {
            Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e13);
        }
    }

    @Deprecated
    public static void setClipBounds(@NonNull View view, @Nullable Rect rect) {
        view.setClipBounds(rect);
    }

    public static void setContentCaptureSession(@NonNull View view, @Nullable ContentCaptureSessionCompat contentCaptureSessionCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            m.e(view, contentCaptureSessionCompat);
        }
    }

    public static void setElevation(@NonNull View view, float f10) {
        h.s(view, f10);
    }

    @Deprecated
    public static void setFitsSystemWindows(View view, boolean z10) {
        view.setFitsSystemWindows(z10);
    }

    public static void setFocusedByDefault(@NonNull View view, boolean z10) {
        if (Build.VERSION.SDK_INT >= 26) {
            k.l(view, z10);
        }
    }

    @Deprecated
    public static void setHasTransientState(@NonNull View view, boolean z10) {
        view.setHasTransientState(z10);
    }

    @UiThread
    @Deprecated
    public static void setImportantForAccessibility(@NonNull View view, int i10) {
        view.setImportantForAccessibility(i10);
    }

    private static void setImportantForAccessibilityIfNeeded(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static void setImportantForAutofill(@NonNull View view, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            k.m(view, i10);
        }
    }

    public static void setImportantForContentCapture(@NonNull View view, int i10) {
        if (Build.VERSION.SDK_INT >= 30) {
            n.e(view, i10);
        }
    }

    public static void setKeyboardNavigationCluster(@NonNull View view, boolean z10) {
        if (Build.VERSION.SDK_INT >= 26) {
            k.n(view, z10);
        }
    }

    @Deprecated
    public static void setLabelFor(@NonNull View view, @IdRes int i10) {
        view.setLabelFor(i10);
    }

    @Deprecated
    public static void setLayerPaint(@NonNull View view, @Nullable Paint paint) {
        view.setLayerPaint(paint);
    }

    @Deprecated
    public static void setLayerType(View view, int i10, Paint paint) {
        view.setLayerType(i10, paint);
    }

    @Deprecated
    public static void setLayoutDirection(@NonNull View view, int i10) {
        view.setLayoutDirection(i10);
    }

    public static void setNestedScrollingEnabled(@NonNull View view, boolean z10) {
        h.t(view, z10);
    }

    public static void setNextClusterForwardId(@NonNull View view, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            k.o(view, i10);
        }
    }

    public static void setOnApplyWindowInsetsListener(@NonNull View view, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        h.u(view, onApplyWindowInsetsListener);
    }

    public static void setOnReceiveContentListener(@NonNull View view, @Nullable String[] strArr, @Nullable OnReceiveContentListener onReceiveContentListener) {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 31) {
            o.c(view, strArr, onReceiveContentListener);
            return;
        }
        if (strArr == null || strArr.length == 0) {
            strArr = null;
        }
        boolean z11 = false;
        if (onReceiveContentListener != null) {
            if (strArr != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "When the listener is set, MIME types must also be set");
        }
        if (strArr != null) {
            int length = strArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                } else if (strArr[i10].startsWith(ProxyConfig.MATCH_ALL_SCHEMES)) {
                    z11 = true;
                    break;
                } else {
                    i10++;
                }
            }
            Preconditions.checkArgument(!z11, "A MIME type set here must not start with *: " + Arrays.toString(strArr));
        }
        view.setTag(R.id.tag_on_receive_content_mime_types, strArr);
        view.setTag(R.id.tag_on_receive_content_listener, onReceiveContentListener);
    }

    @Deprecated
    public static void setOverScrollMode(View view, int i10) {
        view.setOverScrollMode(i10);
    }

    @Deprecated
    public static void setPaddingRelative(@NonNull View view, @Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        view.setPaddingRelative(i10, i11, i12, i13);
    }

    @Deprecated
    public static void setPivotX(View view, float f10) {
        view.setPivotX(f10);
    }

    @Deprecated
    public static void setPivotY(View view, float f10) {
        view.setPivotY(f10);
    }

    public static void setPointerIcon(@NonNull View view, @Nullable PointerIconCompat pointerIconCompat) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 24) {
            if (pointerIconCompat != null) {
                obj = pointerIconCompat.getPointerIcon();
            } else {
                obj = null;
            }
            j.d(view, h0.a(obj));
        }
    }

    @Deprecated
    public static void setRotation(View view, float f10) {
        view.setRotation(f10);
    }

    @Deprecated
    public static void setRotationX(View view, float f10) {
        view.setRotationX(f10);
    }

    @Deprecated
    public static void setRotationY(View view, float f10) {
        view.setRotationY(f10);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View view, boolean z10) {
        view.setSaveFromParentEnabled(z10);
    }

    @Deprecated
    public static void setScaleX(View view, float f10) {
        view.setScaleX(f10);
    }

    @Deprecated
    public static void setScaleY(View view, float f10) {
        view.setScaleY(f10);
    }

    @UiThread
    public static void setScreenReaderFocusable(@NonNull View view, boolean z10) {
        screenReaderFocusableProperty().f(view, Boolean.valueOf(z10));
    }

    public static void setScrollIndicators(@NonNull View view, int i10) {
        i.c(view, i10);
    }

    @UiThread
    public static void setStateDescription(@NonNull View view, @Nullable CharSequence charSequence) {
        stateDescriptionProperty().f(view, charSequence);
    }

    public static void setSystemGestureExclusionRects(@NonNull View view, @NonNull List<Rect> list) {
        if (Build.VERSION.SDK_INT >= 29) {
            m.f(view, list);
        }
    }

    public static void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            k.p(view, charSequence);
        }
    }

    public static void setTransitionName(@NonNull View view, @Nullable String str) {
        h.v(view, str);
    }

    @Deprecated
    public static void setTranslationX(View view, float f10) {
        view.setTranslationX(f10);
    }

    @Deprecated
    public static void setTranslationY(View view, float f10) {
        view.setTranslationY(f10);
    }

    public static void setTranslationZ(@NonNull View view, float f10) {
        h.w(view, f10);
    }

    public static void setWindowInsetsAnimationCallback(@NonNull View view, @Nullable WindowInsetsAnimationCompat.Callback callback) {
        WindowInsetsAnimationCompat.setCallback(view, callback);
    }

    @Deprecated
    public static void setX(View view, float f10) {
        view.setX(f10);
    }

    @Deprecated
    public static void setY(View view, float f10) {
        view.setY(f10);
    }

    public static void setZ(@NonNull View view, float f10) {
        h.x(view, f10);
    }

    public static boolean startDragAndDrop(@NonNull View view, @Nullable ClipData clipData, @NonNull View.DragShadowBuilder dragShadowBuilder, @Nullable Object obj, int i10) {
        if (Build.VERSION.SDK_INT >= 24) {
            return j.e(view, clipData, dragShadowBuilder, obj, i10);
        }
        return view.startDrag(clipData, dragShadowBuilder, obj, i10);
    }

    public static boolean startNestedScroll(@NonNull View view, int i10) {
        return h.y(view, i10);
    }

    private static f stateDescriptionProperty() {
        return new c(R.id.tag_state_description, CharSequence.class, 64, 30);
    }

    public static void stopNestedScroll(@NonNull View view) {
        h.z(view);
    }

    private static void tickleInvalidationFlag(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void updateDragShadow(@NonNull View view, @NonNull View.DragShadowBuilder dragShadowBuilder) {
        if (Build.VERSION.SDK_INT >= 24) {
            j.f(view, dragShadowBuilder);
        }
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view, int i10, int i11, @Nullable int[] iArr, @Nullable int[] iArr2, int i12) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedPreScroll(i10, i11, iArr, iArr2, i12);
        }
        if (i12 == 0) {
            return dispatchNestedPreScroll(view, i10, i11, iArr, iArr2);
        }
        return false;
    }

    public static void dispatchNestedScroll(@NonNull View view, int i10, int i11, int i12, int i13, @Nullable int[] iArr, int i14, @NonNull int[] iArr2) {
        View view2 = view;
        if (view2 instanceof NestedScrollingChild3) {
            ((NestedScrollingChild3) view2).dispatchNestedScroll(i10, i11, i12, i13, iArr, i14, iArr2);
        } else {
            dispatchNestedScroll(view, i10, i11, i12, i13, iArr, i14);
        }
    }

    public static boolean hasNestedScrollingParent(@NonNull View view, int i10) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).hasNestedScrollingParent(i10);
            return false;
        } else if (i10 == 0) {
            return hasNestedScrollingParent(view);
        } else {
            return false;
        }
    }

    @Deprecated
    public static void postInvalidateOnAnimation(@NonNull View view, int i10, int i11, int i12, int i13) {
        view.postInvalidateOnAnimation(i10, i11, i12, i13);
    }

    public static void setScrollIndicators(@NonNull View view, int i10, int i11) {
        i.d(view, i10, i11);
    }

    public static boolean startNestedScroll(@NonNull View view, int i10, int i11) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).startNestedScroll(i10, i11);
        }
        if (i11 == 0) {
            return startNestedScroll(view, i10);
        }
        return false;
    }

    public static void stopNestedScroll(@NonNull View view, int i10) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).stopNestedScroll(i10);
        } else if (i10 == 0) {
            stopNestedScroll(view);
        }
    }

    public static boolean performHapticFeedback(@NonNull View view, int i10, int i11) {
        int feedbackConstantOrFallback = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(i10);
        if (feedbackConstantOrFallback == -1) {
            return false;
        }
        return view.performHapticFeedback(feedbackConstantOrFallback, i11);
    }

    private static void addAccessibilityAction(@NonNull View view, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        ensureAccessibilityDelegateCompat(view);
        removeActionWithId(accessibilityActionCompat.getId(), view);
        getActionList(view).add(accessibilityActionCompat);
        notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    public static boolean dispatchNestedScroll(@NonNull View view, int i10, int i11, int i12, int i13, @Nullable int[] iArr, int i14) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedScroll(i10, i11, i12, i13, iArr, i14);
        }
        if (i14 == 0) {
            return dispatchNestedScroll(view, i10, i11, i12, i13, iArr);
        }
        return false;
    }
}
