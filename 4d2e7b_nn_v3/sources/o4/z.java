package o4;

import android.icu.util.ULocale;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class z implements b {

    /* renamed from: a  reason: collision with root package name */
    private ULocale f22992a;

    /* renamed from: b  reason: collision with root package name */
    private ULocale.Builder f22993b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22994c;

    private z(ULocale uLocale) {
        this.f22993b = null;
        this.f22994c = false;
        this.f22992a = uLocale;
    }

    public static b i() {
        return new z(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public static b j(String str) {
        return new z(str);
    }

    public static b k(ULocale uLocale) {
        return new z(uLocale);
    }

    private void l() {
        if (this.f22994c) {
            try {
                this.f22992a = this.f22993b.build();
                this.f22994c = false;
            } catch (RuntimeException e10) {
                throw new k(e10.getMessage());
            }
        }
    }

    public String a() {
        return h().toLanguageTag();
    }

    public HashMap b() {
        l();
        HashMap hashMap = new HashMap();
        Iterator a10 = this.f22992a.getKeywords();
        if (a10 != null) {
            while (a10.hasNext()) {
                String str = (String) a10.next();
                hashMap.put(z3.b(str), this.f22992a.getKeywordValue(str));
            }
        }
        return hashMap;
    }

    public ArrayList c(String str) {
        l();
        String a10 = z3.a(str);
        ArrayList arrayList = new ArrayList();
        String a11 = this.f22992a.getKeywordValue(a10);
        if (a11 != null && !a11.isEmpty()) {
            Collections.addAll(arrayList, a11.split("-|_"));
        }
        return arrayList;
    }

    public b e() {
        l();
        return new z(this.f22992a);
    }

    public String f() {
        return d().toLanguageTag();
    }

    public void g(String str, ArrayList arrayList) {
        l();
        if (this.f22993b == null) {
            this.f22993b = y.a().setLocale(this.f22992a);
        }
        try {
            ULocale.Builder unused = this.f22993b.setUnicodeLocaleKeyword(str, TextUtils.join("-", arrayList));
            this.f22994c = true;
        } catch (RuntimeException e10) {
            throw new k(e10.getMessage());
        }
    }

    /* renamed from: m */
    public ULocale h() {
        l();
        return this.f22992a;
    }

    /* renamed from: n */
    public ULocale d() {
        l();
        ULocale.Builder a10 = y.a();
        ULocale.Builder unused = a10.setLocale(this.f22992a);
        ULocale.Builder unused2 = a10.clearExtensions();
        return a10.build();
    }

    private z(String str) {
        this.f22992a = null;
        this.f22993b = null;
        this.f22994c = false;
        ULocale.Builder a10 = y.a();
        this.f22993b = a10;
        try {
            ULocale.Builder unused = a10.setLanguageTag(str);
            this.f22994c = true;
        } catch (RuntimeException e10) {
            throw new k(e10.getMessage());
        }
    }
}
