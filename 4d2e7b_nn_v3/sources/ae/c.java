package ae;

public class c extends IllegalStateException {

    /* renamed from: a  reason: collision with root package name */
    private Throwable f16a;

    c(String str, Throwable th) {
        super(str);
        this.f16a = th;
    }

    public Throwable getCause() {
        return this.f16a;
    }
}
