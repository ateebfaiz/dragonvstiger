package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Glide implements ComponentCallbacks2 {
    private static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    private static final String TAG = "Glide";
    @GuardedBy("Glide.class")
    private static volatile Glide glide;
    private static volatile boolean isInitializing;
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;
    @GuardedBy("this")
    @Nullable
    private BitmapPreFiller bitmapPreFiller;
    private final ConnectivityMonitorFactory connectivityMonitorFactory;
    private final RequestOptionsFactory defaultRequestOptionsFactory;
    private final Engine engine;
    private final GlideContext glideContext;
    @GuardedBy("managers")
    private final List<RequestManager> managers = new ArrayList();
    private final MemoryCache memoryCache;
    private MemoryCategory memoryCategory = MemoryCategory.NORMAL;
    private final RequestManagerRetriever requestManagerRetriever;

    public interface RequestOptionsFactory {
        @NonNull
        RequestOptions build();
    }

    Glide(@NonNull Context context, @NonNull Engine engine2, @NonNull MemoryCache memoryCache2, @NonNull BitmapPool bitmapPool2, @NonNull ArrayPool arrayPool2, @NonNull RequestManagerRetriever requestManagerRetriever2, @NonNull ConnectivityMonitorFactory connectivityMonitorFactory2, int i10, @NonNull RequestOptionsFactory requestOptionsFactory, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull List<RequestListener<Object>> list, @NonNull List<GlideModule> list2, @Nullable AppGlideModule appGlideModule, @NonNull GlideExperiments glideExperiments) {
        this.engine = engine2;
        this.bitmapPool = bitmapPool2;
        ArrayPool arrayPool3 = arrayPool2;
        this.arrayPool = arrayPool3;
        this.memoryCache = memoryCache2;
        this.requestManagerRetriever = requestManagerRetriever2;
        this.connectivityMonitorFactory = connectivityMonitorFactory2;
        RequestOptionsFactory requestOptionsFactory2 = requestOptionsFactory;
        this.defaultRequestOptionsFactory = requestOptionsFactory2;
        this.glideContext = new GlideContext(context, arrayPool3, RegistryFactory.lazilyCreateAndInitializeRegistry(this, list2, appGlideModule), new ImageViewTargetFactory(), requestOptionsFactory2, map, list, engine2, glideExperiments, i10);
    }

    @VisibleForTesting
    @GuardedBy("Glide.class")
    static void checkAndInitializeGlide(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (!isInitializing) {
            isInitializing = true;
            try {
                initializeGlide(context, generatedAppGlideModule);
            } finally {
                isInitializing = false;
            }
        } else {
            throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
        }
    }

    @VisibleForTesting
    public static void enableHardwareBitmaps() {
        HardwareConfigState.getInstance().unblockHardwareBitmaps();
    }

    @NonNull
    public static Glide get(@NonNull Context context) {
        if (glide == null) {
            GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context.getApplicationContext());
            synchronized (Glide.class) {
                try {
                    if (glide == null) {
                        checkAndInitializeGlide(context, annotationGeneratedGlideModules);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return glide;
    }

    @Nullable
    private static GeneratedAppGlideModule getAnnotationGeneratedGlideModules(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context.getApplicationContext()});
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
        } catch (InstantiationException e10) {
            throwIncorrectGlideModule(e10);
        } catch (IllegalAccessException e11) {
            throwIncorrectGlideModule(e11);
        } catch (NoSuchMethodException e12) {
            throwIncorrectGlideModule(e12);
        } catch (InvocationTargetException e13) {
            throwIncorrectGlideModule(e13);
        }
        return null;
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context) {
        return getPhotoCacheDir(context, "image_manager_disk_cache");
    }

    @NonNull
    private static RequestManagerRetriever getRetriever(@Nullable Context context) {
        Preconditions.checkNotNull(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return get(context).getRequestManagerRetriever();
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void init(Glide glide2) {
        synchronized (Glide.class) {
            try {
                if (glide != null) {
                    tearDown();
                }
                glide = glide2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @GuardedBy("Glide.class")
    private static void initializeGlide(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        initializeGlide(context, new GlideBuilder(), generatedAppGlideModule);
    }

    @VisibleForTesting
    public static void tearDown() {
        synchronized (Glide.class) {
            try {
                if (glide != null) {
                    glide.getContext().getApplicationContext().unregisterComponentCallbacks(glide);
                    glide.engine.shutdown();
                }
                glide = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void throwIncorrectGlideModule(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @NonNull
    public static RequestManager with(@NonNull Context context) {
        return getRetriever(context).get(context);
    }

    public void clearDiskCache() {
        Util.assertBackgroundThread();
        this.engine.clearDiskCache();
    }

    public void clearMemory() {
        Util.assertMainThread();
        this.memoryCache.clearMemory();
        this.bitmapPool.clearMemory();
        this.arrayPool.clearMemory();
    }

    @NonNull
    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    @NonNull
    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    /* access modifiers changed from: package-private */
    public ConnectivityMonitorFactory getConnectivityMonitorFactory() {
        return this.connectivityMonitorFactory;
    }

    @NonNull
    public Context getContext() {
        return this.glideContext.getBaseContext();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public GlideContext getGlideContext() {
        return this.glideContext;
    }

    @NonNull
    public Registry getRegistry() {
        return this.glideContext.getRegistry();
    }

    @NonNull
    public RequestManagerRetriever getRequestManagerRetriever() {
        return this.requestManagerRetriever;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        clearMemory();
    }

    public void onTrimMemory(int i10) {
        trimMemory(i10);
    }

    public synchronized void preFillBitmapPool(@NonNull PreFillType.Builder... builderArr) {
        try {
            if (this.bitmapPreFiller == null) {
                this.bitmapPreFiller = new BitmapPreFiller(this.memoryCache, this.bitmapPool, (DecodeFormat) this.defaultRequestOptionsFactory.build().getOptions().get(Downsampler.DECODE_FORMAT));
            }
            this.bitmapPreFiller.preFill(builderArr);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void registerRequestManager(RequestManager requestManager) {
        synchronized (this.managers) {
            try {
                if (!this.managers.contains(requestManager)) {
                    this.managers.add(requestManager);
                } else {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean removeFromManagers(@NonNull Target<?> target) {
        synchronized (this.managers) {
            try {
                for (RequestManager untrack : this.managers) {
                    if (untrack.untrack(target)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public MemoryCategory setMemoryCategory(@NonNull MemoryCategory memoryCategory2) {
        Util.assertMainThread();
        this.memoryCache.setSizeMultiplier(memoryCategory2.getMultiplier());
        this.bitmapPool.setSizeMultiplier(memoryCategory2.getMultiplier());
        MemoryCategory memoryCategory3 = this.memoryCategory;
        this.memoryCategory = memoryCategory2;
        return memoryCategory3;
    }

    public void trimMemory(int i10) {
        Util.assertMainThread();
        synchronized (this.managers) {
            try {
                for (RequestManager onTrimMemory : this.managers) {
                    onTrimMemory.onTrimMemory(i10);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.memoryCache.trimMemory(i10);
        this.bitmapPool.trimMemory(i10);
        this.arrayPool.trimMemory(i10);
    }

    /* access modifiers changed from: package-private */
    public void unregisterRequestManager(RequestManager requestManager) {
        synchronized (this.managers) {
            try {
                if (this.managers.contains(requestManager)) {
                    this.managers.remove(requestManager);
                } else {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.isDirectory() || file.mkdirs()) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable(TAG, 6)) {
            Log.e(TAG, "default disk cache dir is null");
        }
        return null;
    }

    @GuardedBy("Glide.class")
    private static void initializeGlide(@NonNull Context context, @NonNull GlideBuilder glideBuilder, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<GlideModule> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.isManifestParsingEnabled()) {
            emptyList = new ManifestParser(applicationContext).parse();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.getExcludedModuleClasses().isEmpty()) {
            Set<Class<?>> excludedModuleClasses = generatedAppGlideModule.getExcludedModuleClasses();
            Iterator<GlideModule> it = emptyList.iterator();
            while (it.hasNext()) {
                GlideModule next = it.next();
                if (excludedModuleClasses.contains(next.getClass())) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(TAG, 3)) {
            for (GlideModule glideModule : emptyList) {
                Log.d(TAG, "Discovered GlideModule from manifest: " + glideModule.getClass());
            }
        }
        glideBuilder.setRequestManagerFactory(generatedAppGlideModule != null ? generatedAppGlideModule.getRequestManagerFactory() : null);
        for (GlideModule applyOptions : emptyList) {
            applyOptions.applyOptions(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.applyOptions(applicationContext, glideBuilder);
        }
        Glide build = glideBuilder.build(applicationContext, emptyList, generatedAppGlideModule);
        applicationContext.registerComponentCallbacks(build);
        glide = build;
    }

    @NonNull
    @Deprecated
    public static RequestManager with(@NonNull Activity activity) {
        return getRetriever(activity).get(activity);
    }

    @NonNull
    public static RequestManager with(@NonNull FragmentActivity fragmentActivity) {
        return getRetriever(fragmentActivity).get(fragmentActivity);
    }

    @NonNull
    public static RequestManager with(@NonNull Fragment fragment) {
        return getRetriever(fragment.getContext()).get(fragment);
    }

    @VisibleForTesting
    public static void init(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context);
        synchronized (Glide.class) {
            try {
                if (glide != null) {
                    tearDown();
                }
                initializeGlide(context, glideBuilder, annotationGeneratedGlideModules);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    @Deprecated
    public static RequestManager with(@NonNull android.app.Fragment fragment) {
        return getRetriever(fragment.getActivity()).get(fragment);
    }

    @NonNull
    public static RequestManager with(@NonNull View view) {
        return getRetriever(view.getContext()).get(view);
    }
}
