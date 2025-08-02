package q5;

import android.os.Bundle;
import com.facebook.o;
import com.facebook.w;
import com.google.firebase.messaging.Constants;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.Arrays;
import java.util.Collection;
import kotlin.collections.r;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;
import q5.d0;

public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23341a;

    /* renamed from: b  reason: collision with root package name */
    private static final Collection f23342b = r.o("service_disabled", "AndroidAuthKillSwitchException");

    /* renamed from: c  reason: collision with root package name */
    private static final Collection f23343c = r.o("access_denied", "OAuthAccessDeniedException");

    /* renamed from: d  reason: collision with root package name */
    private static final String f23344d = "CONNECTION_FAILURE";

    /* renamed from: e  reason: collision with root package name */
    public static final i0 f23345e = new i0();

    static {
        String name = i0.class.getName();
        m.e(name, "ServerProtocol::class.java.name");
        f23341a = name;
    }

    private i0() {
    }

    public static final String a() {
        return "v12.0";
    }

    public static final String b() {
        b0 b0Var = b0.f709a;
        String format = String.format("m.%s", Arrays.copyOf(new Object[]{o.q()}, 1));
        m.e(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String c() {
        return f23344d;
    }

    public static final Collection d() {
        return f23342b;
    }

    public static final Collection e() {
        return f23343c;
    }

    public static final String f() {
        b0 b0Var = b0.f709a;
        String format = String.format("https://graph.%s", Arrays.copyOf(new Object[]{o.q()}, 1));
        m.e(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String g() {
        b0 b0Var = b0.f709a;
        String format = String.format("https://graph.%s", Arrays.copyOf(new Object[]{o.s()}, 1));
        m.e(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String h(String str) {
        m.f(str, "subdomain");
        b0 b0Var = b0.f709a;
        String format = String.format("https://graph.%s", Arrays.copyOf(new Object[]{str}, 1));
        m.e(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String i() {
        b0 b0Var = b0.f709a;
        String format = String.format("https://graph-video.%s", Arrays.copyOf(new Object[]{o.s()}, 1));
        m.e(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String j() {
        b0 b0Var = b0.f709a;
        String format = String.format("m.%s", Arrays.copyOf(new Object[]{o.t()}, 1));
        m.e(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final Bundle k(String str, int i10, Bundle bundle) {
        m.f(str, "callId");
        String i11 = o.i(o.f());
        if (p0.Y(i11)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("android_key_hash", i11);
        bundle2.putString(Constant.PARAM_APP_ID, o.g());
        bundle2.putInt("version", i10);
        bundle2.putString(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "touch");
        Bundle bundle3 = new Bundle();
        bundle3.putString("action_id", str);
        try {
            JSONObject b10 = c.b(bundle3);
            if (bundle == null) {
                bundle = new Bundle();
            }
            JSONObject b11 = c.b(bundle);
            if (b10 != null) {
                if (b11 != null) {
                    bundle2.putString("bridge_args", b10.toString());
                    bundle2.putString("method_args", b11.toString());
                    return bundle2;
                }
            }
            return null;
        } catch (JSONException e10) {
            d0.a aVar = d0.f23283f;
            w wVar = w.DEVELOPER_ERRORS;
            String str2 = f23341a;
            aVar.a(wVar, 6, str2, "Error creating Url -- " + e10);
            return null;
        } catch (IllegalArgumentException e11) {
            d0.a aVar2 = d0.f23283f;
            w wVar2 = w.DEVELOPER_ERRORS;
            String str3 = f23341a;
            aVar2.a(wVar2, 6, str3, "Error creating Url -- " + e11);
            return null;
        }
    }
}
