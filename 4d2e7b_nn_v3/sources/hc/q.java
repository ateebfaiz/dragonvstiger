package hc;

public class q extends IllegalStateException {

    /* renamed from: a  reason: collision with root package name */
    private Throwable f412a;

    public q(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.f412a;
    }

    public q(String str, Throwable th) {
        super(str);
        this.f412a = th;
    }
}
