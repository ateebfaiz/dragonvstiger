package androidx.webkit;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class UserAgentMetadata {
    public static final int BITNESS_DEFAULT = 0;
    private final String mArchitecture;
    private int mBitness;
    private final List<BrandVersion> mBrandVersionList;
    private final String mFullVersion;
    private boolean mMobile;
    private final String mModel;
    private final String mPlatform;
    private final String mPlatformVersion;
    private boolean mWow64;

    public static final class BrandVersion {
        private final String mBrand;
        private final String mFullVersion;
        private final String mMajorVersion;

        public static final class Builder {
            private String mBrand;
            private String mFullVersion;
            private String mMajorVersion;

            public Builder() {
            }

            public BrandVersion build() {
                String str;
                String str2;
                String str3 = this.mBrand;
                if (str3 != null && !str3.trim().isEmpty() && (str = this.mMajorVersion) != null && !str.trim().isEmpty() && (str2 = this.mFullVersion) != null && !str2.trim().isEmpty()) {
                    return new BrandVersion(this.mBrand, this.mMajorVersion, this.mFullVersion);
                }
                throw new IllegalStateException("Brand name, major version and full version should not be null or blank.");
            }

            public Builder setBrand(String str) {
                if (!str.trim().isEmpty()) {
                    this.mBrand = str;
                    return this;
                }
                throw new IllegalArgumentException("Brand should not be blank.");
            }

            public Builder setFullVersion(String str) {
                if (!str.trim().isEmpty()) {
                    this.mFullVersion = str;
                    return this;
                }
                throw new IllegalArgumentException("FullVersion should not be blank.");
            }

            public Builder setMajorVersion(String str) {
                if (!str.trim().isEmpty()) {
                    this.mMajorVersion = str;
                    return this;
                }
                throw new IllegalArgumentException("MajorVersion should not be blank.");
            }

            public Builder(BrandVersion brandVersion) {
                this.mBrand = brandVersion.getBrand();
                this.mMajorVersion = brandVersion.getMajorVersion();
                this.mFullVersion = brandVersion.getFullVersion();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BrandVersion)) {
                return false;
            }
            BrandVersion brandVersion = (BrandVersion) obj;
            if (!Objects.equals(this.mBrand, brandVersion.mBrand) || !Objects.equals(this.mMajorVersion, brandVersion.mMajorVersion) || !Objects.equals(this.mFullVersion, brandVersion.mFullVersion)) {
                return false;
            }
            return true;
        }

        public String getBrand() {
            return this.mBrand;
        }

        public String getFullVersion() {
            return this.mFullVersion;
        }

        public String getMajorVersion() {
            return this.mMajorVersion;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mBrand, this.mMajorVersion, this.mFullVersion});
        }

        public String toString() {
            return this.mBrand + "," + this.mMajorVersion + "," + this.mFullVersion;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        private BrandVersion(String str, String str2, String str3) {
            this.mBrand = str;
            this.mMajorVersion = str2;
            this.mFullVersion = str3;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserAgentMetadata)) {
            return false;
        }
        UserAgentMetadata userAgentMetadata = (UserAgentMetadata) obj;
        if (this.mMobile != userAgentMetadata.mMobile || this.mBitness != userAgentMetadata.mBitness || this.mWow64 != userAgentMetadata.mWow64 || !Objects.equals(this.mBrandVersionList, userAgentMetadata.mBrandVersionList) || !Objects.equals(this.mFullVersion, userAgentMetadata.mFullVersion) || !Objects.equals(this.mPlatform, userAgentMetadata.mPlatform) || !Objects.equals(this.mPlatformVersion, userAgentMetadata.mPlatformVersion) || !Objects.equals(this.mArchitecture, userAgentMetadata.mArchitecture) || !Objects.equals(this.mModel, userAgentMetadata.mModel)) {
            return false;
        }
        return true;
    }

    public String getArchitecture() {
        return this.mArchitecture;
    }

    public int getBitness() {
        return this.mBitness;
    }

    public List<BrandVersion> getBrandVersionList() {
        return this.mBrandVersionList;
    }

    public String getFullVersion() {
        return this.mFullVersion;
    }

    public String getModel() {
        return this.mModel;
    }

    public String getPlatform() {
        return this.mPlatform;
    }

    public String getPlatformVersion() {
        return this.mPlatformVersion;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mBrandVersionList, this.mFullVersion, this.mPlatform, this.mPlatformVersion, this.mArchitecture, this.mModel, Boolean.valueOf(this.mMobile), Integer.valueOf(this.mBitness), Boolean.valueOf(this.mWow64)});
    }

    public boolean isMobile() {
        return this.mMobile;
    }

    public boolean isWow64() {
        return this.mWow64;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    private UserAgentMetadata(List<BrandVersion> list, String str, String str2, String str3, String str4, String str5, boolean z10, int i10, boolean z11) {
        this.mBrandVersionList = list;
        this.mFullVersion = str;
        this.mPlatform = str2;
        this.mPlatformVersion = str3;
        this.mArchitecture = str4;
        this.mModel = str5;
        this.mMobile = z10;
        this.mBitness = i10;
        this.mWow64 = z11;
    }

    public static final class Builder {
        private String mArchitecture;
        private int mBitness = 0;
        private List<BrandVersion> mBrandVersionList = new ArrayList();
        private String mFullVersion;
        private boolean mMobile = true;
        private String mModel;
        private String mPlatform;
        private String mPlatformVersion;
        private boolean mWow64 = false;

        public Builder() {
        }

        public UserAgentMetadata build() {
            return new UserAgentMetadata(this.mBrandVersionList, this.mFullVersion, this.mPlatform, this.mPlatformVersion, this.mArchitecture, this.mModel, this.mMobile, this.mBitness, this.mWow64);
        }

        public Builder setArchitecture(String str) {
            this.mArchitecture = str;
            return this;
        }

        public Builder setBitness(int i10) {
            this.mBitness = i10;
            return this;
        }

        public Builder setBrandVersionList(List<BrandVersion> list) {
            this.mBrandVersionList = list;
            return this;
        }

        public Builder setFullVersion(String str) {
            if (str == null) {
                this.mFullVersion = null;
                return this;
            } else if (!str.trim().isEmpty()) {
                this.mFullVersion = str;
                return this;
            } else {
                throw new IllegalArgumentException("Full version should not be blank.");
            }
        }

        public Builder setMobile(boolean z10) {
            this.mMobile = z10;
            return this;
        }

        public Builder setModel(String str) {
            this.mModel = str;
            return this;
        }

        public Builder setPlatform(String str) {
            if (str == null) {
                this.mPlatform = null;
                return this;
            } else if (!str.trim().isEmpty()) {
                this.mPlatform = str;
                return this;
            } else {
                throw new IllegalArgumentException("Platform should not be blank.");
            }
        }

        public Builder setPlatformVersion(String str) {
            this.mPlatformVersion = str;
            return this;
        }

        public Builder setWow64(boolean z10) {
            this.mWow64 = z10;
            return this;
        }

        public Builder(UserAgentMetadata userAgentMetadata) {
            this.mBrandVersionList = userAgentMetadata.getBrandVersionList();
            this.mFullVersion = userAgentMetadata.getFullVersion();
            this.mPlatform = userAgentMetadata.getPlatform();
            this.mPlatformVersion = userAgentMetadata.getPlatformVersion();
            this.mArchitecture = userAgentMetadata.getArchitecture();
            this.mModel = userAgentMetadata.getModel();
            this.mMobile = userAgentMetadata.isMobile();
            this.mBitness = userAgentMetadata.getBitness();
            this.mWow64 = userAgentMetadata.isWow64();
        }
    }
}
