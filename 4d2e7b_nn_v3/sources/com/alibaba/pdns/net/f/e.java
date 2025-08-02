package com.alibaba.pdns.net.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.alibaba.pdns.DNSResolver;

final class e implements b {

    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent != null && (action = intent.getAction()) != null && TextUtils.equals(action, "android.net.conn.CONNECTIVITY_CHANGE")) {
                try {
                    DNSResolver.getInstance().onNetworkStatusChanged();
                } catch (Error | Exception e10) {
                    if (com.alibaba.pdns.u.a.f18279a) {
                        e10.printStackTrace();
                    }
                }
            }
        }
    }

    public e(Context context) {
        if (context != null) {
            context.getApplicationContext().registerReceiver(new a(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }
}
