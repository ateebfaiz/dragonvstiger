package com.facebook.react.views.text;

import android.graphics.Color;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.room.FtsOptions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.d0;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.s;
import com.facebook.react.uimanager.t0;
import com.facebook.react.uimanager.u0;
import com.facebook.react.uimanager.v;
import com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan;
import com.facebook.react.views.text.internal.span.ReactBackgroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactForegroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactStrikethroughSpan;
import com.facebook.react.views.text.internal.span.ReactUnderlineSpan;
import com.facebook.yoga.YogaValue;
import com.facebook.yoga.u;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import v7.a;
import w7.b;
import w7.d;
import w7.e;
import w7.f;
import w7.g;
import w7.h;
import w7.i;
import w7.j;

public abstract class c extends v {
    protected q A;
    protected boolean B;
    protected int C;
    protected boolean D;
    protected int E;
    protected i0.e F;
    protected i0.f G;
    protected int H;
    protected int I;
    protected int J;
    protected int K;
    protected int L;
    protected float M;
    protected float N;
    protected float O;
    protected int P;
    protected boolean Q;
    protected boolean R;
    protected boolean S;
    protected boolean T;
    protected float U;
    protected int V;
    protected int W;
    protected String X;
    protected String Y;
    protected boolean Z;

    /* renamed from: a0  reason: collision with root package name */
    protected Map f4204a0;

    public c() {
        this((m) null);
    }

    private static void w1(c cVar, SpannableStringBuilder spannableStringBuilder, List list, q qVar, boolean z10, Map map, int i10) {
        q qVar2;
        float f10;
        float f11;
        c cVar2 = cVar;
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        List list2 = list;
        q qVar3 = qVar;
        int i11 = i10;
        if (qVar3 != null) {
            qVar2 = qVar3.a(cVar2.A);
        } else {
            qVar2 = cVar2.A;
        }
        q qVar4 = qVar2;
        int b10 = cVar.b();
        for (int i12 = 0; i12 < b10; i12++) {
            u0 f02 = cVar2.a(i12);
            if (f02 instanceof e) {
                spannableStringBuilder2.append(s.b(((e) f02).v1(), qVar4.l()));
            } else if (f02 instanceof c) {
                w1((c) f02, spannableStringBuilder, list, qVar4, z10, map, spannableStringBuilder.length());
            } else if (f02 instanceof a) {
                spannableStringBuilder2.append("0");
                list2.add(new g(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), ((a) f02).w1()));
            } else if (z10) {
                int q10 = f02.q();
                YogaValue C2 = f02.C();
                YogaValue m10 = f02.m();
                u uVar = C2.f4859b;
                u uVar2 = u.POINT;
                if (uVar == uVar2 && m10.f4859b == uVar2) {
                    f11 = C2.f4858a;
                    f10 = m10.f4858a;
                } else {
                    f02.s();
                    f11 = f02.c0();
                    f10 = f02.k();
                }
                spannableStringBuilder2.append("0");
                list2.add(new g(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new j(q10, (int) f11, (int) f10)));
                map.put(Integer.valueOf(q10), f02);
                f02.d();
            } else {
                throw new s("Unexpected view type nested under a <Text> or <TextInput> node: " + f02.getClass());
            }
            Map map2 = map;
            f02.d();
        }
        int length = spannableStringBuilder.length();
        if (length >= i11) {
            if (cVar2.B) {
                list2.add(new g(i11, length, new ReactForegroundColorSpan(cVar2.C)));
            }
            if (cVar2.D) {
                list2.add(new g(i11, length, new ReactBackgroundColorSpan(cVar2.E)));
            }
            i0.f fVar = cVar2.G;
            if (fVar == null ? cVar2.F == i0.e.LINK : fVar == i0.f.LINK) {
                list2.add(new g(i11, length, new d(cVar.q())));
            }
            float d10 = qVar4.d();
            if (!Float.isNaN(d10) && (qVar3 == null || qVar.d() != d10)) {
                list2.add(new g(i11, length, new w7.a(d10)));
            }
            int c10 = qVar4.c();
            if (qVar3 == null || qVar.c() != c10) {
                list2.add(new g(i11, length, new ReactAbsoluteSizeSpan(c10)));
            }
            if (!(cVar2.V == -1 && cVar2.W == -1 && cVar2.X == null)) {
                list2.add(new g(i11, length, new w7.c(cVar2.V, cVar2.W, cVar2.Y, cVar2.X, cVar.F().getAssets())));
            }
            if (cVar2.Q) {
                list2.add(new g(i11, length, new ReactUnderlineSpan()));
            }
            if (cVar2.R) {
                list2.add(new g(i11, length, new ReactStrikethroughSpan()));
            }
            if (!((cVar2.M == 0.0f && cVar2.N == 0.0f && cVar2.O == 0.0f) || Color.alpha(cVar2.P) == 0)) {
                list2.add(new g(i11, length, new h(cVar2.M, cVar2.N, cVar2.O, cVar2.P)));
            }
            float e10 = qVar4.e();
            if (!Float.isNaN(e10) && (qVar3 == null || qVar.e() != e10)) {
                list2.add(new g(i11, length, new b(e10)));
            }
            list2.add(new g(i11, length, new f(cVar.q())));
        }
    }

    @h7.a(name = "accessibilityRole")
    public void setAccessibilityRole(@Nullable String str) {
        if (t()) {
            this.F = i0.e.c(str);
            x0();
        }
    }

    @h7.a(name = "adjustsFontSizeToFit")
    public void setAdjustFontSizeToFit(boolean z10) {
        if (z10 != this.T) {
            this.T = z10;
            x0();
        }
    }

    @h7.a(defaultBoolean = true, name = "allowFontScaling")
    public void setAllowFontScaling(boolean z10) {
        if (z10 != this.A.b()) {
            this.A.m(z10);
            x0();
        }
    }

    @h7.a(customType = "Color", name = "backgroundColor")
    public void setBackgroundColor(@Nullable Integer num) {
        boolean z10;
        if (t()) {
            if (num != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.D = z10;
            if (z10) {
                this.E = num.intValue();
            }
            x0();
        }
    }

    @h7.a(customType = "Color", name = "color")
    public void setColor(@Nullable Integer num) {
        boolean z10;
        if (num != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.B = z10;
        if (z10) {
            this.C = num.intValue();
        }
        x0();
    }

    @h7.a(name = "fontFamily")
    public void setFontFamily(@Nullable String str) {
        this.X = str;
        x0();
    }

    @h7.a(defaultFloat = Float.NaN, name = "fontSize")
    public void setFontSize(float f10) {
        this.A.n(f10);
        x0();
    }

    @h7.a(name = "fontStyle")
    public void setFontStyle(@Nullable String str) {
        int b10 = n.b(str);
        if (b10 != this.V) {
            this.V = b10;
            x0();
        }
    }

    @h7.a(name = "fontVariant")
    public void setFontVariant(@Nullable ReadableArray readableArray) {
        String c10 = n.c(readableArray);
        if (!TextUtils.equals(c10, this.Y)) {
            this.Y = c10;
            x0();
        }
    }

    @h7.a(name = "fontWeight")
    public void setFontWeight(@Nullable String str) {
        int d10 = n.d(str);
        if (d10 != this.W) {
            this.W = d10;
            x0();
        }
    }

    @h7.a(defaultBoolean = true, name = "includeFontPadding")
    public void setIncludeFontPadding(boolean z10) {
        this.S = z10;
    }

    @h7.a(defaultFloat = 0.0f, name = "letterSpacing")
    public void setLetterSpacing(float f10) {
        this.A.p(f10);
        x0();
    }

    @h7.a(defaultFloat = Float.NaN, name = "lineHeight")
    public void setLineHeight(float f10) {
        this.A.q(f10);
        x0();
    }

    @h7.a(defaultFloat = Float.NaN, name = "maxFontSizeMultiplier")
    public void setMaxFontSizeMultiplier(float f10) {
        if (f10 != this.A.k()) {
            this.A.r(f10);
            x0();
        }
    }

    @h7.a(name = "minimumFontScale")
    public void setMinimumFontScale(float f10) {
        if (f10 != this.U) {
            this.U = f10;
            x0();
        }
    }

    @h7.a(defaultInt = -1, name = "numberOfLines")
    public void setNumberOfLines(int i10) {
        if (i10 == 0) {
            i10 = -1;
        }
        this.H = i10;
        x0();
    }

    @h7.a(name = "role")
    public void setRole(@Nullable String str) {
        if (t()) {
            this.G = i0.f.b(str);
            x0();
        }
    }

    @h7.a(name = "textAlign")
    public void setTextAlign(@Nullable String str) {
        if ("justify".equals(str)) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.L = 1;
            }
            this.I = 3;
        } else {
            if (Build.VERSION.SDK_INT >= 26) {
                this.L = 0;
            }
            if (str == null || "auto".equals(str)) {
                this.I = 0;
            } else if ("left".equals(str)) {
                this.I = 3;
            } else if ("right".equals(str)) {
                this.I = 5;
            } else if ("center".equals(str)) {
                this.I = 1;
            } else {
                z2.a.G("ReactNative", "Invalid textAlign: " + str);
                this.I = 0;
            }
        }
        x0();
    }

    @h7.a(name = "textBreakStrategy")
    public void setTextBreakStrategy(@Nullable String str) {
        if (str == null || "highQuality".equals(str)) {
            this.J = 1;
        } else if (FtsOptions.TOKENIZER_SIMPLE.equals(str)) {
            this.J = 0;
        } else if ("balanced".equals(str)) {
            this.J = 2;
        } else {
            z2.a.G("ReactNative", "Invalid textBreakStrategy: " + str);
            this.J = 1;
        }
        x0();
    }

    @h7.a(name = "textDecorationLine")
    public void setTextDecorationLine(@Nullable String str) {
        this.Q = false;
        this.R = false;
        if (str != null) {
            for (String str2 : str.split(" ")) {
                if ("underline".equals(str2)) {
                    this.Q = true;
                } else if ("line-through".equals(str2)) {
                    this.R = true;
                }
            }
        }
        x0();
    }

    @h7.a(customType = "Color", defaultInt = 1426063360, name = "textShadowColor")
    public void setTextShadowColor(int i10) {
        if (i10 != this.P) {
            this.P = i10;
            x0();
        }
    }

    @h7.a(name = "textShadowOffset")
    public void setTextShadowOffset(ReadableMap readableMap) {
        this.M = 0.0f;
        this.N = 0.0f;
        if (readableMap != null) {
            if (readableMap.hasKey(Snapshot.WIDTH) && !readableMap.isNull(Snapshot.WIDTH)) {
                this.M = g0.c(readableMap.getDouble(Snapshot.WIDTH));
            }
            if (readableMap.hasKey(Snapshot.HEIGHT) && !readableMap.isNull(Snapshot.HEIGHT)) {
                this.N = g0.c(readableMap.getDouble(Snapshot.HEIGHT));
            }
        }
        x0();
    }

    @h7.a(defaultInt = 1, name = "textShadowRadius")
    public void setTextShadowRadius(float f10) {
        if (f10 != this.O) {
            this.O = f10;
            x0();
        }
    }

    @h7.a(name = "textTransform")
    public void setTextTransform(@Nullable String str) {
        if (str == null) {
            this.A.s(s.UNSET);
        } else if (DevicePublicKeyStringDef.NONE.equals(str)) {
            this.A.s(s.NONE);
        } else if ("uppercase".equals(str)) {
            this.A.s(s.UPPERCASE);
        } else if ("lowercase".equals(str)) {
            this.A.s(s.LOWERCASE);
        } else if ("capitalize".equals(str)) {
            this.A.s(s.CAPITALIZE);
        } else {
            z2.a.G("ReactNative", "Invalid textTransform: " + str);
            this.A.s(s.UNSET);
        }
        x0();
    }

    /* access modifiers changed from: protected */
    public Spannable x1(c cVar, String str, boolean z10, d0 d0Var) {
        boolean z11;
        HashMap hashMap;
        int i10;
        c cVar2 = cVar;
        String str2 = str;
        d0 d0Var2 = d0Var;
        if (!z10 || d0Var2 != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        p5.a.b(z11, "nativeViewHierarchyOptimizer is required when inline views are supported");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList arrayList = new ArrayList();
        if (z10) {
            hashMap = new HashMap();
        } else {
            hashMap = null;
        }
        HashMap hashMap2 = hashMap;
        if (str2 != null) {
            spannableStringBuilder.append(s.b(str2, cVar2.A.l()));
        }
        w1(cVar, spannableStringBuilder, arrayList, (q) null, z10, hashMap2, 0);
        cVar2.Z = false;
        cVar2.f4204a0 = hashMap2;
        float f10 = Float.NaN;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            g gVar = (g) arrayList.get((arrayList.size() - i11) - 1);
            e eVar = gVar.f13204c;
            boolean z12 = eVar instanceof i;
            if (z12 || (eVar instanceof j)) {
                if (z12) {
                    i10 = ((i) eVar).b();
                    cVar2.Z = true;
                } else {
                    j jVar = (j) eVar;
                    int a10 = jVar.a();
                    t0 t0Var = (t0) hashMap2.get(Integer.valueOf(jVar.b()));
                    d0Var2.h(t0Var);
                    t0Var.N(cVar);
                    i10 = a10;
                }
                if (Float.isNaN(f10) || ((float) i10) > f10) {
                    f10 = (float) i10;
                }
            }
            gVar.a(spannableStringBuilder, i11);
        }
        cVar2.A.o(f10);
        return spannableStringBuilder;
    }

    public c(m mVar) {
        this.B = false;
        this.D = false;
        this.F = null;
        this.G = null;
        this.H = -1;
        this.I = 0;
        this.J = 1;
        this.K = 0;
        this.L = 0;
        this.M = 0.0f;
        this.N = 0.0f;
        this.O = 0.0f;
        this.P = 1426063360;
        this.Q = false;
        this.R = false;
        this.S = true;
        this.T = false;
        this.U = 0.0f;
        this.V = -1;
        this.W = -1;
        this.X = null;
        this.Y = null;
        this.Z = false;
        this.A = new q();
    }
}
