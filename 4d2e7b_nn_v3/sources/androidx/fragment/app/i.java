package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class i {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f15746a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap f15747b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private g f15748c;

    i() {
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (!this.f15746a.contains(fragment)) {
            synchronized (this.f15746a) {
                this.f15746a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f15747b.values().removeAll(Collections.singleton((Object) null));
    }

    /* access modifiers changed from: package-private */
    public boolean c(String str) {
        if (this.f15747b.get(str) != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void d(int i10) {
        for (h hVar : this.f15747b.values()) {
            if (hVar != null) {
                hVar.u(i10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f15747b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (h hVar : this.f15747b.values()) {
                printWriter.print(str);
                if (hVar != null) {
                    Fragment k10 = hVar.k();
                    printWriter.println(k10);
                    k10.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f15746a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size; i10++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(((Fragment) this.f15746a.get(i10)).toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment f(String str) {
        h hVar = (h) this.f15747b.get(str);
        if (hVar != null) {
            return hVar.k();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment g(int i10) {
        for (int size = this.f15746a.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f15746a.get(size);
            if (fragment != null && fragment.mFragmentId == i10) {
                return fragment;
            }
        }
        for (h hVar : this.f15747b.values()) {
            if (hVar != null) {
                Fragment k10 = hVar.k();
                if (k10.mFragmentId == i10) {
                    return k10;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f15746a.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f15746a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (h hVar : this.f15747b.values()) {
            if (hVar != null) {
                Fragment k10 = hVar.k();
                if (str.equals(k10.mTag)) {
                    return k10;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment i(String str) {
        Fragment findFragmentByWho;
        for (h hVar : this.f15747b.values()) {
            if (hVar != null && (findFragmentByWho = hVar.k().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f15746a.indexOf(fragment);
        for (int i10 = indexOf - 1; i10 >= 0; i10--) {
            Fragment fragment2 = (Fragment) this.f15746a.get(i10);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f15746a.size()) {
                return -1;
            }
            Fragment fragment3 = (Fragment) this.f15746a.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f15747b.size();
    }

    /* access modifiers changed from: package-private */
    public List l() {
        ArrayList arrayList = new ArrayList();
        for (h hVar : this.f15747b.values()) {
            if (hVar != null) {
                arrayList.add(hVar);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List m() {
        ArrayList arrayList = new ArrayList();
        for (h hVar : this.f15747b.values()) {
            if (hVar != null) {
                arrayList.add(hVar.k());
            } else {
                arrayList.add((Object) null);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public h n(String str) {
        return (h) this.f15747b.get(str);
    }

    /* access modifiers changed from: package-private */
    public List o() {
        ArrayList arrayList;
        if (this.f15746a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f15746a) {
            arrayList = new ArrayList(this.f15746a);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public g p() {
        return this.f15748c;
    }

    /* access modifiers changed from: package-private */
    public void q(h hVar) {
        Fragment k10 = hVar.k();
        if (!c(k10.mWho)) {
            this.f15747b.put(k10.mWho, hVar);
            if (k10.mRetainInstanceChangedWhileDetached) {
                if (k10.mRetainInstance) {
                    this.f15748c.a(k10);
                } else {
                    this.f15748c.j(k10);
                }
                k10.mRetainInstanceChangedWhileDetached = false;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Added fragment to active set " + k10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(h hVar) {
        Fragment k10 = hVar.k();
        if (k10.mRetainInstance) {
            this.f15748c.j(k10);
        }
        if (((h) this.f15747b.put(k10.mWho, (Object) null)) != null && FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k10);
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        Iterator it = this.f15746a.iterator();
        while (it.hasNext()) {
            h hVar = (h) this.f15747b.get(((Fragment) it.next()).mWho);
            if (hVar != null) {
                hVar.m();
            }
        }
        for (h hVar2 : this.f15747b.values()) {
            if (hVar2 != null) {
                hVar2.m();
                Fragment k10 = hVar2.k();
                if (k10.mRemoving && !k10.isInBackStack()) {
                    r(hVar2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void t(Fragment fragment) {
        synchronized (this.f15746a) {
            this.f15746a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    /* access modifiers changed from: package-private */
    public void u() {
        this.f15747b.clear();
    }

    /* access modifiers changed from: package-private */
    public void v(List list) {
        this.f15746a.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Fragment f10 = f(str);
                if (f10 != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + f10);
                    }
                    a(f10);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList w() {
        ArrayList arrayList = new ArrayList(this.f15747b.size());
        for (h hVar : this.f15747b.values()) {
            if (hVar != null) {
                Fragment k10 = hVar.k();
                FragmentState s10 = hVar.s();
                arrayList.add(s10);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Saved state of " + k10 + ": " + s10.X);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public ArrayList x() {
        synchronized (this.f15746a) {
            try {
                if (this.f15746a.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.f15746a.size());
                Iterator it = this.f15746a.iterator();
                while (it.hasNext()) {
                    Fragment fragment = (Fragment) it.next();
                    arrayList.add(fragment.mWho);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment.mWho + "): " + fragment);
                    }
                }
                return arrayList;
            } finally {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void y(g gVar) {
        this.f15748c = gVar;
    }
}
