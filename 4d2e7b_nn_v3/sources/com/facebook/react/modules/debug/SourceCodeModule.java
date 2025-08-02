package com.facebook.react.modules.debug;

import com.facebook.fbreact.specs.NativeSourceCodeSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.m;
import kotlin.t;
import s6.a;

@a(name = "SourceCode")
public final class SourceCodeModule extends NativeSourceCodeSpec {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SourceCodeModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        m.f(reactApplicationContext, "reactContext");
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getTypedExportedConstants() {
        return i0.d(t.a("scriptURL", p5.a.d(getReactApplicationContext().getSourceURL(), "No source URL loaded, have you initialised the instance?")));
    }
}
