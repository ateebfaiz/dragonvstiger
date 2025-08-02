package com.facebook.react.uimanager;

import e6.b;
import kotlin.Lazy;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.n;
import kotlin.l;

public final class n2 {

    /* renamed from: a  reason: collision with root package name */
    public static final n2 f3818a = new n2();

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f3819b = i.a(l.SYNCHRONIZED, a.f3820a);

    static final class a extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f3820a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final b invoke() {
            return new b(1024);
        }
    }

    private n2() {
    }

    public static final b a() {
        return f3818a.b();
    }

    private final b b() {
        return (b) f3819b.getValue();
    }
}
