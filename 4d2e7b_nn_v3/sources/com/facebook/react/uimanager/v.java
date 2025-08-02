package com.facebook.react.uimanager;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.yoga.g;
import com.facebook.yoga.k;
import com.facebook.yoga.m;
import com.facebook.yoga.s;
import com.facebook.yoga.t;
import com.facebook.yoga.u;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;

public class v extends u0 {

    /* renamed from: y  reason: collision with root package name */
    private final b f3955y = new b();

    /* renamed from: z  reason: collision with root package name */
    boolean f3956z;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3957a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.yoga.u[] r0 = com.facebook.yoga.u.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3957a = r0
                com.facebook.yoga.u r1 = com.facebook.yoga.u.POINT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3957a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.yoga.u r1 = com.facebook.yoga.u.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3957a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.yoga.u r1 = com.facebook.yoga.u.AUTO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3957a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.yoga.u r1 = com.facebook.yoga.u.PERCENT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.v.a.<clinit>():void");
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        float f3958a;

        /* renamed from: b  reason: collision with root package name */
        u f3959b;

        private b() {
        }

        /* access modifiers changed from: package-private */
        public void a(Dynamic dynamic) {
            if (dynamic.isNull()) {
                this.f3959b = u.UNDEFINED;
                this.f3958a = Float.NaN;
            } else if (dynamic.getType() == ReadableType.String) {
                String asString = dynamic.asString();
                if (asString.equals("auto")) {
                    this.f3959b = u.AUTO;
                    this.f3958a = Float.NaN;
                } else if (asString.endsWith("%")) {
                    this.f3959b = u.PERCENT;
                    this.f3958a = Float.parseFloat(asString.substring(0, asString.length() - 1));
                } else {
                    z2.a.G("ReactNative", "Unknown value: " + asString);
                    this.f3959b = u.UNDEFINED;
                    this.f3958a = Float.NaN;
                }
            } else if (dynamic.getType() == ReadableType.Number) {
                this.f3959b = u.POINT;
                this.f3958a = g0.c(dynamic.asDouble());
            } else {
                this.f3959b = u.UNDEFINED;
                this.f3958a = Float.NaN;
            }
        }
    }

    private int v1(int i10) {
        if (!com.facebook.react.modules.i18nmanager.a.f().d(F())) {
            return i10;
        }
        if (i10 == 0) {
            return 4;
        }
        if (i10 != 2) {
            return i10;
        }
        return 5;
    }

    @h7.a(name = "alignContent")
    public void setAlignContent(@Nullable String str) {
        if (!t()) {
            if (str == null) {
                C0(com.facebook.yoga.a.FLEX_START);
                return;
            }
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c10 = 5;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c10 = 6;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c10 = 7;
                        break;
                    }
                    break;
                case 2055030478:
                    if (str.equals("space-evenly")) {
                        c10 = 8;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    C0(com.facebook.yoga.a.STRETCH);
                    return;
                case 1:
                    C0(com.facebook.yoga.a.BASELINE);
                    return;
                case 2:
                    C0(com.facebook.yoga.a.CENTER);
                    return;
                case 3:
                    C0(com.facebook.yoga.a.FLEX_START);
                    return;
                case 4:
                    C0(com.facebook.yoga.a.AUTO);
                    return;
                case 5:
                    C0(com.facebook.yoga.a.SPACE_BETWEEN);
                    return;
                case 6:
                    C0(com.facebook.yoga.a.FLEX_END);
                    return;
                case 7:
                    C0(com.facebook.yoga.a.SPACE_AROUND);
                    return;
                case 8:
                    C0(com.facebook.yoga.a.SPACE_EVENLY);
                    return;
                default:
                    z2.a.G("ReactNative", "invalid value for alignContent: " + str);
                    C0(com.facebook.yoga.a.FLEX_START);
                    return;
            }
        }
    }

    @h7.a(name = "alignItems")
    public void setAlignItems(@Nullable String str) {
        if (!t()) {
            if (str == null) {
                D0(com.facebook.yoga.a.STRETCH);
                return;
            }
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c10 = 5;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c10 = 6;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c10 = 7;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    D0(com.facebook.yoga.a.STRETCH);
                    return;
                case 1:
                    D0(com.facebook.yoga.a.BASELINE);
                    return;
                case 2:
                    D0(com.facebook.yoga.a.CENTER);
                    return;
                case 3:
                    D0(com.facebook.yoga.a.FLEX_START);
                    return;
                case 4:
                    D0(com.facebook.yoga.a.AUTO);
                    return;
                case 5:
                    D0(com.facebook.yoga.a.SPACE_BETWEEN);
                    return;
                case 6:
                    D0(com.facebook.yoga.a.FLEX_END);
                    return;
                case 7:
                    D0(com.facebook.yoga.a.SPACE_AROUND);
                    return;
                default:
                    z2.a.G("ReactNative", "invalid value for alignItems: " + str);
                    D0(com.facebook.yoga.a.STRETCH);
                    return;
            }
        }
    }

    @h7.a(name = "alignSelf")
    public void setAlignSelf(@Nullable String str) {
        if (!t()) {
            if (str == null) {
                E0(com.facebook.yoga.a.AUTO);
                return;
            }
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c10 = 5;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c10 = 6;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c10 = 7;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    E0(com.facebook.yoga.a.STRETCH);
                    return;
                case 1:
                    E0(com.facebook.yoga.a.BASELINE);
                    return;
                case 2:
                    E0(com.facebook.yoga.a.CENTER);
                    return;
                case 3:
                    E0(com.facebook.yoga.a.FLEX_START);
                    return;
                case 4:
                    E0(com.facebook.yoga.a.AUTO);
                    return;
                case 5:
                    E0(com.facebook.yoga.a.SPACE_BETWEEN);
                    return;
                case 6:
                    E0(com.facebook.yoga.a.FLEX_END);
                    return;
                case 7:
                    E0(com.facebook.yoga.a.SPACE_AROUND);
                    return;
                default:
                    z2.a.G("ReactNative", "invalid value for alignSelf: " + str);
                    E0(com.facebook.yoga.a.AUTO);
                    return;
            }
        }
    }

    @h7.a(defaultFloat = Float.NaN, name = "aspectRatio")
    public void setAspectRatio(float f10) {
        g1(f10);
    }

    @h7.b(defaultFloat = Float.NaN, names = {"borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
    public void setBorderWidths(int i10, float f10) {
        if (!t()) {
            G0(v1(m2.f3813b[i10]), g0.d(f10));
        }
    }

    @h7.a(name = "collapsable")
    public void setCollapsable(boolean z10) {
        this.f3956z = z10;
    }

    @h7.a(name = "collapsableChildren")
    public void setCollapsableChildren(boolean z10) {
    }

    @h7.a(name = "columnGap")
    public void setColumnGap(Dynamic dynamic) {
        if (!t()) {
            this.f3955y.a(dynamic);
            int i10 = a.f3957a[this.f3955y.f3959b.ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                H0(this.f3955y.f3958a);
            } else if (i10 == 4) {
                I0(this.f3955y.f3958a);
            }
            dynamic.recycle();
        }
    }

    @h7.a(name = "display")
    public void setDisplay(@Nullable String str) {
        if (!t()) {
            if (str == null) {
                K0(g.FLEX);
            } else if (str.equals("flex")) {
                K0(g.FLEX);
            } else if (!str.equals(DevicePublicKeyStringDef.NONE)) {
                z2.a.G("ReactNative", "invalid value for display: " + str);
                K0(g.FLEX);
            } else {
                K0(g.NONE);
            }
        }
    }

    @h7.a(defaultFloat = 0.0f, name = "flex")
    public void setFlex(float f10) {
        if (!t()) {
            super.setFlex(f10);
        }
    }

    @h7.a(name = "flexBasis")
    public void setFlexBasis(Dynamic dynamic) {
        if (!t()) {
            this.f3955y.a(dynamic);
            int i10 = a.f3957a[this.f3955y.f3959b.ordinal()];
            if (i10 == 1 || i10 == 2) {
                L0(this.f3955y.f3958a);
            } else if (i10 == 3) {
                M0();
            } else if (i10 == 4) {
                N0(this.f3955y.f3958a);
            }
            dynamic.recycle();
        }
    }

    @h7.a(name = "flexDirection")
    public void setFlexDirection(@Nullable String str) {
        if (!t()) {
            if (str == null) {
                O0(k.COLUMN);
                return;
            }
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1448970769:
                    if (str.equals("row-reverse")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1354837162:
                    if (str.equals("column")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 113114:
                    if (str.equals("row")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 1272730475:
                    if (str.equals("column-reverse")) {
                        c10 = 3;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    O0(k.ROW_REVERSE);
                    return;
                case 1:
                    O0(k.COLUMN);
                    return;
                case 2:
                    O0(k.ROW);
                    return;
                case 3:
                    O0(k.COLUMN_REVERSE);
                    return;
                default:
                    z2.a.G("ReactNative", "invalid value for flexDirection: " + str);
                    O0(k.COLUMN);
                    return;
            }
        }
    }

    @h7.a(defaultFloat = 0.0f, name = "flexGrow")
    public void setFlexGrow(float f10) {
        if (!t()) {
            super.setFlexGrow(f10);
        }
    }

    @h7.a(defaultFloat = 0.0f, name = "flexShrink")
    public void setFlexShrink(float f10) {
        if (!t()) {
            super.setFlexShrink(f10);
        }
    }

    @h7.a(name = "flexWrap")
    public void setFlexWrap(@Nullable String str) {
        if (!t()) {
            if (str == null) {
                P0(com.facebook.yoga.v.NO_WRAP);
                return;
            }
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1039592053:
                    if (str.equals("nowrap")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -749527969:
                    if (str.equals("wrap-reverse")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 3657802:
                    if (str.equals("wrap")) {
                        c10 = 2;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    P0(com.facebook.yoga.v.NO_WRAP);
                    return;
                case 1:
                    P0(com.facebook.yoga.v.WRAP_REVERSE);
                    return;
                case 2:
                    P0(com.facebook.yoga.v.WRAP);
                    return;
                default:
                    z2.a.G("ReactNative", "invalid value for flexWrap: " + str);
                    P0(com.facebook.yoga.v.NO_WRAP);
                    return;
            }
        }
    }

    @h7.a(name = "gap")
    public void setGap(Dynamic dynamic) {
        if (!t()) {
            this.f3955y.a(dynamic);
            int i10 = a.f3957a[this.f3955y.f3959b.ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                Q0(this.f3955y.f3958a);
            } else if (i10 == 4) {
                R0(this.f3955y.f3958a);
            }
            dynamic.recycle();
        }
    }

    @h7.a(name = "height")
    public void setHeight(Dynamic dynamic) {
        if (!t()) {
            this.f3955y.a(dynamic);
            int i10 = a.f3957a[this.f3955y.f3959b.ordinal()];
            if (i10 == 1 || i10 == 2) {
                f(this.f3955y.f3958a);
            } else if (i10 == 3) {
                h1();
            } else if (i10 == 4) {
                i1(this.f3955y.f3958a);
            }
            dynamic.recycle();
        }
    }

    @h7.a(name = "inset")
    public void setInset(Dynamic dynamic) {
    }

    @h7.b(names = {"insetBlock", "insetBlockEnd", "insetBlockStart"})
    public void setInsetBlock(int i10, Dynamic dynamic) {
    }

    @h7.b(names = {"insetInline", "insetInlineEnd", "insetInlineStart"})
    public void setInsetInline(int i10, Dynamic dynamic) {
    }

    @h7.a(name = "justifyContent")
    public void setJustifyContent(@Nullable String str) {
        if (!t()) {
            if (str == null) {
                S0(m.FLEX_START);
                return;
            }
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 2055030478:
                    if (str.equals("space-evenly")) {
                        c10 = 5;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    S0(m.CENTER);
                    return;
                case 1:
                    S0(m.FLEX_START);
                    return;
                case 2:
                    S0(m.SPACE_BETWEEN);
                    return;
                case 3:
                    S0(m.FLEX_END);
                    return;
                case 4:
                    S0(m.SPACE_AROUND);
                    return;
                case 5:
                    S0(m.SPACE_EVENLY);
                    return;
                default:
                    z2.a.G("ReactNative", "invalid value for justifyContent: " + str);
                    S0(m.FLEX_START);
                    return;
            }
        }
    }

    @h7.a(name = "experimental_layoutConformance")
    public void setLayoutConformance(String str) {
    }

    @h7.b(names = {"marginBlock", "marginBlockEnd", "marginBlockStart"})
    public void setMarginBlock(int i10, Dynamic dynamic) {
    }

    @h7.b(names = {"marginInline", "marginInlineEnd", "marginInlineStart"})
    public void setMarginInline(int i10, Dynamic dynamic) {
    }

    @h7.b(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i10, Dynamic dynamic) {
        if (!t()) {
            int v12 = v1(m2.f3814c[i10]);
            this.f3955y.a(dynamic);
            int i11 = a.f3957a[this.f3955y.f3959b.ordinal()];
            if (i11 == 1 || i11 == 2) {
                U0(v12, this.f3955y.f3958a);
            } else if (i11 == 3) {
                V0(v12);
            } else if (i11 == 4) {
                W0(v12, this.f3955y.f3958a);
            }
            dynamic.recycle();
        }
    }

    @h7.a(name = "maxHeight")
    public void setMaxHeight(Dynamic dynamic) {
        if (!t()) {
            this.f3955y.a(dynamic);
            int i10 = a.f3957a[this.f3955y.f3959b.ordinal()];
            if (i10 == 1 || i10 == 2) {
                j1(this.f3955y.f3958a);
            } else if (i10 == 4) {
                k1(this.f3955y.f3958a);
            }
            dynamic.recycle();
        }
    }

    @h7.a(name = "maxWidth")
    public void setMaxWidth(Dynamic dynamic) {
        if (!t()) {
            this.f3955y.a(dynamic);
            int i10 = a.f3957a[this.f3955y.f3959b.ordinal()];
            if (i10 == 1 || i10 == 2) {
                l1(this.f3955y.f3958a);
            } else if (i10 == 4) {
                m1(this.f3955y.f3958a);
            }
            dynamic.recycle();
        }
    }

    @h7.a(name = "minHeight")
    public void setMinHeight(Dynamic dynamic) {
        if (!t()) {
            this.f3955y.a(dynamic);
            int i10 = a.f3957a[this.f3955y.f3959b.ordinal()];
            if (i10 == 1 || i10 == 2) {
                n1(this.f3955y.f3958a);
            } else if (i10 == 4) {
                o1(this.f3955y.f3958a);
            }
            dynamic.recycle();
        }
    }

    @h7.a(name = "minWidth")
    public void setMinWidth(Dynamic dynamic) {
        if (!t()) {
            this.f3955y.a(dynamic);
            int i10 = a.f3957a[this.f3955y.f3959b.ordinal()];
            if (i10 == 1 || i10 == 2) {
                p1(this.f3955y.f3958a);
            } else if (i10 == 4) {
                q1(this.f3955y.f3958a);
            }
            dynamic.recycle();
        }
    }

    @h7.a(name = "overflow")
    public void setOverflow(@Nullable String str) {
        if (!t()) {
            if (str == null) {
                Y0(s.VISIBLE);
                return;
            }
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1217487446:
                    if (str.equals("hidden")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -907680051:
                    if (str.equals("scroll")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 466743410:
                    if (str.equals("visible")) {
                        c10 = 2;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    Y0(s.HIDDEN);
                    return;
                case 1:
                    Y0(s.SCROLL);
                    return;
                case 2:
                    Y0(s.VISIBLE);
                    return;
                default:
                    z2.a.G("ReactNative", "invalid value for overflow: " + str);
                    Y0(s.VISIBLE);
                    return;
            }
        }
    }

    @h7.b(names = {"paddingBlock", "paddingBlockEnd", "paddingBlockStart"})
    public void setPaddingBlock(int i10, Dynamic dynamic) {
    }

    @h7.b(names = {"paddingInline", "paddingInlineEnd", "paddingInlineStart"})
    public void setPaddingInline(int i10, Dynamic dynamic) {
    }

    @h7.b(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i10, Dynamic dynamic) {
        if (!t()) {
            int v12 = v1(m2.f3814c[i10]);
            this.f3955y.a(dynamic);
            int i11 = a.f3957a[this.f3955y.f3959b.ordinal()];
            if (i11 == 1 || i11 == 2) {
                Z0(v12, this.f3955y.f3958a);
            } else if (i11 == 4) {
                a1(v12, this.f3955y.f3958a);
            }
            dynamic.recycle();
        }
    }

    @h7.a(name = "position")
    public void setPosition(@Nullable String str) {
        if (!t()) {
            if (str == null) {
                d1(t.RELATIVE);
            } else if (str.equals("relative")) {
                d1(t.RELATIVE);
            } else if (!str.equals("absolute")) {
                z2.a.G("ReactNative", "invalid value for position: " + str);
                d1(t.RELATIVE);
            } else {
                d1(t.ABSOLUTE);
            }
        }
    }

    @h7.b(names = {"start", "end", "left", "right", "top", "bottom"})
    public void setPositionValues(int i10, Dynamic dynamic) {
        if (!t()) {
            int v12 = v1(new int[]{4, 5, 0, 2, 1, 3}[i10]);
            this.f3955y.a(dynamic);
            int i11 = a.f3957a[this.f3955y.f3959b.ordinal()];
            if (i11 == 1 || i11 == 2) {
                b1(v12, this.f3955y.f3958a);
            } else if (i11 == 4) {
                c1(v12, this.f3955y.f3958a);
            }
            dynamic.recycle();
        }
    }

    @h7.a(name = "rowGap")
    public void setRowGap(Dynamic dynamic) {
        if (!t()) {
            this.f3955y.a(dynamic);
            int i10 = a.f3957a[this.f3955y.f3959b.ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                e1(this.f3955y.f3958a);
            } else if (i10 == 4) {
                f1(this.f3955y.f3958a);
            }
            dynamic.recycle();
        }
    }

    @h7.a(name = "onLayout")
    public void setShouldNotifyOnLayout(boolean z10) {
        super.setShouldNotifyOnLayout(z10);
    }

    @h7.a(name = "onPointerEnter")
    public void setShouldNotifyPointerEnter(boolean z10) {
    }

    @h7.a(name = "onPointerLeave")
    public void setShouldNotifyPointerLeave(boolean z10) {
    }

    @h7.a(name = "onPointerMove")
    public void setShouldNotifyPointerMove(boolean z10) {
    }

    @h7.a(name = "width")
    public void setWidth(Dynamic dynamic) {
        if (!t()) {
            this.f3955y.a(dynamic);
            int i10 = a.f3957a[this.f3955y.f3959b.ordinal()];
            if (i10 == 1 || i10 == 2) {
                A(this.f3955y.f3958a);
            } else if (i10 == 3) {
                r1();
            } else if (i10 == 4) {
                s1(this.f3955y.f3958a);
            }
            dynamic.recycle();
        }
    }
}
