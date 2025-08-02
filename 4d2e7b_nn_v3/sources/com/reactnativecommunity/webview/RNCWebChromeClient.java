package com.reactnativecommunity.webview;

import android.app.Activity;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.k1;
import com.google.android.gms.common.internal.ImagesContract;
import com.reactnativecommunity.webview.RNCWebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import va.e;
import w6.g;
import w6.h;

public class RNCWebChromeClient extends WebChromeClient implements LifecycleEventListener {
    protected static final int COMMON_PERMISSION_REQUEST = 3;
    protected static final FrameLayout.LayoutParams FULLSCREEN_LAYOUT_PARAMS = new FrameLayout.LayoutParams(-1, -1, 17);
    protected static final int FULLSCREEN_SYSTEM_UI_VISIBILITY = 7942;
    protected GeolocationPermissions.Callback geolocationPermissionCallback;
    protected String geolocationPermissionOrigin;
    protected List<String> grantedPermissions;
    protected boolean mAllowsProtectedMedia = false;
    protected WebChromeClient.CustomViewCallback mCustomViewCallback;
    protected boolean mHasOnOpenWindowEvent = false;
    protected View mVideoView;
    protected RNCWebView mWebView;
    protected List<String> pendingPermissions = new ArrayList();
    protected PermissionRequest permissionRequest;
    protected boolean permissionsRequestShown = false;
    protected RNCWebView.c progressChangedFilter = null;
    private h webviewPermissionsListener = new b(this);

    class a extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebView f11239a;

        a(WebView webView) {
            this.f11239a = webView;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("targetUrl", str);
            WebView webView2 = this.f11239a;
            ((RNCWebView) webView2).g(webView2, new va.h(RNCWebViewWrapper.a(this.f11239a), createMap));
            return true;
        }
    }

    public RNCWebChromeClient(RNCWebView rNCWebView) {
        this.mWebView = rNCWebView;
    }

    private g getPermissionAwareActivity() {
        Activity currentActivity = this.mWebView.getThemedReactContext().getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
        } else if (currentActivity instanceof g) {
            return (g) currentActivity;
        } else {
            throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(int i10, String[] strArr, int[] iArr) {
        PermissionRequest permissionRequest2;
        List<String> list;
        boolean z10;
        List<String> list2;
        List<String> list3;
        List<String> list4;
        GeolocationPermissions.Callback callback;
        String str;
        this.permissionsRequestShown = false;
        boolean z11 = false;
        for (int i11 = 0; i11 < strArr.length; i11++) {
            String str2 = strArr[i11];
            if (iArr[i11] == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!(!str2.equals("android.permission.ACCESS_FINE_LOCATION") || (callback = this.geolocationPermissionCallback) == null || (str = this.geolocationPermissionOrigin) == null)) {
                if (z10) {
                    callback.invoke(str, true, false);
                } else {
                    callback.invoke(str, false, false);
                }
                this.geolocationPermissionCallback = null;
                this.geolocationPermissionOrigin = null;
            }
            if (str2.equals("android.permission.RECORD_AUDIO")) {
                if (z10 && (list4 = this.grantedPermissions) != null) {
                    list4.add("android.webkit.resource.AUDIO_CAPTURE");
                }
                z11 = true;
            }
            if (str2.equals("android.permission.CAMERA")) {
                if (z10 && (list3 = this.grantedPermissions) != null) {
                    list3.add("android.webkit.resource.VIDEO_CAPTURE");
                }
                z11 = true;
            }
            if (str2.equals("android.webkit.resource.PROTECTED_MEDIA_ID")) {
                if (z10 && (list2 = this.grantedPermissions) != null) {
                    list2.add("android.webkit.resource.PROTECTED_MEDIA_ID");
                }
                z11 = true;
            }
        }
        if (!(!z11 || (permissionRequest2 = this.permissionRequest) == null || (list = this.grantedPermissions) == null)) {
            permissionRequest2.grant((String[]) list.toArray(new String[0]));
            this.permissionRequest = null;
            this.grantedPermissions = null;
        }
        if (this.pendingPermissions.isEmpty()) {
            return true;
        }
        requestPermissions(this.pendingPermissions);
        return false;
    }

    private synchronized void requestPermissions(List<String> list) {
        if (this.permissionsRequestShown) {
            this.pendingPermissions.addAll(list);
            return;
        }
        g permissionAwareActivity = getPermissionAwareActivity();
        this.permissionsRequestShown = true;
        permissionAwareActivity.requestPermissions((String[]) list.toArray(new String[0]), 3, this.webviewPermissionsListener);
        this.pendingPermissions.clear();
    }

    /* access modifiers changed from: protected */
    public ViewGroup getRootView() {
        return (ViewGroup) this.mWebView.getThemedReactContext().getCurrentActivity().findViewById(16908290);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return true;
    }

    public boolean onCreateWindow(WebView webView, boolean z10, boolean z11, Message message) {
        WebView webView2 = new WebView(webView.getContext());
        if (this.mHasOnOpenWindowEvent) {
            webView2.setWebViewClient(new a(webView));
        }
        ((WebView.WebViewTransport) message.obj).setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        if (ContextCompat.checkSelfPermission(this.mWebView.getThemedReactContext(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
            this.geolocationPermissionCallback = callback;
            this.geolocationPermissionOrigin = str;
            requestPermissions(Collections.singletonList("android.permission.ACCESS_FINE_LOCATION"));
            return;
        }
        callback.invoke(str, true, false);
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    public void onHostResume() {
        View view = this.mVideoView;
        if (view != null && view.getSystemUiVisibility() != FULLSCREEN_SYSTEM_UI_VISIBILITY) {
            this.mVideoView.setSystemUiVisibility(FULLSCREEN_SYSTEM_UI_VISIBILITY);
        }
    }

    public void onPermissionRequest(PermissionRequest permissionRequest2) {
        this.grantedPermissions = new ArrayList();
        ArrayList arrayList = new ArrayList();
        String[] resources = permissionRequest2.getResources();
        int length = resources.length;
        int i10 = 0;
        while (true) {
            String str = null;
            if (i10 >= length) {
                break;
            }
            String str2 = resources[i10];
            if (str2.equals("android.webkit.resource.AUDIO_CAPTURE")) {
                str = "android.permission.RECORD_AUDIO";
            } else if (str2.equals("android.webkit.resource.VIDEO_CAPTURE")) {
                str = "android.permission.CAMERA";
            } else if (str2.equals("android.webkit.resource.PROTECTED_MEDIA_ID")) {
                if (this.mAllowsProtectedMedia) {
                    this.grantedPermissions.add(str2);
                } else {
                    str = "android.webkit.resource.PROTECTED_MEDIA_ID";
                }
            }
            if (str != null) {
                if (ContextCompat.checkSelfPermission(this.mWebView.getThemedReactContext(), str) == 0) {
                    this.grantedPermissions.add(str2);
                } else {
                    arrayList.add(str);
                }
            }
            i10++;
        }
        if (arrayList.isEmpty()) {
            permissionRequest2.grant((String[]) this.grantedPermissions.toArray(new String[0]));
            this.grantedPermissions = null;
            return;
        }
        this.permissionRequest = permissionRequest2;
        requestPermissions(arrayList);
    }

    public void onProgressChanged(WebView webView, int i10) {
        super.onProgressChanged(webView, i10);
        String url = webView.getUrl();
        if (!this.progressChangedFilter.a()) {
            int a10 = RNCWebViewWrapper.a(webView);
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("target", (double) a10);
            createMap.putString("title", webView.getTitle());
            createMap.putString(ImagesContract.URL, url);
            createMap.putBoolean("canGoBack", webView.canGoBack());
            createMap.putBoolean("canGoForward", webView.canGoForward());
            createMap.putDouble(NotificationCompat.CATEGORY_PROGRESS, (double) (((float) i10) / 100.0f));
            k1.c(this.mWebView.getThemedReactContext(), a10).c(new e(a10, createMap));
        }
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        String[] acceptTypes = fileChooserParams.getAcceptTypes();
        boolean z10 = true;
        if (fileChooserParams.getMode() != 1) {
            z10 = false;
        }
        return ((RNCWebViewModule) this.mWebView.getThemedReactContext().getNativeModule(RNCWebViewModule.class)).startPhotoPickerIntent(valueCallback, acceptTypes, z10, fileChooserParams.isCaptureEnabled());
    }

    /* access modifiers changed from: protected */
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        ((RNCWebViewModule) this.mWebView.getThemedReactContext().getNativeModule(RNCWebViewModule.class)).startPhotoPickerIntent(valueCallback, str);
    }

    public void setAllowsProtectedMedia(boolean z10) {
        this.mAllowsProtectedMedia = z10;
    }

    public void setHasOnOpenWindowEvent(boolean z10) {
        this.mHasOnOpenWindowEvent = z10;
    }

    public void setProgressChangedFilter(RNCWebView.c cVar) {
        this.progressChangedFilter = cVar;
    }

    /* access modifiers changed from: protected */
    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        ((RNCWebViewModule) this.mWebView.getThemedReactContext().getNativeModule(RNCWebViewModule.class)).startPhotoPickerIntent(valueCallback, "");
    }

    /* access modifiers changed from: protected */
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        ((RNCWebViewModule) this.mWebView.getThemedReactContext().getNativeModule(RNCWebViewModule.class)).startPhotoPickerIntent(valueCallback, str);
    }
}
