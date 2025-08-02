package com.google.android.gms.ads.identifier;

import android.net.Uri;
import java.util.Map;

final class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Map f6609a;

    a(AdvertisingIdClient advertisingIdClient, Map map) {
        this.f6609a = map;
    }

    public final void run() {
        Map map = this.f6609a;
        Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str : map.keySet()) {
            buildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        zzc.zza(buildUpon.build().toString());
    }
}
