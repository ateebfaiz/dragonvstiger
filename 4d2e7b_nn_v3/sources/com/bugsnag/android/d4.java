package com.bugsnag.android;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public enum d4 {
    ALWAYS,
    UNHANDLED_ONLY,
    NEVER;
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f18706a = null;

    public static final class a {
        private a() {
        }

        public final d4 a(String str) {
            d4 d4Var;
            d4[] values = d4.values();
            int length = values.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    d4Var = null;
                    break;
                }
                d4Var = values[i10];
                i10++;
                if (m.b(d4Var.name(), str)) {
                    break;
                }
            }
            if (d4Var == null) {
                return d4.ALWAYS;
            }
            return d4Var;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        f18706a = new a((DefaultConstructorMarker) null);
    }
}
