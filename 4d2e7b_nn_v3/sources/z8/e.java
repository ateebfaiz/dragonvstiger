package z8;

import android.content.Context;
import com.geetest.core.GeeGuard;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.geetest.core.e f13450a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f13451b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f13452c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f13453d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ GeeGuard.CallbackHandler f13454e;

    public /* synthetic */ e(com.geetest.core.e eVar, Context context, String str, int i10, GeeGuard.CallbackHandler callbackHandler) {
        this.f13450a = eVar;
        this.f13451b = context;
        this.f13452c = str;
        this.f13453d = i10;
        this.f13454e = callbackHandler;
    }

    public final void run() {
        this.f13450a.a(this.f13451b, this.f13452c, this.f13453d, this.f13454e);
    }
}
