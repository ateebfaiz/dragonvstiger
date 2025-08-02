package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class OnBackPressedDispatcher {
    private boolean backInvokedCallbackRegistered;
    private final Runnable fallbackOnBackPressed;
    private boolean hasEnabledCallbacks;
    /* access modifiers changed from: private */
    public OnBackPressedCallback inProgressCallback;
    private OnBackInvokedDispatcher invokedDispatcher;
    private OnBackInvokedCallback onBackInvokedCallback;
    /* access modifiers changed from: private */
    public final i<OnBackPressedCallback> onBackPressedCallbacks;
    private final Consumer<Boolean> onHasEnabledCallbacksChanged;

    @RequiresApi(33)
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        /* access modifiers changed from: private */
        public static final void createOnBackInvokedCallback$lambda$0(Function0 function0) {
            m.f(function0, "$onBackInvoked");
            function0.invoke();
        }

        @DoNotInline
        public final OnBackInvokedCallback createOnBackInvokedCallback(Function0<Unit> function0) {
            m.f(function0, "onBackInvoked");
            return new z(function0);
        }

        @DoNotInline
        public final void registerOnBackInvokedCallback(Object obj, int i10, Object obj2) {
            m.f(obj, "dispatcher");
            m.f(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i10, (OnBackInvokedCallback) obj2);
        }

        @DoNotInline
        public final void unregisterOnBackInvokedCallback(Object obj, Object obj2) {
            m.f(obj, "dispatcher");
            m.f(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    @RequiresApi(34)
    public static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        @DoNotInline
        public final OnBackInvokedCallback createOnBackAnimationCallback(Function1<? super BackEventCompat, Unit> function1, Function1<? super BackEventCompat, Unit> function12, Function0<Unit> function0, Function0<Unit> function02) {
            m.f(function1, "onBackStarted");
            m.f(function12, "onBackProgressed");
            m.f(function0, "onBackInvoked");
            m.f(function02, "onBackCancelled");
            return new OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1(function1, function12, function0, function02);
        }
    }

    private final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {

        /* renamed from: a  reason: collision with root package name */
        private final Lifecycle f13784a;

        /* renamed from: b  reason: collision with root package name */
        private final OnBackPressedCallback f13785b;

        /* renamed from: c  reason: collision with root package name */
        private Cancellable f13786c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f13787d;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
            m.f(lifecycle, "lifecycle");
            m.f(onBackPressedCallback, "onBackPressedCallback");
            this.f13787d = onBackPressedDispatcher;
            this.f13784a = lifecycle;
            this.f13785b = onBackPressedCallback;
            lifecycle.addObserver(this);
        }

        public void cancel() {
            this.f13784a.removeObserver(this);
            this.f13785b.removeCancellable(this);
            Cancellable cancellable = this.f13786c;
            if (cancellable != null) {
                cancellable.cancel();
            }
            this.f13786c = null;
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            m.f(lifecycleOwner, "source");
            m.f(event, NotificationCompat.CATEGORY_EVENT);
            if (event == Lifecycle.Event.ON_START) {
                this.f13786c = this.f13787d.addCancellableCallback$activity_release(this.f13785b);
            } else if (event == Lifecycle.Event.ON_STOP) {
                Cancellable cancellable = this.f13786c;
                if (cancellable != null) {
                    cancellable.cancel();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }
    }

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f13788a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(OnBackPressedDispatcher onBackPressedDispatcher) {
            super(1);
            this.f13788a = onBackPressedDispatcher;
        }

        public final void a(BackEventCompat backEventCompat) {
            m.f(backEventCompat, "backEvent");
            this.f13788a.onBackStarted(backEventCompat);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BackEventCompat) obj);
            return Unit.f12577a;
        }
    }

    static final class b extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f13789a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(OnBackPressedDispatcher onBackPressedDispatcher) {
            super(1);
            this.f13789a = onBackPressedDispatcher;
        }

        public final void a(BackEventCompat backEventCompat) {
            m.f(backEventCompat, "backEvent");
            this.f13789a.onBackProgressed(backEventCompat);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BackEventCompat) obj);
            return Unit.f12577a;
        }
    }

    static final class c extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f13790a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(OnBackPressedDispatcher onBackPressedDispatcher) {
            super(0);
            this.f13790a = onBackPressedDispatcher;
        }

        public final void invoke() {
            this.f13790a.onBackPressed();
        }
    }

    static final class d extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f13791a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(OnBackPressedDispatcher onBackPressedDispatcher) {
            super(0);
            this.f13791a = onBackPressedDispatcher;
        }

        public final void invoke() {
            this.f13791a.onBackCancelled();
        }
    }

    static final class e extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f13792a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(OnBackPressedDispatcher onBackPressedDispatcher) {
            super(0);
            this.f13792a = onBackPressedDispatcher;
        }

        public final void invoke() {
            this.f13792a.onBackPressed();
        }
    }

    private final class f implements Cancellable {

        /* renamed from: a  reason: collision with root package name */
        private final OnBackPressedCallback f13793a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f13794b;

        public f(OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback) {
            m.f(onBackPressedCallback, "onBackPressedCallback");
            this.f13794b = onBackPressedDispatcher;
            this.f13793a = onBackPressedCallback;
        }

        public void cancel() {
            this.f13794b.onBackPressedCallbacks.remove(this.f13793a);
            if (m.b(this.f13794b.inProgressCallback, this.f13793a)) {
                this.f13793a.handleOnBackCancelled();
                this.f13794b.inProgressCallback = null;
            }
            this.f13793a.removeCancellable(this);
            Function0<Unit> enabledChangedCallback$activity_release = this.f13793a.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.f13793a.setEnabledChangedCallback$activity_release((Function0<Unit>) null);
        }
    }

    /* synthetic */ class g extends j implements Function0 {
        g(Object obj) {
            super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        public final void c() {
            ((OnBackPressedDispatcher) this.receiver).updateEnabledCallbacks();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            c();
            return Unit.f12577a;
        }
    }

    /* synthetic */ class h extends j implements Function0 {
        h(Object obj) {
            super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        public final void c() {
            ((OnBackPressedDispatcher) this.receiver).updateEnabledCallbacks();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            c();
            return Unit.f12577a;
        }
    }

    public OnBackPressedDispatcher() {
        this((Runnable) null, 1, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void onBackCancelled() {
        OnBackPressedCallback onBackPressedCallback;
        OnBackPressedCallback onBackPressedCallback2 = this.inProgressCallback;
        if (onBackPressedCallback2 == null) {
            i<OnBackPressedCallback> iVar = this.onBackPressedCallbacks;
            ListIterator<OnBackPressedCallback> listIterator = iVar.listIterator(iVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    onBackPressedCallback = null;
                    break;
                }
                onBackPressedCallback = listIterator.previous();
                if (onBackPressedCallback.isEnabled()) {
                    break;
                }
            }
            onBackPressedCallback2 = onBackPressedCallback;
        }
        this.inProgressCallback = null;
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.handleOnBackCancelled();
        }
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void onBackProgressed(BackEventCompat backEventCompat) {
        OnBackPressedCallback onBackPressedCallback;
        OnBackPressedCallback onBackPressedCallback2 = this.inProgressCallback;
        if (onBackPressedCallback2 == null) {
            i<OnBackPressedCallback> iVar = this.onBackPressedCallbacks;
            ListIterator<OnBackPressedCallback> listIterator = iVar.listIterator(iVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    onBackPressedCallback = null;
                    break;
                }
                onBackPressedCallback = listIterator.previous();
                if (onBackPressedCallback.isEnabled()) {
                    break;
                }
            }
            onBackPressedCallback2 = onBackPressedCallback;
        }
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.handleOnBackProgressed(backEventCompat);
        }
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void onBackStarted(BackEventCompat backEventCompat) {
        OnBackPressedCallback onBackPressedCallback;
        i<OnBackPressedCallback> iVar = this.onBackPressedCallbacks;
        ListIterator<OnBackPressedCallback> listIterator = iVar.listIterator(iVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                onBackPressedCallback = null;
                break;
            }
            onBackPressedCallback = listIterator.previous();
            if (onBackPressedCallback.isEnabled()) {
                break;
            }
        }
        OnBackPressedCallback onBackPressedCallback2 = onBackPressedCallback;
        if (this.inProgressCallback != null) {
            onBackCancelled();
        }
        this.inProgressCallback = onBackPressedCallback2;
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.handleOnBackStarted(backEventCompat);
        }
    }

    @RequiresApi(33)
    private final void updateBackInvokedCallbackState(boolean z10) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.invokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback2 = this.onBackInvokedCallback;
        if (onBackInvokedDispatcher != null && onBackInvokedCallback2 != null) {
            if (z10 && !this.backInvokedCallbackRegistered) {
                Api33Impl.INSTANCE.registerOnBackInvokedCallback(onBackInvokedDispatcher, 0, onBackInvokedCallback2);
                this.backInvokedCallbackRegistered = true;
            } else if (!z10 && this.backInvokedCallbackRegistered) {
                Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback2);
                this.backInvokedCallbackRegistered = false;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateEnabledCallbacks() {
        boolean z10 = this.hasEnabledCallbacks;
        i<OnBackPressedCallback> iVar = this.onBackPressedCallbacks;
        boolean z11 = false;
        if (!(iVar instanceof Collection) || !iVar.isEmpty()) {
            Iterator<T> it = iVar.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((OnBackPressedCallback) it.next()).isEnabled()) {
                        z11 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.hasEnabledCallbacks = z11;
        if (z11 != z10) {
            Consumer<Boolean> consumer = this.onHasEnabledCallbacksChanged;
            if (consumer != null) {
                consumer.accept(Boolean.valueOf(z11));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                updateBackInvokedCallbackState(z11);
            }
        }
    }

    @MainThread
    public final void addCallback(OnBackPressedCallback onBackPressedCallback) {
        m.f(onBackPressedCallback, "onBackPressedCallback");
        addCancellableCallback$activity_release(onBackPressedCallback);
    }

    @MainThread
    public final Cancellable addCancellableCallback$activity_release(OnBackPressedCallback onBackPressedCallback) {
        m.f(onBackPressedCallback, "onBackPressedCallback");
        this.onBackPressedCallbacks.add(onBackPressedCallback);
        f fVar = new f(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(fVar);
        updateEnabledCallbacks();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new h(this));
        return fVar;
    }

    @VisibleForTesting
    @MainThread
    public final void dispatchOnBackCancelled() {
        onBackCancelled();
    }

    @VisibleForTesting
    @MainThread
    public final void dispatchOnBackProgressed(BackEventCompat backEventCompat) {
        m.f(backEventCompat, "backEvent");
        onBackProgressed(backEventCompat);
    }

    @VisibleForTesting
    @MainThread
    public final void dispatchOnBackStarted(BackEventCompat backEventCompat) {
        m.f(backEventCompat, "backEvent");
        onBackStarted(backEventCompat);
    }

    @MainThread
    public final boolean hasEnabledCallbacks() {
        return this.hasEnabledCallbacks;
    }

    @MainThread
    public final void onBackPressed() {
        OnBackPressedCallback onBackPressedCallback;
        OnBackPressedCallback onBackPressedCallback2 = this.inProgressCallback;
        if (onBackPressedCallback2 == null) {
            i<OnBackPressedCallback> iVar = this.onBackPressedCallbacks;
            ListIterator<OnBackPressedCallback> listIterator = iVar.listIterator(iVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    onBackPressedCallback = null;
                    break;
                }
                onBackPressedCallback = listIterator.previous();
                if (onBackPressedCallback.isEnabled()) {
                    break;
                }
            }
            onBackPressedCallback2 = onBackPressedCallback;
        }
        this.inProgressCallback = null;
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.fallbackOnBackPressed;
        if (runnable != null) {
            runnable.run();
        }
    }

    @RequiresApi(33)
    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        m.f(onBackInvokedDispatcher, "invoker");
        this.invokedDispatcher = onBackInvokedDispatcher;
        updateBackInvokedCallbackState(this.hasEnabledCallbacks);
    }

    public OnBackPressedDispatcher(Runnable runnable, Consumer<Boolean> consumer) {
        OnBackInvokedCallback onBackInvokedCallback2;
        this.fallbackOnBackPressed = runnable;
        this.onHasEnabledCallbacksChanged = consumer;
        this.onBackPressedCallbacks = new i<>();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            if (i10 >= 34) {
                onBackInvokedCallback2 = Api34Impl.INSTANCE.createOnBackAnimationCallback(new a(this), new b(this), new c(this), new d(this));
            } else {
                onBackInvokedCallback2 = Api33Impl.INSTANCE.createOnBackInvokedCallback(new e(this));
            }
            this.onBackInvokedCallback = onBackInvokedCallback2;
        }
    }

    @MainThread
    public final void addCallback(LifecycleOwner lifecycleOwner, OnBackPressedCallback onBackPressedCallback) {
        m.f(lifecycleOwner, "owner");
        m.f(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            onBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
            updateEnabledCallbacks();
            onBackPressedCallback.setEnabledChangedCallback$activity_release(new g(this));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : runnable);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, (Consumer<Boolean>) null);
    }
}
