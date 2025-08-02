package com.facebook.react.views.image;

import android.graphics.Shader;
import kotlin.jvm.internal.m;
import w3.p;
import z2.a;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f4020a = new d();

    private d() {
    }

    public static final Shader.TileMode a() {
        return Shader.TileMode.CLAMP;
    }

    public static final p.b b() {
        p.b bVar = p.b.f24590i;
        m.e(bVar, "CENTER_CROP");
        return bVar;
    }

    public static final p.b c(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        p.b bVar = p.b.f24582a;
                        m.e(bVar, "FIT_XY");
                        return bVar;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        p.b bVar2 = p.b.f24589h;
                        m.e(bVar2, "CENTER_INSIDE");
                        return bVar2;
                    }
                    break;
                case -934531685:
                    if (str.equals("repeat")) {
                        return i.f4023l.a();
                    }
                    break;
                case 94852023:
                    if (str.equals("cover")) {
                        p.b bVar3 = p.b.f24590i;
                        m.e(bVar3, "CENTER_CROP");
                        return bVar3;
                    }
                    break;
                case 951526612:
                    if (str.equals("contain")) {
                        p.b bVar4 = p.b.f24586e;
                        m.e(bVar4, "FIT_CENTER");
                        return bVar4;
                    }
                    break;
            }
        }
        if (str != null) {
            a.G("ReactNative", "Invalid resize mode: '" + str + "'");
        }
        return b();
    }

    public static final Shader.TileMode d(String str) {
        if (m.b("contain", str) || m.b("cover", str) || m.b("stretch", str) || m.b("center", str)) {
            return Shader.TileMode.CLAMP;
        }
        if (m.b("repeat", str)) {
            return Shader.TileMode.REPEAT;
        }
        if (str != null) {
            a.G("ReactNative", "Invalid resize mode: '" + str + "'");
        }
        return a();
    }
}
