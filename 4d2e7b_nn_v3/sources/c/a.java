package c;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f17187c = new a(new byte[0]);

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f17188a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f17189b = 0;

    public a(byte[] bArr) {
        this.f17188a = bArr;
    }

    public byte[] a() {
        byte[] bArr = this.f17188a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        byte[] bArr = this.f17188a;
        int length = bArr.length;
        byte[] bArr2 = ((a) obj).f17188a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i10 = this.f17189b;
        if (i10 == 0) {
            int i11 = r1;
            for (byte b10 : this.f17188a) {
                i11 = (i11 * 31) + b10;
            }
            if (i11 == 0) {
                i10 = 1;
            } else {
                i10 = i11;
            }
            this.f17189b = i10;
        }
        return i10;
    }
}
