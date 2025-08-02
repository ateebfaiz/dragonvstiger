package s;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import i.j;
import java.net.InetAddress;
import java.util.List;

public abstract class k {
    public static c a(Network network, Context context) {
        ConnectivityManager connectivityManager;
        if (!j.b(context) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        if (network == null) {
            network = connectivityManager.getActiveNetwork();
        }
        if (network == null) {
            return null;
        }
        try {
            LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
            if (linkProperties == null) {
                return null;
            }
            List<InetAddress> dnsServers = linkProperties.getDnsServers();
            String domains = linkProperties.getDomains();
            if (Build.VERSION.SDK_INT >= 28) {
                return new c(dnsServers, linkProperties.isPrivateDnsActive(), linkProperties.getPrivateDnsServerName(), domains);
            }
            return new c(dnsServers, false, "", domains);
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static boolean b(Context context) {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                    return networkCapabilities.hasTransport(4);
                }
                for (Network networkCapabilities2 : connectivityManager.getAllNetworks()) {
                    NetworkCapabilities networkCapabilities3 = connectivityManager.getNetworkCapabilities(networkCapabilities2);
                    if (networkCapabilities3 != null && networkCapabilities3.hasTransport(4)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e10) {
            e10.getLocalizedMessage();
            return false;
        }
    }
}
