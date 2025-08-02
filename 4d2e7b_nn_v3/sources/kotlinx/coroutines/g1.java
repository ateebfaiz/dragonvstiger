package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.m;

public final class g1 extends CancellationException {

    /* renamed from: a  reason: collision with root package name */
    public final transient f1 f1087a;

    public g1(String str, Throwable th, f1 f1Var) {
        super(str);
        this.f1087a = f1Var;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof g1) {
                g1 g1Var = (g1) obj;
                if (!m.b(g1Var.getMessage(), getMessage()) || !m.b(g1Var.f1087a, this.f1087a) || !m.b(g1Var.getCause(), getCause())) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        int i10;
        String message = getMessage();
        m.c(message);
        int hashCode = ((message.hashCode() * 31) + this.f1087a.hashCode()) * 31;
        Throwable cause = getCause();
        if (cause != null) {
            i10 = cause.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public String toString() {
        return super.toString() + "; job=" + this.f1087a;
    }
}
