package androidx.webkit;

import androidx.annotation.IntRange;
import androidx.webkit.Profile;

@Profile.ExperimentalUrlPrefetch
public class SpeculativeLoadingConfig {
    public static final int ABSOLUTE_MAX_PREFETCHES = 20;
    public static final int DEFAULT_MAX_PREFETCHES = 10;
    public static final int DEFAULT_TTL_SECS = 60;
    private final int mMaxPrefetches;
    private final int mPrefetchTTLSeconds;

    @Profile.ExperimentalUrlPrefetch
    public static final class Builder {
        private int mMaxPrefetches = 10;
        private int mPrefetchTTLSeconds = 60;

        @Profile.ExperimentalUrlPrefetch
        public SpeculativeLoadingConfig build() {
            return new SpeculativeLoadingConfig(this.mPrefetchTTLSeconds, this.mMaxPrefetches);
        }

        public Builder setMaxPrefetches(@IntRange(from = 1, to = 20) int i10) {
            if (i10 > 20) {
                throw new IllegalArgumentException("Max prefetches cannot exceed20");
            } else if (i10 >= 1) {
                this.mMaxPrefetches = i10;
                return this;
            } else {
                throw new IllegalArgumentException("Max prefetches must be greater than 0");
            }
        }

        public Builder setPrefetchTtlSeconds(@IntRange(from = 1, to = 2147483647L) int i10) {
            if (i10 > 0) {
                this.mPrefetchTTLSeconds = i10;
                return this;
            }
            throw new IllegalArgumentException("Prefetch TTL must be greater than 0");
        }
    }

    @IntRange(from = 1, to = 20)
    public int getMaxPrefetches() {
        return this.mMaxPrefetches;
    }

    @IntRange(from = 1, to = 2147483647L)
    public int getPrefetchTtlSeconds() {
        return this.mPrefetchTTLSeconds;
    }

    private SpeculativeLoadingConfig(int i10, int i11) {
        this.mPrefetchTTLSeconds = i10;
        this.mMaxPrefetches = i11;
    }
}
