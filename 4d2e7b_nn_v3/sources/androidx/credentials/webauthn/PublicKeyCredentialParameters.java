package androidx.credentials.webauthn;

import androidx.annotation.RestrictTo;
import g0.c;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class PublicKeyCredentialParameters {
    private final long alg;
    private final String type;

    public PublicKeyCredentialParameters(String str, long j10) {
        m.f(str, "type");
        this.type = str;
        this.alg = j10;
    }

    public static /* synthetic */ PublicKeyCredentialParameters copy$default(PublicKeyCredentialParameters publicKeyCredentialParameters, String str, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = publicKeyCredentialParameters.type;
        }
        if ((i10 & 2) != 0) {
            j10 = publicKeyCredentialParameters.alg;
        }
        return publicKeyCredentialParameters.copy(str, j10);
    }

    public final String component1() {
        return this.type;
    }

    public final long component2() {
        return this.alg;
    }

    public final PublicKeyCredentialParameters copy(String str, long j10) {
        m.f(str, "type");
        return new PublicKeyCredentialParameters(str, j10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublicKeyCredentialParameters)) {
            return false;
        }
        PublicKeyCredentialParameters publicKeyCredentialParameters = (PublicKeyCredentialParameters) obj;
        return m.b(this.type, publicKeyCredentialParameters.type) && this.alg == publicKeyCredentialParameters.alg;
    }

    public final long getAlg() {
        return this.alg;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + c.a(this.alg);
    }

    public String toString() {
        return "PublicKeyCredentialParameters(type=" + this.type + ", alg=" + this.alg + ')';
    }
}
