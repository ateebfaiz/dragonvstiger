package okio;

import java.util.zip.Deflater;
import kotlin.jvm.internal.m;

/* renamed from: okio.-DeflaterSinkExtensions  reason: invalid class name */
public final class DeflaterSinkExtensions {
    public static final DeflaterSink deflate(Sink sink, Deflater deflater) {
        m.f(sink, "$this$deflate");
        m.f(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink sink, Deflater deflater, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            deflater = new Deflater();
        }
        m.f(sink, "$this$deflate");
        m.f(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }
}
