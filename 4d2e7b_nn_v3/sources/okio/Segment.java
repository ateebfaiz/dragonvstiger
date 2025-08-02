package okio;

import java.util.Arrays;
import kotlin.collections.j;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class Segment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        boolean z10;
        Segment segment = this.prev;
        int i10 = 0;
        if (segment != this) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            m.c(segment);
            if (segment.owner) {
                int i11 = this.limit - this.pos;
                Segment segment2 = this.prev;
                m.c(segment2);
                int i12 = 8192 - segment2.limit;
                Segment segment3 = this.prev;
                m.c(segment3);
                if (!segment3.shared) {
                    Segment segment4 = this.prev;
                    m.c(segment4);
                    i10 = segment4.pos;
                }
                if (i11 <= i12 + i10) {
                    Segment segment5 = this.prev;
                    m.c(segment5);
                    writeTo(segment5, i11);
                    pop();
                    SegmentPool.recycle(this);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("cannot compact".toString());
    }

    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        m.c(segment2);
        segment2.next = this.next;
        Segment segment3 = this.next;
        m.c(segment3);
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final Segment push(Segment segment) {
        m.f(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        m.c(segment2);
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int i10) {
        boolean z10;
        Segment segment;
        if (i10 <= 0 || i10 > this.limit - this.pos) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            if (i10 >= 1024) {
                segment = sharedCopy();
            } else {
                segment = SegmentPool.take();
                byte[] bArr = this.data;
                byte[] bArr2 = segment.data;
                int i11 = this.pos;
                j.f(bArr, bArr2, 0, i11, i11 + i10, 2, (Object) null);
            }
            segment.limit = segment.pos + i10;
            this.pos += i10;
            Segment segment2 = this.prev;
            m.c(segment2);
            segment2.push(segment);
            return segment;
        }
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        m.e(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new Segment(copyOf, this.pos, this.limit, false, true);
    }

    public final void writeTo(Segment segment, int i10) {
        m.f(segment, "sink");
        if (segment.owner) {
            int i11 = segment.limit;
            if (i11 + i10 > 8192) {
                if (!segment.shared) {
                    int i12 = segment.pos;
                    if ((i11 + i10) - i12 <= 8192) {
                        byte[] bArr = segment.data;
                        j.f(bArr, bArr, 0, i12, i11, 2, (Object) null);
                        segment.limit -= segment.pos;
                        segment.pos = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.data;
            byte[] bArr3 = segment.data;
            int i13 = segment.limit;
            int i14 = this.pos;
            j.d(bArr2, bArr3, i13, i14, i14 + i10);
            segment.limit += i10;
            this.pos += i10;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public Segment(byte[] bArr, int i10, int i11, boolean z10, boolean z11) {
        m.f(bArr, "data");
        this.data = bArr;
        this.pos = i10;
        this.limit = i11;
        this.shared = z10;
        this.owner = z11;
    }
}
