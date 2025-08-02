package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class BaseGlideUrlLoader<Model> implements ModelLoader<Model, InputStream> {
    private final ModelLoader<GlideUrl, InputStream> concreteLoader;
    @Nullable
    private final ModelCache<Model, GlideUrl> modelCache;

    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this(modelLoader, (ModelCache) null);
    }

    private static List<Key> getAlternateKeys(Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (String glideUrl : collection) {
            arrayList.add(new GlideUrl(glideUrl));
        }
        return arrayList;
    }

    @Nullable
    public ModelLoader.LoadData<InputStream> buildLoadData(@NonNull Model model, int i10, int i11, @NonNull Options options) {
        GlideUrl glideUrl;
        ModelCache<Model, GlideUrl> modelCache2 = this.modelCache;
        if (modelCache2 != null) {
            glideUrl = modelCache2.get(model, i10, i11);
        } else {
            glideUrl = null;
        }
        if (glideUrl == null) {
            String url = getUrl(model, i10, i11, options);
            if (TextUtils.isEmpty(url)) {
                return null;
            }
            GlideUrl glideUrl2 = new GlideUrl(url, getHeaders(model, i10, i11, options));
            ModelCache<Model, GlideUrl> modelCache3 = this.modelCache;
            if (modelCache3 != null) {
                modelCache3.put(model, i10, i11, glideUrl2);
            }
            glideUrl = glideUrl2;
        }
        List<String> alternateUrls = getAlternateUrls(model, i10, i11, options);
        ModelLoader.LoadData<InputStream> buildLoadData = this.concreteLoader.buildLoadData(glideUrl, i10, i11, options);
        if (buildLoadData == null || alternateUrls.isEmpty()) {
            return buildLoadData;
        }
        return new ModelLoader.LoadData<>(buildLoadData.sourceKey, getAlternateKeys(alternateUrls), buildLoadData.fetcher);
    }

    /* access modifiers changed from: protected */
    public List<String> getAlternateUrls(Model model, int i10, int i11, Options options) {
        return Collections.emptyList();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Headers getHeaders(Model model, int i10, int i11, Options options) {
        return Headers.DEFAULT;
    }

    /* access modifiers changed from: protected */
    public abstract String getUrl(Model model, int i10, int i11, Options options);

    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader, @Nullable ModelCache<Model, GlideUrl> modelCache2) {
        this.concreteLoader = modelLoader;
        this.modelCache = modelCache2;
    }
}
