package g1;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.exifinterface.media.ExifInterface;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.core.api.MTReporter;
import com.engagelab.privates.push.api.NotificationMessage;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import d2.b;
import d2.g;
import d2.i;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import s1.a;

public class w extends s {

    /* renamed from: b  reason: collision with root package name */
    public static ConcurrentHashMap f21612b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public static volatile w f21613c = null;

    public static w r() {
        if (f21613c == null) {
            synchronized (w.class) {
                f21613c = new w();
            }
        }
        return f21613c;
    }

    public void c(Context context, Bundle bundle) {
        String str;
        int i10;
        Context context2 = context;
        try {
            String string = bundle.getString("message");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                String j10 = i.j(jSONObject);
                if (TextUtils.isEmpty(j10)) {
                    a.a("MTNotificationBusiness", "notificationMessage's messageId is null, can't show this notification");
                    return;
                }
                String optString = jSONObject.optString("override_msg_id");
                if (TextUtils.isEmpty(optString)) {
                    i10 = i.k(j10);
                } else {
                    i10 = i.k(optString);
                }
                int optInt = jSONObject.optInt("n_builder_id");
                JSONObject optJSONObject = jSONObject.optJSONObject("m_content");
                if (optJSONObject == null) {
                    a.a("MTNotificationBusiness", "onMessage failed, can't parse content");
                    return;
                }
                String optString2 = optJSONObject.optString("n_title");
                String optString3 = optJSONObject.optString("n_content");
                Bundle b10 = i.b(optJSONObject.optJSONObject("n_extras"));
                String optString4 = optJSONObject.optString("n_small_icon");
                String optString5 = optJSONObject.optString("n_large_icon");
                int optInt2 = optJSONObject.optInt("n_alert_type", -1);
                int optInt3 = optJSONObject.optInt("n_priority");
                str = "MTNotificationBusiness";
                try {
                    String optString6 = optJSONObject.optString("n_category");
                    String str2 = "message";
                    int optInt4 = optJSONObject.optInt("n_style");
                    String optString7 = optJSONObject.optString("n_big_text");
                    String optString8 = optJSONObject.optString("n_big_pic_path");
                    String str3 = optString6;
                    String[] a10 = i.a(optJSONObject.optString("n_inbox"));
                    String optString9 = optJSONObject.optString("n_channel_id");
                    String optString10 = optJSONObject.optString("n_sound");
                    int optInt5 = optJSONObject.optInt("n_badge_add_num");
                    String optString11 = optJSONObject.optString("intent_uri");
                    NotificationMessage x10 = new NotificationMessage().K(j10).M(optString).N((byte) 0).L(i10).Q(optString4).J(optString5).T(optString2).D(optString3).A(optInt).F(b10).S(optInt4).z(optString7).G(a10).y(optString8).E(optInt2).P(optInt3).B(str3).R(optString10).C(optString9).I(optString11).x(optInt5);
                    Context context3 = context;
                    try {
                        k(context3, x10, bundle.getBoolean("message_limit", true));
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable(str2, x10);
                        h1.a.i(context3, AuthApiStatusCodes.AUTH_API_CLIENT_ERROR, bundle2);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    a.a(str, "onMessage failed " + th.getMessage());
                }
            }
        } catch (Throwable th3) {
            th = th3;
            str = "MTNotificationBusiness";
            a.a(str, "onMessage failed " + th.getMessage());
        }
    }

    public final Intent d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent parseUri = Intent.parseUri(str, 4);
        Intent intent = new Intent(parseUri);
        parseUri.addCategory("android.intent.category.BROWSABLE");
        parseUri.setComponent((ComponentName) null);
        parseUri.setSelector((Intent) null);
        return intent;
    }

    public void e(int i10) {
        ConcurrentHashMap concurrentHashMap = f21612b;
        if (concurrentHashMap == null) {
            a.a("MTNotificationBusiness", "there are no aurora notification");
        } else if (!concurrentHashMap.containsValue(Integer.valueOf(i10))) {
            a.a("MTNotificationBusiness", "there are no aurora notification " + i10);
        } else {
            Iterator it = f21612b.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((Integer) ((Map.Entry) it.next()).getValue()).intValue() == i10) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            a.a("MTNotificationBusiness", "after remove, current messageMap size " + f21612b.size());
        }
    }

    public final void f(Context context) {
        try {
            if (p1.a.p()) {
                a.a("MTNotificationBusiness", "pushSdkVersionName:" + z1.a.f24997a + ", isForeground, no need launch");
                return;
            }
            a.a("MTNotificationBusiness", "pushSdkVersionName:" + z1.a.f24997a + ", isBackground, need launch");
            String k10 = p1.a.k();
            if (!TextUtils.isEmpty(k10)) {
                l(context, k10);
            } else {
                s(context);
            }
        } catch (Throwable th) {
            a.h("MTNotificationBusiness", "launch failed " + th.getMessage());
        }
    }

    public final void g(Context context, byte b10, String str, Set set) {
        if (!TextUtils.isEmpty(str)) {
            if (set == null) {
                set = new LinkedHashSet();
            } else if (set.size() >= 50) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (set.size() >= 50) {
                        it.remove();
                    }
                }
            }
            set.add(str);
            a.a("MTNotificationBusiness", "addMessageId " + str);
            f0.e(context, b10, set);
        }
    }

    public final void h(Context context, int i10) {
        a.a("MTNotificationBusiness", "cancel notificationId:" + i10);
        ((NotificationManager) context.getSystemService("notification")).cancel(i10);
        e(i10);
    }

    public void i(Context context, int i10, Bundle bundle) {
        MTCommonReceiver f10;
        try {
            bundle.setClassLoader(NotificationMessage.class.getClassLoader());
            NotificationMessage notificationMessage = (NotificationMessage) bundle.getParcelable("message");
            if (notificationMessage != null && (f10 = p1.a.f(context)) != null) {
                switch (i10) {
                    case AuthApiStatusCodes.AUTH_API_CLIENT_ERROR:
                        f10.onNotificationArrived(context, notificationMessage);
                        h1.a.j(context, 3998, bundle);
                        return;
                    case AuthApiStatusCodes.AUTH_API_SERVER_ERROR:
                        a.h("MTNotificationBusiness", "on_notification_clicked");
                        String l10 = notificationMessage.l();
                        if (n1.a.a(context, l10, notificationMessage.k())) {
                            a.a("MTNotificationBusiness", "allow transfer to " + l10);
                            if (z1.a.f24997a.startsWith(ExifInterface.GPS_MEASUREMENT_3D)) {
                                if (notificationMessage.q() == 0) {
                                    f(context);
                                }
                                if (notificationMessage.q() == 8) {
                                    j(context, notificationMessage);
                                }
                            } else {
                                j(context, notificationMessage);
                            }
                        } else {
                            a.a("MTNotificationBusiness", "prevent transfer to " + l10);
                        }
                        f10.onNotificationClicked(context, notificationMessage);
                        h1.a.j(context, 3997, bundle);
                        return;
                    case AuthApiStatusCodes.AUTH_TOKEN_ERROR:
                        f10.onNotificationDeleted(context, notificationMessage);
                        h1.a.j(context, 3996, bundle);
                        return;
                    case AuthApiStatusCodes.AUTH_URL_RESOLUTION:
                        h1.a.j(context, 3995, bundle);
                        return;
                    default:
                        return;
                }
            }
        } catch (Throwable th) {
            a.h("MTNotificationBusiness", "processMainMessage failed " + th.getMessage());
        }
    }

    public final void j(Context context, NotificationMessage notificationMessage) {
        try {
            String l10 = notificationMessage.l();
            if (TextUtils.isEmpty(l10)) {
                a.a("MTNotificationBusiness", "pushSdkVersionName:" + z1.a.f24997a + ", there is no intentUri, no need transfer");
                f(context);
                return;
            }
            a.a("MTNotificationBusiness", "pushSdkVersionName:" + z1.a.f24997a + ", there is intentUri, need transfer");
            Intent d10 = d(l10);
            d10.addFlags(335544320);
            Bundle bundle = new Bundle();
            bundle.putString("message_json", b.c(notificationMessage));
            d10.putExtras(bundle);
            context.startActivity(d10);
        } catch (Throwable th) {
            a.h("MTNotificationBusiness", "transfer failed " + th.getMessage());
        }
    }

    public final void k(Context context, NotificationMessage notificationMessage, boolean z10) {
        Notification.Builder builder;
        int i10 = Build.VERSION.SDK_INT;
        a.a("MTNotificationBusiness", "showNotification " + notificationMessage.toString());
        byte q10 = notificationMessage.q();
        String n10 = notificationMessage.n();
        String p10 = notificationMessage.p();
        if (z10 && !p(context, q10, n10, p10)) {
            return;
        }
        if (!q.c().j(context)) {
            a.h("MTNotificationBusiness", "is not notificationShowTime, notificationShowTime:" + f0.v(context));
        } else if (TextUtils.isEmpty(notificationMessage.g())) {
            a.h("MTNotificationBusiness", "notificationMessage's content is null, can't show this notification " + notificationMessage.toString());
        } else {
            boolean l10 = q.c().l(context);
            if (i10 >= 26) {
                v.a();
                builder = u.a(context, g.a(context, l10, notificationMessage));
            } else {
                builder = new Notification.Builder(context);
            }
            builder.setAutoCancel(true);
            builder.setWhen(System.currentTimeMillis());
            String u10 = i.u(context, notificationMessage);
            builder.setContentTitle(u10);
            notificationMessage.T(u10);
            String e10 = i.e(context, notificationMessage);
            builder.setContentText(i.e(context, notificationMessage));
            notificationMessage.D(e10);
            int f10 = i.f(context, l10, notificationMessage);
            builder.setDefaults(f10);
            notificationMessage.E(f10);
            builder.setContentIntent(i.n(context, String.valueOf(AuthApiStatusCodes.AUTH_API_SERVER_ERROR), notificationMessage));
            builder.setDeleteIntent(i.n(context, String.valueOf(AuthApiStatusCodes.AUTH_TOKEN_ERROR), notificationMessage));
            int q11 = i.q(context);
            if (q11 > 0) {
                builder.setSmallIcon(q11);
            }
            Bitmap h10 = i.h(context, notificationMessage.m());
            if (h10 != null) {
                builder.setLargeIcon(h10);
            }
            Uri s10 = i.s(context, l10, notificationMessage);
            if (s10 != null) {
                builder.setSound(s10);
            }
            RemoteViews l11 = i.l(context, notificationMessage);
            if (l11 != null) {
                builder.setContent(l11);
            }
            builder.setPriority(i.p(context, l10, notificationMessage));
            builder.setStyle(i.t(context, notificationMessage));
            builder.setVisibility(i.v(context, l10, notificationMessage));
            if (!TextUtils.isEmpty(notificationMessage.e())) {
                builder.setCategory(notificationMessage.e());
            }
            Icon r10 = i.r(context, notificationMessage);
            if (r10 != null) {
                builder.setSmallIcon(r10);
            }
            builder.setShowWhen(true);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            int f11 = q.c().f(context);
            if (f21612b.size() >= f11) {
                Object[] array = f21612b.keySet().toArray();
                Arrays.sort(array);
                for (Object obj : array) {
                    Integer num = (Integer) f21612b.get(obj);
                    a.a("MTNotificationBusiness", "currentNotificationCount is " + f21612b.size() + ", limit notificationCount [" + f11 + "], need remove messageId[" + obj + "]:notificationId[" + num + "]");
                    notificationManager.cancel(num.intValue());
                    f21612b.remove(obj);
                    if (f21612b.size() < f11) {
                        break;
                    }
                }
            }
            f21612b.put(notificationMessage.n(), Integer.valueOf(notificationMessage.o()));
            a.a("MTNotificationBusiness", "after add, current messageMap size " + f21612b.size());
            Notification build = builder.build();
            i.y(context, build, notificationMessage.a());
            notificationManager.notify(notificationMessage.o(), build);
            a.a("MTNotificationBusiness", "showNotification notificationId:" + notificationMessage.o());
        }
    }

    public final void l(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), str);
            intent.setFlags(872415232);
            context.startActivity(intent);
        } catch (Throwable th) {
            a.h("MTNotificationBusiness", "launchCurrentActivity failed " + th.getMessage());
        }
    }

    public final void m(Context context, String str, byte b10, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msg_id", str);
            jSONObject.put("sdk_type", b10);
            jSONObject.put("tmsg_id", str2);
            jSONObject.put(DbParams.KEY_CHANNEL_RESULT, 1069);
            MTReporter c10 = new MTReporter().d("third_msg_status").c(jSONObject.toString());
            Bundle bundle = new Bundle();
            bundle.putParcelable("protocol", c10);
            h1.a.j(context, 2233, bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putString("json", jSONObject.toString());
            h1.a.i(context, 3202, bundle2);
        } catch (Throwable th) {
            a.h("MTNotificationBusiness", "reportRevokeMessage failed " + th.getMessage());
        }
    }

    public final void n(Context context, String str, String str2) {
        a.a("MTNotificationBusiness", "revokeNotification reportMessageId:" + str + ",revokeMessageId:" + str2);
        w(context, str2, f0.y(context));
        int k10 = i.k(str2);
        Set c10 = f0.c(context, (byte) 0);
        if (c10 == null || !c10.contains(str)) {
            a.a("MTNotificationBusiness", "there are no messageId [" + str + "] in cache messageIdSet");
            Set c11 = f0.c(context, (byte) 8);
            if (c11 == null || !c11.contains(str)) {
                a.a("MTNotificationBusiness", "there are no messageId [" + str + "] in cache googleMessageIdSet");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("revoke third message ");
                sb2.append(str);
                a.a("MTNotificationBusiness", sb2.toString());
                Bundle bundle = new Bundle();
                bundle.putInt("notification_id", k10);
                h1.a.i(context, 3104, bundle);
            } else if (!q(context, k10, true)) {
                a.a("MTNotificationBusiness", "the message [" + str2 + "] is not showing");
            } else {
                h(context, k10);
                m(context, str, (byte) 8, "");
            }
        } else if (!q(context, k10, true)) {
            a.a("MTNotificationBusiness", "the message [" + str2 + "] is not showing");
        } else {
            h(context, k10);
            v(context, str);
        }
    }

    public final void o(Context context, String str, Set set) {
        if (!TextUtils.isEmpty(str)) {
            if (set == null) {
                set = new LinkedHashSet();
            } else if (set.size() >= 50) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (set.size() >= 50) {
                        it.remove();
                    }
                }
            }
            set.add(str);
            a.a("MTNotificationBusiness", "addOverrideMessageId " + str);
            f0.i(context, set);
        }
    }

    public final boolean p(Context context, byte b10, String str, String str2) {
        Set c10 = f0.c(context, b10);
        if (c10 == null || c10.isEmpty() || TextUtils.isEmpty(str) || !c10.contains(str)) {
            Set x10 = f0.x(context);
            if (x10 == null || x10.isEmpty() || TextUtils.isEmpty(str) || !str2.contains(str)) {
                Set y10 = f0.y(context);
                if (y10 != null && !y10.isEmpty() && !TextUtils.isEmpty(str) && y10.contains(str)) {
                    a.a("MTNotificationBusiness", "the message [" + str + "] had been revoke");
                    v(context, str);
                    return false;
                } else if (c10 == null || c10.isEmpty() || TextUtils.isEmpty(str2) || !c10.contains(str2)) {
                    g(context, b10, str, c10);
                    o(context, str2, x10);
                    return true;
                } else {
                    a.a("MTNotificationBusiness", "the overrideMessage [" + str2 + "] had been show");
                    if (!q(context, i.k(str2), true)) {
                        return false;
                    }
                    a.a("MTNotificationBusiness", "the overrideMessage [" + str2 + "] is showing, need override");
                    g(context, b10, str, c10);
                    o(context, str2, x10);
                    return true;
                }
            } else {
                a.a("MTNotificationBusiness", "the message [" + str + "] had been override");
                return false;
            }
        } else {
            a.a("MTNotificationBusiness", "the message [" + str + "] had been show");
            return false;
        }
    }

    public final boolean q(Context context, int i10, boolean z10) {
        for (StatusBarNotification statusBarNotification : ((NotificationManager) context.getSystemService("notification")).getActiveNotifications()) {
            a.a("MTNotificationBusiness", "statusBarNotification:" + statusBarNotification.getId());
            if (statusBarNotification.getId() == i10) {
                return true;
            }
        }
        return false;
    }

    public final void s(Context context) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            launchIntentForPackage.setFlags(872415232);
            context.startActivity(launchIntentForPackage);
        } catch (Throwable th) {
            a.h("MTNotificationBusiness", "launchMainActivity failed " + th.getMessage());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void t(android.content.Context r7, int r8, android.os.Bundle r9) {
        /*
            r6 = this;
            java.lang.String r0 = "MTNotificationBusiness"
            java.lang.Class<com.engagelab.privates.push.api.NotificationMessage> r1 = com.engagelab.privates.push.api.NotificationMessage.class
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ all -> 0x0041 }
            r9.setClassLoader(r1)     // Catch:{ all -> 0x0041 }
            java.lang.String r1 = "message"
            android.os.Parcelable r9 = r9.getParcelable(r1)     // Catch:{ all -> 0x0041 }
            com.engagelab.privates.push.api.NotificationMessage r9 = (com.engagelab.privates.push.api.NotificationMessage) r9     // Catch:{ all -> 0x0041 }
            if (r9 != 0) goto L_0x0016
            return
        L_0x0016:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0041 }
            r1.<init>()     // Catch:{ all -> 0x0041 }
            java.lang.String r2 = "msg_id"
            java.lang.String r3 = r9.n()     // Catch:{ all -> 0x0041 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0041 }
            byte r2 = r9.q()     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0044
            java.lang.String r2 = "sdk_type"
            byte r3 = r9.q()     // Catch:{ all -> 0x0041 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0041 }
            java.lang.String r2 = "tmsg_id"
            java.lang.String r3 = r9.r()     // Catch:{ all -> 0x0041 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0041 }
            java.lang.String r2 = "third_msg_status"
            r3 = 3202(0xc82, float:4.487E-42)
            goto L_0x0048
        L_0x0041:
            r7 = move-exception
            goto L_0x00f8
        L_0x0044:
            java.lang.String r2 = "msg_status"
            r3 = 3201(0xc81, float:4.486E-42)
        L_0x0048:
            java.lang.String r4 = "result"
            switch(r8) {
                case 3995: goto L_0x00a9;
                case 3996: goto L_0x008b;
                case 3997: goto L_0x006d;
                case 3998: goto L_0x004f;
                default: goto L_0x004d;
            }
        L_0x004d:
            goto L_0x00c6
        L_0x004f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
            r8.<init>()     // Catch:{ all -> 0x0041 }
            java.lang.String r5 = "onNotificationArrived "
            r8.append(r5)     // Catch:{ all -> 0x0041 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0041 }
            r8.append(r9)     // Catch:{ all -> 0x0041 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0041 }
            s1.a.a(r0, r8)     // Catch:{ all -> 0x0041 }
            r8 = 1018(0x3fa, float:1.427E-42)
            r1.put(r4, r8)     // Catch:{ all -> 0x0041 }
            goto L_0x00c6
        L_0x006d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
            r8.<init>()     // Catch:{ all -> 0x0041 }
            java.lang.String r5 = "onNotificationClicked "
            r8.append(r5)     // Catch:{ all -> 0x0041 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0041 }
            r8.append(r9)     // Catch:{ all -> 0x0041 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0041 }
            s1.a.a(r0, r8)     // Catch:{ all -> 0x0041 }
            r8 = 1000(0x3e8, float:1.401E-42)
            r1.put(r4, r8)     // Catch:{ all -> 0x0041 }
            goto L_0x00c6
        L_0x008b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
            r8.<init>()     // Catch:{ all -> 0x0041 }
            java.lang.String r5 = "onNotificationDeleted "
            r8.append(r5)     // Catch:{ all -> 0x0041 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0041 }
            r8.append(r9)     // Catch:{ all -> 0x0041 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0041 }
            s1.a.a(r0, r8)     // Catch:{ all -> 0x0041 }
            r8 = 1038(0x40e, float:1.455E-42)
            r1.put(r4, r8)     // Catch:{ all -> 0x0041 }
            goto L_0x00c6
        L_0x00a9:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
            r8.<init>()     // Catch:{ all -> 0x0041 }
            java.lang.String r5 = "onNotificationOpened "
            r8.append(r5)     // Catch:{ all -> 0x0041 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0041 }
            r8.append(r9)     // Catch:{ all -> 0x0041 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0041 }
            s1.a.a(r0, r8)     // Catch:{ all -> 0x0041 }
            r8 = 1028(0x404, float:1.44E-42)
            r1.put(r4, r8)     // Catch:{ all -> 0x0041 }
        L_0x00c6:
            com.engagelab.privates.core.api.MTReporter r8 = new com.engagelab.privates.core.api.MTReporter     // Catch:{ all -> 0x0041 }
            r8.<init>()     // Catch:{ all -> 0x0041 }
            com.engagelab.privates.core.api.MTReporter r8 = r8.d(r2)     // Catch:{ all -> 0x0041 }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x0041 }
            com.engagelab.privates.core.api.MTReporter r8 = r8.c(r9)     // Catch:{ all -> 0x0041 }
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ all -> 0x0041 }
            r9.<init>()     // Catch:{ all -> 0x0041 }
            java.lang.String r2 = "protocol"
            r9.putParcelable(r2, r8)     // Catch:{ all -> 0x0041 }
            r8 = 2233(0x8b9, float:3.129E-42)
            h1.a.j(r7, r8, r9)     // Catch:{ all -> 0x0041 }
            android.os.Bundle r8 = new android.os.Bundle     // Catch:{ all -> 0x0041 }
            r8.<init>()     // Catch:{ all -> 0x0041 }
            java.lang.String r9 = "json"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0041 }
            r8.putString(r9, r1)     // Catch:{ all -> 0x0041 }
            h1.a.i(r7, r3, r8)     // Catch:{ all -> 0x0041 }
            goto L_0x0110
        L_0x00f8:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "processRemoteMessage failed "
            r8.append(r9)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            s1.a.h(r0, r7)
        L_0x0110:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.w.t(android.content.Context, int, android.os.Bundle):void");
    }

    public void u(Context context, Bundle bundle) {
        if (bundle != null) {
            h(context, bundle.getInt("notify_id"));
        } else if (!f21612b.isEmpty()) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            for (Map.Entry entry : f21612b.entrySet()) {
                notificationManager.cancel(((Integer) entry.getValue()).intValue());
                a.a("MTNotificationBusiness", "clear notification which messageId:" + ((String) entry.getKey()) + ", notificationId:" + entry.getValue());
            }
            f21612b.clear();
            a.a("MTNotificationBusiness", "current messageMap size " + f21612b.size());
        }
    }

    public final void v(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msg_id", str);
            jSONObject.put(DbParams.KEY_CHANNEL_RESULT, 1068);
            MTReporter c10 = new MTReporter().d("msg_status").c(jSONObject.toString());
            Bundle bundle = new Bundle();
            bundle.putParcelable("protocol", c10);
            h1.a.j(context, 2233, bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putString("json", jSONObject.toString());
            h1.a.i(context, 3201, bundle2);
        } catch (Throwable th) {
            a.h("MTNotificationBusiness", "reportRevokeMessage failed " + th.getMessage());
        }
    }

    public final void w(Context context, String str, Set set) {
        if (!TextUtils.isEmpty(str)) {
            if (set == null) {
                set = new LinkedHashSet();
            } else if (set.size() >= 50) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (set.size() >= 50) {
                        it.remove();
                    }
                }
            }
            set.add(str);
            a.a("MTNotificationBusiness", "addRevokeMessageId " + str);
            f0.o(context, set);
        }
    }

    public void x(Context context, Bundle bundle) {
        try {
            String string = bundle.getString("protocol");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                a.a("MTNotificationBusiness", "revokeMessage:" + a.g(jSONObject));
                String optString = jSONObject.optString("ids");
                if (!TextUtils.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    if (split.length == 1) {
                        String str = split[0];
                        n(context, str, str);
                    } else if (split.length == 2) {
                        n(context, split[0], split[1]);
                    }
                }
            }
        } catch (Throwable th) {
            a.h("MTNotificationBusiness", "revokeMessage failed " + th.getMessage());
        }
    }

    public void y(Context context, Bundle bundle) {
        try {
            bundle.setClassLoader(NotificationMessage.class.getClassLoader());
            NotificationMessage notificationMessage = (NotificationMessage) bundle.getParcelable("message");
            if (notificationMessage != null) {
                k(context, notificationMessage, bundle.getBoolean("message_limit", true));
            }
        } catch (Throwable th) {
            a.h("MTNotificationBusiness", "showNotification failed " + th.getMessage());
        }
    }
}
