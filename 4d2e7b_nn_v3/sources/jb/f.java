package jb;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.MotionEventCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f12451b = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f12452c = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* renamed from: a  reason: collision with root package name */
    private final b f12453a;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f12454a;

        public a(byte[] bArr, int i10) {
            this.f12454a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i10);
        }

        public short a(int i10) {
            return this.f12454a.getShort(i10);
        }

        public int b(int i10) {
            return this.f12454a.getInt(i10);
        }

        public int c() {
            return this.f12454a.remaining();
        }

        public void d(ByteOrder byteOrder) {
            this.f12454a.order(byteOrder);
        }
    }

    private interface b {
        int getUInt16();

        short getUInt8();

        int read(byte[] bArr, int i10);

        long skip(long j10);
    }

    private static class c implements b {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f12455a;

        public c(InputStream inputStream) {
            this.f12455a = inputStream;
        }

        public int getUInt16() {
            return ((this.f12455a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f12455a.read() & 255);
        }

        public short getUInt8() {
            return (short) (this.f12455a.read() & 255);
        }

        public int read(byte[] bArr, int i10) {
            int i11 = i10;
            while (i11 > 0) {
                int read = this.f12455a.read(bArr, i10 - i11, i11);
                if (read == -1) {
                    break;
                }
                i11 -= read;
            }
            return i10 - i11;
        }

        public long skip(long j10) {
            if (j10 < 0) {
                return 0;
            }
            long j11 = j10;
            while (j11 > 0) {
                long skip = this.f12455a.skip(j11);
                if (skip <= 0) {
                    if (this.f12455a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j11 -= skip;
            }
            return j10 - j11;
        }
    }

    public f(InputStream inputStream) {
        this.f12453a = new c(inputStream);
    }

    private static int a(int i10, int i11) {
        return i10 + 2 + (i11 * 12);
    }

    public static void b(ExifInterface exifInterface, int i10, int i11, String str) {
        String[] strArr = {ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_DATETIME, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_FLASH, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_WHITE_BALANCE};
        try {
            ExifInterface exifInterface2 = new ExifInterface(str);
            for (int i12 = 0; i12 < 22; i12++) {
                String str2 = strArr[i12];
                String attribute = exifInterface.getAttribute(str2);
                if (!TextUtils.isEmpty(attribute)) {
                    exifInterface2.setAttribute(str2, attribute);
                }
            }
            exifInterface2.setAttribute(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i10));
            exifInterface2.setAttribute(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i11));
            exifInterface2.setAttribute(ExifInterface.TAG_ORIENTATION, "0");
            exifInterface2.saveAttributes();
        } catch (IOException e10) {
            Log.d("ImageHeaderParser", e10.getMessage());
        }
    }

    private static boolean d(int i10) {
        if ((i10 & 65496) == 65496 || i10 == 19789 || i10 == 18761) {
            return true;
        }
        return false;
    }

    private boolean e(byte[] bArr, int i10) {
        boolean z10;
        if (bArr == null || i10 <= f12451b.length) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            int i11 = 0;
            while (true) {
                byte[] bArr2 = f12451b;
                if (i11 >= bArr2.length) {
                    break;
                } else if (bArr[i11] != bArr2[i11]) {
                    return false;
                } else {
                    i11++;
                }
            }
        }
        return z10;
    }

    private int f() {
        short uInt8;
        int uInt16;
        long j10;
        long skip;
        do {
            short uInt82 = this.f12453a.getUInt8();
            if (uInt82 != 255) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unknown segmentId=" + uInt82);
                }
                return -1;
            }
            uInt8 = this.f12453a.getUInt8();
            if (uInt8 == 218) {
                return -1;
            }
            if (uInt8 == 217) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            uInt16 = this.f12453a.getUInt16() - 2;
            if (uInt8 == 225) {
                return uInt16;
            }
            j10 = (long) uInt16;
            skip = this.f12453a.skip(j10);
        } while (skip == j10);
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + uInt8 + ", wanted to skip: " + uInt16 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    private static int g(a aVar) {
        ByteOrder byteOrder;
        short a10 = aVar.a(6);
        if (a10 == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (a10 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unknown endianness = " + a10);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        aVar.d(byteOrder);
        int b10 = aVar.b(10) + 6;
        short a11 = aVar.a(b10);
        for (int i10 = 0; i10 < a11; i10++) {
            int a12 = a(b10, i10);
            short a13 = aVar.a(a12);
            if (a13 == 274) {
                short a14 = aVar.a(a12 + 2);
                if (a14 >= 1 && a14 <= 12) {
                    int b11 = aVar.b(a12 + 4);
                    if (b11 >= 0) {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got tagIndex=" + i10 + " tagType=" + a13 + " formatCode=" + a14 + " componentCount=" + b11);
                        }
                        int i11 = b11 + f12452c[a14];
                        if (i11 <= 4) {
                            int i12 = a12 + 8;
                            if (i12 < 0 || i12 > aVar.c()) {
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + i12 + " tagType=" + a13);
                                }
                            } else if (i11 >= 0 && i11 + i12 <= aVar.c()) {
                                return aVar.a(i12);
                            } else {
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + a13);
                                }
                            }
                        } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + a14);
                        }
                    } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Got invalid format code = " + a14);
                }
            }
        }
        return -1;
    }

    private int h(byte[] bArr, int i10) {
        int read = this.f12453a.read(bArr, i10);
        if (read != i10) {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unable to read exif segment data, length: " + i10 + ", actually read: " + read);
            }
            return -1;
        } else if (e(bArr, i10)) {
            return g(new a(bArr, i10));
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    public int c() {
        int uInt16 = this.f12453a.getUInt16();
        if (!d(uInt16)) {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Parser doesn't handle magic number: " + uInt16);
            }
            return -1;
        }
        int f10 = f();
        if (f10 != -1) {
            return h(new byte[f10], f10);
        }
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
        }
        return -1;
    }
}
