package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

interface ViewTypeStorage {

    public static class IsolatedViewTypeStorage implements ViewTypeStorage {
        SparseArray<i> mGlobalTypeToWrapper = new SparseArray<>();
        int mNextViewType = 0;

        class a implements ViewTypeLookup {

            /* renamed from: a  reason: collision with root package name */
            private SparseIntArray f16286a = new SparseIntArray(1);

            /* renamed from: b  reason: collision with root package name */
            private SparseIntArray f16287b = new SparseIntArray(1);

            /* renamed from: c  reason: collision with root package name */
            final i f16288c;

            a(i iVar) {
                this.f16288c = iVar;
            }

            public void dispose() {
                IsolatedViewTypeStorage.this.removeWrapper(this.f16288c);
            }

            public int globalToLocal(int i10) {
                int indexOfKey = this.f16287b.indexOfKey(i10);
                if (indexOfKey >= 0) {
                    return this.f16287b.valueAt(indexOfKey);
                }
                throw new IllegalStateException("requested global type " + i10 + " does not belong to the adapter:" + this.f16288c.f16403c);
            }

            public int localToGlobal(int i10) {
                int indexOfKey = this.f16286a.indexOfKey(i10);
                if (indexOfKey > -1) {
                    return this.f16286a.valueAt(indexOfKey);
                }
                int obtainViewType = IsolatedViewTypeStorage.this.obtainViewType(this.f16288c);
                this.f16286a.put(i10, obtainViewType);
                this.f16287b.put(obtainViewType, i10);
                return obtainViewType;
            }
        }

        @NonNull
        public ViewTypeLookup createViewTypeWrapper(@NonNull i iVar) {
            return new a(iVar);
        }

        @NonNull
        public i getWrapperForGlobalType(int i10) {
            i iVar = this.mGlobalTypeToWrapper.get(i10);
            if (iVar != null) {
                return iVar;
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i10);
        }

        /* access modifiers changed from: package-private */
        public int obtainViewType(i iVar) {
            int i10 = this.mNextViewType;
            this.mNextViewType = i10 + 1;
            this.mGlobalTypeToWrapper.put(i10, iVar);
            return i10;
        }

        /* access modifiers changed from: package-private */
        public void removeWrapper(@NonNull i iVar) {
            for (int size = this.mGlobalTypeToWrapper.size() - 1; size >= 0; size--) {
                if (this.mGlobalTypeToWrapper.valueAt(size) == iVar) {
                    this.mGlobalTypeToWrapper.removeAt(size);
                }
            }
        }
    }

    public static class SharedIdRangeViewTypeStorage implements ViewTypeStorage {
        SparseArray<List<i>> mGlobalTypeToWrapper = new SparseArray<>();

        class a implements ViewTypeLookup {

            /* renamed from: a  reason: collision with root package name */
            final i f16290a;

            a(i iVar) {
                this.f16290a = iVar;
            }

            public void dispose() {
                SharedIdRangeViewTypeStorage.this.removeWrapper(this.f16290a);
            }

            public int globalToLocal(int i10) {
                return i10;
            }

            public int localToGlobal(int i10) {
                List list = SharedIdRangeViewTypeStorage.this.mGlobalTypeToWrapper.get(i10);
                if (list == null) {
                    list = new ArrayList();
                    SharedIdRangeViewTypeStorage.this.mGlobalTypeToWrapper.put(i10, list);
                }
                if (!list.contains(this.f16290a)) {
                    list.add(this.f16290a);
                }
                return i10;
            }
        }

        @NonNull
        public ViewTypeLookup createViewTypeWrapper(@NonNull i iVar) {
            return new a(iVar);
        }

        @NonNull
        public i getWrapperForGlobalType(int i10) {
            List list = this.mGlobalTypeToWrapper.get(i10);
            if (list != null && !list.isEmpty()) {
                return (i) list.get(0);
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i10);
        }

        /* access modifiers changed from: package-private */
        public void removeWrapper(@NonNull i iVar) {
            for (int size = this.mGlobalTypeToWrapper.size() - 1; size >= 0; size--) {
                List valueAt = this.mGlobalTypeToWrapper.valueAt(size);
                if (valueAt.remove(iVar) && valueAt.isEmpty()) {
                    this.mGlobalTypeToWrapper.removeAt(size);
                }
            }
        }
    }

    public interface ViewTypeLookup {
        void dispose();

        int globalToLocal(int i10);

        int localToGlobal(int i10);
    }

    ViewTypeLookup createViewTypeWrapper(i iVar);

    i getWrapperForGlobalType(int i10);
}
