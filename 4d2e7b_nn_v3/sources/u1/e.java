package u1;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.autofill.HintConstants;
import androidx.webkit.ProxyConfig;
import com.adjust.sdk.Constants;
import java.io.File;
import java.io.FileFilter;
import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static final FileFilter f24258a = new a();

    public static class a implements FileFilter {
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i10 = 3; i10 < name.length(); i10++) {
                if (name.charAt(i10) < '0' || name.charAt(i10) > '9') {
                    return false;
                }
            }
            return true;
        }
    }

    public static String a(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String b(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkOperatorName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String d() {
        return String.format(Locale.ENGLISH, Build.MANUFACTURER, new Object[0]);
    }

    public static String e() {
        return String.format(Locale.ENGLISH, Build.MODEL, new Object[0]);
    }

    public static String f() {
        return String.format(Locale.ENGLISH, Build.PRODUCT, new Object[0]);
    }

    public static String g(Context context) {
        DisplayMetrics displayMetrics;
        try {
            if (context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
                return "0*0";
            }
            int i10 = displayMetrics.widthPixels;
            int i11 = displayMetrics.heightPixels;
            return i10 + ProxyConfig.MATCH_ALL_SCHEMES + i11;
        } catch (Throwable unused) {
            return "0*0";
        }
    }

    public static String h() {
        return Build.DEVICE.toLowerCase();
    }

    public static String i() {
        return String.format(Locale.ENGLISH, Build.VERSION.RELEASE, new Object[0]);
    }

    public static int j() {
        return Build.VERSION.SDK_INT;
    }

    public static String k() {
        String str;
        long rawOffset = (long) (TimeZone.getDefault().getRawOffset() / Constants.ONE_HOUR);
        int i10 = (rawOffset > 0 ? 1 : (rawOffset == 0 ? 0 : -1));
        if (i10 > 0) {
            str = "+" + rawOffset;
        } else if (i10 < 0) {
            str = "-" + rawOffset;
        } else {
            str = "" + rawOffset;
        }
        return str.replace("--", "-");
    }

    public static String l() {
        if (Build.VERSION.SDK_INT >= 26) {
            return ZoneId.systemDefault().getId();
        }
        return TimeZone.getDefault().getID();
    }
}
