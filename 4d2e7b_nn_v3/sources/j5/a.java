package j5;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import java.util.Locale;
import r2.d;
import r2.i;
import y2.l;

public class a extends k5.a {

    /* renamed from: c  reason: collision with root package name */
    private final int f22222c;

    /* renamed from: d  reason: collision with root package name */
    private final int f22223d;

    /* renamed from: e  reason: collision with root package name */
    private d f22224e;

    public a(int i10, int i11) {
        boolean z10;
        boolean z11 = false;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        l.b(Boolean.valueOf(i11 > 0 ? true : z11));
        this.f22222c = i10;
        this.f22223d = i11;
    }

    public d b() {
        if (this.f22224e == null) {
            this.f22224e = new i(String.format((Locale) null, "i%dr%d", new Object[]{Integer.valueOf(this.f22222c), Integer.valueOf(this.f22223d)}));
        }
        return this.f22224e;
    }

    public void d(Bitmap bitmap) {
        NativeBlurFilter.a(bitmap, this.f22222c, this.f22223d);
    }
}
