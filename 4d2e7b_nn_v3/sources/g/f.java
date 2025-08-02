package g;

import com.mah.sdk.MahProxy;
import com.mah.sdk.MahProxyAddress;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f21527a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MahProxyAddress f21528b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MahProxyAddress f21529c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MahProxyAddress f21530d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MahProxy.ProxyChangedReason f21531e;

    public /* synthetic */ f(i iVar, MahProxyAddress mahProxyAddress, MahProxyAddress mahProxyAddress2, MahProxyAddress mahProxyAddress3, MahProxy.ProxyChangedReason proxyChangedReason) {
        this.f21527a = iVar;
        this.f21528b = mahProxyAddress;
        this.f21529c = mahProxyAddress2;
        this.f21530d = mahProxyAddress3;
        this.f21531e = proxyChangedReason;
    }

    public final void run() {
        this.f21527a.x(this.f21528b, this.f21529c, this.f21530d, this.f21531e);
    }
}
