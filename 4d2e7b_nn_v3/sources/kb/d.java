package kb;

import android.Manifest;
import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.net.Uri;
import android.os.Build;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.games.paddleboat.GameControllerManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p;
import kotlin.text.j;
import w6.g;
import w6.h;
import z2.a;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f12573a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static int f12574b;

    private d() {
    }

    private final g h(ReactApplicationContext reactApplicationContext) {
        Activity currentActivity = reactApplicationContext.getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.".toString());
        } else if (currentActivity instanceof g) {
            return (g) currentActivity;
        } else {
            throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.".toString());
        }
    }

    private final boolean i(ReactApplicationContext reactApplicationContext, String str) {
        Object obj;
        boolean z10;
        List list;
        String str2;
        String str3;
        String l02 = j.l0(j.l0(str, "android.permission."), "com.android.voicemail.permission.");
        try {
            o.a aVar = o.f12592b;
            obj = o.b(Manifest.permission.class.getField(l02));
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            obj = o.b(p.a(th));
        }
        boolean h10 = o.h(obj);
        PackageManager packageManager = reactApplicationContext.getPackageManager();
        List<PermissionGroupInfo> allPermissionGroups = packageManager.getAllPermissionGroups(0);
        m.e(allPermissionGroups, "getAllPermissionGroups(...)");
        List y02 = r.y0(allPermissionGroups);
        y02.add((Object) null);
        Iterable iterable = y02;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            loop0:
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PermissionGroupInfo permissionGroupInfo = (PermissionGroupInfo) it.next();
                try {
                    o.a aVar3 = o.f12592b;
                    if (permissionGroupInfo != null) {
                        str3 = permissionGroupInfo.name;
                    } else {
                        str3 = null;
                    }
                    list = o.b(packageManager.queryPermissionsByGroup(str3, 0));
                } catch (Throwable th2) {
                    o.a aVar4 = o.f12592b;
                    list = o.b(p.a(th2));
                }
                List l10 = r.l();
                if (o.f(list)) {
                    list = l10;
                }
                Iterable<PermissionInfo> iterable2 = (Iterable) list;
                if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                    for (PermissionInfo permissionInfo : iterable2) {
                        if (permissionInfo != null) {
                            str2 = permissionInfo.name;
                        } else {
                            str2 = null;
                        }
                        if (m.b(str2, str)) {
                            z10 = true;
                            break loop0;
                        }
                    }
                    continue;
                }
            }
            if (!h10 || z10) {
                return true;
            }
            return false;
        }
        z10 = false;
        if (!h10) {
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final void n(Promise promise, String str, Object[] objArr) {
        String str2;
        m.f(promise, "$promise");
        m.f(str, "$permission");
        m.f(objArr, "args");
        int[] iArr = objArr[0];
        m.d(iArr, "null cannot be cast to non-null type kotlin.IntArray");
        g gVar = objArr[1];
        m.d(gVar, "null cannot be cast to non-null type com.facebook.react.modules.core.PermissionAwareActivity");
        g gVar2 = gVar;
        Integer B = kotlin.collections.j.B(iArr, 0);
        if (B != null && B.intValue() == 0) {
            str2 = "granted";
        } else if (gVar2.shouldShowRequestPermissionRationale(str)) {
            str2 = "denied";
        } else {
            str2 = "blocked";
        }
        promise.resolve(str2);
    }

    /* access modifiers changed from: private */
    public static final void q(ArrayList arrayList, Promise promise, WritableMap writableMap, Object[] objArr) {
        String str;
        m.f(arrayList, "$permissionsToCheck");
        m.f(promise, "$promise");
        m.f(writableMap, "$output");
        m.f(objArr, "args");
        int i10 = 0;
        int[] iArr = objArr[0];
        m.d(iArr, "null cannot be cast to non-null type kotlin.IntArray");
        int[] iArr2 = iArr;
        g gVar = objArr[1];
        m.d(gVar, "null cannot be cast to non-null type com.facebook.react.modules.core.PermissionAwareActivity");
        g gVar2 = gVar;
        for (Object next : arrayList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                r.u();
            }
            String str2 = (String) next;
            Integer B = kotlin.collections.j.B(iArr2, i10);
            if (B != null && B.intValue() == 0) {
                str = "granted";
            } else if (gVar2.shouldShowRequestPermissionRationale(str2)) {
                str = "denied";
            } else {
                str = "blocked";
            }
            writableMap.putString(str2, str);
            i10 = i11;
        }
        promise.resolve(writableMap);
    }

    public final void c(ReactApplicationContext reactApplicationContext, Promise promise) {
        AlarmManager alarmManager;
        boolean z10;
        m.f(reactApplicationContext, "reactContext");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (Build.VERSION.SDK_INT < 31) {
            promise.resolve(Boolean.TRUE);
            return;
        }
        Object systemService = reactApplicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (systemService instanceof AlarmManager) {
            alarmManager = (AlarmManager) systemService;
        } else {
            alarmManager = null;
        }
        if (alarmManager != null) {
            z10 = alarmManager.canScheduleExactAlarms();
        } else {
            z10 = false;
        }
        promise.resolve(Boolean.valueOf(z10));
    }

    public final void d(ReactApplicationContext reactApplicationContext, String str, Promise promise) {
        m.f(reactApplicationContext, "reactContext");
        m.f(str, "permission");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (!i(reactApplicationContext, str)) {
            promise.resolve("unavailable");
        } else if (reactApplicationContext.getBaseContext().checkSelfPermission(str) == 0) {
            promise.resolve("granted");
        } else {
            promise.resolve("denied");
        }
    }

    public final void e(Promise promise) {
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        promise.reject("Permissions:checkLocationAccuracy", "checkLocationAccuracy is not supported on Android");
    }

    public final void f(ReactApplicationContext reactApplicationContext, ReadableArray readableArray, Promise promise) {
        String str;
        m.f(reactApplicationContext, "reactContext");
        m.f(readableArray, "permissions");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Context baseContext = reactApplicationContext.getBaseContext();
        int size = readableArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            String string = readableArray.getString(i10);
            if (!i(reactApplicationContext, string)) {
                str = "unavailable";
            } else if (baseContext.checkSelfPermission(string) == 0) {
                str = "granted";
            } else {
                str = "denied";
            }
            writableNativeMap.putString(string, str);
        }
        promise.resolve(writableNativeMap);
    }

    public final void g(ReactApplicationContext reactApplicationContext, Promise promise) {
        String str;
        m.f(reactApplicationContext, "reactContext");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(reactApplicationContext).areNotificationsEnabled();
        WritableMap createMap = Arguments.createMap();
        if (areNotificationsEnabled) {
            str = "granted";
        } else {
            str = "denied";
        }
        createMap.putString(NotificationCompat.CATEGORY_STATUS, str);
        createMap.putMap("settings", Arguments.createMap());
        promise.resolve(createMap);
    }

    public final boolean j(ReactApplicationContext reactApplicationContext, SparseArray sparseArray, int i10, int[] iArr) {
        m.f(reactApplicationContext, "reactContext");
        m.f(sparseArray, "callbacks");
        m.f(iArr, "grantResults");
        try {
            Callback callback = (Callback) sparseArray.get(i10);
            if (callback != null) {
                callback.invoke(iArr, h(reactApplicationContext));
                sparseArray.remove(i10);
            } else {
                a.I("PermissionsModule", "Unable to find callback with requestCode %d", Integer.valueOf(i10));
            }
            if (sparseArray.size() == 0) {
                return true;
            }
            return false;
        } catch (IllegalStateException e10) {
            a.m("PermissionsModule", e10, "Unexpected invocation of `onRequestPermissionsResult`", new Object[0]);
            return false;
        }
    }

    public final void k(Promise promise) {
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        promise.reject("Permissions:openPhotoPicker", "openPhotoPicker is not supported on Android");
    }

    public final void l(ReactApplicationContext reactApplicationContext, String str, Promise promise) {
        Intent intent;
        m.f(reactApplicationContext, "reactContext");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            String packageName = reactApplicationContext.getPackageName();
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 31) {
                if (m.b(str, "alarms")) {
                    intent = new Intent();
                    intent.setAction("android.settings.REQUEST_SCHEDULE_EXACT_ALARM");
                    intent.setData(Uri.parse("package:" + packageName));
                    intent.addFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
                    reactApplicationContext.startActivity(intent);
                    promise.resolve(Boolean.TRUE);
                }
            }
            if (i10 < 26 || !m.b(str, "notifications")) {
                intent = new Intent();
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:" + packageName));
            } else {
                intent = new Intent();
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
            }
            intent.addFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
            reactApplicationContext.startActivity(intent);
            promise.resolve(Boolean.TRUE);
        } catch (Exception e10) {
            promise.reject("E_INVALID_ACTIVITY", (Throwable) e10);
        }
    }

    public final void m(ReactApplicationContext reactApplicationContext, h hVar, SparseArray sparseArray, String str, Promise promise) {
        m.f(reactApplicationContext, "reactContext");
        m.f(hVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        m.f(sparseArray, "callbacks");
        m.f(str, "permission");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (!i(reactApplicationContext, str)) {
            promise.resolve("unavailable");
        } else if (reactApplicationContext.getBaseContext().checkSelfPermission(str) == 0) {
            promise.resolve("granted");
        } else {
            try {
                g h10 = h(reactApplicationContext);
                sparseArray.put(f12574b, new b(promise, str));
                h10.requestPermissions(new String[]{str}, f12574b, hVar);
                f12574b++;
            } catch (IllegalStateException e10) {
                promise.reject("E_INVALID_ACTIVITY", (Throwable) e10);
            }
        }
    }

    public final void o(Promise promise) {
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        promise.reject("Permissions:requestLocationAccuracy", "requestLocationAccuracy is not supported on Android");
    }

    public final void p(ReactApplicationContext reactApplicationContext, h hVar, SparseArray sparseArray, ReadableArray readableArray, Promise promise) {
        m.f(reactApplicationContext, "reactContext");
        m.f(hVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        m.f(sparseArray, "callbacks");
        m.f(readableArray, "permissions");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        ArrayList arrayList = new ArrayList();
        Context baseContext = reactApplicationContext.getBaseContext();
        int size = readableArray.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            String string = readableArray.getString(i11);
            if (!i(reactApplicationContext, string)) {
                writableNativeMap.putString(string, "unavailable");
            } else if (baseContext.checkSelfPermission(string) == 0) {
                writableNativeMap.putString(string, "granted");
            } else {
                arrayList.add(string);
            }
            i10++;
        }
        if (readableArray.size() == i10) {
            promise.resolve(writableNativeMap);
            return;
        }
        try {
            g h10 = h(reactApplicationContext);
            sparseArray.put(f12574b, new c(arrayList, promise, writableNativeMap));
            h10.requestPermissions((String[]) arrayList.toArray(new String[0]), f12574b, hVar);
            f12574b++;
        } catch (IllegalStateException e10) {
            promise.reject("E_INVALID_ACTIVITY", (Throwable) e10);
        }
    }

    public final void r(ReactApplicationContext reactApplicationContext, Promise promise) {
        String str;
        m.f(reactApplicationContext, "reactContext");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(reactApplicationContext).areNotificationsEnabled();
        WritableMap createMap = Arguments.createMap();
        if (areNotificationsEnabled) {
            str = "granted";
        } else {
            str = "blocked";
        }
        createMap.putString(NotificationCompat.CATEGORY_STATUS, str);
        createMap.putMap("settings", Arguments.createMap());
        promise.resolve(createMap);
    }

    public final void s(ReactApplicationContext reactApplicationContext, String str, Promise promise) {
        m.f(reactApplicationContext, "reactContext");
        m.f(str, "permission");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            promise.resolve(Boolean.valueOf(h(reactApplicationContext).shouldShowRequestPermissionRationale(str)));
        } catch (IllegalStateException e10) {
            promise.reject("E_INVALID_ACTIVITY", (Throwable) e10);
        }
    }
}
