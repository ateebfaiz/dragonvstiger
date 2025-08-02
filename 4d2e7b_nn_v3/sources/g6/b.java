package g6;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import android.util.SparseArray;
import com.adjust.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

public class b {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f12206c = {"", "_bold", "_italic", "_bold_italic"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f12207d = {".ttf", ".otf"};

    /* renamed from: e  reason: collision with root package name */
    private static b f12208e;

    /* renamed from: a  reason: collision with root package name */
    private final Map f12209a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map f12210b = new HashMap();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private SparseArray f12211a;

        public Typeface a(int i10) {
            return (Typeface) this.f12211a.get(i10);
        }

        public void b(int i10, Typeface typeface) {
            this.f12211a.put(i10, typeface);
        }

        private a() {
            this.f12211a = new SparseArray(4);
        }
    }

    private b() {
    }

    private static Typeface a(String str, int i10, AssetManager assetManager) {
        String str2 = f12206c[i10];
        String[] strArr = f12207d;
        int length = strArr.length;
        int i11 = 0;
        while (i11 < length) {
            String str3 = strArr[i11];
            try {
                return Typeface.createFromAsset(assetManager, "fonts/" + str + str2 + str3);
            } catch (RuntimeException unused) {
                i11++;
            }
        }
        return Typeface.create(str, i10);
    }

    public static b b() {
        if (f12208e == null) {
            f12208e = new b();
        }
        return f12208e;
    }

    public Typeface c(String str, int i10, int i11, AssetManager assetManager) {
        return e(str, new C0138b(i10, i11), assetManager);
    }

    public Typeface d(String str, int i10, AssetManager assetManager) {
        return e(str, new C0138b(i10), assetManager);
    }

    public Typeface e(String str, C0138b bVar, AssetManager assetManager) {
        if (this.f12210b.containsKey(str)) {
            return bVar.a((Typeface) this.f12210b.get(str));
        }
        a aVar = (a) this.f12209a.get(str);
        if (aVar == null) {
            aVar = new a();
            this.f12209a.put(str, aVar);
        }
        int b10 = bVar.b();
        Typeface a10 = aVar.a(b10);
        if (a10 != null) {
            return a10;
        }
        Typeface a11 = a(str, b10, assetManager);
        aVar.b(b10, a11);
        return a11;
    }

    /* renamed from: g6.b$b  reason: collision with other inner class name */
    public static class C0138b {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f12212a;

        /* renamed from: b  reason: collision with root package name */
        private final int f12213b;

        public C0138b(int i10) {
            boolean z10 = false;
            i10 = i10 == -1 ? 0 : i10;
            this.f12212a = (i10 & 2) != 0 ? true : z10;
            this.f12213b = (i10 & 1) != 0 ? 700 : Constants.MINIMAL_ERROR_STATUS_CODE;
        }

        public Typeface a(Typeface typeface) {
            if (Build.VERSION.SDK_INT < 28) {
                return Typeface.create(typeface, b());
            }
            return Typeface.create(typeface, this.f12213b, this.f12212a);
        }

        public int b() {
            if (this.f12213b < 700) {
                if (this.f12212a) {
                    return 2;
                }
                return 0;
            } else if (this.f12212a) {
                return 3;
            } else {
                return 1;
            }
        }

        public C0138b(int i10, int i11) {
            boolean z10 = false;
            i10 = i10 == -1 ? 0 : i10;
            this.f12212a = (i10 & 2) != 0 ? true : z10;
            this.f12213b = i11 == -1 ? (i10 & 1) != 0 ? 700 : Constants.MINIMAL_ERROR_STATUS_CODE : i11;
        }
    }
}
