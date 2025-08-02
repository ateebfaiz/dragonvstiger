package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class BooleanVector extends BaseVector {
    public BooleanVector __assign(int i10, ByteBuffer byteBuffer) {
        __reset(i10, 1, byteBuffer);
        return this;
    }

    public boolean get(int i10) {
        if (this.f15430bb.get(__element(i10)) != 0) {
            return true;
        }
        return false;
    }
}
