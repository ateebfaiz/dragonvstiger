package com.facebook.react.views.scroll;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.g0;
import e6.f;
import java.util.Map;

public abstract class c {

    public interface a {
        void flashScrollIndicators(Object obj);

        void scrollTo(Object obj, b bVar);

        void scrollToEnd(Object obj, C0058c cVar);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f4135a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4136b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f4137c;

        b(int i10, int i11, boolean z10) {
            this.f4135a = i10;
            this.f4136b = i11;
            this.f4137c = z10;
        }
    }

    /* renamed from: com.facebook.react.views.scroll.c$c  reason: collision with other inner class name */
    public static class C0058c {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f4138a;

        C0058c(boolean z10) {
            this.f4138a = z10;
        }
    }

    public static Map a() {
        return f.f("scrollTo", 1, "scrollToEnd", 2, "flashScrollIndicators", 3);
    }

    public static void b(a aVar, Object obj, int i10, ReadableArray readableArray) {
        p5.a.c(aVar);
        p5.a.c(obj);
        if (i10 == 1) {
            d(aVar, obj, (ReadableArray) p5.a.c(readableArray));
        } else if (i10 == 2) {
            e(aVar, obj, (ReadableArray) p5.a.c(readableArray));
        } else if (i10 == 3) {
            aVar.flashScrollIndicators(obj);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", new Object[]{Integer.valueOf(i10), aVar.getClass().getSimpleName()}));
        }
    }

    public static void c(a aVar, Object obj, String str, ReadableArray readableArray) {
        p5.a.c(aVar);
        p5.a.c(obj);
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -402165208:
                if (str.equals("scrollTo")) {
                    c10 = 0;
                    break;
                }
                break;
            case 28425985:
                if (str.equals("flashScrollIndicators")) {
                    c10 = 1;
                    break;
                }
                break;
            case 2055114131:
                if (str.equals("scrollToEnd")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                d(aVar, obj, (ReadableArray) p5.a.c(readableArray));
                return;
            case 1:
                aVar.flashScrollIndicators(obj);
                return;
            case 2:
                e(aVar, obj, (ReadableArray) p5.a.c(readableArray));
                return;
            default:
                throw new IllegalArgumentException(String.format("Unsupported command %s received by %s.", new Object[]{str, aVar.getClass().getSimpleName()}));
        }
    }

    private static void d(a aVar, Object obj, ReadableArray readableArray) {
        aVar.scrollTo(obj, new b(Math.round(g0.c(readableArray.getDouble(0))), Math.round(g0.c(readableArray.getDouble(1))), readableArray.getBoolean(2)));
    }

    private static void e(a aVar, Object obj, ReadableArray readableArray) {
        aVar.scrollToEnd(obj, new C0058c(readableArray.getBoolean(0)));
    }
}
