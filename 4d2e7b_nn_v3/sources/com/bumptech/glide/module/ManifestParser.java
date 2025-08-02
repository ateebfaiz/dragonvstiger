package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public final class ManifestParser {
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private static final String TAG = "ManifestParser";
    private final Context context;

    public ManifestParser(Context context2) {
        this.context = context2;
    }

    @Nullable
    private ApplicationInfo getOurApplicationInfo() throws PackageManager.NameNotFoundException {
        return this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
    }

    private static GlideModule parseModule(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object obj = null;
            try {
                obj = cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            } catch (InstantiationException e10) {
                throwInstantiateGlideModuleException(cls, e10);
            } catch (IllegalAccessException e11) {
                throwInstantiateGlideModuleException(cls, e11);
            } catch (NoSuchMethodException e12) {
                throwInstantiateGlideModuleException(cls, e12);
            } catch (InvocationTargetException e13) {
                throwInstantiateGlideModuleException(cls, e13);
            }
            if (obj instanceof GlideModule) {
                return (GlideModule) obj;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
        } catch (ClassNotFoundException e14) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e14);
        }
    }

    private static void throwInstantiateGlideModuleException(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public List<GlideModule> parse() {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo ourApplicationInfo = getOurApplicationInfo();
            if (ourApplicationInfo != null) {
                if (ourApplicationInfo.metaData != null) {
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Got app info metadata: " + ourApplicationInfo.metaData);
                    }
                    for (String next : ourApplicationInfo.metaData.keySet()) {
                        if (GLIDE_MODULE_VALUE.equals(ourApplicationInfo.metaData.get(next))) {
                            arrayList.add(parseModule(next));
                            if (Log.isLoggable(TAG, 3)) {
                                Log.d(TAG, "Loaded Glide module: " + next);
                            }
                        }
                    }
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Finished loading Glide modules");
                    }
                    return arrayList;
                }
            }
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Got null app info metadata");
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e10);
        }
    }
}
