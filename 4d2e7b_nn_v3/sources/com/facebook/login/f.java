package com.facebook.login;

import com.google.android.gms.common.Scopes;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class f {

    /* renamed from: d  reason: collision with root package name */
    public static final a f20498d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Set f20499a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20500b;

    /* renamed from: c  reason: collision with root package name */
    private final String f20501c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f(Collection collection) {
        this(collection, (String) null, 2, (DefaultConstructorMarker) null);
    }

    public final String a() {
        return this.f20500b;
    }

    public final Set b() {
        return this.f20499a;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ f(java.util.Collection r1, java.lang.String r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0011
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "UUID.randomUUID().toString()"
            kotlin.jvm.internal.m.e(r2, r3)
        L_0x0011:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.f.<init>(java.util.Collection, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public f(Collection collection, String str) {
        this(collection, str, m.a());
        m.f(str, "nonce");
    }

    public f(Collection collection, String str, String str2) {
        HashSet hashSet;
        m.f(str, "nonce");
        m.f(str2, "codeVerifier");
        if (l.a(str) && m.b(str2)) {
            if (collection == null) {
                hashSet = new HashSet();
            }
            hashSet.add(Scopes.OPEN_ID);
            Set unmodifiableSet = Collections.unmodifiableSet(hashSet);
            m.e(unmodifiableSet, "Collections.unmodifiableSet(permissions)");
            this.f20499a = unmodifiableSet;
            this.f20500b = str;
            this.f20501c = str2;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
