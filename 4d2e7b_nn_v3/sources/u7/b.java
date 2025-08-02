package u7;

import android.os.SystemClock;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f13126a = Integer.MIN_VALUE;

    /* renamed from: b  reason: collision with root package name */
    private int f13127b = Integer.MIN_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private float f13128c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f13129d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    private long f13130e = -11;

    public float a() {
        return this.f13128c;
    }

    public float b() {
        return this.f13129d;
    }

    public boolean c(int i10, int i11) {
        boolean z10;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j10 = this.f13130e;
        if (uptimeMillis - j10 <= 10 && this.f13126a == i10 && this.f13127b == i11) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (uptimeMillis - j10 != 0) {
            this.f13128c = ((float) (i10 - this.f13126a)) / ((float) (uptimeMillis - j10));
            this.f13129d = ((float) (i11 - this.f13127b)) / ((float) (uptimeMillis - j10));
        }
        this.f13130e = uptimeMillis;
        this.f13126a = i10;
        this.f13127b = i11;
        return z10;
    }
}
