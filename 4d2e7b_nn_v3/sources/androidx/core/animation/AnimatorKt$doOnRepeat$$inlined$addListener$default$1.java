package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;

public final class AnimatorKt$doOnRepeat$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ Function1 $onRepeat;

    public AnimatorKt$doOnRepeat$$inlined$addListener$default$1(Function1 function1) {
        this.$onRepeat = function1;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
        this.$onRepeat.invoke(animator);
    }

    public void onAnimationStart(Animator animator) {
    }
}
