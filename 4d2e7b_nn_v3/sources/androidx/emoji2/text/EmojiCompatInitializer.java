package androidx.emoji2.text;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.d;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class EmojiCompatInitializer implements Initializer<Boolean> {
    private static final long STARTUP_THREAD_CREATION_DELAY_MS = 500;
    private static final String S_INITIALIZER_THREAD_NAME = "EmojiCompatInitializer";

    static class a extends EmojiCompat.Config {
        protected a(Context context) {
            super(new b(context));
            setMetadataLoadStrategy(1);
        }
    }

    static class b implements EmojiCompat.MetadataRepoLoader {

        /* renamed from: a  reason: collision with root package name */
        private final Context f15403a;

        class a extends EmojiCompat.MetadataRepoLoaderCallback {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback f15404a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ThreadPoolExecutor f15405b;

            a(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
                this.f15404a = metadataRepoLoaderCallback;
                this.f15405b = threadPoolExecutor;
            }

            public void onFailed(Throwable th) {
                try {
                    this.f15404a.onFailed(th);
                } finally {
                    this.f15405b.shutdown();
                }
            }

            public void onLoaded(MetadataRepo metadataRepo) {
                try {
                    this.f15404a.onLoaded(metadataRepo);
                } finally {
                    this.f15405b.shutdown();
                }
            }
        }

        b(Context context) {
            this.f15403a = context.getApplicationContext();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void c(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
            try {
                FontRequestEmojiCompatConfig create = DefaultEmojiCompatConfig.create(this.f15403a);
                if (create != null) {
                    create.setLoadingExecutor(threadPoolExecutor);
                    create.getMetadataRepoLoader().load(new a(metadataRepoLoaderCallback, threadPoolExecutor));
                    return;
                }
                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            } catch (Throwable th) {
                metadataRepoLoaderCallback.onFailed(th);
                threadPoolExecutor.shutdown();
            }
        }

        public void load(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            ThreadPoolExecutor c10 = d.c(EmojiCompatInitializer.S_INITIALIZER_THREAD_NAME);
            c10.execute(new f(this, metadataRepoLoaderCallback, c10));
        }
    }

    static class c implements Runnable {
        c() {
        }

        public void run() {
            try {
                TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.isConfigured()) {
                    EmojiCompat.get().load();
                }
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(19)
    public void delayUntilFirstResume(@NonNull Context context) {
        final Lifecycle lifecycle = ((LifecycleOwner) AppInitializer.getInstance(context).initializeComponent(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.addObserver(new DefaultLifecycleObserver() {
            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                d.a(this, lifecycleOwner);
            }

            public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
                d.b(this, lifecycleOwner);
            }

            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                d.c(this, lifecycleOwner);
            }

            public void onResume(LifecycleOwner lifecycleOwner) {
                EmojiCompatInitializer.this.loadEmojiCompatAfterDelay();
                lifecycle.removeObserver(this);
            }

            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                d.e(this, lifecycleOwner);
            }

            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                d.f(this, lifecycleOwner);
            }
        });
    }

    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(19)
    public void loadEmojiCompatAfterDelay() {
        d.e().postDelayed(new c(), STARTUP_THREAD_CREATION_DELAY_MS);
    }

    @NonNull
    public Boolean create(@NonNull Context context) {
        EmojiCompat.init((EmojiCompat.Config) new a(context));
        delayUntilFirstResume(context);
        return Boolean.TRUE;
    }
}
