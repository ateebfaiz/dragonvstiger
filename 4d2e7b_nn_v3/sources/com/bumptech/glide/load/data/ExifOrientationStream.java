package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ExifOrientationStream extends FilterInputStream {
    private static final byte[] EXIF_SEGMENT;
    private static final int ORIENTATION_POSITION;
    private static final int SEGMENT_LENGTH;
    private static final int SEGMENT_START_POSITION = 2;
    private final byte orientation;
    private int position;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        EXIF_SEGMENT = bArr;
        int length = bArr.length;
        SEGMENT_LENGTH = length;
        ORIENTATION_POSITION = length + 2;
    }

    public ExifOrientationStream(InputStream inputStream, int i10) {
        super(inputStream);
        if (i10 < -1 || i10 > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i10);
        }
        this.orientation = (byte) i10;
    }

    public void mark(int i10) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        int i10;
        int i11;
        int i12 = this.position;
        if (i12 < 2 || i12 > (i11 = ORIENTATION_POSITION)) {
            i10 = super.read();
        } else if (i12 == i11) {
            i10 = this.orientation;
        } else {
            i10 = EXIF_SEGMENT[i12 - 2] & 255;
        }
        if (i10 != -1) {
            this.position++;
        }
        return i10;
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public long skip(long j10) throws IOException {
        long skip = super.skip(j10);
        if (skip > 0) {
            this.position = (int) (((long) this.position) + skip);
        }
        return skip;
    }

    public int read(@NonNull byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        int i13 = this.position;
        int i14 = ORIENTATION_POSITION;
        if (i13 > i14) {
            i12 = super.read(bArr, i10, i11);
        } else if (i13 == i14) {
            bArr[i10] = this.orientation;
            i12 = 1;
        } else if (i13 < 2) {
            i12 = super.read(bArr, i10, 2 - i13);
        } else {
            int min = Math.min(i14 - i13, i11);
            System.arraycopy(EXIF_SEGMENT, this.position - 2, bArr, i10, min);
            i12 = min;
        }
        if (i12 > 0) {
            this.position += i12;
        }
        return i12;
    }
}
