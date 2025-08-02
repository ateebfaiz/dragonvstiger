package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class WindowInsetsCompat {
    @NonNull
    public static final WindowInsetsCompat CONSUMED;
    private static final String TAG = "WindowInsetsCompat";
    private final k mImpl;

    public static final class Type {
        static final int CAPTION_BAR = 4;
        static final int DISPLAY_CUTOUT = 128;
        static final int FIRST = 1;
        static final int IME = 8;
        static final int LAST = 256;
        static final int MANDATORY_SYSTEM_GESTURES = 32;
        static final int NAVIGATION_BARS = 2;
        static final int SIZE = 9;
        static final int STATUS_BARS = 1;
        static final int SYSTEM_GESTURES = 16;
        static final int TAPPABLE_ELEMENT = 64;
        static final int WINDOW_DECOR = 256;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface InsetsType {
        }

        private Type() {
        }

        @SuppressLint({"WrongConstant"})
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        static int all() {
            return -1;
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int ime() {
            return 8;
        }

        static int indexOf(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 == 8) {
                return 3;
            }
            if (i10 == 16) {
                return 4;
            }
            if (i10 == 32) {
                return 5;
            }
            if (i10 == 64) {
                return 6;
            }
            if (i10 == 128) {
                return 7;
            }
            if (i10 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 7;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int tappableElement() {
            return 64;
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Field f15210a;

        /* renamed from: b  reason: collision with root package name */
        private static Field f15211b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f15212c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f15213d = true;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f15210a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f15211b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f15212c = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets from AttachInfo " + e10.getMessage(), e10);
            }
        }

        public static WindowInsetsCompat a(View view) {
            if (f15213d && view.isAttachedToWindow()) {
                try {
                    Object obj = f15210a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f15211b.get(obj);
                        Rect rect2 = (Rect) f15212c.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            WindowInsetsCompat build = new Builder().setStableInsets(Insets.of(rect)).setSystemWindowInsets(Insets.of(rect2)).build();
                            build.setRootWindowInsets(build);
                            build.copyRootViewBounds(view.getRootView());
                            return build;
                        }
                    }
                } catch (IllegalAccessException e10) {
                    Log.w(WindowInsetsCompat.TAG, "Failed to get insets from AttachInfo. " + e10.getMessage(), e10);
                }
            }
            return null;
        }
    }

    private static class d extends c {
        d() {
        }

        /* access modifiers changed from: package-private */
        public void d(int i10, @NonNull Insets insets) {
            WindowInsets.Builder unused = this.f15220c.setInsets(l.a(i10), insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void e(int i10, @NonNull Insets insets) {
            WindowInsets.Builder unused = this.f15220c.setInsetsIgnoringVisibility(l.a(i10), insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void k(int i10, boolean z10) {
            WindowInsets.Builder unused = this.f15220c.setVisible(l.a(i10), z10);
        }

        d(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    private static class e {

        /* renamed from: a  reason: collision with root package name */
        private final WindowInsetsCompat f15221a;

        /* renamed from: b  reason: collision with root package name */
        Insets[] f15222b;

        e() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        /* access modifiers changed from: protected */
        public final void a() {
            Insets[] insetsArr = this.f15222b;
            if (insetsArr != null) {
                Insets insets = insetsArr[Type.indexOf(1)];
                Insets insets2 = this.f15222b[Type.indexOf(2)];
                if (insets2 == null) {
                    insets2 = this.f15221a.getInsets(2);
                }
                if (insets == null) {
                    insets = this.f15221a.getInsets(1);
                }
                i(Insets.max(insets, insets2));
                Insets insets3 = this.f15222b[Type.indexOf(16)];
                if (insets3 != null) {
                    h(insets3);
                }
                Insets insets4 = this.f15222b[Type.indexOf(32)];
                if (insets4 != null) {
                    f(insets4);
                }
                Insets insets5 = this.f15222b[Type.indexOf(64)];
                if (insets5 != null) {
                    j(insets5);
                }
            }
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract WindowInsetsCompat b();

        /* access modifiers changed from: package-private */
        public void c(@Nullable DisplayCutoutCompat displayCutoutCompat) {
        }

        /* access modifiers changed from: package-private */
        public void d(int i10, @NonNull Insets insets) {
            if (this.f15222b == null) {
                this.f15222b = new Insets[9];
            }
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    this.f15222b[Type.indexOf(i11)] = insets;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e(int i10, @NonNull Insets insets) {
            if (i10 == 8) {
                throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
            }
        }

        /* access modifiers changed from: package-private */
        public void f(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public abstract void g(@NonNull Insets insets);

        /* access modifiers changed from: package-private */
        public void h(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public abstract void i(@NonNull Insets insets);

        /* access modifiers changed from: package-private */
        public void j(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void k(int i10, boolean z10) {
        }

        e(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f15221a = windowInsetsCompat;
        }
    }

    private static class h extends g {
        h(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat a() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f15228c.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!Objects.equals(this.f15228c, hVar.f15228c) || !Objects.equals(this.f15232g, hVar.f15232g)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public DisplayCutoutCompat f() {
            return DisplayCutoutCompat.wrap(this.f15228c.getDisplayCutout());
        }

        public int hashCode() {
            return this.f15228c.hashCode();
        }

        h(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull h hVar) {
            super(windowInsetsCompat, (g) hVar);
        }
    }

    private static class j extends i {

        /* renamed from: q  reason: collision with root package name */
        static final WindowInsetsCompat f15237q = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);

        j(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        public final void d(@NonNull View view) {
        }

        @NonNull
        public Insets g(int i10) {
            return Insets.toCompatInsets(this.f15228c.getInsets(l.a(i10)));
        }

        @NonNull
        public Insets h(int i10) {
            return Insets.toCompatInsets(this.f15228c.getInsetsIgnoringVisibility(l.a(i10)));
        }

        public boolean q(int i10) {
            return this.f15228c.isVisible(l.a(i10));
        }

        j(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull j jVar) {
            super(windowInsetsCompat, (i) jVar);
        }
    }

    private static class k {

        /* renamed from: b  reason: collision with root package name */
        static final WindowInsetsCompat f15238b = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();

        /* renamed from: a  reason: collision with root package name */
        final WindowInsetsCompat f15239a;

        k(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f15239a = windowInsetsCompat;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat a() {
            return this.f15239a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat b() {
            return this.f15239a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat c() {
            return this.f15239a;
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull View view) {
        }

        /* access modifiers changed from: package-private */
        public void e(@NonNull WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            if (p() != kVar.p() || o() != kVar.o() || !ObjectsCompat.equals(l(), kVar.l()) || !ObjectsCompat.equals(j(), kVar.j()) || !ObjectsCompat.equals(f(), kVar.f())) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public DisplayCutoutCompat f() {
            return null;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets g(int i10) {
            return Insets.NONE;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets h(int i10) {
            if ((i10 & 8) == 0) {
                return Insets.NONE;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public int hashCode() {
            return ObjectsCompat.hash(Boolean.valueOf(p()), Boolean.valueOf(o()), l(), j(), f());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets i() {
            return l();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets j() {
            return Insets.NONE;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets k() {
            return l();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets l() {
            return Insets.NONE;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets m() {
            return l();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat n(int i10, int i11, int i12, int i13) {
            return f15238b;
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean p() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean q(int i10) {
            return true;
        }

        public void r(Insets[] insetsArr) {
        }

        /* access modifiers changed from: package-private */
        public void s(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void t(@Nullable WindowInsetsCompat windowInsetsCompat) {
        }

        public void u(Insets insets) {
        }
    }

    private static final class l {
        static int a(int i10) {
            int a10;
            int i11 = 0;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i10 & i12) != 0) {
                    if (i12 == 1) {
                        a10 = WindowInsets.Type.statusBars();
                    } else if (i12 == 2) {
                        a10 = WindowInsets.Type.navigationBars();
                    } else if (i12 == 4) {
                        a10 = WindowInsets.Type.captionBar();
                    } else if (i12 == 8) {
                        a10 = WindowInsets.Type.ime();
                    } else if (i12 == 16) {
                        a10 = WindowInsets.Type.systemGestures();
                    } else if (i12 == 32) {
                        a10 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i12 == 64) {
                        a10 = WindowInsets.Type.tappableElement();
                    } else if (i12 == 128) {
                        a10 = WindowInsets.Type.displayCutout();
                    }
                    i11 |= a10;
                }
            }
            return i11;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            CONSUMED = j.f15237q;
        } else {
            CONSUMED = k.f15238b;
        }
    }

    @RequiresApi(20)
    private WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.mImpl = new j(this, windowInsets);
        } else if (i10 >= 29) {
            this.mImpl = new i(this, windowInsets);
        } else if (i10 >= 28) {
            this.mImpl = new h(this, windowInsets);
        } else {
            this.mImpl = new g(this, windowInsets);
        }
    }

    static Insets insetInsets(@NonNull Insets insets, int i10, int i11, int i12, int i13) {
        int max = Math.max(0, insets.left - i10);
        int max2 = Math.max(0, insets.top - i11);
        int max3 = Math.max(0, insets.right - i12);
        int max4 = Math.max(0, insets.bottom - i13);
        if (max == i10 && max2 == i11 && max3 == i12 && max4 == i13) {
            return insets;
        }
        return Insets.of(max, max2, max3, max4);
    }

    @RequiresApi(20)
    @NonNull
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        return toWindowInsetsCompat(windowInsets, (View) null);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.a();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.b();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.c();
    }

    /* access modifiers changed from: package-private */
    public void copyRootViewBounds(@NonNull View view) {
        this.mImpl.d(view);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat) obj).mImpl);
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.f();
    }

    @NonNull
    public Insets getInsets(int i10) {
        return this.mImpl.g(i10);
    }

    @NonNull
    public Insets getInsetsIgnoringVisibility(int i10) {
        return this.mImpl.h(i10);
    }

    @NonNull
    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.i();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.mImpl.j().bottom;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.mImpl.j().left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.mImpl.j().right;
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.mImpl.j().top;
    }

    @NonNull
    @Deprecated
    public Insets getStableInsets() {
        return this.mImpl.j();
    }

    @NonNull
    @Deprecated
    public Insets getSystemGestureInsets() {
        return this.mImpl.k();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.l().bottom;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.l().left;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.l().right;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.l().top;
    }

    @NonNull
    @Deprecated
    public Insets getSystemWindowInsets() {
        return this.mImpl.l();
    }

    @NonNull
    @Deprecated
    public Insets getTappableElementInsets() {
        return this.mImpl.m();
    }

    public boolean hasInsets() {
        Insets insets = getInsets(Type.all());
        Insets insets2 = Insets.NONE;
        if (!insets.equals(insets2) || !getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals(insets2) || getDisplayCutout() != null) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !this.mImpl.j().equals(Insets.NONE);
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.mImpl.l().equals(Insets.NONE);
    }

    public int hashCode() {
        k kVar = this.mImpl;
        if (kVar == null) {
            return 0;
        }
        return kVar.hashCode();
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull Insets insets) {
        return inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean isConsumed() {
        return this.mImpl.o();
    }

    public boolean isRound() {
        return this.mImpl.p();
    }

    public boolean isVisible(int i10) {
        return this.mImpl.q(i10);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i10, int i11, int i12, int i13) {
        return new Builder(this).setSystemWindowInsets(Insets.of(i10, i11, i12, i13)).build();
    }

    /* access modifiers changed from: package-private */
    public void setOverriddenInsets(Insets[] insetsArr) {
        this.mImpl.r(insetsArr);
    }

    /* access modifiers changed from: package-private */
    public void setRootViewData(@NonNull Insets insets) {
        this.mImpl.s(insets);
    }

    /* access modifiers changed from: package-private */
    public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
        this.mImpl.t(windowInsetsCompat);
    }

    /* access modifiers changed from: package-private */
    public void setStableInsets(@Nullable Insets insets) {
        this.mImpl.u(insets);
    }

    @RequiresApi(20)
    @Nullable
    public WindowInsets toWindowInsets() {
        k kVar = this.mImpl;
        if (kVar instanceof f) {
            return ((f) kVar).f15228c;
        }
        return null;
    }

    private static class b extends e {

        /* renamed from: e  reason: collision with root package name */
        private static Field f15214e;

        /* renamed from: f  reason: collision with root package name */
        private static boolean f15215f;

        /* renamed from: g  reason: collision with root package name */
        private static Constructor f15216g;

        /* renamed from: h  reason: collision with root package name */
        private static boolean f15217h;

        /* renamed from: c  reason: collision with root package name */
        private WindowInsets f15218c;

        /* renamed from: d  reason: collision with root package name */
        private Insets f15219d;

        b() {
            this.f15218c = l();
        }

        @Nullable
        private static WindowInsets l() {
            Class<WindowInsets> cls = WindowInsets.class;
            if (!f15215f) {
                try {
                    f15214e = cls.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e10) {
                    Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets.CONSUMED field", e10);
                }
                f15215f = true;
            }
            Field field = f15214e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e11) {
                    Log.i(WindowInsetsCompat.TAG, "Could not get value from WindowInsets.CONSUMED field", e11);
                }
            }
            if (!f15217h) {
                try {
                    f15216g = cls.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException e12) {
                    Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets(Rect) constructor", e12);
                }
                f15217h = true;
            }
            Constructor constructor = f15216g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException e13) {
                    Log.i(WindowInsetsCompat.TAG, "Could not invoke WindowInsets(Rect) constructor", e13);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.f15218c);
            windowInsetsCompat.setOverriddenInsets(this.f15222b);
            windowInsetsCompat.setStableInsets(this.f15219d);
            return windowInsetsCompat;
        }

        /* access modifiers changed from: package-private */
        public void g(@Nullable Insets insets) {
            this.f15219d = insets;
        }

        /* access modifiers changed from: package-private */
        public void i(@NonNull Insets insets) {
            WindowInsets windowInsets = this.f15218c;
            if (windowInsets != null) {
                this.f15218c = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }

        b(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.f15218c = windowInsetsCompat.toWindowInsets();
        }
    }

    private static class c extends e {

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets.Builder f15220c;

        c() {
            this.f15220c = t1.a();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.f15220c.build());
            windowInsetsCompat.setOverriddenInsets(this.f15222b);
            return windowInsetsCompat;
        }

        /* access modifiers changed from: package-private */
        public void c(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            DisplayCutout displayCutout;
            WindowInsets.Builder builder = this.f15220c;
            if (displayCutoutCompat != null) {
                displayCutout = displayCutoutCompat.unwrap();
            } else {
                displayCutout = null;
            }
            WindowInsets.Builder unused = builder.setDisplayCutout(displayCutout);
        }

        /* access modifiers changed from: package-private */
        public void f(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.f15220c.setMandatorySystemGestureInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void g(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.f15220c.setStableInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void h(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.f15220c.setSystemGestureInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void i(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.f15220c.setSystemWindowInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void j(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.f15220c.setTappableElementInsets(insets.toPlatformInsets());
        }

        c(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets.Builder builder;
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                builder = s1.a(windowInsets);
            } else {
                builder = t1.a();
            }
            this.f15220c = builder;
        }
    }

    private static class g extends f {

        /* renamed from: m  reason: collision with root package name */
        private Insets f15233m = null;

        g(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat b() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f15228c.consumeStableInsets());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat c() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f15228c.consumeSystemWindowInsets());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public final Insets j() {
            if (this.f15233m == null) {
                this.f15233m = Insets.of(this.f15228c.getStableInsetLeft(), this.f15228c.getStableInsetTop(), this.f15228c.getStableInsetRight(), this.f15228c.getStableInsetBottom());
            }
            return this.f15233m;
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            return this.f15228c.isConsumed();
        }

        public void u(@Nullable Insets insets) {
            this.f15233m = insets;
        }

        g(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull g gVar) {
            super(windowInsetsCompat, (f) gVar);
            this.f15233m = gVar.f15233m;
        }
    }

    @RequiresApi(20)
    @NonNull
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets, @Nullable View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            windowInsetsCompat.setRootWindowInsets(ViewCompat.getRootWindowInsets(view));
            windowInsetsCompat.copyRootViewBounds(view.getRootView());
        }
        return windowInsetsCompat;
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int i10, @IntRange(from = 0) int i11, @IntRange(from = 0) int i12, @IntRange(from = 0) int i13) {
        return this.mImpl.n(i10, i11, i12, i13);
    }

    private static class f extends k {

        /* renamed from: h  reason: collision with root package name */
        private static boolean f15223h;

        /* renamed from: i  reason: collision with root package name */
        private static Method f15224i;

        /* renamed from: j  reason: collision with root package name */
        private static Class f15225j;

        /* renamed from: k  reason: collision with root package name */
        private static Field f15226k;

        /* renamed from: l  reason: collision with root package name */
        private static Field f15227l;

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets f15228c;

        /* renamed from: d  reason: collision with root package name */
        private Insets[] f15229d;

        /* renamed from: e  reason: collision with root package name */
        private Insets f15230e;

        /* renamed from: f  reason: collision with root package name */
        private WindowInsetsCompat f15231f;

        /* renamed from: g  reason: collision with root package name */
        Insets f15232g;

        f(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.f15230e = null;
            this.f15228c = windowInsets;
        }

        @SuppressLint({"PrivateApi"})
        private static void A() {
            try {
                f15224i = View.class.getDeclaredMethod("getViewRootImpl", (Class[]) null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f15225j = cls;
                f15226k = cls.getDeclaredField("mVisibleInsets");
                f15227l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f15226k.setAccessible(true);
                f15227l.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
            }
            f15223h = true;
        }

        @SuppressLint({"WrongConstant"})
        @NonNull
        private Insets v(int i10, boolean z10) {
            Insets insets = Insets.NONE;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    insets = Insets.max(insets, w(i11, z10));
                }
            }
            return insets;
        }

        private Insets x() {
            WindowInsetsCompat windowInsetsCompat = this.f15231f;
            if (windowInsetsCompat != null) {
                return windowInsetsCompat.getStableInsets();
            }
            return Insets.NONE;
        }

        @Nullable
        private Insets y(@NonNull View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f15223h) {
                    A();
                }
                Method method = f15224i;
                if (!(method == null || f15225j == null || f15226k == null)) {
                    try {
                        Object invoke = method.invoke(view, (Object[]) null);
                        if (invoke == null) {
                            Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f15226k.get(f15227l.get(invoke));
                        if (rect != null) {
                            return Insets.of(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e10) {
                        Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull View view) {
            Insets y10 = y(view);
            if (y10 == null) {
                y10 = Insets.NONE;
            }
            s(y10);
        }

        /* access modifiers changed from: package-private */
        public void e(@NonNull WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.setRootWindowInsets(this.f15231f);
            windowInsetsCompat.setRootViewData(this.f15232g);
        }

        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f15232g, ((f) obj).f15232g);
        }

        @NonNull
        public Insets g(int i10) {
            return v(i10, false);
        }

        @NonNull
        public Insets h(int i10) {
            return v(i10, true);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public final Insets l() {
            if (this.f15230e == null) {
                this.f15230e = Insets.of(this.f15228c.getSystemWindowInsetLeft(), this.f15228c.getSystemWindowInsetTop(), this.f15228c.getSystemWindowInsetRight(), this.f15228c.getSystemWindowInsetBottom());
            }
            return this.f15230e;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat n(int i10, int i11, int i12, int i13) {
            Builder builder = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.f15228c));
            builder.setSystemWindowInsets(WindowInsetsCompat.insetInsets(l(), i10, i11, i12, i13));
            builder.setStableInsets(WindowInsetsCompat.insetInsets(j(), i10, i11, i12, i13));
            return builder.build();
        }

        /* access modifiers changed from: package-private */
        public boolean p() {
            return this.f15228c.isRound();
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"WrongConstant"})
        public boolean q(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0 && !z(i11)) {
                    return false;
                }
            }
            return true;
        }

        public void r(Insets[] insetsArr) {
            this.f15229d = insetsArr;
        }

        /* access modifiers changed from: package-private */
        public void s(@NonNull Insets insets) {
            this.f15232g = insets;
        }

        /* access modifiers changed from: package-private */
        public void t(@Nullable WindowInsetsCompat windowInsetsCompat) {
            this.f15231f = windowInsetsCompat;
        }

        /* access modifiers changed from: protected */
        @NonNull
        public Insets w(int i10, boolean z10) {
            int i11;
            DisplayCutoutCompat displayCutoutCompat;
            if (i10 != 1) {
                Insets insets = null;
                if (i10 != 2) {
                    if (i10 == 8) {
                        Insets[] insetsArr = this.f15229d;
                        if (insetsArr != null) {
                            insets = insetsArr[Type.indexOf(8)];
                        }
                        if (insets != null) {
                            return insets;
                        }
                        Insets l10 = l();
                        Insets x10 = x();
                        int i12 = l10.bottom;
                        if (i12 > x10.bottom) {
                            return Insets.of(0, 0, 0, i12);
                        }
                        Insets insets2 = this.f15232g;
                        if (insets2 == null || insets2.equals(Insets.NONE) || (i11 = this.f15232g.bottom) <= x10.bottom) {
                            return Insets.NONE;
                        }
                        return Insets.of(0, 0, 0, i11);
                    } else if (i10 == 16) {
                        return k();
                    } else {
                        if (i10 == 32) {
                            return i();
                        }
                        if (i10 == 64) {
                            return m();
                        }
                        if (i10 != 128) {
                            return Insets.NONE;
                        }
                        WindowInsetsCompat windowInsetsCompat = this.f15231f;
                        if (windowInsetsCompat != null) {
                            displayCutoutCompat = windowInsetsCompat.getDisplayCutout();
                        } else {
                            displayCutoutCompat = f();
                        }
                        if (displayCutoutCompat != null) {
                            return Insets.of(displayCutoutCompat.getSafeInsetLeft(), displayCutoutCompat.getSafeInsetTop(), displayCutoutCompat.getSafeInsetRight(), displayCutoutCompat.getSafeInsetBottom());
                        }
                        return Insets.NONE;
                    }
                } else if (z10) {
                    Insets x11 = x();
                    Insets j10 = j();
                    return Insets.of(Math.max(x11.left, j10.left), 0, Math.max(x11.right, j10.right), Math.max(x11.bottom, j10.bottom));
                } else {
                    Insets l11 = l();
                    WindowInsetsCompat windowInsetsCompat2 = this.f15231f;
                    if (windowInsetsCompat2 != null) {
                        insets = windowInsetsCompat2.getStableInsets();
                    }
                    int i13 = l11.bottom;
                    if (insets != null) {
                        i13 = Math.min(i13, insets.bottom);
                    }
                    return Insets.of(l11.left, 0, l11.right, i13);
                }
            } else if (z10) {
                return Insets.of(0, Math.max(x().top, l().top), 0, 0);
            } else {
                return Insets.of(0, l().top, 0, 0);
            }
        }

        /* access modifiers changed from: protected */
        public boolean z(int i10) {
            if (!(i10 == 1 || i10 == 2)) {
                if (i10 == 4) {
                    return false;
                }
                if (!(i10 == 8 || i10 == 128)) {
                    return true;
                }
            }
            return !w(i10, false).equals(Insets.NONE);
        }

        f(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull f fVar) {
            this(windowInsetsCompat, new WindowInsets(fVar.f15228c));
        }
    }

    private static class i extends h {

        /* renamed from: n  reason: collision with root package name */
        private Insets f15234n = null;

        /* renamed from: o  reason: collision with root package name */
        private Insets f15235o = null;

        /* renamed from: p  reason: collision with root package name */
        private Insets f15236p = null;

        i(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets i() {
            if (this.f15235o == null) {
                this.f15235o = Insets.toCompatInsets(this.f15228c.getMandatorySystemGestureInsets());
            }
            return this.f15235o;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets k() {
            if (this.f15234n == null) {
                this.f15234n = Insets.toCompatInsets(this.f15228c.getSystemGestureInsets());
            }
            return this.f15234n;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets m() {
            if (this.f15236p == null) {
                this.f15236p = Insets.toCompatInsets(this.f15228c.getTappableElementInsets());
            }
            return this.f15236p;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat n(int i10, int i11, int i12, int i13) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f15228c.inset(i10, i11, i12, i13));
        }

        public void u(@Nullable Insets insets) {
        }

        i(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull i iVar) {
            super(windowInsetsCompat, (h) iVar);
        }
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect rect) {
        return new Builder(this).setSystemWindowInsets(Insets.of(rect)).build();
    }

    public static final class Builder {
        private final e mImpl;

        public Builder() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.mImpl = new d();
            } else if (i10 >= 29) {
                this.mImpl = new c();
            } else {
                this.mImpl = new b();
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            return this.mImpl.b();
        }

        @NonNull
        public Builder setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.mImpl.c(displayCutoutCompat);
            return this;
        }

        @NonNull
        public Builder setInsets(int i10, @NonNull Insets insets) {
            this.mImpl.d(i10, insets);
            return this;
        }

        @NonNull
        public Builder setInsetsIgnoringVisibility(int i10, @NonNull Insets insets) {
            this.mImpl.e(i10, insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setMandatorySystemGestureInsets(@NonNull Insets insets) {
            this.mImpl.f(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setStableInsets(@NonNull Insets insets) {
            this.mImpl.g(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemGestureInsets(@NonNull Insets insets) {
            this.mImpl.h(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemWindowInsets(@NonNull Insets insets) {
            this.mImpl.i(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTappableElementInsets(@NonNull Insets insets) {
            this.mImpl.j(insets);
            return this;
        }

        @NonNull
        public Builder setVisible(int i10, boolean z10) {
            this.mImpl.k(i10, z10);
            return this;
        }

        public Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.mImpl = new d(windowInsetsCompat);
            } else if (i10 >= 29) {
                this.mImpl = new c(windowInsetsCompat);
            } else {
                this.mImpl = new b(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            k kVar = windowInsetsCompat.mImpl;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30 && (kVar instanceof j)) {
                this.mImpl = new j(this, (j) kVar);
            } else if (i10 >= 29 && (kVar instanceof i)) {
                this.mImpl = new i(this, (i) kVar);
            } else if (i10 >= 28 && (kVar instanceof h)) {
                this.mImpl = new h(this, (h) kVar);
            } else if (kVar instanceof g) {
                this.mImpl = new g(this, (g) kVar);
            } else if (kVar instanceof f) {
                this.mImpl = new f(this, (f) kVar);
            } else {
                this.mImpl = new k(this);
            }
            kVar.e(this);
            return;
        }
        this.mImpl = new k(this);
    }
}
