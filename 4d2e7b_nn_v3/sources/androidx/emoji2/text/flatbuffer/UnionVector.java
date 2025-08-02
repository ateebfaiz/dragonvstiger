package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class UnionVector extends BaseVector {
    public UnionVector __assign(int i10, int i11, ByteBuffer byteBuffer) {
        __reset(i10, i11, byteBuffer);
        return this;
    }

    public Table get(Table table, int i10) {
        return Table.__union(table, __element(i10), this.f15430bb);
    }
}
