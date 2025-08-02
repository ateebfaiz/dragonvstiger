package org.cocos2dx.javascript;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowManager;
import com.adjust.sdk.Constants;
import com.alibaba.pdns.f;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DeviceUtils {
    static final String TAG = "DeviceUtils";
    static List<String> notchDevices = new a();

    class a extends ArrayList {
        a() {
            add("oneplus 6 a6000");
        }
    }

    public static int dp2px(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean fixOrientation(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static int getBottomNotchHeight(Activity activity) {
        DisplayCutout a10;
        List a11;
        int i10 = 0;
        if (!(Build.VERSION.SDK_INT < 28 || (a10 = activity.getWindow().getDecorView().getRootWindowInsets().getDisplayCutout()) == null || (a11 = a10.getBoundingRects()) == null || a11.size() == 0)) {
            i10 = a10.getSafeInsetBottom();
        }
        Log.e("notchbottomHeight  : ", String.valueOf(i10));
        return i10;
    }

    private static int[] getHuaWeiNotchSize(Context context) {
        int[] iArr = {0, 0};
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return (int[]) loadClass.getMethod("getNotchSize", (Class[]) null).invoke(loadClass, (Object[]) null);
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return iArr;
        }
    }

    private static int getMeiZuNotHeight(Context context) {
        int identifier = context.getResources().getIdentifier("fringe_height", "dimen", f.f17924q);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getMemorySize(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return (int) Math.ceil(((double) memoryInfo.totalMem) / 1.073741824E9d);
    }

    public static int getRestMemorySize(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return (int) Math.ceil(((double) memoryInfo.availMem) / 1048576.0d);
    }

    public static int getScreenHeight(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", f.f17924q);
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x017e, code lost:
        if (notchDevices.contains(android.os.Build.MODEL.toLowerCase()) != false) goto L_0x0148;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getTopNotchHeight(android.app.Activity r6) {
        /*
            boolean r0 = hasNotchInScreen(r6)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r2 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "sdk_int: "
            android.util.Log.e(r3, r2)
            r2 = 28
            r3 = 1
            if (r0 < r2) goto L_0x00f8
            android.view.Window r0 = r6.getWindow()
            android.view.View r0 = r0.getDecorView()
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            android.view.DisplayCutout r0 = r0.getDisplayCutout()
            if (r0 == 0) goto L_0x0181
            android.content.res.Resources r2 = r6.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.orientation
            if (r2 != r3) goto L_0x00e6
            java.util.List r2 = r0.getBoundingRects()
            if (r2 == 0) goto L_0x0181
            int r3 = r2.size()
            if (r3 != 0) goto L_0x0044
            goto L_0x0181
        L_0x0044:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "rect size:"
            r1.append(r3)
            int r3 = r2.size()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "notch"
            android.util.Log.e(r3, r1)
            java.util.Iterator r1 = r2.iterator()
        L_0x0062:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00d3
            java.lang.Object r2 = r1.next()
            android.graphics.Rect r2 = (android.graphics.Rect) r2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "cutout.getSafeInsetTop():"
            r4.append(r5)
            int r5 = r0.getSafeInsetTop()
            r4.append(r5)
            java.lang.String r5 = ", cutout.getSafeInsetBottom():"
            r4.append(r5)
            int r5 = r0.getSafeInsetBottom()
            r4.append(r5)
            java.lang.String r5 = ", cutout.getSafeInsetLeft():"
            r4.append(r5)
            int r5 = r0.getSafeInsetLeft()
            r4.append(r5)
            java.lang.String r5 = ", cutout.getSafeInsetRight():"
            r4.append(r5)
            int r5 = r0.getSafeInsetRight()
            r4.append(r5)
            java.lang.String r5 = ", cutout.rects: right "
            r4.append(r5)
            int r5 = r2.right
            r4.append(r5)
            java.lang.String r5 = ", cutout.rects: left "
            r4.append(r5)
            int r5 = r2.left
            r4.append(r5)
            java.lang.String r5 = ", cutout.rects: top "
            r4.append(r5)
            int r5 = r2.top
            r4.append(r5)
            java.lang.String r5 = ", cutout.rects: bottom "
            r4.append(r5)
            int r2 = r2.bottom
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            android.util.Log.e(r3, r2)
            goto L_0x0062
        L_0x00d3:
            int r6 = getStatusBarHeight(r6)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r1 = "status bar height:"
            android.util.Log.e(r1, r6)
            int r1 = r0.getSafeInsetTop()
            goto L_0x0181
        L_0x00e6:
            int r6 = r0.getSafeInsetLeft()
            if (r6 != 0) goto L_0x00f2
            int r1 = r0.getSafeInsetRight()
            goto L_0x0181
        L_0x00f2:
            int r1 = r0.getSafeInsetLeft()
            goto L_0x0181
        L_0x00f8:
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "manufacturer="
            r2.append(r4)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "DeviceUtils"
            android.util.Log.d(r4, r2)
            java.lang.String r2 = "HUAWEI"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0125
            boolean r2 = hasNotchHw(r6)
            if (r2 == 0) goto L_0x0125
            int[] r6 = getHuaWeiNotchSize(r6)
            r1 = r6[r3]
            goto L_0x0181
        L_0x0125:
            java.lang.String r2 = "xiaomi"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0138
            boolean r2 = hasNotchXiaoMi(r6)
            if (r2 == 0) goto L_0x0138
            int r1 = getXiaoMiNotchHeight(r6)
            goto L_0x0181
        L_0x0138:
            java.lang.String r2 = "oppo"
            boolean r2 = r0.equalsIgnoreCase(r2)
            r3 = 80
            if (r2 == 0) goto L_0x014a
            boolean r2 = hasNotchOPPO(r6)
            if (r2 == 0) goto L_0x014a
        L_0x0148:
            r1 = r3
            goto L_0x0181
        L_0x014a:
            java.lang.String r2 = "vivo"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x015f
            boolean r2 = hasNotchVIVO(r6)
            if (r2 == 0) goto L_0x015f
            r0 = 1107296256(0x42000000, float:32.0)
            int r1 = dp2px(r6, r0)
            goto L_0x0181
        L_0x015f:
            java.lang.String r2 = "meizu"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0172
            boolean r0 = hasNotchMeizu(r6)
            if (r0 == 0) goto L_0x0172
            int r1 = getMeiZuNotHeight(r6)
            goto L_0x0181
        L_0x0172:
            java.lang.String r6 = android.os.Build.MODEL
            java.util.List<java.lang.String> r0 = notchDevices
            java.lang.String r6 = r6.toLowerCase()
            boolean r6 = r0.contains(r6)
            if (r6 == 0) goto L_0x0181
            goto L_0x0148
        L_0x0181:
            java.lang.String r6 = "notchHeight  : "
            java.lang.String r0 = java.lang.String.valueOf(r1)
            android.util.Log.e(r6, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.javascript.DeviceUtils.getTopNotchHeight(android.app.Activity):int");
    }

    public static String getUniq(Context context) {
        String str;
        if (Build.VERSION.SDK_INT >= 28) {
            str = Settings.System.getString(context.getContentResolver(), "android_id");
            Log.d(TAG, "API>=28,android.os.Build.SERIAL=" + str);
        } else {
            try {
                str = Build.class.getField("SERIAL").get((Object) null).toString();
                Log.d(TAG, "api>=9,android.os.Build.SERIAL=" + str);
            } catch (Exception unused) {
                Log.d(TAG, "api<9,serial=" + "serial");
                str = "serial";
            }
        }
        String uuid = new UUID((long) ("35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10)).hashCode(), (long) str.hashCode()).toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("uuid=");
        sb2.append(uuid);
        Log.d(TAG, sb2.toString());
        return uuid;
    }

    private static int getXiaoMiNotchHeight(Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", f.f17924q);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static boolean hasNotchHw(Activity activity) {
        try {
            Class<?> loadClass = activity.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", (Class[]) null).invoke(loadClass, (Object[]) null)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean hasNotchInScreen(Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            String str = Build.MANUFACTURER;
            Log.d(TAG, "manufacturer=" + str);
            if (str.equalsIgnoreCase("HUAWEI")) {
                return hasNotchHw(activity);
            }
            if (str.equalsIgnoreCase(Constants.REFERRER_API_XIAOMI)) {
                return hasNotchXiaoMi(activity);
            }
            if (str.equalsIgnoreCase("oppo")) {
                return hasNotchOPPO(activity);
            }
            if (str.equalsIgnoreCase("vivo")) {
                return hasNotchVIVO(activity);
            }
            if (str.equalsIgnoreCase("meizu")) {
                return hasNotchMeizu(activity);
            }
            return notchDevices.contains(Build.MODEL.toLowerCase());
        } else if (activity.getWindow().getDecorView().getRootWindowInsets().getDisplayCutout() != null) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean hasNotchMeizu(Activity activity) {
        try {
            return ((Boolean) Class.forName("flyme.config.FlymeFeature").getDeclaredField("IS_FRINGE_DEVICE").get((Object) null)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean hasNotchOPPO(Activity activity) {
        return activity.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    private static boolean hasNotchVIVO(Activity activity) {
        try {
            Class<?> cls = Class.forName("android.util.FtFeature");
            return ((Boolean) cls.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(cls, new Object[]{32})).booleanValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    private static boolean hasNotchXiaoMi(Activity activity) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            if (((Integer) cls.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(cls, new Object[]{"ro.miui.notch", 0})).intValue() == 1) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean isTranslucentOrFloating(Activity activity) {
        boolean z10 = false;
        try {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get((Object) null));
            try {
                Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", new Class[]{TypedArray.class});
                method.setAccessible(true);
                boolean booleanValue = ((Boolean) method.invoke((Object) null, new Object[]{obtainStyledAttributes})).booleanValue();
                try {
                    method.setAccessible(false);
                    return booleanValue;
                } catch (Exception e10) {
                    e = e10;
                    z10 = booleanValue;
                }
            } catch (Exception e11) {
                e = e11;
                e.printStackTrace();
                return z10;
            }
        } catch (Exception e12) {
            e = e12;
            e.printStackTrace();
            return z10;
        }
    }
}
