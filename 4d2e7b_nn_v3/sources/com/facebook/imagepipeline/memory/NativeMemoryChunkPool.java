package com.facebook.imagepipeline.memory;

import h5.f0;
import h5.g0;
import y2.d;

@d
public class NativeMemoryChunkPool extends f {
    @d
    public NativeMemoryChunkPool(b3.d dVar, f0 f0Var, g0 g0Var) {
        super(dVar, f0Var, g0Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: E */
    public NativeMemoryChunk g(int i10) {
        return new NativeMemoryChunk(i10);
    }
}
