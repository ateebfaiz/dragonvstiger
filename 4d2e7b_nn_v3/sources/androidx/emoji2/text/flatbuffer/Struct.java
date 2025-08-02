package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class Struct {

    /* renamed from: bb  reason: collision with root package name */
    protected ByteBuffer f15442bb;
    protected int bb_pos;

    /* access modifiers changed from: protected */
    public void __reset(int i10, ByteBuffer byteBuffer) {
        this.f15442bb = byteBuffer;
        if (byteBuffer != null) {
            this.bb_pos = i10;
        } else {
            this.bb_pos = 0;
        }
    }

    public void __reset() {
        __reset(0, (ByteBuffer) null);
    }
}
