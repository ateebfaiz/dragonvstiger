package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;

public final class AnimatorKt$doOnEnd$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ Function1 $onEnd;

    public AnimatorKt$doOnEnd$$inlined$addListener$default$1(Function1 function1) {
        this.$onEnd = function1;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.$onEnd.invoke(animator);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
