package com.fasterxml.jackson.databind.ser.std;

import com.alibaba.pdns.x.c;
import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.i;
import java.math.BigDecimal;
import java.math.BigInteger;

public class v extends g0 implements i {

    /* renamed from: d  reason: collision with root package name */
    public static final v f5586d = new v(Number.class);

    /* renamed from: c  reason: collision with root package name */
    protected final boolean f5587c;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5588a;

        static {
            int[] iArr = new int[i.c.values().length];
            f5588a = iArr;
            try {
                iArr[i.c.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static final class b extends m0 {

        /* renamed from: c  reason: collision with root package name */
        static final b f5589c = new b();

        public b() {
            super(BigDecimal.class);
        }

        public boolean d(b0 b0Var, Object obj) {
            return false;
        }

        public void f(Object obj, f fVar, b0 b0Var) {
            String str;
            if (fVar.y(f.b.WRITE_BIGDECIMAL_AS_PLAIN)) {
                BigDecimal bigDecimal = (BigDecimal) obj;
                if (!y(fVar, bigDecimal)) {
                    b0Var.g0(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", new Object[]{Integer.valueOf(bigDecimal.scale()), Integer.valueOf(c.f18290d), Integer.valueOf(c.f18290d)}), new Object[0]);
                }
                str = bigDecimal.toPlainString();
            } else {
                str = obj.toString();
            }
            fVar.s0(str);
        }

        public String x(Object obj) {
            throw new IllegalStateException();
        }

        /* access modifiers changed from: protected */
        public boolean y(f fVar, BigDecimal bigDecimal) {
            int scale = bigDecimal.scale();
            if (scale < -9999 || scale > 9999) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(Class cls) {
        super(cls, false);
        boolean z10 = false;
        this.f5587c = cls == BigInteger.class ? true : z10;
    }

    public static o x() {
        return b.f5589c;
    }

    public o a(b0 b0Var, d dVar) {
        i.d q10 = q(b0Var, dVar, c());
        if (q10 == null || a.f5588a[q10.i().ordinal()] != 1) {
            return this;
        }
        if (c() == BigDecimal.class) {
            return x();
        }
        return l0.f5560c;
    }

    /* renamed from: y */
    public void f(Number number, f fVar, b0 b0Var) {
        if (number instanceof BigDecimal) {
            fVar.a0((BigDecimal) number);
        } else if (number instanceof BigInteger) {
            fVar.b0((BigInteger) number);
        } else if (number instanceof Long) {
            fVar.Y(number.longValue());
        } else if (number instanceof Double) {
            fVar.V(number.doubleValue());
        } else if (number instanceof Float) {
            fVar.W(number.floatValue());
        } else if ((number instanceof Integer) || (number instanceof Byte) || (number instanceof Short)) {
            fVar.X(number.intValue());
        } else {
            fVar.Z(number.toString());
        }
    }
}
