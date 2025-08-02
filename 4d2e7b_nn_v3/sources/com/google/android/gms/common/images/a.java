package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f6768a;

    /* renamed from: b  reason: collision with root package name */
    private final ParcelFileDescriptor f6769b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ImageManager f6770c;

    public a(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.f6770c = imageManager;
        this.f6768a = uri;
        this.f6769b = parcelFileDescriptor;
    }

    public final void run() {
        Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor = this.f6769b;
        Bitmap bitmap = null;
        boolean z10 = false;
        if (parcelFileDescriptor != null) {
            try {
                bitmap = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError e10) {
                Log.e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(this.f6768a)), e10);
                z10 = true;
            }
            try {
                this.f6769b.close();
            } catch (IOException e11) {
                Log.e("ImageManager", "closed failed", e11);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager imageManager = this.f6770c;
        imageManager.zae.post(new c(imageManager, this.f6768a, bitmap, z10, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(this.f6768a)));
        }
    }
}
