package r6;

import android.util.SparseArray;
import com.alibaba.pdns.f;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.appregistry.AppRegistry;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class c {

    /* renamed from: g  reason: collision with root package name */
    private static final WeakHashMap f12932g = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f12933a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Set f12934b = new CopyOnWriteArraySet();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f12935c = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    private final Set f12936d = new CopyOnWriteArraySet();

    /* renamed from: e  reason: collision with root package name */
    private final Map f12937e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    private final SparseArray f12938f = new SparseArray();

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f12939a;

        a(int i10) {
            this.f12939a = i10;
        }

        public void run() {
            for (d a10 : c.this.f12934b) {
                a10.a(this.f12939a);
            }
        }
    }

    private c(ReactContext reactContext) {
        this.f12933a = new WeakReference(reactContext);
    }

    public static c e(ReactContext reactContext) {
        WeakHashMap weakHashMap = f12932g;
        c cVar = (c) weakHashMap.get(reactContext);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(reactContext);
        weakHashMap.put(reactContext, cVar2);
        return cVar2;
    }

    private void j(int i10) {
        Runnable runnable = (Runnable) this.f12938f.get(i10);
        if (runnable != null) {
            UiThreadUtil.removeOnUiThread(runnable);
            this.f12938f.remove(i10);
        }
    }

    private void l(int i10, long j10) {
        b bVar = new b(this, i10);
        this.f12938f.append(i10, bVar);
        UiThreadUtil.runOnUiThread(bVar, j10);
    }

    private synchronized void n(a aVar, int i10) {
        try {
            UiThreadUtil.assertOnUiThread();
            ReactContext reactContext = (ReactContext) p5.a.d((ReactContext) this.f12933a.get(), "Tried to start a task on a react context that has already been destroyed");
            if (reactContext.getLifecycleState() == LifecycleState.RESUMED) {
                if (!aVar.e()) {
                    throw new IllegalStateException("Tried to start task " + aVar.c() + " while in foreground, but this is not allowed.");
                }
            }
            this.f12936d.add(Integer.valueOf(i10));
            this.f12937e.put(Integer.valueOf(i10), new a(aVar));
            if (reactContext.hasActiveReactInstance()) {
                ((AppRegistry) reactContext.getJSModule(AppRegistry.class)).startHeadlessTask(i10, aVar.c(), aVar.a());
            } else {
                ReactSoftExceptionLogger.logSoftException("HeadlessJsTaskContext", new RuntimeException("Cannot start headless task, CatalystInstance not available"));
            }
            if (aVar.d() > 0) {
                l(i10, aVar.d());
            }
            for (d b10 : this.f12934b) {
                b10.b(i10);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void c(d dVar) {
        this.f12934b.add(dVar);
        for (Integer intValue : this.f12936d) {
            dVar.b(intValue.intValue());
        }
    }

    /* renamed from: d */
    public synchronized void h(int i10) {
        boolean remove = this.f12936d.remove(Integer.valueOf(i10));
        this.f12937e.remove(Integer.valueOf(i10));
        j(i10);
        if (remove) {
            UiThreadUtil.runOnUiThread(new a(i10));
        }
    }

    public boolean f() {
        if (this.f12936d.size() > 0) {
            return true;
        }
        return false;
    }

    public synchronized boolean g(int i10) {
        return this.f12936d.contains(Integer.valueOf(i10));
    }

    public void i(d dVar) {
        this.f12934b.remove(dVar);
    }

    public synchronized boolean k(int i10) {
        boolean z10;
        a aVar = (a) this.f12937e.get(Integer.valueOf(i10));
        if (aVar != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        p5.a.b(z10, "Tried to retrieve non-existent task config with id " + i10 + f.G);
        aVar.b();
        throw null;
    }

    public synchronized int m(a aVar) {
        int incrementAndGet;
        incrementAndGet = this.f12935c.incrementAndGet();
        n(aVar, incrementAndGet);
        return incrementAndGet;
    }
}
