package com.geetest.core;

import java.math.BigInteger;

public class q4 extends f4 {
    public q4(p4 p4Var, p4 p4Var2) throws q3 {
        a(30);
        if (p4Var == null) {
            throw new q3("Numerator is null");
        } else if (p4Var2 == null) {
            throw new q3("Denominator is null");
        } else if (!p4Var2.a().equals(BigInteger.ZERO)) {
            a(p4Var);
            a(p4Var2);
        } else {
            throw new q3("Denominator is zero");
        }
    }
}
