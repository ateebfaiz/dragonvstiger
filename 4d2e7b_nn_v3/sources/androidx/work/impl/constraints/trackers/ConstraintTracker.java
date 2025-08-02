package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ConstraintTracker<T> {
    private static final String TAG = Logger.tagWithPrefix("ConstraintTracker");
    protected final Context mAppContext;
    T mCurrentState;
    private final Set<ConstraintListener<T>> mListeners = new LinkedHashSet();
    private final Object mLock = new Object();
    protected final TaskExecutor mTaskExecutor;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f16997a;

        a(List list) {
            this.f16997a = list;
        }

        public void run() {
            for (ConstraintListener onConstraintChanged : this.f16997a) {
                onConstraintChanged.onConstraintChanged(ConstraintTracker.this.mCurrentState);
            }
        }
    }

    ConstraintTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        this.mAppContext = context.getApplicationContext();
        this.mTaskExecutor = taskExecutor;
    }

    public void addListener(ConstraintListener<T> constraintListener) {
        synchronized (this.mLock) {
            try {
                if (this.mListeners.add(constraintListener)) {
                    if (this.mListeners.size() == 1) {
                        this.mCurrentState = getInitialState();
                        Logger.get().debug(TAG, String.format("%s: initial state = %s", new Object[]{getClass().getSimpleName(), this.mCurrentState}), new Throwable[0]);
                        startTracking();
                    }
                    constraintListener.onConstraintChanged(this.mCurrentState);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract T getInitialState();

    public void removeListener(ConstraintListener<T> constraintListener) {
        synchronized (this.mLock) {
            try {
                if (this.mListeners.remove(constraintListener) && this.mListeners.isEmpty()) {
                    stopTracking();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setState(T r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock
            monitor-enter(r0)
            T r1 = r3.mCurrentState     // Catch:{ all -> 0x0010 }
            if (r1 == r4) goto L_0x002b
            if (r1 == 0) goto L_0x0012
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0010 }
            if (r1 == 0) goto L_0x0012
            goto L_0x002b
        L_0x0010:
            r4 = move-exception
            goto L_0x002d
        L_0x0012:
            r3.mCurrentState = r4     // Catch:{ all -> 0x0010 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0010 }
            java.util.Set<androidx.work.impl.constraints.ConstraintListener<T>> r1 = r3.mListeners     // Catch:{ all -> 0x0010 }
            r4.<init>(r1)     // Catch:{ all -> 0x0010 }
            androidx.work.impl.utils.taskexecutor.TaskExecutor r1 = r3.mTaskExecutor     // Catch:{ all -> 0x0010 }
            java.util.concurrent.Executor r1 = r1.getMainThreadExecutor()     // Catch:{ all -> 0x0010 }
            androidx.work.impl.constraints.trackers.ConstraintTracker$a r2 = new androidx.work.impl.constraints.trackers.ConstraintTracker$a     // Catch:{ all -> 0x0010 }
            r2.<init>(r4)     // Catch:{ all -> 0x0010 }
            r1.execute(r2)     // Catch:{ all -> 0x0010 }
            monitor-exit(r0)     // Catch:{ all -> 0x0010 }
            return
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x0010 }
            return
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x0010 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.ConstraintTracker.setState(java.lang.Object):void");
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
