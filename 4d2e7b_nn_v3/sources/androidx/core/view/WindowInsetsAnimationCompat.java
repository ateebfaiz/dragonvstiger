package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public final class WindowInsetsAnimationCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "WindowInsetsAnimCompat";
    private c mImpl;

    public static abstract class Callback {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;
        WindowInsets mDispachedInsets;
        private final int mDispatchMode;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface DispatchMode {
        }

        public Callback(int i10) {
            this.mDispatchMode = i10;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public void onEnd(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public void onPrepare(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        @NonNull
        public abstract WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list);

        @NonNull
        public BoundsCompat onStart(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat, @NonNull BoundsCompat boundsCompat) {
            return boundsCompat;
        }
    }

    private static class a extends c {

        /* renamed from: f  reason: collision with root package name */
        private static final Interpolator f15180f = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

        /* renamed from: g  reason: collision with root package name */
        private static final Interpolator f15181g = new FastOutLinearInInterpolator();

        /* renamed from: h  reason: collision with root package name */
        private static final Interpolator f15182h = new DecelerateInterpolator();

        /* renamed from: androidx.core.view.WindowInsetsAnimationCompat$a$a  reason: collision with other inner class name */
        private static class C0192a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a  reason: collision with root package name */
            final Callback f15183a;

            /* renamed from: b  reason: collision with root package name */
            private WindowInsetsCompat f15184b;

            /* renamed from: androidx.core.view.WindowInsetsAnimationCompat$a$a$a  reason: collision with other inner class name */
            class C0193a implements ValueAnimator.AnimatorUpdateListener {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ WindowInsetsAnimationCompat f15185a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ WindowInsetsCompat f15186b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ WindowInsetsCompat f15187c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ int f15188d;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ View f15189e;

                C0193a(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int i10, View view) {
                    this.f15185a = windowInsetsAnimationCompat;
                    this.f15186b = windowInsetsCompat;
                    this.f15187c = windowInsetsCompat2;
                    this.f15188d = i10;
                    this.f15189e = view;
                }

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f15185a.setFraction(valueAnimator.getAnimatedFraction());
                    a.o(this.f15189e, a.s(this.f15186b, this.f15187c, this.f15185a.getInterpolatedFraction(), this.f15188d), Collections.singletonList(this.f15185a));
                }
            }

            /* renamed from: androidx.core.view.WindowInsetsAnimationCompat$a$a$b */
            class b extends AnimatorListenerAdapter {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ WindowInsetsAnimationCompat f15191a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ View f15192b;

                b(WindowInsetsAnimationCompat windowInsetsAnimationCompat, View view) {
                    this.f15191a = windowInsetsAnimationCompat;
                    this.f15192b = view;
                }

                public void onAnimationEnd(Animator animator) {
                    this.f15191a.setFraction(1.0f);
                    a.m(this.f15192b, this.f15191a);
                }
            }

            /* renamed from: androidx.core.view.WindowInsetsAnimationCompat$a$a$c */
            class c implements Runnable {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ View f15194a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ WindowInsetsAnimationCompat f15195b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ BoundsCompat f15196c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ ValueAnimator f15197d;

                c(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat, ValueAnimator valueAnimator) {
                    this.f15194a = view;
                    this.f15195b = windowInsetsAnimationCompat;
                    this.f15196c = boundsCompat;
                    this.f15197d = valueAnimator;
                }

                public void run() {
                    a.p(this.f15194a, this.f15195b, this.f15196c);
                    this.f15197d.start();
                }
            }

            C0192a(View view, Callback callback) {
                WindowInsetsCompat windowInsetsCompat;
                this.f15183a = callback;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
                if (rootWindowInsets != null) {
                    windowInsetsCompat = new WindowInsetsCompat.Builder(rootWindowInsets).build();
                } else {
                    windowInsetsCompat = null;
                }
                this.f15184b = windowInsetsCompat;
            }

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                View view2 = view;
                WindowInsets windowInsets2 = windowInsets;
                if (!view.isLaidOut()) {
                    this.f15184b = WindowInsetsCompat.toWindowInsetsCompat(windowInsets2, view2);
                    return a.q(view, windowInsets);
                }
                WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets2, view2);
                if (this.f15184b == null) {
                    this.f15184b = ViewCompat.getRootWindowInsets(view);
                }
                if (this.f15184b == null) {
                    this.f15184b = windowInsetsCompat;
                    return a.q(view, windowInsets);
                }
                Callback r10 = a.r(view);
                if (r10 != null && Objects.equals(r10.mDispachedInsets, windowInsets2)) {
                    return a.q(view, windowInsets);
                }
                int i10 = a.i(windowInsetsCompat, this.f15184b);
                if (i10 == 0) {
                    return a.q(view, windowInsets);
                }
                WindowInsetsCompat windowInsetsCompat2 = this.f15184b;
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(i10, a.k(i10, windowInsetsCompat, windowInsetsCompat2), 160);
                windowInsetsAnimationCompat.setFraction(0.0f);
                ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(windowInsetsAnimationCompat.getDurationMillis());
                BoundsCompat j10 = a.j(windowInsetsCompat, windowInsetsCompat2, i10);
                a.n(view2, windowInsetsAnimationCompat, windowInsets2, false);
                duration.addUpdateListener(new C0193a(windowInsetsAnimationCompat, windowInsetsCompat, windowInsetsCompat2, i10, view));
                duration.addListener(new b(windowInsetsAnimationCompat, view2));
                OneShotPreDrawListener.add(view2, new c(view, windowInsetsAnimationCompat, j10, duration));
                this.f15184b = windowInsetsCompat;
                return a.q(view, windowInsets);
            }
        }

        a(int i10, Interpolator interpolator, long j10) {
            super(i10, interpolator, j10);
        }

        static int i(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2) {
            int i10 = 0;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if (!windowInsetsCompat.getInsets(i11).equals(windowInsetsCompat2.getInsets(i11))) {
                    i10 |= i11;
                }
            }
            return i10;
        }

        static BoundsCompat j(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int i10) {
            Insets insets = windowInsetsCompat.getInsets(i10);
            Insets insets2 = windowInsetsCompat2.getInsets(i10);
            return new BoundsCompat(Insets.of(Math.min(insets.left, insets2.left), Math.min(insets.top, insets2.top), Math.min(insets.right, insets2.right), Math.min(insets.bottom, insets2.bottom)), Insets.of(Math.max(insets.left, insets2.left), Math.max(insets.top, insets2.top), Math.max(insets.right, insets2.right), Math.max(insets.bottom, insets2.bottom)));
        }

        static Interpolator k(int i10, WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2) {
            if ((i10 & 8) == 0) {
                return f15182h;
            }
            if (windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime()).bottom > windowInsetsCompat2.getInsets(WindowInsetsCompat.Type.ime()).bottom) {
                return f15180f;
            }
            return f15181g;
        }

        private static View.OnApplyWindowInsetsListener l(View view, Callback callback) {
            return new C0192a(view, callback);
        }

        static void m(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            Callback r10 = r(view);
            if (r10 != null) {
                r10.onEnd(windowInsetsAnimationCompat);
                if (r10.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    m(viewGroup.getChildAt(i10), windowInsetsAnimationCompat);
                }
            }
        }

        static void n(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean z10) {
            Callback r10 = r(view);
            if (r10 != null) {
                r10.mDispachedInsets = windowInsets;
                if (!z10) {
                    r10.onPrepare(windowInsetsAnimationCompat);
                    if (r10.getDispatchMode() == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    n(viewGroup.getChildAt(i10), windowInsetsAnimationCompat, windowInsets, z10);
                }
            }
        }

        static void o(View view, WindowInsetsCompat windowInsetsCompat, List list) {
            Callback r10 = r(view);
            if (r10 != null) {
                windowInsetsCompat = r10.onProgress(windowInsetsCompat, list);
                if (r10.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    o(viewGroup.getChildAt(i10), windowInsetsCompat, list);
                }
            }
        }

        static void p(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            Callback r10 = r(view);
            if (r10 != null) {
                r10.onStart(windowInsetsAnimationCompat, boundsCompat);
                if (r10.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    p(viewGroup.getChildAt(i10), windowInsetsAnimationCompat, boundsCompat);
                }
            }
        }

        static WindowInsets q(View view, WindowInsets windowInsets) {
            if (view.getTag(R.id.tag_on_apply_window_listener) != null) {
                return windowInsets;
            }
            return view.onApplyWindowInsets(windowInsets);
        }

        static Callback r(View view) {
            Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
            if (tag instanceof C0192a) {
                return ((C0192a) tag).f15183a;
            }
            return null;
        }

        static WindowInsetsCompat s(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, float f10, int i10) {
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(windowInsetsCompat);
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) == 0) {
                    builder.setInsets(i11, windowInsetsCompat.getInsets(i11));
                } else {
                    Insets insets = windowInsetsCompat.getInsets(i11);
                    Insets insets2 = windowInsetsCompat2.getInsets(i11);
                    float f11 = 1.0f - f10;
                    builder.setInsets(i11, WindowInsetsCompat.insetInsets(insets, (int) (((double) (((float) (insets.left - insets2.left)) * f11)) + 0.5d), (int) (((double) (((float) (insets.top - insets2.top)) * f11)) + 0.5d), (int) (((double) (((float) (insets.right - insets2.right)) * f11)) + 0.5d), (int) (((double) (((float) (insets.bottom - insets2.bottom)) * f11)) + 0.5d)));
                }
            }
            return builder.build();
        }

        static void t(View view, Callback callback) {
            Object tag = view.getTag(R.id.tag_on_apply_window_listener);
            if (callback == null) {
                view.setTag(R.id.tag_window_insets_animation_callback, (Object) null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener l10 = l(view, callback);
            view.setTag(R.id.tag_window_insets_animation_callback, l10);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(l10);
            }
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private final int f15204a;

        /* renamed from: b  reason: collision with root package name */
        private float f15205b;

        /* renamed from: c  reason: collision with root package name */
        private final Interpolator f15206c;

        /* renamed from: d  reason: collision with root package name */
        private final long f15207d;

        /* renamed from: e  reason: collision with root package name */
        private float f15208e;

        c(int i10, Interpolator interpolator, long j10) {
            this.f15204a = i10;
            this.f15206c = interpolator;
            this.f15207d = j10;
        }

        public float a() {
            return this.f15208e;
        }

        public long b() {
            return this.f15207d;
        }

        public float c() {
            return this.f15205b;
        }

        public float d() {
            Interpolator interpolator = this.f15206c;
            if (interpolator != null) {
                return interpolator.getInterpolation(this.f15205b);
            }
            return this.f15205b;
        }

        public Interpolator e() {
            return this.f15206c;
        }

        public int f() {
            return this.f15204a;
        }

        public void g(float f10) {
            this.f15208e = f10;
        }

        public void h(float f10) {
            this.f15205b = f10;
        }
    }

    public WindowInsetsAnimationCompat(int i10, @Nullable Interpolator interpolator, long j10) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new b(i10, interpolator, j10);
        } else {
            this.mImpl = new a(i10, interpolator, j10);
        }
    }

    static void setCallback(@NonNull View view, @Nullable Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.l(view, callback);
        } else {
            a.t(view, callback);
        }
    }

    @RequiresApi(30)
    static WindowInsetsAnimationCompat toWindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        return new WindowInsetsAnimationCompat(windowInsetsAnimation);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAlpha() {
        return this.mImpl.a();
    }

    public long getDurationMillis() {
        return this.mImpl.b();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getFraction() {
        return this.mImpl.c();
    }

    public float getInterpolatedFraction() {
        return this.mImpl.d();
    }

    @Nullable
    public Interpolator getInterpolator() {
        return this.mImpl.e();
    }

    public int getTypeMask() {
        return this.mImpl.f();
    }

    public void setAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.mImpl.g(f10);
    }

    public void setFraction(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.mImpl.h(f10);
    }

    private static class b extends c {

        /* renamed from: f  reason: collision with root package name */
        private final WindowInsetsAnimation f15199f;

        private static class a extends WindowInsetsAnimation$Callback {

            /* renamed from: a  reason: collision with root package name */
            private final Callback f15200a;

            /* renamed from: b  reason: collision with root package name */
            private List f15201b;

            /* renamed from: c  reason: collision with root package name */
            private ArrayList f15202c;

            /* renamed from: d  reason: collision with root package name */
            private final HashMap f15203d = new HashMap();

            a(Callback callback) {
                super(callback.getDispatchMode());
                this.f15200a = callback;
            }

            private WindowInsetsAnimationCompat a(WindowInsetsAnimation windowInsetsAnimation) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) this.f15203d.get(windowInsetsAnimation);
                if (windowInsetsAnimationCompat != null) {
                    return windowInsetsAnimationCompat;
                }
                WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = WindowInsetsAnimationCompat.toWindowInsetsAnimationCompat(windowInsetsAnimation);
                this.f15203d.put(windowInsetsAnimation, windowInsetsAnimationCompat2);
                return windowInsetsAnimationCompat2;
            }

            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f15200a.onEnd(a(windowInsetsAnimation));
                this.f15203d.remove(windowInsetsAnimation);
            }

            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.f15200a.onPrepare(a(windowInsetsAnimation));
            }

            public WindowInsets onProgress(WindowInsets windowInsets, List list) {
                ArrayList arrayList = this.f15202c;
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList(list.size());
                    this.f15202c = arrayList2;
                    this.f15201b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation a10 = a1.a(list.get(size));
                    WindowInsetsAnimationCompat a11 = a(a10);
                    a11.setFraction(a10.getFraction());
                    this.f15202c.add(a11);
                }
                return this.f15200a.onProgress(WindowInsetsCompat.toWindowInsetsCompat(windowInsets), this.f15201b).toWindowInsets();
            }

            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.f15200a.onStart(a(windowInsetsAnimation), BoundsCompat.toBoundsCompat(bounds)).toBounds();
            }
        }

        b(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, (Interpolator) null, 0);
            this.f15199f = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds i(BoundsCompat boundsCompat) {
            q0.a();
            return p0.a(boundsCompat.getLowerBound().toPlatformInsets(), boundsCompat.getUpperBound().toPlatformInsets());
        }

        public static Insets j(WindowInsetsAnimation.Bounds bounds) {
            return Insets.toCompatInsets(bounds.getUpperBound());
        }

        public static Insets k(WindowInsetsAnimation.Bounds bounds) {
            return Insets.toCompatInsets(bounds.getLowerBound());
        }

        public static void l(View view, Callback callback) {
            a aVar;
            if (callback != null) {
                aVar = new a(callback);
            } else {
                aVar = null;
            }
            view.setWindowInsetsAnimationCallback(aVar);
        }

        public long b() {
            return this.f15199f.getDurationMillis();
        }

        public float c() {
            return this.f15199f.getFraction();
        }

        public float d() {
            return this.f15199f.getInterpolatedFraction();
        }

        public Interpolator e() {
            return this.f15199f.getInterpolator();
        }

        public int f() {
            return this.f15199f.getTypeMask();
        }

        public void h(float f10) {
            this.f15199f.setFraction(f10);
        }

        b(int i10, Interpolator interpolator, long j10) {
            this(z0.a(i10, interpolator, j10));
        }
    }

    public static final class BoundsCompat {
        private final Insets mLowerBound;
        private final Insets mUpperBound;

        public BoundsCompat(@NonNull Insets insets, @NonNull Insets insets2) {
            this.mLowerBound = insets;
            this.mUpperBound = insets2;
        }

        @RequiresApi(30)
        @NonNull
        public static BoundsCompat toBoundsCompat(@NonNull WindowInsetsAnimation.Bounds bounds) {
            return new BoundsCompat(bounds);
        }

        @NonNull
        public Insets getLowerBound() {
            return this.mLowerBound;
        }

        @NonNull
        public Insets getUpperBound() {
            return this.mUpperBound;
        }

        @NonNull
        public BoundsCompat inset(@NonNull Insets insets) {
            return new BoundsCompat(WindowInsetsCompat.insetInsets(this.mLowerBound, insets.left, insets.top, insets.right, insets.bottom), WindowInsetsCompat.insetInsets(this.mUpperBound, insets.left, insets.top, insets.right, insets.bottom));
        }

        @RequiresApi(30)
        @NonNull
        public WindowInsetsAnimation.Bounds toBounds() {
            return b.i(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.mLowerBound + " upper=" + this.mUpperBound + "}";
        }

        @RequiresApi(30)
        private BoundsCompat(@NonNull WindowInsetsAnimation.Bounds bounds) {
            this.mLowerBound = b.k(bounds);
            this.mUpperBound = b.j(bounds);
        }
    }

    @RequiresApi(30)
    private WindowInsetsAnimationCompat(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
        this(0, (Interpolator) null, 0);
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new b(windowInsetsAnimation);
        }
    }
}
