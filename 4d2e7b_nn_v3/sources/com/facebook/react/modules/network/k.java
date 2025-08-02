package com.facebook.react.modules.network;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class k extends ResponseBody {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ResponseBody f3332a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final i f3333b;

    /* renamed from: c  reason: collision with root package name */
    private BufferedSource f3334c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f3335d = 0;

    class a extends ForwardingSource {
        a(Source source) {
            super(source);
        }

        public long read(Buffer buffer, long j10) {
            long j11;
            boolean z10;
            long read = super.read(buffer, j10);
            k kVar = k.this;
            long h10 = kVar.f3335d;
            int i10 = (read > -1 ? 1 : (read == -1 ? 0 : -1));
            if (i10 != 0) {
                j11 = read;
            } else {
                j11 = 0;
            }
            kVar.f3335d = h10 + j11;
            i a10 = k.this.f3333b;
            long h11 = k.this.f3335d;
            long contentLength = k.this.f3332a.contentLength();
            if (i10 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            a10.a(h11, contentLength, z10);
            return read;
        }
    }

    public k(ResponseBody responseBody, i iVar) {
        this.f3332a = responseBody;
        this.f3333b = iVar;
    }

    private Source k(Source source) {
        return new a(source);
    }

    public long contentLength() {
        return this.f3332a.contentLength();
    }

    public MediaType contentType() {
        return this.f3332a.contentType();
    }

    public long m() {
        return this.f3335d;
    }

    public BufferedSource source() {
        if (this.f3334c == null) {
            this.f3334c = Okio.buffer(k(this.f3332a.source()));
        }
        return this.f3334c;
    }
}
