package org.cocos2dx.javascript;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import androidx.core.content.FileProvider;
import androidx.webkit.internal.AssetHelper;
import com.google.android.games.paddleboat.GameControllerManager;
import java.io.File;

public class LocalShareUtil {
    private static AppActivity mActivity;

    public static boolean shareImg(Activity activity, String str, String str2, String str3, String str4) {
        Uri uri;
        Log.e("sysShareImg", "sysShareImg:" + str);
        if (!(str == null || activity == null)) {
            Intent intent = new Intent();
            File file = new File(str);
            if (!file.exists()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                AppActivity appActivity = mActivity;
                uri = FileProvider.getUriForFile(appActivity, activity.getPackageName() + ".fileprovider", file);
            } else {
                uri = Uri.fromFile(file);
            }
            intent.setAction("android.intent.action.SEND");
            intent.addFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.addFlags(1);
            if (str4 != null) {
                intent.setPackage(str4);
            }
            intent.putExtra("android.intent.extra.SUBJECT", str3);
            intent.putExtra("android.intent.extra.TEXT", str2);
            intent.setFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
            try {
                activity.startActivity(Intent.createChooser(intent, "Share To"));
                return true;
            } catch (Exception e10) {
                e10.printStackTrace();
                Log.e("sysShareImg Exception", "sysShareImg Exception:" + e10.getMessage());
            }
        }
        return false;
    }

    public static void shareText(Activity activity, String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.addFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
        if (str2 != null) {
            intent.setPackage(str2);
        }
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        intent.putExtra("android.intent.extra.TEXT", str);
        try {
            activity.startActivity(Intent.createChooser(intent, "Share To"));
        } catch (Exception e10) {
            e10.printStackTrace();
            Log.e("sysShareText Exception:", e10.getMessage());
        }
    }

    public static boolean shareToFacebook(Activity activity, String str) {
        Uri uri;
        Log.e("", "sysShareToFacebook:" + str);
        if (!(str == null || activity == null)) {
            Intent intent = new Intent();
            File file = new File(Environment.getExternalStorageDirectory() + "/app/a.jpg");
            if (!file.exists()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                AppActivity appActivity = mActivity;
                uri = FileProvider.getUriForFile(appActivity, activity.getPackageName() + ".fileprovider", file);
            } else {
                uri = Uri.fromFile(file);
            }
            intent.setPackage("com.facebook.katana");
            intent.setAction("android.intent.action.SEND");
            intent.addFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            intent.putExtra("android.intent.extra.TEXT", str);
            try {
                activity.startActivity(Intent.createChooser(intent, "Share To"));
                return true;
            } catch (Exception e10) {
                e10.printStackTrace();
                Log.e("sysShareImg Exception:", "sysShareImg Exception:" + e10.getMessage());
            }
        }
        return false;
    }
}
