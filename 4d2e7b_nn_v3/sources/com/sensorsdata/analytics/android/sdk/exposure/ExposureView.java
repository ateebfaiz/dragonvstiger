package com.sensorsdata.analytics.android.sdk.exposure;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData;
import java.lang.ref.WeakReference;

public class ExposureView implements Cloneable {
    private final long addTime;
    private boolean exposed;
    private SAExposureData exposureData;
    private boolean isActivityChange;
    private boolean isAddExposureView = false;
    private boolean isViewLayoutChange;
    private boolean lastVisible;
    private WeakReference<View> viewWeakReference;

    public ExposureView(SAExposureData sAExposureData, boolean z10, boolean z11, View view) {
        this.exposureData = sAExposureData;
        this.lastVisible = z10;
        this.exposed = z11;
        this.viewWeakReference = new WeakReference<>(view);
        this.addTime = System.nanoTime();
    }

    public long getAddTime() {
        return this.addTime;
    }

    public SAExposureData getExposureData() {
        return this.exposureData;
    }

    public View getView() {
        WeakReference<View> weakReference = this.viewWeakReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean isActivityChange() {
        return this.isActivityChange;
    }

    public boolean isAddExposureView() {
        return this.isAddExposureView;
    }

    public boolean isExposed() {
        return this.exposed;
    }

    public boolean isLastVisible() {
        return this.lastVisible;
    }

    public boolean isViewLayoutChange() {
        return this.isViewLayoutChange;
    }

    public void setActivityChange(boolean z10) {
        this.isActivityChange = z10;
    }

    public void setAddExposureView(boolean z10) {
        this.isAddExposureView = z10;
    }

    public void setExposed(boolean z10) {
        this.exposed = z10;
    }

    public void setExposureData(SAExposureData sAExposureData) {
        this.exposureData = sAExposureData;
    }

    public void setLastVisible(boolean z10) {
        this.lastVisible = z10;
    }

    public void setView(View view) {
        this.viewWeakReference = new WeakReference<>(view);
    }

    public void setViewLayoutChange(boolean z10) {
        this.isViewLayoutChange = z10;
    }

    public String toString() {
        return "ExposureView{exposureData=" + this.exposureData + ", lastVisible=" + this.lastVisible + ", exposed=" + this.exposed + ", viewWeakReference=" + this.viewWeakReference.get() + ",isAddExposureView=" + this.isAddExposureView + ",isViewLayoutChange=" + this.isViewLayoutChange + '}';
    }

    /* access modifiers changed from: protected */
    public ExposureView clone() throws CloneNotSupportedException {
        return (ExposureView) super.clone();
    }
}
