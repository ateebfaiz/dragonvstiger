package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

public final class OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1 implements OnBackAnimationCallback {
    final /* synthetic */ Function0<Unit> $onBackCancelled;
    final /* synthetic */ Function0<Unit> $onBackInvoked;
    final /* synthetic */ Function1<BackEventCompat, Unit> $onBackProgressed;
    final /* synthetic */ Function1<BackEventCompat, Unit> $onBackStarted;

    OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1(Function1<? super BackEventCompat, Unit> function1, Function1<? super BackEventCompat, Unit> function12, Function0<Unit> function0, Function0<Unit> function02) {
        this.$onBackStarted = function1;
        this.$onBackProgressed = function12;
        this.$onBackInvoked = function0;
        this.$onBackCancelled = function02;
    }

    public void onBackCancelled() {
        this.$onBackCancelled.invoke();
    }

    public void onBackInvoked() {
        this.$onBackInvoked.invoke();
    }

    public void onBackProgressed(BackEvent backEvent) {
        m.f(backEvent, "backEvent");
        this.$onBackProgressed.invoke(new BackEventCompat(backEvent));
    }

    public void onBackStarted(BackEvent backEvent) {
        m.f(backEvent, "backEvent");
        this.$onBackStarted.invoke(new BackEventCompat(backEvent));
    }
}
