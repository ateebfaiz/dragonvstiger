package com.facebook.react.runtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class d {

    /* renamed from: c  reason: collision with root package name */
    private static final a f3444c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3445a;

    /* renamed from: b  reason: collision with root package name */
    private final List f3446b = Collections.synchronizedList(new ArrayList());

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(boolean z10) {
        this.f3445a = z10;
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        m.f(str, "state");
        z2.a.G("BridgelessReact", str);
        if (this.f3445a) {
            this.f3446b.add(str);
        }
    }
}
