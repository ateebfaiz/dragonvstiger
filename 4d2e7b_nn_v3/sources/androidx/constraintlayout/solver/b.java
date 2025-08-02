package androidx.constraintlayout.solver;

class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f14686a;

    /* renamed from: b  reason: collision with root package name */
    private int f14687b;

    b(int i10) {
        if (i10 > 0) {
            this.f14686a = new Object[i10];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public void a(Object[] objArr, int i10) {
        if (i10 > objArr.length) {
            i10 = objArr.length;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = objArr[i11];
            int i12 = this.f14687b;
            Object[] objArr2 = this.f14686a;
            if (i12 < objArr2.length) {
                objArr2[i12] = obj;
                this.f14687b = i12 + 1;
            }
        }
    }

    public Object acquire() {
        int i10 = this.f14687b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f14686a;
        Object obj = objArr[i11];
        objArr[i11] = null;
        this.f14687b = i10 - 1;
        return obj;
    }

    public boolean release(Object obj) {
        int i10 = this.f14687b;
        Object[] objArr = this.f14686a;
        if (i10 >= objArr.length) {
            return false;
        }
        objArr[i10] = obj;
        this.f14687b = i10 + 1;
        return true;
    }
}
