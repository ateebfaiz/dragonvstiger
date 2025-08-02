package com.facebook.react.uimanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.OnBatchCompleteListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@s6.a(name = "UIManager")
public class UIManagerModule extends ReactContextBaseJavaModule implements OnBatchCompleteListener, LifecycleEventListener, UIManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG = k3.c.a().c(l3.a.f22453f);
    public static final String NAME = "UIManager";
    public static final String TAG = "UIManagerModule";
    private int mBatchId = 0;
    private final Map<String, Object> mCustomDirectEvents;
    private final com.facebook.react.uimanager.events.e mEventDispatcher;
    private final List<p1> mListeners = new ArrayList();
    private final e mMemoryTrimCallback = new e();
    private final Map<String, Object> mModuleConstants;
    /* access modifiers changed from: private */
    public final j1 mUIImplementation;
    private final CopyOnWriteArrayList<UIManagerListener> mUIManagerListeners = new CopyOnWriteArrayList<>();
    private final i2 mViewManagerRegistry;

    class a implements d {
        a() {
        }

        public String a(String str) {
            return UIManagerModule.this.resolveCustomDirectEventName(str);
        }
    }

    class b extends GuardedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f3538a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f3539b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ReactContext reactContext, int i10, Object obj) {
            super(reactContext);
            this.f3538a = i10;
            this.f3539b = obj;
        }

        public void runGuarded() {
            UIManagerModule.this.mUIImplementation.U(this.f3538a, this.f3539b);
        }
    }

    class c extends GuardedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f3541a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f3542b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f3543c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ReactContext reactContext, int i10, int i11, int i12) {
            super(reactContext);
            this.f3541a = i10;
            this.f3542b = i11;
            this.f3543c = i12;
        }

        public void runGuarded() {
            UIManagerModule.this.mUIImplementation.X(this.f3541a, this.f3542b, this.f3543c);
            UIManagerModule.this.mUIImplementation.m(-1);
        }
    }

    public interface d {
        String a(String str);
    }

    private static class e implements ComponentCallbacks2 {
        private e() {
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i10) {
            if (i10 >= 60) {
                n2.a().a();
            }
        }
    }

    public UIManagerModule(ReactApplicationContext reactApplicationContext, j2 j2Var, int i10) {
        super(reactApplicationContext);
        g.f(reactApplicationContext);
        f fVar = new f(reactApplicationContext);
        this.mEventDispatcher = fVar;
        this.mModuleConstants = createConstants(j2Var);
        this.mCustomDirectEvents = m1.c();
        i2 i2Var = new i2(j2Var);
        this.mViewManagerRegistry = i2Var;
        this.mUIImplementation = new j1(reactApplicationContext, i2Var, (com.facebook.react.uimanager.events.e) fVar, i10);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    private static Map<String, Object> createConstants(j2 j2Var) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
        c8.b.a(0, "CreateUIManagerConstants").b("Lazy", Boolean.TRUE).c();
        try {
            return o1.a(j2Var);
        } finally {
            c8.a.g(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
        }
    }

    public <T extends View> int addRootView(T t10) {
        return addRootView(t10, (WritableMap) null);
    }

    public void addUIBlock(i1 i1Var) {
        this.mUIImplementation.a(i1Var);
    }

    public void addUIManagerEventListener(UIManagerListener uIManagerListener) {
        this.mUIManagerListeners.add(uIManagerListener);
    }

    @Deprecated
    public void addUIManagerListener(p1 p1Var) {
        this.mListeners.add(p1Var);
    }

    @ReactMethod
    public void clearJSResponder() {
        this.mUIImplementation.f();
    }

    @ReactMethod
    public void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback, Callback callback2) {
        this.mUIImplementation.g(readableMap, callback);
    }

    @ReactMethod
    public void createView(int i10, String str, int i11, ReadableMap readableMap) {
        if (DEBUG) {
            String str2 = "(UIManager.createView) tag: " + i10 + ", class: " + str + ", props: " + readableMap;
            z2.a.b("ReactNative", str2);
            k3.c.a().a(l3.a.f22453f, str2);
        }
        this.mUIImplementation.j(i10, str, i11, readableMap);
    }

    @Deprecated
    public void dispatchCommand(int i10, int i11, @Nullable ReadableArray readableArray) {
        this.mUIImplementation.k(i10, i11, readableArray);
    }

    @ReactMethod
    public void dispatchViewManagerCommand(int i10, Dynamic dynamic, @Nullable ReadableArray readableArray) {
        UIManager g10 = k1.g(getReactApplicationContext(), i7.a.a(i10));
        if (g10 != null) {
            if (dynamic.getType() == ReadableType.Number) {
                g10.dispatchCommand(i10, dynamic.asInt(), readableArray);
            } else if (dynamic.getType() == ReadableType.String) {
                g10.dispatchCommand(i10, dynamic.asString(), readableArray);
            }
        }
    }

    @ReactMethod
    public void findSubviewIn(int i10, ReadableArray readableArray, Callback callback) {
        this.mUIImplementation.o(i10, (float) Math.round(g0.c(readableArray.getDouble(0))), (float) Math.round(g0.c(readableArray.getDouble(1))), callback);
    }

    public Map<String, Object> getConstants() {
        return this.mModuleConstants;
    }

    @Nullable
    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getConstantsForViewManager(String str) {
        ViewManager O = this.mUIImplementation.O(str);
        if (O == null) {
            return null;
        }
        return getConstantsForViewManager(O, this.mCustomDirectEvents);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getDefaultEventTypes() {
        return Arguments.makeNativeMap((Map<String, Object>) o1.d());
    }

    @Deprecated
    public d getDirectEventNamesResolver() {
        return new a();
    }

    @NonNull
    public String getName() {
        return NAME;
    }

    public Map<String, Long> getPerformanceCounters() {
        return this.mUIImplementation.p();
    }

    @Deprecated
    public j1 getUIImplementation() {
        return this.mUIImplementation;
    }

    @Deprecated
    public i2 getViewManagerRegistry_DO_NOT_USE() {
        return this.mViewManagerRegistry;
    }

    public void initialize() {
        getReactApplicationContext().registerComponentCallbacks(this.mMemoryTrimCallback);
        getReactApplicationContext().registerComponentCallbacks(this.mViewManagerRegistry);
        this.mEventDispatcher.a(1, (RCTEventEmitter) getReactApplicationContext().getJSModule(RCTEventEmitter.class));
    }

    public void invalidate() {
        super.invalidate();
        this.mEventDispatcher.g();
        this.mUIImplementation.B();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.unregisterComponentCallbacks(this.mMemoryTrimCallback);
        reactApplicationContext.unregisterComponentCallbacks(this.mViewManagerRegistry);
        n2.a().a();
        e2.a();
    }

    public void invalidateNodeLayout(int i10) {
        t0 N = this.mUIImplementation.N(i10);
        if (N == null) {
            z2.a.G("ReactNative", "Warning : attempted to dirty a non-existent react shadow node. reactTag=" + i10);
            return;
        }
        N.h();
        this.mUIImplementation.m(-1);
    }

    @ReactMethod
    public void manageChildren(int i10, @Nullable ReadableArray readableArray, @Nullable ReadableArray readableArray2, @Nullable ReadableArray readableArray3, @Nullable ReadableArray readableArray4, @Nullable ReadableArray readableArray5) {
        if (DEBUG) {
            String str = "(UIManager.manageChildren) tag: " + i10 + ", moveFrom: " + readableArray + ", moveTo: " + readableArray2 + ", addTags: " + readableArray3 + ", atIndices: " + readableArray4 + ", removeFrom: " + readableArray5;
            z2.a.b("ReactNative", str);
            k3.c.a().a(l3.a.f22453f, str);
        }
        this.mUIImplementation.u(i10, readableArray, readableArray2, readableArray3, readableArray4, readableArray5);
    }

    @ReactMethod
    public void measure(int i10, Callback callback) {
        this.mUIImplementation.v(i10, callback);
    }

    @ReactMethod
    public void measureInWindow(int i10, Callback callback) {
        this.mUIImplementation.w(i10, callback);
    }

    @ReactMethod
    public void measureLayout(int i10, int i11, Callback callback, Callback callback2) {
        this.mUIImplementation.x(i10, i11, callback, callback2);
    }

    public void onBatchComplete() {
        int i10 = this.mBatchId;
        this.mBatchId = i10 + 1;
        c8.b.a(0, "onBatchCompleteUI").a("BatchId", i10).c();
        for (p1 willDispatchViewUpdates : this.mListeners) {
            willDispatchViewUpdates.willDispatchViewUpdates(this);
        }
        Iterator<UIManagerListener> it = this.mUIManagerListeners.iterator();
        while (it.hasNext()) {
            it.next().willDispatchViewUpdates(this);
        }
        try {
            if (this.mUIImplementation.q() > 0) {
                this.mUIImplementation.m(i10);
            }
        } finally {
            c8.a.g(0);
        }
    }

    public void onHostDestroy() {
        this.mUIImplementation.C();
    }

    public void onHostPause() {
        this.mUIImplementation.D();
    }

    public void onHostResume() {
        this.mUIImplementation.E();
    }

    public void prependUIBlock(i1 i1Var) {
        this.mUIImplementation.F(i1Var);
    }

    public void profileNextBatch() {
        this.mUIImplementation.G();
    }

    public void receiveEvent(int i10, String str, @Nullable WritableMap writableMap) {
        receiveEvent(-1, i10, str, writableMap);
    }

    @ReactMethod
    public void removeRootView(int i10) {
        this.mUIImplementation.J(i10);
    }

    public void removeUIManagerEventListener(UIManagerListener uIManagerListener) {
        this.mUIManagerListeners.remove(uIManagerListener);
    }

    @Deprecated
    public void removeUIManagerListener(p1 p1Var) {
        this.mListeners.remove(p1Var);
    }

    @Deprecated
    @Nullable
    public String resolveCustomDirectEventName(@Nullable String str) {
        Map map;
        if (str == null || (map = (Map) this.mCustomDirectEvents.get(str)) == null) {
            return str;
        }
        return (String) map.get("registrationName");
    }

    @Deprecated
    public int resolveRootTagFromReactTag(int i10) {
        if (i7.a.d(i10)) {
            return i10;
        }
        return this.mUIImplementation.M(i10);
    }

    public View resolveView(int i10) {
        UiThreadUtil.assertOnUiThread();
        return this.mUIImplementation.r().S().resolveView(i10);
    }

    @ReactMethod
    public void sendAccessibilityEvent(int i10, int i11) {
        int a10 = i7.a.a(i10);
        if (a10 == 2) {
            UIManager g10 = k1.g(getReactApplicationContext(), a10);
            if (g10 != null) {
                g10.sendAccessibilityEvent(i10, i11);
                return;
            }
            return;
        }
        this.mUIImplementation.P(i10, i11);
    }

    @ReactMethod
    public void setChildren(int i10, ReadableArray readableArray) {
        if (DEBUG) {
            String str = "(UIManager.setChildren) tag: " + i10 + ", children: " + readableArray;
            z2.a.b("ReactNative", str);
            k3.c.a().a(l3.a.f22453f, str);
        }
        this.mUIImplementation.Q(i10, readableArray);
    }

    @ReactMethod
    public void setJSResponder(int i10, boolean z10) {
        this.mUIImplementation.R(i10, z10);
    }

    @ReactMethod
    public void setLayoutAnimationEnabledExperimental(boolean z10) {
        this.mUIImplementation.S(z10);
    }

    public void setViewHierarchyUpdateDebugListener(@Nullable j7.a aVar) {
        this.mUIImplementation.T(aVar);
    }

    public void setViewLocalData(int i10, Object obj) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.assertOnUiQueueThread();
        reactApplicationContext.runOnNativeModulesQueueThread(new b(reactApplicationContext, i10, obj));
    }

    public <T extends View> int startSurface(T t10, String str, WritableMap writableMap, int i10, int i11) {
        throw new UnsupportedOperationException();
    }

    public void stopSurface(int i10) {
        throw new UnsupportedOperationException();
    }

    public void synchronouslyUpdateViewOnUIThread(int i10, ReadableMap readableMap) {
        this.mUIImplementation.V(i10, new v0(readableMap));
    }

    public void updateNodeSize(int i10, int i11, int i12) {
        getReactApplicationContext().assertOnNativeModulesQueueThread();
        this.mUIImplementation.W(i10, i11, i12);
    }

    public void updateRootLayoutSpecs(int i10, int i11, int i12, int i13, int i14) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.runOnNativeModulesQueueThread(new c(reactApplicationContext, i10, i11, i12));
    }

    @ReactMethod
    public void updateView(int i10, String str, ReadableMap readableMap) {
        if (DEBUG) {
            String str2 = "(UIManager.updateView) tag: " + i10 + ", class: " + str + ", props: " + readableMap;
            z2.a.b("ReactNative", str2);
            k3.c.a().a(l3.a.f22453f, str2);
        }
        this.mUIImplementation.Z(i10, str, readableMap);
    }

    @Deprecated
    @ReactMethod
    public void viewIsDescendantOf(int i10, int i11, Callback callback) {
        this.mUIImplementation.b0(i10, i11, callback);
    }

    public <T extends View> int addRootView(T t10, WritableMap writableMap) {
        c8.a.c(0, "UIManagerModule.addRootView");
        int a10 = s0.a();
        this.mUIImplementation.H(t10, a10, new e1(getReactApplicationContext(), t10.getContext(), ((r0) t10).getSurfaceID(), -1));
        c8.a.g(0);
        return a10;
    }

    public void dispatchCommand(int i10, String str, @Nullable ReadableArray readableArray) {
        this.mUIImplementation.l(i10, str, readableArray);
    }

    public com.facebook.react.uimanager.events.e getEventDispatcher() {
        return this.mEventDispatcher;
    }

    public void receiveEvent(int i10, int i11, String str, @Nullable WritableMap writableMap) {
        ((RCTEventEmitter) getReactApplicationContext().getJSModule(RCTEventEmitter.class)).receiveEvent(i11, str, writableMap);
    }

    @Nullable
    public static WritableMap getConstantsForViewManager(ViewManager viewManager, Map<String, Object> map) {
        c8.b.a(0, "UIManagerModule.getConstantsForViewManager").b("ViewManager", viewManager.getName()).b("Lazy", Boolean.TRUE).c();
        try {
            Map c10 = o1.c(viewManager, (Map) null, (Map) null, (Map) null, map);
            if (c10 != null) {
                return Arguments.makeNativeMap((Map<String, Object>) c10);
            }
            c8.b.b(0).c();
            return null;
        } finally {
            c8.b.b(0).c();
        }
    }

    public static Map<String, Object> createConstants(List<ViewManager> list, @Nullable Map<String, Object> map, @Nullable Map<String, Object> map2) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
        c8.b.a(0, "CreateUIManagerConstants").b("Lazy", Boolean.FALSE).c();
        try {
            return o1.b(list, map, map2);
        } finally {
            c8.a.g(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
        }
    }

    public UIManagerModule(ReactApplicationContext reactApplicationContext, List<ViewManager> list, int i10) {
        super(reactApplicationContext);
        g.f(reactApplicationContext);
        f fVar = new f(reactApplicationContext);
        this.mEventDispatcher = fVar;
        HashMap b10 = e6.f.b();
        this.mCustomDirectEvents = b10;
        this.mModuleConstants = createConstants(list, (Map<String, Object>) null, b10);
        i2 i2Var = new i2((List) list);
        this.mViewManagerRegistry = i2Var;
        this.mUIImplementation = new j1(reactApplicationContext, i2Var, (com.facebook.react.uimanager.events.e) fVar, i10);
        reactApplicationContext.addLifecycleEventListener(this);
    }
}
