package com.facebook.react.common.mapbuffer;

import kotlin.ranges.IntRange;

public interface a extends Iterable, wb.a {

    /* renamed from: k  reason: collision with root package name */
    public static final C0047a f2924k = C0047a.f2925a;

    /* renamed from: com.facebook.react.common.mapbuffer.a$a  reason: collision with other inner class name */
    public static final class C0047a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ C0047a f2925a = new C0047a();

        /* renamed from: b  reason: collision with root package name */
        private static final IntRange f2926b = new IntRange(0, 65535);

        private C0047a() {
        }

        public final IntRange a() {
            return f2926b;
        }
    }

    public enum b {
        BOOL,
        INT,
        DOUBLE,
        STRING,
        MAP,
        LONG;

        static {
            b[] a10;
            f2934h = pb.a.a(a10);
        }
    }

    public interface c {
        long a();

        double b();

        String c();

        int d();

        a e();

        boolean f();

        int getKey();

        b getType();
    }

    boolean b(int i10);

    boolean getBoolean(int i10);

    int getCount();

    double getDouble(int i10);

    int getInt(int i10);

    String getString(int i10);

    a h(int i10);
}
