package ae;

public class a extends IllegalStateException {

    /* renamed from: a  reason: collision with root package name */
    private Throwable f15a;

    a(String str, Throwable th) {
        super(str);
        this.f15a = th;
    }

    public Throwable getCause() {
        return this.f15a;
    }
}
