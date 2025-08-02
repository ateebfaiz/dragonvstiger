package androidx.emoji2.text;

import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmojiCompatInitializer.b f15427a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback f15428b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f15429c;

    public /* synthetic */ f(EmojiCompatInitializer.b bVar, EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
        this.f15427a = bVar;
        this.f15428b = metadataRepoLoaderCallback;
        this.f15429c = threadPoolExecutor;
    }

    public final void run() {
        this.f15427a.c(this.f15428b, this.f15429c);
    }
}
