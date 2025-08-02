package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function1;

public abstract class f {
    public static final e a(int i10, c cVar, Function1 function1) {
        e mVar;
        if (i10 != -2) {
            if (i10 != -1) {
                if (i10 != 0) {
                    if (i10 == Integer.MAX_VALUE) {
                        return new BufferedChannel(Integer.MAX_VALUE, function1);
                    }
                    if (cVar == c.SUSPEND) {
                        return new BufferedChannel(i10, function1);
                    }
                    return new m(i10, cVar, function1);
                } else if (cVar == c.SUSPEND) {
                    mVar = new BufferedChannel(0, function1);
                } else {
                    mVar = new m(1, cVar, function1);
                }
            } else if (cVar == c.SUSPEND) {
                return new m(1, c.DROP_OLDEST, function1);
            } else {
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
        } else if (cVar == c.SUSPEND) {
            mVar = new BufferedChannel(e.f901s.a(), function1);
        } else {
            mVar = new m(1, cVar, function1);
        }
        return mVar;
    }

    public static /* synthetic */ e b(int i10, c cVar, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            cVar = c.SUSPEND;
        }
        if ((i11 & 4) != 0) {
            function1 = null;
        }
        return a(i10, cVar, function1);
    }
}
