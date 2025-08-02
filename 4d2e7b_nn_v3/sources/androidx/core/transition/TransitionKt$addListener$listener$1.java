package androidx.core.transition;

import android.transition.Transition;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    final /* synthetic */ Function1<Transition, Unit> $onCancel;
    final /* synthetic */ Function1<Transition, Unit> $onEnd;
    final /* synthetic */ Function1<Transition, Unit> $onPause;
    final /* synthetic */ Function1<Transition, Unit> $onResume;
    final /* synthetic */ Function1<Transition, Unit> $onStart;

    public TransitionKt$addListener$listener$1(Function1<? super Transition, Unit> function1, Function1<? super Transition, Unit> function12, Function1<? super Transition, Unit> function13, Function1<? super Transition, Unit> function14, Function1<? super Transition, Unit> function15) {
        this.$onEnd = function1;
        this.$onResume = function12;
        this.$onPause = function13;
        this.$onCancel = function14;
        this.$onStart = function15;
    }

    public void onTransitionCancel(Transition transition) {
        this.$onCancel.invoke(transition);
    }

    public void onTransitionEnd(Transition transition) {
        this.$onEnd.invoke(transition);
    }

    public void onTransitionPause(Transition transition) {
        this.$onPause.invoke(transition);
    }

    public void onTransitionResume(Transition transition) {
        this.$onResume.invoke(transition);
    }

    public void onTransitionStart(Transition transition) {
        this.$onStart.invoke(transition);
    }
}
