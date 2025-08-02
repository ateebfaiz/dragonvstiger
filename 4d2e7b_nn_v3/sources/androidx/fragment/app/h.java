package androidx.fragment.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.n;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;

class h {

    /* renamed from: a  reason: collision with root package name */
    private final e f15738a;

    /* renamed from: b  reason: collision with root package name */
    private final i f15739b;

    /* renamed from: c  reason: collision with root package name */
    private final Fragment f15740c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15741d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f15742e = -1;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f15743a;

        a(View view) {
            this.f15743a = view;
        }

        public void onViewAttachedToWindow(View view) {
            this.f15743a.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(this.f15743a);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15745a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.lifecycle.Lifecycle$State[] r0 = androidx.lifecycle.Lifecycle.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15745a = r0
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f15745a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f15745a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.CREATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f15745a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.h.b.<clinit>():void");
        }
    }

    h(e eVar, i iVar, Fragment fragment) {
        this.f15738a = eVar;
        this.f15739b = iVar;
        this.f15740c = fragment;
    }

    private boolean l(View view) {
        if (view == this.f15740c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f15740c.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f15740c.performSaveInstanceState(bundle);
        this.f15738a.j(this.f15740c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f15740c.mView != null) {
            t();
        }
        if (this.f15740c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f15740c.mSavedViewState);
        }
        if (this.f15740c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f15740c.mSavedViewRegistryState);
        }
        if (!this.f15740c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f15740c.mUserVisibleHint);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f15740c);
        }
        Fragment fragment = this.f15740c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        e eVar = this.f15738a;
        Fragment fragment2 = this.f15740c;
        eVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int j10 = this.f15739b.j(this.f15740c);
        Fragment fragment = this.f15740c;
        fragment.mContainer.addView(fragment.mView, j10);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f15740c);
        }
        Fragment fragment = this.f15740c;
        Fragment fragment2 = fragment.mTarget;
        h hVar = null;
        if (fragment2 != null) {
            h n10 = this.f15739b.n(fragment2.mWho);
            if (n10 != null) {
                Fragment fragment3 = this.f15740c;
                fragment3.mTargetWho = fragment3.mTarget.mWho;
                fragment3.mTarget = null;
                hVar = n10;
            } else {
                throw new IllegalStateException("Fragment " + this.f15740c + " declared target fragment " + this.f15740c.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (hVar = this.f15739b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f15740c + " declared target fragment " + this.f15740c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (hVar != null && (FragmentManager.USE_STATE_MANAGER || hVar.k().mState < 1)) {
            hVar.m();
        }
        Fragment fragment4 = this.f15740c;
        fragment4.mHost = fragment4.mFragmentManager.getHost();
        Fragment fragment5 = this.f15740c;
        fragment5.mParentFragment = fragment5.mFragmentManager.getParent();
        this.f15738a.g(this.f15740c, false);
        this.f15740c.performAttach();
        this.f15738a.b(this.f15740c, false);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        n.e.b bVar;
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.f15740c;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int i10 = this.f15742e;
        int i11 = b.f15745a[fragment2.mMaxState.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                i10 = Math.min(i10, 5);
            } else if (i11 == 3) {
                i10 = Math.min(i10, 1);
            } else if (i11 != 4) {
                i10 = Math.min(i10, -1);
            } else {
                i10 = Math.min(i10, 0);
            }
        }
        Fragment fragment3 = this.f15740c;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                i10 = Math.max(this.f15742e, 2);
                View view = this.f15740c.mView;
                if (view != null && view.getParent() == null) {
                    i10 = Math.min(i10, 2);
                }
            } else {
                i10 = this.f15742e < 4 ? Math.min(i10, fragment3.mState) : Math.min(i10, 1);
            }
        }
        if (!this.f15740c.mAdded) {
            i10 = Math.min(i10, 1);
        }
        if (!FragmentManager.USE_STATE_MANAGER || (viewGroup = fragment.mContainer) == null) {
            bVar = null;
        } else {
            bVar = n.n(viewGroup, (fragment = this.f15740c).getParentFragmentManager()).l(this);
        }
        if (bVar == n.e.b.ADDING) {
            i10 = Math.min(i10, 6);
        } else if (bVar == n.e.b.REMOVING) {
            i10 = Math.max(i10, 3);
        } else {
            Fragment fragment4 = this.f15740c;
            if (fragment4.mRemoving) {
                if (fragment4.isInBackStack()) {
                    i10 = Math.min(i10, 1);
                } else {
                    i10 = Math.min(i10, -1);
                }
            }
        }
        Fragment fragment5 = this.f15740c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i10 = Math.min(i10, 4);
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i10 + " for " + this.f15740c);
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f15740c);
        }
        Fragment fragment = this.f15740c;
        if (!fragment.mIsCreated) {
            this.f15738a.h(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.f15740c;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            e eVar = this.f15738a;
            Fragment fragment3 = this.f15740c;
            eVar.c(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        this.f15740c.mState = 1;
    }

    /* JADX WARNING: type inference failed for: r2v9, types: [android.view.View] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
            r7 = this;
            androidx.fragment.app.Fragment r0 = r7.f15740c
            boolean r0 = r0.mFromLayout
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 3
            boolean r0 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r0)
            java.lang.String r1 = "FragmentManager"
            if (r0 == 0) goto L_0x0026
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "moveto CREATE_VIEW: "
            r0.append(r2)
            androidx.fragment.app.Fragment r2 = r7.f15740c
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L_0x0026:
            androidx.fragment.app.Fragment r0 = r7.f15740c
            android.os.Bundle r2 = r0.mSavedFragmentState
            android.view.LayoutInflater r0 = r0.performGetLayoutInflater(r2)
            androidx.fragment.app.Fragment r2 = r7.f15740c
            android.view.ViewGroup r3 = r2.mContainer
            if (r3 == 0) goto L_0x0036
            goto L_0x00b6
        L_0x0036:
            int r3 = r2.mContainerId
            if (r3 == 0) goto L_0x00b5
            r4 = -1
            if (r3 == r4) goto L_0x0097
            androidx.fragment.app.FragmentManager r2 = r2.mFragmentManager
            androidx.fragment.app.FragmentContainer r2 = r2.getContainer()
            androidx.fragment.app.Fragment r3 = r7.f15740c
            int r3 = r3.mContainerId
            android.view.View r2 = r2.onFindViewById(r3)
            r3 = r2
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            if (r3 != 0) goto L_0x00b6
            androidx.fragment.app.Fragment r2 = r7.f15740c
            boolean r4 = r2.mRestored
            if (r4 == 0) goto L_0x0057
            goto L_0x00b6
        L_0x0057:
            android.content.res.Resources r0 = r2.getResources()     // Catch:{ NotFoundException -> 0x0064 }
            androidx.fragment.app.Fragment r1 = r7.f15740c     // Catch:{ NotFoundException -> 0x0064 }
            int r1 = r1.mContainerId     // Catch:{ NotFoundException -> 0x0064 }
            java.lang.String r0 = r0.getResourceName(r1)     // Catch:{ NotFoundException -> 0x0064 }
            goto L_0x0066
        L_0x0064:
            java.lang.String r0 = "unknown"
        L_0x0066:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "No view found for id 0x"
            r2.append(r3)
            androidx.fragment.app.Fragment r3 = r7.f15740c
            int r3 = r3.mContainerId
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r3 = " ("
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ") for fragment "
            r2.append(r0)
            androidx.fragment.app.Fragment r0 = r7.f15740c
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0097:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot create fragment "
            r1.append(r2)
            androidx.fragment.app.Fragment r2 = r7.f15740c
            r1.append(r2)
            java.lang.String r2 = " for a container view with no id"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00b5:
            r3 = 0
        L_0x00b6:
            androidx.fragment.app.Fragment r2 = r7.f15740c
            r2.mContainer = r3
            android.os.Bundle r4 = r2.mSavedFragmentState
            r2.performCreateView(r0, r3, r4)
            androidx.fragment.app.Fragment r0 = r7.f15740c
            android.view.View r0 = r0.mView
            r2 = 2
            if (r0 == 0) goto L_0x0179
            r4 = 0
            r0.setSaveFromParentEnabled(r4)
            androidx.fragment.app.Fragment r0 = r7.f15740c
            android.view.View r5 = r0.mView
            int r6 = androidx.fragment.R.id.fragment_container_view_tag
            r5.setTag(r6, r0)
            if (r3 == 0) goto L_0x00d8
            r7.b()
        L_0x00d8:
            androidx.fragment.app.Fragment r0 = r7.f15740c
            boolean r3 = r0.mHidden
            if (r3 == 0) goto L_0x00e5
            android.view.View r0 = r0.mView
            r3 = 8
            r0.setVisibility(r3)
        L_0x00e5:
            androidx.fragment.app.Fragment r0 = r7.f15740c
            android.view.View r0 = r0.mView
            boolean r0 = androidx.core.view.ViewCompat.isAttachedToWindow(r0)
            if (r0 == 0) goto L_0x00f7
            androidx.fragment.app.Fragment r0 = r7.f15740c
            android.view.View r0 = r0.mView
            androidx.core.view.ViewCompat.requestApplyInsets(r0)
            goto L_0x0103
        L_0x00f7:
            androidx.fragment.app.Fragment r0 = r7.f15740c
            android.view.View r0 = r0.mView
            androidx.fragment.app.h$a r3 = new androidx.fragment.app.h$a
            r3.<init>(r0)
            r0.addOnAttachStateChangeListener(r3)
        L_0x0103:
            androidx.fragment.app.Fragment r0 = r7.f15740c
            r0.performViewCreated()
            androidx.fragment.app.e r0 = r7.f15738a
            androidx.fragment.app.Fragment r3 = r7.f15740c
            android.view.View r5 = r3.mView
            android.os.Bundle r6 = r3.mSavedFragmentState
            r0.m(r3, r5, r6, r4)
            androidx.fragment.app.Fragment r0 = r7.f15740c
            android.view.View r0 = r0.mView
            int r0 = r0.getVisibility()
            androidx.fragment.app.Fragment r3 = r7.f15740c
            android.view.View r3 = r3.mView
            float r3 = r3.getAlpha()
            boolean r5 = androidx.fragment.app.FragmentManager.USE_STATE_MANAGER
            if (r5 == 0) goto L_0x016e
            androidx.fragment.app.Fragment r4 = r7.f15740c
            r4.setPostOnViewCreatedAlpha(r3)
            androidx.fragment.app.Fragment r3 = r7.f15740c
            android.view.ViewGroup r4 = r3.mContainer
            if (r4 == 0) goto L_0x0179
            if (r0 != 0) goto L_0x0179
            android.view.View r0 = r3.mView
            android.view.View r0 = r0.findFocus()
            if (r0 == 0) goto L_0x0165
            androidx.fragment.app.Fragment r3 = r7.f15740c
            r3.setFocusedView(r0)
            boolean r3 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r2)
            if (r3 == 0) goto L_0x0165
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "requestFocus: Saved focused view "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " for Fragment "
            r3.append(r0)
            androidx.fragment.app.Fragment r0 = r7.f15740c
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            android.util.Log.v(r1, r0)
        L_0x0165:
            androidx.fragment.app.Fragment r0 = r7.f15740c
            android.view.View r0 = r0.mView
            r1 = 0
            r0.setAlpha(r1)
            goto L_0x0179
        L_0x016e:
            androidx.fragment.app.Fragment r1 = r7.f15740c
            if (r0 != 0) goto L_0x0177
            android.view.ViewGroup r0 = r1.mContainer
            if (r0 == 0) goto L_0x0177
            r4 = 1
        L_0x0177:
            r1.mIsNewlyAdded = r4
        L_0x0179:
            androidx.fragment.app.Fragment r0 = r7.f15740c
            r0.mState = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.h.f():void");
    }

    /* access modifiers changed from: package-private */
    public void g() {
        boolean z10;
        Fragment f10;
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f15740c);
        }
        Fragment fragment = this.f15740c;
        boolean z11 = true;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10 || this.f15739b.p().m(this.f15740c)) {
            FragmentHostCallback<?> fragmentHostCallback = this.f15740c.mHost;
            if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                z11 = this.f15739b.p().i();
            } else if (fragmentHostCallback.getContext() instanceof Activity) {
                z11 = true ^ ((Activity) fragmentHostCallback.getContext()).isChangingConfigurations();
            }
            if (z10 || z11) {
                this.f15739b.p().b(this.f15740c);
            }
            this.f15740c.performDestroy();
            this.f15738a.d(this.f15740c, false);
            for (h hVar : this.f15739b.l()) {
                if (hVar != null) {
                    Fragment k10 = hVar.k();
                    if (this.f15740c.mWho.equals(k10.mTargetWho)) {
                        k10.mTarget = this.f15740c;
                        k10.mTargetWho = null;
                    }
                }
            }
            Fragment fragment2 = this.f15740c;
            String str = fragment2.mTargetWho;
            if (str != null) {
                fragment2.mTarget = this.f15739b.f(str);
            }
            this.f15739b.r(this);
            return;
        }
        String str2 = this.f15740c.mTargetWho;
        if (!(str2 == null || (f10 = this.f15739b.f(str2)) == null || !f10.mRetainInstance)) {
            this.f15740c.mTarget = f10;
        }
        this.f15740c.mState = 0;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        View view;
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f15740c);
        }
        Fragment fragment = this.f15740c;
        ViewGroup viewGroup = fragment.mContainer;
        if (!(viewGroup == null || (view = fragment.mView) == null)) {
            viewGroup.removeView(view);
        }
        this.f15740c.performDestroyView();
        this.f15738a.n(this.f15740c, false);
        Fragment fragment2 = this.f15740c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.setValue(null);
        this.f15740c.mInLayout = false;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f15740c);
        }
        this.f15740c.performDetach();
        this.f15738a.e(this.f15740c, false);
        Fragment fragment = this.f15740c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if ((fragment.mRemoving && !fragment.isInBackStack()) || this.f15739b.p().m(this.f15740c)) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f15740c);
            }
            this.f15740c.initState();
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        Fragment fragment = this.f15740c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f15740c);
            }
            Fragment fragment2 = this.f15740c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), (ViewGroup) null, this.f15740c.mSavedFragmentState);
            View view = this.f15740c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f15740c;
                fragment3.mView.setTag(R.id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f15740c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f15740c.performViewCreated();
                e eVar = this.f15738a;
                Fragment fragment5 = this.f15740c;
                eVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f15740c.mState = 2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment k() {
        return this.f15740c;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (!this.f15741d) {
            try {
                this.f15741d = true;
                while (true) {
                    int d10 = d();
                    Fragment fragment = this.f15740c;
                    int i10 = fragment.mState;
                    if (d10 != i10) {
                        if (d10 <= i10) {
                            switch (i10 - 1) {
                                case -1:
                                    i();
                                    break;
                                case 0:
                                    g();
                                    break;
                                case 1:
                                    h();
                                    this.f15740c.mState = 1;
                                    break;
                                case 2:
                                    fragment.mInLayout = false;
                                    fragment.mState = 2;
                                    break;
                                case 3:
                                    if (FragmentManager.isLoggingEnabled(3)) {
                                        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f15740c);
                                    }
                                    Fragment fragment2 = this.f15740c;
                                    if (fragment2.mView != null && fragment2.mSavedViewState == null) {
                                        t();
                                    }
                                    Fragment fragment3 = this.f15740c;
                                    if (!(fragment3.mView == null || (viewGroup2 = fragment3.mContainer) == null)) {
                                        n.n(viewGroup2, fragment3.getParentFragmentManager()).d(this);
                                    }
                                    this.f15740c.mState = 3;
                                    break;
                                case 4:
                                    w();
                                    break;
                                case 5:
                                    fragment.mState = 5;
                                    break;
                                case 6:
                                    n();
                                    break;
                            }
                        } else {
                            switch (i10 + 1) {
                                case 0:
                                    c();
                                    break;
                                case 1:
                                    e();
                                    break;
                                case 2:
                                    j();
                                    f();
                                    break;
                                case 3:
                                    a();
                                    break;
                                case 4:
                                    if (!(fragment.mView == null || (viewGroup3 = fragment.mContainer) == null)) {
                                        n.n(viewGroup3, fragment.getParentFragmentManager()).b(n.e.c.b(this.f15740c.mView.getVisibility()), this);
                                    }
                                    this.f15740c.mState = 4;
                                    break;
                                case 5:
                                    v();
                                    break;
                                case 6:
                                    fragment.mState = 6;
                                    break;
                                case 7:
                                    p();
                                    break;
                            }
                        }
                    } else {
                        if (FragmentManager.USE_STATE_MANAGER && fragment.mHiddenChanged) {
                            if (!(fragment.mView == null || (viewGroup = fragment.mContainer) == null)) {
                                n n10 = n.n(viewGroup, fragment.getParentFragmentManager());
                                if (this.f15740c.mHidden) {
                                    n10.c(this);
                                } else {
                                    n10.e(this);
                                }
                            }
                            Fragment fragment4 = this.f15740c;
                            FragmentManager fragmentManager = fragment4.mFragmentManager;
                            if (fragmentManager != null) {
                                fragmentManager.invalidateMenuForFragment(fragment4);
                            }
                            Fragment fragment5 = this.f15740c;
                            fragment5.mHiddenChanged = false;
                            fragment5.onHiddenChanged(fragment5.mHidden);
                        }
                        this.f15741d = false;
                        return;
                    }
                }
            } catch (Throwable th) {
                this.f15741d = false;
                throw th;
            }
        } else if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
        }
    }

    /* access modifiers changed from: package-private */
    public void n() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f15740c);
        }
        this.f15740c.performPause();
        this.f15738a.f(this.f15740c, false);
    }

    /* access modifiers changed from: package-private */
    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f15740c.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.f15740c;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.f15740c;
            fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
            Fragment fragment3 = this.f15740c;
            fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
            Fragment fragment4 = this.f15740c;
            if (fragment4.mTargetWho != null) {
                fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            Fragment fragment5 = this.f15740c;
            Boolean bool = fragment5.mSavedUserVisibleHint;
            if (bool != null) {
                fragment5.mUserVisibleHint = bool.booleanValue();
                this.f15740c.mSavedUserVisibleHint = null;
            } else {
                fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            Fragment fragment6 = this.f15740c;
            if (!fragment6.mUserVisibleHint) {
                fragment6.mDeferStart = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        String str;
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f15740c);
        }
        View focusedView = this.f15740c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(focusedView);
                sb2.append(" ");
                if (requestFocus) {
                    str = "succeeded";
                } else {
                    str = "failed";
                }
                sb2.append(str);
                sb2.append(" on Fragment ");
                sb2.append(this.f15740c);
                sb2.append(" resulting in focused view ");
                sb2.append(this.f15740c.mView.findFocus());
                Log.v("FragmentManager", sb2.toString());
            }
        }
        this.f15740c.setFocusedView((View) null);
        this.f15740c.performResume();
        this.f15738a.i(this.f15740c, false);
        Fragment fragment = this.f15740c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    /* access modifiers changed from: package-private */
    public Fragment.SavedState r() {
        Bundle q10;
        if (this.f15740c.mState <= -1 || (q10 = q()) == null) {
            return null;
        }
        return new Fragment.SavedState(q10);
    }

    /* access modifiers changed from: package-private */
    public FragmentState s() {
        FragmentState fragmentState = new FragmentState(this.f15740c);
        Fragment fragment = this.f15740c;
        if (fragment.mState <= -1 || fragmentState.X != null) {
            fragmentState.X = fragment.mSavedFragmentState;
        } else {
            Bundle q10 = q();
            fragmentState.X = q10;
            if (this.f15740c.mTargetWho != null) {
                if (q10 == null) {
                    fragmentState.X = new Bundle();
                }
                fragmentState.X.putString("android:target_state", this.f15740c.mTargetWho);
                int i10 = this.f15740c.mTargetRequestCode;
                if (i10 != 0) {
                    fragmentState.X.putInt("android:target_req_state", i10);
                }
            }
        }
        return fragmentState;
    }

    /* access modifiers changed from: package-private */
    public void t() {
        if (this.f15740c.mView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f15740c.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f15740c.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.f15740c.mViewLifecycleOwner.e(bundle);
            if (!bundle.isEmpty()) {
                this.f15740c.mSavedViewRegistryState = bundle;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void u(int i10) {
        this.f15742e = i10;
    }

    /* access modifiers changed from: package-private */
    public void v() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f15740c);
        }
        this.f15740c.performStart();
        this.f15738a.k(this.f15740c, false);
    }

    /* access modifiers changed from: package-private */
    public void w() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f15740c);
        }
        this.f15740c.performStop();
        this.f15738a.l(this.f15740c, false);
    }

    h(e eVar, i iVar, ClassLoader classLoader, FragmentFactory fragmentFactory, FragmentState fragmentState) {
        this.f15738a = eVar;
        this.f15739b = iVar;
        Fragment instantiate = fragmentFactory.instantiate(classLoader, fragmentState.f15621a);
        this.f15740c = instantiate;
        Bundle bundle = fragmentState.f15630j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        instantiate.setArguments(fragmentState.f15630j);
        instantiate.mWho = fragmentState.f15622b;
        instantiate.mFromLayout = fragmentState.f15623c;
        instantiate.mRestored = true;
        instantiate.mFragmentId = fragmentState.f15624d;
        instantiate.mContainerId = fragmentState.f15625e;
        instantiate.mTag = fragmentState.f15626f;
        instantiate.mRetainInstance = fragmentState.f15627g;
        instantiate.mRemoving = fragmentState.f15628h;
        instantiate.mDetached = fragmentState.f15629i;
        instantiate.mHidden = fragmentState.f15631w;
        instantiate.mMaxState = Lifecycle.State.values()[fragmentState.C];
        Bundle bundle2 = fragmentState.X;
        if (bundle2 != null) {
            instantiate.mSavedFragmentState = bundle2;
        } else {
            instantiate.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + instantiate);
        }
    }

    h(e eVar, i iVar, Fragment fragment, FragmentState fragmentState) {
        this.f15738a = eVar;
        this.f15739b = iVar;
        this.f15740c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.X;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
