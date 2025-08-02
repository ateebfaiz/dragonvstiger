package com.facebook.react.runtime;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.a0;
import com.facebook.react.devsupport.x0;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import e6.j;
import java.util.Map;
import k6.c;
import k6.h;
import k6.i;

class b extends a0 {
    private final ReactHostImpl F;

    class a implements x0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReactHostImpl f3431a;

        a(ReactHostImpl reactHostImpl) {
            this.f3431a = reactHostImpl;
        }

        public View a(String str) {
            Activity j10 = j();
            if (j10 == null || this.f3431a.F0(str)) {
                return null;
            }
            d1 e10 = d1.e(j10, str, new Bundle());
            e10.b(this.f3431a);
            e10.start();
            return e10.getView();
        }

        public void d(View view) {
        }

        public void h() {
            ReactContext h02 = this.f3431a.h0();
            if (h02 != null) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) h02.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("toggleElementInspector", (Object) null);
            }
        }

        public Activity j() {
            return this.f3431a.o0();
        }

        public JavaScriptExecutorFactory k() {
            throw new IllegalStateException("Not implemented for bridgeless mode");
        }
    }

    public b(ReactHostImpl reactHostImpl, Context context, String str) {
        super(context.getApplicationContext(), T0(reactHostImpl), str, true, (i) null, (k6.b) null, 2, (Map) null, (j) null, (c) null, (h) null);
        this.F = reactHostImpl;
    }

    private static x0 T0(ReactHostImpl reactHostImpl) {
        return new a(reactHostImpl);
    }

    /* access modifiers changed from: protected */
    public String p0() {
        return "Bridgeless";
    }

    public void r() {
        UiThreadUtil.assertOnUiThread();
        p();
        this.F.g("BridgelessDevSupportManager.handleReloadJS()");
    }
}
