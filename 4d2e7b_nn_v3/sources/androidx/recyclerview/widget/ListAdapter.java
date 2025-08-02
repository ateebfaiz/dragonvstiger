package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer.ListListener<T> mListener;

    class a implements AsyncListDiffer.ListListener {
        a() {
        }

        public void onCurrentListChanged(List list, List list2) {
            ListAdapter.this.onCurrentListChanged(list, list2);
        }
    }

    protected ListAdapter(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
        a aVar = new a();
        this.mListener = aVar;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>((ListUpdateCallback) new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).build());
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(aVar);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    /* access modifiers changed from: protected */
    public T getItem(int i10) {
        return this.mDiffer.getCurrentList().get(i10);
    }

    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
    }

    public void submitList(@Nullable List<T> list) {
        this.mDiffer.submitList(list);
    }

    public void submitList(@Nullable List<T> list, @Nullable Runnable runnable) {
        this.mDiffer.submitList(list, runnable);
    }

    protected ListAdapter(@NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        a aVar = new a();
        this.mListener = aVar;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>((ListUpdateCallback) new AdapterListUpdateCallback(this), asyncDifferConfig);
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(aVar);
    }
}
