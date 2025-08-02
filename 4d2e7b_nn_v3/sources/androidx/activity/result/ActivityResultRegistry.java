package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.sequences.h;

public abstract class ActivityResultRegistry {
    private static final b Companion = new b((DefaultConstructorMarker) null);
    private static final int INITIAL_REQUEST_CODE_VALUE = 65536;
    private static final String KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
    private static final String LOG_TAG = "ActivityResultRegistry";
    private final transient Map<String, a> keyToCallback = new LinkedHashMap();
    private final Map<String, c> keyToLifecycleContainers = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final Map<String, Integer> keyToRc = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final List<String> launchedKeys = new ArrayList();
    private final Map<String, Object> parsedPendingResults = new LinkedHashMap();
    private final Bundle pendingResults = new Bundle();
    private final Map<Integer, String> rcToKey = new LinkedHashMap();

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ActivityResultCallback f13829a;

        /* renamed from: b  reason: collision with root package name */
        private final ActivityResultContract f13830b;

        public a(ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract) {
            m.f(activityResultCallback, "callback");
            m.f(activityResultContract, "contract");
            this.f13829a = activityResultCallback;
            this.f13830b = activityResultContract;
        }

        public final ActivityResultCallback a() {
            return this.f13829a;
        }

        public final ActivityResultContract b() {
            return this.f13830b;
        }
    }

    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Lifecycle f13831a;

        /* renamed from: b  reason: collision with root package name */
        private final List f13832b = new ArrayList();

        public c(Lifecycle lifecycle) {
            m.f(lifecycle, "lifecycle");
            this.f13831a = lifecycle;
        }

        public final void a(LifecycleEventObserver lifecycleEventObserver) {
            m.f(lifecycleEventObserver, "observer");
            this.f13831a.addObserver(lifecycleEventObserver);
            this.f13832b.add(lifecycleEventObserver);
        }

        public final void b() {
            for (LifecycleEventObserver removeObserver : this.f13832b) {
                this.f13831a.removeObserver(removeObserver);
            }
            this.f13832b.clear();
        }
    }

    static final class d extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final d f13833a = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final Integer invoke() {
            return Integer.valueOf(kotlin.random.c.f729a.d(2147418112) + 65536);
        }
    }

    private final void bindRcKey(int i10, String str) {
        this.rcToKey.put(Integer.valueOf(i10), str);
        this.keyToRc.put(str, Integer.valueOf(i10));
    }

    private final <O> void doDispatch(String str, int i10, Intent intent, a aVar) {
        ActivityResultCallback activityResultCallback;
        if (aVar != null) {
            activityResultCallback = aVar.a();
        } else {
            activityResultCallback = null;
        }
        if (activityResultCallback == null || !this.launchedKeys.contains(str)) {
            this.parsedPendingResults.remove(str);
            this.pendingResults.putParcelable(str, new ActivityResult(i10, intent));
            return;
        }
        aVar.a().onActivityResult(aVar.b().parseResult(i10, intent));
        this.launchedKeys.remove(str);
    }

    private final int generateRandomNumber() {
        for (Number number : h.f(d.f13833a)) {
            if (!this.rcToKey.containsKey(Integer.valueOf(number.intValue()))) {
                return number.intValue();
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    /* access modifiers changed from: private */
    public static final void register$lambda$1(ActivityResultRegistry activityResultRegistry, String str, ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.f(activityResultRegistry, "this$0");
        m.f(str, "$key");
        m.f(activityResultCallback, "$callback");
        m.f(activityResultContract, "$contract");
        m.f(lifecycleOwner, "<anonymous parameter 0>");
        m.f(event, NotificationCompat.CATEGORY_EVENT);
        if (Lifecycle.Event.ON_START == event) {
            activityResultRegistry.keyToCallback.put(str, new a(activityResultCallback, activityResultContract));
            if (activityResultRegistry.parsedPendingResults.containsKey(str)) {
                Object obj = activityResultRegistry.parsedPendingResults.get(str);
                activityResultRegistry.parsedPendingResults.remove(str);
                activityResultCallback.onActivityResult(obj);
            }
            ActivityResult activityResult = (ActivityResult) BundleCompat.getParcelable(activityResultRegistry.pendingResults, str, ActivityResult.class);
            if (activityResult != null) {
                activityResultRegistry.pendingResults.remove(str);
                activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
            }
        } else if (Lifecycle.Event.ON_STOP == event) {
            activityResultRegistry.keyToCallback.remove(str);
        } else if (Lifecycle.Event.ON_DESTROY == event) {
            activityResultRegistry.unregister$activity_release(str);
        }
    }

    private final void registerKey(String str) {
        if (this.keyToRc.get(str) == null) {
            bindRcKey(generateRandomNumber(), str);
        }
    }

    @MainThread
    public final boolean dispatchResult(int i10, int i11, Intent intent) {
        String str = this.rcToKey.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        doDispatch(str, i11, intent, this.keyToCallback.get(str));
        return true;
    }

    @MainThread
    public abstract <I, O> void onLaunch(int i10, ActivityResultContract<I, O> activityResultContract, I i11, ActivityOptionsCompat activityOptionsCompat);

    public final void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS);
            ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS);
            if (stringArrayList != null && integerArrayList != null) {
                ArrayList<String> stringArrayList2 = bundle.getStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS);
                if (stringArrayList2 != null) {
                    this.launchedKeys.addAll(stringArrayList2);
                }
                Bundle bundle2 = bundle.getBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS);
                if (bundle2 != null) {
                    this.pendingResults.putAll(bundle2);
                }
                int size = stringArrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    String str = stringArrayList.get(i10);
                    if (this.keyToRc.containsKey(str)) {
                        Integer remove = this.keyToRc.remove(str);
                        if (!this.pendingResults.containsKey(str)) {
                            c0.d(this.rcToKey).remove(remove);
                        }
                    }
                    Integer num = integerArrayList.get(i10);
                    m.e(num, "rcs[i]");
                    int intValue = num.intValue();
                    String str2 = stringArrayList.get(i10);
                    m.e(str2, "keys[i]");
                    bindRcKey(intValue, str2);
                }
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        m.f(bundle, "outState");
        bundle.putIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS, new ArrayList(this.keyToRc.values()));
        bundle.putStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS, new ArrayList(this.keyToRc.keySet()));
        bundle.putStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS, new ArrayList(this.launchedKeys));
        bundle.putBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS, new Bundle(this.pendingResults));
    }

    public final <I, O> ActivityResultLauncher<I> register(String str, LifecycleOwner lifecycleOwner, ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        m.f(str, "key");
        m.f(lifecycleOwner, "lifecycleOwner");
        m.f(activityResultContract, "contract");
        m.f(activityResultCallback, "callback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (!lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            registerKey(str);
            c cVar = this.keyToLifecycleContainers.get(str);
            if (cVar == null) {
                cVar = new c(lifecycle);
            }
            cVar.a(new c(this, str, activityResultCallback, activityResultContract));
            this.keyToLifecycleContainers.put(str, cVar);
            return new ActivityResultRegistry$register$2(this, str, activityResultContract);
        }
        throw new IllegalStateException(("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.").toString());
    }

    @MainThread
    public final void unregister$activity_release(String str) {
        Integer remove;
        m.f(str, "key");
        if (!this.launchedKeys.contains(str) && (remove = this.keyToRc.remove(str)) != null) {
            this.rcToKey.remove(remove);
        }
        this.keyToCallback.remove(str);
        if (this.parsedPendingResults.containsKey(str)) {
            Log.w(LOG_TAG, "Dropping pending result for request " + str + ": " + this.parsedPendingResults.get(str));
            this.parsedPendingResults.remove(str);
        }
        if (this.pendingResults.containsKey(str)) {
            Log.w(LOG_TAG, "Dropping pending result for request " + str + ": " + ((ActivityResult) BundleCompat.getParcelable(this.pendingResults, str, ActivityResult.class)));
            this.pendingResults.remove(str);
        }
        c cVar = this.keyToLifecycleContainers.get(str);
        if (cVar != null) {
            cVar.b();
            this.keyToLifecycleContainers.remove(str);
        }
    }

    @MainThread
    public final <O> boolean dispatchResult(int i10, O o10) {
        String str = this.rcToKey.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        a aVar = this.keyToCallback.get(str);
        if ((aVar != null ? aVar.a() : null) == null) {
            this.pendingResults.remove(str);
            this.parsedPendingResults.put(str, o10);
            return true;
        }
        ActivityResultCallback a10 = aVar.a();
        m.d(a10, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
        if (!this.launchedKeys.remove(str)) {
            return true;
        }
        a10.onActivityResult(o10);
        return true;
    }

    public final <I, O> ActivityResultLauncher<I> register(String str, ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        m.f(str, "key");
        m.f(activityResultContract, "contract");
        m.f(activityResultCallback, "callback");
        registerKey(str);
        this.keyToCallback.put(str, new a(activityResultCallback, activityResultContract));
        if (this.parsedPendingResults.containsKey(str)) {
            Object obj = this.parsedPendingResults.get(str);
            this.parsedPendingResults.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) BundleCompat.getParcelable(this.pendingResults, str, ActivityResult.class);
        if (activityResult != null) {
            this.pendingResults.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
        }
        return new ActivityResultRegistry$register$3(this, str, activityResultContract);
    }
}
