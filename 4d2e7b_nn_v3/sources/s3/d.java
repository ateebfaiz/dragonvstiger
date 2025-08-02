package s3;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private boolean f23868a;

    /* renamed from: b  reason: collision with root package name */
    private int f23869b;

    /* renamed from: c  reason: collision with root package name */
    private int f23870c;

    public d() {
        a();
    }

    public void a() {
        this.f23868a = false;
        this.f23869b = 4;
        c();
    }

    public void b() {
        this.f23870c++;
    }

    public void c() {
        this.f23870c = 0;
    }

    public void d(boolean z10) {
        this.f23868a = z10;
    }

    public boolean e() {
        if (!this.f23868a || this.f23870c >= this.f23869b) {
            return false;
        }
        return true;
    }
}
