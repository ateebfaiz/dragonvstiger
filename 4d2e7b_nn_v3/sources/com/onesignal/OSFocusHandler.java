package com.onesignal;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.onesignal.o3;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class OSFocusHandler {

    /* renamed from: b  reason: collision with root package name */
    public static final a f10290b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static boolean f10291c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static boolean f10292d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static boolean f10293e;

    /* renamed from: a  reason: collision with root package name */
    private Runnable f10294a;

    public static final class OnLostFocusWorker extends Worker {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnLostFocusWorker(Context context, WorkerParameters workerParameters) {
            super(context, workerParameters);
            m.f(context, "context");
            m.f(workerParameters, "workerParams");
        }

        public ListenableWorker.Result doWork() {
            OSFocusHandler.f10290b.a();
            ListenableWorker.Result success = ListenableWorker.Result.success();
            m.e(success, "success()");
            return success;
        }
    }

    public static final class a {
        private a() {
        }

        public final void a() {
            a b10 = b.b();
            if (b10 == null || b10.e() == null) {
                o3.E1(false);
            }
            o3.d1(o3.v.DEBUG, "OSFocusHandler running onAppLostFocus");
            OSFocusHandler.f10292d = true;
            o3.a1();
            OSFocusHandler.f10293e = true;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final Constraints d() {
        Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        m.e(build, "Builder()\n            .s…TED)\n            .build()");
        return build;
    }

    private final void h() {
        i();
        f10292d = false;
    }

    private final void i() {
        f10291c = false;
        Runnable runnable = this.f10294a;
        if (runnable != null) {
            i3.b().a(runnable);
        }
    }

    /* access modifiers changed from: private */
    public static final void n() {
        f10291c = true;
        o3.d1(o3.v.DEBUG, "OSFocusHandler setting stop state: true");
    }

    public final void e(String str, Context context) {
        m.f(str, "tag");
        m.f(context, "context");
        n3.a(context).cancelAllWorkByTag(str);
    }

    public final boolean f() {
        return f10292d;
    }

    public final boolean g() {
        return f10293e;
    }

    public final void j() {
        h();
        o3.d1(o3.v.DEBUG, "OSFocusHandler running onAppFocus");
        o3.Y0();
    }

    public final void k(String str, long j10, Context context) {
        m.f(str, "tag");
        m.f(context, "context");
        WorkRequest build = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(OnLostFocusWorker.class).setConstraints(d())).setInitialDelay(j10, TimeUnit.MILLISECONDS)).addTag(str)).build();
        m.e(build, "Builder(OnLostFocusWorke…tag)\n            .build()");
        n3.a(context).enqueueUniqueWork(str, ExistingWorkPolicy.KEEP, (OneTimeWorkRequest) build);
    }

    public final void l() {
        if (f10291c) {
            f10291c = false;
            this.f10294a = null;
            o3.d1(o3.v.DEBUG, "OSFocusHandler running onAppStartFocusLogic");
            o3.b1();
            return;
        }
        i();
    }

    public final void m() {
        j1 j1Var = new j1();
        i3.b().c(1500, j1Var);
        Unit unit = Unit.f12577a;
        this.f10294a = j1Var;
    }
}
