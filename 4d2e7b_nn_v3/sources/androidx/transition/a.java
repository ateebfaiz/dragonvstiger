package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

abstract class a {
    static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    static void b(Animator animator) {
        animator.pause();
    }

    static void c(Animator animator) {
        animator.resume();
    }
}
