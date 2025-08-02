package com.alpha0010.fs;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.jvm.internal.m;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
import vb.n;

public final class d extends ResponseBody {

    /* renamed from: a  reason: collision with root package name */
    private final ResponseBody f18314a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final n f18315b;

    /* renamed from: c  reason: collision with root package name */
    private BufferedSource f18316c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f18317d;

    public static final class a extends ForwardingSource {

        /* renamed from: a  reason: collision with root package name */
        private long f18318a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f18319b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d dVar, BufferedSource bufferedSource) {
            super(bufferedSource);
            this.f18319b = dVar;
        }

        public long read(Buffer buffer, long j10) {
            boolean z10;
            long j11;
            m.f(buffer, "sink");
            long read = super.read(buffer, j10);
            if (read == -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            long j12 = this.f18318a;
            if (z10) {
                j11 = 0;
            } else {
                j11 = read;
            }
            this.f18318a = j12 + j11;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f18319b.f18317d > 150 || z10) {
                this.f18319b.f18317d = currentTimeMillis;
                this.f18319b.f18315b.e(Long.valueOf(this.f18318a), Long.valueOf(this.f18319b.contentLength()), Boolean.valueOf(z10));
            }
            return read;
        }
    }

    public d(ResponseBody responseBody, n nVar) {
        m.f(responseBody, "responseBody");
        m.f(nVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f18314a = responseBody;
        this.f18315b = nVar;
    }

    public long contentLength() {
        return this.f18314a.contentLength();
    }

    public MediaType contentType() {
        return this.f18314a.contentType();
    }

    public BufferedSource source() {
        BufferedSource bufferedSource = this.f18316c;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        BufferedSource buffer = Okio.buffer((Source) new a(this, this.f18314a.source()));
        this.f18316c = buffer;
        return buffer;
    }
}
