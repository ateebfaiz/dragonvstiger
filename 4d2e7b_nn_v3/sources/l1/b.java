package l1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import s1.a;

public class b extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22391a;

    public b(Context context) {
        this.f22391a = context;
    }

    private void a(boolean z10, Network network) {
        try {
            a.a("MTNetworkListener", "onNetworkState state:" + z10 + ",network:" + network.toString());
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f22391a.getSystemService("connectivity")).getActiveNetworkInfo();
            Bundle bundle = new Bundle();
            bundle.putBoolean("state", z10);
            bundle.putParcelable("networkInfo", activeNetworkInfo);
            h1.a.g(this.f22391a, g1.a.f21571a, 1007, bundle);
        } catch (Throwable th) {
            a.h("MTNetworkListener", "onNetworkState failed " + th.getMessage());
        }
    }

    public void onAvailable(Network network) {
        a(true, network);
    }

    public void onLost(Network network) {
        a(false, network);
    }
}
