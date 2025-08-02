package r0;

import androidx.webkit.ProxyConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e {

    /* renamed from: c  reason: collision with root package name */
    public static final e f23623c = new e("COMPOSITION");

    /* renamed from: a  reason: collision with root package name */
    private final List f23624a;

    /* renamed from: b  reason: collision with root package name */
    private f f23625b;

    public e(String... strArr) {
        this.f23624a = Arrays.asList(strArr);
    }

    private boolean b() {
        List list = this.f23624a;
        return ((String) list.get(list.size() - 1)).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    public e a(String str) {
        e eVar = new e(this);
        eVar.f23624a.add(str);
        return eVar;
    }

    public boolean c(String str, int i10) {
        boolean z10;
        boolean z11;
        if (i10 >= this.f23624a.size()) {
            return false;
        }
        if (i10 == this.f23624a.size() - 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        String str2 = (String) this.f23624a.get(i10);
        if (!str2.equals("**")) {
            if (str2.equals(str) || str2.equals(ProxyConfig.MATCH_ALL_SCHEMES)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((z10 || (i10 == this.f23624a.size() - 2 && b())) && z11) {
                return true;
            }
            return false;
        } else if (z10 || !((String) this.f23624a.get(i10 + 1)).equals(str)) {
            if (z10) {
                return true;
            }
            int i11 = i10 + 1;
            if (i11 < this.f23624a.size() - 1) {
                return false;
            }
            return ((String) this.f23624a.get(i11)).equals(str);
        } else if (i10 == this.f23624a.size() - 2 || (i10 == this.f23624a.size() - 3 && b())) {
            return true;
        } else {
            return false;
        }
    }

    public f d() {
        return this.f23625b;
    }

    public int e(String str, int i10) {
        if (f(str)) {
            return 0;
        }
        if (!((String) this.f23624a.get(i10)).equals("**")) {
            return 1;
        }
        if (i10 != this.f23624a.size() - 1 && ((String) this.f23624a.get(i10 + 1)).equals(str)) {
            return 2;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.f23624a.equals(eVar.f23624a)) {
            return false;
        }
        f fVar = this.f23625b;
        f fVar2 = eVar.f23625b;
        if (fVar != null) {
            return fVar.equals(fVar2);
        }
        if (fVar2 == null) {
            return true;
        }
        return false;
    }

    public boolean g(String str, int i10) {
        if (f(str)) {
            return true;
        }
        if (i10 >= this.f23624a.size()) {
            return false;
        }
        if (((String) this.f23624a.get(i10)).equals(str) || ((String) this.f23624a.get(i10)).equals("**") || ((String) this.f23624a.get(i10)).equals(ProxyConfig.MATCH_ALL_SCHEMES)) {
            return true;
        }
        return false;
    }

    public boolean h(String str, int i10) {
        if (!"__container".equals(str) && i10 >= this.f23624a.size() - 1 && !((String) this.f23624a.get(i10)).equals("**")) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        int hashCode = this.f23624a.hashCode() * 31;
        f fVar = this.f23625b;
        if (fVar != null) {
            i10 = fVar.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public e i(f fVar) {
        e eVar = new e(this);
        eVar.f23625b = fVar;
        return eVar;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("KeyPath{keys=");
        sb2.append(this.f23624a);
        sb2.append(",resolved=");
        if (this.f23625b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        sb2.append(z10);
        sb2.append('}');
        return sb2.toString();
    }

    private e(e eVar) {
        this.f23624a = new ArrayList(eVar.f23624a);
        this.f23625b = eVar.f23625b;
    }
}
