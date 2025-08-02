package androidx.work.impl.constraints;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;

public class WorkConstraintsTracker implements ConstraintController.OnConstraintUpdatedCallback {
    private static final String TAG = Logger.tagWithPrefix("WorkConstraintsTracker");
    @Nullable
    private final WorkConstraintsCallback mCallback;
    private final ConstraintController<?>[] mConstraintControllers;
    private final Object mLock = new Object();

    public WorkConstraintsTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor, @Nullable WorkConstraintsCallback workConstraintsCallback) {
        Context applicationContext = context.getApplicationContext();
        this.mCallback = workConstraintsCallback;
        this.mConstraintControllers = new ConstraintController[]{new BatteryChargingController(applicationContext, taskExecutor), new BatteryNotLowController(applicationContext, taskExecutor), new StorageNotLowController(applicationContext, taskExecutor), new NetworkConnectedController(applicationContext, taskExecutor), new NetworkUnmeteredController(applicationContext, taskExecutor), new NetworkNotRoamingController(applicationContext, taskExecutor), new NetworkMeteredController(applicationContext, taskExecutor)};
    }

    public boolean areAllConstraintsMet(@NonNull String str) {
        synchronized (this.mLock) {
            try {
                for (ConstraintController<?> constraintController : this.mConstraintControllers) {
                    if (constraintController.isWorkSpecConstrained(str)) {
                        Logger.get().debug(TAG, String.format("Work %s constrained by %s", new Object[]{str, constraintController.getClass().getSimpleName()}), new Throwable[0]);
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onConstraintMet(@NonNull List<String> list) {
        synchronized (this.mLock) {
            try {
                ArrayList arrayList = new ArrayList();
                for (String next : list) {
                    if (areAllConstraintsMet(next)) {
                        Logger.get().debug(TAG, String.format("Constraints met for %s", new Object[]{next}), new Throwable[0]);
                        arrayList.add(next);
                    }
                }
                WorkConstraintsCallback workConstraintsCallback = this.mCallback;
                if (workConstraintsCallback != null) {
                    workConstraintsCallback.onAllConstraintsMet(arrayList);
                }
            } finally {
            }
        }
    }

    public void onConstraintNotMet(@NonNull List<String> list) {
        synchronized (this.mLock) {
            try {
                WorkConstraintsCallback workConstraintsCallback = this.mCallback;
                if (workConstraintsCallback != null) {
                    workConstraintsCallback.onAllConstraintsNotMet(list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void replace(@NonNull Iterable<WorkSpec> iterable) {
        synchronized (this.mLock) {
            try {
                for (ConstraintController<?> callback : this.mConstraintControllers) {
                    callback.setCallback((ConstraintController.OnConstraintUpdatedCallback) null);
                }
                for (ConstraintController<?> replace : this.mConstraintControllers) {
                    replace.replace(iterable);
                }
                for (ConstraintController<?> callback2 : this.mConstraintControllers) {
                    callback2.setCallback(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void reset() {
        synchronized (this.mLock) {
            try {
                for (ConstraintController<?> reset : this.mConstraintControllers) {
                    reset.reset();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    WorkConstraintsTracker(@Nullable WorkConstraintsCallback workConstraintsCallback, ConstraintController<?>[] constraintControllerArr) {
        this.mCallback = workConstraintsCallback;
        this.mConstraintControllers = constraintControllerArr;
    }
}
