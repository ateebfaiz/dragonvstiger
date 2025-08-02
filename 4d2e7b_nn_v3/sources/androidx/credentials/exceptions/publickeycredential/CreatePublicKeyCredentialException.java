package androidx.credentials.exceptions.publickeycredential;

import androidx.annotation.RestrictTo;
import androidx.credentials.exceptions.CreateCredentialCustomException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public class CreatePublicKeyCredentialException extends CreateCredentialException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String type;

    public static final class Companion {
        private Companion() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final CreateCredentialException createFrom(String str, String str2) {
            m.f(str, "type");
            try {
                if (j.K(str, CreatePublicKeyCredentialDomException.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION, false, 2, (Object) null)) {
                    return CreatePublicKeyCredentialDomException.Companion.createFrom(str, str2);
                }
                throw new FrameworkClassParsingException();
            } catch (FrameworkClassParsingException unused) {
                return new CreateCredentialCustomException(str, str2);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreatePublicKeyCredentialException(String str) {
        this(str, (CharSequence) null, 2, (DefaultConstructorMarker) null);
        m.f(str, "type");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final CreateCredentialException createFrom(String str, String str2) {
        return Companion.createFrom(str, str2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getType() {
        return this.type;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreatePublicKeyCredentialException(String str, CharSequence charSequence, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : charSequence);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreatePublicKeyCredentialException(String str, CharSequence charSequence) {
        super(str, charSequence);
        m.f(str, "type");
        this.type = str;
        if (getType().length() <= 0) {
            throw new IllegalArgumentException("type must not be empty".toString());
        }
    }
}
