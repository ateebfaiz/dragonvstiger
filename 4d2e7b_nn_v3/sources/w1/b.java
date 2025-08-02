package w1;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f24485a;

    /* renamed from: b  reason: collision with root package name */
    private int f24486b;

    /* renamed from: c  reason: collision with root package name */
    private int f24487c;

    public b(int i10) {
        this.f24485a = new byte[i10];
        this.f24486b = 0;
        this.f24487c = -1;
    }

    private void a(long j10, int i10) {
    }

    private void c(int i10) {
        byte[] bArr = this.f24485a;
        int length = bArr.length;
        int i11 = this.f24486b;
        if (length - i11 < i10) {
            int length2 = bArr.length * 2;
            int i12 = i10 + i11;
            if (length2 < i12) {
                length2 = i12;
            }
            byte[] bArr2 = new byte[length2];
            System.arraycopy(bArr, 0, bArr2, 0, i11);
            this.f24485a = bArr2;
        }
    }

    public int b() {
        return this.f24486b;
    }

    public byte[] d() {
        int i10 = this.f24486b;
        byte[] bArr = new byte[i10];
        System.arraycopy(this.f24485a, 0, bArr, 0, i10);
        return bArr;
    }

    public void e(byte[] bArr) {
        f(bArr, 0, bArr.length);
    }

    public void f(byte[] bArr, int i10, int i11) {
        c(i11);
        System.arraycopy(bArr, i10, this.f24485a, this.f24486b, i11);
        this.f24486b += i11;
    }

    public void g(byte[] bArr) {
        h(bArr.length);
        f(bArr, 0, bArr.length);
    }

    public void h(int i10) {
        a((long) i10, 16);
        c(2);
        byte[] bArr = this.f24485a;
        int i11 = this.f24486b;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        this.f24486b = i11 + 2;
        bArr[i11 + 1] = (byte) (i10 & 255);
    }

    public void i(int i10, int i11) {
        a((long) i10, 16);
        if (i11 <= this.f24486b - 2) {
            byte[] bArr = this.f24485a;
            bArr[i11] = (byte) ((i10 >>> 8) & 255);
            bArr[i11 + 1] = (byte) (i10 & 255);
            return;
        }
        throw new IllegalArgumentException("cannot write past end of data");
    }

    public void j(long j10) {
        a(j10, 32);
        c(4);
        byte[] bArr = this.f24485a;
        int i10 = this.f24486b;
        bArr[i10] = (byte) ((int) ((j10 >>> 24) & 255));
        bArr[i10 + 1] = (byte) ((int) ((j10 >>> 16) & 255));
        bArr[i10 + 2] = (byte) ((int) ((j10 >>> 8) & 255));
        this.f24486b = i10 + 4;
        bArr[i10 + 3] = (byte) ((int) (j10 & 255));
    }

    public void k(long j10) {
        c(8);
        byte[] bArr = this.f24485a;
        int i10 = this.f24486b;
        bArr[i10] = (byte) ((int) ((j10 >>> 56) & 255));
        bArr[i10 + 1] = (byte) ((int) ((j10 >>> 48) & 255));
        bArr[i10 + 2] = (byte) ((int) ((j10 >>> 40) & 255));
        bArr[i10 + 3] = (byte) ((int) ((j10 >>> 32) & 255));
        bArr[i10 + 4] = (byte) ((int) ((j10 >>> 24) & 255));
        bArr[i10 + 5] = (byte) ((int) ((j10 >>> 16) & 255));
        bArr[i10 + 6] = (byte) ((int) ((j10 >>> 8) & 255));
        this.f24486b = i10 + 8;
        bArr[i10 + 7] = (byte) ((int) (j10 & 255));
    }

    public void l(int i10) {
        a((long) i10, 8);
        c(1);
        byte[] bArr = this.f24485a;
        int i11 = this.f24486b;
        this.f24486b = i11 + 1;
        bArr[i11] = (byte) (i10 & 255);
    }

    public void m(int i10, int i11) {
        a((long) i10, 8);
        if (i11 <= this.f24486b - 1) {
            this.f24485a[i11] = (byte) (i10 & 255);
            return;
        }
        throw new IllegalArgumentException("cannot write past end of data");
    }

    public b() {
        this(32);
    }
}
