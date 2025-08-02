package g;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f21522a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final b f21523b;

    /* renamed from: c  reason: collision with root package name */
    public static b f21524c;

    static {
        n nVar = new n();
        f21523b = nVar;
        f21524c = nVar;
    }

    public static b a() {
        b bVar;
        synchronized (f21522a) {
            bVar = f21524c;
        }
        return bVar;
    }

    public static void b(b bVar) {
        synchronized (f21522a) {
            if (bVar == null) {
                try {
                    f21524c = f21523b;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                f21524c = bVar;
            }
        }
    }
}
