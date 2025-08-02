package com.google.android.gms.internal.measurement;

import c.d;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class z2 {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f7371a = Logger.getLogger(zzjm.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final String f7372b = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    static zzjr a(Class cls) {
        String str;
        Class<z2> cls2 = z2.class;
        ClassLoader classLoader = cls2.getClassLoader();
        if (cls.equals(zzjr.class)) {
            str = f7372b;
        } else if (!cls.getPackage().equals(cls2.getPackage())) {
            throw new IllegalArgumentException(cls.getName());
        } else {
            str = String.format("%s.BlazeGenerated%sLoader", new Object[]{cls.getPackage().getName(), cls.getSimpleName()});
        }
        try {
            d.a(Class.forName(str, true, classLoader).getConstructor((Class[]) null).newInstance((Object[]) null));
            throw null;
        } catch (NoSuchMethodException e10) {
            throw new IllegalStateException(e10);
        } catch (InstantiationException e11) {
            throw new IllegalStateException(e11);
        } catch (IllegalAccessException e12) {
            throw new IllegalStateException(e12);
        } catch (InvocationTargetException e13) {
            throw new IllegalStateException(e13);
        } catch (ClassNotFoundException unused) {
            Iterator<S> it = ServiceLoader.load(cls2, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    d.a(it.next());
                    throw null;
                } catch (ServiceConfigurationError e14) {
                    f7371a.logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(cls.getSimpleName()), e14);
                }
            }
            if (arrayList.size() == 1) {
                return (zzjr) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzjr) cls.getMethod("combine", new Class[]{Collection.class}).invoke((Object) null, new Object[]{arrayList});
            } catch (NoSuchMethodException e15) {
                throw new IllegalStateException(e15);
            } catch (IllegalAccessException e16) {
                throw new IllegalStateException(e16);
            } catch (InvocationTargetException e17) {
                throw new IllegalStateException(e17);
            }
        }
    }
}
