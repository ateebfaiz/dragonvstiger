package androidx.webkit;

import androidx.webkit.Profile;
import java.util.HashMap;
import java.util.Map;

@Profile.ExperimentalUrlPrefetch
public final class SpeculativeLoadingParameters {
    private final Map<String, String> mAdditionalHeaders;
    private final NoVarySearchHeader mExpectedNoVarySearchHeader;
    private final boolean mIsJavaScriptEnabled;

    public static final class Builder {
        private final Map<String, String> mAdditionalHeaders = new HashMap();
        private NoVarySearchHeader mExpectedNoVarySearchHeader = null;
        private boolean mIsJavaScriptEnabled = false;

        @Profile.ExperimentalUrlPrefetch
        public Builder addAdditionalHeader(String str, String str2) {
            this.mAdditionalHeaders.put(str, str2);
            return this;
        }

        @Profile.ExperimentalUrlPrefetch
        public Builder addAdditionalHeaders(Map<String, String> map) {
            this.mAdditionalHeaders.putAll(map);
            return this;
        }

        @Profile.ExperimentalUrlPrefetch
        public SpeculativeLoadingParameters build() {
            return new SpeculativeLoadingParameters(this.mAdditionalHeaders, this.mExpectedNoVarySearchHeader, this.mIsJavaScriptEnabled);
        }

        @Profile.ExperimentalUrlPrefetch
        public Builder setExpectedNoVarySearchData(NoVarySearchHeader noVarySearchHeader) {
            this.mExpectedNoVarySearchHeader = noVarySearchHeader;
            return this;
        }

        @Profile.ExperimentalUrlPrefetch
        public Builder setJavaScriptEnabled(boolean z10) {
            this.mIsJavaScriptEnabled = z10;
            return this;
        }
    }

    public Map<String, String> getAdditionalHeaders() {
        return this.mAdditionalHeaders;
    }

    public NoVarySearchHeader getExpectedNoVarySearchData() {
        return this.mExpectedNoVarySearchHeader;
    }

    public boolean isJavaScriptEnabled() {
        return this.mIsJavaScriptEnabled;
    }

    private SpeculativeLoadingParameters(Map<String, String> map, NoVarySearchHeader noVarySearchHeader, boolean z10) {
        this.mAdditionalHeaders = map;
        this.mExpectedNoVarySearchHeader = noVarySearchHeader;
        this.mIsJavaScriptEnabled = z10;
    }
}
