package com.reactnativecommunity.webview;

import android.app.DownloadManager;
import android.net.Uri;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import s6.a;

@a(name = "RNCWebViewModule")
public class RNCWebViewModule extends ReactContextBaseJavaModule {
    private final i mRNCWebViewModuleImpl;

    public RNCWebViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mRNCWebViewModuleImpl = new i(reactApplicationContext);
    }

    public void downloadFile(String str) {
        this.mRNCWebViewModuleImpl.h(str);
    }

    @NonNull
    public String getName() {
        return "RNCWebViewModule";
    }

    public boolean grantFileDownloaderPermissions(String str, String str2) {
        return this.mRNCWebViewModuleImpl.t(str, str2);
    }

    @ReactMethod
    public void isFileUploadSupported(Promise promise) {
        promise.resolve(Boolean.valueOf(this.mRNCWebViewModuleImpl.u()));
    }

    public void setDownloadRequest(DownloadManager.Request request) {
        this.mRNCWebViewModuleImpl.x(request);
    }

    @ReactMethod
    public void shouldStartLoadWithLockIdentifier(boolean z10, double d10) {
        this.mRNCWebViewModuleImpl.y(z10, d10);
    }

    public void startPhotoPickerIntent(ValueCallback<Uri> valueCallback, String str) {
        this.mRNCWebViewModuleImpl.z(str, valueCallback);
    }

    public boolean startPhotoPickerIntent(ValueCallback<Uri[]> valueCallback, String[] strArr, boolean z10, boolean z11) {
        return this.mRNCWebViewModuleImpl.A(strArr, z10, valueCallback, z11);
    }
}
