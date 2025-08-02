package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.util.f;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

abstract class u {

    /* renamed from: b  reason: collision with root package name */
    protected static final p[] f5416b = new p[0];

    /* renamed from: c  reason: collision with root package name */
    protected static final Annotation[] f5417c = new Annotation[0];

    /* renamed from: a  reason: collision with root package name */
    protected final b f5418a;

    protected u(b bVar) {
        this.f5418a = bVar;
    }

    static p a() {
        return new p();
    }

    static p[] b(int i10) {
        if (i10 == 0) {
            return f5416b;
        }
        p[] pVarArr = new p[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            pVarArr[i11] = a();
        }
        return pVarArr;
    }

    protected static final boolean c(Annotation annotation) {
        if ((annotation instanceof Target) || (annotation instanceof Retention)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final o d(o oVar, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            oVar = oVar.a(annotation);
            if (this.f5418a.h0(annotation)) {
                oVar = h(oVar, annotation);
            }
        }
        return oVar;
    }

    /* access modifiers changed from: protected */
    public final o e(Annotation[] annotationArr) {
        o e10 = o.e();
        for (Annotation annotation : annotationArr) {
            e10 = e10.a(annotation);
            if (this.f5418a.h0(annotation)) {
                e10 = h(e10, annotation);
            }
        }
        return e10;
    }

    /* access modifiers changed from: protected */
    public final o f(o oVar, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            if (!oVar.f(annotation)) {
                oVar = oVar.a(annotation);
                if (this.f5418a.h0(annotation)) {
                    oVar = g(oVar, annotation);
                }
            }
        }
        return oVar;
    }

    /* access modifiers changed from: protected */
    public final o g(o oVar, Annotation annotation) {
        for (Annotation annotation2 : f.n(annotation.annotationType())) {
            if (!c(annotation2) && !oVar.f(annotation2)) {
                oVar = oVar.a(annotation2);
                if (this.f5418a.h0(annotation2)) {
                    oVar = h(oVar, annotation2);
                }
            }
        }
        return oVar;
    }

    /* access modifiers changed from: protected */
    public final o h(o oVar, Annotation annotation) {
        for (Annotation annotation2 : f.n(annotation.annotationType())) {
            if (!c(annotation2)) {
                if (!this.f5418a.h0(annotation2)) {
                    oVar = oVar.a(annotation2);
                } else if (!oVar.f(annotation2)) {
                    oVar = h(oVar.a(annotation2), annotation2);
                }
            }
        }
        return oVar;
    }
}
