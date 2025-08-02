package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    boolean mSupportsChangeAnimations = true;

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateAdd(RecyclerView.ViewHolder viewHolder);

    public boolean animateAppearance(@NonNull RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i10;
        int i11;
        if (itemHolderInfo == null || ((i10 = itemHolderInfo.left) == (i11 = itemHolderInfo2.left) && itemHolderInfo.top == itemHolderInfo2.top)) {
            return animateAdd(viewHolder);
        }
        return animateMove(viewHolder, i10, itemHolderInfo.top, i11, itemHolderInfo2.top);
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i10, int i11, int i12, int i13);

    public boolean animateChange(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i10;
        int i11;
        int i12 = itemHolderInfo.left;
        int i13 = itemHolderInfo.top;
        if (viewHolder2.shouldIgnore()) {
            int i14 = itemHolderInfo.left;
            i10 = itemHolderInfo.top;
            i11 = i14;
        } else {
            i11 = itemHolderInfo2.left;
            i10 = itemHolderInfo2.top;
        }
        return animateChange(viewHolder, viewHolder2, i12, i13, i11, i10);
    }

    public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i10;
        int i11;
        int i12 = itemHolderInfo.left;
        int i13 = itemHolderInfo.top;
        View view = viewHolder.itemView;
        if (itemHolderInfo2 == null) {
            i10 = view.getLeft();
        } else {
            i10 = itemHolderInfo2.left;
        }
        int i14 = i10;
        if (itemHolderInfo2 == null) {
            i11 = view.getTop();
        } else {
            i11 = itemHolderInfo2.top;
        }
        int i15 = i11;
        if (viewHolder.isRemoved() || (i12 == i14 && i13 == i15)) {
            return animateRemove(viewHolder);
        }
        view.layout(i14, i15, view.getWidth() + i14, view.getHeight() + i15);
        return animateMove(viewHolder, i12, i13, i14, i15);
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateMove(RecyclerView.ViewHolder viewHolder, int i10, int i11, int i12, int i13);

    public boolean animatePersistence(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i10 = itemHolderInfo.left;
        int i11 = itemHolderInfo2.left;
        if (i10 == i11 && itemHolderInfo.top == itemHolderInfo2.top) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        return animateMove(viewHolder, i10, itemHolderInfo.top, i11, itemHolderInfo2.top);
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean animateRemove(RecyclerView.ViewHolder viewHolder);

    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (!this.mSupportsChangeAnimations || viewHolder.isInvalid()) {
            return true;
        }
        return false;
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchAddFinished(RecyclerView.ViewHolder viewHolder) {
        onAddFinished(viewHolder);
        dispatchAnimationFinished(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchAddStarting(RecyclerView.ViewHolder viewHolder) {
        onAddStarting(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchChangeFinished(RecyclerView.ViewHolder viewHolder, boolean z10) {
        onChangeFinished(viewHolder, z10);
        dispatchAnimationFinished(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchChangeStarting(RecyclerView.ViewHolder viewHolder, boolean z10) {
        onChangeStarting(viewHolder, z10);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchMoveFinished(RecyclerView.ViewHolder viewHolder) {
        onMoveFinished(viewHolder);
        dispatchAnimationFinished(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchMoveStarting(RecyclerView.ViewHolder viewHolder) {
        onMoveStarting(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchRemoveFinished(RecyclerView.ViewHolder viewHolder) {
        onRemoveFinished(viewHolder);
        dispatchAnimationFinished(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void dispatchRemoveStarting(RecyclerView.ViewHolder viewHolder) {
        onRemoveStarting(viewHolder);
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    @SuppressLint({"UnknownNullness"})
    public void onAddFinished(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onAddStarting(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onChangeFinished(RecyclerView.ViewHolder viewHolder, boolean z10) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onChangeStarting(RecyclerView.ViewHolder viewHolder, boolean z10) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onMoveFinished(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onMoveStarting(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
    }

    public void setSupportsChangeAnimations(boolean z10) {
        this.mSupportsChangeAnimations = z10;
    }
}
