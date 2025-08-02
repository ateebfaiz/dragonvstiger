package com.microsoft.codepush.react;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.messaging.Constants;
import org.json.JSONException;
import org.json.JSONObject;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f10227a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10228b = "appVersion";

    /* renamed from: c  reason: collision with root package name */
    private final String f10229c = "DeploymentFailed";

    /* renamed from: d  reason: collision with root package name */
    private final String f10230d = "deploymentKey";

    /* renamed from: e  reason: collision with root package name */
    private final String f10231e = "DeploymentSucceeded";

    /* renamed from: f  reason: collision with root package name */
    private final String f10232f = Constants.ScionAnalytics.PARAM_LABEL;

    /* renamed from: g  reason: collision with root package name */
    private final String f10233g = "CODE_PUSH_LAST_DEPLOYMENT_REPORT";

    /* renamed from: h  reason: collision with root package name */
    private final String f10234h = "package";

    /* renamed from: i  reason: collision with root package name */
    private final String f10235i = "previousDeploymentKey";

    /* renamed from: j  reason: collision with root package name */
    private final String f10236j = "previousLabelOrAppVersion";

    /* renamed from: k  reason: collision with root package name */
    private final String f10237k = "CODE_PUSH_RETRY_DEPLOYMENT_REPORT";

    /* renamed from: l  reason: collision with root package name */
    private final String f10238l = NotificationCompat.CATEGORY_STATUS;

    public f(Context context) {
        this.f10227a = context.getSharedPreferences("CodePush", 0);
    }

    private void a() {
        this.f10227a.edit().remove("CODE_PUSH_RETRY_DEPLOYMENT_REPORT").commit();
    }

    private String c(String str) {
        String[] split = str.split(":");
        if (split.length > 0) {
            return split[0];
        }
        return null;
    }

    private String d(ReadableMap readableMap) {
        String l10 = k.l(readableMap, "deploymentKey");
        String l11 = k.l(readableMap, Constants.ScionAnalytics.PARAM_LABEL);
        if (l10 == null || l11 == null) {
            return null;
        }
        return l10 + ":" + l11;
    }

    private String e() {
        return this.f10227a.getString("CODE_PUSH_LAST_DEPLOYMENT_REPORT", (String) null);
    }

    private String i(String str) {
        String[] split = str.split(":");
        if (split.length > 1) {
            return split[1];
        }
        return null;
    }

    private boolean j(String str) {
        if (str == null || !str.contains(":")) {
            return false;
        }
        return true;
    }

    private void m(String str) {
        this.f10227a.edit().putString("CODE_PUSH_LAST_DEPLOYMENT_REPORT", str).commit();
    }

    public WritableMap b(String str) {
        String e10 = e();
        if (e10 == null) {
            a();
            WritableMap createMap = Arguments.createMap();
            createMap.putString("appVersion", str);
            return createMap;
        } else if (e10.equals(str)) {
            return null;
        } else {
            a();
            WritableMap createMap2 = Arguments.createMap();
            if (j(e10)) {
                String c10 = c(e10);
                String i10 = i(e10);
                createMap2.putString("appVersion", str);
                createMap2.putString("previousDeploymentKey", c10);
                createMap2.putString("previousLabelOrAppVersion", i10);
            } else {
                createMap2.putString("appVersion", str);
                createMap2.putString("previousLabelOrAppVersion", e10);
            }
            return createMap2;
        }
    }

    public WritableMap f() {
        String string = this.f10227a.getString("CODE_PUSH_RETRY_DEPLOYMENT_REPORT", (String) null);
        if (string != null) {
            a();
            try {
                return k.c(new JSONObject(string));
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public WritableMap g(WritableMap writableMap) {
        WritableMap createMap = Arguments.createMap();
        createMap.putMap("package", writableMap);
        createMap.putString(NotificationCompat.CATEGORY_STATUS, "DeploymentFailed");
        return createMap;
    }

    public WritableMap h(WritableMap writableMap) {
        String d10 = d(writableMap);
        String e10 = e();
        if (d10 != null) {
            if (e10 == null) {
                a();
                WritableMap createMap = Arguments.createMap();
                createMap.putMap("package", writableMap);
                createMap.putString(NotificationCompat.CATEGORY_STATUS, "DeploymentSucceeded");
                return createMap;
            } else if (!e10.equals(d10)) {
                a();
                WritableMap createMap2 = Arguments.createMap();
                if (j(e10)) {
                    String c10 = c(e10);
                    String i10 = i(e10);
                    createMap2.putMap("package", writableMap);
                    createMap2.putString(NotificationCompat.CATEGORY_STATUS, "DeploymentSucceeded");
                    createMap2.putString("previousDeploymentKey", c10);
                    createMap2.putString("previousLabelOrAppVersion", i10);
                    return createMap2;
                }
                createMap2.putMap("package", writableMap);
                createMap2.putString(NotificationCompat.CATEGORY_STATUS, "DeploymentSucceeded");
                createMap2.putString("previousLabelOrAppVersion", e10);
                return createMap2;
            }
        }
        return null;
    }

    public void k(ReadableMap readableMap) {
        if (readableMap.hasKey(NotificationCompat.CATEGORY_STATUS) && "DeploymentFailed".equals(readableMap.getString(NotificationCompat.CATEGORY_STATUS))) {
            return;
        }
        if (readableMap.hasKey("appVersion")) {
            m(readableMap.getString("appVersion"));
        } else if (readableMap.hasKey("package")) {
            m(d(readableMap.getMap("package")));
        }
    }

    public void l(ReadableMap readableMap) {
        this.f10227a.edit().putString("CODE_PUSH_RETRY_DEPLOYMENT_REPORT", k.e(readableMap).toString()).commit();
    }
}
