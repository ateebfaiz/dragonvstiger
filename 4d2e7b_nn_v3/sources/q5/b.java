package q5;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.facebook.o;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class b {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String f23248f = b.class.getCanonicalName();

    /* renamed from: g  reason: collision with root package name */
    public static b f23249g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f23250h = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f23251a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public long f23252b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f23253c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f23254d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f23255e;

    public static final class a {
        private a() {
        }

        private final b a(b bVar) {
            bVar.f23252b = System.currentTimeMillis();
            b.f23249g = bVar;
            return bVar;
        }

        private final b b(Context context) {
            b c10 = c(context);
            if (c10 != null) {
                return c10;
            }
            b d10 = d(context);
            if (d10 == null) {
                return new b();
            }
            return d10;
        }

        private final b c(Context context) {
            Method G;
            Object P;
            boolean z10 = false;
            try {
                if (!(!g(context) || (G = p0.G("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class)) == null || (P = p0.P((Object) null, G, context)) == null)) {
                    Method F = p0.F(P.getClass(), "getId", new Class[0]);
                    Method F2 = p0.F(P.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
                    if (F != null) {
                        if (F2 != null) {
                            b bVar = new b();
                            bVar.f23251a = (String) p0.P(P, F, new Object[0]);
                            Boolean bool = (Boolean) p0.P(P, F2, new Object[0]);
                            if (bool != null) {
                                z10 = bool.booleanValue();
                            }
                            bVar.f23255e = z10;
                            return bVar;
                        }
                    }
                }
                return null;
            } catch (Exception e10) {
                p0.e0("android_id", e10);
                return null;
            }
        }

        private final b d(Context context) {
            c cVar = new c();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (context.bindService(intent, cVar, 1)) {
                    try {
                        C0323b bVar = new C0323b(cVar.a());
                        b bVar2 = new b();
                        bVar2.f23251a = bVar.M();
                        bVar2.f23255e = bVar.N();
                        return bVar2;
                    } catch (Exception e10) {
                        p0.e0("android_id", e10);
                    } finally {
                        context.unbindService(cVar);
                    }
                }
            } catch (SecurityException unused) {
            }
            return null;
        }

        private final String f(Context context) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getInstallerPackageName(context.getPackageName());
            }
            return null;
        }

        private final boolean g(Context context) {
            Method G = p0.G("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
            if (G == null) {
                return false;
            }
            Object P = p0.P((Object) null, G, context);
            if (!(P instanceof Integer) || (!m.b(P, 0))) {
                return false;
            }
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0087 A[Catch:{ Exception -> 0x0036, all -> 0x0033 }] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x008c A[Catch:{ Exception -> 0x0036, all -> 0x0033 }] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0091 A[Catch:{ Exception -> 0x0036, all -> 0x0033 }] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0112  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x011a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final q5.b e(android.content.Context r13) {
            /*
                r12 = this;
                java.lang.String r0 = "limit_tracking"
                java.lang.String r1 = "androidid"
                java.lang.String r2 = "aid"
                java.lang.String r3 = "context"
                kotlin.jvm.internal.m.f(r13, r3)
                q5.b r3 = r12.b(r13)
                r4 = 0
                android.os.Looper r5 = android.os.Looper.myLooper()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                android.os.Looper r6 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                boolean r5 = kotlin.jvm.internal.m.b(r5, r6)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                if (r5 != 0) goto L_0x00f0
                q5.b r5 = q5.b.f23249g     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                if (r5 == 0) goto L_0x003a
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                long r8 = r5.f23252b     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                long r6 = r6 - r8
                r8 = 3600000(0x36ee80, double:1.7786363E-317)
                int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r6 >= 0) goto L_0x003a
                return r5
            L_0x0033:
                r13 = move-exception
                goto L_0x0118
            L_0x0036:
                r13 = move-exception
                r0 = r4
                goto L_0x00f8
            L_0x003a:
                java.lang.String[] r7 = new java.lang.String[]{r2, r1, r0}     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                android.content.pm.PackageManager r5 = r13.getPackageManager()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                java.lang.String r6 = "com.facebook.katana.provider.AttributionIdProvider"
                r8 = 0
                android.content.pm.ProviderInfo r5 = r5.resolveContentProvider(r6, r8)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                android.content.pm.PackageManager r6 = r13.getPackageManager()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                java.lang.String r9 = "com.facebook.wakizashi.provider.AttributionIdProvider"
                android.content.pm.ProviderInfo r6 = r6.resolveContentProvider(r9, r8)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                if (r5 == 0) goto L_0x006a
                java.lang.String r5 = r5.packageName     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                java.lang.String r8 = "contentProviderInfo.packageName"
                kotlin.jvm.internal.m.e(r5, r8)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                boolean r5 = q5.m.a(r13, r5)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                if (r5 == 0) goto L_0x006a
                java.lang.String r5 = "content://com.facebook.katana.provider.AttributionIdProvider"
                android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            L_0x0068:
                r6 = r5
                goto L_0x0081
            L_0x006a:
                if (r6 == 0) goto L_0x0080
                java.lang.String r5 = r6.packageName     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                java.lang.String r6 = "wakizashiProviderInfo.packageName"
                kotlin.jvm.internal.m.e(r5, r6)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                boolean r5 = q5.m.a(r13, r5)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                if (r5 == 0) goto L_0x0080
                java.lang.String r5 = "content://com.facebook.wakizashi.provider.AttributionIdProvider"
                android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                goto L_0x0068
            L_0x0080:
                r6 = r4
            L_0x0081:
                java.lang.String r5 = r12.f(r13)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                if (r5 == 0) goto L_0x008a
                r3.f23254d = r5     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            L_0x008a:
                if (r6 != 0) goto L_0x0091
                q5.b r13 = r12.a(r3)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                return r13
            L_0x0091:
                android.content.ContentResolver r5 = r13.getContentResolver()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                r9 = 0
                r10 = 0
                r8 = 0
                android.database.Cursor r13 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                if (r13 == 0) goto L_0x00e6
                boolean r5 = r13.moveToFirst()     // Catch:{ Exception -> 0x00d9, all -> 0x00d5 }
                if (r5 != 0) goto L_0x00a5
                goto L_0x00e6
            L_0x00a5:
                int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x00d9, all -> 0x00d5 }
                int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x00d9, all -> 0x00d5 }
                int r0 = r13.getColumnIndex(r0)     // Catch:{ Exception -> 0x00d9, all -> 0x00d5 }
                java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x00d9, all -> 0x00d5 }
                r3.f23253c = r2     // Catch:{ Exception -> 0x00d9, all -> 0x00d5 }
                if (r1 <= 0) goto L_0x00de
                if (r0 <= 0) goto L_0x00de
                java.lang.String r2 = r3.h()     // Catch:{ Exception -> 0x00d9, all -> 0x00d5 }
                if (r2 != 0) goto L_0x00de
                java.lang.String r1 = r13.getString(r1)     // Catch:{ Exception -> 0x00d9, all -> 0x00d5 }
                r3.f23251a = r1     // Catch:{ Exception -> 0x00d9, all -> 0x00d5 }
                java.lang.String r0 = r13.getString(r0)     // Catch:{ Exception -> 0x00d9, all -> 0x00d5 }
                boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ Exception -> 0x00d9, all -> 0x00d5 }
                r3.f23255e = r0     // Catch:{ Exception -> 0x00d9, all -> 0x00d5 }
                goto L_0x00de
            L_0x00d5:
                r0 = move-exception
                r4 = r13
                r13 = r0
                goto L_0x0118
            L_0x00d9:
                r0 = move-exception
                r11 = r0
                r0 = r13
                r13 = r11
                goto L_0x00f8
            L_0x00de:
                r13.close()
                q5.b r13 = r12.a(r3)
                return r13
            L_0x00e6:
                q5.b r0 = r12.a(r3)     // Catch:{ Exception -> 0x00d9, all -> 0x00d5 }
                if (r13 == 0) goto L_0x00ef
                r13.close()
            L_0x00ef:
                return r0
            L_0x00f0:
                com.facebook.l r13 = new com.facebook.l     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                java.lang.String r0 = "getAttributionIdentifiers cannot be called on the main thread."
                r13.<init>((java.lang.String) r0)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
                throw r13     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            L_0x00f8:
                java.lang.String r1 = q5.b.f23248f     // Catch:{ all -> 0x0116 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0116 }
                r2.<init>()     // Catch:{ all -> 0x0116 }
                java.lang.String r3 = "Caught unexpected exception in getAttributionId(): "
                r2.append(r3)     // Catch:{ all -> 0x0116 }
                r2.append(r13)     // Catch:{ all -> 0x0116 }
                java.lang.String r13 = r2.toString()     // Catch:{ all -> 0x0116 }
                q5.p0.f0(r1, r13)     // Catch:{ all -> 0x0116 }
                if (r0 == 0) goto L_0x0115
                r0.close()
            L_0x0115:
                return r4
            L_0x0116:
                r13 = move-exception
                r4 = r0
            L_0x0118:
                if (r4 == 0) goto L_0x011d
                r4.close()
            L_0x011d:
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: q5.b.a.e(android.content.Context):q5.b");
        }

        public final boolean h(Context context) {
            m.f(context, "context");
            b e10 = e(context);
            if (e10 == null || !e10.k()) {
                return false;
            }
            return true;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: q5.b$b  reason: collision with other inner class name */
    private static final class C0323b implements IInterface {

        /* renamed from: b  reason: collision with root package name */
        public static final a f23256b = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final IBinder f23257a;

        /* renamed from: q5.b$b$a */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public C0323b(IBinder iBinder) {
            m.f(iBinder, "binder");
            this.f23257a = iBinder;
        }

        public final String M() {
            Parcel obtain = Parcel.obtain();
            m.e(obtain, "Parcel.obtain()");
            Parcel obtain2 = Parcel.obtain();
            m.e(obtain2, "Parcel.obtain()");
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f23257a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final boolean N() {
            Parcel obtain = Parcel.obtain();
            m.e(obtain, "Parcel.obtain()");
            Parcel obtain2 = Parcel.obtain();
            m.e(obtain2, "Parcel.obtain()");
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z10 = true;
                obtain.writeInt(1);
                this.f23257a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z10 = false;
                }
                return z10;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f23257a;
        }
    }

    private static final class c implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicBoolean f23258a = new AtomicBoolean(false);

        /* renamed from: b  reason: collision with root package name */
        private final BlockingQueue f23259b = new LinkedBlockingDeque();

        public final IBinder a() {
            if (!this.f23258a.compareAndSet(true, true)) {
                Object take = this.f23259b.take();
                m.e(take, "queue.take()");
                return (IBinder) take;
            }
            throw new IllegalStateException("Binder already consumed".toString());
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.f23259b.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public final String h() {
        if (!o.A() || !o.e()) {
            return null;
        }
        return this.f23251a;
    }

    public final String i() {
        return this.f23254d;
    }

    public final String j() {
        return this.f23253c;
    }

    public final boolean k() {
        return this.f23255e;
    }
}
