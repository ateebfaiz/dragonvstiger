package rc;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private d f2016a;

    /* access modifiers changed from: protected */
    public abstract d a();

    public synchronized d b() {
        try {
            if (this.f2016a == null) {
                this.f2016a = a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f2016a;
    }
}
