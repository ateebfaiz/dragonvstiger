package com.zing.zalo.zalosdk.core.helper;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import com.adjust.sdk.Constants;
import com.google.android.games.paddleboat.GameControllerManager;
import com.zing.zalo.zalosdk.core.log.Log;
import java.net.URLEncoder;
import java.security.MessageDigest;

public class AppInfo {
    private static AppInfo __instance;
    private static String applicationHashKey;
    private static String firstRunDate;
    private String appId;
    String appName;
    private String facebookAppId;
    String firstInstallDate;
    long firstTimeOpenApp = 0;
    String installDate;
    String installerPackageName;
    private boolean isAutoTrackingOpenApp;
    String lastUpdateDate;
    String packageName;
    String preloadChannel = "";
    int versionCode;
    String versionName;

    private AppInfo(Context context) {
        extractBasicAppInfo(context);
    }

    private void extractBasicAppInfo(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName2 = context.getPackageName();
            this.packageName = packageName2;
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName2, 4096);
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.packageName, 128);
            this.versionName = packageInfo.versionName;
            this.versionCode = packageInfo.versionCode;
            this.appName = URLEncoder.encode(String.valueOf(packageInfo.applicationInfo.loadLabel(packageManager)), "UTF-8");
            this.installerPackageName = packageManager.getInstallerPackageName(this.packageName);
            this.installDate = String.valueOf(packageInfo.firstInstallTime);
            this.firstInstallDate = String.valueOf(packageInfo.firstInstallTime);
            this.lastUpdateDate = String.valueOf(packageInfo.lastUpdateTime);
            Bundle bundle = applicationInfo.metaData;
            String stringValue = getStringValue(bundle, "com.zing.zalo.zalosdk.appID");
            this.appId = stringValue;
            if (stringValue != null) {
                if (stringValue.trim().length() == 0) {
                }
                this.isAutoTrackingOpenApp = getBooleanValue(bundle, "com.zing.zalosdk.configAutoTrackingActivity");
                this.preloadChannel = getStringValue(bundle, "com.zalo.sdk.preloadChannel");
                this.facebookAppId = getStringValue(bundle, "com.facebook.sdk.ApplicationId");
            }
            this.appId = getStringValue(bundle, "appID");
            this.isAutoTrackingOpenApp = getBooleanValue(bundle, "com.zing.zalosdk.configAutoTrackingActivity");
            this.preloadChannel = getStringValue(bundle, "com.zalo.sdk.preloadChannel");
            this.facebookAppId = getStringValue(bundle, "com.facebook.sdk.ApplicationId");
        } catch (Exception e10) {
            Log.e("extractBasicAppInfo", e10);
        }
    }

    public static String getAppId(Context context) {
        return getInstance(context).appId;
    }

    public static Long getAppIdLong(Context context) {
        try {
            return Long.valueOf(Long.parseLong(getInstance(context).appId));
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String getAppName(Context context) {
        return getInstance(context).appName;
    }

    public static String getApplicationHashKey(Context context) {
        String str = applicationHashKey;
        if (str != null) {
            return str;
        }
        try {
            for (Signature byteArray : context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures) {
                MessageDigest instance = MessageDigest.getInstance("SHA");
                instance.update(byteArray.toByteArray());
                applicationHashKey = Base64.encodeToString(instance.digest(), 0).trim();
            }
        } catch (Exception e10) {
            Log.e("getApplicationHashKey", e10);
        }
        return applicationHashKey;
    }

    private boolean getBooleanValue(Bundle bundle, String str) {
        try {
            if (bundle.containsKey(str)) {
                return bundle.getBoolean(str);
            }
            return false;
        } catch (Exception e10) {
            Log.v(e10.toString());
            return false;
        }
    }

    public static String getFacebookAppId(Context context) {
        return getInstance(context).facebookAppId;
    }

    public static String getFirstInstallDate(Context context) {
        return getInstance(context).firstInstallDate;
    }

    public static String getFirstRunDate(Context context) {
        String str = firstRunDate;
        if (str != null) {
            return str;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("zacPref", 0);
        String string = sharedPreferences.getString("first_run_date", (String) null);
        firstRunDate = string;
        if (string == null) {
            firstRunDate = String.valueOf(System.currentTimeMillis());
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("first_run_date", firstRunDate);
            edit.apply();
        }
        return firstRunDate;
    }

    public static long getFirstTimeOpenApp(Context context) {
        if (getInstance(context).firstTimeOpenApp == 0) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("zacPref", 0);
            getInstance(context).firstTimeOpenApp = sharedPreferences.getLong("first_time_open_app", 0);
        }
        return getInstance(context).firstTimeOpenApp;
    }

    public static String getInstallDate(Context context) {
        return getInstance(context).installDate;
    }

    public static String getInstallerPackageName(Context context) {
        return getInstance(context).installerPackageName;
    }

    public static synchronized AppInfo getInstance(Context context) {
        AppInfo appInfo;
        synchronized (AppInfo.class) {
            try {
                if (__instance == null) {
                    __instance = new AppInfo(context);
                }
                appInfo = __instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return appInfo;
    }

    public static String getLastUpdateDate(Context context) {
        return getInstance(context).lastUpdateDate;
    }

    public static String getPackageName(Context context) {
        return getInstance(context).packageName;
    }

    public static String getPreloadChannel(Context context) {
        return getInstance(context).preloadChannel;
    }

    public static String getReferrer(Context context) {
        try {
            return context.getSharedPreferences("zacCookie", 0).getString(Constants.REFERRER, "");
        } catch (Exception unused) {
            return "";
        }
    }

    private String getStringValue(Bundle bundle, String str) {
        String str2 = null;
        try {
            if (bundle.containsKey(str)) {
                str2 = bundle.getString(str);
            }
        } catch (Exception e10) {
            Log.v(e10.toString());
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public static int getVersionCode(Context context) {
        return getInstance(context).versionCode;
    }

    public static String getVersionName(Context context) {
        return getInstance(context).versionName;
    }

    public static boolean isAutoTrackingOpenApp(Context context) {
        return getInstance(context).isAutoTrackingOpenApp;
    }

    public static boolean isPackageExists(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 128);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void launchMarketApp(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
            intent.setData(Uri.parse("market://details?id=" + str));
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str));
            intent2.addFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
            context.startActivity(intent2);
        }
    }

    static synchronized void reset() {
        synchronized (AppInfo.class) {
            __instance = null;
        }
    }

    public static void setFirstTimeOpenApp(Context context, long j10) {
        if (getInstance(context).firstTimeOpenApp != j10) {
            getInstance(context).firstTimeOpenApp = j10;
            SharedPreferences.Editor edit = context.getSharedPreferences("zacPref", 0).edit();
            edit.putLong("first_time_open_app", j10);
            edit.apply();
        }
    }
}
