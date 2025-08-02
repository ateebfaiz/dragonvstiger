package androidx.credentials.provider;

import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.credentials.provider.utils.PrivilegedApp;
import androidx.credentials.provider.utils.RequestValidationUtil;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import org.json.JSONException;
import org.json.JSONObject;

public final class CallingAppInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "CallingAppInfo";
    private final String origin;
    private final String packageName;
    private final SigningInfo signingInfo;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final SigningInfo f15324a;

        /* renamed from: androidx.credentials.provider.CallingAppInfo$a$a  reason: collision with other inner class name */
        static final class C0194a extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final C0194a f15325a = new C0194a();

            C0194a() {
                super(1);
            }

            public final CharSequence a(byte b10) {
                String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
                m.e(format, "format(this, *args)");
                return format;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).byteValue());
            }
        }

        public a(SigningInfo signingInfo) {
            m.f(signingInfo, "signingInfo");
            this.f15324a = signingInfo;
        }

        private final Set a(Signature[] signatureArr) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Signature byteArray : signatureArr) {
                byte[] digest = MessageDigest.getInstance("SHA-256").digest(byteArray.toByteArray());
                m.e(digest, "digest");
                linkedHashSet.add(j.L(digest, ":", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, C0194a.f15325a, 30, (Object) null));
            }
            return linkedHashSet;
        }

        private final Set b() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (this.f15324a.hasMultipleSigners() && this.f15324a.getApkContentsSigners() != null) {
                Signature[] a10 = this.f15324a.getApkContentsSigners();
                m.e(a10, "signingInfo.apkContentsSigners");
                linkedHashSet.addAll(a(a10));
            } else if (this.f15324a.getSigningCertificateHistory() != null) {
                Signature signature = this.f15324a.getSigningCertificateHistory()[0];
                m.e(signature, "signingInfo.signingCertificateHistory[0]");
                linkedHashSet.addAll(a(new Signature[]{signature}));
            }
            return linkedHashSet;
        }

        public final boolean c(Set set) {
            m.f(set, "candidateSigFingerprints");
            Set b10 = b();
            if (this.f15324a.hasMultipleSigners()) {
                return set.containsAll(b10);
            }
            if (!r.b0(set, b10).isEmpty()) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CallingAppInfo(String str, SigningInfo signingInfo2) {
        this(str, signingInfo2, (String) null, 4, (DefaultConstructorMarker) null);
        m.f(str, "packageName");
        m.f(signingInfo2, "signingInfo");
    }

    private final boolean isAppPrivileged(List<PrivilegedApp> list) {
        for (PrivilegedApp next : list) {
            if (m.b(next.getPackageName(), this.packageName)) {
                return isAppPrivileged(next.getFingerprints());
            }
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final String getOrigin() {
        return this.origin;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final SigningInfo getSigningInfo() {
        return this.signingInfo;
    }

    public final boolean isOriginPopulated() {
        if (this.origin != null) {
            return true;
        }
        return false;
    }

    public CallingAppInfo(String str, SigningInfo signingInfo2, String str2) {
        m.f(str, "packageName");
        m.f(signingInfo2, "signingInfo");
        this.packageName = str;
        this.signingInfo = signingInfo2;
        this.origin = str2;
        if (str.length() <= 0) {
            throw new IllegalArgumentException("packageName must not be empty".toString());
        }
    }

    public final String getOrigin(String str) {
        m.f(str, "privilegedAllowlist");
        if (RequestValidationUtil.Companion.isValidJSON(str)) {
            String str2 = this.origin;
            if (str2 == null) {
                return str2;
            }
            try {
                if (isAppPrivileged(PrivilegedApp.Companion.extractPrivilegedApps$credentials_release(new JSONObject(str)))) {
                    return this.origin;
                }
                throw new IllegalStateException("Origin is not being returned as the calling app did notmatch the privileged allowlist");
            } catch (JSONException unused) {
                throw new IllegalArgumentException("privilegedAllowlist must be formatted properly");
            }
        } else {
            throw new IllegalArgumentException("privilegedAllowlist must not be empty, and must be a valid JSON");
        }
    }

    private final boolean isAppPrivileged(Set<String> set) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new a(this.signingInfo).c(set);
        }
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallingAppInfo(String str, SigningInfo signingInfo2, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, signingInfo2, (i10 & 4) != 0 ? null : str2);
    }
}
