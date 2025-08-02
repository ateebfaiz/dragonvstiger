package e4;

import c4.b;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;

public interface a {

    /* renamed from: e4.a$a  reason: collision with other inner class name */
    public static final class C0267a {
        public static void a(a aVar) {
        }

        public static c3.a b(a aVar, int i10, int i11, int i12) {
            return null;
        }

        public static void c(a aVar) {
        }

        public static void d(a aVar, int i10, int i11, Function0 function0) {
        }

        public static void e(a aVar, b bVar, b bVar2, b4.a aVar2, int i10, Function0 function0) {
            m.f(bVar, "bitmapFramePreparer");
            m.f(bVar2, "bitmapFrameCache");
            m.f(aVar2, "animationBackend");
        }

        public static /* synthetic */ void f(a aVar, b bVar, b bVar2, b4.a aVar2, int i10, Function0 function0, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 16) != 0) {
                    function0 = null;
                }
                aVar.d(bVar, bVar2, aVar2, i10, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prepareFrames");
        }
    }

    void a(int i10, int i11, Function0 function0);

    c3.a b(int i10, int i11, int i12);

    void c();

    void d(b bVar, b bVar2, b4.a aVar, int i10, Function0 function0);

    void onStop();
}
