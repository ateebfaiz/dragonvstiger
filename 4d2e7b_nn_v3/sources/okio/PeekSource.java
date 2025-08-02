package okio;

import kotlin.jvm.internal.m;

public final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(BufferedSource bufferedSource) {
        int i10;
        m.f(bufferedSource, "upstream");
        this.upstream = bufferedSource;
        Buffer buffer2 = bufferedSource.getBuffer();
        this.buffer = buffer2;
        Segment segment = buffer2.head;
        this.expectedSegment = segment;
        if (segment != null) {
            i10 = segment.pos;
        } else {
            i10 = -1;
        }
        this.expectedPos = i10;
    }

    public void close() {
        this.closed = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r5 == r6.pos) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long read(okio.Buffer r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.m.f(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r2 < 0) goto L_0x000f
            r5 = r4
            goto L_0x0010
        L_0x000f:
            r5 = r3
        L_0x0010:
            if (r5 == 0) goto L_0x0087
            boolean r5 = r8.closed
            r5 = r5 ^ r4
            if (r5 == 0) goto L_0x007b
            okio.Segment r5 = r8.expectedSegment
            if (r5 == 0) goto L_0x002a
            okio.Buffer r6 = r8.buffer
            okio.Segment r6 = r6.head
            if (r5 != r6) goto L_0x002b
            int r5 = r8.expectedPos
            kotlin.jvm.internal.m.c(r6)
            int r6 = r6.pos
            if (r5 != r6) goto L_0x002b
        L_0x002a:
            r3 = r4
        L_0x002b:
            if (r3 == 0) goto L_0x006f
            if (r2 != 0) goto L_0x0030
            return r0
        L_0x0030:
            okio.BufferedSource r0 = r8.upstream
            long r1 = r8.pos
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.request(r1)
            if (r0 != 0) goto L_0x0040
            r9 = -1
            return r9
        L_0x0040:
            okio.Segment r0 = r8.expectedSegment
            if (r0 != 0) goto L_0x0053
            okio.Buffer r0 = r8.buffer
            okio.Segment r0 = r0.head
            if (r0 == 0) goto L_0x0053
            r8.expectedSegment = r0
            kotlin.jvm.internal.m.c(r0)
            int r0 = r0.pos
            r8.expectedPos = r0
        L_0x0053:
            okio.Buffer r0 = r8.buffer
            long r0 = r0.size()
            long r2 = r8.pos
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            okio.Buffer r2 = r8.buffer
            long r4 = r8.pos
            r3 = r9
            r6 = r10
            r2.copyTo((okio.Buffer) r3, (long) r4, (long) r6)
            long r0 = r8.pos
            long r0 = r0 + r10
            r8.pos = r0
            return r10
        L_0x006f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x007b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0087:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "byteCount < 0: "
            r9.append(r0)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.PeekSource.read(okio.Buffer, long):long");
    }

    public Timeout timeout() {
        return this.upstream.timeout();
    }
}
