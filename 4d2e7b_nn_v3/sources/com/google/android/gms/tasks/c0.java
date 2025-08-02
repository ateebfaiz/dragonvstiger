package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class c0 extends Task {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7831a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final x f7832b = new x();

    /* renamed from: c  reason: collision with root package name */
    private boolean f7833c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f7834d;

    /* renamed from: e  reason: collision with root package name */
    private Object f7835e;

    /* renamed from: f  reason: collision with root package name */
    private Exception f7836f;

    c0() {
    }

    private final void f() {
        Preconditions.checkState(this.f7833c, "Task is not yet complete");
    }

    private final void g() {
        if (this.f7834d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void h() {
        if (this.f7833c) {
            throw DuplicateTaskCompletionException.of(this);
        }
    }

    private final void i() {
        synchronized (this.f7831a) {
            try {
                if (this.f7833c) {
                    this.f7832b.b(this);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final void a(Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.f7831a) {
            h();
            this.f7833c = true;
            this.f7836f = exc;
        }
        this.f7832b.b(this);
    }

    public final Task addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        m mVar = new m(TaskExecutors.MAIN_THREAD, onCanceledListener);
        this.f7832b.a(mVar);
        b0.a(activity).b(mVar);
        i();
        return this;
    }

    public final Task addOnCompleteListener(Activity activity, OnCompleteListener onCompleteListener) {
        o oVar = new o(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.f7832b.a(oVar);
        b0.a(activity).b(oVar);
        i();
        return this;
    }

    public final Task addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        q qVar = new q(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.f7832b.a(qVar);
        b0.a(activity).b(qVar);
        i();
        return this;
    }

    public final Task addOnSuccessListener(Activity activity, OnSuccessListener onSuccessListener) {
        t tVar = new t(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.f7832b.a(tVar);
        b0.a(activity).b(tVar);
        i();
        return this;
    }

    public final void b(Object obj) {
        synchronized (this.f7831a) {
            h();
            this.f7833c = true;
            this.f7835e = obj;
        }
        this.f7832b.b(this);
    }

    public final boolean c() {
        synchronized (this.f7831a) {
            try {
                if (this.f7833c) {
                    return false;
                }
                this.f7833c = true;
                this.f7834d = true;
                this.f7832b.b(this);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final Task continueWith(Continuation continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    public final Task continueWithTask(Continuation continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    public final boolean d(Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.f7831a) {
            try {
                if (this.f7833c) {
                    return false;
                }
                this.f7833c = true;
                this.f7836f = exc;
                this.f7832b.b(this);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final boolean e(Object obj) {
        synchronized (this.f7831a) {
            try {
                if (this.f7833c) {
                    return false;
                }
                this.f7833c = true;
                this.f7835e = obj;
                this.f7832b.b(this);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final Exception getException() {
        Exception exc;
        synchronized (this.f7831a) {
            exc = this.f7836f;
        }
        return exc;
    }

    public final Object getResult() {
        Object obj;
        synchronized (this.f7831a) {
            try {
                f();
                g();
                Exception exc = this.f7836f;
                if (exc == null) {
                    obj = this.f7835e;
                } else {
                    throw new RuntimeExecutionException(exc);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public final boolean isCanceled() {
        return this.f7834d;
    }

    public final boolean isComplete() {
        boolean z10;
        synchronized (this.f7831a) {
            z10 = this.f7833c;
        }
        return z10;
    }

    public final boolean isSuccessful() {
        boolean z10;
        synchronized (this.f7831a) {
            try {
                z10 = false;
                if (this.f7833c && !this.f7834d && this.f7836f == null) {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public final Task onSuccessTask(SuccessContinuation successContinuation) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        c0 c0Var = new c0();
        this.f7832b.a(new v(executor, successContinuation, c0Var));
        i();
        return c0Var;
    }

    public final Task continueWith(Executor executor, Continuation continuation) {
        c0 c0Var = new c0();
        this.f7832b.a(new i(executor, continuation, c0Var));
        i();
        return c0Var;
    }

    public final Task continueWithTask(Executor executor, Continuation continuation) {
        c0 c0Var = new c0();
        this.f7832b.a(new k(executor, continuation, c0Var));
        i();
        return c0Var;
    }

    public final Task addOnCanceledListener(OnCanceledListener onCanceledListener) {
        addOnCanceledListener(TaskExecutors.MAIN_THREAD, onCanceledListener);
        return this;
    }

    public final Task addOnCompleteListener(OnCompleteListener onCompleteListener) {
        this.f7832b.a(new o(TaskExecutors.MAIN_THREAD, onCompleteListener));
        i();
        return this;
    }

    public final Task addOnFailureListener(OnFailureListener onFailureListener) {
        addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    public final Task addOnSuccessListener(OnSuccessListener onSuccessListener) {
        addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        return this;
    }

    public final Task onSuccessTask(Executor executor, SuccessContinuation successContinuation) {
        c0 c0Var = new c0();
        this.f7832b.a(new v(executor, successContinuation, c0Var));
        i();
        return c0Var;
    }

    public final Task addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        this.f7832b.a(new m(executor, onCanceledListener));
        i();
        return this;
    }

    public final Task addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.f7832b.a(new q(executor, onFailureListener));
        i();
        return this;
    }

    public final Task addOnSuccessListener(Executor executor, OnSuccessListener onSuccessListener) {
        this.f7832b.a(new t(executor, onSuccessListener));
        i();
        return this;
    }

    public final Task addOnCompleteListener(Executor executor, OnCompleteListener onCompleteListener) {
        this.f7832b.a(new o(executor, onCompleteListener));
        i();
        return this;
    }

    public final Object getResult(Class cls) {
        Object obj;
        synchronized (this.f7831a) {
            try {
                f();
                g();
                if (!cls.isInstance(this.f7836f)) {
                    Exception exc = this.f7836f;
                    if (exc == null) {
                        obj = this.f7835e;
                    } else {
                        throw new RuntimeExecutionException(exc);
                    }
                } else {
                    throw ((Throwable) cls.cast(this.f7836f));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
