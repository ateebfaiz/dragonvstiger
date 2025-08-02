package com.facebook.react.runtime.hermes;

import com.facebook.jni.HybridData;
import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.react.fabric.ReactNativeConfig;
import com.facebook.react.runtime.JSRuntimeFactory;
import com.facebook.soloader.SoLoader;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class HermesInstance extends JSRuntimeFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3468a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: protected */
        @DoNotStrip
        public final HybridData initHybrid(Object obj) {
            return HermesInstance.initHybrid(obj);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        SoLoader.t("hermesinstancejni");
    }

    public HermesInstance(ReactNativeConfig reactNativeConfig) {
        super(initHybrid(reactNativeConfig));
    }

    @DoNotStrip
    protected static final native HybridData initHybrid(Object obj);

    public HermesInstance() {
        this((ReactNativeConfig) null);
    }
}
