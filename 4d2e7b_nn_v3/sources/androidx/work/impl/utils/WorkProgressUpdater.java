package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkProgressUpdater implements ProgressUpdater {
    static final String TAG = Logger.tagWithPrefix("WorkProgressUpdater");
    final TaskExecutor mTaskExecutor;
    final WorkDatabase mWorkDatabase;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UUID f17089a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Data f17090b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SettableFuture f17091c;

        a(UUID uuid, Data data, SettableFuture settableFuture) {
            this.f17089a = uuid;
            this.f17090b = data;
            this.f17091c = settableFuture;
        }

        public void run() {
            String uuid = this.f17089a.toString();
            Logger logger = Logger.get();
            String str = WorkProgressUpdater.TAG;
            logger.debug(str, String.format("Updating progress for %s (%s)", new Object[]{this.f17089a, this.f17090b}), new Throwable[0]);
            WorkProgressUpdater.this.mWorkDatabase.beginTransaction();
            try {
                WorkSpec workSpec = WorkProgressUpdater.this.mWorkDatabase.workSpecDao().getWorkSpec(uuid);
                if (workSpec != null) {
                    if (workSpec.state == WorkInfo.State.RUNNING) {
                        WorkProgressUpdater.this.mWorkDatabase.workProgressDao().insert(new WorkProgress(uuid, this.f17090b));
                    } else {
                        Logger.get().warning(str, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", new Object[]{uuid}), new Throwable[0]);
                    }
                    this.f17091c.set(null);
                    WorkProgressUpdater.this.mWorkDatabase.setTransactionSuccessful();
                    WorkProgressUpdater.this.mWorkDatabase.endTransaction();
                    return;
                }
                throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
            } catch (Throwable th) {
                WorkProgressUpdater.this.mWorkDatabase.endTransaction();
                throw th;
            }
        }
    }

    public WorkProgressUpdater(@NonNull WorkDatabase workDatabase, @NonNull TaskExecutor taskExecutor) {
        this.mWorkDatabase = workDatabase;
        this.mTaskExecutor = taskExecutor;
    }

    @NonNull
    public ListenableFuture<Void> updateProgress(@NonNull Context context, @NonNull UUID uuid, @NonNull Data data) {
        SettableFuture create = SettableFuture.create();
        this.mTaskExecutor.executeOnBackgroundThread(new a(uuid, data, create));
        return create;
    }
}
