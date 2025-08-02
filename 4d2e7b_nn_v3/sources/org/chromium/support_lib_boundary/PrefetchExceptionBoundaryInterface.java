package org.chromium.support_lib_boundary;

public interface PrefetchExceptionBoundaryInterface {
    Throwable getCause();

    String getMessage();
}
