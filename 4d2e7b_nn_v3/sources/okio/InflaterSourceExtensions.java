package okio;

import java.util.zip.Inflater;
import kotlin.jvm.internal.m;

/* renamed from: okio.-InflaterSourceExtensions  reason: invalid class name */
public final class InflaterSourceExtensions {
    public static final InflaterSource inflate(Source source, Inflater inflater) {
        m.f(source, "$this$inflate");
        m.f(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source source, Inflater inflater, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            inflater = new Inflater();
        }
        m.f(source, "$this$inflate");
        m.f(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }
}
