package com.facebook.react.uimanager;

import com.facebook.yoga.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class c1 {

    /* renamed from: e  reason: collision with root package name */
    public static final a f3568e = new a((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f3569f = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};

    /* renamed from: a  reason: collision with root package name */
    private final float f3570a;

    /* renamed from: b  reason: collision with root package name */
    private final float[] f3571b;

    /* renamed from: c  reason: collision with root package name */
    private int f3572c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3573d;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final float[] b() {
            return new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c1(float f10, float[] fArr) {
        m.f(fArr, "spacing");
        this.f3570a = f10;
        this.f3571b = fArr;
    }

    public final float a(int i10) {
        float f10;
        char c10;
        if (!(i10 == 4 || i10 == 5)) {
            switch (i10) {
                case 9:
                case 10:
                case 11:
                    break;
                default:
                    f10 = this.f3570a;
                    break;
            }
        }
        f10 = Float.NaN;
        int i11 = this.f3572c;
        if (i11 == 0) {
            return f10;
        }
        int[] iArr = f3569f;
        if ((iArr[i10] & i11) != 0) {
            return this.f3571b[i10];
        }
        if (this.f3573d) {
            if (i10 == 1 || i10 == 3) {
                c10 = 7;
            } else {
                c10 = 6;
            }
            if ((iArr[c10] & i11) != 0) {
                return this.f3571b[c10];
            }
            if ((i11 & iArr[8]) != 0) {
                return this.f3571b[8];
            }
        }
        return f10;
    }

    public final float b(int i10) {
        return this.f3571b[i10];
    }

    public final boolean c(int i10, float f10) {
        int i11;
        boolean z10 = false;
        if (n.a(this.f3571b[i10], f10)) {
            return false;
        }
        this.f3571b[i10] = f10;
        if (e.a(f10)) {
            i11 = (~f3569f[i10]) & this.f3572c;
        } else {
            i11 = f3569f[i10] | this.f3572c;
        }
        this.f3572c = i11;
        int[] iArr = f3569f;
        if (!((iArr[8] & i11) == 0 && (iArr[7] & i11) == 0 && (iArr[6] & i11) == 0 && (i11 & iArr[9]) == 0)) {
            z10 = true;
        }
        this.f3573d = z10;
        return true;
    }

    public c1() {
        this(0.0f, f3568e.b());
    }

    public c1(float f10) {
        this(f10, f3568e.b());
    }
}
