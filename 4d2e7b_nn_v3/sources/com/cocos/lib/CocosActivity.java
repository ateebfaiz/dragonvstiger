package com.cocos.lib;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import com.google.androidgamesdk.GameActivity;
import java.util.ArrayList;
import java.util.List;

public class CocosActivity extends GameActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INITIAL_ROTATION = -1;
    private static final String TAG = "CocosActivity";
    public final int REQUEST_CODE_FILE_CHOOSER = 888;
    /* access modifiers changed from: private */
    public FrameLayout mRootLayout;
    private int mRotation = -1;
    private CocosSensorHandler mSensorHandler;
    /* access modifiers changed from: private */
    public List<CocosSurfaceView> mSurfaceViewArray;
    public ValueCallback<Uri> mUploadCallBack;
    public ValueCallback<Uri[]> mUploadCallBackAboveL;
    private CocosVideoHelper mVideoHelper = null;
    private CocosWebViewHelper mWebViewHelper = null;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19213a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f19214b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19215c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f19216d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f19217e;

        a(int i10, int i11, int i12, int i13, int i14) {
            this.f19213a = i10;
            this.f19214b = i11;
            this.f19215c = i12;
            this.f19216d = i13;
            this.f19217e = i14;
        }

        public void run() {
            CocosSurfaceView cocosSurfaceView = new CocosSurfaceView(CocosActivity.this, this.f19213a);
            cocosSurfaceView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f19214b, this.f19215c);
            layoutParams.leftMargin = this.f19216d;
            layoutParams.topMargin = this.f19217e;
            CocosActivity.this.mRootLayout.addView(cocosSurfaceView, layoutParams);
            if (CocosActivity.this.mSurfaceViewArray == null) {
                CocosActivity.this.mSurfaceViewArray = new ArrayList();
            }
            CocosActivity.this.mSurfaceViewArray.add(cocosSurfaceView);
        }
    }

    private void clearUploadMessage() {
        ValueCallback<Uri[]> valueCallback = this.mUploadCallBackAboveL;
        if (valueCallback != null) {
            valueCallback.onReceiveValue((Object) null);
            this.mUploadCallBackAboveL = null;
        }
        ValueCallback<Uri> valueCallback2 = this.mUploadCallBack;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue((Object) null);
            this.mUploadCallBack = null;
        }
    }

    private void createSurface(int i10, int i11, int i12, int i13, int i14) {
        runOnUiThread(new a(i14, i12, i13, i10, i11));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$0(View view, MotionEvent motionEvent) {
        return processMotionEvent(motionEvent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$1(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int deviceRotation = CocosHelper.getDeviceRotation();
        if (this.mRotation != deviceRotation) {
            this.mRotation = deviceRotation;
            onConfigurationChangedNative(getGameActivityNativeHandle());
        }
    }

    private native void onCreateNative();

    private void onLoadNativeLibraries() {
        try {
            String string = getPackageManager().getApplicationInfo(getPackageName(), 128).metaData.getString(GameActivity.META_DATA_LIB_NAME);
            if (TextUtils.isEmpty(string)) {
                Log.e(TAG, "can not find library, please config android.app.lib_name at AndroidManifest.xml");
            }
            System.loadLibrary(string);
            getIntent().putExtra(GameActivity.META_DATA_LIB_NAME, string);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void setImmersiveMode() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        try {
            attributes.getClass().getField("layoutInDisplayCutoutMode").setInt(attributes, attributes.getClass().getDeclaredField("LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES").getInt((Object) null));
            getWindow().getDecorView().setSystemUiVisibility(View.class.getDeclaredField("SYSTEM_UI_FLAG_IMMERSIVE_STICKY").getInt((Object) null) | 1798);
        } catch (IllegalAccessException | NoSuchFieldException e10) {
            e10.printStackTrace();
        }
    }

    public SurfaceView getSurfaceView() {
        return this.mSurfaceView;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.mRootLayout = (FrameLayout) findViewById(this.contentViewId);
        if (this.mWebViewHelper == null) {
            this.mWebViewHelper = new CocosWebViewHelper(this.mRootLayout);
        }
        if (this.mVideoHelper == null) {
            this.mVideoHelper = new CocosVideoHelper(this, this.mRootLayout);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        Uri uri;
        ValueCallback<Uri[]> valueCallback;
        if (i10 == 888) {
            if (intent == null || i11 != -1) {
                uri = null;
            } else {
                uri = intent.getData();
            }
            if (uri == null || (valueCallback = this.mUploadCallBackAboveL) == null) {
                clearUploadMessage();
                return;
            }
            valueCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i11, intent));
            this.mUploadCallBackAboveL = null;
            return;
        }
        super.onActivityResult(i10, i11, intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        onLoadNativeLibraries();
        onCreateNative();
        getWindow().requestFeature(1);
        super.onCreate(bundle);
        GlobalObject.init(this, this);
        CocosHelper.registerBatteryLevelReceiver(this);
        CocosHelper.init();
        CocosAudioFocusManager.n(this);
        CanvasRenderingContext2DImpl.init(this);
        setVolumeControlStream(3);
        getWindow().setSoftInputMode(48);
        initView();
        this.mSensorHandler = new CocosSensorHandler(this);
        setImmersiveMode();
        Utils.hideVirtualButton();
        this.mSurfaceView.setOnTouchListener(new b(this));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        CocosHelper.unregisterBatteryLevelReceiver(this);
        CocosAudioFocusManager.o(this);
        CanvasRenderingContext2DImpl.destroy();
        GlobalObject.destroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mSensorHandler.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mSensorHandler.onResume();
        Utils.hideVirtualButton();
        if (CocosAudioFocusManager.g()) {
            CocosAudioFocusManager.n(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mSurfaceView.setVisibility(0);
        List<CocosSurfaceView> list = this.mSurfaceViewArray;
        if (list != null) {
            for (CocosSurfaceView visibility : list) {
                visibility.setVisibility(0);
            }
        }
        if (this.mRotation == -1 && getRequestedOrientation() == 6) {
            this.mRotation = CocosHelper.getDeviceRotation();
            this.mSurfaceView.addOnLayoutChangeListener(new a(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mSurfaceView.setVisibility(4);
        List<CocosSurfaceView> list = this.mSurfaceViewArray;
        if (list != null) {
            for (CocosSurfaceView visibility : list) {
                visibility.setVisibility(4);
            }
        }
    }

    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
    }

    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10 && CocosAudioFocusManager.g()) {
            CocosAudioFocusManager.n(this);
        }
    }
}
