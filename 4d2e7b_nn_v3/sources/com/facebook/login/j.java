package com.facebook.login;

import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import java.util.Set;
import kotlin.jvm.internal.m;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final AccessToken f20539a;

    /* renamed from: b  reason: collision with root package name */
    private final AuthenticationToken f20540b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f20541c;

    /* renamed from: d  reason: collision with root package name */
    private final Set f20542d;

    public j(AccessToken accessToken, AuthenticationToken authenticationToken, Set set, Set set2) {
        m.f(accessToken, "accessToken");
        m.f(set, "recentlyGrantedPermissions");
        m.f(set2, "recentlyDeniedPermissions");
        this.f20539a = accessToken;
        this.f20540b = authenticationToken;
        this.f20541c = set;
        this.f20542d = set2;
    }

    public final AccessToken a() {
        return this.f20539a;
    }

    public final Set b() {
        return this.f20541c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return m.b(this.f20539a, jVar.f20539a) && m.b(this.f20540b, jVar.f20540b) && m.b(this.f20541c, jVar.f20541c) && m.b(this.f20542d, jVar.f20542d);
    }

    public int hashCode() {
        AccessToken accessToken = this.f20539a;
        int i10 = 0;
        int hashCode = (accessToken != null ? accessToken.hashCode() : 0) * 31;
        AuthenticationToken authenticationToken = this.f20540b;
        int hashCode2 = (hashCode + (authenticationToken != null ? authenticationToken.hashCode() : 0)) * 31;
        Set set = this.f20541c;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Set set2 = this.f20542d;
        if (set2 != null) {
            i10 = set2.hashCode();
        }
        return hashCode3 + i10;
    }

    public String toString() {
        return "LoginResult(accessToken=" + this.f20539a + ", authenticationToken=" + this.f20540b + ", recentlyGrantedPermissions=" + this.f20541c + ", recentlyDeniedPermissions=" + this.f20542d + ")";
    }
}
