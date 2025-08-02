package androidx.core.animation;

import android.animation.Animator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {
    final /* synthetic */ Function1<Animator, Unit> $onCancel;
    final /* synthetic */ Function1<Animator, Unit> $onEnd;
    final /* synthetic */ Function1<Animator, Unit> $onRepeat;
    final /* synthetic */ Function1<Animator, Unit> $onStart;

    public AnimatorKt$addListener$listener$1(Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function12, Function1<? super Animator, Unit> function13, Function1<? super Animator, Unit> function14) {
        this.$onRepeat = function1;
        this.$onEnd = function12;
        this.$onCancel = function13;
        this.$onStart = function14;
    }

    public void onAnimationCancel(Animator animator) {
        this.$onCancel.invoke(animator);
    }

    public void onAnimationEnd(Animator animator) {
        this.$onEnd.invoke(animator);
    }

    public void onAnimationRepeat(Animator animator) {
        this.$onRepeat.invoke(animator);
    }

    public void onAnimationStart(Animator animator) {
        this.$onStart.invoke(animator);
    }
}
