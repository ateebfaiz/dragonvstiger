package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SoftwareKeyboardControllerCompat {
    private final c mImpl;

    private static class a extends c {

        /* renamed from: a  reason: collision with root package name */
        private final View f15159a;

        a(View view) {
            this.f15159a = view;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            View view = this.f15159a;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f15159a.getWindowToken(), 0);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            View view = this.f15159a;
            if (view != null) {
                if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                    view.requestFocus();
                } else {
                    view = view.getRootView().findFocus();
                }
                if (view == null) {
                    view = this.f15159a.getRootView().findViewById(16908290);
                }
                if (view != null && view.hasWindowFocus()) {
                    view.post(new y(view));
                }
            }
        }
    }

    private static class c {
        c() {
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        /* access modifiers changed from: package-private */
        public abstract void b();
    }

    public SoftwareKeyboardControllerCompat(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new b(view);
        } else {
            this.mImpl = new a(view);
        }
    }

    public void hide() {
        this.mImpl.a();
    }

    public void show() {
        this.mImpl.b();
    }

    private static class b extends a {

        /* renamed from: b  reason: collision with root package name */
        private View f15160b;

        /* renamed from: c  reason: collision with root package name */
        private WindowInsetsController f15161c;

        b(View view) {
            super(view);
            this.f15160b = view;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void f(AtomicBoolean atomicBoolean, WindowInsetsController windowInsetsController, int i10) {
            boolean z10;
            if ((i10 & 8) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            atomicBoolean.set(z10);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            View view;
            WindowInsetsController windowInsetsController = this.f15161c;
            if (windowInsetsController == null) {
                View view2 = this.f15160b;
                if (view2 != null) {
                    windowInsetsController = view2.getWindowInsetsController();
                } else {
                    windowInsetsController = null;
                }
            }
            if (windowInsetsController != null) {
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                f0 f0Var = new f0(atomicBoolean);
                windowInsetsController.addOnControllableInsetsChangedListener(f0Var);
                if (!atomicBoolean.get() && (view = this.f15160b) != null) {
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f15160b.getWindowToken(), 0);
                }
                windowInsetsController.removeOnControllableInsetsChangedListener(f0Var);
                windowInsetsController.hide(WindowInsets.Type.ime());
                return;
            }
            super.a();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            View view = this.f15160b;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = this.f15161c;
            if (windowInsetsController == null) {
                View view2 = this.f15160b;
                if (view2 != null) {
                    windowInsetsController = view2.getWindowInsetsController();
                } else {
                    windowInsetsController = null;
                }
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            }
            super.b();
        }

        b(WindowInsetsController windowInsetsController) {
            super((View) null);
            this.f15161c = windowInsetsController;
        }
    }

    @RequiresApi(30)
    @Deprecated
    SoftwareKeyboardControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        this.mImpl = new b(windowInsetsController);
    }
}
