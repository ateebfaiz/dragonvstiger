package kotlinx.coroutines.channels;

import kotlin.coroutines.d;

public interface ChannelIterator {

    public static final class DefaultImpls {
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0050  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ java.lang.Object a(kotlinx.coroutines.channels.ChannelIterator r4, kotlin.coroutines.d r5) {
            /*
                boolean r0 = r5 instanceof kotlinx.coroutines.channels.ChannelIterator$next0$1
                if (r0 == 0) goto L_0x0013
                r0 = r5
                kotlinx.coroutines.channels.ChannelIterator$next0$1 r0 = (kotlinx.coroutines.channels.ChannelIterator$next0$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                kotlinx.coroutines.channels.ChannelIterator$next0$1 r0 = new kotlinx.coroutines.channels.ChannelIterator$next0$1
                r0.<init>(r5)
            L_0x0018:
                java.lang.Object r5 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                java.lang.Object r4 = r0.L$0
                kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
                kotlin.p.b(r5)
                goto L_0x0043
            L_0x002d:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L_0x0035:
                kotlin.p.b(r5)
                r0.L$0 = r4
                r0.label = r3
                java.lang.Object r5 = r4.a(r0)
                if (r5 != r1) goto L_0x0043
                return r1
            L_0x0043:
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L_0x0050
                java.lang.Object r4 = r4.next()
                return r4
            L_0x0050:
                kotlinx.coroutines.channels.k r4 = new kotlinx.coroutines.channels.k
                java.lang.String r5 = "Channel was closed"
                r4.<init>(r5)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelIterator.DefaultImpls.a(kotlinx.coroutines.channels.ChannelIterator, kotlin.coroutines.d):java.lang.Object");
        }
    }

    Object a(d dVar);

    Object next();
}
