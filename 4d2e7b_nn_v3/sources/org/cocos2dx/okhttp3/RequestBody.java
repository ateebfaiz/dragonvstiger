package org.cocos2dx.okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okio.BufferedSink;
import org.cocos2dx.okio.ByteString;
import org.cocos2dx.okio.Okio;
import org.cocos2dx.okio.Source;

public abstract class RequestBody {

    class a extends RequestBody {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MediaType f1536a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ByteString f1537b;

        a(MediaType mediaType, ByteString byteString) {
            this.f1536a = mediaType;
            this.f1537b = byteString;
        }

        public long contentLength() {
            return (long) this.f1537b.size();
        }

        public MediaType contentType() {
            return this.f1536a;
        }

        public void writeTo(BufferedSink bufferedSink) {
            bufferedSink.write(this.f1537b);
        }
    }

    class b extends RequestBody {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MediaType f1538a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1539b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ byte[] f1540c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f1541d;

        b(MediaType mediaType, int i10, byte[] bArr, int i11) {
            this.f1538a = mediaType;
            this.f1539b = i10;
            this.f1540c = bArr;
            this.f1541d = i11;
        }

        public long contentLength() {
            return (long) this.f1539b;
        }

        public MediaType contentType() {
            return this.f1538a;
        }

        public void writeTo(BufferedSink bufferedSink) {
            bufferedSink.write(this.f1540c, this.f1541d, this.f1539b);
        }
    }

    class c extends RequestBody {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MediaType f1542a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f1543b;

        c(MediaType mediaType, File file) {
            this.f1542a = mediaType;
            this.f1543b = file;
        }

        public long contentLength() {
            return this.f1543b.length();
        }

        public MediaType contentType() {
            return this.f1542a;
        }

        public void writeTo(BufferedSink bufferedSink) {
            Source source = null;
            try {
                source = Okio.source(this.f1543b);
                bufferedSink.writeAll(source);
            } finally {
                Util.closeQuietly((Closeable) source);
            }
        }
    }

    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public long contentLength() throws IOException {
        return -1;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public static RequestBody create(MediaType mediaType, ByteString byteString) {
        return new a(mediaType, byteString);
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr, int i10, int i11) {
        if (bArr != null) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i10, (long) i11);
            return new b(mediaType, i11, bArr, i10);
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(MediaType mediaType, File file) {
        if (file != null) {
            return new c(mediaType, file);
        }
        throw new NullPointerException("file == null");
    }
}
