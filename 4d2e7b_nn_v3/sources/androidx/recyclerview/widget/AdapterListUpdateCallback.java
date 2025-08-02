package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public final class AdapterListUpdateCallback implements ListUpdateCallback {
    @NonNull
    private final RecyclerView.Adapter mAdapter;

    public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i10, int i11, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i10, i11, obj);
    }

    public void onInserted(int i10, int i11) {
        this.mAdapter.notifyItemRangeInserted(i10, i11);
    }

    public void onMoved(int i10, int i11) {
        this.mAdapter.notifyItemMoved(i10, i11);
    }

    public void onRemoved(int i10, int i11) {
        this.mAdapter.notifyItemRangeRemoved(i10, i11);
    }
}
