package com.sensorsdata.analytics.android.sdk.core.business.exposure;

public class SAExposureConfig {
    private float areaRate;
    private long delayTime = 500;
    private boolean repeated;
    private double stayDuration;

    public SAExposureConfig(float f10, double d10, boolean z10) {
        this.areaRate = f10;
        this.stayDuration = d10;
        this.repeated = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SAExposureConfig sAExposureConfig = (SAExposureConfig) obj;
        if (sAExposureConfig.areaRate == this.areaRate && this.repeated == sAExposureConfig.repeated && sAExposureConfig.stayDuration == this.stayDuration) {
            return true;
        }
        return false;
    }

    public float getAreaRate() {
        return this.areaRate;
    }

    public long getDelayTime() {
        return this.delayTime;
    }

    public double getStayDuration() {
        return this.stayDuration;
    }

    public boolean isRepeated() {
        return this.repeated;
    }

    public void setAreaRate(float f10) {
        this.areaRate = f10;
    }

    public void setDelayTime(long j10) {
        this.delayTime = j10;
    }

    public void setRepeated(boolean z10) {
        this.repeated = z10;
    }

    public void setStayDuration(double d10) {
        this.stayDuration = d10;
    }

    public String toString() {
        return "SAExposureConfig{areaRate=" + this.areaRate + ", repeated=" + this.repeated + ", stayDuration=" + this.stayDuration + '}';
    }
}
