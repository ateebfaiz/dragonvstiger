package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.fabric.DevToolsReactPerfLogger;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.events.FabricEventEmitter;
import com.facebook.react.fabric.internal.interop.InteropUIBlockListener;
import com.facebook.react.fabric.interop.UIBlock;
import com.facebook.react.fabric.interop.UIBlockViewResolver;
import com.facebook.react.fabric.mounting.MountItemDispatcher;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.fabric.mounting.mountitems.BatchMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItemFactory;
import com.facebook.react.internal.interop.InteropEventEmitter;
import com.facebook.react.modules.core.a;
import com.facebook.react.uimanager.a1;
import com.facebook.react.uimanager.d1;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.e2;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.a;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.events.k;
import com.facebook.react.uimanager.events.p;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.i2;
import com.facebook.react.uimanager.k1;
import com.facebook.react.uimanager.r0;
import com.facebook.react.uimanager.s;
import com.facebook.react.uimanager.s0;
import com.facebook.react.views.text.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import k3.c;
import m6.b;

@SuppressLint({"MissingNativeLoadLibrary"})
public class FabricUIManager implements UIManager, LifecycleEventListener, UIBlockViewResolver, p {
    public static final boolean ENABLE_FABRIC_LOGS;
    public static final boolean ENABLE_FABRIC_PERF_LOGS;
    private static final DevToolsReactPerfLogger.DevToolsReactPerfLoggerListener FABRIC_PERF_LOGGER = new b();
    public static final boolean IS_DEVELOPMENT_ENVIRONMENT = false;
    public static final String TAG = "FabricUIManager";
    @NonNull
    private final a mBatchEventDispatchedListener;
    /* access modifiers changed from: private */
    @Nullable
    public Binding mBinding;
    private long mCommitStartTime = 0;
    private int mCurrentSynchronousCommitNumber = 10000;
    /* access modifiers changed from: private */
    public volatile boolean mDestroyed = false;
    public DevToolsReactPerfLogger mDevToolsReactPerfLogger;
    /* access modifiers changed from: private */
    @NonNull
    public final DispatchUIFrameCallback mDispatchUIFrameCallback;
    private long mDispatchViewUpdatesTime = 0;
    /* access modifiers changed from: private */
    public boolean mDriveCxxAnimations = false;
    @NonNull
    private final e mEventDispatcher;
    private long mFinishTransactionCPPTime = 0;
    private long mFinishTransactionTime = 0;
    @Nullable
    private InteropUIBlockListener mInteropUIBlockListener;
    private long mLayoutTime = 0;
    /* access modifiers changed from: private */
    @NonNull
    public final CopyOnWriteArrayList<UIManagerListener> mListeners = new CopyOnWriteArrayList<>();
    /* access modifiers changed from: private */
    @NonNull
    public final MountItemDispatcher mMountItemDispatcher;
    private final MountingManager.MountItemExecutor mMountItemExecutor;
    /* access modifiers changed from: private */
    public boolean mMountNotificationScheduled = false;
    /* access modifiers changed from: private */
    public final List<Integer> mMountedSurfaceIds = new ArrayList();
    @NonNull
    private final MountingManager mMountingManager;
    @NonNull
    private final ReactApplicationContext mReactApplicationContext;
    /* access modifiers changed from: private */
    public final Set<SynchronousEvent> mSynchronousEvents = new HashSet();
    @NonNull
    private final i2 mViewManagerRegistry;

    private class DispatchUIFrameCallback extends GuardedFrameCallback {
        private volatile boolean mIsMountingEnabled;

        @UiThread
        public void doFrameGuarded(long j10) {
            if (!this.mIsMountingEnabled || FabricUIManager.this.mDestroyed) {
                z2.a.G(FabricUIManager.TAG, "Not flushing pending UI operations because of previously thrown Exception");
                return;
            }
            if (FabricUIManager.this.mDriveCxxAnimations && FabricUIManager.this.mBinding != null) {
                FabricUIManager.this.mBinding.driveCxxAnimations();
            }
            try {
                FabricUIManager.this.mMountItemDispatcher.dispatchPreMountItems(j10);
                FabricUIManager.this.mMountItemDispatcher.tryDispatchMountItems();
                com.facebook.react.modules.core.a.h().m(a.b.DISPATCH_UI, FabricUIManager.this.mDispatchUIFrameCallback);
                FabricUIManager.this.mSynchronousEvents.clear();
            } catch (Exception e10) {
                z2.a.k(FabricUIManager.TAG, "Exception thrown when executing UIFrameGuarded", e10);
                stop();
                throw e10;
            } catch (Throwable th) {
                com.facebook.react.modules.core.a.h().m(a.b.DISPATCH_UI, FabricUIManager.this.mDispatchUIFrameCallback);
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        @AnyThread
        public void stop() {
            this.mIsMountingEnabled = false;
        }

        private DispatchUIFrameCallback(@NonNull ReactContext reactContext) {
            super(reactContext);
            this.mIsMountingEnabled = true;
        }
    }

    private class MountItemDispatchListener implements MountItemDispatcher.ItemDispatchListener {
        public void didDispatchMountItems() {
            Iterator it = FabricUIManager.this.mListeners.iterator();
            while (it.hasNext()) {
                ((UIManagerListener) it.next()).didDispatchMountItems(FabricUIManager.this);
            }
        }

        @UiThread
        public void didMountItems(@Nullable List<MountItem> list) {
            Iterator it = FabricUIManager.this.mListeners.iterator();
            while (it.hasNext()) {
                ((UIManagerListener) it.next()).didMountItems(FabricUIManager.this);
            }
            if (list != null && !list.isEmpty()) {
                for (MountItem next : list) {
                    if (next != null && !FabricUIManager.this.mMountedSurfaceIds.contains(Integer.valueOf(next.getSurfaceId()))) {
                        FabricUIManager.this.mMountedSurfaceIds.add(Integer.valueOf(next.getSurfaceId()));
                    }
                }
                if (!FabricUIManager.this.mMountNotificationScheduled && !FabricUIManager.this.mMountedSurfaceIds.isEmpty()) {
                    UiThreadUtil.getUiThreadHandler().postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            FabricUIManager.this.mMountNotificationScheduled = false;
                            Binding b10 = FabricUIManager.this.mBinding;
                            if (b10 == null || FabricUIManager.this.mDestroyed) {
                                FabricUIManager.this.mMountedSurfaceIds.clear();
                                return;
                            }
                            for (Integer intValue : FabricUIManager.this.mMountedSurfaceIds) {
                                b10.reportMount(intValue.intValue());
                            }
                            FabricUIManager.this.mMountedSurfaceIds.clear();
                        }
                    });
                }
            }
        }

        @UiThread
        public void willMountItems(@Nullable List<MountItem> list) {
            Iterator it = FabricUIManager.this.mListeners.iterator();
            while (it.hasNext()) {
                ((UIManagerListener) it.next()).willMountItems(FabricUIManager.this);
            }
        }

        private MountItemDispatchListener() {
        }
    }

    static {
        boolean z10;
        if (ReactFeatureFlags.enableFabricLogs || c.a().c(l3.a.f22454g)) {
            z10 = true;
        } else {
            z10 = false;
        }
        ENABLE_FABRIC_LOGS = z10;
        ENABLE_FABRIC_PERF_LOGS = z10;
        FabricSoLoader.staticInit();
    }

    public FabricUIManager(@NonNull ReactApplicationContext reactApplicationContext, @NonNull i2 i2Var, @NonNull com.facebook.react.uimanager.events.a aVar) {
        AnonymousClass1 r02 = new MountingManager.MountItemExecutor() {
            public void executeItems(Queue<MountItem> queue) {
                FabricUIManager.this.mMountItemDispatcher.dispatchMountItems(queue);
            }
        };
        this.mMountItemExecutor = r02;
        this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        MountingManager mountingManager = new MountingManager(i2Var, r02);
        this.mMountingManager = mountingManager;
        this.mMountItemDispatcher = new MountItemDispatcher(mountingManager, new MountItemDispatchListener());
        this.mEventDispatcher = new k(reactApplicationContext);
        this.mBatchEventDispatchedListener = aVar;
        reactApplicationContext.addLifecycleEventListener(this);
        this.mViewManagerRegistry = i2Var;
        reactApplicationContext.registerComponentCallbacks(i2Var);
    }

    @AnyThread
    private MountItem createIntBufferBatchMountItem(int i10, @Nullable int[] iArr, @Nullable Object[] objArr, int i11) {
        if (iArr == null) {
            iArr = new int[0];
        }
        if (objArr == null) {
            objArr = new Object[0];
        }
        return MountItemFactory.createIntBufferBatchMountItem(i10, iArr, objArr, i11);
    }

    @NonNull
    private InteropUIBlockListener getInteropUIBlockListener() {
        if (this.mInteropUIBlockListener == null) {
            InteropUIBlockListener interopUIBlockListener = new InteropUIBlockListener();
            this.mInteropUIBlockListener = interopUIBlockListener;
            addUIManagerEventListener(interopUIBlockListener);
        }
        return this.mInteropUIBlockListener;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(DevToolsReactPerfLogger.FabricCommitPoint fabricCommitPoint) {
        long commitDuration = fabricCommitPoint.getCommitDuration();
        long layoutDuration = fabricCommitPoint.getLayoutDuration();
        long diffDuration = fabricCommitPoint.getDiffDuration();
        long transactionEndDuration = fabricCommitPoint.getTransactionEndDuration();
        long batchExecutionDuration = fabricCommitPoint.getBatchExecutionDuration();
        LongStreamingStats longStreamingStats = DevToolsReactPerfLogger.mStreamingCommitStats;
        longStreamingStats.add(commitDuration);
        LongStreamingStats longStreamingStats2 = DevToolsReactPerfLogger.mStreamingLayoutStats;
        longStreamingStats2.add(layoutDuration);
        LongStreamingStats longStreamingStats3 = DevToolsReactPerfLogger.mStreamingDiffStats;
        longStreamingStats3.add(diffDuration);
        LongStreamingStats longStreamingStats4 = DevToolsReactPerfLogger.mStreamingTransactionEndStats;
        longStreamingStats4.add(transactionEndDuration);
        LongStreamingStats longStreamingStats5 = DevToolsReactPerfLogger.mStreamingBatchExecutionStats;
        longStreamingStats5.add(batchExecutionDuration);
        String str = TAG;
        z2.a.t(str, "Statistics of Fabric commit #%d:\n - Total commit time: %d ms. Avg: %.2f. Median: %.2f ms. Max: %d ms.\n - Layout time: %d ms. Avg: %.2f. Median: %.2f ms. Max: %d ms.\n - Diffing time: %d ms. Avg: %.2f. Median: %.2f ms. Max: %d ms.\n - FinishTransaction (Diffing + JNI serialization): %d ms. Avg: %.2f. Median: %.2f ms. Max: %d ms.\n - Mounting: %d ms. Avg: %.2f. Median: %.2f ms. Max: %d ms.\n", Long.valueOf(fabricCommitPoint.getCommitNumber()), Long.valueOf(commitDuration), Double.valueOf(longStreamingStats.getAverage()), Double.valueOf(longStreamingStats.getMedian()), Long.valueOf(longStreamingStats.getMax()), Long.valueOf(layoutDuration), Double.valueOf(longStreamingStats2.getAverage()), Double.valueOf(longStreamingStats2.getMedian()), Long.valueOf(longStreamingStats2.getMax()), Long.valueOf(diffDuration), Double.valueOf(longStreamingStats3.getAverage()), Double.valueOf(longStreamingStats3.getMedian()), Long.valueOf(longStreamingStats3.getMax()), Long.valueOf(transactionEndDuration), Double.valueOf(longStreamingStats4.getAverage()), Double.valueOf(longStreamingStats4.getMedian()), Long.valueOf(longStreamingStats4.getMax()), Long.valueOf(batchExecutionDuration), Double.valueOf(longStreamingStats5.getAverage()), Double.valueOf(longStreamingStats5.getMedian()), Long.valueOf(longStreamingStats5.getMax()));
    }

    private long measure(int i10, String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f10, float f11, float f12, float f13) {
        return measure(i10, str, readableMap, readableMap2, readableMap3, f10, f11, f12, f13, (float[]) null);
    }

    private NativeArray measureLines(ReadableMapBuffer readableMapBuffer, ReadableMapBuffer readableMapBuffer2, float f10, float f11) {
        return (NativeArray) r.j(this.mReactApplicationContext, readableMapBuffer, readableMapBuffer2, g0.d(f10), g0.d(f11));
    }

    private long measureMapBuffer(int i10, String str, ReadableMapBuffer readableMapBuffer, ReadableMapBuffer readableMapBuffer2, @Nullable ReadableMapBuffer readableMapBuffer3, float f10, float f11, float f12, float f13, @Nullable float[] fArr) {
        ReactContext reactContext;
        if (i10 > 0) {
            SurfaceMountingManager surfaceManagerEnforced = this.mMountingManager.getSurfaceManagerEnforced(i10, "measure");
            if (surfaceManagerEnforced.isStopped()) {
                return 0;
            }
            reactContext = surfaceManagerEnforced.getContext();
        } else {
            reactContext = this.mReactApplicationContext;
        }
        return this.mMountingManager.measureMapBuffer(reactContext, str, readableMapBuffer, readableMapBuffer2, readableMapBuffer3, com.facebook.react.fabric.mounting.a.d(f10, f11), com.facebook.react.fabric.mounting.a.c(f10, f11), com.facebook.react.fabric.mounting.a.d(f12, f13), com.facebook.react.fabric.mounting.a.c(f12, f13), fArr);
    }

    @AnyThread
    private void preallocateView(int i10, int i11, String str, @Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, boolean z10) {
        this.mMountItemDispatcher.addPreAllocateMountItem(MountItemFactory.createPreAllocateViewMountItem(i10, i11, str, (ReadableMap) obj, (d1) obj2, (EventEmitterWrapper) obj3, z10));
    }

    @AnyThread
    private void scheduleMountItem(@Nullable MountItem mountItem, int i10, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i11) {
        boolean z10;
        MountItem mountItem2 = mountItem;
        int i12 = i10;
        long j17 = j10;
        long j18 = j13;
        long j19 = j14;
        long j20 = j15;
        long j21 = j16;
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z11 = mountItem2 instanceof BatchMountItem;
        if ((!z11 || ((BatchMountItem) mountItem2).isBatchEmpty()) && (z11 || mountItem2 == null)) {
            z10 = false;
        } else {
            z10 = true;
        }
        for (Iterator<UIManagerListener> it = this.mListeners.iterator(); it.hasNext(); it = it) {
            it.next().didScheduleMountItems(this);
        }
        if (z11) {
            this.mCommitStartTime = j17;
            this.mLayoutTime = j19 - j18;
            this.mFinishTransactionCPPTime = j21 - j20;
            this.mFinishTransactionTime = uptimeMillis - j20;
            this.mDispatchViewUpdatesTime = SystemClock.uptimeMillis();
        }
        if (z10) {
            this.mMountItemDispatcher.addMountItem(mountItem2);
            AnonymousClass3 r12 = new GuardedRunnable(this.mReactApplicationContext) {
                public void runGuarded() {
                    FabricUIManager.this.mMountItemDispatcher.tryDispatchMountItems();
                }
            };
            if (UiThreadUtil.isOnUiThread()) {
                r12.run();
            }
        }
        if (z11) {
            int i13 = i10;
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_START, (String) null, i13, j10);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_START, (String) null, i13, j20);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_END, (String) null, i13, j21);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_START, (String) null, i13, j11);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_END, (String) null, i13, j12);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_START, (String) null, i13, j18);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_END, (String) null, i13, j19);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_AFFECTED_NODES, (String) null, i10, j14, i11);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_END, (String) null, i13);
        }
    }

    @UiThread
    @Deprecated
    public <T extends View> int addRootView(T t10, WritableMap writableMap) {
        String str = TAG;
        ReactSoftExceptionLogger.logSoftException(str, new s("Do not call addRootView in Fabric; it is unsupported. Call startSurface instead."));
        r0 r0Var = (r0) t10;
        int rootViewTag = r0Var.getRootViewTag();
        this.mMountingManager.startSurface(rootViewTag, new e1(this.mReactApplicationContext, t10.getContext(), r0Var.getSurfaceID(), rootViewTag), t10);
        String jSModuleName = r0Var.getJSModuleName();
        if (ENABLE_FABRIC_LOGS) {
            z2.a.d(str, "Starting surface for module: %s and reactTag: %d", jSModuleName, Integer.valueOf(rootViewTag));
        }
        this.mBinding.startSurface(rootViewTag, jSModuleName, (NativeMap) writableMap);
        return rootViewTag;
    }

    public void addUIBlock(UIBlock uIBlock) {
        if (ReactFeatureFlags.unstable_useFabricInterop) {
            getInteropUIBlockListener().addUIBlock(uIBlock);
        }
    }

    public void addUIManagerEventListener(UIManagerListener uIManagerListener) {
        this.mListeners.add(uIManagerListener);
    }

    public void attachRootView(b bVar, View view) {
        this.mMountingManager.attachRootView(bVar.getSurfaceId(), view, new e1(this.mReactApplicationContext, view.getContext(), bVar.getModuleName(), bVar.getSurfaceId()));
        bVar.setMountable(true);
    }

    public void clearJSResponder() {
        this.mMountItemDispatcher.addMountItem(new MountItem() {
            public void execute(@NonNull MountingManager mountingManager) {
                mountingManager.clearJSResponder();
            }

            public int getSurfaceId() {
                return -1;
            }

            @NonNull
            public String toString() {
                return "CLEAR_JS_RESPONDER";
            }
        });
    }

    /* access modifiers changed from: package-private */
    public DispatchCommandMountItem createDispatchCommandMountItemForInterop(int i10, int i11, String str, @Nullable ReadableArray readableArray) {
        try {
            return MountItemFactory.createDispatchCommandMountItem(i10, i11, Integer.parseInt(str), readableArray);
        } catch (NumberFormatException unused) {
            return MountItemFactory.createDispatchCommandMountItem(i10, i11, str, readableArray);
        }
    }

    @Deprecated
    @AnyThread
    public void dispatchCommand(int i10, int i11, @Nullable ReadableArray readableArray) {
        throw new UnsupportedOperationException("dispatchCommand called without surfaceId - Fabric dispatchCommand must be called through Fabric JSI API");
    }

    public int getColor(int i10, String[] strArr) {
        e1 context = this.mMountingManager.getSurfaceManagerEnforced(i10, "getColor").getContext();
        if (context == null) {
            return 0;
        }
        for (String resolveResourcePath : strArr) {
            Integer resolveResourcePath2 = ColorPropConverter.resolveResourcePath(context, resolveResourcePath);
            if (resolveResourcePath2 != null) {
                return resolveResourcePath2.intValue();
            }
        }
        return 0;
    }

    @UiThread
    public ReadableMap getInspectorDataForInstance(int i10, View view) {
        UiThreadUtil.assertOnUiThread();
        return this.mBinding.getInspectorDataForInstance(this.mMountingManager.getEventEmitter(i10, view.getId()));
    }

    public Map<String, Long> getPerformanceCounters() {
        HashMap hashMap = new HashMap();
        hashMap.put("CommitStartTime", Long.valueOf(this.mCommitStartTime));
        hashMap.put("LayoutTime", Long.valueOf(this.mLayoutTime));
        hashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.mDispatchViewUpdatesTime));
        hashMap.put("RunStartTime", Long.valueOf(this.mMountItemDispatcher.getRunStartTime()));
        hashMap.put("BatchedExecutionTime", Long.valueOf(this.mMountItemDispatcher.getBatchedExecutionTime()));
        hashMap.put("FinishFabricTransactionTime", Long.valueOf(this.mFinishTransactionTime));
        hashMap.put("FinishFabricTransactionCPPTime", Long.valueOf(this.mFinishTransactionCPPTime));
        return hashMap;
    }

    public boolean getThemeData(int i10, float[] fArr) {
        e1 context = this.mMountingManager.getSurfaceManagerEnforced(i10, "getThemeData").getContext();
        if (context == null) {
            z2.a.G(TAG, "\"themedReactContext\" is null when call \"getThemeData\"");
            return false;
        }
        float[] a10 = k1.a(context);
        fArr[0] = a10[0];
        fArr[1] = a10[1];
        fArr[2] = a10[2];
        fArr[3] = a10[3];
        return true;
    }

    public void initialize() {
        this.mEventDispatcher.h(2, new FabricEventEmitter(this));
        this.mEventDispatcher.f(this.mBatchEventDispatchedListener);
        if (ENABLE_FABRIC_PERF_LOGS) {
            DevToolsReactPerfLogger devToolsReactPerfLogger = new DevToolsReactPerfLogger();
            this.mDevToolsReactPerfLogger = devToolsReactPerfLogger;
            devToolsReactPerfLogger.addDevToolsReactPerfLoggerListener(FABRIC_PERF_LOGGER);
            ReactMarker.addFabricListener(this.mDevToolsReactPerfLogger);
        }
        if (ReactFeatureFlags.unstable_useFabricInterop) {
            this.mReactApplicationContext.internal_registerInteropModule(RCTEventEmitter.class, new InteropEventEmitter(this.mReactApplicationContext));
        }
    }

    @AnyThread
    public void invalidate() {
        String str = TAG;
        z2.a.p(str, "FabricUIManager.invalidate");
        DevToolsReactPerfLogger devToolsReactPerfLogger = this.mDevToolsReactPerfLogger;
        if (devToolsReactPerfLogger != null) {
            devToolsReactPerfLogger.removeDevToolsReactPerfLoggerListener(FABRIC_PERF_LOGGER);
            ReactMarker.removeFabricListener(this.mDevToolsReactPerfLogger);
        }
        if (this.mDestroyed) {
            ReactSoftExceptionLogger.logSoftException(str, new IllegalStateException("Cannot double-destroy FabricUIManager"));
            return;
        }
        this.mDestroyed = true;
        this.mDispatchUIFrameCallback.stop();
        this.mEventDispatcher.e(this.mBatchEventDispatchedListener);
        this.mEventDispatcher.i(2);
        this.mReactApplicationContext.unregisterComponentCallbacks(this.mViewManagerRegistry);
        this.mViewManagerRegistry.f();
        this.mReactApplicationContext.removeLifecycleEventListener(this);
        onHostPause();
        this.mBinding.unregister();
        this.mBinding = null;
        e2.a();
        if (!ReactFeatureFlags.enableBridgelessArchitecture) {
            this.mEventDispatcher.g();
        }
    }

    @AnyThread
    public void onAllAnimationsComplete() {
        this.mDriveCxxAnimations = false;
    }

    @AnyThread
    public void onAnimationStarted() {
        this.mDriveCxxAnimations = true;
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
        com.facebook.react.modules.core.a.h().o(a.b.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    public void onHostResume() {
        com.facebook.react.modules.core.a.h().m(a.b.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    public void onRequestEventBeat() {
        this.mEventDispatcher.d();
    }

    public void prependUIBlock(UIBlock uIBlock) {
        if (ReactFeatureFlags.unstable_useFabricInterop) {
            getInteropUIBlockListener().prependUIBlock(uIBlock);
        }
    }

    public void profileNextBatch() {
    }

    public void receiveEvent(int i10, String str, @Nullable WritableMap writableMap) {
        receiveEvent(-1, i10, str, false, writableMap, 2);
    }

    public void removeUIManagerEventListener(UIManagerListener uIManagerListener) {
        this.mListeners.remove(uIManagerListener);
    }

    @Deprecated
    @Nullable
    public String resolveCustomDirectEventName(@Nullable String str) {
        if (str == null) {
            return null;
        }
        if (!str.startsWith("top")) {
            return str;
        }
        return "on" + str.substring(3);
    }

    public View resolveView(int i10) {
        UiThreadUtil.assertOnUiThread();
        SurfaceMountingManager surfaceManagerForView = this.mMountingManager.getSurfaceManagerForView(i10);
        if (surfaceManagerForView == null) {
            return null;
        }
        return surfaceManagerForView.getView(i10);
    }

    @AnyThread
    public void sendAccessibilityEvent(int i10, int i11) {
        this.mMountItemDispatcher.addMountItem(MountItemFactory.createSendAccessibilityEventMountItem(-1, i10, i11));
    }

    @AnyThread
    public void sendAccessibilityEventFromJS(int i10, int i11, String str) {
        int i12;
        if ("focus".equals(str)) {
            i12 = 8;
        } else if ("windowStateChange".equals(str)) {
            i12 = 32;
        } else if ("click".equals(str)) {
            i12 = 1;
        } else if ("viewHoverEnter".equals(str)) {
            i12 = 128;
        } else {
            throw new IllegalArgumentException("sendAccessibilityEventFromJS: invalid eventType " + str);
        }
        this.mMountItemDispatcher.addMountItem(MountItemFactory.createSendAccessibilityEventMountItem(i10, i11, i12));
    }

    public void setBinding(Binding binding) {
        this.mBinding = binding;
    }

    public void setJSResponder(int i10, int i11, int i12, boolean z10) {
        final int i13 = i10;
        final int i14 = i11;
        final int i15 = i12;
        final boolean z11 = z10;
        this.mMountItemDispatcher.addMountItem(new MountItem() {
            public void execute(@NonNull MountingManager mountingManager) {
                SurfaceMountingManager surfaceManager = mountingManager.getSurfaceManager(i13);
                if (surfaceManager != null) {
                    surfaceManager.setJSResponder(i14, i15, z11);
                    return;
                }
                String str = FabricUIManager.TAG;
                z2.a.j(str, "setJSResponder skipped, surface no longer available [" + i13 + "]");
            }

            public int getSurfaceId() {
                return i13;
            }

            @SuppressLint({"DefaultLocale"})
            @NonNull
            public String toString() {
                return String.format("SET_JS_RESPONDER [%d] [surface:%d]", new Object[]{Integer.valueOf(i14), Integer.valueOf(i13)});
            }
        });
    }

    @AnyThread
    public <T extends View> int startSurface(T t10, String str, WritableMap writableMap, int i10, int i11) {
        T t11 = t10;
        String str2 = str;
        int rootViewTag = ((r0) t11).getRootViewTag();
        Context context = t10.getContext();
        e1 e1Var = new e1(this.mReactApplicationContext, context, str2, rootViewTag);
        if (ENABLE_FABRIC_LOGS) {
            z2.a.d(TAG, "Starting surface for module: %s and reactTag: %d", str2, Integer.valueOf(rootViewTag));
        }
        this.mMountingManager.startSurface(rootViewTag, e1Var, t11);
        Point b10 = UiThreadUtil.isOnUiThread() ? a1.b(t10) : new Point(0, 0);
        this.mBinding.startSurfaceWithConstraints(rootViewTag, str, (NativeMap) writableMap, com.facebook.react.fabric.mounting.a.b(i10), com.facebook.react.fabric.mounting.a.a(i10), com.facebook.react.fabric.mounting.a.b(i11), com.facebook.react.fabric.mounting.a.a(i11), (float) b10.x, (float) b10.y, com.facebook.react.modules.i18nmanager.a.f().i(context), com.facebook.react.modules.i18nmanager.a.f().d(context));
        return rootViewTag;
    }

    public void stopSurface(b bVar) {
        if (!bVar.isRunning()) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Trying to stop surface that hasn't started yet"));
            return;
        }
        this.mMountingManager.stopSurface(bVar.getSurfaceId());
        bVar.stop();
        if (bVar instanceof SurfaceHandlerBinding) {
            this.mBinding.unregisterSurface((SurfaceHandlerBinding) bVar);
        }
    }

    @UiThread
    public void synchronouslyUpdateViewOnUIThread(final int i10, @NonNull final ReadableMap readableMap) {
        UiThreadUtil.assertOnUiThread();
        int i11 = this.mCurrentSynchronousCommitNumber;
        this.mCurrentSynchronousCommitNumber = i11 + 1;
        AnonymousClass2 r12 = new MountItem() {
            public void execute(@NonNull MountingManager mountingManager) {
                try {
                    mountingManager.updateProps(i10, readableMap);
                } catch (Exception unused) {
                }
            }

            public int getSurfaceId() {
                return -1;
            }

            @NonNull
            public String toString() {
                return String.format("SYNC UPDATE PROPS [%d]: %s", new Object[]{Integer.valueOf(i10), "<hidden>"});
            }
        };
        if (!this.mMountingManager.getViewExists(i10)) {
            this.mMountItemDispatcher.addMountItem(r12);
            return;
        }
        ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_START, (String) null, i11);
        if (ENABLE_FABRIC_LOGS) {
            z2.a.d(TAG, "SynchronouslyUpdateViewOnUIThread for tag %d: %s", Integer.valueOf(i10), "<hidden>");
        }
        r12.execute(this.mMountingManager);
        ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END, (String) null, i11);
    }

    @UiThread
    public void updateRootLayoutSpecs(int i10, int i11, int i12, int i13, int i14) {
        boolean z10;
        boolean z11;
        int i15 = i10;
        if (ENABLE_FABRIC_LOGS) {
            z2.a.c(TAG, "Updating Root Layout Specs for [%d]", Integer.valueOf(i10));
        }
        SurfaceMountingManager surfaceManager = this.mMountingManager.getSurfaceManager(i10);
        if (surfaceManager == null) {
            ReactSoftExceptionLogger.logSoftException(TAG, new s("Cannot updateRootLayoutSpecs on surfaceId that does not exist: " + i10));
            return;
        }
        e1 context = surfaceManager.getContext();
        if (context != null) {
            boolean i16 = com.facebook.react.modules.i18nmanager.a.f().i(context);
            z10 = com.facebook.react.modules.i18nmanager.a.f().d(context);
            z11 = i16;
        } else {
            z11 = false;
            z10 = false;
        }
        this.mBinding.setConstraints(i10, com.facebook.react.fabric.mounting.a.b(i11), com.facebook.react.fabric.mounting.a.a(i11), com.facebook.react.fabric.mounting.a.b(i12), com.facebook.react.fabric.mounting.a.a(i12), (float) i13, (float) i14, z11, z10);
    }

    private long measure(int i10, String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f10, float f11, float f12, float f13, @Nullable float[] fArr) {
        ReactContext reactContext;
        if (i10 > 0) {
            SurfaceMountingManager surfaceManagerEnforced = this.mMountingManager.getSurfaceManagerEnforced(i10, "measure");
            if (surfaceManagerEnforced.isStopped()) {
                return 0;
            }
            reactContext = surfaceManagerEnforced.getContext();
        } else {
            reactContext = this.mReactApplicationContext;
        }
        return this.mMountingManager.measure(reactContext, str, readableMap, readableMap2, readableMap3, com.facebook.react.fabric.mounting.a.d(f10, f11), com.facebook.react.fabric.mounting.a.c(f10, f11), com.facebook.react.fabric.mounting.a.d(f12, f13), com.facebook.react.fabric.mounting.a.c(f12, f13), fArr);
    }

    @Deprecated
    @AnyThread
    public void dispatchCommand(int i10, String str, @Nullable ReadableArray readableArray) {
        throw new UnsupportedOperationException("dispatchCommand called without surfaceId - Fabric dispatchCommand must be called through Fabric JSI API");
    }

    @NonNull
    public e getEventDispatcher() {
        return this.mEventDispatcher;
    }

    public void receiveEvent(int i10, int i11, String str, @Nullable WritableMap writableMap) {
        receiveEvent(i10, i11, str, false, writableMap, 2);
    }

    @Deprecated
    @AnyThread
    public void dispatchCommand(int i10, int i11, int i12, @Nullable ReadableArray readableArray) {
        this.mMountItemDispatcher.addViewCommandMountItem(MountItemFactory.createDispatchCommandMountItem(i10, i11, i12, readableArray));
    }

    public void receiveEvent(int i10, int i11, String str, boolean z10, @Nullable WritableMap writableMap, int i12) {
        receiveEvent(i10, i11, str, z10, writableMap, i12, false);
    }

    public void receiveEvent(int i10, int i11, String str, boolean z10, @Nullable WritableMap writableMap, int i12, boolean z11) {
        if (this.mDestroyed) {
            z2.a.j(TAG, "Attempted to receiveEvent after destruction");
            return;
        }
        EventEmitterWrapper eventEmitter = this.mMountingManager.getEventEmitter(i10, i11);
        if (eventEmitter == null) {
            if (this.mMountingManager.getViewExists(i11)) {
                this.mMountingManager.enqueuePendingEvent(i10, i11, str, z10, writableMap, i12);
                return;
            }
            String str2 = TAG;
            z2.a.b(str2, "Unable to invoke event: " + str + " for reactTag: " + i11);
        } else if (z11) {
            if (this.mSynchronousEvents.add(new SynchronousEvent(i10, i11, str))) {
                eventEmitter.dispatchEventSynchronously(str, writableMap);
            }
        } else if (z10) {
            eventEmitter.dispatchUnique(str, writableMap);
        } else {
            eventEmitter.dispatch(str, writableMap, i12);
        }
    }

    @AnyThread
    public void dispatchCommand(int i10, int i11, String str, @Nullable ReadableArray readableArray) {
        if (ReactFeatureFlags.unstable_useFabricInterop) {
            this.mMountItemDispatcher.addViewCommandMountItem(createDispatchCommandMountItemForInterop(i10, i11, str, readableArray));
        } else {
            this.mMountItemDispatcher.addViewCommandMountItem(MountItemFactory.createDispatchCommandMountItem(i10, i11, str, readableArray));
        }
    }

    @AnyThread
    public void stopSurface(int i10) {
        this.mMountingManager.stopSurface(i10);
        this.mBinding.stopSurface(i10);
    }

    public void startSurface(b bVar, Context context, @Nullable View view) {
        int a10 = s0.a();
        this.mMountingManager.startSurface(a10, new e1(this.mReactApplicationContext, context, bVar.getModuleName(), a10), view);
        bVar.setSurfaceId(a10);
        if (bVar instanceof SurfaceHandlerBinding) {
            this.mBinding.registerSurface((SurfaceHandlerBinding) bVar);
        }
        bVar.setMountable(view != null);
        bVar.start();
    }
}
