package kotlin.coroutines.jvm.internal;

import com.google.firebase.messaging.Constants;
import java.lang.reflect.Field;
import kotlin.jvm.internal.m;

public abstract class d {
    private static final void a(int i10, int i11) {
        if (i11 > i10) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i10 + ", got " + i11 + ". Please update the Kotlin standard library.").toString());
        }
    }

    private static final c b(BaseContinuationImpl baseContinuationImpl) {
        return (c) baseContinuationImpl.getClass().getAnnotation(c.class);
    }

    private static final int c(BaseContinuationImpl baseContinuationImpl) {
        Integer num;
        int i10;
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField(Constants.ScionAnalytics.PARAM_LABEL);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                i10 = num.intValue();
            } else {
                i10 = 0;
            }
            return i10 - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(BaseContinuationImpl baseContinuationImpl) {
        int i10;
        String str;
        m.f(baseContinuationImpl, "<this>");
        c b10 = b(baseContinuationImpl);
        if (b10 == null) {
            return null;
        }
        a(1, b10.v());
        int c10 = c(baseContinuationImpl);
        if (c10 < 0) {
            i10 = -1;
        } else {
            i10 = b10.l()[c10];
        }
        String b11 = f.f685a.b(baseContinuationImpl);
        if (b11 == null) {
            str = b10.c();
        } else {
            str = b11 + '/' + b10.c();
        }
        return new StackTraceElement(str, b10.m(), b10.f(), i10);
    }
}
