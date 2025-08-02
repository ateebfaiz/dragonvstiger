package org.cocos2dx.okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.ByteString;

public abstract class ResponseBody implements Closeable {
    private Reader reader;

    class a extends ResponseBody {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MediaType f1544a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f1545b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BufferedSource f1546c;

        a(MediaType mediaType, long j10, BufferedSource bufferedSource) {
            this.f1544a = mediaType;
            this.f1545b = j10;
            this.f1546c = bufferedSource;
        }

        public long contentLength() {
            return this.f1545b;
        }

        public MediaType contentType() {
            return this.f1544a;
        }

        public BufferedSource source() {
            return this.f1546c;
        }
    }

    static final class b extends Reader {

        /* renamed from: a  reason: collision with root package name */
        private final BufferedSource f1547a;

        /* renamed from: b  reason: collision with root package name */
        private final Charset f1548b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1549c;

        /* renamed from: d  reason: collision with root package name */
        private Reader f1550d;

        b(BufferedSource bufferedSource, Charset charset) {
            this.f1547a = bufferedSource;
            this.f1548b = charset;
        }

        public void close() {
            this.f1549c = true;
            Reader reader = this.f1550d;
            if (reader != null) {
                reader.close();
            } else {
                this.f1547a.close();
            }
        }

        public int read(char[] cArr, int i10, int i11) {
            if (!this.f1549c) {
                Reader reader = this.f1550d;
                if (reader == null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(this.f1547a.inputStream(), Util.bomAwareCharset(this.f1547a, this.f1548b));
                    this.f1550d = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i10, i11);
            }
            throw new IOException("Stream closed");
        }
    }

    private Charset charset() {
        MediaType contentType = contentType();
        if (contentType != null) {
            return contentType.charset(Util.UTF_8);
        }
        return Util.UTF_8;
    }

    public static ResponseBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        Buffer writeString = new Buffer().writeString(str, charset);
        return create(mediaType, writeString.size(), writeString);
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    /* JADX INFO: finally extract failed */
    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            BufferedSource source = source();
            try {
                byte[] readByteArray = source.readByteArray();
                Util.closeQuietly((Closeable) source);
                if (contentLength == -1 || contentLength == ((long) readByteArray.length)) {
                    return readByteArray;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + readByteArray.length + ") disagree");
            } catch (Throwable th) {
                Util.closeQuietly((Closeable) source);
                throw th;
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    public final Reader charStream() {
        Reader reader2 = this.reader;
        if (reader2 != null) {
            return reader2;
        }
        b bVar = new b(source(), charset());
        this.reader = bVar;
        return bVar;
    }

    public void close() {
        Util.closeQuietly((Closeable) source());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final String string() throws IOException {
        BufferedSource source = source();
        try {
            return source.readString(Util.bomAwareCharset(source, charset()));
        } finally {
            Util.closeQuietly((Closeable) source);
        }
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, (long) bArr.length, new Buffer().write(bArr));
    }

    public static ResponseBody create(MediaType mediaType, ByteString byteString) {
        return create(mediaType, (long) byteString.size(), new Buffer().write(byteString));
    }

    public static ResponseBody create(MediaType mediaType, long j10, BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new a(mediaType, j10, bufferedSource);
        }
        throw new NullPointerException("source == null");
    }
}
