package com.alibaba.pdns.net.f;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.alibaba.pdns.DNSResolver;

final class f implements b {

    class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        public void onAvailable(Network network) {
            super.onAvailable(network);
            DNSResolver.getInstance().onNetworkStatusChanged();
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
        }

        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            super.onLinkPropertiesChanged(network, linkProperties);
        }

        public void onLosing(Network network, int i10) {
            super.onLosing(network, i10);
        }

        public void onLost(Network network) {
            super.onLost(network);
            DNSResolver.getInstance().onNetworkStatusChanged();
        }

        public void onUnavailable() {
            super.onUnavailable();
        }
    }

    @TargetApi(21)
    f(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) != null) {
            connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(0).addTransportType(1).addTransportType(2).addTransportType(3).build(), new a());
        }
    }
}
