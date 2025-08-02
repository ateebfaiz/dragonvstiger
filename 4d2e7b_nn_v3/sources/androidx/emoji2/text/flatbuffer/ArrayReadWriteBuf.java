package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;

public class ArrayReadWriteBuf implements b {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    public byte[] data() {
        return this.buffer;
    }

    public byte get(int i10) {
        return this.buffer[i10];
    }

    public boolean getBoolean(int i10) {
        if (this.buffer[i10] != 0) {
            return true;
        }
        return false;
    }

    public double getDouble(int i10) {
        return Double.longBitsToDouble(getLong(i10));
    }

    public float getFloat(int i10) {
        return Float.intBitsToFloat(getInt(i10));
    }

    public int getInt(int i10) {
        byte[] bArr = this.buffer;
        return (bArr[i10] & 255) | (bArr[i10 + 3] << 24) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 1] & 255) << 8);
    }

    public long getLong(int i10) {
        byte[] bArr = this.buffer;
        return (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48) | (((long) bArr[i10 + 7]) << 56);
    }

    public short getShort(int i10) {
        byte[] bArr = this.buffer;
        return (short) ((bArr[i10] & 255) | (bArr[i10 + 1] << 8));
    }

    public String getString(int i10, int i11) {
        return Utf8Safe.decodeUtf8Array(this.buffer, i10, i11);
    }

    public int limit() {
        return this.writePos;
    }

    public void put(byte[] bArr, int i10, int i11) {
        set(this.writePos, bArr, i10, i11);
        this.writePos += i11;
    }

    public void putBoolean(boolean z10) {
        setBoolean(this.writePos, z10);
        this.writePos++;
    }

    public void putDouble(double d10) {
        setDouble(this.writePos, d10);
        this.writePos += 8;
    }

    public void putFloat(float f10) {
        setFloat(this.writePos, f10);
        this.writePos += 4;
    }

    public void putInt(int i10) {
        setInt(this.writePos, i10);
        this.writePos += 4;
    }

    public void putLong(long j10) {
        setLong(this.writePos, j10);
        this.writePos += 8;
    }

    public void putShort(short s10) {
        setShort(this.writePos, s10);
        this.writePos += 2;
    }

    public boolean requestCapacity(int i10) {
        byte[] bArr = this.buffer;
        if (bArr.length > i10) {
            return true;
        }
        int length = bArr.length;
        this.buffer = Arrays.copyOf(bArr, length + (length >> 1));
        return true;
    }

    public void set(int i10, byte b10) {
        requestCapacity(i10 + 1);
        this.buffer[i10] = b10;
    }

    public void setBoolean(int i10, boolean z10) {
        set(i10, z10 ? (byte) 1 : 0);
    }

    public void setDouble(int i10, double d10) {
        requestCapacity(i10 + 8);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d10);
        int i11 = (int) doubleToRawLongBits;
        byte[] bArr = this.buffer;
        bArr[i10] = (byte) (i11 & 255);
        bArr[i10 + 1] = (byte) ((i11 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((i11 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((i11 >> 24) & 255);
        int i12 = (int) (doubleToRawLongBits >> 32);
        bArr[i10 + 4] = (byte) (i12 & 255);
        bArr[i10 + 5] = (byte) ((i12 >> 8) & 255);
        bArr[i10 + 6] = (byte) ((i12 >> 16) & 255);
        bArr[i10 + 7] = (byte) ((i12 >> 24) & 255);
    }

    public void setFloat(int i10, float f10) {
        requestCapacity(i10 + 4);
        int floatToRawIntBits = Float.floatToRawIntBits(f10);
        byte[] bArr = this.buffer;
        bArr[i10] = (byte) (floatToRawIntBits & 255);
        bArr[i10 + 1] = (byte) ((floatToRawIntBits >> 8) & 255);
        bArr[i10 + 2] = (byte) ((floatToRawIntBits >> 16) & 255);
        bArr[i10 + 3] = (byte) ((floatToRawIntBits >> 24) & 255);
    }

    public void setInt(int i10, int i11) {
        requestCapacity(i10 + 4);
        byte[] bArr = this.buffer;
        bArr[i10] = (byte) (i11 & 255);
        bArr[i10 + 1] = (byte) ((i11 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((i11 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((i11 >> 24) & 255);
    }

    public void setLong(int i10, long j10) {
        requestCapacity(i10 + 8);
        int i11 = (int) j10;
        byte[] bArr = this.buffer;
        bArr[i10] = (byte) (i11 & 255);
        bArr[i10 + 1] = (byte) ((i11 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((i11 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((i11 >> 24) & 255);
        int i12 = (int) (j10 >> 32);
        bArr[i10 + 4] = (byte) (i12 & 255);
        bArr[i10 + 5] = (byte) ((i12 >> 8) & 255);
        bArr[i10 + 6] = (byte) ((i12 >> 16) & 255);
        bArr[i10 + 7] = (byte) ((i12 >> 24) & 255);
    }

    public void setShort(int i10, short s10) {
        requestCapacity(i10 + 2);
        byte[] bArr = this.buffer;
        bArr[i10] = (byte) (s10 & 255);
        bArr[i10 + 1] = (byte) ((s10 >> 8) & 255);
    }

    public int writePosition() {
        return this.writePos;
    }

    public ArrayReadWriteBuf(int i10) {
        this(new byte[i10]);
    }

    public ArrayReadWriteBuf(byte[] bArr) {
        this.buffer = bArr;
        this.writePos = 0;
    }

    public void put(byte b10) {
        set(this.writePos, b10);
        this.writePos++;
    }

    public void set(int i10, byte[] bArr, int i11, int i12) {
        requestCapacity((i12 - i11) + i10);
        System.arraycopy(bArr, i11, this.buffer, i10, i12);
    }

    public ArrayReadWriteBuf(byte[] bArr, int i10) {
        this.buffer = bArr;
        this.writePos = i10;
    }
}
