package com.facebook.hermes.intl;

import android.icu.text.DateFormat;
import android.icu.text.NumberingSystem;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import androidx.core.text.util.LocalePreferences;
import com.facebook.hermes.intl.b;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import o4.f;
import o4.j;
import o4.k;
import o4.q1;
import o4.z3;

public class o implements b {

    /* renamed from: a  reason: collision with root package name */
    private DateFormat f19941a = null;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19942a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f19943b;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0063 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006d */
        static {
            /*
                com.facebook.hermes.intl.b$k[] r0 = com.facebook.hermes.intl.b.k.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19943b = r0
                r1 = 1
                com.facebook.hermes.intl.b$k r2 = com.facebook.hermes.intl.b.k.FULL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f19943b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.hermes.intl.b$k r3 = com.facebook.hermes.intl.b.k.LONG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f19943b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.hermes.intl.b$k r4 = com.facebook.hermes.intl.b.k.MEDIUM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f19943b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.hermes.intl.b$k r5 = com.facebook.hermes.intl.b.k.SHORT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f19943b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.hermes.intl.b$k r6 = com.facebook.hermes.intl.b.k.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                com.facebook.hermes.intl.b$b[] r5 = com.facebook.hermes.intl.b.C0249b.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f19942a = r5
                com.facebook.hermes.intl.b$b r6 = com.facebook.hermes.intl.b.C0249b.FULL     // Catch:{ NoSuchFieldError -> 0x004f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = f19942a     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.facebook.hermes.intl.b$b r5 = com.facebook.hermes.intl.b.C0249b.LONG     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f19942a     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.facebook.hermes.intl.b$b r1 = com.facebook.hermes.intl.b.C0249b.MEDIUM     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = f19942a     // Catch:{ NoSuchFieldError -> 0x006d }
                com.facebook.hermes.intl.b$b r1 = com.facebook.hermes.intl.b.C0249b.SHORT     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f19942a     // Catch:{ NoSuchFieldError -> 0x0077 }
                com.facebook.hermes.intl.b$b r1 = com.facebook.hermes.intl.b.C0249b.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0077 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0077 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0077 }
            L_0x0077:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.o.a.<clinit>():void");
        }
    }

    private static class b {
        public static String a(String str) {
            StringBuilder sb2 = new StringBuilder();
            boolean z10 = false;
            for (int i10 = 0; i10 < str.length(); i10++) {
                char charAt = str.charAt(i10);
                if (charAt == '\'') {
                    z10 = !z10;
                } else if (!z10 && ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z'))) {
                    sb2.append(str.charAt(i10));
                }
            }
            return sb2.toString();
        }
    }

    o() {
    }

    private static String i(o4.b bVar, b.C0249b bVar2, b.k kVar) {
        if (bVar2 == b.C0249b.UNDEFINED) {
            return q1.a(DateFormat.getTimeInstance(m(kVar), f.a(bVar.h()))).toLocalizedPattern();
        }
        if (kVar == b.k.UNDEFINED) {
            return q1.a(DateFormat.getDateInstance(l(bVar2), f.a(bVar.h()))).toLocalizedPattern();
        }
        return q1.a(DateFormat.getDateTimeInstance(l(bVar2), m(kVar), f.a(bVar.h()))).toLocalizedPattern();
    }

    private static String j(o4.b bVar, b.m mVar, b.d dVar, b.n nVar, b.i iVar, b.c cVar, b.f fVar, b.h hVar, b.j jVar, b.l lVar, b.g gVar, b.C0249b bVar2, b.k kVar, Object obj) {
        b.g gVar2 = gVar;
        b.C0249b bVar3 = bVar2;
        b.k kVar2 = kVar;
        StringBuilder sb2 = new StringBuilder();
        if (bVar3 == b.C0249b.UNDEFINED && kVar2 == b.k.UNDEFINED) {
            sb2.append(mVar.b());
            sb2.append(dVar.b());
            sb2.append(nVar.b());
            sb2.append(iVar.b());
            sb2.append(cVar.b());
            if (gVar2 == b.g.H11 || gVar2 == b.g.H12) {
                sb2.append(fVar.b());
            } else {
                sb2.append(fVar.c());
            }
            sb2.append(hVar.b());
            sb2.append(jVar.b());
            sb2.append(lVar.b());
        } else {
            o4.b bVar4 = bVar;
            sb2.append(i(bVar, bVar3, kVar2));
            HashMap b10 = bVar.b();
            if (b10.containsKey("hc")) {
                String str = (String) b10.get("hc");
                if (str == LocalePreferences.HourCycle.H11 || str == LocalePreferences.HourCycle.H12) {
                    k(sb2, new char[]{'H', 'K', 'k'}, 'h');
                } else if (str == LocalePreferences.HourCycle.H23 || str == LocalePreferences.HourCycle.H24) {
                    k(sb2, new char[]{'h', 'H', 'K'}, 'k');
                }
            }
            if (gVar2 == b.g.H11 || gVar2 == b.g.H12) {
                k(sb2, new char[]{'H', 'K', 'k'}, 'h');
            } else if (gVar2 == b.g.H23 || gVar2 == b.g.H24) {
                k(sb2, new char[]{'h', 'H', 'K'}, 'k');
            }
            if (!j.n(obj) && !j.j(obj)) {
                if (j.e(obj)) {
                    k(sb2, new char[]{'H', 'K', 'k'}, 'h');
                } else {
                    k(sb2, new char[]{'h', 'H', 'K'}, 'k');
                }
            }
        }
        return sb2.toString();
    }

    private static void k(StringBuilder sb2, char[] cArr, char c10) {
        for (int i10 = 0; i10 < sb2.length(); i10++) {
            int length = cArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (sb2.charAt(i10) == cArr[i11]) {
                    sb2.setCharAt(i10, c10);
                    break;
                }
                i11++;
            }
        }
    }

    static int l(b.C0249b bVar) {
        int i10 = a.f19942a[bVar.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        throw new k("Invalid DateStyle: " + bVar.toString());
    }

    static int m(b.k kVar) {
        int i10 = a.f19943b[kVar.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        throw new k("Invalid DateStyle: " + kVar.toString());
    }

    public AttributedCharacterIterator a(double d10) {
        return this.f19941a.formatToCharacterIterator(Double.valueOf(d10));
    }

    public String b(double d10) {
        return this.f19941a.format(new Date((long) d10));
    }

    public String c(o4.b bVar) {
        return NumberingSystem.getInstance(f.a(bVar.h())).getName();
    }

    public String d(o4.b bVar) {
        return Calendar.getInstance(f.a(bVar.h())).getTimeZone().getID();
    }

    public void e(o4.b bVar, String str, String str2, b.e eVar, b.m mVar, b.d dVar, b.n nVar, b.i iVar, b.c cVar, b.f fVar, b.h hVar, b.j jVar, b.l lVar, b.g gVar, Object obj, b.C0249b bVar2, b.k kVar, Object obj2) {
        Calendar calendar;
        String str3 = str2;
        String j10 = j(bVar, mVar, dVar, nVar, iVar, cVar, fVar, hVar, jVar, lVar, gVar, bVar2, kVar, obj2);
        if (!str.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(j.h(str));
            o4.b e10 = bVar.e();
            e10.g("ca", arrayList);
            calendar = Calendar.getInstance(f.a(e10.h()));
        } else {
            calendar = null;
        }
        if (!str2.isEmpty()) {
            try {
                if (NumberingSystem.getInstanceByName(j.h(str2)) != null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(j.h(str2));
                    bVar.g("nu", arrayList2);
                } else {
                    throw new k("Invalid numbering system: " + str3);
                }
            } catch (RuntimeException unused) {
                throw new k("Invalid numbering system: " + str3);
            }
        } else {
            o4.b bVar3 = bVar;
        }
        if (calendar != null) {
            this.f19941a = DateFormat.getPatternInstance(calendar, j10, f.a(bVar.h()));
        } else {
            this.f19941a = DateFormat.getPatternInstance(j10, f.a(bVar.h()));
        }
        if (!j.n(obj) && !j.j(obj)) {
            this.f19941a.setTimeZone(TimeZone.getTimeZone(j.h(obj)));
        }
    }

    public String f(AttributedCharacterIterator.Attribute attribute, String str) {
        if (attribute == DateFormat.Field.DAY_OF_WEEK) {
            return "weekday";
        }
        if (attribute == DateFormat.Field.ERA) {
            return "era";
        }
        if (attribute == DateFormat.Field.YEAR) {
            try {
                Double.parseDouble(str);
                return "year";
            } catch (NumberFormatException unused) {
                return "yearName";
            }
        } else if (attribute == DateFormat.Field.MONTH) {
            return "month";
        } else {
            if (attribute == DateFormat.Field.DAY_OF_MONTH) {
                return "day";
            }
            if (attribute == DateFormat.Field.HOUR0 || attribute == DateFormat.Field.HOUR1 || attribute == DateFormat.Field.HOUR_OF_DAY0 || attribute == DateFormat.Field.HOUR_OF_DAY1) {
                return "hour";
            }
            if (attribute == DateFormat.Field.MINUTE) {
                return "minute";
            }
            if (attribute == DateFormat.Field.SECOND) {
                return "second";
            }
            if (attribute == DateFormat.Field.TIME_ZONE) {
                return "timeZoneName";
            }
            if (attribute == DateFormat.Field.AM_PM) {
                return "dayPeriod";
            }
            if (attribute.toString().equals("android.icu.text.DateFormat$Field(related year)")) {
                return "relatedYear";
            }
            return "literal";
        }
    }

    public b.g g(o4.b bVar) {
        try {
            String a10 = b.a(q1.a(DateFormat.getTimeInstance(0, f.a(bVar.h()))).toPattern());
            if (a10.contains(String.valueOf('h'))) {
                return b.g.H12;
            }
            if (a10.contains(String.valueOf('K'))) {
                return b.g.H11;
            }
            if (a10.contains(String.valueOf('H'))) {
                return b.g.H23;
            }
            return b.g.H24;
        } catch (ClassCastException unused) {
            return b.g.H24;
        }
    }

    public String h(o4.b bVar) {
        return z3.d(DateFormat.getDateInstance(3, f.a(bVar.h())).getCalendar().getType());
    }
}
