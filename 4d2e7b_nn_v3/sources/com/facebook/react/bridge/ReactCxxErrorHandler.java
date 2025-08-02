package com.facebook.react.bridge;

import d6.a;
import java.lang.reflect.Method;

@a
public class ReactCxxErrorHandler {
    private static Method mHandleErrorFunc;
    private static Object mObject;

    @a
    private static void handleError(String str) {
        if (mHandleErrorFunc != null) {
            try {
                mHandleErrorFunc.invoke(mObject, new Object[]{new Exception(str)});
            } catch (Exception e10) {
                z2.a.k("ReactCxxErrorHandler", "Failed to invoke error handler function", e10);
            }
        }
    }

    @a
    public static void setHandleErrorFunc(Object obj, Method method) {
        mObject = obj;
        mHandleErrorFunc = method;
    }
}
