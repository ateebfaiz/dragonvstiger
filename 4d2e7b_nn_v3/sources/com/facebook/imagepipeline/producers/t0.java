package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.ImagesContract;
import e5.f;
import e5.n;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.concurrent.Executor;
import y2.g;
import y2.l;

public class t0 implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20249a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ContentResolver f20250b;

    class a extends m1 {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ g1 f20251f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ e1 f20252g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ k5.b f20253h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(n nVar, g1 g1Var, e1 e1Var, String str, g1 g1Var2, e1 e1Var2, k5.b bVar) {
            super(nVar, g1Var, e1Var, str);
            this.f20251f = g1Var2;
            this.f20252g = e1Var2;
            this.f20253h = bVar;
        }

        /* access modifiers changed from: protected */
        public void e(Exception exc) {
            super.e(exc);
            this.f20251f.c(this.f20252g, "VideoThumbnailProducer", false);
            this.f20252g.k(ImagesContract.LOCAL, "video");
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
            try {
                str = t0.this.i(this.f20253h);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                bitmap = ThumbnailUtils.createVideoThumbnail(str, t0.g(this.f20253h));
            } else {
                bitmap = null;
            }
            if (bitmap == null) {
                bitmap = t0.h(t0.this.f20250b, this.f20253h.u());
            }
            if (bitmap == null) {
                return null;
            }
            e5.g a10 = f.a(bitmap, w4.f.a(), n.f21287d, 0);
            this.f20252g.w("image_format", "thumbnail");
            a10.m(this.f20252g.getExtras());
            return c3.a.z(a10);
        }

        /* access modifiers changed from: protected */
        /* renamed from: m */
        public void f(c3.a aVar) {
            boolean z10;
            super.f(aVar);
            g1 g1Var = this.f20251f;
            e1 e1Var = this.f20252g;
            if (aVar != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            g1Var.c(e1Var, "VideoThumbnailProducer", z10);
            this.f20252g.k(ImagesContract.LOCAL, "video");
        }
    }

    class b extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m1 f20255a;

        b(m1 m1Var) {
            this.f20255a = m1Var;
        }

        public void a() {
            this.f20255a.a();
        }
    }

    public t0(Executor executor, ContentResolver contentResolver) {
        this.f20249a = executor;
        this.f20250b = contentResolver;
    }

    /* access modifiers changed from: private */
    public static int g(k5.b bVar) {
        if (bVar.m() > 96 || bVar.l() > 96) {
            return 1;
        }
        return 3;
    }

    /* access modifiers changed from: private */
    public static Bitmap h(ContentResolver contentResolver, Uri uri) {
        try {
            ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            l.g(openFileDescriptor);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(openFileDescriptor.getFileDescriptor());
            return mediaMetadataRetriever.getFrameAtTime(-1);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public String i(k5.b bVar) {
        return g3.f.e(this.f20250b, bVar.u());
    }

    public void b(n nVar, e1 e1Var) {
        g1 z10 = e1Var.z();
        k5.b b10 = e1Var.b();
        e1Var.k(ImagesContract.LOCAL, "video");
        a aVar = new a(nVar, z10, e1Var, "VideoThumbnailProducer", z10, e1Var, b10);
        e1Var.h(new b(aVar));
        this.f20249a.execute(aVar);
    }
}
