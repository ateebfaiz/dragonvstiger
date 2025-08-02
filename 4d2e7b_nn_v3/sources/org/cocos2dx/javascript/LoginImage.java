package org.cocos2dx.javascript;

import android.content.res.AssetManager;
import android.util.Log;
import com.cocos.lib.CocosHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class LoginImage {
    private static final String TAG = "LoginImage";
    private static final String dataDir = "data";
    private static final String gifPath = "gif/loginImage";

    public static void CopyDataFileToWritablePath() {
        AssetManager assets = PlatformUtils.context.getAssets();
        try {
            String str = CocosHelper.getWritablePath() + File.separator + "data";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            String[] list = assets.list("data");
            for (String str2 : list) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(file);
                String str3 = File.separator;
                sb2.append(str3);
                sb2.append(str2);
                String sb3 = sb2.toString();
                Log.i(TAG, "CopyDataFile : " + str);
                InputStream open = PlatformUtils.context.getAssets().open("data" + str3 + str2);
                FileOutputStream fileOutputStream = new FileOutputStream(sb3);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                open.close();
                fileOutputStream.close();
            }
        } catch (IOException unused) {
            Log.e(TAG, "copy data file exception");
        }
    }

    public static void CopyLoginImageToWritablePath() {
        if (IsFileExists("gifInfo.json")) {
            try {
                String str = CocosHelper.getWritablePath() + File.separator + gifPath;
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String[] list = PlatformUtils.context.getAssets().list(gifPath);
                for (int i10 = 0; i10 < list.length; i10++) {
                    CopyToWritableDir(str + File.separator + list[i10], list[i10]);
                }
            } catch (IOException unused) {
                Log.e(TAG, "copy file exception");
            }
        }
    }

    private static void CopyToWritableDir(String str, String str2) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            AssetManager assets = PlatformUtils.context.getAssets();
            InputStream open = assets.open(gifPath + File.separator + str2);
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    Log.i(TAG, "copy file success : " + str2);
                    return;
                }
            }
        } catch (IOException unused) {
            Log.e(TAG, "copy file exception : " + str2);
        }
    }

    private static boolean IsFileExists(String str) {
        try {
            String[] list = PlatformUtils.context.getAssets().list(gifPath);
            for (int i10 = 0; i10 < list.length; i10++) {
                Log.i(TAG, list[i10]);
                if (list[i10].equals(str)) {
                    return true;
                }
            }
        } catch (IOException unused) {
            Log.e(TAG, "check file exist exception");
        }
        return false;
    }
}
