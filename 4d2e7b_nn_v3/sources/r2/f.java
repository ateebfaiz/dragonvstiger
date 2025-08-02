package r2;

import android.net.Uri;
import java.util.List;
import y2.l;

public class f implements d {

    /* renamed from: a  reason: collision with root package name */
    final List f23651a;

    public f(List list) {
        this.f23651a = (List) l.g(list);
    }

    public boolean a(Uri uri) {
        for (int i10 = 0; i10 < this.f23651a.size(); i10++) {
            if (((d) this.f23651a.get(i10)).a(uri)) {
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        return false;
    }

    public String c() {
        return ((d) this.f23651a.get(0)).c();
    }

    public List d() {
        return this.f23651a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return this.f23651a.equals(((f) obj).f23651a);
        }
        return false;
    }

    public int hashCode() {
        return this.f23651a.hashCode();
    }

    public String toString() {
        return "MultiCacheKey:" + this.f23651a.toString();
    }
}
