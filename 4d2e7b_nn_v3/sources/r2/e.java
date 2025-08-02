package r2;

import g3.c;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public abstract class e {
    public static String a(d dVar) {
        try {
            if (dVar instanceof f) {
                return c((d) ((f) dVar).d().get(0));
            }
            return c(dVar);
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static List b(d dVar) {
        ArrayList arrayList;
        String str;
        try {
            if (dVar instanceof f) {
                List d10 = ((f) dVar).d();
                arrayList = new ArrayList(d10.size());
                for (int i10 = 0; i10 < d10.size(); i10++) {
                    arrayList.add(c((d) d10.get(i10)));
                }
            } else {
                arrayList = new ArrayList(1);
                if (dVar.b()) {
                    str = dVar.c();
                } else {
                    str = c(dVar);
                }
                arrayList.add(str);
            }
            return arrayList;
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static String c(d dVar) {
        return c.a(dVar.c().getBytes("UTF-8"));
    }
}
