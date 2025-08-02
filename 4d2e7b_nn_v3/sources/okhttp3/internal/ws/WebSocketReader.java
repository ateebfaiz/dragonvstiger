package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.m;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public final class WebSocketReader implements Closeable {
    private boolean closed;
    private final Buffer controlFrameBuffer = new Buffer();
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageFrameBuffer = new Buffer();
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;
    private final BufferedSource source;

    public interface FrameCallback {
        void onReadClose(int i10, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    public WebSocketReader(boolean z10, BufferedSource bufferedSource, FrameCallback frameCallback2, boolean z11, boolean z12) {
        byte[] bArr;
        m.f(bufferedSource, "source");
        m.f(frameCallback2, "frameCallback");
        this.isClient = z10;
        this.source = bufferedSource;
        this.frameCallback = frameCallback2;
        this.perMessageDeflate = z11;
        this.noContextTakeover = z12;
        Buffer.UnsafeCursor unsafeCursor = null;
        if (z10) {
            bArr = null;
        } else {
            bArr = new byte[4];
        }
        this.maskKey = bArr;
        this.maskCursor = !z10 ? new Buffer.UnsafeCursor() : unsafeCursor;
    }

    private final void readControlFrame() throws IOException {
        String str;
        short s10;
        long j10 = this.frameLength;
        if (j10 > 0) {
            this.source.readFully(this.controlFrameBuffer, j10);
            if (!this.isClient) {
                Buffer buffer = this.controlFrameBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                m.c(unsafeCursor);
                buffer.readAndWriteUnsafe(unsafeCursor);
                this.maskCursor.seek(0);
                WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                Buffer.UnsafeCursor unsafeCursor2 = this.maskCursor;
                byte[] bArr = this.maskKey;
                m.c(bArr);
                webSocketProtocol.toggleMask(unsafeCursor2, bArr);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                long size = this.controlFrameBuffer.size();
                if (size != 1) {
                    if (size != 0) {
                        s10 = this.controlFrameBuffer.readShort();
                        str = this.controlFrameBuffer.readUtf8();
                        String closeCodeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(s10);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    } else {
                        s10 = 1005;
                        str = "";
                    }
                    this.frameCallback.onReadClose(s10, str);
                    this.closed = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Util.toHexString(this.opcode));
        }
    }

    /* JADX INFO: finally extract failed */
    private final void readHeader() throws IOException, ProtocolException {
        boolean z10;
        boolean z11;
        boolean z12;
        String str;
        boolean z13;
        if (!this.closed) {
            long timeoutNanos = this.source.timeout().timeoutNanos();
            this.source.timeout().clearTimeout();
            try {
                int and = Util.and(this.source.readByte(), 255);
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                int i10 = and & 15;
                this.opcode = i10;
                boolean z14 = false;
                if ((and & 128) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.isFinalFrame = z10;
                if ((and & 8) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                this.isControlFrame = z11;
                if (!z11 || z10) {
                    if ((and & 64) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (i10 == 1 || i10 == 2) {
                        if (!z12) {
                            z13 = false;
                        } else if (this.perMessageDeflate) {
                            z13 = true;
                        } else {
                            throw new ProtocolException("Unexpected rsv1 flag");
                        }
                        this.readingCompressedMessage = z13;
                    } else if (z12) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    if ((and & 32) != 0) {
                        throw new ProtocolException("Unexpected rsv2 flag");
                    } else if ((and & 16) == 0) {
                        int and2 = Util.and(this.source.readByte(), 255);
                        if ((and2 & 128) != 0) {
                            z14 = true;
                        }
                        if (z14 == this.isClient) {
                            if (this.isClient) {
                                str = "Server-sent frames must not be masked.";
                            } else {
                                str = "Client-sent frames must be masked.";
                            }
                            throw new ProtocolException(str);
                        }
                        long j10 = (long) (and2 & 127);
                        this.frameLength = j10;
                        if (j10 == ((long) WebSocketProtocol.PAYLOAD_SHORT)) {
                            this.frameLength = (long) Util.and(this.source.readShort(), 65535);
                        } else if (j10 == ((long) 127)) {
                            long readLong = this.source.readLong();
                            this.frameLength = readLong;
                            if (readLong < 0) {
                                throw new ProtocolException("Frame length 0x" + Util.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                            }
                        }
                        if (this.isControlFrame && this.frameLength > 125) {
                            throw new ProtocolException("Control frame must be less than 125B.");
                        } else if (z14) {
                            BufferedSource bufferedSource = this.source;
                            byte[] bArr = this.maskKey;
                            m.c(bArr);
                            bufferedSource.readFully(bArr);
                        }
                    } else {
                        throw new ProtocolException("Unexpected rsv3 flag");
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    private final void readMessage() throws IOException {
        while (!this.closed) {
            long j10 = this.frameLength;
            if (j10 > 0) {
                this.source.readFully(this.messageFrameBuffer, j10);
                if (!this.isClient) {
                    Buffer buffer = this.messageFrameBuffer;
                    Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                    m.c(unsafeCursor);
                    buffer.readAndWriteUnsafe(unsafeCursor);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                    Buffer.UnsafeCursor unsafeCursor2 = this.maskCursor;
                    byte[] bArr = this.maskKey;
                    m.c(bArr);
                    webSocketProtocol.toggleMask(unsafeCursor2, bArr);
                    this.maskCursor.close();
                }
            }
            if (!this.isFinalFrame) {
                readUntilNonControlFrame();
                if (this.opcode != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + Util.toHexString(this.opcode));
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }

    private final void readMessageFrame() throws IOException {
        int i10 = this.opcode;
        if (i10 == 1 || i10 == 2) {
            readMessage();
            if (this.readingCompressedMessage) {
                MessageInflater messageInflater2 = this.messageInflater;
                if (messageInflater2 == null) {
                    messageInflater2 = new MessageInflater(this.noContextTakeover);
                    this.messageInflater = messageInflater2;
                }
                messageInflater2.inflate(this.messageFrameBuffer);
            }
            if (i10 == 1) {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
            } else {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Util.toHexString(i10));
        }
    }

    private final void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }

    public void close() throws IOException {
        MessageInflater messageInflater2 = this.messageInflater;
        if (messageInflater2 != null) {
            messageInflater2.close();
        }
    }

    public final BufferedSource getSource() {
        return this.source;
    }

    public final void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
