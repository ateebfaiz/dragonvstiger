package com.facebook.hermes.intl;

import android.os.Build;
import androidx.core.text.util.LocalePreferences;
import com.adjust.sdk.Constants;
import com.facebook.hermes.intl.c;
import com.facebook.hermes.intl.j;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.zing.zalo.zalosdk.common.Constant;
import d6.a;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import o4.b;
import o4.i;
import o4.j;
import o4.k;

@a
public class NumberFormat {

    /* renamed from: v  reason: collision with root package name */
    private static String[] f19731v = {"acre", "bit", "byte", LocalePreferences.TemperatureUnit.CELSIUS, "centimeter", "day", "degree", "fahrenheit", "fluid-ounce", "foot", "gallon", "gigabit", "gigabyte", "gram", "hectare", "hour", "inch", "kilobit", "kilobyte", "kilogram", "kilometer", "liter", "megabit", "megabyte", "meter", "mile", "mile-scandinavian", "milliliter", "millimeter", "millisecond", "minute", "month", "ounce", "percent", "petabyte", "pound", "second", "stone", "terabit", "terabyte", "week", "yard", "year"};

    /* renamed from: a  reason: collision with root package name */
    private c.h f19732a;

    /* renamed from: b  reason: collision with root package name */
    private String f19733b = null;

    /* renamed from: c  reason: collision with root package name */
    private c.C0250c f19734c = c.C0250c.SYMBOL;

    /* renamed from: d  reason: collision with root package name */
    private c.d f19735d = c.d.STANDARD;

    /* renamed from: e  reason: collision with root package name */
    private String f19736e = null;

    /* renamed from: f  reason: collision with root package name */
    private c.i f19737f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f19738g = true;

    /* renamed from: h  reason: collision with root package name */
    private int f19739h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f19740i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f19741j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f19742k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f19743l = -1;

    /* renamed from: m  reason: collision with root package name */
    private c.f f19744m;

    /* renamed from: n  reason: collision with root package name */
    private c.g f19745n = c.g.AUTO;

    /* renamed from: o  reason: collision with root package name */
    private c f19746o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f19747p;

    /* renamed from: q  reason: collision with root package name */
    private String f19748q = null;

    /* renamed from: r  reason: collision with root package name */
    private c.e f19749r = null;

    /* renamed from: s  reason: collision with root package name */
    private c.b f19750s;

    /* renamed from: t  reason: collision with root package name */
    private b f19751t = null;

    /* renamed from: u  reason: collision with root package name */
    private b f19752u = null;

    @a
    public NumberFormat(List<String> list, Map<String, Object> map) throws k {
        String str;
        if (Build.VERSION.SDK_INT >= 24) {
            this.f19746o = new q();
        } else {
            this.f19746o = new p();
        }
        a(list, map);
        c cVar = this.f19746o;
        b bVar = this.f19751t;
        if (this.f19747p) {
            str = "";
        } else {
            str = this.f19748q;
        }
        cVar.j(bVar, str, this.f19732a, this.f19735d, this.f19749r, this.f19750s).f(this.f19733b, this.f19734c).k(this.f19738g).i(this.f19739h).g(this.f19744m, this.f19742k, this.f19743l).l(this.f19744m, this.f19740i, this.f19741j).e(this.f19745n).d(this.f19736e, this.f19737f);
    }

    private void a(List list, Map map) {
        Object obj;
        Object obj2;
        int i10;
        Object q10 = j.q();
        j.a aVar = j.a.STRING;
        o4.j.c(q10, "localeMatcher", j.c(map, "localeMatcher", aVar, o4.a.f22985a, "best fit"));
        Object c10 = j.c(map, "numberingSystem", aVar, o4.j.d(), o4.j.d());
        if (o4.j.n(c10) || b(o4.j.h(c10))) {
            o4.j.c(q10, "nu", c10);
            HashMap a10 = i.a(list, q10, Collections.singletonList("nu"));
            b bVar = (b) o4.j.g(a10).get("locale");
            this.f19751t = bVar;
            this.f19752u = bVar.e();
            Object a11 = o4.j.a(a10, "nu");
            if (!o4.j.j(a11)) {
                this.f19747p = false;
                this.f19748q = o4.j.h(a11);
            } else {
                this.f19747p = true;
                this.f19748q = this.f19746o.c(this.f19751t);
            }
            h(map);
            if (this.f19732a == c.h.CURRENCY) {
                if (Build.VERSION.SDK_INT >= 24) {
                    i10 = q.n(this.f19733b);
                } else {
                    i10 = p.n(this.f19733b);
                }
                double d10 = (double) i10;
                obj = o4.j.p(d10);
                obj2 = o4.j.p(d10);
            } else {
                obj = o4.j.p(0.0d);
                if (this.f19732a == c.h.PERCENT) {
                    obj2 = o4.j.p(0.0d);
                } else {
                    obj2 = o4.j.p(3.0d);
                }
            }
            this.f19749r = (c.e) j.d(c.e.class, o4.j.h(j.c(map, "notation", aVar, new String[]{"standard", "scientific", "engineering", "compact"}, "standard")));
            g(map, obj, obj2);
            Object c11 = j.c(map, "compactDisplay", aVar, new String[]{"short", Constants.LONG}, "short");
            if (this.f19749r == c.e.COMPACT) {
                this.f19750s = (c.b) j.d(c.b.class, o4.j.h(c11));
            }
            this.f19738g = o4.j.e(j.c(map, "useGrouping", j.a.BOOLEAN, o4.j.d(), o4.j.o(true)));
            this.f19745n = (c.g) j.d(c.g.class, o4.j.h(j.c(map, "signDisplay", aVar, new String[]{"auto", "never", "always", "exceptZero"}, "auto")));
            return;
        }
        throw new k("Invalid numbering system !");
    }

    private boolean b(String str) {
        return i.o(str, 0, str.length() - 1);
    }

    private boolean c(String str) {
        if (Arrays.binarySearch(f19731v, str) >= 0) {
            return true;
        }
        return false;
    }

    private boolean d(String str) {
        return f(str).matches("^[A-Z][A-Z][A-Z]$");
    }

    private boolean e(String str) {
        if (c(str)) {
            return true;
        }
        int indexOf = str.indexOf("-per-");
        if (indexOf >= 0 && str.indexOf("-per-", indexOf + 1) < 0 && c(str.substring(0, indexOf)) && c(str.substring(indexOf + 5))) {
            return true;
        }
        return false;
    }

    private String f(String str) {
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt < 'a' || charAt > 'z') {
                sb2.append(charAt);
            } else {
                sb2.append((char) (charAt - ' '));
            }
        }
        return sb2.toString();
    }

    private void g(Map map, Object obj, Object obj2) {
        Map map2 = map;
        Object b10 = j.b(map2, "minimumIntegerDigits", o4.j.p(1.0d), o4.j.p(21.0d), o4.j.p(1.0d));
        Object a10 = o4.j.a(map2, "minimumFractionDigits");
        Object a11 = o4.j.a(map2, "maximumFractionDigits");
        Object a12 = o4.j.a(map2, "minimumSignificantDigits");
        Object a13 = o4.j.a(map2, "maximumSignificantDigits");
        this.f19739h = (int) Math.floor(o4.j.f(b10));
        if (!o4.j.n(a12) || !o4.j.n(a13)) {
            this.f19744m = c.f.SIGNIFICANT_DIGITS;
            Object a14 = j.a("minimumSignificantDigits", a12, o4.j.p(1.0d), o4.j.p(21.0d), o4.j.p(1.0d));
            Object a15 = j.a("maximumSignificantDigits", a13, a14, o4.j.p(21.0d), o4.j.p(21.0d));
            this.f19742k = (int) Math.floor(o4.j.f(a14));
            this.f19743l = (int) Math.floor(o4.j.f(a15));
        } else if (!o4.j.n(a10) || !o4.j.n(a11)) {
            this.f19744m = c.f.FRACTION_DIGITS;
            Object a16 = j.a("minimumFractionDigits", a10, o4.j.p(0.0d), o4.j.p(20.0d), o4.j.d());
            Object a17 = j.a("maximumFractionDigits", a11, o4.j.p(0.0d), o4.j.p(20.0d), o4.j.d());
            if (o4.j.n(a16)) {
                a16 = o4.j.p(Math.min(o4.j.f(obj), o4.j.f(a17)));
            } else if (o4.j.n(a17)) {
                a17 = o4.j.p(Math.max(o4.j.f(obj2), o4.j.f(a16)));
            } else if (o4.j.f(a16) > o4.j.f(a17)) {
                throw new k("minimumFractionDigits is greater than maximumFractionDigits");
            }
            this.f19740i = (int) Math.floor(o4.j.f(a16));
            this.f19741j = (int) Math.floor(o4.j.f(a17));
        } else {
            c.e eVar = this.f19749r;
            if (eVar == c.e.COMPACT) {
                this.f19744m = c.f.COMPACT_ROUNDING;
            } else if (eVar == c.e.ENGINEERING) {
                this.f19744m = c.f.FRACTION_DIGITS;
                this.f19741j = 5;
            } else {
                this.f19744m = c.f.FRACTION_DIGITS;
                this.f19740i = (int) Math.floor(o4.j.f(obj));
                this.f19741j = (int) Math.floor(o4.j.f(obj2));
            }
        }
    }

    private void h(Map map) {
        j.a aVar = j.a.STRING;
        this.f19732a = (c.h) j.d(c.h.class, o4.j.h(j.c(map, "style", aVar, new String[]{"decimal", "percent", FirebaseAnalytics.Param.CURRENCY, "unit"}, "decimal")));
        Object c10 = j.c(map, FirebaseAnalytics.Param.CURRENCY, aVar, o4.j.d(), o4.j.d());
        if (o4.j.n(c10)) {
            if (this.f19732a == c.h.CURRENCY) {
                throw new k("Expected currency style !");
            }
        } else if (!d(o4.j.h(c10))) {
            throw new k("Malformed currency code !");
        }
        Object c11 = j.c(map, "currencyDisplay", aVar, new String[]{"symbol", "narrowSymbol", Constant.PARAM_OAUTH_CODE, "name"}, "symbol");
        Object c12 = j.c(map, "currencySign", aVar, new String[]{"accounting", "standard"}, "standard");
        Object c13 = j.c(map, "unit", aVar, o4.j.d(), o4.j.d());
        if (o4.j.n(c13)) {
            if (this.f19732a == c.h.UNIT) {
                throw new k("Expected unit !");
            }
        } else if (!e(o4.j.h(c13))) {
            throw new k("Malformed unit identifier !");
        }
        Object c14 = j.c(map, "unitDisplay", aVar, new String[]{Constants.LONG, "short", "narrow"}, "short");
        c.h hVar = this.f19732a;
        if (hVar == c.h.CURRENCY) {
            this.f19733b = f(o4.j.h(c10));
            this.f19734c = (c.C0250c) j.d(c.C0250c.class, o4.j.h(c11));
            this.f19735d = (c.d) j.d(c.d.class, o4.j.h(c12));
        } else if (hVar == c.h.UNIT) {
            this.f19736e = o4.j.h(c13);
            this.f19737f = (c.i) j.d(c.i.class, o4.j.h(c14));
        }
    }

    @a
    public static List<String> supportedLocalesOf(List<String> list, Map<String, Object> map) throws k {
        String h10 = o4.j.h(j.c(map, "localeMatcher", j.a.STRING, o4.a.f22985a, "best fit"));
        String[] strArr = new String[list.size()];
        if (Build.VERSION.SDK_INT < 24 || !h10.equals("best fit")) {
            return Arrays.asList(g.h((String[]) list.toArray(strArr)));
        }
        return Arrays.asList(g.d((String[]) list.toArray(strArr)));
    }

    @a
    public String format(double d10) throws k {
        return this.f19746o.b(d10);
    }

    @a
    public List<Map<String, String>> formatToParts(double d10) throws k {
        String str;
        ArrayList arrayList = new ArrayList();
        AttributedCharacterIterator a10 = this.f19746o.a(d10);
        StringBuilder sb2 = new StringBuilder();
        for (char first = a10.first(); first != 65535; first = a10.next()) {
            sb2.append(first);
            if (a10.getIndex() + 1 == a10.getRunLimit()) {
                Iterator<AttributedCharacterIterator.Attribute> it = a10.getAttributes().keySet().iterator();
                if (it.hasNext()) {
                    str = this.f19746o.h(it.next(), d10);
                } else {
                    str = "literal";
                }
                String sb3 = sb2.toString();
                sb2.setLength(0);
                HashMap hashMap = new HashMap();
                hashMap.put("type", str);
                hashMap.put("value", sb3);
                arrayList.add(hashMap);
            }
        }
        return arrayList;
    }

    @a
    public Map<String, Object> resolvedOptions() throws k {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("locale", this.f19752u.a());
        linkedHashMap.put("numberingSystem", this.f19748q);
        linkedHashMap.put("style", this.f19732a.toString());
        c.h hVar = this.f19732a;
        if (hVar == c.h.CURRENCY) {
            linkedHashMap.put(FirebaseAnalytics.Param.CURRENCY, this.f19733b);
            linkedHashMap.put("currencyDisplay", this.f19734c.toString());
            linkedHashMap.put("currencySign", this.f19735d.toString());
        } else if (hVar == c.h.UNIT) {
            linkedHashMap.put("unit", this.f19736e);
            linkedHashMap.put("unitDisplay", this.f19737f.toString());
        }
        int i10 = this.f19739h;
        if (i10 != -1) {
            linkedHashMap.put("minimumIntegerDigits", Integer.valueOf(i10));
        }
        c.f fVar = this.f19744m;
        if (fVar == c.f.SIGNIFICANT_DIGITS) {
            int i11 = this.f19743l;
            if (i11 != -1) {
                linkedHashMap.put("minimumSignificantDigits", Integer.valueOf(i11));
            }
            int i12 = this.f19742k;
            if (i12 != -1) {
                linkedHashMap.put("maximumSignificantDigits", Integer.valueOf(i12));
            }
        } else if (fVar == c.f.FRACTION_DIGITS) {
            int i13 = this.f19740i;
            if (i13 != -1) {
                linkedHashMap.put("minimumFractionDigits", Integer.valueOf(i13));
            }
            int i14 = this.f19741j;
            if (i14 != -1) {
                linkedHashMap.put("maximumFractionDigits", Integer.valueOf(i14));
            }
        }
        linkedHashMap.put("useGrouping", Boolean.valueOf(this.f19738g));
        linkedHashMap.put("notation", this.f19749r.toString());
        if (this.f19749r == c.e.COMPACT) {
            linkedHashMap.put("compactDisplay", this.f19750s.toString());
        }
        linkedHashMap.put("signDisplay", this.f19745n.toString());
        return linkedHashMap;
    }
}
