package okio;

import kotlin.jvm.internal.m;

/* renamed from: okio.-GzipSourceExtensions  reason: invalid class name */
public final class GzipSourceExtensions {
    private static final int FCOMMENT = 4;
    private static final int FEXTRA = 2;
    private static final int FHCRC = 1;
    private static final int FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;

    /* access modifiers changed from: private */
    public static final boolean getBit(int i10, int i11) {
        return ((i10 >> i11) & 1) == 1;
    }

    public static final GzipSource gzip(Source source) {
        m.f(source, "$this$gzip");
        return new GzipSource(source);
    }
}
