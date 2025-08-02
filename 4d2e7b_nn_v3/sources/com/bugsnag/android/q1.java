package com.bugsnag.android;

import c1.j;
import g0.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import tb.h;

public final class q1 {

    /* renamed from: f  reason: collision with root package name */
    public static final a f18935f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f18936a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18937b;

    /* renamed from: c  reason: collision with root package name */
    private final long f18938c;

    /* renamed from: d  reason: collision with root package name */
    private final String f18939d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f18940e;

    public static final class a {
        private a() {
        }

        public static /* synthetic */ q1 h(a aVar, Object obj, String str, String str2, long j10, j jVar, Boolean bool, int i10, Object obj2) {
            String str3;
            long j11;
            Boolean bool2;
            if ((i10 & 2) != 0) {
                str3 = UUID.randomUUID().toString();
            } else {
                str3 = str;
            }
            if ((i10 & 8) != 0) {
                j11 = System.currentTimeMillis();
            } else {
                j11 = j10;
            }
            if ((i10 & 32) != 0) {
                bool2 = null;
            } else {
                bool2 = bool;
            }
            return aVar.g(obj, str3, str2, j11, jVar, bool2);
        }

        public final String a(File file, j jVar) {
            String str;
            String m02 = kotlin.text.j.m0(file.getName(), "_startupcrash.json");
            String str2 = m02;
            int V = kotlin.text.j.V(str2, "_", 0, false, 6, (Object) null) + 1;
            int V2 = kotlin.text.j.V(str2, "_", V, false, 4, (Object) null);
            if (V == 0 || V2 == -1 || V2 <= V) {
                str = null;
            } else {
                str = m02.substring(V, V2);
                m.e(str, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            if (str == null) {
                return jVar.a();
            }
            return str;
        }

        public final Set b(Object obj) {
            if (obj instanceof o1) {
                return ((o1) obj).i().i();
            }
            return r0.c(ErrorType.C);
        }

        public final Set c(File file) {
            String name = file.getName();
            String str = name;
            int a02 = kotlin.text.j.a0(str, "_", kotlin.text.j.a0(name, "_", 0, false, 6, (Object) null) - 1, false, 4, (Object) null);
            int a03 = kotlin.text.j.a0(str, "_", a02 - 1, false, 4, (Object) null) + 1;
            if (a03 >= a02) {
                return r0.d();
            }
            String substring = name.substring(a03, a02);
            m.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            List v02 = kotlin.text.j.v0(substring, new String[]{","}, false, 0, 6, (Object) null);
            ErrorType[] values = ErrorType.values();
            ArrayList arrayList = new ArrayList();
            int length = values.length;
            int i10 = 0;
            while (i10 < length) {
                ErrorType errorType = values[i10];
                i10++;
                if (v02.contains(errorType.getDesc$bugsnag_android_core_release())) {
                    arrayList.add(errorType);
                }
            }
            return r.A0(arrayList);
        }

        public final String d(Object obj, Boolean bool) {
            if ((!(obj instanceof o1) || !m.b(((o1) obj).f().m(), Boolean.TRUE)) && !m.b(bool, Boolean.TRUE)) {
                return "";
            }
            return "startupcrash";
        }

        public final String e(File file) {
            String n10 = h.n(file);
            boolean z10 = true;
            String substring = n10.substring(kotlin.text.j.a0(n10, "_", 0, false, 6, (Object) null) + 1);
            m.e(substring, "this as java.lang.String).substring(startIndex)");
            if (!m.b(substring, "startupcrash")) {
                z10 = m.b(substring, "not-jvm");
            }
            if (z10) {
                return substring;
            }
            return "";
        }

        public final long f(File file) {
            Long k10 = kotlin.text.j.k(kotlin.text.j.L0(h.n(file), "_", "-1"));
            if (k10 == null) {
                return -1;
            }
            return k10.longValue();
        }

        public final q1 g(Object obj, String str, String str2, long j10, j jVar, Boolean bool) {
            if (obj instanceof o1) {
                str2 = ((o1) obj).e();
            } else if (str2 == null || str2.length() == 0) {
                str2 = jVar.a();
            }
            return new q1(str2, str, j10, d(obj, bool), b(obj));
        }

        public final q1 i(File file, j jVar) {
            return new q1(a(file, jVar), "", f(file), e(file), c(file));
        }

        public final String j(String str, String str2, long j10, String str3, Set set) {
            return j10 + '_' + str + '_' + t0.b(set) + '_' + str2 + '_' + str3 + ".json";
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public q1(String str, String str2, long j10, String str3, Set set) {
        this.f18936a = str;
        this.f18937b = str2;
        this.f18938c = j10;
        this.f18939d = str3;
        this.f18940e = set;
    }

    public final String a() {
        return this.f18936a;
    }

    public final String b() {
        return f18935f.j(this.f18936a, this.f18937b, this.f18938c, this.f18939d, this.f18940e);
    }

    public final String c() {
        return this.f18936a;
    }

    public final Set d() {
        return this.f18940e;
    }

    public final boolean e() {
        return m.b(this.f18939d, "startupcrash");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q1)) {
            return false;
        }
        q1 q1Var = (q1) obj;
        return m.b(this.f18936a, q1Var.f18936a) && m.b(this.f18937b, q1Var.f18937b) && this.f18938c == q1Var.f18938c && m.b(this.f18939d, q1Var.f18939d) && m.b(this.f18940e, q1Var.f18940e);
    }

    public int hashCode() {
        return (((((((this.f18936a.hashCode() * 31) + this.f18937b.hashCode()) * 31) + c.a(this.f18938c)) * 31) + this.f18939d.hashCode()) * 31) + this.f18940e.hashCode();
    }

    public String toString() {
        return "EventFilenameInfo(apiKey=" + this.f18936a + ", uuid=" + this.f18937b + ", timestamp=" + this.f18938c + ", suffix=" + this.f18939d + ", errorTypes=" + this.f18940e + ')';
    }
}
