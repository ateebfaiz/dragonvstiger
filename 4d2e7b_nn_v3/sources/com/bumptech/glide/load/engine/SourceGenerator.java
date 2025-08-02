package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.IOException;
import java.util.List;

class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {
    private static final String TAG = "SourceGenerator";

    /* renamed from: cb  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f19209cb;
    private volatile Object dataToCache;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private volatile int loadDataListIndex;
    private volatile DataCacheKey originalKey;
    private volatile DataCacheGenerator sourceCacheGenerator;

    SourceGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.f19209cb = fetcherReadyCallback;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean cacheData(java.lang.Object r12) throws java.io.IOException {
        /*
            r11 = this;
            java.lang.String r0 = "SourceGenerator"
            long r1 = com.bumptech.glide.util.LogTime.getLogTime()
            r3 = 0
            com.bumptech.glide.load.engine.DecodeHelper<?> r4 = r11.helper     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.data.DataRewinder r4 = r4.getRewinder(r12)     // Catch:{ all -> 0x0072 }
            java.lang.Object r5 = r4.rewindAndGet()     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DecodeHelper<?> r6 = r11.helper     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.Encoder r6 = r6.getSourceEncoder(r5)     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DataCacheWriter r7 = new com.bumptech.glide.load.engine.DataCacheWriter     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DecodeHelper<?> r8 = r11.helper     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.Options r8 = r8.getOptions()     // Catch:{ all -> 0x0072 }
            r7.<init>(r6, r5, r8)     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DataCacheKey r5 = new com.bumptech.glide.load.engine.DataCacheKey     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r8 = r11.loadData     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.Key r8 = r8.sourceKey     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DecodeHelper<?> r9 = r11.helper     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.Key r9 = r9.getSignature()     // Catch:{ all -> 0x0072 }
            r5.<init>(r8, r9)     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DecodeHelper<?> r8 = r11.helper     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.cache.DiskCache r8 = r8.getDiskCache()     // Catch:{ all -> 0x0072 }
            r8.put(r5, r7)     // Catch:{ all -> 0x0072 }
            r7 = 2
            boolean r7 = android.util.Log.isLoggable(r0, r7)     // Catch:{ all -> 0x0072 }
            java.lang.String r9 = ", data: "
            if (r7 == 0) goto L_0x0074
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r7.<init>()     // Catch:{ all -> 0x0072 }
            java.lang.String r10 = "Finished encoding source to cache, key: "
            r7.append(r10)     // Catch:{ all -> 0x0072 }
            r7.append(r5)     // Catch:{ all -> 0x0072 }
            r7.append(r9)     // Catch:{ all -> 0x0072 }
            r7.append(r12)     // Catch:{ all -> 0x0072 }
            java.lang.String r10 = ", encoder: "
            r7.append(r10)     // Catch:{ all -> 0x0072 }
            r7.append(r6)     // Catch:{ all -> 0x0072 }
            java.lang.String r6 = ", duration: "
            r7.append(r6)     // Catch:{ all -> 0x0072 }
            double r1 = com.bumptech.glide.util.LogTime.getElapsedMillis(r1)     // Catch:{ all -> 0x0072 }
            r7.append(r1)     // Catch:{ all -> 0x0072 }
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x0072 }
            android.util.Log.v(r0, r1)     // Catch:{ all -> 0x0072 }
            goto L_0x0074
        L_0x0072:
            r12 = move-exception
            goto L_0x00df
        L_0x0074:
            java.io.File r1 = r8.get(r5)     // Catch:{ all -> 0x0072 }
            r2 = 1
            if (r1 == 0) goto L_0x0096
            r11.originalKey = r5     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DataCacheGenerator r12 = new com.bumptech.glide.load.engine.DataCacheGenerator     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r11.loadData     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.Key r0 = r0.sourceKey     // Catch:{ all -> 0x0072 }
            java.util.List r0 = java.util.Collections.singletonList(r0)     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DecodeHelper<?> r1 = r11.helper     // Catch:{ all -> 0x0072 }
            r12.<init>(r0, r1, r11)     // Catch:{ all -> 0x0072 }
            r11.sourceCacheGenerator = r12     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r12 = r11.loadData
            com.bumptech.glide.load.data.DataFetcher<Data> r12 = r12.fetcher
            r12.cleanup()
            return r2
        L_0x0096:
            r1 = 3
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x0072 }
            if (r1 == 0) goto L_0x00be
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r1.<init>()     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = "Attempt to write: "
            r1.append(r5)     // Catch:{ all -> 0x0072 }
            com.bumptech.glide.load.engine.DataCacheKey r5 = r11.originalKey     // Catch:{ all -> 0x0072 }
            r1.append(r5)     // Catch:{ all -> 0x0072 }
            r1.append(r9)     // Catch:{ all -> 0x0072 }
            r1.append(r12)     // Catch:{ all -> 0x0072 }
            java.lang.String r12 = " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly..."
            r1.append(r12)     // Catch:{ all -> 0x0072 }
            java.lang.String r12 = r1.toString()     // Catch:{ all -> 0x0072 }
            android.util.Log.d(r0, r12)     // Catch:{ all -> 0x0072 }
        L_0x00be:
            com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback r12 = r11.f19209cb     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r11.loadData     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.Key r5 = r0.sourceKey     // Catch:{ all -> 0x00dd }
            java.lang.Object r6 = r4.rewindAndGet()     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r11.loadData     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.data.DataFetcher<Data> r7 = r0.fetcher     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r11.loadData     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.data.DataFetcher<Data> r0 = r0.fetcher     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.DataSource r8 = r0.getDataSource()     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r11.loadData     // Catch:{ all -> 0x00dd }
            com.bumptech.glide.load.Key r9 = r0.sourceKey     // Catch:{ all -> 0x00dd }
            r4 = r12
            r4.onDataFetcherReady(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00dd }
            return r3
        L_0x00dd:
            r12 = move-exception
            r3 = r2
        L_0x00df:
            if (r3 != 0) goto L_0x00e8
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r11.loadData
            com.bumptech.glide.load.data.DataFetcher<Data> r0 = r0.fetcher
            r0.cleanup()
        L_0x00e8:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.SourceGenerator.cacheData(java.lang.Object):boolean");
    }

    private boolean hasNextModelLoader() {
        if (this.loadDataListIndex < this.helper.getLoadData().size()) {
            return true;
        }
        return false;
    }

    private void startNextLoad(final ModelLoader.LoadData<?> loadData2) {
        this.loadData.fetcher.loadData(this.helper.getPriority(), new DataFetcher.DataCallback<Object>() {
            public void onDataReady(@Nullable Object obj) {
                if (SourceGenerator.this.isCurrentRequest(loadData2)) {
                    SourceGenerator.this.onDataReadyInternal(loadData2, obj);
                }
            }

            public void onLoadFailed(@NonNull Exception exc) {
                if (SourceGenerator.this.isCurrentRequest(loadData2)) {
                    SourceGenerator.this.onLoadFailedInternal(loadData2, exc);
                }
            }
        });
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData2 = this.loadData;
        if (loadData2 != null) {
            loadData2.fetcher.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isCurrentRequest(ModelLoader.LoadData<?> loadData2) {
        ModelLoader.LoadData<?> loadData3 = this.loadData;
        if (loadData3 == null || loadData3 != loadData2) {
            return false;
        }
        return true;
    }

    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.f19209cb.onDataFetcherFailed(key, exc, dataFetcher, this.loadData.fetcher.getDataSource());
    }

    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f19209cb.onDataFetcherReady(key, obj, dataFetcher, this.loadData.fetcher.getDataSource(), key);
    }

    /* access modifiers changed from: package-private */
    public void onDataReadyInternal(ModelLoader.LoadData<?> loadData2, Object obj) {
        DiskCacheStrategy diskCacheStrategy = this.helper.getDiskCacheStrategy();
        if (obj == null || !diskCacheStrategy.isDataCacheable(loadData2.fetcher.getDataSource())) {
            DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.f19209cb;
            Key key = loadData2.sourceKey;
            DataFetcher<Data> dataFetcher = loadData2.fetcher;
            fetcherReadyCallback.onDataFetcherReady(key, obj, dataFetcher, dataFetcher.getDataSource(), this.originalKey);
            return;
        }
        this.dataToCache = obj;
        this.f19209cb.reschedule();
    }

    /* access modifiers changed from: package-private */
    public void onLoadFailedInternal(ModelLoader.LoadData<?> loadData2, @NonNull Exception exc) {
        DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.f19209cb;
        DataCacheKey dataCacheKey = this.originalKey;
        DataFetcher<Data> dataFetcher = loadData2.fetcher;
        fetcherReadyCallback.onDataFetcherFailed(dataCacheKey, exc, dataFetcher, dataFetcher.getDataSource());
    }

    public void reschedule() {
        throw new UnsupportedOperationException();
    }

    public boolean startNext() {
        if (this.dataToCache != null) {
            Object obj = this.dataToCache;
            this.dataToCache = null;
            try {
                if (!cacheData(obj)) {
                    return true;
                }
            } catch (IOException e10) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Failed to properly rewind or write data to cache", e10);
                }
            }
        }
        if (this.sourceCacheGenerator != null && this.sourceCacheGenerator.startNext()) {
            return true;
        }
        this.sourceCacheGenerator = null;
        this.loadData = null;
        boolean z10 = false;
        while (!z10 && hasNextModelLoader()) {
            List<ModelLoader.LoadData<?>> loadData2 = this.helper.getLoadData();
            int i10 = this.loadDataListIndex;
            this.loadDataListIndex = i10 + 1;
            this.loadData = loadData2.get(i10);
            if (this.loadData != null && (this.helper.getDiskCacheStrategy().isDataCacheable(this.loadData.fetcher.getDataSource()) || this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()))) {
                startNextLoad(this.loadData);
                z10 = true;
            }
        }
        return z10;
    }
}
