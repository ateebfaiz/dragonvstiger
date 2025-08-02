package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.util.Pair;
import b3.h;
import b3.i;
import com.facebook.soloader.f;
import com.google.android.gms.common.internal.ImagesContract;
import e5.j;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import o5.e;
import y2.g;
import y2.l;

public class LocalExifThumbnailProducer implements u1 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20005a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final i f20006b;

    /* renamed from: c  reason: collision with root package name */
    private final ContentResolver f20007c;

    @f
    private class Api24Utils {
        /* access modifiers changed from: package-private */
        public ExifInterface a(FileDescriptor fileDescriptor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return k0.a(fileDescriptor);
            }
            return null;
        }

        private Api24Utils() {
        }
    }

    class a extends m1 {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ k5.b f20009f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(n nVar, g1 g1Var, e1 e1Var, String str, k5.b bVar) {
            super(nVar, g1Var, e1Var, str);
            this.f20009f = bVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: j */
        public void b(j jVar) {
            j.h(jVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: k */
        public Map i(j jVar) {
            boolean z10;
            if (jVar != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            return g.of("createdThumbnail", Boolean.toString(z10));
        }

        /* access modifiers changed from: protected */
        /* renamed from: l */
        public j c() {
            ExifInterface g10 = LocalExifThumbnailProducer.this.g(this.f20009f.u());
            if (g10 == null || !g10.hasThumbnail()) {
                return null;
            }
            return LocalExifThumbnailProducer.this.e(LocalExifThumbnailProducer.this.f20006b.b((byte[]) l.g(g10.getThumbnail())), g10);
        }
    }

    class b extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m1 f20011a;

        b(m1 m1Var) {
            this.f20011a = m1Var;
        }

        public void a() {
            this.f20011a.a();
        }
    }

    public LocalExifThumbnailProducer(Executor executor, i iVar, ContentResolver contentResolver) {
        this.f20005a = executor;
        this.f20006b = iVar;
        this.f20007c = contentResolver;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public j e(h hVar, ExifInterface exifInterface) {
        int i10;
        Pair b10 = o5.a.b(new b3.j(hVar));
        int h10 = h(exifInterface);
        int i11 = -1;
        if (b10 != null) {
            i10 = ((Integer) b10.first).intValue();
        } else {
            i10 = -1;
        }
        if (b10 != null) {
            i11 = ((Integer) b10.second).intValue();
        }
        c3.a z10 = c3.a.z(hVar);
        try {
            j jVar = new j(z10);
            c3.a.m(z10);
            jVar.R(q4.b.f23216b);
            jVar.S(h10);
            jVar.V(i10);
            jVar.Q(i11);
            return jVar;
        } catch (Throwable th) {
            c3.a.m(z10);
            throw th;
        }
    }

    private int h(ExifInterface exifInterface) {
        return e.a(Integer.parseInt((String) l.g(exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION))));
    }

    public boolean a(y4.f fVar) {
        return v1.b(512, 512, fVar);
    }

    public void b(n nVar, e1 e1Var) {
        g1 z10 = e1Var.z();
        k5.b b10 = e1Var.b();
        e1Var.k(ImagesContract.LOCAL, "exif");
        a aVar = new a(nVar, z10, e1Var, "LocalExifThumbnailProducer", b10);
        e1Var.h(new b(aVar));
        this.f20005a.execute(aVar);
    }

    /* access modifiers changed from: package-private */
    public boolean f(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public ExifInterface g(Uri uri) {
        String e10 = g3.f.e(this.f20007c, uri);
        if (e10 == null) {
            return null;
        }
        try {
            if (f(e10)) {
                return new ExifInterface(e10);
            }
            AssetFileDescriptor a10 = g3.f.a(this.f20007c, uri);
            if (a10 != null && Build.VERSION.SDK_INT >= 24) {
                ExifInterface a11 = new Api24Utils().a(a10.getFileDescriptor());
                a10.close();
                return a11;
            }
            return null;
        } catch (IOException unused) {
        } catch (StackOverflowError unused2) {
            z2.a.f(LocalExifThumbnailProducer.class, "StackOverflowError in ExifInterface constructor");
        }
    }
}
