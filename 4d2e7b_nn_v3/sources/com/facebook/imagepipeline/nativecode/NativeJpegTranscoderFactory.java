package com.facebook.imagepipeline.nativecode;

import m5.c;
import q4.b;
import y2.d;

@d
public class NativeJpegTranscoderFactory implements m5.d {

    /* renamed from: a  reason: collision with root package name */
    private final int f19995a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f19996b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f19997c;

    @d
    public NativeJpegTranscoderFactory(int i10, boolean z10, boolean z11) {
        this.f19995a = i10;
        this.f19996b = z10;
        this.f19997c = z11;
    }

    @d
    public c createImageTranscoder(q4.c cVar, boolean z10) {
        if (cVar != b.f23216b) {
            return null;
        }
        return new NativeJpegTranscoder(z10, this.f19995a, this.f19996b, this.f19997c);
    }
}
