package com.sensorsdata.analytics.android.sdk;

import android.content.Context;
import android.view.OrientationEventListener;

public class SensorsDataScreenOrientationDetector extends OrientationEventListener {
    private int mCurrentOrientation;
    private boolean mEnableState = true;

    public SensorsDataScreenOrientationDetector(Context context, int i10) {
        super(context, i10);
    }

    public String getOrientation() {
        if (!this.mEnableState) {
            return null;
        }
        int i10 = this.mCurrentOrientation;
        if (i10 == 0 || i10 == 180) {
            return "portrait";
        }
        if (i10 == 90 || i10 == 270) {
            return "landscape";
        }
        return null;
    }

    public boolean isEnableState() {
        return this.mEnableState;
    }

    public void onOrientationChanged(int i10) {
        if (i10 != -1) {
            if (i10 < 45 || i10 > 315) {
                this.mCurrentOrientation = 0;
            } else if (i10 > 45 && i10 < 135) {
                this.mCurrentOrientation = 90;
            } else if (i10 > 135 && i10 < 225) {
                this.mCurrentOrientation = 180;
            } else if (i10 > 225 && i10 < 315) {
                this.mCurrentOrientation = 270;
            }
        }
    }

    public void setState(boolean z10) {
        this.mEnableState = z10;
    }
}
