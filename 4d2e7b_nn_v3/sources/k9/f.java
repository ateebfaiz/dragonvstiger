package k9;

import com.linecorp.linesdk.LineIdToken;
import g9.a;
import java.util.Collections;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final e f12527a;

    /* renamed from: b  reason: collision with root package name */
    private final List f12528b;

    /* renamed from: c  reason: collision with root package name */
    private final LineIdToken f12529c;

    public f(e eVar, List list, LineIdToken lineIdToken) {
        this.f12527a = eVar;
        this.f12528b = Collections.unmodifiableList(list);
        this.f12529c = lineIdToken;
    }

    public e a() {
        return this.f12527a;
    }

    public LineIdToken b() {
        return this.f12529c;
    }

    public List c() {
        return this.f12528b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (!this.f12527a.equals(fVar.f12527a) || !this.f12528b.equals(fVar.f12528b)) {
            return false;
        }
        LineIdToken lineIdToken = this.f12529c;
        LineIdToken lineIdToken2 = fVar.f12529c;
        if (lineIdToken != null) {
            return lineIdToken.equals(lineIdToken2);
        }
        if (lineIdToken2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = ((this.f12527a.hashCode() * 31) + this.f12528b.hashCode()) * 31;
        LineIdToken lineIdToken = this.f12529c;
        if (lineIdToken != null) {
            i10 = lineIdToken.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public String toString() {
        return "IssueAccessTokenResult{accessToken=" + a.b(this.f12527a) + ", scopes=" + this.f12528b + ", idToken=" + this.f12529c + '}';
    }
}
