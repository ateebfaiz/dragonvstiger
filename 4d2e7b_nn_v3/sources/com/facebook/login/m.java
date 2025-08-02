package com.facebook.login;

import io.jsonwebtoken.JwtParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.random.c;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;
import kotlin.text.h;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f20549a = new m();

    private m() {
    }

    public static final String a() {
        int j10 = l.j(new IntRange(43, 128), c.f729a);
        List k02 = r.k0(r.k0(r.k0(r.k0(r.j0(r.i0(new kotlin.ranges.c('a', 'z'), new kotlin.ranges.c('A', 'Z')), new kotlin.ranges.c('0', '9')), '-'), Character.valueOf(JwtParser.SEPARATOR_CHAR)), '_'), '~');
        ArrayList arrayList = new ArrayList(j10);
        for (int i10 = 0; i10 < j10; i10++) {
            Character ch = (Character) r.l0(k02, c.f729a);
            ch.charValue();
            arrayList.add(ch);
        }
        return r.f0(arrayList, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static final boolean b(String str) {
        if (str == null || str.length() == 0 || str.length() < 43 || str.length() > 128) {
            return false;
        }
        return new h("^[-._~A-Za-z0-9]+$").c(str);
    }
}
