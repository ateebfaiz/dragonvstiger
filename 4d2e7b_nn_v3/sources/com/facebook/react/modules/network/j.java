package com.facebook.react.modules.network;

import java.io.OutputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;

class j extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    private final RequestBody f3328a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final i f3329b;

    /* renamed from: c  reason: collision with root package name */
    private long f3330c = 0;

    public j(RequestBody requestBody, i iVar) {
        this.f3328a = requestBody;
        this.f3329b = iVar;
    }

    private Sink b(BufferedSink bufferedSink) {
        return Okio.sink((OutputStream) new a(bufferedSink.outputStream()));
    }

    public long contentLength() {
        if (this.f3330c == 0) {
            this.f3330c = this.f3328a.contentLength();
        }
        return this.f3330c;
    }

    public MediaType contentType() {
        return this.f3328a.contentType();
    }

    public void writeTo(BufferedSink bufferedSink) {
        BufferedSink buffer = Okio.buffer(b(bufferedSink));
        contentLength();
        this.f3328a.writeTo(buffer);
        buffer.flush();
    }

    class a extends b {
        a(OutputStream outputStream) {
            super(outputStream);
        }

        private void b() {
            boolean z10;
            long a10 = a();
            long contentLength = j.this.contentLength();
            i a11 = j.this.f3329b;
            if (a10 == contentLength) {
                z10 = true;
            } else {
                z10 = false;
            }
            a11.a(a10, contentLength, z10);
        }

        public void write(byte[] bArr, int i10, int i11) {
            super.write(bArr, i10, i11);
            b();
        }

        public void write(int i10) {
            super.write(i10);
            b();
        }
    }
}
