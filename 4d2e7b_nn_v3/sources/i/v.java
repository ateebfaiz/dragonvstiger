package i;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.games.paddleboat.GameControllerManager;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import o.g;
import w.d;

public abstract class v {

    /* renamed from: a  reason: collision with root package name */
    public static final String f22033a = d.f("");

    /* renamed from: b  reason: collision with root package name */
    public static final Random f22034b = new Random();

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicReference f22035c = new AtomicReference("unknown");

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicReference f22036d = new AtomicReference();

    public static String a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null || TextUtils.isEmpty(applicationInfo.packageName)) {
            return context.getPackageName();
        }
        return applicationInfo.packageName;
    }

    public static Context b(Context context) {
        if (!(context instanceof Application)) {
            return context.getApplicationContext();
        }
        return context;
    }

    public static String c() {
        return (String) f22035c.get();
    }

    public static String d(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        if (useDelimiter.hasNext()) {
            return useDelimiter.next();
        }
        return "";
    }

    public static String e(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        th.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        return stringWriter.toString().replace("\t", "").replace(10, '-');
    }

    public static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void g(List list, String str) {
        if (!TextUtils.isEmpty(str) && !str.contains("%")) {
            list.add(str);
        }
    }

    public static String[] h(String str, String str2) {
        try {
            return str.split(str2);
        } catch (PatternSyntaxException unused) {
            return null;
        }
    }

    public static String i() {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());
    }

    public static String j(Context context) {
        return context.getFilesDir().getAbsolutePath();
    }

    public static boolean k(String str) {
        Matcher matcher = Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str);
        Matcher matcher2 = Pattern.compile("^((([0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){1,7}:)|(([0-9A-Fa-f]{1,4}:){6}:[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){5}(:[0-9A-Fa-f]{1,4}){1,2})|(([0-9A-Fa-f]{1,4}:){4}(:[0-9A-Fa-f]{1,4}){1,3})|(([0-9A-Fa-f]{1,4}:){3}(:[0-9A-Fa-f]{1,4}){1,4})|(([0-9A-Fa-f]{1,4}:){2}(:[0-9A-Fa-f]{1,4}){1,5})|([0-9A-Fa-f]{1,4}:(:[0-9A-Fa-f]{1,4}){1,6})|(:(:[0-9A-Fa-f]{1,4}){1,7})|(([0-9A-Fa-f]{1,4}:){6}(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){5}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){4}(:[0-9A-Fa-f]{1,4}){0,1}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){3}(:[0-9A-Fa-f]{1,4}){0,2}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){2}(:[0-9A-Fa-f]{1,4}){0,3}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|([0-9A-Fa-f]{1,4}:(:[0-9A-Fa-f]{1,4}){0,4}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(:(:[0-9A-Fa-f]{1,4}){0,5}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}))$").matcher(str);
        if (matcher.find() || matcher2.find()) {
            return true;
        }
        return false;
    }

    public static Random l() {
        return f22034b;
    }

    public static void m(String str) {
        f22035c.set(str);
    }

    public static List n(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return q(context);
        }
        ArrayList arrayList = new ArrayList();
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i10 = 0; i10 < 4; i10++) {
                String str = (String) method.invoke((Object) null, new Object[]{strArr[i10]});
                if (str != null && ((str.matches("^\\d+(\\.\\d+){3}$") || str.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) && !arrayList.contains(str))) {
                    arrayList.add(str);
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static ConnectivityManager o(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static boolean p() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public static List q(Context context) {
        LinkProperties linkProperties;
        ArrayList arrayList = new ArrayList();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork())) == null) {
                return arrayList;
            }
            for (InetAddress next : linkProperties.getDnsServers()) {
                if (!next.isLinkLocalAddress()) {
                    String hostAddress = next.getHostAddress();
                    if (next instanceof Inet4Address) {
                        g(arrayList, hostAddress);
                    } else if (next instanceof Inet6Address) {
                        g(arrayList, hostAddress);
                    }
                }
            }
            return arrayList;
        } catch (Throwable unused) {
        }
    }

    public static String r(Context context) {
        return context.getApplicationInfo().nativeLibraryDir + DomExceptionUtils.SEPARATOR;
    }

    public static String s(Context context) {
        if (context == null) {
            return null;
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return null;
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == myPid) {
                    return next.processName;
                }
            }
            return null;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static DisplayMetrics t(Context context) {
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return null;
            }
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String u(Context context) {
        return w(context);
    }

    public static String v(Context context) {
        AtomicReference atomicReference = f22036d;
        String str = (String) atomicReference.get();
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        File externalFilesDir = context.getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            atomicReference.set(externalFilesDir.getAbsolutePath());
        }
        TextUtils.isEmpty((CharSequence) atomicReference.get());
        return (String) atomicReference.get();
    }

    public static String w(Context context) {
        LinkProperties linkProperties;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!(connectivityManager == null || (linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork())) == null)) {
                return linkProperties.getDomains();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String x(Context context) {
        SigningInfo a10;
        try {
            PackageManager packageManager = context.getPackageManager();
            String a11 = a(context);
            if (Build.VERSION.SDK_INT >= 28) {
                PackageInfo packageInfo = packageManager.getPackageInfo(a11, GameControllerManager.DEVICEFLAG_VIBRATION);
                if (!(packageInfo == null || (a10 = packageInfo.signingInfo) == null)) {
                    Signature[] a12 = a10.getApkContentsSigners();
                    int length = a12.length;
                    if (a12.length > 0) {
                        return p.f(a12[0].toByteArray());
                    }
                }
            } else {
                PackageInfo packageInfo2 = packageManager.getPackageInfo(a11, 64);
                if (packageInfo2 != null) {
                    Signature[] signatureArr = packageInfo2.signatures;
                    if (signatureArr.length > 0) {
                        return p.f(signatureArr[0].toByteArray());
                    }
                }
            }
        } catch (Throwable th) {
            g.a().c(th, "getAppMd5Signature");
        }
        return "";
    }
}
