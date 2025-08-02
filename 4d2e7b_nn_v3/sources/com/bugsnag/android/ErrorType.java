package com.bugsnag.android;

import com.alibaba.pdns.f;
import com.alibaba.pdns.net.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public enum ErrorType {
    UNKNOWN(""),
    ANDROID(f.f17924q),
    REACTNATIVEJS("reactnativejs"),
    C(d.f18103f),
    DART("dart");
    
    public static final a Companion = null;
    private final String desc;

    public static final class a {
        private a() {
        }

        public final ErrorType a(String str) {
            ErrorType[] values = ErrorType.values();
            int length = values.length;
            int i10 = 0;
            while (i10 < length) {
                ErrorType errorType = values[i10];
                i10++;
                if (m.b(errorType.getDesc$bugsnag_android_core_release(), str)) {
                    return errorType;
                }
            }
            return null;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Companion = new a((DefaultConstructorMarker) null);
    }

    private ErrorType(String str) {
        this.desc = str;
    }

    public static final ErrorType fromDescriptor(String str) {
        return Companion.a(str);
    }

    public final String getDesc$bugsnag_android_core_release() {
        return this.desc;
    }
}
