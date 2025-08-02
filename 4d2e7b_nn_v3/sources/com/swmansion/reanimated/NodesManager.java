package com.swmansion.reanimated;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.a;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.d;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.events.i;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.j1;
import com.facebook.react.uimanager.k1;
import com.facebook.react.uimanager.o;
import com.facebook.react.uimanager.q1;
import com.facebook.react.uimanager.s;
import com.facebook.react.uimanager.t0;
import com.facebook.react.uimanager.v0;
import com.swmansion.reanimated.layoutReanimation.AnimationsManager;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import com.swmansion.reanimated.nativeProxy.NoopEventHandler;
import com.swmansion.worklets.WorkletsModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class NodesManager implements i {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ReaCompatibility compatibility;
    private double lastFrameTimeMs;
    private final AnimationsManager mAnimationManager;
    private int mAnimationsDragFactor;
    private final AtomicBoolean mCallbackPosted = new AtomicBoolean();
    private final o mChoreographerCallback;
    private final ReactContext mContext;
    private RCTEventEmitter mCustomEventHandler = new NoopEventHandler();
    protected final UIManagerModule.d mCustomEventNamesResolver;
    private final DeviceEventManagerModule.RCTDeviceEventEmitter mEventEmitter;
    private ConcurrentLinkedQueue<CopiedEvent> mEventQueue = new ConcurrentLinkedQueue<>();
    private Long mFirstUptime = Long.valueOf(SystemClock.uptimeMillis());
    private List<OnAnimationFrame> mFrameCallbacks = new ArrayList();
    private NativeProxy mNativeProxy;
    private Queue<NativeUpdateOperation> mOperationsInBatch;
    private final a mReactChoreographer;
    private boolean mSlowAnimationsEnabled = false;
    private boolean mTryRunBatchUpdatesSynchronously;
    /* access modifiers changed from: private */
    public final j1 mUIImplementation;
    /* access modifiers changed from: private */
    public final UIManager mUIManager;
    private Runnable mUnsubscribe;
    private final WorkletsModule mWorkletsModule;
    public Set<String> nativeProps = Collections.emptySet();
    public Set<String> uiProps = Collections.emptySet();

    /* renamed from: com.swmansion.reanimated.NodesManager$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$bridge$ReadableType = r0
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Boolean     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Null     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Array     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.reanimated.NodesManager.AnonymousClass4.<clinit>():void");
        }
    }

    private final class NativeUpdateOperation {
        public WritableMap mNativeProps;
        public int mViewTag;

        public NativeUpdateOperation(int i10, WritableMap writableMap) {
            this.mViewTag = i10;
            this.mNativeProps = writableMap;
        }
    }

    public interface OnAnimationFrame {
        void onAnimationFrame(double d10);
    }

    public NodesManager(ReactContext reactContext, WorkletsModule workletsModule) {
        j1 j1Var = null;
        this.mUnsubscribe = null;
        this.mOperationsInBatch = new LinkedList();
        this.mTryRunBatchUpdatesSynchronously = false;
        this.mContext = reactContext;
        this.mWorkletsModule = workletsModule;
        UIManager g10 = k1.g(reactContext, 1);
        this.mUIManager = g10;
        this.mUIImplementation = g10 instanceof UIManagerModule ? ((UIManagerModule) g10).getUIImplementation() : j1Var;
        Objects.requireNonNull(g10);
        this.mCustomEventNamesResolver = new c(g10);
        this.mEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        this.mReactChoreographer = a.h();
        this.mChoreographerCallback = new o(reactContext) {
            /* access modifiers changed from: protected */
            public void doFrameGuarded(long j10) {
                NodesManager.this.onAnimationFrame(j10);
            }
        };
        e b10 = k1.b(reactContext, 1);
        Objects.requireNonNull(b10);
        e eVar = b10;
        eVar.b(this);
        this.mUnsubscribe = new d(this, eVar);
        this.mAnimationManager = new AnimationsManager(reactContext, g10);
    }

    private static void addProp(WritableMap writableMap, String str, Object obj) {
        if (obj == null) {
            writableMap.putNull(str);
        } else if (obj instanceof Double) {
            writableMap.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            writableMap.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Number) {
            writableMap.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            writableMap.putString(str, (String) obj);
        } else if (obj instanceof ReadableArray) {
            if (!(obj instanceof WritableArray)) {
                writableMap.putArray(str, copyReadableArray((ReadableArray) obj));
            } else {
                writableMap.putArray(str, (ReadableArray) obj);
            }
        } else if (!(obj instanceof ReadableMap)) {
            throw new IllegalStateException("[Reanimated] Unknown type of animated value.");
        } else if (!(obj instanceof WritableMap)) {
            writableMap.putMap(str, copyReadableMap((ReadableMap) obj));
        } else {
            writableMap.putMap(str, (ReadableMap) obj);
        }
    }

    private static WritableArray copyReadableArray(ReadableArray readableArray) {
        WritableArray createArray = Arguments.createArray();
        for (int i10 = 0; i10 < readableArray.size(); i10++) {
            switch (AnonymousClass4.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i10).ordinal()]) {
                case 1:
                    createArray.pushBoolean(readableArray.getBoolean(i10));
                    break;
                case 2:
                    createArray.pushString(readableArray.getString(i10));
                    break;
                case 3:
                    createArray.pushNull();
                    break;
                case 4:
                    createArray.pushDouble(readableArray.getDouble(i10));
                    break;
                case 5:
                    createArray.pushMap(copyReadableMap(readableArray.getMap(i10)));
                    break;
                case 6:
                    createArray.pushArray(copyReadableArray(readableArray.getArray(i10)));
                    break;
                default:
                    throw new IllegalStateException("[Reanimated] Unknown type of ReadableArray.");
            }
        }
        return createArray;
    }

    private static WritableMap copyReadableMap(ReadableMap readableMap) {
        WritableMap createMap = Arguments.createMap();
        createMap.merge(readableMap);
        return createMap;
    }

    private void handleEvent(d dVar) {
        dVar.dispatch(this.mCustomEventHandler);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(e eVar) {
        eVar.j(this);
    }

    /* access modifiers changed from: private */
    public void onAnimationFrame(long j10) {
        double d10 = ((double) j10) / 1000000.0d;
        if (this.mSlowAnimationsEnabled) {
            d10 = ((d10 - ((double) this.mFirstUptime.longValue())) / ((double) this.mAnimationsDragFactor)) + ((double) this.mFirstUptime.longValue());
        }
        if (d10 > this.lastFrameTimeMs) {
            this.lastFrameTimeMs = d10;
            while (!this.mEventQueue.isEmpty()) {
                CopiedEvent poll = this.mEventQueue.poll();
                handleEvent(poll.getTargetTag(), poll.getEventName(), poll.getPayload());
            }
            if (!this.mFrameCallbacks.isEmpty()) {
                List<OnAnimationFrame> list = this.mFrameCallbacks;
                this.mFrameCallbacks = new ArrayList(list.size());
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    list.get(i10).onAnimationFrame(d10);
                }
            }
            performOperations();
        }
        this.mCallbackPosted.set(false);
        if (!this.mFrameCallbacks.isEmpty() || !this.mEventQueue.isEmpty()) {
            startUpdatingOnAnimationFrame();
        }
    }

    private void stopUpdatingOnAnimationFrame() {
        if (this.mCallbackPosted.getAndSet(false)) {
            this.mReactChoreographer.o(a.b.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
        }
    }

    public void configureProps(Set<String> set, Set<String> set2) {
        this.uiProps = set;
        this.nativeProps = set2;
    }

    public void dispatchCommand(int i10, String str, ReadableArray readableArray) {
        ReactContext reactContext = this.mContext;
        final int i11 = i10;
        final String str2 = str;
        final ReadableArray readableArray2 = readableArray;
        reactContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactContext.getExceptionHandler()) {
            public void runGuarded() {
                NodesManager.this.mUIManager.dispatchCommand(i11, str2, readableArray2);
            }
        });
    }

    public void enableSlowAnimations(boolean z10, int i10) {
        this.mSlowAnimationsEnabled = z10;
        this.mAnimationsDragFactor = i10;
        if (z10) {
            this.mFirstUptime = Long.valueOf(SystemClock.uptimeMillis());
        }
    }

    public void enqueueUpdateViewOnNativeThread(int i10, WritableMap writableMap, boolean z10) {
        if (z10) {
            this.mTryRunBatchUpdatesSynchronously = true;
        }
        this.mOperationsInBatch.add(new NativeUpdateOperation(i10, writableMap));
    }

    public AnimationsManager getAnimationsManager() {
        return this.mAnimationManager;
    }

    public UIManagerModule.d getEventNameResolver() {
        return this.mCustomEventNamesResolver;
    }

    public NativeProxy getNativeProxy() {
        return this.mNativeProxy;
    }

    public void initWithContext(ReactApplicationContext reactApplicationContext) {
        this.mNativeProxy = new NativeProxy(reactApplicationContext, this.mWorkletsModule);
        this.mAnimationManager.setAndroidUIScheduler(this.mWorkletsModule.getAndroidUIScheduler());
        ReaCompatibility reaCompatibility = new ReaCompatibility(reactApplicationContext);
        this.compatibility = reaCompatibility;
        reaCompatibility.registerFabricEventListener(this);
    }

    public void invalidate() {
        AnimationsManager animationsManager = this.mAnimationManager;
        if (animationsManager != null) {
            animationsManager.invalidate();
        }
        NativeProxy nativeProxy = this.mNativeProxy;
        if (nativeProxy != null) {
            nativeProxy.invalidate();
            this.mNativeProxy = null;
        }
        ReaCompatibility reaCompatibility = this.compatibility;
        if (reaCompatibility != null) {
            reaCompatibility.unregisterFabricEventListener(this);
        }
        Runnable runnable = this.mUnsubscribe;
        if (runnable != null) {
            runnable.run();
            this.mUnsubscribe = null;
        }
    }

    public boolean isAnimationRunning() {
        return this.mCallbackPosted.get();
    }

    public float[] measure(int i10) {
        try {
            return NativeMethodsHelper.measure(this.mUIManager.resolveView(i10));
        } catch (s e10) {
            e10.printStackTrace();
            return new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
        }
    }

    public String obtainProp(int i10, String str) {
        try {
            View resolveView = this.mUIManager.resolveView(i10);
            str.hashCode();
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1267206133:
                    if (str.equals("opacity")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1221029593:
                    if (str.equals(Snapshot.HEIGHT)) {
                        c10 = 1;
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 113126854:
                    if (str.equals(Snapshot.WIDTH)) {
                        c10 = 5;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals("backgroundColor")) {
                        c10 = 6;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    return Float.toString(resolveView.getAlpha());
                case 1:
                    return Float.toString(g0.b((float) resolveView.getHeight()));
                case 2:
                    return Float.toString(resolveView.getElevation());
                case 3:
                    return Float.toString(g0.b((float) resolveView.getTop()));
                case 4:
                    return Float.toString(g0.b((float) resolveView.getLeft()));
                case 5:
                    return Float.toString(g0.b((float) resolveView.getWidth()));
                case 6:
                    Drawable background = resolveView.getBackground();
                    try {
                        String format = String.format("%08x", new Object[]{Integer.valueOf(((Integer) background.getClass().getMethod("getColor", (Class[]) null).invoke(background, (Object[]) null)).intValue())});
                        return "#" + format.substring(2, 8) + format.substring(0, 2);
                    } catch (Exception unused) {
                        return "Unable to resolve background color";
                    }
                default:
                    throw new IllegalArgumentException("[Reanimated] Attempted to get unsupported property " + str + " with function `getViewProp`");
            }
        } catch (Exception unused2) {
            return "[Reanimated] Unable to resolve view";
        }
    }

    public void onEventDispatch(d dVar) {
        if (this.mNativeProxy != null) {
            if (UiThreadUtil.isOnUiThread()) {
                handleEvent(dVar);
                performOperations();
                return;
            }
            if (this.mNativeProxy.isAnyHandlerWaitingForEvent(this.mCustomEventNamesResolver.a(dVar.getEventName()), dVar.getViewTag())) {
                this.mEventQueue.offer(new CopiedEvent(dVar));
            }
            startUpdatingOnAnimationFrame();
        }
    }

    public void onHostPause() {
        if (this.mCallbackPosted.get()) {
            stopUpdatingOnAnimationFrame();
            this.mCallbackPosted.set(true);
        }
    }

    public void onHostResume() {
        if (this.mCallbackPosted.getAndSet(false)) {
            startUpdatingOnAnimationFrame();
        }
    }

    public void performOperations() {
        if (!this.mOperationsInBatch.isEmpty()) {
            final Queue<NativeUpdateOperation> queue = this.mOperationsInBatch;
            this.mOperationsInBatch = new LinkedList();
            boolean z10 = this.mTryRunBatchUpdatesSynchronously;
            this.mTryRunBatchUpdatesSynchronously = false;
            Semaphore semaphore = new Semaphore(0);
            ReactContext reactContext = this.mContext;
            final boolean z11 = z10;
            final Semaphore semaphore2 = semaphore;
            reactContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactContext.getExceptionHandler()) {
                public void runGuarded() {
                    boolean z10;
                    boolean a10 = q1.a(NodesManager.this.mUIImplementation);
                    if (!z11 || !a10) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (!z10) {
                        semaphore2.release();
                    }
                    while (!queue.isEmpty()) {
                        NativeUpdateOperation nativeUpdateOperation = (NativeUpdateOperation) queue.remove();
                        t0 N = NodesManager.this.mUIImplementation.N(nativeUpdateOperation.mViewTag);
                        if (N != null) {
                            ((UIManagerModule) NodesManager.this.mUIManager).updateView(nativeUpdateOperation.mViewTag, N.M(), nativeUpdateOperation.mNativeProps);
                        }
                    }
                    if (a10) {
                        NodesManager.this.mUIImplementation.m(-1);
                    }
                    if (z10) {
                        semaphore2.release();
                    }
                }
            });
            if (z10) {
                try {
                    semaphore.tryAcquire(16, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public void postOnAnimation(OnAnimationFrame onAnimationFrame) {
        this.mFrameCallbacks.add(onAnimationFrame);
        startUpdatingOnAnimationFrame();
    }

    public void registerEventHandler(RCTEventEmitter rCTEventEmitter) {
        this.mCustomEventHandler = rCTEventEmitter;
    }

    public void scrollTo(int i10, double d10, double d11, boolean z10) {
        try {
            NativeMethodsHelper.scrollTo(this.mUIManager.resolveView(i10), d10, d11, z10);
        } catch (s e10) {
            e10.printStackTrace();
        }
    }

    public void sendEvent(String str, WritableMap writableMap) {
        this.mEventEmitter.emit(str, writableMap);
    }

    public void startUpdatingOnAnimationFrame() {
        if (!this.mCallbackPosted.getAndSet(true)) {
            this.mReactChoreographer.m(a.b.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
        }
    }

    public void updateProps(int i10, Map<String, Object> map) {
        try {
            if (this.mUIManager.resolveView(i10) != null) {
                JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                WritableMap createMap = Arguments.createMap();
                WritableMap createMap2 = Arguments.createMap();
                boolean z10 = false;
                boolean z11 = false;
                boolean z12 = false;
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (this.uiProps.contains(str)) {
                        addProp(javaOnlyMap, str, value);
                        z10 = true;
                    } else if (this.nativeProps.contains(str)) {
                        addProp(createMap2, str, value);
                        z11 = true;
                    } else {
                        addProp(createMap, str, value);
                        z12 = true;
                    }
                }
                if (i10 != -1) {
                    if (z10) {
                        this.mUIImplementation.V(i10, new v0(javaOnlyMap));
                    }
                    if (z11) {
                        enqueueUpdateViewOnNativeThread(i10, createMap2, true);
                    }
                    if (z12) {
                        WritableMap createMap3 = Arguments.createMap();
                        createMap3.putInt("viewTag", i10);
                        createMap3.putMap("props", createMap);
                        sendEvent("onReanimatedPropsChange", createMap3);
                    }
                }
            }
        } catch (s unused) {
        }
    }

    private void handleEvent(int i10, String str, WritableMap writableMap) {
        this.mCustomEventHandler.receiveEvent(i10, str, writableMap);
    }
}
