package ac;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f3a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal[] f4b;

    static {
        ThreadLocal[] threadLocalArr = new ThreadLocal[4];
        for (int i10 = 0; i10 < 4; i10++) {
            threadLocalArr[i10] = new ThreadLocal();
        }
        f4b = threadLocalArr;
    }

    public static final boolean a() {
        return f3a;
    }
}
