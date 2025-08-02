package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;

public final class AnimatorKt$doOnCancel$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ Function1 $onCancel;

    public AnimatorKt$doOnCancel$$inlined$addListener$default$1(Function1 function1) {
        this.$onCancel = function1;
    }

    public void onAnimationCancel(Animator animator) {
        this.$onCancel.invoke(animator);
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
