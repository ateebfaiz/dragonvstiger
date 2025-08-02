package okio;

import kotlin.jvm.internal.m;

final /* synthetic */ class Okio__OkioKt {
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    public static final BufferedSource buffer(Source source) {
        m.f(source, "$this$buffer");
        return new RealBufferedSource(source);
    }

    public static final BufferedSink buffer(Sink sink) {
        m.f(sink, "$this$buffer");
        return new RealBufferedSink(sink);
    }
}
