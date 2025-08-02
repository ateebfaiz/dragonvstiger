package d4;

import android.net.Uri;
import r2.d;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private final String f21035a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21036b;

    public a(int i10, boolean z10) {
        this.f21035a = "anim://" + i10;
        this.f21036b = z10;
    }

    public boolean a(Uri uri) {
        return uri.toString().startsWith(this.f21035a);
    }

    public boolean b() {
        return false;
    }

    public String c() {
        return this.f21035a;
    }

    public boolean equals(Object obj) {
        if (!this.f21036b) {
            return super.equals(obj);
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f21035a.equals(((a) obj).f21035a);
    }

    public int hashCode() {
        if (!this.f21036b) {
            return super.hashCode();
        }
        return this.f21035a.hashCode();
    }
}
