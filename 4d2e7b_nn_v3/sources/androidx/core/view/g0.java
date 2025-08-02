package androidx.core.view;

import android.view.MotionEvent;

class g0 {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f15255a = new float[20];

    /* renamed from: b  reason: collision with root package name */
    private final long[] f15256b = new long[20];

    /* renamed from: c  reason: collision with root package name */
    private float f15257c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    private int f15258d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f15259e = 0;

    g0() {
    }

    private void b() {
        this.f15258d = 0;
        this.f15257c = 0.0f;
    }

    private float e() {
        long[] jArr;
        long j10;
        int i10 = this.f15258d;
        if (i10 < 2) {
            return 0.0f;
        }
        int i11 = this.f15259e;
        int i12 = ((i11 + 20) - (i10 - 1)) % 20;
        long j11 = this.f15256b[i11];
        while (true) {
            jArr = this.f15256b;
            j10 = jArr[i12];
            if (j11 - j10 <= 100) {
                break;
            }
            this.f15258d--;
            i12 = (i12 + 1) % 20;
        }
        int i13 = this.f15258d;
        if (i13 < 2) {
            return 0.0f;
        }
        if (i13 == 2) {
            int i14 = (i12 + 1) % 20;
            long j12 = jArr[i14];
            if (j10 == j12) {
                return 0.0f;
            }
            return this.f15255a[i14] / ((float) (j12 - j10));
        }
        float f10 = 0.0f;
        int i15 = 0;
        for (int i16 = 0; i16 < this.f15258d - 1; i16++) {
            int i17 = i16 + i12;
            long[] jArr2 = this.f15256b;
            long j13 = jArr2[i17 % 20];
            int i18 = (i17 + 1) % 20;
            if (jArr2[i18] != j13) {
                i15++;
                float f11 = f(f10);
                float f12 = this.f15255a[i18] / ((float) (this.f15256b[i18] - j13));
                f10 += (f12 - f11) * Math.abs(f12);
                if (i15 == 1) {
                    f10 *= 0.5f;
                }
            }
        }
        return f(f10);
    }

    private static float f(float f10) {
        float f11;
        if (f10 < 0.0f) {
            f11 = -1.0f;
        } else {
            f11 = 1.0f;
        }
        return f11 * ((float) Math.sqrt((double) (Math.abs(f10) * 2.0f)));
    }

    /* access modifiers changed from: package-private */
    public void a(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.f15258d != 0 && eventTime - this.f15256b[this.f15259e] > 40) {
            b();
        }
        int i10 = (this.f15259e + 1) % 20;
        this.f15259e = i10;
        int i11 = this.f15258d;
        if (i11 != 20) {
            this.f15258d = i11 + 1;
        }
        this.f15255a[i10] = motionEvent.getAxisValue(26);
        this.f15256b[this.f15259e] = eventTime;
    }

    /* access modifiers changed from: package-private */
    public void c(int i10, float f10) {
        float e10 = e() * ((float) i10);
        this.f15257c = e10;
        if (e10 < (-Math.abs(f10))) {
            this.f15257c = -Math.abs(f10);
        } else if (this.f15257c > Math.abs(f10)) {
            this.f15257c = Math.abs(f10);
        }
    }

    /* access modifiers changed from: package-private */
    public float d(int i10) {
        if (i10 != 26) {
            return 0.0f;
        }
        return this.f15257c;
    }
}
