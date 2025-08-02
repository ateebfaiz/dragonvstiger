package com.facebook.react.fabric;

import c8.a;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.RuntimeScheduler;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerProvider;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.uimanager.i2;

public class FabricUIManagerProviderImpl implements UIManagerProvider {
    private final ComponentFactory mComponentFactory;
    private final ReactNativeConfig mConfig;
    private final i2 mViewManagerRegistry;

    public FabricUIManagerProviderImpl(ComponentFactory componentFactory, ReactNativeConfig reactNativeConfig, i2 i2Var) {
        this.mComponentFactory = componentFactory;
        this.mConfig = reactNativeConfig;
        this.mViewManagerRegistry = i2Var;
    }

    public UIManager createUIManager(ReactApplicationContext reactApplicationContext) {
        a.c(0, "FabricUIManagerProviderImpl.create");
        EventBeatManager eventBeatManager = new EventBeatManager();
        a.c(0, "FabricUIManagerProviderImpl.createUIManager");
        FabricUIManager fabricUIManager = new FabricUIManager(reactApplicationContext, this.mViewManagerRegistry, eventBeatManager);
        a.g(0);
        a.c(0, "FabricUIManagerProviderImpl.registerBinding");
        BindingImpl bindingImpl = new BindingImpl();
        CatalystInstance catalystInstance = reactApplicationContext.getCatalystInstance();
        RuntimeExecutor runtimeExecutor = catalystInstance.getRuntimeExecutor();
        RuntimeScheduler runtimeScheduler = catalystInstance.getRuntimeScheduler();
        if (runtimeExecutor == null || runtimeScheduler == null) {
            throw new IllegalStateException("Unable to register FabricUIManager with CatalystInstance, runtimeExecutor and runtimeScheduler must not be null");
        }
        bindingImpl.register(runtimeExecutor, runtimeScheduler, fabricUIManager, eventBeatManager, this.mComponentFactory, this.mConfig);
        a.g(0);
        a.g(0);
        return fabricUIManager;
    }
}
