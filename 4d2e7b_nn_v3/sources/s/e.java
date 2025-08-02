package s;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import i.v;

public class e {

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f23720d = {"Unknown", "None", "WIFI", "2G", "3G", "4G", "5G"};

    /* renamed from: a  reason: collision with root package name */
    public final String f23721a;

    /* renamed from: b  reason: collision with root package name */
    public final int f23722b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f23723c;

    public interface a {
        void OooO00o();
    }

    public e(int i10) {
        String str = f23720d[i10];
        this.f23722b = i10;
        this.f23721a = str;
        this.f23723c = true;
    }

    public static e b(int i10) {
        if (i10 == -1) {
            return new e(1);
        }
        if (i10 == 1) {
            return new e(2);
        }
        if (i10 == 2) {
            return new e(3);
        }
        if (i10 == 3) {
            return new e(4);
        }
        if (i10 == 4) {
            return new e(5);
        }
        if (i10 != 5) {
            return new e(0);
        }
        return new e(6);
    }

    public static e c(Context context) {
        return d(context, (a) null);
    }

    public static e d(Context context, a aVar) {
        if (aVar != null) {
            try {
                aVar.OooO00o();
            } catch (Throwable unused) {
                return new e(0, f23720d[0], false);
            }
        }
        ConnectivityManager o10 = v.o(context);
        if (o10 == null) {
            return new e(0);
        }
        NetworkInfo activeNetworkInfo = o10.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return new e(1);
        }
        if (activeNetworkInfo.isAvailable()) {
            if (activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return new e(2);
                }
                if (type == 0) {
                    return g(activeNetworkInfo.getSubtype());
                }
                return new e(0);
            }
        }
        return new e(1);
    }

    public static e g(int i10) {
        switch (i10) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 16:
                return new e(3);
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return new e(4);
            case 13:
            case 18:
            case 19:
                return new e(5);
            case 20:
                return new e(6);
            default:
                return new e(0);
        }
    }

    public String a() {
        return this.f23721a;
    }

    public boolean e(e eVar) {
        if (this.f23722b == eVar.f23722b && i() == eVar.i()) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.f23722b;
    }

    public boolean h() {
        if (this.f23722b != 1) {
            return true;
        }
        return false;
    }

    public boolean i() {
        return this.f23723c;
    }

    public boolean j() {
        if (this.f23722b == 2) {
            return true;
        }
        return false;
    }

    public e(int i10, String str, boolean z10) {
        this.f23722b = i10;
        this.f23721a = str;
        this.f23723c = z10;
    }
}
