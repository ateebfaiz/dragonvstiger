package com.alpha0010.fs;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReadableMap;
import java.util.Map;
import kotlin.jvm.internal.m;

public abstract class FileAccessSpec extends ReactContextBaseJavaModule {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileAccessSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        m.f(reactApplicationContext, "context");
    }

    public abstract void addListener(String str);

    public abstract void appendFile(String str, String str2, String str3, Promise promise);

    public abstract void cancelFetch(double d10, Promise promise);

    public abstract void concatFiles(String str, String str2, Promise promise);

    public abstract void cp(String str, String str2, Promise promise);

    public abstract void cpAsset(String str, String str2, String str3, Promise promise);

    public abstract void cpExternal(String str, String str2, String str3, Promise promise);

    public abstract void df(Promise promise);

    public abstract void exists(String str, Promise promise);

    public abstract void fetch(double d10, String str, ReadableMap readableMap);

    public abstract void getAppGroupDir(String str, Promise promise);

    public Map<String, String> getConstants() {
        return getTypedExportedConstants();
    }

    /* access modifiers changed from: protected */
    public abstract Map<String, String> getTypedExportedConstants();

    public abstract void hash(String str, String str2, Promise promise);

    public abstract void isDir(String str, Promise promise);

    public abstract void ls(String str, Promise promise);

    public abstract void mkdir(String str, Promise promise);

    public abstract void mv(String str, String str2, Promise promise);

    public abstract void readFile(String str, String str2, Promise promise);

    public abstract void readFileChunk(String str, double d10, double d11, String str2, Promise promise);

    public abstract void removeListeners(double d10);

    public abstract void stat(String str, Promise promise);

    public abstract void statDir(String str, Promise promise);

    public abstract void unlink(String str, Promise promise);

    public abstract void unzip(String str, String str2, Promise promise);

    public abstract void writeFile(String str, String str2, String str3, Promise promise);
}
