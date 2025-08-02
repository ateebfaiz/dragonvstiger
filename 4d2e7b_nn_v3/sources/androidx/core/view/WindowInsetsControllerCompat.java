package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import com.google.android.games.paddleboat.GameControllerManager;

public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_DEFAULT = 1;
    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final e mImpl;

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(@NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, int i10);
    }

    private static class a extends e {

        /* renamed from: a  reason: collision with root package name */
        protected final Window f15240a;

        /* renamed from: b  reason: collision with root package name */
        private final SoftwareKeyboardControllerCompat f15241b;

        a(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.f15240a = window;
            this.f15241b = softwareKeyboardControllerCompat;
        }

        private void l(int i10) {
            if (i10 == 1) {
                m(4);
            } else if (i10 == 2) {
                m(2);
            } else if (i10 == 8) {
                this.f15241b.hide();
            }
        }

        private void o(int i10) {
            if (i10 == 1) {
                p(4);
                q(1024);
            } else if (i10 == 2) {
                p(2);
            } else if (i10 == 8) {
                this.f15241b.show();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        /* access modifiers changed from: package-private */
        public void b(int i10, long j10, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void d(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    l(i11);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void g(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        /* access modifiers changed from: package-private */
        public void j(int i10) {
            if (i10 == 0) {
                p(6144);
            } else if (i10 == 1) {
                p(4096);
                m(2048);
            } else if (i10 == 2) {
                p(2048);
                m(4096);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    o(i11);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void m(int i10) {
            View decorView = this.f15240a.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void n(int i10) {
            this.f15240a.addFlags(i10);
        }

        /* access modifiers changed from: protected */
        public void p(int i10) {
            View decorView = this.f15240a.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void q(int i10) {
            this.f15240a.clearFlags(i10);
        }
    }

    private static class b extends a {
        b(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        public boolean f() {
            if ((this.f15240a.getDecorView().getSystemUiVisibility() & 8192) != 0) {
                return true;
            }
            return false;
        }

        public void i(boolean z10) {
            if (z10) {
                q(67108864);
                n(Integer.MIN_VALUE);
                m(8192);
                return;
            }
            p(8192);
        }
    }

    private static class c extends b {
        c(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        public boolean e() {
            if ((this.f15240a.getDecorView().getSystemUiVisibility() & 16) != 0) {
                return true;
            }
            return false;
        }

        public void h(boolean z10) {
            if (z10) {
                q(GameControllerManager.DEVICEFLAG_VIBRATION);
                n(Integer.MIN_VALUE);
                m(16);
                return;
            }
            p(16);
        }
    }

    private static class e {
        e() {
        }

        /* access modifiers changed from: package-private */
        public abstract void a(OnControllableInsetsChangedListener onControllableInsetsChangedListener);

        /* access modifiers changed from: package-private */
        public abstract void b(int i10, long j10, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat);

        /* access modifiers changed from: package-private */
        public abstract int c();

        /* access modifiers changed from: package-private */
        public abstract void d(int i10);

        public boolean e() {
            return false;
        }

        public abstract boolean f();

        /* access modifiers changed from: package-private */
        public abstract void g(OnControllableInsetsChangedListener onControllableInsetsChangedListener);

        public void h(boolean z10) {
        }

        public abstract void i(boolean z10);

        /* access modifiers changed from: package-private */
        public abstract void j(int i10);

        /* access modifiers changed from: package-private */
        public abstract void k(int i10);
    }

    @RequiresApi(30)
    @Deprecated
    private WindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        this.mImpl = new d(windowInsetsController, this, new SoftwareKeyboardControllerCompat(windowInsetsController));
    }

    @RequiresApi(30)
    @NonNull
    @Deprecated
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public void addOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.a(onControllableInsetsChangedListener);
    }

    public void controlWindowInsetsAnimation(int i10, long j10, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.mImpl.b(i10, j10, interpolator, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    @SuppressLint({"WrongConstant"})
    public int getSystemBarsBehavior() {
        return this.mImpl.c();
    }

    public void hide(int i10) {
        this.mImpl.d(i10);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.e();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.f();
    }

    public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.g(onControllableInsetsChangedListener);
    }

    public void setAppearanceLightNavigationBars(boolean z10) {
        this.mImpl.h(z10);
    }

    public void setAppearanceLightStatusBars(boolean z10) {
        this.mImpl.i(z10);
    }

    public void setSystemBarsBehavior(int i10) {
        this.mImpl.j(i10);
    }

    public void show(int i10) {
        this.mImpl.k(i10);
    }

    private static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final WindowInsetsControllerCompat f15242a;

        /* renamed from: b  reason: collision with root package name */
        final WindowInsetsController f15243b;

        /* renamed from: c  reason: collision with root package name */
        final SoftwareKeyboardControllerCompat f15244c;

        /* renamed from: d  reason: collision with root package name */
        private final SimpleArrayMap f15245d;

        /* renamed from: e  reason: collision with root package name */
        protected Window f15246e;

        class a implements WindowInsetsAnimationControlListener {

            /* renamed from: a  reason: collision with root package name */
            private WindowInsetsAnimationControllerCompat f15247a = null;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ WindowInsetsAnimationControlListenerCompat f15248b;

            a(WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
                this.f15248b = windowInsetsAnimationControlListenerCompat;
            }

            public void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
                WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat;
                WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat = this.f15248b;
                if (windowInsetsAnimationController == null) {
                    windowInsetsAnimationControllerCompat = null;
                } else {
                    windowInsetsAnimationControllerCompat = this.f15247a;
                }
                windowInsetsAnimationControlListenerCompat.onCancelled(windowInsetsAnimationControllerCompat);
            }

            public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
                this.f15248b.onFinished(this.f15247a);
            }

            public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i10) {
                WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                this.f15247a = windowInsetsAnimationControllerCompat;
                this.f15248b.onReady(windowInsetsAnimationControllerCompat, i10);
            }
        }

        d(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this(window.getInsetsController(), windowInsetsControllerCompat, softwareKeyboardControllerCompat);
            this.f15246e = window;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(OnControllableInsetsChangedListener onControllableInsetsChangedListener, WindowInsetsController windowInsetsController, int i10) {
            if (this.f15243b == windowInsetsController) {
                onControllableInsetsChangedListener.onControllableInsetsChanged(this.f15242a, i10);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            if (!this.f15245d.containsKey(onControllableInsetsChangedListener)) {
                v2 v2Var = new v2(this, onControllableInsetsChangedListener);
                this.f15245d.put(onControllableInsetsChangedListener, v2Var);
                this.f15243b.addOnControllableInsetsChangedListener(v2Var);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i10, long j10, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
            this.f15243b.controlWindowInsetsAnimation(i10, j10, interpolator, cancellationSignal, new a(windowInsetsAnimationControlListenerCompat));
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return this.f15243b.getSystemBarsBehavior();
        }

        /* access modifiers changed from: package-private */
        public void d(int i10) {
            if ((i10 & 8) != 0) {
                this.f15244c.hide();
            }
            this.f15243b.hide(i10 & -9);
        }

        public boolean e() {
            this.f15243b.setSystemBarsAppearance(0, 0);
            if ((this.f15243b.getSystemBarsAppearance() & 16) != 0) {
                return true;
            }
            return false;
        }

        public boolean f() {
            this.f15243b.setSystemBarsAppearance(0, 0);
            if ((this.f15243b.getSystemBarsAppearance() & 8) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void g(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            WindowInsetsController.OnControllableInsetsChangedListener a10 = t2.a(this.f15245d.remove(onControllableInsetsChangedListener));
            if (a10 != null) {
                this.f15243b.removeOnControllableInsetsChangedListener(a10);
            }
        }

        public void h(boolean z10) {
            if (z10) {
                if (this.f15246e != null) {
                    n(16);
                }
                this.f15243b.setSystemBarsAppearance(16, 16);
                return;
            }
            if (this.f15246e != null) {
                o(16);
            }
            this.f15243b.setSystemBarsAppearance(0, 16);
        }

        public void i(boolean z10) {
            if (z10) {
                if (this.f15246e != null) {
                    n(8192);
                }
                this.f15243b.setSystemBarsAppearance(8, 8);
                return;
            }
            if (this.f15246e != null) {
                o(8192);
            }
            this.f15243b.setSystemBarsAppearance(0, 8);
        }

        /* access modifiers changed from: package-private */
        public void j(int i10) {
            this.f15243b.setSystemBarsBehavior(i10);
        }

        /* access modifiers changed from: package-private */
        public void k(int i10) {
            if ((i10 & 8) != 0) {
                this.f15244c.show();
            }
            this.f15243b.show(i10 & -9);
        }

        /* access modifiers changed from: protected */
        public void n(int i10) {
            View decorView = this.f15246e.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void o(int i10) {
            View decorView = this.f15246e.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        d(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.f15245d = new SimpleArrayMap();
            this.f15243b = windowInsetsController;
            this.f15242a = windowInsetsControllerCompat;
            this.f15244c = softwareKeyboardControllerCompat;
        }
    }

    public WindowInsetsControllerCompat(@NonNull Window window, @NonNull View view) {
        SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.mImpl = new d(window, this, softwareKeyboardControllerCompat);
        } else if (i10 >= 26) {
            this.mImpl = new c(window, softwareKeyboardControllerCompat);
        } else {
            this.mImpl = new b(window, softwareKeyboardControllerCompat);
        }
    }
}
