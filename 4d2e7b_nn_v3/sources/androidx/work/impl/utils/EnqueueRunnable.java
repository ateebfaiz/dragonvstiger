package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class EnqueueRunnable implements Runnable {
    private static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    private final OperationImpl mOperation = new OperationImpl();
    private final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(@NonNull WorkContinuationImpl workContinuationImpl) {
        this.mWorkContinuation = workContinuationImpl;
    }

    private static boolean enqueueContinuation(@NonNull WorkContinuationImpl workContinuationImpl) {
        boolean enqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), (String[]) WorkContinuationImpl.prerequisitesFor(workContinuationImpl).toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return enqueueWorkWithPrerequisites;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl r16, @androidx.annotation.NonNull java.util.List<? extends androidx.work.WorkRequest> r17, java.lang.String[] r18, java.lang.String r19, androidx.work.ExistingWorkPolicy r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            long r3 = java.lang.System.currentTimeMillis()
            androidx.work.impl.WorkDatabase r5 = r16.getWorkDatabase()
            r6 = 1
            r7 = 0
            if (r0 == 0) goto L_0x0017
            int r8 = r0.length
            if (r8 <= 0) goto L_0x0017
            r8 = r6
            goto L_0x0018
        L_0x0017:
            r8 = r7
        L_0x0018:
            if (r8 == 0) goto L_0x005a
            int r9 = r0.length
            r11 = r6
            r10 = r7
            r12 = r10
            r13 = r12
        L_0x001f:
            if (r10 >= r9) goto L_0x005d
            r14 = r0[r10]
            androidx.work.impl.model.WorkSpecDao r15 = r5.workSpecDao()
            androidx.work.impl.model.WorkSpec r15 = r15.getWorkSpec(r14)
            if (r15 != 0) goto L_0x0043
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r1 = TAG
            java.lang.String r2 = "Prerequisite %s doesn't exist; not enqueuing"
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r3[r7] = r14
            java.lang.String r2 = java.lang.String.format(r2, r3)
            java.lang.Throwable[] r3 = new java.lang.Throwable[r7]
            r0.error(r1, r2, r3)
            return r7
        L_0x0043:
            androidx.work.WorkInfo$State r14 = r15.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r14 != r15) goto L_0x004b
            r15 = r6
            goto L_0x004c
        L_0x004b:
            r15 = r7
        L_0x004c:
            r11 = r11 & r15
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            if (r14 != r15) goto L_0x0053
            r13 = r6
            goto L_0x0058
        L_0x0053:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            if (r14 != r15) goto L_0x0058
            r12 = r6
        L_0x0058:
            int r10 = r10 + r6
            goto L_0x001f
        L_0x005a:
            r11 = r6
            r12 = r7
            r13 = r12
        L_0x005d:
            boolean r9 = android.text.TextUtils.isEmpty(r19)
            r9 = r9 ^ r6
            if (r9 == 0) goto L_0x0136
            if (r8 != 0) goto L_0x0136
            androidx.work.impl.model.WorkSpecDao r10 = r5.workSpecDao()
            java.util.List r10 = r10.getWorkSpecIdAndStatesForName(r1)
            boolean r14 = r10.isEmpty()
            if (r14 != 0) goto L_0x0136
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND
            if (r2 == r14) goto L_0x00bf
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r14) goto L_0x007d
            goto L_0x00bf
        L_0x007d:
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.KEEP
            if (r2 != r14) goto L_0x009c
            java.util.Iterator r2 = r10.iterator()
        L_0x0085:
            boolean r14 = r2.hasNext()
            if (r14 == 0) goto L_0x009c
            java.lang.Object r14 = r2.next()
            androidx.work.impl.model.WorkSpec$IdAndState r14 = (androidx.work.impl.model.WorkSpec.IdAndState) r14
            androidx.work.WorkInfo$State r14 = r14.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.ENQUEUED
            if (r14 == r15) goto L_0x009b
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.RUNNING
            if (r14 != r15) goto L_0x0085
        L_0x009b:
            return r7
        L_0x009c:
            r2 = r16
            androidx.work.impl.utils.CancelWorkRunnable r2 = androidx.work.impl.utils.CancelWorkRunnable.forName(r1, r2, r7)
            r2.run()
            androidx.work.impl.model.WorkSpecDao r2 = r5.workSpecDao()
            java.util.Iterator r10 = r10.iterator()
        L_0x00ad:
            boolean r14 = r10.hasNext()
            if (r14 == 0) goto L_0x0137
            java.lang.Object r14 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r14 = (androidx.work.impl.model.WorkSpec.IdAndState) r14
            java.lang.String r14 = r14.f17026id
            r2.delete(r14)
            goto L_0x00ad
        L_0x00bf:
            androidx.work.impl.model.DependencyDao r8 = r5.dependencyDao()
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00cc:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x00fe
            java.lang.Object r15 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r15 = (androidx.work.impl.model.WorkSpec.IdAndState) r15
            java.lang.String r7 = r15.f17026id
            boolean r7 = r8.hasDependents(r7)
            if (r7 != 0) goto L_0x00fb
            androidx.work.WorkInfo$State r7 = r15.state
            androidx.work.WorkInfo$State r6 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r7 != r6) goto L_0x00e8
            r6 = 1
            goto L_0x00e9
        L_0x00e8:
            r6 = 0
        L_0x00e9:
            r6 = r6 & r11
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.FAILED
            if (r7 != r11) goto L_0x00f0
            r13 = 1
            goto L_0x00f5
        L_0x00f0:
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.CANCELLED
            if (r7 != r11) goto L_0x00f5
            r12 = 1
        L_0x00f5:
            java.lang.String r7 = r15.f17026id
            r14.add(r7)
            r11 = r6
        L_0x00fb:
            r6 = 1
            r7 = 0
            goto L_0x00cc
        L_0x00fe:
            androidx.work.ExistingWorkPolicy r6 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r6) goto L_0x012a
            if (r12 != 0) goto L_0x0106
            if (r13 == 0) goto L_0x012a
        L_0x0106:
            androidx.work.impl.model.WorkSpecDao r2 = r5.workSpecDao()
            java.util.List r6 = r2.getWorkSpecIdAndStatesForName(r1)
            java.util.Iterator r6 = r6.iterator()
        L_0x0112:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0124
            java.lang.Object r7 = r6.next()
            androidx.work.impl.model.WorkSpec$IdAndState r7 = (androidx.work.impl.model.WorkSpec.IdAndState) r7
            java.lang.String r7 = r7.f17026id
            r2.delete(r7)
            goto L_0x0112
        L_0x0124:
            java.util.List r14 = java.util.Collections.emptyList()
            r12 = 0
            r13 = 0
        L_0x012a:
            java.lang.Object[] r0 = r14.toArray(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            int r2 = r0.length
            if (r2 <= 0) goto L_0x0135
            r8 = 1
            goto L_0x0136
        L_0x0135:
            r8 = 0
        L_0x0136:
            r6 = 0
        L_0x0137:
            java.util.Iterator r2 = r17.iterator()
        L_0x013b:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x01ec
            java.lang.Object r7 = r2.next()
            androidx.work.WorkRequest r7 = (androidx.work.WorkRequest) r7
            androidx.work.impl.model.WorkSpec r10 = r7.getWorkSpec()
            if (r8 == 0) goto L_0x0162
            if (r11 != 0) goto L_0x0162
            if (r13 == 0) goto L_0x0156
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo.State.FAILED
            r10.state = r14
            goto L_0x016f
        L_0x0156:
            if (r12 == 0) goto L_0x015d
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo.State.CANCELLED
            r10.state = r14
            goto L_0x016f
        L_0x015d:
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo.State.BLOCKED
            r10.state = r14
            goto L_0x016f
        L_0x0162:
            boolean r14 = r10.isPeriodic()
            if (r14 != 0) goto L_0x016b
            r10.periodStartTime = r3
            goto L_0x016f
        L_0x016b:
            r14 = 0
            r10.periodStartTime = r14
        L_0x016f:
            int r14 = android.os.Build.VERSION.SDK_INT
            r15 = 25
            if (r14 > r15) goto L_0x0178
            tryDelegateConstrainedWorkSpec(r10)
        L_0x0178:
            androidx.work.WorkInfo$State r14 = r10.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.ENQUEUED
            if (r14 != r15) goto L_0x017f
            r6 = 1
        L_0x017f:
            androidx.work.impl.model.WorkSpecDao r14 = r5.workSpecDao()
            r14.insertWorkSpec(r10)
            if (r8 == 0) goto L_0x01a9
            int r10 = r0.length
            r14 = 0
        L_0x018a:
            if (r14 >= r10) goto L_0x01a9
            r15 = r0[r14]
            r16 = r0
            androidx.work.impl.model.Dependency r0 = new androidx.work.impl.model.Dependency
            r17 = r2
            java.lang.String r2 = r7.getStringId()
            r0.<init>(r2, r15)
            androidx.work.impl.model.DependencyDao r2 = r5.dependencyDao()
            r2.insertDependency(r0)
            r0 = 1
            int r14 = r14 + r0
            r0 = r16
            r2 = r17
            goto L_0x018a
        L_0x01a9:
            r16 = r0
            r17 = r2
            r0 = 1
            java.util.Set r2 = r7.getTags()
            java.util.Iterator r2 = r2.iterator()
        L_0x01b6:
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto L_0x01d4
            java.lang.Object r10 = r2.next()
            java.lang.String r10 = (java.lang.String) r10
            androidx.work.impl.model.WorkTagDao r14 = r5.workTagDao()
            androidx.work.impl.model.WorkTag r15 = new androidx.work.impl.model.WorkTag
            java.lang.String r0 = r7.getStringId()
            r15.<init>(r10, r0)
            r14.insert(r15)
            r0 = 1
            goto L_0x01b6
        L_0x01d4:
            if (r9 == 0) goto L_0x01e6
            androidx.work.impl.model.WorkNameDao r0 = r5.workNameDao()
            androidx.work.impl.model.WorkName r2 = new androidx.work.impl.model.WorkName
            java.lang.String r7 = r7.getStringId()
            r2.<init>(r1, r7)
            r0.insert(r2)
        L_0x01e6:
            r0 = r16
            r2 = r17
            goto L_0x013b
        L_0x01ec:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static boolean processContinuation(@NonNull WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        boolean z10 = false;
        if (parents != null) {
            boolean z11 = false;
            for (WorkContinuationImpl next : parents) {
                if (!next.isEnqueued()) {
                    z11 |= processContinuation(next);
                } else {
                    Logger.get().warning(TAG, String.format("Already enqueued work ids (%s).", new Object[]{TextUtils.join(", ", next.getIds())}), new Throwable[0]);
                }
            }
            z10 = z11;
        }
        return enqueueContinuation(workContinuationImpl) | z10;
    }

    private static void tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        Constraints constraints = workSpec.constraints;
        String str = workSpec.workerClassName;
        Class<ConstraintTrackingWorker> cls = ConstraintTrackingWorker.class;
        if (str.equals(cls.getName())) {
            return;
        }
        if (constraints.requiresBatteryNotLow() || constraints.requiresStorageNotLow()) {
            Data.Builder builder = new Data.Builder();
            builder.putAll(workSpec.input).putString(ConstraintTrackingWorker.ARGUMENT_CLASS_NAME, str);
            workSpec.workerClassName = cls.getName();
            workSpec.input = builder.build();
        }
    }

    private static boolean usesScheduler(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (Scheduler scheduler : workManagerImpl.getSchedulers()) {
                if (cls.isAssignableFrom(scheduler.getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    @VisibleForTesting
    public boolean addToDatabase() {
        WorkDatabase workDatabase = this.mWorkContinuation.getWorkManagerImpl().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            boolean processContinuation = processContinuation(this.mWorkContinuation);
            workDatabase.setTransactionSuccessful();
            return processContinuation;
        } finally {
            workDatabase.endTransaction();
        }
    }

    @NonNull
    public Operation getOperation() {
        return this.mOperation;
    }

    public void run() {
        try {
            if (!this.mWorkContinuation.hasCycles()) {
                if (addToDatabase()) {
                    PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                    scheduleWorkInBackground();
                }
                this.mOperation.setState(Operation.SUCCESS);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[]{this.mWorkContinuation}));
        } catch (Throwable th) {
            this.mOperation.setState(new Operation.State.FAILURE(th));
        }
    }

    @VisibleForTesting
    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }
}
