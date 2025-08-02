package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

public final class OnBackPressedDispatcherKt {
    public static final OnBackPressedCallback addCallback(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z10, Function1<? super OnBackPressedCallback, Unit> function1) {
        m.f(onBackPressedDispatcher, "<this>");
        m.f(function1, "onBackPressed");
        OnBackPressedDispatcherKt$addCallback$callback$1 onBackPressedDispatcherKt$addCallback$callback$1 = new OnBackPressedDispatcherKt$addCallback$callback$1(z10, function1);
        if (lifecycleOwner != null) {
            onBackPressedDispatcher.addCallback(lifecycleOwner, onBackPressedDispatcherKt$addCallback$callback$1);
        } else {
            onBackPressedDispatcher.addCallback(onBackPressedDispatcherKt$addCallback$callback$1);
        }
        return onBackPressedDispatcherKt$addCallback$callback$1;
    }

    public static /* synthetic */ OnBackPressedCallback addCallback$default(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z10, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lifecycleOwner = null;
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return addCallback(onBackPressedDispatcher, lifecycleOwner, z10, function1);
    }
}
