package w4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import b3.h;
import com.facebook.imagepipeline.memory.d;
import e5.j;
import h5.e0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import q4.b;

public final class c implements h3.a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f24609c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final b f24610a;

    /* renamed from: b  reason: collision with root package name */
    private final d f24611b;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final BitmapFactory.Options b(int i10, Bitmap.Config config) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDither = true;
            options.inPreferredConfig = config;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inSampleSize = i10;
            options.inMutable = true;
            return options;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(e0 e0Var) {
        m.f(e0Var, "poolFactory");
        this.f24610a = new b(e0Var.h());
        d d10 = e0Var.d();
        m.e(d10, "poolFactory.flexByteArrayPool");
        this.f24611b = d10;
    }

    public Bitmap a(int i10, int i11, Bitmap.Config config) {
        j jVar;
        m.f(config, "bitmapConfig");
        c3.a a10 = this.f24610a.a((short) i10, (short) i11);
        m.e(a10, "jpegGenerator.generate(w…hort(), height.toShort())");
        c3.a aVar = null;
        try {
            jVar = new j(a10);
            try {
                jVar.R(b.f23216b);
                BitmapFactory.Options a11 = f24609c.b(jVar.z(), config);
                int size = ((h) a10.p()).size();
                Object p10 = a10.p();
                m.e(p10, "jpgRef.get()");
                aVar = this.f24611b.a(size + 2);
                Object p11 = aVar.p();
                m.e(p11, "encodedBytesArrayRef.get()");
                byte[] bArr = (byte[]) p11;
                ((h) p10).d(0, bArr, 0, size);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, size, a11);
                if (decodeByteArray != null) {
                    decodeByteArray.setHasAlpha(true);
                    decodeByteArray.eraseColor(0);
                    c3.a.m(aVar);
                    j.h(jVar);
                    c3.a.m(a10);
                    return decodeByteArray;
                }
                throw new IllegalStateException("Required value was null.".toString());
            } catch (Throwable th) {
                th = th;
                c3.a.m(aVar);
                j.h(jVar);
                c3.a.m(a10);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            jVar = null;
            c3.a.m(aVar);
            j.h(jVar);
            c3.a.m(a10);
            throw th;
        }
    }
}
