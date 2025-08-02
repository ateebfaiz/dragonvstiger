package androidx.credentials.provider;

import android.os.Bundle;
import androidx.credentials.PasswordCredential;
import androidx.credentials.PublicKeyCredential;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class BeginGetCredentialOption {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Bundle candidateQueryData;

    /* renamed from: id  reason: collision with root package name */
    private final String f15321id;
    private final String type;

    public static final class Companion {
        private Companion() {
        }

        public final BeginGetCredentialOption createFrom$credentials_release(String str, String str2, Bundle bundle) {
            m.f(str, "id");
            m.f(str2, "type");
            m.f(bundle, "candidateQueryData");
            if (m.b(str2, PasswordCredential.TYPE_PASSWORD_CREDENTIAL)) {
                return BeginGetPasswordOption.Companion.createFrom$credentials_release(bundle, str);
            }
            if (m.b(str2, PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL)) {
                return BeginGetPublicKeyCredentialOption.Companion.createFrom$credentials_release(bundle, str);
            }
            return new BeginGetCustomCredentialOption(str, str2, bundle);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BeginGetCredentialOption(String str, String str2, Bundle bundle) {
        m.f(str, "id");
        m.f(str2, "type");
        m.f(bundle, "candidateQueryData");
        this.f15321id = str;
        this.type = str2;
        this.candidateQueryData = bundle;
    }

    public static final BeginGetCredentialOption createFrom$credentials_release(String str, String str2, Bundle bundle) {
        return Companion.createFrom$credentials_release(str, str2, bundle);
    }

    public final Bundle getCandidateQueryData() {
        return this.candidateQueryData;
    }

    public final String getId() {
        return this.f15321id;
    }

    public final String getType() {
        return this.type;
    }
}
