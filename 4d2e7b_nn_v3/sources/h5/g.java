package h5;

import android.graphics.Bitmap;
import c3.h;
import y2.l;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private int f21951a;

    /* renamed from: b  reason: collision with root package name */
    private long f21952b;

    /* renamed from: c  reason: collision with root package name */
    private final int f21953c;

    /* renamed from: d  reason: collision with root package name */
    private final int f21954d;

    /* renamed from: e  reason: collision with root package name */
    private final h f21955e;

    class a implements h {
        a() {
        }

        /* renamed from: a */
        public void release(Bitmap bitmap) {
            try {
                g.this.a(bitmap);
            } finally {
                bitmap.recycle();
            }
        }
    }

    public g(int i10, int i11) {
        boolean z10;
        boolean z11 = false;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        l.b(Boolean.valueOf(i11 > 0 ? true : z11));
        this.f21953c = i10;
        this.f21954d = i11;
        this.f21955e = new a();
    }

    public synchronized void a(Bitmap bitmap) {
        boolean z10;
        boolean z11;
        int g10 = o5.a.g(bitmap);
        if (this.f21951a > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.c(z10, "No bitmaps registered.");
        long j10 = (long) g10;
        if (j10 <= this.f21952b) {
            z11 = true;
        } else {
            z11 = false;
        }
        l.d(z11, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(g10), Long.valueOf(this.f21952b));
        this.f21952b -= j10;
        this.f21951a--;
    }

    public synchronized int b() {
        return this.f21951a;
    }

    public synchronized int c() {
        return this.f21953c;
    }

    public synchronized int d() {
        return this.f21954d;
    }

    public h e() {
        return this.f21955e;
    }

    public synchronized long f() {
        return this.f21952b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean g(android.graphics.Bitmap r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            int r10 = o5.a.g(r10)     // Catch:{ all -> 0x0021 }
            int r0 = r9.f21951a     // Catch:{ all -> 0x0021 }
            int r1 = r9.f21953c     // Catch:{ all -> 0x0021 }
            if (r0 >= r1) goto L_0x0023
            long r1 = r9.f21952b     // Catch:{ all -> 0x0021 }
            long r3 = (long) r10     // Catch:{ all -> 0x0021 }
            long r5 = r1 + r3
            int r10 = r9.f21954d     // Catch:{ all -> 0x0021 }
            long r7 = (long) r10     // Catch:{ all -> 0x0021 }
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 <= 0) goto L_0x0018
            goto L_0x0023
        L_0x0018:
            r10 = 1
            int r0 = r0 + r10
            r9.f21951a = r0     // Catch:{ all -> 0x0021 }
            long r1 = r1 + r3
            r9.f21952b = r1     // Catch:{ all -> 0x0021 }
            monitor-exit(r9)
            return r10
        L_0x0021:
            r10 = move-exception
            goto L_0x0026
        L_0x0023:
            monitor-exit(r9)
            r10 = 0
            return r10
        L_0x0026:
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.g.g(android.graphics.Bitmap):boolean");
    }
}
