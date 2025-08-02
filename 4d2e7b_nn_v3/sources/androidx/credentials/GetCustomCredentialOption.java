package androidx.credentials;

import android.content.ComponentName;
import android.os.Bundle;
import java.util.Set;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public class GetCustomCredentialOption extends CredentialOption {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetCustomCredentialOption(String str, Bundle bundle, Bundle bundle2, boolean z10) {
        this(str, bundle, bundle2, z10, false, (Set) null, 48, (DefaultConstructorMarker) null);
        m.f(str, "type");
        m.f(bundle, "requestData");
        m.f(bundle2, "candidateQueryData");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetCustomCredentialOption(String str, Bundle bundle, Bundle bundle2, boolean z10, boolean z11) {
        this(str, bundle, bundle2, z10, z11, (Set) null, 32, (DefaultConstructorMarker) null);
        m.f(str, "type");
        m.f(bundle, "requestData");
        m.f(bundle2, "candidateQueryData");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetCustomCredentialOption(String str, Bundle bundle, Bundle bundle2, boolean z10, boolean z11, Set set, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bundle, bundle2, z10, (i10 & 16) != 0 ? false : z11, (i10 & 32) != 0 ? r0.d() : set);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetCustomCredentialOption(String str, Bundle bundle, Bundle bundle2, boolean z10, boolean z11, Set<ComponentName> set) {
        super(str, bundle, bundle2, z10, z11, set);
        m.f(str, "type");
        m.f(bundle, "requestData");
        m.f(bundle2, "candidateQueryData");
        m.f(set, "allowedProviders");
        if (str.length() <= 0) {
            throw new IllegalArgumentException("type should not be empty".toString());
        }
    }
}
