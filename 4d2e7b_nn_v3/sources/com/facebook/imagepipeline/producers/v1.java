package com.facebook.imagepipeline.producers;

import e5.j;
import y4.f;

public final class v1 {

    /* renamed from: a  reason: collision with root package name */
    public static final v1 f20290a = new v1();

    private v1() {
    }

    public static final int a(int i10) {
        return (int) (((float) i10) * 1.3333334f);
    }

    public static final boolean b(int i10, int i11, f fVar) {
        if (fVar == null) {
            if (((float) a(i10)) < 2048.0f || a(i11) < 2048) {
                return false;
            }
        } else if (a(i10) < fVar.f24926a || a(i11) < fVar.f24927b) {
            return false;
        }
        return true;
    }

    public static final boolean c(j jVar, f fVar) {
        if (jVar == null) {
            return false;
        }
        int l10 = jVar.l();
        if (l10 == 90 || l10 == 270) {
            return b(jVar.getHeight(), jVar.getWidth(), fVar);
        }
        return b(jVar.getWidth(), jVar.getHeight(), fVar);
    }
}
