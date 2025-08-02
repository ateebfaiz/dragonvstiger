package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class e {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList f15726a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final FragmentManager f15727b;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        final FragmentManager.FragmentLifecycleCallbacks f15728a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f15729b;

        a(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z10) {
            this.f15728a = fragmentLifecycleCallbacks;
            this.f15729b = z10;
        }
    }

    e(FragmentManager fragmentManager) {
        this.f15727b = fragmentManager;
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment parent = this.f15727b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().a(fragment, bundle, true);
        }
        Iterator it = this.f15726a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f15729b) {
                aVar.f15728a.onFragmentActivityCreated(this.f15727b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment, boolean z10) {
        Context context = this.f15727b.getHost().getContext();
        Fragment parent = this.f15727b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().b(fragment, true);
        }
        Iterator it = this.f15726a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f15729b) {
                aVar.f15728a.onFragmentAttached(this.f15727b, fragment, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment parent = this.f15727b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().c(fragment, bundle, true);
        }
        Iterator it = this.f15726a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f15729b) {
                aVar.f15728a.onFragmentCreated(this.f15727b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Fragment fragment, boolean z10) {
        Fragment parent = this.f15727b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().d(fragment, true);
        }
        Iterator it = this.f15726a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f15729b) {
                aVar.f15728a.onFragmentDestroyed(this.f15727b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(Fragment fragment, boolean z10) {
        Fragment parent = this.f15727b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().e(fragment, true);
        }
        Iterator it = this.f15726a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f15729b) {
                aVar.f15728a.onFragmentDetached(this.f15727b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment, boolean z10) {
        Fragment parent = this.f15727b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().f(fragment, true);
        }
        Iterator it = this.f15726a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f15729b) {
                aVar.f15728a.onFragmentPaused(this.f15727b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(Fragment fragment, boolean z10) {
        Context context = this.f15727b.getHost().getContext();
        Fragment parent = this.f15727b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().g(fragment, true);
        }
        Iterator it = this.f15726a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f15729b) {
                aVar.f15728a.onFragmentPreAttached(this.f15727b, fragment, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment parent = this.f15727b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().h(fragment, bundle, true);
        }
        Iterator it = this.f15726a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f15729b) {
                aVar.f15728a.onFragmentPreCreated(this.f15727b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i(Fragment fragment, boolean z10) {
        Fragment parent = this.f15727b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().i(fragment, true);
        }
        Iterator it = this.f15726a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f15729b) {
                aVar.f15728a.onFragmentResumed(this.f15727b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment parent = this.f15727b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().j(fragment, bundle, true);
        }
        Iterator it = this.f15726a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f15729b) {
                aVar.f15728a.onFragmentSaveInstanceState(this.f15727b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k(Fragment fragment, boolean z10) {
        Fragment parent = this.f15727b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().k(fragment, true);
        }
        Iterator it = this.f15726a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f15729b) {
                aVar.f15728a.onFragmentStarted(this.f15727b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l(Fragment fragment, boolean z10) {
        Fragment parent = this.f15727b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().l(fragment, true);
        }
        Iterator it = this.f15726a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f15729b) {
                aVar.f15728a.onFragmentStopped(this.f15727b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m(Fragment fragment, View view, Bundle bundle, boolean z10) {
        Fragment parent = this.f15727b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().m(fragment, view, bundle, true);
        }
        Iterator it = this.f15726a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f15729b) {
                aVar.f15728a.onFragmentViewCreated(this.f15727b, fragment, view, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void n(Fragment fragment, boolean z10) {
        Fragment parent = this.f15727b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().n(fragment, true);
        }
        Iterator it = this.f15726a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.f15729b) {
                aVar.f15728a.onFragmentViewDestroyed(this.f15727b, fragment);
            }
        }
    }

    public void o(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z10) {
        this.f15726a.add(new a(fragmentLifecycleCallbacks, z10));
    }

    public void p(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        synchronized (this.f15726a) {
            try {
                int size = this.f15726a.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        break;
                    } else if (((a) this.f15726a.get(i10)).f15728a == fragmentLifecycleCallbacks) {
                        this.f15726a.remove(i10);
                        break;
                    } else {
                        i10++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
