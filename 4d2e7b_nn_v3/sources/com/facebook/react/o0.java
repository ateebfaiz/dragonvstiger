package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.Iterator;
import java.util.List;

abstract class o0 {

    class a implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        int f20878a = 0;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f20879b;

        a(List list) {
            this.f20879b = list;
        }

        /* renamed from: a */
        public ModuleHolder next() {
            List list = this.f20879b;
            int i10 = this.f20878a;
            this.f20878a = i10 + 1;
            return new ModuleHolder((NativeModule) list.get(i10));
        }

        public boolean hasNext() {
            if (this.f20878a < this.f20879b.size()) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Cannot remove methods ");
        }
    }

    static Iterable b(m0 m0Var, ReactApplicationContext reactApplicationContext) {
        z2.a.b("ReactNative", m0Var.getClass().getSimpleName() + " is not a LazyReactPackage, falling back to old version.");
        return new n0(m0Var.createNativeModules(reactApplicationContext));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Iterator c(List list) {
        return new a(list);
    }
}
