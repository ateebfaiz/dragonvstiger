package j8;

import com.fasterxml.jackson.core.f;
import j8.d;

public class c extends d.c {

    /* renamed from: e  reason: collision with root package name */
    public static final String f12401e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f12402f;

    /* renamed from: b  reason: collision with root package name */
    private final char[] f12403b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12404c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12405d;

    static {
        String str;
        try {
            str = System.getProperty("line.separator");
        } catch (Throwable unused) {
            str = "\n";
        }
        f12401e = str;
        f12402f = new c("  ", str);
    }

    public c(String str, String str2) {
        this.f12404c = str.length();
        this.f12403b = new char[(str.length() * 16)];
        int i10 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            str.getChars(0, str.length(), this.f12403b, i10);
            i10 += str.length();
        }
        this.f12405d = str2;
    }

    public void a(f fVar, int i10) {
        fVar.i0(this.f12405d);
        if (i10 > 0) {
            int i11 = i10 * this.f12404c;
            while (true) {
                char[] cArr = this.f12403b;
                if (i11 > cArr.length) {
                    fVar.j0(cArr, 0, cArr.length);
                    i11 -= this.f12403b.length;
                } else {
                    fVar.j0(cArr, 0, i11);
                    return;
                }
            }
        }
    }

    public boolean isInline() {
        return false;
    }
}
