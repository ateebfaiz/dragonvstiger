package v1;

import android.content.Context;
import android.os.Bundle;
import androidx.work.WorkRequest;
import g1.c;
import g1.e;
import g1.f;
import g1.m;
import t1.b;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24387a = (o1.a.a() + "CORE");

    /* renamed from: b  reason: collision with root package name */
    public static final String f24388b = (o1.a.a() + "REPORT");

    /* renamed from: c  reason: collision with root package name */
    public static final String f24389c = (o1.a.a() + "CONNECT");

    public void a(Context context, int i10, Bundle bundle) {
        if (i10 == 2001) {
            f.a().d(context);
        } else if (i10 == 2002) {
            f.a().g(context);
        } else if (i10 == 2233) {
            h1.a.g(context, f24388b, i10, bundle);
        } else if (i10 == 2993) {
            String str = f24389c;
            h1.a.e(context, str);
            h1.a.g(context, str, i10, bundle);
        } else if (i10 != 2994) {
            String str2 = f24387a;
            h1.a.a(context, str2, (int) (x1.a.c() + WorkRequest.MIN_BACKOFF_MILLIS));
            h1.a.g(context, str2, i10, bundle);
        } else {
            String str3 = f24389c;
            h1.a.a(context, str3, (int) (x1.a.c() + WorkRequest.MIN_BACKOFF_MILLIS));
            h1.a.g(context, str3, i10, bundle);
        }
    }

    public short b() {
        return 0;
    }

    public String c() {
        return "core_sdk_ver";
    }

    public int d() {
        return 1;
    }

    public String e() {
        return "3.6.0";
    }

    public String[] f() {
        return new String[]{f24387a, f24388b, f24389c};
    }

    public void g(Context context, int i10, Bundle bundle) {
        if (i10 == 2) {
            f.a().b(context);
        } else if (i10 == 2992) {
            f.a().i(context);
        }
    }

    public void h(Context context, int i10, Bundle bundle) {
        if (i10 == 19) {
            f.a().c(context, bundle);
        } else if (i10 == 25) {
            c.a().c(context, bundle);
        } else if (i10 == 1999) {
            c.a().d(context);
            c.a().b(context);
        } else if (i10 == 2222) {
            f.a().e(context, bundle);
        } else if (i10 == 2233) {
            m.b().f(context, bundle);
        } else if (i10 == 1994) {
            e.a().b(context);
        } else if (i10 == 1995) {
            e.a().c(context);
        } else if (i10 == 2101) {
            c.a().f(context, bundle);
        } else if (i10 != 2102) {
            if (i10 != 2998) {
                if (i10 != 2999) {
                    switch (i10) {
                        case 2991:
                            break;
                        case 2992:
                            break;
                        case 2993:
                            f.a().j(context);
                            return;
                        case 2994:
                            f.a().h(context);
                            return;
                        case 2995:
                            f.a().l(context);
                            return;
                        case 2996:
                            f.a().m(context);
                            return;
                        default:
                            return;
                    }
                }
                f.a().i(context);
                return;
            }
            f.a().k(context);
        } else {
            c.a().e(context, bundle);
        }
    }

    public boolean i() {
        return true;
    }

    public boolean j(int i10) {
        if (i10 == 2 || i10 == 19 || i10 == 25 || i10 == 2222 || i10 == 2233 || i10 == 1994 || i10 == 1995 || i10 == 1998 || i10 == 1999 || i10 == 2001 || i10 == 2002 || i10 == 2101 || i10 == 2102 || i10 == 2998 || i10 == 2999) {
            return true;
        }
        switch (i10) {
            case 2991:
            case 2992:
            case 2993:
            case 2994:
            case 2995:
            case 2996:
                return true;
            default:
                return false;
        }
    }
}
