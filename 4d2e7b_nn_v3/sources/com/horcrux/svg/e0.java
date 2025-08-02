package com.horcrux.svg;

import com.adjust.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

enum e0 {
    Normal(Constants.NORMAL),
    Bold("bold"),
    w100("100"),
    w200("200"),
    w300("300"),
    w400("400"),
    w500("500"),
    w600("600"),
    w700("700"),
    w800("800"),
    w900("900"),
    Bolder("bolder"),
    Lighter("lighter");
    
    private static final Map Z = null;

    /* renamed from: a  reason: collision with root package name */
    private final String f9803a;

    static {
        int i10;
        Z = new HashMap();
        for (e0 e0Var : values()) {
            Z.put(e0Var.f9803a, e0Var);
        }
    }

    private e0(String str) {
        this.f9803a = str;
    }

    static e0 b(String str) {
        return (e0) Z.get(str);
    }

    static boolean c(String str) {
        return Z.containsKey(str);
    }

    public String toString() {
        return this.f9803a;
    }
}
