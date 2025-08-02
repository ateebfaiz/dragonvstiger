package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;

final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final zag f6771a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ImageManager f6772b;

    public b(ImageManager imageManager, zag zag) {
        this.f6772b = imageManager;
        this.f6771a = zag;
    }

    public final void run() {
        Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.f6772b.zah.get(this.f6771a);
        if (imageReceiver != null) {
            this.f6772b.zah.remove(this.f6771a);
            imageReceiver.c(this.f6771a);
        }
        zag zag = this.f6771a;
        d dVar = zag.zaa;
        Uri uri = dVar.f6777a;
        if (uri != null) {
            Long l10 = (Long) this.f6772b.zaj.get(uri);
            if (l10 != null) {
                if (SystemClock.elapsedRealtime() - l10.longValue() < 3600000) {
                    zag zag2 = this.f6771a;
                    ImageManager imageManager = this.f6772b;
                    zag2.zab(imageManager.zad, imageManager.zag, true);
                    return;
                }
                this.f6772b.zaj.remove(dVar.f6777a);
            }
            this.f6771a.zaa((Drawable) null, false, true, false);
            ImageManager.ImageReceiver imageReceiver2 = (ImageManager.ImageReceiver) this.f6772b.zai.get(dVar.f6777a);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageManager.ImageReceiver(dVar.f6777a);
                this.f6772b.zai.put(dVar.f6777a, imageReceiver2);
            }
            imageReceiver2.b(this.f6771a);
            zag zag3 = this.f6771a;
            if (!(zag3 instanceof zaf)) {
                this.f6772b.zah.put(zag3, imageReceiver2);
            }
            synchronized (ImageManager.zaa) {
                try {
                    if (!ImageManager.zab.contains(dVar.f6777a)) {
                        ImageManager.zab.add(dVar.f6777a);
                        imageReceiver2.d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        ImageManager imageManager2 = this.f6772b;
        zag.zab(imageManager2.zad, imageManager2.zag, true);
    }
}
