package com.facebook.login;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public enum k {
    FACEBOOK("facebook"),
    INSTAGRAM("instagram");
    

    /* renamed from: e  reason: collision with root package name */
    public static final a f20546e = null;

    /* renamed from: a  reason: collision with root package name */
    private final String f20547a;

    public static final class a {
        private a() {
        }

        public final k a(String str) {
            for (k kVar : k.values()) {
                if (m.b(kVar.toString(), str)) {
                    return kVar;
                }
            }
            return k.FACEBOOK;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        f20546e = new a((DefaultConstructorMarker) null);
    }

    private k(String str) {
        this.f20547a = str;
    }

    public String toString() {
        return this.f20547a;
    }
}
