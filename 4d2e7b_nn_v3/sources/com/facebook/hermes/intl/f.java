package com.facebook.hermes.intl;

import com.facebook.hermes.intl.e;
import com.facebook.hermes.intl.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;
import o4.n;

public abstract class f {
    private static void a(String str, k.a aVar) {
        ArrayList arrayList = aVar.f19933d;
        if (arrayList != null) {
            int binarySearch = Collections.binarySearch(arrayList, str);
            if (binarySearch < 0) {
                aVar.f19933d.add((binarySearch * -1) - 1, str);
                return;
            }
            throw new o4.k("Duplicate variant");
        }
        ArrayList arrayList2 = new ArrayList();
        aVar.f19933d = arrayList2;
        arrayList2.add(str);
    }

    static String b(String str) {
        return n.b(str).a();
    }

    static boolean c(CharSequence charSequence, e eVar, e.a aVar, boolean z10, k kVar) {
        if (z10 && aVar.d()) {
            j(charSequence, eVar, aVar, kVar);
            return true;
        } else if (!aVar.a()) {
            return false;
        } else {
            if (!z10) {
                d(charSequence, aVar, eVar, kVar);
                return true;
            }
            throw new o4.k(String.format("Extension singletons in transformed extension language tag: %s", new Object[]{charSequence}));
        }
    }

    static void d(CharSequence charSequence, e.a aVar, e eVar, k kVar) {
        if (eVar.a()) {
            char charAt = aVar.toString().charAt(0);
            if (charAt == 'u') {
                l(charSequence, eVar, kVar);
            } else if (charAt == 't') {
                k(charSequence, eVar, kVar);
            } else if (charAt == 'x') {
                i(charSequence, eVar, kVar);
            } else {
                h(charSequence, eVar, kVar, charAt);
            }
        } else {
            throw new o4.k("Extension sequence expected.");
        }
    }

    static void e(CharSequence charSequence, e eVar, e.a aVar, boolean z10, k kVar) {
        k.a aVar2 = new k.a();
        if (z10) {
            kVar.f19926d = aVar2;
        } else {
            kVar.f19923a = aVar2;
        }
        try {
            if (aVar.i()) {
                aVar2.f19930a = aVar.m();
                if (eVar.a()) {
                    e.a c10 = eVar.c();
                    if (!c(charSequence, eVar, c10, z10, kVar)) {
                        if (c10.k()) {
                            aVar2.f19931b = c10.n();
                            if (eVar.a()) {
                                c10 = eVar.c();
                            } else {
                                return;
                            }
                        }
                        if (c10.j()) {
                            aVar2.f19932c = c10.o();
                            if (eVar.a()) {
                                c10 = eVar.c();
                            } else {
                                return;
                            }
                        }
                        while (!c(charSequence, eVar, c10, z10, kVar)) {
                            if (c10.l()) {
                                a(c10.toString(), aVar2);
                                if (eVar.a()) {
                                    c10 = eVar.c();
                                } else {
                                    return;
                                }
                            } else {
                                throw new o4.k(String.format("Unknown token [%s] found in locale id: %s", new Object[]{c10.toString(), charSequence}));
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            throw new o4.k(String.format("Language subtag expected at %s: %s", new Object[]{aVar.toString(), charSequence}));
        } catch (e.b unused) {
            throw new o4.k(String.format("Locale Identifier subtag iteration failed: %s", new Object[]{charSequence}));
        }
    }

    static k f(String str) {
        int binarySearch;
        String[] strArr = d.f19889a;
        if (strArr != null && (binarySearch = Arrays.binarySearch(strArr, str.toString())) >= 0) {
            str = d.f19890b[binarySearch];
        }
        String lowerCase = str.toLowerCase();
        return g(lowerCase, new e(lowerCase));
    }

    static k g(String str, e eVar) {
        k kVar = new k();
        try {
            if (eVar.a()) {
                e(str, eVar, eVar.c(), false, kVar);
                return kVar;
            }
            throw new o4.k(String.format("Language subtag not found: %s", new Object[]{str}));
        } catch (e.b unused) {
            throw new o4.k(String.format("Locale Identifier subtag iteration failed: %s", new Object[]{str}));
        }
    }

    static void h(CharSequence charSequence, e eVar, k kVar, char c10) {
        if (eVar.a()) {
            e.a c11 = eVar.c();
            if (kVar.f19928f == null) {
                kVar.f19928f = new TreeMap();
            }
            ArrayList arrayList = new ArrayList();
            kVar.f19928f.put(new Character(c10), arrayList);
            while (c11.b()) {
                arrayList.add(c11.toString());
                if (eVar.a()) {
                    c11 = eVar.c();
                } else {
                    return;
                }
            }
            if (c11.a()) {
                d(charSequence, c11, eVar, kVar);
                return;
            }
            throw new o4.k("Malformed sequence expected.");
        }
        throw new o4.k("Extension sequence expected.");
    }

    static void i(CharSequence charSequence, e eVar, k kVar) {
        if (eVar.a()) {
            e.a c10 = eVar.c();
            if (kVar.f19929g == null) {
                kVar.f19929g = new ArrayList();
            }
            while (c10.c()) {
                kVar.f19929g.add(c10.toString());
                if (eVar.a()) {
                    c10 = eVar.c();
                } else {
                    return;
                }
            }
            throw new o4.k("Tokens are not expected after pu extension.");
        }
        throw new o4.k("Extension sequence expected.");
    }

    static void j(CharSequence charSequence, e eVar, e.a aVar, k kVar) {
        if (aVar.d()) {
            TreeMap treeMap = kVar.f19927e;
            if (treeMap == null) {
                if (treeMap == null) {
                    kVar.f19927e = new TreeMap();
                }
                do {
                    String aVar2 = aVar.toString();
                    ArrayList arrayList = new ArrayList();
                    kVar.f19927e.put(aVar2, arrayList);
                    if (eVar.a()) {
                        aVar = eVar.c();
                        while (aVar.e()) {
                            arrayList.add(aVar.toString());
                            if (eVar.a()) {
                                aVar = eVar.c();
                            } else {
                                return;
                            }
                        }
                    } else {
                        throw new o4.k(String.format("Malformated transformed key in : %s", new Object[]{charSequence}));
                    }
                } while (aVar.d());
            } else {
                throw new o4.k(String.format("Duplicate transformed extension sequence in [%s]", new Object[]{charSequence}));
            }
        }
        if (aVar.a()) {
            d(charSequence, aVar, eVar, kVar);
            return;
        }
        throw new o4.k("Malformed extension sequence.");
    }

    static void k(CharSequence charSequence, e eVar, k kVar) {
        if (eVar.a()) {
            e.a c10 = eVar.c();
            if (c10.i()) {
                e(charSequence, eVar, c10, true, kVar);
            } else if (c10.d()) {
                j(charSequence, eVar, c10, kVar);
            } else {
                throw new o4.k(String.format("Unexpected token [%s] in transformed extension sequence [%s]", new Object[]{c10.toString(), charSequence}));
            }
        } else {
            throw new o4.k("Extension sequence expected.");
        }
    }

    static void l(CharSequence charSequence, e eVar, k kVar) {
        e.a aVar;
        if (eVar.a()) {
            e.a c10 = eVar.c();
            if (kVar.f19924b == null && kVar.f19925c == null) {
                while (aVar.f()) {
                    if (kVar.f19924b == null) {
                        kVar.f19924b = new ArrayList();
                    }
                    kVar.f19924b.add(aVar.toString());
                    if (eVar.a()) {
                        c10 = eVar.c();
                    } else {
                        return;
                    }
                }
                if (aVar.g()) {
                    if (kVar.f19925c == null) {
                        kVar.f19925c = new TreeMap();
                    }
                    do {
                        String aVar2 = aVar.toString();
                        ArrayList arrayList = new ArrayList();
                        kVar.f19925c.put(aVar2, arrayList);
                        if (eVar.a()) {
                            aVar = eVar.c();
                            while (aVar.h()) {
                                arrayList.add(aVar.toString());
                                if (eVar.a()) {
                                    aVar = eVar.c();
                                } else {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    } while (aVar.g());
                }
                if (aVar.a()) {
                    d(charSequence, aVar, eVar, kVar);
                    return;
                }
                throw new o4.k("Malformed sequence expected.");
            }
            throw new o4.k(String.format("Duplicate unicode extension sequence in [%s]", new Object[]{charSequence}));
        }
        throw new o4.k("Extension sequence expected.");
    }

    public static void m(StringBuffer stringBuffer, StringBuffer stringBuffer2, StringBuffer stringBuffer3) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        String[] strArr5;
        String[] strArr6;
        if (d.f19891c != null) {
            if (stringBuffer.length() == 2) {
                strArr6 = d.f19891c;
                strArr5 = d.f19892d;
                strArr4 = d.f19895g;
                strArr3 = d.f19896h;
                strArr2 = d.f19897i;
                strArr = d.f19898j;
            } else {
                strArr6 = d.f19893e;
                strArr5 = d.f19894f;
                strArr4 = d.f19899k;
                strArr3 = d.f19900l;
                strArr2 = d.f19901m;
                strArr = d.f19902n;
            }
            int binarySearch = Arrays.binarySearch(strArr6, stringBuffer.toString());
            if (binarySearch >= 0) {
                stringBuffer.delete(0, stringBuffer.length());
                stringBuffer.append(strArr5[binarySearch]);
                return;
            }
            int binarySearch2 = Arrays.binarySearch(strArr4, stringBuffer.toString());
            if (binarySearch2 >= 0) {
                String str = strArr3[binarySearch2];
                String str2 = strArr2[binarySearch2];
                String str3 = strArr[binarySearch2];
                stringBuffer.delete(0, stringBuffer.length());
                stringBuffer.append(str);
                if (stringBuffer2.length() == 0 && str2 != null) {
                    stringBuffer2.append(str2);
                }
                if (stringBuffer3.length() == 0 && str3 != null) {
                    stringBuffer3.append(str3);
                }
            }
        }
    }

    public static String n(StringBuffer stringBuffer) {
        if (d.f19903o == null) {
            return stringBuffer.toString();
        }
        if (stringBuffer.length() == 2) {
            int binarySearch = Arrays.binarySearch(d.f19903o, stringBuffer.toString());
            if (binarySearch >= 0) {
                return d.f19904p[binarySearch];
            }
            return stringBuffer.toString();
        }
        int binarySearch2 = Arrays.binarySearch(d.f19905q, stringBuffer.toString());
        if (binarySearch2 >= 0) {
            return d.f19906r[binarySearch2];
        }
        return stringBuffer.toString();
    }
}
