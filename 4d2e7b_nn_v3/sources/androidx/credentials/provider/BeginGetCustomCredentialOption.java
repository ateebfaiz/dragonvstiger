package androidx.credentials.provider;

import android.os.Bundle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public class BeginGetCustomCredentialOption extends BeginGetCredentialOption {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public final BeginGetCustomCredentialOption createFrom$credentials_release(Bundle bundle, String str, String str2) {
            m.f(bundle, "data");
            m.f(str, "id");
            m.f(str2, "type");
            return new BeginGetCustomCredentialOption(str, str2, bundle);
        }

        public final BeginGetCustomCredentialOption createFromEntrySlice$credentials_release(Bundle bundle, String str, String str2) {
            m.f(bundle, "data");
            m.f(str, "id");
            m.f(str2, "type");
            return new BeginGetCustomCredentialOption(str, str2, bundle);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BeginGetCustomCredentialOption(String str, String str2, Bundle bundle) {
        super(str, str2, bundle);
        m.f(str, "id");
        m.f(str2, "type");
        m.f(bundle, "candidateQueryData");
        if (str.length() <= 0) {
            throw new IllegalArgumentException("id should not be empty".toString());
        } else if (str2.length() <= 0) {
            throw new IllegalArgumentException("type should not be empty".toString());
        }
    }

    public static final BeginGetCustomCredentialOption createFrom$credentials_release(Bundle bundle, String str, String str2) {
        return Companion.createFrom$credentials_release(bundle, str, str2);
    }

    public static final BeginGetCustomCredentialOption createFromEntrySlice$credentials_release(Bundle bundle, String str, String str2) {
        return Companion.createFromEntrySlice$credentials_release(bundle, str, str2);
    }
}
