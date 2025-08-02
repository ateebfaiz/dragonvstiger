package com.google.android.gms.dynamite;

import dalvik.system.PathClassLoader;

final class d extends PathClassLoader {
    d(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    /* access modifiers changed from: protected */
    public final Class loadClass(String str, boolean z10) {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        return super.loadClass(str, z10);
    }
}
