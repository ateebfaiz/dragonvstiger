package androidx.credentials.exceptions.publickeycredential;

import androidx.annotation.RestrictTo;
import androidx.credentials.exceptions.GetCredentialCustomException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public class GetPublicKeyCredentialException extends GetCredentialException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String type;

    public static final class Companion {
        private Companion() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final GetCredentialException createFrom(String str, String str2) {
            m.f(str, "type");
            try {
                if (j.F(str, GetPublicKeyCredentialDomException.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION, false, 2, (Object) null)) {
                    return GetPublicKeyCredentialDomException.Companion.createFrom(str, str2);
                }
                throw new FrameworkClassParsingException();
            } catch (FrameworkClassParsingException unused) {
                return new GetCredentialCustomException(str, str2);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetPublicKeyCredentialException(String str) {
        this(str, (CharSequence) null, 2, (DefaultConstructorMarker) null);
        m.f(str, "type");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final GetCredentialException createFrom(String str, String str2) {
        return Companion.createFrom(str, str2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getType() {
        return this.type;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetPublicKeyCredentialException(String str, CharSequence charSequence, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : charSequence);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetPublicKeyCredentialException(String str, CharSequence charSequence) {
        super(str, charSequence);
        m.f(str, "type");
        this.type = str;
        if (getType().length() <= 0) {
            throw new IllegalArgumentException("type must not be empty".toString());
        }
    }
}
