package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    private static final FontProviderHelper DEFAULT_FONTS_CONTRACT = new FontProviderHelper();

    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {
        private long mRetryOrigin;
        private final long mTotalMs;

        public ExponentialBackoffRetryPolicy(long j10) {
            this.mTotalMs = j10;
        }

        public long getRetryDelay() {
            if (this.mRetryOrigin == 0) {
                this.mRetryOrigin = SystemClock.uptimeMillis();
                return 0;
            }
            long uptimeMillis = SystemClock.uptimeMillis() - this.mRetryOrigin;
            if (uptimeMillis > this.mTotalMs) {
                return -1;
            }
            return Math.min(Math.max(uptimeMillis, 1000), this.mTotalMs - uptimeMillis);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class FontProviderHelper {
        @Nullable
        public Typeface buildTypeface(@NonNull Context context, @NonNull FontsContractCompat.FontInfo fontInfo) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.buildTypeface(context, (CancellationSignal) null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        @NonNull
        public FontsContractCompat.FontFamilyResult fetchFonts(@NonNull Context context, @NonNull FontRequest fontRequest) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.fetchFonts(context, (CancellationSignal) null, fontRequest);
        }

        public void registerObserver(@NonNull Context context, @NonNull Uri uri, @NonNull ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void unregisterObserver(@NonNull Context context, @NonNull ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    public static abstract class RetryPolicy {
        public abstract long getRetryDelay();
    }

    private static class a implements EmojiCompat.MetadataRepoLoader {

        /* renamed from: a  reason: collision with root package name */
        private final Context f15407a;

        /* renamed from: b  reason: collision with root package name */
        private final FontRequest f15408b;

        /* renamed from: c  reason: collision with root package name */
        private final FontProviderHelper f15409c;

        /* renamed from: d  reason: collision with root package name */
        private final Object f15410d = new Object();

        /* renamed from: e  reason: collision with root package name */
        private Handler f15411e;

        /* renamed from: f  reason: collision with root package name */
        private Executor f15412f;

        /* renamed from: g  reason: collision with root package name */
        private ThreadPoolExecutor f15413g;

        /* renamed from: h  reason: collision with root package name */
        private RetryPolicy f15414h;

        /* renamed from: i  reason: collision with root package name */
        EmojiCompat.MetadataRepoLoaderCallback f15415i;

        /* renamed from: j  reason: collision with root package name */
        private ContentObserver f15416j;

        /* renamed from: k  reason: collision with root package name */
        private Runnable f15417k;

        /* renamed from: androidx.emoji2.text.FontRequestEmojiCompatConfig$a$a  reason: collision with other inner class name */
        class C0199a extends ContentObserver {
            C0199a(Handler handler) {
                super(handler);
            }

            public void onChange(boolean z10, Uri uri) {
                a.this.c();
            }
        }

        a(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
            Preconditions.checkNotNull(context, "Context cannot be null");
            Preconditions.checkNotNull(fontRequest, "FontRequest cannot be null");
            this.f15407a = context.getApplicationContext();
            this.f15408b = fontRequest;
            this.f15409c = fontProviderHelper;
        }

        private void a() {
            synchronized (this.f15410d) {
                try {
                    this.f15415i = null;
                    ContentObserver contentObserver = this.f15416j;
                    if (contentObserver != null) {
                        this.f15409c.unregisterObserver(this.f15407a, contentObserver);
                        this.f15416j = null;
                    }
                    Handler handler = this.f15411e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f15417k);
                    }
                    this.f15411e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f15413g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f15412f = null;
                    this.f15413g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private FontsContractCompat.FontInfo d() {
            try {
                FontsContractCompat.FontFamilyResult fetchFonts = this.f15409c.fetchFonts(this.f15407a, this.f15408b);
                if (fetchFonts.getStatusCode() == 0) {
                    FontsContractCompat.FontInfo[] fonts = fetchFonts.getFonts();
                    if (fonts != null && fonts.length != 0) {
                        return fonts[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException("fetchFonts failed (" + fetchFonts.getStatusCode() + ")");
            } catch (PackageManager.NameNotFoundException e10) {
                throw new RuntimeException("provider not found", e10);
            }
        }

        private void e(Uri uri, long j10) {
            synchronized (this.f15410d) {
                try {
                    Handler handler = this.f15411e;
                    if (handler == null) {
                        handler = d.e();
                        this.f15411e = handler;
                    }
                    if (this.f15416j == null) {
                        C0199a aVar = new C0199a(handler);
                        this.f15416j = aVar;
                        this.f15409c.registerObserver(this.f15407a, uri, aVar);
                    }
                    if (this.f15417k == null) {
                        this.f15417k = new i(this);
                    }
                    handler.postDelayed(this.f15417k, j10);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r0 = d();
            r1 = r0.getResultCode();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
            if (r1 != 2) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
            r2 = r7.f15410d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r3 = r7.f15414h;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x001d, code lost:
            if (r3 == null) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x001f, code lost:
            r3 = r3.getRetryDelay();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
            if (r3 < 0) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
            e(r0.getUri(), r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0032, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0034, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0038, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x003a, code lost:
            if (r1 != 0) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            androidx.core.os.TraceCompat.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
            r1 = r7.f15409c.buildTypeface(r7.f15407a, r0);
            r0 = androidx.core.graphics.TypefaceCompatUtil.mmap(r7.f15407a, (android.os.CancellationSignal) null, r0.getUri());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0054, code lost:
            if (r0 == null) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0056, code lost:
            if (r1 == null) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0058, code lost:
            r0 = androidx.emoji2.text.MetadataRepo.create(r1, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            androidx.core.os.TraceCompat.endSection();
            r1 = r7.f15410d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0061, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            r2 = r7.f15415i;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0064, code lost:
            if (r2 == null) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0066, code lost:
            r2.onLoaded(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x006a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x006c, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0073, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x007c, code lost:
            throw new java.lang.RuntimeException("Unable to open file.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            androidx.core.os.TraceCompat.endSection();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0080, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x009c, code lost:
            throw new java.lang.RuntimeException("fetchFonts result is not OK. (" + r1 + ")");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x009f, code lost:
            monitor-enter(r7.f15410d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            r2 = r7.f15415i;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00a2, code lost:
            if (r2 != null) goto L_0x00a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00a4, code lost:
            r2.onFailed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00a8, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00ab, code lost:
            a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x00b0, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r7 = this;
                java.lang.Object r0 = r7.f15410d
                monitor-enter(r0)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r1 = r7.f15415i     // Catch:{ all -> 0x0009 }
                if (r1 != 0) goto L_0x000c
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                return
            L_0x0009:
                r1 = move-exception
                goto L_0x00b1
            L_0x000c:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                androidx.core.provider.FontsContractCompat$FontInfo r0 = r7.d()     // Catch:{ all -> 0x0038 }
                int r1 = r0.getResultCode()     // Catch:{ all -> 0x0038 }
                r2 = 2
                if (r1 != r2) goto L_0x003a
                java.lang.Object r2 = r7.f15410d     // Catch:{ all -> 0x0038 }
                monitor-enter(r2)     // Catch:{ all -> 0x0038 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$RetryPolicy r3 = r7.f15414h     // Catch:{ all -> 0x0032 }
                if (r3 == 0) goto L_0x0034
                long r3 = r3.getRetryDelay()     // Catch:{ all -> 0x0032 }
                r5 = 0
                int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r5 < 0) goto L_0x0034
                android.net.Uri r0 = r0.getUri()     // Catch:{ all -> 0x0032 }
                r7.e(r0, r3)     // Catch:{ all -> 0x0032 }
                monitor-exit(r2)     // Catch:{ all -> 0x0032 }
                return
            L_0x0032:
                r0 = move-exception
                goto L_0x0036
            L_0x0034:
                monitor-exit(r2)     // Catch:{ all -> 0x0032 }
                goto L_0x003a
            L_0x0036:
                monitor-exit(r2)     // Catch:{ all -> 0x0032 }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x0038:
                r0 = move-exception
                goto L_0x009d
            L_0x003a:
                if (r1 != 0) goto L_0x0081
                java.lang.String r1 = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface"
                androidx.core.os.TraceCompat.beginSection(r1)     // Catch:{ all -> 0x0073 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$FontProviderHelper r1 = r7.f15409c     // Catch:{ all -> 0x0073 }
                android.content.Context r2 = r7.f15407a     // Catch:{ all -> 0x0073 }
                android.graphics.Typeface r1 = r1.buildTypeface(r2, r0)     // Catch:{ all -> 0x0073 }
                android.content.Context r2 = r7.f15407a     // Catch:{ all -> 0x0073 }
                android.net.Uri r0 = r0.getUri()     // Catch:{ all -> 0x0073 }
                r3 = 0
                java.nio.ByteBuffer r0 = androidx.core.graphics.TypefaceCompatUtil.mmap(r2, r3, r0)     // Catch:{ all -> 0x0073 }
                if (r0 == 0) goto L_0x0075
                if (r1 == 0) goto L_0x0075
                androidx.emoji2.text.MetadataRepo r0 = androidx.emoji2.text.MetadataRepo.create((android.graphics.Typeface) r1, (java.nio.ByteBuffer) r0)     // Catch:{ all -> 0x0073 }
                androidx.core.os.TraceCompat.endSection()     // Catch:{ all -> 0x0038 }
                java.lang.Object r1 = r7.f15410d     // Catch:{ all -> 0x0038 }
                monitor-enter(r1)     // Catch:{ all -> 0x0038 }
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r7.f15415i     // Catch:{ all -> 0x006a }
                if (r2 == 0) goto L_0x006c
                r2.onLoaded(r0)     // Catch:{ all -> 0x006a }
                goto L_0x006c
            L_0x006a:
                r0 = move-exception
                goto L_0x0071
            L_0x006c:
                monitor-exit(r1)     // Catch:{ all -> 0x006a }
                r7.a()     // Catch:{ all -> 0x0038 }
                goto L_0x00ae
            L_0x0071:
                monitor-exit(r1)     // Catch:{ all -> 0x006a }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x0073:
                r0 = move-exception
                goto L_0x007d
            L_0x0075:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0073 }
                java.lang.String r1 = "Unable to open file."
                r0.<init>(r1)     // Catch:{ all -> 0x0073 }
                throw r0     // Catch:{ all -> 0x0073 }
            L_0x007d:
                androidx.core.os.TraceCompat.endSection()     // Catch:{ all -> 0x0038 }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x0081:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0038 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
                r2.<init>()     // Catch:{ all -> 0x0038 }
                java.lang.String r3 = "fetchFonts result is not OK. ("
                r2.append(r3)     // Catch:{ all -> 0x0038 }
                r2.append(r1)     // Catch:{ all -> 0x0038 }
                java.lang.String r1 = ")"
                r2.append(r1)     // Catch:{ all -> 0x0038 }
                java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0038 }
                r0.<init>(r1)     // Catch:{ all -> 0x0038 }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x009d:
                java.lang.Object r1 = r7.f15410d
                monitor-enter(r1)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r7.f15415i     // Catch:{ all -> 0x00a8 }
                if (r2 == 0) goto L_0x00aa
                r2.onFailed(r0)     // Catch:{ all -> 0x00a8 }
                goto L_0x00aa
            L_0x00a8:
                r0 = move-exception
                goto L_0x00af
            L_0x00aa:
                monitor-exit(r1)     // Catch:{ all -> 0x00a8 }
                r7.a()
            L_0x00ae:
                return
            L_0x00af:
                monitor-exit(r1)     // Catch:{ all -> 0x00a8 }
                throw r0
            L_0x00b1:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.FontRequestEmojiCompatConfig.a.b():void");
        }

        /* access modifiers changed from: package-private */
        public void c() {
            synchronized (this.f15410d) {
                try {
                    if (this.f15415i != null) {
                        if (this.f15412f == null) {
                            ThreadPoolExecutor c10 = d.c("emojiCompat");
                            this.f15413g = c10;
                            this.f15412f = c10;
                        }
                        this.f15412f.execute(new h(this));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void f(Executor executor) {
            synchronized (this.f15410d) {
                this.f15412f = executor;
            }
        }

        public void g(RetryPolicy retryPolicy) {
            synchronized (this.f15410d) {
                this.f15414h = retryPolicy;
            }
        }

        public void load(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.checkNotNull(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.f15410d) {
                this.f15415i = metadataRepoLoaderCallback;
            }
            c();
        }
    }

    public FontRequestEmojiCompatConfig(@NonNull Context context, @NonNull FontRequest fontRequest) {
        super(new a(context, fontRequest, DEFAULT_FONTS_CONTRACT));
    }

    @NonNull
    @Deprecated
    public FontRequestEmojiCompatConfig setHandler(@Nullable Handler handler) {
        if (handler == null) {
            return this;
        }
        setLoadingExecutor(d.b(handler));
        return this;
    }

    @NonNull
    public FontRequestEmojiCompatConfig setLoadingExecutor(@NonNull Executor executor) {
        ((a) getMetadataRepoLoader()).f(executor);
        return this;
    }

    @NonNull
    public FontRequestEmojiCompatConfig setRetryPolicy(@Nullable RetryPolicy retryPolicy) {
        ((a) getMetadataRepoLoader()).g(retryPolicy);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public FontRequestEmojiCompatConfig(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontProviderHelper fontProviderHelper) {
        super(new a(context, fontRequest, fontProviderHelper));
    }
}
