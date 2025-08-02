package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;

public final class AnimatorKt$doOnStart$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ Function1 $onStart;

    public AnimatorKt$doOnStart$$inlined$addListener$default$1(Function1 function1) {
        this.$onStart = function1;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.$onStart.invoke(animator);
    }
}
