package com.facebook.imagepipeline.producers;

import java.util.Map;
import k5.b;
import kotlin.jvm.internal.m;
import x4.j;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final u f20262a = new u();

    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    private u() {
    }

    public static final j a(b bVar, j jVar, j jVar2, Map map) {
        String f10;
        m.f(bVar, "imageRequest");
        if (bVar.c() == b.C0299b.SMALL) {
            return jVar;
        }
        if (bVar.c() == b.C0299b.DEFAULT) {
            return jVar2;
        }
        if (bVar.c() != b.C0299b.DYNAMIC || map == null || (f10 = bVar.f()) == null) {
            return null;
        }
        return (j) map.get(f10);
    }
}
