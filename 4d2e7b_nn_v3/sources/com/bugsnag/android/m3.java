package com.bugsnag.android;

import g0.c;
import java.io.File;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class m3 {

    /* renamed from: d  reason: collision with root package name */
    public static final a f18854d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private String f18855a;

    /* renamed from: b  reason: collision with root package name */
    private final long f18856b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18857c;

    public static final class a {
        private a() {
        }

        public final m3 a(Object obj, String str) {
            if (obj instanceof l3) {
                str = ((l3) obj).c();
            }
            return new m3(str, System.currentTimeMillis(), UUID.randomUUID().toString());
        }

        public final String b(File file, String str) {
            if (file == null || !e(file)) {
                return str;
            }
            String str2 = null;
            String M0 = j.M0(file.getName(), '_', (String) null, 2, (Object) null);
            if (M0.length() != 0) {
                str2 = M0;
            }
            if (str2 == null) {
                return str;
            }
            return str2;
        }

        public final long c(File file) {
            String name = file.getName();
            if (e(file)) {
                name = j.F0(file.getName(), '_', (String) null, 2, (Object) null);
            }
            Long k10 = j.k(j.M0(j.R0(name, d(file).length()), '_', (String) null, 2, (Object) null));
            if (k10 == null) {
                return -1;
            }
            return k10.longValue();
        }

        public final String d(File file) {
            String T0;
            String name = file.getName();
            String str = null;
            if (e(file)) {
                name = j.F0(file.getName(), '_', (String) null, 2, (Object) null);
            }
            if (name.length() >= 36) {
                str = name;
            }
            if (str == null || (T0 = j.T0(str, 36)) == null) {
                return "";
            }
            return T0;
        }

        public final boolean e(File file) {
            return j.p(file.getName(), "_v3.json", false, 2, (Object) null);
        }

        public final String f(String str, long j10, String str2) {
            return str + '_' + str2 + j10 + "_v3.json";
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public m3(String str, long j10, String str2) {
        this.f18855a = str;
        this.f18856b = j10;
        this.f18857c = str2;
    }

    public static final String b(File file, String str) {
        return f18854d.b(file, str);
    }

    public final String a() {
        return f18854d.f(this.f18855a, this.f18856b, this.f18857c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m3)) {
            return false;
        }
        m3 m3Var = (m3) obj;
        return m.b(this.f18855a, m3Var.f18855a) && this.f18856b == m3Var.f18856b && m.b(this.f18857c, m3Var.f18857c);
    }

    public int hashCode() {
        return (((this.f18855a.hashCode() * 31) + c.a(this.f18856b)) * 31) + this.f18857c.hashCode();
    }

    public String toString() {
        return "SessionFilenameInfo(apiKey=" + this.f18855a + ", timestamp=" + this.f18856b + ", uuid=" + this.f18857c + ')';
    }
}
