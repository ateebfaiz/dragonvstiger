package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.CancellationSignal;
import android.util.Size;
import com.google.android.gms.common.internal.ImagesContract;
import e5.f;
import e5.n;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;
import y2.g;

public class s0 implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20239a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ContentResolver f20240b;

    class a extends m1 {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ g1 f20241f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ e1 f20242g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ k5.b f20243h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ CancellationSignal f20244i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(n nVar, g1 g1Var, e1 e1Var, String str, g1 g1Var2, e1 e1Var2, k5.b bVar, CancellationSignal cancellationSignal) {
            super(nVar, g1Var, e1Var, str);
            this.f20241f = g1Var2;
            this.f20242g = e1Var2;
            this.f20243h = bVar;
            this.f20244i = cancellationSignal;
        }

        /* access modifiers changed from: protected */
        public void d() {
            super.d();
            this.f20244i.cancel();
        }

        /* access modifiers changed from: protected */
        public void e(Exception exc) {
            super.e(exc);
            this.f20241f.c(this.f20242g, "LocalThumbnailBitmapSdk29Producer", false);
            this.f20242g.k(ImagesContract.LOCAL, "thumbnail_bitmap");
        }

        /* access modifiers changed from: protected */
        /* renamed from: j */
        public void b(c3.a aVar) {
            c3.a.m(aVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: k */
        public Map i(c3.a aVar) {
            boolean z10;
            if (aVar != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            return g.of("createdThumbnail", String.valueOf(z10));
        }

        /* access modifiers changed from: protected */
        /* renamed from: l */
        public c3.a c() {
            String str;
            Bitmap bitmap;
            Size size = new Size(this.f20243h.m(), this.f20243h.l());
            try {
                str = s0.this.e(this.f20243h);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str == null) {
                bitmap = null;
            } else if (a3.a.c(a3.a.b(str))) {
                bitmap = ThumbnailUtils.createVideoThumbnail(new File(str), size, this.f20244i);
            } else {
                bitmap = ThumbnailUtils.createImageThumbnail(new File(str), size, this.f20244i);
            }
            if (bitmap == null) {
                bitmap = s0.this.f20240b.loadThumbnail(this.f20243h.u(), size, this.f20244i);
            }
            if (bitmap == null) {
                return null;
            }
            e5.g a10 = f.a(bitmap, w4.f.a(), n.f21287d, 0);
            this.f20242g.w("image_format", "thumbnail");
            a10.m(this.f20242g.getExtras());
            return c3.a.z(a10);
        }

        /* access modifiers changed from: protected */
        /* renamed from: m */
        public void f(c3.a aVar) {
            boolean z10;
            super.f(aVar);
            g1 g1Var = this.f20241f;
            e1 e1Var = this.f20242g;
            if (aVar != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            g1Var.c(e1Var, "LocalThumbnailBitmapSdk29Producer", z10);
            this.f20242g.k(ImagesContract.LOCAL, "thumbnail_bitmap");
        }
    }

    class b extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m1 f20246a;

        b(m1 m1Var) {
            this.f20246a = m1Var;
        }

        public void a() {
            this.f20246a.a();
        }
    }

    public s0(Executor executor, ContentResolver contentResolver) {
        this.f20239a = executor;
        this.f20240b = contentResolver;
    }

    /* access modifiers changed from: private */
    public String e(k5.b bVar) {
        return g3.f.e(this.f20240b, bVar.u());
    }

    public void b(n nVar, e1 e1Var) {
        g1 z10 = e1Var.z();
        k5.b b10 = e1Var.b();
        e1Var.k(ImagesContract.LOCAL, "thumbnail_bitmap");
        a aVar = new a(nVar, z10, e1Var, "LocalThumbnailBitmapSdk29Producer", z10, e1Var, b10, new CancellationSignal());
        e1Var.h(new b(aVar));
        this.f20239a.execute(aVar);
    }
}
