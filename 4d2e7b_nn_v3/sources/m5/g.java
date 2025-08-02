package m5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import e5.j;
import java.io.OutputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import q4.b;
import q4.c;
import y4.f;

public final class g implements c {

    /* renamed from: d  reason: collision with root package name */
    public static final a f22621d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f22622a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22623b;

    /* renamed from: c  reason: collision with root package name */
    private final String f22624c = "SimpleImageTranscoder";

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final Bitmap.CompressFormat b(c cVar) {
            if (cVar == null) {
                return Bitmap.CompressFormat.JPEG;
            }
            if (cVar == b.f23216b) {
                return Bitmap.CompressFormat.JPEG;
            }
            if (cVar == b.f23217c) {
                return Bitmap.CompressFormat.PNG;
            }
            if (b.a(cVar)) {
                return Bitmap.CompressFormat.WEBP;
            }
            return Bitmap.CompressFormat.JPEG;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g(boolean z10, int i10) {
        this.f22622a = z10;
        this.f22623b = i10;
    }

    private final int e(j jVar, y4.g gVar, f fVar) {
        if (!this.f22622a) {
            return 1;
        }
        return a.b(gVar, fVar, jVar, this.f22623b);
    }

    public boolean a(j jVar, y4.g gVar, f fVar) {
        m.f(jVar, "encodedImage");
        if (gVar == null) {
            gVar = y4.g.f24930c.a();
        }
        if (!this.f22622a || a.b(gVar, fVar, jVar, this.f22623b) <= 1) {
            return false;
        }
        return true;
    }

    public String b() {
        return this.f22624c;
    }

    public b c(j jVar, OutputStream outputStream, y4.g gVar, f fVar, c cVar, Integer num, ColorSpace colorSpace) {
        Integer num2;
        g gVar2;
        y4.g gVar3;
        Bitmap bitmap;
        b bVar;
        j jVar2 = jVar;
        OutputStream outputStream2 = outputStream;
        ColorSpace colorSpace2 = colorSpace;
        m.f(jVar2, "encodedImage");
        m.f(outputStream2, "outputStream");
        if (num == null) {
            num2 = 85;
        } else {
            num2 = num;
        }
        if (gVar == null) {
            gVar3 = y4.g.f24930c.a();
            gVar2 = this;
        } else {
            gVar2 = this;
            gVar3 = gVar;
        }
        int e10 = gVar2.e(jVar2, gVar3, fVar);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = e10;
        if (colorSpace2 != null && Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = colorSpace2;
        }
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(jVar.w(), (Rect) null, options);
            if (decodeStream == null) {
                z2.a.j("SimpleImageTranscoder", "Couldn't decode the EncodedImage InputStream ! ");
                return new b(2);
            }
            Matrix g10 = e.g(jVar2, gVar3);
            if (g10 != null) {
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), g10, false);
                    m.e(createBitmap, "createBitmap(\n          …x,\n                false)");
                    bitmap = createBitmap;
                } catch (OutOfMemoryError e11) {
                    e = e11;
                    bitmap = decodeStream;
                    try {
                        z2.a.k("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                        bVar = new b(2);
                        bitmap.recycle();
                        decodeStream.recycle();
                        return bVar;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bitmap = decodeStream;
                    bitmap.recycle();
                    decodeStream.recycle();
                    throw th;
                }
            } else {
                bitmap = decodeStream;
            }
            try {
                bitmap.compress(f22621d.b(cVar), num2.intValue(), outputStream2);
                int i10 = 1;
                if (e10 > 1) {
                    i10 = 0;
                }
                bVar = new b(i10);
            } catch (OutOfMemoryError e12) {
                e = e12;
                z2.a.k("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                bVar = new b(2);
                bitmap.recycle();
                decodeStream.recycle();
                return bVar;
            }
            bitmap.recycle();
            decodeStream.recycle();
            return bVar;
        } catch (OutOfMemoryError e13) {
            z2.a.k("SimpleImageTranscoder", "Out-Of-Memory during transcode", e13);
            return new b(2);
        }
    }

    public boolean d(c cVar) {
        m.f(cVar, "imageFormat");
        if (cVar == b.f23226l || cVar == b.f23216b) {
            return true;
        }
        return false;
    }
}
