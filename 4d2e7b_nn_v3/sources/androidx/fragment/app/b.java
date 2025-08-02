package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.c;
import androidx.fragment.app.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class b extends n {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15663a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.fragment.app.n$e$c[] r0 = androidx.fragment.app.n.e.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15663a = r0
                androidx.fragment.app.n$e$c r1 = androidx.fragment.app.n.e.c.GONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f15663a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.n$e$c r1 = androidx.fragment.app.n.e.c.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f15663a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.n$e$c r1 = androidx.fragment.app.n.e.c.REMOVED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f15663a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.fragment.app.n$e$c r1 = androidx.fragment.app.n.e.c.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.b.a.<clinit>():void");
        }
    }

    /* renamed from: androidx.fragment.app.b$b  reason: collision with other inner class name */
    class C0201b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f15664a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n.e f15665b;

        C0201b(List list, n.e eVar) {
            this.f15664a = list;
            this.f15665b = eVar;
        }

        public void run() {
            if (this.f15664a.contains(this.f15665b)) {
                this.f15664a.remove(this.f15665b);
                b.this.s(this.f15665b);
            }
        }
    }

    class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f15667a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f15668b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f15669c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ n.e f15670d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ k f15671e;

        c(ViewGroup viewGroup, View view, boolean z10, n.e eVar, k kVar) {
            this.f15667a = viewGroup;
            this.f15668b = view;
            this.f15669c = z10;
            this.f15670d = eVar;
            this.f15671e = kVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f15667a.endViewTransition(this.f15668b);
            if (this.f15669c) {
                this.f15670d.e().a(this.f15668b);
            }
            this.f15671e.a();
        }
    }

    class d implements CancellationSignal.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Animator f15673a;

        d(Animator animator) {
            this.f15673a = animator;
        }

        public void onCancel() {
            this.f15673a.end();
        }
    }

    class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f15675a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f15676b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f15677c;

        class a implements Runnable {
            a() {
            }

            public void run() {
                e eVar = e.this;
                eVar.f15675a.endViewTransition(eVar.f15676b);
                e.this.f15677c.a();
            }
        }

        e(ViewGroup viewGroup, View view, k kVar) {
            this.f15675a = viewGroup;
            this.f15676b = view;
            this.f15677c = kVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f15675a.post(new a());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    class f implements CancellationSignal.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f15680a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f15681b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f15682c;

        f(View view, ViewGroup viewGroup, k kVar) {
            this.f15680a = view;
            this.f15681b = viewGroup;
            this.f15682c = kVar;
        }

        public void onCancel() {
            this.f15680a.clearAnimation();
            this.f15681b.endViewTransition(this.f15680a);
            this.f15682c.a();
        }
    }

    class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n.e f15684a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n.e f15685b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f15686c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayMap f15687d;

        g(n.e eVar, n.e eVar2, boolean z10, ArrayMap arrayMap) {
            this.f15684a = eVar;
            this.f15685b = eVar2;
            this.f15686c = z10;
            this.f15687d = arrayMap;
        }

        public void run() {
            j.f(this.f15684a.f(), this.f15685b.f(), this.f15686c, this.f15687d, false);
        }
    }

    class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentTransitionImpl f15689a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f15690b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Rect f15691c;

        h(FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
            this.f15689a = fragmentTransitionImpl;
            this.f15690b = view;
            this.f15691c = rect;
        }

        public void run() {
            this.f15689a.getBoundsOnScreen(this.f15690b, this.f15691c);
        }
    }

    class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f15693a;

        i(ArrayList arrayList) {
            this.f15693a = arrayList;
        }

        public void run() {
            j.B(this.f15693a, 4);
        }
    }

    class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f15695a;

        j(m mVar) {
            this.f15695a = mVar;
        }

        public void run() {
            this.f15695a.a();
        }
    }

    private static class k extends l {

        /* renamed from: c  reason: collision with root package name */
        private boolean f15697c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f15698d = false;

        /* renamed from: e  reason: collision with root package name */
        private c.d f15699e;

        k(n.e eVar, CancellationSignal cancellationSignal, boolean z10) {
            super(eVar, cancellationSignal);
            this.f15697c = z10;
        }

        /* access modifiers changed from: package-private */
        public c.d e(Context context) {
            boolean z10;
            if (this.f15698d) {
                return this.f15699e;
            }
            Fragment f10 = b().f();
            if (b().e() == n.e.c.VISIBLE) {
                z10 = true;
            } else {
                z10 = false;
            }
            c.d c10 = c.c(context, f10, z10, this.f15697c);
            this.f15699e = c10;
            this.f15698d = true;
            return c10;
        }
    }

    private static class l {

        /* renamed from: a  reason: collision with root package name */
        private final n.e f15700a;

        /* renamed from: b  reason: collision with root package name */
        private final CancellationSignal f15701b;

        l(n.e eVar, CancellationSignal cancellationSignal) {
            this.f15700a = eVar;
            this.f15701b = cancellationSignal;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f15700a.d(this.f15701b);
        }

        /* access modifiers changed from: package-private */
        public n.e b() {
            return this.f15700a;
        }

        /* access modifiers changed from: package-private */
        public CancellationSignal c() {
            return this.f15701b;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            n.e.c cVar;
            n.e.c c10 = n.e.c.c(this.f15700a.f().mView);
            n.e.c e10 = this.f15700a.e();
            if (c10 == e10 || (c10 != (cVar = n.e.c.VISIBLE) && e10 != cVar)) {
                return true;
            }
            return false;
        }
    }

    private static class m extends l {

        /* renamed from: c  reason: collision with root package name */
        private final Object f15702c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f15703d;

        /* renamed from: e  reason: collision with root package name */
        private final Object f15704e;

        m(n.e eVar, CancellationSignal cancellationSignal, boolean z10, boolean z11) {
            super(eVar, cancellationSignal);
            Object obj;
            Object obj2;
            boolean z12;
            if (eVar.e() == n.e.c.VISIBLE) {
                if (z10) {
                    obj2 = eVar.f().getReenterTransition();
                } else {
                    obj2 = eVar.f().getEnterTransition();
                }
                this.f15702c = obj2;
                if (z10) {
                    z12 = eVar.f().getAllowReturnTransitionOverlap();
                } else {
                    z12 = eVar.f().getAllowEnterTransitionOverlap();
                }
                this.f15703d = z12;
            } else {
                if (z10) {
                    obj = eVar.f().getReturnTransition();
                } else {
                    obj = eVar.f().getExitTransition();
                }
                this.f15702c = obj;
                this.f15703d = true;
            }
            if (!z11) {
                this.f15704e = null;
            } else if (z10) {
                this.f15704e = eVar.f().getSharedElementReturnTransition();
            } else {
                this.f15704e = eVar.f().getSharedElementEnterTransition();
            }
        }

        private FragmentTransitionImpl f(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = j.f15750b;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = j.f15751c;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        /* access modifiers changed from: package-private */
        public FragmentTransitionImpl e() {
            FragmentTransitionImpl f10 = f(this.f15702c);
            FragmentTransitionImpl f11 = f(this.f15704e);
            if (f10 != null && f11 != null && f10 != f11) {
                throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f15702c + " which uses a different Transition  type than its shared element transition " + this.f15704e);
            } else if (f10 != null) {
                return f10;
            } else {
                return f11;
            }
        }

        public Object g() {
            return this.f15704e;
        }

        /* access modifiers changed from: package-private */
        public Object h() {
            return this.f15702c;
        }

        public boolean i() {
            if (this.f15704e != null) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return this.f15703d;
        }
    }

    b(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List list, List list2, boolean z10, Map map) {
        boolean z11;
        ViewGroup m10 = m();
        Context context = m10.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z12 = false;
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (kVar.d()) {
                kVar.a();
            } else {
                c.d e10 = kVar.e(context);
                if (e10 == null) {
                    kVar.a();
                } else {
                    Animator animator = e10.f15717b;
                    if (animator == null) {
                        arrayList.add(kVar);
                    } else {
                        n.e b10 = kVar.b();
                        Fragment f10 = b10.f();
                        if (Boolean.TRUE.equals(map.get(b10))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + f10 + " as this Fragment was involved in a Transition.");
                            }
                            kVar.a();
                        } else {
                            if (b10.e() == n.e.c.GONE) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            List list3 = list2;
                            if (z11) {
                                list3.remove(b10);
                            }
                            View view = f10.mView;
                            m10.startViewTransition(view);
                            c cVar = r0;
                            c cVar2 = new c(m10, view, z11, b10, kVar);
                            animator.addListener(cVar);
                            animator.setTarget(view);
                            animator.start();
                            kVar.c().setOnCancelListener(new d(animator));
                            z12 = true;
                        }
                    }
                }
            }
            Map map2 = map;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            k kVar2 = (k) it2.next();
            n.e b11 = kVar2.b();
            Fragment f11 = b11.f();
            if (z10) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f11 + " as Animations cannot run alongside Transitions.");
                }
                kVar2.a();
            } else if (z12) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f11 + " as Animations cannot run alongside Animators.");
                }
                kVar2.a();
            } else {
                View view2 = f11.mView;
                Animation animation = (Animation) Preconditions.checkNotNull(((c.d) Preconditions.checkNotNull(kVar2.e(context))).f15716a);
                if (b11.e() != n.e.c.REMOVED) {
                    view2.startAnimation(animation);
                    kVar2.a();
                } else {
                    m10.startViewTransition(view2);
                    c.e eVar = new c.e(animation, m10, view2);
                    eVar.setAnimationListener(new e(m10, view2, kVar2));
                    view2.startAnimation(eVar);
                }
                kVar2.c().setOnCancelListener(new f(view2, m10, kVar2));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map x(java.util.List r32, java.util.List r33, boolean r34, androidx.fragment.app.n.e r35, androidx.fragment.app.n.e r36) {
        /*
            r31 = this;
            r6 = r31
            r7 = r34
            r8 = r35
            r9 = r36
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.Iterator r0 = r32.iterator()
            r15 = 0
        L_0x0012:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0062
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.b$m r1 = (androidx.fragment.app.b.m) r1
            boolean r2 = r1.d()
            if (r2 == 0) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            androidx.fragment.app.FragmentTransitionImpl r2 = r1.e()
            if (r15 != 0) goto L_0x002d
            r15 = r2
            goto L_0x0012
        L_0x002d:
            if (r2 == 0) goto L_0x0012
            if (r15 != r2) goto L_0x0032
            goto L_0x0012
        L_0x0032:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Mixing framework transitions and AndroidX transitions is not allowed. Fragment "
            r2.append(r3)
            androidx.fragment.app.n$e r3 = r1.b()
            androidx.fragment.app.Fragment r3 = r3.f()
            r2.append(r3)
            java.lang.String r3 = " returned Transition "
            r2.append(r3)
            java.lang.Object r1 = r1.h()
            r2.append(r1)
            java.lang.String r1 = " which uses a different Transition  type than other Fragments."
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0062:
            if (r15 != 0) goto L_0x0082
            java.util.Iterator r0 = r32.iterator()
        L_0x0068:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0081
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.b$m r1 = (androidx.fragment.app.b.m) r1
            androidx.fragment.app.n$e r2 = r1.b()
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r10.put(r2, r3)
            r1.a()
            goto L_0x0068
        L_0x0081:
            return r10
        L_0x0082:
            android.view.View r14 = new android.view.View
            android.view.ViewGroup r0 = r31.m()
            android.content.Context r0 = r0.getContext()
            r14.<init>(r0)
            android.graphics.Rect r13 = new android.graphics.Rect
            r13.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            java.util.Iterator r20 = r32.iterator()
            r0 = 0
            r2 = 0
            r21 = 0
        L_0x00ab:
            boolean r1 = r20.hasNext()
            if (r1 == 0) goto L_0x0308
            java.lang.Object r1 = r20.next()
            androidx.fragment.app.b$m r1 = (androidx.fragment.app.b.m) r1
            boolean r16 = r1.i()
            if (r16 == 0) goto L_0x02eb
            if (r8 == 0) goto L_0x02eb
            if (r9 == 0) goto L_0x02eb
            java.lang.Object r0 = r1.g()
            java.lang.Object r0 = r15.cloneTransition(r0)
            java.lang.Object r1 = r15.wrapTransitionInSet(r0)
            androidx.fragment.app.Fragment r0 = r36.f()
            java.util.ArrayList r0 = r0.getSharedElementSourceNames()
            androidx.fragment.app.Fragment r16 = r35.f()
            java.util.ArrayList r3 = r16.getSharedElementSourceNames()
            androidx.fragment.app.Fragment r16 = r35.f()
            java.util.ArrayList r11 = r16.getSharedElementTargetNames()
            r16 = r1
            r18 = r2
            r1 = 0
        L_0x00ea:
            int r2 = r11.size()
            if (r1 >= r2) goto L_0x0109
            java.lang.Object r2 = r11.get(r1)
            int r2 = r0.indexOf(r2)
            r19 = r11
            r11 = -1
            if (r2 == r11) goto L_0x0104
            java.lang.Object r11 = r3.get(r1)
            r0.set(r2, r11)
        L_0x0104:
            int r1 = r1 + 1
            r11 = r19
            goto L_0x00ea
        L_0x0109:
            androidx.fragment.app.Fragment r1 = r36.f()
            java.util.ArrayList r11 = r1.getSharedElementTargetNames()
            if (r7 != 0) goto L_0x0124
            androidx.fragment.app.Fragment r1 = r35.f()
            androidx.core.app.SharedElementCallback r1 = r1.getExitTransitionCallback()
            androidx.fragment.app.Fragment r2 = r36.f()
            androidx.core.app.SharedElementCallback r2 = r2.getEnterTransitionCallback()
            goto L_0x0134
        L_0x0124:
            androidx.fragment.app.Fragment r1 = r35.f()
            androidx.core.app.SharedElementCallback r1 = r1.getEnterTransitionCallback()
            androidx.fragment.app.Fragment r2 = r36.f()
            androidx.core.app.SharedElementCallback r2 = r2.getExitTransitionCallback()
        L_0x0134:
            int r3 = r0.size()
            r9 = 0
        L_0x0139:
            if (r9 >= r3) goto L_0x0157
            java.lang.Object r19 = r0.get(r9)
            r23 = r3
            r3 = r19
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r19 = r11.get(r9)
            r8 = r19
            java.lang.String r8 = (java.lang.String) r8
            r4.put(r3, r8)
            int r9 = r9 + 1
            r8 = r35
            r3 = r23
            goto L_0x0139
        L_0x0157:
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            androidx.fragment.app.Fragment r3 = r35.f()
            android.view.View r3 = r3.mView
            r6.u(r8, r3)
            r8.retainAll(r0)
            if (r1 == 0) goto L_0x01aa
            r1.onMapSharedElements(r0, r8)
            int r1 = r0.size()
            r3 = 1
            int r1 = r1 - r3
        L_0x0173:
            if (r1 < 0) goto L_0x01a7
            java.lang.Object r3 = r0.get(r1)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r9 = r8.get(r3)
            android.view.View r9 = (android.view.View) r9
            if (r9 != 0) goto L_0x0189
            r4.remove(r3)
            r19 = r0
            goto L_0x01a2
        L_0x0189:
            r19 = r0
            java.lang.String r0 = androidx.core.view.ViewCompat.getTransitionName(r9)
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x01a2
            java.lang.Object r0 = r4.remove(r3)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r3 = androidx.core.view.ViewCompat.getTransitionName(r9)
            r4.put(r3, r0)
        L_0x01a2:
            int r1 = r1 + -1
            r0 = r19
            goto L_0x0173
        L_0x01a7:
            r19 = r0
            goto L_0x01b3
        L_0x01aa:
            r19 = r0
            java.util.Set r0 = r8.keySet()
            r4.retainAll(r0)
        L_0x01b3:
            androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap
            r9.<init>()
            androidx.fragment.app.Fragment r0 = r36.f()
            android.view.View r0 = r0.mView
            r6.u(r9, r0)
            r9.retainAll(r11)
            java.util.Collection r0 = r4.values()
            r9.retainAll(r0)
            if (r2 == 0) goto L_0x020a
            r2.onMapSharedElements(r11, r9)
            int r0 = r11.size()
            r1 = 1
            int r0 = r0 - r1
        L_0x01d6:
            if (r0 < 0) goto L_0x020d
            java.lang.Object r1 = r11.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r9.get(r1)
            android.view.View r2 = (android.view.View) r2
            if (r2 != 0) goto L_0x01f0
            java.lang.String r1 = androidx.fragment.app.j.q(r4, r1)
            if (r1 == 0) goto L_0x0207
            r4.remove(r1)
            goto L_0x0207
        L_0x01f0:
            java.lang.String r3 = androidx.core.view.ViewCompat.getTransitionName(r2)
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0207
            java.lang.String r1 = androidx.fragment.app.j.q(r4, r1)
            if (r1 == 0) goto L_0x0207
            java.lang.String r2 = androidx.core.view.ViewCompat.getTransitionName(r2)
            r4.put(r1, r2)
        L_0x0207:
            int r0 = r0 + -1
            goto L_0x01d6
        L_0x020a:
            androidx.fragment.app.j.y(r4, r9)
        L_0x020d:
            java.util.Set r0 = r4.keySet()
            r6.v(r8, r0)
            java.util.Collection r0 = r4.values()
            r6.v(r9, r0)
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x0239
            r12.clear()
            r5.clear()
            r3 = r35
            r26 = r4
            r1 = r5
            r5 = r6
            r4 = r12
            r8 = r13
            r9 = r14
            r11 = r15
            r2 = r18
            r0 = 0
            r6 = 0
            r15 = r36
            goto L_0x02fa
        L_0x0239:
            androidx.fragment.app.Fragment r0 = r36.f()
            androidx.fragment.app.Fragment r1 = r35.f()
            r3 = 1
            androidx.fragment.app.j.f(r0, r1, r7, r8, r3)
            android.view.ViewGroup r2 = r31.m()
            androidx.fragment.app.b$g r1 = new androidx.fragment.app.b$g
            r22 = r19
            r0 = r1
            r23 = r10
            r7 = r16
            r10 = r1
            r1 = r31
            r16 = r14
            r24 = r18
            r14 = r2
            r2 = r36
            r25 = r3
            r6 = 0
            r3 = r35
            r26 = r4
            r4 = r34
            r27 = r5
            r5 = r9
            r0.<init>(r2, r3, r4, r5)
            androidx.core.view.OneShotPreDrawListener.add(r14, r10)
            java.util.Collection r0 = r8.values()
            r12.addAll(r0)
            boolean r0 = r22.isEmpty()
            if (r0 != 0) goto L_0x028e
            r0 = r22
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            android.view.View r2 = (android.view.View) r2
            r15.setEpicenter((java.lang.Object) r7, (android.view.View) r2)
            goto L_0x0290
        L_0x028e:
            r2 = r24
        L_0x0290:
            java.util.Collection r0 = r9.values()
            r1 = r27
            r1.addAll(r0)
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x02c0
            java.lang.Object r0 = r11.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r9.get(r0)
            android.view.View r0 = (android.view.View) r0
            if (r0 == 0) goto L_0x02c0
            android.view.ViewGroup r3 = r31.m()
            androidx.fragment.app.b$h r4 = new androidx.fragment.app.b$h
            r5 = r31
            r4.<init>(r15, r0, r13)
            androidx.core.view.OneShotPreDrawListener.add(r3, r4)
            r0 = r16
            r21 = r25
            goto L_0x02c4
        L_0x02c0:
            r5 = r31
            r0 = r16
        L_0x02c4:
            r15.setSharedElementTargets(r7, r0, r12)
            r16 = 0
            r17 = 0
            r14 = 0
            r3 = 0
            r4 = r12
            r12 = r15
            r8 = r13
            r13 = r7
            r9 = r0
            r11 = r15
            r15 = r3
            r18 = r7
            r19 = r1
            r12.scheduleRemoveTargets(r13, r14, r15, r16, r17, r18, r19)
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r3 = r35
            r10 = r23
            r10.put(r3, r0)
            r15 = r36
            r10.put(r15, r0)
            r0 = r7
            goto L_0x02fa
        L_0x02eb:
            r24 = r2
            r26 = r4
            r1 = r5
            r5 = r6
            r3 = r8
            r4 = r12
            r8 = r13
            r11 = r15
            r6 = 0
            r15 = r9
            r9 = r14
            r2 = r24
        L_0x02fa:
            r7 = r34
            r12 = r4
            r6 = r5
            r13 = r8
            r14 = r9
            r9 = r15
            r4 = r26
            r5 = r1
            r8 = r3
            r15 = r11
            goto L_0x00ab
        L_0x0308:
            r24 = r2
            r26 = r4
            r1 = r5
            r5 = r6
            r3 = r8
            r4 = r12
            r8 = r13
            r11 = r15
            r6 = 0
            r25 = 1
            r15 = r9
            r9 = r14
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r7 = r32.iterator()
            r13 = 0
            r14 = 0
        L_0x0322:
            boolean r12 = r7.hasNext()
            if (r12 == 0) goto L_0x0444
            java.lang.Object r12 = r7.next()
            r20 = r12
            androidx.fragment.app.b$m r20 = (androidx.fragment.app.b.m) r20
            boolean r12 = r20.d()
            if (r12 == 0) goto L_0x0344
            androidx.fragment.app.n$e r12 = r20.b()
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r10.put(r12, r6)
            r20.a()
            r6 = 0
            goto L_0x0322
        L_0x0344:
            java.lang.Object r6 = r20.h()
            java.lang.Object r6 = r11.cloneTransition(r6)
            androidx.fragment.app.n$e r12 = r20.b()
            if (r0 == 0) goto L_0x0359
            if (r12 == r3) goto L_0x0356
            if (r12 != r15) goto L_0x0359
        L_0x0356:
            r16 = r25
            goto L_0x035b
        L_0x0359:
            r16 = 0
        L_0x035b:
            if (r6 != 0) goto L_0x0378
            if (r16 != 0) goto L_0x0367
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r10.put(r12, r6)
            r20.a()
        L_0x0367:
            r12 = r33
            r30 = r1
            r29 = r4
            r34 = r7
            r27 = r9
            r6 = r13
            r1 = r15
            r7 = r24
            r13 = 0
            goto L_0x0435
        L_0x0378:
            r34 = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r17 = r13
            androidx.fragment.app.Fragment r13 = r12.f()
            android.view.View r13 = r13.mView
            r5.t(r7, r13)
            if (r16 == 0) goto L_0x0395
            if (r12 != r3) goto L_0x0392
            r7.removeAll(r4)
            goto L_0x0395
        L_0x0392:
            r7.removeAll(r1)
        L_0x0395:
            boolean r13 = r7.isEmpty()
            if (r13 == 0) goto L_0x03ac
            r11.addTarget(r6, r9)
            r30 = r1
            r29 = r4
            r27 = r9
            r13 = r12
            r4 = r14
            r1 = r15
            r9 = r17
            r12 = r33
            goto L_0x0404
        L_0x03ac:
            r11.addTargets(r6, r7)
            r18 = 0
            r19 = 0
            r16 = 0
            r23 = 0
            r13 = r12
            r12 = r11
            r27 = r9
            r28 = r13
            r9 = r17
            r13 = r6
            r29 = r4
            r4 = r14
            r14 = r6
            r30 = r1
            r1 = r15
            r15 = r7
            r17 = r23
            r12.scheduleRemoveTargets(r13, r14, r15, r16, r17, r18, r19)
            androidx.fragment.app.n$e$c r12 = r28.e()
            androidx.fragment.app.n$e$c r13 = androidx.fragment.app.n.e.c.GONE
            if (r12 != r13) goto L_0x0400
            r12 = r33
            r13 = r28
            r12.remove(r13)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>(r7)
            androidx.fragment.app.Fragment r15 = r13.f()
            android.view.View r15 = r15.mView
            r14.remove(r15)
            androidx.fragment.app.Fragment r15 = r13.f()
            android.view.View r15 = r15.mView
            r11.scheduleHideFragmentView(r6, r15, r14)
            android.view.ViewGroup r14 = r31.m()
            androidx.fragment.app.b$i r15 = new androidx.fragment.app.b$i
            r15.<init>(r7)
            androidx.core.view.OneShotPreDrawListener.add(r14, r15)
            goto L_0x0404
        L_0x0400:
            r12 = r33
            r13 = r28
        L_0x0404:
            androidx.fragment.app.n$e$c r14 = r13.e()
            androidx.fragment.app.n$e$c r15 = androidx.fragment.app.n.e.c.VISIBLE
            if (r14 != r15) goto L_0x0417
            r2.addAll(r7)
            if (r21 == 0) goto L_0x0414
            r11.setEpicenter((java.lang.Object) r6, (android.graphics.Rect) r8)
        L_0x0414:
            r7 = r24
            goto L_0x041c
        L_0x0417:
            r7 = r24
            r11.setEpicenter((java.lang.Object) r6, (android.view.View) r7)
        L_0x041c:
            java.lang.Boolean r14 = java.lang.Boolean.TRUE
            r10.put(r13, r14)
            boolean r13 = r20.j()
            if (r13 == 0) goto L_0x042f
            r13 = 0
            java.lang.Object r4 = r11.mergeTransitionsTogether(r4, r6, r13)
            r14 = r4
            r6 = r9
            goto L_0x0435
        L_0x042f:
            r13 = 0
            java.lang.Object r6 = r11.mergeTransitionsTogether(r9, r6, r13)
            r14 = r4
        L_0x0435:
            r15 = r1
            r13 = r6
            r24 = r7
            r9 = r27
            r4 = r29
            r1 = r30
            r6 = 0
            r7 = r34
            goto L_0x0322
        L_0x0444:
            r30 = r1
            r29 = r4
            r9 = r13
            r4 = r14
            r1 = r15
            java.lang.Object r4 = r11.mergeTransitionsInSequence(r4, r9, r0)
            java.util.Iterator r6 = r32.iterator()
        L_0x0453:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x04c8
            java.lang.Object r7 = r6.next()
            androidx.fragment.app.b$m r7 = (androidx.fragment.app.b.m) r7
            boolean r8 = r7.d()
            if (r8 == 0) goto L_0x0466
            goto L_0x0453
        L_0x0466:
            java.lang.Object r8 = r7.h()
            androidx.fragment.app.n$e r9 = r7.b()
            if (r0 == 0) goto L_0x0477
            if (r9 == r3) goto L_0x0474
            if (r9 != r1) goto L_0x0477
        L_0x0474:
            r12 = r25
            goto L_0x0478
        L_0x0477:
            r12 = 0
        L_0x0478:
            if (r8 != 0) goto L_0x047c
            if (r12 == 0) goto L_0x0453
        L_0x047c:
            android.view.ViewGroup r8 = r31.m()
            boolean r8 = androidx.core.view.ViewCompat.isLaidOut(r8)
            if (r8 != 0) goto L_0x04b3
            r8 = 2
            boolean r8 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r8)
            if (r8 == 0) goto L_0x04af
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r12 = "SpecialEffectsController: Container "
            r8.append(r12)
            android.view.ViewGroup r12 = r31.m()
            r8.append(r12)
            java.lang.String r12 = " has not been laid out. Completing operation "
            r8.append(r12)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "FragmentManager"
            android.util.Log.v(r9, r8)
        L_0x04af:
            r7.a()
            goto L_0x0453
        L_0x04b3:
            androidx.fragment.app.n$e r8 = r7.b()
            androidx.fragment.app.Fragment r8 = r8.f()
            androidx.core.os.CancellationSignal r9 = r7.c()
            androidx.fragment.app.b$j r12 = new androidx.fragment.app.b$j
            r12.<init>(r7)
            r11.setListenerForTransitionEnd(r8, r4, r9, r12)
            goto L_0x0453
        L_0x04c8:
            android.view.ViewGroup r1 = r31.m()
            boolean r1 = androidx.core.view.ViewCompat.isLaidOut(r1)
            if (r1 != 0) goto L_0x04d3
            return r10
        L_0x04d3:
            r1 = 4
            androidx.fragment.app.j.B(r2, r1)
            r1 = r30
            java.util.ArrayList r16 = r11.prepareSetNameOverridesReordered(r1)
            android.view.ViewGroup r3 = r31.m()
            r11.beginDelayedTransition(r3, r4)
            android.view.ViewGroup r13 = r31.m()
            r12 = r11
            r14 = r29
            r15 = r1
            r17 = r26
            r12.setNameOverridesReordered(r13, r14, r15, r16, r17)
            r3 = 0
            androidx.fragment.app.j.B(r2, r3)
            r2 = r29
            r11.swapSharedElementTargets(r0, r2, r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.b.x(java.util.List, java.util.List, boolean, androidx.fragment.app.n$e, androidx.fragment.app.n$e):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    public void f(List list, boolean z10) {
        Iterator it = list.iterator();
        n.e eVar = null;
        n.e eVar2 = null;
        while (it.hasNext()) {
            n.e eVar3 = (n.e) it.next();
            n.e.c c10 = n.e.c.c(eVar3.f().mView);
            int i10 = a.f15663a[eVar3.e().ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                if (c10 == n.e.c.VISIBLE && eVar == null) {
                    eVar = eVar3;
                }
            } else if (i10 == 4 && c10 != n.e.c.VISIBLE) {
                eVar2 = eVar3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<n.e> arrayList3 = new ArrayList<>(list);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            n.e eVar4 = (n.e) it2.next();
            CancellationSignal cancellationSignal = new CancellationSignal();
            eVar4.j(cancellationSignal);
            arrayList.add(new k(eVar4, cancellationSignal, z10));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            eVar4.j(cancellationSignal2);
            boolean z11 = false;
            if (z10) {
                if (eVar4 != eVar) {
                    arrayList2.add(new m(eVar4, cancellationSignal2, z10, z11));
                    eVar4.a(new C0201b(arrayList3, eVar4));
                }
            } else if (eVar4 != eVar2) {
                arrayList2.add(new m(eVar4, cancellationSignal2, z10, z11));
                eVar4.a(new C0201b(arrayList3, eVar4));
            }
            z11 = true;
            arrayList2.add(new m(eVar4, cancellationSignal2, z10, z11));
            eVar4.a(new C0201b(arrayList3, eVar4));
        }
        Map x10 = x(arrayList2, arrayList3, z10, eVar, eVar2);
        w(arrayList, arrayList3, x10.containsValue(Boolean.TRUE), x10);
        for (n.e s10 : arrayList3) {
            s(s10);
        }
        arrayList3.clear();
    }

    /* access modifiers changed from: package-private */
    public void s(n.e eVar) {
        eVar.e().a(eVar.f().mView);
    }

    /* access modifiers changed from: package-private */
    public void t(ArrayList arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!ViewGroupCompat.isTransitionGroup(viewGroup)) {
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    if (childAt.getVisibility() == 0) {
                        t(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    /* access modifiers changed from: package-private */
    public void u(Map map, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v(ArrayMap arrayMap, Collection collection) {
        Iterator it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName((View) ((Map.Entry) it.next()).getValue()))) {
                it.remove();
            }
        }
    }
}
