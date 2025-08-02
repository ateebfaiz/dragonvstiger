package e2;

import e2.a;
import e2.c;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import l2.b;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21162a;

    /* renamed from: b  reason: collision with root package name */
    public static final f f21163b = new f();

    private static final class a extends ObjectInputStream {

        /* renamed from: a  reason: collision with root package name */
        public static final C0264a f21164a = new C0264a((DefaultConstructorMarker) null);

        /* renamed from: e2.f$a$a  reason: collision with other inner class name */
        public static final class C0264a {
            private C0264a() {
            }

            public /* synthetic */ C0264a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a(InputStream inputStream) {
            super(inputStream);
        }

        /* access modifiers changed from: protected */
        public ObjectStreamClass readClassDescriptor() {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            m.e(readClassDescriptor, "resultClassDescriptor");
            if (m.b(readClassDescriptor.getName(), "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                readClassDescriptor = ObjectStreamClass.lookup(a.b.class);
            } else if (m.b(readClassDescriptor.getName(), "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2")) {
                readClassDescriptor = ObjectStreamClass.lookup(c.b.class);
            }
            m.e(readClassDescriptor, "resultClassDescriptor");
            return readClassDescriptor;
        }
    }

    static {
        String name = f.class.getName();
        m.e(name, "AppEventStore::class.java.name");
        f21162a = name;
    }

    private f() {
    }

    public static final synchronized void a(a aVar, o oVar) {
        synchronized (f.class) {
            if (!v5.a.d(f.class)) {
                try {
                    m.f(aVar, "accessTokenAppIdPair");
                    m.f(oVar, "appEvents");
                    b.b();
                    n c10 = c();
                    c10.a(aVar, oVar.d());
                    d(c10);
                } catch (Throwable th) {
                    v5.a.b(th, f.class);
                }
            }
        }
    }

    public static final synchronized void b(d dVar) {
        synchronized (f.class) {
            if (!v5.a.d(f.class)) {
                try {
                    m.f(dVar, "eventsToPersist");
                    b.b();
                    n c10 = c();
                    for (a aVar : dVar.f()) {
                        o c11 = dVar.c(aVar);
                        if (c11 != null) {
                            c10.a(aVar, c11.d());
                        } else {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                    }
                    d(c10);
                } catch (Throwable th) {
                    v5.a.b(th, f.class);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x00a9 A[Catch:{ all -> 0x0040 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized e2.n c() {
        /*
            java.lang.Class<e2.f> r0 = e2.f.class
            monitor-enter(r0)
            java.lang.Class<e2.f> r1 = e2.f.class
            boolean r1 = v5.a.d(r1)     // Catch:{ all -> 0x00b7 }
            r2 = 0
            if (r1 == 0) goto L_0x000e
            monitor-exit(r0)
            return r2
        L_0x000e:
            l2.b.b()     // Catch:{ all -> 0x0040 }
            android.content.Context r1 = com.facebook.o.f()     // Catch:{ all -> 0x0040 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch:{ FileNotFoundException -> 0x005e, Exception -> 0x005b, all -> 0x0058 }
            java.lang.String r4 = "context.openFileInput(PERSISTED_EVENTS_FILENAME)"
            kotlin.jvm.internal.m.e(r3, r4)     // Catch:{ FileNotFoundException -> 0x005e, Exception -> 0x005b, all -> 0x0058 }
            e2.f$a r4 = new e2.f$a     // Catch:{ FileNotFoundException -> 0x005e, Exception -> 0x005b, all -> 0x0058 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x005e, Exception -> 0x005b, all -> 0x0058 }
            r5.<init>(r3)     // Catch:{ FileNotFoundException -> 0x005e, Exception -> 0x005b, all -> 0x0058 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x005e, Exception -> 0x005b, all -> 0x0058 }
            java.lang.Object r3 = r4.readObject()     // Catch:{ FileNotFoundException -> 0x0093, Exception -> 0x004e }
            if (r3 == 0) goto L_0x0050
            e2.n r3 = (e2.n) r3     // Catch:{ FileNotFoundException -> 0x0093, Exception -> 0x004e }
            q5.p0.i(r4)     // Catch:{ all -> 0x0040 }
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch:{ Exception -> 0x0043 }
            r1.delete()     // Catch:{ Exception -> 0x0043 }
            goto L_0x00a7
        L_0x0040:
            r1 = move-exception
            goto L_0x00b0
        L_0x0043:
            r1 = move-exception
            java.lang.String r4 = f21162a     // Catch:{ all -> 0x0040 }
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r4, r5, r1)     // Catch:{ all -> 0x0040 }
            goto L_0x00a7
        L_0x004c:
            r3 = move-exception
            goto L_0x007d
        L_0x004e:
            r3 = move-exception
            goto L_0x0060
        L_0x0050:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ FileNotFoundException -> 0x0093, Exception -> 0x004e }
            java.lang.String r5 = "null cannot be cast to non-null type com.facebook.appevents.PersistedEvents"
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0093, Exception -> 0x004e }
            throw r3     // Catch:{ FileNotFoundException -> 0x0093, Exception -> 0x004e }
        L_0x0058:
            r3 = move-exception
            r4 = r2
            goto L_0x007d
        L_0x005b:
            r3 = move-exception
            r4 = r2
            goto L_0x0060
        L_0x005e:
            r4 = r2
            goto L_0x0093
        L_0x0060:
            java.lang.String r5 = f21162a     // Catch:{ all -> 0x004c }
            java.lang.String r6 = "Got unexpected exception while reading events: "
            android.util.Log.w(r5, r6, r3)     // Catch:{ all -> 0x004c }
            q5.p0.i(r4)     // Catch:{ all -> 0x0040 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x0074 }
            r1.delete()     // Catch:{ Exception -> 0x0074 }
            goto L_0x00a6
        L_0x0074:
            r1 = move-exception
            java.lang.String r3 = f21162a     // Catch:{ all -> 0x0040 }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
        L_0x0079:
            android.util.Log.w(r3, r4, r1)     // Catch:{ all -> 0x0040 }
            goto L_0x00a6
        L_0x007d:
            q5.p0.i(r4)     // Catch:{ all -> 0x0040 }
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch:{ Exception -> 0x008a }
            r1.delete()     // Catch:{ Exception -> 0x008a }
            goto L_0x0092
        L_0x008a:
            r1 = move-exception
            java.lang.String r4 = f21162a     // Catch:{ all -> 0x0040 }
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r4, r5, r1)     // Catch:{ all -> 0x0040 }
        L_0x0092:
            throw r3     // Catch:{ all -> 0x0040 }
        L_0x0093:
            q5.p0.i(r4)     // Catch:{ all -> 0x0040 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x00a0 }
            r1.delete()     // Catch:{ Exception -> 0x00a0 }
            goto L_0x00a6
        L_0x00a0:
            r1 = move-exception
            java.lang.String r3 = f21162a     // Catch:{ all -> 0x0040 }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            goto L_0x0079
        L_0x00a6:
            r3 = r2
        L_0x00a7:
            if (r3 != 0) goto L_0x00ae
            e2.n r3 = new e2.n     // Catch:{ all -> 0x0040 }
            r3.<init>()     // Catch:{ all -> 0x0040 }
        L_0x00ae:
            monitor-exit(r0)
            return r3
        L_0x00b0:
            java.lang.Class<e2.f> r3 = e2.f.class
            v5.a.b(r1, r3)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r0)
            return r2
        L_0x00b7:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.f.c():e2.n");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:13|14|16|17|18|19|21|22|27) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003d */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void d(e2.n r7) {
        /*
            java.lang.String r0 = "AppEventsLogger.persistedevents"
            java.lang.Class<e2.f> r1 = e2.f.class
            boolean r2 = v5.a.d(r1)
            if (r2 == 0) goto L_0x000b
            return
        L_0x000b:
            android.content.Context r2 = com.facebook.o.f()     // Catch:{ all -> 0x0026 }
            r3 = 0
            java.io.ObjectOutputStream r4 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x002b }
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x002b }
            r6 = 0
            java.io.FileOutputStream r6 = r2.openFileOutput(r0, r6)     // Catch:{ all -> 0x002b }
            r5.<init>(r6)     // Catch:{ all -> 0x002b }
            r4.<init>(r5)     // Catch:{ all -> 0x002b }
            r4.writeObject(r7)     // Catch:{ all -> 0x0028 }
            q5.p0.i(r4)     // Catch:{ all -> 0x0026 }
            goto L_0x0040
        L_0x0026:
            r7 = move-exception
            goto L_0x0045
        L_0x0028:
            r7 = move-exception
            r3 = r4
            goto L_0x002c
        L_0x002b:
            r7 = move-exception
        L_0x002c:
            java.lang.String r4 = f21162a     // Catch:{ all -> 0x003b }
            java.lang.String r5 = "Got unexpected exception while persisting events: "
            android.util.Log.w(r4, r5, r7)     // Catch:{ all -> 0x003b }
            java.io.File r7 = r2.getFileStreamPath(r0)     // Catch:{ Exception -> 0x003d }
            r7.delete()     // Catch:{ Exception -> 0x003d }
            goto L_0x003d
        L_0x003b:
            r7 = move-exception
            goto L_0x0041
        L_0x003d:
            q5.p0.i(r3)     // Catch:{ all -> 0x0026 }
        L_0x0040:
            return
        L_0x0041:
            q5.p0.i(r3)     // Catch:{ all -> 0x0026 }
            throw r7     // Catch:{ all -> 0x0026 }
        L_0x0045:
            v5.a.b(r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.f.d(e2.n):void");
    }
}
