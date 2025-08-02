package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.h0;
import com.fasterxml.jackson.databind.introspect.i;
import java.io.Serializable;

public class v implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public static final v f5720h = new v(Boolean.TRUE, (String) null, (Integer) null, (String) null, (a) null, (h0) null, (h0) null);

    /* renamed from: i  reason: collision with root package name */
    public static final v f5721i = new v(Boolean.FALSE, (String) null, (Integer) null, (String) null, (a) null, (h0) null, (h0) null);

    /* renamed from: j  reason: collision with root package name */
    public static final v f5722j = new v((Boolean) null, (String) null, (Integer) null, (String) null, (a) null, (h0) null, (h0) null);

    /* renamed from: a  reason: collision with root package name */
    protected final Boolean f5723a;

    /* renamed from: b  reason: collision with root package name */
    protected final String f5724b;

    /* renamed from: c  reason: collision with root package name */
    protected final Integer f5725c;

    /* renamed from: d  reason: collision with root package name */
    protected final String f5726d;

    /* renamed from: e  reason: collision with root package name */
    protected final transient a f5727e;

    /* renamed from: f  reason: collision with root package name */
    protected h0 f5728f;

    /* renamed from: g  reason: collision with root package name */
    protected h0 f5729g;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final i f5730a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f5731b;

        protected a(i iVar, boolean z10) {
            this.f5730a = iVar;
            this.f5731b = z10;
        }

        public static a a(i iVar) {
            return new a(iVar, true);
        }

        public static a b(i iVar) {
            return new a(iVar, false);
        }

        public static a c(i iVar) {
            return new a(iVar, false);
        }
    }

    protected v(Boolean bool, String str, Integer num, String str2, a aVar, h0 h0Var, h0 h0Var2) {
        this.f5723a = bool;
        this.f5724b = str;
        this.f5725c = num;
        this.f5726d = (str2 == null || str2.isEmpty()) ? null : str2;
        this.f5727e = aVar;
        this.f5728f = h0Var;
        this.f5729g = h0Var2;
    }

    public static v a(Boolean bool, String str, Integer num, String str2) {
        if (str != null || num != null || str2 != null) {
            return new v(bool, str, num, str2, (a) null, (h0) null, (h0) null);
        }
        if (bool == null) {
            return f5722j;
        }
        if (bool.booleanValue()) {
            return f5720h;
        }
        return f5721i;
    }

    public Integer b() {
        return this.f5725c;
    }

    public boolean c() {
        if (this.f5725c != null) {
            return true;
        }
        return false;
    }

    public v d(String str) {
        return new v(this.f5723a, str, this.f5725c, this.f5726d, this.f5727e, this.f5728f, this.f5729g);
    }

    public v e(a aVar) {
        return new v(this.f5723a, this.f5724b, this.f5725c, this.f5726d, aVar, this.f5728f, this.f5729g);
    }

    public v f(h0 h0Var, h0 h0Var2) {
        return new v(this.f5723a, this.f5724b, this.f5725c, this.f5726d, this.f5727e, h0Var, h0Var2);
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        if (this.f5724b != null || this.f5725c != null || this.f5726d != null || this.f5727e != null || this.f5728f != null || this.f5729g != null) {
            return this;
        }
        Boolean bool = this.f5723a;
        if (bool == null) {
            return f5722j;
        }
        if (bool.booleanValue()) {
            return f5720h;
        }
        return f5721i;
    }
}
