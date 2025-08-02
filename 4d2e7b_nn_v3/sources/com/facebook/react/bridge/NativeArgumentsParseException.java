package com.facebook.react.bridge;

import androidx.annotation.Nullable;

class NativeArgumentsParseException extends JSApplicationCausedNativeException {
    public NativeArgumentsParseException(String str) {
        super(str);
    }

    public NativeArgumentsParseException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }
}
