package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.util.e;
import java.nio.ByteBuffer;

public class g extends g0 {
    public g() {
        super(ByteBuffer.class);
    }

    /* renamed from: x */
    public void f(ByteBuffer byteBuffer, f fVar, b0 b0Var) {
        if (byteBuffer.hasArray()) {
            int position = byteBuffer.position();
            fVar.N(byteBuffer.array(), byteBuffer.arrayOffset() + position, byteBuffer.limit() - position);
            return;
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        if (asReadOnlyBuffer.position() > 0) {
            asReadOnlyBuffer.rewind();
        }
        e eVar = new e(asReadOnlyBuffer);
        fVar.K(eVar, asReadOnlyBuffer.remaining());
        eVar.close();
    }
}
