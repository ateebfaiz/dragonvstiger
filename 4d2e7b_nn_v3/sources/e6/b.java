package e6;

import androidx.core.util.Pools;

public class b implements Pools.Pool {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f11901a;

    /* renamed from: b  reason: collision with root package name */
    private int f11902b = 0;

    public b(int i10) {
        this.f11901a = new Object[i10];
    }

    public synchronized void a() {
        int i10 = 0;
        while (i10 < this.f11902b) {
            try {
                this.f11901a[i10] = null;
                i10++;
            } finally {
            }
        }
        this.f11902b = 0;
    }

    public synchronized Object acquire() {
        int i10 = this.f11902b;
        if (i10 == 0) {
            return null;
        }
        int i11 = i10 - 1;
        this.f11902b = i11;
        Object[] objArr = this.f11901a;
        Object obj = objArr[i11];
        objArr[i11] = null;
        return obj;
    }

    public synchronized boolean release(Object obj) {
        int i10 = this.f11902b;
        Object[] objArr = this.f11901a;
        if (i10 == objArr.length) {
            return false;
        }
        objArr[i10] = obj;
        this.f11902b = i10 + 1;
        return true;
    }
}
