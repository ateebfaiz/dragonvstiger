package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.ViewTypeStorage;

class i {

    /* renamed from: a  reason: collision with root package name */
    private final ViewTypeStorage.ViewTypeLookup f16401a;

    /* renamed from: b  reason: collision with root package name */
    private final StableIdStorage.StableIdLookup f16402b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView.Adapter f16403c;

    /* renamed from: d  reason: collision with root package name */
    final b f16404d;

    /* renamed from: e  reason: collision with root package name */
    int f16405e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f16406f = new a();

    class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        public void onChanged() {
            i iVar = i.this;
            iVar.f16405e = iVar.f16403c.getItemCount();
            i iVar2 = i.this;
            iVar2.f16404d.e(iVar2);
        }

        public void onItemRangeChanged(int i10, int i11) {
            i iVar = i.this;
            iVar.f16404d.b(iVar, i10, i11, (Object) null);
        }

        public void onItemRangeInserted(int i10, int i11) {
            i iVar = i.this;
            iVar.f16405e += i11;
            iVar.f16404d.c(iVar, i10, i11);
            i iVar2 = i.this;
            if (iVar2.f16405e > 0 && iVar2.f16403c.getStateRestorationPolicy() == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                i iVar3 = i.this;
                iVar3.f16404d.a(iVar3);
            }
        }

        public void onItemRangeMoved(int i10, int i11, int i12) {
            boolean z10 = true;
            if (i12 != 1) {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "moving more than 1 item is not supported in RecyclerView");
            i iVar = i.this;
            iVar.f16404d.d(iVar, i10, i11);
        }

        public void onItemRangeRemoved(int i10, int i11) {
            i iVar = i.this;
            iVar.f16405e -= i11;
            iVar.f16404d.f(iVar, i10, i11);
            i iVar2 = i.this;
            if (iVar2.f16405e < 1 && iVar2.f16403c.getStateRestorationPolicy() == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                i iVar3 = i.this;
                iVar3.f16404d.a(iVar3);
            }
        }

        public void onStateRestorationPolicyChanged() {
            i iVar = i.this;
            iVar.f16404d.a(iVar);
        }

        public void onItemRangeChanged(int i10, int i11, Object obj) {
            i iVar = i.this;
            iVar.f16404d.b(iVar, i10, i11, obj);
        }
    }

    interface b {
        void a(i iVar);

        void b(i iVar, int i10, int i11, Object obj);

        void c(i iVar, int i10, int i11);

        void d(i iVar, int i10, int i11);

        void e(i iVar);

        void f(i iVar, int i10, int i11);
    }

    i(RecyclerView.Adapter adapter, b bVar, ViewTypeStorage viewTypeStorage, StableIdStorage.StableIdLookup stableIdLookup) {
        this.f16403c = adapter;
        this.f16404d = bVar;
        this.f16401a = viewTypeStorage.createViewTypeWrapper(this);
        this.f16402b = stableIdLookup;
        this.f16405e = adapter.getItemCount();
        adapter.registerAdapterDataObserver(this.f16406f);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f16403c.unregisterAdapterDataObserver(this.f16406f);
        this.f16401a.dispose();
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f16405e;
    }

    public long c(int i10) {
        return this.f16402b.localToGlobal(this.f16403c.getItemId(i10));
    }

    /* access modifiers changed from: package-private */
    public int d(int i10) {
        return this.f16401a.localToGlobal(this.f16403c.getItemViewType(i10));
    }

    /* access modifiers changed from: package-private */
    public void e(RecyclerView.ViewHolder viewHolder, int i10) {
        this.f16403c.bindViewHolder(viewHolder, i10);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.ViewHolder f(ViewGroup viewGroup, int i10) {
        return this.f16403c.onCreateViewHolder(viewGroup, this.f16401a.globalToLocal(i10));
    }
}
