package com.hcaptcha.sdk;

import com.fasterxml.jackson.annotation.m;
import edu.umd.cs.findbugs.annotations.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Serializable;
import java.util.Locale;
import lombok.Generated;
import lombok.NonNull;

public class HCaptchaConfig implements Serializable {
    @m
    @Deprecated
    private String apiEndpoint;
    private String assethost;
    private String customTheme;
    private Boolean diagnosticLog;
    @NonNull
    private Boolean disableHardwareAcceleration;
    private String endpoint;
    private Boolean hideDialog;
    private String host;
    private String imghost;
    private String jsSrc;
    private Boolean loading;
    private String locale;
    private HCaptchaOrientation orientation;
    private String reportapi;
    @Deprecated
    private Boolean resetOnTimeout;
    @m
    private v retryPredicate;
    private String rqdata;
    private Boolean sentry;
    @NonNull
    private String siteKey;
    private HCaptchaSize size;
    private HCaptchaTheme theme;
    private long tokenExpiration;

    public static class a {
        private boolean A;
        private String B;
        private boolean C;
        private Boolean D;
        private boolean E;
        private v F;
        private boolean G;
        private long H;
        private boolean I;
        private Boolean J;
        private boolean K;
        private Boolean L;

        /* renamed from: a  reason: collision with root package name */
        private String f9468a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f9469b;

        /* renamed from: c  reason: collision with root package name */
        private Boolean f9470c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f9471d;

        /* renamed from: e  reason: collision with root package name */
        private Boolean f9472e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f9473f;

        /* renamed from: g  reason: collision with root package name */
        private Boolean f9474g;

        /* renamed from: h  reason: collision with root package name */
        private String f9475h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f9476i;

        /* renamed from: j  reason: collision with root package name */
        private String f9477j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f9478k;

        /* renamed from: l  reason: collision with root package name */
        private String f9479l;

        /* renamed from: m  reason: collision with root package name */
        private String f9480m;

        /* renamed from: n  reason: collision with root package name */
        private String f9481n;

        /* renamed from: o  reason: collision with root package name */
        private String f9482o;

        /* renamed from: p  reason: collision with root package name */
        private String f9483p;

        /* renamed from: q  reason: collision with root package name */
        private boolean f9484q;

        /* renamed from: r  reason: collision with root package name */
        private String f9485r;

        /* renamed from: s  reason: collision with root package name */
        private boolean f9486s;

        /* renamed from: t  reason: collision with root package name */
        private HCaptchaSize f9487t;

        /* renamed from: u  reason: collision with root package name */
        private boolean f9488u;

        /* renamed from: v  reason: collision with root package name */
        private HCaptchaOrientation f9489v;

        /* renamed from: w  reason: collision with root package name */
        private boolean f9490w;

        /* renamed from: x  reason: collision with root package name */
        private HCaptchaTheme f9491x;

        /* renamed from: y  reason: collision with root package name */
        private boolean f9492y;

        /* renamed from: z  reason: collision with root package name */
        private String f9493z;

        public a a(String str) {
            k(str);
            return this;
        }

        public a b(String str) {
            this.f9482o = str;
            return this;
        }

        public HCaptchaConfig c() {
            Boolean bool = this.f9470c;
            if (!this.f9469b) {
                bool = HCaptchaConfig.$default$sentry();
            }
            Boolean bool2 = bool;
            Boolean bool3 = this.f9472e;
            if (!this.f9471d) {
                bool3 = HCaptchaConfig.$default$loading();
            }
            Boolean bool4 = bool3;
            Boolean bool5 = this.f9474g;
            if (!this.f9473f) {
                bool5 = HCaptchaConfig.$default$hideDialog();
            }
            Boolean bool6 = bool5;
            String str = this.f9477j;
            if (!this.f9476i) {
                str = HCaptchaConfig.$default$apiEndpoint();
            }
            String str2 = str;
            String str3 = this.f9479l;
            if (!this.f9478k) {
                str3 = HCaptchaConfig.$default$jsSrc();
            }
            String str4 = str3;
            String str5 = this.f9485r;
            if (!this.f9484q) {
                str5 = HCaptchaConfig.$default$locale();
            }
            String str6 = str5;
            HCaptchaSize hCaptchaSize = this.f9487t;
            if (!this.f9486s) {
                hCaptchaSize = HCaptchaConfig.$default$size();
            }
            HCaptchaSize hCaptchaSize2 = hCaptchaSize;
            HCaptchaOrientation hCaptchaOrientation = this.f9489v;
            if (!this.f9488u) {
                hCaptchaOrientation = HCaptchaConfig.$default$orientation();
            }
            HCaptchaOrientation hCaptchaOrientation2 = hCaptchaOrientation;
            HCaptchaTheme hCaptchaTheme = this.f9491x;
            if (!this.f9490w) {
                hCaptchaTheme = HCaptchaConfig.$default$theme();
            }
            HCaptchaTheme hCaptchaTheme2 = hCaptchaTheme;
            String str7 = this.f9493z;
            if (!this.f9492y) {
                str7 = HCaptchaConfig.$default$host();
            }
            String str8 = str7;
            String str9 = this.B;
            if (!this.A) {
                str9 = HCaptchaConfig.$default$customTheme();
            }
            String str10 = str9;
            Boolean bool7 = this.D;
            if (!this.C) {
                bool7 = HCaptchaConfig.$default$resetOnTimeout();
            }
            Boolean bool8 = bool7;
            v vVar = this.F;
            if (!this.E) {
                vVar = HCaptchaConfig.$default$retryPredicate();
            }
            v vVar2 = vVar;
            long j10 = this.H;
            if (!this.G) {
                j10 = HCaptchaConfig.$default$tokenExpiration();
            }
            long j11 = j10;
            Boolean bool9 = this.J;
            if (!this.I) {
                bool9 = HCaptchaConfig.$default$diagnosticLog();
            }
            Boolean bool10 = bool9;
            Boolean bool11 = this.L;
            if (!this.K) {
                bool11 = HCaptchaConfig.$default$disableHardwareAcceleration();
            }
            return new HCaptchaConfig(this.f9468a, bool2, bool4, bool6, this.f9475h, str2, str4, this.f9480m, this.f9481n, this.f9482o, this.f9483p, str6, hCaptchaSize2, hCaptchaOrientation2, hCaptchaTheme2, str8, str10, bool8, vVar2, j11, bool10, bool11);
        }

        public a d(String str) {
            this.B = str;
            this.A = true;
            return this;
        }

        public a e(Boolean bool) {
            this.J = bool;
            this.I = true;
            return this;
        }

        public a f(Boolean bool) {
            if (bool != null) {
                this.L = bool;
                this.K = true;
                return this;
            }
            throw new NullPointerException("disableHardwareAcceleration is marked non-null but is null");
        }

        public a g(String str) {
            this.f9480m = str;
            return this;
        }

        public a h(Boolean bool) {
            this.f9474g = bool;
            this.f9473f = true;
            return this;
        }

        public a i(String str) {
            this.f9493z = str;
            this.f9492y = true;
            return this;
        }

        public a j(String str) {
            this.f9483p = str;
            return this;
        }

        public a k(String str) {
            this.f9479l = str;
            this.f9478k = true;
            return this;
        }

        public a l(Boolean bool) {
            this.f9472e = bool;
            this.f9471d = true;
            return this;
        }

        public a m(String str) {
            this.f9485r = str;
            this.f9484q = true;
            return this;
        }

        public a n(HCaptchaOrientation hCaptchaOrientation) {
            this.f9489v = hCaptchaOrientation;
            this.f9488u = true;
            return this;
        }

        public a o(String str) {
            this.f9481n = str;
            return this;
        }

        public a p(Boolean bool) {
            this.D = bool;
            this.C = true;
            return this;
        }

        public a q(v vVar) {
            this.F = vVar;
            this.E = true;
            return this;
        }

        public a r(String str) {
            this.f9475h = str;
            return this;
        }

        public a s(Boolean bool) {
            this.f9470c = bool;
            this.f9469b = true;
            return this;
        }

        public a t(String str) {
            if (str != null) {
                this.f9468a = str;
                return this;
            }
            throw new NullPointerException("siteKey is marked non-null but is null");
        }

        public String toString() {
            return "HCaptchaConfig.HCaptchaConfigBuilder(siteKey=" + this.f9468a + ", sentry$value=" + this.f9470c + ", loading$value=" + this.f9472e + ", hideDialog$value=" + this.f9474g + ", rqdata=" + this.f9475h + ", apiEndpoint$value=" + this.f9477j + ", jsSrc$value=" + this.f9479l + ", endpoint=" + this.f9480m + ", reportapi=" + this.f9481n + ", assethost=" + this.f9482o + ", imghost=" + this.f9483p + ", locale$value=" + this.f9485r + ", size$value=" + this.f9487t + ", orientation$value=" + this.f9489v + ", theme$value=" + this.f9491x + ", host$value=" + this.f9493z + ", customTheme$value=" + this.B + ", resetOnTimeout$value=" + this.D + ", retryPredicate$value=" + this.F + ", tokenExpiration$value=" + this.H + ", diagnosticLog$value=" + this.J + ", disableHardwareAcceleration$value=" + this.L + ")";
        }

        public a u(HCaptchaSize hCaptchaSize) {
            this.f9487t = hCaptchaSize;
            this.f9486s = true;
            return this;
        }

        public a v(HCaptchaTheme hCaptchaTheme) {
            this.f9491x = hCaptchaTheme;
            this.f9490w = true;
            return this;
        }

        public a w(long j10) {
            this.H = j10;
            this.G = true;
            return this;
        }
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static String $default$apiEndpoint() {
        return "https://js.hcaptcha.com/1/api.js";
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static String $default$customTheme() {
        return null;
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static Boolean $default$diagnosticLog() {
        return Boolean.FALSE;
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static Boolean $default$disableHardwareAcceleration() {
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static Boolean $default$hideDialog() {
        return Boolean.FALSE;
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static String $default$host() {
        return null;
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static String $default$jsSrc() {
        return "https://js.hcaptcha.com/1/api.js";
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static Boolean $default$loading() {
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static String $default$locale() {
        return Locale.getDefault().getLanguage();
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static HCaptchaOrientation $default$orientation() {
        return HCaptchaOrientation.PORTRAIT;
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static Boolean $default$resetOnTimeout() {
        return Boolean.FALSE;
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static v $default$retryPredicate() {
        return new c();
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static Boolean $default$sentry() {
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static HCaptchaSize $default$size() {
        return HCaptchaSize.INVISIBLE;
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static HCaptchaTheme $default$theme() {
        return HCaptchaTheme.LIGHT;
    }

    /* access modifiers changed from: private */
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public static long $default$tokenExpiration() {
        return 120;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public HCaptchaConfig(@NonNull String str, Boolean bool, Boolean bool2, Boolean bool3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, HCaptchaSize hCaptchaSize, HCaptchaOrientation hCaptchaOrientation, HCaptchaTheme hCaptchaTheme, String str10, String str11, Boolean bool4, v vVar, long j10, Boolean bool5, @NonNull Boolean bool6) {
        String str12 = str;
        Boolean bool7 = bool6;
        if (str12 == null) {
            throw new NullPointerException("siteKey is marked non-null but is null");
        } else if (bool7 != null) {
            this.siteKey = str12;
            this.sentry = bool;
            this.loading = bool2;
            this.hideDialog = bool3;
            this.rqdata = str2;
            this.apiEndpoint = str3;
            this.jsSrc = str4;
            this.endpoint = str5;
            this.reportapi = str6;
            this.assethost = str7;
            this.imghost = str8;
            this.locale = str9;
            this.size = hCaptchaSize;
            this.orientation = hCaptchaOrientation;
            this.theme = hCaptchaTheme;
            this.host = str10;
            this.customTheme = str11;
            this.resetOnTimeout = bool4;
            this.retryPredicate = vVar;
            this.tokenExpiration = j10;
            this.diagnosticLog = bool5;
            this.disableHardwareAcceleration = bool7;
        } else {
            throw new NullPointerException("disableHardwareAcceleration is marked non-null but is null");
        }
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    @edu.umd.cs.findbugs.annotations.NonNull
    public static a builder() {
        return new a();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$$default$retryPredicate$41a513e9$1(HCaptchaConfig hCaptchaConfig, i iVar) {
        if (!Boolean.TRUE.equals(hCaptchaConfig.resetOnTimeout) || iVar.b() != h.SESSION_TIMEOUT) {
            return false;
        }
        return true;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public boolean canEqual(@Nullable Object obj) {
        return obj instanceof HCaptchaConfig;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HCaptchaConfig)) {
            return false;
        }
        HCaptchaConfig hCaptchaConfig = (HCaptchaConfig) obj;
        if (!hCaptchaConfig.canEqual(this) || getTokenExpiration() != hCaptchaConfig.getTokenExpiration()) {
            return false;
        }
        Boolean sentry2 = getSentry();
        Boolean sentry3 = hCaptchaConfig.getSentry();
        if (sentry2 != null ? !sentry2.equals(sentry3) : sentry3 != null) {
            return false;
        }
        Boolean loading2 = getLoading();
        Boolean loading3 = hCaptchaConfig.getLoading();
        if (loading2 != null ? !loading2.equals(loading3) : loading3 != null) {
            return false;
        }
        Boolean hideDialog2 = getHideDialog();
        Boolean hideDialog3 = hCaptchaConfig.getHideDialog();
        if (hideDialog2 != null ? !hideDialog2.equals(hideDialog3) : hideDialog3 != null) {
            return false;
        }
        Boolean resetOnTimeout2 = getResetOnTimeout();
        Boolean resetOnTimeout3 = hCaptchaConfig.getResetOnTimeout();
        if (resetOnTimeout2 != null ? !resetOnTimeout2.equals(resetOnTimeout3) : resetOnTimeout3 != null) {
            return false;
        }
        Boolean diagnosticLog2 = getDiagnosticLog();
        Boolean diagnosticLog3 = hCaptchaConfig.getDiagnosticLog();
        if (diagnosticLog2 != null ? !diagnosticLog2.equals(diagnosticLog3) : diagnosticLog3 != null) {
            return false;
        }
        Boolean disableHardwareAcceleration2 = getDisableHardwareAcceleration();
        Boolean disableHardwareAcceleration3 = hCaptchaConfig.getDisableHardwareAcceleration();
        if (disableHardwareAcceleration2 != null ? !disableHardwareAcceleration2.equals(disableHardwareAcceleration3) : disableHardwareAcceleration3 != null) {
            return false;
        }
        String siteKey2 = getSiteKey();
        String siteKey3 = hCaptchaConfig.getSiteKey();
        if (siteKey2 != null ? !siteKey2.equals(siteKey3) : siteKey3 != null) {
            return false;
        }
        String rqdata2 = getRqdata();
        String rqdata3 = hCaptchaConfig.getRqdata();
        if (rqdata2 != null ? !rqdata2.equals(rqdata3) : rqdata3 != null) {
            return false;
        }
        String apiEndpoint2 = getApiEndpoint();
        String apiEndpoint3 = hCaptchaConfig.getApiEndpoint();
        if (apiEndpoint2 != null ? !apiEndpoint2.equals(apiEndpoint3) : apiEndpoint3 != null) {
            return false;
        }
        String jsSrc2 = getJsSrc();
        String jsSrc3 = hCaptchaConfig.getJsSrc();
        if (jsSrc2 != null ? !jsSrc2.equals(jsSrc3) : jsSrc3 != null) {
            return false;
        }
        String endpoint2 = getEndpoint();
        String endpoint3 = hCaptchaConfig.getEndpoint();
        if (endpoint2 != null ? !endpoint2.equals(endpoint3) : endpoint3 != null) {
            return false;
        }
        String reportapi2 = getReportapi();
        String reportapi3 = hCaptchaConfig.getReportapi();
        if (reportapi2 != null ? !reportapi2.equals(reportapi3) : reportapi3 != null) {
            return false;
        }
        String assethost2 = getAssethost();
        String assethost3 = hCaptchaConfig.getAssethost();
        if (assethost2 != null ? !assethost2.equals(assethost3) : assethost3 != null) {
            return false;
        }
        String imghost2 = getImghost();
        String imghost3 = hCaptchaConfig.getImghost();
        if (imghost2 != null ? !imghost2.equals(imghost3) : imghost3 != null) {
            return false;
        }
        String locale2 = getLocale();
        String locale3 = hCaptchaConfig.getLocale();
        if (locale2 != null ? !locale2.equals(locale3) : locale3 != null) {
            return false;
        }
        HCaptchaSize size2 = getSize();
        HCaptchaSize size3 = hCaptchaConfig.getSize();
        if (size2 != null ? !size2.equals(size3) : size3 != null) {
            return false;
        }
        HCaptchaOrientation orientation2 = getOrientation();
        HCaptchaOrientation orientation3 = hCaptchaConfig.getOrientation();
        if (orientation2 != null ? !orientation2.equals(orientation3) : orientation3 != null) {
            return false;
        }
        HCaptchaTheme theme2 = getTheme();
        HCaptchaTheme theme3 = hCaptchaConfig.getTheme();
        if (theme2 != null ? !theme2.equals(theme3) : theme3 != null) {
            return false;
        }
        String host2 = getHost();
        String host3 = hCaptchaConfig.getHost();
        if (host2 != null ? !host2.equals(host3) : host3 != null) {
            return false;
        }
        String customTheme2 = getCustomTheme();
        String customTheme3 = hCaptchaConfig.getCustomTheme();
        if (customTheme2 != null ? !customTheme2.equals(customTheme3) : customTheme3 != null) {
            return false;
        }
        v retryPredicate2 = getRetryPredicate();
        v retryPredicate3 = hCaptchaConfig.getRetryPredicate();
        if (retryPredicate2 != null ? retryPredicate2.equals(retryPredicate3) : retryPredicate3 == null) {
            return true;
        }
        return false;
    }

    @Deprecated
    public String getApiEndpoint() {
        return this.jsSrc;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public String getAssethost() {
        return this.assethost;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public String getCustomTheme() {
        return this.customTheme;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public Boolean getDiagnosticLog() {
        return this.diagnosticLog;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    @NonNull
    public Boolean getDisableHardwareAcceleration() {
        return this.disableHardwareAcceleration;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public String getEndpoint() {
        return this.endpoint;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public Boolean getHideDialog() {
        return this.hideDialog;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public String getHost() {
        return this.host;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public String getImghost() {
        return this.imghost;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public String getJsSrc() {
        return this.jsSrc;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public Boolean getLoading() {
        return this.loading;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public String getLocale() {
        return this.locale;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public HCaptchaOrientation getOrientation() {
        return this.orientation;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public String getReportapi() {
        return this.reportapi;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    @Deprecated
    public Boolean getResetOnTimeout() {
        return this.resetOnTimeout;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public v getRetryPredicate() {
        return this.retryPredicate;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public String getRqdata() {
        return this.rqdata;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public Boolean getSentry() {
        return this.sentry;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    @NonNull
    public String getSiteKey() {
        return this.siteKey;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public HCaptchaSize getSize() {
        return this.size;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public HCaptchaTheme getTheme() {
        return this.theme;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public long getTokenExpiration() {
        return this.tokenExpiration;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        long tokenExpiration2 = getTokenExpiration();
        Boolean sentry2 = getSentry();
        int i30 = (((int) (tokenExpiration2 ^ (tokenExpiration2 >>> 32))) + 59) * 59;
        int i31 = 43;
        if (sentry2 == null) {
            i10 = 43;
        } else {
            i10 = sentry2.hashCode();
        }
        int i32 = i30 + i10;
        Boolean loading2 = getLoading();
        int i33 = i32 * 59;
        if (loading2 == null) {
            i11 = 43;
        } else {
            i11 = loading2.hashCode();
        }
        int i34 = i33 + i11;
        Boolean hideDialog2 = getHideDialog();
        int i35 = i34 * 59;
        if (hideDialog2 == null) {
            i12 = 43;
        } else {
            i12 = hideDialog2.hashCode();
        }
        int i36 = i35 + i12;
        Boolean resetOnTimeout2 = getResetOnTimeout();
        int i37 = i36 * 59;
        if (resetOnTimeout2 == null) {
            i13 = 43;
        } else {
            i13 = resetOnTimeout2.hashCode();
        }
        int i38 = i37 + i13;
        Boolean diagnosticLog2 = getDiagnosticLog();
        int i39 = i38 * 59;
        if (diagnosticLog2 == null) {
            i14 = 43;
        } else {
            i14 = diagnosticLog2.hashCode();
        }
        int i40 = i39 + i14;
        Boolean disableHardwareAcceleration2 = getDisableHardwareAcceleration();
        int i41 = i40 * 59;
        if (disableHardwareAcceleration2 == null) {
            i15 = 43;
        } else {
            i15 = disableHardwareAcceleration2.hashCode();
        }
        int i42 = i41 + i15;
        String siteKey2 = getSiteKey();
        int i43 = i42 * 59;
        if (siteKey2 == null) {
            i16 = 43;
        } else {
            i16 = siteKey2.hashCode();
        }
        int i44 = i43 + i16;
        String rqdata2 = getRqdata();
        int i45 = i44 * 59;
        if (rqdata2 == null) {
            i17 = 43;
        } else {
            i17 = rqdata2.hashCode();
        }
        int i46 = i45 + i17;
        String apiEndpoint2 = getApiEndpoint();
        int i47 = i46 * 59;
        if (apiEndpoint2 == null) {
            i18 = 43;
        } else {
            i18 = apiEndpoint2.hashCode();
        }
        int i48 = i47 + i18;
        String jsSrc2 = getJsSrc();
        int i49 = i48 * 59;
        if (jsSrc2 == null) {
            i19 = 43;
        } else {
            i19 = jsSrc2.hashCode();
        }
        int i50 = i49 + i19;
        String endpoint2 = getEndpoint();
        int i51 = i50 * 59;
        if (endpoint2 == null) {
            i20 = 43;
        } else {
            i20 = endpoint2.hashCode();
        }
        int i52 = i51 + i20;
        String reportapi2 = getReportapi();
        int i53 = i52 * 59;
        if (reportapi2 == null) {
            i21 = 43;
        } else {
            i21 = reportapi2.hashCode();
        }
        int i54 = i53 + i21;
        String assethost2 = getAssethost();
        int i55 = i54 * 59;
        if (assethost2 == null) {
            i22 = 43;
        } else {
            i22 = assethost2.hashCode();
        }
        int i56 = i55 + i22;
        String imghost2 = getImghost();
        int i57 = i56 * 59;
        if (imghost2 == null) {
            i23 = 43;
        } else {
            i23 = imghost2.hashCode();
        }
        int i58 = i57 + i23;
        String locale2 = getLocale();
        int i59 = i58 * 59;
        if (locale2 == null) {
            i24 = 43;
        } else {
            i24 = locale2.hashCode();
        }
        int i60 = i59 + i24;
        HCaptchaSize size2 = getSize();
        int i61 = i60 * 59;
        if (size2 == null) {
            i25 = 43;
        } else {
            i25 = size2.hashCode();
        }
        int i62 = i61 + i25;
        HCaptchaOrientation orientation2 = getOrientation();
        int i63 = i62 * 59;
        if (orientation2 == null) {
            i26 = 43;
        } else {
            i26 = orientation2.hashCode();
        }
        int i64 = i63 + i26;
        HCaptchaTheme theme2 = getTheme();
        int i65 = i64 * 59;
        if (theme2 == null) {
            i27 = 43;
        } else {
            i27 = theme2.hashCode();
        }
        int i66 = i65 + i27;
        String host2 = getHost();
        int i67 = i66 * 59;
        if (host2 == null) {
            i28 = 43;
        } else {
            i28 = host2.hashCode();
        }
        int i68 = i67 + i28;
        String customTheme2 = getCustomTheme();
        int i69 = i68 * 59;
        if (customTheme2 == null) {
            i29 = 43;
        } else {
            i29 = customTheme2.hashCode();
        }
        int i70 = i69 + i29;
        v retryPredicate2 = getRetryPredicate();
        int i71 = i70 * 59;
        if (retryPredicate2 != null) {
            i31 = retryPredicate2.hashCode();
        }
        return i71 + i31;
    }

    @m
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    @Deprecated
    public void setApiEndpoint(String str) {
        this.apiEndpoint = str;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setAssethost(String str) {
        this.assethost = str;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setCustomTheme(String str) {
        this.customTheme = str;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setDiagnosticLog(Boolean bool) {
        this.diagnosticLog = bool;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setDisableHardwareAcceleration(@NonNull Boolean bool) {
        if (bool != null) {
            this.disableHardwareAcceleration = bool;
            return;
        }
        throw new NullPointerException("disableHardwareAcceleration is marked non-null but is null");
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setEndpoint(String str) {
        this.endpoint = str;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setHideDialog(Boolean bool) {
        this.hideDialog = bool;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setHost(String str) {
        this.host = str;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setImghost(String str) {
        this.imghost = str;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setJsSrc(String str) {
        this.jsSrc = str;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setLoading(Boolean bool) {
        this.loading = bool;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setLocale(String str) {
        this.locale = str;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setOrientation(HCaptchaOrientation hCaptchaOrientation) {
        this.orientation = hCaptchaOrientation;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setReportapi(String str) {
        this.reportapi = str;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    @Deprecated
    public void setResetOnTimeout(Boolean bool) {
        this.resetOnTimeout = bool;
    }

    @m
    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setRetryPredicate(v vVar) {
        this.retryPredicate = vVar;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setRqdata(String str) {
        this.rqdata = str;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setSentry(Boolean bool) {
        this.sentry = bool;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setSiteKey(@NonNull String str) {
        if (str != null) {
            this.siteKey = str;
            return;
        }
        throw new NullPointerException("siteKey is marked non-null but is null");
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setSize(HCaptchaSize hCaptchaSize) {
        this.size = hCaptchaSize;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setTheme(HCaptchaTheme hCaptchaTheme) {
        this.theme = hCaptchaTheme;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    public void setTokenExpiration(long j10) {
        this.tokenExpiration = j10;
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    @edu.umd.cs.findbugs.annotations.NonNull
    public a toBuilder() {
        return new a().t(this.siteKey).s(this.sentry).l(this.loading).h(this.hideDialog).r(this.rqdata).a(this.apiEndpoint).k(this.jsSrc).g(this.endpoint).o(this.reportapi).b(this.assethost).j(this.imghost).m(this.locale).u(this.size).n(this.orientation).v(this.theme).i(this.host).d(this.customTheme).p(this.resetOnTimeout).q(this.retryPredicate).w(this.tokenExpiration).e(this.diagnosticLog).f(this.disableHardwareAcceleration);
    }

    @Generated
    @SuppressFBWarnings(justification = "generated code")
    @edu.umd.cs.findbugs.annotations.NonNull
    public String toString() {
        return "HCaptchaConfig(siteKey=" + getSiteKey() + ", sentry=" + getSentry() + ", loading=" + getLoading() + ", hideDialog=" + getHideDialog() + ", rqdata=" + getRqdata() + ", apiEndpoint=" + getApiEndpoint() + ", jsSrc=" + getJsSrc() + ", endpoint=" + getEndpoint() + ", reportapi=" + getReportapi() + ", assethost=" + getAssethost() + ", imghost=" + getImghost() + ", locale=" + getLocale() + ", size=" + getSize() + ", orientation=" + getOrientation() + ", theme=" + getTheme() + ", host=" + getHost() + ", customTheme=" + getCustomTheme() + ", resetOnTimeout=" + getResetOnTimeout() + ", retryPredicate=" + getRetryPredicate() + ", tokenExpiration=" + getTokenExpiration() + ", diagnosticLog=" + getDiagnosticLog() + ", disableHardwareAcceleration=" + getDisableHardwareAcceleration() + ")";
    }
}
