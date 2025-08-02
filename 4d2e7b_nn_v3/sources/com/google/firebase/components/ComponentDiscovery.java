package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.inject.Provider;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ComponentDiscovery<T> {
    private static final String COMPONENT_KEY_PREFIX = "com.google.firebase.components:";
    private static final String COMPONENT_SENTINEL_VALUE = "com.google.firebase.components.ComponentRegistrar";
    static final String TAG = "ComponentDiscovery";
    private final T context;
    private final c retriever;

    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final Class f8974a;

        private Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w(ComponentDiscovery.TAG, "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f8974a), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w(ComponentDiscovery.TAG, this.f8974a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w(ComponentDiscovery.TAG, "Application info not found.");
                return null;
            }
        }

        /* renamed from: c */
        public List a(Context context) {
            Bundle b10 = b(context);
            if (b10 == null) {
                Log.w(ComponentDiscovery.TAG, "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String next : b10.keySet()) {
                if (ComponentDiscovery.COMPONENT_SENTINEL_VALUE.equals(b10.get(next)) && next.startsWith(ComponentDiscovery.COMPONENT_KEY_PREFIX)) {
                    arrayList.add(next.substring(31));
                }
            }
            return arrayList;
        }

        private b(Class cls) {
            this.f8974a = cls;
        }
    }

    interface c {
        List a(Object obj);
    }

    @VisibleForTesting
    ComponentDiscovery(T t10, c cVar) {
        this.context = t10;
        this.retriever = cVar;
    }

    public static ComponentDiscovery<Context> forContext(Context context2, Class<? extends Service> cls) {
        return new ComponentDiscovery<>(context2, new b(cls));
    }

    /* access modifiers changed from: private */
    @Nullable
    public static ComponentRegistrar instantiate(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            }
            throw new InvalidRegistrarException(String.format("Class %s is not an instance of %s", new Object[]{str, COMPONENT_SENTINEL_VALUE}));
        } catch (ClassNotFoundException unused) {
            Log.w(TAG, String.format("Class %s is not an found.", new Object[]{str}));
            return null;
        } catch (IllegalAccessException e10) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", new Object[]{str}), e10);
        } catch (InstantiationException e11) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", new Object[]{str}), e11);
        } catch (NoSuchMethodException e12) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", new Object[]{str}), e12);
        } catch (InvocationTargetException e13) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", new Object[]{str}), e13);
        }
    }

    @Deprecated
    public List<ComponentRegistrar> discover() {
        ArrayList arrayList = new ArrayList();
        for (String instantiate : this.retriever.a(this.context)) {
            try {
                ComponentRegistrar instantiate2 = instantiate(instantiate);
                if (instantiate2 != null) {
                    arrayList.add(instantiate2);
                }
            } catch (InvalidRegistrarException e10) {
                Log.w(TAG, "Invalid component registrar.", e10);
            }
        }
        return arrayList;
    }

    public List<Provider<ComponentRegistrar>> discoverLazy() {
        ArrayList arrayList = new ArrayList();
        for (String gVar : this.retriever.a(this.context)) {
            arrayList.add(new g(gVar));
        }
        return arrayList;
    }
}
