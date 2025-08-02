package OooOo;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import s.k;

@SuppressLint({"NewApi"})
public class OooO0oO extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final Context f13480a;

    /* renamed from: b  reason: collision with root package name */
    public final Looper f13481b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f13482c;

    /* renamed from: d  reason: collision with root package name */
    public final C0163OooO0oO f13483d;

    /* renamed from: e  reason: collision with root package name */
    public final h f13484e;

    /* renamed from: f  reason: collision with root package name */
    public final i f13485f;

    /* renamed from: g  reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f13486g;

    /* renamed from: h  reason: collision with root package name */
    public d f13487h;

    /* renamed from: i  reason: collision with root package name */
    public e f13488i = new e((a) null);

    /* renamed from: j  reason: collision with root package name */
    public NetworkRequest f13489j = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();

    /* renamed from: k  reason: collision with root package name */
    public boolean f13490k;

    /* renamed from: l  reason: collision with root package name */
    public g f13491l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f13492m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f13493n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f13494o;

    /* renamed from: OooOo.OooO0oO$OooO0oO  reason: collision with other inner class name */
    public static class C0163OooO0oO extends IntentFilter {
        public C0163OooO0oO() {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f13495a;

        public a(Runnable runnable) {
            this.f13495a = runnable;
        }

        public void run() {
            if (OooO0oO.this.f13490k) {
                this.f13495a.run();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            if (OooO0oO.this.f13492m) {
                OooO0oO.this.f13492m = false;
                return;
            }
            OooO0oO oooO0oO = OooO0oO.this;
            oooO0oO.d(oooO0oO.n());
        }
    }

    public class c extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        public LinkProperties f13498a;

        /* renamed from: b  reason: collision with root package name */
        public NetworkCapabilities f13499b;

        public c(a aVar) {
        }

        public final g a(Network network) {
            int i10;
            int i11;
            int i12 = 1;
            int i13 = -1;
            if (!this.f13499b.hasTransport(1) && !this.f13499b.hasTransport(5)) {
                i12 = 0;
                if (this.f13499b.hasTransport(0)) {
                    NetworkInfo n10 = OooO0oO.this.f13487h.n(network);
                    if (n10 != null) {
                        i13 = n10.getSubtype();
                    }
                } else if (this.f13499b.hasTransport(3)) {
                    i12 = 9;
                } else if (this.f13499b.hasTransport(2)) {
                    i12 = 7;
                } else if (this.f13499b.hasTransport(4)) {
                    NetworkInfo m10 = OooO0oO.this.f13487h.m(network);
                    i12 = m10 != null ? m10.getType() : 17;
                } else {
                    i11 = -1;
                    i10 = -1;
                    return new g(true, i11, i10, String.valueOf(OooO0oO.b(network)), this.f13498a.isPrivateDnsActive(), this.f13498a.getPrivateDnsServerName());
                }
            }
            i11 = i12;
            i10 = i13;
            return new g(true, i11, i10, String.valueOf(OooO0oO.b(network)), this.f13498a.isPrivateDnsActive(), this.f13498a.getPrivateDnsServerName());
        }

        public void onAvailable(Network network) {
            this.f13498a = null;
            this.f13499b = null;
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            this.f13499b = networkCapabilities;
            if (OooO0oO.this.f13490k && this.f13498a != null && this.f13499b != null) {
                OooO0oO.this.d(a(network));
            }
        }

        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            this.f13498a = linkProperties;
            if (OooO0oO.this.f13490k && this.f13498a != null && this.f13499b != null) {
                OooO0oO.this.d(a(network));
            }
        }

        public void onLost(Network network) {
            this.f13498a = null;
            this.f13499b = null;
            if (OooO0oO.this.f13490k) {
                OooO0oO.this.d(new g(false, -1, -1, (String) null, false, ""));
            }
        }
    }

    public static class d {

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ boolean f13501c = true;

        /* renamed from: a  reason: collision with root package name */
        public final ConnectivityManager f13502a;

        /* renamed from: b  reason: collision with root package name */
        public final Context f13503b;

        public d(Context context) {
            this.f13503b = context.getApplicationContext();
            this.f13502a = (ConnectivityManager) context.getSystemService("connectivity");
        }

        public int a(Network network) {
            NetworkInfo m10 = m(network);
            if (m10 == null || !m10.isConnected()) {
                return -1;
            }
            return OooO0oO.i(m10.getType(), m10.getSubtype());
        }

        public g b(j jVar) {
            Network j10 = j();
            NetworkInfo d10 = d(m(j10));
            if (d10 == null) {
                return new g(false, -1, -1, (String) null, false, "");
            }
            if (j10 != null) {
                s.c a10 = k.a(j10, this.f13503b);
                if (a10 == null) {
                    return new g(true, d10.getType(), d10.getSubtype(), String.valueOf(OooO0oO.b(j10)), false, "");
                }
                return new g(true, d10.getType(), d10.getSubtype(), String.valueOf(OooO0oO.b(j10)), a10.a(), a10.b());
            } else if (!f13501c) {
                throw new AssertionError();
            } else if (d10.getType() != 1) {
                return new g(true, d10.getType(), d10.getSubtype(), (String) null, false, "");
            } else {
                if (d10.getExtraInfo() == null || "".equals(d10.getExtraInfo())) {
                    return new g(true, d10.getType(), d10.getSubtype(), jVar.a(), false, "");
                }
                return new g(true, d10.getType(), d10.getSubtype(), d10.getExtraInfo(), false, "");
            }
        }

        public final NetworkInfo d(NetworkInfo networkInfo) {
            if (networkInfo == null) {
                return null;
            }
            if (!networkInfo.isConnected() && networkInfo.getDetailedState() != NetworkInfo.DetailedState.BLOCKED) {
                return null;
            }
            return networkInfo;
        }

        public void e(ConnectivityManager.NetworkCallback networkCallback) {
            this.f13502a.unregisterNetworkCallback(networkCallback);
        }

        public void f(ConnectivityManager.NetworkCallback networkCallback, Handler handler) {
            this.f13502a.registerDefaultNetworkCallback(networkCallback, handler);
        }

        public void g(NetworkRequest networkRequest, ConnectivityManager.NetworkCallback networkCallback, Handler handler) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f13502a.registerNetworkCallback(networkRequest, networkCallback, handler);
            } else {
                this.f13502a.registerNetworkCallback(networkRequest, networkCallback);
            }
        }

        public final Network[] h() {
            Network[] allNetworks = this.f13502a.getAllNetworks();
            if (allNetworks == null) {
                return new Network[0];
            }
            return allNetworks;
        }

        public Network j() {
            Network activeNetwork = this.f13502a.getActiveNetwork();
            if (activeNetwork != null) {
                return activeNetwork;
            }
            NetworkInfo activeNetworkInfo = this.f13502a.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            for (Network network : OooO0oO.k(this, (Network) null)) {
                NetworkInfo n10 = n(network);
                if (n10 != null && (n10.getType() == activeNetworkInfo.getType() || n10.getType() == 17)) {
                    if (f13501c || activeNetwork == null) {
                        activeNetwork = network;
                    } else {
                        throw new AssertionError();
                    }
                }
            }
            return activeNetwork;
        }

        public final NetworkCapabilities k(Network network) {
            int i10 = 0;
            while (i10 < 2) {
                try {
                    return this.f13502a.getNetworkCapabilities(network);
                } catch (SecurityException unused) {
                    i10++;
                }
            }
            return null;
        }

        public NetworkInfo m(Network network) {
            NetworkInfo n10 = n(network);
            if (n10 == null || n10.getType() != 17) {
                return n10;
            }
            return this.f13502a.getActiveNetworkInfo();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
            return r1.f13502a.getNetworkInfo(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
            return null;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.net.NetworkInfo n(android.net.Network r2) {
            /*
                r1 = this;
                android.net.ConnectivityManager r0 = r1.f13502a     // Catch:{ NullPointerException -> 0x0007 }
                android.net.NetworkInfo r2 = r0.getNetworkInfo(r2)     // Catch:{ NullPointerException -> 0x0007 }
                return r2
            L_0x0007:
                android.net.ConnectivityManager r0 = r1.f13502a     // Catch:{ NullPointerException -> 0x000e }
                android.net.NetworkInfo r2 = r0.getNetworkInfo(r2)     // Catch:{ NullPointerException -> 0x000e }
                return r2
            L_0x000e:
                r2 = 0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: OooOo.OooO0oO.d.n(android.net.Network):android.net.NetworkInfo");
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0025 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean o(android.net.Network r4) {
            /*
                r3 = this;
                java.net.Socket r0 = new java.net.Socket
                r0.<init>()
                android.os.StrictMode$VmPolicy r1 = android.os.StrictMode.getVmPolicy()
                android.os.StrictMode$VmPolicy r2 = android.os.StrictMode.VmPolicy.LAX
                android.os.StrictMode.setVmPolicy(r2)
                r4.bindSocket(r0)     // Catch:{ IOException -> 0x0025, all -> 0x001b }
                r0.close()     // Catch:{ IOException -> 0x0014 }
            L_0x0014:
                if (r1 == 0) goto L_0x0019
                android.os.StrictMode.setVmPolicy(r1)
            L_0x0019:
                r4 = 1
                return r4
            L_0x001b:
                r4 = move-exception
                r0.close()     // Catch:{ IOException -> 0x001f }
            L_0x001f:
                if (r1 == 0) goto L_0x0024
                android.os.StrictMode.setVmPolicy(r1)
            L_0x0024:
                throw r4
            L_0x0025:
                r0.close()     // Catch:{ IOException -> 0x0028 }
            L_0x0028:
                if (r1 == 0) goto L_0x002d
                android.os.StrictMode.setVmPolicy(r1)
            L_0x002d:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: OooOo.OooO0oO.d.o(android.net.Network):boolean");
        }
    }

    public class e extends ConnectivityManager.NetworkCallback {

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ boolean f13504c = true;

        /* renamed from: a  reason: collision with root package name */
        public Network f13505a;

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f13507a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f13508b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f13509c;

            public a(long j10, int i10, boolean z10) {
                this.f13507a = j10;
                this.f13508b = i10;
                this.f13509c = z10;
            }

            public void run() {
                OooO0oO.this.f13484e.f(this.f13507a, this.f13508b);
                if (this.f13509c) {
                    OooO0oO.this.f13484e.a(this.f13508b);
                    OooO0oO.this.f13484e.g(new long[]{this.f13507a});
                }
            }
        }

        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f13511a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f13512b;

            public b(long j10, int i10) {
                this.f13511a = j10;
                this.f13512b = i10;
            }

            public void run() {
                OooO0oO.this.f13484e.f(this.f13511a, this.f13512b);
            }
        }

        public class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f13514a;

            public c(long j10) {
                this.f13514a = j10;
            }

            public void run() {
                OooO0oO.this.f13484e.d(this.f13514a);
            }
        }

        public class d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Network f13516a;

            public d(Network network) {
                this.f13516a = network;
            }

            public void run() {
                OooO0oO.this.f13484e.e(OooO0oO.b(this.f13516a));
            }
        }

        /* renamed from: OooOo.OooO0oO$e$e  reason: collision with other inner class name */
        public class C0164e implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f13518a;

            public C0164e(int i10) {
                this.f13518a = i10;
            }

            public void run() {
                OooO0oO.this.f13484e.a(this.f13518a);
            }
        }

        public e(a aVar) {
        }

        public void a() {
            NetworkCapabilities c10;
            Network[] k10 = OooO0oO.k(OooO0oO.this.f13487h, (Network) null);
            this.f13505a = null;
            if (k10.length == 1 && (c10 = OooO0oO.this.f13487h.k(k10[0])) != null && c10.hasTransport(4)) {
                this.f13505a = k10[0];
            }
        }

        public final boolean b(Network network) {
            Network network2 = this.f13505a;
            if (network2 == null || network2.equals(network)) {
                return false;
            }
            return true;
        }

        public final boolean c(Network network, NetworkCapabilities networkCapabilities) {
            if (networkCapabilities == null) {
                networkCapabilities = OooO0oO.this.f13487h.k(network);
            }
            if (networkCapabilities == null || (networkCapabilities.hasTransport(4) && !OooO0oO.this.f13487h.o(network))) {
                return true;
            }
            return false;
        }

        public final boolean d(Network network, NetworkCapabilities networkCapabilities) {
            if (b(network) || c(network, networkCapabilities)) {
                return true;
            }
            return false;
        }

        public void onAvailable(Network network) {
            boolean z10;
            Network network2;
            NetworkCapabilities c10 = OooO0oO.this.f13487h.k(network);
            if (!d(network, c10)) {
                if (!c10.hasTransport(4) || ((network2 = this.f13505a) != null && network.equals(network2))) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                boolean z11 = z10;
                if (z11) {
                    this.f13505a = network;
                }
                OooO0oO.this.f(new a(OooO0oO.b(network), OooO0oO.this.f13487h.a(network), z11));
            }
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (!d(network, networkCapabilities)) {
                OooO0oO.this.f(new b(OooO0oO.b(network), OooO0oO.this.f13487h.a(network)));
            }
        }

        public void onLosing(Network network, int i10) {
            if (!d(network, (NetworkCapabilities) null)) {
                OooO0oO.this.f(new c(OooO0oO.b(network)));
            }
        }

        public void onLost(Network network) {
            if (!b(network)) {
                OooO0oO.this.f(new d(network));
                Network network2 = this.f13505a;
                if (network2 == null) {
                    return;
                }
                if (f13504c || network.equals(network2)) {
                    this.f13505a = null;
                    for (Network onAvailable : OooO0oO.k(OooO0oO.this.f13487h, network)) {
                        onAvailable(onAvailable);
                    }
                    OooO0oO.this.f(new C0164e(OooO0oO.this.n().b()));
                    return;
                }
                throw new AssertionError();
            }
        }
    }

    public class f extends ConnectivityManager.NetworkCallback {
        public f(a aVar) {
        }

        public void onAvailable(Network network) {
            if (OooO0oO.this.f13490k) {
                OooO0oO oooO0oO = OooO0oO.this;
                oooO0oO.d(oooO0oO.n());
            }
        }

        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            onAvailable((Network) null);
        }

        public void onLost(Network network) {
            onAvailable((Network) null);
        }
    }

    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f13521a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13522b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13523c;

        /* renamed from: d  reason: collision with root package name */
        public final String f13524d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f13525e;

        /* renamed from: f  reason: collision with root package name */
        public final String f13526f;

        public g(boolean z10, int i10, int i11, String str, boolean z11, String str2) {
            this.f13521a = z10;
            this.f13522b = i10;
            this.f13523c = i11;
            this.f13524d = str == null ? "" : str;
            this.f13525e = z11;
            this.f13526f = str2 == null ? "" : str2;
        }

        public int a() {
            if (!g()) {
                return 0;
            }
            int f10 = f();
            if (f10 != 0 && f10 != 4 && f10 != 5) {
                return 1;
            }
            switch (d()) {
                case 1:
                    return 2;
                case 2:
                    return 3;
                case 3:
                    return 7;
                case 4:
                    return 4;
                case 5:
                    return 8;
                case 6:
                    return 9;
                case 7:
                    return 5;
                case 8:
                    return 10;
                case 9:
                    return 11;
                case 10:
                    return 12;
                case 11:
                    return 6;
                case 12:
                    return 13;
                case 13:
                    return 16;
                case 14:
                    return 14;
                case 15:
                    return 15;
                default:
                    return 1;
            }
        }

        public int b() {
            if (!g()) {
                return -1;
            }
            return OooO0oO.i(f(), d());
        }

        public String c() {
            return this.f13524d;
        }

        public int d() {
            return this.f13523c;
        }

        public String e() {
            return this.f13526f;
        }

        public int f() {
            return this.f13522b;
        }

        public boolean g() {
            return this.f13521a;
        }

        public boolean h() {
            return this.f13525e;
        }
    }

    public interface h {
        void a(int i10);

        void c(int i10);

        void d(long j10);

        void e(long j10);

        void f(long j10, int i10);

        void g(long[] jArr);
    }

    public static abstract class i {

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ boolean f13527b = true;

        /* renamed from: a  reason: collision with root package name */
        public OooO0oO f13528a;

        public abstract void a();

        public abstract void b(OooO0oO oooO0oO);

        public final void c() {
            if (f13527b || this.f13528a != null) {
                this.f13528a.r();
                return;
            }
            throw new AssertionError();
        }
    }

    public static class j {
        public abstract String a();
    }

    public OooO0oO(Context context, h hVar, i iVar) {
        this.f13480a = context;
        Looper myLooper = Looper.myLooper();
        this.f13481b = myLooper;
        this.f13482c = new Handler(myLooper);
        this.f13484e = hVar;
        this.f13487h = new d(context);
        int i10 = Build.VERSION.SDK_INT;
        f fVar = null;
        if (i10 >= 30) {
            this.f13486g = new c((a) null);
        } else {
            this.f13486g = i10 >= 28 ? new f((a) null) : fVar;
        }
        this.f13491l = n();
        this.f13483d = new C0163OooO0oO();
        this.f13492m = false;
        this.f13493n = false;
        this.f13485f = iVar;
        iVar.b(this);
        this.f13493n = true;
    }

    public static long b(Network network) {
        return network.getNetworkHandle();
    }

    public static int i(int i10, int i11) {
        if (i10 != 0) {
            if (i10 == 1) {
                return 1;
            }
            if (!(i10 == 4 || i10 == 5)) {
                if (i10 == 6) {
                    return 4;
                }
                if (i10 != 7) {
                    return i10 != 9 ? 0 : 11;
                }
                return 10;
            }
        }
        if (i11 == 20) {
            return 5;
        }
        switch (i11) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    public static Network[] k(d dVar, Network network) {
        NetworkCapabilities k10;
        Network[] i10 = dVar.h();
        int i11 = 0;
        for (Network network2 : i10) {
            if (!network2.equals(network) && (k10 = dVar.k(network2)) != null && k10.hasCapability(12)) {
                if (!k10.hasTransport(4)) {
                    i10[i11] = network2;
                    i11++;
                } else if (dVar.o(network2)) {
                    return new Network[]{network2};
                }
            }
        }
        return (Network[]) Arrays.copyOf(i10, i11);
    }

    public final void c() {
        if (!q()) {
            throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
        }
    }

    public final void d(g gVar) {
        if (gVar.b() != this.f13491l.b() || !gVar.c().equals(this.f13491l.c()) || gVar.h() != this.f13491l.h() || !gVar.e().equals(this.f13491l.e())) {
            this.f13484e.a(gVar.b());
        }
        if (!(gVar.b() == this.f13491l.b() && gVar.a() == this.f13491l.a())) {
            this.f13484e.c(gVar.a());
        }
        this.f13491l = gVar;
    }

    public final void f(Runnable runnable) {
        if (q()) {
            runnable.run();
        } else {
            this.f13482c.post(new a(runnable));
        }
    }

    public void l() {
        c();
        this.f13485f.a();
        s();
    }

    public g n() {
        return this.f13487h.b((j) null);
    }

    public long o() {
        Network j10 = this.f13487h.j();
        if (j10 == null) {
            return -1;
        }
        return b(j10);
    }

    public void onReceive(Context context, Intent intent) {
        f(new b());
    }

    public final boolean q() {
        if (this.f13481b == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public void r() {
        boolean z10;
        c();
        if (this.f13490k) {
            d(n());
            return;
        }
        if (this.f13493n) {
            d(n());
        }
        ConnectivityManager.NetworkCallback networkCallback = this.f13486g;
        if (networkCallback != null) {
            try {
                this.f13487h.f(networkCallback, this.f13482c);
            } catch (RuntimeException unused) {
                this.f13486g = null;
            }
        }
        if (this.f13486g == null) {
            if (this.f13480a.registerReceiver(this, this.f13483d) != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f13492m = z10;
        }
        this.f13490k = true;
        e eVar = this.f13488i;
        if (eVar != null) {
            eVar.a();
            try {
                this.f13487h.g(this.f13489j, this.f13488i, this.f13482c);
            } catch (RuntimeException unused2) {
                this.f13494o = true;
                this.f13488i = null;
            }
            if (!this.f13494o && this.f13493n) {
                Network[] k10 = k(this.f13487h, (Network) null);
                long[] jArr = new long[k10.length];
                for (int i10 = 0; i10 < k10.length; i10++) {
                    jArr[i10] = b(k10[i10]);
                }
                this.f13484e.g(jArr);
            }
        }
    }

    public void s() {
        c();
        if (this.f13490k) {
            this.f13490k = false;
            e eVar = this.f13488i;
            if (eVar != null) {
                this.f13487h.e(eVar);
            }
            ConnectivityManager.NetworkCallback networkCallback = this.f13486g;
            if (networkCallback != null) {
                this.f13487h.e(networkCallback);
            } else {
                this.f13480a.unregisterReceiver(this);
            }
        }
    }
}
