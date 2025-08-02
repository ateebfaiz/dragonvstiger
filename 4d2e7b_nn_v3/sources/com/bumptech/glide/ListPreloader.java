package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;

public class ListPreloader<T> implements AbsListView.OnScrollListener {
    private boolean isIncreasing = true;
    private int lastEnd;
    private int lastFirstVisible = -1;
    private int lastStart;
    private final int maxPreload;
    private final PreloadSizeProvider<T> preloadDimensionProvider;
    private final PreloadModelProvider<T> preloadModelProvider;
    private final PreloadTargetQueue preloadTargetQueue;
    private final RequestManager requestManager;
    private int totalItemCount;

    public interface PreloadModelProvider<U> {
        @NonNull
        List<U> getPreloadItems(int i10);

        @Nullable
        RequestBuilder<?> getPreloadRequestBuilder(@NonNull U u10);
    }

    public interface PreloadSizeProvider<T> {
        @Nullable
        int[] getPreloadSize(@NonNull T t10, int i10, int i11);
    }

    private static final class PreloadTarget implements Target<Object> {
        int photoHeight;
        int photoWidth;
        @Nullable
        private Request request;

        PreloadTarget() {
        }

        @Nullable
        public Request getRequest() {
            return this.request;
        }

        public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.photoWidth, this.photoHeight);
        }

        public void onDestroy() {
        }

        public void onLoadCleared(@Nullable Drawable drawable) {
        }

        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        public void onLoadStarted(@Nullable Drawable drawable) {
        }

        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        }

        public void setRequest(@Nullable Request request2) {
            this.request = request2;
        }
    }

    private static final class PreloadTargetQueue {
        final Queue<PreloadTarget> queue;

        PreloadTargetQueue(int i10) {
            this.queue = Util.createQueue(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                this.queue.offer(new PreloadTarget());
            }
        }

        public PreloadTarget next(int i10, int i11) {
            PreloadTarget poll = this.queue.poll();
            this.queue.offer(poll);
            poll.photoWidth = i10;
            poll.photoHeight = i11;
            return poll;
        }
    }

    public ListPreloader(@NonNull RequestManager requestManager2, @NonNull PreloadModelProvider<T> preloadModelProvider2, @NonNull PreloadSizeProvider<T> preloadSizeProvider, int i10) {
        this.requestManager = requestManager2;
        this.preloadModelProvider = preloadModelProvider2;
        this.preloadDimensionProvider = preloadSizeProvider;
        this.maxPreload = i10;
        this.preloadTargetQueue = new PreloadTargetQueue(i10 + 1);
    }

    private void cancelAll() {
        for (int i10 = 0; i10 < this.preloadTargetQueue.queue.size(); i10++) {
            this.requestManager.clear((Target<?>) this.preloadTargetQueue.next(0, 0));
        }
    }

    private void preload(int i10, boolean z10) {
        if (this.isIncreasing != z10) {
            this.isIncreasing = z10;
            cancelAll();
        }
        preload(i10, (z10 ? this.maxPreload : -this.maxPreload) + i10);
    }

    private void preloadAdapterPosition(List<T> list, int i10, boolean z10) {
        int size = list.size();
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                preloadItem(list.get(i11), i10, i11);
            }
            return;
        }
        for (int i12 = size - 1; i12 >= 0; i12--) {
            preloadItem(list.get(i12), i10, i12);
        }
    }

    private void preloadItem(@Nullable T t10, int i10, int i11) {
        int[] preloadSize;
        RequestBuilder<?> preloadRequestBuilder;
        if (t10 != null && (preloadSize = this.preloadDimensionProvider.getPreloadSize(t10, i10, i11)) != null && (preloadRequestBuilder = this.preloadModelProvider.getPreloadRequestBuilder(t10)) != null) {
            preloadRequestBuilder.into(this.preloadTargetQueue.next(preloadSize[0], preloadSize[1]));
        }
    }

    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        if (this.totalItemCount != 0 || i12 != 0) {
            this.totalItemCount = i12;
            int i13 = this.lastFirstVisible;
            if (i10 > i13) {
                preload(i11 + i10, true);
            } else if (i10 < i13) {
                preload(i10, false);
            }
            this.lastFirstVisible = i10;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i10) {
    }

    private void preload(int i10, int i11) {
        int i12;
        int i13;
        if (i10 < i11) {
            i12 = Math.max(this.lastEnd, i10);
            i13 = i11;
        } else {
            i13 = Math.min(this.lastStart, i10);
            i12 = i11;
        }
        int min = Math.min(this.totalItemCount, i13);
        int min2 = Math.min(this.totalItemCount, Math.max(0, i12));
        if (i10 < i11) {
            for (int i14 = min2; i14 < min; i14++) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i14), i14, true);
            }
        } else {
            for (int i15 = min - 1; i15 >= min2; i15--) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i15), i15, false);
            }
        }
        this.lastStart = min2;
        this.lastEnd = min;
    }
}
