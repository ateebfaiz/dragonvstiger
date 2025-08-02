package com.facebook.imagepipeline.nativecode;

import android.graphics.ColorSpace;
import e5.j;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import m5.a;
import m5.b;
import m5.c;
import m5.e;
import y2.d;
import y2.l;
import y4.f;
import y4.g;

@d
public class NativeJpegTranscoder implements c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f19992a;

    /* renamed from: b  reason: collision with root package name */
    private int f19993b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19994c;

    public NativeJpegTranscoder(boolean z10, int i10, boolean z11, boolean z12) {
        this.f19992a = z10;
        this.f19993b = i10;
        this.f19994c = z11;
        if (z12) {
            d.a();
        }
    }

    public static void e(InputStream inputStream, OutputStream outputStream, int i10, int i11, int i12) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        d.a();
        boolean z14 = false;
        if (i11 >= 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        if (i11 <= 16) {
            z11 = true;
        } else {
            z11 = false;
        }
        l.b(Boolean.valueOf(z11));
        if (i12 >= 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        l.b(Boolean.valueOf(z12));
        if (i12 <= 100) {
            z13 = true;
        } else {
            z13 = false;
        }
        l.b(Boolean.valueOf(z13));
        l.b(Boolean.valueOf(e.j(i10)));
        if (!(i11 == 8 && i10 == 0)) {
            z14 = true;
        }
        l.c(z14, "no transformation requested");
        nativeTranscodeJpeg((InputStream) l.g(inputStream), (OutputStream) l.g(outputStream), i10, i11, i12);
    }

    public static void f(InputStream inputStream, OutputStream outputStream, int i10, int i11, int i12) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        d.a();
        boolean z14 = false;
        if (i11 >= 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        if (i11 <= 16) {
            z11 = true;
        } else {
            z11 = false;
        }
        l.b(Boolean.valueOf(z11));
        if (i12 >= 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        l.b(Boolean.valueOf(z12));
        if (i12 <= 100) {
            z13 = true;
        } else {
            z13 = false;
        }
        l.b(Boolean.valueOf(z13));
        l.b(Boolean.valueOf(e.i(i10)));
        if (!(i11 == 8 && i10 == 1)) {
            z14 = true;
        }
        l.c(z14, "no transformation requested");
        nativeTranscodeJpegWithExifOrientation((InputStream) l.g(inputStream), (OutputStream) l.g(outputStream), i10, i11, i12);
    }

    @d
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i10, int i11, int i12) throws IOException;

    @d
    private static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i10, int i11, int i12) throws IOException;

    public boolean a(j jVar, g gVar, f fVar) {
        if (gVar == null) {
            gVar = g.d();
        }
        if (e.f(gVar, fVar, jVar, this.f19992a) < 8) {
            return true;
        }
        return false;
    }

    public String b() {
        return "NativeJpegTranscoder";
    }

    /* JADX INFO: finally extract failed */
    public b c(j jVar, OutputStream outputStream, g gVar, f fVar, q4.c cVar, Integer num, ColorSpace colorSpace) {
        if (num == null) {
            num = 85;
        }
        if (gVar == null) {
            gVar = g.d();
        }
        int b10 = a.b(gVar, fVar, jVar, this.f19993b);
        InputStream inputStream = null;
        try {
            int f10 = e.f(gVar, fVar, jVar, this.f19992a);
            int a10 = e.a(b10);
            if (this.f19994c) {
                f10 = a10;
            }
            inputStream = jVar.w();
            if (e.f22615b.contains(Integer.valueOf(jVar.F()))) {
                f((InputStream) l.h(inputStream, "Cannot transcode from null input stream!"), outputStream, e.d(gVar, jVar), f10, num.intValue());
            } else {
                e((InputStream) l.h(inputStream, "Cannot transcode from null input stream!"), outputStream, e.e(gVar, jVar), f10, num.intValue());
            }
            y2.b.b(inputStream);
            int i10 = 1;
            if (b10 != 1) {
                i10 = 0;
            }
            return new b(i10);
        } catch (Throwable th) {
            y2.b.b(inputStream);
            throw th;
        }
    }

    public boolean d(q4.c cVar) {
        if (cVar == q4.b.f23216b) {
            return true;
        }
        return false;
    }
}
