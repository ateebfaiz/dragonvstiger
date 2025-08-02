package m7;

import android.content.Context;
import com.facebook.react.uimanager.x;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.n;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private x f12786a;

    /* renamed from: b  reason: collision with root package name */
    private x f12787b;

    /* renamed from: c  reason: collision with root package name */
    private x f12788c;

    /* renamed from: d  reason: collision with root package name */
    private x f12789d;

    /* renamed from: e  reason: collision with root package name */
    private x f12790e;

    /* renamed from: f  reason: collision with root package name */
    private x f12791f;

    /* renamed from: g  reason: collision with root package name */
    private x f12792g;

    /* renamed from: h  reason: collision with root package name */
    private x f12793h;

    /* renamed from: i  reason: collision with root package name */
    private x f12794i;

    /* renamed from: j  reason: collision with root package name */
    private x f12795j;

    /* renamed from: k  reason: collision with root package name */
    private x f12796k;

    /* renamed from: l  reason: collision with root package name */
    private x f12797l;

    /* renamed from: m  reason: collision with root package name */
    private x f12798m;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12799a;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(2:25|26)|27|29) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|29) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                m7.a[] r0 = m7.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                m7.a r1 = m7.a.BORDER_RADIUS     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                m7.a r1 = m7.a.BORDER_TOP_LEFT_RADIUS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                m7.a r1 = m7.a.BORDER_TOP_RIGHT_RADIUS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                m7.a r1 = m7.a.BORDER_BOTTOM_LEFT_RADIUS     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                m7.a r1 = m7.a.BORDER_BOTTOM_RIGHT_RADIUS     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                m7.a r1 = m7.a.BORDER_TOP_START_RADIUS     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                m7.a r1 = m7.a.BORDER_TOP_END_RADIUS     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                m7.a r1 = m7.a.BORDER_BOTTOM_START_RADIUS     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                m7.a r1 = m7.a.BORDER_BOTTOM_END_RADIUS     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                m7.a r1 = m7.a.BORDER_START_START_RADIUS     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                m7.a r1 = m7.a.BORDER_START_END_RADIUS     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                m7.a r1 = m7.a.BORDER_END_START_RADIUS     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                m7.a r1 = m7.a.BORDER_END_END_RADIUS     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                f12799a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: m7.b.a.<clinit>():void");
        }
    }

    public b() {
        this((x) null, (x) null, (x) null, (x) null, (x) null, (x) null, (x) null, (x) null, (x) null, (x) null, (x) null, (x) null, (x) null, 8191, (DefaultConstructorMarker) null);
    }

    public final x a(a aVar) {
        m.f(aVar, "property");
        switch (a.f12799a[aVar.ordinal()]) {
            case 1:
                return this.f12786a;
            case 2:
                return this.f12787b;
            case 3:
                return this.f12788c;
            case 4:
                return this.f12789d;
            case 5:
                return this.f12790e;
            case 6:
                return this.f12791f;
            case 7:
                return this.f12792g;
            case 8:
                return this.f12793h;
            case 9:
                return this.f12794i;
            case 10:
                return this.f12795j;
            case 11:
                return this.f12796k;
            case 12:
                return this.f12797l;
            case 13:
                return this.f12798m;
            default:
                throw new n();
        }
    }

    public final x b() {
        return this.f12786a;
    }

    public final boolean c() {
        if (this.f12786a == null && this.f12787b == null && this.f12788c == null && this.f12789d == null && this.f12790e == null && this.f12791f == null && this.f12792g == null && this.f12793h == null && this.f12794i == null && this.f12795j == null && this.f12796k == null && this.f12797l == null && this.f12798m == null) {
            return false;
        }
        return true;
    }

    public final c d(int i10, Context context, float f10, float f11) {
        c cVar;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        m.f(context, "context");
        float f21 = 0.0f;
        if (i10 == 0) {
            x xVar = this.f12795j;
            if (xVar == null && (xVar = this.f12791f) == null && (xVar = this.f12787b) == null) {
                xVar = this.f12786a;
            }
            if (xVar != null) {
                f12 = xVar.b(f10, f11);
            } else {
                f12 = 0.0f;
            }
            x xVar2 = this.f12797l;
            if (xVar2 == null && (xVar2 = this.f12792g) == null && (xVar2 = this.f12788c) == null) {
                xVar2 = this.f12786a;
            }
            if (xVar2 != null) {
                f13 = xVar2.b(f10, f11);
            } else {
                f13 = 0.0f;
            }
            x xVar3 = this.f12796k;
            if (xVar3 == null && (xVar3 = this.f12793h) == null && (xVar3 = this.f12789d) == null) {
                xVar3 = this.f12786a;
            }
            if (xVar3 != null) {
                f14 = xVar3.b(f10, f11);
            } else {
                f14 = 0.0f;
            }
            x xVar4 = this.f12798m;
            if (xVar4 == null && (xVar4 = this.f12794i) == null && (xVar4 = this.f12790e) == null) {
                xVar4 = this.f12786a;
            }
            if (xVar4 != null) {
                f21 = xVar4.b(f10, f11);
            }
            cVar = new c(f12, f13, f14, f21);
        } else if (i10 != 1) {
            throw new IllegalArgumentException("Expected?.resolved layout direction");
        } else if (com.facebook.react.modules.i18nmanager.a.f3290a.a().d(context)) {
            x xVar5 = this.f12797l;
            if (xVar5 == null && (xVar5 = this.f12792g) == null && (xVar5 = this.f12788c) == null) {
                xVar5 = this.f12786a;
            }
            if (xVar5 != null) {
                f18 = xVar5.b(f10, f11);
            } else {
                f18 = 0.0f;
            }
            x xVar6 = this.f12795j;
            if (xVar6 == null && (xVar6 = this.f12791f) == null && (xVar6 = this.f12787b) == null) {
                xVar6 = this.f12786a;
            }
            if (xVar6 != null) {
                f19 = xVar6.b(f10, f11);
            } else {
                f19 = 0.0f;
            }
            x xVar7 = this.f12798m;
            if (xVar7 == null && (xVar7 = this.f12793h) == null && (xVar7 = this.f12790e) == null) {
                xVar7 = this.f12786a;
            }
            if (xVar7 != null) {
                f20 = xVar7.b(f10, f11);
            } else {
                f20 = 0.0f;
            }
            x xVar8 = this.f12796k;
            if (xVar8 == null && (xVar8 = this.f12794i) == null && (xVar8 = this.f12789d) == null) {
                xVar8 = this.f12786a;
            }
            if (xVar8 != null) {
                f21 = xVar8.b(f10, f11);
            }
            cVar = new c(f18, f19, f20, f21);
        } else {
            x xVar9 = this.f12797l;
            if (xVar9 == null && (xVar9 = this.f12792g) == null && (xVar9 = this.f12787b) == null) {
                xVar9 = this.f12786a;
            }
            if (xVar9 != null) {
                f15 = xVar9.b(f10, f11);
            } else {
                f15 = 0.0f;
            }
            x xVar10 = this.f12795j;
            if (xVar10 == null && (xVar10 = this.f12791f) == null && (xVar10 = this.f12788c) == null) {
                xVar10 = this.f12786a;
            }
            if (xVar10 != null) {
                f16 = xVar10.b(f10, f11);
            } else {
                f16 = 0.0f;
            }
            x xVar11 = this.f12798m;
            if (xVar11 == null && (xVar11 = this.f12793h) == null && (xVar11 = this.f12789d) == null) {
                xVar11 = this.f12786a;
            }
            if (xVar11 != null) {
                f17 = xVar11.b(f10, f11);
            } else {
                f17 = 0.0f;
            }
            x xVar12 = this.f12796k;
            if (xVar12 == null && (xVar12 = this.f12794i) == null && (xVar12 = this.f12790e) == null) {
                xVar12 = this.f12786a;
            }
            if (xVar12 != null) {
                f21 = xVar12.b(f10, f11);
            }
            cVar = new c(f15, f16, f17, f21);
        }
        return cVar;
    }

    public final void e(a aVar, x xVar) {
        m.f(aVar, "property");
        switch (a.f12799a[aVar.ordinal()]) {
            case 1:
                this.f12786a = xVar;
                return;
            case 2:
                this.f12787b = xVar;
                return;
            case 3:
                this.f12788c = xVar;
                return;
            case 4:
                this.f12789d = xVar;
                return;
            case 5:
                this.f12790e = xVar;
                return;
            case 6:
                this.f12791f = xVar;
                return;
            case 7:
                this.f12792g = xVar;
                return;
            case 8:
                this.f12793h = xVar;
                return;
            case 9:
                this.f12794i = xVar;
                return;
            case 10:
                this.f12795j = xVar;
                return;
            case 11:
                this.f12796k = xVar;
                return;
            case 12:
                this.f12797l = xVar;
                return;
            case 13:
                this.f12798m = xVar;
                return;
            default:
                return;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (m.b(this.f12786a, bVar.f12786a) && m.b(this.f12787b, bVar.f12787b) && m.b(this.f12788c, bVar.f12788c) && m.b(this.f12789d, bVar.f12789d) && m.b(this.f12790e, bVar.f12790e) && m.b(this.f12791f, bVar.f12791f) && m.b(this.f12792g, bVar.f12792g) && m.b(this.f12793h, bVar.f12793h) && m.b(this.f12794i, bVar.f12794i) && m.b(this.f12795j, bVar.f12795j) && m.b(this.f12796k, bVar.f12796k) && m.b(this.f12797l, bVar.f12797l) && m.b(this.f12798m, bVar.f12798m)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        x xVar = this.f12786a;
        int i22 = 0;
        if (xVar == null) {
            i10 = 0;
        } else {
            i10 = xVar.hashCode();
        }
        int i23 = i10 * 31;
        x xVar2 = this.f12787b;
        if (xVar2 == null) {
            i11 = 0;
        } else {
            i11 = xVar2.hashCode();
        }
        int i24 = (i23 + i11) * 31;
        x xVar3 = this.f12788c;
        if (xVar3 == null) {
            i12 = 0;
        } else {
            i12 = xVar3.hashCode();
        }
        int i25 = (i24 + i12) * 31;
        x xVar4 = this.f12789d;
        if (xVar4 == null) {
            i13 = 0;
        } else {
            i13 = xVar4.hashCode();
        }
        int i26 = (i25 + i13) * 31;
        x xVar5 = this.f12790e;
        if (xVar5 == null) {
            i14 = 0;
        } else {
            i14 = xVar5.hashCode();
        }
        int i27 = (i26 + i14) * 31;
        x xVar6 = this.f12791f;
        if (xVar6 == null) {
            i15 = 0;
        } else {
            i15 = xVar6.hashCode();
        }
        int i28 = (i27 + i15) * 31;
        x xVar7 = this.f12792g;
        if (xVar7 == null) {
            i16 = 0;
        } else {
            i16 = xVar7.hashCode();
        }
        int i29 = (i28 + i16) * 31;
        x xVar8 = this.f12793h;
        if (xVar8 == null) {
            i17 = 0;
        } else {
            i17 = xVar8.hashCode();
        }
        int i30 = (i29 + i17) * 31;
        x xVar9 = this.f12794i;
        if (xVar9 == null) {
            i18 = 0;
        } else {
            i18 = xVar9.hashCode();
        }
        int i31 = (i30 + i18) * 31;
        x xVar10 = this.f12795j;
        if (xVar10 == null) {
            i19 = 0;
        } else {
            i19 = xVar10.hashCode();
        }
        int i32 = (i31 + i19) * 31;
        x xVar11 = this.f12796k;
        if (xVar11 == null) {
            i20 = 0;
        } else {
            i20 = xVar11.hashCode();
        }
        int i33 = (i32 + i20) * 31;
        x xVar12 = this.f12797l;
        if (xVar12 == null) {
            i21 = 0;
        } else {
            i21 = xVar12.hashCode();
        }
        int i34 = (i33 + i21) * 31;
        x xVar13 = this.f12798m;
        if (xVar13 != null) {
            i22 = xVar13.hashCode();
        }
        return i34 + i22;
    }

    public String toString() {
        x xVar = this.f12786a;
        x xVar2 = this.f12787b;
        x xVar3 = this.f12788c;
        x xVar4 = this.f12789d;
        x xVar5 = this.f12790e;
        x xVar6 = this.f12791f;
        x xVar7 = this.f12792g;
        x xVar8 = this.f12793h;
        x xVar9 = this.f12794i;
        x xVar10 = this.f12795j;
        x xVar11 = this.f12796k;
        x xVar12 = this.f12797l;
        x xVar13 = this.f12798m;
        return "BorderRadiusStyle(uniform=" + xVar + ", topLeft=" + xVar2 + ", topRight=" + xVar3 + ", bottomLeft=" + xVar4 + ", bottomRight=" + xVar5 + ", topStart=" + xVar6 + ", topEnd=" + xVar7 + ", bottomStart=" + xVar8 + ", bottomEnd=" + xVar9 + ", startStart=" + xVar10 + ", startEnd=" + xVar11 + ", endStart=" + xVar12 + ", endEnd=" + xVar13 + ")";
    }

    public b(x xVar, x xVar2, x xVar3, x xVar4, x xVar5, x xVar6, x xVar7, x xVar8, x xVar9, x xVar10, x xVar11, x xVar12, x xVar13) {
        this.f12786a = xVar;
        this.f12787b = xVar2;
        this.f12788c = xVar3;
        this.f12789d = xVar4;
        this.f12790e = xVar5;
        this.f12791f = xVar6;
        this.f12792g = xVar7;
        this.f12793h = xVar8;
        this.f12794i = xVar9;
        this.f12795j = xVar10;
        this.f12796k = xVar11;
        this.f12797l = xVar12;
        this.f12798m = xVar13;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(com.facebook.react.uimanager.x r15, com.facebook.react.uimanager.x r16, com.facebook.react.uimanager.x r17, com.facebook.react.uimanager.x r18, com.facebook.react.uimanager.x r19, com.facebook.react.uimanager.x r20, com.facebook.react.uimanager.x r21, com.facebook.react.uimanager.x r22, com.facebook.react.uimanager.x r23, com.facebook.react.uimanager.x r24, com.facebook.react.uimanager.x r25, com.facebook.react.uimanager.x r26, com.facebook.react.uimanager.x r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x001a
        L_0x0018:
            r4 = r17
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = r2
            goto L_0x0022
        L_0x0020:
            r5 = r18
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = r2
            goto L_0x002a
        L_0x0028:
            r6 = r19
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = r2
            goto L_0x0032
        L_0x0030:
            r7 = r20
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = r2
            goto L_0x003a
        L_0x0038:
            r8 = r21
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = r2
            goto L_0x0042
        L_0x0040:
            r9 = r22
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = r2
            goto L_0x004a
        L_0x0048:
            r10 = r23
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = r2
            goto L_0x0052
        L_0x0050:
            r11 = r24
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = r2
            goto L_0x005a
        L_0x0058:
            r12 = r25
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = r2
            goto L_0x0062
        L_0x0060:
            r13 = r26
        L_0x0062:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r2 = r27
        L_0x0069:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r2
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.b.<init>(com.facebook.react.uimanager.x, com.facebook.react.uimanager.x, com.facebook.react.uimanager.x, com.facebook.react.uimanager.x, com.facebook.react.uimanager.x, com.facebook.react.uimanager.x, com.facebook.react.uimanager.x, com.facebook.react.uimanager.x, com.facebook.react.uimanager.x, com.facebook.react.uimanager.x, com.facebook.react.uimanager.x, com.facebook.react.uimanager.x, com.facebook.react.uimanager.x, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
