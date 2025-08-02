package com.bugsnag.android;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Writer;

public class k2 extends l2 {
    private final g3 C;
    private final Writer X;

    public interface a {
        void toStream(k2 k2Var);
    }

    public k2(Writer writer) {
        super(writer);
        E(false);
        this.X = writer;
        this.C = new g3();
    }

    public /* bridge */ /* synthetic */ l2 H(long j10) {
        return super.H(j10);
    }

    public /* bridge */ /* synthetic */ l2 I(Boolean bool) {
        return super.I(bool);
    }

    public /* bridge */ /* synthetic */ l2 J(Number number) {
        return super.J(number);
    }

    public /* bridge */ /* synthetic */ l2 K(String str) {
        return super.K(str);
    }

    public /* bridge */ /* synthetic */ l2 L(boolean z10) {
        return super.L(z10);
    }

    /* renamed from: N */
    public k2 v(String str) {
        super.v(str);
        return this;
    }

    public void O(File file) {
        BufferedReader bufferedReader;
        Throwable th;
        if (file != null && file.length() > 0) {
            super.flush();
            b();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                try {
                    e2.b(bufferedReader, this.X);
                    e2.a(bufferedReader);
                    this.X.flush();
                } catch (Throwable th2) {
                    th = th2;
                    e2.a(bufferedReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                e2.a(bufferedReader);
                throw th;
            }
        }
    }

    public void P(Object obj) {
        if (obj instanceof File) {
            O((File) obj);
        } else {
            Q(obj, false);
        }
    }

    public void Q(Object obj, boolean z10) {
        if (obj instanceof a) {
            ((a) obj).toStream(this);
        } else {
            this.C.f(obj, this, z10);
        }
    }

    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    public /* bridge */ /* synthetic */ void flush() {
        super.flush();
    }

    public /* bridge */ /* synthetic */ l2 h() {
        return super.h();
    }

    public /* bridge */ /* synthetic */ l2 j() {
        return super.j();
    }

    public /* bridge */ /* synthetic */ l2 m() {
        return super.m();
    }

    public /* bridge */ /* synthetic */ l2 n() {
        return super.n();
    }

    public /* bridge */ /* synthetic */ l2 y() {
        return super.y();
    }

    k2(k2 k2Var, g3 g3Var) {
        super(k2Var.X);
        E(k2Var.p());
        this.X = k2Var.X;
        this.C = g3Var;
    }
}
