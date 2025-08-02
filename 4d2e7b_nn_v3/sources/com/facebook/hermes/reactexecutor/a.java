package com.facebook.hermes.reactexecutor;

import com.facebook.hermes.instrumentation.HermesSamplingProfiler;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;

public class a implements JavaScriptExecutorFactory {

    /* renamed from: a  reason: collision with root package name */
    private boolean f19956a;

    /* renamed from: b  reason: collision with root package name */
    private String f19957b;

    public a() {
        this((p4.a) null);
    }

    public JavaScriptExecutor create() {
        return new HermesExecutor((p4.a) null, this.f19956a, this.f19957b);
    }

    public void startSamplingProfiler() {
        HermesSamplingProfiler.enable();
    }

    public void stopSamplingProfiler(String str) {
        HermesSamplingProfiler.dumpSampledTraceToFile(str);
        HermesSamplingProfiler.disable();
    }

    public String toString() {
        return "JSIExecutor+HermesRuntime";
    }

    public a(p4.a aVar) {
        this.f19956a = true;
        this.f19957b = "";
    }
}
