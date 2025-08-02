package com.bugsnag.android;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class AnrPlugin implements i3 {
    private static final String ANR_ERROR_CLASS = "ANR";
    private static final String ANR_ERROR_MSG = "Application did not respond to UI input";
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String LOAD_ERR_MSG = "Native library could not be linked. Bugsnag will not report ANRs. See https://docs.bugsnag.com/platforms/android/anr-link-errors";
    private z client;
    private final c collector = new c();
    private final r2 libraryLoader = new r2();
    private final AtomicBoolean oneTimeSetupPerformed = new AtomicBoolean(false);

    public static final class a {
        private a() {
        }

        public final boolean a(StackTraceElement[] stackTraceElementArr) {
            if (stackTraceElementArr.length == 0) {
                return false;
            }
            return ((StackTraceElement) j.v(stackTraceElementArr)).isNativeMethod();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final native void disableAnrReporting();

    private final native void enableAnrReporting();

    private final void initNativePlugin() {
        enableAnrReporting();
        z zVar = this.client;
        if (zVar == null) {
            m.u("client");
            zVar = null;
        }
        zVar.f19174q.f("Initialised ANR Plugin");
    }

    /* access modifiers changed from: private */
    /* renamed from: load$lambda-0  reason: not valid java name */
    public static final void m166load$lambda0(AnrPlugin anrPlugin) {
        anrPlugin.initNativePlugin();
    }

    private final Class<?> loadClass(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private final void notifyAnrDetected(List<NativeStackframe> list) {
        Object obj;
        z zVar = null;
        try {
            z zVar2 = this.client;
            if (zVar2 == null) {
                m.u("client");
                zVar2 = null;
            }
            if (!zVar2.f19158a.N(ANR_ERROR_CLASS)) {
                StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                boolean a10 = Companion.a(stackTrace);
                RuntimeException runtimeException = new RuntimeException();
                runtimeException.setStackTrace(stackTrace);
                z zVar3 = this.client;
                if (zVar3 == null) {
                    m.u("client");
                    zVar3 = null;
                }
                o1 createEvent = NativeInterface.createEvent(runtimeException, zVar3, q3.h("anrError"));
                k1 k1Var = (k1) createEvent.h().get(0);
                k1Var.g(ANR_ERROR_CLASS);
                k1Var.h(ANR_ERROR_MSG);
                if (a10) {
                    Iterable<NativeStackframe> iterable = list;
                    ArrayList arrayList = new ArrayList(r.v(iterable, 10));
                    for (NativeStackframe s3Var : iterable) {
                        arrayList.add(new s3(s3Var));
                    }
                    k1Var.d().addAll(0, arrayList);
                    Iterator it = createEvent.l().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((a4) obj).a()) {
                            break;
                        }
                    }
                    a4 a4Var = (a4) obj;
                    if (a4Var != null) {
                        List d10 = a4Var.d();
                        if (d10 != null) {
                            d10.addAll(0, arrayList);
                        }
                    }
                }
                c cVar = this.collector;
                z zVar4 = this.client;
                if (zVar4 == null) {
                    m.u("client");
                    zVar4 = null;
                }
                cVar.d(zVar4, createEvent);
            }
        } catch (Exception e10) {
            z zVar5 = this.client;
            if (zVar5 == null) {
                m.u("client");
            } else {
                zVar = zVar5;
            }
            zVar.f19174q.e("Internal error reporting ANR", e10);
        }
    }

    private final void performOneTimeSetup(z zVar) {
        Class<?> loadClass;
        i3 x10;
        if (this.libraryLoader.c("bugsnag-plugin-android-anr", zVar, new d()) && (loadClass = loadClass("com.bugsnag.android.NdkPlugin")) != null && (x10 = zVar.x(loadClass)) != null) {
            Object invoke = x10.getClass().getMethod("getSignalUnwindStackFunction", (Class[]) null).invoke(x10, (Object[]) null);
            if (invoke != null) {
                setUnwindFunction(((Long) invoke).longValue());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: performOneTimeSetup$lambda-1  reason: not valid java name */
    public static final boolean m167performOneTimeSetup$lambda1(o1 o1Var) {
        k1 k1Var = (k1) o1Var.h().get(0);
        o1Var.b("LinkError", "errorClass", k1Var.b());
        o1Var.b("LinkError", "errorMessage", k1Var.c());
        k1Var.g("AnrLinkError");
        k1Var.h(LOAD_ERR_MSG);
        return true;
    }

    private final native void setUnwindFunction(long j10);

    public void load(z zVar) {
        this.client = zVar;
        if (!this.oneTimeSetupPerformed.getAndSet(true)) {
            performOneTimeSetup(zVar);
        }
        if (this.libraryLoader.a()) {
            Looper mainLooper = Looper.getMainLooper();
            if (m.b(Looper.myLooper(), mainLooper)) {
                initNativePlugin();
            } else {
                new Handler(mainLooper).postAtFrontOfQueue(new e(this));
            }
        } else {
            zVar.f19174q.a(LOAD_ERR_MSG);
        }
    }

    public void unload() {
        if (this.libraryLoader.a()) {
            disableAnrReporting();
        }
    }
}
