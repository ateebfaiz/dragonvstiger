package com.adjust.sdk;

import android.content.Context;
import com.adjust.sdk.AdjustInstance;

public class AdjustConfig {
    public static final String AD_REVENUE_ADMOB = "admob_sdk";
    public static final String AD_REVENUE_ADMOST = "admost_sdk";
    public static final String AD_REVENUE_APPLOVIN_MAX = "applovin_max_sdk";
    public static final String AD_REVENUE_HELIUM_CHARTBOOST = "helium_chartboost_sdk";
    public static final String AD_REVENUE_IRONSOURCE = "ironsource_sdk";
    public static final String AD_REVENUE_MOPUB = "mopub";
    public static final String AD_REVENUE_SOURCE_PUBLISHER = "publisher_sdk";
    public static final String AD_REVENUE_UNITY = "unity_sdk";
    public static final String DATA_RESIDENCY_EU = "data_residency_eu";
    public static final String DATA_RESIDENCY_TR = "data_residency_tr";
    public static final String DATA_RESIDENCY_US = "data_residency_us";
    public static final String ENVIRONMENT_PRODUCTION = "production";
    public static final String ENVIRONMENT_SANDBOX = "sandbox";
    public static final String URL_STRATEGY_CHINA = "url_strategy_china";
    public static final String URL_STRATEGY_INDIA = "url_strategy_india";
    public String appSecret;
    public String appToken;
    public String basePath;
    public Context context;
    public boolean coppaCompliantEnabled;
    public Class deepLinkComponent;
    public String defaultTracker;
    public Double delayStart;
    public Boolean deviceKnown;
    public String environment;
    public boolean eventBufferingEnabled;
    public String externalDeviceId;
    public String gdprPath;
    public ILogger logger;
    public Boolean needsCost;
    public OnAttributionChangedListener onAttributionChangedListener;
    public OnDeeplinkResponseListener onDeeplinkResponseListener;
    public OnEventTrackingFailedListener onEventTrackingFailedListener;
    public OnEventTrackingSucceededListener onEventTrackingSucceededListener;
    public OnSessionTrackingFailedListener onSessionTrackingFailedListener;
    public OnSessionTrackingSucceededListener onSessionTrackingSucceededListener;
    public boolean playStoreKidsAppEnabled;
    public AdjustInstance.PreLaunchActions preLaunchActions;
    public String preinstallFilePath;
    public boolean preinstallTrackingEnabled;
    public String processName;
    public String pushToken;
    public String sdkPrefix;
    public String secretId;
    public boolean sendInBackground;
    public Boolean startEnabled;
    public boolean startOffline;
    public String subscriptionPath;
    public String urlStrategy;
    public String userAgent;

    public AdjustConfig(Context context2, String str, String str2) {
        init(context2, str, str2, false);
    }

    private boolean checkAppToken(String str) {
        if (str == null) {
            this.logger.error("Missing App Token", new Object[0]);
            return false;
        } else if (str.length() == 12) {
            return true;
        } else {
            this.logger.error("Malformed App Token '%s'", str);
            return false;
        }
    }

    private boolean checkContext(Context context2) {
        if (context2 == null) {
            this.logger.error("Missing context", new Object[0]);
            return false;
        } else if (Util.checkPermission(context2, "android.permission.INTERNET")) {
            return true;
        } else {
            this.logger.error("Missing permission: INTERNET", new Object[0]);
            return false;
        }
    }

    private boolean checkEnvironment(String str) {
        if (str == null) {
            this.logger.error("Missing environment", new Object[0]);
            return false;
        } else if (str.equals(ENVIRONMENT_SANDBOX)) {
            this.logger.warnInProduction("SANDBOX: Adjust is running in Sandbox mode. Use this setting for testing. Don't forget to set the environment to `production` before publishing!", new Object[0]);
            return true;
        } else if (str.equals(ENVIRONMENT_PRODUCTION)) {
            this.logger.warnInProduction("PRODUCTION: Adjust is running in Production mode. Use this setting only for the build that you want to publish. Set the environment to `sandbox` if you want to test your app!", new Object[0]);
            return true;
        } else {
            this.logger.error("Unknown environment '%s'", str);
            return false;
        }
    }

    private void init(Context context2, String str, String str2, boolean z10) {
        this.logger = AdjustFactory.getLogger();
        setLogLevel((!z10 || !ENVIRONMENT_PRODUCTION.equals(str2)) ? LogLevel.INFO : LogLevel.SUPRESS, str2);
        if (context2 != null) {
            context2 = context2.getApplicationContext();
        }
        this.context = context2;
        this.appToken = str;
        this.environment = str2;
        this.eventBufferingEnabled = false;
        this.sendInBackground = false;
        this.preinstallTrackingEnabled = false;
    }

    public boolean isValid() {
        return checkAppToken(this.appToken) && checkEnvironment(this.environment) && checkContext(this.context);
    }

    public void setAppSecret(long j10, long j11, long j12, long j13, long j14) {
        this.secretId = Util.formatString("%d", Long.valueOf(j10));
        this.appSecret = Util.formatString("%d%d%d%d", Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13), Long.valueOf(j14));
    }

    public void setCoppaCompliantEnabled(boolean z10) {
        this.coppaCompliantEnabled = z10;
    }

    public void setDeepLinkComponent(Class cls) {
        this.deepLinkComponent = cls;
    }

    public void setDefaultTracker(String str) {
        this.defaultTracker = str;
    }

    public void setDelayStart(double d10) {
        this.delayStart = Double.valueOf(d10);
    }

    public void setDeviceKnown(boolean z10) {
        this.deviceKnown = Boolean.valueOf(z10);
    }

    public void setEventBufferingEnabled(Boolean bool) {
        this.eventBufferingEnabled = bool == null ? false : bool.booleanValue();
    }

    public void setExternalDeviceId(String str) {
        this.externalDeviceId = str;
    }

    public void setLogLevel(LogLevel logLevel) {
        setLogLevel(logLevel, this.environment);
    }

    public void setNeedsCost(boolean z10) {
        this.needsCost = Boolean.valueOf(z10);
    }

    public void setOnAttributionChangedListener(OnAttributionChangedListener onAttributionChangedListener2) {
        this.onAttributionChangedListener = onAttributionChangedListener2;
    }

    public void setOnDeeplinkResponseListener(OnDeeplinkResponseListener onDeeplinkResponseListener2) {
        this.onDeeplinkResponseListener = onDeeplinkResponseListener2;
    }

    public void setOnEventTrackingFailedListener(OnEventTrackingFailedListener onEventTrackingFailedListener2) {
        this.onEventTrackingFailedListener = onEventTrackingFailedListener2;
    }

    public void setOnEventTrackingSucceededListener(OnEventTrackingSucceededListener onEventTrackingSucceededListener2) {
        this.onEventTrackingSucceededListener = onEventTrackingSucceededListener2;
    }

    public void setOnSessionTrackingFailedListener(OnSessionTrackingFailedListener onSessionTrackingFailedListener2) {
        this.onSessionTrackingFailedListener = onSessionTrackingFailedListener2;
    }

    public void setOnSessionTrackingSucceededListener(OnSessionTrackingSucceededListener onSessionTrackingSucceededListener2) {
        this.onSessionTrackingSucceededListener = onSessionTrackingSucceededListener2;
    }

    public void setPlayStoreKidsAppEnabled(boolean z10) {
        this.playStoreKidsAppEnabled = z10;
    }

    public void setPreinstallFilePath(String str) {
        this.preinstallFilePath = str;
    }

    public void setPreinstallTrackingEnabled(boolean z10) {
        this.preinstallTrackingEnabled = z10;
    }

    public void setProcessName(String str) {
        this.processName = str;
    }

    @Deprecated
    public void setReadMobileEquipmentIdentity(boolean z10) {
        this.logger.warn("This method has been deprecated and shouldn't be used anymore", new Object[0]);
    }

    public void setSdkPrefix(String str) {
        this.sdkPrefix = str;
    }

    public void setSendInBackground(boolean z10) {
        this.sendInBackground = z10;
    }

    public void setUrlStrategy(String str) {
        if (str == null || str.isEmpty()) {
            this.logger.error("Invalid url strategy", new Object[0]);
            return;
        }
        if (!str.equals(URL_STRATEGY_INDIA) && !str.equals(URL_STRATEGY_CHINA) && !str.equals(DATA_RESIDENCY_EU) && !str.equals(DATA_RESIDENCY_TR) && !str.equals(DATA_RESIDENCY_US)) {
            this.logger.warn("Unrecognised url strategy %s", str);
        }
        this.urlStrategy = str;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public AdjustConfig(Context context2, String str, String str2, boolean z10) {
        init(context2, str, str2, z10);
    }

    private void setLogLevel(LogLevel logLevel, String str) {
        this.logger.setLogLevel(logLevel, ENVIRONMENT_PRODUCTION.equals(str));
    }
}
