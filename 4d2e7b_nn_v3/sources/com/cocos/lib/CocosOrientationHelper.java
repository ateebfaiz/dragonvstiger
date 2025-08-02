package com.cocos.lib;

import android.content.Context;
import android.view.OrientationEventListener;

public class CocosOrientationHelper extends OrientationEventListener {
    /* access modifiers changed from: private */
    public int mCurrentOrientation = CocosHelper.getDeviceRotation();

    class a implements Runnable {
        a() {
        }

        public void run() {
            CocosOrientationHelper.nativeOnOrientationChanged(CocosOrientationHelper.this.mCurrentOrientation);
        }
    }

    public CocosOrientationHelper(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    public static native void nativeOnOrientationChanged(int i10);

    public void onOrientationChanged(int i10) {
        if (CocosHelper.getDeviceRotation() != this.mCurrentOrientation) {
            this.mCurrentOrientation = CocosHelper.getDeviceRotation();
            CocosHelper.runOnGameThreadAtForeground(new a());
        }
    }

    public void onPause() {
        disable();
    }

    public void onResume() {
        enable();
    }
}
