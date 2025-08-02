package x;

import OooO0o0.OooO0O0;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.mah.sdk.MahProxy;
import com.mah.sdk.MahProxyAddress;
import f.b;
import w.d;

public class j implements k {

    /* renamed from: b  reason: collision with root package name */
    public static final String f24678b = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final RemoteCallbackList f24679a = new RemoteCallbackList();

    public void a() {
        synchronized (this.f24679a) {
            try {
                int beginBroadcast = this.f24679a.beginBroadcast();
                for (int i10 = 0; i10 < beginBroadcast; i10++) {
                    b bVar = (b) this.f24679a.getBroadcastItem(i10);
                    if (bVar != null) {
                        try {
                            bVar.a(0);
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f24679a.finishBroadcast();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(OooO0O0 oooO0O0) {
        synchronized (this.f24679a) {
            try {
                int beginBroadcast = this.f24679a.beginBroadcast();
                for (int i10 = 0; i10 < beginBroadcast; i10++) {
                    b bVar = (b) this.f24679a.getBroadcastItem(i10);
                    if (bVar != null) {
                        try {
                            bVar.b(oooO0O0);
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f24679a.finishBroadcast();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(b bVar) {
        synchronized (this.f24679a) {
            this.f24679a.unregister(bVar);
        }
    }

    public void e(b bVar) {
        synchronized (this.f24679a) {
            this.f24679a.register(bVar);
        }
    }

    public void i(MahProxyAddress mahProxyAddress, MahProxyAddress mahProxyAddress2, MahProxyAddress mahProxyAddress3, MahProxy.ProxyChangedReason proxyChangedReason) {
        synchronized (this.f24679a) {
            try {
                int beginBroadcast = this.f24679a.beginBroadcast();
                for (int i10 = 0; i10 < beginBroadcast; i10++) {
                    b bVar = (b) this.f24679a.getBroadcastItem(i10);
                    if (bVar != null) {
                        try {
                            bVar.m(mahProxyAddress, mahProxyAddress2, mahProxyAddress3, proxyChangedReason.ordinal());
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f24679a.finishBroadcast();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
