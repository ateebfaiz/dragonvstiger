package androidx.core.animation;

import android.animation.Animator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.n;

public final class AnimatorKt {

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f14790a = new a();

        a() {
            super(1);
        }

        public final void invoke(Animator animator) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Animator) obj);
            return Unit.f12577a;
        }
    }

    static final class b extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f14791a = new b();

        b() {
            super(1);
        }

        public final void invoke(Animator animator) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Animator) obj);
            return Unit.f12577a;
        }
    }

    public static final Animator.AnimatorListener addListener(Animator animator, Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function12, Function1<? super Animator, Unit> function13, Function1<? super Animator, Unit> function14) {
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function14, function1, function13, function12);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function1 = AnimatorKt$addListener$1.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            function12 = AnimatorKt$addListener$2.INSTANCE;
        }
        if ((i10 & 4) != 0) {
            function13 = AnimatorKt$addListener$3.INSTANCE;
        }
        if ((i10 & 8) != 0) {
            function14 = AnimatorKt$addListener$4.INSTANCE;
        }
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function14, function1, function13, function12);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static final Animator.AnimatorPauseListener addPauseListener(Animator animator, Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function12) {
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(function12, function1);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, Function1 function1, Function1 function12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function1 = a.f14790a;
        }
        if ((i10 & 2) != 0) {
            function12 = b.f14791a;
        }
        return addPauseListener(animator, function1, function12);
    }

    public static final Animator.AnimatorListener doOnCancel(Animator animator, Function1<? super Animator, Unit> function1) {
        AnimatorKt$doOnCancel$$inlined$addListener$default$1 animatorKt$doOnCancel$$inlined$addListener$default$1 = new AnimatorKt$doOnCancel$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnCancel$$inlined$addListener$default$1);
        return animatorKt$doOnCancel$$inlined$addListener$default$1;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator animator, Function1<? super Animator, Unit> function1) {
        AnimatorKt$doOnEnd$$inlined$addListener$default$1 animatorKt$doOnEnd$$inlined$addListener$default$1 = new AnimatorKt$doOnEnd$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnEnd$$inlined$addListener$default$1);
        return animatorKt$doOnEnd$$inlined$addListener$default$1;
    }

    public static final Animator.AnimatorPauseListener doOnPause(Animator animator, Function1<? super Animator, Unit> function1) {
        return addPauseListener$default(animator, (Function1) null, function1, 1, (Object) null);
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator animator, Function1<? super Animator, Unit> function1) {
        AnimatorKt$doOnRepeat$$inlined$addListener$default$1 animatorKt$doOnRepeat$$inlined$addListener$default$1 = new AnimatorKt$doOnRepeat$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnRepeat$$inlined$addListener$default$1);
        return animatorKt$doOnRepeat$$inlined$addListener$default$1;
    }

    public static final Animator.AnimatorPauseListener doOnResume(Animator animator, Function1<? super Animator, Unit> function1) {
        return addPauseListener$default(animator, function1, (Function1) null, 2, (Object) null);
    }

    public static final Animator.AnimatorListener doOnStart(Animator animator, Function1<? super Animator, Unit> function1) {
        AnimatorKt$doOnStart$$inlined$addListener$default$1 animatorKt$doOnStart$$inlined$addListener$default$1 = new AnimatorKt$doOnStart$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnStart$$inlined$addListener$default$1);
        return animatorKt$doOnStart$$inlined$addListener$default$1;
    }
}
