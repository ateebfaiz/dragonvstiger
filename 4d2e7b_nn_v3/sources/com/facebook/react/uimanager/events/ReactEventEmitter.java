package com.facebook.react.uimanager.events;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import p5.a;

class ReactEventEmitter implements RCTModernEventEmitter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ReactEventEmitter";
    @Nullable
    private RCTEventEmitter mDefaultEventEmitter = null;
    @Nullable
    private RCTModernEventEmitter mFabricEventEmitter = null;
    private final ReactApplicationContext mReactContext;

    public ReactEventEmitter(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
    }

    @Nullable
    private RCTEventEmitter getDefaultEventEmitter() {
        if (this.mDefaultEventEmitter == null) {
            if (this.mReactContext.hasActiveReactInstance()) {
                this.mDefaultEventEmitter = (RCTEventEmitter) this.mReactContext.getJSModule(RCTEventEmitter.class);
            } else {
                ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot get RCTEventEmitter from Context, no active Catalyst instance!"));
            }
        }
        return this.mDefaultEventEmitter;
    }

    public void receiveEvent(int i10, String str, @Nullable WritableMap writableMap) {
        receiveEvent(-1, i10, str, writableMap);
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        a.a(writableArray.size() > 0);
        if (i7.a.a(writableArray.getMap(0).getInt("target")) == 1 && getDefaultEventEmitter() != null) {
            this.mDefaultEventEmitter.receiveTouches(str, writableArray, writableArray2);
        }
    }

    public void register(int i10, RCTModernEventEmitter rCTModernEventEmitter) {
        this.mFabricEventEmitter = rCTModernEventEmitter;
    }

    public void unregister(int i10) {
        if (i10 == 1) {
            this.mDefaultEventEmitter = null;
        } else {
            this.mFabricEventEmitter = null;
        }
    }

    public void receiveEvent(int i10, int i11, String str, @Nullable WritableMap writableMap) {
        receiveEvent(i10, i11, str, false, 0, writableMap, 2);
    }

    public void register(int i10, RCTEventEmitter rCTEventEmitter) {
        this.mDefaultEventEmitter = rCTEventEmitter;
    }

    public void receiveEvent(int i10, int i11, String str, boolean z10, int i12, @Nullable WritableMap writableMap, int i13) {
        RCTModernEventEmitter rCTModernEventEmitter;
        int i14 = i10;
        int i15 = i11;
        String str2 = str;
        int b10 = i7.a.b(i11, i10);
        if (b10 == 2 && (rCTModernEventEmitter = this.mFabricEventEmitter) != null) {
            rCTModernEventEmitter.receiveEvent(i10, i11, str, z10, i12, writableMap, i13);
        } else if (b10 == 1) {
            RCTEventEmitter defaultEventEmitter = getDefaultEventEmitter();
            if (defaultEventEmitter != null) {
                WritableMap writableMap2 = writableMap;
                defaultEventEmitter.receiveEvent(i11, str, writableMap);
            }
        } else {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot find EventEmitter for receiveEvent: SurfaceId[" + i10 + "] ReactTag[" + i11 + "] UIManagerType[" + b10 + "] EventName[" + str + "]"));
        }
    }

    public void receiveTouches(q qVar) {
        RCTModernEventEmitter rCTModernEventEmitter;
        int viewTag = qVar.getViewTag();
        int b10 = i7.a.b(qVar.getViewTag(), qVar.getSurfaceId());
        if (b10 == 2 && (rCTModernEventEmitter = this.mFabricEventEmitter) != null) {
            t.c(rCTModernEventEmitter, qVar);
        } else if (b10 != 1 || getDefaultEventEmitter() == null) {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot find EventEmitter for receivedTouches: ReactTag[" + viewTag + "] UIManagerType[" + b10 + "] EventName[" + qVar.getEventName() + "]"));
        } else {
            t.d(this.mDefaultEventEmitter, qVar);
        }
    }
}
