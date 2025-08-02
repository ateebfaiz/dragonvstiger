package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class ActivityResultCallerLauncher$resultContract$2 extends n implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivityResultCallerLauncher f13828a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActivityResultCallerLauncher$resultContract$2(ActivityResultCallerLauncher activityResultCallerLauncher) {
        super(0);
        this.f13828a = activityResultCallerLauncher;
    }

    /* renamed from: a */
    public final AnonymousClass1 invoke() {
        final ActivityResultCallerLauncher activityResultCallerLauncher = this.f13828a;
        return new ActivityResultContract<Unit, O>() {
            public O parseResult(int i10, Intent intent) {
                return activityResultCallerLauncher.getCallerContract().parseResult(i10, intent);
            }

            public Intent createIntent(Context context, Unit unit) {
                m.f(context, "context");
                m.f(unit, "input");
                return activityResultCallerLauncher.getCallerContract().createIntent(context, activityResultCallerLauncher.getCallerInput());
            }
        };
    }
}
