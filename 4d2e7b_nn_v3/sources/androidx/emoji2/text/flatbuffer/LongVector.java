package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class LongVector extends BaseVector {
    public LongVector __assign(int i10, ByteBuffer byteBuffer) {
        __reset(i10, 8, byteBuffer);
        return this;
    }

    public long get(int i10) {
        return this.f15430bb.getLong(__element(i10));
    }
}
