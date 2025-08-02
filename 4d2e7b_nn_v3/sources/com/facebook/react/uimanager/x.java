package com.facebook.react.uimanager;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class x {

    /* renamed from: c  reason: collision with root package name */
    public static final a f3964c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final float f3965a;

    /* renamed from: b  reason: collision with root package name */
    private final y f3966b;

    public static final class a {

        /* renamed from: com.facebook.react.uimanager.x$a$a  reason: collision with other inner class name */
        public /* synthetic */ class C0055a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f3967a;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    f3967a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.x.a.C0055a.<clinit>():void");
            }
        }

        private a() {
        }

        public final x a(Dynamic dynamic) {
            m.f(dynamic, "dynamic");
            int i10 = C0055a.f3967a[dynamic.getType().ordinal()];
            if (i10 == 1) {
                double asDouble = dynamic.asDouble();
                if (asDouble >= 0.0d) {
                    return new x(g0.c(asDouble), y.POINT);
                }
                return null;
            } else if (i10 != 2) {
                ReadableType type = dynamic.getType();
                z2.a.G("ReactNative", "Unsupported type for radius property: " + type);
                return null;
            } else {
                String asString = dynamic.asString();
                if (j.p(asString, "%", false, 2, (Object) null)) {
                    try {
                        String substring = asString.substring(0, asString.length() - 1);
                        m.e(substring, "substring(...)");
                        float parseFloat = Float.parseFloat(substring);
                        if (parseFloat >= 0.0f) {
                            return new x(parseFloat, y.PERCENT);
                        }
                        return null;
                    } catch (NumberFormatException unused) {
                        z2.a.G("ReactNative", "Invalid percentage format: " + asString);
                        return null;
                    }
                } else {
                    z2.a.G("ReactNative", "Invalid string value: " + asString);
                    return null;
                }
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public x(float f10, y yVar) {
        m.f(yVar, "unit");
        this.f3965a = f10;
        this.f3966b = yVar;
    }

    public static final x c(Dynamic dynamic) {
        return f3964c.a(dynamic);
    }

    public final y a() {
        return this.f3966b;
    }

    public final float b(float f10, float f11) {
        if (this.f3966b == y.PERCENT) {
            return (this.f3965a / ((float) 100)) * Math.min(f10, f11);
        }
        return this.f3965a;
    }
}
