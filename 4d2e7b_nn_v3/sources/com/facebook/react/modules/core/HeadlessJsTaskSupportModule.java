package com.facebook.react.modules.core;

import com.facebook.fbreact.specs.NativeHeadlessJsTaskSupportSpec;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import r6.c;
import s6.a;

@a(name = "HeadlessJsTaskSupport")
public class HeadlessJsTaskSupportModule extends NativeHeadlessJsTaskSupportSpec {
    public HeadlessJsTaskSupportModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void notifyTaskFinished(double d10) {
        int i10 = (int) d10;
        c e10 = c.e(getReactApplicationContext());
        if (e10.g(i10)) {
            e10.h(i10);
            return;
        }
        z2.a.E(HeadlessJsTaskSupportModule.class, "Tried to finish non-active task with id %d. Did it time out?", Integer.valueOf(i10));
    }

    public void notifyTaskRetry(double d10, Promise promise) {
        int i10 = (int) d10;
        c e10 = c.e(getReactApplicationContext());
        if (e10.g(i10)) {
            promise.resolve(Boolean.valueOf(e10.k(i10)));
            return;
        }
        z2.a.E(HeadlessJsTaskSupportModule.class, "Tried to retry non-active task with id %d. Did it time out?", Integer.valueOf(i10));
        promise.resolve(Boolean.FALSE);
    }
}
