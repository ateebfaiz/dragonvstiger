package z8;

import android.content.Context;
import com.geetest.core.GeeGuard;
import com.geetest.core.e;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f13457a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f13458b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GeeGuard.CallbackHandler f13459c;

    public /* synthetic */ g(e eVar, Context context, GeeGuard.CallbackHandler callbackHandler) {
        this.f13457a = eVar;
        this.f13458b = context;
        this.f13459c = callbackHandler;
    }

    public final void run() {
        this.f13457a.a(this.f13458b, this.f13459c);
    }
}
