package androidx.core.view;

import android.view.WindowInsetsAnimationController;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;

public final class WindowInsetsAnimationControllerCompat {
    private final b mImpl;

    private static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        private final WindowInsetsAnimationController f15209a;

        a(WindowInsetsAnimationController windowInsetsAnimationController) {
            this.f15209a = windowInsetsAnimationController;
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z10) {
            this.f15209a.finish(z10);
        }

        public float b() {
            return this.f15209a.getCurrentAlpha();
        }

        public float c() {
            return this.f15209a.getCurrentFraction();
        }

        public Insets d() {
            return Insets.toCompatInsets(this.f15209a.getCurrentInsets());
        }

        public Insets e() {
            return Insets.toCompatInsets(this.f15209a.getHiddenStateInsets());
        }

        public Insets f() {
            return Insets.toCompatInsets(this.f15209a.getShownStateInsets());
        }

        public int g() {
            return this.f15209a.getTypes();
        }

        /* access modifiers changed from: package-private */
        public boolean h() {
            return this.f15209a.isCancelled();
        }

        /* access modifiers changed from: package-private */
        public boolean i() {
            return this.f15209a.isFinished();
        }

        public void j(Insets insets, float f10, float f11) {
            android.graphics.Insets insets2;
            WindowInsetsAnimationController windowInsetsAnimationController = this.f15209a;
            if (insets == null) {
                insets2 = null;
            } else {
                insets2 = insets.toPlatformInsets();
            }
            windowInsetsAnimationController.setInsetsAndAlpha(insets2, f10, f11);
        }
    }

    private static class b {
        b() {
        }

        /* access modifiers changed from: package-private */
        public abstract void a(boolean z10);

        public abstract float b();

        public abstract float c();

        public abstract Insets d();

        public abstract Insets e();

        public abstract Insets f();

        public abstract int g();

        /* access modifiers changed from: package-private */
        public abstract boolean h();

        /* access modifiers changed from: package-private */
        public abstract boolean i();

        public abstract void j(Insets insets, float f10, float f11);
    }

    @RequiresApi(30)
    WindowInsetsAnimationControllerCompat(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mImpl = new a(windowInsetsAnimationController);
    }

    public void finish(boolean z10) {
        this.mImpl.a(z10);
    }

    public float getCurrentAlpha() {
        return this.mImpl.b();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getCurrentFraction() {
        return this.mImpl.c();
    }

    @NonNull
    public Insets getCurrentInsets() {
        return this.mImpl.d();
    }

    @NonNull
    public Insets getHiddenStateInsets() {
        return this.mImpl.e();
    }

    @NonNull
    public Insets getShownStateInsets() {
        return this.mImpl.f();
    }

    public int getTypes() {
        return this.mImpl.g();
    }

    public boolean isCancelled() {
        return this.mImpl.h();
    }

    public boolean isFinished() {
        return this.mImpl.i();
    }

    public boolean isReady() {
        if (isFinished() || isCancelled()) {
            return false;
        }
        return true;
    }

    public void setInsetsAndAlpha(@Nullable Insets insets, @FloatRange(from = 0.0d, to = 1.0d) float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        this.mImpl.j(insets, f10, f11);
    }
}
