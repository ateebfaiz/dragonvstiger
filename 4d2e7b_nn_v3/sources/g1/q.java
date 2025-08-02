package g1;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.core.api.MTReporter;
import com.engagelab.privates.push.api.NotificationLayout;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import d2.i;
import java.util.Arrays;
import java.util.Calendar;
import java.util.regex.Pattern;
import org.json.JSONObject;
import s1.a;
import u1.e;

public class q {

    /* renamed from: b  reason: collision with root package name */
    public static volatile q f21605b;

    /* renamed from: a  reason: collision with root package name */
    public int f21606a = -1;

    public static q c() {
        if (f21605b == null) {
            synchronized (q.class) {
                f21605b = new q();
            }
        }
        return f21605b;
    }

    public int a(Context context) {
        return f0.s(context);
    }

    public NotificationLayout b(Context context, int i10) {
        try {
            String b10 = f0.b(context, i10);
            if (TextUtils.isEmpty(b10)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(b10);
            if (jSONObject.length() == 0) {
                return null;
            }
            int optInt = jSONObject.optInt("layout_id");
            int optInt2 = jSONObject.optInt("icon_view_id");
            int optInt3 = jSONObject.optInt("icon_resource_id");
            int optInt4 = jSONObject.optInt("title_view_id");
            int optInt5 = jSONObject.optInt("content_view_id");
            NotificationLayout k10 = new NotificationLayout().j(optInt).i(optInt2).h(optInt3).l(optInt4).g(optInt5).k(jSONObject.optInt("time_view_id"));
            a.a("MTPushBusiness", "getNotificationLayout builderId:" + i10 + k10.toString());
            return k10;
        } catch (Throwable th) {
            a.h("MTPushBusiness", "getNotificationLayout builderId:" + i10 + " failed " + th.getMessage());
            return null;
        }
    }

    public final void d(Context context, int i10, boolean z10) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("notification_state", z10);
            h1.a.i(context, AuthApiStatusCodes.AUTH_APP_CERT_ERROR, bundle);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("notification_state", z10);
            jSONObject.put("trigger_scene", i10);
            MTReporter c10 = new MTReporter().d("android_notification_state").c(jSONObject.toString());
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("protocol", c10);
            h1.a.j(context, 2233, bundle2);
            h1.a.j(context, 3799, bundle2);
        } catch (Throwable th) {
            a.h("MTPushBusiness", "onNotificationState failed " + th.getMessage());
        }
    }

    public void e(Context context, Bundle bundle) {
        try {
            MTCommonReceiver f10 = p1.a.f(context);
            if (f10 != null) {
                f10.onNotificationStatus(context, bundle.getBoolean("notification_state"));
            }
        } catch (Throwable th) {
            a.h("MTPushBusiness", "processMainNotificationState failed " + th.getMessage());
        }
    }

    public int f(Context context) {
        return f0.u(context);
    }

    public void g(Context context, int i10) {
        boolean m10 = i.m(context);
        int i11 = this.f21606a;
        if (i11 == -1) {
            a.a("MTPushBusiness", "notification state is " + m10);
            this.f21606a = m10;
            d(context, i10, m10);
        } else if (i11 == m10) {
            a.a("MTPushBusiness", "no need update notification state lastNotificationState:" + this.f21606a + ",currentNotificationState:" + m10);
        } else {
            a.a("MTPushBusiness", "notification state is " + m10);
            this.f21606a = m10 ? 1 : 0;
            d(context, i10, m10);
        }
    }

    public void h(Context context, Bundle bundle) {
        int i10 = bundle.getInt("id");
        a.a("MTPushBusiness", "resetNotificationLayout builderId:" + i10);
        f0.f(context, i10, "");
    }

    public void i(Context context, Bundle bundle) {
        int i10 = bundle.getInt("notification_badge");
        if (i10 < 0) {
            a.b("MTPushBusiness", "setNotificationBadge error: number count must >= 0");
            return;
        }
        f0.l(context, i10);
        String str = Build.MANUFACTURER;
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str.toLowerCase();
        lowerCase2.hashCode();
        if (lowerCase2.equals("huawei")) {
            i.x(context, i10);
        } else if (!lowerCase2.equals("honor")) {
            a.a("MTPushBusiness", "setNotificationBadge not support " + lowerCase);
        } else {
            i.w(context, i10);
        }
    }

    public boolean j(Context context) {
        try {
            String v10 = f0.v(context);
            if (TextUtils.isEmpty(v10)) {
                return true;
            }
            a.a("MTPushBusiness", "isNotificationShowTime showTime:" + v10);
            String[] split = v10.split("_");
            String str = split[0];
            String str2 = split[1];
            char[] charArray = str.toCharArray();
            String[] split2 = str2.split("\\^");
            Calendar instance = Calendar.getInstance();
            int i10 = instance.get(7);
            int i11 = instance.get(11);
            a.a("MTPushBusiness", "isNotificationShowTime currentHour:" + i11 + ",currentDay:" + i10);
            int length = charArray.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                int parseInt = Integer.parseInt(String.valueOf(charArray[i12]));
                a.a("MTPushBusiness", "settingDay:" + parseInt);
                if (i10 != parseInt + 1) {
                    break;
                }
                int parseInt2 = Integer.parseInt(split2[0]);
                int parseInt3 = Integer.parseInt(split2[1]);
                if (i11 >= parseInt2 && i11 <= parseInt3) {
                    return true;
                }
                i12++;
            }
            return false;
        } catch (Throwable th) {
            a.h("MTPushBusiness", "isNotificationShowTime failed " + th.getMessage());
            return true;
        }
    }

    public void k(Context context, Bundle bundle) {
        if (bundle != null) {
            int i10 = bundle.getInt("notification_count");
            if (i10 <= 0) {
                a.b("MTPushBusiness", "setNotificationCount error: count must > 0");
                return;
            }
            a.b("MTPushBusiness", "setNotificationCount " + i10);
            f0.q(context, i10);
        }
    }

    public boolean l(Context context) {
        try {
            String w10 = f0.w(context);
            if (TextUtils.isEmpty(w10)) {
                return false;
            }
            a.a("MTPushBusiness", "isNotificationSilenceTime cacheSilenceTime:" + w10);
            JSONObject jSONObject = new JSONObject(w10);
            int optInt = jSONObject.optInt("begin_hour");
            int optInt2 = jSONObject.optInt("begin_minute");
            int optInt3 = jSONObject.optInt("end_hour");
            int optInt4 = jSONObject.optInt("end_minute");
            Calendar instance = Calendar.getInstance();
            int i10 = instance.get(11);
            int i11 = instance.get(12);
            a.a("MTPushBusiness", "isNotificationSilenceTime currentTime:" + i10 + ":" + i11 + ", silenceTime:" + optInt + ":" + optInt2 + "-" + optInt3 + ":" + optInt4);
            if (optInt < optInt3) {
                if (i10 > optInt && i10 < optInt3) {
                    a.a("MTPushBusiness", "is notificationSilenceTime 1");
                    return true;
                } else if (i10 == optInt && i11 >= optInt2) {
                    a.a("MTPushBusiness", "is notificationSilenceTime 2");
                    return true;
                } else if (i10 != optInt3 || i11 > optInt4) {
                    a.a("MTPushBusiness", "not notificationSilenceTime 1");
                    return false;
                } else {
                    a.a("MTPushBusiness", "is notificationSilenceTime 3");
                    return true;
                }
            } else if (optInt != optInt3) {
                if (optInt > optInt3) {
                    if (i10 > optInt && i10 <= 23) {
                        a.a("MTPushBusiness", "is notificationSilenceTime 8");
                        return true;
                    } else if (i10 >= 0 && i10 < optInt3) {
                        a.a("MTPushBusiness", "is notificationSilenceTime 9");
                        return true;
                    } else if (i10 == optInt && i11 >= optInt2) {
                        a.a("MTPushBusiness", "is notificationSilenceTime 10");
                        return true;
                    } else if (i10 != optInt3 || i11 > optInt4) {
                        a.a("MTPushBusiness", "not notificationSilenceTime 4");
                        return false;
                    } else {
                        a.a("MTPushBusiness", "is notificationSilenceTime 11");
                        return true;
                    }
                }
                a.a("MTPushBusiness", "not notificationSilenceTime 5");
                return false;
            } else if (optInt2 >= optInt4) {
                if (i10 != optInt) {
                    a.a("MTPushBusiness", "is notificationSilenceTime 4");
                    return true;
                } else if (i11 >= optInt2) {
                    a.a("MTPushBusiness", "is notificationSilenceTime 5");
                    return true;
                } else if (i11 <= optInt4) {
                    a.a("MTPushBusiness", "is notificationSilenceTime 6");
                    return true;
                } else {
                    a.a("MTPushBusiness", "not notificationSilenceTime 2");
                    return false;
                }
            } else if (i10 != optInt || i11 < optInt2 || i11 > optInt4) {
                a.a("MTPushBusiness", "not notificationSilenceTime 3");
                return false;
            } else {
                a.a("MTPushBusiness", "is notificationSilenceTime 7");
                return true;
            }
        } catch (Throwable th) {
            a.h("MTPushBusiness", "isNotificationSilenceTime failed " + th.getMessage());
        }
    }

    public void m(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("itime", System.currentTimeMillis() / 1000);
            jSONObject.put("lang", e.c(context));
            jSONObject.put("contry", p1.a.j(context));
            jSONObject.put("carrier", e.b(context));
            jSONObject.put("os_version", e.i());
            jSONObject.put("os_version_code", e.j());
            jSONObject.put("model", e.e());
            jSONObject.put("device_name", e.h());
            jSONObject.put("product", e.f());
            jSONObject.put("manufacturer", e.d());
            jSONObject.put("time_zone", e.k());
            jSONObject.put("time_zone_id", e.l());
            jSONObject.put("app_version", p1.a.e(context));
            jSONObject.put("android_id", e.a(context));
            MTReporter c10 = new MTReporter().d("oversea_info").c(jSONObject.toString());
            Bundle bundle = new Bundle();
            bundle.putParcelable("protocol", c10);
            h1.a.j(context, 2233, bundle);
        } catch (Throwable th) {
            a.h("MTPushBusiness", "reportSoverseaInfo failed " + th.getMessage());
        }
    }

    public void n(Context context, Bundle bundle) {
        try {
            bundle.setClassLoader(NotificationLayout.class.getClassLoader());
            int i10 = bundle.getInt("id");
            NotificationLayout notificationLayout = (NotificationLayout) bundle.getParcelable("notification_layout");
            a.a("MTPushBusiness", "setNotificationLayout id:" + i10 + notificationLayout.toString());
            int d10 = notificationLayout.d();
            int c10 = notificationLayout.c();
            int b10 = notificationLayout.b();
            int f10 = notificationLayout.f();
            int a10 = notificationLayout.a();
            int e10 = notificationLayout.e();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("layout_id", d10);
            jSONObject.put("icon_view_id", c10);
            jSONObject.put("icon_resource_id", b10);
            jSONObject.put("title_view_id", f10);
            jSONObject.put("content_view_id", a10);
            jSONObject.put("time_view_id", e10);
            f0.f(context, i10, jSONObject.toString());
        } catch (Throwable th) {
            a.h("MTPushBusiness", "setNotificationLayout failed " + th.getMessage());
        }
    }

    public void o(Context context) {
        f0.l(context, 0);
        String str = Build.MANUFACTURER;
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str.toLowerCase();
        lowerCase2.hashCode();
        if (lowerCase2.equals("huawei")) {
            i.x(context, 0);
        } else if (!lowerCase2.equals("honor")) {
            a.a("MTPushBusiness", "setNotificationBadge not support " + lowerCase);
        } else {
            i.w(context, 0);
        }
    }

    public void p(Context context, Bundle bundle) {
        try {
            a.a("MTPushBusiness", "setNotificationShowTime:" + a.f(bundle));
            int[] intArray = bundle.getIntArray("day");
            if (intArray.length == 0) {
                a.a("MTPushBusiness", "setNotificationShowTime weekDays.length is 0, can't show notification everyTime");
                f0.r(context, "");
                return;
            }
            int i10 = bundle.getInt("begin_hour");
            int i11 = bundle.getInt("end_hour");
            a.a("MTPushBusiness", "setNotificationShowTime startHour:" + i10 + ",endHour:" + i11 + ",weekDays:" + Arrays.toString(intArray));
            StringBuilder sb2 = new StringBuilder();
            for (int valueOf : intArray) {
                sb2.append(Integer.valueOf(valueOf));
            }
            sb2.append("_");
            sb2.append(i10);
            sb2.append("^");
            sb2.append(i11);
            if (Pattern.compile("([0-6]{0,7})_((" + "([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])" + ")|(" + "([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])" + "-)+(" + "([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])" + "))").matcher(sb2).matches()) {
                f0.r(context, sb2.toString());
                return;
            }
            a.b("MTPushBusiness", "setNotificationShowTime invalid time format - " + sb2);
        } catch (Throwable th) {
            a.h("MTPushBusiness", "setNotificationPushTime failed " + th.getMessage());
        }
    }

    public void q(Context context) {
        a.a("MTPushBusiness", "resetNotificationCount");
        f0.q(context, 5);
    }

    public void r(Context context, Bundle bundle) {
        try {
            int i10 = bundle.getInt("begin_hour");
            int i11 = bundle.getInt("begin_minute");
            int i12 = bundle.getInt("end_hour");
            int i13 = bundle.getInt("end_minute");
            a.a("MTPushBusiness", "setNotificationSilenceTime:" + i10 + ":" + i11 + "-" + i12 + ":" + i13);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("begin_hour", i10);
            jSONObject.put("begin_minute", i11);
            jSONObject.put("end_hour", i12);
            jSONObject.put("end_minute", i13);
            f0.t(context, jSONObject.toString());
        } catch (Throwable th) {
            a.h("MTPushBusiness", "setNotificationSilenceTime failed " + th.getMessage());
        }
    }

    public void s(Context context) {
        a.a("MTPushBusiness", "resetNotificationShowTime");
        f0.r(context, "");
    }

    public void t(Context context) {
        a.a("MTPushBusiness", "resetNotificationSilenceTime");
        f0.t(context, "");
    }
}
