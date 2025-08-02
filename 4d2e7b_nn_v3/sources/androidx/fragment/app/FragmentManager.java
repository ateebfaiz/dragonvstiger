package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.collection.ArraySet;
import androidx.core.os.CancellationSignal;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.c;
import androidx.fragment.app.j;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager implements FragmentResultOwner {
    private static boolean DEBUG = false;
    private static final String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    static final String TAG = "FragmentManager";
    static boolean USE_STATE_MANAGER = true;
    ArrayList<a> mBackStack;
    private ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    private final AtomicInteger mBackStackIndex = new AtomicInteger();
    private FragmentContainer mContainer;
    private ArrayList<Fragment> mCreatedMenus;
    int mCurState = -1;
    private o mDefaultSpecialEffectsControllerFactory = new f();
    private boolean mDestroyed;
    private Runnable mExecCommit = new g();
    private boolean mExecutingActions;
    private Map<Fragment, HashSet<CancellationSignal>> mExitAnimationCancellationSignals = Collections.synchronizedMap(new HashMap());
    private FragmentFactory mFragmentFactory = null;
    /* access modifiers changed from: private */
    public final i mFragmentStore = new i();
    private final j.g mFragmentTransitionCallback = new d();
    private boolean mHavePendingDeferredStart;
    private FragmentHostCallback<?> mHost;
    private FragmentFactory mHostFragmentFactory = new e();
    ArrayDeque<LaunchedFragmentInfo> mLaunchedFragments = new ArrayDeque<>();
    private final d mLayoutInflaterFactory = new d(this);
    private final e mLifecycleCallbacksDispatcher = new e(this);
    private boolean mNeedMenuInvalidate;
    private g mNonConfig;
    private final CopyOnWriteArrayList<FragmentOnAttachListener> mOnAttachListeners = new CopyOnWriteArrayList<>();
    private final OnBackPressedCallback mOnBackPressedCallback = new c(false);
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private Fragment mParent;
    private final ArrayList<m> mPendingActions = new ArrayList<>();
    private ArrayList<o> mPostponedTransactions;
    @Nullable
    Fragment mPrimaryNav;
    private ActivityResultLauncher<String[]> mRequestPermissions;
    /* access modifiers changed from: private */
    public final Map<String, l> mResultListeners = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */
    public final Map<String, Bundle> mResults = Collections.synchronizedMap(new HashMap());
    private o mSpecialEffectsControllerFactory = null;
    private ActivityResultLauncher<Intent> mStartActivityForResult;
    private ActivityResultLauncher<IntentSenderRequest> mStartIntentSenderForResult;
    private boolean mStateSaved;
    private boolean mStopped;
    private ArrayList<Fragment> mTmpAddedFragments;
    private ArrayList<Boolean> mTmpIsPop;
    private ArrayList<a> mTmpRecords;

    public interface BackStackEntry {
        @Deprecated
        @Nullable
        CharSequence getBreadCrumbShortTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbShortTitleRes();

        @Deprecated
        @Nullable
        CharSequence getBreadCrumbTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbTitleRes();

        int getId();

        @Nullable
        String getName();
    }

    public static abstract class FragmentLifecycleCallbacks {
        @Deprecated
        public void onFragmentActivityCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentDetached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPaused(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPreAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentPreCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Bundle bundle) {
        }

        public void onFragmentStarted(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentStopped(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
        }

        public void onFragmentViewDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }
    }

    public interface OnBackStackChangedListener {
        @MainThread
        void onBackStackChanged();
    }

    class a implements ActivityResultCallback {
        a() {
        }

        /* renamed from: a */
        public void onActivityResult(ActivityResult activityResult) {
            LaunchedFragmentInfo pollFirst = FragmentManager.this.mLaunchedFragments.pollFirst();
            if (pollFirst == null) {
                Log.w(FragmentManager.TAG, "No IntentSenders were started for " + this);
                return;
            }
            String str = pollFirst.f15587a;
            int i10 = pollFirst.f15588b;
            Fragment i11 = FragmentManager.this.mFragmentStore.i(str);
            if (i11 == null) {
                Log.w(FragmentManager.TAG, "Intent Sender result delivered for unknown Fragment " + str);
                return;
            }
            i11.onActivityResult(i10, activityResult.getResultCode(), activityResult.getData());
        }
    }

    class b implements ActivityResultCallback {
        b() {
        }

        /* renamed from: a */
        public void onActivityResult(Map map) {
            int i10;
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                if (((Boolean) arrayList.get(i11)).booleanValue()) {
                    i10 = 0;
                } else {
                    i10 = -1;
                }
                iArr[i11] = i10;
            }
            LaunchedFragmentInfo pollFirst = FragmentManager.this.mLaunchedFragments.pollFirst();
            if (pollFirst == null) {
                Log.w(FragmentManager.TAG, "No permissions were requested for " + this);
                return;
            }
            String str = pollFirst.f15587a;
            int i12 = pollFirst.f15588b;
            Fragment i13 = FragmentManager.this.mFragmentStore.i(str);
            if (i13 == null) {
                Log.w(FragmentManager.TAG, "Permission request result delivered for unknown Fragment " + str);
                return;
            }
            i13.onRequestPermissionsResult(i12, strArr, iArr);
        }
    }

    class c extends OnBackPressedCallback {
        c(boolean z10) {
            super(z10);
        }

        public void handleOnBackPressed() {
            FragmentManager.this.handleOnBackPressed();
        }
    }

    class d implements j.g {
        d() {
        }

        public void a(Fragment fragment, CancellationSignal cancellationSignal) {
            if (!cancellationSignal.isCanceled()) {
                FragmentManager.this.removeCancellationSignal(fragment, cancellationSignal);
            }
        }

        public void b(Fragment fragment, CancellationSignal cancellationSignal) {
            FragmentManager.this.addCancellationSignal(fragment, cancellationSignal);
        }
    }

    class e extends FragmentFactory {
        e() {
        }

        public Fragment instantiate(ClassLoader classLoader, String str) {
            return FragmentManager.this.getHost().instantiate(FragmentManager.this.getHost().getContext(), str, (Bundle) null);
        }
    }

    class f implements o {
        f() {
        }

        public n a(ViewGroup viewGroup) {
            return new b(viewGroup);
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            FragmentManager.this.execPendingActions(true);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f15596a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f15597b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f15598c;

        h(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f15596a = viewGroup;
            this.f15597b = view;
            this.f15598c = fragment;
        }

        public void onAnimationEnd(Animator animator) {
            this.f15596a.endViewTransition(this.f15597b);
            animator.removeListener(this);
            Fragment fragment = this.f15598c;
            View view = fragment.mView;
            if (view != null && fragment.mHidden) {
                view.setVisibility(8);
            }
        }
    }

    class i implements FragmentOnAttachListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f15600a;

        i(Fragment fragment) {
            this.f15600a = fragment;
        }

        public void onAttachFragment(FragmentManager fragmentManager, Fragment fragment) {
            this.f15600a.onAttachFragment(fragment);
        }
    }

    class j implements ActivityResultCallback {
        j() {
        }

        /* renamed from: a */
        public void onActivityResult(ActivityResult activityResult) {
            LaunchedFragmentInfo pollFirst = FragmentManager.this.mLaunchedFragments.pollFirst();
            if (pollFirst == null) {
                Log.w(FragmentManager.TAG, "No Activities were started for result for " + this);
                return;
            }
            String str = pollFirst.f15587a;
            int i10 = pollFirst.f15588b;
            Fragment i11 = FragmentManager.this.mFragmentStore.i(str);
            if (i11 == null) {
                Log.w(FragmentManager.TAG, "Activity result delivered for unknown Fragment " + str);
                return;
            }
            i11.onActivityResult(i10, activityResult.getResultCode(), activityResult.getData());
        }
    }

    static class k extends ActivityResultContract {
        k() {
        }

        public Intent createIntent(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST);
            Intent fillInIntent = intentSenderRequest.getFillInIntent();
            if (!(fillInIntent == null || (bundleExtra = fillInIntent.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE)) == null)) {
                intent.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundleExtra);
                fillInIntent.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
                if (fillInIntent.getBooleanExtra(FragmentManager.EXTRA_CREATED_FILLIN_INTENT, false)) {
                    intentSenderRequest = new IntentSenderRequest.Builder(intentSenderRequest.getIntentSender()).setFillInIntent((Intent) null).setFlags(intentSenderRequest.getFlagsValues(), intentSenderRequest.getFlagsMask()).build();
                }
            }
            intent.putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST, intentSenderRequest);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        public ActivityResult parseResult(int i10, Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    private static class l implements FragmentResultListener {

        /* renamed from: a  reason: collision with root package name */
        private final Lifecycle f15603a;

        /* renamed from: b  reason: collision with root package name */
        private final FragmentResultListener f15604b;

        /* renamed from: c  reason: collision with root package name */
        private final LifecycleEventObserver f15605c;

        l(Lifecycle lifecycle, FragmentResultListener fragmentResultListener, LifecycleEventObserver lifecycleEventObserver) {
            this.f15603a = lifecycle;
            this.f15604b = fragmentResultListener;
            this.f15605c = lifecycleEventObserver;
        }

        public boolean a(Lifecycle.State state) {
            return this.f15603a.getCurrentState().isAtLeast(state);
        }

        public void b() {
            this.f15603a.removeObserver(this.f15605c);
        }

        public void onFragmentResult(String str, Bundle bundle) {
            this.f15604b.onFragmentResult(str, bundle);
        }
    }

    interface m {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    private class n implements m {

        /* renamed from: a  reason: collision with root package name */
        final String f15606a;

        /* renamed from: b  reason: collision with root package name */
        final int f15607b;

        /* renamed from: c  reason: collision with root package name */
        final int f15608c;

        n(String str, int i10, int i11) {
            this.f15606a = str;
            this.f15607b = i10;
            this.f15608c = i11;
        }

        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = FragmentManager.this.mPrimaryNav;
            if (fragment != null && this.f15607b < 0 && this.f15606a == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
                return false;
            }
            return FragmentManager.this.popBackStackState(arrayList, arrayList2, this.f15606a, this.f15607b, this.f15608c);
        }
    }

    static class o implements Fragment.k {

        /* renamed from: a  reason: collision with root package name */
        final boolean f15610a;

        /* renamed from: b  reason: collision with root package name */
        final a f15611b;

        /* renamed from: c  reason: collision with root package name */
        private int f15612c;

        o(a aVar, boolean z10) {
            this.f15610a = z10;
            this.f15611b = aVar;
        }

        public void a() {
            this.f15612c++;
        }

        public void b() {
            int i10 = this.f15612c - 1;
            this.f15612c = i10;
            if (i10 == 0) {
                this.f15611b.f15660a.scheduleCommit();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            a aVar = this.f15611b;
            aVar.f15660a.completeExecute(aVar, this.f15610a, false, false);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            boolean z10;
            if (this.f15612c > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            for (Fragment next : this.f15611b.f15660a.getFragments()) {
                next.setOnStartEnterTransitionListener((Fragment.k) null);
                if (z10 && next.isPostponed()) {
                    next.startPostponedEnterTransition();
                }
            }
            a aVar = this.f15611b;
            aVar.f15660a.completeExecute(aVar, this.f15610a, !z10, true);
        }

        public boolean e() {
            if (this.f15612c == 0) {
                return true;
            }
            return false;
        }
    }

    private void addAddedFragments(@NonNull ArraySet<Fragment> arraySet) {
        int i10 = this.mCurState;
        if (i10 >= 1) {
            int min = Math.min(i10, 5);
            for (Fragment fragment : this.mFragmentStore.o()) {
                if (fragment.mState < min) {
                    moveToState(fragment, min);
                    if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                        arraySet.add(fragment);
                    }
                }
            }
        }
    }

    private void cancelExitAnimation(@NonNull Fragment fragment) {
        HashSet hashSet = this.mExitAnimationCancellationSignals.get(fragment);
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((CancellationSignal) it.next()).cancel();
            }
            hashSet.clear();
            destroyFragmentView(fragment);
            this.mExitAnimationCancellationSignals.remove(fragment);
        }
    }

    private void checkStateLoss() {
        if (isStateSaved()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    private Set<n> collectAllSpecialEffectsController() {
        HashSet hashSet = new HashSet();
        for (h k10 : this.mFragmentStore.l()) {
            ViewGroup viewGroup = k10.k().mContainer;
            if (viewGroup != null) {
                hashSet.add(n.o(viewGroup, getSpecialEffectsControllerFactory()));
            }
        }
        return hashSet;
    }

    private Set<n> collectChangedControllers(@NonNull ArrayList<a> arrayList, int i10, int i11) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i10 < i11) {
            Iterator<FragmentTransaction.a> it = arrayList.get(i10).mOps.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f15639b;
                if (!(fragment == null || (viewGroup = fragment.mContainer) == null)) {
                    hashSet.add(n.n(viewGroup, this));
                }
            }
            i10++;
        }
        return hashSet;
    }

    private void completeShowHideFragment(@NonNull Fragment fragment) {
        int i10;
        Animator animator;
        if (fragment.mView != null) {
            c.d c10 = c.c(this.mHost.getContext(), fragment, !fragment.mHidden, fragment.getPopDirection());
            if (c10 == null || (animator = c10.f15717b) == null) {
                if (c10 != null) {
                    fragment.mView.startAnimation(c10.f15716a);
                    c10.f15716a.start();
                }
                if (!fragment.mHidden || fragment.isHideReplaced()) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                fragment.mView.setVisibility(i10);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    ViewGroup viewGroup = fragment.mContainer;
                    View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    c10.f15717b.addListener(new h(viewGroup, view, fragment));
                }
                c10.f15717b.start();
            }
        }
        invalidateMenuForFragment(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    private void destroyFragmentView(@NonNull Fragment fragment) {
        fragment.performDestroyView();
        this.mLifecycleCallbacksDispatcher.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(@Nullable Fragment fragment) {
        if (fragment != null && fragment.equals(findActiveFragment(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    /* JADX INFO: finally extract failed */
    private void dispatchStateChange(int i10) {
        try {
            this.mExecutingActions = true;
            this.mFragmentStore.d(i10);
            moveToState(i10, false);
            if (USE_STATE_MANAGER) {
                for (n j10 : collectAllSpecialEffectsController()) {
                    j10.j();
                }
            }
            this.mExecutingActions = false;
            execPendingActions(true);
        } catch (Throwable th) {
            this.mExecutingActions = false;
            throw th;
        }
    }

    private void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
    }

    @Deprecated
    public static void enableDebugLogging(boolean z10) {
        DEBUG = z10;
    }

    @FragmentStateManagerControl
    public static void enableNewStateManager(boolean z10) {
        USE_STATE_MANAGER = z10;
    }

    private void endAnimatingAwayFragments() {
        if (USE_STATE_MANAGER) {
            for (n j10 : collectAllSpecialEffectsController()) {
                j10.j();
            }
        } else if (!this.mExitAnimationCancellationSignals.isEmpty()) {
            for (Fragment next : this.mExitAnimationCancellationSignals.keySet()) {
                cancelExitAnimation(next);
                moveToState(next);
            }
        }
    }

    private void ensureExecReady(boolean z10) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.mHost == null) {
            if (this.mDestroyed) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.mHost.getHandler().getLooper()) {
            if (!z10) {
                checkStateLoss();
            }
            if (this.mTmpRecords == null) {
                this.mTmpRecords = new ArrayList<>();
                this.mTmpIsPop = new ArrayList<>();
            }
            this.mExecutingActions = true;
            try {
                executePostponedTransaction((ArrayList<a>) null, (ArrayList<Boolean>) null);
            } finally {
                this.mExecutingActions = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    private static void executeOps(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i10, int i11) {
        while (i10 < i11) {
            a aVar = arrayList.get(i10);
            boolean z10 = true;
            if (arrayList2.get(i10).booleanValue()) {
                aVar.b(-1);
                if (i10 != i11 - 1) {
                    z10 = false;
                }
                aVar.g(z10);
            } else {
                aVar.b(1);
                aVar.f();
            }
            i10++;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void executeOpsTogether(@androidx.annotation.NonNull java.util.ArrayList<androidx.fragment.app.a> r18, @androidx.annotation.NonNull java.util.ArrayList<java.lang.Boolean> r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            r15 = r18
            r5 = r19
            r4 = r20
            r3 = r21
            java.lang.Object r0 = r15.get(r4)
            androidx.fragment.app.a r0 = (androidx.fragment.app.a) r0
            boolean r2 = r0.mReorderingAllowed
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.mTmpAddedFragments
            if (r0 != 0) goto L_0x001e
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.mTmpAddedFragments = r0
            goto L_0x0021
        L_0x001e:
            r0.clear()
        L_0x0021:
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.mTmpAddedFragments
            androidx.fragment.app.i r1 = r6.mFragmentStore
            java.util.List r1 = r1.o()
            r0.addAll(r1)
            androidx.fragment.app.Fragment r0 = r17.getPrimaryNavigationFragment()
            r1 = 0
            r16 = r1
            r7 = r4
        L_0x0034:
            r14 = 1
            if (r7 >= r3) goto L_0x0065
            java.lang.Object r8 = r15.get(r7)
            androidx.fragment.app.a r8 = (androidx.fragment.app.a) r8
            java.lang.Object r9 = r5.get(r7)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0050
            java.util.ArrayList<androidx.fragment.app.Fragment> r9 = r6.mTmpAddedFragments
            androidx.fragment.app.Fragment r0 = r8.h(r9, r0)
            goto L_0x0056
        L_0x0050:
            java.util.ArrayList<androidx.fragment.app.Fragment> r9 = r6.mTmpAddedFragments
            androidx.fragment.app.Fragment r0 = r8.o(r9, r0)
        L_0x0056:
            if (r16 != 0) goto L_0x0060
            boolean r8 = r8.mAddToBackStack
            if (r8 == 0) goto L_0x005d
            goto L_0x0060
        L_0x005d:
            r16 = r1
            goto L_0x0062
        L_0x0060:
            r16 = r14
        L_0x0062:
            int r7 = r7 + 1
            goto L_0x0034
        L_0x0065:
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.mTmpAddedFragments
            r0.clear()
            if (r2 != 0) goto L_0x00a4
            int r0 = r6.mCurState
            if (r0 < r14) goto L_0x00a4
            boolean r0 = USE_STATE_MANAGER
            if (r0 == 0) goto L_0x00a6
            r0 = r4
        L_0x0075:
            if (r0 >= r3) goto L_0x00a4
            java.lang.Object r1 = r15.get(r0)
            androidx.fragment.app.a r1 = (androidx.fragment.app.a) r1
            java.util.ArrayList<androidx.fragment.app.FragmentTransaction$a> r1 = r1.mOps
            java.util.Iterator r1 = r1.iterator()
        L_0x0083:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x00a1
            java.lang.Object r7 = r1.next()
            androidx.fragment.app.FragmentTransaction$a r7 = (androidx.fragment.app.FragmentTransaction.a) r7
            androidx.fragment.app.Fragment r7 = r7.f15639b
            if (r7 == 0) goto L_0x0083
            androidx.fragment.app.FragmentManager r8 = r7.mFragmentManager
            if (r8 == 0) goto L_0x0083
            androidx.fragment.app.h r7 = r6.createOrGetFragmentStateManager(r7)
            androidx.fragment.app.i r8 = r6.mFragmentStore
            r8.q(r7)
            goto L_0x0083
        L_0x00a1:
            int r0 = r0 + 1
            goto L_0x0075
        L_0x00a4:
            r1 = r14
            goto L_0x00be
        L_0x00a6:
            androidx.fragment.app.FragmentHostCallback<?> r0 = r6.mHost
            android.content.Context r7 = r0.getContext()
            androidx.fragment.app.FragmentContainer r8 = r6.mContainer
            r13 = 0
            androidx.fragment.app.j$g r0 = r6.mFragmentTransitionCallback
            r9 = r18
            r10 = r19
            r11 = r20
            r12 = r21
            r1 = r14
            r14 = r0
            androidx.fragment.app.j.C(r7, r8, r9, r10, r11, r12, r13, r14)
        L_0x00be:
            executeOps(r18, r19, r20, r21)
            boolean r0 = USE_STATE_MANAGER
            if (r0 == 0) goto L_0x0143
            int r0 = r3 + -1
            java.lang.Object r0 = r5.get(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = r4
        L_0x00d2:
            if (r2 >= r3) goto L_0x011c
            java.lang.Object r7 = r15.get(r2)
            androidx.fragment.app.a r7 = (androidx.fragment.app.a) r7
            if (r0 == 0) goto L_0x00fb
            java.util.ArrayList<androidx.fragment.app.FragmentTransaction$a> r8 = r7.mOps
            int r8 = r8.size()
            int r8 = r8 - r1
        L_0x00e3:
            if (r8 < 0) goto L_0x0119
            java.util.ArrayList<androidx.fragment.app.FragmentTransaction$a> r9 = r7.mOps
            java.lang.Object r9 = r9.get(r8)
            androidx.fragment.app.FragmentTransaction$a r9 = (androidx.fragment.app.FragmentTransaction.a) r9
            androidx.fragment.app.Fragment r9 = r9.f15639b
            if (r9 == 0) goto L_0x00f8
            androidx.fragment.app.h r9 = r6.createOrGetFragmentStateManager(r9)
            r9.m()
        L_0x00f8:
            int r8 = r8 + -1
            goto L_0x00e3
        L_0x00fb:
            java.util.ArrayList<androidx.fragment.app.FragmentTransaction$a> r7 = r7.mOps
            java.util.Iterator r7 = r7.iterator()
        L_0x0101:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0119
            java.lang.Object r8 = r7.next()
            androidx.fragment.app.FragmentTransaction$a r8 = (androidx.fragment.app.FragmentTransaction.a) r8
            androidx.fragment.app.Fragment r8 = r8.f15639b
            if (r8 == 0) goto L_0x0101
            androidx.fragment.app.h r8 = r6.createOrGetFragmentStateManager(r8)
            r8.m()
            goto L_0x0101
        L_0x0119:
            int r2 = r2 + 1
            goto L_0x00d2
        L_0x011c:
            int r2 = r6.mCurState
            r6.moveToState((int) r2, (boolean) r1)
            java.util.Set r1 = r6.collectChangedControllers(r15, r4, r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0129:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x013f
            java.lang.Object r2 = r1.next()
            androidx.fragment.app.n r2 = (androidx.fragment.app.n) r2
            r2.r(r0)
            r2.p()
            r2.g()
            goto L_0x0129
        L_0x013f:
            r0 = r3
            r3 = r5
            goto L_0x0199
        L_0x0143:
            if (r2 == 0) goto L_0x0165
            androidx.collection.ArraySet r7 = new androidx.collection.ArraySet
            r7.<init>()
            r6.addAddedFragments(r7)
            r0 = r17
            r14 = r1
            r1 = r18
            r8 = r2
            r2 = r19
            r13 = r3
            r3 = r20
            r12 = r4
            r4 = r21
            r11 = r5
            r5 = r7
            int r0 = r0.postponePostponableTransactions(r1, r2, r3, r4, r5)
            r6.makeRemovedFragmentsInvisible(r7)
            goto L_0x016b
        L_0x0165:
            r14 = r1
            r8 = r2
            r13 = r3
            r12 = r4
            r11 = r5
            r0 = r13
        L_0x016b:
            if (r0 == r12) goto L_0x0197
            if (r8 == 0) goto L_0x0197
            int r1 = r6.mCurState
            if (r1 < r14) goto L_0x018e
            androidx.fragment.app.FragmentHostCallback<?> r1 = r6.mHost
            android.content.Context r7 = r1.getContext()
            androidx.fragment.app.FragmentContainer r8 = r6.mContainer
            r1 = 1
            androidx.fragment.app.j$g r2 = r6.mFragmentTransitionCallback
            r9 = r18
            r10 = r19
            r3 = r11
            r11 = r20
            r12 = r0
            r0 = r13
            r13 = r1
            r1 = r14
            r14 = r2
            androidx.fragment.app.j.C(r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0191
        L_0x018e:
            r3 = r11
            r0 = r13
            r1 = r14
        L_0x0191:
            int r2 = r6.mCurState
            r6.moveToState((int) r2, (boolean) r1)
            goto L_0x0199
        L_0x0197:
            r3 = r11
            r0 = r13
        L_0x0199:
            r1 = r20
        L_0x019b:
            if (r1 >= r0) goto L_0x01bc
            java.lang.Object r2 = r15.get(r1)
            androidx.fragment.app.a r2 = (androidx.fragment.app.a) r2
            java.lang.Object r4 = r3.get(r1)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x01b6
            int r4 = r2.f15662c
            if (r4 < 0) goto L_0x01b6
            r4 = -1
            r2.f15662c = r4
        L_0x01b6:
            r2.m()
            int r1 = r1 + 1
            goto L_0x019b
        L_0x01bc:
            if (r16 == 0) goto L_0x01c1
            r17.reportBackStackChanged()
        L_0x01c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.executeOpsTogether(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    private void executePostponedTransaction(@Nullable ArrayList<a> arrayList, @Nullable ArrayList<Boolean> arrayList2) {
        int i10;
        int indexOf;
        int indexOf2;
        ArrayList<o> arrayList3 = this.mPostponedTransactions;
        if (arrayList3 == null) {
            i10 = 0;
        } else {
            i10 = arrayList3.size();
        }
        int i11 = 0;
        while (i11 < i10) {
            o oVar = this.mPostponedTransactions.get(i11);
            if (arrayList != null && !oVar.f15610a && (indexOf2 = arrayList.indexOf(oVar.f15611b)) != -1 && arrayList2 != null && arrayList2.get(indexOf2).booleanValue()) {
                this.mPostponedTransactions.remove(i11);
                i11--;
                i10--;
                oVar.c();
            } else if (oVar.e() || (arrayList != null && oVar.f15611b.j(arrayList, 0, arrayList.size()))) {
                this.mPostponedTransactions.remove(i11);
                i11--;
                i10--;
                if (arrayList == null || oVar.f15610a || (indexOf = arrayList.indexOf(oVar.f15611b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                    oVar.d();
                } else {
                    oVar.c();
                }
            }
            i11++;
        }
    }

    @NonNull
    public static <F extends Fragment> F findFragment(@NonNull View view) {
        F findViewFragment = findViewFragment(view);
        if (findViewFragment != null) {
            return findViewFragment;
        }
        throw new IllegalStateException("View " + view + " does not have a Fragment set");
    }

    @NonNull
    static FragmentManager findFragmentManager(@NonNull View view) {
        FragmentActivity fragmentActivity;
        Fragment findViewFragment = findViewFragment(view);
        if (findViewFragment == null) {
            Context context = view.getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    fragmentActivity = null;
                    break;
                } else if (context instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (fragmentActivity != null) {
                return fragmentActivity.getSupportFragmentManager();
            }
            throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
        } else if (findViewFragment.isAdded()) {
            return findViewFragment.getChildFragmentManager();
        } else {
            throw new IllegalStateException("The Fragment " + findViewFragment + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
    }

    @Nullable
    private static Fragment findViewFragment(@NonNull View view) {
        while (view != null) {
            Fragment viewFragment = getViewFragment(view);
            if (viewFragment != null) {
                return viewFragment;
            }
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
        }
        return null;
    }

    private void forcePostponedTransactions() {
        if (USE_STATE_MANAGER) {
            for (n k10 : collectAllSpecialEffectsController()) {
                k10.k();
            }
        } else if (this.mPostponedTransactions != null) {
            while (!this.mPostponedTransactions.isEmpty()) {
                this.mPostponedTransactions.remove(0).d();
            }
        }
    }

    private boolean generateOpsForPendingActions(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        synchronized (this.mPendingActions) {
            try {
                if (this.mPendingActions.isEmpty()) {
                    return false;
                }
                int size = this.mPendingActions.size();
                boolean z10 = false;
                for (int i10 = 0; i10 < size; i10++) {
                    z10 |= this.mPendingActions.get(i10).a(arrayList, arrayList2);
                }
                this.mPendingActions.clear();
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                return z10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    private g getChildNonConfig(@NonNull Fragment fragment) {
        return this.mNonConfig.d(fragment);
    }

    private ViewGroup getFragmentContainer(@NonNull Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.mContainer.onHasView()) {
            View onFindViewById = this.mContainer.onFindViewById(fragment.mContainerId);
            if (onFindViewById instanceof ViewGroup) {
                return (ViewGroup) onFindViewById;
            }
        }
        return null;
    }

    @Nullable
    static Fragment getViewFragment(@NonNull View view) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    static boolean isLoggingEnabled(int i10) {
        if (DEBUG || Log.isLoggable(TAG, i10)) {
            return true;
        }
        return false;
    }

    private boolean isMenuAvailable(@NonNull Fragment fragment) {
        if ((!fragment.mHasMenu || !fragment.mMenuVisible) && !fragment.mChildFragmentManager.checkForMenus()) {
            return false;
        }
        return true;
    }

    private void makeRemovedFragmentsInvisible(@NonNull ArraySet<Fragment> arraySet) {
        int size = arraySet.size();
        for (int i10 = 0; i10 < size; i10++) {
            Fragment valueAt = arraySet.valueAt(i10);
            if (!valueAt.mAdded) {
                View requireView = valueAt.requireView();
                valueAt.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    private int postponePostponableTransactions(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i10, int i11, @NonNull ArraySet<Fragment> arraySet) {
        int i12 = i11;
        for (int i13 = i11 - 1; i13 >= i10; i13--) {
            a aVar = arrayList.get(i13);
            boolean booleanValue = arrayList2.get(i13).booleanValue();
            if (aVar.l() && !aVar.j(arrayList, i13 + 1, i11)) {
                if (this.mPostponedTransactions == null) {
                    this.mPostponedTransactions = new ArrayList<>();
                }
                o oVar = new o(aVar, booleanValue);
                this.mPostponedTransactions.add(oVar);
                aVar.n(oVar);
                if (booleanValue) {
                    aVar.f();
                } else {
                    aVar.g(false);
                }
                i12--;
                if (i13 != i12) {
                    arrayList.remove(i13);
                    arrayList.add(i12, aVar);
                }
                addAddedFragments(arraySet);
            }
        }
        return i12;
    }

    private void removeRedundantOperationsAndExecute(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                executePostponedTransaction(arrayList, arrayList2);
                int size = arrayList.size();
                int i10 = 0;
                int i11 = 0;
                while (i10 < size) {
                    if (!arrayList.get(i10).mReorderingAllowed) {
                        if (i11 != i10) {
                            executeOpsTogether(arrayList, arrayList2, i11, i10);
                        }
                        i11 = i10 + 1;
                        if (arrayList2.get(i10).booleanValue()) {
                            while (i11 < size && arrayList2.get(i11).booleanValue() && !arrayList.get(i11).mReorderingAllowed) {
                                i11++;
                            }
                        }
                        executeOpsTogether(arrayList, arrayList2, i10, i11);
                        i10 = i11 - 1;
                    }
                    i10++;
                }
                if (i11 != size) {
                    executeOpsTogether(arrayList, arrayList2, i11, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    private void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i10 = 0; i10 < this.mBackStackChangeListeners.size(); i10++) {
                this.mBackStackChangeListeners.get(i10).onBackStackChanged();
            }
        }
    }

    static int reverseTransit(int i10) {
        if (i10 == 4097) {
            return 8194;
        }
        if (i10 == 4099) {
            return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
        }
        if (i10 != 8194) {
            return 0;
        }
        return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
    }

    private void setVisibleRemovingFragment(@NonNull Fragment fragment) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer != null && fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() > 0) {
            if (fragmentContainer.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                fragmentContainer.setTag(R.id.visible_removing_fragment_view_tag, fragment);
            }
            ((Fragment) fragmentContainer.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
        }
    }

    private void startPendingDeferredFragments() {
        for (h performPendingDeferredStart : this.mFragmentStore.l()) {
            performPendingDeferredStart(performPendingDeferredStart);
        }
    }

    private void throwException(RuntimeException runtimeException) {
        Log.e(TAG, runtimeException.getMessage());
        Log.e(TAG, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new m(TAG));
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.onDump("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e10) {
                Log.e(TAG, "Failed dumping state", e10);
            }
        } else {
            try {
                dump("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e11) {
                Log.e(TAG, "Failed dumping state", e11);
            }
        }
        throw runtimeException;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        r0 = r3.mOnBackPressedCallback;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        if (getBackStackEntryCount() <= 0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        if (isPrimaryNavigation(r3.mParent) == false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        r0.setEnabled(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateOnBackPressedCallbackEnabled() {
        /*
            r3 = this;
            java.util.ArrayList<androidx.fragment.app.FragmentManager$m> r0 = r3.mPendingActions
            monitor-enter(r0)
            java.util.ArrayList<androidx.fragment.app.FragmentManager$m> r1 = r3.mPendingActions     // Catch:{ all -> 0x0013 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0013 }
            r2 = 1
            if (r1 != 0) goto L_0x0015
            androidx.activity.OnBackPressedCallback r1 = r3.mOnBackPressedCallback     // Catch:{ all -> 0x0013 }
            r1.setEnabled(r2)     // Catch:{ all -> 0x0013 }
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            return
        L_0x0013:
            r1 = move-exception
            goto L_0x002c
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            androidx.activity.OnBackPressedCallback r0 = r3.mOnBackPressedCallback
            int r1 = r3.getBackStackEntryCount()
            if (r1 <= 0) goto L_0x0027
            androidx.fragment.app.Fragment r1 = r3.mParent
            boolean r1 = r3.isPrimaryNavigation(r1)
            if (r1 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r2 = 0
        L_0x0028:
            r0.setEnabled(r2)
            return
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.updateOnBackPressedCallbackEnabled():void");
    }

    /* access modifiers changed from: package-private */
    public void addBackStackState(a aVar) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList<>();
        }
        this.mBackStack.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public void addCancellationSignal(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
        if (this.mExitAnimationCancellationSignals.get(fragment) == null) {
            this.mExitAnimationCancellationSignals.put(fragment, new HashSet());
        }
        this.mExitAnimationCancellationSignals.get(fragment).add(cancellationSignal);
    }

    /* access modifiers changed from: package-private */
    public h addFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "add: " + fragment);
        }
        h createOrGetFragmentStateManager = createOrGetFragmentStateManager(fragment);
        fragment.mFragmentManager = this;
        this.mFragmentStore.q(createOrGetFragmentStateManager);
        if (!fragment.mDetached) {
            this.mFragmentStore.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
        return createOrGetFragmentStateManager;
    }

    public void addFragmentOnAttachListener(@NonNull FragmentOnAttachListener fragmentOnAttachListener) {
        this.mOnAttachListeners.add(fragmentOnAttachListener);
    }

    public void addOnBackStackChangedListener(@NonNull OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList<>();
        }
        this.mBackStackChangeListeners.add(onBackStackChangedListener);
    }

    /* access modifiers changed from: package-private */
    public void addRetainedFragment(@NonNull Fragment fragment) {
        this.mNonConfig.a(fragment);
    }

    /* access modifiers changed from: package-private */
    public int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: androidx.activity.OnBackPressedDispatcherOwner} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: androidx.fragment.app.Fragment} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"SyntheticAccessor"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void attachController(@androidx.annotation.NonNull androidx.fragment.app.FragmentHostCallback<?> r3, @androidx.annotation.NonNull androidx.fragment.app.FragmentContainer r4, @androidx.annotation.Nullable androidx.fragment.app.Fragment r5) {
        /*
            r2 = this;
            androidx.fragment.app.FragmentHostCallback<?> r0 = r2.mHost
            if (r0 != 0) goto L_0x0108
            r2.mHost = r3
            r2.mContainer = r4
            r2.mParent = r5
            if (r5 == 0) goto L_0x0015
            androidx.fragment.app.FragmentManager$i r4 = new androidx.fragment.app.FragmentManager$i
            r4.<init>(r5)
            r2.addFragmentOnAttachListener(r4)
            goto L_0x001f
        L_0x0015:
            boolean r4 = r3 instanceof androidx.fragment.app.FragmentOnAttachListener
            if (r4 == 0) goto L_0x001f
            r4 = r3
            androidx.fragment.app.FragmentOnAttachListener r4 = (androidx.fragment.app.FragmentOnAttachListener) r4
            r2.addFragmentOnAttachListener(r4)
        L_0x001f:
            androidx.fragment.app.Fragment r4 = r2.mParent
            if (r4 == 0) goto L_0x0026
            r2.updateOnBackPressedCallbackEnabled()
        L_0x0026:
            boolean r4 = r3 instanceof androidx.activity.OnBackPressedDispatcherOwner
            if (r4 == 0) goto L_0x003b
            r4 = r3
            androidx.activity.OnBackPressedDispatcherOwner r4 = (androidx.activity.OnBackPressedDispatcherOwner) r4
            androidx.activity.OnBackPressedDispatcher r0 = r4.getOnBackPressedDispatcher()
            r2.mOnBackPressedDispatcher = r0
            if (r5 == 0) goto L_0x0036
            r4 = r5
        L_0x0036:
            androidx.activity.OnBackPressedCallback r1 = r2.mOnBackPressedCallback
            r0.addCallback(r4, r1)
        L_0x003b:
            if (r5 == 0) goto L_0x0046
            androidx.fragment.app.FragmentManager r3 = r5.mFragmentManager
            androidx.fragment.app.g r3 = r3.getChildNonConfig(r5)
            r2.mNonConfig = r3
            goto L_0x005f
        L_0x0046:
            boolean r4 = r3 instanceof androidx.lifecycle.ViewModelStoreOwner
            if (r4 == 0) goto L_0x0057
            androidx.lifecycle.ViewModelStoreOwner r3 = (androidx.lifecycle.ViewModelStoreOwner) r3
            androidx.lifecycle.ViewModelStore r3 = r3.getViewModelStore()
            androidx.fragment.app.g r3 = androidx.fragment.app.g.e(r3)
            r2.mNonConfig = r3
            goto L_0x005f
        L_0x0057:
            androidx.fragment.app.g r3 = new androidx.fragment.app.g
            r4 = 0
            r3.<init>(r4)
            r2.mNonConfig = r3
        L_0x005f:
            androidx.fragment.app.g r3 = r2.mNonConfig
            boolean r4 = r2.isStateSaved()
            r3.l(r4)
            androidx.fragment.app.i r3 = r2.mFragmentStore
            androidx.fragment.app.g r4 = r2.mNonConfig
            r3.y(r4)
            androidx.fragment.app.FragmentHostCallback<?> r3 = r2.mHost
            boolean r4 = r3 instanceof androidx.activity.result.ActivityResultRegistryOwner
            if (r4 == 0) goto L_0x0107
            androidx.activity.result.ActivityResultRegistryOwner r3 = (androidx.activity.result.ActivityResultRegistryOwner) r3
            androidx.activity.result.ActivityResultRegistry r3 = r3.getActivityResultRegistry()
            if (r5 == 0) goto L_0x0091
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r5.mWho
            r4.append(r5)
            java.lang.String r5 = ":"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            goto L_0x0093
        L_0x0091:
            java.lang.String r4 = ""
        L_0x0093:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "FragmentManager:"
            r5.append(r0)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r0 = "StartActivityForResult"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult r0 = new androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult
            r0.<init>()
            androidx.fragment.app.FragmentManager$j r1 = new androidx.fragment.app.FragmentManager$j
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r5 = r3.register(r5, r0, r1)
            r2.mStartActivityForResult = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r0 = "StartIntentSenderForResult"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            androidx.fragment.app.FragmentManager$k r0 = new androidx.fragment.app.FragmentManager$k
            r0.<init>()
            androidx.fragment.app.FragmentManager$a r1 = new androidx.fragment.app.FragmentManager$a
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r5 = r3.register(r5, r0, r1)
            r2.mStartIntentSenderForResult = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = "RequestPermissions"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions r5 = new androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions
            r5.<init>()
            androidx.fragment.app.FragmentManager$b r0 = new androidx.fragment.app.FragmentManager$b
            r0.<init>()
            androidx.activity.result.ActivityResultLauncher r3 = r3.register(r4, r5, r0)
            r2.mRequestPermissions = r3
        L_0x0107:
            return
        L_0x0108:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Already attached"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.attachController(androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer, androidx.fragment.app.Fragment):void");
    }

    /* access modifiers changed from: package-private */
    public void attachFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.mFragmentStore.a(fragment);
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "add from attach: " + fragment);
                }
                if (isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
            }
        }
    }

    @NonNull
    public FragmentTransaction beginTransaction() {
        return new a(this);
    }

    /* access modifiers changed from: package-private */
    public boolean checkForMenus() {
        boolean z10 = false;
        for (Fragment fragment : this.mFragmentStore.m()) {
            if (fragment != null) {
                z10 = isMenuAvailable(fragment);
                continue;
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    public final void clearFragmentResult(@NonNull String str) {
        this.mResults.remove(str);
    }

    public final void clearFragmentResultListener(@NonNull String str) {
        l remove = this.mResultListeners.remove(str);
        if (remove != null) {
            remove.b();
        }
    }

    /* access modifiers changed from: package-private */
    public void completeExecute(@NonNull a aVar, boolean z10, boolean z11, boolean z12) {
        if (z10) {
            aVar.g(z12);
        } else {
            aVar.f();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z10));
        if (z11 && this.mCurState >= 1) {
            j.C(this.mHost.getContext(), this.mContainer, arrayList, arrayList2, 0, 1, true, this.mFragmentTransitionCallback);
        }
        if (z12) {
            moveToState(this.mCurState, true);
        }
        for (Fragment fragment : this.mFragmentStore.m()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.i(fragment.mContainerId)) {
                float f10 = fragment.mPostponedAlpha;
                if (f10 > 0.0f) {
                    fragment.mView.setAlpha(f10);
                }
                if (z12) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public h createOrGetFragmentStateManager(@NonNull Fragment fragment) {
        h n10 = this.mFragmentStore.n(fragment.mWho);
        if (n10 != null) {
            return n10;
        }
        h hVar = new h(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, fragment);
        hVar.o(this.mHost.getContext().getClassLoader());
        hVar.u(this.mCurState);
        return hVar;
    }

    /* access modifiers changed from: package-private */
    public void detachFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "remove from detach: " + fragment);
                }
                this.mFragmentStore.t(fragment);
                if (isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
                setVisibleRemovingFragment(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.l(false);
        dispatchStateChange(4);
    }

    /* access modifiers changed from: package-private */
    public void dispatchAttach() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.l(false);
        dispatchStateChange(0);
    }

    /* access modifiers changed from: package-private */
    public void dispatchConfigurationChanged(@NonNull Configuration configuration) {
        for (Fragment fragment : this.mFragmentStore.o()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchContextItemSelected(@NonNull MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.o()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.l(false);
        dispatchStateChange(1);
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        if (this.mCurState < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z10 = false;
        for (Fragment fragment : this.mFragmentStore.o()) {
            if (fragment != null && isParentMenuVisible(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z10 = true;
            }
        }
        if (this.mCreatedMenus != null) {
            for (int i10 = 0; i10 < this.mCreatedMenus.size(); i10++) {
                Fragment fragment2 = this.mCreatedMenus.get(i10);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z10;
    }

    /* access modifiers changed from: package-private */
    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions(true);
        endAnimatingAwayFragments();
        dispatchStateChange(-1);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher != null) {
            this.mOnBackPressedCallback.remove();
            this.mOnBackPressedDispatcher = null;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = this.mStartActivityForResult;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
            this.mStartIntentSenderForResult.unregister();
            this.mRequestPermissions.unregister();
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    /* access modifiers changed from: package-private */
    public void dispatchLowMemory() {
        for (Fragment fragment : this.mFragmentStore.o()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchMultiWindowModeChanged(boolean z10) {
        for (Fragment fragment : this.mFragmentStore.o()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnAttachFragment(@NonNull Fragment fragment) {
        Iterator<FragmentOnAttachListener> it = this.mOnAttachListeners.iterator();
        while (it.hasNext()) {
            it.next().onAttachFragment(this, fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.o()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOptionsMenuClosed(@NonNull Menu menu) {
        if (this.mCurState >= 1) {
            for (Fragment fragment : this.mFragmentStore.o()) {
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchPause() {
        dispatchStateChange(5);
    }

    /* access modifiers changed from: package-private */
    public void dispatchPictureInPictureModeChanged(boolean z10) {
        for (Fragment fragment : this.mFragmentStore.o()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchPrepareOptionsMenu(@NonNull Menu menu) {
        boolean z10 = false;
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.o()) {
            if (fragment != null && isParentMenuVisible(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public void dispatchPrimaryNavigationFragmentChanged() {
        updateOnBackPressedCallbackEnabled();
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    /* access modifiers changed from: package-private */
    public void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.l(false);
        dispatchStateChange(7);
    }

    /* access modifiers changed from: package-private */
    public void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.l(false);
        dispatchStateChange(5);
    }

    /* access modifiers changed from: package-private */
    public void dispatchStop() {
        this.mStopped = true;
        this.mNonConfig.l(true);
        dispatchStateChange(4);
    }

    /* access modifiers changed from: package-private */
    public void dispatchViewCreated() {
        dispatchStateChange(2);
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.mFragmentStore.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.mCreatedMenus;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size2; i10++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(this.mCreatedMenus.get(i10).toString());
            }
        }
        ArrayList<a> arrayList2 = this.mBackStack;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size; i11++) {
                a aVar = this.mBackStack.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.d(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.mBackStackIndex.get());
        synchronized (this.mPendingActions) {
            try {
                int size3 = this.mPendingActions.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i12 = 0; i12 < size3; i12++) {
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i12);
                        printWriter.print(": ");
                        printWriter.println(this.mPendingActions.get(i12));
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
    }

    /* access modifiers changed from: package-private */
    public void enqueueAction(@NonNull m mVar, boolean z10) {
        if (!z10) {
            if (this.mHost != null) {
                checkStateLoss();
            } else if (this.mDestroyed) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.mPendingActions) {
            try {
                if (this.mHost != null) {
                    this.mPendingActions.add(mVar);
                    scheduleCommit();
                } else if (!z10) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean execPendingActions(boolean z10) {
        ensureExecReady(z10);
        boolean z11 = false;
        while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
            z11 = true;
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.b();
        return z11;
    }

    /* access modifiers changed from: package-private */
    public void execSingleAction(@NonNull m mVar, boolean z10) {
        if (!z10 || (this.mHost != null && !this.mDestroyed)) {
            ensureExecReady(z10);
            if (mVar.a(this.mTmpRecords, this.mTmpIsPop)) {
                this.mExecutingActions = true;
                try {
                    removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                } finally {
                    cleanupExec();
                }
            }
            updateOnBackPressedCallbackEnabled();
            doPendingDeferredStart();
            this.mFragmentStore.b();
        }
    }

    public boolean executePendingTransactions() {
        boolean execPendingActions = execPendingActions(true);
        forcePostponedTransactions();
        return execPendingActions;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment findActiveFragment(@NonNull String str) {
        return this.mFragmentStore.f(str);
    }

    @Nullable
    public Fragment findFragmentById(@IdRes int i10) {
        return this.mFragmentStore.g(i10);
    }

    @Nullable
    public Fragment findFragmentByTag(@Nullable String str) {
        return this.mFragmentStore.h(str);
    }

    /* access modifiers changed from: package-private */
    public Fragment findFragmentByWho(@NonNull String str) {
        return this.mFragmentStore.i(str);
    }

    /* access modifiers changed from: package-private */
    public int getActiveFragmentCount() {
        return this.mFragmentStore.k();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<Fragment> getActiveFragments() {
        return this.mFragmentStore.m();
    }

    @NonNull
    public BackStackEntry getBackStackEntryAt(int i10) {
        return this.mBackStack.get(i10);
    }

    public int getBackStackEntryCount() {
        ArrayList<a> arrayList = this.mBackStack;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentContainer getContainer() {
        return this.mContainer;
    }

    @Nullable
    public Fragment getFragment(@NonNull Bundle bundle, @NonNull String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment findActiveFragment = findActiveFragment(string);
        if (findActiveFragment == null) {
            throwException(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return findActiveFragment;
    }

    @NonNull
    public FragmentFactory getFragmentFactory() {
        FragmentFactory fragmentFactory = this.mFragmentFactory;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Fragment fragment = this.mParent;
        if (fragment != null) {
            return fragment.mFragmentManager.getFragmentFactory();
        }
        return this.mHostFragmentFactory;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public i getFragmentStore() {
        return this.mFragmentStore;
    }

    @NonNull
    public List<Fragment> getFragments() {
        return this.mFragmentStore.o();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentHostCallback<?> getHost() {
        return this.mHost;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public e getLifecycleCallbacksDispatcher() {
        return this.mLifecycleCallbacksDispatcher;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment getParent() {
        return this.mParent;
    }

    @Nullable
    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public o getSpecialEffectsControllerFactory() {
        o oVar = this.mSpecialEffectsControllerFactory;
        if (oVar != null) {
            return oVar;
        }
        Fragment fragment = this.mParent;
        if (fragment != null) {
            return fragment.mFragmentManager.getSpecialEffectsControllerFactory();
        }
        return this.mDefaultSpecialEffectsControllerFactory;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ViewModelStore getViewModelStore(@NonNull Fragment fragment) {
        return this.mNonConfig.h(fragment);
    }

    /* access modifiers changed from: package-private */
    public void handleOnBackPressed() {
        execPendingActions(true);
        if (this.mOnBackPressedCallback.isEnabled()) {
            popBackStackImmediate();
        } else {
            this.mOnBackPressedDispatcher.onBackPressed();
        }
    }

    /* access modifiers changed from: package-private */
    public void hideFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            setVisibleRemovingFragment(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void invalidateMenuForFragment(@NonNull Fragment fragment) {
        if (fragment.mAdded && isMenuAvailable(fragment)) {
            this.mNeedMenuInvalidate = true;
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    /* access modifiers changed from: package-private */
    public boolean isParentMenuVisible(@Nullable Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    /* access modifiers changed from: package-private */
    public boolean isPrimaryNavigation(@Nullable Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (!fragment.equals(fragmentManager.getPrimaryNavigationFragment()) || !isPrimaryNavigation(fragmentManager.mParent)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isStateAtLeast(int i10) {
        if (this.mCurState >= i10) {
            return true;
        }
        return false;
    }

    public boolean isStateSaved() {
        if (this.mStateSaved || this.mStopped) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void launchRequestPermissions(@NonNull Fragment fragment, @NonNull String[] strArr, int i10) {
        if (this.mRequestPermissions != null) {
            this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(fragment.mWho, i10));
            this.mRequestPermissions.launch(strArr);
            return;
        }
        this.mHost.onRequestPermissionsFromFragment(fragment, strArr, i10);
    }

    /* access modifiers changed from: package-private */
    public void launchStartActivityForResult(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, @Nullable Bundle bundle) {
        if (this.mStartActivityForResult != null) {
            this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(fragment.mWho, i10));
            if (!(intent == null || bundle == null)) {
                intent.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundle);
            }
            this.mStartActivityForResult.launch(intent);
            return;
        }
        this.mHost.onStartActivityFromFragment(fragment, intent, i10, bundle);
    }

    /* access modifiers changed from: package-private */
    public void launchStartIntentSenderForResult(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, @Nullable Intent intent, int i11, int i12, int i13, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        Fragment fragment2 = fragment;
        Bundle bundle2 = bundle;
        if (this.mStartIntentSenderForResult != null) {
            if (bundle2 != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra(EXTRA_CREATED_FILLIN_INTENT, true);
                } else {
                    intent2 = intent;
                }
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "ActivityOptions " + bundle2 + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
                }
                intent2.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundle2);
            } else {
                intent2 = intent;
            }
            IntentSender intentSender2 = intentSender;
            IntentSenderRequest build = new IntentSenderRequest.Builder(intentSender).setFillInIntent(intent2).setFlags(i12, i11).build();
            int i14 = i10;
            this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(fragment2.mWho, i10));
            if (isLoggingEnabled(2)) {
                Log.v(TAG, "Fragment " + fragment + "is launching an IntentSender for result ");
            }
            this.mStartIntentSenderForResult.launch(build);
            return;
        }
        IntentSender intentSender3 = intentSender;
        int i15 = i10;
        int i16 = i11;
        int i17 = i12;
        this.mHost.onStartIntentSenderFromFragment(fragment, intentSender, i10, intent, i11, i12, i13, bundle);
    }

    /* access modifiers changed from: package-private */
    public void moveFragmentToExpectedState(@NonNull Fragment fragment) {
        if (this.mFragmentStore.c(fragment.mWho)) {
            moveToState(fragment);
            View view = fragment.mView;
            if (!(view == null || !fragment.mIsNewlyAdded || fragment.mContainer == null)) {
                float f10 = fragment.mPostponedAlpha;
                if (f10 > 0.0f) {
                    view.setAlpha(f10);
                }
                fragment.mPostponedAlpha = 0.0f;
                fragment.mIsNewlyAdded = false;
                c.d c10 = c.c(this.mHost.getContext(), fragment, true, fragment.getPopDirection());
                if (c10 != null) {
                    Animation animation = c10.f15716a;
                    if (animation != null) {
                        fragment.mView.startAnimation(animation);
                    } else {
                        c10.f15717b.setTarget(fragment.mView);
                        c10.f15717b.start();
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                completeShowHideFragment(fragment);
            }
        } else if (isLoggingEnabled(3)) {
            Log.d(TAG, "Ignoring moving " + fragment + " to state " + this.mCurState + "since it is not added to " + this);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r2 != 5) goto L_0x0165;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void moveToState(@androidx.annotation.NonNull androidx.fragment.app.Fragment r11, int r12) {
        /*
            r10 = this;
            androidx.fragment.app.i r0 = r10.mFragmentStore
            java.lang.String r1 = r11.mWho
            androidx.fragment.app.h r0 = r0.n(r1)
            r1 = 1
            if (r0 != 0) goto L_0x0017
            androidx.fragment.app.h r0 = new androidx.fragment.app.h
            androidx.fragment.app.e r2 = r10.mLifecycleCallbacksDispatcher
            androidx.fragment.app.i r3 = r10.mFragmentStore
            r0.<init>(r2, r3, r11)
            r0.u(r1)
        L_0x0017:
            boolean r2 = r11.mFromLayout
            r3 = 2
            if (r2 == 0) goto L_0x0028
            boolean r2 = r11.mInLayout
            if (r2 == 0) goto L_0x0028
            int r2 = r11.mState
            if (r2 != r3) goto L_0x0028
            int r12 = java.lang.Math.max(r12, r3)
        L_0x0028:
            int r2 = r0.d()
            int r12 = java.lang.Math.min(r12, r2)
            int r2 = r11.mState
            r4 = 3
            java.lang.String r5 = "FragmentManager"
            r6 = 5
            r7 = 4
            r8 = -1
            if (r2 > r12) goto L_0x007c
            if (r2 >= r12) goto L_0x0047
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.CancellationSignal>> r2 = r10.mExitAnimationCancellationSignals
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0047
            r10.cancelExitAnimation(r11)
        L_0x0047:
            int r2 = r11.mState
            if (r2 == r8) goto L_0x0057
            if (r2 == 0) goto L_0x005c
            if (r2 == r1) goto L_0x0061
            if (r2 == r3) goto L_0x006b
            if (r2 == r7) goto L_0x0070
            if (r2 == r6) goto L_0x0075
            goto L_0x0165
        L_0x0057:
            if (r12 <= r8) goto L_0x005c
            r0.c()
        L_0x005c:
            if (r12 <= 0) goto L_0x0061
            r0.e()
        L_0x0061:
            if (r12 <= r8) goto L_0x0066
            r0.j()
        L_0x0066:
            if (r12 <= r1) goto L_0x006b
            r0.f()
        L_0x006b:
            if (r12 <= r3) goto L_0x0070
            r0.a()
        L_0x0070:
            if (r12 <= r7) goto L_0x0075
            r0.v()
        L_0x0075:
            if (r12 <= r6) goto L_0x0165
            r0.p()
            goto L_0x0165
        L_0x007c:
            if (r2 <= r12) goto L_0x0165
            if (r2 == 0) goto L_0x015e
            if (r2 == r1) goto L_0x0150
            if (r2 == r3) goto L_0x00c6
            if (r2 == r7) goto L_0x0097
            if (r2 == r6) goto L_0x0092
            r9 = 7
            if (r2 == r9) goto L_0x008d
            goto L_0x0165
        L_0x008d:
            if (r12 >= r9) goto L_0x0092
            r0.n()
        L_0x0092:
            if (r12 >= r6) goto L_0x0097
            r0.w()
        L_0x0097:
            if (r12 >= r7) goto L_0x00c6
            boolean r2 = isLoggingEnabled(r4)
            if (r2 == 0) goto L_0x00b3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "movefrom ACTIVITY_CREATED: "
            r2.append(r6)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r5, r2)
        L_0x00b3:
            android.view.View r2 = r11.mView
            if (r2 == 0) goto L_0x00c6
            androidx.fragment.app.FragmentHostCallback<?> r2 = r10.mHost
            boolean r2 = r2.onShouldSaveFragmentState(r11)
            if (r2 == 0) goto L_0x00c6
            android.util.SparseArray<android.os.Parcelable> r2 = r11.mSavedViewState
            if (r2 != 0) goto L_0x00c6
            r0.t()
        L_0x00c6:
            if (r12 >= r3) goto L_0x0150
            android.view.View r2 = r11.mView
            if (r2 == 0) goto L_0x0145
            android.view.ViewGroup r6 = r11.mContainer
            if (r6 == 0) goto L_0x0145
            r6.endViewTransition(r2)
            android.view.View r2 = r11.mView
            r2.clearAnimation()
            boolean r2 = r11.isRemovingParent()
            if (r2 != 0) goto L_0x0145
            int r2 = r10.mCurState
            r6 = 0
            if (r2 <= r8) goto L_0x0105
            boolean r2 = r10.mDestroyed
            if (r2 != 0) goto L_0x0105
            android.view.View r2 = r11.mView
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x0105
            float r2 = r11.mPostponedAlpha
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x0105
            androidx.fragment.app.FragmentHostCallback<?> r2 = r10.mHost
            android.content.Context r2 = r2.getContext()
            r7 = 0
            boolean r8 = r11.getPopDirection()
            androidx.fragment.app.c$d r2 = androidx.fragment.app.c.c(r2, r11, r7, r8)
            goto L_0x0106
        L_0x0105:
            r2 = 0
        L_0x0106:
            r11.mPostponedAlpha = r6
            android.view.ViewGroup r6 = r11.mContainer
            android.view.View r7 = r11.mView
            if (r2 == 0) goto L_0x0113
            androidx.fragment.app.j$g r8 = r10.mFragmentTransitionCallback
            androidx.fragment.app.c.a(r11, r2, r8)
        L_0x0113:
            r6.removeView(r7)
            boolean r2 = isLoggingEnabled(r3)
            if (r2 == 0) goto L_0x0140
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Removing view "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = " for fragment "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r3 = " from container "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            android.util.Log.v(r5, r2)
        L_0x0140:
            android.view.ViewGroup r2 = r11.mContainer
            if (r6 == r2) goto L_0x0145
            return
        L_0x0145:
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.CancellationSignal>> r2 = r10.mExitAnimationCancellationSignals
            java.lang.Object r2 = r2.get(r11)
            if (r2 != 0) goto L_0x0150
            r0.h()
        L_0x0150:
            if (r12 >= r1) goto L_0x015e
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.CancellationSignal>> r2 = r10.mExitAnimationCancellationSignals
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L_0x015b
            goto L_0x015f
        L_0x015b:
            r0.g()
        L_0x015e:
            r1 = r12
        L_0x015f:
            if (r1 >= 0) goto L_0x0164
            r0.i()
        L_0x0164:
            r12 = r1
        L_0x0165:
            int r0 = r11.mState
            if (r0 == r12) goto L_0x0197
            boolean r0 = isLoggingEnabled(r4)
            if (r0 == 0) goto L_0x0195
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveToState: Fragment state for "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r1 = " not updated inline; expected state "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r1 = " found "
            r0.append(r1)
            int r1 = r11.mState
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r5, r0)
        L_0x0195:
            r11.mState = r12
        L_0x0197:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.moveToState(androidx.fragment.app.Fragment, int):void");
    }

    /* access modifiers changed from: package-private */
    public void noteStateNotSaved() {
        if (this.mHost != null) {
            this.mStateSaved = false;
            this.mStopped = false;
            this.mNonConfig.l(false);
            for (Fragment fragment : this.mFragmentStore.o()) {
                if (fragment != null) {
                    fragment.noteStateNotSaved();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onContainerAvailable(@NonNull FragmentContainerView fragmentContainerView) {
        View view;
        for (h hVar : this.mFragmentStore.l()) {
            Fragment k10 = hVar.k();
            if (k10.mContainerId == fragmentContainerView.getId() && (view = k10.mView) != null && view.getParent() == null) {
                k10.mContainer = fragmentContainerView;
                hVar.b();
            }
        }
    }

    @NonNull
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    /* access modifiers changed from: package-private */
    public void performPendingDeferredStart(@NonNull h hVar) {
        Fragment k10 = hVar.k();
        if (!k10.mDeferStart) {
            return;
        }
        if (this.mExecutingActions) {
            this.mHavePendingDeferredStart = true;
            return;
        }
        k10.mDeferStart = false;
        if (USE_STATE_MANAGER) {
            hVar.m();
        } else {
            moveToState(k10);
        }
    }

    public void popBackStack() {
        enqueueAction(new n((String) null, -1, 0), false);
    }

    public boolean popBackStackImmediate() {
        return popBackStackImmediate((String) null, -1, 0);
    }

    /* access modifiers changed from: package-private */
    public boolean popBackStackState(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2, @Nullable String str, int i10, int i11) {
        int i12;
        ArrayList<a> arrayList3 = this.mBackStack;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i10 < 0 && (i11 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.mBackStack.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i10 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    a aVar = this.mBackStack.get(size2);
                    if ((str != null && str.equals(aVar.getName())) || (i10 >= 0 && i10 == aVar.f15662c)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i11 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        a aVar2 = this.mBackStack.get(size2);
                        if ((str == null || !str.equals(aVar2.getName())) && (i10 < 0 || i10 != aVar2.f15662c)) {
                            break;
                        }
                    }
                }
                i12 = size2;
            } else {
                i12 = -1;
            }
            if (i12 == this.mBackStack.size() - 1) {
                return false;
            }
            for (int size3 = this.mBackStack.size() - 1; size3 > i12; size3--) {
                arrayList.add(this.mBackStack.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public void putFragment(@NonNull Bundle bundle, @NonNull String str, @NonNull Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public void registerFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z10) {
        this.mLifecycleCallbacksDispatcher.o(fragmentLifecycleCallbacks, z10);
    }

    /* access modifiers changed from: package-private */
    public void removeCancellationSignal(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
        HashSet hashSet = this.mExitAnimationCancellationSignals.get(fragment);
        if (hashSet != null && hashSet.remove(cancellationSignal) && hashSet.isEmpty()) {
            this.mExitAnimationCancellationSignals.remove(fragment);
            if (fragment.mState < 5) {
                destroyFragmentView(fragment);
                moveToState(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removeFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z10 = !fragment.isInBackStack();
        if (!fragment.mDetached || z10) {
            this.mFragmentStore.t(fragment);
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mRemoving = true;
            setVisibleRemovingFragment(fragment);
        }
    }

    public void removeFragmentOnAttachListener(@NonNull FragmentOnAttachListener fragmentOnAttachListener) {
        this.mOnAttachListeners.remove(fragmentOnAttachListener);
    }

    public void removeOnBackStackChangedListener(@NonNull OnBackStackChangedListener onBackStackChangedListener) {
        ArrayList<OnBackStackChangedListener> arrayList = this.mBackStackChangeListeners;
        if (arrayList != null) {
            arrayList.remove(onBackStackChangedListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeRetainedFragment(@NonNull Fragment fragment) {
        this.mNonConfig.j(fragment);
    }

    /* access modifiers changed from: package-private */
    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (this.mHost instanceof ViewModelStoreOwner) {
            throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }
        this.mNonConfig.k(fragmentManagerNonConfig);
        restoreSaveState(parcelable);
    }

    /* access modifiers changed from: package-private */
    public void restoreSaveState(@Nullable Parcelable parcelable) {
        h hVar;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f15613a != null) {
                this.mFragmentStore.u();
                Iterator it = fragmentManagerState.f15613a.iterator();
                while (it.hasNext()) {
                    FragmentState fragmentState = (FragmentState) it.next();
                    if (fragmentState != null) {
                        Fragment c10 = this.mNonConfig.c(fragmentState.f15622b);
                        if (c10 != null) {
                            if (isLoggingEnabled(2)) {
                                Log.v(TAG, "restoreSaveState: re-attaching retained " + c10);
                            }
                            hVar = new h(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, c10, fragmentState);
                        } else {
                            hVar = new h(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.getContext().getClassLoader(), getFragmentFactory(), fragmentState);
                        }
                        Fragment k10 = hVar.k();
                        k10.mFragmentManager = this;
                        if (isLoggingEnabled(2)) {
                            Log.v(TAG, "restoreSaveState: active (" + k10.mWho + "): " + k10);
                        }
                        hVar.o(this.mHost.getContext().getClassLoader());
                        this.mFragmentStore.q(hVar);
                        hVar.u(this.mCurState);
                    }
                }
                for (Fragment fragment : this.mNonConfig.f()) {
                    if (!this.mFragmentStore.c(fragment.mWho)) {
                        if (isLoggingEnabled(2)) {
                            Log.v(TAG, "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f15613a);
                        }
                        this.mNonConfig.j(fragment);
                        fragment.mFragmentManager = this;
                        h hVar2 = new h(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, fragment);
                        hVar2.u(1);
                        hVar2.m();
                        fragment.mRemoving = true;
                        hVar2.m();
                    }
                }
                this.mFragmentStore.v(fragmentManagerState.f15614b);
                if (fragmentManagerState.f15615c != null) {
                    this.mBackStack = new ArrayList<>(fragmentManagerState.f15615c.length);
                    int i10 = 0;
                    while (true) {
                        BackStackState[] backStackStateArr = fragmentManagerState.f15615c;
                        if (i10 >= backStackStateArr.length) {
                            break;
                        }
                        a a10 = backStackStateArr[i10].a(this);
                        if (isLoggingEnabled(2)) {
                            Log.v(TAG, "restoreAllState: back stack #" + i10 + " (index " + a10.f15662c + "): " + a10);
                            PrintWriter printWriter = new PrintWriter(new m(TAG));
                            a10.e("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.mBackStack.add(a10);
                        i10++;
                    }
                } else {
                    this.mBackStack = null;
                }
                this.mBackStackIndex.set(fragmentManagerState.f15616d);
                String str = fragmentManagerState.f15617e;
                if (str != null) {
                    Fragment findActiveFragment = findActiveFragment(str);
                    this.mPrimaryNav = findActiveFragment;
                    dispatchParentPrimaryNavigationFragmentChanged(findActiveFragment);
                }
                ArrayList arrayList = fragmentManagerState.f15618f;
                if (arrayList != null) {
                    for (int i11 = 0; i11 < arrayList.size(); i11++) {
                        Bundle bundle = (Bundle) fragmentManagerState.f15619g.get(i11);
                        bundle.setClassLoader(this.mHost.getContext().getClassLoader());
                        this.mResults.put(arrayList.get(i11), bundle);
                    }
                }
                this.mLaunchedFragments = new ArrayDeque<>(fragmentManagerState.f15620h);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public FragmentManagerNonConfig retainNonConfig() {
        if (this.mHost instanceof ViewModelStoreOwner) {
            throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        }
        return this.mNonConfig.g();
    }

    /* access modifiers changed from: package-private */
    public Parcelable saveAllState() {
        int size;
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.l(true);
        ArrayList w10 = this.mFragmentStore.w();
        BackStackState[] backStackStateArr = null;
        if (w10.isEmpty()) {
            if (isLoggingEnabled(2)) {
                Log.v(TAG, "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList x10 = this.mFragmentStore.x();
        ArrayList<a> arrayList = this.mBackStack;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i10 = 0; i10 < size; i10++) {
                backStackStateArr[i10] = new BackStackState(this.mBackStack.get(i10));
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "saveAllState: adding back stack #" + i10 + ": " + this.mBackStack.get(i10));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f15613a = w10;
        fragmentManagerState.f15614b = x10;
        fragmentManagerState.f15615c = backStackStateArr;
        fragmentManagerState.f15616d = this.mBackStackIndex.get();
        Fragment fragment = this.mPrimaryNav;
        if (fragment != null) {
            fragmentManagerState.f15617e = fragment.mWho;
        }
        fragmentManagerState.f15618f.addAll(this.mResults.keySet());
        fragmentManagerState.f15619g.addAll(this.mResults.values());
        fragmentManagerState.f15620h = new ArrayList(this.mLaunchedFragments);
        return fragmentManagerState;
    }

    @Nullable
    public Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment fragment) {
        h n10 = this.mFragmentStore.n(fragment.mWho);
        if (n10 == null || !n10.k().equals(fragment)) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return n10.r();
    }

    /* access modifiers changed from: package-private */
    public void scheduleCommit() {
        boolean z10;
        synchronized (this.mPendingActions) {
            try {
                ArrayList<o> arrayList = this.mPostponedTransactions;
                boolean z11 = false;
                if (arrayList == null || arrayList.isEmpty()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (this.mPendingActions.size() == 1) {
                    z11 = true;
                }
                if (z10 || z11) {
                    this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                    this.mHost.getHandler().post(this.mExecCommit);
                    updateOnBackPressedCallbackEnabled();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setExitAnimationOrder(@NonNull Fragment fragment, boolean z10) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer != null && (fragmentContainer instanceof FragmentContainerView)) {
            ((FragmentContainerView) fragmentContainer).setDrawDisappearingViewsLast(!z10);
        }
    }

    public void setFragmentFactory(@NonNull FragmentFactory fragmentFactory) {
        this.mFragmentFactory = fragmentFactory;
    }

    public final void setFragmentResult(@NonNull String str, @NonNull Bundle bundle) {
        l lVar = this.mResultListeners.get(str);
        if (lVar == null || !lVar.a(Lifecycle.State.STARTED)) {
            this.mResults.put(str, bundle);
        } else {
            lVar.onFragmentResult(str, bundle);
        }
    }

    @SuppressLint({"SyntheticAccessor"})
    public final void setFragmentResultListener(@NonNull final String str, @NonNull LifecycleOwner lifecycleOwner, @NonNull final FragmentResultListener fragmentResultListener) {
        final Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            AnonymousClass6 r02 = new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    Bundle bundle;
                    if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) FragmentManager.this.mResults.get(str)) != null) {
                        fragmentResultListener.onFragmentResult(str, bundle);
                        FragmentManager.this.clearFragmentResult(str);
                    }
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.removeObserver(this);
                        FragmentManager.this.mResultListeners.remove(str);
                    }
                }
            };
            lifecycle.addObserver(r02);
            l put = this.mResultListeners.put(str, new l(lifecycle, fragmentResultListener, r02));
            if (put != null) {
                put.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (!fragment.equals(findActiveFragment(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = state;
    }

    /* access modifiers changed from: package-private */
    public void setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        if (fragment == null || (fragment.equals(findActiveFragment(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.mPrimaryNav;
            this.mPrimaryNav = fragment;
            dispatchParentPrimaryNavigationFragmentChanged(fragment2);
            dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* access modifiers changed from: package-private */
    public void setSpecialEffectsControllerFactory(@NonNull o oVar) {
        this.mSpecialEffectsControllerFactory = oVar;
    }

    /* access modifiers changed from: package-private */
    public void showFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Fragment fragment = this.mParent;
        if (fragment != null) {
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(this.mParent)));
            sb2.append("}");
        } else {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                sb2.append(fragmentHostCallback.getClass().getSimpleName());
                sb2.append("{");
                sb2.append(Integer.toHexString(System.identityHashCode(this.mHost)));
                sb2.append("}");
            } else {
                sb2.append("null");
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.mLifecycleCallbacksDispatcher.p(fragmentLifecycleCallbacks);
    }

    public void popBackStack(@Nullable String str, int i10) {
        enqueueAction(new n(str, -1, i10), false);
    }

    public boolean popBackStackImmediate(@Nullable String str, int i10) {
        return popBackStackImmediate(str, -1, i10);
    }

    @SuppressLint({"BanParcelableUsage"})
    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        String f15587a;

        /* renamed from: b  reason: collision with root package name */
        int f15588b;

        class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            /* renamed from: b */
            public LaunchedFragmentInfo[] newArray(int i10) {
                return new LaunchedFragmentInfo[i10];
            }
        }

        LaunchedFragmentInfo(String str, int i10) {
            this.f15587a = str;
            this.f15588b = i10;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f15587a);
            parcel.writeInt(this.f15588b);
        }

        LaunchedFragmentInfo(Parcel parcel) {
            this.f15587a = parcel.readString();
            this.f15588b = parcel.readInt();
        }
    }

    public void popBackStack(int i10, int i11) {
        if (i10 >= 0) {
            enqueueAction(new n((String) null, i10, i11), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public boolean popBackStackImmediate(int i10, int i11) {
        if (i10 >= 0) {
            return popBackStackImmediate((String) null, i10, i11);
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    private boolean popBackStackImmediate(@Nullable String str, int i10, int i11) {
        execPendingActions(false);
        ensureExecReady(true);
        Fragment fragment = this.mPrimaryNav;
        if (fragment != null && i10 < 0 && str == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean popBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, str, i10, i11);
        if (popBackStackState) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.b();
        return popBackStackState;
    }

    /* access modifiers changed from: package-private */
    public void moveToState(@NonNull Fragment fragment) {
        moveToState(fragment, this.mCurState);
    }

    /* access modifiers changed from: package-private */
    public void moveToState(int i10, boolean z10) {
        FragmentHostCallback<?> fragmentHostCallback;
        if (this.mHost == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z10 || i10 != this.mCurState) {
            this.mCurState = i10;
            if (USE_STATE_MANAGER) {
                this.mFragmentStore.s();
            } else {
                for (Fragment moveFragmentToExpectedState : this.mFragmentStore.o()) {
                    moveFragmentToExpectedState(moveFragmentToExpectedState);
                }
                for (h hVar : this.mFragmentStore.l()) {
                    Fragment k10 = hVar.k();
                    if (!k10.mIsNewlyAdded) {
                        moveFragmentToExpectedState(k10);
                    }
                    if (k10.mRemoving && !k10.isInBackStack()) {
                        this.mFragmentStore.r(hVar);
                    }
                }
            }
            startPendingDeferredFragments();
            if (this.mNeedMenuInvalidate && (fragmentHostCallback = this.mHost) != null && this.mCurState == 7) {
                fragmentHostCallback.onSupportInvalidateOptionsMenu();
                this.mNeedMenuInvalidate = false;
            }
        }
    }
}
