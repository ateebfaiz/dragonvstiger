package w;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public static final String f24412b = "OooO0O0";

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleDateFormat f24413c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);

    /* renamed from: a  reason: collision with root package name */
    public final FileOutputStream f24414a;

    public b(Context context) {
        this.f24414a = d(context);
    }

    public static FileOutputStream d(Context context) {
        try {
            return new FileOutputStream(new File(context.getExternalFilesDir((String) null), "mah_sdk_log.log"));
        } catch (Exception e10) {
            Log.e(f24412b, "open log file", e10);
            return null;
        }
    }

    public static void e(int i10, String str, String str2) {
        if (((long) str2.length()) <= 3072) {
            Log.println(i10, str, str2);
            return;
        }
        while (str2.length() > 3072) {
            String substring = str2.substring(0, 3072);
            str2 = str2.replace(substring, "");
            Log.println(i10, str, substring);
        }
        Log.println(i10, str, str2);
    }

    public void a(String str, String str2) {
        e(4, str, str2);
    }

    public void b(String str, String str2) {
        e(6, str, str2);
    }

    public void c(String str, String str2) {
        e(5, str, str2);
    }
}
