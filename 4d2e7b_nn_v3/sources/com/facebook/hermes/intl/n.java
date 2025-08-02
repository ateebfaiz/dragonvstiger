package com.facebook.hermes.intl;

import com.facebook.hermes.intl.b;
import java.text.AttributedCharacterIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import o4.b;
import o4.j;

public class n implements b {

    /* renamed from: a  reason: collision with root package name */
    private DateFormat f19940a = null;

    private static class a {
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

    n() {
    }

    public AttributedCharacterIterator a(double d10) {
        return this.f19940a.formatToCharacterIterator(Double.valueOf(d10));
    }

    public String b(double d10) {
        return this.f19940a.format(new Date((long) d10));
    }

    public String c(b bVar) {
        return "latn";
    }

    public String d(b bVar) {
        return Calendar.getInstance((Locale) bVar.h()).getTimeZone().getID();
    }

    public void e(b bVar, String str, String str2, b.e eVar, b.m mVar, b.d dVar, b.n nVar, b.i iVar, b.c cVar, b.f fVar, b.h hVar, b.j jVar, b.l lVar, b.g gVar, Object obj, b.C0249b bVar2, b.k kVar, Object obj2) {
        o4.b bVar3 = bVar;
        if (!str.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(j.h(str));
            bVar.g("ca", arrayList);
        }
        if (!str2.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(j.h(str2));
            bVar.g("nu", arrayList2);
        }
        boolean z10 = true;
        boolean z11 = (nVar == null && iVar == null && cVar == null) ? false : true;
        if (fVar == null && hVar == null && jVar == null) {
            z10 = false;
        }
        if (z11 && z10) {
            this.f19940a = DateFormat.getDateTimeInstance(0, 0, (Locale) bVar.h());
        } else if (z11) {
            this.f19940a = DateFormat.getDateInstance(0, (Locale) bVar.h());
        } else if (z10) {
            this.f19940a = DateFormat.getTimeInstance(0, (Locale) bVar.h());
        }
        if (!j.n(obj) && !j.j(obj)) {
            this.f19940a.setTimeZone(TimeZone.getTimeZone(j.h(obj)));
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
            String a10 = a.a(((SimpleDateFormat) DateFormat.getTimeInstance(0, (Locale) bVar.h())).toPattern());
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
        return DateFormat.getDateInstance(3, (Locale) bVar.h()).getCalendar().toString();
    }
}
