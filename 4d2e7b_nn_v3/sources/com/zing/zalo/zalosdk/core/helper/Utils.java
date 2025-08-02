package com.zing.zalo.zalosdk.core.helper;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.alibaba.pdns.j;
import com.zing.zalo.zalosdk.Constant;
import com.zing.zalo.zalosdk.core.log.Log;
import com.zing.zalo.zalosdk.core.type.EventType;
import com.zing.zalo.zalosdk.oauth.ZaloSDKApplication;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utils {
    private static final String KEY_EXCEPTION_FILE_PRELOAD = "com.zing.zalo.sdk.preloadkey.exception";
    private static final String KEY_PRELOAD = "com.zing.zalo.sdk.preloadkey";

    public static void addEventZingAnalytics(EventType eventType, Map<String, String> map) {
        if (eventType != null) {
            try {
                addEventZingAnalytics(eventType.getEventName(), map);
            } catch (Exception unused) {
            }
        }
    }

    public static JSONObject addMapToJSONObject(JSONObject jSONObject, Map<String, String> map) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (map == null) {
            return jSONObject;
        }
        for (String next : map.keySet()) {
            try {
                jSONObject.put(next, map.get(next));
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public static boolean belowSandwich() {
        return false;
    }

    public static String encryptRSA(String str) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(Constant.PUBLIC_RSA, 0)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, generatePublic);
            return Base64.encodeToString(instance.doFinal(str.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String genCodeChallenge(String str) {
        try {
            byte[] bytes = str.getBytes("US-ASCII");
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bytes, 0, bytes.length);
            return Base64.encodeToString(instance.digest(), 11);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String genCodeVerifier() {
        byte[] bArr = new byte[32];
        new SecureRandom().nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }

    public static String getAdvertiseID(Context context) {
        return DeviceHelper.getAdvertiseID(context);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:5|6|(1:8)(1:12)) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r2.getInt(r3) != 0) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        return true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean getBoolean(org.json.JSONObject r2, java.lang.String r3) {
        /*
            boolean r0 = r2.has(r3)
            r1 = 0
            if (r0 == 0) goto L_0x0013
            boolean r2 = r2.getBoolean(r3)     // Catch:{ JSONException -> 0x000c }
            return r2
        L_0x000c:
            int r2 = r2.getInt(r3)     // Catch:{ JSONException -> 0x0013 }
            if (r2 == 0) goto L_0x0013
            r1 = 1
        L_0x0013:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zing.zalo.zalosdk.core.helper.Utils.getBoolean(org.json.JSONObject, java.lang.String):boolean");
    }

    public static String getConnectionType(Context context) {
        return DeviceHelper.getConnectionType(context);
    }

    public static String getExceptionFilePreload(Context context) {
        return getSavedString(context, Constant.PREFS_NAME_PRELOAD, KEY_EXCEPTION_FILE_PRELOAD);
    }

    public static int getResourceId(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, str2, context.getPackageName());
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static String getSDKVersion() {
        return "4.24.1101";
    }

    public static int getSDKVersionCode() {
        return 261115;
    }

    public static boolean getSavedBoolean(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, false);
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static int getSavedInt(Context context, String str, String str2) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, -1);
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static long getSavedLong(Context context, String str, String str2) {
        if (context != null) {
            try {
                return context.getSharedPreferences(str, 0).getLong(str2, -1);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return 0;
    }

    public static String getSavedPreloadValue(Context context) {
        return getSavedString(context, Constant.PREFS_NAME_PRELOAD, KEY_PRELOAD);
    }

    public static String getSavedString(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, "");
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String getSignature(String[] strArr, String[] strArr2, String str) {
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.clear();
            int length = strArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                arrayList.add(strArr[i10] + "=" + strArr2[i10]);
            }
            Collections.sort(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb2.append((String) it.next());
            }
            sb2.append(str);
            Log.v("bsig: " + sb2.toString());
            return md5(sb2.toString());
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String getWLANMACAddress(Context context) {
        return DeviceHelper.getWLANMACAddress(context);
    }

    public static byte[] gzipCompress(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    public static String gzipDecompress(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 32);
        StringBuilder sb2 = new StringBuilder();
        byte[] bArr2 = new byte[32];
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                sb2.append(new String(bArr2, 0, read));
            } else {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return sb2.toString();
            }
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
            } else {
                activity.getWindow().setSoftInputMode(3);
            }
        }
    }

    public static boolean initZaloSDK(Application application) {
        Class<ZaloSDKApplication> cls = ZaloSDKApplication.class;
        try {
            int i10 = ZaloSDKApplication.f11862a;
            Method method = cls.getMethod("wrap", new Class[]{Application.class});
            if (method != null) {
                method.invoke((Object) null, new Object[]{application});
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void initZingAnalytics(Application application, String str) {
        Object invoke;
        Method method;
        try {
            Class<?> cls = Class.forName("com.zing.zalo.devicetrackingsdk.ZingAnalyticsManager");
            Method method2 = cls.getMethod("getInstance", (Class[]) null);
            if (method2 != null && (invoke = method2.invoke((Object) null, (Object[]) null)) != null && (method = cls.getMethod("init", new Class[]{Application.class, String.class})) != null) {
                method.invoke(invoke, new Object[]{application, str});
            }
        } catch (Exception unused) {
        }
    }

    public static boolean isOnline(Context context) {
        try {
            if (!isPermissionGranted(context, "android.permission.ACCESS_WIFI_STATE")) {
                return true;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isPackageExisted(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 128);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isPermissionGranted(Context context, String str) {
        int i10;
        try {
            Method method = context.getClass().getMethod("checkSelfPermission", new Class[]{String.class});
            if (method != null) {
                i10 = ((Integer) method.invoke(context, new Object[]{str})).intValue();
            } else {
                i10 = context.getPackageManager().checkPermission(str, context.getPackageName());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            i10 = -1;
        }
        if (i10 == 0) {
            return true;
        }
        return false;
    }

    public static JSONArray listToJSONObject(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public static String loadListDeviceIDWakeUp(Context context) {
        return getSavedString(context, Constant.PREFS_NAME_WAKEUP, Constant.KEY_LIST_DEVICEID_WAKE_UP);
    }

    public static JSONObject mapToJSONObject(Map<String, String> map) {
        return addMapToJSONObject((JSONObject) null, map);
    }

    public static String md5(String str) {
        String str2 = "";
        try {
            MessageDigest instance = MessageDigest.getInstance(j.f17955b);
            instance.reset();
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            for (byte b10 : digest) {
                String hexString = Integer.toHexString(b10 & 255);
                if (hexString.length() == 1) {
                    str2 = str2 + "0" + hexString;
                } else {
                    str2 = str2 + hexString;
                }
            }
        } catch (NoSuchAlgorithmException unused) {
        }
        return str2;
    }

    public static String readTextFile(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        StringBuilder sb2 = new StringBuilder(256);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb2.append(readLine);
            } else {
                fileInputStream.close();
                return sb2.toString();
            }
        }
    }

    public static void saveBoolean(Context context, String str, String str2, boolean z10) {
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
                edit.putBoolean(str2, z10);
                edit.apply();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static void saveExceptionFilePreload(Context context, String str) {
        saveString(context, Constant.PREFS_NAME_PRELOAD, KEY_EXCEPTION_FILE_PRELOAD, str);
    }

    public static void saveInt(Context context, String str, String str2, int i10) {
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
                edit.putInt(str2, i10);
                edit.apply();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static void saveLong(Context context, String str, String str2, long j10) {
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
                edit.putLong(str2, j10);
                edit.apply();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static void savePreloadValue(Context context, String str) {
        saveString(context, Constant.PREFS_NAME_PRELOAD, KEY_PRELOAD, str);
    }

    public static void saveString(Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
                edit.putString(str2, str3);
                edit.apply();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static void addEventZingAnalytics(String str, Map<String, String> map) {
        Object invoke;
        Method method;
        try {
            Class<?> cls = Class.forName("com.zing.zalo.devicetrackingsdk.ZingAnalyticsManager");
            Method method2 = cls.getMethod("getInstance", (Class[]) null);
            if (method2 != null && (invoke = method2.invoke((Object) null, (Object[]) null)) != null && (method = cls.getMethod("addEvent", new Class[]{String.class, Map.class})) != null) {
                method.invoke(invoke, new Object[]{str, map});
            }
        } catch (Exception unused) {
        }
    }
}
