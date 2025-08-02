package com.bugsnag.android;

import com.bugsnag.android.k2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class m1 implements k2.a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f18848e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private String f18849a;

    /* renamed from: b  reason: collision with root package name */
    private String f18850b;

    /* renamed from: c  reason: collision with root package name */
    private ErrorType f18851c;

    /* renamed from: d  reason: collision with root package name */
    private final List f18852d;

    public static final class a {
        private a() {
        }

        public final List a(Throwable th, Collection collection, s2 s2Var) {
            ArrayList arrayList = new ArrayList();
            for (Throwable th2 : g4.a(th)) {
                StackTraceElement[] stackTrace = th2.getStackTrace();
                if (stackTrace == null) {
                    stackTrace = new StackTraceElement[0];
                }
                arrayList.add(new k1(new m1(th2.getClass().getName(), th2.getLocalizedMessage(), new u3(stackTrace, collection, s2Var), (ErrorType) null, 8, (DefaultConstructorMarker) null), s2Var));
            }
            return arrayList;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public m1(String str, String str2, u3 u3Var, ErrorType errorType) {
        this.f18849a = str;
        this.f18850b = str2;
        this.f18851c = errorType;
        this.f18852d = u3Var.a();
    }

    public final String a() {
        return this.f18849a;
    }

    public final String b() {
        return this.f18850b;
    }

    public final List c() {
        return this.f18852d;
    }

    public final ErrorType d() {
        return this.f18851c;
    }

    public final void e(String str) {
        this.f18849a = str;
    }

    public final void f(String str) {
        this.f18850b = str;
    }

    public final void g(ErrorType errorType) {
        this.f18851c = errorType;
    }

    public void toStream(k2 k2Var) {
        k2Var.j();
        k2Var.v("errorClass").K(this.f18849a);
        k2Var.v("message").K(this.f18850b);
        k2Var.v("type").K(this.f18851c.getDesc$bugsnag_android_core_release());
        k2Var.v("stacktrace").P(this.f18852d);
        k2Var.n();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m1(String str, String str2, u3 u3Var, ErrorType errorType, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, u3Var, (i10 & 8) != 0 ? ErrorType.ANDROID : errorType);
    }
}
