package v4;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.facebook.imagepipeline.producers.c0;
import com.facebook.imagepipeline.producers.e1;
import com.facebook.imagepipeline.producers.f;
import com.facebook.imagepipeline.producers.n;
import com.facebook.imagepipeline.producers.x0;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.t;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class b extends com.facebook.imagepipeline.producers.d {

    /* renamed from: d  reason: collision with root package name */
    private static final a f24395d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Call.Factory f24396a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Executor f24397b;

    /* renamed from: c  reason: collision with root package name */
    private final CacheControl f24398c;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: v4.b$b  reason: collision with other inner class name */
    public static final class C0347b extends c0 {

        /* renamed from: f  reason: collision with root package name */
        public long f24399f;

        /* renamed from: g  reason: collision with root package name */
        public long f24400g;

        /* renamed from: h  reason: collision with root package name */
        public long f24401h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0347b(n nVar, e1 e1Var) {
            super(nVar, e1Var);
            m.f(nVar, "consumer");
            m.f(e1Var, "producerContext");
        }
    }

    public static final class c extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Call f24402a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f24403b;

        c(Call call, b bVar) {
            this.f24402a = call;
            this.f24403b = bVar;
        }

        /* access modifiers changed from: private */
        public static final void f(Call call) {
            call.cancel();
        }

        public void a() {
            if (!m.b(Looper.myLooper(), Looper.getMainLooper())) {
                this.f24402a.cancel();
            } else {
                this.f24403b.f24397b.execute(new c(this.f24402a));
            }
        }
    }

    public static final class d implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C0347b f24404a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f24405b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x0.a f24406c;

        d(C0347b bVar, b bVar2, x0.a aVar) {
            this.f24404a = bVar;
            this.f24405b = bVar2;
            this.f24406c = aVar;
        }

        public void onFailure(Call call, IOException iOException) {
            m.f(call, NotificationCompat.CATEGORY_CALL);
            m.f(iOException, "e");
            this.f24405b.l(call, iOException, this.f24406c);
        }

        public void onResponse(Call call, Response response) {
            int i10;
            m.f(call, NotificationCompat.CATEGORY_CALL);
            m.f(response, "response");
            this.f24404a.f24400g = SystemClock.elapsedRealtime();
            ResponseBody body = response.body();
            Unit unit = null;
            if (body != null) {
                b bVar = this.f24405b;
                x0.a aVar = this.f24406c;
                C0347b bVar2 = this.f24404a;
                try {
                    if (!response.isSuccessful()) {
                        bVar.l(call, new IOException("Unexpected HTTP code " + response), aVar);
                    } else {
                        y4.a c10 = y4.a.f24890c.c(response.header("Content-Range"));
                        if (!(c10 == null || (c10.f24892a == 0 && c10.f24893b == Integer.MAX_VALUE))) {
                            bVar2.j(c10);
                            bVar2.i(8);
                        }
                        if (body.contentLength() < 0) {
                            i10 = 0;
                        } else {
                            i10 = (int) body.contentLength();
                        }
                        aVar.b(body.byteStream(), i10);
                    }
                } catch (Exception e10) {
                    try {
                        bVar.l(call, e10, aVar);
                    } catch (Throwable th) {
                        tb.c.a(body, th);
                        throw th;
                    }
                }
                Unit unit2 = Unit.f12577a;
                tb.c.a(body, (Throwable) null);
                unit = Unit.f12577a;
            }
            if (unit == null) {
                b bVar3 = this.f24405b;
                bVar3.l(call, new IOException("Response body null: " + response), this.f24406c);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Call.Factory factory, Executor executor, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(factory, executor, (i10 & 4) != 0 ? true : z10);
    }

    /* access modifiers changed from: private */
    public final void l(Call call, Exception exc, x0.a aVar) {
        if (call.isCanceled()) {
            aVar.a();
        } else {
            aVar.onFailure(exc);
        }
    }

    /* renamed from: h */
    public C0347b e(n nVar, e1 e1Var) {
        m.f(nVar, "consumer");
        m.f(e1Var, "context");
        return new C0347b(nVar, e1Var);
    }

    /* renamed from: i */
    public void d(C0347b bVar, x0.a aVar) {
        m.f(bVar, "fetchState");
        m.f(aVar, "callback");
        bVar.f24399f = SystemClock.elapsedRealtime();
        Uri g10 = bVar.g();
        m.e(g10, "fetchState.uri");
        try {
            Request.Builder builder = new Request.Builder().url(g10.toString()).get();
            CacheControl cacheControl = this.f24398c;
            if (cacheControl != null) {
                m.e(builder, "requestBuilder");
                builder.cacheControl(cacheControl);
            }
            y4.a b10 = bVar.b().b().b();
            if (b10 != null) {
                builder.addHeader("Range", b10.d());
            }
            Request build = builder.build();
            m.e(build, "requestBuilder.build()");
            j(bVar, aVar, build);
        } catch (Exception e10) {
            aVar.onFailure(e10);
        }
    }

    /* access modifiers changed from: protected */
    public void j(C0347b bVar, x0.a aVar, Request request) {
        m.f(bVar, "fetchState");
        m.f(aVar, "callback");
        m.f(request, "request");
        Call newCall = this.f24396a.newCall(request);
        bVar.b().h(new c(newCall, this));
        newCall.enqueue(new d(bVar, this, aVar));
    }

    /* renamed from: k */
    public Map c(C0347b bVar, int i10) {
        m.f(bVar, "fetchState");
        return i0.i(t.a("queue_time", String.valueOf(bVar.f24400g - bVar.f24399f)), t.a("fetch_time", String.valueOf(bVar.f24401h - bVar.f24400g)), t.a("total_time", String.valueOf(bVar.f24401h - bVar.f24399f)), t.a("image_size", String.valueOf(i10)));
    }

    /* renamed from: m */
    public void a(C0347b bVar, int i10) {
        m.f(bVar, "fetchState");
        bVar.f24401h = SystemClock.elapsedRealtime();
    }

    public b(Call.Factory factory, Executor executor, boolean z10) {
        m.f(factory, "callFactory");
        m.f(executor, "cancellationExecutor");
        this.f24396a = factory;
        this.f24397b = executor;
        this.f24398c = z10 ? new CacheControl.Builder().noStore().build() : null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(okhttp3.OkHttpClient r8) {
        /*
            r7 = this;
            java.lang.String r0 = "okHttpClient"
            kotlin.jvm.internal.m.f(r8, r0)
            okhttp3.Dispatcher r0 = r8.dispatcher()
            java.util.concurrent.ExecutorService r3 = r0.executorService()
            java.lang.String r0 = "okHttpClient.dispatcher().executorService()"
            kotlin.jvm.internal.m.e(r3, r0)
            r5 = 4
            r6 = 0
            r4 = 0
            r1 = r7
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.b.<init>(okhttp3.OkHttpClient):void");
    }
}
