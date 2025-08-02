package a9;

import com.geetest.gtc4.GeeGuard;
import com.geetest.gtc4.GeeGuardReceipt;
import com.geetest.gtc4.b;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2252a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GeeGuardReceipt f2253b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f2254c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ GeeGuard.CallbackHandler f2255d;

    public /* synthetic */ a(String str, GeeGuardReceipt geeGuardReceipt, int i10, GeeGuard.CallbackHandler callbackHandler) {
        this.f2252a = str;
        this.f2253b = geeGuardReceipt;
        this.f2254c = i10;
        this.f2255d = callbackHandler;
    }

    public final void run() {
        b.a(this.f2252a, this.f2253b, this.f2254c, this.f2255d);
    }
}
