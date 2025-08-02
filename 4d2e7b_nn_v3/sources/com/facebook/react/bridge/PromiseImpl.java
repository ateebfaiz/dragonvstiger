package com.facebook.react.bridge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d6.a;

@a
public class PromiseImpl implements Promise {
    private static final String ERROR_DEFAULT_CODE = "EUNSPECIFIED";
    private static final String ERROR_DEFAULT_MESSAGE = "Error not specified.";
    private static final String ERROR_MAP_KEY_CODE = "code";
    private static final String ERROR_MAP_KEY_MESSAGE = "message";
    private static final String ERROR_MAP_KEY_NAME = "name";
    private static final String ERROR_MAP_KEY_NATIVE_STACK = "nativeStackAndroid";
    private static final String ERROR_MAP_KEY_USER_INFO = "userInfo";
    private static final int ERROR_STACK_FRAME_LIMIT = 50;
    private static final String STACK_FRAME_KEY_CLASS = "class";
    private static final String STACK_FRAME_KEY_FILE = "file";
    private static final String STACK_FRAME_KEY_LINE_NUMBER = "lineNumber";
    private static final String STACK_FRAME_KEY_METHOD_NAME = "methodName";
    @Nullable
    private Callback mReject;
    @Nullable
    private Callback mResolve;

    @a
    public PromiseImpl(@Nullable Callback callback, @Nullable Callback callback2) {
        this.mResolve = callback;
        this.mReject = callback2;
    }

    public void reject(String str, String str2) {
        reject(str, str2, (Throwable) null, (WritableMap) null);
    }

    public void resolve(Object obj) {
        Callback callback = this.mResolve;
        if (callback != null) {
            callback.invoke(obj);
            this.mResolve = null;
            this.mReject = null;
        }
    }

    public void reject(String str, Throwable th) {
        reject(str, (String) null, th, (WritableMap) null);
    }

    public void reject(String str, String str2, Throwable th) {
        reject(str, str2, th, (WritableMap) null);
    }

    public void reject(Throwable th) {
        reject((String) null, (String) null, th, (WritableMap) null);
    }

    public void reject(Throwable th, WritableMap writableMap) {
        reject((String) null, (String) null, th, writableMap);
    }

    public void reject(String str, @NonNull WritableMap writableMap) {
        reject(str, (String) null, (Throwable) null, writableMap);
    }

    public void reject(String str, Throwable th, WritableMap writableMap) {
        reject(str, (String) null, th, writableMap);
    }

    public void reject(String str, String str2, @NonNull WritableMap writableMap) {
        reject(str, str2, (Throwable) null, writableMap);
    }

    public void reject(@Nullable String str, @Nullable String str2, @Nullable Throwable th, @Nullable WritableMap writableMap) {
        if (this.mReject == null) {
            this.mResolve = null;
            return;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (str == null) {
            writableNativeMap.putString("code", ERROR_DEFAULT_CODE);
        } else {
            writableNativeMap.putString("code", str);
        }
        if (str2 != null) {
            writableNativeMap.putString(ERROR_MAP_KEY_MESSAGE, str2);
        } else if (th != null) {
            String message = th.getMessage();
            if (message == null || message.isEmpty()) {
                message = th.getClass().getCanonicalName();
            }
            writableNativeMap.putString(ERROR_MAP_KEY_MESSAGE, message);
        } else {
            writableNativeMap.putString(ERROR_MAP_KEY_MESSAGE, ERROR_DEFAULT_MESSAGE);
        }
        if (writableMap != null) {
            writableNativeMap.putMap(ERROR_MAP_KEY_USER_INFO, writableMap);
        } else {
            writableNativeMap.putNull(ERROR_MAP_KEY_USER_INFO);
        }
        if (th != null) {
            writableNativeMap.putString("name", th.getClass().getCanonicalName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            int i10 = 0;
            while (i10 < stackTrace.length && i10 < 50) {
                StackTraceElement stackTraceElement = stackTrace[i10];
                WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                writableNativeMap2.putString(STACK_FRAME_KEY_CLASS, stackTraceElement.getClassName());
                writableNativeMap2.putString(STACK_FRAME_KEY_FILE, stackTraceElement.getFileName());
                writableNativeMap2.putInt(STACK_FRAME_KEY_LINE_NUMBER, stackTraceElement.getLineNumber());
                writableNativeMap2.putString(STACK_FRAME_KEY_METHOD_NAME, stackTraceElement.getMethodName());
                writableNativeArray.pushMap(writableNativeMap2);
                i10++;
            }
            writableNativeMap.putArray(ERROR_MAP_KEY_NATIVE_STACK, writableNativeArray);
        } else {
            writableNativeMap.putArray(ERROR_MAP_KEY_NATIVE_STACK, new WritableNativeArray());
        }
        this.mReject.invoke(writableNativeMap);
        this.mResolve = null;
        this.mReject = null;
    }

    @Deprecated
    public void reject(String str) {
        reject((String) null, str, (Throwable) null, (WritableMap) null);
    }
}
