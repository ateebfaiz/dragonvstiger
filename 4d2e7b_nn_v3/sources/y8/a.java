package y8;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f13334a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f13335b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f13336c;

    private a() {
    }

    public final void a() {
        try {
            Class.forName("com.flyjingfish.android_aop_core.utils.AnnotationInit");
        } catch (Throwable unused) {
        }
        f13335b = true;
    }

    public final boolean b() {
        return f13336c;
    }

    public final void c(boolean z10) {
        if (!f13335b) {
            f13336c = z10;
            return;
        }
        throw new IllegalStateException("isApkDebug can only be set once");
    }
}
