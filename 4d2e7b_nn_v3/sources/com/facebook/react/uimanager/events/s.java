package com.facebook.react.uimanager.events;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public enum s {
    START("topTouchStart"),
    END("topTouchEnd"),
    MOVE("topTouchMove"),
    CANCEL("topTouchCancel");
    

    /* renamed from: b  reason: collision with root package name */
    public static final a f3659b = null;

    /* renamed from: a  reason: collision with root package name */
    private final String f3666a;

    public static final class a {
        private a() {
        }

        public final String a(s sVar) {
            m.f(sVar, "type");
            return sVar.c();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        s[] a10;
        f3665h = pb.a.a(a10);
        f3659b = new a((DefaultConstructorMarker) null);
    }

    private s(String str) {
        this.f3666a = str;
    }

    public static final String b(s sVar) {
        return f3659b.a(sVar);
    }

    public final String c() {
        return this.f3666a;
    }
}
