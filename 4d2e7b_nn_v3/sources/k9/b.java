package k9;

import java.util.Collections;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f12515a;

    /* renamed from: b  reason: collision with root package name */
    private final long f12516b;

    /* renamed from: c  reason: collision with root package name */
    private final List f12517c;

    public b(String str, long j10, List list) {
        this.f12515a = str;
        this.f12516b = j10;
        this.f12517c = Collections.unmodifiableList(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f12516b == bVar.f12516b && this.f12515a.equals(bVar.f12515a)) {
            return this.f12517c.equals(bVar.f12517c);
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f12516b;
        return (((this.f12515a.hashCode() * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.f12517c.hashCode();
    }

    public String toString() {
        return "AccessTokenVerificationResult{channelId='" + this.f12515a + '\'' + ", expiresInMillis=" + this.f12516b + ", scopes=" + this.f12517c + '}';
    }
}
