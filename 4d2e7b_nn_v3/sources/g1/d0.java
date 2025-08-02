package g1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.core.api.MTProtocol;
import com.engagelab.privates.push.api.MobileNumberMessage;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import s1.a;
import z1.a;

public class d0 extends b0 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile d0 f21578c;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap f21579b = new ConcurrentHashMap();

    public static d0 e() {
        if (f21578c == null) {
            synchronized (d0.class) {
                f21578c = new d0();
            }
        }
        return f21578c;
    }

    public final int b(String str) {
        if (!Pattern.compile("^[+0-9][-0-9]{1,}$").matcher(str).matches()) {
            a.h("MTMobileNumberBusiness", "[" + str + "] is not mobileNumber");
            return a.C0362a.f25006i;
        } else if (a() != 0) {
            return a.C0362a.f25005h;
        } else {
            return 0;
        }
    }

    public void c(Context context, int i10, Bundle bundle) {
        MTCommonReceiver f10;
        try {
            bundle.setClassLoader(MobileNumberMessage.class.getClassLoader());
            MobileNumberMessage mobileNumberMessage = (MobileNumberMessage) bundle.getParcelable("message");
            if (mobileNumberMessage != null && (f10 = p1.a.f(context)) != null) {
                f10.onMobileNumber(context, mobileNumberMessage);
            }
        } catch (Throwable th) {
            s1.a.h("MTMobileNumberBusiness", "processMainMessage failed " + th.getMessage());
        }
    }

    public void d(Context context, Bundle bundle) {
        try {
            MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable("protocol");
            if (mTProtocol != null) {
                int c10 = (int) mTProtocol.c();
                String str = (String) this.f21579b.get(Integer.valueOf(c10));
                this.f21579b.remove(Integer.valueOf(c10));
                if (!TextUtils.isEmpty(str)) {
                    MobileNumberMessage b10 = new MobileNumberMessage().c(c10).a(a.C0362a.f24998a).b(str);
                    s1.a.a("MTMobileNumberBusiness", "onMobileNumberFailed mobileNumberMessage:" + b10.toString());
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("message", b10);
                    h1.a.i(context, 3023, bundle2);
                }
            }
        } catch (Throwable th) {
            s1.a.h("MTMobileNumberBusiness", "onMobileNumberFailed failed " + th.getMessage());
        }
    }

    public void f(Context context, int i10, Bundle bundle) {
        try {
            int i11 = bundle.getInt("sequence");
            String string = bundle.getString("mobileNumber");
            int b10 = b(string);
            if (b10 != 0) {
                s1.a.a("MTMobileNumberBusiness", "sendMobileNumberOperation failed code:" + b10 + ", sequence:" + i11 + ", mobileNumber:" + string);
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("message", new MobileNumberMessage().c(i11).a(b10).b(string));
                h1.a.i(context, 3023, bundle2);
                return;
            }
            this.f21579b.put(Integer.valueOf(i11), string);
            s1.a.a("MTMobileNumberBusiness", "sendMobileNumberOperation sequence:" + i11 + ", mobileNumber:" + string);
            MTProtocol f10 = new MTProtocol().h((long) i11).g(26).j(1).f(d.c(string));
            Bundle bundle3 = new Bundle();
            bundle3.putParcelable("protocol", f10);
            h1.a.j(context, 2222, bundle3);
        } catch (Throwable th) {
            s1.a.h("MTMobileNumberBusiness", "processRemoteMessage failed " + th.getMessage());
        }
    }

    public void g(Context context, Bundle bundle) {
        try {
            MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable("protocol");
            int c10 = (int) mTProtocol.c();
            if (!this.f21579b.containsKey(Integer.valueOf(c10))) {
                s1.a.a("MTMobileNumberBusiness", "failed ");
                return;
            }
            this.f21579b.remove(Integer.valueOf(c10));
            MobileNumberMessage b10 = new MobileNumberMessage().c(c10).a(ByteBuffer.wrap(mTProtocol.a()).getShort()).b((String) this.f21579b.get(Integer.valueOf(c10)));
            s1.a.a("MTMobileNumberBusiness", "onMobileNumberSuccess mobileNumberMessage:" + b10.toString());
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("message", b10);
            h1.a.i(context, 3023, bundle2);
        } catch (Throwable th) {
            s1.a.h("MTMobileNumberBusiness", "onMobileNumberSuccess failed " + th.getMessage());
        }
    }
}
