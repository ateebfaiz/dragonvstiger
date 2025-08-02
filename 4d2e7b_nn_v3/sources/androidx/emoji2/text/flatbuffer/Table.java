package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;

public class Table {

    /* renamed from: bb  reason: collision with root package name */
    protected ByteBuffer f15443bb;
    protected int bb_pos;
    Utf8 utf8 = Utf8.getDefault();
    private int vtable_size;
    private int vtable_start;

    class a implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ByteBuffer f15444a;

        a(ByteBuffer byteBuffer) {
            this.f15444a = byteBuffer;
        }

        /* renamed from: a */
        public int compare(Integer num, Integer num2) {
            return Table.this.keysCompare(num, num2, this.f15444a);
        }
    }

    protected static boolean __has_identifier(ByteBuffer byteBuffer, String str) {
        if (str.length() == 4) {
            for (int i10 = 0; i10 < 4; i10++) {
                if (str.charAt(i10) != ((char) byteBuffer.get(byteBuffer.position() + 4 + i10))) {
                    return false;
                }
            }
            return true;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    protected static int compareStrings(int i10, int i11, ByteBuffer byteBuffer) {
        int i12 = i10 + byteBuffer.getInt(i10);
        int i13 = i11 + byteBuffer.getInt(i11);
        int i14 = byteBuffer.getInt(i12);
        int i15 = byteBuffer.getInt(i13);
        int i16 = i12 + 4;
        int i17 = i13 + 4;
        int min = Math.min(i14, i15);
        for (int i18 = 0; i18 < min; i18++) {
            int i19 = i18 + i16;
            int i20 = i18 + i17;
            if (byteBuffer.get(i19) != byteBuffer.get(i20)) {
                return byteBuffer.get(i19) - byteBuffer.get(i20);
            }
        }
        return i14 - i15;
    }

    /* access modifiers changed from: protected */
    public int __indirect(int i10) {
        return i10 + this.f15443bb.getInt(i10);
    }

    /* access modifiers changed from: protected */
    public int __offset(int i10) {
        if (i10 < this.vtable_size) {
            return this.f15443bb.getShort(this.vtable_start + i10);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void __reset(int i10, ByteBuffer byteBuffer) {
        this.f15443bb = byteBuffer;
        if (byteBuffer != null) {
            this.bb_pos = i10;
            int i11 = i10 - byteBuffer.getInt(i10);
            this.vtable_start = i11;
            this.vtable_size = this.f15443bb.getShort(i11);
            return;
        }
        this.bb_pos = 0;
        this.vtable_start = 0;
        this.vtable_size = 0;
    }

    /* access modifiers changed from: protected */
    public String __string(int i10) {
        return __string(i10, this.f15443bb, this.utf8);
    }

    /* access modifiers changed from: protected */
    public Table __union(Table table, int i10) {
        return __union(table, i10, this.f15443bb);
    }

    /* access modifiers changed from: protected */
    public int __vector(int i10) {
        int i11 = i10 + this.bb_pos;
        return i11 + this.f15443bb.getInt(i11) + 4;
    }

    /* access modifiers changed from: protected */
    public ByteBuffer __vector_as_bytebuffer(int i10, int i11) {
        int __offset = __offset(i10);
        if (__offset == 0) {
            return null;
        }
        ByteBuffer order = this.f15443bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int __vector = __vector(__offset);
        order.position(__vector);
        order.limit(__vector + (__vector_len(__offset) * i11));
        return order;
    }

    /* access modifiers changed from: protected */
    public ByteBuffer __vector_in_bytebuffer(ByteBuffer byteBuffer, int i10, int i11) {
        int __offset = __offset(i10);
        if (__offset == 0) {
            return null;
        }
        int __vector = __vector(__offset);
        byteBuffer.rewind();
        byteBuffer.limit((__vector_len(__offset) * i11) + __vector);
        byteBuffer.position(__vector);
        return byteBuffer;
    }

    /* access modifiers changed from: protected */
    public int __vector_len(int i10) {
        int i11 = i10 + this.bb_pos;
        return this.f15443bb.getInt(i11 + this.f15443bb.getInt(i11));
    }

    public ByteBuffer getByteBuffer() {
        return this.f15443bb;
    }

    /* access modifiers changed from: protected */
    public int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void sortTables(int[] iArr, ByteBuffer byteBuffer) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            numArr[i10] = Integer.valueOf(iArr[i10]);
        }
        Arrays.sort(numArr, new a(byteBuffer));
        for (int i11 = 0; i11 < iArr.length; i11++) {
            iArr[i11] = numArr[i11].intValue();
        }
    }

    /* access modifiers changed from: protected */
    public static int __indirect(int i10, ByteBuffer byteBuffer) {
        return i10 + byteBuffer.getInt(i10);
    }

    protected static int __offset(int i10, int i11, ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity() - i11;
        return byteBuffer.getShort((i10 + capacity) - byteBuffer.getInt(capacity)) + capacity;
    }

    protected static String __string(int i10, ByteBuffer byteBuffer, Utf8 utf82) {
        int i11 = i10 + byteBuffer.getInt(i10);
        return utf82.decodeUtf8(byteBuffer, i11 + 4, byteBuffer.getInt(i11));
    }

    protected static Table __union(Table table, int i10, ByteBuffer byteBuffer) {
        table.__reset(__indirect(i10, byteBuffer), byteBuffer);
        return table;
    }

    protected static int compareStrings(int i10, byte[] bArr, ByteBuffer byteBuffer) {
        int i11 = i10 + byteBuffer.getInt(i10);
        int i12 = byteBuffer.getInt(i11);
        int length = bArr.length;
        int i13 = i11 + 4;
        int min = Math.min(i12, length);
        for (int i14 = 0; i14 < min; i14++) {
            int i15 = i14 + i13;
            if (byteBuffer.get(i15) != bArr[i14]) {
                return byteBuffer.get(i15) - bArr[i14];
            }
        }
        return i12 - length;
    }

    public void __reset() {
        __reset(0, (ByteBuffer) null);
    }
}
