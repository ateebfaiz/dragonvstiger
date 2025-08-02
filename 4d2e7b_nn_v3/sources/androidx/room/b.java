package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class b {

    /* renamed from: a  reason: collision with root package name */
    final Context f16434a;

    /* renamed from: b  reason: collision with root package name */
    final String f16435b;

    /* renamed from: c  reason: collision with root package name */
    int f16436c;

    /* renamed from: d  reason: collision with root package name */
    final InvalidationTracker f16437d;

    /* renamed from: e  reason: collision with root package name */
    final InvalidationTracker.Observer f16438e;

    /* renamed from: f  reason: collision with root package name */
    IMultiInstanceInvalidationService f16439f;

    /* renamed from: g  reason: collision with root package name */
    final Executor f16440g;

    /* renamed from: h  reason: collision with root package name */
    final IMultiInstanceInvalidationCallback f16441h = new a();

    /* renamed from: i  reason: collision with root package name */
    final AtomicBoolean f16442i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    final ServiceConnection f16443j;

    /* renamed from: k  reason: collision with root package name */
    final Runnable f16444k;

    /* renamed from: l  reason: collision with root package name */
    final Runnable f16445l;

    /* renamed from: m  reason: collision with root package name */
    private final Runnable f16446m;

    class a extends IMultiInstanceInvalidationCallback.Stub {

        /* renamed from: androidx.room.b$a$a  reason: collision with other inner class name */
        class C0211a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String[] f16448a;

            C0211a(String[] strArr) {
                this.f16448a = strArr;
            }

            public void run() {
                b.this.f16437d.notifyObserversByTableNames(this.f16448a);
            }
        }

        a() {
        }

        public void onInvalidation(String[] strArr) {
            b.this.f16440g.execute(new C0211a(strArr));
        }
    }

    /* renamed from: androidx.room.b$b  reason: collision with other inner class name */
    class C0212b implements ServiceConnection {
        C0212b() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.f16439f = IMultiInstanceInvalidationService.Stub.asInterface(iBinder);
            b bVar = b.this;
            bVar.f16440g.execute(bVar.f16444k);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            b bVar = b.this;
            bVar.f16440g.execute(bVar.f16445l);
            b.this.f16439f = null;
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            try {
                b bVar = b.this;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = bVar.f16439f;
                if (iMultiInstanceInvalidationService != null) {
                    bVar.f16436c = iMultiInstanceInvalidationService.registerCallback(bVar.f16441h, bVar.f16435b);
                    b bVar2 = b.this;
                    bVar2.f16437d.addObserver(bVar2.f16438e);
                }
            } catch (RemoteException e10) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", e10);
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            b bVar = b.this;
            bVar.f16437d.removeObserver(bVar.f16438e);
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            b bVar = b.this;
            bVar.f16437d.removeObserver(bVar.f16438e);
            try {
                b bVar2 = b.this;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = bVar2.f16439f;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(bVar2.f16441h, bVar2.f16436c);
                }
            } catch (RemoteException e10) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e10);
            }
            b bVar3 = b.this;
            bVar3.f16434a.unbindService(bVar3.f16443j);
        }
    }

    class f extends InvalidationTracker.Observer {
        f(String[] strArr) {
            super(strArr);
        }

        /* access modifiers changed from: package-private */
        public boolean isRemote() {
            return true;
        }

        public void onInvalidated(Set set) {
            if (!b.this.f16442i.get()) {
                try {
                    b bVar = b.this;
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = bVar.f16439f;
                    if (iMultiInstanceInvalidationService != null) {
                        iMultiInstanceInvalidationService.broadcastInvalidation(bVar.f16436c, (String[]) set.toArray(new String[0]));
                    }
                } catch (RemoteException e10) {
                    Log.w("ROOM", "Cannot broadcast invalidation", e10);
                }
            }
        }
    }

    b(Context context, String str, InvalidationTracker invalidationTracker, Executor executor) {
        C0212b bVar = new C0212b();
        this.f16443j = bVar;
        this.f16444k = new c();
        this.f16445l = new d();
        this.f16446m = new e();
        Context applicationContext = context.getApplicationContext();
        this.f16434a = applicationContext;
        this.f16435b = str;
        this.f16437d = invalidationTracker;
        this.f16440g = executor;
        this.f16438e = new f((String[]) invalidationTracker.mTableIdLookup.keySet().toArray(new String[0]));
        applicationContext.bindService(new Intent(applicationContext, MultiInstanceInvalidationService.class), bVar, 1);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f16442i.compareAndSet(false, true)) {
            this.f16440g.execute(this.f16446m);
        }
    }
}
