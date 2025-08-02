package com.facebook.react.views.scroll;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.n;

public enum f {
    BEGIN_DRAG,
    END_DRAG,
    SCROLL,
    MOMENTUM_BEGIN,
    MOMENTUM_END;
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f4167a = null;

    public static final class a {

        /* renamed from: com.facebook.react.views.scroll.f$a$a  reason: collision with other inner class name */
        public /* synthetic */ class C0060a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f4175a = null;

            /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    com.facebook.react.views.scroll.f[] r0 = com.facebook.react.views.scroll.f.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.facebook.react.views.scroll.f r1 = com.facebook.react.views.scroll.f.BEGIN_DRAG     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.facebook.react.views.scroll.f r1 = com.facebook.react.views.scroll.f.END_DRAG     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    com.facebook.react.views.scroll.f r1 = com.facebook.react.views.scroll.f.SCROLL     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    com.facebook.react.views.scroll.f r1 = com.facebook.react.views.scroll.f.MOMENTUM_BEGIN     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    com.facebook.react.views.scroll.f r1 = com.facebook.react.views.scroll.f.MOMENTUM_END     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    f4175a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.f.a.C0060a.<clinit>():void");
            }
        }

        private a() {
        }

        public final String a(f fVar) {
            m.f(fVar, "type");
            int i10 = C0060a.f4175a[fVar.ordinal()];
            if (i10 == 1) {
                return "topScrollBeginDrag";
            }
            if (i10 == 2) {
                return "topScrollEndDrag";
            }
            if (i10 == 3) {
                return "topScroll";
            }
            if (i10 == 4) {
                return "topMomentumScrollBegin";
            }
            if (i10 == 5) {
                return "topMomentumScrollEnd";
            }
            throw new n();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        f[] a10;
        f4174h = pb.a.a(a10);
        f4167a = new a((DefaultConstructorMarker) null);
    }

    public static final String b(f fVar) {
        return f4167a.a(fVar);
    }
}
