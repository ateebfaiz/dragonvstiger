package androidx.credentials.provider;

import androidx.credentials.CredentialOption;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class ProviderGetCredentialRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final CallingAppInfo callingAppInfo;
    private final List<CredentialOption> credentialOptions;

    public static final class Companion {
        private Companion() {
        }

        public final ProviderGetCredentialRequest createFrom$credentials_release(List<? extends CredentialOption> list, CallingAppInfo callingAppInfo) {
            m.f(list, "options");
            m.f(callingAppInfo, "callingAppInfo");
            return new ProviderGetCredentialRequest(list, callingAppInfo);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ProviderGetCredentialRequest(List<? extends CredentialOption> list, CallingAppInfo callingAppInfo2) {
        m.f(list, "credentialOptions");
        m.f(callingAppInfo2, "callingAppInfo");
        this.credentialOptions = list;
        this.callingAppInfo = callingAppInfo2;
    }

    public static final ProviderGetCredentialRequest createFrom$credentials_release(List<? extends CredentialOption> list, CallingAppInfo callingAppInfo2) {
        return Companion.createFrom$credentials_release(list, callingAppInfo2);
    }

    public final CallingAppInfo getCallingAppInfo() {
        return this.callingAppInfo;
    }

    public final List<CredentialOption> getCredentialOptions() {
        return this.credentialOptions;
    }
}
