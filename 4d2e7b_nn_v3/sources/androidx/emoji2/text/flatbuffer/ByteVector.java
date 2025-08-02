package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class ByteVector extends BaseVector {
    public ByteVector __assign(int i10, ByteBuffer byteBuffer) {
        __reset(i10, 1, byteBuffer);
        return this;
    }

    public byte get(int i10) {
        return this.f15430bb.get(__element(i10));
    }

    public int getAsUnsigned(int i10) {
        return get(i10) & 255;
    }
}
