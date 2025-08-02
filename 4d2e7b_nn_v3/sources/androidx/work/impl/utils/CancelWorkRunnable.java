package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.LinkedList;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class CancelWorkRunnable implements Runnable {
    private final OperationImpl mOperation = new OperationImpl();

    class a extends CancelWorkRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WorkManagerImpl f17052a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UUID f17053b;

        a(WorkManagerImpl workManagerImpl, UUID uuid) {
            this.f17052a = workManagerImpl;
            this.f17053b = uuid;
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        public void runInternal() {
            WorkDatabase workDatabase = this.f17052a.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                cancel(this.f17052a, this.f17053b.toString());
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                reschedulePendingWorkers(this.f17052a);
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    class b extends CancelWorkRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WorkManagerImpl f17054a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17055b;

        b(WorkManagerImpl workManagerImpl, String str) {
            this.f17054a = workManagerImpl;
            this.f17055b = str;
        }

        /* access modifiers changed from: package-private */
        public void runInternal() {
            WorkDatabase workDatabase = this.f17054a.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                for (String cancel : workDatabase.workSpecDao().getUnfinishedWorkWithTag(this.f17055b)) {
                    cancel(this.f17054a, cancel);
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                reschedulePendingWorkers(this.f17054a);
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    class c extends CancelWorkRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WorkManagerImpl f17056a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17057b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f17058c;

        c(WorkManagerImpl workManagerImpl, String str, boolean z10) {
            this.f17056a = workManagerImpl;
            this.f17057b = str;
            this.f17058c = z10;
        }

        /* access modifiers changed from: package-private */
        public void runInternal() {
            WorkDatabase workDatabase = this.f17056a.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                for (String cancel : workDatabase.workSpecDao().getUnfinishedWorkWithName(this.f17057b)) {
                    cancel(this.f17056a, cancel);
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (this.f17058c) {
                    reschedulePendingWorkers(this.f17056a);
                }
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    class d extends CancelWorkRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WorkManagerImpl f17059a;

        d(WorkManagerImpl workManagerImpl) {
            this.f17059a = workManagerImpl;
        }

        /* access modifiers changed from: package-private */
        public void runInternal() {
            WorkDatabase workDatabase = this.f17059a.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                for (String cancel : workDatabase.workSpecDao().getAllUnfinishedWork()) {
                    cancel(this.f17059a, cancel);
                }
                new PreferenceUtils(this.f17059a.getWorkDatabase()).setLastCancelAllTimeMillis(System.currentTimeMillis());
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    public static CancelWorkRunnable forAll(@NonNull WorkManagerImpl workManagerImpl) {
        return new d(workManagerImpl);
    }

    public static CancelWorkRunnable forId(@NonNull UUID uuid, @NonNull WorkManagerImpl workManagerImpl) {
        return new a(workManagerImpl, uuid);
    }

    public static CancelWorkRunnable forName(@NonNull String str, @NonNull WorkManagerImpl workManagerImpl, boolean z10) {
        return new c(workManagerImpl, str, z10);
    }

    public static CancelWorkRunnable forTag(@NonNull String str, @NonNull WorkManagerImpl workManagerImpl) {
        return new b(workManagerImpl, str);
    }

    private void iterativelyCancelWorkAndDependents(WorkDatabase workDatabase, String str) {
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        DependencyDao dependencyDao = workDatabase.dependencyDao();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo.State state = workSpecDao.getState(str2);
            if (!(state == WorkInfo.State.SUCCEEDED || state == WorkInfo.State.FAILED)) {
                workSpecDao.setState(WorkInfo.State.CANCELLED, str2);
            }
            linkedList.addAll(dependencyDao.getDependentWorkIds(str2));
        }
    }

    /* access modifiers changed from: package-private */
    public void cancel(WorkManagerImpl workManagerImpl, String str) {
        iterativelyCancelWorkAndDependents(workManagerImpl.getWorkDatabase(), str);
        workManagerImpl.getProcessor().stopAndCancelWork(str);
        for (Scheduler cancel : workManagerImpl.getSchedulers()) {
            cancel.cancel(str);
        }
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    /* access modifiers changed from: package-private */
    public void reschedulePendingWorkers(WorkManagerImpl workManagerImpl) {
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    public void run() {
        try {
            runInternal();
            this.mOperation.setState(Operation.SUCCESS);
        } catch (Throwable th) {
            this.mOperation.setState(new Operation.State.FAILURE(th));
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void runInternal();
}
