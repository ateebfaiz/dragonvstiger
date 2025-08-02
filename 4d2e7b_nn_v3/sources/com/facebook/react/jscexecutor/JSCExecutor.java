package com.facebook.react.jscexecutor;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.soloader.SoLoader;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@d6.a
public final class JSCExecutor extends JavaScriptExecutor {

    /* renamed from: a  reason: collision with root package name */
    private static final a f3187a;

    private static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final HybridData b(ReadableNativeMap readableNativeMap) {
            return JSCExecutor.initHybrid(readableNativeMap);
        }

        public final void c() {
            SoLoader.t("jscexecutor");
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        a aVar = new a((DefaultConstructorMarker) null);
        f3187a = aVar;
        aVar.c();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JSCExecutor(ReadableNativeMap readableNativeMap) {
        super(f3187a.b(readableNativeMap));
        m.f(readableNativeMap, "jscConfig");
    }

    public static final void b() {
        f3187a.c();
    }

    /* access modifiers changed from: private */
    public static final native HybridData initHybrid(ReadableNativeMap readableNativeMap);

    public String getName() {
        return "JSCExecutor";
    }
}
