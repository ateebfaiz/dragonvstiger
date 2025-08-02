package com.facebook.react.bridge;

import androidx.core.app.NotificationCompat;
import d6.a;
import kotlin.jvm.internal.m;

@a
public final class UnexpectedNativeTypeException extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnexpectedNativeTypeException(String str) {
        super(str);
        m.f(str, NotificationCompat.CATEGORY_MESSAGE);
    }
}
