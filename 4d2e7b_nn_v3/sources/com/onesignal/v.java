package com.onesignal;

import android.R;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.alibaba.pdns.model.DomainUhfReportModel;
import com.alibaba.pdns.s.e.c;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.onesignal.o3;
import com.zing.zalo.zalosdk.ZaloOAuthResultCode;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class v {

    /* renamed from: a  reason: collision with root package name */
    private static Class f11076a = NotificationOpenedReceiver.class;

    /* renamed from: b  reason: collision with root package name */
    private static Class f11077b = NotificationDismissReceiver.class;

    /* renamed from: c  reason: collision with root package name */
    private static Resources f11078c;

    /* renamed from: d  reason: collision with root package name */
    private static Context f11079d;

    /* renamed from: e  reason: collision with root package name */
    private static String f11080e;

    /* renamed from: f  reason: collision with root package name */
    private static Integer f11081f;

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        NotificationCompat.Builder f11082a;

        /* renamed from: b  reason: collision with root package name */
        boolean f11083b;

        private b() {
        }
    }

    private static int A(String str) {
        if (str == null) {
            return 0;
        }
        String trim = str.trim();
        if (!OSUtils.J(trim)) {
            return 0;
        }
        int w10 = w(trim);
        if (w10 != 0) {
            return w10;
        }
        try {
            return R.drawable.class.getField(str).getInt((Object) null);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static int B(JSONObject jSONObject) {
        int A = A(jSONObject.optString("sicon", (String) null));
        if (A != 0) {
            return A;
        }
        return v();
    }

    private static CharSequence C(JSONObject jSONObject) {
        String optString = jSONObject.optString("title", (String) null);
        if (optString != null) {
            return optString;
        }
        return p();
    }

    private static void D() {
        if (Build.VERSION.SDK_INT >= 24) {
            f11081f = 2;
        } else {
            f11081f = 1;
        }
    }

    static void E() {
        if (OSUtils.H()) {
            throw new f3("Process for showing a notification should never been done on Main Thread!");
        }
    }

    private static boolean F(JSONObject jSONObject) {
        String optString = jSONObject.optString("sound", (String) null);
        if ("null".equals(optString) || "nil".equals(optString)) {
            return false;
        }
        return true;
    }

    private static void G(NotificationCompat.Builder builder) {
        builder.setOnlyAlertOnce(true).setDefaults(0).setSound((Uri) null).setVibrate((long[]) null).setTicker((CharSequence) null);
    }

    private static Bitmap H(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int dimension = (int) f11078c.getDimension(17104902);
            int dimension2 = (int) f11078c.getDimension(17104901);
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            if (width <= dimension2 && height <= dimension) {
                return bitmap;
            }
            if (height > width) {
                dimension2 = (int) (((float) dimension) * (((float) width) / ((float) height)));
            } else if (width > height) {
                dimension = (int) (((float) dimension2) * (((float) height) / ((float) width)));
            }
            return Bitmap.createScaledBitmap(bitmap, dimension2, dimension, true);
        } catch (Throwable unused) {
            return bitmap;
        }
    }

    private static Integer I(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.has(str)) {
                return Integer.valueOf(new BigInteger(jSONObject.optString(str), 16).intValue());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void J(JSONObject jSONObject, NotificationCompat.Builder builder) {
        int e10 = e(jSONObject.optInt("pri", 6));
        builder.setPriority(e10);
        if (e10 >= 0) {
            int i10 = 4;
            if (jSONObject.has("ledc") && jSONObject.optInt("led", 1) == 1) {
                try {
                    builder.setLights(new BigInteger(jSONObject.optString("ledc"), 16).intValue(), CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, 5000);
                    i10 = 0;
                } catch (Throwable unused) {
                }
            }
            if (jSONObject.optInt("vib", 1) == 1) {
                if (jSONObject.has("vib_pt")) {
                    long[] Q = OSUtils.Q(jSONObject);
                    if (Q != null) {
                        builder.setVibrate(Q);
                    }
                } else {
                    i10 |= 2;
                }
            }
            if (F(jSONObject)) {
                Uri n10 = OSUtils.n(f11079d, jSONObject.optString("sound", (String) null));
                if (n10 != null) {
                    builder.setSound(n10);
                } else {
                    i10 |= 1;
                }
            }
            builder.setDefaults(i10);
        }
    }

    private static void K(Context context) {
        f11079d = context;
        f11080e = context.getPackageName();
        f11078c = f11079d.getResources();
    }

    private static void L(RemoteViews remoteViews, JSONObject jSONObject, int i10, String str, String str2) {
        Integer I = I(jSONObject, str);
        if (I != null) {
            remoteViews.setTextColor(i10, I.intValue());
            return;
        }
        int identifier = f11078c.getIdentifier(str2, "color", f11080e);
        if (identifier != 0) {
            remoteViews.setTextColor(i10, h.b(f11079d, identifier));
        }
    }

    private static boolean M(i2 i2Var) {
        int i10;
        Notification notification;
        int intValue = i2Var.a().intValue();
        JSONObject e10 = i2Var.e();
        String optString = e10.optString("grp", (String) null);
        e0 e0Var = new e0(f11079d);
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList = y3.c(f11079d);
            if (optString == null && arrayList.size() >= 3) {
                optString = y3.g();
                y3.b(f11079d, arrayList);
            }
        }
        b q10 = q(i2Var);
        NotificationCompat.Builder builder = q10.f11082a;
        b(e10, e0Var, builder, intValue, (String) null);
        try {
            a(e10, builder);
        } catch (Throwable th) {
            o3.b(o3.v.ERROR, "Could not set background notification image!", th);
        }
        d(i2Var, builder);
        if (i2Var.n()) {
            G(builder);
        }
        if (optString != null) {
            i10 = 2;
        } else {
            i10 = 1;
        }
        y0.a(f11079d, i10);
        if (optString != null) {
            g(builder, e0Var, e10, optString, intValue);
            notification = j(i2Var, builder);
            if (Build.VERSION.SDK_INT < 24 || !optString.equals(y3.g())) {
                l(i2Var, q10);
            } else {
                i(i2Var, e0Var, arrayList.size() + 1);
            }
        } else {
            notification = h(builder, e0Var, e10, intValue);
        }
        c(q10, notification);
        NotificationManagerCompat.from(f11079d).notify(intValue, notification);
        if (Build.VERSION.SDK_INT >= 26) {
            return y3.a(f11079d, notification.getChannelId());
        }
        return true;
    }

    static void N(i2 i2Var) {
        K(i2Var.d());
        l(i2Var, (b) null);
    }

    private static void a(JSONObject jSONObject, NotificationCompat.Builder builder) {
        JSONObject jSONObject2;
        Bitmap bitmap;
        String str;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            o3.a(o3.v.VERBOSE, "Cannot use background images in notifications for device on version: " + i10);
            return;
        }
        String optString = jSONObject.optString("bg_img", (String) null);
        if (optString != null) {
            jSONObject2 = new JSONObject(optString);
            bitmap = r(jSONObject2.optString("img", (String) null));
        } else {
            bitmap = null;
            jSONObject2 = null;
        }
        if (bitmap == null) {
            bitmap = s("onesignal_bgimage_default_image");
        }
        if (bitmap != null) {
            RemoteViews remoteViews = new RemoteViews(f11079d.getPackageName(), n4.f10821a);
            remoteViews.setTextViewText(m4.f10803e, C(jSONObject));
            remoteViews.setTextViewText(m4.f10802d, jSONObject.optString("alert"));
            L(remoteViews, jSONObject2, m4.f10803e, DomainUhfReportModel.OTHER_TIMEOUT, "onesignal_bgimage_notif_title_color");
            L(remoteViews, jSONObject2, m4.f10802d, "bc", "onesignal_bgimage_notif_body_color");
            if (jSONObject2 == null || !jSONObject2.has("img_align")) {
                int identifier = f11078c.getIdentifier("onesignal_bgimage_notif_image_align", "string", f11080e);
                if (identifier != 0) {
                    str = f11078c.getString(identifier);
                } else {
                    str = null;
                }
            } else {
                str = jSONObject2.getString("img_align");
            }
            if ("right".equals(str)) {
                remoteViews.setViewPadding(m4.f10800b, ZaloOAuthResultCode.ERR_APP_ID_IS_INVALID, 0, 0, 0);
                remoteViews.setImageViewBitmap(m4.f10801c, bitmap);
                remoteViews.setViewVisibility(m4.f10801c, 0);
                remoteViews.setViewVisibility(m4.f10799a, 2);
            } else {
                remoteViews.setImageViewBitmap(m4.f10799a, bitmap);
            }
            builder.setContent(remoteViews);
            builder.setStyle((NotificationCompat.Style) null);
        }
    }

    private static void b(JSONObject jSONObject, e0 e0Var, NotificationCompat.Builder builder, int i10, String str) {
        int i11;
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("custom"));
            if (jSONObject2.has("a")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("a");
                if (jSONObject3.has("actionButtons")) {
                    JSONArray jSONArray = jSONObject3.getJSONArray("actionButtons");
                    for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i12);
                        JSONObject jSONObject4 = new JSONObject(jSONObject.toString());
                        Intent b10 = e0Var.b(i10);
                        b10.setAction("" + i12);
                        b10.putExtra("action_button", true);
                        jSONObject4.put("actionId", optJSONObject.optString("id"));
                        b10.putExtra("onesignalData", jSONObject4.toString());
                        if (str != null) {
                            b10.putExtra("summary", str);
                        } else if (jSONObject.has("grp")) {
                            b10.putExtra("grp", jSONObject.optString("grp"));
                        }
                        PendingIntent a10 = e0Var.a(i10, b10);
                        if (optJSONObject.has("icon")) {
                            i11 = A(optJSONObject.optString("icon"));
                        } else {
                            i11 = 0;
                        }
                        builder.addAction(i11, optJSONObject.optString("text"), a10);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void c(b bVar, Notification notification) {
        if (bVar.f11083b) {
            try {
                Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
                Field declaredField = newInstance.getClass().getDeclaredField("customizedIcon");
                declaredField.setAccessible(true);
                declaredField.set(newInstance, Boolean.TRUE);
                Field field = notification.getClass().getField("extraNotification");
                field.setAccessible(true);
                field.set(notification, newInstance);
            } catch (Throwable unused) {
            }
        }
    }

    private static void d(i2 i2Var, NotificationCompat.Builder builder) {
        Class<NotificationCompat.Builder> cls = NotificationCompat.Builder.class;
        if (i2Var.l()) {
            try {
                Field declaredField = cls.getDeclaredField("mNotification");
                declaredField.setAccessible(true);
                Notification notification = (Notification) declaredField.get(builder);
                i2Var.s(Integer.valueOf(notification.flags));
                i2Var.t(notification.sound);
                builder.extend(i2Var.f().f());
                Notification notification2 = (Notification) declaredField.get(builder);
                Field declaredField2 = cls.getDeclaredField("mContentText");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentTitle");
                declaredField3.setAccessible(true);
                i2Var.u((CharSequence) declaredField2.get(builder));
                i2Var.x((CharSequence) declaredField3.get(builder));
                if (!i2Var.n()) {
                    i2Var.v(Integer.valueOf(notification2.flags));
                    i2Var.w(notification2.sound);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static int e(int i10) {
        if (i10 > 9) {
            return 2;
        }
        if (i10 > 7) {
            return 1;
        }
        if (i10 > 4) {
            return 0;
        }
        return i10 > 2 ? -1 : -2;
    }

    private static Intent f(int i10, e0 e0Var, JSONObject jSONObject, String str) {
        return e0Var.b(i10).putExtra("onesignalData", jSONObject.toString()).putExtra("summary", str);
    }

    private static void g(NotificationCompat.Builder builder, e0 e0Var, JSONObject jSONObject, String str, int i10) {
        SecureRandom secureRandom = new SecureRandom();
        builder.setContentIntent(e0Var.a(secureRandom.nextInt(), e0Var.b(i10).putExtra("onesignalData", jSONObject.toString()).putExtra("grp", str)));
        builder.setDeleteIntent(z(secureRandom.nextInt(), y(i10).putExtra("grp", str)));
        builder.setGroup(str);
        try {
            builder.setGroupAlertBehavior(f11081f.intValue());
        } catch (Throwable unused) {
        }
    }

    private static Notification h(NotificationCompat.Builder builder, e0 e0Var, JSONObject jSONObject, int i10) {
        SecureRandom secureRandom = new SecureRandom();
        builder.setContentIntent(e0Var.a(secureRandom.nextInt(), e0Var.b(i10).putExtra("onesignalData", jSONObject.toString())));
        builder.setDeleteIntent(z(secureRandom.nextInt(), y(i10)));
        return builder.build();
    }

    private static void i(i2 i2Var, e0 e0Var, int i10) {
        JSONObject e10 = i2Var.e();
        SecureRandom secureRandom = new SecureRandom();
        String g10 = y3.g();
        String str = i10 + " new messages";
        int f10 = y3.f();
        k(v3.n(f11079d), g10, f10);
        PendingIntent a10 = e0Var.a(secureRandom.nextInt(), f(f10, e0Var, e10, g10));
        PendingIntent z10 = z(secureRandom.nextInt(), y(0).putExtra("summary", g10));
        NotificationCompat.Builder builder = q(i2Var).f11082a;
        if (i2Var.i() != null) {
            builder.setSound(i2Var.i());
        }
        if (i2Var.h() != null) {
            builder.setDefaults(i2Var.h().intValue());
        }
        builder.setContentIntent(a10).setDeleteIntent(z10).setContentTitle(p()).setContentText(str).setNumber(i10).setSmallIcon(v()).setLargeIcon(u()).setOnlyAlertOnce(true).setAutoCancel(false).setGroup(g10).setGroupSummary(true);
        try {
            builder.setGroupAlertBehavior(f11081f.intValue());
        } catch (Throwable unused) {
        }
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle(str);
        builder.setStyle(inboxStyle);
        NotificationManagerCompat.from(f11079d).notify(f10, builder.build());
    }

    private static Notification j(i2 i2Var, NotificationCompat.Builder builder) {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 24 || i2Var.n()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10 && i2Var.i() != null && !i2Var.i().equals(i2Var.g())) {
            builder.setSound((Uri) null);
        }
        Notification build = builder.build();
        if (z10) {
            builder.setSound(i2Var.i());
        }
        return build;
    }

    private static void k(v3 v3Var, String str, int i10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("android_notification_id", Integer.valueOf(i10));
        contentValues.put(FirebaseAnalytics.Param.GROUP_ID, str);
        contentValues.put("is_summary", 1);
        v3Var.w("notification", (String) null, contentValues);
    }

    private static void l(i2 i2Var, b bVar) {
        String str;
        String str2;
        Integer num;
        ArrayList<SpannableString> arrayList;
        JSONObject jSONObject;
        Notification notification;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        b bVar2 = bVar;
        String str9 = "message";
        String str10 = "title";
        String str11 = "is_summary";
        boolean n10 = i2Var.n();
        JSONObject e10 = i2Var.e();
        e0 e0Var = new e0(f11079d);
        Cursor cursor = null;
        String optString = e10.optString("grp", (String) null);
        SecureRandom secureRandom = new SecureRandom();
        PendingIntent z10 = z(secureRandom.nextInt(), y(0).putExtra("summary", optString));
        v3 n11 = v3.n(f11079d);
        try {
            String[] strArr = {"android_notification_id", "full_data", str11, str10, str9};
            String[] strArr2 = {optString};
            if (!n10) {
                try {
                    str = "group_id = ? AND dismissed = 0 AND opened = 0" + " AND android_notification_id <> " + i2Var.a();
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                    cursor.close();
                    throw th;
                }
            } else {
                str = "group_id = ? AND dismissed = 0 AND opened = 0";
            }
            try {
                cursor = n11.h("notification", strArr, str, strArr2, (String) null, (String) null, "_id DESC");
                if (!cursor.isClosed()) {
                    cursor.close();
                }
                if (num == null) {
                    int nextInt = secureRandom.nextInt();
                    num = Integer.valueOf(nextInt);
                    k(n11, optString, nextInt);
                }
                PendingIntent a10 = e0Var.a(secureRandom.nextInt(), f(num.intValue(), e0Var, jSONObject, optString));
                if (arrayList == null || ((!n10 || arrayList.size() <= 1) && (n10 || arrayList.size() <= 0))) {
                    b bVar3 = bVar;
                    NotificationCompat.Builder builder = bVar3.f11082a;
                    builder.mActions.clear();
                    b(jSONObject, e0Var, builder, num.intValue(), optString);
                    builder.setContentIntent(a10).setDeleteIntent(z10).setOnlyAlertOnce(n10).setAutoCancel(false).setGroup(optString).setGroupSummary(true);
                    try {
                        builder.setGroupAlertBehavior(f11081f.intValue());
                    } catch (Throwable unused) {
                    }
                    notification = builder.build();
                    c(bVar3, notification);
                } else {
                    int size = arrayList.size() + (n10 ^ true ? 1 : 0);
                    String optString2 = jSONObject.optString("grp_msg", (String) null);
                    if (optString2 == null) {
                        str3 = size + " new messages";
                    } else {
                        str3 = optString2.replace("$[notif_count]", str2 + size);
                    }
                    NotificationCompat.Builder builder2 = q(i2Var).f11082a;
                    if (n10) {
                        G(builder2);
                    } else {
                        if (i2Var.i() != null) {
                            builder2.setSound(i2Var.i());
                        }
                        if (i2Var.h() != null) {
                            builder2.setDefaults(i2Var.h().intValue());
                        }
                    }
                    builder2.setContentIntent(a10).setDeleteIntent(z10).setContentTitle(p()).setContentText(str3).setNumber(size).setSmallIcon(v()).setLargeIcon(u()).setOnlyAlertOnce(n10).setAutoCancel(false).setGroup(optString).setGroupSummary(true);
                    try {
                        builder2.setGroupAlertBehavior(f11081f.intValue());
                    } catch (Throwable unused2) {
                    }
                    if (!n10) {
                        builder2.setTicker(str3);
                    }
                    NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                    if (!n10) {
                        if (i2Var.k() != null) {
                            str4 = i2Var.k().toString();
                        } else {
                            str4 = null;
                        }
                        if (str4 != null) {
                            str2 = str4 + " ";
                        }
                        SpannableString spannableString = new SpannableString(str2 + i2Var.c().toString());
                        if (str2.length() > 0) {
                            spannableString.setSpan(new StyleSpan(1), 0, str2.length(), 0);
                        }
                        inboxStyle.addLine(spannableString);
                    }
                    for (SpannableString addLine : arrayList) {
                        inboxStyle.addLine(addLine);
                    }
                    inboxStyle.setBigContentTitle(str3);
                    builder2.setStyle(inboxStyle);
                    notification = builder2.build();
                }
                NotificationManagerCompat.from(f11079d).notify(num.intValue(), notification);
                return;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                cursor.close();
                throw th;
            }
            try {
                JSONObject jSONObject2 = e10;
                str2 = "";
                if (cursor.moveToFirst()) {
                    arrayList = new ArrayList<>();
                    String str12 = null;
                    num = null;
                    while (true) {
                        String str13 = str11;
                        if (cursor.getInt(cursor.getColumnIndex(str11)) == 1) {
                            num = Integer.valueOf(cursor.getInt(cursor.getColumnIndex("android_notification_id")));
                            str6 = str9;
                            str7 = str10;
                        } else {
                            String string = cursor.getString(cursor.getColumnIndex(str10));
                            if (string == null) {
                                str5 = str2;
                            } else {
                                str5 = string + " ";
                            }
                            str6 = str9;
                            str7 = str10;
                            SpannableString spannableString2 = new SpannableString(str5 + cursor.getString(cursor.getColumnIndex(str9)));
                            if (str5.length() > 0) {
                                spannableString2.setSpan(new StyleSpan(1), 0, str5.length(), 0);
                            }
                            arrayList.add(spannableString2);
                            if (str12 == null) {
                                str12 = cursor.getString(cursor.getColumnIndex("full_data"));
                            }
                        }
                        str8 = str12;
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        str12 = str8;
                        str11 = str13;
                        str9 = str6;
                        str10 = str7;
                    }
                    if (n10 && str8 != null) {
                        jSONObject = new JSONObject(str8);
                    }
                    jSONObject = jSONObject2;
                } else {
                    jSONObject = jSONObject2;
                    arrayList = null;
                    num = null;
                }
            } catch (JSONException e11) {
                e11.printStackTrace();
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            cursor.close();
            throw th;
        }
    }

    static boolean m(i2 i2Var) {
        K(i2Var.d());
        return M(i2Var);
    }

    static boolean n(i2 i2Var) {
        K(i2Var.d());
        E();
        D();
        return M(i2Var);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|(2:4|5)|6|7|(2:9|10)|11|12|(2:14|15)|16) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0025 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f A[Catch:{ all -> 0x0025 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.math.BigInteger o(org.json.JSONObject r4) {
        /*
            java.lang.String r0 = "bgac"
            r1 = 16
            r2 = 0
            boolean r3 = r4.has(r0)     // Catch:{ all -> 0x0015 }
            if (r3 == 0) goto L_0x0015
            java.math.BigInteger r3 = new java.math.BigInteger     // Catch:{ all -> 0x0015 }
            java.lang.String r4 = r4.optString(r0, r2)     // Catch:{ all -> 0x0015 }
            r3.<init>(r4, r1)     // Catch:{ all -> 0x0015 }
            return r3
        L_0x0015:
            android.content.Context r4 = com.onesignal.o3.f10882b     // Catch:{ all -> 0x0025 }
            java.lang.String r0 = "onesignal_notification_accent_color"
            java.lang.String r4 = com.onesignal.OSUtils.k(r4, r0, r2)     // Catch:{ all -> 0x0025 }
            if (r4 == 0) goto L_0x0025
            java.math.BigInteger r0 = new java.math.BigInteger     // Catch:{ all -> 0x0025 }
            r0.<init>(r4, r1)     // Catch:{ all -> 0x0025 }
            return r0
        L_0x0025:
            android.content.Context r4 = com.onesignal.o3.f10882b     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "com.onesignal.NotificationAccentColor.DEFAULT"
            java.lang.String r4 = com.onesignal.OSUtils.f(r4, r0)     // Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x0035
            java.math.BigInteger r0 = new java.math.BigInteger     // Catch:{ all -> 0x0035 }
            r0.<init>(r4, r1)     // Catch:{ all -> 0x0035 }
            return r0
        L_0x0035:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.v.o(org.json.JSONObject):java.math.BigInteger");
    }

    private static CharSequence p() {
        ApplicationInfo a10 = j.f10703a.a(f11079d);
        if (a10 == null) {
            return "";
        }
        return f11079d.getPackageManager().getApplicationLabel(a10);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|5|(1:9)|10|11|(1:13)|14|15|(1:17)(1:18)|19|20|(1:23)|24|(1:26)|27|(2:29|30)|31|33) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x006e */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0074 A[Catch:{ all -> 0x0081 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007d A[Catch:{ all -> 0x0081 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ae A[SYNTHETIC, Splitter:B:29:0x00ae] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.onesignal.v.b q(com.onesignal.i2 r9) {
        /*
            java.lang.String r0 = "vis"
            org.json.JSONObject r1 = r9.e()
            com.onesignal.v$b r2 = new com.onesignal.v$b
            r3 = 0
            r2.<init>()
            java.lang.String r4 = com.onesignal.x0.c(r9)     // Catch:{ all -> 0x0018 }
            androidx.core.app.NotificationCompat$Builder r5 = new androidx.core.app.NotificationCompat$Builder     // Catch:{ all -> 0x0018 }
            android.content.Context r6 = f11079d     // Catch:{ all -> 0x0018 }
            r5.<init>((android.content.Context) r6, (java.lang.String) r4)     // Catch:{ all -> 0x0018 }
            goto L_0x001f
        L_0x0018:
            androidx.core.app.NotificationCompat$Builder r5 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r4 = f11079d
            r5.<init>(r4)
        L_0x001f:
            java.lang.String r4 = "alert"
            java.lang.String r4 = r1.optString(r4, r3)
            r6 = 1
            androidx.core.app.NotificationCompat$Builder r7 = r5.setAutoCancel(r6)
            int r8 = B(r1)
            androidx.core.app.NotificationCompat$Builder r7 = r7.setSmallIcon((int) r8)
            androidx.core.app.NotificationCompat$BigTextStyle r8 = new androidx.core.app.NotificationCompat$BigTextStyle
            r8.<init>()
            androidx.core.app.NotificationCompat$BigTextStyle r8 = r8.bigText(r4)
            androidx.core.app.NotificationCompat$Builder r7 = r7.setStyle(r8)
            androidx.core.app.NotificationCompat$Builder r7 = r7.setContentText(r4)
            r7.setTicker(r4)
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 24
            if (r7 < r8) goto L_0x005a
            java.lang.String r7 = "title"
            java.lang.String r7 = r1.optString(r7)
            java.lang.String r8 = ""
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0061
        L_0x005a:
            java.lang.CharSequence r7 = C(r1)
            r5.setContentTitle(r7)
        L_0x0061:
            java.math.BigInteger r7 = o(r1)     // Catch:{ all -> 0x006e }
            if (r7 == 0) goto L_0x006e
            int r7 = r7.intValue()     // Catch:{ all -> 0x006e }
            r5.setColor(r7)     // Catch:{ all -> 0x006e }
        L_0x006e:
            boolean r7 = r1.has(r0)     // Catch:{ all -> 0x0081 }
            if (r7 == 0) goto L_0x007d
            java.lang.String r0 = r1.optString(r0)     // Catch:{ all -> 0x0081 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0081 }
            goto L_0x007e
        L_0x007d:
            r0 = r6
        L_0x007e:
            r5.setVisibility(r0)     // Catch:{ all -> 0x0081 }
        L_0x0081:
            android.graphics.Bitmap r0 = x(r1)
            if (r0 == 0) goto L_0x008c
            r2.f11083b = r6
            r5.setLargeIcon((android.graphics.Bitmap) r0)
        L_0x008c:
            java.lang.String r0 = "bicon"
            java.lang.String r0 = r1.optString(r0, r3)
            android.graphics.Bitmap r0 = r(r0)
            if (r0 == 0) goto L_0x00a8
            androidx.core.app.NotificationCompat$BigPictureStyle r3 = new androidx.core.app.NotificationCompat$BigPictureStyle
            r3.<init>()
            androidx.core.app.NotificationCompat$BigPictureStyle r0 = r3.bigPicture((android.graphics.Bitmap) r0)
            androidx.core.app.NotificationCompat$BigPictureStyle r0 = r0.setSummaryText(r4)
            r5.setStyle(r0)
        L_0x00a8:
            java.lang.Long r0 = r9.j()
            if (r0 == 0) goto L_0x00bc
            java.lang.Long r9 = r9.j()     // Catch:{ all -> 0x00bc }
            long r3 = r9.longValue()     // Catch:{ all -> 0x00bc }
            r6 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r6
            r5.setWhen(r3)     // Catch:{ all -> 0x00bc }
        L_0x00bc:
            J(r1, r5)
            r2.f11082a = r5
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.v.q(com.onesignal.i2):com.onesignal.v$b");
    }

    private static Bitmap r(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith(c.f18246k) || trim.startsWith(c.f18247l)) {
            return t(trim);
        }
        return s(str);
    }

    private static Bitmap s(String str) {
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeStream(f11079d.getAssets().open(str));
        } catch (Throwable unused) {
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        try {
            for (String str2 : Arrays.asList(new String[]{".png", ".webp", ".jpg", ".gif", ".bmp"})) {
                try {
                    bitmap = BitmapFactory.decodeStream(f11079d.getAssets().open(str + str2));
                    continue;
                } catch (Throwable unused2) {
                }
                if (bitmap != null) {
                    return bitmap;
                }
            }
            int A = A(str);
            if (A != 0) {
                return BitmapFactory.decodeResource(f11078c, A);
            }
        } catch (Throwable unused3) {
        }
        return null;
    }

    private static Bitmap t(String str) {
        try {
            return BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        } catch (Throwable th) {
            o3.b(o3.v.WARN, "Could not download image!", th);
            return null;
        }
    }

    private static Bitmap u() {
        return H(s("ic_onesignal_large_icon_default"));
    }

    private static int v() {
        int w10 = w("ic_stat_onesignal_default");
        if (w10 != 0) {
            return w10;
        }
        int w11 = w("corona_statusbar_icon_default");
        if (w11 != 0) {
            return w11;
        }
        int w12 = w("ic_os_notification_fallback_white_24dp");
        if (w12 != 0) {
            return w12;
        }
        return 17301598;
    }

    private static int w(String str) {
        return f11078c.getIdentifier(str, "drawable", f11080e);
    }

    private static Bitmap x(JSONObject jSONObject) {
        Bitmap r10 = r(jSONObject.optString("licon"));
        if (r10 == null) {
            r10 = s("ic_onesignal_large_icon_default");
        }
        if (r10 == null) {
            return null;
        }
        return H(r10);
    }

    private static Intent y(int i10) {
        return new Intent(f11079d, f11077b).putExtra("androidNotificationId", i10).putExtra("dismissed", true);
    }

    private static PendingIntent z(int i10, Intent intent) {
        return PendingIntent.getBroadcast(f11079d, i10, intent, 201326592);
    }
}
