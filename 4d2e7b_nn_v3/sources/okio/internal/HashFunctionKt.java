package okio.internal;

import kotlin.jvm.internal.m;

public final class HashFunctionKt {
    public static final HashFunction newHashFunction(String str) {
        m.f(str, "algorithm");
        return new HashFunctionKt$newHashFunction$1(str);
    }
}
