package androidx.activity;

import android.content.res.Resources;
import androidx.annotation.ColorInt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class SystemBarStyle {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int darkScrim;
    private final Function1<Resources, Boolean> detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    public static final class Companion {

        static final class a extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final a f13800a = new a();

            a() {
                super(1);
            }

            /* renamed from: a */
            public final Boolean invoke(Resources resources) {
                boolean z10;
                m.f(resources, "resources");
                if ((resources.getConfiguration().uiMode & 48) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }

        static final class b extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final b f13801a = new b();

            b() {
                super(1);
            }

            /* renamed from: a */
            public final Boolean invoke(Resources resources) {
                m.f(resources, "<anonymous parameter 0>");
                return Boolean.TRUE;
            }
        }

        static final class c extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final c f13802a = new c();

            c() {
                super(1);
            }

            /* renamed from: a */
            public final Boolean invoke(Resources resources) {
                m.f(resources, "<anonymous parameter 0>");
                return Boolean.FALSE;
            }
        }

        private Companion() {
        }

        public static /* synthetic */ SystemBarStyle auto$default(Companion companion, int i10, int i11, Function1 function1, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                function1 = a.f13800a;
            }
            return companion.auto(i10, i11, function1);
        }

        public final SystemBarStyle auto(@ColorInt int i10, @ColorInt int i11) {
            return auto$default(this, i10, i11, (Function1) null, 4, (Object) null);
        }

        public final SystemBarStyle dark(@ColorInt int i10) {
            return new SystemBarStyle(i10, i10, 2, b.f13801a, (DefaultConstructorMarker) null);
        }

        public final SystemBarStyle light(@ColorInt int i10, @ColorInt int i11) {
            return new SystemBarStyle(i10, i11, 1, c.f13802a, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SystemBarStyle auto(@ColorInt int i10, @ColorInt int i11, Function1<? super Resources, Boolean> function1) {
            m.f(function1, "detectDarkMode");
            return new SystemBarStyle(i10, i11, 0, function1, (DefaultConstructorMarker) null);
        }
    }

    public /* synthetic */ SystemBarStyle(int i10, int i11, int i12, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, i11, i12, function1);
    }

    public static final SystemBarStyle auto(@ColorInt int i10, @ColorInt int i11) {
        return Companion.auto(i10, i11);
    }

    public static final SystemBarStyle dark(@ColorInt int i10) {
        return Companion.dark(i10);
    }

    public static final SystemBarStyle light(@ColorInt int i10, @ColorInt int i11) {
        return Companion.light(i10, i11);
    }

    public final int getDarkScrim$activity_release() {
        return this.darkScrim;
    }

    public final Function1<Resources, Boolean> getDetectDarkMode$activity_release() {
        return this.detectDarkMode;
    }

    public final int getNightMode$activity_release() {
        return this.nightMode;
    }

    public final int getScrim$activity_release(boolean z10) {
        if (z10) {
            return this.darkScrim;
        }
        return this.lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean z10) {
        if (this.nightMode == 0) {
            return 0;
        }
        if (z10) {
            return this.darkScrim;
        }
        return this.lightScrim;
    }

    private SystemBarStyle(int i10, int i11, int i12, Function1<? super Resources, Boolean> function1) {
        this.lightScrim = i10;
        this.darkScrim = i11;
        this.nightMode = i12;
        this.detectDarkMode = function1;
    }

    public static final SystemBarStyle auto(@ColorInt int i10, @ColorInt int i11, Function1<? super Resources, Boolean> function1) {
        return Companion.auto(i10, i11, function1);
    }
}
