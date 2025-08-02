package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.transition.FragmentTransitionSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f15749a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    static final FragmentTransitionImpl f15750b = new k();

    /* renamed from: c  reason: collision with root package name */
    static final FragmentTransitionImpl f15751c = x();

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f15752a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f15753b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CancellationSignal f15754c;

        a(g gVar, Fragment fragment, CancellationSignal cancellationSignal) {
            this.f15752a = gVar;
            this.f15753b = fragment;
            this.f15754c = cancellationSignal;
        }

        public void run() {
            this.f15752a.a(this.f15753b, this.f15754c);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f15755a;

        b(ArrayList arrayList) {
            this.f15755a = arrayList;
        }

        public void run() {
            j.B(this.f15755a, 4);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f15756a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f15757b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CancellationSignal f15758c;

        c(g gVar, Fragment fragment, CancellationSignal cancellationSignal) {
            this.f15756a = gVar;
            this.f15757b = fragment;
            this.f15758c = cancellationSignal;
        }

        public void run() {
            this.f15756a.a(this.f15757b, this.f15758c);
        }
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f15759a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FragmentTransitionImpl f15760b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f15761c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Fragment f15762d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f15763e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f15764f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ArrayList f15765g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Object f15766h;

        d(Object obj, FragmentTransitionImpl fragmentTransitionImpl, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f15759a = obj;
            this.f15760b = fragmentTransitionImpl;
            this.f15761c = view;
            this.f15762d = fragment;
            this.f15763e = arrayList;
            this.f15764f = arrayList2;
            this.f15765g = arrayList3;
            this.f15766h = obj2;
        }

        public void run() {
            Object obj = this.f15759a;
            if (obj != null) {
                this.f15760b.removeTarget(obj, this.f15761c);
                this.f15764f.addAll(j.k(this.f15760b, this.f15759a, this.f15762d, this.f15763e, this.f15761c));
            }
            if (this.f15765g != null) {
                if (this.f15766h != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f15761c);
                    this.f15760b.replaceTargets(this.f15766h, this.f15765g, arrayList);
                }
                this.f15765g.clear();
                this.f15765g.add(this.f15761c);
            }
        }
    }

    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f15767a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f15768b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f15769c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayMap f15770d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f15771e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ FragmentTransitionImpl f15772f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Rect f15773g;

        e(Fragment fragment, Fragment fragment2, boolean z10, ArrayMap arrayMap, View view, FragmentTransitionImpl fragmentTransitionImpl, Rect rect) {
            this.f15767a = fragment;
            this.f15768b = fragment2;
            this.f15769c = z10;
            this.f15770d = arrayMap;
            this.f15771e = view;
            this.f15772f = fragmentTransitionImpl;
            this.f15773g = rect;
        }

        public void run() {
            j.f(this.f15767a, this.f15768b, this.f15769c, this.f15770d, false);
            View view = this.f15771e;
            if (view != null) {
                this.f15772f.getBoundsOnScreen(view, this.f15773g);
            }
        }
    }

    class f implements Runnable {
        final /* synthetic */ Rect C;

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentTransitionImpl f15774a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayMap f15775b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f15776c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h f15777d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f15778e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ View f15779f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Fragment f15780g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Fragment f15781h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ boolean f15782i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ ArrayList f15783j;

        /* renamed from: w  reason: collision with root package name */
        final /* synthetic */ Object f15784w;

        f(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap arrayMap, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z10, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f15774a = fragmentTransitionImpl;
            this.f15775b = arrayMap;
            this.f15776c = obj;
            this.f15777d = hVar;
            this.f15778e = arrayList;
            this.f15779f = view;
            this.f15780g = fragment;
            this.f15781h = fragment2;
            this.f15782i = z10;
            this.f15783j = arrayList2;
            this.f15784w = obj2;
            this.C = rect;
        }

        public void run() {
            ArrayMap h10 = j.h(this.f15774a, this.f15775b, this.f15776c, this.f15777d);
            if (h10 != null) {
                this.f15778e.addAll(h10.values());
                this.f15778e.add(this.f15779f);
            }
            j.f(this.f15780g, this.f15781h, this.f15782i, h10, false);
            Object obj = this.f15776c;
            if (obj != null) {
                this.f15774a.swapSharedElementTargets(obj, this.f15783j, this.f15778e);
                View t10 = j.t(h10, this.f15777d, this.f15784w, this.f15782i);
                if (t10 != null) {
                    this.f15774a.getBoundsOnScreen(t10, this.C);
                }
            }
        }
    }

    interface g {
        void a(Fragment fragment, CancellationSignal cancellationSignal);

        void b(Fragment fragment, CancellationSignal cancellationSignal);
    }

    static class h {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f15785a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15786b;

        /* renamed from: c  reason: collision with root package name */
        public a f15787c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f15788d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f15789e;

        /* renamed from: f  reason: collision with root package name */
        public a f15790f;

        h() {
        }
    }

    private static void A(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, ArrayMap arrayMap, boolean z10, a aVar) {
        String str;
        ArrayList<String> arrayList = aVar.mSharedElementSourceNames;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (z10) {
                str = aVar.mSharedElementTargetNames.get(0);
            } else {
                str = aVar.mSharedElementSourceNames.get(0);
            }
            View view = (View) arrayMap.get(str);
            fragmentTransitionImpl.setEpicenter(obj, view);
            if (obj2 != null) {
                fragmentTransitionImpl.setEpicenter(obj2, view);
            }
        }
    }

    static void B(ArrayList arrayList, int i10) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i10);
            }
        }
    }

    static void C(Context context, FragmentContainer fragmentContainer, ArrayList arrayList, ArrayList arrayList2, int i10, int i11, boolean z10, g gVar) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i12 = i10; i12 < i11; i12++) {
            a aVar = (a) arrayList.get(i12);
            if (((Boolean) arrayList2.get(i12)).booleanValue()) {
                e(aVar, sparseArray, z10);
            } else {
                c(aVar, sparseArray, z10);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i13 = 0; i13 < size; i13++) {
                int keyAt = sparseArray.keyAt(i13);
                ArrayMap d10 = d(keyAt, arrayList, arrayList2, i10, i11);
                h hVar = (h) sparseArray.valueAt(i13);
                if (fragmentContainer.onHasView() && (viewGroup = (ViewGroup) fragmentContainer.onFindViewById(keyAt)) != null) {
                    if (z10) {
                        o(viewGroup, hVar, view, d10, gVar);
                    } else {
                        n(viewGroup, hVar, view, d10, gVar);
                    }
                }
            }
        }
    }

    static boolean D() {
        if (f15750b == null && f15751c == null) {
            return false;
        }
        return true;
    }

    private static void a(ArrayList arrayList, ArrayMap arrayMap, Collection collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View view = (View) arrayMap.valueAt(size);
            if (collection.contains(ViewCompat.getTransitionName(view))) {
                arrayList.add(view);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0039, code lost:
        if (r0.mAdded != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003b, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0053, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0090, code lost:
        if (r0.mHidden == false) goto L_0x003b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00da A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(androidx.fragment.app.a r8, androidx.fragment.app.FragmentTransaction.a r9, android.util.SparseArray r10, boolean r11, boolean r12) {
        /*
            androidx.fragment.app.Fragment r0 = r9.f15639b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r1 = r0.mContainerId
            if (r1 != 0) goto L_0x000a
            return
        L_0x000a:
            if (r11 == 0) goto L_0x0013
            int[] r2 = f15749a
            int r9 = r9.f15638a
            r9 = r2[r9]
            goto L_0x0015
        L_0x0013:
            int r9 = r9.f15638a
        L_0x0015:
            r2 = 0
            r3 = 1
            if (r9 == r3) goto L_0x0085
            r4 = 3
            if (r9 == r4) goto L_0x0064
            r4 = 4
            if (r9 == r4) goto L_0x0045
            r4 = 5
            if (r9 == r4) goto L_0x002d
            r4 = 6
            if (r9 == r4) goto L_0x0064
            r4 = 7
            if (r9 == r4) goto L_0x0085
            r9 = r2
            r3 = r9
            r4 = r3
            goto L_0x0093
        L_0x002d:
            if (r12 == 0) goto L_0x003f
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x003d
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x003d
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x003d
        L_0x003b:
            r9 = r3
            goto L_0x0041
        L_0x003d:
            r9 = r2
            goto L_0x0041
        L_0x003f:
            boolean r9 = r0.mHidden
        L_0x0041:
            r4 = r2
            r2 = r9
            r9 = r4
            goto L_0x0093
        L_0x0045:
            if (r12 == 0) goto L_0x0057
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x0055
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0055
            boolean r9 = r0.mHidden
            if (r9 == 0) goto L_0x0055
        L_0x0053:
            r9 = r3
            goto L_0x0060
        L_0x0055:
            r9 = r2
            goto L_0x0060
        L_0x0057:
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0055
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0055
            goto L_0x0053
        L_0x0060:
            r4 = r9
            r9 = r3
            r3 = r2
            goto L_0x0093
        L_0x0064:
            if (r12 == 0) goto L_0x007c
            boolean r9 = r0.mAdded
            if (r9 != 0) goto L_0x0055
            android.view.View r9 = r0.mView
            if (r9 == 0) goto L_0x0055
            int r9 = r9.getVisibility()
            if (r9 != 0) goto L_0x0055
            float r9 = r0.mPostponedAlpha
            r4 = 0
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 < 0) goto L_0x0055
        L_0x007b:
            goto L_0x0053
        L_0x007c:
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0055
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0055
            goto L_0x007b
        L_0x0085:
            if (r12 == 0) goto L_0x008a
            boolean r9 = r0.mIsNewlyAdded
            goto L_0x0041
        L_0x008a:
            boolean r9 = r0.mAdded
            if (r9 != 0) goto L_0x003d
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x003d
            goto L_0x003b
        L_0x0093:
            java.lang.Object r5 = r10.get(r1)
            androidx.fragment.app.j$h r5 = (androidx.fragment.app.j.h) r5
            if (r2 == 0) goto L_0x00a5
            androidx.fragment.app.j$h r5 = p(r5, r10, r1)
            r5.f15785a = r0
            r5.f15786b = r11
            r5.f15787c = r8
        L_0x00a5:
            r2 = 0
            if (r12 != 0) goto L_0x00c6
            if (r3 == 0) goto L_0x00c6
            if (r5 == 0) goto L_0x00b2
            androidx.fragment.app.Fragment r3 = r5.f15788d
            if (r3 != r0) goto L_0x00b2
            r5.f15788d = r2
        L_0x00b2:
            boolean r3 = r8.mReorderingAllowed
            if (r3 != 0) goto L_0x00c6
            androidx.fragment.app.FragmentManager r3 = r8.f15660a
            androidx.fragment.app.h r6 = r3.createOrGetFragmentStateManager(r0)
            androidx.fragment.app.i r7 = r3.getFragmentStore()
            r7.q(r6)
            r3.moveToState(r0)
        L_0x00c6:
            if (r4 == 0) goto L_0x00d8
            if (r5 == 0) goto L_0x00ce
            androidx.fragment.app.Fragment r3 = r5.f15788d
            if (r3 != 0) goto L_0x00d8
        L_0x00ce:
            androidx.fragment.app.j$h r5 = p(r5, r10, r1)
            r5.f15788d = r0
            r5.f15789e = r11
            r5.f15790f = r8
        L_0x00d8:
            if (r12 != 0) goto L_0x00e4
            if (r9 == 0) goto L_0x00e4
            if (r5 == 0) goto L_0x00e4
            androidx.fragment.app.Fragment r8 = r5.f15785a
            if (r8 != r0) goto L_0x00e4
            r5.f15785a = r2
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.j.b(androidx.fragment.app.a, androidx.fragment.app.FragmentTransaction$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(a aVar, SparseArray sparseArray, boolean z10) {
        int size = aVar.mOps.size();
        for (int i10 = 0; i10 < size; i10++) {
            b(aVar, aVar.mOps.get(i10), sparseArray, false, z10);
        }
    }

    private static ArrayMap d(int i10, ArrayList arrayList, ArrayList arrayList2, int i11, int i12) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        ArrayMap arrayMap = new ArrayMap();
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            a aVar = (a) arrayList.get(i13);
            if (aVar.i(i10)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i13)).booleanValue();
                ArrayList<String> arrayList5 = aVar.mSharedElementSourceNames;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar.mSharedElementSourceNames;
                        arrayList4 = aVar.mSharedElementTargetNames;
                    } else {
                        ArrayList<String> arrayList6 = aVar.mSharedElementSourceNames;
                        arrayList3 = aVar.mSharedElementTargetNames;
                        arrayList4 = arrayList6;
                    }
                    for (int i14 = 0; i14 < size; i14++) {
                        String str = arrayList4.get(i14);
                        String str2 = arrayList3.get(i14);
                        String str3 = (String) arrayMap.remove(str2);
                        if (str3 != null) {
                            arrayMap.put(str, str3);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    public static void e(a aVar, SparseArray sparseArray, boolean z10) {
        if (aVar.f15660a.getContainer().onHasView()) {
            for (int size = aVar.mOps.size() - 1; size >= 0; size--) {
                b(aVar, aVar.mOps.get(size), sparseArray, true, z10);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z10, ArrayMap arrayMap, boolean z11) {
        SharedElementCallback sharedElementCallback;
        int i10;
        if (z10) {
            sharedElementCallback = fragment2.getEnterTransitionCallback();
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
        }
        if (sharedElementCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (arrayMap == null) {
                i10 = 0;
            } else {
                i10 = arrayMap.size();
            }
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList2.add(arrayMap.keyAt(i11));
                arrayList.add(arrayMap.valueAt(i11));
            }
            if (z11) {
                sharedElementCallback.onSharedElementStart(arrayList2, arrayList, (List<View>) null);
            } else {
                sharedElementCallback.onSharedElementEnd(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    private static boolean g(FragmentTransitionImpl fragmentTransitionImpl, List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!fragmentTransitionImpl.canHandle(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    static ArrayMap h(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap arrayMap, Object obj, h hVar) {
        SharedElementCallback sharedElementCallback;
        ArrayList<String> arrayList;
        String q10;
        Fragment fragment = hVar.f15785a;
        View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        ArrayMap arrayMap2 = new ArrayMap();
        fragmentTransitionImpl.findNamedViews(arrayMap2, view);
        a aVar = hVar.f15787c;
        if (hVar.f15786b) {
            sharedElementCallback = fragment.getExitTransitionCallback();
            arrayList = aVar.mSharedElementSourceNames;
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
            arrayList = aVar.mSharedElementTargetNames;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
            arrayMap2.retainAll(arrayMap.values());
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view2 = (View) arrayMap2.get(str);
                if (view2 == null) {
                    String q11 = q(arrayMap, str);
                    if (q11 != null) {
                        arrayMap.remove(q11);
                    }
                } else if (!str.equals(ViewCompat.getTransitionName(view2)) && (q10 = q(arrayMap, str)) != null) {
                    arrayMap.put(q10, ViewCompat.getTransitionName(view2));
                }
            }
        } else {
            y(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    private static ArrayMap i(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap arrayMap, Object obj, h hVar) {
        SharedElementCallback sharedElementCallback;
        ArrayList<String> arrayList;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = hVar.f15788d;
        ArrayMap arrayMap2 = new ArrayMap();
        fragmentTransitionImpl.findNamedViews(arrayMap2, fragment.requireView());
        a aVar = hVar.f15790f;
        if (hVar.f15789e) {
            sharedElementCallback = fragment.getEnterTransitionCallback();
            arrayList = aVar.mSharedElementTargetNames;
        } else {
            sharedElementCallback = fragment.getExitTransitionCallback();
            arrayList = aVar.mSharedElementSourceNames;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = (View) arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(ViewCompat.getTransitionName(view))) {
                    arrayMap.put(ViewCompat.getTransitionName(view), (String) arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    private static FragmentTransitionImpl j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        FragmentTransitionImpl fragmentTransitionImpl = f15750b;
        if (fragmentTransitionImpl != null && g(fragmentTransitionImpl, arrayList)) {
            return fragmentTransitionImpl;
        }
        FragmentTransitionImpl fragmentTransitionImpl2 = f15751c;
        if (fragmentTransitionImpl2 != null && g(fragmentTransitionImpl2, arrayList)) {
            return fragmentTransitionImpl2;
        }
        if (fragmentTransitionImpl == null && fragmentTransitionImpl2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList k(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        View view2 = fragment.getView();
        if (view2 != null) {
            fragmentTransitionImpl.captureTransitioningViews(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        fragmentTransitionImpl.addTargets(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap arrayMap, h hVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        ArrayMap arrayMap2;
        Object obj3;
        Object obj4;
        Rect rect;
        FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        h hVar2 = hVar;
        ArrayList arrayList3 = arrayList;
        Object obj5 = obj;
        Fragment fragment = hVar2.f15785a;
        Fragment fragment2 = hVar2.f15788d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z10 = hVar2.f15786b;
        if (arrayMap.isEmpty()) {
            arrayMap2 = arrayMap;
            obj3 = null;
        } else {
            obj3 = u(fragmentTransitionImpl2, fragment, fragment2, z10);
            arrayMap2 = arrayMap;
        }
        ArrayMap i10 = i(fragmentTransitionImpl2, arrayMap2, obj3, hVar2);
        if (arrayMap.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(i10.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        f(fragment, fragment2, z10, i10, true);
        if (obj4 != null) {
            rect = new Rect();
            fragmentTransitionImpl2.setSharedElementTargets(obj4, view, arrayList3);
            A(fragmentTransitionImpl, obj4, obj2, i10, hVar2.f15789e, hVar2.f15790f);
            if (obj5 != null) {
                fragmentTransitionImpl2.setEpicenter(obj5, rect);
            }
        } else {
            rect = null;
        }
        f fVar = r0;
        f fVar2 = new f(fragmentTransitionImpl, arrayMap, obj4, hVar, arrayList2, view, fragment, fragment2, z10, arrayList, obj, rect);
        OneShotPreDrawListener.add(viewGroup, fVar);
        return obj4;
    }

    private static Object m(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap arrayMap, h hVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        Rect rect;
        View view2;
        FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        View view3 = view;
        ArrayMap arrayMap2 = arrayMap;
        h hVar2 = hVar;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        Object obj5 = obj;
        Fragment fragment = hVar2.f15785a;
        Fragment fragment2 = hVar2.f15788d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z10 = hVar2.f15786b;
        if (arrayMap.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = u(fragmentTransitionImpl, fragment, fragment2, z10);
        }
        ArrayMap i10 = i(fragmentTransitionImpl, arrayMap2, obj3, hVar2);
        ArrayMap h10 = h(fragmentTransitionImpl, arrayMap2, obj3, hVar2);
        if (arrayMap.isEmpty()) {
            if (i10 != null) {
                i10.clear();
            }
            if (h10 != null) {
                h10.clear();
            }
            obj4 = null;
        } else {
            a(arrayList3, i10, arrayMap.keySet());
            a(arrayList4, h10, arrayMap.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        f(fragment, fragment2, z10, i10, true);
        if (obj4 != null) {
            arrayList4.add(view3);
            fragmentTransitionImpl.setSharedElementTargets(obj4, view3, arrayList3);
            A(fragmentTransitionImpl, obj4, obj2, i10, hVar2.f15789e, hVar2.f15790f);
            Rect rect2 = new Rect();
            View t10 = t(h10, hVar2, obj5, z10);
            if (t10 != null) {
                fragmentTransitionImpl.setEpicenter(obj5, rect2);
            }
            rect = rect2;
            view2 = t10;
        } else {
            view2 = null;
            rect = null;
        }
        OneShotPreDrawListener.add(viewGroup, new e(fragment, fragment2, z10, h10, view2, fragmentTransitionImpl, rect));
        return obj4;
    }

    private static void n(ViewGroup viewGroup, h hVar, View view, ArrayMap arrayMap, g gVar) {
        Object obj;
        ViewGroup viewGroup2 = viewGroup;
        h hVar2 = hVar;
        View view2 = view;
        ArrayMap arrayMap2 = arrayMap;
        g gVar2 = gVar;
        Fragment fragment = hVar2.f15785a;
        Fragment fragment2 = hVar2.f15788d;
        FragmentTransitionImpl j10 = j(fragment2, fragment);
        if (j10 != null) {
            boolean z10 = hVar2.f15786b;
            boolean z11 = hVar2.f15789e;
            Object r10 = r(j10, fragment, z10);
            Object s10 = s(j10, fragment2, z11);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = s10;
            FragmentTransitionImpl fragmentTransitionImpl = j10;
            Object l10 = l(j10, viewGroup, view, arrayMap, hVar, arrayList, arrayList2, r10, obj2);
            Object obj3 = r10;
            if (obj3 == null && l10 == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList k10 = k(fragmentTransitionImpl, obj, fragment2, arrayList4, view2);
            if (k10 == null || k10.isEmpty()) {
                obj = null;
            }
            Object obj4 = obj;
            fragmentTransitionImpl.addTarget(obj3, view2);
            Object v10 = v(fragmentTransitionImpl, obj3, obj4, l10, fragment, hVar2.f15786b);
            if (!(fragment2 == null || k10 == null || (k10.size() <= 0 && arrayList4.size() <= 0))) {
                CancellationSignal cancellationSignal = new CancellationSignal();
                gVar2.b(fragment2, cancellationSignal);
                fragmentTransitionImpl.setListenerForTransitionEnd(fragment2, v10, cancellationSignal, new c(gVar2, fragment2, cancellationSignal));
            }
            if (v10 != null) {
                ArrayList arrayList5 = new ArrayList();
                FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
                fragmentTransitionImpl2.scheduleRemoveTargets(v10, obj3, arrayList5, obj4, k10, l10, arrayList2);
                z(fragmentTransitionImpl2, viewGroup, fragment, view, arrayList2, obj3, arrayList5, obj4, k10);
                ViewGroup viewGroup3 = viewGroup;
                FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl;
                ArrayList arrayList6 = arrayList2;
                fragmentTransitionImpl3.setNameOverridesOrdered(viewGroup3, arrayList6, arrayMap2);
                fragmentTransitionImpl3.beginDelayedTransition(viewGroup3, v10);
                fragmentTransitionImpl3.scheduleNameReset(viewGroup3, arrayList6, arrayMap2);
            }
        }
    }

    private static void o(ViewGroup viewGroup, h hVar, View view, ArrayMap arrayMap, g gVar) {
        Object obj;
        h hVar2 = hVar;
        View view2 = view;
        g gVar2 = gVar;
        Fragment fragment = hVar2.f15785a;
        Fragment fragment2 = hVar2.f15788d;
        FragmentTransitionImpl j10 = j(fragment2, fragment);
        if (j10 != null) {
            boolean z10 = hVar2.f15786b;
            boolean z11 = hVar2.f15789e;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object r10 = r(j10, fragment, z10);
            Object s10 = s(j10, fragment2, z11);
            ArrayList arrayList3 = arrayList2;
            Object m10 = m(j10, viewGroup, view, arrayMap, hVar, arrayList2, arrayList, r10, s10);
            Object obj2 = r10;
            if (obj2 == null && m10 == null) {
                obj = s10;
                if (obj == null) {
                    return;
                }
            } else {
                obj = s10;
            }
            ArrayList k10 = k(j10, obj, fragment2, arrayList3, view2);
            ArrayList k11 = k(j10, obj2, fragment, arrayList, view2);
            B(k11, 4);
            Fragment fragment3 = fragment;
            ArrayList arrayList4 = k10;
            Object v10 = v(j10, obj2, obj, m10, fragment3, z10);
            if (!(fragment2 == null || arrayList4 == null || (arrayList4.size() <= 0 && arrayList3.size() <= 0))) {
                CancellationSignal cancellationSignal = new CancellationSignal();
                g gVar3 = gVar;
                gVar3.b(fragment2, cancellationSignal);
                j10.setListenerForTransitionEnd(fragment2, v10, cancellationSignal, new a(gVar3, fragment2, cancellationSignal));
            }
            if (v10 != null) {
                w(j10, obj, fragment2, arrayList4);
                ArrayList<String> prepareSetNameOverridesReordered = j10.prepareSetNameOverridesReordered(arrayList);
                FragmentTransitionImpl fragmentTransitionImpl = j10;
                fragmentTransitionImpl.scheduleRemoveTargets(v10, obj2, k11, obj, arrayList4, m10, arrayList);
                ViewGroup viewGroup2 = viewGroup;
                j10.beginDelayedTransition(viewGroup2, v10);
                fragmentTransitionImpl.setNameOverridesReordered(viewGroup2, arrayList3, arrayList, prepareSetNameOverridesReordered, arrayMap);
                B(k11, 0);
                j10.swapSharedElementTargets(m10, arrayList3, arrayList);
            }
        }
    }

    private static h p(h hVar, SparseArray sparseArray, int i10) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i10, hVar2);
        return hVar2;
    }

    static String q(ArrayMap arrayMap, String str) {
        int size = arrayMap.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equals(arrayMap.valueAt(i10))) {
                return (String) arrayMap.keyAt(i10);
            }
        }
        return null;
    }

    private static Object r(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z10) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z10) {
            obj = fragment.getReenterTransition();
        } else {
            obj = fragment.getEnterTransition();
        }
        return fragmentTransitionImpl.cloneTransition(obj);
    }

    private static Object s(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z10) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z10) {
            obj = fragment.getReturnTransition();
        } else {
            obj = fragment.getExitTransition();
        }
        return fragmentTransitionImpl.cloneTransition(obj);
    }

    static View t(ArrayMap arrayMap, h hVar, Object obj, boolean z10) {
        ArrayList<String> arrayList;
        String str;
        a aVar = hVar.f15787c;
        if (obj == null || arrayMap == null || (arrayList = aVar.mSharedElementSourceNames) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z10) {
            str = aVar.mSharedElementSourceNames.get(0);
        } else {
            str = aVar.mSharedElementTargetNames.get(0);
        }
        return (View) arrayMap.get(str);
    }

    private static Object u(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z10) {
        Object obj;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z10) {
            obj = fragment2.getSharedElementReturnTransition();
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(obj));
    }

    private static Object v(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z10) {
        boolean z11;
        if (obj == null || obj2 == null || fragment == null) {
            z11 = true;
        } else if (z10) {
            z11 = fragment.getAllowReturnTransitionOverlap();
        } else {
            z11 = fragment.getAllowEnterTransitionOverlap();
        }
        if (z11) {
            return fragmentTransitionImpl.mergeTransitionsTogether(obj2, obj, obj3);
        }
        return fragmentTransitionImpl.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    private static void w(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            fragmentTransitionImpl.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            OneShotPreDrawListener.add(fragment.mContainer, new b(arrayList));
        }
    }

    private static FragmentTransitionImpl x() {
        try {
            return FragmentTransitionSupport.class.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }

    static void y(ArrayMap arrayMap, ArrayMap arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey((String) arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    private static void z(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, Fragment fragment, View view, ArrayList arrayList, Object obj, ArrayList arrayList2, Object obj2, ArrayList arrayList3) {
        ViewGroup viewGroup2 = viewGroup;
        OneShotPreDrawListener.add(viewGroup, new d(obj, fragmentTransitionImpl, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }
}
