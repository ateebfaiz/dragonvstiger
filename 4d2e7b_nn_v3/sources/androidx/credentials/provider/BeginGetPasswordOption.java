package androidx.credentials.provider;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.credentials.GetPasswordOption;
import androidx.credentials.PasswordCredential;
import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class BeginGetPasswordOption extends BeginGetCredentialOption {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Set<String> allowedUserIds;

    public static final class Companion {
        private Companion() {
        }

        @VisibleForTesting
        public final BeginGetPasswordOption createForTest(Bundle bundle, String str) {
            m.f(bundle, "data");
            m.f(str, "id");
            return createFrom$credentials_release(bundle, str);
        }

        public final BeginGetPasswordOption createFrom$credentials_release(Bundle bundle, String str) {
            Set set;
            m.f(bundle, "data");
            m.f(str, "id");
            ArrayList<String> stringArrayList = bundle.getStringArrayList(GetPasswordOption.BUNDLE_KEY_ALLOWED_USER_IDS);
            if (stringArrayList == null || (set = r.A0(stringArrayList)) == null) {
                set = r0.d();
            }
            return new BeginGetPasswordOption(set, bundle, str);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BeginGetPasswordOption(Set<String> set, Bundle bundle, String str) {
        super(str, PasswordCredential.TYPE_PASSWORD_CREDENTIAL, bundle);
        m.f(set, "allowedUserIds");
        m.f(bundle, "candidateQueryData");
        m.f(str, "id");
        this.allowedUserIds = set;
    }

    @VisibleForTesting
    public static final BeginGetPasswordOption createForTest(Bundle bundle, String str) {
        return Companion.createForTest(bundle, str);
    }

    public final Set<String> getAllowedUserIds() {
        return this.allowedUserIds;
    }
}
