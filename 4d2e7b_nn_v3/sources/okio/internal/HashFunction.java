package okio.internal;

public interface HashFunction {
    byte[] digest();

    void update(byte[] bArr, int i10, int i11);
}
