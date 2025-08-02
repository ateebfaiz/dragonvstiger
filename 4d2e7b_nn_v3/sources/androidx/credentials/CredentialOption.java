package androidx.credentials;

import android.content.ComponentName;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.credentials.internal.FrameworkClassParsingException;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class CredentialOption {
    public static final String BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED = "androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Set<ComponentName> allowedProviders;
    private final Bundle candidateQueryData;
    private final boolean isAutoSelectAllowed;
    private final boolean isSystemProviderRequired;
    private final Bundle requestData;
    private final String type;

    public static final class Companion {
        private Companion() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final CredentialOption createFrom(String str, Bundle bundle, Bundle bundle2, boolean z10, Set<ComponentName> set) {
            m.f(str, "type");
            m.f(bundle, "requestData");
            m.f(bundle2, "candidateQueryData");
            m.f(set, "allowedProviders");
            try {
                if (m.b(str, PasswordCredential.TYPE_PASSWORD_CREDENTIAL)) {
                    return GetPasswordOption.Companion.createFrom$credentials_release(bundle, set, bundle2);
                }
                if (m.b(str, PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL)) {
                    String string = bundle.getString(PublicKeyCredential.BUNDLE_KEY_SUBTYPE);
                    if (string != null && string.hashCode() == -613058807 && string.equals(GetPublicKeyCredentialOption.BUNDLE_VALUE_SUBTYPE_GET_PUBLIC_KEY_CREDENTIAL_OPTION)) {
                        return GetPublicKeyCredentialOption.Companion.createFrom$credentials_release(bundle, set, bundle2);
                    }
                    throw new FrameworkClassParsingException();
                }
                throw new FrameworkClassParsingException();
            } catch (FrameworkClassParsingException unused) {
                return new GetCustomCredentialOption(str, bundle, bundle2, z10, bundle.getBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", false), set);
            }
        }

        public final boolean extractAutoSelectValue$credentials_release(Bundle bundle) {
            m.f(bundle, "data");
            return bundle.getBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CredentialOption(String str, Bundle bundle, Bundle bundle2, boolean z10, boolean z11, Set<ComponentName> set) {
        m.f(str, "type");
        m.f(bundle, "requestData");
        m.f(bundle2, "candidateQueryData");
        m.f(set, "allowedProviders");
        this.type = str;
        this.requestData = bundle;
        this.candidateQueryData = bundle2;
        this.isSystemProviderRequired = z10;
        this.isAutoSelectAllowed = z11;
        this.allowedProviders = set;
        bundle.putBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", z11);
        bundle2.putBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", z11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final CredentialOption createFrom(String str, Bundle bundle, Bundle bundle2, boolean z10, Set<ComponentName> set) {
        return Companion.createFrom(str, bundle, bundle2, z10, set);
    }

    public final Set<ComponentName> getAllowedProviders() {
        return this.allowedProviders;
    }

    public final Bundle getCandidateQueryData() {
        return this.candidateQueryData;
    }

    public final Bundle getRequestData() {
        return this.requestData;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isAutoSelectAllowed() {
        return this.isAutoSelectAllowed;
    }

    public final boolean isSystemProviderRequired() {
        return this.isSystemProviderRequired;
    }
}
