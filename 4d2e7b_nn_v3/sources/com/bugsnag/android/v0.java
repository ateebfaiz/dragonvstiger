package com.bugsnag.android;

import kotlin.jvm.internal.DefaultConstructorMarker;

public enum v0 {
    DELIVERED,
    UNDELIVERED,
    FAILURE;
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f19030a = null;

    public static final class a {
        private a() {
        }

        public final v0 a(int i10) {
            if (200 <= i10 && i10 < 300) {
                return v0.DELIVERED;
            }
            if (400 > i10 || i10 >= 500 || i10 == 408 || i10 == 429) {
                return v0.UNDELIVERED;
            }
            return v0.FAILURE;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        f19030a = new a((DefaultConstructorMarker) null);
    }
}
