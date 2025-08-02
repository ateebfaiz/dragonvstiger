package com.facebook.react.views.text;

import android.os.Build;
import android.text.TextUtils;
import androidx.room.FtsOptions;
import com.adjust.sdk.Constants;
import com.facebook.react.common.mapbuffer.a;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.v0;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.ArrayList;
import java.util.Iterator;
import z2.a;

public class p {
    private static final int D = 0;
    protected String A = null;
    protected boolean B = false;
    protected float C = Float.NaN;

    /* renamed from: a  reason: collision with root package name */
    protected float f4235a = Float.NaN;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f4236b = false;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f4237c = true;

    /* renamed from: d  reason: collision with root package name */
    protected int f4238d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f4239e = false;

    /* renamed from: f  reason: collision with root package name */
    protected int f4240f;

    /* renamed from: g  reason: collision with root package name */
    protected int f4241g = -1;

    /* renamed from: h  reason: collision with root package name */
    protected int f4242h = -1;

    /* renamed from: i  reason: collision with root package name */
    protected float f4243i = -1.0f;

    /* renamed from: j  reason: collision with root package name */
    protected float f4244j = -1.0f;

    /* renamed from: k  reason: collision with root package name */
    protected float f4245k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    protected int f4246l = 0;

    /* renamed from: m  reason: collision with root package name */
    protected int f4247m = -1;

    /* renamed from: n  reason: collision with root package name */
    protected s f4248n = s.NONE;

    /* renamed from: o  reason: collision with root package name */
    protected float f4249o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    protected float f4250p = 0.0f;

    /* renamed from: q  reason: collision with root package name */
    protected float f4251q = 0.0f;

    /* renamed from: r  reason: collision with root package name */
    protected int f4252r = 1426063360;

    /* renamed from: s  reason: collision with root package name */
    protected boolean f4253s = false;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f4254t = false;

    /* renamed from: u  reason: collision with root package name */
    protected boolean f4255u = true;

    /* renamed from: v  reason: collision with root package name */
    protected i0.e f4256v = null;

    /* renamed from: w  reason: collision with root package name */
    protected i0.f f4257w = null;

    /* renamed from: x  reason: collision with root package name */
    protected int f4258x = -1;

    /* renamed from: y  reason: collision with root package name */
    protected int f4259y = -1;

    /* renamed from: z  reason: collision with root package name */
    protected String f4260z = null;

    private p() {
    }

    private void A(String str) {
        if (str == null || DevicePublicKeyStringDef.NONE.equals(str)) {
            this.f4248n = s.NONE;
        } else if ("uppercase".equals(str)) {
            this.f4248n = s.UPPERCASE;
        } else if ("lowercase".equals(str)) {
            this.f4248n = s.LOWERCASE;
        } else if ("capitalize".equals(str)) {
            this.f4248n = s.CAPITALIZE;
        } else {
            a.G("ReactNative", "Invalid textTransform: " + str);
            this.f4248n = s.NONE;
        }
    }

    public static p a(com.facebook.react.common.mapbuffer.a aVar) {
        p pVar = new p();
        Iterator it = aVar.iterator();
        while (it.hasNext()) {
            a.c cVar = (a.c) it.next();
            switch (cVar.getKey()) {
                case 0:
                    pVar.l(Integer.valueOf(cVar.d()));
                    break;
                case 1:
                    pVar.k(Integer.valueOf(cVar.d()));
                    break;
                case 3:
                    pVar.m(cVar.c());
                    break;
                case 4:
                    pVar.n((float) cVar.b());
                    break;
                case 6:
                    pVar.q(cVar.c());
                    break;
                case 7:
                    pVar.o(cVar.c());
                    break;
                case 8:
                    pVar.p(cVar.e());
                    break;
                case 9:
                    pVar.j(cVar.f());
                    break;
                case 10:
                    pVar.s((float) cVar.b());
                    break;
                case 11:
                    pVar.t((float) cVar.b());
                    break;
                case 15:
                    pVar.v(cVar.c());
                    break;
                case 18:
                    pVar.z((float) cVar.b());
                    break;
                case 19:
                    pVar.w(cVar.d());
                    break;
                case 20:
                    pVar.x((float) cVar.b());
                    break;
                case 21:
                    pVar.y((float) cVar.b());
                    break;
                case 23:
                    pVar.r(cVar.c());
                    break;
                case 24:
                    pVar.i(cVar.c());
                    break;
                case 26:
                    pVar.u(i0.f.values()[cVar.d()]);
                    break;
                case 27:
                    pVar.A(cVar.c());
                    break;
            }
        }
        return pVar;
    }

    public static int c(String str) {
        if (str == null) {
            return 0;
        }
        if (str.equals(Constants.NORMAL)) {
            return 1;
        }
        if (!str.equals(DevicePublicKeyStringDef.NONE)) {
            return 2;
        }
        return 0;
    }

    public static int d(v0 v0Var, int i10) {
        if (!v0Var.c("textAlign")) {
            return i10;
        }
        if (!"justify".equals(v0Var.b("textAlign")) || Build.VERSION.SDK_INT < 26) {
            return D;
        }
        return 1;
    }

    public static int e(String str) {
        if (str == null || "undefined".equals(str)) {
            return -1;
        }
        if ("rtl".equals(str)) {
            return 1;
        }
        if ("ltr".equals(str)) {
            return 0;
        }
        z2.a.G("ReactNative", "Invalid layoutDirection: " + str);
        return -1;
    }

    public static int g(v0 v0Var, boolean z10, int i10) {
        if (!v0Var.c("textAlign")) {
            return i10;
        }
        String b10 = v0Var.b("textAlign");
        if ("justify".equals(b10)) {
            return 3;
        }
        if (b10 != null && !"auto".equals(b10)) {
            if ("left".equals(b10)) {
                if (z10) {
                    return 5;
                }
                return 3;
            } else if ("right".equals(b10)) {
                if (z10) {
                    return 3;
                }
                return 5;
            } else if ("center".equals(b10)) {
                return 1;
            } else {
                z2.a.G("ReactNative", "Invalid textAlign: " + b10);
            }
        }
        return 0;
    }

    public static int h(String str) {
        if (str == null) {
            return 1;
        }
        if (str.equals("balanced")) {
            return 2;
        }
        if (!str.equals(FtsOptions.TOKENIZER_SIMPLE)) {
            return 1;
        }
        return 0;
    }

    private void i(String str) {
        if (str == null) {
            this.f4256v = null;
        } else {
            this.f4256v = i0.e.c(str);
        }
    }

    private void j(boolean z10) {
        if (z10 != this.f4237c) {
            this.f4237c = z10;
            n(this.f4243i);
            t(this.f4244j);
            s(this.f4245k);
        }
    }

    private void k(Integer num) {
        boolean z10;
        if (num != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f4239e = z10;
        if (z10) {
            this.f4240f = num.intValue();
        }
    }

    private void l(Integer num) {
        boolean z10;
        if (num != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f4236b = z10;
        if (z10) {
            this.f4238d = num.intValue();
        }
    }

    private void m(String str) {
        this.f4260z = str;
    }

    private void n(float f10) {
        double ceil;
        this.f4243i = f10;
        if (f10 != -1.0f) {
            if (this.f4237c) {
                ceil = Math.ceil((double) g0.f(f10));
            } else {
                ceil = Math.ceil((double) g0.d(f10));
            }
            f10 = (float) ceil;
        }
        this.f4242h = (int) f10;
    }

    private void o(String str) {
        this.f4258x = n.b(str);
    }

    private void p(com.facebook.react.common.mapbuffer.a aVar) {
        if (aVar == null || aVar.getCount() == 0) {
            this.A = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = aVar.iterator();
        while (it.hasNext()) {
            String c10 = ((a.c) it.next()).c();
            if (c10 != null) {
                char c11 = 65535;
                switch (c10.hashCode()) {
                    case -1983120972:
                        if (c10.equals("stylistic-thirteen")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case -1933522176:
                        if (c10.equals("stylistic-fifteen")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case -1534462052:
                        if (c10.equals("stylistic-eighteen")) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case -1195362251:
                        if (c10.equals("proportional-nums")) {
                            c11 = 3;
                            break;
                        }
                        break;
                    case -1061392823:
                        if (c10.equals("lining-nums")) {
                            c11 = 4;
                            break;
                        }
                        break;
                    case -771984547:
                        if (c10.equals("tabular-nums")) {
                            c11 = 5;
                            break;
                        }
                        break;
                    case -659678800:
                        if (c10.equals("oldstyle-nums")) {
                            c11 = 6;
                            break;
                        }
                        break;
                    case 296506098:
                        if (c10.equals("stylistic-eight")) {
                            c11 = 7;
                            break;
                        }
                        break;
                    case 309330544:
                        if (c10.equals("stylistic-seven")) {
                            c11 = 8;
                            break;
                        }
                        break;
                    case 310339585:
                        if (c10.equals("stylistic-three")) {
                            c11 = 9;
                            break;
                        }
                        break;
                    case 604478526:
                        if (c10.equals("stylistic-eleven")) {
                            c11 = 10;
                            break;
                        }
                        break;
                    case 979426287:
                        if (c10.equals("stylistic-five")) {
                            c11 = 11;
                            break;
                        }
                        break;
                    case 979432035:
                        if (c10.equals("stylistic-four")) {
                            c11 = 12;
                            break;
                        }
                        break;
                    case 979664367:
                        if (c10.equals("stylistic-nine")) {
                            c11 = 13;
                            break;
                        }
                        break;
                    case 1001434505:
                        if (c10.equals("stylistic-one")) {
                            c11 = 14;
                            break;
                        }
                        break;
                    case 1001438213:
                        if (c10.equals("stylistic-six")) {
                            c11 = 15;
                            break;
                        }
                        break;
                    case 1001439040:
                        if (c10.equals("stylistic-ten")) {
                            c11 = 16;
                            break;
                        }
                        break;
                    case 1001439599:
                        if (c10.equals("stylistic-two")) {
                            c11 = 17;
                            break;
                        }
                        break;
                    case 1030714463:
                        if (c10.equals("stylistic-sixteen")) {
                            c11 = 18;
                            break;
                        }
                        break;
                    case 1044065430:
                        if (c10.equals("stylistic-twelve")) {
                            c11 = 19;
                            break;
                        }
                        break;
                    case 1044067310:
                        if (c10.equals("stylistic-twenty")) {
                            c11 = 20;
                            break;
                        }
                        break;
                    case 1183323111:
                        if (c10.equals("small-caps")) {
                            c11 = 21;
                            break;
                        }
                        break;
                    case 1463562569:
                        if (c10.equals("stylistic-nineteen")) {
                            c11 = 22;
                            break;
                        }
                        break;
                    case 1648446397:
                        if (c10.equals("stylistic-fourteen")) {
                            c11 = 23;
                            break;
                        }
                        break;
                    case 2097122634:
                        if (c10.equals("stylistic-seventeen")) {
                            c11 = 24;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        arrayList.add("'ss13'");
                        break;
                    case 1:
                        arrayList.add("'ss15'");
                        break;
                    case 2:
                        arrayList.add("'ss18'");
                        break;
                    case 3:
                        arrayList.add("'pnum'");
                        break;
                    case 4:
                        arrayList.add("'lnum'");
                        break;
                    case 5:
                        arrayList.add("'tnum'");
                        break;
                    case 6:
                        arrayList.add("'onum'");
                        break;
                    case 7:
                        arrayList.add("'ss08'");
                        break;
                    case 8:
                        arrayList.add("'ss07'");
                        break;
                    case 9:
                        arrayList.add("'ss03'");
                        break;
                    case 10:
                        arrayList.add("'ss11'");
                        break;
                    case 11:
                        arrayList.add("'ss05'");
                        break;
                    case 12:
                        arrayList.add("'ss04'");
                        break;
                    case 13:
                        arrayList.add("'ss09'");
                        break;
                    case 14:
                        arrayList.add("'ss01'");
                        break;
                    case 15:
                        arrayList.add("'ss06'");
                        break;
                    case 16:
                        arrayList.add("'ss10'");
                        break;
                    case 17:
                        arrayList.add("'ss02'");
                        break;
                    case 18:
                        arrayList.add("'ss16'");
                        break;
                    case 19:
                        arrayList.add("'ss12'");
                        break;
                    case 20:
                        arrayList.add("'ss20'");
                        break;
                    case 21:
                        arrayList.add("'smcp'");
                        break;
                    case 22:
                        arrayList.add("'ss19'");
                        break;
                    case 23:
                        arrayList.add("'ss14'");
                        break;
                    case 24:
                        arrayList.add("'ss17'");
                        break;
                }
            }
        }
        this.A = TextUtils.join(", ", arrayList);
    }

    private void q(String str) {
        this.f4259y = n.d(str);
    }

    private void r(String str) {
        this.f4247m = e(str);
    }

    private void s(float f10) {
        this.f4245k = f10;
    }

    private void t(float f10) {
        float f11;
        this.f4244j = f10;
        if (f10 == -1.0f) {
            this.f4235a = Float.NaN;
            return;
        }
        if (this.f4237c) {
            f11 = g0.f(f10);
        } else {
            f11 = g0.d(f10);
        }
        this.f4235a = f11;
    }

    private void u(i0.f fVar) {
        this.f4257w = fVar;
    }

    private void v(String str) {
        this.f4253s = false;
        this.f4254t = false;
        if (str != null) {
            for (String str2 : str.split("-")) {
                if ("underline".equals(str2)) {
                    this.f4253s = true;
                } else if ("strikethrough".equals(str2)) {
                    this.f4254t = true;
                }
            }
        }
    }

    private void w(int i10) {
        if (i10 != this.f4252r) {
            this.f4252r = i10;
        }
    }

    private void x(float f10) {
        this.f4249o = g0.d(f10);
    }

    private void y(float f10) {
        this.f4250p = g0.d(f10);
    }

    private void z(float f10) {
        if (f10 != this.f4251q) {
            this.f4251q = f10;
        }
    }

    public float b() {
        if (!Float.isNaN(this.f4235a) && !Float.isNaN(this.C)) {
            float f10 = this.C;
            if (f10 > this.f4235a) {
                return f10;
            }
        }
        return this.f4235a;
    }

    public float f() {
        float f10;
        if (this.f4237c) {
            f10 = g0.f(this.f4245k);
        } else {
            f10 = g0.d(this.f4245k);
        }
        int i10 = this.f4242h;
        if (i10 > 0) {
            return f10 / ((float) i10);
        }
        throw new IllegalArgumentException("FontSize should be a positive value. Current value: " + this.f4242h);
    }
}
