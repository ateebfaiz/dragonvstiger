package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import z2.a;

class j extends e {

    /* renamed from: e  reason: collision with root package name */
    private long f2808e;

    /* renamed from: f  reason: collision with root package name */
    private double[] f2809f;

    /* renamed from: g  reason: collision with root package name */
    private double f2810g;

    /* renamed from: h  reason: collision with root package name */
    private double f2811h;

    /* renamed from: i  reason: collision with root package name */
    private int f2812i;

    /* renamed from: j  reason: collision with root package name */
    private int f2813j;

    /* renamed from: k  reason: collision with root package name */
    private int f2814k = 0;

    j(ReadableMap readableMap) {
        a(readableMap);
    }

    public void a(ReadableMap readableMap) {
        int i10;
        ReadableArray array = readableMap.getArray("frames");
        int size = array.size();
        double[] dArr = this.f2809f;
        if (dArr == null || dArr.length != size) {
            this.f2809f = new double[size];
        }
        boolean z10 = false;
        for (int i11 = 0; i11 < size; i11++) {
            this.f2809f[i11] = array.getDouble(i11);
        }
        double d10 = 0.0d;
        if (readableMap.hasKey("toValue")) {
            if (readableMap.getType("toValue") == ReadableType.Number) {
                d10 = readableMap.getDouble("toValue");
            }
            this.f2810g = d10;
        } else {
            this.f2810g = 0.0d;
        }
        if (readableMap.hasKey("iterations")) {
            if (readableMap.getType("iterations") == ReadableType.Number) {
                i10 = readableMap.getInt("iterations");
            } else {
                i10 = 1;
            }
            this.f2812i = i10;
        } else {
            this.f2812i = 1;
        }
        this.f2813j = 1;
        if (this.f2812i == 0) {
            z10 = true;
        }
        this.f2782a = z10;
        this.f2808e = -1;
    }

    public void b(long j10) {
        double d10;
        if (this.f2808e < 0) {
            this.f2808e = j10;
            if (this.f2813j == 1) {
                this.f2811h = this.f2783b.f2779e;
            }
        }
        int round = (int) Math.round(((double) ((j10 - this.f2808e) / 1000000)) / 16.666666666666668d);
        if (round < 0) {
            String str = "Calculated frame index should never be lower than 0. Called with frameTimeNanos " + j10 + " and mStartFrameTimeNanos " + this.f2808e;
            if (this.f2814k < 100) {
                a.G("ReactNative", str);
                this.f2814k++;
            }
        } else if (!this.f2782a) {
            double[] dArr = this.f2809f;
            if (round >= dArr.length - 1) {
                d10 = this.f2810g;
                int i10 = this.f2812i;
                if (i10 == -1 || this.f2813j < i10) {
                    this.f2808e = -1;
                    this.f2813j++;
                } else {
                    this.f2782a = true;
                }
            } else {
                double d11 = this.f2811h;
                d10 = d11 + (dArr[round] * (this.f2810g - d11));
            }
            this.f2783b.f2779e = d10;
        }
    }
}
