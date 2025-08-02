package org.cocos2dx.javascript.rn;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.webkit.internal.AssetHelper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.cocos2dx.javascript.AppActivity;
import org.cocos2dx.javascript.LocalShareUtil;
import org.cocos2dx.javascript.PlatformUtils;

public class ShareUtils {
    private static final String TAG = "ShareUtils";

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f1479a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1480b;

        a(Activity activity, String str) {
            this.f1479a = activity;
            this.f1480b = str;
        }

        public void run() {
            try {
                this.f1479a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f1480b)));
            } catch (Exception unused) {
            }
        }
    }

    public static void contactQQ(String str, String str2) {
        AppActivity activity = PlatformUtils.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new f(str2, str, activity));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$contactQQ$1(String str, String str2, Activity activity) {
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str + str2)));
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$sysShare$0(String str, Activity activity) {
        JSONObject parseObject = JSON.parseObject(str);
        String string = parseObject.getString("title");
        String string2 = parseObject.getString(FirebaseAnalytics.Param.CONTENT);
        String string3 = parseObject.getString("path");
        Log.d(TAG, "sysShare: title=" + string + ",content=" + string2 + "path=" + string3);
        if (string2 == null || string2.length() <= 0 || !((string == null || string.length() == 0) && (string3 == null || string3.length() == 0))) {
            LocalShareUtil.shareImg(activity, string3, string2, string, (String) null);
        } else {
            LocalShareUtil.shareText(activity, string2, (String) null);
        }
    }

    public static void openAPP(String str, String str2, String str3) {
        String str4;
        if (str.equals("1")) {
            contactQQ(str2, str3);
        } else if (str.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
            wxOpen(str3);
        } else {
            if (str.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                if (str2.length() > 0) {
                    str4 = str3 + str2;
                } else {
                    whatsAppOpen(str3);
                    return;
                }
            } else if (str.equals("4")) {
                str4 = str3 + str2;
            } else if (str.equals("5")) {
                str4 = str3 + str2;
            } else {
                str4 = "";
            }
            if (!str.equals("-1")) {
                str3 = str4;
            }
            AppActivity activity = PlatformUtils.getActivity();
            if (activity != null) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str3));
                    activity.startActivity(intent);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    public static void sysShare(String str) {
        Log.d(TAG, "share: " + str);
        AppActivity activity = PlatformUtils.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new g(str, activity));
        }
    }

    public static void whatsAppOpen(String str) {
        Log.d(TAG, "whatsAppOpen()");
        AppActivity activity = PlatformUtils.getActivity();
        activity.getPackageManager();
        try {
            if (PlatformUtils.findInt(str)) {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", "#");
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            intent.setPackage("com.whatsapp");
            activity.startActivity(intent);
        } catch (NullPointerException unused) {
        }
    }

    public static void wxOpen(String str) {
        Log.d(TAG, "wxOpen()");
        AppActivity activity = PlatformUtils.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new a(activity, str));
        }
    }
}
