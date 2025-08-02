package androidx.appcompat.widget;

class q {

    /* renamed from: a  reason: collision with root package name */
    private int f14349a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f14350b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f14351c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f14352d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f14353e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f14354f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14355g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14356h = false;

    q() {
    }

    public int a() {
        if (this.f14355g) {
            return this.f14349a;
        }
        return this.f14350b;
    }

    public int b() {
        return this.f14349a;
    }

    public int c() {
        return this.f14350b;
    }

    public int d() {
        if (this.f14355g) {
            return this.f14350b;
        }
        return this.f14349a;
    }

    public void e(int i10, int i11) {
        this.f14356h = false;
        if (i10 != Integer.MIN_VALUE) {
            this.f14353e = i10;
            this.f14349a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f14354f = i11;
            this.f14350b = i11;
        }
    }

    public void f(boolean z10) {
        if (z10 != this.f14355g) {
            this.f14355g = z10;
            if (!this.f14356h) {
                this.f14349a = this.f14353e;
                this.f14350b = this.f14354f;
            } else if (z10) {
                int i10 = this.f14352d;
                if (i10 == Integer.MIN_VALUE) {
                    i10 = this.f14353e;
                }
                this.f14349a = i10;
                int i11 = this.f14351c;
                if (i11 == Integer.MIN_VALUE) {
                    i11 = this.f14354f;
                }
                this.f14350b = i11;
            } else {
                int i12 = this.f14351c;
                if (i12 == Integer.MIN_VALUE) {
                    i12 = this.f14353e;
                }
                this.f14349a = i12;
                int i13 = this.f14352d;
                if (i13 == Integer.MIN_VALUE) {
                    i13 = this.f14354f;
                }
                this.f14350b = i13;
            }
        }
    }

    public void g(int i10, int i11) {
        this.f14351c = i10;
        this.f14352d = i11;
        this.f14356h = true;
        if (this.f14355g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f14349a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f14350b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f14349a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f14350b = i11;
        }
    }
}
