package i9;

import com.linecorp.linesdk.LineApiError;
import java.util.NoSuchElementException;

public class c {

    /* renamed from: d  reason: collision with root package name */
    private static final c f12347d = new c(d.SUCCESS, (Object) null, LineApiError.f9948c);

    /* renamed from: a  reason: collision with root package name */
    private final d f12348a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f12349b;

    /* renamed from: c  reason: collision with root package name */
    private final LineApiError f12350c;

    private c(d dVar, Object obj, LineApiError lineApiError) {
        this.f12348a = dVar;
        this.f12349b = obj;
        this.f12350c = lineApiError;
    }

    public static c a(d dVar, LineApiError lineApiError) {
        return new c(dVar, (Object) null, lineApiError);
    }

    public static c b(Object obj) {
        if (obj == null) {
            return f12347d;
        }
        return new c(d.SUCCESS, obj, LineApiError.f9948c);
    }

    public LineApiError c() {
        return this.f12350c;
    }

    public d d() {
        return this.f12348a;
    }

    public Object e() {
        Object obj = this.f12349b;
        if (obj != null) {
            return obj;
        }
        throw new NoSuchElementException("response data is null. Please check result by isSuccess before.");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f12348a != cVar.f12348a) {
            return false;
        }
        Object obj2 = this.f12349b;
        if (obj2 == null ? cVar.f12349b == null : obj2.equals(cVar.f12349b)) {
            return this.f12350c.equals(cVar.f12350c);
        }
        return false;
    }

    public boolean f() {
        if (this.f12348a == d.NETWORK_ERROR) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f12348a == d.SUCCESS) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = this.f12348a.hashCode() * 31;
        Object obj = this.f12349b;
        if (obj != null) {
            i10 = obj.hashCode();
        } else {
            i10 = 0;
        }
        return ((hashCode + i10) * 31) + this.f12350c.hashCode();
    }

    public String toString() {
        return "LineApiResponse{errorData=" + this.f12350c + ", responseCode=" + this.f12348a + ", responseData=" + this.f12349b + '}';
    }
}
