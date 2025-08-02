package tc;

public abstract class a implements sc.a {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f2093a = new byte[4];

    /* renamed from: b  reason: collision with root package name */
    private int f2094b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f2095c;

    protected a() {
    }

    public void d() {
        long j10 = this.f2095c << 3;
        i(Byte.MIN_VALUE);
        while (this.f2094b != 0) {
            i((byte) 0);
        }
        f(j10);
        e();
    }

    /* access modifiers changed from: protected */
    public abstract void e();

    /* access modifiers changed from: protected */
    public abstract void f(long j10);

    /* access modifiers changed from: protected */
    public abstract void g(byte[] bArr, int i10);

    public void h() {
        this.f2095c = 0;
        this.f2094b = 0;
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f2093a;
            if (i10 < bArr.length) {
                bArr[i10] = 0;
                i10++;
            } else {
                return;
            }
        }
    }

    public void i(byte b10) {
        byte[] bArr = this.f2093a;
        int i10 = this.f2094b;
        int i11 = i10 + 1;
        this.f2094b = i11;
        bArr[i10] = b10;
        if (i11 == bArr.length) {
            g(bArr, 0);
            this.f2094b = 0;
        }
        this.f2095c++;
    }

    public void update(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        int max = Math.max(0, i11);
        if (this.f2094b != 0) {
            int i13 = 0;
            while (true) {
                if (i13 >= max) {
                    i12 = i13;
                    break;
                }
                byte[] bArr2 = this.f2093a;
                int i14 = this.f2094b;
                int i15 = i14 + 1;
                this.f2094b = i15;
                int i16 = i13 + 1;
                bArr2[i14] = bArr[i13 + i10];
                if (i15 == 4) {
                    g(bArr2, 0);
                    this.f2094b = 0;
                    i12 = i16;
                    break;
                }
                i13 = i16;
            }
        }
        int i17 = ((max - i12) & -4) + i12;
        while (i12 < i17) {
            g(bArr, i10 + i12);
            i12 += 4;
        }
        while (i12 < max) {
            byte[] bArr3 = this.f2093a;
            int i18 = this.f2094b;
            this.f2094b = i18 + 1;
            bArr3[i18] = bArr[i12 + i10];
            i12++;
        }
        this.f2095c += (long) max;
    }
}
