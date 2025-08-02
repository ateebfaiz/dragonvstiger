package okio.internal;

import java.security.MessageDigest;
import kotlin.jvm.internal.m;

public final class HashFunctionKt$newHashFunction$1 implements HashFunction {
    final /* synthetic */ String $algorithm;
    private final MessageDigest digest;

    HashFunctionKt$newHashFunction$1(String str) {
        this.$algorithm = str;
        this.digest = MessageDigest.getInstance(str);
    }

    public byte[] digest() {
        return this.digest.digest();
    }

    public void update(byte[] bArr, int i10, int i11) {
        m.f(bArr, "input");
        this.digest.update(bArr, i10, i11);
    }
}
