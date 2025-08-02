package com.facebook.react.common.mapbuffer;

import com.facebook.jni.HybridData;
import com.facebook.react.common.mapbuffer.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.ranges.IntRange;
import kotlin.v;

@d6.a
public final class ReadableMapBuffer implements a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f2905d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f2906a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2907b;

    /* renamed from: c  reason: collision with root package name */
    private int f2908c;
    @d6.a
    private final HybridData mHybridData;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final class b implements a.c {

        /* renamed from: a  reason: collision with root package name */
        private final int f2909a;

        public b(int i10) {
            this.f2909a = i10;
        }

        private final void g(a.b bVar) {
            a.b type = getType();
            if (bVar != type) {
                int key = getKey();
                throw new IllegalStateException(("Expected " + bVar + " for key: " + key + " found " + type + " instead.").toString());
            }
        }

        public long a() {
            g(a.b.LONG);
            return ReadableMapBuffer.this.u(this.f2909a + 4);
        }

        public double b() {
            g(a.b.DOUBLE);
            return ReadableMapBuffer.this.r(this.f2909a + 4);
        }

        public String c() {
            g(a.b.STRING);
            return ReadableMapBuffer.this.w(this.f2909a + 4);
        }

        public int d() {
            g(a.b.INT);
            return ReadableMapBuffer.this.t(this.f2909a + 4);
        }

        public a e() {
            g(a.b.MAP);
            return ReadableMapBuffer.this.v(this.f2909a + 4);
        }

        public boolean f() {
            g(a.b.BOOL);
            return ReadableMapBuffer.this.p(this.f2909a + 4);
        }

        public int getKey() {
            return ReadableMapBuffer.this.x(this.f2909a) & com.alibaba.pdns.net.f.a.f18108a;
        }

        public a.b getType() {
            return a.b.values()[ReadableMapBuffer.this.x(this.f2909a + 2) & com.alibaba.pdns.net.f.a.f18108a];
        }
    }

    public static final class c implements Iterator, wb.a {

        /* renamed from: a  reason: collision with root package name */
        private int f2911a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2912b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReadableMapBuffer f2913c;

        c(ReadableMapBuffer readableMapBuffer) {
            this.f2913c = readableMapBuffer;
            this.f2912b = readableMapBuffer.getCount() - 1;
        }

        /* renamed from: a */
        public a.c next() {
            ReadableMapBuffer readableMapBuffer = this.f2913c;
            int i10 = this.f2911a;
            this.f2911a = i10 + 1;
            return new b(readableMapBuffer.l(i10));
        }

        public boolean hasNext() {
            if (this.f2911a <= this.f2912b) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    static final class d extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final d f2914a = new d();

        public /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f2915a;

            /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    com.facebook.react.common.mapbuffer.a$b[] r0 = com.facebook.react.common.mapbuffer.a.b.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.facebook.react.common.mapbuffer.a$b r1 = com.facebook.react.common.mapbuffer.a.b.BOOL     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.facebook.react.common.mapbuffer.a$b r1 = com.facebook.react.common.mapbuffer.a.b.INT     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    com.facebook.react.common.mapbuffer.a$b r1 = com.facebook.react.common.mapbuffer.a.b.LONG     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    com.facebook.react.common.mapbuffer.a$b r1 = com.facebook.react.common.mapbuffer.a.b.DOUBLE     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    com.facebook.react.common.mapbuffer.a$b r1 = com.facebook.react.common.mapbuffer.a.b.STRING     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    com.facebook.react.common.mapbuffer.a$b r1 = com.facebook.react.common.mapbuffer.a.b.MAP     // Catch:{ NoSuchFieldError -> 0x003d }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                    r2 = 6
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
                L_0x003d:
                    f2915a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.common.mapbuffer.ReadableMapBuffer.d.a.<clinit>():void");
            }
        }

        d() {
            super(1);
        }

        /* renamed from: a */
        public final CharSequence invoke(a.c cVar) {
            m.f(cVar, "entry");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cVar.getKey());
            sb2.append('=');
            switch (a.f2915a[cVar.getType().ordinal()]) {
                case 1:
                    sb2.append(cVar.f());
                    break;
                case 2:
                    sb2.append(cVar.d());
                    break;
                case 3:
                    sb2.append(cVar.a());
                    break;
                case 4:
                    sb2.append(cVar.b());
                    break;
                case 5:
                    sb2.append('\"');
                    sb2.append(cVar.c());
                    sb2.append('\"');
                    break;
                case 6:
                    sb2.append(cVar.e().toString());
                    break;
            }
            return sb2;
        }
    }

    static {
        h6.a.a();
    }

    @d6.a
    private ReadableMapBuffer(HybridData hybridData) {
        this.mHybridData = hybridData;
        this.f2906a = importByteBuffer();
        this.f2907b = 0;
        s();
    }

    private final native ByteBuffer importByteBuffer();

    private final int k(int i10) {
        IntRange a10 = a.f2924k.a();
        int a11 = a10.a();
        if (i10 <= a10.c() && a11 <= i10) {
            short a12 = v.a((short) i10);
            int count = getCount() - 1;
            int i11 = 0;
            while (i11 <= count) {
                int i12 = (i11 + count) >>> 1;
                short x10 = x(l(i12)) & com.alibaba.pdns.net.f.a.f18108a;
                short s10 = 65535 & a12;
                if (m.g(x10, s10) < 0) {
                    i11 = i12 + 1;
                } else if (m.g(x10, s10) <= 0) {
                    return i12;
                } else {
                    count = i12 - 1;
                }
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final int l(int i10) {
        return this.f2907b + 8 + (i10 * 12);
    }

    private final int n() {
        return l(getCount());
    }

    private final int o(int i10, a.b bVar) {
        int k10 = k(i10);
        if (k10 != -1) {
            a.b q10 = q(k10);
            if (q10 == bVar) {
                return l(k10) + 4;
            }
            throw new IllegalStateException(("Expected " + bVar + " for key: " + i10 + ", found " + q10 + " instead.").toString());
        }
        throw new IllegalArgumentException(("Key not found: " + i10).toString());
    }

    /* access modifiers changed from: private */
    public final boolean p(int i10) {
        if (t(i10) == 1) {
            return true;
        }
        return false;
    }

    private final a.b q(int i10) {
        return a.b.values()[x(l(i10) + 2) & com.alibaba.pdns.net.f.a.f18108a];
    }

    /* access modifiers changed from: private */
    public final double r(int i10) {
        return this.f2906a.getDouble(i10);
    }

    private final void s() {
        if (this.f2906a.getShort() != 254) {
            this.f2906a.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.f2908c = x(this.f2906a.position()) & com.alibaba.pdns.net.f.a.f18108a;
    }

    /* access modifiers changed from: private */
    public final int t(int i10) {
        return this.f2906a.getInt(i10);
    }

    /* access modifiers changed from: private */
    public final long u(int i10) {
        return this.f2906a.getLong(i10);
    }

    /* access modifiers changed from: private */
    public final ReadableMapBuffer v(int i10) {
        return new ReadableMapBuffer(this.f2906a, n() + this.f2906a.getInt(i10) + 4);
    }

    /* access modifiers changed from: private */
    public final String w(int i10) {
        int n10 = n() + this.f2906a.getInt(i10);
        int i11 = this.f2906a.getInt(n10);
        byte[] bArr = new byte[i11];
        this.f2906a.position(n10 + 4);
        this.f2906a.get(bArr, 0, i11);
        return new String(bArr, kotlin.text.d.f797b);
    }

    /* access modifiers changed from: private */
    public final short x(int i10) {
        return v.a(this.f2906a.getShort(i10));
    }

    public boolean b(int i10) {
        if (k(i10) != -1) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ReadableMapBuffer)) {
            return false;
        }
        ByteBuffer byteBuffer = this.f2906a;
        ByteBuffer byteBuffer2 = ((ReadableMapBuffer) obj).f2906a;
        if (byteBuffer == byteBuffer2) {
            return true;
        }
        byteBuffer.rewind();
        byteBuffer2.rewind();
        return m.b(byteBuffer, byteBuffer2);
    }

    public boolean getBoolean(int i10) {
        return p(o(i10, a.b.BOOL));
    }

    public int getCount() {
        return this.f2908c;
    }

    public double getDouble(int i10) {
        return r(o(i10, a.b.DOUBLE));
    }

    public int getInt(int i10) {
        return t(o(i10, a.b.INT));
    }

    public String getString(int i10) {
        return w(o(i10, a.b.STRING));
    }

    public int hashCode() {
        this.f2906a.rewind();
        return this.f2906a.hashCode();
    }

    public Iterator iterator() {
        return new c(this);
    }

    /* renamed from: m */
    public ReadableMapBuffer h(int i10) {
        return v(o(i10, a.b.MAP));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("{");
        r.d0(this, sb2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, d.f2914a, 62, (Object) null);
        sb2.append('}');
        String sb3 = sb2.toString();
        m.e(sb3, "toString(...)");
        return sb3;
    }

    private ReadableMapBuffer(ByteBuffer byteBuffer, int i10) {
        this.mHybridData = null;
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(i10);
        m.e(duplicate, "apply(...)");
        this.f2906a = duplicate;
        this.f2907b = i10;
        s();
    }
}
