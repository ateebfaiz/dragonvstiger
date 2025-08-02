package s3;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import s3.a;

class b extends a {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f23848b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Handler f23849c = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f23850d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f23851e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f23852f = new a();

    class a implements Runnable {
        a() {
        }

        public void run() {
            synchronized (b.this.f23848b) {
                ArrayList f10 = b.this.f23851e;
                b bVar = b.this;
                ArrayList unused = bVar.f23851e = bVar.f23850d;
                ArrayList unused2 = b.this.f23850d = f10;
            }
            int size = b.this.f23851e.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((a.C0331a) b.this.f23851e.get(i10)).release();
            }
            b.this.f23851e.clear();
        }
    }

    public void a(a.C0331a aVar) {
        synchronized (this.f23848b) {
            this.f23850d.remove(aVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        if (r1 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        r2.f23849c.post(r2.f23852f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(s3.a.C0331a r3) {
        /*
            r2 = this;
            boolean r0 = s3.a.c()
            if (r0 != 0) goto L_0x000a
            r3.release()
            return
        L_0x000a:
            java.lang.Object r0 = r2.f23848b
            monitor-enter(r0)
            java.util.ArrayList r1 = r2.f23850d     // Catch:{ all -> 0x0017 }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x0019
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return
        L_0x0017:
            r3 = move-exception
            goto L_0x0034
        L_0x0019:
            java.util.ArrayList r1 = r2.f23850d     // Catch:{ all -> 0x0017 }
            r1.add(r3)     // Catch:{ all -> 0x0017 }
            java.util.ArrayList r3 = r2.f23850d     // Catch:{ all -> 0x0017 }
            int r3 = r3.size()     // Catch:{ all -> 0x0017 }
            r1 = 1
            if (r3 != r1) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r1 = 0
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x0033
            android.os.Handler r3 = r2.f23849c
            java.lang.Runnable r0 = r2.f23852f
            r3.post(r0)
        L_0x0033:
            return
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: s3.b.d(s3.a$a):void");
    }
}
