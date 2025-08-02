package q;

import android.os.Build;
import android.text.TextUtils;
import com.mah.sdk.MahProxy;
import d.h;
import i.v;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;

public class j extends d {
    public j(int i10, String str, String str2, String str3) {
        super(1, i10, str, str2, str3, System.currentTimeMillis());
    }

    public static d b(h hVar, String str) {
        int i10;
        String str2;
        int a10 = hVar.a();
        if (a10 == -14) {
            str2 = hVar.getMessage();
            i10 = 9;
        } else if (a10 == -2) {
            str2 = hVar.getMessage();
            i10 = 3;
        } else if (a10 == -11) {
            str2 = d();
            i10 = 7;
        } else if (a10 == -10) {
            str2 = hVar.getMessage();
            i10 = 6;
        } else if (a10 == -8) {
            str2 = hVar.getMessage();
            i10 = 5;
        } else if (a10 != -7) {
            i10 = -1;
            if (a10 == -6) {
                str2 = v.e(hVar);
            } else if (a10 != -5) {
                switch (a10) {
                    case -20:
                        str2 = hVar.getMessage();
                        i10 = 12;
                        break;
                    case -19:
                        str2 = hVar.getMessage();
                        i10 = 11;
                        break;
                    case -18:
                        str2 = hVar.getMessage();
                        i10 = 10;
                        break;
                    case -17:
                        str2 = hVar.getMessage();
                        i10 = 8;
                        break;
                    default:
                        str2 = v.e(hVar) + ",errorCode=" + hVar.a();
                        break;
                }
            } else {
                str2 = String.valueOf(Build.VERSION.SDK_INT);
                i10 = 1;
            }
        } else {
            str2 = hVar.getMessage();
            i10 = 4;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = v.e(hVar) + ",errorCode=" + hVar.a();
        }
        return new j(i10, str, MahProxy.getVersion(), str2);
    }

    public static d c(Throwable th, String str) {
        if (th instanceof h) {
            return b((h) th, str);
        }
        String e10 = v.e(th);
        String message = th.getMessage();
        String.format(Locale.US, "Unknown error(%s)", new Object[]{message});
        return new j(-1, str, MahProxy.getVersion(), e10);
    }

    public static String d() {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/system/etc/hosts"), 1024);
            try {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        String sb3 = sb2.toString();
                        v.f(bufferedReader2);
                        return sb3;
                    } else if (readLine.contains("localhost")) {
                        sb2.append(readLine);
                        sb2.append("|");
                    }
                }
            } catch (Exception unused) {
                bufferedReader = bufferedReader2;
                v.f(bufferedReader);
                return "";
            } catch (Throwable th) {
                v.f(bufferedReader2);
                throw th;
            }
        } catch (Exception unused2) {
            v.f(bufferedReader);
            return "";
        }
    }
}
