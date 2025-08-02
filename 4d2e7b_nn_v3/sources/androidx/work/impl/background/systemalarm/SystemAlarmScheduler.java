package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemAlarmScheduler implements Scheduler {
    private static final String TAG = Logger.tagWithPrefix("SystemAlarmScheduler");
    private final Context mContext;

    public SystemAlarmScheduler(@NonNull Context context) {
        this.mContext = context.getApplicationContext();
    }

    private void scheduleWorkSpec(@NonNull WorkSpec workSpec) {
        Logger.get().debug(TAG, String.format("Scheduling work with workSpecId %s", new Object[]{workSpec.f17025id}), new Throwable[0]);
        this.mContext.startService(CommandHandler.createScheduleWorkIntent(this.mContext, workSpec.f17025id));
    }

    public void cancel(@NonNull String str) {
        this.mContext.startService(CommandHandler.createStopWorkIntent(this.mContext, str));
    }

    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    public void schedule(@NonNull WorkSpec... workSpecArr) {
        for (WorkSpec scheduleWorkSpec : workSpecArr) {
            scheduleWorkSpec(scheduleWorkSpec);
        }
    }
}
