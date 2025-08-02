package v2;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private static c f24390a;

    private c() {
    }

    public static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            try {
                if (f24390a == null) {
                    f24390a = new c();
                }
                cVar = f24390a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public void a(a aVar) {
    }
}
