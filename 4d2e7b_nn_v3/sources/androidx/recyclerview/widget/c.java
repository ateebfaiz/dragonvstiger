package androidx.recyclerview.widget;

import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.ViewTypeStorage;
import androidx.recyclerview.widget.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

class c implements i.b {

    /* renamed from: a  reason: collision with root package name */
    private final ConcatAdapter f16309a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewTypeStorage f16310b;

    /* renamed from: c  reason: collision with root package name */
    private List f16311c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final IdentityHashMap f16312d = new IdentityHashMap();

    /* renamed from: e  reason: collision with root package name */
    private List f16313e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private a f16314f = new a();

    /* renamed from: g  reason: collision with root package name */
    private final ConcatAdapter.Config.StableIdMode f16315g;

    /* renamed from: h  reason: collision with root package name */
    private final StableIdStorage f16316h;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        i f16317a;

        /* renamed from: b  reason: collision with root package name */
        int f16318b;

        /* renamed from: c  reason: collision with root package name */
        boolean f16319c;

        a() {
        }
    }

    c(ConcatAdapter concatAdapter, ConcatAdapter.Config config) {
        this.f16309a = concatAdapter;
        if (config.isolateViewTypes) {
            this.f16310b = new ViewTypeStorage.IsolatedViewTypeStorage();
        } else {
            this.f16310b = new ViewTypeStorage.SharedIdRangeViewTypeStorage();
        }
        ConcatAdapter.Config.StableIdMode stableIdMode = config.stableIdMode;
        this.f16315g = stableIdMode;
        if (stableIdMode == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
            this.f16316h = new StableIdStorage.NoStableIdStorage();
        } else if (stableIdMode == ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) {
            this.f16316h = new StableIdStorage.IsolatedStableIdStorage();
        } else if (stableIdMode == ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) {
            this.f16316h = new StableIdStorage.SharedPoolStableIdStorage();
        } else {
            throw new IllegalArgumentException("unknown stable id mode");
        }
    }

    private void F(a aVar) {
        aVar.f16319c = false;
        aVar.f16317a = null;
        aVar.f16318b = -1;
        this.f16314f = aVar;
    }

    private void i() {
        RecyclerView.Adapter.StateRestorationPolicy j10 = j();
        if (j10 != this.f16309a.getStateRestorationPolicy()) {
            this.f16309a.internalSetStateRestorationPolicy(j10);
        }
    }

    private RecyclerView.Adapter.StateRestorationPolicy j() {
        for (i iVar : this.f16313e) {
            RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy = iVar.f16403c.getStateRestorationPolicy();
            RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy2 = RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
            if (stateRestorationPolicy == stateRestorationPolicy2) {
                return stateRestorationPolicy2;
            }
            if (stateRestorationPolicy == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY && iVar.b() == 0) {
                return stateRestorationPolicy2;
            }
        }
        return RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
    }

    private int k(i iVar) {
        i iVar2;
        Iterator it = this.f16313e.iterator();
        int i10 = 0;
        while (it.hasNext() && (iVar2 = (i) it.next()) != iVar) {
            i10 += iVar2.b();
        }
        return i10;
    }

    private a l(int i10) {
        a aVar = this.f16314f;
        if (aVar.f16319c) {
            aVar = new a();
        } else {
            aVar.f16319c = true;
        }
        Iterator it = this.f16313e.iterator();
        int i11 = i10;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i iVar = (i) it.next();
            if (iVar.b() > i11) {
                aVar.f16317a = iVar;
                aVar.f16318b = i11;
                break;
            }
            i11 -= iVar.b();
        }
        if (aVar.f16317a != null) {
            return aVar;
        }
        throw new IllegalArgumentException("Cannot find wrapper for " + i10);
    }

    private i m(RecyclerView.Adapter adapter) {
        int v10 = v(adapter);
        if (v10 == -1) {
            return null;
        }
        return (i) this.f16313e.get(v10);
    }

    private i t(RecyclerView.ViewHolder viewHolder) {
        i iVar = (i) this.f16312d.get(viewHolder);
        if (iVar != null) {
            return iVar;
        }
        throw new IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    private int v(RecyclerView.Adapter adapter) {
        int size = this.f16313e.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((i) this.f16313e.get(i10)).f16403c == adapter) {
                return i10;
            }
        }
        return -1;
    }

    private boolean w(RecyclerView recyclerView) {
        for (WeakReference weakReference : this.f16311c) {
            if (weakReference.get() == recyclerView) {
                return true;
            }
        }
        return false;
    }

    public void A(RecyclerView recyclerView) {
        int size = this.f16311c.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            WeakReference weakReference = (WeakReference) this.f16311c.get(size);
            if (weakReference.get() == null) {
                this.f16311c.remove(size);
            } else if (weakReference.get() == recyclerView) {
                this.f16311c.remove(size);
                break;
            }
            size--;
        }
        for (i iVar : this.f16313e) {
            iVar.f16403c.onDetachedFromRecyclerView(recyclerView);
        }
    }

    public boolean B(RecyclerView.ViewHolder viewHolder) {
        i iVar = (i) this.f16312d.get(viewHolder);
        if (iVar != null) {
            boolean onFailedToRecycleView = iVar.f16403c.onFailedToRecycleView(viewHolder);
            this.f16312d.remove(viewHolder);
            return onFailedToRecycleView;
        }
        throw new IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    public void C(RecyclerView.ViewHolder viewHolder) {
        t(viewHolder).f16403c.onViewAttachedToWindow(viewHolder);
    }

    public void D(RecyclerView.ViewHolder viewHolder) {
        t(viewHolder).f16403c.onViewDetachedFromWindow(viewHolder);
    }

    public void E(RecyclerView.ViewHolder viewHolder) {
        i iVar = (i) this.f16312d.get(viewHolder);
        if (iVar != null) {
            iVar.f16403c.onViewRecycled(viewHolder);
            this.f16312d.remove(viewHolder);
            return;
        }
        throw new IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    /* access modifiers changed from: package-private */
    public boolean G(RecyclerView.Adapter adapter) {
        int v10 = v(adapter);
        if (v10 == -1) {
            return false;
        }
        i iVar = (i) this.f16313e.get(v10);
        int k10 = k(iVar);
        this.f16313e.remove(v10);
        this.f16309a.notifyItemRangeRemoved(k10, iVar.b());
        for (WeakReference weakReference : this.f16311c) {
            RecyclerView recyclerView = (RecyclerView) weakReference.get();
            if (recyclerView != null) {
                adapter.onDetachedFromRecyclerView(recyclerView);
            }
        }
        iVar.a();
        i();
        return true;
    }

    public void a(i iVar) {
        i();
    }

    public void b(i iVar, int i10, int i11, Object obj) {
        this.f16309a.notifyItemRangeChanged(i10 + k(iVar), i11, obj);
    }

    public void c(i iVar, int i10, int i11) {
        this.f16309a.notifyItemRangeInserted(i10 + k(iVar), i11);
    }

    public void d(i iVar, int i10, int i11) {
        int k10 = k(iVar);
        this.f16309a.notifyItemMoved(i10 + k10, i11 + k10);
    }

    public void e(i iVar) {
        this.f16309a.notifyDataSetChanged();
        i();
    }

    public void f(i iVar, int i10, int i11) {
        this.f16309a.notifyItemRangeRemoved(i10 + k(iVar), i11);
    }

    /* access modifiers changed from: package-private */
    public boolean g(int i10, RecyclerView.Adapter adapter) {
        if (i10 < 0 || i10 > this.f16313e.size()) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + this.f16313e.size() + ". Given:" + i10);
        }
        if (u()) {
            Preconditions.checkArgument(adapter.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
        } else if (adapter.hasStableIds()) {
            Log.w("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
        }
        if (m(adapter) != null) {
            return false;
        }
        i iVar = new i(adapter, this, this.f16310b, this.f16316h.createStableIdLookup());
        this.f16313e.add(i10, iVar);
        for (WeakReference weakReference : this.f16311c) {
            RecyclerView recyclerView = (RecyclerView) weakReference.get();
            if (recyclerView != null) {
                adapter.onAttachedToRecyclerView(recyclerView);
            }
        }
        if (iVar.b() > 0) {
            this.f16309a.notifyItemRangeInserted(k(iVar), iVar.b());
        }
        i();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean h(RecyclerView.Adapter adapter) {
        return g(this.f16313e.size(), adapter);
    }

    public List n() {
        if (this.f16313e.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f16313e.size());
        for (i iVar : this.f16313e) {
            arrayList.add(iVar.f16403c);
        }
        return arrayList;
    }

    public long o(int i10) {
        a l10 = l(i10);
        long c10 = l10.f16317a.c(l10.f16318b);
        F(l10);
        return c10;
    }

    public int p(int i10) {
        a l10 = l(i10);
        int d10 = l10.f16317a.d(l10.f16318b);
        F(l10);
        return d10;
    }

    public int q(RecyclerView.Adapter adapter, RecyclerView.ViewHolder viewHolder, int i10) {
        i iVar = (i) this.f16312d.get(viewHolder);
        if (iVar == null) {
            return -1;
        }
        int k10 = i10 - k(iVar);
        int itemCount = iVar.f16403c.getItemCount();
        if (k10 >= 0 && k10 < itemCount) {
            return iVar.f16403c.findRelativeAdapterPositionIn(adapter, viewHolder, k10);
        }
        throw new IllegalStateException("Detected inconsistent adapter updates. The local position of the view holder maps to " + k10 + " which is out of bounds for the adapter with size " + itemCount + ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:" + viewHolder + "adapter:" + adapter);
    }

    public int r() {
        int i10 = 0;
        for (i b10 : this.f16313e) {
            i10 += b10.b();
        }
        return i10;
    }

    public Pair s(int i10) {
        a l10 = l(i10);
        Pair pair = new Pair(l10.f16317a.f16403c, Integer.valueOf(l10.f16318b));
        F(l10);
        return pair;
    }

    public boolean u() {
        if (this.f16315g != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
            return true;
        }
        return false;
    }

    public void x(RecyclerView recyclerView) {
        if (!w(recyclerView)) {
            this.f16311c.add(new WeakReference(recyclerView));
            for (i iVar : this.f16313e) {
                iVar.f16403c.onAttachedToRecyclerView(recyclerView);
            }
        }
    }

    public void y(RecyclerView.ViewHolder viewHolder, int i10) {
        a l10 = l(i10);
        this.f16312d.put(viewHolder, l10.f16317a);
        l10.f16317a.e(viewHolder, l10.f16318b);
        F(l10);
    }

    public RecyclerView.ViewHolder z(ViewGroup viewGroup, int i10) {
        return this.f16310b.getWrapperForGlobalType(i10).f(viewGroup, i10);
    }
}
