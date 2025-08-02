package com.google.androidgamesdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SwappyDisplayManager implements DisplayManager.DisplayListener {
    private final boolean DEBUG = false;
    private final String LOG_TAG = "SwappyDisplayManager";
    private final long ONE_MS_IN_NS = 1000000;
    private final long ONE_S_IN_NS = 1000000000;
    /* access modifiers changed from: private */
    public Activity mActivity;
    private long mCookie;
    private Display.Mode mCurrentMode;
    private b mLooper;
    private WindowManager mWindowManager;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8952a;

        a(int i10) {
            this.f8952a = i10;
        }

        public void run() {
            Window window = SwappyDisplayManager.this.mActivity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.preferredDisplayModeId = this.f8952a;
            window.setAttributes(attributes);
        }
    }

    private class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private Lock f8954a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f8955b;

        /* renamed from: c  reason: collision with root package name */
        private Condition f8956c;

        /* synthetic */ b(SwappyDisplayManager swappyDisplayManager, a aVar) {
            this();
        }

        public void run() {
            Log.i("SwappyDisplayManager", "Starting looper thread");
            this.f8954a.lock();
            Looper.prepare();
            this.f8955b = new Handler();
            this.f8956c.signal();
            this.f8954a.unlock();
            Looper.loop();
            Log.i("SwappyDisplayManager", "Terminating looper thread");
        }

        public void start() {
            this.f8954a.lock();
            super.start();
            try {
                this.f8956c.await();
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            this.f8954a.unlock();
        }

        private b() {
            ReentrantLock reentrantLock = new ReentrantLock();
            this.f8954a = reentrantLock;
            this.f8956c = reentrantLock.newCondition();
        }
    }

    public SwappyDisplayManager(long j10, Activity activity) {
        String string;
        try {
            Bundle bundle = activity.getPackageManager().getActivityInfo(activity.getIntent().getComponent(), 128).metaData;
            if (!(bundle == null || (string = bundle.getString(GameActivity.META_DATA_LIB_NAME)) == null)) {
                System.loadLibrary(string);
            }
        } catch (Throwable th) {
            Log.e("SwappyDisplayManager", th.getMessage());
        }
        this.mCookie = j10;
        this.mActivity = activity;
        WindowManager windowManager = (WindowManager) activity.getSystemService(WindowManager.class);
        this.mWindowManager = windowManager;
        Display defaultDisplay = windowManager.getDefaultDisplay();
        this.mCurrentMode = defaultDisplay.getMode();
        updateSupportedRefreshRates(defaultDisplay);
        DisplayManager displayManager = (DisplayManager) this.mActivity.getSystemService(DisplayManager.class);
        synchronized (this) {
            b bVar = new b(this, (a) null);
            this.mLooper = bVar;
            bVar.start();
            displayManager.registerDisplayListener(this, this.mLooper.f8955b);
        }
    }

    @TargetApi(23)
    private boolean modeMatchesCurrentResolution(Display.Mode mode) {
        if (mode.getPhysicalHeight() == this.mCurrentMode.getPhysicalHeight() && mode.getPhysicalWidth() == this.mCurrentMode.getPhysicalWidth()) {
            return true;
        }
        return false;
    }

    private native void nOnRefreshPeriodChanged(long j10, long j11, long j12, long j13);

    private native void nSetSupportedRefreshPeriods(long j10, long[] jArr, int[] iArr);

    private void updateSupportedRefreshRates(Display display) {
        Display.Mode[] supportedModes = display.getSupportedModes();
        int i10 = 0;
        for (Display.Mode modeMatchesCurrentResolution : supportedModes) {
            if (modeMatchesCurrentResolution(modeMatchesCurrentResolution)) {
                i10++;
            }
        }
        long[] jArr = new long[i10];
        int[] iArr = new int[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < supportedModes.length; i12++) {
            if (modeMatchesCurrentResolution(supportedModes[i12])) {
                jArr[i11] = (long) (1.0E9f / supportedModes[i12].getRefreshRate());
                iArr[i11] = supportedModes[i12].getModeId();
                i11++;
            }
        }
        nSetSupportedRefreshPeriods(this.mCookie, jArr, iArr);
    }

    public void onDisplayAdded(int i10) {
    }

    public void onDisplayChanged(int i10) {
        boolean z10;
        boolean z11;
        synchronized (this) {
            try {
                Display defaultDisplay = this.mWindowManager.getDefaultDisplay();
                float refreshRate = defaultDisplay.getRefreshRate();
                Display.Mode mode = defaultDisplay.getMode();
                boolean z12 = false;
                if (mode.getPhysicalWidth() != this.mCurrentMode.getPhysicalWidth()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (mode.getPhysicalHeight() != this.mCurrentMode.getPhysicalHeight()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z13 = z10 | z11;
                if (refreshRate != this.mCurrentMode.getRefreshRate()) {
                    z12 = true;
                }
                this.mCurrentMode = mode;
                if (z13) {
                    updateSupportedRefreshRates(defaultDisplay);
                }
                if (z12) {
                    long j10 = (long) (1.0E9f / refreshRate);
                    nOnRefreshPeriodChanged(this.mCookie, j10, defaultDisplay.getAppVsyncOffsetNanos(), (j10 - this.mWindowManager.getDefaultDisplay().getPresentationDeadlineNanos()) - 1000000);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onDisplayRemoved(int i10) {
    }

    public void setPreferredDisplayModeId(int i10) {
        this.mActivity.runOnUiThread(new a(i10));
    }

    public void terminate() {
        this.mLooper.f8955b.getLooper().quit();
    }
}
