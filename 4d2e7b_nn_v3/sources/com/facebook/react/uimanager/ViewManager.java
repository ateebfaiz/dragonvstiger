package com.facebook.react.uimanager;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.uimanager.t0;
import com.facebook.yoga.o;
import g7.a;
import g7.d;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public abstract class ViewManager<T extends View, C extends t0> extends BaseJavaModule {
    private static final String NAME = "ViewManager";
    @Nullable
    private HashMap<Integer, Stack<T>> mRecyclableViews = null;

    public ViewManager() {
        super((ReactApplicationContext) null);
    }

    @Nullable
    private Stack<T> getRecyclableViewStack(int i10) {
        HashMap<Integer, Stack<T>> hashMap = this.mRecyclableViews;
        if (hashMap == null) {
            return null;
        }
        if (!hashMap.containsKey(Integer.valueOf(i10))) {
            this.mRecyclableViews.put(Integer.valueOf(i10), new Stack());
        }
        return this.mRecyclableViews.get(Integer.valueOf(i10));
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(@NonNull e1 e1Var, @NonNull T t10) {
    }

    public C createShadowNodeInstance() {
        throw new RuntimeException("ViewManager subclasses must implement createShadowNodeInstance()");
    }

    @NonNull
    public T createView(int i10, @NonNull e1 e1Var, @Nullable v0 v0Var, @Nullable d1 d1Var, a aVar) {
        T createViewInstance = createViewInstance(i10, e1Var, v0Var, d1Var);
        if (createViewInstance instanceof d) {
            ((d) createViewInstance).setOnInterceptTouchEventListener(aVar);
        }
        return createViewInstance;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public T createViewInstance(int i10, @NonNull e1 e1Var, @Nullable v0 v0Var, @Nullable d1 d1Var) {
        T t10;
        Object updateState;
        Stack recyclableViewStack = getRecyclableViewStack(e1Var.c());
        if (recyclableViewStack == null || recyclableViewStack.empty()) {
            t10 = createViewInstance(e1Var);
        } else {
            t10 = recycleView(e1Var, (View) recyclableViewStack.pop());
        }
        t10.setId(i10);
        addEventEmitters(e1Var, t10);
        if (v0Var != null) {
            updateProperties(t10, v0Var);
        }
        if (!(d1Var == null || (updateState = updateState(t10, v0Var, d1Var)) == null)) {
            updateExtraData(t10, updateState);
        }
        return t10;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract T createViewInstance(@NonNull e1 e1Var);

    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public c2 getDelegate() {
        return null;
    }

    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return null;
    }

    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return null;
    }

    @Nullable
    public Map<String, Object> getExportedViewConstants() {
        return null;
    }

    @NonNull
    public abstract String getName();

    public Map<String, String> getNativeProps() {
        return e2.e(getClass(), getShadowNodeClass());
    }

    public abstract Class<? extends C> getShadowNodeClass();

    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f10, o oVar, float f11, o oVar2, @Nullable float[] fArr) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(@NonNull T t10) {
    }

    public void onDropViewInstance(@NonNull T t10) {
        Context context = t10.getContext();
        if (context == null) {
            String str = NAME;
            z2.a.j(str, "onDropViewInstance: view [" + t10.getId() + "] has a null context");
        } else if (!(context instanceof e1)) {
            String str2 = NAME;
            z2.a.j(str2, "onDropViewInstance: view [" + t10.getId() + "] has a context that is not a ThemedReactContext: " + context);
        } else {
            e1 e1Var = (e1) context;
            Stack recyclableViewStack = getRecyclableViewStack(e1Var.c());
            if (recyclableViewStack != null) {
                recyclableViewStack.push(prepareToRecycleView(e1Var, t10));
            }
        }
    }

    public void onSurfaceStopped(int i10) {
        HashMap<Integer, Stack<T>> hashMap = this.mRecyclableViews;
        if (hashMap != null) {
            hashMap.remove(Integer.valueOf(i10));
        }
    }

    /* access modifiers changed from: protected */
    public T prepareToRecycleView(@NonNull e1 e1Var, @NonNull T t10) {
        return t10;
    }

    @Deprecated
    public void receiveCommand(@NonNull T t10, int i10, @Nullable ReadableArray readableArray) {
    }

    /* access modifiers changed from: protected */
    public T recycleView(@NonNull e1 e1Var, @NonNull T t10) {
        return t10;
    }

    public void setPadding(T t10, int i10, int i11, int i12, int i13) {
    }

    /* access modifiers changed from: protected */
    public void setupViewRecycling() {
        if (ReactFeatureFlags.enableViewRecycling) {
            this.mRecyclableViews = new HashMap<>();
        }
    }

    /* access modifiers changed from: package-private */
    public void trimMemory() {
        if (this.mRecyclableViews != null) {
            this.mRecyclableViews = new HashMap<>();
        }
    }

    public abstract void updateExtraData(@NonNull T t10, Object obj);

    public void updateProperties(@NonNull T t10, v0 v0Var) {
        c2 delegate = getDelegate();
        if (delegate != null) {
            e2.h(delegate, t10, v0Var);
        } else {
            e2.g(this, t10, v0Var);
        }
        onAfterUpdateTransaction(t10);
    }

    @Nullable
    public Object updateState(@NonNull T t10, v0 v0Var, d1 d1Var) {
        return null;
    }

    @NonNull
    public C createShadowNodeInstance(@NonNull ReactApplicationContext reactApplicationContext) {
        return createShadowNodeInstance();
    }

    public long measure(Context context, com.facebook.react.common.mapbuffer.a aVar, com.facebook.react.common.mapbuffer.a aVar2, @Nullable com.facebook.react.common.mapbuffer.a aVar3, float f10, o oVar, float f11, o oVar2, @Nullable float[] fArr) {
        return 0;
    }

    public void receiveCommand(@NonNull T t10, String str, @Nullable ReadableArray readableArray) {
        c2 delegate = getDelegate();
        if (delegate != null) {
            delegate.a(t10, str, readableArray);
        }
    }

    public ViewManager(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
