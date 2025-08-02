package com.blankj.utilcode.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import c.d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class NetworkUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Set f18380a = new CopyOnWriteArraySet();

    public static final class NetworkChangedReceiver extends BroadcastReceiver {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public a f18381a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Set f18382b = new HashSet();

        class a implements Runnable {
            a() {
            }

            public void run() {
                a b10 = NetworkUtils.b();
                if (NetworkChangedReceiver.this.f18381a != b10) {
                    a unused = NetworkChangedReceiver.this.f18381a = b10;
                    if (b10 == a.NETWORK_NO) {
                        Iterator it = NetworkChangedReceiver.this.f18382b.iterator();
                        if (it.hasNext()) {
                            d.a(it.next());
                            throw null;
                        }
                        return;
                    }
                    Iterator it2 = NetworkChangedReceiver.this.f18382b.iterator();
                    if (it2.hasNext()) {
                        d.a(it2.next());
                        throw null;
                    }
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                s.l(new a(), 1000);
            }
        }
    }

    public enum a {
        NETWORK_ETHERNET,
        NETWORK_WIFI,
        NETWORK_5G,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

    private static NetworkInfo a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) p.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static a b() {
        if (c()) {
            return a.NETWORK_ETHERNET;
        }
        NetworkInfo a10 = a();
        if (a10 == null || !a10.isAvailable()) {
            return a.NETWORK_NO;
        }
        if (a10.getType() == 1) {
            return a.NETWORK_WIFI;
        }
        if (a10.getType() != 0) {
            return a.NETWORK_UNKNOWN;
        }
        switch (a10.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return a.NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return a.NETWORK_3G;
            case 13:
            case 18:
                return a.NETWORK_4G;
            case 20:
                return a.NETWORK_5G;
            default:
                String subtypeName = a10.getSubtypeName();
                if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                    return a.NETWORK_3G;
                }
                return a.NETWORK_UNKNOWN;
        }
    }

    private static boolean c() {
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) p.a().getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || (state = networkInfo.getState()) == null) {
            return false;
        }
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            return true;
        }
        return false;
    }
}
