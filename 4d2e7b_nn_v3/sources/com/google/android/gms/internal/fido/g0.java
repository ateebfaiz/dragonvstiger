package com.google.android.gms.internal.fido;

import java.util.Comparator;

abstract class g0 {

    /* renamed from: a  reason: collision with root package name */
    static final String f7063a;

    /* renamed from: b  reason: collision with root package name */
    static final Comparator f7064b;

    static {
        Comparator comparator;
        String concat = g0.class.getName().concat("$UnsafeComparator");
        f7063a = concat;
        try {
            Object[] enumConstants = Class.forName(concat).getEnumConstants();
            enumConstants.getClass();
            comparator = (Comparator) enumConstants[0];
        } catch (Throwable unused) {
            comparator = f0.INSTANCE;
        }
        f7064b = comparator;
    }
}
