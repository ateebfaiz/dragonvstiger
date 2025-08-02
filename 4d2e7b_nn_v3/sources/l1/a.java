package l1;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;

public class a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f22387d;

    /* renamed from: a  reason: collision with root package name */
    private b f22388a;

    /* renamed from: b  reason: collision with root package name */
    private int f22389b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22390c = false;

    public static a a() {
        if (f22387d == null) {
            synchronized (a.class) {
                f22387d = new a();
            }
        }
        return f22387d;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:8|9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r1 = new android.net.NetworkRequest.Builder().build();
        r2 = new l1.b(r4);
        r3.f22388a = r2;
        r0.registerNetworkCallback(r1, r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0035 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r4) {
        /*
            r3 = this;
            boolean r0 = r3.f22390c
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1
            r3.f22390c = r0
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r4.getSystemService(r0)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L_0x0035
            l1.b r1 = new l1.b     // Catch:{ all -> 0x0021 }
            r1.<init>(r4)     // Catch:{ all -> 0x0021 }
            r3.f22388a = r1     // Catch:{ all -> 0x0021 }
            r0.registerDefaultNetworkCallback(r1)     // Catch:{ all -> 0x0021 }
            return
        L_0x0021:
            android.net.NetworkRequest$Builder r1 = new android.net.NetworkRequest$Builder     // Catch:{ all -> 0x0035 }
            r1.<init>()     // Catch:{ all -> 0x0035 }
            android.net.NetworkRequest r1 = r1.build()     // Catch:{ all -> 0x0035 }
            l1.b r2 = new l1.b     // Catch:{ all -> 0x0035 }
            r2.<init>(r4)     // Catch:{ all -> 0x0035 }
            r3.f22388a = r2     // Catch:{ all -> 0x0035 }
            r0.registerNetworkCallback(r1, r2)     // Catch:{ all -> 0x0035 }
            return
        L_0x0035:
            android.net.NetworkRequest$Builder r1 = new android.net.NetworkRequest$Builder     // Catch:{ all -> 0x0049 }
            r1.<init>()     // Catch:{ all -> 0x0049 }
            android.net.NetworkRequest r1 = r1.build()     // Catch:{ all -> 0x0049 }
            l1.b r2 = new l1.b     // Catch:{ all -> 0x0049 }
            r2.<init>(r4)     // Catch:{ all -> 0x0049 }
            r3.f22388a = r2     // Catch:{ all -> 0x0049 }
            r0.registerNetworkCallback(r1, r2)     // Catch:{ all -> 0x0049 }
            return
        L_0x0049:
            com.engagelab.privates.common.component.MTCommonReceiver r0 = p1.a.f(r4)
            android.content.IntentFilter r1 = new android.content.IntentFilter
            r1.<init>()
            java.lang.String r2 = "android.net.conn.CONNECTIVITY_CHANGE"
            r1.addAction(r2)
            u1.i.a(r4, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.a.b(android.content.Context):void");
    }

    public Bundle c(Context context, boolean z10, NetworkInfo networkInfo) {
        Bundle bundle = new Bundle();
        if (!z10) {
            p1.a.H(false);
            p1.a.I(0);
            p1.a.F("unknown");
            p1.a.G("unknown");
            bundle.putBoolean("state", false);
            bundle.putInt("type", 0);
            bundle.putString("name", "unknown");
            bundle.putString("radio", "unknown");
            return bundle;
        }
        p1.a.H(true);
        bundle.putBoolean("state", true);
        if (networkInfo.getType() == 1) {
            p1.a.I(1);
            p1.a.F("wifi");
            p1.a.G("wifi");
            bundle.putInt("type", 1);
            bundle.putString("name", "wifi");
            bundle.putString("radio", "wifi");
            return bundle;
        }
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                p1.a.I(2);
                p1.a.F("2g");
                p1.a.G("cdma");
                bundle.putInt("type", 2);
                bundle.putString("name", "2g");
                bundle.putString("radio", "cdma");
                break;
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
                p1.a.I(3);
                p1.a.F("3g");
                p1.a.G("gsm");
                bundle.putInt("type", 3);
                bundle.putString("name", "3g");
                bundle.putString("radio", "gsm");
                break;
            case 13:
            case 18:
            case 19:
                p1.a.I(4);
                p1.a.F("4g");
                p1.a.G("lte");
                bundle.putInt("type", 4);
                bundle.putString("name", "4g");
                bundle.putString("radio", "lte");
                break;
            case 20:
                p1.a.I(5);
                p1.a.F("5g");
                p1.a.G("nr");
                bundle.putInt("type", 5);
                bundle.putString("name", "5g");
                bundle.putString("radio", "nr");
                break;
            default:
                p1.a.I(0);
                p1.a.F("unknown");
                p1.a.G("unknown");
                bundle.putInt("type", 0);
                bundle.putString("name", "unknown");
                bundle.putString("radio", "unknown");
                break;
        }
        return bundle;
    }

    public void d(Context context, Bundle bundle) {
        boolean z10;
        String str;
        NetworkInfo networkInfo = (NetworkInfo) bundle.getParcelable("networkInfo");
        if (bundle.containsKey("state")) {
            z10 = bundle.getBoolean("state");
        } else if (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
            z10 = false;
        } else {
            z10 = true;
        }
        Bundle c10 = c(context, z10, networkInfo);
        int i10 = 1996;
        int i11 = 1004;
        if (z10 && this.f22389b == 1) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("state", false);
            bundle2.putInt("type", 0);
            bundle2.putString("name", "unknown");
            bundle2.putString("radio", "unknown");
            s1.a.a("MTNetworkBusiness", "onMainNetworkState network is connecting, new network connected");
            h1.a.i(context, 1004, bundle2);
            if (p1.a.f23054c) {
                h1.a.j(context, 1996, bundle2);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onMainNetworkState ");
        if (z10) {
            str = "connected";
        } else {
            str = "disConnected";
        }
        sb2.append(str);
        sb2.append(" currentNetwork:");
        sb2.append(p1.a.s());
        s1.a.a("MTNetworkBusiness", sb2.toString());
        this.f22389b = z10 ? 1 : 0;
        if (z10) {
            i11 = 1003;
        }
        h1.a.i(context, i11, c10);
        if (p1.a.f23054c) {
            if (z10) {
                i10 = 1997;
            }
            h1.a.j(context, i10, c10);
        }
    }

    public void e(Context context, Bundle bundle) {
        String str;
        if (bundle != null) {
            boolean z10 = bundle.getBoolean("state");
            int i10 = bundle.getInt("type");
            String string = bundle.getString("name");
            String string2 = bundle.getString("radio");
            p1.a.H(z10);
            p1.a.I(i10);
            if (TextUtils.isEmpty(string)) {
                string = "unknown";
            }
            p1.a.F(string);
            if (TextUtils.isEmpty(string2)) {
                string2 = "unknown";
            }
            p1.a.G(string2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onRemoteNetworkState ");
            if (z10) {
                str = "connected";
            } else {
                str = "disConnected";
            }
            sb2.append(str);
            sb2.append(" currentNetwork:");
            sb2.append(p1.a.s());
            s1.a.a("MTNetworkBusiness", sb2.toString());
        }
    }
}
