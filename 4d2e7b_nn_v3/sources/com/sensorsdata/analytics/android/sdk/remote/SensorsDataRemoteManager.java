package com.sensorsdata.analytics.android.sdk.remote;

import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.SACoreHelper;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;
import com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager;
import com.sensorsdata.analytics.android.sdk.util.Dispatcher;
import java.security.SecureRandom;
import org.json.JSONObject;

public class SensorsDataRemoteManager extends BaseSensorsDataSDKRemoteManager {
    private static final String SHARED_PREF_REQUEST_TIME = "sensorsdata.request.time";
    private static final String SHARED_PREF_REQUEST_TIME_RANDOM = "sensorsdata.request.time.random";
    private static final String TAG = "SA.SensorsDataRemoteManager";
    private volatile boolean mIsInit = true;
    private volatile CountDownTimer mPullSDKConfigCountDownTimer;
    private final SAStoreManager mStorageManager = SAStoreManager.getInstance();

    /* renamed from: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager$RandomTimeType[] r0 = com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType = r0
                com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager$RandomTimeType r1 = com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager$RandomTimeType r1 = com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeClean     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.AnonymousClass4.<clinit>():void");
        }
    }

    public SensorsDataRemoteManager(SensorsDataAPI sensorsDataAPI, SAContextManager sAContextManager) {
        super(sensorsDataAPI, sAContextManager);
        SALog.i(TAG, "Construct a SensorsDataRemoteManager");
    }

    private void cleanRemoteRequestRandomTime() {
        this.mStorageManager.remove(SHARED_PREF_REQUEST_TIME);
        this.mStorageManager.remove(SHARED_PREF_REQUEST_TIME_RANDOM);
    }

    private boolean isRequestValid() {
        try {
            long longValue = this.mStorageManager.getLong(SHARED_PREF_REQUEST_TIME, 0).longValue();
            int integer = this.mStorageManager.getInteger(SHARED_PREF_REQUEST_TIME_RANDOM, 0);
            if (longValue == 0 || integer == 0) {
                return true;
            }
            float elapsedRealtime = (float) (SystemClock.elapsedRealtime() - longValue);
            if (elapsedRealtime <= 0.0f || elapsedRealtime / 1000.0f >= ((float) (integer * 3600))) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void pullSDKConfigCount(boolean z10) {
        if (this.mPullSDKConfigCountDownTimer != null) {
            this.mPullSDKConfigCountDownTimer.cancel();
            this.mPullSDKConfigCountDownTimer = null;
        }
        final boolean z11 = z10;
        this.mPullSDKConfigCountDownTimer = new CountDownTimer(90000, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            public void onFinish() {
            }

            public void onTick(long j10) {
                SensorsDataAPI sensorsDataAPI = SensorsDataRemoteManager.this.mSensorsDataAPI;
                if ((sensorsDataAPI == null || sensorsDataAPI.isNetworkRequestEnable()) && !SensorsDataRemoteManager.this.mContextManager.getInternalConfigs().saConfigOptions.isDisableSDK() && (SensorsDataRemoteManager.this.mContextManager.getInternalConfigs().isRemoteConfigEnabled || SensorsDataRemoteManager.this.mContextManager.getInternalConfigs().saConfigOptions.isEnableEncrypt())) {
                    SensorsDataRemoteManager.this.requestRemoteConfig(z11, (HttpCallback.StringCallback) new HttpCallback.StringCallback() {
                        public void onAfter() {
                        }

                        public void onFailure(int i10, String str) {
                            if (i10 == 304 || i10 == 404) {
                                SensorsDataRemoteManager.this.resetPullSDKConfigTimer();
                            }
                            SALog.i(SensorsDataRemoteManager.TAG, "Remote request failed,responseCode is " + i10 + ",errorMessage is " + str);
                        }

                        public void onResponse(String str) {
                            SensorsDataRemoteManager.this.resetPullSDKConfigTimer();
                            if (!TextUtils.isEmpty(str)) {
                                SensorsDataSDKRemoteConfig sDKRemoteConfig = SensorsDataRemoteManager.this.toSDKRemoteConfig(str);
                                SAModuleManager.getInstance().invokeModuleFunction(Modules.Encrypt.MODULE_NAME, Modules.Encrypt.METHOD_STORE_SECRET_KEY, str);
                                if (SensorsDataRemoteManager.this.mContextManager.getInternalConfigs().isRemoteConfigEnabled) {
                                    SensorsDataRemoteManager.this.setSDKRemoteConfig(sDKRemoteConfig);
                                }
                            }
                            SALog.i(SensorsDataRemoteManager.TAG, "Remote request was successful,response data is " + str);
                        }
                    });
                } else {
                    SALog.i(SensorsDataRemoteManager.TAG, "Close network request or sdk is disable");
                }
            }
        };
        this.mPullSDKConfigCountDownTimer.start();
    }

    private void writeRemoteRequestRandomTime() {
        SAConfigOptions sAConfigOptions = this.mContextManager.getInternalConfigs().saConfigOptions;
        if (sAConfigOptions != null && this.mContextManager.getInternalConfigs().isRemoteConfigEnabled) {
            int minRequestInterval = sAConfigOptions.getMinRequestInterval();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (sAConfigOptions.getMaxRequestInterval() > sAConfigOptions.getMinRequestInterval()) {
                minRequestInterval += new SecureRandom().nextInt((sAConfigOptions.getMaxRequestInterval() - sAConfigOptions.getMinRequestInterval()) + 1);
            }
            this.mStorageManager.setLong(SHARED_PREF_REQUEST_TIME, elapsedRealtime);
            this.mStorageManager.setInteger(SHARED_PREF_REQUEST_TIME_RANDOM, minRequestInterval);
        }
    }

    public void applySDKConfigFromCache() {
        String str;
        try {
            if (this.mIsInit) {
                str = DbAdapter.getInstance().getRemoteConfigFromLocal();
                this.mIsInit = false;
            } else {
                str = DbAdapter.getInstance().getRemoteConfig();
            }
            SensorsDataSDKRemoteConfig sDKRemoteConfig = toSDKRemoteConfig(str);
            if (SALog.isLogEnabled()) {
                SALog.i(TAG, "Cache remote config is " + sDKRemoteConfig.toString());
            }
            if (this.mSensorsDataAPI != null) {
                if (sDKRemoteConfig.isDisableDebugMode()) {
                    this.mSensorsDataAPI.setDebugMode(SensorsDataAPI.DebugMode.DEBUG_OFF);
                    SALog.i(TAG, "Set DebugOff Mode");
                }
                if (sDKRemoteConfig.isDisableSDK()) {
                    try {
                        this.mContextManager.getAnalyticsMessages().flush();
                        SALog.i(TAG, "DisableSDK is true");
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            }
            BaseSensorsDataSDKRemoteManager.mSDKRemoteConfig = sDKRemoteConfig;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void pullSDKConfigFromServer() {
        SAConfigOptions sAConfigOptions = this.mContextManager.getInternalConfigs().saConfigOptions;
        if (sAConfigOptions != null && !sAConfigOptions.isDisableSDK()) {
            if (!this.mContextManager.getInternalConfigs().isRemoteConfigEnabled && !this.mContextManager.getInternalConfigs().saConfigOptions.isEnableEncrypt()) {
                return;
            }
            if (sAConfigOptions.isDisableRandomTimeRequestRemoteConfig() || sAConfigOptions.getMinRequestInterval() > sAConfigOptions.getMaxRequestInterval()) {
                requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeClean, true);
                SALog.i(TAG, "remote config: Request remote config because disableRandomTimeRequestRemoteConfig or minHourInterval greater than maxHourInterval");
            } else if (!isSecretKeyValid()) {
                requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite, false);
                SALog.i(TAG, "remote config: Request remote config because encrypt key is null");
            } else if (isRequestValid()) {
                requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite, true);
                SALog.i(TAG, "remote config: Request remote config because satisfy the random request condition");
            }
        }
    }

    public void requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType randomTimeType, final boolean z10) {
        if (this.mDisableDefaultRemoteConfig) {
            SALog.i(TAG, "disableDefaultRemoteConfig is true");
            return;
        }
        int i10 = AnonymousClass4.$SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType[randomTimeType.ordinal()];
        if (i10 == 1) {
            writeRemoteRequestRandomTime();
        } else if (i10 == 2) {
            cleanRemoteRequestRandomTime();
        }
        Dispatcher.getInstance().post(new Runnable() {
            public void run() {
                try {
                    SensorsDataRemoteManager.this.pullSDKConfigCount(z10);
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public void resetPullSDKConfigTimer() {
        try {
            if (this.mPullSDKConfigCountDownTimer != null) {
                this.mPullSDKConfigCountDownTimer.cancel();
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        } catch (Throwable th) {
            this.mPullSDKConfigCountDownTimer = null;
            throw th;
        }
        this.mPullSDKConfigCountDownTimer = null;
    }

    /* access modifiers changed from: protected */
    public void setSDKRemoteConfig(SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig) {
        try {
            final JSONObject jSONObject = new JSONObject();
            String jSONObject2 = sensorsDataSDKRemoteConfig.toJson().toString();
            jSONObject.put("$app_remote_config", jSONObject2);
            SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                public void run() {
                    SensorsDataRemoteManager.this.mContextManager.trackEvent(new InputData().setEventName("$AppRemoteConfigChanged").setProperties(jSONObject).setEventType(EventType.TRACK));
                }
            });
            this.mContextManager.getAnalyticsMessages().flush();
            DbAdapter.getInstance().commitRemoteConfig(jSONObject2);
            SALog.i(TAG, "Save remote data");
            if (1 == sensorsDataSDKRemoteConfig.getEffectMode()) {
                BaseSensorsDataSDKRemoteManager.mSDKRemoteConfig = sensorsDataSDKRemoteConfig;
                SALog.i(TAG, "The remote configuration takes effect immediately");
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }
}
