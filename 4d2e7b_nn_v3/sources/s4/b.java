package s4;

import com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.m;
import w4.d;
import x4.n;
import z4.g;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f23871a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f23872b;

    /* renamed from: c  reason: collision with root package name */
    private static a f23873c;

    private b() {
    }

    public static final a a(d dVar, g gVar, n nVar, boolean z10, boolean z11, int i10, ExecutorService executorService) {
        if (!f23872b) {
            Class<AnimatedFactoryV2Impl> cls = AnimatedFactoryV2Impl.class;
            try {
                Class cls2 = Boolean.TYPE;
                AnimatedFactoryV2Impl newInstance = cls.getConstructor(new Class[]{d.class, g.class, n.class, cls2, cls2, Integer.TYPE, w2.g.class}).newInstance(new Object[]{dVar, gVar, nVar, Boolean.valueOf(z10), Boolean.valueOf(z11), Integer.valueOf(i10), executorService});
                m.d(newInstance, "null cannot be cast to non-null type com.facebook.imagepipeline.animated.factory.AnimatedFactory");
                f23873c = newInstance;
            } catch (Throwable unused) {
            }
            if (f23873c != null) {
                f23872b = true;
            }
        }
        return f23873c;
    }
}
