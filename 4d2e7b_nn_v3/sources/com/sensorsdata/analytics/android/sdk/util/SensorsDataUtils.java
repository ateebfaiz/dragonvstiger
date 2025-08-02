package com.sensorsdata.analytics.android.sdk.util;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.business.SAPropertyManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.internal.beans.LimitKey;
import com.sensorsdata.analytics.android.sdk.jsbridge.AppWebViewInterface;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public final class SensorsDataUtils {
    public static final String COMMAND_HARMONYOS_VERSION = "getprop hw_sc.build.platform.version";
    private static final String SHARED_PREF_APP_VERSION = "sensorsdata.app.version";
    private static final String TAG = "SA.SensorsDataUtils";
    private static String androidID = "";
    private static boolean isAndroidIDEnabled = true;
    private static boolean isOAIDEnabled = true;
    private static boolean isUniApp;
    private static final List<String> mInvalidAndroidId = new ArrayList<String>() {
        {
            add("9774d56d682e549c");
            add("0123456789abcdef");
            add("0000000000000000");
        }
    };

    public static boolean checkVersionIsNew(Context context, String str) {
        try {
            String string = SAStoreManager.getInstance().getString(SHARED_PREF_APP_VERSION, "");
            if (TextUtils.isEmpty(str) || str.equals(string)) {
                return false;
            }
            SAStoreManager.getInstance().setString(SHARED_PREF_APP_VERSION, str);
            return true;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return true;
        }
    }

    private static Class<?> compatActivity() {
        Class<?> cls;
        try {
            cls = ReflectUtil.getClassByName("androidx.appcompat.app.AppCompatActivity");
        } catch (Exception unused) {
            cls = null;
        }
        if (cls != null) {
            return cls;
        }
        try {
            return ReflectUtil.getClassByName("androidx.appcompat.app.AppCompatActivity");
        } catch (Exception unused2) {
            return cls;
        }
    }

    public static void enableAndroidId(boolean z10) {
        isAndroidIDEnabled = z10;
    }

    public static void enableOAID(boolean z10) {
        isOAIDEnabled = z10;
    }

    public static String getActivityTitle(Activity activity) {
        PackageManager packageManager;
        if (activity != null) {
            try {
                String toolbarTitle = getToolbarTitle(activity);
                if (TextUtils.isEmpty(toolbarTitle)) {
                    toolbarTitle = null;
                }
                if (TextUtils.isEmpty(toolbarTitle)) {
                    toolbarTitle = activity.getTitle().toString();
                }
                if (!TextUtils.isEmpty(toolbarTitle) || (packageManager = activity.getPackageManager()) == null) {
                    return toolbarTitle;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(activity.getComponentName(), 0);
                if (!TextUtils.isEmpty(activityInfo.loadLabel(packageManager))) {
                    return activityInfo.loadLabel(packageManager).toString();
                }
                return toolbarTitle;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @SuppressLint({"HardwareIds"})
    public static String getIdentifier(Context context) {
        try {
            if (!isAndroidIDEnabled) {
                SALog.i(TAG, "SensorsData getAndroidID is disabled");
                return "";
            } else if (SAPropertyManager.getInstance().isLimitKey(LimitKey.ANDROID_ID)) {
                return SAPropertyManager.getInstance().getLimitValue(LimitKey.ANDROID_ID);
            } else {
                if (TextUtils.isEmpty(androidID)) {
                    SALog.i(TAG, "SensorsData getIdentifier");
                    String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    androidID = string;
                    if (!isValidAndroidId(string)) {
                        androidID = "";
                    }
                }
                return androidID;
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static String getToolbarTitle(Activity activity) {
        Object invoke;
        CharSequence charSequence;
        try {
            if (!"com.tencent.connect.common.AssistActivity".equals(SnapCache.getInstance().getCanonicalName(activity.getClass()))) {
                ActionBar actionBar = activity.getActionBar();
                if (actionBar == null) {
                    try {
                        Class<?> compatActivity = compatActivity();
                        if (!(compatActivity == null || !compatActivity.isInstance(activity) || (invoke = activity.getClass().getMethod("getSupportActionBar", (Class[]) null).invoke(activity, (Object[]) null)) == null || (charSequence = (CharSequence) invoke.getClass().getMethod("getTitle", (Class[]) null).invoke(invoke, (Object[]) null)) == null)) {
                            return charSequence.toString();
                        }
                    } catch (Exception unused) {
                    }
                } else if (!TextUtils.isEmpty(actionBar.getTitle())) {
                    return actionBar.getTitle().toString();
                }
                return null;
            } else if (!TextUtils.isEmpty(activity.getTitle())) {
                return activity.getTitle().toString();
            } else {
                return null;
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void handleSchemeUrl(Activity activity, Intent intent) {
        SASchemeHelper.handleSchemeUrl(activity, intent);
    }

    public static void initUniAppStatus() {
        try {
            Class.forName("io.dcloud.application.DCloudApplication");
            isUniApp = true;
        } catch (ClassNotFoundException unused) {
        }
    }

    public static boolean isOAIDEnabled() {
        return isOAIDEnabled;
    }

    public static boolean isUniApp() {
        return isUniApp;
    }

    public static boolean isValidAndroidId(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !mInvalidAndroidId.contains(str.toLowerCase(Locale.getDefault()));
    }

    @Deprecated
    public static void mergeJSONObject(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONUtils.mergeJSONObject(jSONObject, jSONObject2);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void showUpWebView(Context context, Object obj, JSONObject jSONObject, boolean z10, boolean z11) {
        try {
            SALog.i(TAG, "SensorsDataUtils.showUpWebView called.x5WebView = " + obj + ", isSupportJellyBean = " + z10 + ", enableVerify = " + z11);
            if (obj != null) {
                try {
                    Class<?> cls = obj.getClass();
                    try {
                        Object invoke = cls.getMethod("getSettings", (Class[]) null).invoke(obj, (Object[]) null);
                        if (invoke != null) {
                            invoke.getClass().getMethod("setJavaScriptEnabled", new Class[]{Boolean.TYPE}).invoke(invoke, new Object[]{Boolean.TRUE});
                        }
                    } catch (Exception unused) {
                    }
                    cls.getMethod("addJavascriptInterface", new Class[]{Object.class, String.class}).invoke(obj, new Object[]{new AppWebViewInterface(context, jSONObject, z11), "SensorsData_APP_JS_Bridge"});
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
                SAModuleManager.getInstance().invokeModuleFunction(Modules.Visual.MODULE_NAME, Modules.Visual.METHOD_ADD_VISUAL_JAVASCRIPTINTERFACE, obj);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }
}
