package androidx.credentials.exceptions.domerrors;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class SyntaxError extends DomError {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_SYNTAX_ERROR = "androidx.credentials.TYPE_SYNTAX_ERROR";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SyntaxError() {
        super(TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_SYNTAX_ERROR);
    }
}
