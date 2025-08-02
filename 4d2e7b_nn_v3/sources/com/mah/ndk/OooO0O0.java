package com.mah.ndk;

import OooO0o0.OooO0Oo;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.alibaba.pdns.f;
import com.mah.ndk.OooO00o;
import d.c;
import d.k;
import h.a;
import h.b;
import h.g;
import h.i;
import h.j;
import i.p;
import i.v;
import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k.a;
import s.e;
import v.a;
import w.d;

public class OooO0O0 {

    /* renamed from: OooO0o0  reason: collision with root package name */
    public static final String f10166OooO0o0 = d.f("");
    public final Context OooO00o;
    public final String OooO0O0;
    public final k OooO0OO;
    public final c OooO0Oo;

    public static class OooO00o {
        public final String OooO00o;
        public final List<String> OooO0O0;

        public OooO00o(String str, List<String> list) {
            this.OooO00o = str;
            this.OooO0O0 = list;
        }
    }

    public interface OooO0OO {
        String OooO00o();
    }

    public OooO0O0(Context context, c cVar, k kVar) {
        this.OooO00o = context;
        this.OooO0Oo = cVar;
        this.OooO0OO = kVar;
        this.OooO0O0 = new File(context.getFilesDir(), "a.data").getAbsolutePath();
    }

    public static String OooO00o(String str) {
        return str;
    }

    public static List<C0118OooO0O0> OooO0OO(g gVar) {
        ArrayList arrayList = new ArrayList();
        String str = gVar.f21794t;
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(C0118OooO0O0.OooO00o(str, OooO0O0(gVar.f21791q), false, OooO00o.C0365OooO0Oo.OooO0oo));
        }
        String str2 = gVar.f21795u;
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(C0118OooO0O0.OooO00o(str2, OooO0O0(gVar.f21792r), true, OooO00o.C0365OooO0Oo.OooO0oo));
        }
        return arrayList;
    }

    public static String OooO0Oo(String str) {
        String authority;
        if (!TextUtils.isEmpty(str) && (authority = Uri.parse(str).getAuthority()) != null) {
            return OooO0o(authority);
        }
        return null;
    }

    public static String OooO0o(String str) {
        String OooO0O02 = OooO0O0(str);
        if (OooO0O02.startsWith(".*")) {
            return OooO0O02.concat(".*");
        }
        return ".*" + OooO0O02 + ".*";
    }

    public static List<C0118OooO0O0> OooO0o0(g gVar) {
        ArrayList arrayList = new ArrayList();
        String str = gVar.f21800z;
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(C0118OooO0O0.OooO00o(str, true, OooO00o.OooO.OooO0Oo));
        } else {
            String str2 = gVar.f21799y;
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(C0118OooO0O0.OooO00o(str2, false, OooO00o.OooO.OooO0oo));
            }
        }
        return arrayList;
    }

    public final void OooO0O0(OooO00o.OooOO0 oooOO0) {
    }

    public static void OooO00o(OooO00o.OooOO0 oooOO0) {
    }

    public static String OooO0O0(List<String> list) {
        Iterator<String> it = list.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(OooO0O0(it.next()));
        while (it.hasNext()) {
            sb2.append('|');
            sb2.append(OooO0O0(it.next()));
        }
        return sb2.toString();
    }

    public static List<C0118OooO0O0> OooO00o(a aVar, g gVar, k kVar) {
        OooO00o.C0366OooO0o0 oooO0o0 = OooO00o.C0366OooO0o0.OooO0Oo;
        v.a k10 = kVar.k(aVar.f21744f);
        boolean z10 = !TextUtils.isEmpty(gVar.f21800z);
        String OooO00o2 = OooO00o(gVar);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(OooO00o(gVar, aVar, k10, oooO0o0, OooO00o2, kVar));
        arrayList.addAll(OooO0o0(gVar));
        if (kVar.s()) {
            arrayList.add(C0118OooO0O0.OooO00o(OooO00o2, OooO00o.OooO.OooO0Oo, true, OooO00o.C0365OooO0Oo.OooO0o));
            gVar.d();
        }
        arrayList.addAll(OooO00o(kVar.n()));
        arrayList.addAll(OooO0OO(gVar));
        arrayList.addAll(OooO00o(gVar, z10, k10, oooO0o0, aVar.f21742d));
        arrayList.addAll(OooO00o(gVar, aVar, k10, oooO0o0));
        return arrayList;
    }

    public static String OooO0Oo(g gVar) {
        List<b> list = gVar.J;
        if (!h.c.h(list)) {
            return MahxServer.OooO0OO();
        }
        String OooO0O02 = OooO0O0(gVar);
        if (TextUtils.isEmpty(OooO0O02)) {
            return MahxServer.OooO0OO();
        }
        for (b bVar : list) {
            if (OooO0O02.equals(bVar.f21761a)) {
                String[] strArr = bVar.f21763c;
                if (strArr.length > 0) {
                    return TextUtils.join(";", strArr);
                }
            }
        }
        return MahxServer.OooO0OO();
    }

    public static String OooO0o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return OooO0Oo(str);
    }

    /* renamed from: com.mah.ndk.OooO0O0$OooO0O0  reason: collision with other inner class name */
    public static class C0118OooO0O0 {
        public boolean OooO = false;
        public String OooO00o = "";
        public String OooO0O0 = "";
        public String OooO0OO;
        public String OooO0Oo;
        public int OooO0o;

        /* renamed from: OooO0o0  reason: collision with root package name */
        public String f10167OooO0o0 = "";
        public int OooO0oO = 0;
        public long OooO0oo = 0;
        public boolean OooOO0 = false;
        public OooO00o.OooO0O0 OooOO0O = OooO00o.OooO0O0.OooO0Oo;
        public OooO00o.C0367OooO0oO OooOO0o = OooO00o.C0367OooO0oO.OooO0Oo;
        public OooO00o.C0366OooO0o0 OooOOO = OooO00o.C0366OooO0o0.OooO0Oo;
        public OooO00o.OooO OooOOO0 = OooO00o.OooO.OooO0oo;
        public OooO00o.C0369OooOO0o OooOOOO = OooO00o.C0369OooOO0o.OooO0Oo;
        public OooO00o.C0365OooO0Oo OooOOOo = OooO00o.C0365OooO0Oo.OooO0Oo;
        public OooO00o.C0117OooO00o OooOOo0 = OooO00o.C0117OooO00o.OooO0oo;

        public static C0118OooO0O0 OooO00o(String str, OooO00o.OooO oooO, boolean z10, OooO00o.C0365OooO0Oo oooO0Oo) {
            C0118OooO0O0 oooO0O0 = new C0118OooO0O0();
            oooO0O0.OooO0OO = str;
            oooO0O0.OooO0O0 = "";
            oooO0O0.OooO0Oo = "";
            oooO0O0.OooO0o = 0;
            oooO0O0.OooOO0O = OooO00o.OooO0O0.OooO0Oo;
            oooO0O0.OooOOO0 = oooO;
            oooO0O0.OooO = z10;
            oooO0O0.OooOOOo = oooO0Oo;
            return oooO0O0;
        }

        public static C0118OooO0O0 OooO00o(String str, boolean z10, OooO00o.OooO oooO) {
            C0118OooO0O0 oooO0O0 = new C0118OooO0O0();
            oooO0O0.OooO0OO = str;
            oooO0O0.OooO = z10;
            oooO0O0.OooO0O0 = "";
            oooO0O0.OooO0Oo = "";
            oooO0O0.OooO0o = 0;
            oooO0O0.OooOO0O = OooO00o.OooO0O0.OooO0oo;
            oooO0O0.OooOOO0 = oooO;
            return oooO0O0;
        }
    }

    public static OooO00o.C0369OooOO0o OooO0o0(int i10) {
        if (i10 == 1) {
            return OooO00o.C0369OooOO0o.OooO0o;
        }
        if (i10 != 2) {
            return OooO00o.C0369OooOO0o.OooO0Oo;
        }
        return OooO00o.C0369OooOO0o.OooO0oo;
    }

    public static String OooO0OO(String str) {
        if (!TextUtils.isEmpty(str)) {
            return OooO0Oo(str);
        }
        return OooO0o("au.relauservice.com");
    }

    public static String OooO0O0(String str) {
        String replace = str.replace(f.G, "\\.");
        return replace.startsWith(ProxyConfig.MATCH_ALL_SCHEMES) ? f.G.concat(replace) : replace;
    }

    public static OooO00o.C0368OooO0oo OooO0OO(int i10) {
        switch (i10) {
            case 1:
                return OooO00o.C0368OooO0oo.OooO0Oo;
            case 2:
                return OooO00o.C0368OooO0oo.OooO0o;
            case 3:
                return OooO00o.C0368OooO0oo.OooO0oo;
            case 4:
                return OooO00o.C0368OooO0oo.OooOO0;
            case 5:
                return OooO00o.C0368OooO0oo.OooOO0o;
            case 6:
                return OooO00o.C0368OooO0oo.OooOOO;
            default:
                return OooO00o.C0368OooO0oo.OooOO0o;
        }
    }

    public static String OooO0O0(g gVar) {
        String str = gVar.S;
        if (TextUtils.isEmpty(str)) {
            return "au.relauservice.com";
        }
        return Uri.parse(str).getHost();
    }

    public static OooO00o.OooO0O0 OooO0Oo(int i10) {
        if (i10 == 4) {
            return OooO00o.OooO0O0.OooO0o;
        }
        if (i10 == 9) {
            return OooO00o.OooO0O0.OooO0oo;
        }
        if (i10 == 17) {
            return OooO00o.OooO0O0.OooOO0;
        }
        if (i10 == 21) {
            return OooO00o.OooO0O0.OooOO0o;
        }
        if (i10 != 22) {
            return OooO00o.OooO0O0.OooO0Oo;
        }
        return OooO00o.OooO0O0.OooOOO;
    }

    public static List<C0118OooO0O0> OooO00o(OooO0Oo oooO0Oo) {
        ArrayList arrayList = new ArrayList();
        if (!i.f.a(oooO0Oo.Y)) {
            arrayList.add(C0118OooO0O0.OooO00o(OooO0O0((List<String>) oooO0Oo.Y), OooO00o.OooO.OooO0Oo, false, OooO00o.C0365OooO0Oo.OooO0oo));
        }
        if (!i.f.a(oooO0Oo.X)) {
            arrayList.add(C0118OooO0O0.OooO00o(OooO0O0((List<String>) oooO0Oo.X), OooO00o.OooO.OooO0Oo, true, OooO00o.C0365OooO0Oo.OooO0oo));
        }
        return arrayList;
    }

    public static C0118OooO0O0 OooO0O0(a aVar, String str, String str2, String str3) {
        C0118OooO0O0 oooO0O0 = new C0118OooO0O0();
        oooO0O0.OooO0OO = "^(wss|ws)://" + str2 + ".*";
        oooO0O0.OooO0Oo = str;
        oooO0O0.f10167OooO0o0 = "";
        oooO0O0.OooO00o = str3;
        oooO0O0.OooO0o = aVar.f21748j;
        oooO0O0.OooOO0O = OooO0Oo(aVar.f21746h);
        oooO0O0.OooOO0o = OooO00o.C0367OooO0oO.OooO0o;
        oooO0O0.OooOOO0 = OooO00o.OooO.OooO0o;
        oooO0O0.OooOOO = OooO00o.C0366OooO0o0.OooO0Oo;
        oooO0O0.OooO0oo = 0;
        oooO0O0.OooOO0 = false;
        return oooO0O0;
    }

    public static String OooO00o(g gVar) {
        StringBuilder sb2 = new StringBuilder();
        String OooO0OO2 = OooO0OO(gVar.S);
        String OooO0Oo2 = OooO0Oo(gVar.d());
        String OooO0o02 = OooO0o0(gVar.T);
        if (!TextUtils.isEmpty(OooO0Oo2)) {
            sb2.append(OooO0OO2);
            sb2.append("|");
            sb2.append(OooO0Oo2);
            if (!TextUtils.isEmpty(OooO0o02) && !OooO0o02.equals(OooO0OO2)) {
                sb2.append("|");
                sb2.append(OooO0o02);
            }
        } else if (TextUtils.isEmpty(OooO0o02) || OooO0o02.equals(OooO0OO2)) {
            sb2.append(OooO0OO2);
        } else {
            sb2.append(OooO0OO2);
            sb2.append("|");
            sb2.append(OooO0o02);
        }
        return sb2.toString();
    }

    public static OooO00o.OooO OooO0O0(int i10) {
        if (i10 == 0) {
            return OooO00o.OooO.OooO0Oo;
        }
        if (i10 == 1) {
            return OooO00o.OooO.OooO0o;
        }
        if (i10 != 2) {
            return OooO00o.OooO.OooO0oo;
        }
        return OooO00o.OooO.OooO0oo;
    }

    public static List<C0118OooO0O0> OooO00o(g gVar, boolean z10, v.a aVar, OooO00o.C0366OooO0o0 oooO0o0, boolean z11) {
        ArrayList arrayList = new ArrayList();
        List<j> list = gVar.K;
        if (h.c.j(list)) {
            for (j jVar : list) {
                for (j.a aVar2 : jVar.f21835d) {
                    if (!aVar2.a() || !z10) {
                        C0118OooO0O0 oooO0O0 = new C0118OooO0O0();
                        oooO0O0.OooO0O0 = jVar.f21833b;
                        oooO0O0.OooO0OO = aVar2.f21838a;
                        String str = jVar.f21832a;
                        oooO0O0.OooO0Oo = str;
                        oooO0O0.f10167OooO0o0 = jVar.f21836e;
                        oooO0O0.OooO0o = aVar2.f21839b;
                        oooO0O0.OooO00o = OooO00o(gVar, aVar, str, (OooO0OO) null);
                        oooO0O0.OooOO0o = OooO00o(jVar.f21834c);
                        oooO0O0.OooOO0O = OooO0Oo(aVar2.f21840c);
                        oooO0O0.OooOOO0 = OooO0O0(aVar2.f21841d);
                        oooO0O0.OooOOO = oooO0o0;
                        oooO0O0.OooO0oo = 0;
                        oooO0O0.OooOO0 = z11;
                        oooO0O0.OooOOo0 = OooO00o.C0117OooO00o.OooO0O0(aVar2.f21842e);
                        arrayList.add(oooO0O0);
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<C0118OooO0O0> OooO00o(g gVar, a aVar, v.a aVar2, OooO00o.C0366OooO0o0 oooO0o0, String str, k kVar) {
        String str2;
        String OooO00o2 = OooO00o(gVar, aVar2, aVar.f21740b, (OooO0OO) null);
        if (TextUtils.isEmpty(OooO00o2)) {
            str2 = OooO00o(aVar.f21745g, OooO0Oo(gVar), kVar.r().p());
        } else {
            str2 = "";
        }
        ArrayList arrayList = new ArrayList();
        C0118OooO0O0 oooO0O0 = new C0118OooO0O0();
        oooO0O0.OooO0OO = str;
        oooO0O0.OooO0Oo = aVar.f21740b;
        oooO0O0.f10167OooO0o0 = str2;
        oooO0O0.OooO00o = OooO00o2;
        oooO0O0.OooO0o = aVar.f21749k;
        oooO0O0.OooOO0O = OooO0Oo(aVar.f21747i);
        oooO0O0.OooOOO0 = OooO00o.OooO.OooO0Oo;
        oooO0O0.OooOO0o = OooO00o(gVar.f21789o);
        oooO0O0.OooOOO = oooO0o0;
        oooO0O0.OooO0oo = 0;
        oooO0O0.OooOO0 = aVar.f21742d;
        arrayList.add(oooO0O0);
        return arrayList;
    }

    public static String OooO00o(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3);
        }
        if (!TextUtils.isEmpty(str)) {
            for (String str4 : str.split(";")) {
                if (!arrayList.contains(str4)) {
                    arrayList.add(str4);
                }
            }
        }
        for (String str5 : str2.split(";")) {
            if (!arrayList.contains(str5)) {
                arrayList.add(str5);
            }
        }
        return TextUtils.join(";", arrayList);
    }

    public static List<C0118OooO0O0> OooO00o(g gVar, a aVar, v.a aVar2, OooO00o.C0366OooO0o0 oooO0o0) {
        ArrayList arrayList = new ArrayList();
        if (aVar2 != null) {
            Map f10 = aVar2.f();
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : f10.entrySet()) {
                a.C0344a aVar3 = (a.C0344a) entry.getValue();
                if (aVar3 != null && aVar3.f24356d) {
                    String c10 = v.a.c(aVar3);
                    if (!TextUtils.isEmpty(c10)) {
                        String str = (String) entry.getKey();
                        String b10 = v.a.b(aVar3.a());
                        OooO00o oooO00o = (OooO00o) hashMap.get(b10);
                        if (oooO00o == null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(str);
                            hashMap.put(b10, new OooO00o(c10, arrayList2));
                        } else {
                            oooO00o.OooO0O0.add(str);
                        }
                    }
                }
            }
            for (Map.Entry value : hashMap.entrySet()) {
                OooO00o oooO00o2 = (OooO00o) value.getValue();
                String OooO00o2 = OooO00o(oooO00o2.OooO0O0);
                String str2 = oooO00o2.OooO0O0.get(0);
                arrayList.add(OooO0O0(aVar, str2, OooO00o2, oooO00o2.OooO00o));
                arrayList.add(OooO00o(aVar, str2, OooO00o2, oooO00o2.OooO00o));
            }
        }
        C0118OooO0O0 oooO0O0 = new C0118OooO0O0();
        oooO0O0.OooO0OO = "^(wss|ws)://.*";
        oooO0O0.OooO0Oo = "";
        oooO0O0.f10167OooO0o0 = "";
        oooO0O0.OooO00o = "";
        oooO0O0.OooO0o = aVar.f21748j;
        oooO0O0.OooOO0O = OooO0Oo(aVar.f21746h);
        OooO00o.OooO oooO = OooO00o.OooO.OooO0o;
        oooO0O0.OooOOO0 = oooO;
        oooO0O0.OooOO0o = OooO00o(gVar.f21789o);
        oooO0O0.OooOOO = oooO0o0;
        oooO0O0.OooO0oo = 0;
        oooO0O0.OooOO0 = aVar.f21742d;
        arrayList.add(oooO0O0);
        C0118OooO0O0 oooO0O02 = new C0118OooO0O0();
        oooO0O02.OooO0OO = ".*";
        oooO0O02.OooO0Oo = "";
        oooO0O02.f10167OooO0o0 = "";
        oooO0O02.OooO00o = "";
        oooO0O02.OooO0o = aVar.f21749k;
        oooO0O02.OooOO0O = OooO0Oo(aVar.f21747i);
        oooO0O02.OooOOO0 = oooO;
        oooO0O02.OooOO0o = OooO00o(gVar.f21789o);
        oooO0O02.OooOOO = oooO0o0;
        oooO0O02.OooO0oo = 0;
        oooO0O02.OooOO0 = aVar.f21742d;
        arrayList.add(oooO0O02);
        return arrayList;
    }

    public static String OooO00o(List<String> list) {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (String next : list) {
            if (!z10) {
                sb2.append("|");
            } else {
                z10 = false;
            }
            sb2.append(OooO0O0(next));
        }
        if (list.size() <= 1) {
            return sb2.toString();
        }
        return "(" + sb2 + ")";
    }

    public static C0118OooO0O0 OooO00o(h.a aVar, String str, String str2, String str3) {
        C0118OooO0O0 oooO0O0 = new C0118OooO0O0();
        oooO0O0.OooO0OO = "^(http|https)://" + str2 + ".*";
        oooO0O0.OooO0Oo = str;
        oooO0O0.f10167OooO0o0 = "";
        oooO0O0.OooO00o = str3;
        oooO0O0.OooO0o = aVar.f21749k;
        oooO0O0.OooOO0O = OooO0Oo(aVar.f21747i);
        oooO0O0.OooOO0o = OooO00o.C0367OooO0oO.OooO0o;
        oooO0O0.OooOOO0 = OooO00o.OooO.OooO0o;
        oooO0O0.OooOOO = OooO00o.C0366OooO0o0.OooO0Oo;
        oooO0O0.OooO0oo = 0;
        oooO0O0.OooOO0 = false;
        return oooO0O0;
    }

    public static String OooO00o(g gVar, v.a aVar, String str, OooO0OO oooO0OO) {
        String str2 = "";
        if (!gVar.f21785k || v.k(str)) {
            return str2;
        }
        if (aVar != null) {
            str2 = aVar.e(str);
        }
        return (!TextUtils.isEmpty(str2) || oooO0OO == null) ? str2 : oooO0OO.OooO00o();
    }

    public static OooO00o.C0367OooO0oO OooO00o(int i10) {
        if (i10 == 1) {
            return OooO00o.C0367OooO0oO.OooO0o;
        }
        if (i10 == 2) {
            return OooO00o.C0367OooO0oO.OooO0oo;
        }
        if (i10 != 3) {
            return OooO00o.C0367OooO0oO.OooO0Oo;
        }
        return OooO00o.C0367OooO0oO.OooOO0;
    }

    public static void OooO00o(OooO00o.OooOO0 oooOO0, C0118OooO0O0 oooO0O0) {
        oooOO0.OooO0O0(oooO0O0.OooO0O0);
        oooOO0.OooO00o(oooO0O0.OooOO0o);
        oooOO0.OooO0OO(oooO0O0.OooO0Oo);
        oooOO0.OooO0O0(oooO0O0.OooO0o);
        oooOO0.OooO00o(oooO0O0.OooOO0O);
        oooOO0.OooO0o0(oooO0O0.OooO0OO);
        oooOO0.OooO00o(oooO0O0.f10167OooO0o0);
        oooOO0.OooO0O0(oooO0O0.OooO);
        oooOO0.OooO00o(oooO0O0.OooOOO0);
        oooOO0.OooO0OO(oooO0O0.OooO0oO);
        oooOO0.OooO00o(oooO0O0.OooOOO);
        oooOO0.OooO00o((int) oooO0O0.OooO0oo);
        oooOO0.OooO00o(oooO0O0.OooOO0);
        oooOO0.OooO00o(oooO0O0.OooOOOO);
        oooOO0.OooO00o(oooO0O0.OooOOOo);
        oooOO0.OooO00o(oooO0O0.OooOOo0);
        oooOO0.OooO0Oo(oooO0O0.OooO00o);
    }

    public byte[] OooO00o() {
        OooO00o.C0369OooOO0o oooOO0o;
        try {
            g o10 = this.OooO0OO.o();
            e f10 = this.OooO0OO.f();
            h.a b10 = o10.b(f10.f());
            String h10 = this.OooO0Oo.j().h();
            OooO0Oo n10 = this.OooO0OO.n();
            OooO00o.OooOO0 oooOO0 = new OooO00o.OooOO0();
            oooOO0.OooOOO0(this.OooO0O0);
            oooOO0.OooOO0(h10);
            oooOO0.OooOO0O(p.e(h10.getBytes()));
            oooOO0.OooOOo0(this.OooO0Oo.b());
            oooOO0.OooO00o(OooO0OO(f10.f()));
            oooOO0.OooOOOo(!o10.f21778d);
            oooOO0.OooOOO0(!o10.f21784j);
            oooOO0.OooOo00(o10.f21796v);
            oooOO0.OooOo0o(o10.f21797w);
            oooOO0.o000oOoO(o10.f21790p);
            oooOO0.OoooOo0(-1);
            oooOO0.OooO0Oo(false);
            if (o10.f21784j) {
                oooOO0.OoooOoo(o10.f21793s);
            }
            String d10 = k.a.f().d();
            if (!TextUtils.isEmpty(d10)) {
                oooOO0.OooO(d10);
            }
            if (o10.c()) {
                String e10 = a.C0295a.f22232a.e();
                if (!TextUtils.isEmpty(e10)) {
                    oooOO0.OooOOOO(e10);
                    oooOO0.OooO00o(OooO00o.OooOO0O.OooO0Oo);
                }
            } else {
                oooOO0.OooO00o(OooO00o.OooOO0O.OooOO0o);
            }
            OooO00o(oooOO0, (List<b>) o10.J);
            oooOO0.OooOOO(o10.f21783i);
            String str = n10.f13470b;
            if (!TextUtils.isEmpty(str)) {
                oooOO0.OooOOoo(str);
            }
            i iVar = o10.I;
            if (iVar != null) {
                oooOO0.OoooOOO(iVar.f21829a);
                oooOO0.OooO00o((double) iVar.f21830b);
                oooOO0.OoooOOo(iVar.f21831c);
            }
            for (String OooO0o : OooO00o(f10)) {
                oooOO0.OooO0o(OooO0o);
            }
            if (b10.f21739a == 1) {
                oooOO0o = OooO0o0(this.OooO0OO.e());
            } else {
                oooOO0o = OooO00o.C0369OooOO0o.OooO0Oo;
            }
            String OooO00o2 = OooO00o(this.OooO00o);
            if (!TextUtils.isEmpty(OooO00o2)) {
                oooOO0.OooOo0(OooO00o2);
            }
            String u10 = v.u(this.OooO00o);
            if (!TextUtils.isEmpty(u10)) {
                oooOO0.OooOOo(u10);
            }
            oooOO0.OooO0o(n10.f13476h);
            oooOO0.OooO0oO(o10.Q);
            oooOO0.OooOOOO(false);
            oooOO0.OooOO0O(o10.U);
            oooOO0.OooOO0(n10.C);
            for (C0118OooO0O0 next : OooO00o(b10, o10, this.OooO0OO)) {
                OooO00o.OooO0O0 oooO0O0 = next.OooOO0O;
                if (!(oooO0O0 == OooO00o.OooO0O0.OooO0Oo || oooO0O0 == OooO00o.OooO0O0.OooO0oo)) {
                    next.OooOOOO = oooOO0o;
                }
                OooO00o(oooOO0, next);
            }
            oooOO0.OooO(o10.f21785k);
            oooOO0.OooO0o0(o10.V);
            return oooOO0.OooOO0().a();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String[] OooO00o(e eVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MessageFormat.format("Mah-Net: {0},{1}", new Object[]{i.a.c(com.mah.sdk.OooO00o.OooO0Oo(this.OooO00o)), eVar.a()}));
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final void OooO00o(OooO00o.OooOO0 oooOO0, List<b> list) {
        if (h.c.h(list)) {
            for (b next : list) {
                oooOO0.OooO0oO(next.f21761a);
                oooOO0.OooO0Oo(next.f21762b ? 1 : 0);
                StringBuilder sb2 = new StringBuilder();
                String[] strArr = next.f21763c;
                if (strArr != null) {
                    for (String append : strArr) {
                        sb2.append(append);
                        sb2.append(";");
                    }
                }
                oooOO0.OooO0oo(sb2.toString());
            }
        }
    }

    public static String OooO00o(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return "";
        }
        List<String> q10 = v.q(context);
        if (q10.isEmpty()) {
            q10.add("114.114.114.114");
            q10.add("1.1.1.1");
        }
        StringBuilder sb2 = new StringBuilder();
        for (String append : q10) {
            sb2.append(append);
            sb2.append(",");
        }
        return sb2.toString();
    }
}
