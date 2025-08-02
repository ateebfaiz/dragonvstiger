package u1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

public abstract class n {
    public static String a(Context context) {
        try {
            Object systemService = context.getApplicationContext().getSystemService("country_detector");
            if (systemService == null) {
                return "";
            }
            Object invoke = systemService.getClass().getDeclaredMethod("detectCountry", (Class[]) null).invoke(systemService, (Object[]) null);
            if (invoke == null) {
                return "";
            }
            String str = (String) invoke.getClass().getDeclaredMethod("getCountryIso", (Class[]) null).invoke(invoke, (Object[]) null);
            int intValue = ((Integer) invoke.getClass().getDeclaredMethod("getSource", (Class[]) null).invoke(invoke, (Object[]) null)).intValue();
            if (intValue == 0 || intValue == 1) {
                return str;
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int c(Context context) {
        try {
            String str = context.getApplicationInfo().sourceDir;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            if (str.startsWith("/system/app/")) {
                return 1;
            }
            str.startsWith("/data/app/");
            return 0;
        } catch (Throwable unused) {
        }
    }
}
