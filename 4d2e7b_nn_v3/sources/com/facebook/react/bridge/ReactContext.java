package com.facebook.react.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.interop.InteropModuleRegistry;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import d6.a;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class ReactContext extends ContextWrapper {
    private static final String TAG = "ReactContext";
    private final CopyOnWriteArraySet<ActivityEventListener> mActivityEventListeners = new CopyOnWriteArraySet<>();
    @Nullable
    private WeakReference<Activity> mCurrentActivity;
    @Nullable
    private JSExceptionHandler mExceptionHandlerWrapper;
    @Nullable
    private LayoutInflater mInflater;
    @Nullable
    protected InteropModuleRegistry mInteropModuleRegistry;
    private boolean mIsInitialized = false;
    @Nullable
    private JSExceptionHandler mJSExceptionHandler;
    @Nullable
    private MessageQueueThread mJSMessageQueueThread;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet<LifecycleEventListener> mLifecycleEventListeners = new CopyOnWriteArraySet<>();
    private LifecycleState mLifecycleState = LifecycleState.BEFORE_CREATE;
    @Nullable
    private MessageQueueThread mNativeModulesMessageQueueThread;
    @Nullable
    private ReactQueueConfiguration mQueueConfig;
    @Nullable
    private MessageQueueThread mUiMessageQueueThread;
    private final CopyOnWriteArraySet<WindowFocusChangeListener> mWindowFocusEventListeners = new CopyOnWriteArraySet<>();

    /* renamed from: com.facebook.react.bridge.ReactContext$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$common$LifecycleState;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.react.common.LifecycleState[] r0 = com.facebook.react.common.LifecycleState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$common$LifecycleState = r0
                com.facebook.react.common.LifecycleState r1 = com.facebook.react.common.LifecycleState.BEFORE_CREATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$common$LifecycleState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.common.LifecycleState r1 = com.facebook.react.common.LifecycleState.BEFORE_RESUME     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$common$LifecycleState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.common.LifecycleState r1 = com.facebook.react.common.LifecycleState.RESUMED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.ReactContext.AnonymousClass2.<clinit>():void");
        }
    }

    public class ExceptionHandlerWrapper implements JSExceptionHandler {
        public ExceptionHandlerWrapper() {
        }

        public void handleException(Exception exc) {
            ReactContext.this.handleException(exc);
        }
    }

    @a
    public interface RCTDeviceEventEmitter extends JavaScriptModule {
        void emit(@NonNull String str, @Nullable Object obj);
    }

    public ReactContext(Context context) {
        super(context);
    }

    private void onHostDestroyImpl() {
        UiThreadUtil.assertOnUiThread();
        this.mLifecycleState = LifecycleState.BEFORE_CREATE;
        Iterator<LifecycleEventListener> it = this.mLifecycleEventListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().onHostDestroy();
            } catch (RuntimeException e10) {
                handleException(e10);
            }
        }
    }

    public void addActivityEventListener(ActivityEventListener activityEventListener) {
        this.mActivityEventListeners.add(activityEventListener);
    }

    public void addLifecycleEventListener(final LifecycleEventListener lifecycleEventListener) {
        int i10;
        this.mLifecycleEventListeners.add(lifecycleEventListener);
        if ((hasActiveReactInstance() || isBridgeless()) && (i10 = AnonymousClass2.$SwitchMap$com$facebook$react$common$LifecycleState[this.mLifecycleState.ordinal()]) != 1 && i10 != 2) {
            if (i10 == 3) {
                runOnUiQueueThread(new Runnable() {
                    public void run() {
                        if (ReactContext.this.mLifecycleEventListeners.contains(lifecycleEventListener)) {
                            try {
                                lifecycleEventListener.onHostResume();
                            } catch (RuntimeException e10) {
                                ReactContext.this.handleException(e10);
                            }
                        }
                    }
                });
                return;
            }
            throw new IllegalStateException("Unhandled lifecycle state.");
        }
    }

    public void addWindowFocusChangeListener(WindowFocusChangeListener windowFocusChangeListener) {
        this.mWindowFocusEventListeners.add(windowFocusChangeListener);
    }

    public void assertOnJSQueueThread() {
        ((MessageQueueThread) p5.a.c(this.mJSMessageQueueThread)).assertIsOnThread();
    }

    public void assertOnNativeModulesQueueThread() {
        if (this.mIsInitialized) {
            ((MessageQueueThread) p5.a.c(this.mNativeModulesMessageQueueThread)).assertIsOnThread();
            return;
        }
        throw new IllegalStateException("Tried to call assertOnNativeModulesQueueThread() on an uninitialized ReactContext");
    }

    public void assertOnUiQueueThread() {
        ((MessageQueueThread) p5.a.c(this.mUiMessageQueueThread)).assertIsOnThread();
    }

    public abstract void destroy();

    public void emitDeviceEvent(String str, @Nullable Object obj) {
        RCTDeviceEventEmitter rCTDeviceEventEmitter = (RCTDeviceEventEmitter) getJSModule(RCTDeviceEventEmitter.class);
        if (rCTDeviceEventEmitter != null) {
            rCTDeviceEventEmitter.emit(str, obj);
        }
    }

    public abstract CatalystInstance getCatalystInstance();

    @Nullable
    public Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.mCurrentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public JSExceptionHandler getExceptionHandler() {
        if (this.mExceptionHandlerWrapper == null) {
            this.mExceptionHandlerWrapper = new ExceptionHandlerWrapper();
        }
        return this.mExceptionHandlerWrapper;
    }

    @Nullable
    public abstract UIManager getFabricUIManager();

    @Nullable
    public abstract CallInvokerHolder getJSCallInvokerHolder();

    public JSExceptionHandler getJSExceptionHandler() {
        return this.mJSExceptionHandler;
    }

    @Nullable
    public MessageQueueThread getJSMessageQueueThread() {
        return this.mJSMessageQueueThread;
    }

    public abstract <T extends JavaScriptModule> T getJSModule(Class<T> cls);

    @Nullable
    public abstract JavaScriptContextHolder getJavaScriptContextHolder();

    public LifecycleState getLifecycleState() {
        return this.mLifecycleState;
    }

    @Nullable
    public abstract <T extends NativeModule> T getNativeModule(Class<T> cls);

    @Nullable
    public abstract NativeModule getNativeModule(String str);

    public abstract Collection<NativeModule> getNativeModules();

    @Nullable
    public MessageQueueThread getNativeModulesMessageQueueThread() {
        return this.mNativeModulesMessageQueueThread;
    }

    @Nullable
    public abstract String getSourceURL();

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.mInflater;
    }

    @Nullable
    public MessageQueueThread getUiMessageQueueThread() {
        return this.mUiMessageQueueThread;
    }

    public abstract void handleException(Exception exc);

    @Deprecated
    public abstract boolean hasActiveCatalystInstance();

    public abstract boolean hasActiveReactInstance();

    @Deprecated
    public abstract boolean hasCatalystInstance();

    public boolean hasCurrentActivity() {
        WeakReference<Activity> weakReference = this.mCurrentActivity;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return true;
    }

    public abstract <T extends NativeModule> boolean hasNativeModule(Class<T> cls);

    public abstract boolean hasReactInstance();

    /* access modifiers changed from: protected */
    public void initializeFromOther(ReactContext reactContext) {
        if (reactContext.hasReactInstance()) {
            initializeMessageQueueThreads(reactContext.mQueueConfig);
        }
        this.mInteropModuleRegistry = reactContext.mInteropModuleRegistry;
    }

    /* access modifiers changed from: protected */
    public void initializeInteropModules() {
        this.mInteropModuleRegistry = new InteropModuleRegistry();
    }

    public synchronized void initializeMessageQueueThreads(ReactQueueConfiguration reactQueueConfiguration) {
        z2.a.b(TAG, "initializeMessageQueueThreads() is called.");
        if (this.mUiMessageQueueThread == null && this.mNativeModulesMessageQueueThread == null && this.mJSMessageQueueThread == null) {
            this.mQueueConfig = reactQueueConfiguration;
            this.mUiMessageQueueThread = reactQueueConfiguration.getUIQueueThread();
            this.mNativeModulesMessageQueueThread = reactQueueConfiguration.getNativeModulesQueueThread();
            MessageQueueThread jSQueueThread = reactQueueConfiguration.getJSQueueThread();
            this.mJSMessageQueueThread = jSQueueThread;
            if (this.mUiMessageQueueThread == null) {
                throw new IllegalStateException("UI thread is null");
            } else if (this.mNativeModulesMessageQueueThread == null) {
                throw new IllegalStateException("NativeModules thread is null");
            } else if (jSQueueThread != null) {
                this.mIsInitialized = true;
            } else {
                throw new IllegalStateException("JavaScript thread is null");
            }
        } else {
            throw new IllegalStateException("Message queue threads already initialized");
        }
    }

    public <T extends JavaScriptModule> void internal_registerInteropModule(Class<T> cls, Object obj) {
        InteropModuleRegistry interopModuleRegistry = this.mInteropModuleRegistry;
        if (interopModuleRegistry != null) {
            interopModuleRegistry.registerInteropModule(cls, obj);
        }
    }

    @Deprecated
    public abstract boolean isBridgeless();

    public boolean isOnJSQueueThread() {
        return ((MessageQueueThread) p5.a.c(this.mJSMessageQueueThread)).isOnThread();
    }

    public boolean isOnNativeModulesQueueThread() {
        return ((MessageQueueThread) p5.a.c(this.mNativeModulesMessageQueueThread)).isOnThread();
    }

    public boolean isOnUiQueueThread() {
        return ((MessageQueueThread) p5.a.c(this.mUiMessageQueueThread)).isOnThread();
    }

    public void onActivityResult(Activity activity, int i10, int i11, @Nullable Intent intent) {
        Iterator<ActivityEventListener> it = this.mActivityEventListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().onActivityResult(activity, i10, i11, intent);
            } catch (RuntimeException e10) {
                handleException(e10);
            }
        }
    }

    public void onHostDestroy() {
        onHostDestroyImpl();
        this.mCurrentActivity = null;
    }

    public void onHostPause() {
        this.mLifecycleState = LifecycleState.BEFORE_RESUME;
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_PAUSE_START);
        Iterator<LifecycleEventListener> it = this.mLifecycleEventListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().onHostPause();
            } catch (RuntimeException e10) {
                handleException(e10);
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_PAUSE_END);
    }

    public void onHostResume(@Nullable Activity activity) {
        this.mLifecycleState = LifecycleState.RESUMED;
        this.mCurrentActivity = new WeakReference<>(activity);
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_RESUME_START);
        Iterator<LifecycleEventListener> it = this.mLifecycleEventListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().onHostResume();
            } catch (RuntimeException e10) {
                handleException(e10);
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_RESUME_END);
    }

    public void onNewIntent(@Nullable Activity activity, Intent intent) {
        UiThreadUtil.assertOnUiThread();
        this.mCurrentActivity = new WeakReference<>(activity);
        Iterator<ActivityEventListener> it = this.mActivityEventListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().onNewIntent(intent);
            } catch (RuntimeException e10) {
                handleException(e10);
            }
        }
    }

    public void onWindowFocusChange(boolean z10) {
        UiThreadUtil.assertOnUiThread();
        Iterator<WindowFocusChangeListener> it = this.mWindowFocusEventListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().onWindowFocusChange(z10);
            } catch (RuntimeException e10) {
                handleException(e10);
            }
        }
    }

    public abstract void registerSegment(int i10, String str, Callback callback);

    public void removeActivityEventListener(ActivityEventListener activityEventListener) {
        this.mActivityEventListeners.remove(activityEventListener);
    }

    public void removeLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.mLifecycleEventListeners.remove(lifecycleEventListener);
    }

    public void removeWindowFocusChangeListener(WindowFocusChangeListener windowFocusChangeListener) {
        this.mWindowFocusEventListeners.remove(windowFocusChangeListener);
    }

    public void resetPerfStats() {
        MessageQueueThread messageQueueThread = this.mNativeModulesMessageQueueThread;
        if (messageQueueThread != null) {
            messageQueueThread.resetPerfStats();
        }
        MessageQueueThread messageQueueThread2 = this.mJSMessageQueueThread;
        if (messageQueueThread2 != null) {
            messageQueueThread2.resetPerfStats();
        }
    }

    public boolean runOnJSQueueThread(Runnable runnable) {
        return ((MessageQueueThread) p5.a.c(this.mJSMessageQueueThread)).runOnQueue(runnable);
    }

    public void runOnNativeModulesQueueThread(Runnable runnable) {
        ((MessageQueueThread) p5.a.c(this.mNativeModulesMessageQueueThread)).runOnQueue(runnable);
    }

    public void runOnUiQueueThread(Runnable runnable) {
        ((MessageQueueThread) p5.a.c(this.mUiMessageQueueThread)).runOnQueue(runnable);
    }

    public void setJSExceptionHandler(@Nullable JSExceptionHandler jSExceptionHandler) {
        this.mJSExceptionHandler = jSExceptionHandler;
    }

    public boolean startActivityForResult(Intent intent, int i10, Bundle bundle) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return false;
        }
        currentActivity.startActivityForResult(intent, i10, bundle);
        return true;
    }

    public void emitDeviceEvent(String str) {
        emitDeviceEvent(str, (Object) null);
    }

    public void onHostDestroy(boolean z10) {
        if (!z10) {
            onHostDestroy();
        } else {
            onHostDestroyImpl();
        }
    }

    public void assertOnNativeModulesQueueThread(String str) {
        if (this.mIsInitialized) {
            ((MessageQueueThread) p5.a.c(this.mNativeModulesMessageQueueThread)).assertIsOnThread(str);
            return;
        }
        throw new IllegalStateException("Tried to call assertOnNativeModulesQueueThread(message) on an uninitialized ReactContext");
    }
}
