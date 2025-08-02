package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import b3.h;
import c3.a;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import y2.d;
import y2.l;

@d
@TargetApi(19)
public class KitKatPurgeableDecoder extends DalvikPurgeableDecoder {

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.imagepipeline.memory.d f20004c;

    @d
    public KitKatPurgeableDecoder(com.facebook.imagepipeline.memory.d dVar) {
        this.f20004c = dVar;
    }

    private static void h(byte[] bArr, int i10) {
        bArr[i10] = -1;
        bArr[i10 + 1] = -39;
    }

    /* access modifiers changed from: protected */
    public Bitmap c(a aVar, BitmapFactory.Options options) {
        h hVar = (h) aVar.p();
        int size = hVar.size();
        a a10 = this.f20004c.a(size);
        try {
            byte[] bArr = (byte[]) a10.p();
            hVar.d(0, bArr, 0, size);
            return (Bitmap) l.h(BitmapFactory.decodeByteArray(bArr, 0, size, options), "BitmapFactory returned null");
        } finally {
            a.m(a10);
        }
    }

    /* access modifiers changed from: protected */
    public Bitmap d(a aVar, int i10, BitmapFactory.Options options) {
        byte[] bArr;
        boolean z10;
        if (DalvikPurgeableDecoder.e(aVar, i10)) {
            bArr = null;
        } else {
            bArr = DalvikPurgeableDecoder.f19990b;
        }
        h hVar = (h) aVar.p();
        if (i10 <= hVar.size()) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        int i11 = i10 + 2;
        a a10 = this.f20004c.a(i11);
        try {
            byte[] bArr2 = (byte[]) a10.p();
            hVar.d(0, bArr2, 0, i10);
            if (bArr != null) {
                h(bArr2, i10);
                i10 = i11;
            }
            Bitmap bitmap = (Bitmap) l.h(BitmapFactory.decodeByteArray(bArr2, 0, i10, options), "BitmapFactory returned null");
            a.m(a10);
            return bitmap;
        } catch (Throwable th) {
            a.m(a10);
            throw th;
        }
    }
}
