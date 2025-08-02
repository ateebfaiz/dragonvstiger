package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DiffUtil {
    private static final Comparator<c> DIAGONAL_COMPARATOR = new a();

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i10, int i11);

        public abstract boolean areItemsTheSame(int i10, int i11);

        @Nullable
        public Object getChangePayload(int i10, int i11) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final List<c> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        DiffResult(Callback callback, List<c> list, int[] iArr, int[] iArr2, boolean z10) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z10;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            c cVar;
            if (this.mDiagonals.isEmpty()) {
                cVar = null;
            } else {
                cVar = this.mDiagonals.get(0);
            }
            if (!(cVar != null && cVar.f16168a == 0 && cVar.f16169b == 0)) {
                this.mDiagonals.add(0, new c(0, 0, 0));
            }
            this.mDiagonals.add(new c(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i10) {
            int i11;
            int size = this.mDiagonals.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                c cVar = this.mDiagonals.get(i13);
                while (i12 < cVar.f16169b) {
                    if (this.mNewItemStatuses[i12] != 0 || !this.mCallback.areItemsTheSame(i10, i12)) {
                        i12++;
                    } else {
                        if (this.mCallback.areContentsTheSame(i10, i12)) {
                            i11 = 8;
                        } else {
                            i11 = 4;
                        }
                        this.mOldItemStatuses[i10] = (i12 << 4) | i11;
                        this.mNewItemStatuses[i12] = (i10 << 4) | i11;
                        return;
                    }
                }
                i12 = cVar.b();
            }
        }

        private void findMatchingItems() {
            int i10;
            for (c next : this.mDiagonals) {
                for (int i11 = 0; i11 < next.f16170c; i11++) {
                    int i12 = next.f16168a + i11;
                    int i13 = next.f16169b + i11;
                    if (this.mCallback.areContentsTheSame(i12, i13)) {
                        i10 = 1;
                    } else {
                        i10 = 2;
                    }
                    this.mOldItemStatuses[i12] = (i13 << 4) | i10;
                    this.mNewItemStatuses[i13] = (i12 << 4) | i10;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int i10 = 0;
            for (c next : this.mDiagonals) {
                while (i10 < next.f16168a) {
                    if (this.mOldItemStatuses[i10] == 0) {
                        findMatchingAddition(i10);
                    }
                    i10++;
                }
                i10 = next.a();
            }
        }

        @Nullable
        private static d getPostponedUpdate(Collection<d> collection, int i10, boolean z10) {
            d dVar;
            Iterator<d> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    dVar = null;
                    break;
                }
                dVar = it.next();
                if (dVar.f16171a == i10 && dVar.f16173c == z10) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                d next = it.next();
                if (z10) {
                    next.f16172b--;
                } else {
                    next.f16172b++;
                }
            }
            return dVar;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i10) {
            if (i10 < 0 || i10 >= this.mNewListSize) {
                throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i10 + ", new list size = " + this.mNewListSize);
            }
            int i11 = this.mNewItemStatuses[i10];
            if ((i11 & 15) == 0) {
                return -1;
            }
            return i11 >> 4;
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i10) {
            if (i10 < 0 || i10 >= this.mOldListSize) {
                throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i10 + ", old list size = " + this.mOldListSize);
            }
            int i11 = this.mOldItemStatuses[i10];
            if ((i11 & 15) == 0) {
                return -1;
            }
            return i11 >> 4;
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo((ListUpdateCallback) new AdapterListUpdateCallback(adapter));
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            int i10;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            int i11 = this.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i12 = this.mOldListSize;
            int i13 = this.mNewListSize;
            for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
                c cVar = this.mDiagonals.get(size);
                int a10 = cVar.a();
                int b10 = cVar.b();
                while (true) {
                    if (i12 <= a10) {
                        break;
                    }
                    i12--;
                    int i14 = this.mOldItemStatuses[i12];
                    if ((i14 & 12) != 0) {
                        int i15 = i14 >> 4;
                        d postponedUpdate = getPostponedUpdate(arrayDeque, i15, false);
                        if (postponedUpdate != null) {
                            int i16 = (i11 - postponedUpdate.f16172b) - 1;
                            batchingListUpdateCallback.onMoved(i12, i16);
                            if ((i14 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i16, 1, this.mCallback.getChangePayload(i12, i15));
                            }
                        } else {
                            arrayDeque.add(new d(i12, (i11 - i12) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.onRemoved(i12, 1);
                        i11--;
                    }
                }
                while (i13 > b10) {
                    i13--;
                    int i17 = this.mNewItemStatuses[i13];
                    if ((i17 & 12) != 0) {
                        int i18 = i17 >> 4;
                        d postponedUpdate2 = getPostponedUpdate(arrayDeque, i18, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new d(i13, i11 - i12, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i11 - postponedUpdate2.f16172b) - 1, i12);
                            if ((i17 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i12, 1, this.mCallback.getChangePayload(i18, i13));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i12, 1);
                        i11++;
                    }
                }
                int i19 = cVar.f16168a;
                int i20 = cVar.f16169b;
                for (i10 = 0; i10 < cVar.f16170c; i10++) {
                    if ((this.mOldItemStatuses[i19] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i19, 1, this.mCallback.getChangePayload(i19, i20));
                    }
                    i19++;
                    i20++;
                }
                i12 = cVar.f16168a;
                i13 = cVar.f16169b;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t10, @NonNull T t11);

        public abstract boolean areItemsTheSame(@NonNull T t10, @NonNull T t11);

        @Nullable
        public Object getChangePayload(@NonNull T t10, @NonNull T t11) {
            return null;
        }
    }

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            return cVar.f16168a - cVar2.f16168a;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f16166a;

        /* renamed from: b  reason: collision with root package name */
        private final int f16167b;

        b(int i10) {
            int[] iArr = new int[i10];
            this.f16166a = iArr;
            this.f16167b = iArr.length / 2;
        }

        /* access modifiers changed from: package-private */
        public int[] a() {
            return this.f16166a;
        }

        /* access modifiers changed from: package-private */
        public int b(int i10) {
            return this.f16166a[i10 + this.f16167b];
        }

        /* access modifiers changed from: package-private */
        public void c(int i10, int i11) {
            this.f16166a[i10 + this.f16167b] = i11;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f16168a;

        /* renamed from: b  reason: collision with root package name */
        public final int f16169b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16170c;

        c(int i10, int i11, int i12) {
            this.f16168a = i10;
            this.f16169b = i11;
            this.f16170c = i12;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f16168a + this.f16170c;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f16169b + this.f16170c;
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        int f16171a;

        /* renamed from: b  reason: collision with root package name */
        int f16172b;

        /* renamed from: c  reason: collision with root package name */
        boolean f16173c;

        d(int i10, int i11, boolean z10) {
            this.f16171a = i10;
            this.f16172b = i11;
            this.f16173c = z10;
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        int f16174a;

        /* renamed from: b  reason: collision with root package name */
        int f16175b;

        /* renamed from: c  reason: collision with root package name */
        int f16176c;

        /* renamed from: d  reason: collision with root package name */
        int f16177d;

        public e() {
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f16177d - this.f16176c;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f16175b - this.f16174a;
        }

        public e(int i10, int i11, int i12, int i13) {
            this.f16174a = i10;
            this.f16175b = i11;
            this.f16176c = i12;
            this.f16177d = i13;
        }
    }

    static class f {

        /* renamed from: a  reason: collision with root package name */
        public int f16178a;

        /* renamed from: b  reason: collision with root package name */
        public int f16179b;

        /* renamed from: c  reason: collision with root package name */
        public int f16180c;

        /* renamed from: d  reason: collision with root package name */
        public int f16181d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f16182e;

        f() {
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return Math.min(this.f16180c - this.f16178a, this.f16181d - this.f16179b);
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            if (this.f16181d - this.f16179b != this.f16180c - this.f16178a) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            if (this.f16181d - this.f16179b > this.f16180c - this.f16178a) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public c d() {
            if (!b()) {
                int i10 = this.f16178a;
                return new c(i10, this.f16179b, this.f16180c - i10);
            } else if (this.f16182e) {
                return new c(this.f16178a, this.f16179b, a());
            } else {
                if (c()) {
                    return new c(this.f16178a, this.f16179b + 1, a());
                }
                return new c(this.f16178a + 1, this.f16179b, a());
            }
        }
    }

    private DiffUtil() {
    }

    @Nullable
    private static f backward(e eVar, Callback callback, b bVar, b bVar2, int i10) {
        boolean z10;
        int i11;
        int i12;
        int i13;
        int i14;
        if ((eVar.b() - eVar.a()) % 2 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int b10 = eVar.b() - eVar.a();
        int i15 = -i10;
        int i16 = i15;
        while (i16 <= i10) {
            if (i16 == i15 || (i16 != i10 && bVar2.b(i16 + 1) < bVar2.b(i16 - 1))) {
                i12 = bVar2.b(i16 + 1);
                i11 = i12;
            } else {
                i12 = bVar2.b(i16 - 1);
                i11 = i12 - 1;
            }
            int i17 = eVar.f16177d - ((eVar.f16175b - i11) - i16);
            if (i10 == 0 || i11 != i12) {
                i13 = i17;
            } else {
                i13 = i17 + 1;
            }
            while (i11 > eVar.f16174a && i17 > eVar.f16176c && callback.areItemsTheSame(i11 - 1, i17 - 1)) {
                i11--;
                i17--;
            }
            bVar2.c(i16, i11);
            if (!z10 || (i14 = b10 - i16) < i15 || i14 > i10 || bVar.b(i14) < i11) {
                i16 += 2;
            } else {
                f fVar = new f();
                fVar.f16178a = i11;
                fVar.f16179b = i17;
                fVar.f16180c = i12;
                fVar.f16181d = i13;
                fVar.f16182e = true;
                return fVar;
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    @Nullable
    private static f forward(e eVar, Callback callback, b bVar, b bVar2, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z10 = true;
        if (Math.abs(eVar.b() - eVar.a()) % 2 != 1) {
            z10 = false;
        }
        int b10 = eVar.b() - eVar.a();
        int i15 = -i10;
        int i16 = i15;
        while (i16 <= i10) {
            if (i16 == i15 || (i16 != i10 && bVar.b(i16 + 1) > bVar.b(i16 - 1))) {
                i12 = bVar.b(i16 + 1);
                i11 = i12;
            } else {
                i12 = bVar.b(i16 - 1);
                i11 = i12 + 1;
            }
            int i17 = (eVar.f16176c + (i11 - eVar.f16174a)) - i16;
            if (i10 == 0 || i11 != i12) {
                i13 = i17;
            } else {
                i13 = i17 - 1;
            }
            while (i11 < eVar.f16175b && i17 < eVar.f16177d && callback.areItemsTheSame(i11, i17)) {
                i11++;
                i17++;
            }
            bVar.c(i16, i11);
            if (!z10 || (i14 = b10 - i16) < i15 + 1 || i14 > i10 - 1 || bVar2.b(i14) > i11) {
                i16 += 2;
            } else {
                f fVar = new f();
                fVar.f16178a = i12;
                fVar.f16179b = i13;
                fVar.f16180c = i11;
                fVar.f16181d = i17;
                fVar.f16182e = false;
                return fVar;
            }
        }
        return null;
    }

    @Nullable
    private static f midPoint(e eVar, Callback callback, b bVar, b bVar2) {
        if (eVar.b() >= 1 && eVar.a() >= 1) {
            int b10 = ((eVar.b() + eVar.a()) + 1) / 2;
            bVar.c(1, eVar.f16174a);
            bVar2.c(1, eVar.f16175b);
            for (int i10 = 0; i10 < b10; i10++) {
                f forward = forward(eVar, callback, bVar, bVar2, i10);
                if (forward != null) {
                    return forward;
                }
                f backward = backward(eVar, callback, bVar, bVar2, i10);
                if (backward != null) {
                    return backward;
                }
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z10) {
        e eVar;
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new e(0, oldListSize, 0, newListSize));
        int i10 = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        b bVar = new b(i10);
        b bVar2 = new b(i10);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            e eVar2 = (e) arrayList2.remove(arrayList2.size() - 1);
            f midPoint = midPoint(eVar2, callback, bVar, bVar2);
            if (midPoint != null) {
                if (midPoint.a() > 0) {
                    arrayList.add(midPoint.d());
                }
                if (arrayList3.isEmpty()) {
                    eVar = new e();
                } else {
                    eVar = (e) arrayList3.remove(arrayList3.size() - 1);
                }
                eVar.f16174a = eVar2.f16174a;
                eVar.f16176c = eVar2.f16176c;
                eVar.f16175b = midPoint.f16178a;
                eVar.f16177d = midPoint.f16179b;
                arrayList2.add(eVar);
                eVar2.f16175b = eVar2.f16175b;
                eVar2.f16177d = eVar2.f16177d;
                eVar2.f16174a = midPoint.f16180c;
                eVar2.f16176c = midPoint.f16181d;
                arrayList2.add(eVar2);
            } else {
                arrayList3.add(eVar2);
            }
        }
        Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new DiffResult(callback, arrayList, bVar.a(), bVar2.a(), z10);
    }
}
