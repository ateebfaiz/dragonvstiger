package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class DirectedAcyclicGraph<T> {
    private final SimpleArrayMap<T, ArrayList<T>> mGraph = new SimpleArrayMap<>();
    private final Pools.Pool<ArrayList<T>> mListPool = new Pools.SimplePool(10);
    private final ArrayList<T> mSortResult = new ArrayList<>();
    private final HashSet<T> mSortTmpMarked = new HashSet<>();

    private void dfs(T t10, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t10)) {
            if (!hashSet.contains(t10)) {
                hashSet.add(t10);
                ArrayList arrayList2 = this.mGraph.get(t10);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        dfs(arrayList2.get(i10), arrayList, hashSet);
                    }
                }
                hashSet.remove(t10);
                arrayList.add(t10);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    @NonNull
    private ArrayList<T> getEmptyList() {
        ArrayList<T> acquire = this.mListPool.acquire();
        if (acquire == null) {
            return new ArrayList<>();
        }
        return acquire;
    }

    private void poolList(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.mListPool.release(arrayList);
    }

    public void addEdge(@NonNull T t10, @NonNull T t11) {
        if (!this.mGraph.containsKey(t10) || !this.mGraph.containsKey(t11)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.mGraph.get(t10);
        if (arrayList == null) {
            arrayList = getEmptyList();
            this.mGraph.put(t10, arrayList);
        }
        arrayList.add(t11);
    }

    public void addNode(@NonNull T t10) {
        if (!this.mGraph.containsKey(t10)) {
            this.mGraph.put(t10, null);
        }
    }

    public void clear() {
        int size = this.mGraph.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList valueAt = this.mGraph.valueAt(i10);
            if (valueAt != null) {
                poolList(valueAt);
            }
        }
        this.mGraph.clear();
    }

    public boolean contains(@NonNull T t10) {
        return this.mGraph.containsKey(t10);
    }

    @Nullable
    public List<T> getIncomingEdges(@NonNull T t10) {
        ArrayList incomingEdgesInternal = getIncomingEdgesInternal(t10);
        if (incomingEdgesInternal == null) {
            return null;
        }
        return new ArrayList(incomingEdgesInternal);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ArrayList<T> getIncomingEdgesInternal(@NonNull T t10) {
        return this.mGraph.get(t10);
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T t10) {
        int size = this.mGraph.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList valueAt = this.mGraph.valueAt(i10);
            if (valueAt != null && valueAt.contains(t10)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.mGraph.keyAt(i10));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int size = this.mGraph.size();
        for (int i10 = 0; i10 < size; i10++) {
            dfs(this.mGraph.keyAt(i10), this.mSortResult, this.mSortTmpMarked);
        }
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(@NonNull T t10) {
        int size = this.mGraph.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList valueAt = this.mGraph.valueAt(i10);
            if (valueAt != null && valueAt.contains(t10)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int size() {
        return this.mGraph.size();
    }
}
