package com.facebook.soloader;

import android.content.Context;
import android.os.StrictMode;
import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class d extends a0 implements s {

    /* renamed from: a  reason: collision with root package name */
    private final Map f4804a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map f4805b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Set f4806c;

    public d(Context context) {
        this.f4806c = l(context);
    }

    private void f(String str, String str2, String str3) {
        synchronized (this.f4805b) {
            try {
                String str4 = str + str2;
                if (!this.f4805b.containsKey(str4)) {
                    this.f4805b.put(str4, new HashSet());
                }
                ((Set) this.f4805b.get(str4)).add(str3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void g(String str, String str2) {
        synchronized (this.f4804a) {
            try {
                if (!this.f4804a.containsKey(str)) {
                    this.f4804a.put(str, new HashSet());
                }
                ((Set) this.f4804a.get(str)).add(str2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void h(String str, String str2) {
        ZipFile zipFile = new ZipFile(j(str));
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                if (zipEntry != null) {
                    String name = zipEntry.getName();
                    if (name.endsWith(DomExceptionUtils.SEPARATOR + str2)) {
                        i(str, zipFile, zipEntry, str2);
                    }
                }
            }
            zipFile.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private void i(String str, ZipFile zipFile, ZipEntry zipEntry, String str2) {
        i iVar = new i(zipFile, zipEntry);
        try {
            for (String str3 : p.b(str2, iVar)) {
                if (!str3.startsWith(DomExceptionUtils.SEPARATOR)) {
                    f(str, str2, str3);
                }
            }
            iVar.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static String j(String str) {
        return str.substring(0, str.indexOf(33));
    }

    private Set k(String str, String str2) {
        Set set;
        synchronized (this.f4805b) {
            set = (Set) this.f4805b.get(str + str2);
        }
        return set;
    }

    static Set l(Context context) {
        HashSet hashSet = new HashSet();
        String m10 = m(context.getApplicationInfo().sourceDir);
        if (m10 != null) {
            hashSet.add(m10);
        }
        if (context.getApplicationInfo().splitSourceDirs != null) {
            for (String m11 : context.getApplicationInfo().splitSourceDirs) {
                String m12 = m(m11);
                if (m12 != null) {
                    hashSet.add(m12);
                }
            }
        }
        return hashSet;
    }

    private static String m(String str) {
        String[] j10 = SysUtil.j();
        String str2 = "empty";
        if (str == null || str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot compute fallback path, apk path is ");
            if (str == null) {
                str2 = "null";
            }
            sb2.append(str2);
            m.g("SoLoader", sb2.toString());
            return null;
        } else if (j10 == null || j10.length == 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Cannot compute fallback path, supportedAbis is ");
            if (j10 == null) {
                str2 = "null";
            }
            sb3.append(str2);
            m.g("SoLoader", sb3.toString());
            return null;
        } else {
            return str + "!/lib/" + j10[0];
        }
    }

    private void o(String str, String str2, int i10, StrictMode.ThreadPolicy threadPolicy) {
        Set<String> k10 = k(str, str2);
        if (k10 == null) {
            h(str, str2);
            k10 = k(str, str2);
        }
        if (k10 != null) {
            for (String s10 : k10) {
                SoLoader.s(s10, i10, threadPolicy);
            }
        }
    }

    private void p() {
        int indexOf;
        int i10;
        String str = null;
        for (String str2 : this.f4806c) {
            if (!TextUtils.isEmpty(str2) && (indexOf = str2.indexOf(33)) >= 0 && (i10 = indexOf + 2) < str2.length()) {
                str = str2.substring(i10);
            }
            if (!TextUtils.isEmpty(str)) {
                ZipFile zipFile = new ZipFile(j(str2));
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        if (zipEntry != null && zipEntry.getMethod() == 0 && zipEntry.getName().startsWith(str) && zipEntry.getName().endsWith(".so")) {
                            g(str2, zipEntry.getName().substring(str.length() + 1));
                        }
                    }
                    zipFile.close();
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
        }
        return;
        throw th;
    }

    public a0 b(Context context) {
        d dVar = new d(context);
        try {
            dVar.p();
            return dVar;
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public String c() {
        return "DirectApkSoSource";
    }

    public int d(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        if (SoLoader.f4774b != null) {
            for (String str2 : this.f4806c) {
                Set set = (Set) this.f4804a.get(str2);
                if (TextUtils.isEmpty(str2) || set == null || !set.contains(str)) {
                    m.f("SoLoader", str + " not found on " + str2);
                } else {
                    o(str2, str, i10, threadPolicy);
                    try {
                        i10 |= 4;
                        SoLoader.f4774b.a(str2 + File.separator + str, i10);
                        m.a("SoLoader", str + " found on " + str2);
                        return 1;
                    } catch (UnsatisfiedLinkError e10) {
                        m.h("SoLoader", str + " not found on " + str2 + " flag: " + i10, e10);
                    }
                }
            }
            return 0;
        }
        throw new IllegalStateException("SoLoader.init() not yet called");
    }

    /* access modifiers changed from: protected */
    public void e(int i10) {
        p();
    }

    public boolean n() {
        return !this.f4806c.isEmpty();
    }

    public String toString() {
        return c() + "[root = " + this.f4806c.toString() + ']';
    }
}
