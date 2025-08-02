package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewPropertyAnimatorCompatSet {
    final ArrayList<ViewPropertyAnimatorCompat> mAnimators = new ArrayList<>();
    private long mDuration = -1;
    private Interpolator mInterpolator;
    private boolean mIsStarted;
    ViewPropertyAnimatorListener mListener;
    private final ViewPropertyAnimatorListenerAdapter mProxyListener = new a();

    class a extends ViewPropertyAnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f14064a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f14065b = 0;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f14065b = 0;
            this.f14064a = false;
            ViewPropertyAnimatorCompatSet.this.onAnimationsEnded();
        }

        public void onAnimationEnd(View view) {
            int i10 = this.f14065b + 1;
            this.f14065b = i10;
            if (i10 == ViewPropertyAnimatorCompatSet.this.mAnimators.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.mListener;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd((View) null);
                }
                a();
            }
        }

        public void onAnimationStart(View view) {
            if (!this.f14064a) {
                this.f14064a = true;
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.mListener;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationStart((View) null);
                }
            }
        }
    }

    public void cancel() {
        if (this.mIsStarted) {
            Iterator<ViewPropertyAnimatorCompat> it = this.mAnimators.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.mIsStarted = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void onAnimationsEnded() {
        this.mIsStarted = false;
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.mIsStarted) {
            this.mAnimators.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.mAnimators.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.mAnimators.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long j10) {
        if (!this.mIsStarted) {
            this.mDuration = j10;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator) {
        if (!this.mIsStarted) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.mIsStarted) {
            this.mListener = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void start() {
        if (!this.mIsStarted) {
            Iterator<ViewPropertyAnimatorCompat> it = this.mAnimators.iterator();
            while (it.hasNext()) {
                ViewPropertyAnimatorCompat next = it.next();
                long j10 = this.mDuration;
                if (j10 >= 0) {
                    next.setDuration(j10);
                }
                Interpolator interpolator = this.mInterpolator;
                if (interpolator != null) {
                    next.setInterpolator(interpolator);
                }
                if (this.mListener != null) {
                    next.setListener(this.mProxyListener);
                }
                next.start();
            }
            this.mIsStarted = true;
        }
    }
}
