package com.facebook.react.config;

@Deprecated(since = "Use com.facebook.react.internal.featureflags.ReactNativeFeatureFlags instead.")
public class ReactFeatureFlags {
    public static boolean dispatchPointerEvents = false;
    public static boolean enableBridgelessArchitecture = false;
    public static boolean enableCppPropsIteratorSetter = false;
    public static boolean enableEagerRootViewAttachment = false;
    public static boolean enableFabricLogs = false;
    public static volatile boolean enableFabricRenderer = false;
    public static boolean enableFabricRendererExclusively = false;
    public static boolean enableRemoveDeleteTreeInstruction = false;
    public static boolean enableViewRecycling = false;
    public static boolean excludeYogaFromRawProps = false;
    public static boolean rejectTurboModulePromiseOnNativeError = true;
    public static boolean traceTurboModulePromiseRejections;
    public static volatile boolean unstable_enableTurboModuleSyncVoidMethods;
    public static volatile boolean unstable_useFabricInterop;
    public static volatile boolean unstable_useTurboModuleInterop;
    public static volatile boolean unstable_useTurboModuleInteropForAllTurboModules;
    public static volatile boolean useTurboModules;
}
