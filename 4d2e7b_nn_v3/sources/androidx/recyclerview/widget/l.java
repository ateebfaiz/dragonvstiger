package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;

class l {

    /* renamed from: a  reason: collision with root package name */
    final SimpleArrayMap f16409a = new SimpleArrayMap();

    /* renamed from: b  reason: collision with root package name */
    final LongSparseArray f16410b = new LongSparseArray();

    static class a {

        /* renamed from: d  reason: collision with root package name */
        static Pools.Pool f16411d = new Pools.SimplePool(20);

        /* renamed from: a  reason: collision with root package name */
        int f16412a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.ItemAnimator.ItemHolderInfo f16413b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.ItemAnimator.ItemHolderInfo f16414c;

        private a() {
        }

        static void a() {
            do {
            } while (f16411d.acquire() != null);
        }

        static a b() {
            a aVar = (a) f16411d.acquire();
            if (aVar == null) {
                return new a();
            }
            return aVar;
        }

        static void c(a aVar) {
            aVar.f16412a = 0;
            aVar.f16413b = null;
            aVar.f16414c = null;
            f16411d.release(aVar);
        }
    }

    interface b {
        void a(RecyclerView.ViewHolder viewHolder);

        void b(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);
    }

    l() {
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo l(RecyclerView.ViewHolder viewHolder, int i10) {
        a aVar;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int indexOfKey = this.f16409a.indexOfKey(viewHolder);
        if (indexOfKey >= 0 && (aVar = (a) this.f16409a.valueAt(indexOfKey)) != null) {
            int i11 = aVar.f16412a;
            if ((i11 & i10) != 0) {
                int i12 = (~i10) & i11;
                aVar.f16412a = i12;
                if (i10 == 4) {
                    itemHolderInfo = aVar.f16413b;
                } else if (i10 == 8) {
                    itemHolderInfo = aVar.f16414c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i12 & 12) == 0) {
                    this.f16409a.removeAt(indexOfKey);
                    a.c(aVar);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        a aVar = (a) this.f16409a.get(viewHolder);
        if (aVar == null) {
            aVar = a.b();
            this.f16409a.put(viewHolder, aVar);
        }
        aVar.f16412a |= 2;
        aVar.f16413b = itemHolderInfo;
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.ViewHolder viewHolder) {
        a aVar = (a) this.f16409a.get(viewHolder);
        if (aVar == null) {
            aVar = a.b();
            this.f16409a.put(viewHolder, aVar);
        }
        aVar.f16412a |= 1;
    }

    /* access modifiers changed from: package-private */
    public void c(long j10, RecyclerView.ViewHolder viewHolder) {
        this.f16410b.put(j10, viewHolder);
    }

    /* access modifiers changed from: package-private */
    public void d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        a aVar = (a) this.f16409a.get(viewHolder);
        if (aVar == null) {
            aVar = a.b();
            this.f16409a.put(viewHolder, aVar);
        }
        aVar.f16414c = itemHolderInfo;
        aVar.f16412a |= 8;
    }

    /* access modifiers changed from: package-private */
    public void e(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        a aVar = (a) this.f16409a.get(viewHolder);
        if (aVar == null) {
            aVar = a.b();
            this.f16409a.put(viewHolder, aVar);
        }
        aVar.f16413b = itemHolderInfo;
        aVar.f16412a |= 4;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f16409a.clear();
        this.f16410b.clear();
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.ViewHolder g(long j10) {
        return (RecyclerView.ViewHolder) this.f16410b.get(j10);
    }

    /* access modifiers changed from: package-private */
    public boolean h(RecyclerView.ViewHolder viewHolder) {
        a aVar = (a) this.f16409a.get(viewHolder);
        if (aVar == null || (aVar.f16412a & 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean i(RecyclerView.ViewHolder viewHolder) {
        a aVar = (a) this.f16409a.get(viewHolder);
        if (aVar == null || (aVar.f16412a & 4) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        a.a();
    }

    public void k(RecyclerView.ViewHolder viewHolder) {
        p(viewHolder);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.ItemAnimator.ItemHolderInfo m(RecyclerView.ViewHolder viewHolder) {
        return l(viewHolder, 8);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.ItemAnimator.ItemHolderInfo n(RecyclerView.ViewHolder viewHolder) {
        return l(viewHolder, 4);
    }

    /* access modifiers changed from: package-private */
    public void o(b bVar) {
        for (int size = this.f16409a.size() - 1; size >= 0; size--) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) this.f16409a.keyAt(size);
            a aVar = (a) this.f16409a.removeAt(size);
            int i10 = aVar.f16412a;
            if ((i10 & 3) == 3) {
                bVar.a(viewHolder);
            } else if ((i10 & 1) != 0) {
                RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = aVar.f16413b;
                if (itemHolderInfo == null) {
                    bVar.a(viewHolder);
                } else {
                    bVar.c(viewHolder, itemHolderInfo, aVar.f16414c);
                }
            } else if ((i10 & 14) == 14) {
                bVar.b(viewHolder, aVar.f16413b, aVar.f16414c);
            } else if ((i10 & 12) == 12) {
                bVar.d(viewHolder, aVar.f16413b, aVar.f16414c);
            } else if ((i10 & 4) != 0) {
                bVar.c(viewHolder, aVar.f16413b, (RecyclerView.ItemAnimator.ItemHolderInfo) null);
            } else if ((i10 & 8) != 0) {
                bVar.b(viewHolder, aVar.f16413b, aVar.f16414c);
            }
            a.c(aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void p(RecyclerView.ViewHolder viewHolder) {
        a aVar = (a) this.f16409a.get(viewHolder);
        if (aVar != null) {
            aVar.f16412a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    public void q(RecyclerView.ViewHolder viewHolder) {
        int size = this.f16410b.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (viewHolder == this.f16410b.valueAt(size)) {
                this.f16410b.removeAt(size);
                break;
            } else {
                size--;
            }
        }
        a aVar = (a) this.f16409a.remove(viewHolder);
        if (aVar != null) {
            a.c(aVar);
        }
    }
}
