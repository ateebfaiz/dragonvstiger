package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;

@c(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", l = {72, 73}, m = "invokeSuspend")
final class TickerChannelsKt$ticker$3 extends SuspendLambda implements Function2<n, d, Object> {
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ long $initialDelayMillis;
    final /* synthetic */ q $mode;
    private /* synthetic */ Object L$0;
    int label;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f876a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                kotlinx.coroutines.channels.q[] r0 = kotlinx.coroutines.channels.q.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.channels.q r1 = kotlinx.coroutines.channels.q.FIXED_PERIOD     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.channels.q r1 = kotlinx.coroutines.channels.q.FIXED_DELAY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f876a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt$ticker$3.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TickerChannelsKt$ticker$3(q qVar, long j10, long j11, d dVar) {
        super(2, dVar);
        this.$mode = qVar;
        this.$delayMillis = j10;
        this.$initialDelayMillis = j11;
    }

    public final d k(Object obj, d dVar) {
        TickerChannelsKt$ticker$3 tickerChannelsKt$ticker$3 = new TickerChannelsKt$ticker$3(this.$mode, this.$delayMillis, this.$initialDelayMillis, dVar);
        tickerChannelsKt$ticker$3.L$0 = obj;
        return tickerChannelsKt$ticker$3;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            n nVar = (n) this.L$0;
            int i11 = a.f876a[this.$mode.ordinal()];
            if (i11 == 1) {
                long j10 = this.$delayMillis;
                long j11 = this.$initialDelayMillis;
                p i12 = nVar.i();
                this.label = 1;
                if (TickerChannelsKt.d(j10, j11, i12, this) == c10) {
                    return c10;
                }
            } else if (i11 == 2) {
                long j12 = this.$delayMillis;
                long j13 = this.$initialDelayMillis;
                p i13 = nVar.i();
                this.label = 2;
                if (TickerChannelsKt.c(j12, j13, i13, this) == c10) {
                    return c10;
                }
            }
        } else if (i10 == 1 || i10 == 2) {
            p.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f12577a;
    }

    /* renamed from: u */
    public final Object invoke(n nVar, d dVar) {
        return ((TickerChannelsKt$ticker$3) k(nVar, dVar)).n(Unit.f12577a);
    }
}
