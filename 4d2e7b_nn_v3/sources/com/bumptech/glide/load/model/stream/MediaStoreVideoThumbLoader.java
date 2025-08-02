package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {
    private final Context context;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        private final Context context;

        public Factory(Context context2) {
            this.context = context2;
        }

        @NonNull
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreVideoThumbLoader(this.context);
        }

        public void teardown() {
        }
    }

    public MediaStoreVideoThumbLoader(Context context2) {
        this.context = context2.getApplicationContext();
    }

    private boolean isRequestingDefaultFrame(Options options) {
        Long l10 = (Long) options.get(VideoDecoder.TARGET_FRAME);
        if (l10 == null || l10.longValue() != -1) {
            return false;
        }
        return true;
    }

    @Nullable
    public ModelLoader.LoadData<InputStream> buildLoadData(@NonNull Uri uri, int i10, int i11, @NonNull Options options) {
        if (!MediaStoreUtil.isThumbnailSize(i10, i11) || !isRequestingDefaultFrame(options)) {
            return null;
        }
        return new ModelLoader.LoadData<>(new ObjectKey(uri), ThumbFetcher.buildVideoFetcher(this.context, uri));
    }

    public boolean handles(@NonNull Uri uri) {
        return MediaStoreUtil.isMediaStoreVideoUri(uri);
    }
}
