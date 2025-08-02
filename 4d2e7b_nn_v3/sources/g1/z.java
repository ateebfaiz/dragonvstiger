package g1;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.blankj.utilcode.util.h;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.core.api.MTProtocol;
import com.engagelab.privates.core.api.MTReporter;
import com.engagelab.privates.push.api.PlatformTokenMessage;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.firebase.messaging.Constants;
import com.zing.zalo.zalosdk.common.Constant;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONObject;
import t1.b;

public class z extends s {

    /* renamed from: f  reason: collision with root package name */
    public static volatile z f21616f;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentMap f21617b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public boolean f21618c = false;

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentMap f21619d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public Bundle f21620e;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f21621a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bundle f21622b;

        public a(z zVar, Context context, Bundle bundle) {
            this.f21621a = context;
            this.f21622b = bundle;
        }

        public void run() {
            h1.a.j(this.f21621a, 3979, this.f21622b);
        }
    }

    public static z i() {
        if (f21616f == null) {
            synchronized (z.class) {
                f21616f = new z();
            }
        }
        return f21616f;
    }

    public final String d(Context context, String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1619859642:
                if (str.equals("blackshark")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1320380160:
                if (str.equals("oneplus")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1206476313:
                if (str.equals("huawei")) {
                    c10 = 2;
                    break;
                }
                break;
            case -934971466:
                if (str.equals("realme")) {
                    c10 = 3;
                    break;
                }
                break;
            case -759499589:
                if (str.equals(Constants.REFERRER_API_XIAOMI)) {
                    c10 = 4;
                    break;
                }
                break;
            case 3418016:
                if (str.equals("oppo")) {
                    c10 = 5;
                    break;
                }
                break;
            case 3620012:
                if (str.equals("vivo")) {
                    c10 = 6;
                    break;
                }
                break;
            case 99462250:
                if (str.equals("honor")) {
                    c10 = 7;
                    break;
                }
                break;
            case 103777484:
                if (str.equals("meizu")) {
                    c10 = 8;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return j(context, "ro.joyui.ui.version.code");
            case 1:
                String j10 = j(context, "ro.rom.version");
                if (TextUtils.isEmpty(j10)) {
                    return j(context, "ro.build.version.opporom");
                }
                return j10;
            case 2:
                String j11 = j(context, "ro.build.version.emui");
                if (TextUtils.isEmpty(j11)) {
                    return j(context, "hw_sc.build.platform.version");
                }
                return j11;
            case 3:
                return j(context, "ro.build.version.realmeui");
            case 4:
                return j(context, "ro.miui.ui.version.name");
            case 5:
                return j(context, "ro.build.version.opporom");
            case 6:
                return j(context, "ro.vivo.os.build.display.id");
            case 7:
                return j(context, "ro.build.version.magic");
            case 8:
                return j(context, "ro.flyme.version.id");
            default:
                return "";
        }
    }

    public void e(Context context) {
        s1.a.a("MTPlatformBusiness", "on_tcp_connected init");
        try {
            int d10 = b.d(context);
            s1.a.a("MTPlatformBusiness", "lastFrom:" + d10);
            if (d10 > 0) {
                String a10 = b.a(context);
                if (!TextUtils.isEmpty(a10)) {
                    String[] split = a10.split("_");
                    byte parseByte = Byte.parseByte(split[0]);
                    int intValue = Integer.valueOf(split[1]).intValue();
                    int intValue2 = Integer.valueOf(split[2]).intValue();
                    s1.a.a("MTPlatformBusiness", "init lastPlatformNode platform=" + parseByte + " code=" + intValue + " m_code=" + intValue2);
                    f(context, parseByte, intValue, intValue2, "");
                    b.c(context, "");
                }
            }
        } catch (Throwable th) {
            s1.a.h("MTPlatformBusiness", "lastFrom failed " + th.getMessage());
        }
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        if (!TextUtils.isEmpty(lowerCase)) {
            String j10 = p1.a.j(context);
            s1.a.a("MTPlatformBusiness", "manufacturer is " + lowerCase + ", countryCode:" + j10);
            k(context);
            q(context, j10);
            t(context, lowerCase);
            v(context, lowerCase);
            w(context, lowerCase);
            o(context, lowerCase);
            x(context, lowerCase);
            y(context, lowerCase);
            z(context, lowerCase);
            h1.a.i(context, 3101, this.f21620e);
        }
    }

    public final void f(Context context, byte b10, int i10, int i11, String str) {
        try {
            byte f10 = x1.a.f(context);
            String j10 = p1.a.j(context);
            String str2 = Build.PRODUCT;
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            String str3 = Build.VERSION.RELEASE;
            String d10 = d(context, lowerCase);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", b10);
            jSONObject.put(Constant.PARAM_OAUTH_CODE, i10);
            jSONObject.put("m_code", i11);
            jSONObject.put("m_flag", f10);
            jSONObject.put("m_token", str);
            jSONObject.put("country_code", j10);
            jSONObject.put("product", str2);
            jSONObject.put("manufacturer", lowerCase);
            jSONObject.put("system_version", str3);
            jSONObject.put("m_system_version", d10);
            MTReporter c10 = new MTReporter().d("platform_node").c(jSONObject.toString());
            Bundle bundle = new Bundle();
            bundle.putParcelable("protocol", c10);
            h1.a.j(context, 2233, bundle);
        } catch (Throwable th) {
            s1.a.h("MTPlatformBusiness", "reportPlatformNode failed " + th.getMessage());
        }
    }

    public final void g(Context context, PlatformTokenMessage platformTokenMessage, boolean z10) {
        PlatformTokenMessage platformTokenMessage2 = (PlatformTokenMessage) this.f21619d.get(Byte.valueOf(platformTokenMessage.a()));
        if (platformTokenMessage2 != null) {
            if (!platformTokenMessage2.c().equals(platformTokenMessage.c())) {
                z10 = false;
            } else {
                this.f21619d.remove(Byte.valueOf(platformTokenMessage.a()));
            }
            if (z10) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("message", platformTokenMessage);
                bundle.putBoolean("is_repetition_send", true);
                h1.a.d(context, y1.a.f24870a, new a(this, context, bundle), 1000);
                return;
            }
            return;
        }
        s1.a.b("MTPlatformBusiness", "cache not has platformToken, platformToken:" + platformTokenMessage.toString());
    }

    public final boolean h(PlatformTokenMessage platformTokenMessage, Bundle bundle) {
        PlatformTokenMessage platformTokenMessage2 = (PlatformTokenMessage) this.f21619d.get(Byte.valueOf(platformTokenMessage.a()));
        if (platformTokenMessage2 != null) {
            if (platformTokenMessage2.c().equals(platformTokenMessage.c())) {
                return true;
            }
            boolean z10 = bundle.getBoolean("is_repetition_send", false);
            if (z10) {
                s1.a.b("MTPlatformBusiness", "isRepetitionToken is_repetition_send:" + z10);
                return true;
            }
        }
        this.f21619d.put(Byte.valueOf(platformTokenMessage.a()), platformTokenMessage);
        return false;
    }

    public final String j(Context context, String str) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod("get", new Class[]{String.class}).invoke(loadClass, new Object[]{str});
        } catch (Throwable th) {
            s1.a.h("MTPlatformBusiness", "getPropertiesStringValue failed " + th.getMessage());
            return "";
        }
    }

    public final void k(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager.getNotificationChannel("MTPush_Private") == null) {
                notificationManager.createNotificationChannel(h.a("MTPush_Private", "Notification", 3));
            }
        }
    }

    public void l(Context context, Bundle bundle) {
        try {
            byte b10 = bundle.getByte("platform");
            int i10 = bundle.getInt(Constant.PARAM_OAUTH_CODE);
            int i11 = bundle.getInt("mCode");
            int i12 = bundle.getInt("type");
            int i13 = bundle.getInt(Constants.MessagePayloadKeys.FROM);
            String k10 = f0.k(context, b10);
            s1.a.a("MTPlatformBusiness", "onPlatformNode platform=" + b10 + " code=" + i10 + " m_code=" + i11 + " mToken=" + k10 + " type=" + i12 + " currentFrom=" + i13);
            if (3900 == i12) {
                int d10 = b.d(context);
                int i14 = d10 ^ i13;
                if (i14 == 3) {
                    s1.a.a("MTPlatformBusiness", "onTokenFailed, all method obtain orFrom=" + i14 + " lastFrom=" + d10 + " currentFrom=" + i13);
                    f(context, b10, AuthApiStatusCodes.AUTH_URL_RESOLUTION, i11, k10);
                    b.b(context, 0);
                    b.c(context, "");
                    return;
                }
                b.b(context, i13);
                b.c(context, b10 + "_" + i10 + "_" + i11);
                s1.a.a("MTPlatformBusiness", "oneTokenFailed, one method obtain, orFrom=" + i14 + " lastFrom=" + d10 + " currentFrom=" + i13);
                return;
            }
            f(context, b10, i10, i11, k10);
            if (3901 == i12) {
                b.b(context, 0);
                b.c(context, "");
            }
        } catch (Throwable th) {
            s1.a.h("MTPlatformBusiness", "reportPlatformNode failed " + th.getMessage());
        }
    }

    public void m(Context context) {
        this.f21618c = true;
    }

    public void n(Context context, Bundle bundle) {
        byte b10;
        long c10 = ((MTProtocol) bundle.getParcelable("protocol")).c();
        if (this.f21617b.containsKey(Long.valueOf(c10))) {
            PlatformTokenMessage platformTokenMessage = (PlatformTokenMessage) this.f21617b.get(Long.valueOf(c10));
            this.f21617b.remove(Long.valueOf(c10));
            byte a10 = platformTokenMessage.a();
            String c11 = platformTokenMessage.c();
            s1.a.a("MTPlatformBusiness", "onPlatformTokenFailed, rid:" + c10 + ", platformToken:" + platformTokenMessage.toString());
            if (TextUtils.equals(c11, f0.k(context, a10))) {
                s1.a.a("MTPlatformBusiness", "no need update platform state");
                f(context, a10, AuthApiStatusCodes.AUTH_APP_CERT_ERROR, 0, c11);
                g(context, platformTokenMessage, true);
                return;
            }
            byte f10 = (byte) (x1.a.f(context) | a10);
            if (a10 == 8) {
                b10 = f10 & 223;
            } else {
                b10 = f10 | 128;
            }
            byte b11 = (byte) b10;
            s1.a.a("MTPlatformBusiness", "set platform state:" + b11);
            x1.a.k(context, b11);
            f(context, a10, AuthApiStatusCodes.AUTH_APP_CERT_ERROR, 0, c11);
            g(context, platformTokenMessage, true);
        }
    }

    public final void o(Context context, String str) {
        if (TextUtils.equals(str, com.adjust.sdk.Constants.REFERRER_API_XIAOMI) || TextUtils.equals(str, "blackshark")) {
            try {
                h1.a.c(context, (b) Class.forName("com.engagelab.privates.push.platform.mi.global.MTMiGlobal").newInstance());
            } catch (Throwable unused) {
                s1.a.a("MTPlatformBusiness", "not integrated global mi.aar");
                f(context, (byte) 1, AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN, 0, "");
            }
        }
    }

    public void p(Context context, Bundle bundle) {
        byte b10;
        MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable("protocol");
        long c10 = mTProtocol.c();
        short s10 = ByteBuffer.wrap(mTProtocol.a()).getShort();
        if (!this.f21617b.containsKey(Long.valueOf(c10))) {
            s1.a.a("MTPlatformBusiness", "onPlatformTokenFailed, rid:" + c10 + ", internal error");
            return;
        }
        PlatformTokenMessage platformTokenMessage = (PlatformTokenMessage) this.f21617b.get(Long.valueOf(c10));
        this.f21617b.remove(Long.valueOf(c10));
        byte a10 = platformTokenMessage.a();
        String c11 = platformTokenMessage.c();
        if (s10 != 0) {
            s1.a.a("MTPlatformBusiness", "onPlatformTokenFailed, rid:" + c10 + ", code:" + s10);
            f(context, a10, AuthApiStatusCodes.AUTH_APP_CERT_ERROR, s10, c11);
            g(context, platformTokenMessage, false);
            return;
        }
        s1.a.a("MTPlatformBusiness", "onPlatformTokenSuccess, rid:" + c10 + ", platformToken:" + platformTokenMessage.toString());
        if (TextUtils.equals(c11, f0.k(context, a10))) {
            s1.a.a("MTPlatformBusiness", "no need update platform state");
            f(context, a10, 3007, 0, c11);
            return;
        }
        f0.d(context, a10, c11);
        byte f10 = (byte) (x1.a.f(context) | a10);
        if (a10 == 8) {
            b10 = f10 | 32;
        } else {
            b10 = f10 & Byte.MAX_VALUE;
        }
        byte b11 = (byte) b10;
        s1.a.a("MTPlatformBusiness", "set platform state:" + b11);
        x1.a.k(context, b11);
        f(context, a10, 3007, 0, c11);
    }

    public final void q(Context context, String str) {
        try {
            if (!TextUtils.equals(str, "CN")) {
                int i10 = a2.a.f13665b;
                h1.a.c(context, a2.a.class.newInstance());
            }
        } catch (Throwable unused) {
            s1.a.a("MTPlatformBusiness", "not integrated google.aar");
            f(context, (byte) 8, AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN, 0, "");
        }
    }

    public final boolean r(Context context) {
        boolean z10 = true;
        try {
            if (TextUtils.isEmpty(p1.a.r(context, "com.hihonor.push.app_id"))) {
                s1.a.b("MTPlatformBusiness", "not support honor push, honor appId is empty");
                return false;
            }
            Class<?> cls = Class.forName("com.hihonor.push.sdk.a");
            if (((Integer) cls.getDeclaredMethod("b", new Class[]{Context.class}).invoke(cls, new Object[]{context})).intValue() != 0) {
                z10 = false;
            }
            s1.a.a("MTPlatformBusiness", "honor available :" + z10);
            return z10;
        } catch (Throwable th) {
            s1.a.a("MTPlatformBusiness", "isSupportHonorPush error:" + th);
            return false;
        }
    }

    public void s(Context context, Bundle bundle) {
        MTCommonReceiver f10;
        PlatformTokenMessage platformTokenMessage = (PlatformTokenMessage) bundle.getParcelable("message");
        if (platformTokenMessage != null && (f10 = p1.a.f(context)) != null) {
            String c10 = platformTokenMessage.c();
            f0.d(context, platformTokenMessage.a(), c10);
            s1.a.b("MTPlatformBusiness", "processMainToken:" + c10);
            f10.onPlatformToken(context, platformTokenMessage);
            h1.a.j(context, 3979, bundle);
        }
    }

    public final void t(Context context, String str) {
        if (TextUtils.equals(str, "huawei") || (TextUtils.equals(str, "honor") && !r(context))) {
            try {
                h1.a.c(context, (b) Class.forName("com.engagelab.privates.push.platform.huawei.MTHuawei").newInstance());
            } catch (Throwable unused) {
                s1.a.a("MTPlatformBusiness", "not integrated huawei.aar");
                f(context, (byte) 2, AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN, 0, "");
            }
        } else {
            s1.a.a("MTPlatformBusiness", "not integrate huawei");
        }
    }

    public void u(Context context, Bundle bundle) {
        bundle.setClassLoader(PlatformTokenMessage.class.getClassLoader());
        PlatformTokenMessage platformTokenMessage = (PlatformTokenMessage) bundle.getParcelable("message");
        if (!this.f21618c) {
            g(context, platformTokenMessage, true);
            s1.a.h("MTPlatformBusiness", "stop send platformToken Login first, platformToken:" + platformTokenMessage.toString());
        } else if (h(platformTokenMessage, bundle)) {
            s1.a.h("MTPlatformBusiness", "stop send repetition platformToken, platformToken:" + platformTokenMessage.toString());
        } else {
            long h10 = x1.a.h();
            this.f21617b.put(Long.valueOf(h10), platformTokenMessage);
            s1.a.b("MTPlatformBusiness", "send platformToken, rid:" + h10 + ", platformToken:" + platformTokenMessage.toString());
            MTProtocol i10 = new MTProtocol().h(h10).g(27).j(2).f(d.a(platformTokenMessage.a(), platformTokenMessage.c(), platformTokenMessage.b())).i(y1.a.f24870a);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("protocol", i10);
            h1.a.j(context, 2222, bundle2);
        }
    }

    public final void v(Context context, String str) {
        if (TextUtils.equals(str, "honor")) {
            try {
                h1.a.c(context, (b) Class.forName("com.engagelab.privates.push.platform.honor.MTHonor").newInstance());
            } catch (Throwable unused) {
                s1.a.a("MTPlatformBusiness", "not integrated honor.aar");
                f(context, (byte) 7, AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN, 0, "");
            }
        }
    }

    public final void w(Context context, String str) {
        if (TextUtils.equals(str, com.adjust.sdk.Constants.REFERRER_API_XIAOMI) || TextUtils.equals(str, "blackshark")) {
            try {
                h1.a.c(context, (b) Class.forName("com.engagelab.privates.push.platform.mi.MTMi").newInstance());
            } catch (Throwable unused) {
                s1.a.a("MTPlatformBusiness", "not integrated mi.aar");
                f(context, (byte) 1, AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN, 0, "");
            }
        }
    }

    public final void x(Context context, String str) {
        if (TextUtils.equals(str, "meizu")) {
            try {
                h1.a.c(context, (b) Class.forName("com.engagelab.privates.push.platform.meizu.MTMeizu").newInstance());
            } catch (Throwable unused) {
                s1.a.a("MTPlatformBusiness", "not integrated meizu.aar");
                f(context, (byte) 3, AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN, 0, "");
            }
        }
    }

    public final void y(Context context, String str) {
        if (TextUtils.equals(str, "oppo") || TextUtils.equals(str, "realme") || TextUtils.equals(str, "oneplus")) {
            try {
                h1.a.c(context, (b) Class.forName("com.engagelab.privates.push.platform.oppo.MTOppo").newInstance());
            } catch (Throwable unused) {
                s1.a.a("MTPlatformBusiness", "not integrated oppo.aar");
                f(context, (byte) 4, AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN, 0, "");
            }
        }
    }

    public final void z(Context context, String str) {
        if (TextUtils.equals(str, "vivo")) {
            try {
                h1.a.c(context, (b) Class.forName("com.engagelab.privates.push.platform.vivo.MTVivo").newInstance());
            } catch (Throwable unused) {
                s1.a.a("MTPlatformBusiness", "not integrated vivo.aar");
                f(context, (byte) 5, AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN, 0, "");
            }
        }
    }
}
