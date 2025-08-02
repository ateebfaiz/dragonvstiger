package g1;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.stats.CodePackage;
import t1.b;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f21571a = (o1.a.a() + CodePackage.COMMON);

    public void a(Context context, int i10, Bundle bundle) {
        h1.a.g(context, f21571a, i10, bundle);
    }

    public String[] f() {
        return new String[]{f21571a};
    }

    public void h(Context context, int i10, Bundle bundle) {
        if (i10 == 1000) {
            i1.a.b().e(context);
        } else if (i10 == 1013) {
            k1.a.a().c(context, bundle);
        } else if (i10 == 1007) {
            l1.a.a().d(context, bundle);
        } else if (i10 != 1008) {
            switch (i10) {
                case 1994:
                case 1995:
                    k1.a.a().e(context, bundle);
                    return;
                case 1996:
                case 1997:
                    l1.a.a().e(context, bundle);
                    return;
                default:
                    return;
            }
        } else {
            k1.a.a().d(context, bundle);
        }
    }

    public boolean j(int i10) {
        if (i10 == 1000 || i10 == 1013 || i10 == 1007 || i10 == 1008) {
            return true;
        }
        switch (i10) {
            case 1994:
            case 1995:
            case 1996:
            case 1997:
                return true;
            default:
                return false;
        }
    }
}
