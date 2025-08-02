package androidx.credentials.webauthn;

import androidx.annotation.RestrictTo;
import g0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AuthenticatorSelectionCriteria {
    private final String authenticatorAttachment;
    private final boolean requireResidentKey;
    private final String residentKey;
    private final String userVerification;

    public AuthenticatorSelectionCriteria(String str, String str2, boolean z10, String str3) {
        m.f(str, "authenticatorAttachment");
        m.f(str2, "residentKey");
        m.f(str3, "userVerification");
        this.authenticatorAttachment = str;
        this.residentKey = str2;
        this.requireResidentKey = z10;
        this.userVerification = str3;
    }

    public static /* synthetic */ AuthenticatorSelectionCriteria copy$default(AuthenticatorSelectionCriteria authenticatorSelectionCriteria, String str, String str2, boolean z10, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = authenticatorSelectionCriteria.authenticatorAttachment;
        }
        if ((i10 & 2) != 0) {
            str2 = authenticatorSelectionCriteria.residentKey;
        }
        if ((i10 & 4) != 0) {
            z10 = authenticatorSelectionCriteria.requireResidentKey;
        }
        if ((i10 & 8) != 0) {
            str3 = authenticatorSelectionCriteria.userVerification;
        }
        return authenticatorSelectionCriteria.copy(str, str2, z10, str3);
    }

    public final String component1() {
        return this.authenticatorAttachment;
    }

    public final String component2() {
        return this.residentKey;
    }

    public final boolean component3() {
        return this.requireResidentKey;
    }

    public final String component4() {
        return this.userVerification;
    }

    public final AuthenticatorSelectionCriteria copy(String str, String str2, boolean z10, String str3) {
        m.f(str, "authenticatorAttachment");
        m.f(str2, "residentKey");
        m.f(str3, "userVerification");
        return new AuthenticatorSelectionCriteria(str, str2, z10, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticatorSelectionCriteria)) {
            return false;
        }
        AuthenticatorSelectionCriteria authenticatorSelectionCriteria = (AuthenticatorSelectionCriteria) obj;
        return m.b(this.authenticatorAttachment, authenticatorSelectionCriteria.authenticatorAttachment) && m.b(this.residentKey, authenticatorSelectionCriteria.residentKey) && this.requireResidentKey == authenticatorSelectionCriteria.requireResidentKey && m.b(this.userVerification, authenticatorSelectionCriteria.userVerification);
    }

    public final String getAuthenticatorAttachment() {
        return this.authenticatorAttachment;
    }

    public final boolean getRequireResidentKey() {
        return this.requireResidentKey;
    }

    public final String getResidentKey() {
        return this.residentKey;
    }

    public final String getUserVerification() {
        return this.userVerification;
    }

    public int hashCode() {
        return (((((this.authenticatorAttachment.hashCode() * 31) + this.residentKey.hashCode()) * 31) + a.a(this.requireResidentKey)) * 31) + this.userVerification.hashCode();
    }

    public String toString() {
        return "AuthenticatorSelectionCriteria(authenticatorAttachment=" + this.authenticatorAttachment + ", residentKey=" + this.residentKey + ", requireResidentKey=" + this.requireResidentKey + ", userVerification=" + this.userVerification + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuthenticatorSelectionCriteria(String str, String str2, boolean z10, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? "preferred" : str3);
    }
}
