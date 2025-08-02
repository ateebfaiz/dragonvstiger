package com.facebook.react.uimanager;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.util.List;
import s6.a;

@a(name = "UIManager")
public class ReanimatedUIManager extends UIManagerModule {
    public ReanimatedUIManager(ReactApplicationContext reactApplicationContext, List<ViewManager> list, int i10) {
        super(reactApplicationContext, list, i10);
    }

    public boolean canOverrideExistingModule() {
        return true;
    }

    @ReactMethod
    public void clearJSResponder() {
        super.clearJSResponder();
    }

    @ReactMethod
    public void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback, Callback callback2) {
        super.configureNextLayoutAnimation(readableMap, callback, callback2);
    }

    @ReactMethod
    public void createView(int i10, String str, int i11, ReadableMap readableMap) {
        super.createView(i10, str, i11, readableMap);
    }

    @ReactMethod
    public void dispatchViewManagerCommand(int i10, Dynamic dynamic, @Nullable ReadableArray readableArray) {
        super.dispatchViewManagerCommand(i10, dynamic, readableArray);
    }

    @ReactMethod
    public void findSubviewIn(int i10, ReadableArray readableArray, Callback callback) {
        super.findSubviewIn(i10, readableArray, callback);
    }

    @Nullable
    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getConstantsForViewManager(@Nullable String str) {
        return super.getConstantsForViewManager(str);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getDefaultEventTypes() {
        return super.getDefaultEventTypes();
    }

    @ReactMethod
    public void manageChildren(int i10, @Nullable ReadableArray readableArray, @Nullable ReadableArray readableArray2, @Nullable ReadableArray readableArray3, @Nullable ReadableArray readableArray4, @Nullable ReadableArray readableArray5) {
        super.manageChildren(i10, readableArray, readableArray2, readableArray3, readableArray4, readableArray5);
    }

    @ReactMethod
    public void measure(int i10, Callback callback) {
        super.measure(i10, callback);
    }

    @ReactMethod
    public void measureInWindow(int i10, Callback callback) {
        super.measureInWindow(i10, callback);
    }

    @ReactMethod
    public void measureLayout(int i10, int i11, Callback callback, Callback callback2) {
        super.measureLayout(i10, i11, callback, callback2);
    }

    public void onBatchComplete() {
        super.onBatchComplete();
    }

    @ReactMethod
    public void removeRootView(int i10) {
        super.removeRootView(i10);
    }

    @ReactMethod
    public void sendAccessibilityEvent(int i10, int i11) {
        super.sendAccessibilityEvent(i10, i11);
    }

    @ReactMethod
    public void setChildren(int i10, ReadableArray readableArray) {
        super.setChildren(i10, readableArray);
    }

    @ReactMethod
    public void setJSResponder(int i10, boolean z10) {
        super.setJSResponder(i10, z10);
    }

    @ReactMethod
    public void setLayoutAnimationEnabledExperimental(boolean z10) {
        super.setLayoutAnimationEnabledExperimental(z10);
    }

    @ReactMethod
    public void updateView(int i10, String str, ReadableMap readableMap) {
        super.updateView(i10, str, readableMap);
    }

    @Deprecated
    @ReactMethod
    public void viewIsDescendantOf(int i10, int i11, Callback callback) {
        super.viewIsDescendantOf(i10, i11, callback);
    }
}
