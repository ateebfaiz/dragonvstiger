package m9;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.util.Locale;

class e {

    /* renamed from: a  reason: collision with root package name */
    private final PackageInfo f12811a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12812b;

    /* renamed from: c  reason: collision with root package name */
    private String f12813c;

    e(Context context, String str) {
        this.f12811a = a(context);
        this.f12812b = str;
    }

    private static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            throw null;
        }
    }

    public String b() {
        String str;
        String str2 = this.f12813c;
        if (str2 != null) {
            return str2;
        }
        PackageInfo packageInfo = this.f12811a;
        String str3 = "UNK";
        if (packageInfo == null) {
            str = str3;
        } else {
            str = packageInfo.packageName;
        }
        if (packageInfo != null) {
            str3 = packageInfo.versionName;
        }
        Locale locale = Locale.getDefault();
        String str4 = str + DomExceptionUtils.SEPARATOR + str3 + " ChannelSDK/" + this.f12812b + " (Linux; U; Android " + Build.VERSION.RELEASE + "; " + locale.getLanguage() + "-" + locale.getCountry() + "; " + Build.MODEL + " Build/" + Build.ID + ")";
        this.f12813c = str4;
        return str4;
    }
}
