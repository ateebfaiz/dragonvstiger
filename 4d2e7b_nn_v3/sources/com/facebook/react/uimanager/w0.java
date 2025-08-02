package com.facebook.react.uimanager;

import com.facebook.yoga.c;
import com.facebook.yoga.d;
import kotlin.Lazy;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.l;

public final class w0 {

    /* renamed from: a  reason: collision with root package name */
    public static final w0 f3961a = new w0();

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f3962b = i.a(l.NONE, a.f3963a);

    static final class a extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f3963a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final c invoke() {
            c a10 = d.a();
            a10.setPointScaleFactor(0.0f);
            a10.setErrata(com.facebook.yoga.i.ALL);
            return a10;
        }
    }

    private w0() {
    }

    public static final c a() {
        return f3961a.b();
    }

    private final c b() {
        Object value = f3962b.getValue();
        m.e(value, "getValue(...)");
        return (c) value;
    }
}
