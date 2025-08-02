package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.pool.GlideTrace;
import java.io.File;
import java.util.List;

class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private File cacheFile;
    private final List<Key> cacheKeys;

    /* renamed from: cb  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f19203cb;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
    private int sourceIdIndex;
    private Key sourceKey;

    DataCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(decodeHelper.getCacheKeys(), decodeHelper, fetcherReadyCallback);
    }

    private boolean hasNextModelLoader() {
        if (this.modelLoaderIndex < this.modelLoaders.size()) {
            return true;
        }
        return false;
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData2 = this.loadData;
        if (loadData2 != null) {
            loadData2.fetcher.cancel();
        }
    }

    public void onDataReady(Object obj) {
        this.f19203cb.onDataFetcherReady(this.sourceKey, obj, this.loadData.fetcher, DataSource.DATA_DISK_CACHE, this.sourceKey);
    }

    public void onLoadFailed(@NonNull Exception exc) {
        this.f19203cb.onDataFetcherFailed(this.sourceKey, exc, this.loadData.fetcher, DataSource.DATA_DISK_CACHE);
    }

    public boolean startNext() {
        GlideTrace.beginSection("DataCacheGenerator.startNext");
        while (true) {
            try {
                boolean z10 = false;
                if (this.modelLoaders != null) {
                    if (hasNextModelLoader()) {
                        this.loadData = null;
                        while (!z10 && hasNextModelLoader()) {
                            List<ModelLoader<File, ?>> list = this.modelLoaders;
                            int i10 = this.modelLoaderIndex;
                            this.modelLoaderIndex = i10 + 1;
                            this.loadData = list.get(i10).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
                            if (this.loadData != null && this.helper.hasLoadPath(this.loadData.fetcher.getDataClass())) {
                                this.loadData.fetcher.loadData(this.helper.getPriority(), this);
                                z10 = true;
                            }
                        }
                        GlideTrace.endSection();
                        return z10;
                    }
                }
                int i11 = this.sourceIdIndex + 1;
                this.sourceIdIndex = i11;
                if (i11 >= this.cacheKeys.size()) {
                    return false;
                }
                Key key = this.cacheKeys.get(this.sourceIdIndex);
                File file = this.helper.getDiskCache().get(new DataCacheKey(key, this.helper.getSignature()));
                this.cacheFile = file;
                if (file != null) {
                    this.sourceKey = key;
                    this.modelLoaders = this.helper.getModelLoaders(file);
                    this.modelLoaderIndex = 0;
                }
            } finally {
                GlideTrace.endSection();
            }
        }
    }

    DataCacheGenerator(List<Key> list, DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.sourceIdIndex = -1;
        this.cacheKeys = list;
        this.helper = decodeHelper;
        this.f19203cb = fetcherReadyCallback;
    }
}
