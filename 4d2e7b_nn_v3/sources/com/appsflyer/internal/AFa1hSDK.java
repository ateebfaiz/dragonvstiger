package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.autofill.HintConstants;
import com.appsflyer.AFLogger;

public final class AFa1hSDK {

    static final class AFa1zSDK {
        final String AFInAppEventParameterName;
        final String AFInAppEventType;
        final String AFKeystoreWrapper;

        AFa1zSDK(@NonNull String str, @Nullable String str2, @Nullable String str3) {
            this.AFKeystoreWrapper = str;
            this.AFInAppEventType = str2;
            this.AFInAppEventParameterName = str3;
        }
    }

    private static boolean AFInAppEventType(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    public final AFa1zSDK valueOf(@NonNull Context context) {
        String str;
        String str2;
        String str3;
        String str4 = "unknown";
        String str5 = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                Network[] allNetworks = connectivityManager.getAllNetworks();
                int length = allNetworks.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i10]);
                    if (!AFInAppEventType(networkInfo)) {
                        i10++;
                    } else if (1 == networkInfo.getType()) {
                        str4 = "WIFI";
                    } else if (networkInfo.getType() == 0) {
                        str4 = "MOBILE";
                    }
                }
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            str = telephonyManager.getSimOperatorName();
            try {
                str2 = telephonyManager.getNetworkOperatorName();
                if (str2 != null) {
                    if (str2.isEmpty()) {
                    }
                    return new AFa1zSDK(str4, str2, str);
                }
                if (2 == telephonyManager.getPhoneType()) {
                    str2 = "CDMA";
                }
            } catch (Throwable th) {
                th = th;
                String str6 = str;
                str3 = null;
                str5 = str6;
                AFLogger.afErrorLog("Exception while collecting network info. ", th);
                String str7 = str3;
                str = str5;
                str2 = str7;
                return new AFa1zSDK(str4, str2, str);
            }
        } catch (Throwable th2) {
            th = th2;
            str3 = null;
            AFLogger.afErrorLog("Exception while collecting network info. ", th);
            String str72 = str3;
            str = str5;
            str2 = str72;
            return new AFa1zSDK(str4, str2, str);
        }
        return new AFa1zSDK(str4, str2, str);
    }
}
