package com.google.android.libraries.identity.googleid;

public final class GoogleIdTokenParsingException extends Exception {
    public GoogleIdTokenParsingException() {
        this((Throwable) null);
    }

    public GoogleIdTokenParsingException(Throwable th) {
        super(th);
    }
}
