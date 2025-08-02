package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzjk extends IOException {
    zzjk() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzjk(String str, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th);
    }

    zzjk(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
