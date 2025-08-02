package q;

public class b extends d {
    public b(int i10, String str, String str2, String str3) {
        super(2, i10, str, str2, str3, System.currentTimeMillis());
    }

    public static int b(int i10) {
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2) {
                i11 = 3;
                if (i10 != 3) {
                    i11 = 4;
                    if (i10 != 4) {
                        return -1;
                    }
                }
            }
        }
        return i11;
    }
}
