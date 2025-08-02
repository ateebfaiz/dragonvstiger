package b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mah.ndk.MahxServer;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter;
import i.c;
import i.v;
import java.io.File;
import java.io.FileInputStream;
import w.d;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f17127a = d.f("");

    public static File a(String str, File file, String str2) {
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            c.h(fileInputStream, file);
            File n10 = c.n(file, str2);
            fileInputStream.close();
            return n10;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static String b(Context context, String str) {
        File file;
        String[] strArr = context.getApplicationInfo().splitSourceDirs;
        if (strArr == null) {
            Log.w(f17127a, "No splitSourceDirs found");
            return "";
        }
        TextUtils.join(";", strArr);
        int length = strArr.length;
        int i10 = 0;
        while (i10 < length) {
            String str2 = strArr[i10];
            if (str2.endsWith("arm64_v8a.apk") || str2.endsWith("armeabi-v7a.apk")) {
                try {
                    File file2 = new File(context.getFilesDir(), "mah_tmp_apk");
                    if (file2.exists()) {
                        String str3 = f17127a;
                        file = c.n(file2, MahxServer.OooOoo0);
                        if (file == null) {
                            file2.getAbsolutePath();
                            if (!file2.delete()) {
                                Log.e(str3, "delete fail");
                            }
                        }
                    } else {
                        file = null;
                    }
                    if (file == null) {
                        file = a(str2, file2, str);
                    }
                    if (file == null) {
                        String str4 = f17127a;
                        Log.e(str4, str + " not found");
                        return "";
                    }
                    String absolutePath = file.getAbsolutePath();
                    String str5 = f17127a;
                    Log.i(str5, "found bundle libraryPath: " + absolutePath + " size " + file.length());
                    return absolutePath;
                } catch (Exception unused) {
                }
            } else {
                i10++;
            }
        }
        return "";
    }

    public static String c(Context context, String str) {
        String str2 = v.r(context) + str;
        File file = new File(str2);
        if (file.exists()) {
            Log.i(f17127a, str2 + " size " + file.length());
            return str2;
        }
        Log.w(f17127a, str2 + " not found, try bundle apk");
        return b(context, str);
    }

    public static String d(Context context, String str) {
        String str2 = SAPropertyFilter.LIB + str + ".so";
        d.l(f17127a, "load default %s", str2);
        System.loadLibrary(str);
        return c(context, str2);
    }
}
