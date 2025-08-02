package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.appsflyer.share.LinkGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class AFd1mSDK extends AFd1iSDK<String> {
    private final String AFLogger$LogLevel;
    private final Map<String, String> AFVersionDeclaration;
    private final UUID afErrorLogForExcManagerOnly;
    private final AFc1zSDK afRDLog;
    @Nullable
    private final String afWarnLog;
    @Nullable
    private final LinkGenerator.ResponseListener getLevel;

    public AFd1mSDK(@NonNull AFc1vSDK aFc1vSDK, @NonNull UUID uuid, @NonNull String str, @NonNull Map<String, String> map, @Nullable String str2, @Nullable LinkGenerator.ResponseListener responseListener) {
        super(AFd1rSDK.ONELINK, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, uuid.toString());
        this.afRDLog = aFc1vSDK.values();
        this.afErrorLogForExcManagerOnly = uuid;
        this.AFLogger$LogLevel = str;
        this.AFVersionDeclaration = new HashMap(map);
        this.getLevel = responseListener;
        this.afWarnLog = str2;
    }

    private String afErrorLogForExcManagerOnly() {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_DOMAIN);
        String packageName = this.afRDLog.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName();
        LinkGenerator addParameters = new LinkGenerator("af_app_invites").setBaseURL(this.AFLogger$LogLevel, string, packageName).addParameter("af_siteid", packageName).addParameters(this.AFVersionDeclaration);
        AFb1xSDK.AFInAppEventType();
        String values = AFb1xSDK.values();
        if (values != null) {
            addParameters.setReferrerCustomerId(values);
        }
        return addParameters.generateLink();
    }

    /* access modifiers changed from: protected */
    public final AFc1jSDK<String> AFInAppEventType(@NonNull String str) {
        return this.AFLogger.values(this.AFLogger$LogLevel, this.AFVersionDeclaration, this.afWarnLog, this.afErrorLogForExcManagerOnly, str);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean afRDLog() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean getLevel() {
        return false;
    }

    public final long valueOf() {
        return 3000;
    }

    public final void values() {
        AFd1zSDK<Result> aFd1zSDK;
        super.values();
        LinkGenerator.ResponseListener responseListener = this.getLevel;
        if (responseListener == null) {
            return;
        }
        if (this.valueOf != AFd1tSDK.SUCCESS || (aFd1zSDK = this.afErrorLog) == null) {
            Throwable afInfoLog = afInfoLog();
            if (!(afInfoLog instanceof ParsingException)) {
                responseListener.onResponse(afErrorLogForExcManagerOnly());
            } else if (((ParsingException) afInfoLog).getRawResponse().isSuccessful()) {
                responseListener.onResponseError("Can't parse one link data");
            } else {
                responseListener.onResponse(afErrorLogForExcManagerOnly());
            }
        } else {
            responseListener.onResponse((String) aFd1zSDK.getBody());
        }
    }
}
