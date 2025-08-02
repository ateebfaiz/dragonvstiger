package e7;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final f f11959a = new f();

    public f a() {
        return this.f11959a;
    }

    public void b() {
        if (!e()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void c(Exception exc) {
        if (!f(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public void d(Object obj) {
        if (!g(obj)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public boolean e() {
        return this.f11959a.x();
    }

    public boolean f(Exception exc) {
        return this.f11959a.y(exc);
    }

    public boolean g(Object obj) {
        return this.f11959a.z(obj);
    }
}
