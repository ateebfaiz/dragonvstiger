package com.bugsnag.android;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.j;
import kotlin.collections.r0;

public abstract class d2 {

    /* renamed from: a  reason: collision with root package name */
    private final File f18699a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18700b;

    /* renamed from: c  reason: collision with root package name */
    private final s2 f18701c;

    /* renamed from: d  reason: collision with root package name */
    private final a f18702d;

    /* renamed from: e  reason: collision with root package name */
    private final Lock f18703e = new ReentrantLock();

    /* renamed from: f  reason: collision with root package name */
    private final Collection f18704f = new ConcurrentSkipListSet();

    public interface a {
        void a(Exception exc, File file, String str);
    }

    public static final class b implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return nb.a.a(Long.valueOf(((File) obj).lastModified()), Long.valueOf(((File) obj2).lastModified()));
        }
    }

    public d2(File file, int i10, s2 s2Var, a aVar) {
        this.f18699a = file;
        this.f18700b = i10;
        this.f18701c = s2Var;
        this.f18702d = aVar;
    }

    private final boolean j(File file) {
        try {
            file.mkdirs();
            return true;
        } catch (Exception e10) {
            g().e("Could not prepare file storage directory", e10);
            return false;
        }
    }

    public final void a(Collection collection) {
        this.f18703e.lock();
        if (collection != null) {
            try {
                this.f18704f.removeAll(collection);
            } catch (Throwable th) {
                this.f18703e.unlock();
                throw th;
            }
        }
        this.f18703e.unlock();
    }

    public final void b(Collection collection) {
        this.f18703e.lock();
        if (collection != null) {
            try {
                this.f18704f.removeAll(collection);
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    File file = (File) it.next();
                    if (!file.delete()) {
                        file.deleteOnExit();
                    }
                }
            } catch (Throwable th) {
                this.f18703e.unlock();
                throw th;
            }
        }
        this.f18703e.unlock();
    }

    public final void c() {
        File[] listFiles;
        if (j(this.f18699a) && (listFiles = this.f18699a.listFiles()) != null && listFiles.length >= this.f18700b) {
            List<File> T = j.T(listFiles, new b());
            int length = (listFiles.length - this.f18700b) + 1;
            int i10 = 0;
            for (File file : T) {
                if (i10 != length) {
                    if (!this.f18704f.contains(file)) {
                        s2 g10 = g();
                        g10.g("Discarding oldest error as stored error limit reached: '" + file.getPath() + '\'');
                        b(r0.c(file));
                        i10++;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b A[Catch:{ all -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c A[Catch:{ all -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006b A[SYNTHETIC, Splitter:B:26:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0075 A[SYNTHETIC, Splitter:B:31:0x0075] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "Failed to close unsent payload writer: "
            java.io.File r1 = r7.f18699a
            boolean r1 = r7.j(r1)
            if (r1 != 0) goto L_0x000b
            return
        L_0x000b:
            r7.c()
            java.util.concurrent.locks.Lock r1 = r7.f18703e
            r1.lock()
            java.io.File r1 = new java.io.File
            java.io.File r2 = r7.f18699a
            r1.<init>(r2, r9)
            java.lang.String r1 = r1.getAbsolutePath()
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0051 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0051 }
            java.io.BufferedWriter r4 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x0051 }
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0051 }
            java.lang.String r6 = "UTF-8"
            r5.<init>(r3, r6)     // Catch:{ Exception -> 0x0051 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0051 }
            r4.write(r8)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            r4.close()     // Catch:{ Exception -> 0x0037 }
            goto L_0x0043
        L_0x0037:
            r8 = move-exception
        L_0x0038:
            com.bugsnag.android.s2 r1 = r7.g()
            java.lang.String r9 = kotlin.jvm.internal.m.n(r0, r9)
            r1.c(r9, r8)
        L_0x0043:
            java.util.concurrent.locks.Lock r8 = r7.f18703e
            r8.unlock()
            goto L_0x0071
        L_0x0049:
            r8 = move-exception
            r2 = r4
            goto L_0x0072
        L_0x004c:
            r8 = move-exception
            r2 = r4
            goto L_0x0052
        L_0x004f:
            r8 = move-exception
            goto L_0x0072
        L_0x0051:
            r8 = move-exception
        L_0x0052:
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x004f }
            r3.<init>(r1)     // Catch:{ all -> 0x004f }
            com.bugsnag.android.d2$a r1 = r7.f18702d     // Catch:{ all -> 0x004f }
            if (r1 != 0) goto L_0x005c
            goto L_0x0061
        L_0x005c:
            java.lang.String r4 = "NDK Crash report copy"
            r1.a(r8, r3, r4)     // Catch:{ all -> 0x004f }
        L_0x0061:
            com.bugsnag.android.s2 r8 = r7.g()     // Catch:{ all -> 0x004f }
            com.bugsnag.android.e2.c(r3, r8)     // Catch:{ all -> 0x004f }
            if (r2 != 0) goto L_0x006b
            goto L_0x0043
        L_0x006b:
            r2.close()     // Catch:{ Exception -> 0x006f }
            goto L_0x0043
        L_0x006f:
            r8 = move-exception
            goto L_0x0038
        L_0x0071:
            return
        L_0x0072:
            if (r2 != 0) goto L_0x0075
            goto L_0x0085
        L_0x0075:
            r2.close()     // Catch:{ Exception -> 0x0079 }
            goto L_0x0085
        L_0x0079:
            r1 = move-exception
            com.bugsnag.android.s2 r2 = r7.g()
            java.lang.String r9 = kotlin.jvm.internal.m.n(r0, r9)
            r2.c(r9, r1)
        L_0x0085:
            java.util.concurrent.locks.Lock r9 = r7.f18703e
            r9.unlock()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.d2.d(java.lang.String, java.lang.String):void");
    }

    public final List e() {
        File[] listFiles;
        this.f18703e.lock();
        try {
            ArrayList arrayList = new ArrayList();
            if (j(this.f18699a) && (listFiles = this.f18699a.listFiles()) != null) {
                int length = listFiles.length;
                int i10 = 0;
                while (i10 < length) {
                    File file = listFiles[i10];
                    i10++;
                    if (file.length() == 0) {
                        if (!file.delete()) {
                            file.deleteOnExit();
                        }
                    } else if (file.isFile() && !this.f18704f.contains(file)) {
                        arrayList.add(file);
                    }
                }
            }
            this.f18704f.addAll(arrayList);
            this.f18703e.unlock();
            return arrayList;
        } catch (Throwable th) {
            this.f18703e.unlock();
            throw th;
        }
    }

    public abstract String f(Object obj);

    /* access modifiers changed from: protected */
    public s2 g() {
        return this.f18701c;
    }

    public final File h() {
        return this.f18699a;
    }

    public final boolean i() {
        String[] list;
        if (!this.f18704f.isEmpty() || ((list = this.f18699a.list()) != null && list.length != 0)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d A[Catch:{ all -> 0x0065 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e A[Catch:{ all -> 0x0065 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x0093=Splitter:B:29:0x0093, B:22:0x0074=Splitter:B:22:0x0074} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String k(com.bugsnag.android.k2.a r7) {
        /*
            r6 = this;
            java.io.File r0 = r6.f18699a
            boolean r0 = r6.j(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            int r0 = r6.f18700b
            if (r0 != 0) goto L_0x000f
            return r1
        L_0x000f:
            r6.c()
            java.io.File r0 = new java.io.File
            java.io.File r2 = r6.f18699a
            java.lang.String r3 = r6.f(r7)
            r0.<init>(r2, r3)
            java.lang.String r0 = r0.getAbsolutePath()
            java.util.concurrent.locks.Lock r2 = r6.f18703e
            r2.lock()
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0071, Exception -> 0x006e, all -> 0x006c }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0071, Exception -> 0x006e, all -> 0x006c }
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ FileNotFoundException -> 0x0071, Exception -> 0x006e, all -> 0x006c }
            java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ FileNotFoundException -> 0x0071, Exception -> 0x006e, all -> 0x006c }
            java.lang.String r5 = "UTF-8"
            r4.<init>(r2, r5)     // Catch:{ FileNotFoundException -> 0x0071, Exception -> 0x006e, all -> 0x006c }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0071, Exception -> 0x006e, all -> 0x006c }
            com.bugsnag.android.k2 r2 = new com.bugsnag.android.k2     // Catch:{ FileNotFoundException -> 0x0071, Exception -> 0x006e, all -> 0x006c }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0071, Exception -> 0x006e, all -> 0x006c }
            r2.P(r7)     // Catch:{ FileNotFoundException -> 0x006a, Exception -> 0x0068 }
            com.bugsnag.android.s2 r7 = r6.g()     // Catch:{ FileNotFoundException -> 0x006a, Exception -> 0x0068 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x006a, Exception -> 0x0068 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x006a, Exception -> 0x0068 }
            java.lang.String r4 = "Saved unsent payload to disk: '"
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x006a, Exception -> 0x0068 }
            r3.append(r0)     // Catch:{ FileNotFoundException -> 0x006a, Exception -> 0x0068 }
            r4 = 39
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x006a, Exception -> 0x0068 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x006a, Exception -> 0x0068 }
            r7.f(r3)     // Catch:{ FileNotFoundException -> 0x006a, Exception -> 0x0068 }
            com.bugsnag.android.e2.a(r2)
            java.util.concurrent.locks.Lock r7 = r6.f18703e
            r7.unlock()
            return r0
        L_0x0065:
            r7 = move-exception
            r1 = r2
            goto L_0x009e
        L_0x0068:
            r7 = move-exception
            goto L_0x0074
        L_0x006a:
            r7 = move-exception
            goto L_0x0093
        L_0x006c:
            r7 = move-exception
            goto L_0x009e
        L_0x006e:
            r7 = move-exception
            r2 = r1
            goto L_0x0074
        L_0x0071:
            r7 = move-exception
            r2 = r1
            goto L_0x0093
        L_0x0074:
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0065 }
            r3.<init>(r0)     // Catch:{ all -> 0x0065 }
            com.bugsnag.android.d2$a r0 = r6.f18702d     // Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x007e
            goto L_0x0083
        L_0x007e:
            java.lang.String r4 = "Crash report serialization"
            r0.a(r7, r3, r4)     // Catch:{ all -> 0x0065 }
        L_0x0083:
            com.bugsnag.android.s2 r7 = r6.g()     // Catch:{ all -> 0x0065 }
            com.bugsnag.android.e2.c(r3, r7)     // Catch:{ all -> 0x0065 }
        L_0x008a:
            com.bugsnag.android.e2.a(r2)
            java.util.concurrent.locks.Lock r7 = r6.f18703e
            r7.unlock()
            goto L_0x009d
        L_0x0093:
            com.bugsnag.android.s2 r0 = r6.g()     // Catch:{ all -> 0x0065 }
            java.lang.String r3 = "Ignoring FileNotFoundException - unable to create file"
            r0.c(r3, r7)     // Catch:{ all -> 0x0065 }
            goto L_0x008a
        L_0x009d:
            return r1
        L_0x009e:
            com.bugsnag.android.e2.a(r1)
            java.util.concurrent.locks.Lock r0 = r6.f18703e
            r0.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.d2.k(com.bugsnag.android.k2$a):java.lang.String");
    }
}
