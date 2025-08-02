package androidx.credentials.exceptions;

import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class ClearCredentialException extends Exception {
    private final CharSequence errorMessage;
    private final String type;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ClearCredentialException(String str) {
        this(str, (CharSequence) null, 2, (DefaultConstructorMarker) null);
        m.f(str, "type");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence getErrorMessage() {
        return this.errorMessage;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getType() {
        return this.type;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClearCredentialException(String str, CharSequence charSequence, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : charSequence);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClearCredentialException(String str, CharSequence charSequence) {
        super(charSequence != null ? charSequence.toString() : null);
        m.f(str, "type");
        this.type = str;
        this.errorMessage = charSequence;
    }
}
