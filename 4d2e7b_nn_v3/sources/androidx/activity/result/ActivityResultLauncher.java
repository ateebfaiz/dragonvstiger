package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.core.app.ActivityOptionsCompat;

public abstract class ActivityResultLauncher<I> {
    public abstract ActivityResultContract<I, ?> getContract();

    public void launch(I i10) {
        launch(i10, (ActivityOptionsCompat) null);
    }

    public abstract void launch(I i10, ActivityOptionsCompat activityOptionsCompat);

    @MainThread
    public abstract void unregister();
}
