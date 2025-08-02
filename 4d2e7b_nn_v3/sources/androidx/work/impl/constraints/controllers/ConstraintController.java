package androidx.work.impl.constraints.controllers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class ConstraintController<T> implements ConstraintListener<T> {
    private OnConstraintUpdatedCallback mCallback;
    private T mCurrentValue;
    private final List<String> mMatchingWorkSpecIds = new ArrayList();
    private ConstraintTracker<T> mTracker;

    public interface OnConstraintUpdatedCallback {
        void onConstraintMet(@NonNull List<String> list);

        void onConstraintNotMet(@NonNull List<String> list);
    }

    ConstraintController(ConstraintTracker<T> constraintTracker) {
        this.mTracker = constraintTracker;
    }

    private void updateCallback(@Nullable OnConstraintUpdatedCallback onConstraintUpdatedCallback, @Nullable T t10) {
        if (!this.mMatchingWorkSpecIds.isEmpty() && onConstraintUpdatedCallback != null) {
            if (t10 == null || isConstrained(t10)) {
                onConstraintUpdatedCallback.onConstraintNotMet(this.mMatchingWorkSpecIds);
            } else {
                onConstraintUpdatedCallback.onConstraintMet(this.mMatchingWorkSpecIds);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract boolean hasConstraint(@NonNull WorkSpec workSpec);

    /* access modifiers changed from: package-private */
    public abstract boolean isConstrained(@NonNull T t10);

    public boolean isWorkSpecConstrained(@NonNull String str) {
        T t10 = this.mCurrentValue;
        if (t10 == null || !isConstrained(t10) || !this.mMatchingWorkSpecIds.contains(str)) {
            return false;
        }
        return true;
    }

    public void onConstraintChanged(@Nullable T t10) {
        this.mCurrentValue = t10;
        updateCallback(this.mCallback, t10);
    }

    public void replace(@NonNull Iterable<WorkSpec> iterable) {
        this.mMatchingWorkSpecIds.clear();
        for (WorkSpec next : iterable) {
            if (hasConstraint(next)) {
                this.mMatchingWorkSpecIds.add(next.f17025id);
            }
        }
        if (this.mMatchingWorkSpecIds.isEmpty()) {
            this.mTracker.removeListener(this);
        } else {
            this.mTracker.addListener(this);
        }
        updateCallback(this.mCallback, this.mCurrentValue);
    }

    public void reset() {
        if (!this.mMatchingWorkSpecIds.isEmpty()) {
            this.mMatchingWorkSpecIds.clear();
            this.mTracker.removeListener(this);
        }
    }

    public void setCallback(@Nullable OnConstraintUpdatedCallback onConstraintUpdatedCallback) {
        if (this.mCallback != onConstraintUpdatedCallback) {
            this.mCallback = onConstraintUpdatedCallback;
            updateCallback(onConstraintUpdatedCallback, this.mCurrentValue);
        }
    }
}
