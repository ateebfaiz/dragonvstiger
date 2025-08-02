package com.bugsnag.android;

import com.bugsnag.android.k2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.j;
import kotlin.jvm.internal.m;

public final class c2 implements k2.a {

    /* renamed from: a  reason: collision with root package name */
    private volatile a2[] f18654a;

    private c2(a2[] a2VarArr) {
        this.f18654a = a2VarArr;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.bugsnag.android.a2[] r0 = r6.f18654a     // Catch:{ all -> 0x0019 }
            int r1 = r0.length     // Catch:{ all -> 0x0019 }
            r2 = 0
        L_0x0005:
            r3 = -1
            if (r2 >= r1) goto L_0x001b
            int r4 = r2 + 1
            r5 = r0[r2]     // Catch:{ all -> 0x0019 }
            java.lang.String r5 = r5.b()     // Catch:{ all -> 0x0019 }
            boolean r5 = kotlin.jvm.internal.m.b(r5, r7)     // Catch:{ all -> 0x0019 }
            if (r5 == 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r2 = r4
            goto L_0x0005
        L_0x0019:
            r7 = move-exception
            goto L_0x0055
        L_0x001b:
            r2 = r3
        L_0x001c:
            if (r2 != r3) goto L_0x002a
            com.bugsnag.android.a2 r1 = new com.bugsnag.android.a2     // Catch:{ all -> 0x0019 }
            r1.<init>(r7, r8)     // Catch:{ all -> 0x0019 }
            java.lang.Object[] r7 = kotlin.collections.j.o(r0, r1)     // Catch:{ all -> 0x0019 }
            com.bugsnag.android.a2[] r7 = (com.bugsnag.android.a2[]) r7     // Catch:{ all -> 0x0019 }
            goto L_0x004d
        L_0x002a:
            r1 = r0[r2]     // Catch:{ all -> 0x0019 }
            java.lang.String r1 = r1.d()     // Catch:{ all -> 0x0019 }
            boolean r1 = kotlin.jvm.internal.m.b(r1, r8)     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x0053
            int r1 = r0.length     // Catch:{ all -> 0x0019 }
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)     // Catch:{ all -> 0x0019 }
            java.lang.String r1 = "copyOf(this, size)"
            kotlin.jvm.internal.m.e(r0, r1)     // Catch:{ all -> 0x0019 }
            r1 = r0
            com.bugsnag.android.a2[] r1 = (com.bugsnag.android.a2[]) r1     // Catch:{ all -> 0x0019 }
            com.bugsnag.android.a2 r3 = new com.bugsnag.android.a2     // Catch:{ all -> 0x0019 }
            r3.<init>(r7, r8)     // Catch:{ all -> 0x0019 }
            r1[r2] = r3     // Catch:{ all -> 0x0019 }
            r7 = r0
            com.bugsnag.android.a2[] r7 = (com.bugsnag.android.a2[]) r7     // Catch:{ all -> 0x0019 }
        L_0x004d:
            r6.f18654a = r7     // Catch:{ all -> 0x0019 }
            kotlin.Unit r7 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0019 }
            monitor-exit(r6)
            return
        L_0x0053:
            monitor-exit(r6)
            return
        L_0x0055:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.c2.a(java.lang.String, java.lang.String):void");
    }

    public void b(String str) {
        synchronized (this) {
            a2[] a2VarArr = this.f18654a;
            int length = a2VarArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    i10 = -1;
                    break;
                }
                int i11 = i10 + 1;
                if (m.b(a2VarArr[i10].b(), str)) {
                    break;
                }
                i10 = i11;
            }
            if (i10 != -1) {
                a2[] a2VarArr2 = new a2[(a2VarArr.length - 1)];
                j.e(a2VarArr, a2VarArr2, 0, 0, i10);
                j.g(a2VarArr, a2VarArr2, i10, i10 + 1, 0, 8, (Object) null);
                this.f18654a = a2VarArr2;
                Unit unit = Unit.f12577a;
            }
        }
    }

    public void c() {
        synchronized (this) {
            this.f18654a = new a2[0];
            Unit unit = Unit.f12577a;
        }
    }

    public final c2 d() {
        return new c2(this.f18654a);
    }

    public final List e() {
        a2[] a2VarArr = this.f18654a;
        ArrayList arrayList = new ArrayList(a2VarArr.length);
        int length = a2VarArr.length;
        int i10 = 0;
        while (i10 < length) {
            a2 a2Var = a2VarArr[i10];
            i10++;
            arrayList.add(new a2((String) a2Var.getKey(), (String) a2Var.getValue()));
        }
        return arrayList;
    }

    public void toStream(k2 k2Var) {
        a2[] a2VarArr = this.f18654a;
        k2Var.h();
        int length = a2VarArr.length;
        int i10 = 0;
        while (i10 < length) {
            a2 a2Var = a2VarArr[i10];
            i10++;
            String str = (String) a2Var.getValue();
            k2Var.j();
            k2Var.v("featureFlag").K((String) a2Var.getKey());
            if (str != null) {
                k2Var.v("variant").K(str);
            }
            k2Var.n();
        }
        k2Var.m();
    }

    public c2() {
        this(new a2[0]);
    }
}
