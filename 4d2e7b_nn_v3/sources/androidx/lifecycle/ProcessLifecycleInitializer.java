package androidx.lifecycle;

import android.content.Context;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

public final class ProcessLifecycleInitializer implements Initializer<LifecycleOwner> {
    public List<Class<? extends Initializer<?>>> dependencies() {
        return r.l();
    }

    public LifecycleOwner create(Context context) {
        m.f(context, "context");
        AppInitializer instance = AppInitializer.getInstance(context);
        m.e(instance, "getInstance(context)");
        if (instance.isEagerlyInitialized(ProcessLifecycleInitializer.class)) {
            LifecycleDispatcher.init(context);
            ProcessLifecycleOwner.Companion companion = ProcessLifecycleOwner.Companion;
            companion.init$lifecycle_process_release(context);
            return companion.get();
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }
}
