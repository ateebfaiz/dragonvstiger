package com.cocos.lib;

import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.ParcelFileDescriptor;
import android.os.Vibrator;
import android.util.Log;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.alibaba.pdns.f;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class CocosHelper {
    public static final int NETWORK_TYPE_LAN = 1;
    public static final int NETWORK_TYPE_NONE = 0;
    public static final int NETWORK_TYPE_WWAN = 2;
    private static final String TAG = "CocosHelper";
    private static d sBatteryReceiver = new d();
    private static e sForegroundTaskQOnGameThread = new e();
    private static boolean sInited = false;
    private static com.android.vending.expansion.zipfile.b sOBBFile = null;
    private static String sObbFilePath = "";
    private static e sTaskQOnGameThread = new e();
    private static Vibrator sVibrateService;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19280a;

        a(String str) {
            this.f19280a = str;
        }

        public void run() {
            ((ClipboardManager) GlobalObject.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", this.f19280a));
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            GlobalObject.getActivity().finish();
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f19281a;

        c(boolean z10) {
            this.f19281a = z10;
        }

        public void run() {
            if (this.f19281a) {
                GlobalObject.getActivity().getWindow().addFlags(128);
            } else {
                GlobalObject.getActivity().getWindow().clearFlags(128);
            }
        }
    }

    static class d extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public float f19282a = 0.0f;

        d() {
        }

        public void a(Intent intent) {
            if (intent != null) {
                this.f19282a = Math.min(Math.max((((float) intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0)) * 1.0f) / ((float) intent.getIntExtra("scale", 1)), 0.0f), 1.0f);
            }
        }

        public void onReceive(Context context, Intent intent) {
            a(intent);
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        private final Object f19283a = new Object();

        /* renamed from: b  reason: collision with root package name */
        private Queue f19284b = new LinkedList();

        e() {
        }

        public void a(Runnable runnable) {
            synchronized (this.f19283a) {
                this.f19284b.add(runnable);
            }
        }

        public void b() {
            Queue<Runnable> queue;
            synchronized (this.f19283a) {
                queue = this.f19284b;
                this.f19284b = new LinkedList();
            }
            for (Runnable run : queue) {
                run.run();
            }
        }
    }

    public static void copyTextToClipboard(String str) {
        GlobalObject.runOnUiThread(new a(str));
    }

    public static void finishActivity() {
        if (GlobalObject.getActivity() == null) {
            Log.e(TAG, "activity is null");
        } else {
            GlobalObject.runOnUiThread(new b());
        }
    }

    static void flushTasksOnGameThread() {
        sTaskQOnGameThread.b();
    }

    static void flushTasksOnGameThreadAtForeground() {
        sForegroundTaskQOnGameThread.b();
    }

    public static float getBatteryLevel() {
        return sBatteryReceiver.f19282a;
    }

    public static String getCurrentLanguage() {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleList.getDefault().get(0).getLanguage();
        }
        return Locale.getDefault().getLanguage();
    }

    public static String getCurrentLanguageCode() {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleList.getDefault().get(0).toString();
        }
        return Locale.getDefault().toString();
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static int getDeviceRotation() {
        try {
            return ((WindowManager) GlobalObject.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        } catch (NullPointerException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static int getNetworkType() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) GlobalObject.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                return 2;
            }
            if (type == 1) {
                return 1;
            }
            return 0;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static long[] getObbAssetFileDescriptor(String str) {
        AssetFileDescriptor c10;
        long[] jArr = new long[3];
        com.android.vending.expansion.zipfile.b bVar = sOBBFile;
        if (!(bVar == null || (c10 = bVar.c(str)) == null)) {
            try {
                ParcelFileDescriptor parcelFileDescriptor = c10.getParcelFileDescriptor();
                jArr[0] = (long) ((Integer) parcelFileDescriptor.getClass().getMethod("getFd", (Class[]) null).invoke(parcelFileDescriptor, (Object[]) null)).intValue();
                jArr[1] = c10.getStartOffset();
                jArr[2] = c10.getLength();
            } catch (NoSuchMethodException unused) {
                Log.e(TAG, "Accessing file descriptor directly from the OBB is only supported from Android 3.1 (API level 12) and above.");
            } catch (IllegalAccessException e10) {
                Log.e(TAG, e10.toString());
            } catch (InvocationTargetException e11) {
                Log.e(TAG, e11.toString());
            }
        }
        return jArr;
    }

    public static String getObbFilePath() {
        return sObbFilePath;
    }

    public static float[] getSafeArea() {
        WindowInsets rootWindowInsets;
        if (GlobalObject.getActivity() == null) {
            Log.e(TAG, "activity is null");
            return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        }
        if (Build.VERSION.SDK_INT >= 28 && (rootWindowInsets = GlobalObject.getActivity().getWindow().getDecorView().getRootWindowInsets()) != null) {
            try {
                Object invoke = WindowInsets.class.getMethod("getDisplayCutout", (Class[]) null).invoke(rootWindowInsets, (Object[]) null);
                if (invoke != null) {
                    Class<?> cls = invoke.getClass();
                    Method method = cls.getMethod("getSafeInsetLeft", (Class[]) null);
                    Method method2 = cls.getMethod("getSafeInsetRight", (Class[]) null);
                    Method method3 = cls.getMethod("getSafeInsetBottom", (Class[]) null);
                    Method method4 = cls.getMethod("getSafeInsetTop", (Class[]) null);
                    if (!(method == null || method2 == null || method3 == null || method4 == null)) {
                        int intValue = ((Integer) method.invoke(invoke, (Object[]) null)).intValue();
                        int intValue2 = ((Integer) method2.invoke(invoke, (Object[]) null)).intValue();
                        float f10 = (float) intValue2;
                        return new float[]{(float) ((Integer) method4.invoke(invoke, (Object[]) null)).intValue(), (float) intValue, (float) ((Integer) method3.invoke(invoke, (Object[]) null)).intValue(), f10};
                    }
                }
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getWritablePath() {
        return GlobalObject.getContext().getFilesDir().getAbsolutePath();
    }

    public static void init() {
        if (!sInited) {
            sVibrateService = (Vibrator) GlobalObject.getContext().getSystemService("vibrator");
            initObbFilePath();
            initializeOBBFile();
            sInited = true;
        }
    }

    private static void initObbFilePath() {
        int i10;
        ApplicationInfo applicationInfo = GlobalObject.getContext().getApplicationInfo();
        try {
            i10 = GlobalObject.getContext().getPackageManager().getPackageInfo(applicationInfo.packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            i10 = 1;
        }
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/obb/" + applicationInfo.packageName + "/main." + i10 + f.G + applicationInfo.packageName + ".obb";
        if (new File(str).exists()) {
            sObbFilePath = str;
        }
    }

    private static void initializeOBBFile() {
        int i10;
        try {
            i10 = GlobalObject.getContext().getPackageManager().getPackageInfo(GlobalObject.getContext().getApplicationInfo().packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            i10 = 1;
        }
        try {
            sOBBFile = com.android.vending.expansion.zipfile.a.b(GlobalObject.getContext(), i10, 0);
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public static boolean openURL(String str) {
        if (GlobalObject.getActivity() == null) {
            Log.e(TAG, "activity is null");
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            GlobalObject.getActivity().startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    static void registerBatteryLevelReceiver(Context context) {
        sBatteryReceiver.a(context.registerReceiver(sBatteryReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED")));
    }

    public static void runOnGameThread(Runnable runnable) {
        sTaskQOnGameThread.a(runnable);
    }

    public static void runOnGameThreadAtForeground(Runnable runnable) {
        sForegroundTaskQOnGameThread.a(runnable);
    }

    public static void setKeepScreenOn(boolean z10) {
        if (GlobalObject.getActivity() == null) {
            Log.e(TAG, "activity is null");
        } else {
            GlobalObject.runOnUiThread(new c(z10));
        }
    }

    public static boolean supportHPE() {
        return GlobalObject.getContext().getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE");
    }

    static void unregisterBatteryLevelReceiver(Context context) {
        context.unregisterReceiver(sBatteryReceiver);
    }

    public static void vibrate(float f10) {
        try {
            Vibrator vibrator = sVibrateService;
            if (vibrator != null && vibrator.hasVibrator()) {
                if (Build.VERSION.SDK_INT >= 26) {
                    Class<?> cls = Class.forName("android.os.VibrationEffect");
                    Integer num = (Integer) CocosReflectionHelper.getConstantValue(cls, "DEFAULT_AMPLITUDE");
                    num.intValue();
                    Method method = cls.getMethod("createOneShot", new Class[]{Long.TYPE, Integer.TYPE});
                    Class<?> returnType = method.getReturnType();
                    Object invoke = method.invoke(cls, new Object[]{Long.valueOf((long) (f10 * 1000.0f)), num});
                    CocosReflectionHelper.invokeInstanceMethod(sVibrateService, "vibrate", new Class[]{returnType}, new Object[]{invoke});
                    return;
                }
                sVibrateService.vibrate((long) (f10 * 1000.0f));
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
