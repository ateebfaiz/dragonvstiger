package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DecodePath<DataType, ResourceType, Transcode> {
    private static final String TAG = "DecodePath";
    private final Class<DataType> dataClass;
    private final List<? extends ResourceDecoder<DataType, ResourceType>> decoders;
    private final String failureMessage;
    private final Pools.Pool<List<Throwable>> listPool;
    private final ResourceTranscoder<ResourceType, Transcode> transcoder;

    interface DecodeCallback<ResourceType> {
        @NonNull
        Resource<ResourceType> onResourceDecoded(@NonNull Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.dataClass = cls;
        this.decoders = list;
        this.transcoder = resourceTranscoder;
        this.listPool = pool;
        this.failureMessage = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    private Resource<ResourceType> decodeResource(DataRewinder<DataType> dataRewinder, int i10, int i11, @NonNull Options options) throws GlideException {
        List list = (List) Preconditions.checkNotNull(this.listPool.acquire());
        try {
            return decodeResourceWithList(dataRewinder, i10, i11, options, list);
        } finally {
            this.listPool.release(list);
        }
    }

    @NonNull
    private Resource<ResourceType> decodeResourceWithList(DataRewinder<DataType> dataRewinder, int i10, int i11, @NonNull Options options, List<Throwable> list) throws GlideException {
        int size = this.decoders.size();
        Resource<ResourceType> resource = null;
        for (int i12 = 0; i12 < size; i12++) {
            ResourceDecoder resourceDecoder = (ResourceDecoder) this.decoders.get(i12);
            try {
                if (resourceDecoder.handles(dataRewinder.rewindAndGet(), options)) {
                    resource = resourceDecoder.decode(dataRewinder.rewindAndGet(), i10, i11, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e10) {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Failed to decode data for " + resourceDecoder, e10);
                }
                list.add(e10);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.failureMessage, (List<Throwable>) new ArrayList(list));
    }

    public Resource<Transcode> decode(DataRewinder<DataType> dataRewinder, int i10, int i11, @NonNull Options options, DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        return this.transcoder.transcode(decodeCallback.onResourceDecoded(decodeResource(dataRewinder, i10, i11, options)), options);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.dataClass + ", decoders=" + this.decoders + ", transcoder=" + this.transcoder + '}';
    }
}
