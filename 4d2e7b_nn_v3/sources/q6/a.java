package q6;

import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.jscexecutor.JSCExecutor;
import kotlin.jvm.internal.m;

public final class a implements JavaScriptExecutorFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f12908a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12909b;

    public a(String str, String str2) {
        m.f(str, "appName");
        m.f(str2, "deviceName");
        this.f12908a = str;
        this.f12909b = str2;
    }

    public JavaScriptExecutor create() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("OwnerIdentity", "ReactNative");
        writableNativeMap.putString("AppIdentity", this.f12908a);
        writableNativeMap.putString("DeviceIdentity", this.f12909b);
        return new JSCExecutor(writableNativeMap);
    }

    public void startSamplingProfiler() {
        throw new UnsupportedOperationException("Starting sampling profiler not supported on " + this);
    }

    public void stopSamplingProfiler(String str) {
        m.f(str, "filename");
        throw new UnsupportedOperationException("Stopping sampling profiler not supported on " + this);
    }

    public String toString() {
        return "JSIExecutor+JSCRuntime";
    }
}
