package com.facebook.hermes.intl;

import android.os.Build;
import com.facebook.hermes.intl.a;
import com.facebook.hermes.intl.j;
import com.google.firebase.analytics.FirebaseAnalytics;
import d6.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import o4.b;
import o4.k;
import o4.z3;

@a
public class Collator {

    /* renamed from: a  reason: collision with root package name */
    private a.d f19700a;

    /* renamed from: b  reason: collision with root package name */
    private a.c f19701b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19702c;

    /* renamed from: d  reason: collision with root package name */
    private String f19703d = "default";

    /* renamed from: e  reason: collision with root package name */
    private boolean f19704e;

    /* renamed from: f  reason: collision with root package name */
    private a.b f19705f;

    /* renamed from: g  reason: collision with root package name */
    private b f19706g;

    /* renamed from: h  reason: collision with root package name */
    private b f19707h;

    /* renamed from: i  reason: collision with root package name */
    private a f19708i;

    @d6.a
    public Collator(List<String> list, Map<String, Object> map) throws k {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f19708i = new m();
        } else {
            this.f19708i = new l();
        }
        a(list, map);
        this.f19708i.b(this.f19706g).e(this.f19704e).d(this.f19705f).f(this.f19701b).g(this.f19702c);
    }

    private void a(List list, Map map) {
        j.a aVar = j.a.STRING;
        this.f19700a = (a.d) j.d(a.d.class, o4.j.h(j.c(map, "usage", aVar, o4.a.f22989e, "sort")));
        Object q10 = o4.j.q();
        o4.j.c(q10, "localeMatcher", j.c(map, "localeMatcher", aVar, o4.a.f22985a, "best fit"));
        Object c10 = j.c(map, "numeric", j.a.BOOLEAN, o4.j.d(), o4.j.d());
        if (!o4.j.n(c10)) {
            c10 = o4.j.r(String.valueOf(o4.j.e(c10)));
        }
        o4.j.c(q10, "kn", c10);
        o4.j.c(q10, "kf", j.c(map, "caseFirst", aVar, o4.a.f22988d, o4.j.d()));
        HashMap a10 = i.a(list, q10, Arrays.asList(new String[]{"co", "kf", "kn"}));
        b bVar = (b) o4.j.g(a10).get("locale");
        this.f19706g = bVar;
        this.f19707h = bVar.e();
        Object a11 = o4.j.a(a10, "co");
        if (o4.j.j(a11)) {
            a11 = o4.j.r("default");
        }
        this.f19703d = o4.j.h(a11);
        Object a12 = o4.j.a(a10, "kn");
        if (o4.j.j(a12)) {
            this.f19704e = false;
        } else {
            this.f19704e = Boolean.parseBoolean(o4.j.h(a12));
        }
        Object a13 = o4.j.a(a10, "kf");
        if (o4.j.j(a13)) {
            a13 = o4.j.r("false");
        }
        this.f19705f = (a.b) j.d(a.b.class, o4.j.h(a13));
        if (this.f19700a == a.d.SEARCH) {
            ArrayList c11 = this.f19706g.c("collation");
            ArrayList arrayList = new ArrayList();
            Iterator it = c11.iterator();
            while (it.hasNext()) {
                arrayList.add(z3.e((String) it.next()));
            }
            arrayList.add(z3.e(FirebaseAnalytics.Event.SEARCH));
            this.f19706g.g("co", arrayList);
        }
        Object c12 = j.c(map, "sensitivity", j.a.STRING, o4.a.f22987c, o4.j.d());
        if (!o4.j.n(c12)) {
            this.f19701b = (a.c) j.d(a.c.class, o4.j.h(c12));
        } else if (this.f19700a == a.d.SORT) {
            this.f19701b = a.c.VARIANT;
        } else {
            this.f19701b = a.c.LOCALE;
        }
        this.f19702c = o4.j.e(j.c(map, "ignorePunctuation", j.a.BOOLEAN, o4.j.d(), Boolean.FALSE));
    }

    @d6.a
    public static List<String> supportedLocalesOf(List<String> list, Map<String, Object> map) throws k {
        String h10 = o4.j.h(j.c(map, "localeMatcher", j.a.STRING, o4.a.f22985a, "best fit"));
        if (Build.VERSION.SDK_INT < 24 || !h10.equals("best fit")) {
            return Arrays.asList(g.h((String[]) list.toArray(new String[list.size()])));
        }
        return Arrays.asList(g.d((String[]) list.toArray(new String[list.size()])));
    }

    @d6.a
    public double compare(String str, String str2) {
        return (double) this.f19708i.a(str, str2);
    }

    @d6.a
    public Map<String, Object> resolvedOptions() throws k {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("locale", this.f19707h.a().replace("-kn-true", "-kn"));
        linkedHashMap.put("usage", this.f19700a.toString());
        a.c cVar = this.f19701b;
        if (cVar == a.c.LOCALE) {
            linkedHashMap.put("sensitivity", this.f19708i.c().toString());
        } else {
            linkedHashMap.put("sensitivity", cVar.toString());
        }
        linkedHashMap.put("ignorePunctuation", Boolean.valueOf(this.f19702c));
        linkedHashMap.put("collation", this.f19703d);
        linkedHashMap.put("numeric", Boolean.valueOf(this.f19704e));
        linkedHashMap.put("caseFirst", this.f19705f.toString());
        return linkedHashMap;
    }
}
