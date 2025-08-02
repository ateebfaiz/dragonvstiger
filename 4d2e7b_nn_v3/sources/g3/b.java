package g3;

public abstract class b {
    public static int a(int i10, int i11) {
        return ((i10 + 31) * 31) + i11;
    }

    public static int b(Object obj, Object obj2) {
        int i10;
        int i11 = 0;
        if (obj == null) {
            i10 = 0;
        } else {
            i10 = obj.hashCode();
        }
        if (obj2 != null) {
            i11 = obj2.hashCode();
        }
        return a(i10, i11);
    }
}
