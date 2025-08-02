package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class FlexBuffers {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    /* access modifiers changed from: private */
    public static final a EMPTY_BB = new ArrayReadWriteBuf(new byte[]{0}, 1);
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    public static class Blob extends b {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final Blob EMPTY = new Blob(FlexBuffers.EMPTY_BB, 1, 1);

        Blob(a aVar, int i10, int i11) {
            super(aVar, i10, i11);
        }

        public static Blob empty() {
            return EMPTY;
        }

        public ByteBuffer data() {
            ByteBuffer wrap = ByteBuffer.wrap(this.f15434bb.data());
            wrap.position(this.end);
            wrap.limit(this.end + size());
            return wrap.asReadOnlyBuffer().slice();
        }

        public byte get(int i10) {
            return this.f15434bb.get(this.end + i10);
        }

        public byte[] getBytes() {
            int size = size();
            byte[] bArr = new byte[size];
            for (int i10 = 0; i10 < size; i10++) {
                bArr[i10] = this.f15434bb.get(this.end + i10);
            }
            return bArr;
        }

        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        public String toString() {
            return this.f15434bb.getString(this.end, size());
        }

        public StringBuilder toString(StringBuilder sb2) {
            sb2.append('\"');
            sb2.append(this.f15434bb.getString(this.end, size()));
            sb2.append('\"');
            return sb2;
        }
    }

    public static class FlexBufferException extends RuntimeException {
        FlexBufferException(String str) {
            super(str);
        }
    }

    public static class Key extends a {
        /* access modifiers changed from: private */
        public static final Key EMPTY = new Key(FlexBuffers.EMPTY_BB, 0, 0);

        Key(a aVar, int i10, int i11) {
            super(aVar, i10, i11);
        }

        public static Key empty() {
            return EMPTY;
        }

        /* access modifiers changed from: package-private */
        public int compareTo(byte[] bArr) {
            byte b10;
            byte b11;
            int i10 = this.end;
            int i11 = 0;
            do {
                b10 = this.f15434bb.get(i10);
                b11 = bArr[i11];
                if (b10 == 0) {
                    return b10 - b11;
                }
                i10++;
                i11++;
                if (i11 == bArr.length) {
                    return b10 - b11;
                }
            } while (b10 == b11);
            return b10 - b11;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (key.end == this.end && key.byteWidth == this.byteWidth) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.end ^ this.byteWidth;
        }

        public StringBuilder toString(StringBuilder sb2) {
            sb2.append(toString());
            return sb2;
        }

        public String toString() {
            int i10 = this.end;
            while (this.f15434bb.get(i10) != 0) {
                i10++;
            }
            int i11 = this.end;
            return this.f15434bb.getString(i11, i10 - i11);
        }
    }

    public static class KeyVector {
        private final TypedVector vec;

        KeyVector(TypedVector typedVector) {
            this.vec = typedVector;
        }

        public Key get(int i10) {
            if (i10 >= size()) {
                return Key.EMPTY;
            }
            TypedVector typedVector = this.vec;
            TypedVector typedVector2 = this.vec;
            a aVar = typedVector2.f15434bb;
            return new Key(aVar, FlexBuffers.indirect(aVar, typedVector.end + (i10 * typedVector.byteWidth), typedVector2.byteWidth), 1);
        }

        public int size() {
            return this.vec.size();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (int i10 = 0; i10 < this.vec.size(); i10++) {
                this.vec.get(i10).toString(sb2);
                if (i10 != this.vec.size() - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    public static class Map extends Vector {
        private static final Map EMPTY_MAP = new Map(FlexBuffers.EMPTY_BB, 1, 1);

        Map(a aVar, int i10, int i11) {
            super(aVar, i10, i11);
        }

        private int binarySearch(KeyVector keyVector, byte[] bArr) {
            int size = keyVector.size() - 1;
            int i10 = 0;
            while (i10 <= size) {
                int i11 = (i10 + size) >>> 1;
                int compareTo = keyVector.get(i11).compareTo(bArr);
                if (compareTo < 0) {
                    i10 = i11 + 1;
                } else if (compareTo <= 0) {
                    return i11;
                } else {
                    size = i11 - 1;
                }
            }
            return -(i10 + 1);
        }

        public static Map empty() {
            return EMPTY_MAP;
        }

        public Reference get(String str) {
            return get(str.getBytes(StandardCharsets.UTF_8));
        }

        public KeyVector keys() {
            int i10 = this.end - (this.byteWidth * 3);
            a aVar = this.f15434bb;
            int access$200 = FlexBuffers.indirect(aVar, i10, this.byteWidth);
            a aVar2 = this.f15434bb;
            int i11 = this.byteWidth;
            return new KeyVector(new TypedVector(aVar, access$200, FlexBuffers.readInt(aVar2, i10 + i11, i11), 4));
        }

        public StringBuilder toString(StringBuilder sb2) {
            sb2.append("{ ");
            KeyVector keys = keys();
            int size = size();
            Vector values = values();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append('\"');
                sb2.append(keys.get(i10).toString());
                sb2.append("\" : ");
                sb2.append(values.get(i10).toString());
                if (i10 != size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append(" }");
            return sb2;
        }

        public Vector values() {
            return new Vector(this.f15434bb, this.end, this.byteWidth);
        }

        public Reference get(byte[] bArr) {
            KeyVector keys = keys();
            int size = keys.size();
            int binarySearch = binarySearch(keys, bArr);
            if (binarySearch < 0 || binarySearch >= size) {
                return Reference.NULL_REFERENCE;
            }
            return get(binarySearch);
        }
    }

    public static class Reference {
        /* access modifiers changed from: private */
        public static final Reference NULL_REFERENCE = new Reference(FlexBuffers.EMPTY_BB, 0, 1, 0);

        /* renamed from: bb  reason: collision with root package name */
        private a f15433bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        Reference(a aVar, int i10, int i11, int i12) {
            this(aVar, i10, i11, 1 << (i12 & 3), i12 >> 2);
        }

        public Blob asBlob() {
            if (!isBlob() && !isString()) {
                return Blob.empty();
            }
            a aVar = this.f15433bb;
            return new Blob(aVar, FlexBuffers.indirect(aVar, this.end, this.parentWidth), this.byteWidth);
        }

        public boolean asBoolean() {
            if (isBoolean()) {
                if (this.f15433bb.get(this.end) != 0) {
                    return true;
                }
                return false;
            } else if (asUInt() != 0) {
                return true;
            } else {
                return false;
            }
        }

        public double asFloat() {
            int i10 = this.type;
            if (i10 == 3) {
                return FlexBuffers.readDouble(this.f15433bb, this.end, this.parentWidth);
            }
            if (i10 == 1) {
                return (double) FlexBuffers.readInt(this.f15433bb, this.end, this.parentWidth);
            }
            if (i10 != 2) {
                if (i10 == 5) {
                    return Double.parseDouble(asString());
                }
                if (i10 == 6) {
                    a aVar = this.f15433bb;
                    return (double) FlexBuffers.readInt(aVar, FlexBuffers.indirect(aVar, this.end, this.parentWidth), this.byteWidth);
                } else if (i10 == 7) {
                    a aVar2 = this.f15433bb;
                    return (double) FlexBuffers.readUInt(aVar2, FlexBuffers.indirect(aVar2, this.end, this.parentWidth), this.byteWidth);
                } else if (i10 == 8) {
                    a aVar3 = this.f15433bb;
                    return FlexBuffers.readDouble(aVar3, FlexBuffers.indirect(aVar3, this.end, this.parentWidth), this.byteWidth);
                } else if (i10 == 10) {
                    return (double) asVector().size();
                } else {
                    if (i10 != 26) {
                        return 0.0d;
                    }
                }
            }
            return (double) FlexBuffers.readUInt(this.f15433bb, this.end, this.parentWidth);
        }

        public int asInt() {
            int i10 = this.type;
            if (i10 == 1) {
                return FlexBuffers.readInt(this.f15433bb, this.end, this.parentWidth);
            }
            if (i10 == 2) {
                return (int) FlexBuffers.readUInt(this.f15433bb, this.end, this.parentWidth);
            }
            if (i10 == 3) {
                return (int) FlexBuffers.readDouble(this.f15433bb, this.end, this.parentWidth);
            }
            if (i10 == 5) {
                return Integer.parseInt(asString());
            }
            if (i10 == 6) {
                a aVar = this.f15433bb;
                return FlexBuffers.readInt(aVar, FlexBuffers.indirect(aVar, this.end, this.parentWidth), this.byteWidth);
            } else if (i10 == 7) {
                a aVar2 = this.f15433bb;
                return (int) FlexBuffers.readUInt(aVar2, FlexBuffers.indirect(aVar2, this.end, this.parentWidth), this.parentWidth);
            } else if (i10 == 8) {
                a aVar3 = this.f15433bb;
                return (int) FlexBuffers.readDouble(aVar3, FlexBuffers.indirect(aVar3, this.end, this.parentWidth), this.byteWidth);
            } else if (i10 == 10) {
                return asVector().size();
            } else {
                if (i10 != 26) {
                    return 0;
                }
                return FlexBuffers.readInt(this.f15433bb, this.end, this.parentWidth);
            }
        }

        public Key asKey() {
            if (!isKey()) {
                return Key.empty();
            }
            a aVar = this.f15433bb;
            return new Key(aVar, FlexBuffers.indirect(aVar, this.end, this.parentWidth), this.byteWidth);
        }

        public long asLong() {
            int i10 = this.type;
            if (i10 == 1) {
                return FlexBuffers.readLong(this.f15433bb, this.end, this.parentWidth);
            }
            if (i10 == 2) {
                return FlexBuffers.readUInt(this.f15433bb, this.end, this.parentWidth);
            }
            if (i10 == 3) {
                return (long) FlexBuffers.readDouble(this.f15433bb, this.end, this.parentWidth);
            }
            if (i10 == 5) {
                try {
                    return Long.parseLong(asString());
                } catch (NumberFormatException unused) {
                    return 0;
                }
            } else if (i10 == 6) {
                a aVar = this.f15433bb;
                return FlexBuffers.readLong(aVar, FlexBuffers.indirect(aVar, this.end, this.parentWidth), this.byteWidth);
            } else if (i10 == 7) {
                a aVar2 = this.f15433bb;
                return FlexBuffers.readUInt(aVar2, FlexBuffers.indirect(aVar2, this.end, this.parentWidth), this.parentWidth);
            } else if (i10 == 8) {
                a aVar3 = this.f15433bb;
                return (long) FlexBuffers.readDouble(aVar3, FlexBuffers.indirect(aVar3, this.end, this.parentWidth), this.byteWidth);
            } else if (i10 == 10) {
                return (long) asVector().size();
            } else {
                if (i10 != 26) {
                    return 0;
                }
                return (long) FlexBuffers.readInt(this.f15433bb, this.end, this.parentWidth);
            }
        }

        public Map asMap() {
            if (!isMap()) {
                return Map.empty();
            }
            a aVar = this.f15433bb;
            return new Map(aVar, FlexBuffers.indirect(aVar, this.end, this.parentWidth), this.byteWidth);
        }

        public String asString() {
            if (isString()) {
                int access$200 = FlexBuffers.indirect(this.f15433bb, this.end, this.parentWidth);
                a aVar = this.f15433bb;
                int i10 = this.byteWidth;
                return this.f15433bb.getString(access$200, (int) FlexBuffers.readUInt(aVar, access$200 - i10, i10));
            } else if (!isKey()) {
                return "";
            } else {
                int access$2002 = FlexBuffers.indirect(this.f15433bb, this.end, this.byteWidth);
                int i11 = access$2002;
                while (this.f15433bb.get(i11) != 0) {
                    i11++;
                }
                return this.f15433bb.getString(access$2002, i11 - access$2002);
            }
        }

        public long asUInt() {
            int i10 = this.type;
            if (i10 == 2) {
                return FlexBuffers.readUInt(this.f15433bb, this.end, this.parentWidth);
            }
            if (i10 == 1) {
                return FlexBuffers.readLong(this.f15433bb, this.end, this.parentWidth);
            }
            if (i10 == 3) {
                return (long) FlexBuffers.readDouble(this.f15433bb, this.end, this.parentWidth);
            }
            if (i10 == 10) {
                return (long) asVector().size();
            }
            if (i10 == 26) {
                return (long) FlexBuffers.readInt(this.f15433bb, this.end, this.parentWidth);
            }
            if (i10 == 5) {
                return Long.parseLong(asString());
            }
            if (i10 == 6) {
                a aVar = this.f15433bb;
                return FlexBuffers.readLong(aVar, FlexBuffers.indirect(aVar, this.end, this.parentWidth), this.byteWidth);
            } else if (i10 == 7) {
                a aVar2 = this.f15433bb;
                return FlexBuffers.readUInt(aVar2, FlexBuffers.indirect(aVar2, this.end, this.parentWidth), this.byteWidth);
            } else if (i10 != 8) {
                return 0;
            } else {
                a aVar3 = this.f15433bb;
                return (long) FlexBuffers.readDouble(aVar3, FlexBuffers.indirect(aVar3, this.end, this.parentWidth), this.parentWidth);
            }
        }

        public Vector asVector() {
            if (isVector()) {
                a aVar = this.f15433bb;
                return new Vector(aVar, FlexBuffers.indirect(aVar, this.end, this.parentWidth), this.byteWidth);
            }
            int i10 = this.type;
            if (i10 == 15) {
                a aVar2 = this.f15433bb;
                return new TypedVector(aVar2, FlexBuffers.indirect(aVar2, this.end, this.parentWidth), this.byteWidth, 4);
            } else if (!FlexBuffers.isTypedVector(i10)) {
                return Vector.empty();
            } else {
                a aVar3 = this.f15433bb;
                return new TypedVector(aVar3, FlexBuffers.indirect(aVar3, this.end, this.parentWidth), this.byteWidth, FlexBuffers.toTypedVectorElementType(this.type));
            }
        }

        public int getType() {
            return this.type;
        }

        public boolean isBlob() {
            if (this.type == 25) {
                return true;
            }
            return false;
        }

        public boolean isBoolean() {
            if (this.type == 26) {
                return true;
            }
            return false;
        }

        public boolean isFloat() {
            int i10 = this.type;
            if (i10 == 3 || i10 == 8) {
                return true;
            }
            return false;
        }

        public boolean isInt() {
            int i10 = this.type;
            if (i10 == 1 || i10 == 6) {
                return true;
            }
            return false;
        }

        public boolean isIntOrUInt() {
            if (isInt() || isUInt()) {
                return true;
            }
            return false;
        }

        public boolean isKey() {
            if (this.type == 4) {
                return true;
            }
            return false;
        }

        public boolean isMap() {
            if (this.type == 9) {
                return true;
            }
            return false;
        }

        public boolean isNull() {
            if (this.type == 0) {
                return true;
            }
            return false;
        }

        public boolean isNumeric() {
            if (isIntOrUInt() || isFloat()) {
                return true;
            }
            return false;
        }

        public boolean isString() {
            if (this.type == 5) {
                return true;
            }
            return false;
        }

        public boolean isTypedVector() {
            return FlexBuffers.isTypedVector(this.type);
        }

        public boolean isUInt() {
            int i10 = this.type;
            if (i10 == 2 || i10 == 7) {
                return true;
            }
            return false;
        }

        public boolean isVector() {
            int i10 = this.type;
            if (i10 == 10 || i10 == 9) {
                return true;
            }
            return false;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        Reference(a aVar, int i10, int i11, int i12, int i13) {
            this.f15433bb = aVar;
            this.end = i10;
            this.parentWidth = i11;
            this.byteWidth = i12;
            this.type = i13;
        }

        /* access modifiers changed from: package-private */
        public StringBuilder toString(StringBuilder sb2) {
            int i10 = this.type;
            if (i10 != 36) {
                switch (i10) {
                    case 0:
                        sb2.append("null");
                        return sb2;
                    case 1:
                    case 6:
                        sb2.append(asLong());
                        return sb2;
                    case 2:
                    case 7:
                        sb2.append(asUInt());
                        return sb2;
                    case 3:
                    case 8:
                        sb2.append(asFloat());
                        return sb2;
                    case 4:
                        Key asKey = asKey();
                        sb2.append('\"');
                        StringBuilder key = asKey.toString(sb2);
                        key.append('\"');
                        return key;
                    case 5:
                        sb2.append('\"');
                        sb2.append(asString());
                        sb2.append('\"');
                        return sb2;
                    case 9:
                        return asMap().toString(sb2);
                    case 10:
                        return asVector().toString(sb2);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new FlexBufferException("not_implemented:" + this.type);
                    case 25:
                        return asBlob().toString(sb2);
                    case 26:
                        sb2.append(asBoolean());
                        return sb2;
                    default:
                        return sb2;
                }
            }
            sb2.append(asVector());
            return sb2;
        }
    }

    public static class TypedVector extends Vector {
        private static final TypedVector EMPTY_VECTOR = new TypedVector(FlexBuffers.EMPTY_BB, 1, 1, 1);
        private final int elemType;

        TypedVector(a aVar, int i10, int i11, int i12) {
            super(aVar, i10, i11);
            this.elemType = i12;
        }

        public static TypedVector empty() {
            return EMPTY_VECTOR;
        }

        public Reference get(int i10) {
            if (i10 >= size()) {
                return Reference.NULL_REFERENCE;
            }
            return new Reference(this.f15434bb, this.end + (i10 * this.byteWidth), this.byteWidth, 1, this.elemType);
        }

        public int getElemType() {
            return this.elemType;
        }

        public boolean isEmptyVector() {
            if (this == EMPTY_VECTOR) {
                return true;
            }
            return false;
        }
    }

    public static class Vector extends b {
        private static final Vector EMPTY_VECTOR = new Vector(FlexBuffers.EMPTY_BB, 1, 1);

        Vector(a aVar, int i10, int i11) {
            super(aVar, i10, i11);
        }

        public static Vector empty() {
            return EMPTY_VECTOR;
        }

        public Reference get(int i10) {
            long size = (long) size();
            long j10 = (long) i10;
            if (j10 >= size) {
                return Reference.NULL_REFERENCE;
            }
            int a10 = c.a(this.f15434bb.get((int) (((long) this.end) + (size * ((long) this.byteWidth)) + j10)));
            return new Reference(this.f15434bb, this.end + (i10 * this.byteWidth), this.byteWidth, a10);
        }

        public boolean isEmpty() {
            if (this == EMPTY_VECTOR) {
                return true;
            }
            return false;
        }

        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        public StringBuilder toString(StringBuilder sb2) {
            sb2.append("[ ");
            int size = size();
            for (int i10 = 0; i10 < size; i10++) {
                get(i10).toString(sb2);
                if (i10 != size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append(" ]");
            return sb2;
        }
    }

    private static abstract class a {

        /* renamed from: bb  reason: collision with root package name */
        a f15434bb;
        int byteWidth;
        int end;

        a(a aVar, int i10, int i11) {
            this.f15434bb = aVar;
            this.end = i10;
            this.byteWidth = i11;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public abstract StringBuilder toString(StringBuilder sb2);
    }

    private static abstract class b extends a {
        protected final int size;

        b(a aVar, int i10, int i11) {
            super(aVar, i10, i11);
            this.size = FlexBuffers.readInt(this.f15434bb, i10 - i11, i11);
        }

        public int size() {
            return this.size;
        }
    }

    static class c {
        static int a(byte b10) {
            return b10 & 255;
        }

        static long b(int i10) {
            return ((long) i10) & 4294967295L;
        }

        static int c(short s10) {
            return s10 & com.alibaba.pdns.net.f.a.f18108a;
        }
    }

    @Deprecated
    public static Reference getRoot(ByteBuffer byteBuffer) {
        return getRoot(byteBuffer.hasArray() ? new ArrayReadWriteBuf(byteBuffer.array(), byteBuffer.limit()) : new ByteBufferReadWriteBuf(byteBuffer));
    }

    /* access modifiers changed from: private */
    public static int indirect(a aVar, int i10, int i11) {
        return (int) (((long) i10) - readUInt(aVar, i10, i11));
    }

    static boolean isTypeInline(int i10) {
        return i10 <= 3 || i10 == 26;
    }

    static boolean isTypedVector(int i10) {
        return (i10 >= 11 && i10 <= 15) || i10 == 36;
    }

    static boolean isTypedVectorElementType(int i10) {
        return (i10 >= 1 && i10 <= 4) || i10 == 26;
    }

    /* access modifiers changed from: private */
    public static double readDouble(a aVar, int i10, int i11) {
        if (i11 == 4) {
            return (double) aVar.getFloat(i10);
        }
        if (i11 != 8) {
            return -1.0d;
        }
        return aVar.getDouble(i10);
    }

    /* access modifiers changed from: private */
    public static int readInt(a aVar, int i10, int i11) {
        return (int) readLong(aVar, i10, i11);
    }

    /* access modifiers changed from: private */
    public static long readLong(a aVar, int i10, int i11) {
        int i12;
        if (i11 == 1) {
            i12 = aVar.get(i10);
        } else if (i11 == 2) {
            i12 = aVar.getShort(i10);
        } else if (i11 == 4) {
            i12 = aVar.getInt(i10);
        } else if (i11 != 8) {
            return -1;
        } else {
            return aVar.getLong(i10);
        }
        return (long) i12;
    }

    /* access modifiers changed from: private */
    public static long readUInt(a aVar, int i10, int i11) {
        if (i11 == 1) {
            return (long) c.a(aVar.get(i10));
        }
        if (i11 == 2) {
            return (long) c.c(aVar.getShort(i10));
        }
        if (i11 == 4) {
            return c.b(aVar.getInt(i10));
        }
        if (i11 != 8) {
            return -1;
        }
        return aVar.getLong(i10);
    }

    static int toTypedVector(int i10, int i11) {
        if (i11 == 0) {
            return i10 + 10;
        }
        if (i11 == 2) {
            return i10 + 15;
        }
        if (i11 == 3) {
            return i10 + 18;
        }
        if (i11 != 4) {
            return 0;
        }
        return i10 + 21;
    }

    static int toTypedVectorElementType(int i10) {
        return i10 - 10;
    }

    public static Reference getRoot(a aVar) {
        int limit = aVar.limit();
        byte b10 = aVar.get(limit - 1);
        int i10 = limit - 2;
        return new Reference(aVar, i10 - b10, b10, c.a(aVar.get(i10)));
    }
}
