package g1;

import android.content.Context;
import android.os.Bundle;
import androidx.autofill.HintConstants;
import com.engagelab.privates.core.api.MTProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.zing.zalo.zalosdk.common.Constant;
import h1.a;
import java.nio.ByteBuffer;
import org.json.JSONObject;
import w1.b;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f21575a;

    public static c a() {
        if (f21575a == null) {
            synchronized (c.class) {
                f21575a = new c();
            }
        }
        return f21575a;
    }

    public void b(Context context) {
        int t10 = n.t(context);
        int z10 = n.z(context);
        long A = n.A(context);
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.PARAM_OAUTH_CODE, t10);
        bundle.putInt("seed_id", z10);
        bundle.putLong("server_time", A);
        a.i(context, 2102, bundle);
    }

    public void c(Context context, Bundle bundle) {
        try {
            MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable("protocol");
            mTProtocol.c();
            ByteBuffer wrap = ByteBuffer.wrap(mTProtocol.a());
            long j10 = wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            String str = new String(bArr, o1.a.f22951b);
            b bVar = new b();
            bVar.h(0);
            bVar.k(j10);
            bVar.g("".getBytes());
            MTProtocol f10 = new MTProtocol().h(j10).g(25).j(1).f(bVar.d());
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("protocol", f10);
            a.j(context, 2222, bundle2);
            JSONObject jSONObject = new JSONObject(str);
            s1.a.a("MTCoreBusiness", "onCtrl " + s1.a.g(jSONObject));
            int optInt = jSONObject.optInt("cmd");
            JSONObject optJSONObject = jSONObject.optJSONObject(FirebaseAnalytics.Param.CONTENT);
            Bundle bundle3 = new Bundle();
            bundle3.putString("protocol", optJSONObject.toString());
            a.j(context, optInt, bundle3);
        } catch (Throwable th) {
            s1.a.h("MTCoreBusiness", "onCtrl failed " + th.getMessage());
        }
    }

    public void d(Context context) {
        int x10 = n.x(context);
        long G = n.G(context);
        String y10 = n.y(context);
        String v10 = n.v(context);
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.PARAM_OAUTH_CODE, x10);
        bundle.putLong("user_id", G);
        bundle.putString("registration_id", y10);
        bundle.putString(HintConstants.AUTOFILL_HINT_PASSWORD, v10);
        a.i(context, 2101, bundle);
    }

    public void e(Context context, Bundle bundle) {
        int i10 = bundle.getInt(Constant.PARAM_OAUTH_CODE);
        int i11 = bundle.getInt("seed_id");
        long j10 = bundle.getLong("server_time");
        x1.a.i(i10);
        x1.a.n(i11);
        x1.a.o(j10);
    }

    public void f(Context context, Bundle bundle) {
        int i10 = bundle.getInt(Constant.PARAM_OAUTH_CODE);
        long j10 = bundle.getLong("user_id");
        String string = bundle.getString("registration_id");
        String string2 = bundle.getString(HintConstants.AUTOFILL_HINT_PASSWORD);
        x1.a.l(i10);
        x1.a.p(j10);
        x1.a.m(string);
        x1.a.j(string2);
    }
}
