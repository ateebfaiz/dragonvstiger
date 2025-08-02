package y;

import io.jsonwebtoken.JwtParser;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24840a = "_COROUTINE";

    /* access modifiers changed from: private */
    public static final StackTraceElement b(Throwable th, String str) {
        StackTraceElement stackTraceElement = th.getStackTrace()[0];
        return new StackTraceElement(f24840a + JwtParser.SEPARATOR_CHAR + str, "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }
}
