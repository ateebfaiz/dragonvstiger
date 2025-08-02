package a1;

import android.text.TextUtils;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final String f13608a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13609b;

    public g(String str, String str2) {
        this.f13608a = str;
        this.f13609b = str2;
    }

    public final String a() {
        return this.f13608a;
    }

    public final String b() {
        return this.f13609b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (!TextUtils.equals(this.f13608a, gVar.f13608a) || !TextUtils.equals(this.f13609b, gVar.f13609b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f13608a.hashCode() * 31) + this.f13609b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f13608a + ",value=" + this.f13609b + "]";
    }
}
