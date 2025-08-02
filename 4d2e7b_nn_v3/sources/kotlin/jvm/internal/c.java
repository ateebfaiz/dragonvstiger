package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import zb.b;
import zb.d;
import zb.h;
import zb.k;
import zb.m;

public abstract class c implements b, Serializable {
    public static final Object NO_RECEIVER = a.f710a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient b reflected;
    private final String signature;

    private static class a implements Serializable {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f710a = new a();

        private a() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f710a;
        }
    }

    public c() {
        this(NO_RECEIVER);
    }

    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public b compute() {
        b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        b computeReflected = computeReflected();
        this.reflected = computeReflected;
        return computeReflected;
    }

    /* access modifiers changed from: protected */
    public abstract b computeReflected();

    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (this.isTopLevel) {
            return z.c(cls);
        }
        return z.b(cls);
    }

    public List<h> getParameters() {
        return getReflected().getParameters();
    }

    /* access modifiers changed from: protected */
    public b getReflected() {
        b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new ub.b();
    }

    public k getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    public m getVisibility() {
        return getReflected().getVisibility();
    }

    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    public boolean isFinal() {
        return getReflected().isFinal();
    }

    public boolean isOpen() {
        return getReflected().isOpen();
    }

    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    protected c(Object obj) {
        this(obj, (Class) null, (String) null, (String) null, false);
    }

    protected c(Object obj, Class cls, String str, String str2, boolean z10) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z10;
    }
}
