package androidx.webkit.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.WebViewCompat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class StartupApiFeature {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    @VisibleForTesting
    public static final String METADATA_HOLDER_SERVICE_NAME = "org.chromium.android_webview.services.StartupFeatureMetadataHolder";
    private static final Set<StartupApiFeature> sValues = new HashSet();
    private final String mInternalFeatureValue;
    private final String mPublicFeatureValue;

    public static class NoFramework extends StartupApiFeature {
        NoFramework(String str, String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            return false;
        }
    }

    public static class P extends StartupApiFeature {
        P(String str, String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            if (Build.VERSION.SDK_INT >= 28) {
                return true;
            }
            return false;
        }
    }

    StartupApiFeature(String str, String str2) {
        this.mPublicFeatureValue = str;
        this.mInternalFeatureValue = str2;
        sValues.add(this);
    }

    private static Bundle getMetaDataFromWebViewManifestOrNull(Context context) {
        int i10;
        PackageInfo currentWebViewPackage = WebViewCompat.getCurrentWebViewPackage(context);
        if (currentWebViewPackage == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(currentWebViewPackage.packageName, METADATA_HOLDER_SERVICE_NAME);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33) {
            try {
                return ApiHelperForTiramisu.getServiceInfo(context.getPackageManager(), componentName, ApiHelperForTiramisu.of(640)).metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        } else {
            if (i11 >= 24) {
                i10 = 640;
            } else {
                i10 = 128;
            }
            try {
                return getServiceInfo(context, componentName, i10).metaData;
            } catch (PackageManager.NameNotFoundException unused2) {
                return null;
            }
        }
    }

    private static ServiceInfo getServiceInfo(Context context, ComponentName componentName, int i10) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getServiceInfo(componentName, i10);
    }

    public static Set<StartupApiFeature> values() {
        return Collections.unmodifiableSet(sValues);
    }

    public String getPublicFeatureName() {
        return this.mPublicFeatureValue;
    }

    public boolean isSupported(Context context) {
        if (isSupportedByFramework() || isSupportedByWebView(context)) {
            return true;
        }
        return false;
    }

    public abstract boolean isSupportedByFramework();

    public boolean isSupportedByWebView(Context context) {
        Bundle metaDataFromWebViewManifestOrNull = getMetaDataFromWebViewManifestOrNull(context);
        if (metaDataFromWebViewManifestOrNull == null) {
            return false;
        }
        return metaDataFromWebViewManifestOrNull.containsKey(this.mInternalFeatureValue);
    }
}
