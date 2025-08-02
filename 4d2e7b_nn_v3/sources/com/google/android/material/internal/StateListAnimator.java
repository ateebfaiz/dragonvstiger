package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StateListAnimator {
    private final Animator.AnimatorListener animationListener = new a();
    @Nullable
    private b lastMatch = null;
    @Nullable
    ValueAnimator runningAnimator = null;
    private final ArrayList<b> tuples = new ArrayList<>();

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            StateListAnimator stateListAnimator = StateListAnimator.this;
            if (stateListAnimator.runningAnimator == animator) {
                stateListAnimator.runningAnimator = null;
            }
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final int[] f8331a;

        /* renamed from: b  reason: collision with root package name */
        final ValueAnimator f8332b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.f8331a = iArr;
            this.f8332b = valueAnimator;
        }
    }

    private void cancel() {
        ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.runningAnimator = null;
        }
    }

    private void start(@NonNull b bVar) {
        ValueAnimator valueAnimator = bVar.f8332b;
        this.runningAnimator = valueAnimator;
        valueAnimator.start();
    }

    public void addState(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.animationListener);
        this.tuples.add(bVar);
    }

    public void jumpToCurrentState() {
        ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.runningAnimator = null;
        }
    }

    public void setState(int[] iArr) {
        b bVar;
        int size = this.tuples.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                bVar = null;
                break;
            }
            bVar = this.tuples.get(i10);
            if (StateSet.stateSetMatches(bVar.f8331a, iArr)) {
                break;
            }
            i10++;
        }
        b bVar2 = this.lastMatch;
        if (bVar != bVar2) {
            if (bVar2 != null) {
                cancel();
            }
            this.lastMatch = bVar;
            if (bVar != null) {
                start(bVar);
            }
        }
    }
}
