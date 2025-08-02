package e6;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private long[] f11904a;

    /* renamed from: b  reason: collision with root package name */
    private int f11905b = 0;

    private d(int i10) {
        this.f11904a = new long[i10];
    }

    public static d b(int i10) {
        return new d(i10);
    }

    private void e() {
        int i10 = this.f11905b;
        if (i10 == this.f11904a.length) {
            long[] jArr = new long[Math.max(i10 + 1, (int) (((double) i10) * 1.8d))];
            System.arraycopy(this.f11904a, 0, jArr, 0, this.f11905b);
            this.f11904a = jArr;
        }
    }

    public void a(long j10) {
        e();
        long[] jArr = this.f11904a;
        int i10 = this.f11905b;
        this.f11905b = i10 + 1;
        jArr[i10] = j10;
    }

    public void c(int i10) {
        int i11 = this.f11905b;
        if (i10 <= i11) {
            this.f11905b = i11 - i10;
            return;
        }
        throw new IndexOutOfBoundsException("Trying to drop " + i10 + " items from array of length " + this.f11905b);
    }

    public long d(int i10) {
        if (i10 < this.f11905b) {
            return this.f11904a[i10];
        }
        throw new IndexOutOfBoundsException("" + i10 + " >= " + this.f11905b);
    }

    public void f(int i10, long j10) {
        if (i10 < this.f11905b) {
            this.f11904a[i10] = j10;
            return;
        }
        throw new IndexOutOfBoundsException("" + i10 + " >= " + this.f11905b);
    }

    public int g() {
        return this.f11905b;
    }
}
