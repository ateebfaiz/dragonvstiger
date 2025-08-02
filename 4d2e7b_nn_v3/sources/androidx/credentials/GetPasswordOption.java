package androidx.credentials;

import android.content.ComponentName;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class GetPasswordOption extends CredentialOption {
    public static final String BUNDLE_KEY_ALLOWED_USER_IDS = "androidx.credentials.BUNDLE_KEY_ALLOWED_USER_IDS";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Set<String> allowedUserIds;

    public static final class Companion {
        private Companion() {
        }

        public final GetPasswordOption createFrom$credentials_release(Bundle bundle, Set<ComponentName> set, Bundle bundle2) {
            Set d10;
            m.f(bundle, "data");
            m.f(set, "allowedProviders");
            m.f(bundle2, "candidateQueryData");
            ArrayList<String> stringArrayList = bundle.getStringArrayList(GetPasswordOption.BUNDLE_KEY_ALLOWED_USER_IDS);
            if (stringArrayList == null || (d10 = r.A0(stringArrayList)) == null) {
                d10 = r0.d();
            }
            return new GetPasswordOption(d10, bundle.getBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", false), set, bundle, bundle2, (DefaultConstructorMarker) null);
        }

        public final Bundle toBundle$credentials_release(Set<String> set) {
            m.f(set, "allowUserIds");
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(GetPasswordOption.BUNDLE_KEY_ALLOWED_USER_IDS, new ArrayList(set));
            return bundle;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GetPasswordOption() {
        this((Set) null, false, (Set) null, 7, (DefaultConstructorMarker) null);
    }

    public static final GetPasswordOption createFrom$credentials_release(Bundle bundle, Set<ComponentName> set, Bundle bundle2) {
        return Companion.createFrom$credentials_release(bundle, set, bundle2);
    }

    public static final Bundle toBundle$credentials_release(Set<String> set) {
        return Companion.toBundle$credentials_release(set);
    }

    public final Set<String> getAllowedUserIds() {
        return this.allowedUserIds;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetPasswordOption(Set<String> set) {
        this((Set) set, false, (Set) null, 6, (DefaultConstructorMarker) null);
        m.f(set, "allowedUserIds");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetPasswordOption(Set<String> set, boolean z10) {
        this((Set) set, z10, (Set) null, 4, (DefaultConstructorMarker) null);
        m.f(set, "allowedUserIds");
    }

    public /* synthetic */ GetPasswordOption(Set set, boolean z10, Set set2, Bundle bundle, Bundle bundle2, DefaultConstructorMarker defaultConstructorMarker) {
        this((Set<String>) set, z10, (Set<ComponentName>) set2, bundle, bundle2);
    }

    private GetPasswordOption(Set<String> set, boolean z10, Set<ComponentName> set2, Bundle bundle, Bundle bundle2) {
        super(PasswordCredential.TYPE_PASSWORD_CREDENTIAL, bundle, bundle2, false, z10, set2);
        this.allowedUserIds = set;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetPasswordOption(Set set, boolean z10, Set set2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? r0.d() : set, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? r0.d() : set2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GetPasswordOption(java.util.Set<java.lang.String> r8, boolean r9, java.util.Set<android.content.ComponentName> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "allowedUserIds"
            kotlin.jvm.internal.m.f(r8, r0)
            java.lang.String r0 = "allowedProviders"
            kotlin.jvm.internal.m.f(r10, r0)
            androidx.credentials.GetPasswordOption$Companion r0 = Companion
            android.os.Bundle r5 = r0.toBundle$credentials_release(r8)
            android.os.Bundle r6 = r0.toBundle$credentials_release(r8)
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r1.<init>((java.util.Set<java.lang.String>) r2, (boolean) r3, (java.util.Set<android.content.ComponentName>) r4, (android.os.Bundle) r5, (android.os.Bundle) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.GetPasswordOption.<init>(java.util.Set, boolean, java.util.Set):void");
    }
}
