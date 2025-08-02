package com.onesignal;

import android.view.animation.Interpolator;

class s3 implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private double f11037a;

    /* renamed from: b  reason: collision with root package name */
    private double f11038b;

    s3(double d10, double d11) {
        this.f11037a = d10;
        this.f11038b = d11;
    }

    public float getInterpolation(float f10) {
        return (float) ((Math.pow(2.718281828459045d, ((double) (-f10)) / this.f11037a) * -1.0d * Math.cos(this.f11038b * ((double) f10))) + 1.0d);
    }
}
