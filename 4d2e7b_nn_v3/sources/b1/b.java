package b1;

import a1.b;
import a1.g;
import a1.h;
import a1.n;
import a1.r;
import a1.s;
import a1.u;
import a1.v;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class b implements h {

    /* renamed from: d  reason: collision with root package name */
    protected static final boolean f17128d = v.f13657b;

    /* renamed from: a  reason: collision with root package name */
    protected final g f17129a;

    /* renamed from: b  reason: collision with root package name */
    private final a f17130b;

    /* renamed from: c  reason: collision with root package name */
    protected final c f17131c;

    public b(a aVar) {
        this(aVar, new c(4096));
    }

    private static void b(String str, n nVar, u uVar) {
        r p10 = nVar.p();
        int q10 = nVar.q();
        try {
            p10.b(uVar);
            nVar.b(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(q10)}));
        } catch (u e10) {
            nVar.b(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(q10)}));
            throw e10;
        }
    }

    private static List c(List list, b.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(((g) it.next()).a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List list2 = aVar.f13585h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (g gVar : aVar.f13585h) {
                    if (!treeSet.contains(gVar.a())) {
                        arrayList.add(gVar);
                    }
                }
            }
        } else if (!aVar.f13584g.isEmpty()) {
            for (Map.Entry entry : aVar.f13584g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new g((String) entry.getKey(), (String) entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    private Map d(b.a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = aVar.f13579b;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j10 = aVar.f13581d;
        if (j10 > 0) {
            hashMap.put("If-Modified-Since", e.a(j10));
        }
        return hashMap;
    }

    private byte[] e(InputStream inputStream, int i10) {
        k kVar = new k(this.f17131c, i10);
        if (inputStream != null) {
            try {
                byte[] a10 = this.f17131c.a(1024);
                while (true) {
                    int read = inputStream.read(a10);
                    if (read == -1) {
                        break;
                    }
                    kVar.write(a10, 0, read);
                }
                byte[] byteArray = kVar.toByteArray();
                try {
                    inputStream.close();
                } catch (IOException unused) {
                    v.e("Error occurred when closing InputStream", new Object[0]);
                }
                this.f17131c.b(a10);
                kVar.close();
                return byteArray;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                        v.e("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.f17131c.b((byte[]) null);
                kVar.close();
                throw th;
            }
        } else {
            throw new s();
        }
    }

    private void f(long j10, n nVar, byte[] bArr, int i10) {
        Object obj;
        if (f17128d || j10 > 3000) {
            Long valueOf = Long.valueOf(j10);
            if (bArr != null) {
                obj = Integer.valueOf(bArr.length);
            } else {
                obj = "null";
            }
            v.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", nVar, valueOf, obj, Integer.valueOf(i10), Integer.valueOf(nVar.p().c()));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: a1.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: a1.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v19, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v24, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v25, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v29, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v35, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        r15 = null;
        r2 = r12;
        r19 = r13;
        r13 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a7, code lost:
        r0 = e;
        r13 = r13;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a8, code lost:
        r19 = r1;
        r2 = r12;
        r15 = r20;
        r13 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ae, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00af, code lost:
        r1 = r13;
        r13 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bf, code lost:
        r0 = e;
        r1 = r1;
        r13 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c2, code lost:
        r19 = r1;
        r15 = null;
        r13 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c7, code lost:
        r0 = r2.d();
        a1.v.c("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r29.s());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        if (r15 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        r13 = new a1.k(r0, r15, false, android.os.SystemClock.elapsedRealtime() - r10, r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f3, code lost:
        if (r0 == 401) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fc, code lost:
        if (r0 < 400) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0108, code lost:
        throw new a1.d(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x010b, code lost:
        if (r0 < 500) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0115, code lost:
        if (r29.G() != false) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0117, code lost:
        b("server", r8, new a1.s(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0128, code lost:
        throw new a1.s(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x012e, code lost:
        throw new a1.s(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x012f, code lost:
        b("auth", r8, new a1.a(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x013b, code lost:
        b("network", r8, new a1.j());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x014c, code lost:
        throw new a1.l(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0167, code lost:
        throw new java.lang.RuntimeException("Bad URL " + r29.s(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0168, code lost:
        b("socket", r8, new a1.t());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0009, code lost:
        r13 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0009, code lost:
        r13 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0009, code lost:
        r13 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0009, code lost:
        r13 = r13;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a A[Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x0043 }, ExcHandler: MalformedURLException (r0v11 'e' java.net.MalformedURLException A[CUSTOM_DECLARE, Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x0043 }]), Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), PHI: r12 r13 
      PHI: (r12v2 b1.f) = (r12v1 b1.f), (r12v5 b1.f), (r12v5 b1.f), (r12v5 b1.f), (r12v5 b1.f), (r12v5 b1.f), (r12v5 b1.f), (r12v5 b1.f), (r12v5 b1.f) binds: [B:2:0x000e, B:4:0x001c, B:19:0x0067, B:25:0x0078, B:26:?, B:27:0x007b, B:34:0x00a3, B:22:0x006d, B:8:0x0028] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r13v2 java.util.List) = (r13v11 java.util.List), (r13v14 java.util.List), (r13v22 java.util.List), (r13v24 java.util.List), (r13v25 java.util.List), (r13v26 java.util.List), (r13v29 java.util.List), (r13v31 java.util.List), (r13v35 java.util.List) binds: [B:2:0x000e, B:4:0x001c, B:19:0x0067, B:25:0x0078, B:26:?, B:27:0x007b, B:22:0x006d, B:8:0x0028, B:34:0x00a3] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0147 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a1.k a(a1.n r29) {
        /*
            r28 = this;
            r7 = r28
            r8 = r29
            r9 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()
        L_0x0009:
            java.util.List r1 = java.util.Collections.emptyList()
            r2 = 0
            a1.b$a r0 = r29.j()     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00c1 }
            java.util.Map r0 = r7.d(r0)     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00c1 }
            b1.a r3 = r7.f17130b     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00c1 }
            b1.f r12 = r3.a(r8, r0)     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00c1 }
            int r14 = r12.d()     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00bf }
            java.util.List r13 = r12.c()     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00bf }
            r0 = 304(0x130, float:4.26E-43)
            if (r14 != r0) goto L_0x0067
            a1.b$a r0 = r29.j()     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x0043 }
            if (r0 != 0) goto L_0x004d
            a1.k r0 = new a1.k     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x0043 }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x0043 }
            long r19 = r3 - r10
            r16 = 304(0x130, float:4.26E-43)
            r17 = 0
            r18 = 1
            r15 = r0
            r21 = r13
            r15.<init>((int) r16, (byte[]) r17, (boolean) r18, (long) r19, (java.util.List) r21)     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x0043 }
            return r0
        L_0x0043:
            r0 = move-exception
            r15 = r2
            r2 = r12
            r19 = r13
            goto L_0x00c5
        L_0x004a:
            r0 = move-exception
            goto L_0x014d
        L_0x004d:
            java.util.List r27 = c(r13, r0)     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x0043 }
            a1.k r1 = new a1.k     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x0043 }
            byte[] r0 = r0.f13578a     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x0043 }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x0043 }
            long r25 = r3 - r10
            r22 = 304(0x130, float:4.26E-43)
            r24 = 1
            r21 = r1
            r23 = r0
            r21.<init>((int) r22, (byte[]) r23, (boolean) r24, (long) r25, (java.util.List) r27)     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x0043 }
            return r1
        L_0x0067:
            java.io.InputStream r0 = r12.a()     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00b8 }
            if (r0 == 0) goto L_0x0078
            int r1 = r12.b()     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x0043 }
            byte[] r0 = r7.e(r0, r1)     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x0043 }
        L_0x0075:
            r20 = r0
            goto L_0x007b
        L_0x0078:
            byte[] r0 = new byte[r9]     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00b8 }
            goto L_0x0075
        L_0x007b:
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00ae }
            long r2 = r0 - r10
            r1 = r28
            r4 = r29
            r5 = r20
            r6 = r14
            r1.f(r2, r4, r5, r6)     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00ae }
            r0 = 200(0xc8, float:2.8E-43)
            if (r14 < r0) goto L_0x00b1
            r0 = 299(0x12b, float:4.19E-43)
            if (r14 > r0) goto L_0x00b1
            a1.k r0 = new a1.k     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00ae }
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00ae }
            long r17 = r1 - r10
            r16 = 0
            r1 = r13
            r13 = r0
            r15 = r20
            r19 = r1
            r13.<init>((int) r14, (byte[]) r15, (boolean) r16, (long) r17, (java.util.List) r19)     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00a7 }
            return r0
        L_0x00a7:
            r0 = move-exception
        L_0x00a8:
            r19 = r1
            r2 = r12
            r15 = r20
            goto L_0x00c5
        L_0x00ae:
            r0 = move-exception
            r1 = r13
            goto L_0x00a8
        L_0x00b1:
            r1 = r13
            java.io.IOException r0 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00a7 }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00a7 }
            throw r0     // Catch:{ SocketTimeoutException -> 0x0168, MalformedURLException -> 0x004a, IOException -> 0x00a7 }
        L_0x00b8:
            r0 = move-exception
            r1 = r13
        L_0x00ba:
            r19 = r1
            r15 = r2
            r2 = r12
            goto L_0x00c5
        L_0x00bf:
            r0 = move-exception
            goto L_0x00ba
        L_0x00c1:
            r0 = move-exception
            r19 = r1
            r15 = r2
        L_0x00c5:
            if (r2 == 0) goto L_0x0147
            int r0 = r2.d()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.String r2 = r29.s()
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r9] = r1
            r1 = 1
            r3[r1] = r2
            java.lang.String r1 = "Unexpected response code %d for %s"
            a1.v.c(r1, r3)
            if (r15 == 0) goto L_0x013b
            a1.k r1 = new a1.k
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r17 = r2 - r10
            r16 = 0
            r13 = r1
            r14 = r0
            r13.<init>((int) r14, (byte[]) r15, (boolean) r16, (long) r17, (java.util.List) r19)
            r2 = 401(0x191, float:5.62E-43)
            if (r0 == r2) goto L_0x012f
            r2 = 403(0x193, float:5.65E-43)
            if (r0 != r2) goto L_0x00fa
            goto L_0x012f
        L_0x00fa:
            r2 = 400(0x190, float:5.6E-43)
            if (r0 < r2) goto L_0x0109
            r2 = 499(0x1f3, float:6.99E-43)
            if (r0 <= r2) goto L_0x0103
            goto L_0x0109
        L_0x0103:
            a1.d r0 = new a1.d
            r0.<init>(r1)
            throw r0
        L_0x0109:
            r2 = 500(0x1f4, float:7.0E-43)
            if (r0 < r2) goto L_0x0129
            r2 = 599(0x257, float:8.4E-43)
            if (r0 > r2) goto L_0x0129
            boolean r0 = r29.G()
            if (r0 == 0) goto L_0x0123
            a1.s r0 = new a1.s
            r0.<init>(r1)
            java.lang.String r1 = "server"
            b(r1, r8, r0)
            goto L_0x0009
        L_0x0123:
            a1.s r0 = new a1.s
            r0.<init>(r1)
            throw r0
        L_0x0129:
            a1.s r0 = new a1.s
            r0.<init>(r1)
            throw r0
        L_0x012f:
            a1.a r0 = new a1.a
            r0.<init>(r1)
            java.lang.String r1 = "auth"
            b(r1, r8, r0)
            goto L_0x0009
        L_0x013b:
            a1.j r0 = new a1.j
            r0.<init>()
            java.lang.String r1 = "network"
            b(r1, r8, r0)
            goto L_0x0009
        L_0x0147:
            a1.l r1 = new a1.l
            r1.<init>(r0)
            throw r1
        L_0x014d:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Bad URL "
            r2.append(r3)
            java.lang.String r3 = r29.s()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x0168:
            a1.t r0 = new a1.t
            r0.<init>()
            java.lang.String r1 = "socket"
            b(r1, r8, r0)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.b.a(a1.n):a1.k");
    }

    public b(a aVar, c cVar) {
        this.f17130b = aVar;
        this.f17129a = aVar;
        this.f17131c = cVar;
    }
}
