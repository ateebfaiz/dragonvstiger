package cc;

abstract /* synthetic */ class e0 {

    /* renamed from: a  reason: collision with root package name */
    private static final int f64a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f64a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
