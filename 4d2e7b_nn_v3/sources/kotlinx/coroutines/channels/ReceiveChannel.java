package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.d;
import kotlinx.coroutines.selects.g;

public interface ReceiveChannel {

    public static final class DefaultImpls {
        public static /* synthetic */ void a(ReceiveChannel receiveChannel, CancellationException cancellationException, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    cancellationException = null;
                }
                receiveChannel.b(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.Object b(kotlinx.coroutines.channels.ReceiveChannel r4, kotlin.coroutines.d r5) {
            /*
                boolean r0 = r5 instanceof kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1
                if (r0 == 0) goto L_0x0013
                r0 = r5
                kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1 r0 = (kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1 r0 = new kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1
                r0.<init>(r5)
            L_0x0018:
                java.lang.Object r5 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L_0x0037
                if (r2 != r3) goto L_0x002f
                kotlin.p.b(r5)
                kotlinx.coroutines.channels.g r5 = (kotlinx.coroutines.channels.g) r5
                java.lang.Object r4 = r5.k()
                goto L_0x0043
            L_0x002f:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L_0x0037:
                kotlin.p.b(r5)
                r0.label = r3
                java.lang.Object r4 = r4.h(r0)
                if (r4 != r1) goto L_0x0043
                return r1
            L_0x0043:
                java.lang.Object r4 = kotlinx.coroutines.channels.g.f(r4)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.b(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.d):java.lang.Object");
        }
    }

    void b(CancellationException cancellationException);

    g e();

    g f();

    Object g();

    Object h(d dVar);

    ChannelIterator iterator();
}
