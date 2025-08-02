package com.bugsnag.android;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.o;
import kotlin.p;
import kotlin.text.j;

public final class c {

    /* renamed from: b  reason: collision with root package name */
    public static final a f18647b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final HandlerThread f18648a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f18649a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f18650b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicInteger f18651c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Handler f18652d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ o1 f18653e;

        b(c cVar, z zVar, AtomicInteger atomicInteger, Handler handler, o1 o1Var) {
            this.f18649a = cVar;
            this.f18650b = zVar;
            this.f18651c = atomicInteger;
            this.f18652d = handler;
            this.f18653e = o1Var;
        }

        public void run() {
            ActivityManager.ProcessErrorStateInfo c10 = this.f18649a.c(this.f18650b.f19166i);
            if (c10 != null) {
                this.f18649a.a(this.f18653e, c10);
                this.f18650b.K(this.f18653e, (h3) null);
            } else if (this.f18651c.getAndIncrement() < 300) {
                this.f18652d.postDelayed(this, 100);
            }
        }
    }

    public c() {
        HandlerThread handlerThread = new HandlerThread("bugsnag-anr-collector");
        this.f18648a = handlerThread;
        handlerThread.start();
    }

    public final void a(o1 o1Var, ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        String str = processErrorStateInfo.shortMsg;
        if (!o1Var.h().isEmpty()) {
            k1 k1Var = (k1) o1Var.h().get(0);
            if (j.F(str, "ANR", false, 2, (Object) null)) {
                str = j.B(str, "ANR", "", false, 4, (Object) null);
            }
            k1Var.h(str);
        }
    }

    public final ActivityManager.ProcessErrorStateInfo b(ActivityManager activityManager, int i10) {
        List<ActivityManager.ProcessErrorStateInfo> list;
        Object obj;
        if (activityManager == null) {
            list = null;
        } else {
            try {
                list = activityManager.getProcessesInErrorState();
            } catch (RuntimeException unused) {
                return null;
            }
        }
        if (list == null) {
            list = r.l();
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ActivityManager.ProcessErrorStateInfo) obj).pid == i10) {
                break;
            }
        }
        return (ActivityManager.ProcessErrorStateInfo) obj;
    }

    public final ActivityManager.ProcessErrorStateInfo c(Context context) {
        Object obj;
        ActivityManager activityManager;
        ActivityManager activityManager2 = null;
        try {
            o.a aVar = o.f12592b;
            Object systemService = context.getSystemService("activity");
            if (systemService instanceof ActivityManager) {
                activityManager = (ActivityManager) systemService;
            } else {
                activityManager = null;
            }
            obj = o.b(activityManager);
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            obj = o.b(p.a(th));
        }
        if (!o.f(obj)) {
            activityManager2 = obj;
        }
        return b(activityManager2, Process.myPid());
    }

    public final void d(z zVar, o1 o1Var) {
        Handler handler = new Handler(this.f18648a.getLooper());
        handler.post(new b(this, zVar, new AtomicInteger(), handler, o1Var));
    }
}
