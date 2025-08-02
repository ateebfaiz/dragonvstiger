package o;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static g f22872a;

    /* renamed from: b  reason: collision with root package name */
    public static g f22873b;

    public class a extends g {
        public void b(Throwable th) {
        }

        public void c(Throwable th, String str) {
        }

        public void e() {
        }
    }

    static {
        a aVar = new a();
        f22872a = aVar;
        f22873b = aVar;
    }

    public static g a() {
        return f22873b;
    }

    public static void d(g gVar) {
        if (gVar == null) {
            gVar = f22872a;
        }
        f22873b = gVar;
    }

    public abstract void b(Throwable th);

    public abstract void c(Throwable th, String str);

    public abstract void e();
}
