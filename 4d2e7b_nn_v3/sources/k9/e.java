package k9;

import g9.a;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f12523a;

    /* renamed from: b  reason: collision with root package name */
    private final long f12524b;

    /* renamed from: c  reason: collision with root package name */
    private final long f12525c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12526d;

    public e(String str, long j10, long j11, String str2) {
        this.f12523a = str;
        this.f12524b = j10;
        this.f12525c = j11;
        this.f12526d = str2;
    }

    public String a() {
        return this.f12523a;
    }

    public long b() {
        return this.f12524b;
    }

    public long c() {
        return this.f12525c;
    }

    public String d() {
        return this.f12526d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f12524b == eVar.f12524b && this.f12525c == eVar.f12525c && this.f12523a.equals(eVar.f12523a)) {
            return this.f12526d.equals(eVar.f12526d);
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f12524b;
        long j11 = this.f12525c;
        return (((((this.f12523a.hashCode() * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.f12526d.hashCode();
    }

    public String toString() {
        return "InternalAccessToken{accessToken='" + a.b(this.f12523a) + '\'' + ", expiresInMillis=" + this.f12524b + ", issuedClientTimeMillis=" + this.f12525c + ", refreshToken='" + a.b(this.f12526d) + '\'' + '}';
    }
}
