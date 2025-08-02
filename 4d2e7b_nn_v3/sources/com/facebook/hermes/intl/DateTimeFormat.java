package com.facebook.hermes.intl;

import android.os.Build;
import androidx.core.text.util.LocalePreferences;
import com.adjust.sdk.Constants;
import com.facebook.hermes.intl.b;
import com.facebook.hermes.intl.j;
import d6.a;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import o4.b;
import o4.i;
import o4.j;
import o4.k;

@a
public class DateTimeFormat {

    /* renamed from: a  reason: collision with root package name */
    b f19709a;

    /* renamed from: b  reason: collision with root package name */
    private b f19710b = null;

    /* renamed from: c  reason: collision with root package name */
    private b f19711c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19712d;

    /* renamed from: e  reason: collision with root package name */
    private String f19713e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19714f;

    /* renamed from: g  reason: collision with root package name */
    private String f19715g;

    /* renamed from: h  reason: collision with root package name */
    private Object f19716h;

    /* renamed from: i  reason: collision with root package name */
    private b.g f19717i;

    /* renamed from: j  reason: collision with root package name */
    private b.e f19718j;

    /* renamed from: k  reason: collision with root package name */
    private b.m f19719k;

    /* renamed from: l  reason: collision with root package name */
    private b.d f19720l;

    /* renamed from: m  reason: collision with root package name */
    private b.n f19721m;

    /* renamed from: n  reason: collision with root package name */
    private b.i f19722n;

    /* renamed from: o  reason: collision with root package name */
    private b.c f19723o;

    /* renamed from: p  reason: collision with root package name */
    private b.f f19724p;

    /* renamed from: q  reason: collision with root package name */
    private b.h f19725q;

    /* renamed from: r  reason: collision with root package name */
    private b.j f19726r;

    /* renamed from: s  reason: collision with root package name */
    private b.l f19727s;

    /* renamed from: t  reason: collision with root package name */
    private b.C0249b f19728t;

    /* renamed from: u  reason: collision with root package name */
    private b.k f19729u;

    /* renamed from: v  reason: collision with root package name */
    private Object f19730v = null;

    @a
    public DateTimeFormat(List<String> list, Map<String, Object> map) throws k {
        String str;
        if (Build.VERSION.SDK_INT >= 24) {
            this.f19709a = new o();
        } else {
            this.f19709a = new n();
        }
        c(list, map);
        b bVar = this.f19709a;
        o4.b bVar2 = this.f19710b;
        String str2 = "";
        if (this.f19712d) {
            str = str2;
        } else {
            str = this.f19713e;
        }
        bVar.e(bVar2, str, !this.f19714f ? this.f19715g : str2, this.f19718j, this.f19719k, this.f19720l, this.f19721m, this.f19722n, this.f19723o, this.f19724p, this.f19725q, this.f19726r, this.f19727s, this.f19717i, this.f19730v, this.f19728t, this.f19729u, this.f19716h);
    }

    private Object a() {
        return this.f19709a.d(this.f19710b);
    }

    private Object b(Object obj, String str, String str2) {
        Object obj2 = obj;
        String str3 = str;
        String str4 = str2;
        if (j.l(obj)) {
            boolean z10 = true;
            if (str3.equals("date") || str3.equals("any")) {
                String[] strArr = {"weekday", "year", "month", "day"};
                for (int i10 = 0; i10 < 4; i10++) {
                    if (!j.n(j.a(obj2, strArr[i10]))) {
                        z10 = false;
                    }
                }
            }
            if (str3.equals("time") || str3.equals("any")) {
                String[] strArr2 = {"hour", "minute", "second"};
                for (int i11 = 0; i11 < 3; i11++) {
                    if (!j.n(j.a(obj2, strArr2[i11]))) {
                        z10 = false;
                    }
                }
            }
            if (!j.n(j.a(obj2, "dateStyle")) || !j.n(j.a(obj2, "timeStyle"))) {
                z10 = false;
            }
            if (z10 && (str4.equals("date") || str4.equals("all"))) {
                String[] strArr3 = {"year", "month", "day"};
                for (int i12 = 0; i12 < 3; i12++) {
                    j.c(obj2, strArr3[i12], "numeric");
                }
            }
            if (z10 && (str4.equals("time") || str4.equals("all"))) {
                String[] strArr4 = {"hour", "minute", "second"};
                for (int i13 = 0; i13 < 3; i13++) {
                    j.c(obj2, strArr4[i13], "numeric");
                }
            }
            return obj2;
        }
        throw new k("Invalid options object !");
    }

    private void c(List list, Map map) {
        Object obj;
        b.g gVar;
        List asList = Arrays.asList(new String[]{"ca", "nu", "hc"});
        Object b10 = b(map, "any", "date");
        Object q10 = j.q();
        j.a aVar = j.a.STRING;
        o4.j.c(q10, "localeMatcher", j.c(b10, "localeMatcher", aVar, o4.a.f22985a, "best fit"));
        Object c10 = j.c(b10, "calendar", aVar, o4.j.d(), o4.j.d());
        if (o4.j.n(c10) || d(o4.j.h(c10))) {
            o4.j.c(q10, "ca", c10);
            Object c11 = j.c(b10, "numberingSystem", aVar, o4.j.d(), o4.j.d());
            if (o4.j.n(c11) || d(o4.j.h(c11))) {
                o4.j.c(q10, "nu", c11);
                Object c12 = j.c(b10, "hour12", j.a.BOOLEAN, o4.j.d(), o4.j.d());
                Object c13 = j.c(b10, "hourCycle", aVar, new String[]{LocalePreferences.HourCycle.H11, LocalePreferences.HourCycle.H12, LocalePreferences.HourCycle.H23, LocalePreferences.HourCycle.H24}, o4.j.d());
                if (!o4.j.n(c12)) {
                    c13 = o4.j.b();
                }
                o4.j.c(q10, "hc", c13);
                HashMap a10 = i.a(list, q10, asList);
                o4.b bVar = (o4.b) o4.j.g(a10).get("locale");
                this.f19710b = bVar;
                this.f19711c = bVar.e();
                Object a11 = o4.j.a(a10, "ca");
                if (!o4.j.j(a11)) {
                    this.f19712d = false;
                    this.f19713e = o4.j.h(a11);
                } else {
                    this.f19712d = true;
                    this.f19713e = this.f19709a.h(this.f19710b);
                }
                Object a12 = o4.j.a(a10, "nu");
                if (!o4.j.j(a12)) {
                    this.f19714f = false;
                    this.f19715g = o4.j.h(a12);
                } else {
                    this.f19714f = true;
                    this.f19715g = this.f19709a.c(this.f19710b);
                }
                Object a13 = o4.j.a(a10, "hc");
                Object a14 = o4.j.a(b10, "timeZone");
                if (o4.j.n(a14)) {
                    obj = a();
                } else {
                    obj = e(a14.toString());
                }
                this.f19730v = obj;
                this.f19718j = (b.e) j.d(b.e.class, o4.j.h(j.c(b10, "formatMatcher", aVar, new String[]{"basic", "best fit"}, "best fit")));
                this.f19719k = (b.m) j.d(b.m.class, j.c(b10, "weekday", aVar, new String[]{Constants.LONG, "short", "narrow"}, o4.j.d()));
                this.f19720l = (b.d) j.d(b.d.class, j.c(b10, "era", aVar, new String[]{Constants.LONG, "short", "narrow"}, o4.j.d()));
                this.f19721m = (b.n) j.d(b.n.class, j.c(b10, "year", aVar, new String[]{"numeric", "2-digit"}, o4.j.d()));
                this.f19722n = (b.i) j.d(b.i.class, j.c(b10, "month", aVar, new String[]{"numeric", "2-digit", Constants.LONG, "short", "narrow"}, o4.j.d()));
                this.f19723o = (b.c) j.d(b.c.class, j.c(b10, "day", aVar, new String[]{"numeric", "2-digit"}, o4.j.d()));
                Object c14 = j.c(b10, "hour", aVar, new String[]{"numeric", "2-digit"}, o4.j.d());
                this.f19724p = (b.f) j.d(b.f.class, c14);
                this.f19725q = (b.h) j.d(b.h.class, j.c(b10, "minute", aVar, new String[]{"numeric", "2-digit"}, o4.j.d()));
                this.f19726r = (b.j) j.d(b.j.class, j.c(b10, "second", aVar, new String[]{"numeric", "2-digit"}, o4.j.d()));
                this.f19727s = (b.l) j.d(b.l.class, j.c(b10, "timeZoneName", aVar, new String[]{Constants.LONG, "longOffset", "longGeneric", "short", "shortOffset", "shortGeneric"}, o4.j.d()));
                this.f19728t = (b.C0249b) j.d(b.C0249b.class, j.c(b10, "dateStyle", aVar, new String[]{"full", Constants.LONG, "medium", "short"}, o4.j.d()));
                Object c15 = j.c(b10, "timeStyle", aVar, new String[]{"full", Constants.LONG, "medium", "short"}, o4.j.d());
                this.f19729u = (b.k) j.d(b.k.class, c15);
                if (!o4.j.n(c14) || !o4.j.n(c15)) {
                    b.g g10 = this.f19709a.g(this.f19710b);
                    if (o4.j.j(a13)) {
                        gVar = g10;
                    } else {
                        gVar = (b.g) j.d(b.g.class, a13);
                    }
                    if (!o4.j.n(c12)) {
                        if (o4.j.e(c12)) {
                            gVar = b.g.H11;
                            if (!(g10 == gVar || g10 == b.g.H23)) {
                                gVar = b.g.H12;
                            }
                        } else {
                            gVar = (g10 == b.g.H11 || g10 == b.g.H23) ? b.g.H23 : b.g.H24;
                        }
                    }
                    this.f19717i = gVar;
                } else {
                    this.f19717i = b.g.UNDEFINED;
                }
                this.f19716h = c12;
                return;
            }
            throw new k("Invalid numbering system !");
        }
        throw new k("Invalid calendar option !");
    }

    private boolean d(String str) {
        return i.o(str, 0, str.length() - 1);
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

    public String e(String str) {
        for (String str2 : TimeZone.getAvailableIDs()) {
            if (f(str2).equals(f(str))) {
                return str2;
            }
        }
        throw new k("Invalid timezone name!");
    }

    public String f(String str) {
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt < 'A' || charAt > 'Z') {
                sb2.append(charAt);
            } else {
                sb2.append((char) (charAt + ' '));
            }
        }
        return sb2.toString();
    }

    @a
    public String format(double d10) throws k {
        return this.f19709a.b(d10);
    }

    @a
    public List<Map<String, String>> formatToParts(double d10) throws k {
        String str;
        ArrayList arrayList = new ArrayList();
        AttributedCharacterIterator a10 = this.f19709a.a(d10);
        StringBuilder sb2 = new StringBuilder();
        for (char first = a10.first(); first != 65535; first = a10.next()) {
            sb2.append(first);
            if (a10.getIndex() + 1 == a10.getRunLimit()) {
                Iterator<AttributedCharacterIterator.Attribute> it = a10.getAttributes().keySet().iterator();
                if (it.hasNext()) {
                    str = this.f19709a.f(it.next(), sb2.toString());
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
        linkedHashMap.put("locale", this.f19711c.a());
        linkedHashMap.put("numberingSystem", this.f19715g);
        linkedHashMap.put("calendar", this.f19713e);
        linkedHashMap.put("timeZone", this.f19730v);
        b.g gVar = this.f19717i;
        if (gVar != b.g.UNDEFINED) {
            linkedHashMap.put("hourCycle", gVar.toString());
            b.g gVar2 = this.f19717i;
            if (gVar2 == b.g.H11 || gVar2 == b.g.H12) {
                linkedHashMap.put("hour12", Boolean.TRUE);
            } else {
                linkedHashMap.put("hour12", Boolean.FALSE);
            }
        }
        b.m mVar = this.f19719k;
        if (mVar != b.m.UNDEFINED) {
            linkedHashMap.put("weekday", mVar.toString());
        }
        b.d dVar = this.f19720l;
        if (dVar != b.d.UNDEFINED) {
            linkedHashMap.put("era", dVar.toString());
        }
        b.n nVar = this.f19721m;
        if (nVar != b.n.UNDEFINED) {
            linkedHashMap.put("year", nVar.toString());
        }
        b.i iVar = this.f19722n;
        if (iVar != b.i.UNDEFINED) {
            linkedHashMap.put("month", iVar.toString());
        }
        b.c cVar = this.f19723o;
        if (cVar != b.c.UNDEFINED) {
            linkedHashMap.put("day", cVar.toString());
        }
        b.f fVar = this.f19724p;
        if (fVar != b.f.UNDEFINED) {
            linkedHashMap.put("hour", fVar.toString());
        }
        b.h hVar = this.f19725q;
        if (hVar != b.h.UNDEFINED) {
            linkedHashMap.put("minute", hVar.toString());
        }
        b.j jVar = this.f19726r;
        if (jVar != b.j.UNDEFINED) {
            linkedHashMap.put("second", jVar.toString());
        }
        b.l lVar = this.f19727s;
        if (lVar != b.l.UNDEFINED) {
            linkedHashMap.put("timeZoneName", lVar.toString());
        }
        b.C0249b bVar = this.f19728t;
        if (bVar != b.C0249b.UNDEFINED) {
            linkedHashMap.put("dateStyle", bVar.toString());
        }
        b.k kVar = this.f19729u;
        if (kVar != b.k.UNDEFINED) {
            linkedHashMap.put("timeStyle", kVar.toString());
        }
        return linkedHashMap;
    }
}
