package androidx.emoji2.text.flatbuffer;

import com.alibaba.pdns.net.f.a;
import java.nio.ByteBuffer;

public final class ShortVector extends BaseVector {
    public ShortVector __assign(int i10, ByteBuffer byteBuffer) {
        __reset(i10, 2, byteBuffer);
        return this;
    }

    public short get(int i10) {
        return this.f15430bb.getShort(__element(i10));
    }

    public int getAsUnsigned(int i10) {
        return get(i10) & a.f18108a;
    }
}
