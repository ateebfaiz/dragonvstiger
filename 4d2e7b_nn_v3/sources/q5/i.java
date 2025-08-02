package q5;

import android.app.Activity;
import android.util.Log;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import com.facebook.g;
import com.facebook.j;
import com.facebook.l;
import com.facebook.o;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class i {

    /* renamed from: f  reason: collision with root package name */
    public static final Object f23332f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static final a f23333g = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Activity f23334a;

    /* renamed from: b  reason: collision with root package name */
    private final u f23335b;

    /* renamed from: c  reason: collision with root package name */
    private List f23336c;

    /* renamed from: d  reason: collision with root package name */
    private int f23337d;

    /* renamed from: e  reason: collision with root package name */
    private g f23338e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    protected abstract class b {

        /* renamed from: a  reason: collision with root package name */
        private Object f23339a = i.f23332f;

        public b() {
        }

        public abstract boolean a(Object obj, boolean z10);

        public abstract a b(Object obj);

        public Object c() {
            return this.f23339a;
        }
    }

    protected i(Activity activity, int i10) {
        m.f(activity, "activity");
        this.f23334a = activity;
        this.f23335b = null;
        this.f23337d = i10;
        this.f23338e = null;
    }

    private final List a() {
        if (this.f23336c == null) {
            this.f23336c = g();
        }
        List list = this.f23336c;
        if (list != null) {
            return list;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.facebook.internal.FacebookDialogBase<CONTENT, RESULT>.ModeHandler>");
    }

    private final a d(Object obj, Object obj2) {
        boolean z10;
        a aVar;
        if (obj2 == f23332f) {
            z10 = true;
        } else {
            z10 = false;
        }
        Iterator it = a().iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            b bVar = (b) it.next();
            if ((z10 || p0.c(bVar.c(), obj2)) && bVar.a(obj, true)) {
                try {
                    aVar = bVar.b(obj);
                    break;
                } catch (l e10) {
                    a e11 = e();
                    h.k(e11, e10);
                    aVar = e11;
                }
            }
        }
        if (aVar != null) {
            return aVar;
        }
        a e12 = e();
        h.h(e12);
        return e12;
    }

    private final void i(g gVar) {
        g gVar2 = this.f23338e;
        if (gVar2 == null) {
            this.f23338e = gVar;
        } else if (gVar2 != gVar) {
            Log.w("FacebookDialog", "You're registering a callback on a Facebook dialog with two different callback managers. It's almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    public boolean b(Object obj) {
        return c(obj, f23332f);
    }

    /* access modifiers changed from: protected */
    public boolean c(Object obj, Object obj2) {
        boolean z10;
        m.f(obj2, "mode");
        if (obj2 == f23332f) {
            z10 = true;
        } else {
            z10 = false;
        }
        for (b bVar : a()) {
            if ((z10 || p0.c(bVar.c(), obj2)) && bVar.a(obj, false)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract a e();

    /* access modifiers changed from: protected */
    public final Activity f() {
        Activity activity = this.f23334a;
        if (activity != null) {
            return activity;
        }
        u uVar = this.f23335b;
        if (uVar != null) {
            return uVar.a();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract List g();

    public final int h() {
        return this.f23337d;
    }

    public void j(g gVar, j jVar) {
        m.f(gVar, "callbackManager");
        m.f(jVar, "callback");
        if (gVar instanceof d) {
            i(gVar);
            k((d) gVar, jVar);
            return;
        }
        throw new l("Unexpected CallbackManager, please use the provided Factory.");
    }

    /* access modifiers changed from: protected */
    public abstract void k(d dVar, j jVar);

    public final void l(g gVar) {
        this.f23338e = gVar;
    }

    public void m(Object obj) {
        n(obj, f23332f);
    }

    /* access modifiers changed from: protected */
    public void n(Object obj, Object obj2) {
        m.f(obj2, "mode");
        a d10 = d(obj, obj2);
        if (d10 == null) {
            Log.e("FacebookDialog", "No code path should ever result in a null appCall");
            if (!(!o.x())) {
                throw new IllegalStateException("No code path should ever result in a null appCall".toString());
            }
        } else if (f() instanceof ActivityResultRegistryOwner) {
            Activity f10 = f();
            if (f10 != null) {
                ActivityResultRegistry activityResultRegistry = ((ActivityResultRegistryOwner) f10).getActivityResultRegistry();
                m.e(activityResultRegistry, "registryOwner.activityResultRegistry");
                h.f(d10, activityResultRegistry, this.f23338e);
                d10.g();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.activity.result.ActivityResultRegistryOwner");
        } else {
            u uVar = this.f23335b;
            if (uVar != null) {
                h.g(d10, uVar);
                return;
            }
            Activity activity = this.f23334a;
            if (activity != null) {
                h.e(d10, activity);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o(android.content.Intent r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "intent"
            kotlin.jvm.internal.m.f(r4, r0)
            android.app.Activity r0 = r3.f()
            boolean r1 = r0 instanceof androidx.activity.result.ActivityResultRegistryOwner
            if (r1 == 0) goto L_0x001e
            androidx.activity.result.ActivityResultRegistryOwner r0 = (androidx.activity.result.ActivityResultRegistryOwner) r0
            androidx.activity.result.ActivityResultRegistry r0 = r0.getActivityResultRegistry()
            java.lang.String r1 = "(activity as ActivityRes…r).activityResultRegistry"
            kotlin.jvm.internal.m.e(r0, r1)
            com.facebook.g r1 = r3.f23338e
            q5.h.n(r0, r1, r4, r5)
            goto L_0x002b
        L_0x001e:
            if (r0 == 0) goto L_0x0024
            r0.startActivityForResult(r4, r5)
            goto L_0x002b
        L_0x0024:
            q5.u r0 = r3.f23335b
            if (r0 == 0) goto L_0x002d
            r0.d(r4, r5)
        L_0x002b:
            r4 = 0
            goto L_0x002f
        L_0x002d:
            java.lang.String r4 = "Failed to find Activity or Fragment to startActivityForResult "
        L_0x002f:
            if (r4 == 0) goto L_0x0046
            q5.d0$a r5 = q5.d0.f23283f
            com.facebook.w r0 = com.facebook.w.DEVELOPER_ERRORS
            java.lang.Class r1 = r3.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "this.javaClass.name"
            kotlin.jvm.internal.m.e(r1, r2)
            r2 = 6
            r5.a(r0, r2, r1, r4)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.i.o(android.content.Intent, int):void");
    }

    protected i(u uVar, int i10) {
        m.f(uVar, "fragmentWrapper");
        this.f23335b = uVar;
        this.f23334a = null;
        this.f23337d = i10;
        if (uVar.a() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity".toString());
        }
    }
}
