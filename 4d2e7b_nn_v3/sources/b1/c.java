package b1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class c {

    /* renamed from: e  reason: collision with root package name */
    protected static final Comparator f17132e = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List f17133a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    private final List f17134b = new ArrayList(64);

    /* renamed from: c  reason: collision with root package name */
    private int f17135c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final int f17136d;

    static class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public c(int i10) {
        this.f17136d = i10;
    }

    private synchronized void c() {
        while (this.f17135c > this.f17136d) {
            byte[] bArr = (byte[]) this.f17133a.remove(0);
            this.f17134b.remove(bArr);
            this.f17135c -= bArr.length;
        }
    }

    public synchronized byte[] a(int i10) {
        for (int i11 = 0; i11 < this.f17134b.size(); i11++) {
            byte[] bArr = (byte[]) this.f17134b.get(i11);
            if (bArr.length >= i10) {
                this.f17135c -= bArr.length;
                this.f17134b.remove(i11);
                this.f17133a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i10];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(byte[] r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x002e
            int r0 = r3.length     // Catch:{ all -> 0x002b }
            int r1 = r2.f17136d     // Catch:{ all -> 0x002b }
            if (r0 <= r1) goto L_0x0009
            goto L_0x002e
        L_0x0009:
            java.util.List r0 = r2.f17133a     // Catch:{ all -> 0x002b }
            r0.add(r3)     // Catch:{ all -> 0x002b }
            java.util.List r0 = r2.f17134b     // Catch:{ all -> 0x002b }
            java.util.Comparator r1 = f17132e     // Catch:{ all -> 0x002b }
            int r0 = java.util.Collections.binarySearch(r0, r3, r1)     // Catch:{ all -> 0x002b }
            if (r0 >= 0) goto L_0x001b
            int r0 = -r0
            int r0 = r0 + -1
        L_0x001b:
            java.util.List r1 = r2.f17134b     // Catch:{ all -> 0x002b }
            r1.add(r0, r3)     // Catch:{ all -> 0x002b }
            int r0 = r2.f17135c     // Catch:{ all -> 0x002b }
            int r3 = r3.length     // Catch:{ all -> 0x002b }
            int r0 = r0 + r3
            r2.f17135c = r0     // Catch:{ all -> 0x002b }
            r2.c()     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x002e:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.c.b(byte[]):void");
    }
}
