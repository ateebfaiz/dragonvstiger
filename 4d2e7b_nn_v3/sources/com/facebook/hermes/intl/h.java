package com.facebook.hermes.intl;

import android.text.TextUtils;
import com.facebook.hermes.intl.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import o4.b;
import o4.k;

public class h implements b {

    /* renamed from: a  reason: collision with root package name */
    private Locale f19917a;

    /* renamed from: b  reason: collision with root package name */
    private k f19918b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19919c;

    private h(Locale locale) {
        this.f19918b = null;
        this.f19919c = false;
        this.f19917a = locale;
    }

    public static b i() {
        return new h(Locale.getDefault());
    }

    public static b j(String str) {
        return new h(str);
    }

    private void k() {
        if (this.f19919c) {
            try {
                o();
                this.f19919c = false;
            } catch (RuntimeException e10) {
                throw new k(e10.getMessage());
            }
        }
    }

    private void l() {
        if (this.f19918b == null) {
            this.f19918b = f.f(this.f19917a.toLanguageTag());
        }
    }

    private void o() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = new StringBuffer();
        String str = this.f19918b.f19923a.f19930a;
        if (str != null && !str.isEmpty()) {
            stringBuffer2.append(this.f19918b.f19923a.f19930a);
        }
        String str2 = this.f19918b.f19923a.f19931b;
        if (str2 != null && !str2.isEmpty()) {
            stringBuffer3.append(this.f19918b.f19923a.f19931b);
        }
        String str3 = this.f19918b.f19923a.f19932c;
        if (str3 != null && !str3.isEmpty()) {
            stringBuffer4.append(this.f19918b.f19923a.f19932c);
        }
        f.m(stringBuffer2, stringBuffer3, stringBuffer4);
        if (stringBuffer2.length() > 0) {
            stringBuffer.append(stringBuffer2.toString());
        }
        if (stringBuffer3.length() > 0) {
            stringBuffer.append("-");
            stringBuffer.append(stringBuffer3.toString());
        }
        if (stringBuffer4.length() > 0) {
            stringBuffer.append("-");
            stringBuffer.append(f.n(stringBuffer4));
        }
        ArrayList arrayList = this.f19918b.f19923a.f19933d;
        if (arrayList != null && !arrayList.isEmpty()) {
            stringBuffer.append("-");
            stringBuffer.append(TextUtils.join("-", this.f19918b.f19923a.f19933d));
        }
        TreeMap treeMap = this.f19918b.f19928f;
        if (treeMap != null) {
            for (Map.Entry entry : treeMap.entrySet()) {
                stringBuffer.append("-");
                stringBuffer.append(entry.getKey());
                stringBuffer.append("-");
                stringBuffer.append(TextUtils.join("-", (Iterable) entry.getValue()));
            }
        }
        k kVar = this.f19918b;
        if (!(kVar.f19926d == null && kVar.f19927e == null)) {
            stringBuffer.append("-");
            stringBuffer.append('t');
            stringBuffer.append("-");
            StringBuffer stringBuffer5 = new StringBuffer();
            k.a aVar = this.f19918b.f19926d;
            if (aVar != null) {
                stringBuffer5.append(aVar.f19930a);
                if (this.f19918b.f19926d.f19931b != null) {
                    stringBuffer5.append("-");
                    stringBuffer5.append(this.f19918b.f19926d.f19931b);
                }
                if (this.f19918b.f19926d.f19932c != null) {
                    stringBuffer5.append("-");
                    stringBuffer5.append(this.f19918b.f19926d.f19932c);
                }
                ArrayList arrayList2 = this.f19918b.f19926d.f19933d;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    stringBuffer5.append("-");
                    stringBuffer5.append(TextUtils.join("-", this.f19918b.f19926d.f19933d));
                }
            }
            TreeMap treeMap2 = this.f19918b.f19927e;
            if (treeMap2 != null) {
                for (Map.Entry entry2 : treeMap2.entrySet()) {
                    stringBuffer5.append("-" + ((String) entry2.getKey()));
                    Iterator it = ((ArrayList) entry2.getValue()).iterator();
                    while (it.hasNext()) {
                        stringBuffer5.append("-" + ((String) it.next()));
                    }
                }
                if (stringBuffer5.length() > 0 && stringBuffer5.charAt(0) == '-') {
                    stringBuffer5.deleteCharAt(0);
                }
            }
            stringBuffer.append(stringBuffer5.toString());
        }
        k kVar2 = this.f19918b;
        if (!(kVar2.f19924b == null && kVar2.f19925c == null)) {
            stringBuffer.append("-");
            stringBuffer.append('u');
            stringBuffer.append("-");
            StringBuffer stringBuffer6 = new StringBuffer();
            ArrayList arrayList3 = this.f19918b.f19924b;
            if (arrayList3 != null) {
                stringBuffer6.append(TextUtils.join("-", arrayList3));
            }
            TreeMap treeMap3 = this.f19918b.f19925c;
            if (treeMap3 != null) {
                for (Map.Entry entry3 : treeMap3.entrySet()) {
                    stringBuffer6.append("-" + ((String) entry3.getKey()));
                    Iterator it2 = ((ArrayList) entry3.getValue()).iterator();
                    while (it2.hasNext()) {
                        stringBuffer6.append("-" + ((String) it2.next()));
                    }
                }
            }
            if (stringBuffer6.length() > 0 && stringBuffer6.charAt(0) == '-') {
                stringBuffer6.deleteCharAt(0);
            }
            stringBuffer.append(stringBuffer6.toString());
        }
        if (this.f19918b.f19929g != null) {
            stringBuffer.append("-");
            stringBuffer.append('x');
            stringBuffer.append("-");
            stringBuffer.append(TextUtils.join("-", this.f19918b.f19929g));
        }
        try {
            this.f19917a = Locale.forLanguageTag(stringBuffer.toString());
            this.f19919c = false;
        } catch (RuntimeException e10) {
            throw new o4.k(e10.getMessage());
        }
    }

    public String a() {
        return h().toLanguageTag();
    }

    public HashMap b() {
        HashMap hashMap = new HashMap();
        TreeMap treeMap = this.f19918b.f19925c;
        if (treeMap != null) {
            for (String str : treeMap.keySet()) {
                hashMap.put(str, TextUtils.join("-", (ArrayList) this.f19918b.f19925c.get(str)));
            }
        }
        return hashMap;
    }

    public ArrayList c(String str) {
        ArrayList arrayList;
        k();
        l();
        TreeMap treeMap = this.f19918b.f19925c;
        if (treeMap == null || (arrayList = (ArrayList) treeMap.get(str)) == null) {
            return new ArrayList();
        }
        return arrayList;
    }

    public b e() {
        k();
        return new h(this.f19917a);
    }

    public String f() {
        return d().toLanguageTag();
    }

    public void g(String str, ArrayList arrayList) {
        k();
        l();
        k kVar = this.f19918b;
        if (kVar.f19925c == null) {
            kVar.f19925c = new TreeMap();
        }
        if (!this.f19918b.f19925c.containsKey(str)) {
            this.f19918b.f19925c.put(str, new ArrayList());
        }
        ((ArrayList) this.f19918b.f19925c.get(str)).clear();
        ((ArrayList) this.f19918b.f19925c.get(str)).addAll(arrayList);
        this.f19919c = true;
    }

    /* renamed from: m */
    public Locale h() {
        k();
        return this.f19917a;
    }

    /* renamed from: n */
    public Locale d() {
        k();
        l();
        k kVar = new k();
        kVar.f19923a = this.f19918b.f19923a;
        return new h(kVar).h();
    }

    private h(String str) {
        this.f19917a = null;
        this.f19918b = null;
        this.f19919c = false;
        this.f19918b = f.f(str);
        o();
    }

    private h(k kVar) {
        this.f19917a = null;
        this.f19919c = false;
        this.f19918b = kVar;
        o();
    }
}
