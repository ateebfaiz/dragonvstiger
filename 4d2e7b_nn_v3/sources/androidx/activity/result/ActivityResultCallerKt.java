package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

public final class ActivityResultCallerKt {
    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i10, ActivityResultRegistry activityResultRegistry, Function1<O, Unit> function1) {
        m.f(activityResultCaller, "<this>");
        m.f(activityResultContract, "contract");
        m.f(activityResultRegistry, "registry");
        m.f(function1, "callback");
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, activityResultRegistry, new a(function1)), activityResultContract, i10);
    }

    /* access modifiers changed from: private */
    public static final void registerForActivityResult$lambda$0(Function1 function1, Object obj) {
        m.f(function1, "$callback");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void registerForActivityResult$lambda$1(Function1 function1, Object obj) {
        m.f(function1, "$callback");
        function1.invoke(obj);
    }

    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i10, Function1<O, Unit> function1) {
        m.f(activityResultCaller, "<this>");
        m.f(activityResultContract, "contract");
        m.f(function1, "callback");
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, new b(function1)), activityResultContract, i10);
    }
}
