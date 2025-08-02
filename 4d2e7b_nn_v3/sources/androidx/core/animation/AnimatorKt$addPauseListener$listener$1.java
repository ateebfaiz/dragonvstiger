package androidx.core.animation;

import android.animation.Animator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {
    final /* synthetic */ Function1<Animator, Unit> $onPause;
    final /* synthetic */ Function1<Animator, Unit> $onResume;

    AnimatorKt$addPauseListener$listener$1(Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function12) {
        this.$onPause = function1;
        this.$onResume = function12;
    }

    public void onAnimationPause(Animator animator) {
        this.$onPause.invoke(animator);
    }

    public void onAnimationResume(Animator animator) {
        this.$onResume.invoke(animator);
    }
}
