package u1;

public abstract class j {
    private static void a(Object obj) {
        if (obj == null) {
            throw new Exception("owner can not be null");
        }
    }

    private static void b(Class[] clsArr, Object[] objArr) {
        int i10;
        int i11 = 0;
        if (objArr != null) {
            i10 = objArr.length;
        } else {
            i10 = 0;
        }
        if (clsArr != null) {
            i11 = clsArr.length;
        }
        if (i10 != i11) {
            throw new Exception("argClasses' size is not equal to args' size");
        }
    }

    public static Object c(Class cls, Object[] objArr, Class[] clsArr) {
        a(cls);
        b(clsArr, objArr);
        return cls.getConstructor(clsArr).newInstance(objArr);
    }
}
