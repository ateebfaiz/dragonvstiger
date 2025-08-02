package k9;

import g9.a;
import java.util.List;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final String f12562a;

    /* renamed from: b  reason: collision with root package name */
    private final long f12563b;

    /* renamed from: c  reason: collision with root package name */
    private final String f12564c;

    /* renamed from: d  reason: collision with root package name */
    private final List f12565d;

    public j(String str, long j10, String str2, List list) {
        this.f12562a = str;
        this.f12563b = j10;
        this.f12564c = str2;
        this.f12565d = list;
    }

    public String a() {
        return this.f12562a;
    }

    public long b() {
        return this.f12563b;
    }

    public String c() {
        return this.f12564c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f12563b == jVar.f12563b && this.f12562a.equals(jVar.f12562a) && this.f12564c.equals(jVar.f12564c)) {
            return this.f12565d.equals(jVar.f12565d);
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f12563b;
        return (((((this.f12562a.hashCode() * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.f12564c.hashCode()) * 31) + this.f12565d.hashCode();
    }

    public String toString() {
        return "RefreshTokenResult{accessToken='" + a.b(this.f12562a) + '\'' + ", expiresInMillis=" + this.f12563b + ", refreshToken='" + a.b(this.f12564c) + '\'' + ", scopes=" + this.f12565d + '}';
    }
}
