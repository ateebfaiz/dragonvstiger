package com.zing.zalo.zalosdk.core;

import android.content.Context;
import com.zing.zalo.zalosdk.Constant;
import com.zing.zalo.zalosdk.core.helper.Storage;
import com.zing.zalo.zalosdk.core.helper.Utils;

public class SettingsManager {
    private static final String KEY_BRAND_PRELOAD_SETTING = "com.zing.zalo.sdk.settings.preload.brand_preload";
    private static final String KEY_EXPIRE_SETTING = "com.zing.zalo.sdk.wakeup.expiresetting";
    private static final String KEY_LAST_TIME_WAKEUP = "com.zing.zalo.sdk.wakeup.lastimewakeup";
    private static final String KEY_MODEL_PRELOAD_SETTING = "com.zing.zalo.sdk.settings.preload.model_preload";
    private static final String KEY_PRELOAD_DEFAULT_SETTING = "com.zing.zalo.sdk.settings.preload.preload_default";
    private static final String KEY_PRELOAD_EXPIRE_SETTING = "com.zing.zalo.sdk.settings.preload.expiredsetting";
    private static final String KEY_PRELOAD_RESUBMIT_INTERVAL = "com.zing.zalo.sdk.settings.preload.resubmit_interval";
    private static final String KEY_SETTINGS_OUT_APP_LOGIN = "com.zing.zalo.sdk.settings.outapplogin";
    private static final String KEY_SETTINGS_WEBVIEW = "com.zing.zalo.sdk.settings.useWebViewForUnloginZalo";
    private static final String KEY_WAKEUP_ENABLE = "com.zing.zalo.sdk.wakeup.wakeupenable";
    private static final String KEY_WAKEUP_SETTING = "com.zing.zalo.sdk.wakeup.wakeupsetting";
    private static final SettingsManager settingsManager = new SettingsManager();
    public boolean isInitilzed = false;

    public static SettingsManager getInstance() {
        return settingsManager;
    }

    public String getBrandPreloadSetting(Context context) {
        return Utils.getSavedString(context, Constant.PREFS_NAME_PRELOAD, KEY_BRAND_PRELOAD_SETTING);
    }

    public long getExpiredSetting(Context context) {
        return Utils.getSavedLong(context, Constant.PREFS_NAME_WAKEUP, KEY_EXPIRE_SETTING);
    }

    public long getExpiredTimePreloadSetting(Context context) {
        return Utils.getSavedLong(context, Constant.PREFS_NAME_PRELOAD, KEY_PRELOAD_EXPIRE_SETTING);
    }

    public long getLastTimeWakeup(Context context) {
        return Utils.getSavedLong(context, Constant.PREFS_NAME_WAKEUP, KEY_LAST_TIME_WAKEUP);
    }

    public String getModelPreloadSetting(Context context) {
        return Utils.getSavedString(context, Constant.PREFS_NAME_PRELOAD, KEY_MODEL_PRELOAD_SETTING);
    }

    public String getPreloadDefaultSetting(Context context) {
        return Utils.getSavedString(context, Constant.PREFS_NAME_PRELOAD, KEY_PRELOAD_DEFAULT_SETTING);
    }

    public int getResubmitIntervalPreloadSetting(Context context) {
        return Utils.getSavedInt(context, Constant.PREFS_NAME_PRELOAD, KEY_PRELOAD_RESUBMIT_INTERVAL);
    }

    public long getWakeUpInterval(Context context) {
        long savedLong = Utils.getSavedLong(context, Constant.PREFS_NAME_WAKEUP, KEY_WAKEUP_SETTING);
        if (savedLong <= 0) {
            return 600000;
        }
        return savedLong;
    }

    public boolean getWakeupSetting(Context context) {
        return Utils.getSavedBoolean(context, Constant.PREFS_NAME_WAKEUP, KEY_WAKEUP_ENABLE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void init(android.content.Context r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            monitor-enter(r5)
            boolean r2 = r5.isInitilzed     // Catch:{ all -> 0x002b }
            if (r2 == 0) goto L_0x0009
            monitor-exit(r5)
            return
        L_0x0009:
            r5.isInitilzed = r1     // Catch:{ all -> 0x002b }
            boolean r2 = r5.isExpiredSetting(r6)     // Catch:{ all -> 0x002b }
            if (r2 == 0) goto L_0x002d
            com.zing.zalo.devicetrackingsdk.GetSDKSettingAsyncTask r2 = new com.zing.zalo.devicetrackingsdk.GetSDKSettingAsyncTask     // Catch:{ all -> 0x002b }
            r3 = 0
            r2.<init>(r6, r3, r7)     // Catch:{ all -> 0x002b }
            android.content.Context[] r4 = new android.content.Context[r1]     // Catch:{ all -> 0x002b }
            r4[r0] = r6     // Catch:{ all -> 0x002b }
            r2.execute(r4)     // Catch:{ all -> 0x002b }
            com.zing.zalo.devicetrackingsdk.GetPreloadSettingAsyncTask r2 = new com.zing.zalo.devicetrackingsdk.GetPreloadSettingAsyncTask     // Catch:{ all -> 0x002b }
            r2.<init>(r6, r3, r7)     // Catch:{ all -> 0x002b }
            android.content.Context[] r7 = new android.content.Context[r1]     // Catch:{ all -> 0x002b }
            r7[r0] = r6     // Catch:{ all -> 0x002b }
            r2.execute(r7)     // Catch:{ all -> 0x002b }
            goto L_0x002d
        L_0x002b:
            r6 = move-exception
            goto L_0x002f
        L_0x002d:
            monitor-exit(r5)
            return
        L_0x002f:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zing.zalo.zalosdk.core.SettingsManager.init(android.content.Context, java.lang.String):void");
    }

    public boolean isExpiredPreloadSetting(Context context) {
        if (System.currentTimeMillis() > getExpiredTimePreloadSetting(context)) {
            return true;
        }
        return false;
    }

    public boolean isExpiredSetting(Context context) {
        if (System.currentTimeMillis() > getExpiredSetting(context)) {
            return true;
        }
        return false;
    }

    public boolean isLoginViaBrowser(Context context) {
        return Utils.getSavedBoolean(context, Constant.PREFS_NAME_WAKEUP, KEY_SETTINGS_OUT_APP_LOGIN);
    }

    public boolean isUseWebViewUnLoginZalo(Context context) {
        return Storage.getBoolean(context, KEY_SETTINGS_WEBVIEW);
    }

    public void saveExpiredSetting(Context context, long j10) {
        Utils.saveLong(context, Constant.PREFS_NAME_WAKEUP, KEY_EXPIRE_SETTING, j10);
    }

    public void saveExpiredTimePreloadSetting(Context context, long j10) {
        Utils.saveLong(context, Constant.PREFS_NAME_PRELOAD, KEY_PRELOAD_EXPIRE_SETTING, j10);
    }

    public void saveLastTimeWakeUp(Context context, long j10) {
        Utils.saveLong(context, Constant.PREFS_NAME_WAKEUP, KEY_LAST_TIME_WAKEUP, j10);
    }

    public void saveResubmitIntervalPreloadSetting(Context context, int i10) {
        Utils.saveInt(context, Constant.PREFS_NAME_PRELOAD, KEY_PRELOAD_RESUBMIT_INTERVAL, i10);
    }

    public void saveWakeUpInterval(Context context, long j10) {
        Utils.saveLong(context, Constant.PREFS_NAME_WAKEUP, KEY_WAKEUP_SETTING, j10);
    }

    public void saveWakeUpSetting(Context context, boolean z10) {
        Utils.saveBoolean(context, Constant.PREFS_NAME_WAKEUP, KEY_WAKEUP_ENABLE, z10);
    }

    public void setBrandPreloadSetting(Context context, String str) {
        Utils.saveString(context, Constant.PREFS_NAME_PRELOAD, KEY_BRAND_PRELOAD_SETTING, str);
    }

    public void setLoginViaBrowser(Context context, boolean z10) {
        Utils.saveBoolean(context, Constant.PREFS_NAME_WAKEUP, KEY_SETTINGS_OUT_APP_LOGIN, z10);
    }

    public void setModelPreloadSetting(Context context, String str) {
        Utils.saveString(context, Constant.PREFS_NAME_PRELOAD, KEY_MODEL_PRELOAD_SETTING, str);
    }

    public void setPreloadDefaultSetting(Context context, String str) {
        Utils.saveString(context, Constant.PREFS_NAME_PRELOAD, KEY_PRELOAD_DEFAULT_SETTING, str);
    }

    public void setUseWebViewUnLoginZalo(Context context, boolean z10) {
        Storage.setBoolean(context, KEY_SETTINGS_WEBVIEW, z10);
    }
}
