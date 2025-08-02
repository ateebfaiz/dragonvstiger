package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.DoNotInline;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.NotificationCompat;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.OnUserLeaveHintProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public class ComponentActivity extends androidx.core.app.ComponentActivity implements ContextAware, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnNewIntentProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, OnUserLeaveHintProvider, MenuHost, FullyDrawnReporterOwner {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private static final b Companion = new b((DefaultConstructorMarker) null);
    private ViewModelStore _viewModelStore;
    private final ActivityResultRegistry activityResultRegistry;
    @LayoutRes
    private int contentLayoutId;
    private final ContextAwareHelper contextAwareHelper;
    private final Lazy defaultViewModelProviderFactory$delegate;
    private boolean dispatchingOnMultiWindowModeChanged;
    private boolean dispatchingOnPictureInPictureModeChanged;
    private final Lazy fullyDrawnReporter$delegate;
    private final MenuHostHelper menuHostHelper;
    private final AtomicInteger nextLocalRequestCode;
    private final Lazy onBackPressedDispatcher$delegate;
    private final CopyOnWriteArrayList<Consumer<Configuration>> onConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> onMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Intent>> onNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> onPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Integer>> onTrimMemoryListeners;
    private final CopyOnWriteArrayList<Runnable> onUserLeaveHintListeners;
    /* access modifiers changed from: private */
    public final c reportFullyDrawnExecutor;
    private final SavedStateRegistryController savedStateRegistryController;

    public static final class NonConfigurationInstances {
        private Object custom;
        private ViewModelStore viewModelStore;

        public final Object getCustom() {
            return this.custom;
        }

        public final ViewModelStore getViewModelStore() {
            return this.viewModelStore;
        }

        public final void setCustom(Object obj) {
            this.custom = obj;
        }

        public final void setViewModelStore(ViewModelStore viewModelStore2) {
            this.viewModelStore = viewModelStore2;
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f13774a = new a();

        private a() {
        }

        @DoNotInline
        public final OnBackInvokedDispatcher a(Activity activity) {
            m.f(activity, "activity");
            OnBackInvokedDispatcher onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
            m.e(onBackInvokedDispatcher, "activity.getOnBackInvokedDispatcher()");
            return onBackInvokedDispatcher;
        }
    }

    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private interface c extends Executor {
        void h();

        void y(View view);
    }

    private final class d implements c, ViewTreeObserver.OnDrawListener, Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final long f13775a = (SystemClock.uptimeMillis() + ((long) 10000));

        /* renamed from: b  reason: collision with root package name */
        private Runnable f13776b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f13777c;

        public d() {
        }

        /* access modifiers changed from: private */
        public static final void b(d dVar) {
            m.f(dVar, "this$0");
            Runnable runnable = dVar.f13776b;
            if (runnable != null) {
                m.c(runnable);
                runnable.run();
                dVar.f13776b = null;
            }
        }

        public void execute(Runnable runnable) {
            m.f(runnable, "runnable");
            this.f13776b = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            m.e(decorView, "window.decorView");
            if (!this.f13777c) {
                decorView.postOnAnimation(new g(this));
            } else if (m.b(Looper.myLooper(), Looper.getMainLooper())) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        public void h() {
            ComponentActivity.this.getWindow().getDecorView().removeCallbacks(this);
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        public void onDraw() {
            Runnable runnable = this.f13776b;
            if (runnable != null) {
                runnable.run();
                this.f13776b = null;
                if (ComponentActivity.this.getFullyDrawnReporter().isFullyDrawnReported()) {
                    this.f13777c = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                }
            } else if (SystemClock.uptimeMillis() > this.f13775a) {
                this.f13777c = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        public void y(View view) {
            m.f(view, "view");
            if (!this.f13777c) {
                this.f13777c = true;
                view.getViewTreeObserver().addOnDrawListener(this);
            }
        }
    }

    static final class e extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13779a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ComponentActivity componentActivity) {
            super(0);
            this.f13779a = componentActivity;
        }

        /* renamed from: a */
        public final SavedStateViewModelFactory invoke() {
            Bundle bundle;
            Application application = this.f13779a.getApplication();
            ComponentActivity componentActivity = this.f13779a;
            if (componentActivity.getIntent() != null) {
                bundle = this.f13779a.getIntent().getExtras();
            } else {
                bundle = null;
            }
            return new SavedStateViewModelFactory(application, componentActivity, bundle);
        }
    }

    static final class f extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13780a;

        static final class a extends n implements Function0 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ComponentActivity f13781a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(ComponentActivity componentActivity) {
                super(0);
                this.f13781a = componentActivity;
            }

            public final void invoke() {
                this.f13781a.reportFullyDrawn();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(ComponentActivity componentActivity) {
            super(0);
            this.f13780a = componentActivity;
        }

        /* renamed from: a */
        public final FullyDrawnReporter invoke() {
            return new FullyDrawnReporter(this.f13780a.reportFullyDrawnExecutor, new a(this.f13780a));
        }
    }

    static final class g extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13782a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(ComponentActivity componentActivity) {
            super(0);
            this.f13782a = componentActivity;
        }

        /* access modifiers changed from: private */
        public static final void d(ComponentActivity componentActivity) {
            m.f(componentActivity, "this$0");
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e10) {
                if (!m.b(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e10;
                }
            } catch (NullPointerException e11) {
                if (!m.b(e11.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e11;
                }
            }
        }

        /* access modifiers changed from: private */
        public static final void f(ComponentActivity componentActivity, OnBackPressedDispatcher onBackPressedDispatcher) {
            m.f(componentActivity, "this$0");
            m.f(onBackPressedDispatcher, "$dispatcher");
            componentActivity.addObserverForBackInvoker(onBackPressedDispatcher);
        }

        /* renamed from: c */
        public final OnBackPressedDispatcher invoke() {
            OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(new j(this.f13782a));
            ComponentActivity componentActivity = this.f13782a;
            if (Build.VERSION.SDK_INT >= 33) {
                if (!m.b(Looper.myLooper(), Looper.getMainLooper())) {
                    new Handler(Looper.getMainLooper()).post(new k(componentActivity, onBackPressedDispatcher));
                } else {
                    componentActivity.addObserverForBackInvoker(onBackPressedDispatcher);
                }
            }
            return onBackPressedDispatcher;
        }
    }

    public ComponentActivity() {
        this.contextAwareHelper = new ContextAwareHelper();
        this.menuHostHelper = new MenuHostHelper(new a(this));
        SavedStateRegistryController create = SavedStateRegistryController.Companion.create(this);
        this.savedStateRegistryController = create;
        this.reportFullyDrawnExecutor = createFullyDrawnExecutor();
        this.fullyDrawnReporter$delegate = i.b(new f(this));
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityResultRegistry = new ComponentActivity$activityResultRegistry$1(this);
        this.onConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.onTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.onNewIntentListeners = new CopyOnWriteArrayList<>();
        this.onMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onUserLeaveHintListeners = new CopyOnWriteArrayList<>();
        if (getLifecycle() != null) {
            getLifecycle().addObserver(new b(this));
            getLifecycle().addObserver(new c(this));
            getLifecycle().addObserver(new LifecycleEventObserver(this) {
                final /* synthetic */ ComponentActivity this$0;

                {
                    this.this$0 = r1;
                }

                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    m.f(lifecycleOwner, "source");
                    m.f(event, NotificationCompat.CATEGORY_EVENT);
                    this.this$0.ensureViewModelStore();
                    this.this$0.getLifecycle().removeObserver(this);
                }
            });
            create.performAttach();
            SavedStateHandleSupport.enableSavedStateHandles(this);
            if (Build.VERSION.SDK_INT <= 23) {
                getLifecycle().addObserver(new ImmLeaksCleaner(this));
            }
            getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, new d(this));
            addOnContextAvailableListener(new e(this));
            this.defaultViewModelProviderFactory$delegate = i.b(new e(this));
            this.onBackPressedDispatcher$delegate = i.b(new g(this));
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.".toString());
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$2(ComponentActivity componentActivity, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Window window;
        View peekDecorView;
        m.f(componentActivity, "this$0");
        m.f(lifecycleOwner, "<anonymous parameter 0>");
        m.f(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_STOP && (window = componentActivity.getWindow()) != null && (peekDecorView = window.peekDecorView()) != null) {
            peekDecorView.cancelPendingInputEvents();
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$3(ComponentActivity componentActivity, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.f(componentActivity, "this$0");
        m.f(lifecycleOwner, "<anonymous parameter 0>");
        m.f(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_DESTROY) {
            componentActivity.contextAwareHelper.clearAvailableContext();
            if (!componentActivity.isChangingConfigurations()) {
                componentActivity.getViewModelStore().clear();
            }
            componentActivity.reportFullyDrawnExecutor.h();
        }
    }

    /* access modifiers changed from: private */
    public static final Bundle _init_$lambda$4(ComponentActivity componentActivity) {
        m.f(componentActivity, "this$0");
        Bundle bundle = new Bundle();
        componentActivity.activityResultRegistry.onSaveInstanceState(bundle);
        return bundle;
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$5(ComponentActivity componentActivity, Context context) {
        m.f(componentActivity, "this$0");
        m.f(context, "it");
        Bundle consumeRestoredStateForKey = componentActivity.getSavedStateRegistry().consumeRestoredStateForKey(ACTIVITY_RESULT_TAG);
        if (consumeRestoredStateForKey != null) {
            componentActivity.activityResultRegistry.onRestoreInstanceState(consumeRestoredStateForKey);
        }
    }

    /* access modifiers changed from: private */
    @RequiresApi(33)
    public final void addObserverForBackInvoker(OnBackPressedDispatcher onBackPressedDispatcher) {
        getLifecycle().addObserver(new f(onBackPressedDispatcher, this));
    }

    /* access modifiers changed from: private */
    public static final void addObserverForBackInvoker$lambda$7(OnBackPressedDispatcher onBackPressedDispatcher, ComponentActivity componentActivity, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.f(onBackPressedDispatcher, "$dispatcher");
        m.f(componentActivity, "this$0");
        m.f(lifecycleOwner, "<anonymous parameter 0>");
        m.f(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_CREATE) {
            onBackPressedDispatcher.setOnBackInvokedDispatcher(a.f13774a.a(componentActivity));
        }
    }

    private final c createFullyDrawnExecutor() {
        return new d();
    }

    /* access modifiers changed from: private */
    public final void ensureViewModelStore() {
        if (this._viewModelStore == null) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                this._viewModelStore = nonConfigurationInstances.getViewModelStore();
            }
            if (this._viewModelStore == null) {
                this._viewModelStore = new ViewModelStore();
            }
        }
    }

    public static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    private static /* synthetic */ void getSavedStateRegistryController$annotations() {
    }

    /* access modifiers changed from: private */
    public static final void menuHostHelper$lambda$0(ComponentActivity componentActivity) {
        m.f(componentActivity, "this$0");
        componentActivity.invalidateMenu();
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        c cVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        m.e(decorView, "window.decorView");
        cVar.y(decorView);
        super.addContentView(view, layoutParams);
    }

    public void addMenuProvider(MenuProvider menuProvider) {
        m.f(menuProvider, "provider");
        this.menuHostHelper.addMenuProvider(menuProvider);
    }

    public final void addOnConfigurationChangedListener(Consumer<Configuration> consumer) {
        m.f(consumer, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onConfigurationChangedListeners.add(consumer);
    }

    public final void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        m.f(onContextAvailableListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.contextAwareHelper.addOnContextAvailableListener(onContextAvailableListener);
    }

    public final void addOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> consumer) {
        m.f(consumer, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onMultiWindowModeChangedListeners.add(consumer);
    }

    public final void addOnNewIntentListener(Consumer<Intent> consumer) {
        m.f(consumer, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onNewIntentListeners.add(consumer);
    }

    public final void addOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> consumer) {
        m.f(consumer, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onPictureInPictureModeChangedListeners.add(consumer);
    }

    public final void addOnTrimMemoryListener(Consumer<Integer> consumer) {
        m.f(consumer, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onTrimMemoryListeners.add(consumer);
    }

    public final void addOnUserLeaveHintListener(Runnable runnable) {
        m.f(runnable, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onUserLeaveHintListeners.add(runnable);
    }

    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    @CallSuper
    public CreationExtras getDefaultViewModelCreationExtras() {
        Bundle bundle = null;
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras((CreationExtras) null, 1, (DefaultConstructorMarker) null);
        if (getApplication() != null) {
            CreationExtras.Key<Application> key = ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY;
            Application application = getApplication();
            m.e(application, "application");
            mutableCreationExtras.set(key, application);
        }
        mutableCreationExtras.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        mutableCreationExtras.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        Intent intent = getIntent();
        if (intent != null) {
            bundle = intent.getExtras();
        }
        if (bundle != null) {
            mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, bundle);
        }
        return mutableCreationExtras;
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return (ViewModelProvider.Factory) this.defaultViewModelProviderFactory$delegate.getValue();
    }

    public FullyDrawnReporter getFullyDrawnReporter() {
        return (FullyDrawnReporter) this.fullyDrawnReporter$delegate.getValue();
    }

    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.getCustom();
        }
        return null;
    }

    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return (OnBackPressedDispatcher) this.onBackPressedDispatcher$delegate.getValue();
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    public ViewModelStore getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            ViewModelStore viewModelStore = this._viewModelStore;
            m.c(viewModelStore);
            return viewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.".toString());
    }

    @CallSuper
    public void initializeViewTreeOwners() {
        View decorView = getWindow().getDecorView();
        m.e(decorView, "window.decorView");
        ViewTreeLifecycleOwner.set(decorView, this);
        View decorView2 = getWindow().getDecorView();
        m.e(decorView2, "window.decorView");
        ViewTreeViewModelStoreOwner.set(decorView2, this);
        View decorView3 = getWindow().getDecorView();
        m.e(decorView3, "window.decorView");
        ViewTreeSavedStateRegistryOwner.set(decorView3, this);
        View decorView4 = getWindow().getDecorView();
        m.e(decorView4, "window.decorView");
        ViewTreeOnBackPressedDispatcherOwner.set(decorView4, this);
        View decorView5 = getWindow().getDecorView();
        m.e(decorView5, "window.decorView");
        ViewTreeFullyDrawnReporterOwner.set(decorView5, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (!this.activityResultRegistry.dispatchResult(i10, i11, intent)) {
            super.onActivityResult(i10, i11, intent);
        }
    }

    @CallSuper
    @MainThread
    public void onBackPressed() {
        getOnBackPressedDispatcher().onBackPressed();
    }

    @CallSuper
    public void onConfigurationChanged(Configuration configuration) {
        m.f(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Iterator<Consumer<Configuration>> it = this.onConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.savedStateRegistryController.performRestore(bundle);
        this.contextAwareHelper.dispatchOnContextAvailable(this);
        super.onCreate(bundle);
        ReportFragment.Companion.injectIfNeededIn(this);
        int i10 = this.contentLayoutId;
        if (i10 != 0) {
            setContentView(i10);
        }
    }

    public boolean onCreatePanelMenu(int i10, Menu menu) {
        m.f(menu, "menu");
        if (i10 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i10, menu);
        this.menuHostHelper.onCreateMenu(menu, getMenuInflater());
        return true;
    }

    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        m.f(menuItem, "item");
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 0) {
            return this.menuHostHelper.onMenuItemSelected(menuItem);
        }
        return false;
    }

    @CallSuper
    public void onMultiWindowModeChanged(boolean z10) {
        if (!this.dispatchingOnMultiWindowModeChanged) {
            Iterator<Consumer<MultiWindowModeChangedInfo>> it = this.onMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new MultiWindowModeChangedInfo(z10));
            }
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onNewIntent(Intent intent) {
        m.f(intent, "intent");
        super.onNewIntent(intent);
        Iterator<Consumer<Intent>> it = this.onNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    public void onPanelClosed(int i10, Menu menu) {
        m.f(menu, "menu");
        this.menuHostHelper.onMenuClosed(menu);
        super.onPanelClosed(i10, menu);
    }

    @CallSuper
    public void onPictureInPictureModeChanged(boolean z10) {
        if (!this.dispatchingOnPictureInPictureModeChanged) {
            Iterator<Consumer<PictureInPictureModeChangedInfo>> it = this.onPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new PictureInPictureModeChangedInfo(z10));
            }
        }
    }

    public boolean onPreparePanel(int i10, View view, Menu menu) {
        m.f(menu, "menu");
        if (i10 != 0) {
            return true;
        }
        super.onPreparePanel(i10, view, menu);
        this.menuHostHelper.onPrepareMenu(menu);
        return true;
    }

    @CallSuper
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        m.f(strArr, "permissions");
        m.f(iArr, "grantResults");
        if (!this.activityResultRegistry.dispatchResult(i10, -1, new Intent().putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS, strArr).putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS, iArr))) {
            super.onRequestPermissionsResult(i10, strArr, iArr);
        }
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore = this._viewModelStore;
        if (viewModelStore == null && (nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance()) != null) {
            viewModelStore = nonConfigurationInstances.getViewModelStore();
        }
        if (viewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances2 = new NonConfigurationInstances();
        nonConfigurationInstances2.setCustom(onRetainCustomNonConfigurationInstance);
        nonConfigurationInstances2.setViewModelStore(viewModelStore);
        return nonConfigurationInstances2;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onSaveInstanceState(Bundle bundle) {
        m.f(bundle, "outState");
        if (getLifecycle() instanceof LifecycleRegistry) {
            Lifecycle lifecycle = getLifecycle();
            m.d(lifecycle, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            ((LifecycleRegistry) lifecycle).setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.savedStateRegistryController.performSave(bundle);
    }

    @CallSuper
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Iterator<Consumer<Integer>> it = this.onTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i10));
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator<Runnable> it = this.onUserLeaveHintListeners.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
    }

    public Context peekAvailableContext() {
        return this.contextAwareHelper.peekAvailableContext();
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultRegistry activityResultRegistry2, ActivityResultCallback<O> activityResultCallback) {
        m.f(activityResultContract, "contract");
        m.f(activityResultRegistry2, "registry");
        m.f(activityResultCallback, "callback");
        return activityResultRegistry2.register("activity_rq#" + this.nextLocalRequestCode.getAndIncrement(), this, activityResultContract, activityResultCallback);
    }

    public void removeMenuProvider(MenuProvider menuProvider) {
        m.f(menuProvider, "provider");
        this.menuHostHelper.removeMenuProvider(menuProvider);
    }

    public final void removeOnConfigurationChangedListener(Consumer<Configuration> consumer) {
        m.f(consumer, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onConfigurationChangedListeners.remove(consumer);
    }

    public final void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        m.f(onContextAvailableListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.contextAwareHelper.removeOnContextAvailableListener(onContextAvailableListener);
    }

    public final void removeOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> consumer) {
        m.f(consumer, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onMultiWindowModeChangedListeners.remove(consumer);
    }

    public final void removeOnNewIntentListener(Consumer<Intent> consumer) {
        m.f(consumer, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onNewIntentListeners.remove(consumer);
    }

    public final void removeOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> consumer) {
        m.f(consumer, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onPictureInPictureModeChangedListeners.remove(consumer);
    }

    public final void removeOnTrimMemoryListener(Consumer<Integer> consumer) {
        m.f(consumer, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onTrimMemoryListeners.remove(consumer);
    }

    public final void removeOnUserLeaveHintListener(Runnable runnable) {
        m.f(runnable, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onUserLeaveHintListeners.remove(runnable);
    }

    public void reportFullyDrawn() {
        try {
            if (Trace.isEnabled()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            getFullyDrawnReporter().fullyDrawnReported();
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public void setContentView(@LayoutRes int i10) {
        initializeViewTreeOwners();
        c cVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        m.e(decorView, "window.decorView");
        cVar.y(decorView);
        super.setContentView(i10);
    }

    public void startActivityForResult(Intent intent, int i10) {
        m.f(intent, "intent");
        super.startActivityForResult(intent, i10);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13) throws IntentSender.SendIntentException {
        m.f(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
    }

    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        m.f(menuProvider, "provider");
        m.f(lifecycleOwner, "owner");
        this.menuHostHelper.addMenuProvider(menuProvider, lifecycleOwner);
    }

    public void startActivityForResult(Intent intent, int i10, Bundle bundle) {
        m.f(intent, "intent");
        super.startActivityForResult(intent, i10, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        m.f(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        m.f(menuProvider, "provider");
        m.f(lifecycleOwner, "owner");
        m.f(state, "state");
        this.menuHostHelper.addMenuProvider(menuProvider, lifecycleOwner, state);
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        m.f(activityResultContract, "contract");
        m.f(activityResultCallback, "callback");
        return registerForActivityResult(activityResultContract, this.activityResultRegistry, activityResultCallback);
    }

    /* JADX INFO: finally extract failed */
    @RequiresApi(api = 26)
    @CallSuper
    public void onMultiWindowModeChanged(boolean z10, Configuration configuration) {
        m.f(configuration, "newConfig");
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z10, configuration);
            this.dispatchingOnMultiWindowModeChanged = false;
            Iterator<Consumer<MultiWindowModeChangedInfo>> it = this.onMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new MultiWindowModeChangedInfo(z10, configuration));
            }
        } catch (Throwable th) {
            this.dispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    @RequiresApi(api = 26)
    @CallSuper
    public void onPictureInPictureModeChanged(boolean z10, Configuration configuration) {
        m.f(configuration, "newConfig");
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z10, configuration);
            this.dispatchingOnPictureInPictureModeChanged = false;
            Iterator<Consumer<PictureInPictureModeChangedInfo>> it = this.onPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new PictureInPictureModeChangedInfo(z10, configuration));
            }
        } catch (Throwable th) {
            this.dispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public void setContentView(View view) {
        initializeViewTreeOwners();
        c cVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        m.e(decorView, "window.decorView");
        cVar.y(decorView);
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        c cVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        m.e(decorView, "window.decorView");
        cVar.y(decorView);
        super.setContentView(view, layoutParams);
    }

    @ContentView
    public ComponentActivity(@LayoutRes int i10) {
        this();
        this.contentLayoutId = i10;
    }
}
