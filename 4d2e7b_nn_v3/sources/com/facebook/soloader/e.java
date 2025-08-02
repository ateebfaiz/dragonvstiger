package com.facebook.soloader;

import android.os.StrictMode;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class e extends a0 {

    /* renamed from: a  reason: collision with root package name */
    protected final File f4807a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f4808b;

    /* renamed from: c  reason: collision with root package name */
    protected final List f4809c;

    public e(File file, int i10) {
        this(file, i10, new String[0]);
    }

    public String c() {
        return "DirectorySoSource";
    }

    public int d(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        return g(str, i10, this.f4807a, threadPolicy);
    }

    /* access modifiers changed from: protected */
    public File f(String str) {
        File file = new File(this.f4807a, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int g(String str, int i10, File file, StrictMode.ThreadPolicy threadPolicy) {
        if (SoLoader.f4774b == null) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        } else if (this.f4809c.contains(str)) {
            m.a("SoLoader", str + " is on the denyList, skip loading from " + file.getCanonicalPath());
            return 0;
        } else {
            File f10 = f(str);
            if (f10 == null) {
                m.f("SoLoader", str + " file not found on " + file.getCanonicalPath());
                return 0;
            }
            String canonicalPath = f10.getCanonicalPath();
            m.a("SoLoader", str + " file found at " + canonicalPath);
            if ((i10 & 1) == 0 || (this.f4808b & 2) == 0) {
                if ((this.f4808b & 1) != 0) {
                    h hVar = new h(f10);
                    try {
                        p.h(str, hVar, i10, threadPolicy);
                        hVar.close();
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                } else {
                    m.a("SoLoader", "Not resolving dependencies for " + str);
                }
                try {
                    SoLoader.f4774b.a(canonicalPath, i10);
                    return 1;
                } catch (UnsatisfiedLinkError e10) {
                    throw z.b(str, e10);
                }
            } else {
                m.a("SoLoader", str + " loaded implicitly");
                return 2;
            }
        }
        throw th;
    }

    public String toString() {
        String str;
        try {
            str = String.valueOf(this.f4807a.getCanonicalPath());
        } catch (IOException unused) {
            str = this.f4807a.getName();
        }
        return c() + "[root = " + str + " flags = " + this.f4808b + ']';
    }

    public e(File file, int i10, String[] strArr) {
        this.f4807a = file;
        this.f4808b = i10;
        this.f4809c = Arrays.asList(strArr);
    }
}
