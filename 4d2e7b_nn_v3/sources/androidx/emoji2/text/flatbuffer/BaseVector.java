package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class BaseVector {

    /* renamed from: bb  reason: collision with root package name */
    protected ByteBuffer f15430bb;
    private int element_size;
    private int length;
    private int vector;

    /* access modifiers changed from: protected */
    public int __element(int i10) {
        return this.vector + (i10 * this.element_size);
    }

    /* access modifiers changed from: protected */
    public void __reset(int i10, int i11, ByteBuffer byteBuffer) {
        this.f15430bb = byteBuffer;
        if (byteBuffer != null) {
            this.vector = i10;
            this.length = byteBuffer.getInt(i10 - 4);
            this.element_size = i11;
            return;
        }
        this.vector = 0;
        this.length = 0;
        this.element_size = 0;
    }

    /* access modifiers changed from: protected */
    public int __vector() {
        return this.vector;
    }

    public int length() {
        return this.length;
    }

    public void reset() {
        __reset(0, 0, (ByteBuffer) null);
    }
}
