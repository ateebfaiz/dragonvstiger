package y1;

import android.content.Context;
import android.os.Bundle;
import androidx.core.view.MotionEventCompat;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import g1.c0;
import g1.d0;
import g1.e0;
import g1.q;
import g1.r;
import g1.s;
import g1.t;
import g1.w;
import g1.z;
import t1.b;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24870a = (o1.a.a() + "PUSH");

    public void a(Context context, int i10, Bundle bundle) {
        switch (i10) {
            case AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN:
                t.e().d(context, i10, bundle);
                return;
            case AuthApiStatusCodes.AUTH_API_CLIENT_ERROR:
            case AuthApiStatusCodes.AUTH_API_SERVER_ERROR:
            case AuthApiStatusCodes.AUTH_TOKEN_ERROR:
            case AuthApiStatusCodes.AUTH_URL_RESOLUTION:
                w.r().i(context, i10, bundle);
                return;
            case AuthApiStatusCodes.AUTH_APP_CERT_ERROR:
                q.c().e(context, bundle);
                return;
            case 3011:
            case 3012:
            case 3013:
            case 3014:
            case 3015:
            case 3016:
                e0.j().f(context, i10, bundle);
                return;
            case 3017:
            case 3018:
            case 3019:
                c0.e().c(context, i10, bundle);
                return;
            case 3021:
                z.i().s(context, bundle);
                return;
            case 3022:
                z.i().l(context, bundle);
                return;
            case 3023:
                d0.e().c(context, i10, bundle);
                return;
            default:
                h1.a.g(context, f24870a, i10, bundle);
                return;
        }
    }

    public short b() {
        return 1;
    }

    public String c() {
        return "sdk_ver";
    }

    public int d() {
        return 2;
    }

    public String e() {
        return z1.a.f24997a;
    }

    public String[] f() {
        return new String[]{f24870a};
    }

    public void g(Context context, int i10, Bundle bundle) {
        switch (i10) {
            case 26:
                d0.e().d(context, bundle);
                return;
            case 27:
                z.i().n(context, bundle);
                return;
            case MotionEventCompat.AXIS_RELATIVE_Y:
                e0.j().g(context, bundle);
                return;
            case 29:
                c0.e().d(context, bundle);
                return;
            default:
                return;
        }
    }

    public void h(Context context, int i10, Bundle bundle) {
        if (i10 == 3) {
            s.a().c(context, bundle);
        } else if (i10 == 59) {
            w.r().x(context, bundle);
        } else if (i10 == 2001) {
            z.i().e(context);
            h1.a.j(context, 3879, (Bundle) null);
        } else if (i10 == 2997) {
            q.c().g(context, 0);
        } else if (i10 == 2999) {
            z.i().m(context);
            q.c().m(context);
            q.c().g(context, 2);
        } else if (i10 == 3978) {
            d0.e().f(context, i10, bundle);
        } else if (i10 != 3979) {
            switch (i10) {
                case 26:
                    d0.e().g(context, bundle);
                    return;
                case 27:
                    z.i().p(context, bundle);
                    return;
                case MotionEventCompat.AXIS_RELATIVE_Y:
                    e0.j().n(context, bundle);
                    return;
                case 29:
                    c0.e().g(context, bundle);
                    return;
                default:
                    switch (i10) {
                        case 1994:
                            r.a().c(context);
                            return;
                        case 1995:
                            r.a().e(context);
                            q.c().g(context, 1);
                            return;
                        case 1996:
                            h1.a.j(context, 2993, (Bundle) null);
                            return;
                        case 1997:
                            h1.a.j(context, 2994, (Bundle) null);
                            return;
                        default:
                            switch (i10) {
                                case 3884:
                                    q.c().o(context);
                                    return;
                                case 3885:
                                    q.c().i(context, bundle);
                                    return;
                                case 3886:
                                    q.c().q(context);
                                    return;
                                case 3887:
                                    q.c().k(context, bundle);
                                    return;
                                case 3888:
                                    q.c().h(context, bundle);
                                    return;
                                case 3889:
                                    q.c().n(context, bundle);
                                    return;
                                case 3890:
                                    q.c().t(context);
                                    return;
                                case 3891:
                                    q.c().r(context, bundle);
                                    return;
                                case 3892:
                                    q.c().s(context);
                                    return;
                                case 3893:
                                    q.c().p(context, bundle);
                                    return;
                                case 3894:
                                    w.r().u(context, bundle);
                                    return;
                                case 3895:
                                    w.r().y(context, bundle);
                                    return;
                                case 3896:
                                    w.r().c(context, bundle);
                                    return;
                                case 3897:
                                    t.e().c(context, bundle);
                                    return;
                                case 3898:
                                    h1.a.j(context, 2995, (Bundle) null);
                                    h1.a.i(context, 3103, (Bundle) null);
                                    return;
                                case 3899:
                                    h1.a.j(context, 2996, (Bundle) null);
                                    h1.a.i(context, 3102, (Bundle) null);
                                    return;
                                default:
                                    switch (i10) {
                                        case 3981:
                                        case 3982:
                                        case 3983:
                                            c0.e().f(context, i10, bundle);
                                            return;
                                        case 3984:
                                        case 3985:
                                        case 3986:
                                        case 3987:
                                        case 3988:
                                        case 3989:
                                            e0.j().m(context, i10, bundle);
                                            return;
                                        default:
                                            switch (i10) {
                                                case 3995:
                                                case 3996:
                                                case 3997:
                                                    break;
                                                case 3998:
                                                    q.c().g(context, 3);
                                                    break;
                                                case 3999:
                                                    t.e().f(context, i10, bundle);
                                                    return;
                                                default:
                                                    return;
                                            }
                                            w.r().t(context, i10, bundle);
                                            return;
                                    }
                            }
                    }
            }
        } else {
            z.i().u(context, bundle);
        }
    }

    public boolean i() {
        return true;
    }

    public boolean j(int i10) {
        if (i10 == 3102 || i10 == 3103 || i10 == 3797 || i10 == 3798 || i10 == 3978 || i10 == 3979 || i10 == 3 || i10 == 59 || i10 == 2001 || i10 == 2999) {
            return true;
        }
        switch (i10) {
            case 3880:
            case 3881:
            case 3882:
            case 3883:
            case 3884:
            case 3885:
            case 3886:
            case 3887:
            case 3888:
            case 3889:
            case 3890:
            case 3891:
            case 3892:
            case 3893:
            case 3894:
            case 3895:
            case 3896:
            case 3897:
            case 3898:
            case 3899:
                return true;
            default:
                switch (i10) {
                    case 3994:
                    case 3995:
                    case 3996:
                    case 3997:
                    case 3998:
                    case 3999:
                        return true;
                    default:
                        switch (i10) {
                            case 26:
                            case 27:
                            case MotionEventCompat.AXIS_RELATIVE_Y:
                            case 29:
                                return true;
                            default:
                                switch (i10) {
                                    case 1994:
                                    case 1995:
                                    case 1996:
                                    case 1997:
                                        return true;
                                    default:
                                        switch (i10) {
                                            case AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN:
                                            case AuthApiStatusCodes.AUTH_API_CLIENT_ERROR:
                                            case AuthApiStatusCodes.AUTH_API_SERVER_ERROR:
                                            case AuthApiStatusCodes.AUTH_TOKEN_ERROR:
                                            case AuthApiStatusCodes.AUTH_URL_RESOLUTION:
                                            case AuthApiStatusCodes.AUTH_APP_CERT_ERROR:
                                                return true;
                                            default:
                                                switch (i10) {
                                                    case 3011:
                                                    case 3012:
                                                    case 3013:
                                                    case 3014:
                                                    case 3015:
                                                    case 3016:
                                                    case 3017:
                                                    case 3018:
                                                    case 3019:
                                                        return true;
                                                    default:
                                                        switch (i10) {
                                                            case 3021:
                                                            case 3022:
                                                            case 3023:
                                                                return true;
                                                            default:
                                                                switch (i10) {
                                                                    case 3981:
                                                                    case 3982:
                                                                    case 3983:
                                                                    case 3984:
                                                                    case 3985:
                                                                    case 3986:
                                                                    case 3987:
                                                                    case 3988:
                                                                    case 3989:
                                                                        return true;
                                                                    default:
                                                                        return false;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }
}
