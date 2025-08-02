package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {
    final RecyclerView.Adapter<?> mAdapter;

    public SortedListAdapterCallback(@SuppressLint({"UnknownNullness", "MissingNullability"}) RecyclerView.Adapter<?> adapter) {
        this.mAdapter = adapter;
    }

    public void onChanged(int i10, int i11) {
        this.mAdapter.notifyItemRangeChanged(i10, i11);
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

    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i10, int i11, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i10, i11, obj);
    }
}
