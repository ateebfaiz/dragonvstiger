package com.bugsnag.android;

import android.os.SystemClock;
import com.bugsnag.android.a4;
import com.bugsnag.android.k2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class f4 implements k2.a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f18732b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final List f18733a;

    public static final class a {
        private a() {
        }

        private final ThreadGroup b() {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            m.c(threadGroup);
            while (threadGroup.getParent() != null) {
                threadGroup = threadGroup.getParent();
            }
            return threadGroup;
        }

        public final List a() {
            ThreadGroup b10 = b();
            Thread[] threadArr = new Thread[b10.activeCount()];
            b10.enumerate(threadArr);
            return j.t(threadArr);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return nb.a.a(Long.valueOf(((Thread) obj).getId()), Long.valueOf(((Thread) obj2).getId()));
        }
    }

    static final class c extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Thread f18734a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Thread thread) {
            super(1);
            this.f18734a = thread;
        }

        /* renamed from: a */
        public final Integer invoke(Thread thread) {
            return Integer.valueOf(m.h(thread.getId(), this.f18734a.getId()));
        }
    }

    public f4(Throwable th, boolean z10, int i10, long j10, d4 d4Var, Collection collection, s2 s2Var, Thread thread, List list) {
        List a10;
        d4 d4Var2 = d4Var;
        if (d4Var2 == d4.ALWAYS || (d4Var2 == d4.UNHANDLED_ONLY && z10)) {
            a10 = a(list, thread, th, z10, i10, j10, collection, s2Var);
        } else {
            a10 = new ArrayList();
        }
        this.f18733a = a10;
    }

    private final List a(List list, Thread thread, Throwable th, boolean z10, int i10, long j10, Collection collection, s2 s2Var) {
        int i11;
        int i12 = i10;
        List s02 = r.s0(list, new b());
        int i13 = r.i(s02, 0, Math.min(i12, s02.size()), new c(thread));
        Iterable iterable = s02;
        if (i13 >= 0) {
            i11 = i12;
        } else {
            i11 = Math.max(i12 - 1, 0);
        }
        List<Thread> t02 = r.t0(iterable, i11);
        ArrayList arrayList = new ArrayList(i12);
        long elapsedRealtime = SystemClock.elapsedRealtime() + j10;
        for (Thread thread2 : t02) {
            if (SystemClock.elapsedRealtime() >= elapsedRealtime) {
                break;
            }
            arrayList.add(b(thread, th, z10, collection, s2Var, thread2));
        }
        if (i13 < 0) {
            int i14 = (-i13) - 1;
            if (i14 >= arrayList.size()) {
                arrayList.add(b(thread, th, z10, collection, s2Var, thread));
            } else {
                arrayList.add(i14, b(thread, th, z10, collection, s2Var, thread));
            }
        } else if (i13 >= arrayList.size()) {
            arrayList.add(b(thread, th, z10, collection, s2Var, thread));
        }
        if (list.size() > i12) {
            arrayList.add(new a4("", '[' + (list.size() - i12) + " threads omitted as the maxReportedThreads limit (" + i12 + ") was exceeded]", ErrorType.UNKNOWN, false, a4.b.UNKNOWN, new u3(new StackTraceElement[]{new StackTraceElement("", "", "-", 0)}, collection, s2Var), s2Var));
        }
        return arrayList;
    }

    private static final a4 b(Thread thread, Throwable th, boolean z10, Collection collection, s2 s2Var, Thread thread2) {
        boolean z11;
        StackTraceElement[] stackTraceElementArr;
        if (thread2.getId() == thread.getId()) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean z12 = z11;
        if (!z12) {
            stackTraceElementArr = thread2.getStackTrace();
        } else if (th == null || !z10) {
            stackTraceElementArr = thread.getStackTrace();
        } else {
            stackTraceElementArr = th.getStackTrace();
        }
        return new a4(String.valueOf(thread2.getId()), thread2.getName(), ErrorType.ANDROID, z12, a4.b.b(thread2), new u3(stackTraceElementArr, collection, s2Var), s2Var);
    }

    public final List c() {
        return this.f18733a;
    }

    public void toStream(k2 k2Var) {
        k2Var.h();
        for (a4 P : this.f18733a) {
            k2Var.P(P);
        }
        k2Var.m();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ f4(java.lang.Throwable r14, boolean r15, int r16, long r17, com.bugsnag.android.d4 r19, java.util.Collection r20, com.bugsnag.android.s2 r21, java.lang.Thread r22, java.util.List r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r13 = this;
            r0 = r24
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x000c
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r11 = r1
            goto L_0x000e
        L_0x000c:
            r11 = r22
        L_0x000e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x001a
            com.bugsnag.android.f4$a r0 = f18732b
            java.util.List r0 = r0.a()
            r12 = r0
            goto L_0x001c
        L_0x001a:
            r12 = r23
        L_0x001c:
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r8 = r19
            r9 = r20
            r10 = r21
            r2.<init>(r3, r4, r5, r6, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.f4.<init>(java.lang.Throwable, boolean, int, long, com.bugsnag.android.d4, java.util.Collection, com.bugsnag.android.s2, java.lang.Thread, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public f4(Throwable th, boolean z10, c1.j jVar) {
        this(th, z10, jVar.v(), jVar.H(), jVar.E(), jVar.A(), jVar.r(), (Thread) null, (List) null, 384, (DefaultConstructorMarker) null);
    }
}
