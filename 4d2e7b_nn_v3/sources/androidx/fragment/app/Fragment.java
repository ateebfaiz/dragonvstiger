package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import androidx.arch.core.util.Function;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ActivityResultCaller {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f15537a = 0;
    boolean mAdded;
    i mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    @NonNull
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    @LayoutRes
    private int mContentLayoutId;
    ViewModelProvider.Factory mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    Lifecycle.State mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<j> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    SavedStateRegistryController mSavedStateRegistryController;
    @Nullable
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    @Nullable
    l mViewLifecycleOwner;
    MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData;
    @NonNull
    String mWho;

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(@NonNull String str, @Nullable Exception exc) {
            super(str, exc);
        }
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            Fragment.this.callStartTransitionListener(false);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f15541a;

        c(n nVar) {
            this.f15541a = nVar;
        }

        public void run() {
            this.f15541a.g();
        }
    }

    class d extends FragmentContainer {
        d() {
        }

        public View onFindViewById(int i10) {
            View view = Fragment.this.mView;
            if (view != null) {
                return view.findViewById(i10);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }

        public boolean onHasView() {
            if (Fragment.this.mView != null) {
                return true;
            }
            return false;
        }
    }

    class e implements Function {
        e() {
        }

        /* renamed from: a */
        public ActivityResultRegistry apply(Void voidR) {
            Fragment fragment = Fragment.this;
            FragmentHostCallback<?> fragmentHostCallback = fragment.mHost;
            if (fragmentHostCallback instanceof ActivityResultRegistryOwner) {
                return ((ActivityResultRegistryOwner) fragmentHostCallback).getActivityResultRegistry();
            }
            return fragment.requireActivity().getActivityResultRegistry();
        }
    }

    class f implements Function {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActivityResultRegistry f15545a;

        f(ActivityResultRegistry activityResultRegistry) {
            this.f15545a = activityResultRegistry;
        }

        /* renamed from: a */
        public ActivityResultRegistry apply(Void voidR) {
            return this.f15545a;
        }
    }

    class g extends j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function f15547a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicReference f15548b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ActivityResultContract f15549c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ActivityResultCallback f15550d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Function function, AtomicReference atomicReference, ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
            super((a) null);
            this.f15547a = function;
            this.f15548b = atomicReference;
            this.f15549c = activityResultContract;
            this.f15550d = activityResultCallback;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f15548b.set(((ActivityResultRegistry) this.f15547a.apply(null)).register(Fragment.this.generateActivityResultKey(), Fragment.this, this.f15549c, this.f15550d));
        }
    }

    class h extends ActivityResultLauncher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicReference f15552a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ActivityResultContract f15553b;

        h(AtomicReference atomicReference, ActivityResultContract activityResultContract) {
            this.f15552a = atomicReference;
            this.f15553b = activityResultContract;
        }

        public ActivityResultContract getContract() {
            return this.f15553b;
        }

        public void launch(Object obj, ActivityOptionsCompat activityOptionsCompat) {
            ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) this.f15552a.get();
            if (activityResultLauncher != null) {
                activityResultLauncher.launch(obj, activityOptionsCompat);
                return;
            }
            throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        }

        public void unregister() {
            ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) this.f15552a.getAndSet((Object) null);
            if (activityResultLauncher != null) {
                activityResultLauncher.unregister();
            }
        }
    }

    static class i {

        /* renamed from: a  reason: collision with root package name */
        View f15555a;

        /* renamed from: b  reason: collision with root package name */
        Animator f15556b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15557c;

        /* renamed from: d  reason: collision with root package name */
        int f15558d;

        /* renamed from: e  reason: collision with root package name */
        int f15559e;

        /* renamed from: f  reason: collision with root package name */
        int f15560f;

        /* renamed from: g  reason: collision with root package name */
        int f15561g;

        /* renamed from: h  reason: collision with root package name */
        int f15562h;

        /* renamed from: i  reason: collision with root package name */
        ArrayList f15563i;

        /* renamed from: j  reason: collision with root package name */
        ArrayList f15564j;

        /* renamed from: k  reason: collision with root package name */
        Object f15565k = null;

        /* renamed from: l  reason: collision with root package name */
        Object f15566l;

        /* renamed from: m  reason: collision with root package name */
        Object f15567m;

        /* renamed from: n  reason: collision with root package name */
        Object f15568n;

        /* renamed from: o  reason: collision with root package name */
        Object f15569o;

        /* renamed from: p  reason: collision with root package name */
        Object f15570p;

        /* renamed from: q  reason: collision with root package name */
        Boolean f15571q;

        /* renamed from: r  reason: collision with root package name */
        Boolean f15572r;

        /* renamed from: s  reason: collision with root package name */
        SharedElementCallback f15573s;

        /* renamed from: t  reason: collision with root package name */
        SharedElementCallback f15574t;

        /* renamed from: u  reason: collision with root package name */
        float f15575u;

        /* renamed from: v  reason: collision with root package name */
        View f15576v;

        /* renamed from: w  reason: collision with root package name */
        boolean f15577w;

        /* renamed from: x  reason: collision with root package name */
        k f15578x;

        /* renamed from: y  reason: collision with root package name */
        boolean f15579y;

        i() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.f15566l = obj;
            this.f15567m = null;
            this.f15568n = obj;
            this.f15569o = null;
            this.f15570p = obj;
            this.f15573s = null;
            this.f15574t = null;
            this.f15575u = 1.0f;
            this.f15576v = null;
        }
    }

    private static abstract class j {
        private j() {
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    interface k {
        void a();

        void b();
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new f();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new a();
        this.mMaxState = Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new MutableLiveData<>();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList<>();
        initLifecycle();
    }

    private i ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new i();
        }
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        Lifecycle.State state = this.mMaxState;
        if (state == Lifecycle.State.INITIALIZED || this.mParentFragment == null) {
            return state.ordinal();
        }
        return Math.min(state.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mDefaultFactory = null;
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context context, @NonNull String str) {
        return instantiate(context, str, (Bundle) null);
    }

    @NonNull
    private <I, O> ActivityResultLauncher<I> prepareCallInternal(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull Function<Void, ActivityResultRegistry> function, @NonNull ActivityResultCallback<O> activityResultCallback) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            registerOnPreAttachListener(new g(function, atomicReference, activityResultContract, activityResultCallback));
            return new h(atomicReference, activityResultContract);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void registerOnPreAttachListener(@NonNull j jVar) {
        if (this.mState >= 0) {
            jVar.a();
        } else {
            this.mOnPreAttachedListeners.add(jVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void callStartTransitionListener(boolean z10) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        i iVar = this.mAnimationInfo;
        k kVar = null;
        if (iVar != null) {
            iVar.f15577w = false;
            k kVar2 = iVar.f15578x;
            iVar.f15578x = null;
            kVar = kVar2;
        }
        if (kVar != null) {
            kVar.b();
        } else if (FragmentManager.USE_STATE_MANAGER && this.mView != null && (viewGroup = this.mContainer) != null && (fragmentManager = this.mFragmentManager) != null) {
            n n10 = n.n(viewGroup, fragmentManager);
            n10.p();
            if (z10) {
                this.mHost.getHandler().post(new c(n10));
            } else {
                n10.g();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentContainer createFragmentContainer() {
        return new d();
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            LoaderManager.getInstance(this).dump(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        FragmentManager fragmentManager = this.mChildFragmentManager;
        fragmentManager.dump(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment findFragmentByWho(@NonNull String str) {
        if (str.equals(this.mWho)) {
            return this;
        }
        return this.mChildFragmentManager.findFragmentByWho(str);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    @Nullable
    public final FragmentActivity getActivity() {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return (FragmentActivity) fragmentHostCallback.getActivity();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.f15572r) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.f15571q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public View getAnimatingAway() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f15555a;
    }

    /* access modifiers changed from: package-private */
    public Animator getAnimator() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f15556b;
    }

    @Nullable
    public final Bundle getArguments() {
        return this.mArguments;
    }

    @NonNull
    public final FragmentManager getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    @Nullable
    public Context getContext() {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.getContext();
    }

    public /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.f.a(this);
    }

    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager != null) {
            if (this.mDefaultFactory == null) {
                Context applicationContext = requireContext().getApplicationContext();
                while (true) {
                    if (!(applicationContext instanceof ContextWrapper)) {
                        application = null;
                        break;
                    } else if (applicationContext instanceof Application) {
                        application = (Application) applicationContext;
                        break;
                    } else {
                        applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                    }
                }
                if (application == null && FragmentManager.isLoggingEnabled(3)) {
                    Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
                }
                this.mDefaultFactory = new SavedStateViewModelFactory(application, this, getArguments());
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    /* access modifiers changed from: package-private */
    public int getEnterAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f15558d;
    }

    @Nullable
    public Object getEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f15565k;
    }

    /* access modifiers changed from: package-private */
    public SharedElementCallback getEnterTransitionCallback() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f15573s;
    }

    /* access modifiers changed from: package-private */
    public int getExitAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f15559e;
    }

    @Nullable
    public Object getExitTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f15567m;
    }

    /* access modifiers changed from: package-private */
    public SharedElementCallback getExitTransitionCallback() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f15574t;
    }

    /* access modifiers changed from: package-private */
    public View getFocusedView() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f15576v;
    }

    @Deprecated
    @Nullable
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    @Nullable
    public final Object getHost() {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.onGetHost();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    @NonNull
    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater((Bundle) null) : layoutInflater;
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @NonNull
    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    /* access modifiers changed from: package-private */
    public int getNextTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f15562h;
    }

    @Nullable
    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    @NonNull
    public final FragmentManager getParentFragmentManager() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    /* access modifiers changed from: package-private */
    public boolean getPopDirection() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.f15557c;
    }

    /* access modifiers changed from: package-private */
    public int getPopEnterAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f15560f;
    }

    /* access modifiers changed from: package-private */
    public int getPopExitAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f15561g;
    }

    /* access modifiers changed from: package-private */
    public float getPostOnViewCreatedAlpha() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 1.0f;
        }
        return iVar.f15575u;
    }

    @Nullable
    public Object getReenterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f15568n;
        if (obj == USE_DEFAULT_TRANSITION) {
            return getExitTransition();
        }
        return obj;
    }

    @NonNull
    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    @Nullable
    public Object getReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f15566l;
        if (obj == USE_DEFAULT_TRANSITION) {
            return getEnterTransition();
        }
        return obj;
    }

    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Nullable
    public Object getSharedElementEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f15569o;
    }

    @Nullable
    public Object getSharedElementReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f15570p;
        if (obj == USE_DEFAULT_TRANSITION) {
            return getSharedElementEnterTransition();
        }
        return obj;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (arrayList = iVar.f15563i) == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (arrayList = iVar.f15564j) == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    @NonNull
    public final String getString(@StringRes int i10) {
        return getResources().getString(i10);
    }

    @Nullable
    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    @Nullable
    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return fragmentManager.findActiveFragment(str);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    @NonNull
    public final CharSequence getText(@StringRes int i10) {
        return getResources().getText(i10);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @Nullable
    public View getView() {
        return this.mView;
    }

    @MainThread
    @NonNull
    public LifecycleOwner getViewLifecycleOwner() {
        l lVar = this.mViewLifecycleOwner;
        if (lVar != null) {
            return lVar;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    @NonNull
    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @NonNull
    public ViewModelStore getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        } else if (getMinimumMaxLifecycleState() != Lifecycle.State.INITIALIZED.ordinal()) {
            return this.mFragmentManager.getViewModelStore(this);
        } else {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: package-private */
    public void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new f();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        if (this.mHost == null || !this.mAdded) {
            return false;
        }
        return true;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    /* access modifiers changed from: package-private */
    public boolean isHideReplaced() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.f15579y;
    }

    /* access modifiers changed from: package-private */
    public final boolean isInBackStack() {
        if (this.mBackStackNesting > 0) {
            return true;
        }
        return false;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean isMenuVisible() {
        FragmentManager fragmentManager;
        if (!this.mMenuVisible || ((fragmentManager = this.mFragmentManager) != null && !fragmentManager.isParentMenuVisible(this.mParentFragment))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isPostponed() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.f15577w;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    /* access modifiers changed from: package-private */
    public final boolean isRemovingParent() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null || (!parentFragment.isRemoving() && !parentFragment.isRemovingParent())) {
            return false;
        }
        return true;
    }

    public final boolean isResumed() {
        if (this.mState >= 7) {
            return true;
        }
        return false;
    }

    public final boolean isStateSaved() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.isStateSaved();
    }

    public final boolean isVisible() {
        View view;
        if (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onActivityCreated(@Nullable Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i10 + " resultCode: " + i11 + " data: " + intent);
        }
    }

    @CallSuper
    @MainThread
    public void onAttach(@NonNull Context context) {
        this.mCalled = true;
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        Activity activity = fragmentHostCallback == null ? null : fragmentHostCallback.getActivity();
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    @MainThread
    @Deprecated
    public void onAttachFragment(@NonNull Fragment fragment) {
    }

    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        this.mCalled = true;
    }

    @MainThread
    public boolean onContextItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @CallSuper
    @MainThread
    public void onCreate(@Nullable Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (!this.mChildFragmentManager.isStateAtLeast(1)) {
            this.mChildFragmentManager.dispatchCreate();
        }
    }

    @MainThread
    @Nullable
    public Animation onCreateAnimation(int i10, boolean z10, int i11) {
        return null;
    }

    @MainThread
    @Nullable
    public Animator onCreateAnimator(int i10, boolean z10, int i11) {
        return null;
    }

    @MainThread
    public void onCreateContextMenu(@NonNull ContextMenu contextMenu, @NonNull View view, @Nullable ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @MainThread
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
    }

    @MainThread
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i10 = this.mContentLayoutId;
        if (i10 != 0) {
            return layoutInflater.inflate(i10, viewGroup, false);
        }
        return null;
    }

    @CallSuper
    @MainThread
    public void onDestroy() {
        this.mCalled = true;
    }

    @MainThread
    public void onDestroyOptionsMenu() {
    }

    @CallSuper
    @MainThread
    public void onDestroyView() {
        this.mCalled = true;
    }

    @CallSuper
    @MainThread
    public void onDetach() {
        this.mCalled = true;
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    @MainThread
    public void onHiddenChanged(boolean z10) {
    }

    @CallSuper
    @UiThread
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        this.mCalled = true;
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        Activity activity = fragmentHostCallback == null ? null : fragmentHostCallback.getActivity();
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    @CallSuper
    @MainThread
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z10) {
    }

    @MainThread
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @MainThread
    public void onOptionsMenuClosed(@NonNull Menu menu) {
    }

    @CallSuper
    @MainThread
    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z10) {
    }

    @MainThread
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
    }

    @MainThread
    public void onPrimaryNavigationFragmentChanged(boolean z10) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    @CallSuper
    @MainThread
    public void onResume() {
        this.mCalled = true;
    }

    @MainThread
    public void onSaveInstanceState(@NonNull Bundle bundle) {
    }

    @CallSuper
    @MainThread
    public void onStart() {
        this.mCalled = true;
    }

    @CallSuper
    @MainThread
    public void onStop() {
        this.mCalled = true;
    }

    @MainThread
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
    }

    @CallSuper
    @MainThread
    public void onViewStateRestored(@Nullable Bundle bundle) {
        this.mCalled = true;
    }

    /* access modifiers changed from: package-private */
    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            restoreViewState();
            this.mChildFragmentManager.dispatchActivityCreated();
            return;
        }
        throw new p("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    /* access modifiers changed from: package-private */
    public void performAttach() {
        Iterator<j> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.attachController(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.getContext());
        if (this.mCalled) {
            this.mFragmentManager.dispatchOnAttachFragment(this);
            this.mChildFragmentManager.dispatchAttach();
            return;
        }
        throw new p("Fragment " + this + " did not call through to super.onAttach()");
    }

    /* access modifiers changed from: package-private */
    public void performConfigurationChanged(@NonNull Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.dispatchConfigurationChanged(configuration);
    }

    /* access modifiers changed from: package-private */
    public boolean performContextItemSelected(@NonNull MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.dispatchContextItemSelected(menuItem);
    }

    /* access modifiers changed from: package-private */
    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.addObserver(new LifecycleEventObserver() {
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                View view;
                if (event == Lifecycle.Event.ON_STOP && (view = Fragment.this.mView) != null) {
                    view.cancelPendingInputEvents();
                }
            }
        });
        this.mSavedStateRegistryController.performRestore(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            return;
        }
        throw new p("Fragment " + this + " did not call through to super.onCreate()");
    }

    /* access modifiers changed from: package-private */
    public boolean performCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        boolean z10 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z10 = true;
        }
        return z10 | this.mChildFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    /* access modifiers changed from: package-private */
    public void performCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new l(this, getViewModelStore());
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView != null) {
            this.mViewLifecycleOwner.b();
            ViewTreeLifecycleOwner.set(this.mView, this.mViewLifecycleOwner);
            ViewTreeViewModelStoreOwner.set(this.mView, this.mViewLifecycleOwner);
            ViewTreeSavedStateRegistryOwner.set(this.mView, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
        } else if (!this.mViewLifecycleOwner.c()) {
            this.mViewLifecycleOwner = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    /* access modifiers changed from: package-private */
    public void performDestroy() {
        this.mChildFragmentManager.dispatchDestroy();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new p("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    /* access modifiers changed from: package-private */
    public void performDestroyView() {
        this.mChildFragmentManager.dispatchDestroyView();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            LoaderManager.getInstance(this).markForRedelivery();
            this.mPerformedCreateView = false;
            return;
        }
        throw new p("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    /* access modifiers changed from: package-private */
    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new p("Fragment " + this + " did not call through to super.onDetach()");
        } else if (!this.mChildFragmentManager.isDestroyed()) {
            this.mChildFragmentManager.dispatchDestroy();
            this.mChildFragmentManager = new f();
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public LayoutInflater performGetLayoutInflater(@Nullable Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    /* access modifiers changed from: package-private */
    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.dispatchLowMemory();
    }

    /* access modifiers changed from: package-private */
    public void performMultiWindowModeChanged(boolean z10) {
        onMultiWindowModeChanged(z10);
        this.mChildFragmentManager.dispatchMultiWindowModeChanged(z10);
    }

    /* access modifiers changed from: package-private */
    public boolean performOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (!this.mHasMenu || !this.mMenuVisible || !onOptionsItemSelected(menuItem)) {
            return this.mChildFragmentManager.dispatchOptionsItemSelected(menuItem);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void performOptionsMenuClosed(@NonNull Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            this.mChildFragmentManager.dispatchOptionsMenuClosed(menu);
        }
    }

    /* access modifiers changed from: package-private */
    public void performPause() {
        this.mChildFragmentManager.dispatchPause();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_PAUSE);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new p("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    /* access modifiers changed from: package-private */
    public void performPictureInPictureModeChanged(boolean z10) {
        onPictureInPictureModeChanged(z10);
        this.mChildFragmentManager.dispatchPictureInPictureModeChanged(z10);
    }

    /* access modifiers changed from: package-private */
    public boolean performPrepareOptionsMenu(@NonNull Menu menu) {
        boolean z10 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z10 = true;
        }
        return z10 | this.mChildFragmentManager.dispatchPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: package-private */
    public void performPrimaryNavigationFragmentChanged() {
        boolean isPrimaryNavigation = this.mFragmentManager.isPrimaryNavigation(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != isPrimaryNavigation) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(isPrimaryNavigation);
            onPrimaryNavigationFragmentChanged(isPrimaryNavigation);
            this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
        }
    }

    /* access modifiers changed from: package-private */
    public void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled) {
            LifecycleRegistry lifecycleRegistry = this.mLifecycleRegistry;
            Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
            lifecycleRegistry.handleLifecycleEvent(event);
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(event);
            }
            this.mChildFragmentManager.dispatchResume();
            return;
        }
        throw new p("Fragment " + this + " did not call through to super.onResume()");
    }

    /* access modifiers changed from: package-private */
    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.performSave(bundle);
        Parcelable saveAllState = this.mChildFragmentManager.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable("android:support:fragments", saveAllState);
        }
    }

    /* access modifiers changed from: package-private */
    public void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            LifecycleRegistry lifecycleRegistry = this.mLifecycleRegistry;
            Lifecycle.Event event = Lifecycle.Event.ON_START;
            lifecycleRegistry.handleLifecycleEvent(event);
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(event);
            }
            this.mChildFragmentManager.dispatchStart();
            return;
        }
        throw new p("Fragment " + this + " did not call through to super.onStart()");
    }

    /* access modifiers changed from: package-private */
    public void performStop() {
        this.mChildFragmentManager.dispatchStop();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_STOP);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new p("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    /* access modifiers changed from: package-private */
    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.dispatchViewCreated();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().f15577w = true;
    }

    @MainThread
    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return prepareCallInternal(activityResultContract, new e(), activityResultCallback);
    }

    public void registerForContextMenu(@NonNull View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(@NonNull String[] strArr, int i10) {
        if (this.mHost != null) {
            getParentFragmentManager().launchRequestPermissions(this, strArr, i10);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @NonNull
    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @NonNull
    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    @NonNull
    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @NonNull
    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    @NonNull
    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    @NonNull
    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    @NonNull
    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    /* access modifiers changed from: package-private */
    public void restoreChildFragmentState(@Nullable Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.mChildFragmentManager.restoreSaveState(parcelable);
            this.mChildFragmentManager.dispatchCreate();
        }
    }

    /* access modifiers changed from: package-private */
    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.d(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new p("Fragment " + this + " did not call through to super.onViewStateRestored()");
        } else if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z10) {
        ensureAnimationInfo().f15572r = Boolean.valueOf(z10);
    }

    public void setAllowReturnTransitionOverlap(boolean z10) {
        ensureAnimationInfo().f15571q = Boolean.valueOf(z10);
    }

    /* access modifiers changed from: package-private */
    public void setAnimatingAway(View view) {
        ensureAnimationInfo().f15555a = view;
    }

    /* access modifiers changed from: package-private */
    public void setAnimations(int i10, int i11, int i12, int i13) {
        if (this.mAnimationInfo != null || i10 != 0 || i11 != 0 || i12 != 0 || i13 != 0) {
            ensureAnimationInfo().f15558d = i10;
            ensureAnimationInfo().f15559e = i11;
            ensureAnimationInfo().f15560f = i12;
            ensureAnimationInfo().f15561g = i13;
        }
    }

    /* access modifiers changed from: package-private */
    public void setAnimator(Animator animator) {
        ensureAnimationInfo().f15556b = animator;
    }

    public void setArguments(@Nullable Bundle bundle) {
        if (this.mFragmentManager == null || !isStateSaved()) {
            this.mArguments = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        ensureAnimationInfo().f15573s = sharedElementCallback;
    }

    public void setEnterTransition(@Nullable Object obj) {
        ensureAnimationInfo().f15565k = obj;
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        ensureAnimationInfo().f15574t = sharedElementCallback;
    }

    public void setExitTransition(@Nullable Object obj) {
        ensureAnimationInfo().f15567m = obj;
    }

    /* access modifiers changed from: package-private */
    public void setFocusedView(View view) {
        ensureAnimationInfo().f15576v = view;
    }

    public void setHasOptionsMenu(boolean z10) {
        if (this.mHasMenu != z10) {
            this.mHasMenu = z10;
            if (isAdded() && !isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setHideReplaced(boolean z10) {
        ensureAnimationInfo().f15579y = z10;
    }

    public void setInitialSavedState(@Nullable SavedState savedState) {
        Bundle bundle;
        if (this.mFragmentManager == null) {
            if (savedState == null || (bundle = savedState.mState) == null) {
                bundle = null;
            }
            this.mSavedFragmentState = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean z10) {
        if (this.mMenuVisible != z10) {
            this.mMenuVisible = z10;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setNextTransition(int i10) {
        if (this.mAnimationInfo != null || i10 != 0) {
            ensureAnimationInfo();
            this.mAnimationInfo.f15562h = i10;
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnStartEnterTransitionListener(k kVar) {
        ensureAnimationInfo();
        i iVar = this.mAnimationInfo;
        k kVar2 = iVar.f15578x;
        if (kVar != kVar2) {
            if (kVar == null || kVar2 == null) {
                if (iVar.f15577w) {
                    iVar.f15578x = kVar;
                }
                if (kVar != null) {
                    kVar.a();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    /* access modifiers changed from: package-private */
    public void setPopDirection(boolean z10) {
        if (this.mAnimationInfo != null) {
            ensureAnimationInfo().f15557c = z10;
        }
    }

    /* access modifiers changed from: package-private */
    public void setPostOnViewCreatedAlpha(float f10) {
        ensureAnimationInfo().f15575u = f10;
    }

    public void setReenterTransition(@Nullable Object obj) {
        ensureAnimationInfo().f15568n = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z10) {
        this.mRetainInstance = z10;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z10) {
            fragmentManager.addRetainedFragment(this);
        } else {
            fragmentManager.removeRetainedFragment(this);
        }
    }

    public void setReturnTransition(@Nullable Object obj) {
        ensureAnimationInfo().f15566l = obj;
    }

    public void setSharedElementEnterTransition(@Nullable Object obj) {
        ensureAnimationInfo().f15569o = obj;
    }

    /* access modifiers changed from: package-private */
    public void setSharedElementNames(@Nullable ArrayList<String> arrayList, @Nullable ArrayList<String> arrayList2) {
        ensureAnimationInfo();
        i iVar = this.mAnimationInfo;
        iVar.f15563i = arrayList;
        iVar.f15564j = arrayList2;
    }

    public void setSharedElementReturnTransition(@Nullable Object obj) {
        ensureAnimationInfo().f15570p = obj;
    }

    @Deprecated
    public void setTargetFragment(@Nullable Fragment fragment, int i10) {
        FragmentManager fragmentManager;
        FragmentManager fragmentManager2 = this.mFragmentManager;
        if (fragment != null) {
            fragmentManager = fragment.mFragmentManager;
        } else {
            fragmentManager = null;
        }
        if (fragmentManager2 == null || fragmentManager == null || fragmentManager2 == fragmentManager) {
            Fragment fragment2 = fragment;
            while (fragment2 != null) {
                if (!fragment2.equals(this)) {
                    fragment2 = fragment2.getTargetFragment();
                } else {
                    throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
                }
            }
            if (fragment == null) {
                this.mTargetWho = null;
                this.mTarget = null;
            } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
                this.mTargetWho = null;
                this.mTarget = fragment;
            } else {
                this.mTargetWho = fragment.mWho;
                this.mTarget = null;
            }
            this.mTargetRequestCode = i10;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
    }

    @Deprecated
    public void setUserVisibleHint(boolean z10) {
        boolean z11;
        if (!this.mUserVisibleHint && z10 && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            FragmentManager fragmentManager = this.mFragmentManager;
            fragmentManager.performPendingDeferredStart(fragmentManager.createOrGetFragmentStateManager(this));
        }
        this.mUserVisibleHint = z10;
        if (this.mState >= 5 || z10) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.mDeferStart = z11;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z10);
        }
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            return fragmentHostCallback.onShouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, (Bundle) null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i10) {
        startActivityForResult(intent, i10, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, @Nullable Intent intent, int i11, int i12, int i13, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        if (this.mHost != null) {
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Fragment ");
                sb2.append(this);
                sb2.append(" received the following in startIntentSenderForResult() requestCode: ");
                int i14 = i10;
                sb2.append(i10);
                sb2.append(" IntentSender: ");
                IntentSender intentSender2 = intentSender;
                sb2.append(intentSender);
                sb2.append(" fillInIntent: ");
                Intent intent2 = intent;
                sb2.append(intent);
                sb2.append(" options: ");
                sb2.append(bundle);
                Log.v("FragmentManager", sb2.toString());
            } else {
                IntentSender intentSender3 = intentSender;
                int i15 = i10;
                Intent intent3 = intent;
                Bundle bundle2 = bundle;
            }
            getParentFragmentManager().launchStartIntentSenderForResult(this, intentSender, i10, intent, i11, i12, i13, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo != null && ensureAnimationInfo().f15577w) {
            if (this.mHost == null) {
                ensureAnimationInfo().f15577w = false;
            } else if (Looper.myLooper() != this.mHost.getHandler().getLooper()) {
                this.mHost.getHandler().postAtFrontOfQueue(new b());
            } else {
                callStartTransitionListener(true);
            }
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(getClass().getSimpleName());
        sb2.append("{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("}");
        sb2.append(" (");
        sb2.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb2.append(" tag=");
            sb2.append(this.mTag);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public void unregisterForContextMenu(@NonNull View view) {
        view.setOnCreateContextMenuListener((View.OnCreateContextMenuListener) null);
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {
        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        final Bundle mState;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Bundle bundle) {
            this.mState = bundle;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            parcel.writeBundle(this.mState);
        }

        SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.mState = readBundle;
            if (classLoader != null && readBundle != null) {
                readBundle.setClassLoader(classLoader);
            }
        }
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context context, @NonNull String str, @Nullable Bundle bundle) {
        try {
            Fragment fragment = (Fragment) FragmentFactory.loadFragmentClass(context.getClassLoader(), str).getConstructor((Class[]) null).newInstance((Object[]) null);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (InstantiationException e10) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e10);
        } catch (IllegalAccessException e11) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e11);
        } catch (NoSuchMethodException e12) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e12);
        } catch (InvocationTargetException e13) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e13);
        }
    }

    @NonNull
    public final String getString(@StringRes int i10, @Nullable Object... objArr) {
        return getResources().getString(i10, objArr);
    }

    public final void postponeEnterTransition(long j10, @NonNull TimeUnit timeUnit) {
        Handler handler;
        ensureAnimationInfo().f15577w = true;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            handler = fragmentManager.getHost().getHandler();
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j10));
    }

    @MainThread
    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultRegistry activityResultRegistry, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return prepareCallInternal(activityResultContract, new f(activityResultRegistry), activityResultCallback);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, @Nullable Bundle bundle) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.onStartActivityFromFragment(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i10, @Nullable Bundle bundle) {
        if (this.mHost != null) {
            getParentFragmentManager().launchStartActivityForResult(this, intent, i10, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @NonNull
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public LayoutInflater getLayoutInflater(@Nullable Bundle bundle) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            LayoutInflater onGetLayoutInflater = fragmentHostCallback.onGetLayoutInflater();
            LayoutInflaterCompat.setFactory2(onGetLayoutInflater, this.mChildFragmentManager.getLayoutInflaterFactory());
            return onGetLayoutInflater;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onAttach(@NonNull Activity activity) {
        this.mCalled = true;
    }

    @CallSuper
    @UiThread
    @Deprecated
    public void onInflate(@NonNull Activity activity, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        this.mCalled = true;
    }

    private void restoreViewState() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }

    @ContentView
    public Fragment(@LayoutRes int i10) {
        this();
        this.mContentLayoutId = i10;
    }
}
