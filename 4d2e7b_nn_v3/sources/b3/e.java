package b3;

public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private static e f17161a;

    public static synchronized e b() {
        e eVar;
        synchronized (e.class) {
            try {
                if (f17161a == null) {
                    f17161a = new e();
                }
                eVar = f17161a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public void a(c cVar) {
    }
}
