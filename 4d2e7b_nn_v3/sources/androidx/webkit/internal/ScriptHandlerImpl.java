package androidx.webkit.internal;

import androidx.webkit.ScriptHandler;
import gc.a;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.ScriptHandlerBoundaryInterface;

public class ScriptHandlerImpl implements ScriptHandler {
    private final ScriptHandlerBoundaryInterface mBoundaryInterface;

    private ScriptHandlerImpl(ScriptHandlerBoundaryInterface scriptHandlerBoundaryInterface) {
        this.mBoundaryInterface = scriptHandlerBoundaryInterface;
    }

    public static ScriptHandlerImpl toScriptHandler(InvocationHandler invocationHandler) {
        return new ScriptHandlerImpl((ScriptHandlerBoundaryInterface) a.a(ScriptHandlerBoundaryInterface.class, invocationHandler));
    }

    public void remove() {
        this.mBoundaryInterface.remove();
    }
}
