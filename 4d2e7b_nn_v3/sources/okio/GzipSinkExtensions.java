package okio;

import kotlin.jvm.internal.m;

/* renamed from: okio.-GzipSinkExtensions  reason: invalid class name */
public final class GzipSinkExtensions {
    public static final GzipSink gzip(Sink sink) {
        m.f(sink, "$this$gzip");
        return new GzipSink(sink);
    }
}
