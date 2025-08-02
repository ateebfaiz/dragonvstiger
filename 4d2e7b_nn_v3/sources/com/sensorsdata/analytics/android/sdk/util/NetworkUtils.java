package com.sensorsdata.analytics.android.sdk.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.alibaba.pdns.f;
import com.alibaba.pdns.s.e.c;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class NetworkUtils {
    private static final int HTTP_307 = 307;
    private static final String TAG = "SA.NetworkUtils";
    private static SABroadcastReceiver mReceiver;
    private static SANetworkCallbackImpl networkCallback;
    private static String networkType;

    private static class SABroadcastReceiver extends BroadcastReceiver {
        private SABroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                NetworkUtils.cleanNetworkTypeCache();
                SensorsDataAPI.sharedInstance().flush();
                SALog.i(NetworkUtils.TAG, "SABroadcastReceiver is receiving ConnectivityManager.CONNECTIVITY_ACTION broadcast");
            }
        }
    }

    @TargetApi(21)
    private static class SANetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
        private SANetworkCallbackImpl() {
        }

        public void onAvailable(Network network) {
            super.onAvailable(network);
            NetworkUtils.cleanNetworkTypeCache();
            SensorsDataAPI.sharedInstance().flush();
            SALog.i(NetworkUtils.TAG, "onAvailable is calling");
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            NetworkUtils.cleanNetworkTypeCache();
            SALog.i(NetworkUtils.TAG, "onCapabilitiesChanged is calling");
        }

        public void onLost(Network network) {
            super.onLost(network);
            NetworkUtils.cleanNetworkTypeCache();
            SALog.i(NetworkUtils.TAG, "onLost is calling");
        }
    }

    public static void cleanNetworkTypeCache() {
        networkType = null;
    }

    public static boolean compareMainDomain(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str2.contains(f.G)) {
            return false;
        }
        return str.substring(str.indexOf(f.G) + 1).equals(str2.substring(str2.indexOf(f.G) + 1));
    }

    public static String getHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(c.f18246k) || str.startsWith(c.f18247l)) {
            return Uri.parse(str).getHost();
        }
        return "";
    }

    public static String getLocation(HttpURLConnection httpURLConnection, String str) throws MalformedURLException {
        if (httpURLConnection == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        if (TextUtils.isEmpty(headerField)) {
            headerField = httpURLConnection.getHeaderField(FirebaseAnalytics.Param.LOCATION);
        }
        if (TextUtils.isEmpty(headerField)) {
            return null;
        }
        if (headerField.startsWith(c.f18246k) || headerField.startsWith(c.f18247l)) {
            return headerField;
        }
        URL url = new URL(str);
        return url.getProtocol() + "://" + url.getHost() + headerField;
    }

    public static String getRequestUrl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.startsWith(c.f18246k) && !str.startsWith(c.f18247l)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        try {
            return new URI(parse.getScheme(), parse.getUserInfo(), parse.getHost(), parse.getPort(), (String) null, (String) null, (String) null) + DomExceptionUtils.SEPARATOR + str2;
        } catch (URISyntaxException e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    @SuppressLint({"WrongConstant"})
    public static boolean isNetworkAvailable(Context context) {
        if (!PermissionUtils.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return false;
        }
        try {
            return isNetworkAvailable((ConnectivityManager) context.getSystemService("connectivity"));
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }

    @SuppressLint({"WrongConstant"})
    public static boolean isNetworkValid(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return false;
        }
        if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(7) || networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(16)) {
            return true;
        }
        return false;
    }

    public static boolean isShouldFlush(String str, int i10) {
        if ((toNetworkType(str) & i10) != 0) {
            return true;
        }
        return false;
    }

    private static boolean isWiFiNetwork(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0040 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043 A[RETURN] */
    @android.annotation.SuppressLint({"MissingPermission"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String mobileNetworkType(android.content.Context r2, android.telephony.TelephonyManager r3, android.net.ConnectivityManager r4) {
        /*
            r0 = 30
            if (r3 == 0) goto L_0x0020
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 >= r0) goto L_0x000d
            int r2 = r3.getNetworkType()
            goto L_0x0021
        L_0x000d:
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            boolean r2 = com.sensorsdata.analytics.android.sdk.util.PermissionUtils.checkSelfPermission(r2, r1)
            if (r2 != 0) goto L_0x001b
            boolean r2 = r3.hasCarrierPrivileges()
            if (r2 == 0) goto L_0x0020
        L_0x001b:
            int r2 = r3.getDataNetworkType()
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            java.lang.String r3 = "NULL"
            if (r2 != 0) goto L_0x0036
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r0) goto L_0x002a
            return r3
        L_0x002a:
            if (r4 == 0) goto L_0x0036
            android.net.NetworkInfo r4 = r4.getActiveNetworkInfo()
            if (r4 == 0) goto L_0x0036
            int r2 = r4.getSubtype()
        L_0x0036:
            switch(r2) {
                case 1: goto L_0x0043;
                case 2: goto L_0x0043;
                case 3: goto L_0x0040;
                case 4: goto L_0x0043;
                case 5: goto L_0x0040;
                case 6: goto L_0x0040;
                case 7: goto L_0x0043;
                case 8: goto L_0x0040;
                case 9: goto L_0x0040;
                case 10: goto L_0x0040;
                case 11: goto L_0x0043;
                case 12: goto L_0x0040;
                case 13: goto L_0x003d;
                case 14: goto L_0x0040;
                case 15: goto L_0x0040;
                case 16: goto L_0x0039;
                case 17: goto L_0x0039;
                case 18: goto L_0x003d;
                case 19: goto L_0x003d;
                case 20: goto L_0x003a;
                default: goto L_0x0039;
            }
        L_0x0039:
            return r3
        L_0x003a:
            java.lang.String r2 = "5G"
            return r2
        L_0x003d:
            java.lang.String r2 = "4G"
            return r2
        L_0x0040:
            java.lang.String r2 = "3G"
            return r2
        L_0x0043:
            java.lang.String r2 = "2G"
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.NetworkUtils.mobileNetworkType(android.content.Context, android.telephony.TelephonyManager, android.net.ConnectivityManager):java.lang.String");
    }

    public static boolean needRedirects(int i10) {
        return i10 == 301 || i10 == 302 || i10 == 307;
    }

    public static String networkType(Context context) {
        try {
            if (!TextUtils.isEmpty(networkType) && !"NULL".equals(networkType)) {
                return networkType;
            }
            if (!PermissionUtils.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                networkType = "NULL";
                return "NULL";
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                if (!isNetworkAvailable(connectivityManager)) {
                    networkType = "NULL";
                    return "NULL";
                } else if (isWiFiNetwork(connectivityManager)) {
                    networkType = "WIFI";
                    return "WIFI";
                }
            }
            String mobileNetworkType = mobileNetworkType(context, (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE), connectivityManager);
            networkType = mobileNetworkType;
            return mobileNetworkType;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            networkType = "NULL";
            return "NULL";
        }
    }

    public static void registerNetworkListener(Context context) {
        try {
            if (PermissionUtils.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                if (networkCallback == null) {
                    networkCallback = new SANetworkCallbackImpl();
                }
                NetworkRequest build = new NetworkRequest.Builder().build();
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    connectivityManager.registerNetworkCallback(build, networkCallback);
                    SALog.i(TAG, "Register ConnectivityManager");
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    private static int toNetworkType(String str) {
        if ("NULL".equals(str)) {
            return 255;
        }
        if ("WIFI".equals(str)) {
            return 8;
        }
        if ("2G".equals(str)) {
            return 1;
        }
        if ("3G".equals(str)) {
            return 2;
        }
        if ("4G".equals(str)) {
            return 4;
        }
        if ("5G".equals(str)) {
            return 16;
        }
        return 255;
    }

    public static void unregisterNetworkListener(Context context) {
        ConnectivityManager connectivityManager;
        try {
            if (networkCallback != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                connectivityManager.unregisterNetworkCallback(networkCallback);
                SALog.i(TAG, "unregister ConnectivityManager");
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    private static boolean isNetworkAvailable(ConnectivityManager connectivityManager) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return isNetworkValid(networkCapabilities);
    }
}
