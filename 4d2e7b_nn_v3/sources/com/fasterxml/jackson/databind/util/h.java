package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.n;
import java.io.Serializable;
import l8.l;

public final class h implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final Class f5684a;

    /* renamed from: b  reason: collision with root package name */
    private final Enum[] f5685b;

    /* renamed from: c  reason: collision with root package name */
    private final n[] f5686c;

    private h(Class cls, n[] nVarArr) {
        this.f5684a = cls;
        this.f5685b = (Enum[]) cls.getEnumConstants();
        this.f5686c = nVarArr;
    }

    public static h a(Class cls, n[] nVarArr) {
        return new h(cls, nVarArr);
    }

    public static h b(l lVar, Class cls) {
        Class p10 = f.p(cls);
        Enum[] enumArr = (Enum[]) p10.getEnumConstants();
        if (enumArr != null) {
            String[] j10 = lVar.h().j(p10, enumArr, new String[enumArr.length]);
            n[] nVarArr = new n[enumArr.length];
            int length = enumArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                Enum enumR = enumArr[i10];
                String str = j10[i10];
                if (str == null) {
                    str = enumR.name();
                }
                nVarArr[enumR.ordinal()] = lVar.d(str);
            }
            return a(cls, nVarArr);
        }
        throw new IllegalArgumentException("Cannot determine enum constants for Class " + cls.getName());
    }

    public Class c() {
        return this.f5684a;
    }

    public n d(Enum enumR) {
        return this.f5686c[enumR.ordinal()];
    }
}
