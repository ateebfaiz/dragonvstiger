package com.zing.zalo.zalosdk.core.helper;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mah.sdk.OooO00o;
import com.zing.zalo.devicetrackingsdk.DeviceTracking;
import com.zing.zalo.devicetrackingsdk.GetPreloadSettingAsyncTask;
import com.zing.zalo.devicetrackingsdk.ZPermissionManager;
import com.zing.zalo.devicetrackingsdk.model.PreloadInfo;
import com.zing.zalo.zalosdk.core.SettingsManager;
import com.zing.zalo.zalosdk.core.exception.PreloadException;
import com.zing.zalo.zalosdk.core.log.Log;
import com.zing.zalo.zalosdk.core.type.ConnectionType;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceHelper {
    static String MNO;
    static String WLANMacAddress;
    static String advertiserId;
    static Location location;
    private static final Object lock = new Object();
    public static PreloadInfo preloadInfo;
    private static String processName;
    static String screenSize;

    public interface PreloadReadListener {
        void onResult(boolean z10, String str);
    }

    public static String getAdvertiseID(Context context) {
        Object invokeMethodQuietly;
        String str;
        String str2 = advertiserId;
        if (str2 != null) {
            return str2;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("adsid", 0);
        try {
            String string = sharedPreferences.getString("adsidstr", (String) null);
            advertiserId = string;
            if (string != null) {
                return string;
            }
            if (Looper.myLooper() != Looper.getMainLooper()) {
                Method methodQuietly = getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class});
                if (!(methodQuietly == null || (invokeMethodQuietly = invokeMethodQuietly((Object) null, methodQuietly, context)) == null)) {
                    Method methodQuietly2 = getMethodQuietly(invokeMethodQuietly.getClass(), "getId", (Class<?>[]) new Class[0]);
                    Method methodQuietly3 = getMethodQuietly(invokeMethodQuietly.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
                    if (!(methodQuietly2 == null || methodQuietly3 == null || (str = (String) invokeMethodQuietly(invokeMethodQuietly, methodQuietly2, new Object[0])) == null || str.length() <= 0)) {
                        advertiserId = str;
                    }
                }
                String str3 = advertiserId;
                if (str3 != null && str3.length() > 0) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("adsidstr", advertiserId);
                    edit.apply();
                }
                return advertiserId;
            }
            throw new Exception("DeviceHelper.getAdvertiseID call on main thread!!");
        } catch (Exception e10) {
            Log.e("getAdvertiseID", e10);
        }
    }

    public static String getAndroidId(Context context) {
        return "unknown";
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getConnectionType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return "";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            if (activeNetworkInfo.getType() == 0) {
                return "mobile";
            }
            return "";
        } catch (Error | Exception unused) {
            return "";
        }
    }

    public static String getCurrentProcessName(Context context) {
        String str = processName;
        if (str != null) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (next.pid == myPid) {
                    processName = next.processName;
                }
            }
        } catch (Exception e10) {
            Log.e(e10);
            processName = "";
        }
        return processName;
    }

    @SuppressLint({"MissingPermission"})
    public static Location getLocation(Context context) {
        LocationManager locationManager;
        Location location2 = location;
        if (location2 != null) {
            return location2;
        }
        try {
            if ((ZPermissionManager.isPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION") || ZPermissionManager.isPermissionGranted(context, "android.permission.ACCESS_COARSE_LOCATION")) && (locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION)) != null) {
                location = locationManager.getLastKnownLocation("network");
            }
        } catch (Exception unused) {
        }
        return location;
    }

    @SuppressLint({"NewApi"})
    private static String getMACAddress(Context context, String str) {
        return "";
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    private static Method getMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static String getMobileNetworkCode(Context context) {
        String str = MNO;
        if (str != null) {
            return str;
        }
        try {
            if (ZPermissionManager.isPermissionGranted(context, "android.permission.READ_PHONE_STATE")) {
                MNO = ((TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getSimOperator();
            } else {
                MNO = "unknown";
            }
        } catch (Exception unused) {
            MNO = "unknown";
        }
        return MNO;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return "";
            }
            if (activeNetworkInfo.getType() == 1) {
                return String.valueOf(ConnectionType.WIFI.getCode());
            }
            if (activeNetworkInfo.getType() == 0) {
                return String.valueOf(ConnectionType.MOBILE.getCode());
            }
            return "";
        } catch (Error | Exception unused) {
            return "";
        }
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:13|14|15|16|17|18|19|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0022 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x0022=Splitter:B:15:0x0022, B:21:0x0037=Splitter:B:21:0x0037} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.zing.zalo.devicetrackingsdk.model.PreloadInfo getPreloadInfo(android.content.Context r4) {
        /*
            java.lang.Object r0 = lock
            monitor-enter(r0)
            com.zing.zalo.devicetrackingsdk.model.PreloadInfo r1 = preloadInfo     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return r1
        L_0x0009:
            r4 = move-exception
            goto L_0x0040
        L_0x000b:
            java.lang.String r1 = com.zing.zalo.zalosdk.core.helper.Utils.getSavedPreloadValue(r4)     // Catch:{ all -> 0x0009 }
            java.lang.String r2 = com.zing.zalo.zalosdk.core.helper.Utils.getExceptionFilePreload(r4)     // Catch:{ all -> 0x0009 }
            com.zing.zalo.devicetrackingsdk.model.PreloadInfo r3 = preloadInfo     // Catch:{ all -> 0x0009 }
            if (r3 != 0) goto L_0x0037
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0009 }
            if (r3 != 0) goto L_0x001e
            goto L_0x0037
        L_0x001e:
            readingPreloadNewMethod(r4)     // Catch:{ all -> 0x0022 }
            goto L_0x0025
        L_0x0022:
            readingPreloadOldMethod(r4)     // Catch:{ all -> 0x0009 }
        L_0x0025:
            com.zing.zalo.devicetrackingsdk.model.PreloadInfo r1 = preloadInfo     // Catch:{ all -> 0x0009 }
            java.lang.String r1 = r1.preload     // Catch:{ all -> 0x0009 }
            com.zing.zalo.zalosdk.core.helper.Utils.savePreloadValue(r4, r1)     // Catch:{ all -> 0x0009 }
            com.zing.zalo.devicetrackingsdk.model.PreloadInfo r1 = preloadInfo     // Catch:{ all -> 0x0009 }
            java.lang.String r1 = r1.error     // Catch:{ all -> 0x0009 }
            com.zing.zalo.zalosdk.core.helper.Utils.saveExceptionFilePreload(r4, r1)     // Catch:{ all -> 0x0009 }
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            com.zing.zalo.devicetrackingsdk.model.PreloadInfo r4 = preloadInfo
            return r4
        L_0x0037:
            com.zing.zalo.devicetrackingsdk.model.PreloadInfo r3 = new com.zing.zalo.devicetrackingsdk.model.PreloadInfo     // Catch:{ all -> 0x0009 }
            r3.<init>(r4, r1, r2)     // Catch:{ all -> 0x0009 }
            preloadInfo = r3     // Catch:{ all -> 0x0009 }
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return r3
        L_0x0040:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zing.zalo.zalosdk.core.helper.DeviceHelper.getPreloadInfo(android.content.Context):com.zing.zalo.devicetrackingsdk.model.PreloadInfo");
    }

    public static String getProduct() {
        return Build.PRODUCT;
    }

    public static String getScreenSize(Context context) {
        String str = screenSize;
        if (str != null) {
            return str;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            screenSize = point.x + "x" + point.y;
        } catch (Exception unused) {
            screenSize = "unknown";
        }
        return screenSize;
    }

    public static String getSerial() {
        return "unknown";
    }

    private static String getVivoPreloadPath(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Class<String> cls2 = String.class;
            return (String) cls.getMethod("get", new Class[]{cls2, cls2}).invoke(cls, new Object[]{str, "null"});
        } catch (Exception e10) {
            e10.printStackTrace();
            return str2;
        }
    }

    public static String getWLANMACAddress(Context context) {
        String str = WLANMacAddress;
        if (str != null) {
            return str;
        }
        String mACAddress = getMACAddress(context, OooO00o.OooO0oO);
        WLANMacAddress = mACAddress;
        return mACAddress;
    }

    private static Object invokeMethodQuietly(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean isTablet(Context context) {
        if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
            return true;
        }
        return false;
    }

    public static float pxFromDp(Context context, float f10) {
        return f10 * context.getResources().getDisplayMetrics().density;
    }

    public static void readingPreloadNewMethod(Context context) throws Throwable {
        boolean z10 = false;
        boolean z11 = true;
        preloadInfo = new PreloadInfo(context);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            Class<String> cls = String.class;
            String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{"ro.trackingId." + AppInfo.getPackageName(context), ""});
            if (!TextUtils.isEmpty(str)) {
                preloadInfo.preload = str;
            } else {
                jSONObject.put(NotificationCompat.CATEGORY_ERROR, "-2");
                z10 = true;
            }
            z11 = z10;
        } catch (Throwable th) {
            jSONObject.put(NotificationCompat.CATEGORY_ERROR, "-1: " + th.getMessage());
        }
        jSONArray.put(jSONObject);
        preloadInfo.error = jSONArray.toString();
        if (z11) {
            throw new PreloadException("Failed to get preload while using new method !");
        }
    }

    private static void readingPreloadOldMethod(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("/cust/etc/zalo_appchannel.in");
        arrayList.add(getVivoPreloadPath("ro.preinstall.path", "") + "zalo_appchannel.in");
        arrayList.add("/data/etc/appchannel/zalo_appchannel.in");
        arrayList.add("/data/etc/appchannel");
        arrayList.add("/system/etc/zalo_appchannel.in");
        arrayList.add("/my_preload/etc/appchannel/zalo_appchannel.in");
        int i10 = 0;
        try {
            preloadInfo = new PreloadInfo(context);
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fileCode", arrayList.indexOf(str));
                jSONObject.put("filePath", str);
                try {
                    String readTextFile = Utils.readTextFile(str);
                    if (TextUtils.isEmpty(readTextFile)) {
                        jSONObject.put(NotificationCompat.CATEGORY_ERROR, "-4");
                    } else if (readTextFile.contains(":")) {
                        String[] split = readTextFile.split(":");
                        if (split.length == 2) {
                            preloadInfo.preload = split[1].trim();
                            jSONArray.put(jSONObject);
                            break;
                        }
                    } else {
                        jSONObject.put(NotificationCompat.CATEGORY_ERROR, "-3");
                    }
                } catch (FileNotFoundException unused) {
                    jSONObject.put(NotificationCompat.CATEGORY_ERROR, "-2");
                    i10++;
                } catch (Exception e10) {
                    jSONObject.put(NotificationCompat.CATEGORY_ERROR, "-1: " + e10.getMessage());
                }
                jSONArray.put(jSONObject);
            }
            preloadInfo.error = jSONArray.toString();
        } catch (JSONException e11) {
            Log.e("readingPreloadOldMethod", (Exception) e11);
        }
        if (i10 == arrayList.size()) {
            PreloadInfo preloadInfo2 = preloadInfo;
            preloadInfo2.preload = "";
            preloadInfo2.error = "";
        }
    }

    private static Method getMethodQuietly(String str, String str2, Class<?>... clsArr) {
        try {
            return getMethodQuietly(Class.forName(str), str2, clsArr);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static void getPreloadInfo(final Context context, final PreloadReadListener preloadReadListener) {
        synchronized (lock) {
            try {
                getPreloadInfo(context);
                if (preloadInfo.isPreloaded() || !SettingsManager.getInstance().isExpiredPreloadSetting(context)) {
                    preloadReadListener.onResult(preloadInfo.isPreloaded(), preloadInfo.preload);
                } else {
                    DeviceTracking.getInstance().getDeviceId(new DeviceTracking.GetInfoListener() {
                        public void onGetDeviceIdComplete(String str) {
                            new GetPreloadSettingAsyncTask(context, new GetPreloadSettingAsyncTask.Callback() {
                                public void onFailed(int i10, String str) {
                                    Log.e("getPreloadInfo", "Error message: " + str);
                                    PreloadReadListener preloadReadListener = preloadReadListener;
                                    if (preloadReadListener != null) {
                                        preloadReadListener.onResult(DeviceHelper.preloadInfo.isPreloaded(), DeviceHelper.preloadInfo.preload);
                                    }
                                }

                                public void onSuccess() {
                                    PreloadInfo preloadInfo;
                                    PreloadReadListener preloadReadListener = preloadReadListener;
                                    if (preloadReadListener != null && (preloadInfo = DeviceHelper.preloadInfo) != null) {
                                        preloadReadListener.onResult(preloadInfo.isPreloaded(), DeviceHelper.preloadInfo.preload);
                                    }
                                }
                            }, str).execute(new Context[0]);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
