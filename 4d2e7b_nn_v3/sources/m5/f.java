package m5;

import kotlin.jvm.internal.m;
import q4.c;
import z4.p;

public final class f implements d {

    /* renamed from: a  reason: collision with root package name */
    private final int f22616a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22617b;

    /* renamed from: c  reason: collision with root package name */
    private final d f22618c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f22619d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f22620e;

    public f(int i10, boolean z10, d dVar, Integer num, boolean z11) {
        this.f22616a = i10;
        this.f22617b = z10;
        this.f22618c = dVar;
        this.f22619d = num;
        this.f22620e = z11;
    }

    private final c a(c cVar, boolean z10) {
        d dVar = this.f22618c;
        if (dVar != null) {
            return dVar.createImageTranscoder(cVar, z10);
        }
        return null;
    }

    private final c b(c cVar, boolean z10) {
        Integer num = this.f22619d;
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            return c(cVar, z10);
        }
        if (intValue == 1) {
            return d(cVar, z10);
        }
        throw new IllegalArgumentException("Invalid ImageTranscoderType");
    }

    private final c c(c cVar, boolean z10) {
        return com.facebook.imagepipeline.nativecode.c.a(this.f22616a, this.f22617b, this.f22620e).createImageTranscoder(cVar, z10);
    }

    private final c d(c cVar, boolean z10) {
        c createImageTranscoder = new h(this.f22616a).createImageTranscoder(cVar, z10);
        m.e(createImageTranscoder, "SimpleImageTranscoderFac…ormat, isResizingEnabled)");
        return createImageTranscoder;
    }

    public c createImageTranscoder(c cVar, boolean z10) {
        m.f(cVar, "imageFormat");
        c a10 = a(cVar, z10);
        if (a10 == null) {
            a10 = b(cVar, z10);
        }
        if (a10 == null && p.a()) {
            a10 = c(cVar, z10);
        }
        if (a10 == null) {
            return d(cVar, z10);
        }
        return a10;
    }
}
