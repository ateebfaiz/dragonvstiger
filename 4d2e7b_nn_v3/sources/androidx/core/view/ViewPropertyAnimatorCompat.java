package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {
    private final WeakReference<View> mView;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimatorListener f15177a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f15178b;

        a(ViewPropertyAnimatorListener viewPropertyAnimatorListener, View view) {
            this.f15177a = viewPropertyAnimatorListener;
            this.f15178b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f15177a.onAnimationCancel(this.f15178b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f15177a.onAnimationEnd(this.f15178b);
        }

        public void onAnimationStart(Animator animator) {
            this.f15177a.onAnimationStart(this.f15178b);
        }
    }

    static class b {
        @DoNotInline
        static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, float f10) {
            return viewPropertyAnimator.translationZ(f10);
        }

        @DoNotInline
        static ViewPropertyAnimator b(ViewPropertyAnimator viewPropertyAnimator, float f10) {
            return viewPropertyAnimator.translationZBy(f10);
        }

        @DoNotInline
        static ViewPropertyAnimator c(ViewPropertyAnimator viewPropertyAnimator, float f10) {
            return viewPropertyAnimator.z(f10);
        }

        @DoNotInline
        static ViewPropertyAnimator d(ViewPropertyAnimator viewPropertyAnimator, float f10) {
            return viewPropertyAnimator.zBy(f10);
        }
    }

    ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference<>(view);
    }

    private void setListenerInternal(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new a(viewPropertyAnimatorListener, view));
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat alpha(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat alphaBy(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alphaBy(f10);
        }
        return this;
    }

    public void cancel() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long getDuration() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    @Nullable
    public Interpolator getInterpolator() {
        View view = this.mView.get();
        if (view != null) {
            return (Interpolator) view.animate().getInterpolator();
        }
        return null;
    }

    public long getStartDelay() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotation(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotation(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationBy(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationBy(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationX(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationX(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationXBy(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationXBy(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationY(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationY(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationYBy(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationYBy(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleX(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleX(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleXBy(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleXBy(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleY(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleY(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleYBy(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleYBy(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setDuration(long j10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setInterpolator(@Nullable Interpolator interpolator) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setListener(@Nullable ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.mView.get();
        if (view != null) {
            setListenerInternal(view, viewPropertyAnimatorListener);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setStartDelay(long j10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setStartDelay(j10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setUpdateListener(@Nullable ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        n0 n0Var;
        View view = this.mView.get();
        if (view != null) {
            if (viewPropertyAnimatorUpdateListener != null) {
                n0Var = new n0(viewPropertyAnimatorUpdateListener, view);
            } else {
                n0Var = null;
            }
            view.animate().setUpdateListener(n0Var);
        }
        return this;
    }

    public void start() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().start();
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationX(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationX(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationXBy(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationXBy(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationY(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationYBy(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationYBy(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZ(float f10) {
        View view = this.mView.get();
        if (view != null) {
            b.a(view.animate(), f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZBy(float f10) {
        View view = this.mView.get();
        if (view != null) {
            b.b(view.animate(), f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat withEndAction(@NonNull Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().withEndAction(runnable);
        }
        return this;
    }

    @SuppressLint({"WrongConstant"})
    @NonNull
    public ViewPropertyAnimatorCompat withLayer() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().withLayer();
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat withStartAction(@NonNull Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().withStartAction(runnable);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat x(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().x(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat xBy(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().xBy(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat y(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().y(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat yBy(float f10) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().yBy(f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat z(float f10) {
        View view = this.mView.get();
        if (view != null) {
            b.c(view.animate(), f10);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat zBy(float f10) {
        View view = this.mView.get();
        if (view != null) {
            b.d(view.animate(), f10);
        }
        return this;
    }
}
