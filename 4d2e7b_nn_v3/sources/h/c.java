package h;

import android.util.Base64;
import java.util.Date;
import java.util.List;
import o.g;
import org.json.JSONObject;
import w.d;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f21764a = d.f("");

    public static boolean a(int i10) {
        if (i10 < 0 || i10 > 22) {
            return false;
        }
        return true;
    }

    public static String b(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Throwable th) {
            g.a().b(th);
            return null;
        }
    }

    public static String c(JSONObject jSONObject, String str, boolean z10) {
        String str2;
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            str2 = null;
        } else {
            str2 = jSONObject.optString(str);
        }
        if (str2 == null || !z10 || str2.length() == 0) {
            return str2;
        }
        String b10 = b(str2);
        if (b10 == null) {
            return "";
        }
        return b10;
    }

    public static boolean d(int i10) {
        if (i10 < 5 || i10 > 525600) {
            return false;
        }
        return true;
    }

    public static boolean e(long j10) {
        if (j10 == 0) {
            return true;
        }
        long time = j10 - new Date().getTime();
        if (time <= 0 || time > 31536000000L) {
            return false;
        }
        return true;
    }

    public static boolean f(d dVar) {
        if (dVar == null || dVar.a() == null) {
            return false;
        }
        return true;
    }

    public static boolean g(e eVar) {
        if (eVar == null || eVar.f() == 0 || eVar.c() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean h(List list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean i(int i10) {
        if (i10 < 0 || i10 > 3) {
            return false;
        }
        return true;
    }

    public static boolean j(List list) {
        if (list != null) {
            return true;
        }
        return false;
    }

    public static boolean k(int i10) {
        if (i10 < 1 || i10 > 3) {
            return false;
        }
        return true;
    }

    public static boolean l(int i10) {
        if (i10 < 1 || i10 > 5) {
            return false;
        }
        return true;
    }

    public static boolean m(int i10) {
        if (i10 == 4 || i10 == 17) {
            return true;
        }
        return false;
    }

    public static boolean n(int i10) {
        if (i10 < 30 || i10 > 10080) {
            return false;
        }
        return true;
    }

    public static boolean o(int i10) {
        if (i10 < -1 || i10 > 3600) {
            return false;
        }
        return true;
    }

    public static boolean p(int i10) {
        if (i10 < 0 || i10 > 2) {
            return false;
        }
        return true;
    }

    public static boolean q(int i10) {
        if (i10 < 0 || i10 > 2) {
            return false;
        }
        return true;
    }

    public static boolean r(int i10) {
        if (i10 < 1 || i10 > 3) {
            return false;
        }
        return true;
    }

    public static boolean s(int i10) {
        if (i10 < 1 || i10 > 86400) {
            return false;
        }
        return true;
    }

    public static boolean t(int i10) {
        if (i10 == 21 || i10 == 22) {
            return true;
        }
        return false;
    }

    public static boolean u(int i10) {
        if (i10 < 0 || i10 > 3) {
            return false;
        }
        return true;
    }
}
