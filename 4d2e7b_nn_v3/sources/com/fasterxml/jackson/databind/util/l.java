package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f5692a = new e();

    static class a extends l {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f5693b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f5694c;

        a(String str, String str2) {
            this.f5693b = str;
            this.f5694c = str2;
        }

        public String c(String str) {
            return this.f5693b + str + this.f5694c;
        }

        public String toString() {
            return "[PreAndSuffixTransformer('" + this.f5693b + "','" + this.f5694c + "')]";
        }
    }

    static class b extends l {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f5695b;

        b(String str) {
            this.f5695b = str;
        }

        public String c(String str) {
            return this.f5695b + str;
        }

        public String toString() {
            return "[PrefixTransformer('" + this.f5695b + "')]";
        }
    }

    static class c extends l {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f5696b;

        c(String str) {
            this.f5696b = str;
        }

        public String c(String str) {
            return str + this.f5696b;
        }

        public String toString() {
            return "[SuffixTransformer('" + this.f5696b + "')]";
        }
    }

    public static class d extends l implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        protected final l f5697b;

        /* renamed from: c  reason: collision with root package name */
        protected final l f5698c;

        public d(l lVar, l lVar2) {
            this.f5697b = lVar;
            this.f5698c = lVar2;
        }

        public String c(String str) {
            return this.f5697b.c(this.f5698c.c(str));
        }

        public String toString() {
            return "[ChainedTransformer(" + this.f5697b + ", " + this.f5698c + ")]";
        }
    }

    protected static final class e extends l implements Serializable {
        protected e() {
        }

        public String c(String str) {
            return str;
        }
    }

    protected l() {
    }

    public static l a(l lVar, l lVar2) {
        return new d(lVar, lVar2);
    }

    public static l b(String str, String str2) {
        boolean z10;
        boolean z11 = false;
        if (str == null || str.isEmpty()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (str2 != null && !str2.isEmpty()) {
            z11 = true;
        }
        if (z10) {
            if (z11) {
                return new a(str, str2);
            }
            return new b(str);
        } else if (z11) {
            return new c(str2);
        } else {
            return f5692a;
        }
    }

    public abstract String c(String str);
}
