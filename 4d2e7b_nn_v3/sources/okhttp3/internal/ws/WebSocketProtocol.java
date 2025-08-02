package okhttp3.internal.ws;

import kotlin.jvm.internal.m;
import okio.Buffer;
import okio.ByteString;

public final class WebSocketProtocol {
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    public final String acceptHeader(String str) {
        m.f(str, "key");
        ByteString.Companion companion = ByteString.Companion;
        return companion.encodeUtf8(str + ACCEPT_MAGIC).sha1().base64();
    }

    public final String closeCodeExceptionMessage(int i10) {
        if (i10 < 1000 || i10 >= 5000) {
            return "Code must be in range [1000,5000): " + i10;
        } else if ((1004 > i10 || 1006 < i10) && (1015 > i10 || 2999 < i10)) {
            return null;
        } else {
            return "Code " + i10 + " is reserved and may not be used.";
        }
    }

    public final void toggleMask(Buffer.UnsafeCursor unsafeCursor, byte[] bArr) {
        m.f(unsafeCursor, "cursor");
        m.f(bArr, "key");
        int length = bArr.length;
        int i10 = 0;
        do {
            byte[] bArr2 = unsafeCursor.data;
            int i11 = unsafeCursor.start;
            int i12 = unsafeCursor.end;
            if (bArr2 != null) {
                while (i11 < i12) {
                    int i13 = i10 % length;
                    bArr2[i11] = (byte) (bArr2[i11] ^ bArr[i13]);
                    i11++;
                    i10 = i13 + 1;
                }
            }
        } while (unsafeCursor.next() != -1);
    }

    public final void validateCloseCode(int i10) {
        boolean z10;
        String closeCodeExceptionMessage = closeCodeExceptionMessage(i10);
        if (closeCodeExceptionMessage == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            m.c(closeCodeExceptionMessage);
            throw new IllegalArgumentException(closeCodeExceptionMessage.toString());
        }
    }
}
