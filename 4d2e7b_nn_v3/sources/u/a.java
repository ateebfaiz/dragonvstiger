package u;

import android.content.Context;
import android.os.Debug;
import java.io.File;

public abstract class a {
    public static String a(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b(Context context) {
        if (d(context) || Debug.isDebuggerConnected()) {
            return true;
        }
        return false;
    }

    public static boolean c() {
        if (e() == 0) {
            return true;
        }
        return f();
    }

    public static boolean d(Context context) {
        if ((context.getApplicationInfo().flags & 2) != 0) {
            return true;
        }
        return false;
    }

    public static int e() {
        String a10 = a("ro.secure");
        if (a10 != null && "0".equals(a10)) {
            return 0;
        }
        return 1;
    }

    public static boolean f() {
        String[] strArr = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i10 = 0; i10 < 9; i10++) {
            if (new File(strArr[i10]).exists()) {
                return true;
            }
        }
        return false;
    }
}
