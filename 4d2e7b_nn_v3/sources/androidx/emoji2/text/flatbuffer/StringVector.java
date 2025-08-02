package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class StringVector extends BaseVector {
    private Utf8 utf8 = Utf8.getDefault();

    public StringVector __assign(int i10, int i11, ByteBuffer byteBuffer) {
        __reset(i10, i11, byteBuffer);
        return this;
    }

    public String get(int i10) {
        return Table.__string(__element(i10), this.f15430bb, this.utf8);
    }
}
