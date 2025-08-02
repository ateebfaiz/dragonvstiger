package aa;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static final int f2294a = a();

    private static int a() {
        return c(System.getProperty("java.version"));
    }

    private static int b(String str) {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < str.length(); i10++) {
                char charAt = str.charAt(i10);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                sb2.append(charAt);
            }
            return Integer.parseInt(sb2.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    static int c(String str) {
        int e10 = e(str);
        if (e10 == -1) {
            e10 = b(str);
        }
        if (e10 == -1) {
            return 6;
        }
        return e10;
    }

    public static boolean d() {
        if (f2294a >= 9) {
            return true;
        }
        return false;
    }

    private static int e(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt != 1 || split.length <= 1) {
                return parseInt;
            }
            return Integer.parseInt(split[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
