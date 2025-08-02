package com.bugsnag.android;

import c1.j;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import tb.h;

public final class o2 {

    /* renamed from: a  reason: collision with root package name */
    private final File f18892a;

    /* renamed from: b  reason: collision with root package name */
    private final s2 f18893b;

    /* renamed from: c  reason: collision with root package name */
    private final ReentrantReadWriteLock f18894c = new ReentrantReadWriteLock();

    public o2(j jVar) {
        this.f18892a = new File((File) jVar.z().getValue(), "bugsnag/last-run-info");
        this.f18893b = jVar.r();
    }

    private final boolean a(String str, String str2) {
        return Boolean.parseBoolean(kotlin.text.j.G0(str, m.n(str2, "="), (String) null, 2, (Object) null));
    }

    private final int b(String str, String str2) {
        return Integer.parseInt(kotlin.text.j.G0(str, m.n(str2, "="), (String) null, 2, (Object) null));
    }

    private final n2 e() {
        if (!this.f18892a.exists()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : kotlin.text.j.v0(h.e(this.f18892a, (Charset) null, 1, (Object) null), new String[]{"\n"}, false, 0, 6, (Object) null)) {
            if (!kotlin.text.j.s((String) next)) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() != 3) {
            this.f18893b.g(m.n("Unexpected number of lines when loading LastRunInfo. Skipping load. ", arrayList));
            return null;
        }
        try {
            n2 n2Var = new n2(b((String) arrayList.get(0), "consecutiveLaunchCrashes"), a((String) arrayList.get(1), "crashed"), a((String) arrayList.get(2), "crashedDuringLaunch"));
            this.f18893b.d(m.n("Loaded: ", n2Var));
            return n2Var;
        } catch (NumberFormatException e10) {
            this.f18893b.c("Failed to read consecutiveLaunchCrashes from saved lastRunInfo", e10);
            return null;
        }
    }

    private final void g(n2 n2Var) {
        m2 m2Var = new m2();
        m2Var.a("consecutiveLaunchCrashes", Integer.valueOf(n2Var.a()));
        m2Var.a("crashed", Boolean.valueOf(n2Var.b()));
        m2Var.a("crashedDuringLaunch", Boolean.valueOf(n2Var.c()));
        String m2Var2 = m2Var.toString();
        File parentFile = this.f18892a.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        h.h(this.f18892a, m2Var2, (Charset) null, 2, (Object) null);
        this.f18893b.d(m.n("Persisted: ", m2Var2));
    }

    public final File c() {
        return this.f18892a;
    }

    public final n2 d() {
        n2 n2Var;
        ReentrantReadWriteLock.ReadLock readLock = this.f18894c.readLock();
        readLock.lock();
        try {
            n2Var = e();
        } catch (Throwable th) {
            readLock.unlock();
            throw th;
        }
        readLock.unlock();
        return n2Var;
    }

    public final void f(n2 n2Var) {
        ReentrantReadWriteLock.WriteLock writeLock = this.f18894c.writeLock();
        writeLock.lock();
        try {
            g(n2Var);
        } catch (Throwable th) {
            writeLock.unlock();
            throw th;
        }
        Unit unit = Unit.f12577a;
        writeLock.unlock();
    }
}
