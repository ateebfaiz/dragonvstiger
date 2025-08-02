package okhttp3.internal.http2;

import kotlin.jvm.internal.m;
import kotlin.text.j;
import okhttp3.internal.Util;
import okio.ByteString;

public final class Http2 {
    private static final String[] BINARY;
    public static final ByteString CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] FLAGS = new String[64];
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final Http2 INSTANCE = new Http2();
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    static {
        String[] strArr = new String[256];
        for (int i10 = 0; i10 < 256; i10++) {
            String binaryString = Integer.toBinaryString(i10);
            m.e(binaryString, "Integer.toBinaryString(it)");
            strArr[i10] = j.y(Util.format("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i11 = iArr[0];
        strArr2[i11 | 8] = m.n(strArr2[i11], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i12 = 0; i12 < 3; i12++) {
            int i13 = iArr2[i12];
            int i14 = iArr[0];
            String[] strArr3 = FLAGS;
            int i15 = i14 | i13;
            strArr3[i15] = strArr3[i14] + "|" + strArr3[i13];
            strArr3[i15 | 8] = strArr3[i14] + "|" + strArr3[i13] + "|PADDED";
        }
        int length = FLAGS.length;
        for (int i16 = 0; i16 < length; i16++) {
            String[] strArr4 = FLAGS;
            if (strArr4[i16] == null) {
                strArr4[i16] = BINARY[i16];
            }
        }
    }

    private Http2() {
    }

    public final String formatFlags(int i10, int i11) {
        String str;
        if (i11 == 0) {
            return "";
        }
        if (!(i10 == 2 || i10 == 3)) {
            if (i10 == 4 || i10 == 6) {
                if (i11 == 1) {
                    return "ACK";
                }
                return BINARY[i11];
            } else if (!(i10 == 7 || i10 == 8)) {
                String[] strArr = FLAGS;
                if (i11 < strArr.length) {
                    str = strArr[i11];
                    m.c(str);
                } else {
                    str = BINARY[i11];
                }
                String str2 = str;
                if (i10 == 5 && (i11 & 4) != 0) {
                    return j.z(str2, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
                }
                if (i10 != 0 || (i11 & 32) == 0) {
                    return str2;
                }
                return j.z(str2, "PRIORITY", "COMPRESSED", false, 4, (Object) null);
            }
        }
        return BINARY[i11];
    }

    public final String formattedType$okhttp(int i10) {
        String[] strArr = FRAME_NAMES;
        if (i10 < strArr.length) {
            return strArr[i10];
        }
        return Util.format("0x%02x", Integer.valueOf(i10));
    }

    public final String frameLog(boolean z10, int i10, int i11, int i12, int i13) {
        String str;
        String formattedType$okhttp = formattedType$okhttp(i12);
        String formatFlags = formatFlags(i12, i13);
        if (z10) {
            str = "<<";
        } else {
            str = ">>";
        }
        return Util.format("%s 0x%08x %5d %-13s %s", str, Integer.valueOf(i10), Integer.valueOf(i11), formattedType$okhttp, formatFlags);
    }
}
