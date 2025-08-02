package com.facebook.react.bridge;

import kotlin.jvm.internal.m;

public final class SoftAssertions {
    public static final SoftAssertions INSTANCE = new SoftAssertions();

    private SoftAssertions() {
    }

    public static final void assertCondition(boolean z10, String str) {
        m.f(str, "message");
        if (!z10) {
            ReactSoftExceptionLogger.logSoftException("SoftAssertions", new AssertionException(str));
        }
    }

    public static final <T> T assertNotNull(T t10) {
        if (t10 == null) {
            ReactSoftExceptionLogger.logSoftException("SoftAssertions", new AssertionException("Expected object to not be null!"));
        }
        return t10;
    }

    public static final void assertUnreachable(String str) {
        m.f(str, "message");
        ReactSoftExceptionLogger.logSoftException("SoftAssertions", new AssertionException(str));
    }
}
