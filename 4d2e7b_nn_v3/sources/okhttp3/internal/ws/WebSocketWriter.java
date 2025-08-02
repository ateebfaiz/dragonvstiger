package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.jvm.internal.m;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageBuffer = new Buffer();
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final BufferedSink sink;
    private final Buffer sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z10, BufferedSink bufferedSink, Random random2, boolean z11, boolean z12, long j10) {
        byte[] bArr;
        m.f(bufferedSink, "sink");
        m.f(random2, "random");
        this.isClient = z10;
        this.sink = bufferedSink;
        this.random = random2;
        this.perMessageDeflate = z11;
        this.noContextTakeover = z12;
        this.minimumDeflateSize = j10;
        this.sinkBuffer = bufferedSink.getBuffer();
        Buffer.UnsafeCursor unsafeCursor = null;
        if (z10) {
            bArr = new byte[4];
        } else {
            bArr = null;
        }
        this.maskKey = bArr;
        this.maskCursor = z10 ? new Buffer.UnsafeCursor() : unsafeCursor;
    }

    private final void writeControlFrame(int i10, ByteString byteString) throws IOException {
        boolean z10;
        if (!this.writerClosed) {
            int size = byteString.size();
            if (((long) size) <= 125) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.sinkBuffer.writeByte(i10 | 128);
                if (this.isClient) {
                    this.sinkBuffer.writeByte(size | 128);
                    Random random2 = this.random;
                    byte[] bArr = this.maskKey;
                    m.c(bArr);
                    random2.nextBytes(bArr);
                    this.sinkBuffer.write(this.maskKey);
                    if (size > 0) {
                        long size2 = this.sinkBuffer.size();
                        this.sinkBuffer.write(byteString);
                        Buffer buffer = this.sinkBuffer;
                        Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                        m.c(unsafeCursor);
                        buffer.readAndWriteUnsafe(unsafeCursor);
                        this.maskCursor.seek(size2);
                        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.writeByte(size);
                    this.sinkBuffer.write(byteString);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        throw new IOException("closed");
    }

    public void close() {
        MessageDeflater messageDeflater2 = this.messageDeflater;
        if (messageDeflater2 != null) {
            messageDeflater2.close();
        }
    }

    public final Random getRandom() {
        return this.random;
    }

    public final BufferedSink getSink() {
        return this.sink;
    }

    public final void writeClose(int i10, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (!(i10 == 0 && byteString == null)) {
            if (i10 != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i10);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i10);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i10, ByteString byteString) throws IOException {
        int i11;
        m.f(byteString, "data");
        if (!this.writerClosed) {
            this.messageBuffer.write(byteString);
            int i12 = i10 | 128;
            if (this.perMessageDeflate && ((long) byteString.size()) >= this.minimumDeflateSize) {
                MessageDeflater messageDeflater2 = this.messageDeflater;
                if (messageDeflater2 == null) {
                    messageDeflater2 = new MessageDeflater(this.noContextTakeover);
                    this.messageDeflater = messageDeflater2;
                }
                messageDeflater2.deflate(this.messageBuffer);
                i12 = i10 | 192;
            }
            long size = this.messageBuffer.size();
            this.sinkBuffer.writeByte(i12);
            if (this.isClient) {
                i11 = 128;
            } else {
                i11 = 0;
            }
            if (size <= 125) {
                this.sinkBuffer.writeByte(i11 | ((int) size));
            } else if (size <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                this.sinkBuffer.writeByte(i11 | WebSocketProtocol.PAYLOAD_SHORT);
                this.sinkBuffer.writeShort((int) size);
            } else {
                this.sinkBuffer.writeByte(i11 | 127);
                this.sinkBuffer.writeLong(size);
            }
            if (this.isClient) {
                Random random2 = this.random;
                byte[] bArr = this.maskKey;
                m.c(bArr);
                random2.nextBytes(bArr);
                this.sinkBuffer.write(this.maskKey);
                if (size > 0) {
                    Buffer buffer = this.messageBuffer;
                    Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                    m.c(unsafeCursor);
                    buffer.readAndWriteUnsafe(unsafeCursor);
                    this.maskCursor.seek(0);
                    WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            this.sinkBuffer.write(this.messageBuffer, size);
            this.sink.emit();
            return;
        }
        throw new IOException("closed");
    }

    public final void writePing(ByteString byteString) throws IOException {
        m.f(byteString, "payload");
        writeControlFrame(9, byteString);
    }

    public final void writePong(ByteString byteString) throws IOException {
        m.f(byteString, "payload");
        writeControlFrame(10, byteString);
    }
}
