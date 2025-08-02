package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f6773a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f6774b;

    /* renamed from: c  reason: collision with root package name */
    private final CountDownLatch f6775c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ ImageManager f6776d;

    public c(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z10, CountDownLatch countDownLatch) {
        this.f6776d = imageManager;
        this.f6773a = uri;
        this.f6774b = bitmap;
        this.f6775c = countDownLatch;
    }

    public final void run() {
        Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
        Bitmap bitmap = this.f6774b;
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.f6776d.zai.remove(this.f6773a);
        if (imageReceiver != null) {
            ArrayList a10 = imageReceiver.f6766b;
            int size = a10.size();
            for (int i10 = 0; i10 < size; i10++) {
                zag zag = (zag) a10.get(i10);
                Bitmap bitmap2 = this.f6774b;
                if (bitmap2 == null || bitmap == null) {
                    this.f6776d.zaj.put(this.f6773a, Long.valueOf(SystemClock.elapsedRealtime()));
                    ImageManager imageManager = this.f6776d;
                    zag.zab(imageManager.zad, imageManager.zag, false);
                } else {
                    zag.zac(this.f6776d.zad, bitmap2, false);
                }
                if (!(zag instanceof zaf)) {
                    this.f6776d.zah.remove(zag);
                }
            }
        }
        this.f6775c.countDown();
        synchronized (ImageManager.zaa) {
            ImageManager.zab.remove(this.f6773a);
        }
    }
}
