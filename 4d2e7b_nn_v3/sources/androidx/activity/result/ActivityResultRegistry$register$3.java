package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;

public final class ActivityResultRegistry$register$3 extends ActivityResultLauncher<I> {
    final /* synthetic */ ActivityResultContract<I, O> $contract;
    final /* synthetic */ String $key;
    final /* synthetic */ ActivityResultRegistry this$0;

    ActivityResultRegistry$register$3(ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract<I, O> activityResultContract) {
        this.this$0 = activityResultRegistry;
        this.$key = str;
        this.$contract = activityResultContract;
    }

    public ActivityResultContract<I, ?> getContract() {
        return this.$contract;
    }

    public void launch(I i10, ActivityOptionsCompat activityOptionsCompat) {
        Object obj = this.this$0.keyToRc.get(this.$key);
        ActivityResultContract<I, O> activityResultContract = this.$contract;
        if (obj != null) {
            int intValue = ((Number) obj).intValue();
            this.this$0.launchedKeys.add(this.$key);
            try {
                this.this$0.onLaunch(intValue, this.$contract, i10, activityOptionsCompat);
            } catch (Exception e10) {
                this.this$0.launchedKeys.remove(this.$key);
                throw e10;
            }
        } else {
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + i10 + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }
    }

    public void unregister() {
        this.this$0.unregister$activity_release(this.$key);
    }
}
