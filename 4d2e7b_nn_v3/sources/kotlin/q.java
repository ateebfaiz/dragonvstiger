package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

final class q<T> implements Lazy, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final a f12595d = new a((DefaultConstructorMarker) null);

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f12596e = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "b");

    /* renamed from: a  reason: collision with root package name */
    private volatile Function0 f12597a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f12598b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f12599c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public q(Function0 function0) {
        m.f(function0, "initializer");
        this.f12597a = function0;
        u uVar = u.f12606a;
        this.f12598b = uVar;
        this.f12599c = uVar;
    }

    private final Object writeReplace() {
        return new e(getValue());
    }

    public boolean a() {
        if (this.f12598b != u.f12606a) {
            return true;
        }
        return false;
    }

    public Object getValue() {
        Object obj = this.f12598b;
        u uVar = u.f12606a;
        if (obj != uVar) {
            return obj;
        }
        Function0 function0 = this.f12597a;
        if (function0 != null) {
            Object invoke = function0.invoke();
            if (androidx.concurrent.futures.a.a(f12596e, this, uVar, invoke)) {
                this.f12597a = null;
                return invoke;
            }
        }
        return this.f12598b;
    }

    public String toString() {
        if (a()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
