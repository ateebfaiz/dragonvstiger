package r2;

import android.net.Uri;
import y2.l;

public class i implements d {

    /* renamed from: a  reason: collision with root package name */
    final String f23654a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f23655b;

    public i(String str) {
        this(str, false);
    }

    public boolean a(Uri uri) {
        return this.f23654a.contains(uri.toString());
    }

    public boolean b() {
        return this.f23655b;
    }

    public String c() {
        return this.f23654a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            return this.f23654a.equals(((i) obj).f23654a);
        }
        return false;
    }

    public int hashCode() {
        return this.f23654a.hashCode();
    }

    public String toString() {
        return this.f23654a;
    }

    public i(String str, boolean z10) {
        this.f23654a = (String) l.g(str);
        this.f23655b = z10;
    }
}
