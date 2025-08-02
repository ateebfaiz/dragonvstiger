package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkForegroundUpdater implements ForegroundUpdater {
    private static final String TAG = Logger.tagWithPrefix("WMFgUpdater");
    final ForegroundProcessor mForegroundProcessor;
    private final TaskExecutor mTaskExecutor;
    final WorkSpecDao mWorkSpecDao;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SettableFuture f17084a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UUID f17085b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ForegroundInfo f17086c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f17087d;

        a(SettableFuture settableFuture, UUID uuid, ForegroundInfo foregroundInfo, Context context) {
            this.f17084a = settableFuture;
            this.f17085b = uuid;
            this.f17086c = foregroundInfo;
            this.f17087d = context;
        }

        public void run() {
            try {
                if (!this.f17084a.isCancelled()) {
                    String uuid = this.f17085b.toString();
                    WorkInfo.State state = WorkForegroundUpdater.this.mWorkSpecDao.getState(uuid);
                    if (state == null || state.isFinished()) {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    WorkForegroundUpdater.this.mForegroundProcessor.startForeground(uuid, this.f17086c);
                    this.f17087d.startService(SystemForegroundDispatcher.createNotifyIntent(this.f17087d, uuid, this.f17086c));
                }
                this.f17084a.set(null);
            } catch (Throwable th) {
                this.f17084a.setException(th);
            }
        }
    }

    public WorkForegroundUpdater(@NonNull WorkDatabase workDatabase, @NonNull ForegroundProcessor foregroundProcessor, @NonNull TaskExecutor taskExecutor) {
        this.mForegroundProcessor = foregroundProcessor;
        this.mTaskExecutor = taskExecutor;
        this.mWorkSpecDao = workDatabase.workSpecDao();
    }

    @NonNull
    public ListenableFuture<Void> setForegroundAsync(@NonNull Context context, @NonNull UUID uuid, @NonNull ForegroundInfo foregroundInfo) {
        SettableFuture create = SettableFuture.create();
        this.mTaskExecutor.executeOnBackgroundThread(new a(create, uuid, foregroundInfo, context));
        return create;
    }
}
