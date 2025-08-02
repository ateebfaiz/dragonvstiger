package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.io.h;
import com.fasterxml.jackson.core.n;
import j8.f;
import java.io.Serializable;
import l8.l;

public class w implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final w f5732d = new w("", (String) null);

    /* renamed from: e  reason: collision with root package name */
    public static final w f5733e = new w(new String(""), (String) null);

    /* renamed from: a  reason: collision with root package name */
    protected final String f5734a;

    /* renamed from: b  reason: collision with root package name */
    protected final String f5735b;

    /* renamed from: c  reason: collision with root package name */
    protected n f5736c;

    public w(String str) {
        this(str, (String) null);
    }

    public static w a(String str) {
        if (str == null || str.isEmpty()) {
            return f5732d;
        }
        return new w(f.f12416b.a(str), (String) null);
    }

    public static w b(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 != null || !str.isEmpty()) {
            return new w(f.f12416b.a(str), str2);
        }
        return f5732d;
    }

    public String c() {
        return this.f5734a;
    }

    public boolean d() {
        if (this.f5735b != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return !this.f5734a.isEmpty();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        w wVar = (w) obj;
        String str = this.f5734a;
        if (str == null) {
            if (wVar.f5734a != null) {
                return false;
            }
        } else if (!str.equals(wVar.f5734a)) {
            return false;
        }
        String str2 = this.f5735b;
        if (str2 != null) {
            return str2.equals(wVar.f5735b);
        }
        if (wVar.f5735b == null) {
            return true;
        }
        return false;
    }

    public boolean f(String str) {
        return this.f5734a.equals(str);
    }

    public boolean h() {
        if (this.f5735b != null || !this.f5734a.isEmpty()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f5735b;
        if (str == null) {
            return this.f5734a.hashCode();
        }
        return str.hashCode() ^ this.f5734a.hashCode();
    }

    public n i(l lVar) {
        n d10;
        n nVar = this.f5736c;
        if (nVar == null) {
            if (lVar == null) {
                d10 = new h(this.f5734a);
            } else {
                d10 = lVar.d(this.f5734a);
            }
            nVar = d10;
            this.f5736c = nVar;
        }
        return nVar;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        String str;
        if (this.f5735b != null || ((str = this.f5734a) != null && !"".equals(str))) {
            return this;
        }
        return f5732d;
    }

    public String toString() {
        if (this.f5735b == null) {
            return this.f5734a;
        }
        return "{" + this.f5735b + "}" + this.f5734a;
    }

    public w(String str, String str2) {
        this.f5734a = com.fasterxml.jackson.databind.util.f.R(str);
        this.f5735b = str2;
    }
}
