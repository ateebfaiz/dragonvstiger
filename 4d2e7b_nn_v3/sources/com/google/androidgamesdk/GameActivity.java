package com.google.androidgamesdk;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;

public class GameActivity extends AppCompatActivity implements SurfaceHolder.Callback2 {
    private static final String KEY_NATIVE_SAVED_STATE = "android:native_state";
    private static final String LOG_TAG = "GameActivity";
    public static final String META_DATA_FUNC_NAME = "android.app.func_name";
    public static final String META_DATA_LIB_NAME = "android.app.lib_name";
    protected int contentViewId;
    private EditorInfo imeEditorInfo;
    private SurfaceHolder mCurSurfaceHolder;
    protected boolean mDestroyed;
    protected final int[] mLocation = new int[2];
    private long mNativeHandle;
    protected SurfaceView mSurfaceView;

    private static String getAbsolutePath(File file) {
        if (file != null) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public native String getDlError();

    public long getGameActivityNativeHandle() {
        return this.mNativeHandle;
    }

    public EditorInfo getImeEditorInfo() {
        if (this.imeEditorInfo == null) {
            EditorInfo editorInfo = new EditorInfo();
            this.imeEditorInfo = editorInfo;
            editorInfo.inputType = 0;
            editorInfo.actionId = 1;
            editorInfo.imeOptions = 1073741824;
        }
        return this.imeEditorInfo;
    }

    /* access modifiers changed from: protected */
    public native long loadNativeCode(String str, String str2, String str3, String str4, String str5, AssetManager assetManager, byte[] bArr);

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.mDestroyed) {
            onConfigurationChangedNative(this.mNativeHandle);
        }
    }

    /* access modifiers changed from: protected */
    public native void onConfigurationChangedNative(long j10);

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
            r10 = this;
            r10.onCreateSurfaceView()
            r10.onSetUpWindow()
            android.content.Intent r0 = r10.getIntent()
            java.lang.String r1 = "android.app.lib_name"
            java.lang.String r0 = r0.getStringExtra(r1)
            if (r0 == 0) goto L_0x001b
            android.content.Intent r0 = r10.getIntent()
            java.lang.String r0 = r0.getStringExtra(r1)
            goto L_0x001d
        L_0x001b:
            java.lang.String r0 = "main"
        L_0x001d:
            android.content.pm.PackageManager r2 = r10.getPackageManager()     // Catch:{ NameNotFoundException -> 0x004a }
            android.content.Intent r3 = r10.getIntent()     // Catch:{ NameNotFoundException -> 0x004a }
            android.content.ComponentName r3 = r3.getComponent()     // Catch:{ NameNotFoundException -> 0x004a }
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ActivityInfo r2 = r2.getActivityInfo(r3, r4)     // Catch:{ NameNotFoundException -> 0x004a }
            android.os.Bundle r3 = r2.metaData     // Catch:{ NameNotFoundException -> 0x004a }
            java.lang.String r4 = "GameActivity_onCreate"
            if (r3 == 0) goto L_0x0048
            java.lang.String r1 = r3.getString(r1)     // Catch:{ NameNotFoundException -> 0x004a }
            if (r1 == 0) goto L_0x003c
            r0 = r1
        L_0x003c:
            android.os.Bundle r1 = r2.metaData     // Catch:{ NameNotFoundException -> 0x004a }
            java.lang.String r2 = "android.app.func_name"
            java.lang.String r1 = r1.getString(r2)     // Catch:{ NameNotFoundException -> 0x004a }
            if (r1 == 0) goto L_0x0048
            r3 = r1
            goto L_0x004d
        L_0x0048:
            r3 = r4
            goto L_0x004d
        L_0x004a:
            r11 = move-exception
            goto L_0x00d9
        L_0x004d:
            java.lang.ClassLoader r1 = r10.getClassLoader()
            dalvik.system.BaseDexClassLoader r1 = (dalvik.system.BaseDexClassLoader) r1
            java.lang.String r9 = r1.findLibrary(r0)
            if (r9 == 0) goto L_0x00b6
            r0 = 0
            if (r11 == 0) goto L_0x0064
            java.lang.String r1 = "android:native_state"
            byte[] r1 = r11.getByteArray(r1)
            r8 = r1
            goto L_0x0065
        L_0x0064:
            r8 = r0
        L_0x0065:
            java.io.File r1 = r10.getFilesDir()
            java.lang.String r4 = getAbsolutePath(r1)
            java.io.File r1 = r10.getObbDir()
            java.lang.String r5 = getAbsolutePath(r1)
            java.io.File r0 = r10.getExternalFilesDir(r0)
            java.lang.String r6 = getAbsolutePath(r0)
            android.content.res.AssetManager r7 = r10.getAssets()
            r1 = r10
            r2 = r9
            long r0 = r1.loadNativeCode(r2, r3, r4, r5, r6, r7, r8)
            r10.mNativeHandle = r0
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0093
            super.onCreate(r11)
            return
        L_0x0093:
            java.lang.UnsatisfiedLinkError r11 = new java.lang.UnsatisfiedLinkError
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unable to load native library \""
            r0.append(r1)
            r0.append(r9)
            java.lang.String r1 = "\": "
            r0.append(r1)
            java.lang.String r1 = r10.getDlError()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        L_0x00b6:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unable to find native library "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " using classloader: "
            r2.append(r0)
            java.lang.String r0 = r1.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r11.<init>(r0)
            throw r11
        L_0x00d9:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Error getting activity info"
            r0.<init>(r1, r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.androidgamesdk.GameActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onCreateSurfaceView() {
        this.mSurfaceView = new SurfaceView(this);
        FrameLayout frameLayout = new FrameLayout(this);
        int generateViewId = View.generateViewId();
        this.contentViewId = generateViewId;
        frameLayout.setId(generateViewId);
        frameLayout.addView(this.mSurfaceView);
        setContentView((View) frameLayout);
        frameLayout.requestFocus();
        this.mSurfaceView.getHolder().addCallback(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.mDestroyed = true;
        if (this.mCurSurfaceHolder != null) {
            onSurfaceDestroyedNative(this.mNativeHandle);
            this.mCurSurfaceHolder = null;
        }
        unloadNativeCode(this.mNativeHandle);
        super.onDestroy();
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (processMotionEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (onKeyDownNative(this.mNativeHandle, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    /* access modifiers changed from: protected */
    public native boolean onKeyDownNative(long j10, KeyEvent keyEvent);

    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (onKeyUpNative(this.mNativeHandle, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    /* access modifiers changed from: protected */
    public native boolean onKeyUpNative(long j10, KeyEvent keyEvent);

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        onPauseNative(this.mNativeHandle);
    }

    /* access modifiers changed from: protected */
    public native void onPauseNative(long j10);

    public void onPointerCaptureChanged(boolean z10) {
        super.onPointerCaptureChanged(z10);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        onResumeNative(this.mNativeHandle);
    }

    /* access modifiers changed from: protected */
    public native void onResumeNative(long j10);

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        byte[] onSaveInstanceStateNative = onSaveInstanceStateNative(this.mNativeHandle);
        if (onSaveInstanceStateNative != null) {
            bundle.putByteArray(KEY_NATIVE_SAVED_STATE, onSaveInstanceStateNative);
        }
    }

    /* access modifiers changed from: protected */
    public native byte[] onSaveInstanceStateNative(long j10);

    /* access modifiers changed from: protected */
    public void onSetUpWindow() {
        getWindow().setFormat(4);
        getWindow().setSoftInputMode(16);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        onStartNative(this.mNativeHandle);
    }

    /* access modifiers changed from: protected */
    public native void onStartNative(long j10);

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        onStopNative(this.mNativeHandle);
    }

    /* access modifiers changed from: protected */
    public native void onStopNative(long j10);

    /* access modifiers changed from: protected */
    public native void onSurfaceChangedNative(long j10, Surface surface, int i10, int i11, int i12);

    /* access modifiers changed from: protected */
    public native void onSurfaceCreatedNative(long j10, Surface surface);

    /* access modifiers changed from: protected */
    public native void onSurfaceDestroyedNative(long j10);

    /* access modifiers changed from: protected */
    public native void onSurfaceRedrawNeededNative(long j10, Surface surface);

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (processMotionEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public native boolean onTouchEventNative(long j10, MotionEvent motionEvent, int i10, int i11, int i12, int i13, int i14, long j11, long j12, int i15, int i16, int i17, int i18, int i19, int i20, float f10, float f11);

    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        if (!this.mDestroyed) {
            onTrimMemoryNative(this.mNativeHandle, i10);
        }
    }

    /* access modifiers changed from: protected */
    public native void onTrimMemoryNative(long j10, int i10);

    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (!this.mDestroyed) {
            onWindowFocusChangedNative(this.mNativeHandle, z10);
        }
    }

    /* access modifiers changed from: protected */
    public native void onWindowFocusChangedNative(long j10, boolean z10);

    /* access modifiers changed from: protected */
    public native void onWindowInsetsChangedNative(long j10);

    /* access modifiers changed from: protected */
    public boolean processMotionEvent(MotionEvent motionEvent) {
        int i10;
        int i11 = Build.VERSION.SDK_INT;
        int actionButton = motionEvent.getActionButton();
        if (i11 >= 29) {
            i10 = motionEvent.getClassification();
        } else {
            i10 = 0;
        }
        return onTouchEventNative(this.mNativeHandle, motionEvent, motionEvent.getPointerCount(), motionEvent.getHistorySize(), motionEvent.getDeviceId(), motionEvent.getSource(), motionEvent.getAction(), motionEvent.getEventTime(), motionEvent.getDownTime(), motionEvent.getFlags(), motionEvent.getMetaState(), actionButton, motionEvent.getButtonState(), i10, motionEvent.getEdgeFlags(), motionEvent.getXPrecision(), motionEvent.getYPrecision());
    }

    public void setImeEditorInfo(EditorInfo editorInfo) {
        this.imeEditorInfo = editorInfo;
    }

    public void setImeEditorInfoFields(int i10, int i11, int i12) {
        EditorInfo imeEditorInfo2 = getImeEditorInfo();
        imeEditorInfo2.inputType = i10;
        imeEditorInfo2.actionId = i11;
        imeEditorInfo2.imeOptions = i12;
    }

    /* access modifiers changed from: package-private */
    public void setWindowFlags(int i10, int i11) {
        getWindow().setFlags(i10, i11);
    }

    /* access modifiers changed from: package-private */
    public void setWindowFormat(int i10) {
        getWindow().setFormat(i10);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        if (!this.mDestroyed) {
            this.mCurSurfaceHolder = surfaceHolder;
            onSurfaceChangedNative(this.mNativeHandle, surfaceHolder.getSurface(), i10, i11, i12);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!this.mDestroyed) {
            this.mCurSurfaceHolder = surfaceHolder;
            onSurfaceCreatedNative(this.mNativeHandle, surfaceHolder.getSurface());
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mCurSurfaceHolder = null;
        if (!this.mDestroyed) {
            onSurfaceDestroyedNative(this.mNativeHandle);
        }
    }

    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (!this.mDestroyed) {
            this.mCurSurfaceHolder = surfaceHolder;
            onSurfaceRedrawNeededNative(this.mNativeHandle, surfaceHolder.getSurface());
        }
    }

    public void surfaceRedrawNeededAsync(@NonNull SurfaceHolder surfaceHolder, @NonNull Runnable runnable) {
        super.surfaceRedrawNeededAsync(surfaceHolder, runnable);
    }

    /* access modifiers changed from: protected */
    public native void unloadNativeCode(long j10);
}
