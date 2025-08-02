package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.internal.base.zaq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    /* access modifiers changed from: private */
    public static final Object zaa = new Object();
    /* access modifiers changed from: private */
    public static HashSet<Uri> zab = new HashSet<>();
    private static ImageManager zac;
    /* access modifiers changed from: private */
    public final Context zad;
    /* access modifiers changed from: private */
    public final Handler zae = new zaq(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final ExecutorService zaf = zap.zaa().zab(4, 2);
    /* access modifiers changed from: private */
    public final zak zag = new zak();
    /* access modifiers changed from: private */
    public final Map<zag, ImageReceiver> zah = new HashMap();
    /* access modifiers changed from: private */
    public final Map<Uri, ImageReceiver> zai = new HashMap();
    /* access modifiers changed from: private */
    public final Map<Uri, Long> zaj = new HashMap();

    @KeepName
    private final class ImageReceiver extends ResultReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f6765a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList f6766b = new ArrayList();

        ImageReceiver(Uri uri) {
            super(new zaq(Looper.getMainLooper()));
            this.f6765a = uri;
        }

        public final void b(zag zag) {
            Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
            this.f6766b.add(zag);
        }

        public final void c(zag zag) {
            Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.f6766b.remove(zag);
        }

        public final void d() {
            Intent intent = new Intent(Constants.ACTION_LOAD_IMAGE);
            intent.setPackage("com.google.android.gms");
            intent.putExtra(Constants.EXTRA_URI, this.f6765a);
            intent.putExtra(Constants.EXTRA_RESULT_RECEIVER, this);
            intent.putExtra(Constants.EXTRA_PRIORITY, 3);
            ImageManager.this.zad.sendBroadcast(intent);
        }

        public final void onReceiveResult(int i10, Bundle bundle) {
            ImageManager imageManager = ImageManager.this;
            imageManager.zaf.execute(new a(imageManager, this.f6765a, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(@NonNull Uri uri, @Nullable Drawable drawable, boolean z10);
    }

    private ImageManager(Context context, boolean z10) {
        this.zad = context.getApplicationContext();
    }

    @NonNull
    public static ImageManager create(@NonNull Context context) {
        if (zac == null) {
            zac = new ImageManager(context, false);
        }
        return zac;
    }

    public void loadImage(@NonNull ImageView imageView, int i10) {
        zaj(new zae(imageView, i10));
    }

    public final void zaj(zag zag2) {
        Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
        new b(this, zag2).run();
    }

    public void loadImage(@NonNull ImageView imageView, @NonNull Uri uri) {
        zaj(new zae(imageView, uri));
    }

    public void loadImage(@NonNull ImageView imageView, @NonNull Uri uri, int i10) {
        zae zae2 = new zae(imageView, uri);
        zae2.zab = i10;
        zaj(zae2);
    }

    public void loadImage(@NonNull OnImageLoadedListener onImageLoadedListener, @NonNull Uri uri) {
        zaj(new zaf(onImageLoadedListener, uri));
    }

    public void loadImage(@NonNull OnImageLoadedListener onImageLoadedListener, @NonNull Uri uri, int i10) {
        zaf zaf2 = new zaf(onImageLoadedListener, uri);
        zaf2.zab = i10;
        zaj(zaf2);
    }
}
