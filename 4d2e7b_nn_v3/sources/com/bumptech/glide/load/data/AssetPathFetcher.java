package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "AssetPathFetcher";
    private final AssetManager assetManager;
    private final String assetPath;
    private T data;

    public AssetPathFetcher(AssetManager assetManager2, String str) {
        this.assetManager = assetManager2;
        this.assetPath = str;
    }

    public void cancel() {
    }

    public void cleanup() {
        T t10 = this.data;
        if (t10 != null) {
            try {
                close(t10);
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void close(T t10) throws IOException;

    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T loadResource = loadResource(this.assetManager, this.assetPath);
            this.data = loadResource;
            dataCallback.onDataReady(loadResource);
        } catch (IOException e10) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to load data from asset manager", e10);
            }
            dataCallback.onLoadFailed(e10);
        }
    }

    /* access modifiers changed from: protected */
    public abstract T loadResource(AssetManager assetManager2, String str) throws IOException;
}
