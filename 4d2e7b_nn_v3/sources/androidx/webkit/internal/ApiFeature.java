package androidx.webkit.internal;

import android.os.Build;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class ApiFeature implements ConditionallySupportedFeature {
    private static final Set<ApiFeature> sValues = new HashSet();
    private final String mInternalFeatureValue;
    private final String mPublicFeatureValue;

    public static class M extends ApiFeature {
        M(String str, String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            return true;
        }
    }

    public static class N extends ApiFeature {
        N(String str, String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            if (Build.VERSION.SDK_INT >= 24) {
                return true;
            }
            return false;
        }
    }

    public static class NoFramework extends ApiFeature {
        NoFramework(String str, String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            return false;
        }
    }

    public static class O extends ApiFeature {
        O(String str, String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            if (Build.VERSION.SDK_INT >= 26) {
                return true;
            }
            return false;
        }
    }

    public static class O_MR1 extends ApiFeature {
        O_MR1(String str, String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            if (Build.VERSION.SDK_INT >= 27) {
                return true;
            }
            return false;
        }
    }

    public static class P extends ApiFeature {
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

    public static class Q extends ApiFeature {
        Q(String str, String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return false;
        }
    }

    public static class T extends ApiFeature {
        T(String str, String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            if (Build.VERSION.SDK_INT >= 33) {
                return true;
            }
            return false;
        }
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final Set f16933a = new HashSet(Arrays.asList(WebViewGlueCommunicator.getFactory().getWebViewFeatures()));
    }

    ApiFeature(String str, String str2) {
        this.mPublicFeatureValue = str;
        this.mInternalFeatureValue = str2;
        sValues.add(this);
    }

    @VisibleForTesting
    public static Set<String> getWebViewApkFeaturesForTesting() {
        return a.f16933a;
    }

    public static Set<ApiFeature> values() {
        return Collections.unmodifiableSet(sValues);
    }

    public String getPublicFeatureName() {
        return this.mPublicFeatureValue;
    }

    public boolean isSupported() {
        if (isSupportedByFramework() || isSupportedByWebView()) {
            return true;
        }
        return false;
    }

    public abstract boolean isSupportedByFramework();

    public boolean isSupportedByWebView() {
        return gc.a.b(a.f16933a, this.mInternalFeatureValue);
    }
}
