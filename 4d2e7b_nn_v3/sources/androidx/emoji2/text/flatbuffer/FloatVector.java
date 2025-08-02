package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class FloatVector extends BaseVector {
    public FloatVector __assign(int i10, ByteBuffer byteBuffer) {
        __reset(i10, 4, byteBuffer);
        return this;
    }

    public float get(int i10) {
        return this.f15430bb.getFloat(__element(i10));
    }
}
