package androidx.webkit;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

public class WebViewMediaIntegrityApiStatusConfig {
    public static final int WEBVIEW_MEDIA_INTEGRITY_API_DISABLED = 0;
    public static final int WEBVIEW_MEDIA_INTEGRITY_API_ENABLED = 2;
    public static final int WEBVIEW_MEDIA_INTEGRITY_API_ENABLED_WITHOUT_APP_IDENTITY = 1;
    private final int mDefaultStatus;
    private final Map<String, Integer> mOverrideRules;

    public static final class Builder {
        /* access modifiers changed from: private */
        public final int mDefaultStatus;
        /* access modifiers changed from: private */
        public Map<String, Integer> mOverrideRules = new HashMap();

        public Builder(int i10) {
            this.mDefaultStatus = i10;
        }

        public Builder addOverrideRule(String str, int i10) {
            this.mOverrideRules.put(str, Integer.valueOf(i10));
            return this;
        }

        public WebViewMediaIntegrityApiStatusConfig build() {
            return new WebViewMediaIntegrityApiStatusConfig(this);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder setOverrideRules(Map<String, Integer> map) {
            this.mOverrideRules = map;
            return this;
        }
    }

    public WebViewMediaIntegrityApiStatusConfig(Builder builder) {
        this.mDefaultStatus = builder.mDefaultStatus;
        this.mOverrideRules = builder.mOverrideRules;
    }

    public int getDefaultStatus() {
        return this.mDefaultStatus;
    }

    public Map<String, Integer> getOverrideRules() {
        return this.mOverrideRules;
    }
}
