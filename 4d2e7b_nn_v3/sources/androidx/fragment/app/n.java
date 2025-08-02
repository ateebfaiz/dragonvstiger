package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

abstract class n {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f15814a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList f15815b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList f15816c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    boolean f15817d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f15818e = false;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f15819a;

        a(d dVar) {
            this.f15819a = dVar;
        }

        public void run() {
            if (n.this.f15815b.contains(this.f15819a)) {
                this.f15819a.e().a(this.f15819a.f().mView);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f15821a;

        b(d dVar) {
            this.f15821a = dVar;
        }

        public void run() {
            n.this.f15815b.remove(this.f15821a);
            n.this.f15816c.remove(this.f15821a);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15823a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f15824b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            /*
                androidx.fragment.app.n$e$b[] r0 = androidx.fragment.app.n.e.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15824b = r0
                r1 = 1
                androidx.fragment.app.n$e$b r2 = androidx.fragment.app.n.e.b.ADDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f15824b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.n$e$b r3 = androidx.fragment.app.n.e.b.REMOVING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f15824b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.n$e$b r4 = androidx.fragment.app.n.e.b.NONE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                androidx.fragment.app.n$e$c[] r3 = androidx.fragment.app.n.e.c.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f15823a = r3
                androidx.fragment.app.n$e$c r4 = androidx.fragment.app.n.e.c.REMOVED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f15823a     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.fragment.app.n$e$c r3 = androidx.fragment.app.n.e.c.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f15823a     // Catch:{ NoSuchFieldError -> 0x004d }
                androidx.fragment.app.n$e$c r1 = androidx.fragment.app.n.e.c.GONE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f15823a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.fragment.app.n$e$c r1 = androidx.fragment.app.n.e.c.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.n.c.<clinit>():void");
        }
    }

    private static class d extends e {

        /* renamed from: h  reason: collision with root package name */
        private final h f15825h;

        d(e.c cVar, e.b bVar, h hVar, CancellationSignal cancellationSignal) {
            super(cVar, bVar, hVar.k(), cancellationSignal);
            this.f15825h = hVar;
        }

        public void c() {
            super.c();
            this.f15825h.m();
        }

        /* access modifiers changed from: package-private */
        public void l() {
            if (g() == e.b.ADDING) {
                Fragment k10 = this.f15825h.k();
                View findFocus = k10.mView.findFocus();
                if (findFocus != null) {
                    k10.setFocusedView(findFocus);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + k10);
                    }
                }
                View requireView = f().requireView();
                if (requireView.getParent() == null) {
                    this.f15825h.b();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(k10.getPostOnViewCreatedAlpha());
            }
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        private c f15826a;

        /* renamed from: b  reason: collision with root package name */
        private b f15827b;

        /* renamed from: c  reason: collision with root package name */
        private final Fragment f15828c;

        /* renamed from: d  reason: collision with root package name */
        private final List f15829d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private final HashSet f15830e = new HashSet();

        /* renamed from: f  reason: collision with root package name */
        private boolean f15831f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f15832g = false;

        class a implements CancellationSignal.OnCancelListener {
            a() {
            }

            public void onCancel() {
                e.this.b();
            }
        }

        enum b {
            NONE,
            ADDING,
            REMOVING
        }

        enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            static c b(int i10) {
                if (i10 == 0) {
                    return VISIBLE;
                }
                if (i10 == 4) {
                    return INVISIBLE;
                }
                if (i10 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i10);
            }

            static c c(View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return b(view.getVisibility());
            }

            /* access modifiers changed from: package-private */
            public void a(View view) {
                int i10 = c.f15823a[ordinal()];
                if (i10 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                    }
                } else if (i10 == 2) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                } else if (i10 == 3) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                } else if (i10 == 4) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                    }
                    view.setVisibility(4);
                }
            }
        }

        e(c cVar, b bVar, Fragment fragment, CancellationSignal cancellationSignal) {
            this.f15826a = cVar;
            this.f15827b = bVar;
            this.f15828c = fragment;
            cancellationSignal.setOnCancelListener(new a());
        }

        /* access modifiers changed from: package-private */
        public final void a(Runnable runnable) {
            this.f15829d.add(runnable);
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            if (!h()) {
                this.f15831f = true;
                if (this.f15830e.isEmpty()) {
                    c();
                    return;
                }
                Iterator it = new ArrayList(this.f15830e).iterator();
                while (it.hasNext()) {
                    ((CancellationSignal) it.next()).cancel();
                }
            }
        }

        public void c() {
            if (!this.f15832g) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
                }
                this.f15832g = true;
                for (Runnable run : this.f15829d) {
                    run.run();
                }
            }
        }

        public final void d(CancellationSignal cancellationSignal) {
            if (this.f15830e.remove(cancellationSignal) && this.f15830e.isEmpty()) {
                c();
            }
        }

        public c e() {
            return this.f15826a;
        }

        public final Fragment f() {
            return this.f15828c;
        }

        /* access modifiers changed from: package-private */
        public b g() {
            return this.f15827b;
        }

        /* access modifiers changed from: package-private */
        public final boolean h() {
            return this.f15831f;
        }

        /* access modifiers changed from: package-private */
        public final boolean i() {
            return this.f15832g;
        }

        public final void j(CancellationSignal cancellationSignal) {
            l();
            this.f15830e.add(cancellationSignal);
        }

        /* access modifiers changed from: package-private */
        public final void k(c cVar, b bVar) {
            int i10 = c.f15824b[bVar.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f15828c + " mFinalState = " + this.f15826a + " -> REMOVED. mLifecycleImpact  = " + this.f15827b + " to REMOVING.");
                    }
                    this.f15826a = c.REMOVED;
                    this.f15827b = b.REMOVING;
                } else if (i10 == 3 && this.f15826a != c.REMOVED) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f15828c + " mFinalState = " + this.f15826a + " -> " + cVar + ". ");
                    }
                    this.f15826a = cVar;
                }
            } else if (this.f15826a == c.REMOVED) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f15828c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f15827b + " to ADDING.");
                }
                this.f15826a = c.VISIBLE;
                this.f15827b = b.ADDING;
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void l();

        public String toString() {
            return "Operation " + "{" + Integer.toHexString(System.identityHashCode(this)) + "} " + "{" + "mFinalState = " + this.f15826a + "} " + "{" + "mLifecycleImpact = " + this.f15827b + "} " + "{" + "mFragment = " + this.f15828c + "}";
        }
    }

    n(ViewGroup viewGroup) {
        this.f15814a = viewGroup;
    }

    private void a(e.c cVar, e.b bVar, h hVar) {
        synchronized (this.f15815b) {
            try {
                CancellationSignal cancellationSignal = new CancellationSignal();
                e h10 = h(hVar.k());
                if (h10 != null) {
                    h10.k(cVar, bVar);
                    return;
                }
                d dVar = new d(cVar, bVar, hVar, cancellationSignal);
                this.f15815b.add(dVar);
                dVar.a(new a(dVar));
                dVar.a(new b(dVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private e h(Fragment fragment) {
        Iterator it = this.f15815b.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    private e i(Fragment fragment) {
        Iterator it = this.f15816c.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    static n n(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.getSpecialEffectsControllerFactory());
    }

    static n o(ViewGroup viewGroup, o oVar) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof n) {
            return (n) tag;
        }
        n a10 = oVar.a(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, a10);
        return a10;
    }

    private void q() {
        Iterator it = this.f15815b.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.g() == e.b.ADDING) {
                eVar.k(e.c.b(eVar.f().requireView().getVisibility()), e.b.NONE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(e.c cVar, h hVar) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + hVar.k());
        }
        a(cVar, e.b.ADDING, hVar);
    }

    /* access modifiers changed from: package-private */
    public void c(h hVar) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + hVar.k());
        }
        a(e.c.GONE, e.b.NONE, hVar);
    }

    /* access modifiers changed from: package-private */
    public void d(h hVar) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + hVar.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, hVar);
    }

    /* access modifiers changed from: package-private */
    public void e(h hVar) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + hVar.k());
        }
        a(e.c.VISIBLE, e.b.NONE, hVar);
    }

    /* access modifiers changed from: package-private */
    public abstract void f(List list, boolean z10);

    /* access modifiers changed from: package-private */
    public void g() {
        if (!this.f15818e) {
            if (!ViewCompat.isAttachedToWindow(this.f15814a)) {
                j();
                this.f15817d = false;
                return;
            }
            synchronized (this.f15815b) {
                try {
                    if (!this.f15815b.isEmpty()) {
                        ArrayList arrayList = new ArrayList(this.f15816c);
                        this.f15816c.clear();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            e eVar = (e) it.next();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + eVar);
                            }
                            eVar.b();
                            if (!eVar.i()) {
                                this.f15816c.add(eVar);
                            }
                        }
                        q();
                        ArrayList arrayList2 = new ArrayList(this.f15815b);
                        this.f15815b.clear();
                        this.f15816c.addAll(arrayList2);
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            ((e) it2.next()).l();
                        }
                        f(arrayList2, this.f15817d);
                        this.f15817d = false;
                    }
                } finally {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        String str;
        String str2;
        boolean isAttachedToWindow = ViewCompat.isAttachedToWindow(this.f15814a);
        synchronized (this.f15815b) {
            try {
                q();
                Iterator it = this.f15815b.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).l();
                }
                Iterator it2 = new ArrayList(this.f15816c).iterator();
                while (it2.hasNext()) {
                    e eVar = (e) it2.next();
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (isAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f15814a + " is not attached to window. ";
                        }
                        sb2.append(str2);
                        sb2.append("Cancelling running operation ");
                        sb2.append(eVar);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    eVar.b();
                }
                Iterator it3 = new ArrayList(this.f15815b).iterator();
                while (it3.hasNext()) {
                    e eVar2 = (e) it3.next();
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: ");
                        if (isAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.f15814a + " is not attached to window. ";
                        }
                        sb3.append(str);
                        sb3.append("Cancelling pending operation ");
                        sb3.append(eVar2);
                        Log.v("FragmentManager", sb3.toString());
                    }
                    eVar2.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        if (this.f15818e) {
            this.f15818e = false;
            g();
        }
    }

    /* access modifiers changed from: package-private */
    public e.b l(h hVar) {
        e.b bVar;
        e h10 = h(hVar.k());
        if (h10 != null) {
            bVar = h10.g();
        } else {
            bVar = null;
        }
        e i10 = i(hVar.k());
        if (i10 == null || (bVar != null && bVar != e.b.NONE)) {
            return bVar;
        }
        return i10.g();
    }

    public ViewGroup m() {
        return this.f15814a;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        synchronized (this.f15815b) {
            try {
                q();
                this.f15818e = false;
                int size = this.f15815b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    e eVar = (e) this.f15815b.get(size);
                    e.c c10 = e.c.c(eVar.f().mView);
                    e.c e10 = eVar.e();
                    e.c cVar = e.c.VISIBLE;
                    if (e10 == cVar && c10 != cVar) {
                        this.f15818e = eVar.f().isPostponed();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(boolean z10) {
        this.f15817d = z10;
    }
}
