package x;

import com.mah.sdk.MahProxy;
import com.mah.sdk.MahProxyAddress;
import java.util.concurrent.atomic.AtomicReference;

public class i {

    /* renamed from: g  reason: collision with root package name */
    public static final String f24670g = f.f24630x;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference f24671a = new AtomicReference((Object) null);

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference f24672b = new AtomicReference((Object) null);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference f24673c = new AtomicReference((Object) null);

    /* renamed from: d  reason: collision with root package name */
    public final b f24674d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference f24675e = new AtomicReference(g.BYPASS_NONE);

    /* renamed from: f  reason: collision with root package name */
    public final Object f24676f = new Object();

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24677a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                x.g[] r0 = x.g.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24677a = r0
                x.g r1 = x.g.BYPASS_NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24677a     // Catch:{ NoSuchFieldError -> 0x001d }
                x.g r1 = x.g.BYPASS_STOP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24677a     // Catch:{ NoSuchFieldError -> 0x0028 }
                x.g r1 = x.g.BYPASS_PROXY_EXIT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f24677a     // Catch:{ NoSuchFieldError -> 0x0033 }
                x.g r1 = x.g.BYPASS_AUTH_FAILED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f24677a     // Catch:{ NoSuchFieldError -> 0x003e }
                x.g r1 = x.g.BYPASS_NDK_CRASHED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f24677a     // Catch:{ NoSuchFieldError -> 0x0049 }
                x.g r1 = x.g.BYPASS_SDK_DISABLED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: x.i.a.<clinit>():void");
        }
    }

    public interface b {
        void i(MahProxyAddress mahProxyAddress, MahProxyAddress mahProxyAddress2, MahProxyAddress mahProxyAddress3, MahProxy.ProxyChangedReason proxyChangedReason);
    }

    public i(b bVar) {
        this.f24674d = bVar;
    }

    public static MahProxy.ProxyChangedReason a(g gVar) {
        switch (a.f24677a[gVar.ordinal()]) {
            case 1:
                return MahProxy.ProxyChangedReason.START_SUCCEED;
            case 2:
                return MahProxy.ProxyChangedReason.SDK_STOP;
            case 3:
                return MahProxy.ProxyChangedReason.NDK_EXIT;
            case 4:
                return MahProxy.ProxyChangedReason.AUTH_FAILURE;
            case 5:
                return MahProxy.ProxyChangedReason.NDK_CRASHED;
            case 6:
                return MahProxy.ProxyChangedReason.SDK_DISABLE;
            default:
                return MahProxy.ProxyChangedReason.UNKNOWN;
        }
    }

    public g b() {
        return (g) this.f24675e.get();
    }

    public final void c(MahProxyAddress mahProxyAddress, MahProxyAddress mahProxyAddress2, MahProxyAddress mahProxyAddress3, MahProxy.ProxyChangedReason proxyChangedReason) {
        b bVar = this.f24674d;
        if (bVar != null) {
            bVar.i(mahProxyAddress, mahProxyAddress2, mahProxyAddress3, proxyChangedReason);
        }
    }

    public void d(MahProxyAddress mahProxyAddress, MahProxyAddress mahProxyAddress2, MahProxyAddress mahProxyAddress3, boolean z10) {
        synchronized (this.f24676f) {
            try {
                this.f24671a.set(mahProxyAddress);
                this.f24672b.set(mahProxyAddress3);
                this.f24673c.set(mahProxyAddress2);
                if (z10) {
                    c(mahProxyAddress, mahProxyAddress2, mahProxyAddress3, MahProxy.ProxyChangedReason.START_SUCCEED);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(g gVar, boolean z10) {
        MahProxyAddress mahProxyAddress;
        MahProxyAddress mahProxyAddress2;
        MahProxyAddress mahProxyAddress3;
        synchronized (this.f24676f) {
            try {
                this.f24675e.set(gVar);
                if (z10) {
                    if (gVar == g.BYPASS_NONE) {
                        mahProxyAddress = (MahProxyAddress) this.f24671a.get();
                        mahProxyAddress3 = (MahProxyAddress) this.f24673c.get();
                        mahProxyAddress2 = (MahProxyAddress) this.f24672b.get();
                    } else {
                        mahProxyAddress = null;
                        mahProxyAddress3 = null;
                        mahProxyAddress2 = null;
                    }
                    c(mahProxyAddress, mahProxyAddress3, mahProxyAddress2, a(gVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public MahProxyAddress f(d.b bVar) {
        if (bVar == d.b.ADDRESS_TYPE_SOURCE) {
            return (MahProxyAddress) this.f24672b.get();
        }
        if (bVar == d.b.ADDRESS_TYPE_PROXY_HANDSHAKE) {
            return (MahProxyAddress) this.f24673c.get();
        }
        return (MahProxyAddress) this.f24671a.get();
    }

    public void g(g gVar) {
        e(gVar, true);
    }

    public boolean h() {
        return ((g) this.f24675e.get()).f24664c;
    }

    public void i() {
        synchronized (this.f24676f) {
            c((MahProxyAddress) this.f24671a.get(), (MahProxyAddress) this.f24673c.get(), (MahProxyAddress) this.f24672b.get(), MahProxy.ProxyChangedReason.CHANGE_FROM_DISABLE_TO_ENABLE);
        }
    }

    public void j() {
        synchronized (this.f24676f) {
            c((MahProxyAddress) this.f24671a.get(), (MahProxyAddress) this.f24673c.get(), (MahProxyAddress) this.f24672b.get(), MahProxy.ProxyChangedReason.START_SUCCEED);
        }
    }

    public void k() {
        d.a.a(this.f24675e, g.BYPASS_SDK_DISABLED, g.BYPASS_NONE);
    }
}
