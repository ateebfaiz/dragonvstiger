package com.zing.zalo.devicetrackingsdk;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.zing.zalo.devicetrackingsdk.model.DeviceIdInfo;
import com.zing.zalo.devicetrackingsdk.model.SDKIDInfo;
import com.zing.zalo.zalosdk.Constant;
import com.zing.zalo.zalosdk.core.helper.Storage;
import com.zing.zalo.zalosdk.core.log.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseAppInfoStorage extends Storage {
    private static final String DID_FILE_NAME = "ddinfo2";
    private final String PREF_PRIVATE_KEY = "PREF_PRIVATE_KEY";
    private final String PREF_SDK_ID = "PREF_SDK_ID";
    private final String PREF_TRACKING_APP_INSTALL_EXP_TIME = "PREF_TRACKING_APP_INSTALL_EXP_TIME";
    private final String PREF_VIEWER = "PREFERECE_VIEWER";
    private DeviceIdInfo deviceIdInfo = new DeviceIdInfo();
    private SDKIDInfo sdkIdInfo = new SDKIDInfo();

    public BaseAppInfoStorage(Context context) {
        super(context);
    }

    private File prepareFileInExternalStore(String str, boolean z10) {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.google.android.zdt.data/" + str);
        file.getParentFile().mkdirs();
        if (z10 && file.exists()) {
            file.delete();
        }
        return file;
    }

    private StringBuilder readFileData(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        StringBuilder sb2 = new StringBuilder(256);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb2.append(readLine);
            } else {
                fileInputStream.close();
                return sb2;
            }
        }
    }

    private String readFromFile(Context context, String str) {
        try {
            if (isExternalStorageReadable()) {
                File prepareFileInExternalStore = prepareFileInExternalStore(str, false);
                if (prepareFileInExternalStore.exists()) {
                    return readFileData(prepareFileInExternalStore).toString();
                }
            }
        } catch (Exception e10) {
            Log.e(e10);
        }
        try {
            return readFileData(new File(context.getNoBackupFilesDir(), str)).toString();
        } catch (FileNotFoundException unused) {
            Log.v(Constant.LOG_TAG, "file %s not found in internal storage", str);
            Log.v("can't read file " + str);
            return null;
        } catch (Exception e11) {
            Log.e(e11);
            Log.v("can't read file " + str);
            return null;
        }
    }

    private void writeFileData(String str, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        outputStreamWriter.write(str);
        outputStreamWriter.close();
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    private void writeToFile(Context context, String str, String str2) {
        try {
            if (isExternalStorageWritable()) {
                File prepareFileInExternalStore = prepareFileInExternalStore(str2, true);
                prepareFileInExternalStore.createNewFile();
                writeFileData(str, prepareFileInExternalStore);
                return;
            }
        } catch (Exception e10) {
            Log.e(e10);
        }
        try {
            writeFileData(str, new File(context.getNoBackupFilesDir(), str2));
        } catch (Exception e11) {
            Log.e(e11);
            Log.v("can't write file " + str2);
        }
    }

    public String getDeviceId() {
        return this.deviceIdInfo.getDeviceId();
    }

    public long getDeviceIdExpiredTime() {
        return this.deviceIdInfo.getDeviceIdExpiredTime();
    }

    public String getPrivateKey() {
        return this.sdkIdInfo.getPrivateKey();
    }

    public String getSDKId() {
        return this.sdkIdInfo.getSdkId();
    }

    public long getTrackingAppInstallExpireTime() {
        return getLong("PREF_TRACKING_APP_INSTALL_EXP_TIME");
    }

    public String getViewer() {
        return getString("PREFERECE_VIEWER");
    }

    public boolean isExternalStorageReadable() {
        if (!ZPermissionManager.isPermissionGranted(this.context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return false;
        }
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) {
            return true;
        }
        return false;
    }

    public boolean isExternalStorageWritable() {
        if (ZPermissionManager.isPermissionGranted(this.context, "android.permission.WRITE_EXTERNAL_STORAGE") && "mounted".equals(Environment.getExternalStorageState())) {
            return true;
        }
        return false;
    }

    public boolean ispreInstalled() {
        try {
            if (isExternalStorageReadable()) {
                File prepareFileInExternalStore = prepareFileInExternalStore(this.context.getPackageName(), false);
                if (prepareFileInExternalStore.exists()) {
                    return true;
                }
                prepareFileInExternalStore.createNewFile();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void loadDeviceId() {
        String readFromFile = readFromFile(this.context, DID_FILE_NAME);
        if (!TextUtils.isEmpty(readFromFile)) {
            try {
                JSONObject jSONObject = new JSONObject(readFromFile);
                this.deviceIdInfo.setDeviceId(jSONObject.optString("deviceId"));
                this.deviceIdInfo.setDeviceIdExpiredTime(jSONObject.optLong("expiredTime"));
            } catch (JSONException unused) {
            }
        }
        Log.v("Loaded device info: " + this.deviceIdInfo.toString());
    }

    public void loadSDKId() {
        if (this.sdkIdInfo == null) {
            this.sdkIdInfo = new SDKIDInfo();
        }
        this.sdkIdInfo.setSdkId(this.localPref.getString("PREF_SDK_ID", ""));
        this.sdkIdInfo.setPrivateKey(this.localPref.getString("PREF_PRIVATE_KEY", ""));
        Log.v("Loaded sdk info: " + this.sdkIdInfo.toString());
    }

    public void setDeviceId(String str, long j10) {
        this.deviceIdInfo.setDeviceId(str);
        this.deviceIdInfo.setDeviceIdExpiredTime(j10);
        Context context = this.context;
        writeToFile(context, "{\"deviceId\":\"" + str + "\",\"expiredTime\":\"" + j10 + "\"}", DID_FILE_NAME);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("write device info: ");
        sb2.append(this.deviceIdInfo.toString());
        Log.v(sb2.toString());
    }

    public void setSDKId(String str, String str2) {
        setString("PREF_SDK_ID", str);
        setString("PREF_PRIVATE_KEY", str2);
        loadSDKId();
        Log.v("write sdkid info: " + this.sdkIdInfo.toString());
    }

    public void setTrackingAppInstallExpireTime(long j10) {
        setLong("PREF_TRACKING_APP_INSTALL_EXP_TIME", j10);
    }
}
