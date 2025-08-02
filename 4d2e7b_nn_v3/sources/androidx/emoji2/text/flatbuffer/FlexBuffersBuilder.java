package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.FlexBuffers;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class FlexBuffersBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;
    private static final int WIDTH_16 = 1;
    private static final int WIDTH_32 = 2;
    private static final int WIDTH_64 = 3;
    private static final int WIDTH_8 = 0;
    /* access modifiers changed from: private */

    /* renamed from: bb  reason: collision with root package name */
    public final b f15435bb;
    private boolean finished;
    private final int flags;
    private Comparator<b> keyComparator;
    private final HashMap<String, Integer> keyPool;
    private final ArrayList<b> stack;
    private final HashMap<String, Integer> stringPool;

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            byte b10;
            byte b11;
            int i10 = bVar.f15441e;
            int i11 = bVar2.f15441e;
            do {
                b10 = FlexBuffersBuilder.this.f15435bb.get(i10);
                b11 = FlexBuffersBuilder.this.f15435bb.get(i11);
                if (b10 == 0) {
                    return b10 - b11;
                }
                i10++;
                i11++;
            } while (b10 == b11);
            return b10 - b11;
        }
    }

    public FlexBuffersBuilder(int i10) {
        this((b) new ArrayReadWriteBuf(i10), 1);
    }

    private int align(int i10) {
        int i11 = 1 << i10;
        int a10 = b.q(this.f15435bb.writePosition(), i11);
        while (true) {
            int i12 = a10 - 1;
            if (a10 == 0) {
                return i11;
            }
            this.f15435bb.put((byte) 0);
            a10 = i12;
        }
    }

    private b createKeyVector(int i10, int i11) {
        long j10 = (long) i11;
        int max = Math.max(0, widthUInBits(j10));
        int i12 = i10;
        while (i12 < this.stack.size()) {
            i12++;
            max = Math.max(max, b.i(4, 0, (long) this.stack.get(i12).f15441e, this.f15435bb.writePosition(), i12));
        }
        int align = align(max);
        writeInt(j10, align);
        int writePosition = this.f15435bb.writePosition();
        while (i10 < this.stack.size()) {
            int i13 = this.stack.get(i10).f15441e;
            writeOffset((long) this.stack.get(i10).f15441e, align);
            i10++;
        }
        return new b(-1, FlexBuffers.toTypedVector(4, 0), max, (long) writePosition);
    }

    private b createVector(int i10, int i11, int i12, boolean z10, boolean z11, b bVar) {
        int i13;
        int i14;
        b bVar2 = bVar;
        int i15 = i12;
        long j10 = (long) i15;
        int max = Math.max(0, widthUInBits(j10));
        if (bVar2 != null) {
            max = Math.max(max, bVar2.h(this.f15435bb.writePosition(), 0));
            i13 = 3;
        } else {
            i13 = 1;
        }
        int i16 = 4;
        int i17 = max;
        for (int i18 = i11; i18 < this.stack.size(); i18++) {
            i17 = Math.max(i17, this.stack.get(i18).h(this.f15435bb.writePosition(), i18 + i13));
            int i19 = i11;
            if (z10 && i18 == i19) {
                i16 = this.stack.get(i18).f15437a;
                if (!FlexBuffers.isTypedVectorElementType(i16)) {
                    throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
                }
            }
        }
        int i20 = i11;
        int align = align(i17);
        if (bVar2 != null) {
            writeOffset(bVar2.f15440d, align);
            writeInt(1 << bVar2.f15438b, align);
        }
        if (!z11) {
            writeInt(j10, align);
        }
        int writePosition = this.f15435bb.writePosition();
        for (int i21 = i20; i21 < this.stack.size(); i21++) {
            writeAny(this.stack.get(i21), align);
        }
        if (!z10) {
            while (i20 < this.stack.size()) {
                this.f15435bb.put(this.stack.get(i20).s(i17));
                i20++;
            }
        }
        if (bVar2 != null) {
            i14 = 9;
        } else if (z10) {
            if (!z11) {
                i15 = 0;
            }
            i14 = FlexBuffers.toTypedVector(i16, i15);
        } else {
            i14 = 10;
        }
        return new b(i10, i14, i17, (long) writePosition);
    }

    private int putKey(String str) {
        if (str == null) {
            return -1;
        }
        int writePosition = this.f15435bb.writePosition();
        if ((this.flags & 1) != 0) {
            Integer num = this.keyPool.get(str);
            if (num != null) {
                return num.intValue();
            }
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            this.f15435bb.put(bytes, 0, bytes.length);
            this.f15435bb.put((byte) 0);
            this.keyPool.put(str, Integer.valueOf(writePosition));
            return writePosition;
        }
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        this.f15435bb.put(bytes2, 0, bytes2.length);
        this.f15435bb.put((byte) 0);
        this.keyPool.put(str, Integer.valueOf(writePosition));
        return writePosition;
    }

    static int widthUInBits(long j10) {
        if (j10 <= ((long) FlexBuffers.c.a((byte) -1))) {
            return 0;
        }
        if (j10 <= ((long) FlexBuffers.c.c(-1))) {
            return 1;
        }
        if (j10 <= FlexBuffers.c.b(-1)) {
            return 2;
        }
        return 3;
    }

    private void writeAny(b bVar, int i10) {
        int i11 = bVar.f15437a;
        if (!(i11 == 0 || i11 == 1 || i11 == 2)) {
            if (i11 == 3) {
                writeDouble(bVar.f15439c, i10);
                return;
            } else if (i11 != 26) {
                writeOffset(bVar.f15440d, i10);
                return;
            }
        }
        writeInt(bVar.f15440d, i10);
    }

    private b writeBlob(int i10, byte[] bArr, int i11, boolean z10) {
        int widthUInBits = widthUInBits((long) bArr.length);
        writeInt((long) bArr.length, align(widthUInBits));
        int writePosition = this.f15435bb.writePosition();
        this.f15435bb.put(bArr, 0, bArr.length);
        if (z10) {
            this.f15435bb.put((byte) 0);
        }
        return b.f(i10, writePosition, i11, widthUInBits);
    }

    private void writeDouble(double d10, int i10) {
        if (i10 == 4) {
            this.f15435bb.putFloat((float) d10);
        } else if (i10 == 8) {
            this.f15435bb.putDouble(d10);
        }
    }

    private void writeInt(long j10, int i10) {
        if (i10 == 1) {
            this.f15435bb.put((byte) ((int) j10));
        } else if (i10 == 2) {
            this.f15435bb.putShort((short) ((int) j10));
        } else if (i10 == 4) {
            this.f15435bb.putInt((int) j10);
        } else if (i10 == 8) {
            this.f15435bb.putLong(j10);
        }
    }

    private void writeOffset(long j10, int i10) {
        writeInt((long) ((int) (((long) this.f15435bb.writePosition()) - j10)), i10);
    }

    private b writeString(int i10, String str) {
        return writeBlob(i10, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public int endMap(String str, int i10) {
        int putKey = putKey(str);
        ArrayList<b> arrayList = this.stack;
        Collections.sort(arrayList.subList(i10, arrayList.size()), this.keyComparator);
        int i11 = i10;
        b createVector = createVector(putKey, i11, this.stack.size() - i10, false, false, createKeyVector(i10, this.stack.size() - i10));
        while (this.stack.size() > i10) {
            ArrayList<b> arrayList2 = this.stack;
            arrayList2.remove(arrayList2.size() - 1);
        }
        this.stack.add(createVector);
        return (int) createVector.f15440d;
    }

    public int endVector(String str, int i10, boolean z10, boolean z11) {
        b createVector = createVector(putKey(str), i10, this.stack.size() - i10, z10, z11, (b) null);
        while (this.stack.size() > i10) {
            ArrayList<b> arrayList = this.stack;
            arrayList.remove(arrayList.size() - 1);
        }
        this.stack.add(createVector);
        return (int) createVector.f15440d;
    }

    public ByteBuffer finish() {
        int align = align(this.stack.get(0).h(this.f15435bb.writePosition(), 0));
        writeAny(this.stack.get(0), align);
        this.f15435bb.put(this.stack.get(0).r());
        this.f15435bb.put((byte) align);
        this.finished = true;
        return ByteBuffer.wrap(this.f15435bb.data(), 0, this.f15435bb.writePosition());
    }

    public b getBuffer() {
        return this.f15435bb;
    }

    public int putBlob(byte[] bArr) {
        return putBlob((String) null, bArr);
    }

    public void putBoolean(boolean z10) {
        putBoolean((String) null, z10);
    }

    public void putFloat(float f10) {
        putFloat((String) null, f10);
    }

    public void putInt(int i10) {
        putInt((String) null, i10);
    }

    public int putString(String str) {
        return putString((String) null, str);
    }

    public void putUInt(int i10) {
        putUInt((String) null, (long) i10);
    }

    public void putUInt64(BigInteger bigInteger) {
        putUInt64((String) null, bigInteger.longValue());
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    private void putUInt64(String str, long j10) {
        this.stack.add(b.w(putKey(str), j10));
    }

    public int putBlob(String str, byte[] bArr) {
        b writeBlob = writeBlob(putKey(str), bArr, 25, false);
        this.stack.add(writeBlob);
        return (int) writeBlob.f15440d;
    }

    public void putBoolean(String str, boolean z10) {
        this.stack.add(b.g(putKey(str), z10));
    }

    public void putFloat(String str, float f10) {
        this.stack.add(b.j(putKey(str), f10));
    }

    public void putInt(String str, int i10) {
        putInt(str, (long) i10);
    }

    public int putString(String str, String str2) {
        int putKey = putKey(str);
        if ((this.flags & 2) != 0) {
            Integer num = this.stringPool.get(str2);
            if (num == null) {
                b writeString = writeString(putKey, str2);
                this.stringPool.put(str2, Integer.valueOf((int) writeString.f15440d));
                this.stack.add(writeString);
                return (int) writeString.f15440d;
            }
            this.stack.add(b.f(putKey, num.intValue(), 5, widthUInBits((long) str2.length())));
            return num.intValue();
        }
        b writeString2 = writeString(putKey, str2);
        this.stack.add(writeString2);
        return (int) writeString2.f15440d;
    }

    public void putUInt(long j10) {
        putUInt((String) null, j10);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer byteBuffer, int i10) {
        this((b) new ArrayReadWriteBuf(byteBuffer.array()), i10);
    }

    private void putUInt(String str, long j10) {
        b bVar;
        int putKey = putKey(str);
        int widthUInBits = widthUInBits(j10);
        if (widthUInBits == 0) {
            bVar = b.x(putKey, (int) j10);
        } else if (widthUInBits == 1) {
            bVar = b.u(putKey, (int) j10);
        } else if (widthUInBits == 2) {
            bVar = b.v(putKey, (int) j10);
        } else {
            bVar = b.w(putKey, j10);
        }
        this.stack.add(bVar);
    }

    public void putFloat(double d10) {
        putFloat((String) null, d10);
    }

    public void putInt(String str, long j10) {
        int putKey = putKey(str);
        if (-128 <= j10 && j10 <= 127) {
            this.stack.add(b.o(putKey, (int) j10));
        } else if (-32768 <= j10 && j10 <= 32767) {
            this.stack.add(b.l(putKey, (int) j10));
        } else if (-2147483648L > j10 || j10 > 2147483647L) {
            this.stack.add(b.n(putKey, j10));
        } else {
            this.stack.add(b.m(putKey, (int) j10));
        }
    }

    public FlexBuffersBuilder(b bVar, int i10) {
        this.stack = new ArrayList<>();
        this.keyPool = new HashMap<>();
        this.stringPool = new HashMap<>();
        this.finished = false;
        this.keyComparator = new a();
        this.f15435bb = bVar;
        this.flags = i10;
    }

    public void putFloat(String str, double d10) {
        this.stack.add(b.k(putKey(str), d10));
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f15437a;

        /* renamed from: b  reason: collision with root package name */
        final int f15438b;

        /* renamed from: c  reason: collision with root package name */
        final double f15439c;

        /* renamed from: d  reason: collision with root package name */
        long f15440d;

        /* renamed from: e  reason: collision with root package name */
        int f15441e;

        b(int i10, int i11, int i12, long j10) {
            this.f15441e = i10;
            this.f15437a = i11;
            this.f15438b = i12;
            this.f15440d = j10;
            this.f15439c = Double.MIN_VALUE;
        }

        static b f(int i10, int i11, int i12, int i13) {
            return new b(i10, i12, i13, (long) i11);
        }

        static b g(int i10, boolean z10) {
            long j10;
            if (z10) {
                j10 = 1;
            } else {
                j10 = 0;
            }
            return new b(i10, 26, 0, j10);
        }

        /* access modifiers changed from: private */
        public int h(int i10, int i11) {
            return i(this.f15437a, this.f15438b, this.f15440d, i10, i11);
        }

        /* access modifiers changed from: private */
        public static int i(int i10, int i11, long j10, int i12, int i13) {
            if (FlexBuffers.isTypeInline(i10)) {
                return i11;
            }
            for (int i14 = 1; i14 <= 32; i14 *= 2) {
                int widthUInBits = FlexBuffersBuilder.widthUInBits((long) ((int) (((long) ((q(i12, i14) + i12) + (i13 * i14))) - j10)));
                if ((1 << widthUInBits) == ((long) i14)) {
                    return widthUInBits;
                }
            }
            return 3;
        }

        static b j(int i10, float f10) {
            return new b(i10, 3, 2, (double) f10);
        }

        static b k(int i10, double d10) {
            return new b(i10, 3, 3, d10);
        }

        static b l(int i10, int i11) {
            return new b(i10, 1, 1, (long) i11);
        }

        static b m(int i10, int i11) {
            return new b(i10, 1, 2, (long) i11);
        }

        static b n(int i10, long j10) {
            return new b(i10, 1, 3, j10);
        }

        static b o(int i10, int i11) {
            return new b(i10, 1, 0, (long) i11);
        }

        private static byte p(int i10, int i11) {
            return (byte) (i10 | (i11 << 2));
        }

        /* access modifiers changed from: private */
        public static int q(int i10, int i11) {
            return ((~i10) + 1) & (i11 - 1);
        }

        /* access modifiers changed from: private */
        public byte r() {
            return s(0);
        }

        /* access modifiers changed from: private */
        public byte s(int i10) {
            return p(t(i10), this.f15437a);
        }

        private int t(int i10) {
            if (FlexBuffers.isTypeInline(this.f15437a)) {
                return Math.max(this.f15438b, i10);
            }
            return this.f15438b;
        }

        static b u(int i10, int i11) {
            return new b(i10, 2, 1, (long) i11);
        }

        static b v(int i10, int i11) {
            return new b(i10, 2, 2, (long) i11);
        }

        static b w(int i10, long j10) {
            return new b(i10, 2, 3, j10);
        }

        static b x(int i10, int i11) {
            return new b(i10, 2, 0, (long) i11);
        }

        b(int i10, int i11, int i12, double d10) {
            this.f15441e = i10;
            this.f15437a = i11;
            this.f15438b = i12;
            this.f15439c = d10;
            this.f15440d = Long.MIN_VALUE;
        }
    }

    public void putInt(long j10) {
        putInt((String) null, j10);
    }

    public FlexBuffersBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }
}
