package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class e implements BackendRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final a f6460a;

    /* renamed from: b  reason: collision with root package name */
    private final d f6461b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f6462c;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f6463a;

        /* renamed from: b  reason: collision with root package name */
        private Map f6464b = null;

        a(Context context) {
            this.f6463a = context;
        }

        private Map a(Context context) {
            Bundle d10 = d(context);
            if (d10 == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (String next : d10.keySet()) {
                Object obj = d10.get(next);
                if ((obj instanceof String) && next.startsWith("backend:")) {
                    for (String trim : ((String) obj).split(",", -1)) {
                        String trim2 = trim.trim();
                        if (!trim2.isEmpty()) {
                            hashMap.put(trim2, next.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }

        private Map c() {
            if (this.f6464b == null) {
                this.f6464b = a(this.f6463a);
            }
            return this.f6464b;
        }

        private static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public BackendFactory b(String str) {
            String str2 = (String) c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (BackendFactory) Class.forName(str2).asSubclass(BackendFactory.class).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            } catch (ClassNotFoundException e10) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", new Object[]{str2}), e10);
                return null;
            } catch (IllegalAccessException e11) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[]{str2}), e11);
                return null;
            } catch (InstantiationException e12) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[]{str2}), e12);
                return null;
            } catch (NoSuchMethodException e13) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[]{str2}), e13);
                return null;
            } catch (InvocationTargetException e14) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[]{str2}), e14);
                return null;
            }
        }
    }

    e(Context context, d dVar) {
        this(new a(context), dVar);
    }

    public synchronized TransportBackend get(String str) {
        if (this.f6462c.containsKey(str)) {
            return (TransportBackend) this.f6462c.get(str);
        }
        BackendFactory b10 = this.f6460a.b(str);
        if (b10 == null) {
            return null;
        }
        TransportBackend create = b10.create(this.f6461b.a(str));
        this.f6462c.put(str, create);
        return create;
    }

    e(a aVar, d dVar) {
        this.f6462c = new HashMap();
        this.f6460a = aVar;
        this.f6461b = dVar;
    }
}
