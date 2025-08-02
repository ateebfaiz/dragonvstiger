package com.cocos.sdk;

import android.util.Log;
import com.alibaba.pdns.DNSResolver;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.cocos2dx.okhttp3.Dns;

public class OkHttpDns implements Dns {
    private static final String TAG = "OkHttpDns";
    private static volatile OkHttpDns instance;
    private static final Object lock = new Object();
    private final DNSResolver mDNSResolver = DNSResolver.getInstance();

    private OkHttpDns() {
    }

    public static OkHttpDns getInstance() {
        if (instance == null) {
            synchronized (lock) {
                try {
                    if (instance == null) {
                        instance = new OkHttpDns();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public List<InetAddress> lookup(String str) throws UnknownHostException {
        String[] ipsByHost;
        AliProxyController instance2 = AliProxyController.getInstance();
        if (!instance2.isUseDnsSdk() || instance2.isValidIPv4(str) || instance2.isValidIPv6(str) || (ipsByHost = this.mDNSResolver.getIpsByHost(str)) == null || ipsByHost.length <= 0) {
            return Dns.SYSTEM.lookup(str);
        }
        ArrayList arrayList = new ArrayList();
        for (String byName : ipsByHost) {
            Log.d(TAG, "mDnsCache IP1: " + str);
            arrayList.add(InetAddress.getByName(byName));
        }
        return arrayList;
    }
}
