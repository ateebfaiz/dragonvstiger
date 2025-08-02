package com.swmansion.reanimated;

import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.interop.UIBlockViewResolver;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.c0;
import com.facebook.react.uimanager.p1;
import com.swmansion.worklets.WorkletsModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import s6.a;

@a(name = "ReanimatedModule")
public class ReanimatedModule extends NativeReanimatedModuleSpec implements LifecycleEventListener, p1, UIManagerListener {
    private NodesManager mNodesManager;
    private ArrayList<UIThreadOperation> mOperations = new ArrayList<>();
    private Runnable mUnsubscribe = new g();
    private final WorkletsModule mWorkletsModule;

    private interface UIThreadOperation {
        void execute(NodesManager nodesManager);
    }

    public ReanimatedModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mWorkletsModule = (WorkletsModule) reactApplicationContext.getNativeModule(WorkletsModule.class);
    }

    private /* synthetic */ void lambda$initialize$2(UIManager uIManager) {
        ((FabricUIManager) uIManager).removeUIManagerEventListener(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initialize$3(UIManagerModule uIManagerModule) {
        uIManagerModule.removeUIManagerListener(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initialize$4(ReactApplicationContext reactApplicationContext) {
        reactApplicationContext.removeLifecycleEventListener(this);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$1() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$willDispatchViewUpdates$0(ArrayList arrayList, UIBlockViewResolver uIBlockViewResolver) {
        NodesManager nodesManager = getNodesManager();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((UIThreadOperation) it.next()).execute(nodesManager);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$willDispatchViewUpdates$5(ArrayList arrayList, c0 c0Var) {
        NodesManager nodesManager = getNodesManager();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((UIThreadOperation) it.next()).execute(nodesManager);
        }
    }

    @ReactMethod
    public void addListener(String str) {
    }

    public void didDispatchMountItems(@NonNull UIManager uIManager) {
    }

    public void didMountItems(@NonNull UIManager uIManager) {
    }

    public void didScheduleMountItems(@NonNull UIManager uIManager) {
    }

    public NodesManager getNodesManager() {
        if (this.mNodesManager == null) {
            this.mNodesManager = new NodesManager(getReactApplicationContext(), this.mWorkletsModule);
        }
        return this.mNodesManager;
    }

    public WorkletsModule getWorkletsModule() {
        return this.mWorkletsModule;
    }

    public void initialize() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        UIManagerModule uIManagerModule = (UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class);
        Objects.requireNonNull(uIManagerModule);
        uIManagerModule.addUIManagerListener(this);
        this.mUnsubscribe = Utils.combineRunnables(this.mUnsubscribe, new h(this, uIManagerModule));
        reactApplicationContext.addLifecycleEventListener(this);
        this.mUnsubscribe = Utils.combineRunnables(this.mUnsubscribe, new i(this, reactApplicationContext));
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean installTurboModule() {
        boolean z10;
        JavaScriptContextHolder javaScriptContextHolder = getReactApplicationContext().getJavaScriptContextHolder();
        Objects.requireNonNull(javaScriptContextHolder);
        if (javaScriptContextHolder.get() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Utils.isChromeDebugger = z10;
        if (!z10) {
            getNodesManager().initWithContext(getReactApplicationContext());
            return true;
        }
        Log.w("[REANIMATED]", "Unable to create Reanimated Native Module. You can ignore this message if you are using Chrome Debugger now.");
        return false;
    }

    public void invalidate() {
        super.invalidate();
        NodesManager nodesManager = this.mNodesManager;
        if (nodesManager != null) {
            nodesManager.invalidate();
        }
        this.mUnsubscribe.run();
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
        NodesManager nodesManager = this.mNodesManager;
        if (nodesManager != null) {
            nodesManager.onHostPause();
        }
    }

    public void onHostResume() {
        NodesManager nodesManager = this.mNodesManager;
        if (nodesManager != null) {
            nodesManager.onHostResume();
        }
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public void willDispatchViewUpdates(@NonNull UIManager uIManager) {
        if (!this.mOperations.isEmpty()) {
            ArrayList<UIThreadOperation> arrayList = this.mOperations;
            this.mOperations = new ArrayList<>();
            if (uIManager instanceof FabricUIManager) {
                ((FabricUIManager) uIManager).addUIBlock(new e(this, arrayList));
                return;
            }
            throw new RuntimeException("[Reanimated] Failed to obtain instance of FabricUIManager.");
        }
    }

    public void willMountItems(@NonNull UIManager uIManager) {
    }

    public void willDispatchViewUpdates(UIManagerModule uIManagerModule) {
        if (!this.mOperations.isEmpty()) {
            ArrayList<UIThreadOperation> arrayList = this.mOperations;
            this.mOperations = new ArrayList<>();
            uIManagerModule.addUIBlock(new f(this, arrayList));
        }
    }
}
