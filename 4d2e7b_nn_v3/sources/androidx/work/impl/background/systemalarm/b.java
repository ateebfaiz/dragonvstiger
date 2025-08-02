package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;

class b {

    /* renamed from: e  reason: collision with root package name */
    private static final String f16988e = Logger.tagWithPrefix("ConstraintsCmdHandler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f16989a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16990b;

    /* renamed from: c  reason: collision with root package name */
    private final SystemAlarmDispatcher f16991c;

    /* renamed from: d  reason: collision with root package name */
    private final WorkConstraintsTracker f16992d;

    b(Context context, int i10, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.f16989a = context;
        this.f16990b = i10;
        this.f16991c = systemAlarmDispatcher;
        this.f16992d = new WorkConstraintsTracker(context, systemAlarmDispatcher.getTaskExecutor(), (WorkConstraintsCallback) null);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        List<WorkSpec> scheduledWork = this.f16991c.getWorkManager().getWorkDatabase().workSpecDao().getScheduledWork();
        ConstraintProxy.updateAll(this.f16989a, scheduledWork);
        this.f16992d.replace(scheduledWork);
        ArrayList<WorkSpec> arrayList = new ArrayList<>(scheduledWork.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (WorkSpec next : scheduledWork) {
            String str = next.f17025id;
            if (currentTimeMillis >= next.calculateNextRunTime() && (!next.hasConstraints() || this.f16992d.areAllConstraintsMet(str))) {
                arrayList.add(next);
            }
        }
        for (WorkSpec workSpec : arrayList) {
            String str2 = workSpec.f17025id;
            Intent createDelayMetIntent = CommandHandler.createDelayMetIntent(this.f16989a, str2);
            Logger.get().debug(f16988e, String.format("Creating a delay_met command for workSpec with id (%s)", new Object[]{str2}), new Throwable[0]);
            SystemAlarmDispatcher systemAlarmDispatcher = this.f16991c;
            systemAlarmDispatcher.postOnMainThread(new SystemAlarmDispatcher.b(systemAlarmDispatcher, createDelayMetIntent, this.f16990b));
        }
        this.f16992d.reset();
    }
}
