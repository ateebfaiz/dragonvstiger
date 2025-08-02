package t0;

import com.airbnb.lottie.k0;
import com.airbnb.lottie.l0;
import n0.c;
import n0.l;
import u0.b;
import y0.f;

public class j implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f23983a;

    /* renamed from: b  reason: collision with root package name */
    private final a f23984b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f23985c;

    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a b(int i10) {
            if (i10 == 1) {
                return MERGE;
            }
            if (i10 == 2) {
                return ADD;
            }
            if (i10 == 3) {
                return SUBTRACT;
            }
            if (i10 == 4) {
                return INTERSECT;
            }
            if (i10 != 5) {
                return MERGE;
            }
            return EXCLUDE_INTERSECTIONS;
        }
    }

    public j(String str, a aVar, boolean z10) {
        this.f23983a = str;
        this.f23984b = aVar;
        this.f23985c = z10;
    }

    public c a(k0 k0Var, com.airbnb.lottie.j jVar, b bVar) {
        if (k0Var.g0(l0.MergePathsApi19)) {
            return new l(this);
        }
        f.c("Animation contains merge paths but they are disabled.");
        return null;
    }

    public a b() {
        return this.f23984b;
    }

    public String c() {
        return this.f23983a;
    }

    public boolean d() {
        return this.f23985c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f23984b + '}';
    }
}
