package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.l;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class g extends ViewModel {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewModelProvider.Factory f15730h = new a();

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f15731a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap f15732b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap f15733c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final boolean f15734d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15735e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15736f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f15737g = false;

    class a implements ViewModelProvider.Factory {
        a() {
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return l.b(this, cls, creationExtras);
        }

        public ViewModel create(Class cls) {
            return new g(true);
        }
    }

    g(boolean z10) {
        this.f15734d = z10;
    }

    static g e(ViewModelStore viewModelStore) {
        return (g) new ViewModelProvider(viewModelStore, f15730h).get(g.class);
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (this.f15737g) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (!this.f15731a.containsKey(fragment.mWho)) {
            this.f15731a.put(fragment.mWho, fragment);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment) {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        g gVar = (g) this.f15732b.get(fragment.mWho);
        if (gVar != null) {
            gVar.onCleared();
            this.f15732b.remove(fragment.mWho);
        }
        ViewModelStore viewModelStore = (ViewModelStore) this.f15733c.get(fragment.mWho);
        if (viewModelStore != null) {
            viewModelStore.clear();
            this.f15733c.remove(fragment.mWho);
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment c(String str) {
        return (Fragment) this.f15731a.get(str);
    }

    /* access modifiers changed from: package-private */
    public g d(Fragment fragment) {
        g gVar = (g) this.f15732b.get(fragment.mWho);
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this.f15734d);
        this.f15732b.put(fragment.mWho, gVar2);
        return gVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (!this.f15731a.equals(gVar.f15731a) || !this.f15732b.equals(gVar.f15732b) || !this.f15733c.equals(gVar.f15733c)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public Collection f() {
        return new ArrayList(this.f15731a.values());
    }

    /* access modifiers changed from: package-private */
    public FragmentManagerNonConfig g() {
        if (this.f15731a.isEmpty() && this.f15732b.isEmpty() && this.f15733c.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.f15732b.entrySet()) {
            FragmentManagerNonConfig g10 = ((g) entry.getValue()).g();
            if (g10 != null) {
                hashMap.put(entry.getKey(), g10);
            }
        }
        this.f15736f = true;
        if (!this.f15731a.isEmpty() || !hashMap.isEmpty() || !this.f15733c.isEmpty()) {
            return new FragmentManagerNonConfig(new ArrayList(this.f15731a.values()), hashMap, new HashMap(this.f15733c));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ViewModelStore h(Fragment fragment) {
        ViewModelStore viewModelStore = (ViewModelStore) this.f15733c.get(fragment.mWho);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.f15733c.put(fragment.mWho, viewModelStore2);
        return viewModelStore2;
    }

    public int hashCode() {
        return (((this.f15731a.hashCode() * 31) + this.f15732b.hashCode()) * 31) + this.f15733c.hashCode();
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.f15735e;
    }

    /* access modifiers changed from: package-private */
    public void j(Fragment fragment) {
        if (this.f15737g) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.f15731a.remove(fragment.mWho) != null && FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void k(FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.f15731a.clear();
        this.f15732b.clear();
        this.f15733c.clear();
        if (fragmentManagerNonConfig != null) {
            Collection<Fragment> fragments = fragmentManagerNonConfig.getFragments();
            if (fragments != null) {
                for (Fragment next : fragments) {
                    if (next != null) {
                        this.f15731a.put(next.mWho, next);
                    }
                }
            }
            Map<String, FragmentManagerNonConfig> childNonConfigs = fragmentManagerNonConfig.getChildNonConfigs();
            if (childNonConfigs != null) {
                for (Map.Entry next2 : childNonConfigs.entrySet()) {
                    g gVar = new g(this.f15734d);
                    gVar.k((FragmentManagerNonConfig) next2.getValue());
                    this.f15732b.put(next2.getKey(), gVar);
                }
            }
            Map<String, ViewModelStore> viewModelStores = fragmentManagerNonConfig.getViewModelStores();
            if (viewModelStores != null) {
                this.f15733c.putAll(viewModelStores);
            }
        }
        this.f15736f = false;
    }

    /* access modifiers changed from: package-private */
    public void l(boolean z10) {
        this.f15737g = z10;
    }

    /* access modifiers changed from: package-private */
    public boolean m(Fragment fragment) {
        if (!this.f15731a.containsKey(fragment.mWho)) {
            return true;
        }
        if (this.f15734d) {
            return this.f15735e;
        }
        return !this.f15736f;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f15735e = true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator it = this.f15731a.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator it2 = this.f15732b.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append((String) it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator it3 = this.f15733c.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append((String) it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
