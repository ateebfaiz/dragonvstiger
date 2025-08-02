package androidx.credentials;

import android.content.ComponentName;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.credentials.internal.FrameworkClassParsingException;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class GetCredentialRequest {
    private static final String BUNDLE_KEY_PREFER_IDENTITY_DOC_UI = "androidx.credentials.BUNDLE_KEY_PREFER_IDENTITY_DOC_UI";
    public static final String BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS = "androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS";
    private static final String BUNDLE_KEY_PREFER_UI_BRANDING_COMPONENT_NAME = "androidx.credentials.BUNDLE_KEY_PREFER_UI_BRANDING_COMPONENT_NAME";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<CredentialOption> credentialOptions;
    private final String origin;
    private final boolean preferIdentityDocUi;
    private final boolean preferImmediatelyAvailableCredentials;
    private final ComponentName preferUiBrandingComponentName;

    public static final class Builder {
        private List<CredentialOption> credentialOptions = new ArrayList();
        private String origin;
        private boolean preferIdentityDocUi;
        private boolean preferImmediatelyAvailableCredentials;
        private ComponentName preferUiBrandingComponentName;

        public final Builder addCredentialOption(CredentialOption credentialOption) {
            m.f(credentialOption, "credentialOption");
            this.credentialOptions.add(credentialOption);
            return this;
        }

        public final GetCredentialRequest build() {
            return new GetCredentialRequest(r.w0(this.credentialOptions), this.origin, this.preferIdentityDocUi, this.preferUiBrandingComponentName, this.preferImmediatelyAvailableCredentials);
        }

        public final Builder setCredentialOptions(List<? extends CredentialOption> list) {
            m.f(list, "credentialOptions");
            this.credentialOptions = r.y0(list);
            return this;
        }

        public final Builder setOrigin(String str) {
            m.f(str, "origin");
            this.origin = str;
            return this;
        }

        public final Builder setPreferIdentityDocUi(boolean z10) {
            this.preferIdentityDocUi = z10;
            return this;
        }

        public final Builder setPreferImmediatelyAvailableCredentials(boolean z10) {
            this.preferImmediatelyAvailableCredentials = z10;
            return this;
        }

        public final Builder setPreferUiBrandingComponentName(ComponentName componentName) {
            this.preferUiBrandingComponentName = componentName;
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final GetCredentialRequest createFrom(List<? extends CredentialOption> list, String str, Bundle bundle) {
            m.f(list, "credentialOptions");
            m.f(bundle, "data");
            try {
                boolean z10 = bundle.getBoolean(GetCredentialRequest.BUNDLE_KEY_PREFER_IDENTITY_DOC_UI);
                Builder preferImmediatelyAvailableCredentials = new Builder().setCredentialOptions(list).setPreferIdentityDocUi(z10).setPreferUiBrandingComponentName((ComponentName) bundle.getParcelable(GetCredentialRequest.BUNDLE_KEY_PREFER_UI_BRANDING_COMPONENT_NAME)).setPreferImmediatelyAvailableCredentials(bundle.getBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS"));
                if (str != null) {
                    preferImmediatelyAvailableCredentials.setOrigin(str);
                }
                return preferImmediatelyAvailableCredentials.build();
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final Bundle toRequestDataBundle(GetCredentialRequest getCredentialRequest) {
            m.f(getCredentialRequest, "request");
            Bundle bundle = new Bundle();
            bundle.putBoolean(GetCredentialRequest.BUNDLE_KEY_PREFER_IDENTITY_DOC_UI, getCredentialRequest.getPreferIdentityDocUi());
            bundle.putBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", getCredentialRequest.preferImmediatelyAvailableCredentials());
            bundle.putParcelable(GetCredentialRequest.BUNDLE_KEY_PREFER_UI_BRANDING_COMPONENT_NAME, getCredentialRequest.getPreferUiBrandingComponentName());
            return bundle;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetCredentialRequest(List<? extends CredentialOption> list) {
        this(list, (String) null, false, (ComponentName) null, false, 30, (DefaultConstructorMarker) null);
        m.f(list, "credentialOptions");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final GetCredentialRequest createFrom(List<? extends CredentialOption> list, String str, Bundle bundle) {
        return Companion.createFrom(list, str, bundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Bundle toRequestDataBundle(GetCredentialRequest getCredentialRequest) {
        return Companion.toRequestDataBundle(getCredentialRequest);
    }

    public final List<CredentialOption> getCredentialOptions() {
        return this.credentialOptions;
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final boolean getPreferIdentityDocUi() {
        return this.preferIdentityDocUi;
    }

    public final ComponentName getPreferUiBrandingComponentName() {
        return this.preferUiBrandingComponentName;
    }

    public final boolean preferImmediatelyAvailableCredentials() {
        return this.preferImmediatelyAvailableCredentials;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetCredentialRequest(List<? extends CredentialOption> list, String str) {
        this(list, str, false, (ComponentName) null, false, 28, (DefaultConstructorMarker) null);
        m.f(list, "credentialOptions");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetCredentialRequest(List<? extends CredentialOption> list, String str, boolean z10) {
        this(list, str, z10, (ComponentName) null, false, 24, (DefaultConstructorMarker) null);
        m.f(list, "credentialOptions");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetCredentialRequest(List<? extends CredentialOption> list, String str, boolean z10, ComponentName componentName) {
        this(list, str, z10, componentName, false, 16, (DefaultConstructorMarker) null);
        m.f(list, "credentialOptions");
    }

    public GetCredentialRequest(List<? extends CredentialOption> list, String str, boolean z10, ComponentName componentName, boolean z11) {
        m.f(list, "credentialOptions");
        this.credentialOptions = list;
        this.origin = str;
        this.preferIdentityDocUi = z10;
        this.preferUiBrandingComponentName = componentName;
        this.preferImmediatelyAvailableCredentials = z11;
        if (!(!list.isEmpty())) {
            throw new IllegalArgumentException("credentialOptions should not be empty".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetCredentialRequest(List list, String str, boolean z10, ComponentName componentName, boolean z11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? null : componentName, (i10 & 16) != 0 ? false : z11);
    }
}
