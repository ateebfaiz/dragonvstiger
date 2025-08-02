package y2;

public abstract class q {
    public static RuntimeException a(Throwable th) {
        c((Throwable) l.g(th));
        throw new RuntimeException(th);
    }

    public static void b(Throwable th, Class cls) {
        if (th != null && cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }

    public static void c(Throwable th) {
        b(th, Error.class);
        b(th, RuntimeException.class);
    }
}
