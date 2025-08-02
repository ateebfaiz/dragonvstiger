package x4;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import r2.d;
import y4.c;
import y4.f;
import y4.g;

public final class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private final String f24758a;

    /* renamed from: b  reason: collision with root package name */
    private final f f24759b;

    /* renamed from: c  reason: collision with root package name */
    private final g f24760c;

    /* renamed from: d  reason: collision with root package name */
    private final c f24761d;

    /* renamed from: e  reason: collision with root package name */
    private final d f24762e;

    /* renamed from: f  reason: collision with root package name */
    private final String f24763f;

    /* renamed from: g  reason: collision with root package name */
    private Object f24764g;

    /* renamed from: h  reason: collision with root package name */
    private final int f24765h;

    /* renamed from: i  reason: collision with root package name */
    private final long f24766i;

    public b(String str, f fVar, g gVar, c cVar, d dVar, String str2) {
        int i10;
        int i11;
        m.f(str, "sourceString");
        m.f(gVar, "rotationOptions");
        m.f(cVar, "imageDecodeOptions");
        this.f24758a = str;
        this.f24759b = fVar;
        this.f24760c = gVar;
        this.f24761d = cVar;
        this.f24762e = dVar;
        this.f24763f = str2;
        int hashCode = str.hashCode() * 31;
        int i12 = 0;
        if (fVar != null) {
            i10 = fVar.hashCode();
        } else {
            i10 = 0;
        }
        int hashCode2 = (((((hashCode + i10) * 31) + gVar.hashCode()) * 31) + cVar.hashCode()) * 31;
        if (dVar != null) {
            i11 = dVar.hashCode();
        } else {
            i11 = 0;
        }
        this.f24765h = ((hashCode2 + i11) * 31) + (str2 != null ? str2.hashCode() : i12);
        this.f24766i = RealtimeSinceBootClock.get().now();
    }

    public boolean a(Uri uri) {
        m.f(uri, "uri");
        String c10 = c();
        String uri2 = uri.toString();
        m.e(uri2, "uri.toString()");
        return j.K(c10, uri2, false, 2, (Object) null);
    }

    public boolean b() {
        return false;
    }

    public String c() {
        return this.f24758a;
    }

    public final void d(Object obj) {
        this.f24764g = obj;
    }

    public boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!m.b(b.class, cls)) {
            return false;
        }
        m.d(obj, "null cannot be cast to non-null type com.facebook.imagepipeline.cache.BitmapMemoryCacheKey");
        b bVar = (b) obj;
        if (!m.b(this.f24758a, bVar.f24758a) || !m.b(this.f24759b, bVar.f24759b) || !m.b(this.f24760c, bVar.f24760c) || !m.b(this.f24761d, bVar.f24761d) || !m.b(this.f24762e, bVar.f24762e) || !m.b(this.f24763f, bVar.f24763f)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f24765h;
    }

    public String toString() {
        String str = this.f24758a;
        f fVar = this.f24759b;
        g gVar = this.f24760c;
        c cVar = this.f24761d;
        d dVar = this.f24762e;
        String str2 = this.f24763f;
        return "BitmapMemoryCacheKey(sourceString=" + str + ", resizeOptions=" + fVar + ", rotationOptions=" + gVar + ", imageDecodeOptions=" + cVar + ", postprocessorCacheKey=" + dVar + ", postprocessorName=" + str2 + ")";
    }
}
