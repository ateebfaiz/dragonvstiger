package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.c0;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public abstract class k extends c0 {

    /* renamed from: f  reason: collision with root package name */
    protected final File f4822f;

    /* renamed from: g  reason: collision with root package name */
    protected final String f4823g;

    protected static final class a extends c0.c implements Comparable {

        /* renamed from: c  reason: collision with root package name */
        final ZipEntry f4824c;

        /* renamed from: d  reason: collision with root package name */
        final int f4825d;

        a(String str, ZipEntry zipEntry, int i10) {
            super(str, String.valueOf(zipEntry.getCrc()));
            this.f4824c = zipEntry;
            this.f4825d = i10;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            return this.f4800a.compareTo(aVar.f4800a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f4824c.equals(aVar.f4824c) || this.f4825d != aVar.f4825d) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f4825d * 31) + this.f4824c.hashCode();
        }
    }

    protected class b extends c0.e {

        /* renamed from: a  reason: collision with root package name */
        protected a[] f4826a;

        /* renamed from: b  reason: collision with root package name */
        private final ZipFile f4827b;

        /* renamed from: c  reason: collision with root package name */
        private final c0 f4828c;

        b(c0 c0Var) {
            this.f4827b = new ZipFile(k.this.f4822f);
            this.f4828c = c0Var;
        }

        public final c0.c[] b() {
            return k();
        }

        public void close() {
            this.f4827b.close();
        }

        public void h(File file) {
            c0.d dVar;
            a[] k10 = k();
            byte[] bArr = new byte[32768];
            int length = k10.length;
            int i10 = 0;
            while (i10 < length) {
                a aVar = k10[i10];
                InputStream inputStream = this.f4827b.getInputStream(aVar.f4824c);
                try {
                    dVar = new c0.d(aVar, inputStream);
                    inputStream = null;
                    a(dVar, bArr, file);
                    dVar.close();
                    i10++;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            }
            return;
            throw th;
        }

        /* access modifiers changed from: package-private */
        public a[] j() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            HashMap hashMap = new HashMap();
            Pattern compile = Pattern.compile(k.this.f4823g);
            String[] j10 = SysUtil.j();
            Enumeration<? extends ZipEntry> entries = this.f4827b.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                Matcher matcher = compile.matcher(zipEntry.getName());
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    int e10 = SysUtil.e(j10, group);
                    if (e10 >= 0) {
                        linkedHashSet.add(group);
                        a aVar = (a) hashMap.get(group2);
                        if (aVar == null || e10 < aVar.f4825d) {
                            hashMap.put(group2, new a(group2, zipEntry, e10));
                        }
                    }
                }
            }
            this.f4828c.s((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
            a[] aVarArr = (a[]) hashMap.values().toArray(new a[hashMap.size()]);
            Arrays.sort(aVarArr);
            return aVarArr;
        }

        /* access modifiers changed from: package-private */
        public abstract a[] k();
    }

    public k(Context context, String str, File file, String str2) {
        super(context, str);
        this.f4822f = file;
        this.f4823g = str2;
    }
}
