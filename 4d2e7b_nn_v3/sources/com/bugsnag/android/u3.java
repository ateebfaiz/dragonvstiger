package com.bugsnag.android;

import com.bugsnag.android.k2;
import io.jsonwebtoken.JwtParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.j;

public final class u3 implements k2.a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19023b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final List f19024a;

    public static final class a {
        private a() {
        }

        public final Boolean a(String str, Collection collection) {
            Iterable<String> iterable = collection;
            if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                return null;
            }
            for (String F : iterable) {
                if (j.F(str, F, false, 2, (Object) null)) {
                    return Boolean.TRUE;
                }
            }
            return null;
        }

        public final s3 b(StackTraceElement stackTraceElement, Collection collection, s2 s2Var) {
            String methodName;
            try {
                String className = stackTraceElement.getClassName();
                if (className.length() > 0) {
                    methodName = className + JwtParser.SEPARATOR_CHAR + stackTraceElement.getMethodName();
                } else {
                    methodName = stackTraceElement.getMethodName();
                }
                String str = methodName;
                String fileName = stackTraceElement.getFileName();
                if (fileName == null) {
                    fileName = "Unknown";
                }
                return new s3(str, fileName, Integer.valueOf(stackTraceElement.getLineNumber()), a(className, collection), (Map) null, (Number) null, 48, (DefaultConstructorMarker) null);
            } catch (Exception e10) {
                s2Var.c("Failed to serialize stacktrace", e10);
                return null;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public u3(List list) {
        this.f19024a = b(list);
    }

    private final List b(List list) {
        if (list.size() >= 200) {
            return list.subList(0, 200);
        }
        return list;
    }

    public final List a() {
        return this.f19024a;
    }

    public void toStream(k2 k2Var) {
        k2Var.h();
        for (s3 P : this.f19024a) {
            k2Var.P(P);
        }
        k2Var.m();
    }

    public u3(StackTraceElement[] stackTraceElementArr, Collection collection, s2 s2Var) {
        int min = Math.min(200, stackTraceElementArr.length);
        this.f19024a = new ArrayList(min);
        int i10 = 0;
        while (i10 < min) {
            int i11 = i10 + 1;
            s3 b10 = f19023b.b(stackTraceElementArr[i10], collection, s2Var);
            if (b10 != null) {
                this.f19024a.add(b10);
            }
            i10 = i11;
        }
    }
}
