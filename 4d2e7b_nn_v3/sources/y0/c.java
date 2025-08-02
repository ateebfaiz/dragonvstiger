package y0;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class c extends ValueAnimator {

    /* renamed from: a  reason: collision with root package name */
    private final Set f24841a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    private final Set f24842b = new CopyOnWriteArraySet();

    /* renamed from: c  reason: collision with root package name */
    private final Set f24843c = new CopyOnWriteArraySet();

    /* access modifiers changed from: package-private */
    public void a() {
        for (Animator.AnimatorListener onAnimationCancel : this.f24842b) {
            onAnimationCancel.onAnimationCancel(this);
        }
    }

    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f24842b.add(animatorListener);
    }

    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f24843c.add(animatorPauseListener);
    }

    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f24841a.add(animatorUpdateListener);
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z10) {
        for (Animator.AnimatorListener animatorListener : this.f24842b) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z10);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        for (Animator.AnimatorPauseListener onAnimationPause : this.f24843c) {
            onAnimationPause.onAnimationPause(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        for (Animator.AnimatorListener onAnimationRepeat : this.f24842b) {
            onAnimationRepeat.onAnimationRepeat(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        for (Animator.AnimatorPauseListener onAnimationResume : this.f24843c) {
            onAnimationResume.onAnimationResume(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(boolean z10) {
        for (Animator.AnimatorListener animatorListener : this.f24842b) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z10);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        for (ValueAnimator.AnimatorUpdateListener onAnimationUpdate : this.f24841a) {
            onAnimationUpdate.onAnimationUpdate(this);
        }
    }

    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void removeAllListeners() {
        this.f24842b.clear();
    }

    public void removeAllUpdateListeners() {
        this.f24841a.clear();
    }

    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f24842b.remove(animatorListener);
    }

    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f24843c.remove(animatorPauseListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f24841a.remove(animatorUpdateListener);
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    public void setStartDelay(long j10) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    public ValueAnimator setDuration(long j10) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
