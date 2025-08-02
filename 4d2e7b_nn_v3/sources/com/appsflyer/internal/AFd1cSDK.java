package com.appsflyer.internal;

import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.util.Map;
import java.util.UUID;

public final class AFd1cSDK extends AFd1iSDK<Map<String, String>> {
    private String AFLogger$LogLevel;
    private final boolean AFVersionDeclaration;
    private String afErrorLogForExcManagerOnly;
    @Nullable
    public AFa1vSDK afRDLog;
    private final AFc1kSDK afWarnLog;
    private String getLevel;
    private final UUID onInstallConversionFailureNative;

    public interface AFa1vSDK {
        void valueOf(String str);

        void valueOf(Map<String, String> map);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFd1cSDK(@NonNull AFc1vSDK aFc1vSDK, @NonNull UUID uuid, @NonNull Uri uri) {
        super(AFd1rSDK.ONELINK, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, uuid.toString());
        Throwable cause;
        boolean z10 = false;
        this.afWarnLog = aFc1vSDK.AFInAppEventType();
        this.onInstallConversionFailureNative = uuid;
        if (!AFb1mSDK.valueOf(uri.getHost()) && !AFb1mSDK.valueOf(uri.getPath())) {
            try {
                try {
                    Object invoke = ((Class) AFb1lSDK.AFInAppEventParameterName(TextUtils.getCapsMode("", 0, 0) + 37, -1 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((SystemClock.currentThreadTimeMillis() > -1 ? 1 : (SystemClock.currentThreadTimeMillis() == -1 ? 0 : -1)) + 46477))).getMethod("valueOf", (Class[]) null).invoke(((Class) AFb1lSDK.AFInAppEventParameterName(TextUtils.indexOf("", "", 0, 0) + 37, -1 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (((Process.getThreadPriority(0) + 20) >> 6) + 46478))).getDeclaredConstructor(new Class[]{Uri.class}).newInstance(new Object[]{uri}), (Object[]) null);
                    try {
                        boolean booleanValue = ((Boolean) ((Class) AFb1lSDK.AFInAppEventParameterName((ViewConfiguration.getScrollBarSize() >> 8) + 52, TextUtils.indexOf("", '0', 0) + 38, (char) (-1 - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("AFKeystoreWrapper", (Class[]) null).invoke(invoke, (Object[]) null)).booleanValue();
                        try {
                            z10 = ((Boolean) ((Class) AFb1lSDK.AFInAppEventParameterName(52 - (ViewConfiguration.getTapTimeout() >> 16), TextUtils.lastIndexOf("", '0', 0, 0) + 38, (char) (TextUtils.indexOf("", '0', 0, 0) + 1))).getMethod("valueOf", (Class[]) null).invoke(invoke, (Object[]) null)).booleanValue();
                            String[] split = uri.getPath().split(DomExceptionUtils.SEPARATOR);
                            if (booleanValue && split.length == 3) {
                                this.AFLogger$LogLevel = split[1];
                                this.afErrorLogForExcManagerOnly = split[2];
                                this.getLevel = uri.toString();
                            }
                        } catch (Throwable th) {
                            if (cause != null) {
                                throw cause;
                            }
                            throw th;
                        }
                    } finally {
                        cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                    }
                } finally {
                    Throwable cause2 = th.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                }
            } finally {
                Throwable cause3 = th.getCause();
                if (cause3 != null) {
                    throw cause3;
                }
            }
        }
        this.AFVersionDeclaration = z10;
    }

    /* access modifiers changed from: protected */
    public final AFc1jSDK<Map<String, String>> AFInAppEventType(@NonNull String str) {
        return this.afWarnLog.values(this.AFLogger$LogLevel, this.afErrorLogForExcManagerOnly, this.onInstallConversionFailureNative, str);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    public final boolean AFVersionDeclaration() {
        return this.AFVersionDeclaration;
    }

    public final boolean afErrorLogForExcManagerOnly() {
        if (TextUtils.isEmpty(this.AFLogger$LogLevel) || TextUtils.isEmpty(this.afErrorLogForExcManagerOnly) || this.AFLogger$LogLevel.equals("app")) {
            return false;
        }
        return true;
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
        AFa1vSDK aFa1vSDK = this.afRDLog;
        if (aFa1vSDK == null) {
            return;
        }
        if (this.valueOf != AFd1tSDK.SUCCESS || (aFd1zSDK = this.afErrorLog) == null) {
            Throwable afInfoLog = afInfoLog();
            String str = "Can't get OneLink data";
            if (!(afInfoLog instanceof ParsingException)) {
                String str2 = this.getLevel;
                if (str2 != null) {
                    str = str2;
                }
                aFa1vSDK.valueOf(str);
            } else if (((ParsingException) afInfoLog).getRawResponse().isSuccessful()) {
                aFa1vSDK.valueOf("Can't parse one link data");
            } else {
                String str3 = this.getLevel;
                if (str3 != null) {
                    str = str3;
                }
                aFa1vSDK.valueOf(str);
            }
        } else {
            aFa1vSDK.valueOf((Map<String, String>) (Map) aFd1zSDK.getBody());
        }
    }
}
