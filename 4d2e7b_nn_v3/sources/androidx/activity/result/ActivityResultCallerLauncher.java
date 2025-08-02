package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.m;

public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<Unit> {
    private final ActivityResultContract<I, O> callerContract;
    private final I callerInput;
    private final ActivityResultContract<Unit, O> contract = getResultContract();
    private final ActivityResultLauncher<I> launcher;
    private final Lazy resultContract$delegate = i.b(new ActivityResultCallerLauncher$resultContract$2(this));

    public ActivityResultCallerLauncher(ActivityResultLauncher<I> activityResultLauncher, ActivityResultContract<I, O> activityResultContract, I i10) {
        m.f(activityResultLauncher, "launcher");
        m.f(activityResultContract, "callerContract");
        this.launcher = activityResultLauncher;
        this.callerContract = activityResultContract;
        this.callerInput = i10;
    }

    private final ActivityResultContract<Unit, O> getResultContract() {
        return (ActivityResultContract) this.resultContract$delegate.getValue();
    }

    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    public final I getCallerInput() {
        return this.callerInput;
    }

    public ActivityResultContract<Unit, O> getContract() {
        return this.contract;
    }

    public void unregister() {
        this.launcher.unregister();
    }

    public void launch(Unit unit, ActivityOptionsCompat activityOptionsCompat) {
        m.f(unit, "input");
        this.launcher.launch(this.callerInput, activityOptionsCompat);
    }
}
