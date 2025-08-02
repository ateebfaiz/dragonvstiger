package g1;

import android.content.Context;
import android.os.Bundle;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.core.api.MTProtocol;
import java.nio.ByteBuffer;
import s1.a;

public class f {

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f21585d;

    /* renamed from: a  reason: collision with root package name */
    public final l f21586a = new l();

    /* renamed from: b  reason: collision with root package name */
    public final h f21587b = j.a();

    /* renamed from: c  reason: collision with root package name */
    public int f21588c = 0;

    public static f a() {
        if (f21585d == null) {
            synchronized (f.class) {
                f21585d = new f();
            }
        }
        return f21585d;
    }

    public void b(Context context) {
        this.f21588c++;
        a.a("MTConnectBusiness", "onAckFailed :" + this.f21588c);
        if (this.f21588c < 5) {
            k(context);
            i(context);
            return;
        }
        this.f21588c = 0;
        h1.a.j(context, 2993, (Bundle) null);
        h1.a.j(context, 2994, (Bundle) null);
    }

    public void c(Context context, Bundle bundle) {
        ByteBuffer wrap = ByteBuffer.wrap(((MTProtocol) bundle.getParcelable("protocol")).a());
        byte b10 = wrap.get();
        byte b11 = wrap.get();
        byte b12 = wrap.get();
        long j10 = wrap.getLong();
        a.a("MTConnectBusiness", "onAckSuccess command:" + b10 + ", result:" + b11 + ", code:" + b12 + ", serverTime:" + j10);
        if (b10 == 2) {
            a.e("MTConnectBusiness", "onHeartbeatSuccess");
            this.f21588c = 0;
            h1.a.j(context, 2003, (Bundle) null);
            h1.a.j(context, 2997, (Bundle) null);
            h1.a.j(context, 2233, (Bundle) null);
        }
    }

    public void d(Context context) {
        MTCommonReceiver f10 = p1.a.f(context);
        if (f10 != null) {
            f10.onConnectStatus(context, true);
        }
    }

    public void e(Context context, Bundle bundle) {
        this.f21587b.d(context, bundle);
    }

    public boolean f() {
        return this.f21587b.j();
    }

    public void g(Context context) {
        MTCommonReceiver f10 = p1.a.f(context);
        if (f10 != null) {
            f10.onConnectStatus(context, false);
        }
    }

    public void h(Context context) {
        if (!n.p(context)) {
            a.h("MTConnectBusiness", "connect state is false, can't startConnect");
            return;
        }
        a.a("MTConnectBusiness", "startConnect");
        this.f21586a.i(context);
        this.f21587b.r(context);
    }

    public void i(Context context) {
        a.a("MTConnectBusiness", "startHeartbeat");
        String str = v1.a.f24387a;
        h1.a.h(context, str, 2992, (Bundle) null, x1.a.c());
        MTProtocol i10 = new MTProtocol().g(2).j(4).f(o.h(context)).i(str);
        Bundle bundle = new Bundle();
        bundle.putParcelable("protocol", i10);
        e(context, bundle);
    }

    public void j(Context context) {
        a.a("MTConnectBusiness", "stopConnect");
        this.f21586a.l(context);
        this.f21587b.s(context);
    }

    public void k(Context context) {
        a.a("MTConnectBusiness", "stopHeartbeat");
        h1.a.f(context, v1.a.f24387a, 2992);
    }

    public void l(Context context) {
        a.a("MTConnectBusiness", "turnOffConnect");
        n.g(context, false);
        h1.a.j(context, 2993, (Bundle) null);
    }

    public void m(Context context) {
        a.a("MTConnectBusiness", "turnOnConnect");
        n.g(context, true);
        h1.a.j(context, 2994, (Bundle) null);
    }
}
