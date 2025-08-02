package com.zing.zalo.zalosdk.oauth;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.zing.zalo.zalosdk.R;
import com.zing.zalo.zalosdk.common.Constant;
import com.zing.zalo.zalosdk.core.helper.AppInfo;
import com.zing.zalo.zalosdk.core.helper.Utils;
import com.zing.zalo.zalosdk.core.log.Log;

class Utilities {
    Utilities() {
    }

    static boolean canUseBrowserLogin(Context context) {
        String appId = AppInfo.getAppId(context);
        String packageName = AppInfo.getPackageName(context);
        if (TextUtils.isEmpty(appId)) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        intent.setPackage(packageName);
        intent.setData(Uri.parse("zalo-" + appId + "://"));
        ComponentName resolveActivity = intent.resolveActivity(packageManager);
        Class<BrowserLoginActivity> cls = BrowserLoginActivity.class;
        if (resolveActivity != null && cls.getName().equalsIgnoreCase(resolveActivity.getClassName())) {
            return true;
        }
        Log.e("ZaloSDK support login via browser from version 2.4.0901");
        Log.e("Please add this activity to your AndroidManifest.xml");
        Log.e("  <activity android:name=\" " + cls.getName() + " \">");
        Log.e("    <intent-filter>");
        Log.e("      <action android:name=\"android.intent.action.VIEW\" />");
        Log.e("      <category android:name=\"android.intent.category.DEFAULT\" />");
        Log.e("      <category android:name=\"android.intent.category.BROWSABLE\" />");
        Log.e("      <data android:scheme=\"zalo-" + appId + "\" />");
        Log.e("    </intent-filter>");
        Log.e("  </activity>");
        return false;
    }

    static int getOrientation(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static int getVersionCode(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static void invokeMarketApp(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)));
        } catch (ActivityNotFoundException unused) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str)));
        }
    }

    static boolean isOnline(Context context) {
        if (!Utils.isPermissionGranted(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    public static boolean isPortait(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        if (displayMetrics.heightPixels > displayMetrics.widthPixels) {
            return true;
        }
        return false;
    }

    public static boolean isTablet(Context context) {
        return context.getResources().getBoolean(R.bool.isTablet);
    }

    public static boolean isZaloInstalled(Context context) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setComponent(new ComponentName(Constant.ZALO_PACKAGE_NAME, "com.zing.zalo.ui.TempShareViaActivity"));
        if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
            return true;
        }
        return false;
    }

    public static boolean isZaloSupportCallBack(Context context) {
        if (getVersionCode(context, Constant.ZALO_PACKAGE_NAME) > 1100123) {
            return true;
        }
        return false;
    }
}
