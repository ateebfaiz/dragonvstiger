package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class StrictLineReader implements Closeable {
    private static final byte CR = 13;
    private static final byte LF = 10;
    private byte[] buf;
    /* access modifiers changed from: private */
    public final Charset charset;
    private int end;
    private final InputStream in;
    private int pos;

    public StrictLineReader(InputStream inputStream, Charset charset2) {
        this(inputStream, 8192, charset2);
    }

    private void fillBuf() throws IOException {
        InputStream inputStream = this.in;
        byte[] bArr = this.buf;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.pos = 0;
            this.end = read;
            return;
        }
        throw new EOFException();
    }

    public void close() throws IOException {
        synchronized (this.in) {
            try {
                if (this.buf != null) {
                    this.buf = null;
                    this.in.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean hasUnterminatedLine() {
        if (this.end == -1) {
            return true;
        }
        return false;
    }

    public String readLine() throws IOException {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.in) {
            try {
                if (this.buf != null) {
                    if (this.pos >= this.end) {
                        fillBuf();
                    }
                    for (int i12 = this.pos; i12 != this.end; i12++) {
                        byte[] bArr2 = this.buf;
                        if (bArr2[i12] == 10) {
                            int i13 = this.pos;
                            if (i12 != i13) {
                                i11 = i12 - 1;
                                if (bArr2[i11] == 13) {
                                    String str = new String(bArr2, i13, i11 - i13, this.charset.name());
                                    this.pos = i12 + 1;
                                    return str;
                                }
                            }
                            i11 = i12;
                            String str2 = new String(bArr2, i13, i11 - i13, this.charset.name());
                            this.pos = i12 + 1;
                            return str2;
                        }
                    }
                    AnonymousClass1 r12 = new ByteArrayOutputStream((this.end - this.pos) + 80) {
                        public String toString() {
                            int i10 = this.count;
                            if (i10 > 0 && this.buf[i10 - 1] == 13) {
                                i10--;
                            }
                            try {
                                return new String(this.buf, 0, i10, StrictLineReader.this.charset.name());
                            } catch (UnsupportedEncodingException e10) {
                                throw new AssertionError(e10);
                            }
                        }
                    };
                    loop1:
                    while (true) {
                        byte[] bArr3 = this.buf;
                        int i14 = this.pos;
                        r12.write(bArr3, i14, this.end - i14);
                        this.end = -1;
                        fillBuf();
                        i10 = this.pos;
                        while (true) {
                            if (i10 != this.end) {
                                bArr = this.buf;
                                if (bArr[i10] == 10) {
                                    break loop1;
                                }
                                i10++;
                            }
                        }
                    }
                    int i15 = this.pos;
                    if (i10 != i15) {
                        r12.write(bArr, i15, i10 - i15);
                    }
                    this.pos = i10 + 1;
                    String byteArrayOutputStream = r12.toString();
                    return byteArrayOutputStream;
                }
                throw new IOException("LineReader is closed");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public StrictLineReader(InputStream inputStream, int i10, Charset charset2) {
        if (inputStream == null || charset2 == null) {
            throw null;
        } else if (i10 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset2.equals(Util.US_ASCII)) {
            this.in = inputStream;
            this.charset = charset2;
            this.buf = new byte[i10];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }
}
