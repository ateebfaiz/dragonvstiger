package com.appsflyer.internal.components.network.http.exceptions;

import androidx.annotation.NonNull;
import com.appsflyer.internal.AFd1zSDK;
import java.io.IOException;

public class ParsingException extends IOException {
    @NonNull
    private final AFd1zSDK<String> valueOf;

    public ParsingException(String str, Throwable th, @NonNull AFd1zSDK<String> aFd1zSDK) {
        super(str, th);
        this.valueOf = aFd1zSDK;
    }

    @NonNull
    public AFd1zSDK<String> getRawResponse() {
        return this.valueOf;
    }
}
