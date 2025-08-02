package androidx.credentials.exceptions;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class CreateCredentialCustomException extends CreateCredentialException {
    private final String type;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreateCredentialCustomException(String str) {
        this(str, (CharSequence) null, 2, (DefaultConstructorMarker) null);
        m.f(str, "type");
    }

    public String getType() {
        return this.type;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreateCredentialCustomException(String str, CharSequence charSequence, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : charSequence);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreateCredentialCustomException(String str, CharSequence charSequence) {
        super(str, charSequence);
        m.f(str, "type");
        this.type = str;
        if (getType().length() <= 0) {
            throw new IllegalArgumentException("type must not be empty".toString());
        }
    }
}
