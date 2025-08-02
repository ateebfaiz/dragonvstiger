package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Consumer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

abstract class f {

    /* renamed from: a  reason: collision with root package name */
    static final LruCache f15077a = new LruCache(16);

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f15078b = g.a("fonts-androidx", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    static final Object f15079c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final SimpleArrayMap f15080d = new SimpleArrayMap();

    class a implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f15081a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15082b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FontRequest f15083c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f15084d;

        a(String str, Context context, FontRequest fontRequest, int i10) {
            this.f15081a = str;
            this.f15082b = context;
            this.f15083c = fontRequest;
            this.f15084d = i10;
        }

        /* renamed from: a */
        public e call() {
            return f.c(this.f15081a, this.f15082b, this.f15083c, this.f15084d);
        }
    }

    class b implements Consumer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f15085a;

        b(a aVar) {
            this.f15085a = aVar;
        }

        /* renamed from: a */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f15085a.b(eVar);
        }
    }

    class c implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f15086a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15087b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FontRequest f15088c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f15089d;

        c(String str, Context context, FontRequest fontRequest, int i10) {
            this.f15086a = str;
            this.f15087b = context;
            this.f15088c = fontRequest;
            this.f15089d = i10;
        }

        /* renamed from: a */
        public e call() {
            try {
                return f.c(this.f15086a, this.f15087b, this.f15088c, this.f15089d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    class d implements Consumer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f15090a;

        d(String str) {
            this.f15090a = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            r0 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
            if (r0 >= r2.size()) goto L_0x002c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
            ((androidx.core.util.Consumer) r2.get(r0)).accept(r5);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void accept(androidx.core.provider.f.e r5) {
            /*
                r4 = this;
                java.lang.Object r0 = androidx.core.provider.f.f15079c
                monitor-enter(r0)
                androidx.collection.SimpleArrayMap r1 = androidx.core.provider.f.f15080d     // Catch:{ all -> 0x0011 }
                java.lang.String r2 = r4.f15090a     // Catch:{ all -> 0x0011 }
                java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x0011 }
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x0011 }
                if (r2 != 0) goto L_0x0013
                monitor-exit(r0)     // Catch:{ all -> 0x0011 }
                return
            L_0x0011:
                r5 = move-exception
                goto L_0x002d
            L_0x0013:
                java.lang.String r3 = r4.f15090a     // Catch:{ all -> 0x0011 }
                r1.remove(r3)     // Catch:{ all -> 0x0011 }
                monitor-exit(r0)     // Catch:{ all -> 0x0011 }
                r0 = 0
            L_0x001a:
                int r1 = r2.size()
                if (r0 >= r1) goto L_0x002c
                java.lang.Object r1 = r2.get(r0)
                androidx.core.util.Consumer r1 = (androidx.core.util.Consumer) r1
                r1.accept(r5)
                int r0 = r0 + 1
                goto L_0x001a
            L_0x002c:
                return
            L_0x002d:
                monitor-exit(r0)     // Catch:{ all -> 0x0011 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.f.d.accept(androidx.core.provider.f$e):void");
        }
    }

    private static String a(FontRequest fontRequest, int i10) {
        return fontRequest.getId() + "-" + i10;
    }

    private static int b(FontsContractCompat.FontFamilyResult fontFamilyResult) {
        int i10 = 1;
        if (fontFamilyResult.getStatusCode() == 0) {
            FontsContractCompat.FontInfo[] fonts = fontFamilyResult.getFonts();
            if (!(fonts == null || fonts.length == 0)) {
                int length = fonts.length;
                i10 = 0;
                int i11 = 0;
                while (i11 < length) {
                    int resultCode = fonts[i11].getResultCode();
                    if (resultCode == 0) {
                        i11++;
                    } else if (resultCode < 0) {
                        return -3;
                    } else {
                        return resultCode;
                    }
                }
            }
            return i10;
        } else if (fontFamilyResult.getStatusCode() != 1) {
            return -3;
        } else {
            return -2;
        }
    }

    static e c(String str, Context context, FontRequest fontRequest, int i10) {
        LruCache lruCache = f15077a;
        Typeface typeface = (Typeface) lruCache.get(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            FontsContractCompat.FontFamilyResult e10 = e.e(context, fontRequest, (CancellationSignal) null);
            int b10 = b(e10);
            if (b10 != 0) {
                return new e(b10);
            }
            Typeface createFromFontInfo = TypefaceCompat.createFromFontInfo(context, (CancellationSignal) null, e10.getFonts(), i10);
            if (createFromFontInfo == null) {
                return new e(-3);
            }
            lruCache.put(str, createFromFontInfo);
            return new e(createFromFontInfo);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        r9 = new androidx.core.provider.f.c(r0, r5, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r8 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        r8 = f15078b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        androidx.core.provider.g.c(r8, r9, new androidx.core.provider.f.d(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Typeface d(android.content.Context r5, androidx.core.provider.FontRequest r6, int r7, java.util.concurrent.Executor r8, androidx.core.provider.a r9) {
        /*
            java.lang.String r0 = a(r6, r7)
            androidx.collection.LruCache r1 = f15077a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0017
            androidx.core.provider.f$e r5 = new androidx.core.provider.f$e
            r5.<init>((android.graphics.Typeface) r1)
            r9.b(r5)
            return r1
        L_0x0017:
            androidx.core.provider.f$b r1 = new androidx.core.provider.f$b
            r1.<init>(r9)
            java.lang.Object r9 = f15079c
            monitor-enter(r9)
            androidx.collection.SimpleArrayMap r2 = f15080d     // Catch:{ all -> 0x002f }
            java.lang.Object r3 = r2.get(r0)     // Catch:{ all -> 0x002f }
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ all -> 0x002f }
            r4 = 0
            if (r3 == 0) goto L_0x0031
            r3.add(r1)     // Catch:{ all -> 0x002f }
            monitor-exit(r9)     // Catch:{ all -> 0x002f }
            return r4
        L_0x002f:
            r5 = move-exception
            goto L_0x004f
        L_0x0031:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x002f }
            r3.<init>()     // Catch:{ all -> 0x002f }
            r3.add(r1)     // Catch:{ all -> 0x002f }
            r2.put(r0, r3)     // Catch:{ all -> 0x002f }
            monitor-exit(r9)     // Catch:{ all -> 0x002f }
            androidx.core.provider.f$c r9 = new androidx.core.provider.f$c
            r9.<init>(r0, r5, r6, r7)
            if (r8 != 0) goto L_0x0046
            java.util.concurrent.ExecutorService r8 = f15078b
        L_0x0046:
            androidx.core.provider.f$d r5 = new androidx.core.provider.f$d
            r5.<init>(r0)
            androidx.core.provider.g.c(r8, r9, r5)
            return r4
        L_0x004f:
            monitor-exit(r9)     // Catch:{ all -> 0x002f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.f.d(android.content.Context, androidx.core.provider.FontRequest, int, java.util.concurrent.Executor, androidx.core.provider.a):android.graphics.Typeface");
    }

    static Typeface e(Context context, FontRequest fontRequest, a aVar, int i10, int i11) {
        String a10 = a(fontRequest, i10);
        Typeface typeface = (Typeface) f15077a.get(a10);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        } else if (i11 == -1) {
            e c10 = c(a10, context, fontRequest, i10);
            aVar.b(c10);
            return c10.f15091a;
        } else {
            try {
                e eVar = (e) g.d(f15078b, new a(a10, context, fontRequest, i10), i11);
                aVar.b(eVar);
                return eVar.f15091a;
            } catch (InterruptedException unused) {
                aVar.b(new e(-3));
                return null;
            }
        }
    }

    static void f() {
        f15077a.evictAll();
    }

    static final class e {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f15091a;

        /* renamed from: b  reason: collision with root package name */
        final int f15092b;

        e(int i10) {
            this.f15091a = null;
            this.f15092b = i10;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            if (this.f15092b == 0) {
                return true;
            }
            return false;
        }

        e(Typeface typeface) {
            this.f15091a = typeface;
            this.f15092b = 0;
        }
    }
}
