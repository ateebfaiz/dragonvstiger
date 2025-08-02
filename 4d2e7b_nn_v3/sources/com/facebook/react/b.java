package com.facebook.react;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.inject.Provider;

public abstract class b implements m0 {

    class a implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        Map.Entry f20743a = null;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Iterator f20744b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReactApplicationContext f20745c;

        a(Iterator it, ReactApplicationContext reactApplicationContext) {
            this.f20744b = it;
            this.f20745c = reactApplicationContext;
        }

        /* JADX WARNING: Removed duplicated region for block: B:2:0x0008  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a() {
            /*
                r3 = this;
            L_0x0000:
                java.util.Iterator r0 = r3.f20744b
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L_0x0024
                java.util.Iterator r0 = r3.f20744b
                java.lang.Object r0 = r0.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r1 = r0.getValue()
                com.facebook.react.module.model.ReactModuleInfo r1 = (com.facebook.react.module.model.ReactModuleInfo) r1
                boolean r2 = com.facebook.react.config.ReactFeatureFlags.useTurboModules
                if (r2 == 0) goto L_0x0021
                boolean r1 = r1.e()
                if (r1 == 0) goto L_0x0021
                goto L_0x0000
            L_0x0021:
                r3.f20743a = r0
                return
            L_0x0024:
                r0 = 0
                r3.f20743a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.b.a.a():void");
        }

        /* renamed from: b */
        public ModuleHolder next() {
            if (this.f20743a == null) {
                a();
            }
            Map.Entry entry = this.f20743a;
            if (entry != null) {
                a();
                return new ModuleHolder((ReactModuleInfo) entry.getValue(), new C0259b((String) entry.getKey(), this.f20745c));
            }
            throw new NoSuchElementException("ModuleHolder not found");
        }

        public boolean hasNext() {
            if (this.f20743a == null) {
                a();
            }
            if (this.f20743a != null) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Cannot remove native modules from the list");
        }
    }

    /* renamed from: com.facebook.react.b$b  reason: collision with other inner class name */
    private class C0259b implements Provider {

        /* renamed from: a  reason: collision with root package name */
        private final String f20747a;

        /* renamed from: b  reason: collision with root package name */
        private final ReactApplicationContext f20748b;

        public C0259b(String str, ReactApplicationContext reactApplicationContext) {
            this.f20747a = str;
            this.f20748b = reactApplicationContext;
        }

        /* renamed from: a */
        public NativeModule get() {
            return b.this.getModule(this.f20747a, this.f20748b);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Iterator d(Iterator it, ReactApplicationContext reactApplicationContext) {
        return new a(it, reactApplicationContext);
    }

    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactApplicationContext) {
        throw new UnsupportedOperationException("createNativeModules method is not supported. Use getModule() method instead.");
    }

    public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactApplicationContext) {
        List<ModuleSpec> viewManagers = getViewManagers(reactApplicationContext);
        if (viewManagers == null || viewManagers.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (ModuleSpec provider : viewManagers) {
            arrayList.add((ViewManager) provider.getProvider().get());
        }
        return arrayList;
    }

    public abstract NativeModule getModule(String str, ReactApplicationContext reactApplicationContext);

    /* access modifiers changed from: package-private */
    public Iterable<ModuleHolder> getNativeModuleIterator(ReactApplicationContext reactApplicationContext) {
        return new a(this, getReactModuleInfoProvider().a().entrySet().iterator(), reactApplicationContext);
    }

    public abstract t6.a getReactModuleInfoProvider();

    /* access modifiers changed from: protected */
    public List<ModuleSpec> getViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
