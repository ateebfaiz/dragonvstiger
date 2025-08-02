package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class StatusRunnable<T> implements Runnable {
    private final SettableFuture<T> mFuture = SettableFuture.create();

    class a extends StatusRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WorkManagerImpl f17070a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f17071b;

        a(WorkManagerImpl workManagerImpl, List list) {
            this.f17070a = workManagerImpl;
            this.f17071b = list;
        }

        /* renamed from: a */
        public List runInternal() {
            return WorkSpec.WORK_INFO_MAPPER.apply(this.f17070a.getWorkDatabase().workSpecDao().getWorkStatusPojoForIds(this.f17071b));
        }
    }

    class b extends StatusRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WorkManagerImpl f17072a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UUID f17073b;

        b(WorkManagerImpl workManagerImpl, UUID uuid) {
            this.f17072a = workManagerImpl;
            this.f17073b = uuid;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public WorkInfo runInternal() {
            WorkSpec.WorkInfoPojo workStatusPojoForId = this.f17072a.getWorkDatabase().workSpecDao().getWorkStatusPojoForId(this.f17073b.toString());
            if (workStatusPojoForId != null) {
                return workStatusPojoForId.toWorkInfo();
            }
            return null;
        }
    }

    class c extends StatusRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WorkManagerImpl f17074a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17075b;

        c(WorkManagerImpl workManagerImpl, String str) {
            this.f17074a = workManagerImpl;
            this.f17075b = str;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public List runInternal() {
            return WorkSpec.WORK_INFO_MAPPER.apply(this.f17074a.getWorkDatabase().workSpecDao().getWorkStatusPojoForTag(this.f17075b));
        }
    }

    class d extends StatusRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WorkManagerImpl f17076a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17077b;

        d(WorkManagerImpl workManagerImpl, String str) {
            this.f17076a = workManagerImpl;
            this.f17077b = str;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public List runInternal() {
            return WorkSpec.WORK_INFO_MAPPER.apply(this.f17076a.getWorkDatabase().workSpecDao().getWorkStatusPojoForName(this.f17077b));
        }
    }

    class e extends StatusRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WorkManagerImpl f17078a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WorkQuery f17079b;

        e(WorkManagerImpl workManagerImpl, WorkQuery workQuery) {
            this.f17078a = workManagerImpl;
            this.f17079b = workQuery;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public List runInternal() {
            return WorkSpec.WORK_INFO_MAPPER.apply(this.f17078a.getWorkDatabase().rawWorkInfoDao().getWorkInfoPojos(RawQueries.workQueryToRawQuery(this.f17079b)));
        }
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forStringIds(@NonNull WorkManagerImpl workManagerImpl, @NonNull List<String> list) {
        return new a(workManagerImpl, list);
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forTag(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        return new c(workManagerImpl, str);
    }

    @NonNull
    public static StatusRunnable<WorkInfo> forUUID(@NonNull WorkManagerImpl workManagerImpl, @NonNull UUID uuid) {
        return new b(workManagerImpl, uuid);
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forUniqueWork(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        return new d(workManagerImpl, str);
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forWorkQuerySpec(@NonNull WorkManagerImpl workManagerImpl, @NonNull WorkQuery workQuery) {
        return new e(workManagerImpl, workQuery);
    }

    @NonNull
    public ListenableFuture<T> getFuture() {
        return this.mFuture;
    }

    public void run() {
        try {
            this.mFuture.set(runInternal());
        } catch (Throwable th) {
            this.mFuture.setException(th);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public abstract T runInternal();
}
