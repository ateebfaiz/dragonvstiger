package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class AsyncListDiffer<T> {
    private static final Executor sMainThreadExecutor = new b();
    final AsyncDifferConfig<T> mConfig;
    @Nullable
    private List<T> mList;
    private final List<ListListener<T>> mListeners;
    Executor mMainThreadExecutor;
    int mMaxScheduledGeneration;
    @NonNull
    private List<T> mReadOnlyList;
    private final ListUpdateCallback mUpdateCallback;

    public interface ListListener<T> {
        void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2);
    }

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f16110a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f16111b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f16112c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Runnable f16113d;

        /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$a$a  reason: collision with other inner class name */
        class C0206a extends DiffUtil.Callback {
            C0206a() {
            }

            public boolean areContentsTheSame(int i10, int i11) {
                Object obj = a.this.f16110a.get(i10);
                Object obj2 = a.this.f16111b.get(i11);
                if (obj != null && obj2 != null) {
                    return AsyncListDiffer.this.mConfig.getDiffCallback().areContentsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            public boolean areItemsTheSame(int i10, int i11) {
                Object obj = a.this.f16110a.get(i10);
                Object obj2 = a.this.f16111b.get(i11);
                if (obj != null && obj2 != null) {
                    return AsyncListDiffer.this.mConfig.getDiffCallback().areItemsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                return false;
            }

            public Object getChangePayload(int i10, int i11) {
                Object obj = a.this.f16110a.get(i10);
                Object obj2 = a.this.f16111b.get(i11);
                if (obj != null && obj2 != null) {
                    return AsyncListDiffer.this.mConfig.getDiffCallback().getChangePayload(obj, obj2);
                }
                throw new AssertionError();
            }

            public int getNewListSize() {
                return a.this.f16111b.size();
            }

            public int getOldListSize() {
                return a.this.f16110a.size();
            }
        }

        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ DiffUtil.DiffResult f16116a;

            b(DiffUtil.DiffResult diffResult) {
                this.f16116a = diffResult;
            }

            public void run() {
                a aVar = a.this;
                AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                if (asyncListDiffer.mMaxScheduledGeneration == aVar.f16112c) {
                    asyncListDiffer.latchList(aVar.f16111b, this.f16116a, aVar.f16113d);
                }
            }
        }

        a(List list, List list2, int i10, Runnable runnable) {
            this.f16110a = list;
            this.f16111b = list2;
            this.f16112c = i10;
            this.f16113d = runnable;
        }

        public void run() {
            AsyncListDiffer.this.mMainThreadExecutor.execute(new b(DiffUtil.calculateDiff(new C0206a())));
        }
    }

    private static class b implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final Handler f16118a = new Handler(Looper.getMainLooper());

        b() {
        }

        public void execute(Runnable runnable) {
            this.f16118a.post(runnable);
        }
    }

    public AsyncListDiffer(@NonNull RecyclerView.Adapter adapter, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this((ListUpdateCallback) new AdapterListUpdateCallback(adapter), new AsyncDifferConfig.Builder(itemCallback).build());
    }

    private void onCurrentListChanged(@NonNull List<T> list, @Nullable Runnable runnable) {
        for (ListListener<T> onCurrentListChanged : this.mListeners) {
            onCurrentListChanged.onCurrentListChanged(list, this.mReadOnlyList);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void addListListener(@NonNull ListListener<T> listListener) {
        this.mListeners.add(listListener);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    /* access modifiers changed from: package-private */
    public void latchList(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult, @Nullable Runnable runnable) {
        List<T> list2 = this.mReadOnlyList;
        this.mList = list;
        this.mReadOnlyList = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.mUpdateCallback);
        onCurrentListChanged(list2, runnable);
    }

    public void removeListListener(@NonNull ListListener<T> listListener) {
        this.mListeners.remove(listListener);
    }

    public void submitList(@Nullable List<T> list) {
        submitList(list, (Runnable) null);
    }

    public void submitList(@Nullable List<T> list, @Nullable Runnable runnable) {
        int i10 = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = i10;
        List<T> list2 = this.mList;
        if (list != list2) {
            List<T> list3 = this.mReadOnlyList;
            if (list == null) {
                int size = list2.size();
                this.mList = null;
                this.mReadOnlyList = Collections.emptyList();
                this.mUpdateCallback.onRemoved(0, size);
                onCurrentListChanged(list3, runnable);
            } else if (list2 == null) {
                this.mList = list;
                this.mReadOnlyList = Collections.unmodifiableList(list);
                this.mUpdateCallback.onInserted(0, list.size());
                onCurrentListChanged(list3, runnable);
            } else {
                this.mConfig.getBackgroundThreadExecutor().execute(new a(list2, list, i10, runnable));
            }
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.mListeners = new CopyOnWriteArrayList();
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = asyncDifferConfig;
        if (asyncDifferConfig.getMainThreadExecutor() != null) {
            this.mMainThreadExecutor = asyncDifferConfig.getMainThreadExecutor();
        } else {
            this.mMainThreadExecutor = sMainThreadExecutor;
        }
    }
}
