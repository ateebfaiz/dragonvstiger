package androidx.work.impl.background.greedy;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DelayedWorkTracker {
    static final String TAG = Logger.tagWithPrefix("DelayedWorkTracker");
    final GreedyScheduler mGreedyScheduler;
    private final RunnableScheduler mRunnableScheduler;
    private final Map<String, Runnable> mRunnables = new HashMap();

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WorkSpec f16976a;

        a(WorkSpec workSpec) {
            this.f16976a = workSpec;
        }

        public void run() {
            Logger.get().debug(DelayedWorkTracker.TAG, String.format("Scheduling work %s", new Object[]{this.f16976a.f17025id}), new Throwable[0]);
            DelayedWorkTracker.this.mGreedyScheduler.schedule(this.f16976a);
        }
    }

    public DelayedWorkTracker(@NonNull GreedyScheduler greedyScheduler, @NonNull RunnableScheduler runnableScheduler) {
        this.mGreedyScheduler = greedyScheduler;
        this.mRunnableScheduler = runnableScheduler;
    }

    public void schedule(@NonNull WorkSpec workSpec) {
        Runnable remove = this.mRunnables.remove(workSpec.f17025id);
        if (remove != null) {
            this.mRunnableScheduler.cancel(remove);
        }
        a aVar = new a(workSpec);
        this.mRunnables.put(workSpec.f17025id, aVar);
        long currentTimeMillis = System.currentTimeMillis();
        this.mRunnableScheduler.scheduleWithDelay(workSpec.calculateNextRunTime() - currentTimeMillis, aVar);
    }

    public void unschedule(@NonNull String str) {
        Runnable remove = this.mRunnables.remove(str);
        if (remove != null) {
            this.mRunnableScheduler.cancel(remove);
        }
    }
}
