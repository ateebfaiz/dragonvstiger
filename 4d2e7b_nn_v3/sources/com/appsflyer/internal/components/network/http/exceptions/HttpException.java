package com.appsflyer.internal.components.network.http.exceptions;

import androidx.annotation.NonNull;
import com.appsflyer.internal.AFc1hSDK;
import java.io.IOException;

public class HttpException extends IOException {
    private final AFc1hSDK values;

    public HttpException(@NonNull Throwable th, @NonNull AFc1hSDK aFc1hSDK) {
        super(th.getMessage(), th);
        this.values = aFc1hSDK;
    }

    @NonNull
    public AFc1hSDK getMetrics() {
        return this.values;
    }
}
