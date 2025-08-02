package androidx.emoji2.text;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.DefaultEmojiCompatConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@AnyThread
public class EmojiCompat {
    private static final Object CONFIG_LOCK = new Object();
    public static final String EDITOR_INFO_METAVERSION_KEY = "android.support.text.emoji.emojiCompat_metadataVersion";
    public static final String EDITOR_INFO_REPLACE_ALL_KEY = "android.support.text.emoji.emojiCompat_replaceAll";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static final int EMOJI_COUNT_UNLIMITED = Integer.MAX_VALUE;
    public static final int EMOJI_FALLBACK = 2;
    public static final int EMOJI_SUPPORTED = 1;
    public static final int EMOJI_UNSUPPORTED = 0;
    private static final Object INSTANCE_LOCK = new Object();
    public static final int LOAD_STATE_DEFAULT = 3;
    public static final int LOAD_STATE_FAILED = 2;
    public static final int LOAD_STATE_LOADING = 0;
    public static final int LOAD_STATE_SUCCEEDED = 1;
    public static final int LOAD_STRATEGY_DEFAULT = 0;
    public static final int LOAD_STRATEGY_MANUAL = 1;
    private static final String NOT_INITIALIZED_ERROR_TEXT = "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.";
    public static final int REPLACE_STRATEGY_ALL = 1;
    public static final int REPLACE_STRATEGY_DEFAULT = 0;
    public static final int REPLACE_STRATEGY_NON_EXISTENT = 2;
    @GuardedBy("CONFIG_LOCK")
    private static volatile boolean sHasDoneDefaultConfigLookup;
    @GuardedBy("INSTANCE_LOCK")
    @Nullable
    private static volatile EmojiCompat sInstance;
    @Nullable
    final int[] mEmojiAsDefaultStyleExceptions;
    private final int mEmojiSpanIndicatorColor;
    private final boolean mEmojiSpanIndicatorEnabled;
    /* access modifiers changed from: private */
    public final GlyphChecker mGlyphChecker;
    @NonNull
    private final b mHelper;
    @GuardedBy("mInitLock")
    @NonNull
    private final Set<InitCallback> mInitCallbacks;
    @NonNull
    private final ReadWriteLock mInitLock = new ReentrantReadWriteLock();
    @GuardedBy("mInitLock")
    private volatile int mLoadState = 3;
    @NonNull
    private final Handler mMainHandler;
    private final int mMetadataLoadStrategy;
    @NonNull
    final MetadataRepoLoader mMetadataLoader;
    final boolean mReplaceAll;
    final boolean mUseEmojiAsDefaultStyle;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CodepointSequenceMatchResult {
    }

    public static abstract class Config {
        @Nullable
        int[] mEmojiAsDefaultStyleExceptions;
        int mEmojiSpanIndicatorColor = -16711936;
        boolean mEmojiSpanIndicatorEnabled;
        @NonNull
        GlyphChecker mGlyphChecker = new e();
        @Nullable
        Set<InitCallback> mInitCallbacks;
        int mMetadataLoadStrategy = 0;
        @NonNull
        final MetadataRepoLoader mMetadataLoader;
        boolean mReplaceAll;
        boolean mUseEmojiAsDefaultStyle;

        protected Config(@NonNull MetadataRepoLoader metadataRepoLoader) {
            Preconditions.checkNotNull(metadataRepoLoader, "metadataLoader cannot be null.");
            this.mMetadataLoader = metadataRepoLoader;
        }

        /* access modifiers changed from: protected */
        @NonNull
        public final MetadataRepoLoader getMetadataRepoLoader() {
            return this.mMetadataLoader;
        }

        @NonNull
        public Config registerInitCallback(@NonNull InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            if (this.mInitCallbacks == null) {
                this.mInitCallbacks = new ArraySet();
            }
            this.mInitCallbacks.add(initCallback);
            return this;
        }

        @NonNull
        public Config setEmojiSpanIndicatorColor(@ColorInt int i10) {
            this.mEmojiSpanIndicatorColor = i10;
            return this;
        }

        @NonNull
        public Config setEmojiSpanIndicatorEnabled(boolean z10) {
            this.mEmojiSpanIndicatorEnabled = z10;
            return this;
        }

        @NonNull
        public Config setGlyphChecker(@NonNull GlyphChecker glyphChecker) {
            Preconditions.checkNotNull(glyphChecker, "GlyphChecker cannot be null");
            this.mGlyphChecker = glyphChecker;
            return this;
        }

        @NonNull
        public Config setMetadataLoadStrategy(int i10) {
            this.mMetadataLoadStrategy = i10;
            return this;
        }

        @NonNull
        public Config setReplaceAll(boolean z10) {
            this.mReplaceAll = z10;
            return this;
        }

        @NonNull
        public Config setUseEmojiAsDefaultStyle(boolean z10) {
            return setUseEmojiAsDefaultStyle(z10, (List<Integer>) null);
        }

        @NonNull
        public Config unregisterInitCallback(@NonNull InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            Set<InitCallback> set = this.mInitCallbacks;
            if (set != null) {
                set.remove(initCallback);
            }
            return this;
        }

        @NonNull
        public Config setUseEmojiAsDefaultStyle(boolean z10, @Nullable List<Integer> list) {
            this.mUseEmojiAsDefaultStyle = z10;
            if (!z10 || list == null) {
                this.mEmojiAsDefaultStyleExceptions = null;
            } else {
                this.mEmojiAsDefaultStyleExceptions = new int[list.size()];
                int i10 = 0;
                for (Integer intValue : list) {
                    this.mEmojiAsDefaultStyleExceptions[i10] = intValue.intValue();
                    i10++;
                }
                Arrays.sort(this.mEmojiAsDefaultStyleExceptions);
            }
            return this;
        }
    }

    public interface GlyphChecker {
        boolean hasGlyph(@NonNull CharSequence charSequence, @IntRange(from = 0) int i10, @IntRange(from = 0) int i11, @IntRange(from = 0) int i12);
    }

    public static abstract class InitCallback {
        public void onFailed(@Nullable Throwable th) {
        }

        public void onInitialized() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadStrategy {
    }

    public interface MetadataRepoLoader {
        void load(@NonNull MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    public static abstract class MetadataRepoLoaderCallback {
        public abstract void onFailed(@Nullable Throwable th);

        public abstract void onLoaded(@NonNull MetadataRepo metadataRepo);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReplaceStrategy {
    }

    private static final class a extends b {

        /* renamed from: b  reason: collision with root package name */
        private volatile g f15394b;

        /* renamed from: c  reason: collision with root package name */
        private volatile MetadataRepo f15395c;

        /* renamed from: androidx.emoji2.text.EmojiCompat$a$a  reason: collision with other inner class name */
        class C0198a extends MetadataRepoLoaderCallback {
            C0198a() {
            }

            public void onFailed(Throwable th) {
                a.this.f15397a.onMetadataLoadFailed(th);
            }

            public void onLoaded(MetadataRepo metadataRepo) {
                a.this.h(metadataRepo);
            }
        }

        a(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        /* access modifiers changed from: package-private */
        public String a() {
            String sourceSha = this.f15395c.getMetadataList().sourceSha();
            if (sourceSha == null) {
                return "";
            }
            return sourceSha;
        }

        public int b(CharSequence charSequence, int i10) {
            return this.f15394b.d(charSequence, i10);
        }

        /* access modifiers changed from: package-private */
        public boolean c(CharSequence charSequence) {
            if (this.f15394b.c(charSequence) == 1) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean d(CharSequence charSequence, int i10) {
            if (this.f15394b.d(charSequence, i10) == 1) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            try {
                this.f15397a.mMetadataLoader.load(new C0198a());
            } catch (Throwable th) {
                this.f15397a.onMetadataLoadFailed(th);
            }
        }

        /* access modifiers changed from: package-private */
        public CharSequence f(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            return this.f15394b.j(charSequence, i10, i11, i12, z10);
        }

        /* access modifiers changed from: package-private */
        public void g(EditorInfo editorInfo) {
            editorInfo.extras.putInt(EmojiCompat.EDITOR_INFO_METAVERSION_KEY, this.f15395c.getMetadataVersion());
            editorInfo.extras.putBoolean(EmojiCompat.EDITOR_INFO_REPLACE_ALL_KEY, this.f15397a.mReplaceAll);
        }

        /* access modifiers changed from: package-private */
        public void h(MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                this.f15397a.onMetadataLoadFailed(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f15395c = metadataRepo;
            MetadataRepo metadataRepo2 = this.f15395c;
            d dVar = new d();
            GlyphChecker access$000 = this.f15397a.mGlyphChecker;
            EmojiCompat emojiCompat = this.f15397a;
            this.f15394b = new g(metadataRepo2, dVar, access$000, emojiCompat.mUseEmojiAsDefaultStyle, emojiCompat.mEmojiAsDefaultStyleExceptions);
            this.f15397a.onMetadataLoadSuccess();
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        final EmojiCompat f15397a;

        b(EmojiCompat emojiCompat) {
            this.f15397a = emojiCompat;
        }

        /* access modifiers changed from: package-private */
        public abstract String a();

        public abstract int b(CharSequence charSequence, int i10);

        /* access modifiers changed from: package-private */
        public abstract boolean c(CharSequence charSequence);

        /* access modifiers changed from: package-private */
        public abstract boolean d(CharSequence charSequence, int i10);

        /* access modifiers changed from: package-private */
        public abstract void e();

        /* access modifiers changed from: package-private */
        public abstract CharSequence f(CharSequence charSequence, int i10, int i11, int i12, boolean z10);

        /* access modifiers changed from: package-private */
        public abstract void g(EditorInfo editorInfo);
    }

    private static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final List f15398a;

        /* renamed from: b  reason: collision with root package name */
        private final Throwable f15399b;

        /* renamed from: c  reason: collision with root package name */
        private final int f15400c;

        c(InitCallback initCallback, int i10) {
            this(Arrays.asList(new InitCallback[]{(InitCallback) Preconditions.checkNotNull(initCallback, "initCallback cannot be null")}), i10, (Throwable) null);
        }

        public void run() {
            int size = this.f15398a.size();
            int i10 = 0;
            if (this.f15400c != 1) {
                while (i10 < size) {
                    ((InitCallback) this.f15398a.get(i10)).onFailed(this.f15399b);
                    i10++;
                }
                return;
            }
            while (i10 < size) {
                ((InitCallback) this.f15398a.get(i10)).onInitialized();
                i10++;
            }
        }

        c(Collection collection, int i10) {
            this(collection, i10, (Throwable) null);
        }

        c(Collection collection, int i10, Throwable th) {
            Preconditions.checkNotNull(collection, "initCallbacks cannot be null");
            this.f15398a = new ArrayList(collection);
            this.f15400c = i10;
            this.f15399b = th;
        }
    }

    static class d {
        d() {
        }

        /* access modifiers changed from: package-private */
        public EmojiSpan a(EmojiMetadata emojiMetadata) {
            return new TypefaceEmojiSpan(emojiMetadata);
        }
    }

    private EmojiCompat(@NonNull Config config) {
        this.mReplaceAll = config.mReplaceAll;
        this.mUseEmojiAsDefaultStyle = config.mUseEmojiAsDefaultStyle;
        this.mEmojiAsDefaultStyleExceptions = config.mEmojiAsDefaultStyleExceptions;
        this.mEmojiSpanIndicatorEnabled = config.mEmojiSpanIndicatorEnabled;
        this.mEmojiSpanIndicatorColor = config.mEmojiSpanIndicatorColor;
        this.mMetadataLoader = config.mMetadataLoader;
        this.mMetadataLoadStrategy = config.mMetadataLoadStrategy;
        this.mGlyphChecker = config.mGlyphChecker;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        ArraySet arraySet = new ArraySet();
        this.mInitCallbacks = arraySet;
        Set<InitCallback> set = config.mInitCallbacks;
        if (set != null && !set.isEmpty()) {
            arraySet.addAll(config.mInitCallbacks);
        }
        this.mHelper = new a(this);
        loadMetadata();
    }

    @NonNull
    public static EmojiCompat get() {
        EmojiCompat emojiCompat;
        boolean z10;
        synchronized (INSTANCE_LOCK) {
            emojiCompat = sInstance;
            if (emojiCompat != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, NOT_INITIALIZED_ERROR_TEXT);
        }
        return emojiCompat;
    }

    public static boolean handleDeleteSurroundingText(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i10, @IntRange(from = 0) int i11, boolean z10) {
        return g.e(inputConnection, editable, i10, i11, z10);
    }

    public static boolean handleOnKeyDown(@NonNull Editable editable, int i10, @NonNull KeyEvent keyEvent) {
        return g.f(editable, i10, keyEvent);
    }

    @Nullable
    public static EmojiCompat init(@NonNull Context context) {
        return init(context, (DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory) null);
    }

    public static boolean isConfigured() {
        if (sInstance != null) {
            return true;
        }
        return false;
    }

    private boolean isInitialized() {
        if (getLoadState() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    private void loadMetadata() {
        this.mInitLock.writeLock().lock();
        try {
            if (this.mMetadataLoadStrategy == 0) {
                this.mLoadState = 0;
            }
            this.mInitLock.writeLock().unlock();
            if (getLoadState() == 0) {
                this.mHelper.e();
            }
        } catch (Throwable th) {
            this.mInitLock.writeLock().unlock();
            throw th;
        }
    }

    @NonNull
    public static EmojiCompat reset(@NonNull Config config) {
        EmojiCompat emojiCompat;
        synchronized (INSTANCE_LOCK) {
            emojiCompat = new EmojiCompat(config);
            sInstance = emojiCompat;
        }
        return emojiCompat;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void skipDefaultConfigurationLookup(boolean z10) {
        synchronized (CONFIG_LOCK) {
            sHasDoneDefaultConfigLookup = z10;
        }
    }

    @NonNull
    public String getAssetSignature() {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        return this.mHelper.a();
    }

    public int getEmojiMatch(@NonNull CharSequence charSequence, @IntRange(from = 0) int i10) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.mHelper.b(charSequence, i10);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmojiSpanIndicatorColor() {
        return this.mEmojiSpanIndicatorColor;
    }

    public int getLoadState() {
        this.mInitLock.readLock().lock();
        try {
            return this.mLoadState;
        } finally {
            this.mInitLock.readLock().unlock();
        }
    }

    @Deprecated
    public boolean hasEmojiGlyph(@NonNull CharSequence charSequence) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.mHelper.c(charSequence);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isEmojiSpanIndicatorEnabled() {
        return this.mEmojiSpanIndicatorEnabled;
    }

    public void load() {
        boolean z10 = true;
        if (this.mMetadataLoadStrategy != 1) {
            z10 = false;
        }
        Preconditions.checkState(z10, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (!isInitialized()) {
            this.mInitLock.writeLock().lock();
            try {
                if (this.mLoadState != 0) {
                    this.mLoadState = 0;
                    this.mInitLock.writeLock().unlock();
                    this.mHelper.e();
                }
            } finally {
                this.mInitLock.writeLock().unlock();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void onMetadataLoadFailed(@Nullable Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 2;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new c(arrayList, this.mLoadState, th));
        } catch (Throwable th2) {
            this.mInitLock.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void onMetadataLoadSuccess() {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 1;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new c((Collection) arrayList, this.mLoadState));
        } catch (Throwable th) {
            this.mInitLock.writeLock().unlock();
            throw th;
        }
    }

    @CheckResult
    @Nullable
    public CharSequence process(@Nullable CharSequence charSequence) {
        return process(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public void registerInitCallback(@NonNull InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            if (this.mLoadState != 1) {
                if (this.mLoadState != 2) {
                    this.mInitCallbacks.add(initCallback);
                }
            }
            this.mMainHandler.post(new c(initCallback, this.mLoadState));
        } finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    public void unregisterInitCallback(@NonNull InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            this.mInitCallbacks.remove(initCallback);
        } finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    public void updateEditorInfo(@NonNull EditorInfo editorInfo) {
        if (isInitialized() && editorInfo != null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            this.mHelper.g(editorInfo);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static EmojiCompat init(@NonNull Context context, @Nullable DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory defaultEmojiCompatConfigFactory) {
        EmojiCompat emojiCompat;
        if (sHasDoneDefaultConfigLookup) {
            return sInstance;
        }
        if (defaultEmojiCompatConfigFactory == null) {
            defaultEmojiCompatConfigFactory = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory((DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper) null);
        }
        Config create = defaultEmojiCompatConfigFactory.create(context);
        synchronized (CONFIG_LOCK) {
            try {
                if (!sHasDoneDefaultConfigLookup) {
                    if (create != null) {
                        init(create);
                    }
                    sHasDoneDefaultConfigLookup = true;
                }
                emojiCompat = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return emojiCompat;
    }

    @CheckResult
    @Nullable
    public CharSequence process(@Nullable CharSequence charSequence, @IntRange(from = 0) int i10, @IntRange(from = 0) int i11) {
        return process(charSequence, i10, i11, Integer.MAX_VALUE);
    }

    @Deprecated
    public boolean hasEmojiGlyph(@NonNull CharSequence charSequence, @IntRange(from = 0) int i10) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.mHelper.d(charSequence, i10);
    }

    @CheckResult
    @Nullable
    public CharSequence process(@Nullable CharSequence charSequence, @IntRange(from = 0) int i10, @IntRange(from = 0) int i11, @IntRange(from = 0) int i12) {
        return process(charSequence, i10, i11, i12, 0);
    }

    @CheckResult
    @Nullable
    public CharSequence process(@Nullable CharSequence charSequence, @IntRange(from = 0) int i10, @IntRange(from = 0) int i11, @IntRange(from = 0) int i12, int i13) {
        boolean z10;
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkArgumentNonnegative(i10, "start cannot be negative");
        Preconditions.checkArgumentNonnegative(i11, "end cannot be negative");
        Preconditions.checkArgumentNonnegative(i12, "maxEmojiCount cannot be negative");
        boolean z11 = false;
        Preconditions.checkArgument(i10 <= i11, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        Preconditions.checkArgument(i10 <= charSequence.length(), "start should be < than charSequence length");
        Preconditions.checkArgument(i11 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i10 == i11) {
            return charSequence;
        }
        if (i13 != 1) {
            if (i13 != 2) {
                z11 = this.mReplaceAll;
            }
            z10 = z11;
        } else {
            z10 = true;
        }
        return this.mHelper.f(charSequence, i10, i11, i12, z10);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static EmojiCompat reset(@Nullable EmojiCompat emojiCompat) {
        EmojiCompat emojiCompat2;
        synchronized (INSTANCE_LOCK) {
            sInstance = emojiCompat;
            emojiCompat2 = sInstance;
        }
        return emojiCompat2;
    }

    @NonNull
    public static EmojiCompat init(@NonNull Config config) {
        EmojiCompat emojiCompat = sInstance;
        if (emojiCompat == null) {
            synchronized (INSTANCE_LOCK) {
                try {
                    emojiCompat = sInstance;
                    if (emojiCompat == null) {
                        emojiCompat = new EmojiCompat(config);
                        sInstance = emojiCompat;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return emojiCompat;
    }
}
