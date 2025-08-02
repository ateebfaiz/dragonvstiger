package d2;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import android.widget.RemoteViews;
import com.adjust.sdk.Constants;
import com.engagelab.privates.common.component.MTCommonActivity;
import com.engagelab.privates.push.api.NotificationLayout;
import com.engagelab.privates.push.api.NotificationMessage;
import g1.f0;
import g1.q;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.json.JSONObject;
import s1.a;

public abstract class i {
    public static String[] a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            String[] strArr = new String[jSONObject.length()];
            int i10 = 0;
            while (keys.hasNext()) {
                strArr[i10] = jSONObject.optString(keys.next());
                i10++;
            }
            return strArr;
        } catch (Throwable th) {
            a.h("NotificationUtil", "convertJsonToArray failed " + th.getMessage());
            return null;
        }
    }

    public static Bundle b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(jSONObject.toString())) {
                return null;
            }
            Bundle bundle = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.optString(next));
            }
            return bundle;
        } catch (Throwable th) {
            a.h("NotificationUtil", "convertJsonToBundle failed " + th.getMessage());
            return null;
        }
    }

    public static Notification.BigPictureStyle c(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
            Bitmap o10 = o(context, str);
            if (o10 == null) {
                return null;
            }
            return bigPictureStyle.bigPicture(o10);
        } catch (Throwable th) {
            a.h("NotificationUtil", "get bigPictureStyle failed " + th.getMessage());
            return null;
        }
    }

    public static Notification.BigTextStyle d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new Notification.BigTextStyle().bigText(str);
    }

    public static String e(Context context, NotificationMessage notificationMessage) {
        if (TextUtils.isEmpty(notificationMessage.g())) {
            return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        }
        return notificationMessage.g();
    }

    public static int f(Context context, boolean z10, NotificationMessage notificationMessage) {
        if (!z10) {
            switch (notificationMessage.h()) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    return notificationMessage.h();
                default:
                    return -1;
            }
        } else if ((notificationMessage.h() & 1) == 0) {
            return notificationMessage.h();
        } else {
            return notificationMessage.h() - 1;
        }
    }

    public static Notification.InboxStyle g(Context context, String[] strArr) {
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
                    for (String addLine : strArr) {
                        inboxStyle.addLine(addLine);
                    }
                    inboxStyle.setSummaryText(" + " + strArr.length + " new messages");
                    return inboxStyle;
                }
            } catch (Throwable th) {
                a.h("NotificationUtil", "getInboxStyle failed " + th.getMessage());
            }
        }
        return null;
    }

    public static Bitmap h(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return o(context, str);
    }

    private static String i(Context context) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage != null && launchIntentForPackage.getComponent() != null) {
                return launchIntentForPackage.getComponent().getClassName();
            }
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setPackage(context.getPackageName());
            intent.addCategory("android.intent.category.LAUNCHER");
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (resolveActivity == null) {
                resolveActivity = packageManager.resolveActivity(launchIntentForPackage, 0);
            }
            if (resolveActivity != null) {
                return resolveActivity.activityInfo.name;
            }
            return "";
        } catch (Throwable th) {
            a.h("NotificationUtil", "getLaunchActivityClassName failed " + th.getMessage());
            return "";
        }
    }

    public static String j(JSONObject jSONObject) {
        String optString = jSONObject.optString("ad_id");
        if (TextUtils.isEmpty(optString)) {
            optString = jSONObject.optString("msg_id");
        }
        if (TextUtils.isEmpty(optString)) {
            return jSONObject.optString("_jmsgid_");
        }
        return optString;
    }

    public static int k(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable th) {
            a.h("NotificationUtil", "getNotificationId failed " + th.getMessage());
            return 0;
        }
    }

    public static RemoteViews l(Context context, NotificationMessage notificationMessage) {
        try {
            NotificationLayout b10 = q.c().b(context, notificationMessage.d());
            if (b10 == null) {
                a.a("NotificationUtil", "getNotificationLayout builderId:" + notificationMessage.d() + ", notificationLayout is null");
                return null;
            }
            a.a("NotificationUtil", "getNotificationLayout builderId:" + notificationMessage.d() + ", notificationLayout:" + b10.toString());
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), b10.d());
            if (b10.c() > 0) {
                remoteViews.setImageViewResource(b10.c(), q(context));
                Icon r10 = r(context, notificationMessage);
                if (r10 != null) {
                    remoteViews.setImageViewIcon(b10.c(), r10);
                }
            }
            if (b10.f() > 0) {
                remoteViews.setTextViewText(b10.f(), u(context, notificationMessage));
            }
            if (b10.a() > 0) {
                remoteViews.setTextViewText(b10.a(), e(context, notificationMessage));
            }
            if (b10.e() > 0) {
                remoteViews.setLong(b10.e(), "setTime", System.currentTimeMillis());
            }
            return remoteViews;
        } catch (Throwable th) {
            a.h("NotificationUtil", "getNotificationLayout failed " + th.getMessage());
            return null;
        }
    }

    public static boolean m(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager == null) {
                    return false;
                }
                return notificationManager.areNotificationsEnabled();
            } catch (Throwable th) {
                a.h("NotificationUtil", "getNotificationState failed " + th.getMessage());
            }
        }
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i10 = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", new Class[]{cls2, cls2, String.class});
            Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
            num.intValue();
            if (((Integer) method.invoke(appOpsManager, new Object[]{num, Integer.valueOf(i10), packageName})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            a.h("NotificationUtil", "getNotificationState failed " + th2.getMessage());
            return false;
        }
    }

    public static PendingIntent n(Context context, String str, NotificationMessage notificationMessage) {
        Intent intent = new Intent();
        intent.setClass(context, MTCommonActivity.class);
        intent.setAction(str);
        intent.addFlags(276824064);
        Bundle bundle = new Bundle();
        bundle.putParcelable("message", notificationMessage);
        intent.putExtras(bundle);
        return PendingIntent.getActivity(context, notificationMessage.o(), intent, 67108864);
    }

    public static Bitmap o(Context context, String str) {
        try {
            if (!Patterns.WEB_URL.matcher(str).matches()) {
                if (!URLUtil.isValidUrl(str)) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier(str, "drawable", context.getPackageName()));
                    Runtime.getRuntime().gc();
                    return decodeResource;
                }
            }
            byte[] a10 = new a().a(context, str);
            if (a10 == null) {
                a.a("NotificationUtil", "getPicture bytes is null");
                return null;
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(a10, 0, a10.length);
            Runtime.getRuntime().gc();
            return decodeByteArray;
        } catch (Throwable th) {
            a.h("NotificationUtil", "get pictureBitmap failed " + th.getMessage());
            return null;
        } finally {
            Runtime.getRuntime().gc();
        }
    }

    public static int p(Context context, boolean z10, NotificationMessage notificationMessage) {
        if (z10) {
            return -1;
        }
        int s10 = notificationMessage.s();
        if (s10 == -2 || s10 == -1 || s10 == 0 || s10 == 1 || s10 == 2) {
            return notificationMessage.s();
        }
        return 0;
    }

    public static int q(Context context) {
        int identifier = context.getResources().getIdentifier("mtpush_notification_icon", "drawable", context.getPackageName());
        if (identifier > 0) {
            return identifier;
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).icon;
        } catch (Throwable th) {
            a.h("NotificationUtil", "get getSmallIcon failed " + th.getMessage());
            a.b("NotificationUtil", "please put icon [mtpush_notification_icon] in res/drawable");
            return 0;
        }
    }

    public static Icon r(Context context, NotificationMessage notificationMessage) {
        Bitmap o10;
        try {
            if (!TextUtils.isEmpty(notificationMessage.t()) && (o10 = o(context, notificationMessage.t())) != null) {
                return Icon.createWithBitmap(o10);
            }
            return null;
        } catch (Throwable th) {
            a.h("NotificationUtil", "getSmallIcon failed " + th.getMessage());
            return null;
        }
    }

    public static Uri s(Context context, boolean z10, NotificationMessage notificationMessage) {
        if (z10) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(notificationMessage.u())) {
                return null;
            }
            if (context.getResources().getIdentifier(notificationMessage.u(), "raw", context.getPackageName()) == 0) {
                a.a("NotificationUtil", "there are no sound resource");
                return null;
            }
            return Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + notificationMessage.u());
        } catch (Throwable th) {
            a.h("NotificationUtil", "getSoundUri failed " + th.getMessage());
            return null;
        }
    }

    public static Notification.Style t(Context context, NotificationMessage notificationMessage) {
        int v10 = notificationMessage.v();
        if (v10 == 1) {
            return d(context, notificationMessage.c());
        }
        if (v10 == 2) {
            return g(context, notificationMessage.j());
        }
        if (v10 != 3) {
            return null;
        }
        return c(context, notificationMessage.b());
    }

    public static String u(Context context, NotificationMessage notificationMessage) {
        if (TextUtils.isEmpty(notificationMessage.w())) {
            return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        }
        return notificationMessage.w();
    }

    public static int v(Context context, boolean z10, NotificationMessage notificationMessage) {
        int s10;
        if (z10 || (s10 = notificationMessage.s()) == -2 || s10 == -1) {
            return -1;
        }
        if (s10 == 1 || s10 == 2) {
            return 1;
        }
        return 0;
    }

    public static boolean w(Context context, int i10) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Uri parse = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
            if (TextUtils.isEmpty(contentResolver.getType(parse))) {
                parse = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                if (TextUtils.isEmpty(contentResolver.getType(parse))) {
                    a.b("NotificationUtil", " setHonorBadge fail, uri is null");
                    return false;
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());
            bundle.putString("class", i(context));
            bundle.putInt("badgenumber", i10);
            contentResolver.call(parse, "change_badge", (String) null, bundle);
            return true;
        } catch (Throwable th) {
            a.b("NotificationUtil", " setHonorBadge wrong error:" + th);
            return false;
        }
    }

    public static void x(Context context, int i10) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());
            String i11 = i(context);
            if (!TextUtils.isEmpty(i11)) {
                a.a("NotificationUtil", "setHuaweiBadgeNumber " + i10);
                bundle.putString("class", i11);
                bundle.putInt("badgenumber", i10);
                context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
            }
        } catch (Throwable th) {
            a.h("NotificationUtil", "setHuaweiBadgeNumber failed " + th.getMessage());
        }
    }

    public static void y(Context context, Notification notification, int i10) {
        if (i10 != 0) {
            int a10 = q.c().a(context);
            int i11 = a10 + i10;
            f0.l(context, i11);
            a.a("NotificationUtil", "setNotificationBadge cacheNotificationBadge[" + a10 + "]+currentNotificationBadge[" + i10 + "]");
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            lowerCase.hashCode();
            char c10 = 65535;
            switch (lowerCase.hashCode()) {
                case -1206476313:
                    if (lowerCase.equals("huawei")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -759499589:
                    if (lowerCase.equals(Constants.REFERRER_API_XIAOMI)) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 99462250:
                    if (lowerCase.equals("honor")) {
                        c10 = 2;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    x(context, i11);
                    return;
                case 1:
                    z(context, notification, i10);
                    return;
                case 2:
                    w(context, i11);
                    return;
                default:
                    return;
            }
        }
    }

    public static void z(Context context, Notification notification, int i10) {
        if (notification != null) {
            if (i10 <= 0) {
                i10 = 0;
            }
            try {
                Object obj = notification.getClass().getDeclaredField("extraNotification").get(notification);
                obj.getClass().getDeclaredMethod("setMessageCount", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i10)});
            } catch (Throwable th) {
                a.h("NotificationUtil", "setXiaomiBadgeNumber failed " + th.getMessage());
            }
        }
    }
}
