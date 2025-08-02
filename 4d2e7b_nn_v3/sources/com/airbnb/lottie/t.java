package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import c.d;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import r0.g;
import w0.w;
import x0.c;
import y0.f;
import y0.l;

public abstract class t {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f17770a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Set f17771b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f17772c = {80, 75, 3, 4};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f17773d = {31, -117, 8};

    public static u0 A(Context context, String str) {
        return B(context, str, "url_" + str);
    }

    public static u0 B(Context context, String str, String str2) {
        return j(str2, new k(context, str, str2), (Runnable) null);
    }

    public static u0 C(Context context, ZipInputStream zipInputStream, String str) {
        return j(str, new o(context, zipInputStream, str), new p(zipInputStream));
    }

    public static u0 D(ZipInputStream zipInputStream, String str) {
        return C((Context) null, zipInputStream, str);
    }

    public static s0 E(Context context, ZipInputStream zipInputStream, String str) {
        return F(context, zipInputStream, str, true);
    }

    public static s0 F(Context context, ZipInputStream zipInputStream, String str, boolean z10) {
        try {
            return G(context, zipInputStream, str);
        } finally {
            if (z10) {
                l.c(zipInputStream);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v49, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.airbnb.lottie.j} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.airbnb.lottie.s0 G(android.content.Context r13, java.util.zip.ZipInputStream r14, java.lang.String r15) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r2 = 0
            if (r15 != 0) goto L_0x000f
            r3 = r2
            goto L_0x0017
        L_0x000f:
            r0.g r3 = r0.g.b()     // Catch:{ IOException -> 0x001f }
            com.airbnb.lottie.j r3 = r3.a(r15)     // Catch:{ IOException -> 0x001f }
        L_0x0017:
            if (r3 == 0) goto L_0x0022
            com.airbnb.lottie.s0 r13 = new com.airbnb.lottie.s0     // Catch:{ IOException -> 0x001f }
            r13.<init>((java.lang.Object) r3)     // Catch:{ IOException -> 0x001f }
            return r13
        L_0x001f:
            r13 = move-exception
            goto L_0x02b1
        L_0x0022:
            java.util.zip.ZipEntry r3 = r14.getNextEntry()     // Catch:{ IOException -> 0x001f }
            r4 = r2
        L_0x0027:
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L_0x0184
            java.lang.String r7 = r3.getName()     // Catch:{ IOException -> 0x001f }
            java.lang.String r8 = "__MACOSX"
            boolean r8 = r7.contains(r8)     // Catch:{ IOException -> 0x001f }
            if (r8 == 0) goto L_0x003c
            r14.closeEntry()     // Catch:{ IOException -> 0x001f }
            goto L_0x017e
        L_0x003c:
            java.lang.String r8 = r3.getName()     // Catch:{ IOException -> 0x001f }
            java.lang.String r9 = "manifest.json"
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ IOException -> 0x001f }
            if (r8 == 0) goto L_0x004d
            r14.closeEntry()     // Catch:{ IOException -> 0x001f }
            goto L_0x017e
        L_0x004d:
            java.lang.String r3 = r3.getName()     // Catch:{ IOException -> 0x001f }
            java.lang.String r8 = ".json"
            boolean r3 = r3.contains(r8)     // Catch:{ IOException -> 0x001f }
            if (r3 == 0) goto L_0x0072
            okio.Source r3 = okio.Okio.source((java.io.InputStream) r14)     // Catch:{ IOException -> 0x001f }
            okio.BufferedSource r3 = okio.Okio.buffer((okio.Source) r3)     // Catch:{ IOException -> 0x001f }
            x0.c r3 = x0.c.z(r3)     // Catch:{ IOException -> 0x001f }
            com.airbnb.lottie.s0 r3 = u(r3, r2, r6)     // Catch:{ IOException -> 0x001f }
            java.lang.Object r3 = r3.b()     // Catch:{ IOException -> 0x001f }
            r4 = r3
            com.airbnb.lottie.j r4 = (com.airbnb.lottie.j) r4     // Catch:{ IOException -> 0x001f }
            goto L_0x017e
        L_0x0072:
            java.lang.String r3 = ".png"
            boolean r3 = r7.contains(r3)     // Catch:{ IOException -> 0x001f }
            java.lang.String r8 = "/"
            if (r3 != 0) goto L_0x016f
            java.lang.String r3 = ".webp"
            boolean r3 = r7.contains(r3)     // Catch:{ IOException -> 0x001f }
            if (r3 != 0) goto L_0x016f
            java.lang.String r3 = ".jpg"
            boolean r3 = r7.contains(r3)     // Catch:{ IOException -> 0x001f }
            if (r3 != 0) goto L_0x016f
            java.lang.String r3 = ".jpeg"
            boolean r3 = r7.contains(r3)     // Catch:{ IOException -> 0x001f }
            if (r3 == 0) goto L_0x0096
            goto L_0x016f
        L_0x0096:
            java.lang.String r3 = ".ttf"
            boolean r3 = r7.contains(r3)     // Catch:{ IOException -> 0x001f }
            if (r3 != 0) goto L_0x00ac
            java.lang.String r3 = ".otf"
            boolean r3 = r7.contains(r3)     // Catch:{ IOException -> 0x001f }
            if (r3 == 0) goto L_0x00a7
            goto L_0x00ac
        L_0x00a7:
            r14.closeEntry()     // Catch:{ IOException -> 0x001f }
            goto L_0x017e
        L_0x00ac:
            java.lang.String[] r3 = r7.split(r8)     // Catch:{ IOException -> 0x001f }
            int r7 = r3.length     // Catch:{ IOException -> 0x001f }
            int r7 = r7 - r5
            r3 = r3[r7]     // Catch:{ IOException -> 0x001f }
            java.lang.String r5 = "\\."
            java.lang.String[] r5 = r3.split(r5)     // Catch:{ IOException -> 0x001f }
            r5 = r5[r6]     // Catch:{ IOException -> 0x001f }
            if (r13 != 0) goto L_0x00df
            com.airbnb.lottie.s0 r13 = new com.airbnb.lottie.s0     // Catch:{ IOException -> 0x001f }
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x001f }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x001f }
            r15.<init>()     // Catch:{ IOException -> 0x001f }
            java.lang.String r0 = "Unable to extract font "
            r15.append(r0)     // Catch:{ IOException -> 0x001f }
            r15.append(r5)     // Catch:{ IOException -> 0x001f }
            java.lang.String r0 = " please pass a non-null Context parameter"
            r15.append(r0)     // Catch:{ IOException -> 0x001f }
            java.lang.String r15 = r15.toString()     // Catch:{ IOException -> 0x001f }
            r14.<init>(r15)     // Catch:{ IOException -> 0x001f }
            r13.<init>((java.lang.Throwable) r14)     // Catch:{ IOException -> 0x001f }
            return r13
        L_0x00df:
            java.io.File r7 = new java.io.File     // Catch:{ IOException -> 0x001f }
            java.io.File r8 = r13.getCacheDir()     // Catch:{ IOException -> 0x001f }
            r7.<init>(r8, r3)     // Catch:{ IOException -> 0x001f }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x010d }
            r8.<init>(r7)     // Catch:{ all -> 0x010d }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ all -> 0x010f }
            r9.<init>(r7)     // Catch:{ all -> 0x010f }
            r10 = 4096(0x1000, float:5.74E-42)
            byte[] r10 = new byte[r10]     // Catch:{ all -> 0x0101 }
        L_0x00f6:
            int r11 = r14.read(r10)     // Catch:{ all -> 0x0101 }
            r12 = -1
            if (r11 == r12) goto L_0x0103
            r9.write(r10, r6, r11)     // Catch:{ all -> 0x0101 }
            goto L_0x00f6
        L_0x0101:
            r6 = move-exception
            goto L_0x0111
        L_0x0103:
            r9.flush()     // Catch:{ all -> 0x0101 }
            r9.close()     // Catch:{ all -> 0x010f }
            r8.close()     // Catch:{ all -> 0x010d }
            goto L_0x0144
        L_0x010d:
            r6 = move-exception
            goto L_0x0123
        L_0x010f:
            r6 = move-exception
            goto L_0x011a
        L_0x0111:
            r9.close()     // Catch:{ all -> 0x0115 }
            goto L_0x0119
        L_0x0115:
            r9 = move-exception
            r6.addSuppressed(r9)     // Catch:{ all -> 0x010f }
        L_0x0119:
            throw r6     // Catch:{ all -> 0x010f }
        L_0x011a:
            r8.close()     // Catch:{ all -> 0x011e }
            goto L_0x0122
        L_0x011e:
            r8 = move-exception
            r6.addSuppressed(r8)     // Catch:{ all -> 0x010d }
        L_0x0122:
            throw r6     // Catch:{ all -> 0x010d }
        L_0x0123:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x001f }
            r8.<init>()     // Catch:{ IOException -> 0x001f }
            java.lang.String r9 = "Unable to save font "
            r8.append(r9)     // Catch:{ IOException -> 0x001f }
            r8.append(r5)     // Catch:{ IOException -> 0x001f }
            java.lang.String r9 = " to the temporary file: "
            r8.append(r9)     // Catch:{ IOException -> 0x001f }
            r8.append(r3)     // Catch:{ IOException -> 0x001f }
            java.lang.String r3 = ". "
            r8.append(r3)     // Catch:{ IOException -> 0x001f }
            java.lang.String r3 = r8.toString()     // Catch:{ IOException -> 0x001f }
            y0.f.d(r3, r6)     // Catch:{ IOException -> 0x001f }
        L_0x0144:
            android.graphics.Typeface r3 = android.graphics.Typeface.createFromFile(r7)     // Catch:{ IOException -> 0x001f }
            boolean r6 = r7.delete()     // Catch:{ IOException -> 0x001f }
            if (r6 != 0) goto L_0x016b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x001f }
            r6.<init>()     // Catch:{ IOException -> 0x001f }
            java.lang.String r8 = "Failed to delete temp font file "
            r6.append(r8)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ IOException -> 0x001f }
            r6.append(r7)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = "."
            r6.append(r7)     // Catch:{ IOException -> 0x001f }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x001f }
            y0.f.c(r6)     // Catch:{ IOException -> 0x001f }
        L_0x016b:
            r1.put(r5, r3)     // Catch:{ IOException -> 0x001f }
            goto L_0x017e
        L_0x016f:
            java.lang.String[] r3 = r7.split(r8)     // Catch:{ IOException -> 0x001f }
            int r6 = r3.length     // Catch:{ IOException -> 0x001f }
            int r6 = r6 - r5
            r3 = r3[r6]     // Catch:{ IOException -> 0x001f }
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r14)     // Catch:{ IOException -> 0x001f }
            r0.put(r3, r5)     // Catch:{ IOException -> 0x001f }
        L_0x017e:
            java.util.zip.ZipEntry r3 = r14.getNextEntry()     // Catch:{ IOException -> 0x001f }
            goto L_0x0027
        L_0x0184:
            if (r4 != 0) goto L_0x0193
            com.airbnb.lottie.s0 r13 = new com.airbnb.lottie.s0
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r15 = "Unable to parse composition"
            r14.<init>(r15)
            r13.<init>((java.lang.Throwable) r14)
            return r13
        L_0x0193:
            java.util.Set r13 = r0.entrySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x019b:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x01c9
            java.lang.Object r14 = r13.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            java.lang.Object r3 = r14.getKey()
            java.lang.String r3 = (java.lang.String) r3
            com.airbnb.lottie.n0 r3 = k(r4, r3)
            if (r3 == 0) goto L_0x019b
            java.lang.Object r14 = r14.getValue()
            android.graphics.Bitmap r14 = (android.graphics.Bitmap) r14
            int r7 = r3.f()
            int r8 = r3.d()
            android.graphics.Bitmap r14 = y0.l.m(r14, r7, r8)
            r3.g(r14)
            goto L_0x019b
        L_0x01c9:
            java.util.Set r13 = r1.entrySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x01d1:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x0231
            java.lang.Object r14 = r13.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            java.util.Map r1 = r4.g()
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
            r3 = r6
        L_0x01ea:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x020f
            java.lang.Object r7 = r1.next()
            r0.c r7 = (r0.c) r7
            java.lang.String r8 = r7.a()
            java.lang.Object r9 = r14.getKey()
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x01ea
            java.lang.Object r3 = r14.getValue()
            android.graphics.Typeface r3 = (android.graphics.Typeface) r3
            r7.e(r3)
            r3 = r5
            goto L_0x01ea
        L_0x020f:
            if (r3 != 0) goto L_0x01d1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Parsed font for "
            r1.append(r3)
            java.lang.Object r14 = r14.getKey()
            java.lang.String r14 = (java.lang.String) r14
            r1.append(r14)
            java.lang.String r14 = " however it was not found in the animation."
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            y0.f.c(r14)
            goto L_0x01d1
        L_0x0231:
            boolean r13 = r0.isEmpty()
            if (r13 == 0) goto L_0x02a2
            java.util.Map r13 = r4.j()
            java.util.Set r13 = r13.entrySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x0243:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x02a2
            java.lang.Object r14 = r13.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            java.lang.Object r14 = r14.getValue()
            com.airbnb.lottie.n0 r14 = (com.airbnb.lottie.n0) r14
            if (r14 != 0) goto L_0x0258
            return r2
        L_0x0258:
            java.lang.String r0 = r14.c()
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r1.inScaled = r5
            r3 = 160(0xa0, float:2.24E-43)
            r1.inDensity = r3
            java.lang.String r3 = "data:"
            boolean r3 = r0.startsWith(r3)
            if (r3 == 0) goto L_0x0243
            java.lang.String r3 = "base64,"
            int r3 = r0.indexOf(r3)
            if (r3 <= 0) goto L_0x0243
            r3 = 44
            int r3 = r0.indexOf(r3)     // Catch:{ IllegalArgumentException -> 0x029b }
            int r3 = r3 + r5
            java.lang.String r0 = r0.substring(r3)     // Catch:{ IllegalArgumentException -> 0x029b }
            byte[] r0 = android.util.Base64.decode(r0, r6)     // Catch:{ IllegalArgumentException -> 0x029b }
            int r3 = r0.length
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r6, r3, r1)
            int r1 = r14.f()
            int r3 = r14.d()
            android.graphics.Bitmap r0 = y0.l.m(r0, r1, r3)
            r14.g(r0)
            goto L_0x0243
        L_0x029b:
            r13 = move-exception
            java.lang.String r14 = "data URL did not have correct base64 format."
            y0.f.d(r14, r13)
            return r2
        L_0x02a2:
            if (r15 == 0) goto L_0x02ab
            r0.g r13 = r0.g.b()
            r13.c(r15, r4)
        L_0x02ab:
            com.airbnb.lottie.s0 r13 = new com.airbnb.lottie.s0
            r13.<init>((java.lang.Object) r4)
            return r13
        L_0x02b1:
            com.airbnb.lottie.s0 r14 = new com.airbnb.lottie.s0
            r14.<init>((java.lang.Throwable) r13)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.t.G(android.content.Context, java.util.zip.ZipInputStream, java.lang.String):com.airbnb.lottie.s0");
    }

    private static Boolean H(BufferedSource bufferedSource) {
        return T(bufferedSource, f17773d);
    }

    private static boolean I(Context context) {
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    private static Boolean J(BufferedSource bufferedSource) {
        return T(bufferedSource, f17772c);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void K(String str, AtomicBoolean atomicBoolean, j jVar) {
        Map map = f17770a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            U(true);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void L(String str, AtomicBoolean atomicBoolean, Throwable th) {
        Map map = f17770a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            U(true);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ s0 P(WeakReference weakReference, Context context, int i10, String str) {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return z(context, i10, str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ s0 Q(Context context, String str, String str2) {
        s0 c10 = e.k(context).c(context, str, str2);
        if (!(str2 == null || c10.b() == null)) {
            g.b().c(str2, (j) c10.b());
        }
        return c10;
    }

    private static Boolean T(BufferedSource bufferedSource, byte[] bArr) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b10 : bArr) {
                if (peek.readByte() != b10) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        } catch (Exception e10) {
            f.b("Failed to check zip file header", e10);
            return Boolean.FALSE;
        }
    }

    private static void U(boolean z10) {
        ArrayList arrayList = new ArrayList(f17771b);
        if (arrayList.size() > 0) {
            d.a(arrayList.get(0));
            throw null;
        }
    }

    private static String V(Context context, int i10) {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rawRes");
        if (I(context)) {
            str = "_night_";
        } else {
            str = "_day_";
        }
        sb2.append(str);
        sb2.append(i10);
        return sb2.toString();
    }

    private static u0 j(String str, Callable callable, Runnable runnable) {
        j jVar;
        u0 u0Var = null;
        if (str == null) {
            jVar = null;
        } else {
            jVar = g.b().a(str);
        }
        if (jVar != null) {
            u0Var = new u0((Object) jVar);
        }
        if (str != null) {
            Map map = f17770a;
            if (map.containsKey(str)) {
                u0Var = (u0) map.get(str);
            }
        }
        if (u0Var != null) {
            if (runnable != null) {
                runnable.run();
            }
            return u0Var;
        }
        u0 u0Var2 = new u0(callable);
        if (str != null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            u0Var2.d(new q(str, atomicBoolean));
            u0Var2.c(new r(str, atomicBoolean));
            if (!atomicBoolean.get()) {
                Map map2 = f17770a;
                map2.put(str, u0Var2);
                if (map2.size() == 1) {
                    U(false);
                }
            }
        }
        return u0Var2;
    }

    private static n0 k(j jVar, String str) {
        for (n0 n0Var : jVar.j().values()) {
            if (n0Var.c().equals(str)) {
                return n0Var;
            }
        }
        return null;
    }

    public static u0 l(Context context, String str) {
        return m(context, str, "asset_" + str);
    }

    public static u0 m(Context context, String str, String str2) {
        return j(str2, new n(context.getApplicationContext(), str, str2), (Runnable) null);
    }

    public static s0 n(Context context, String str) {
        return o(context, str, "asset_" + str);
    }

    public static s0 o(Context context, String str, String str2) {
        j jVar;
        if (str2 == null) {
            jVar = null;
        } else {
            jVar = g.b().a(str2);
        }
        if (jVar != null) {
            return new s0((Object) jVar);
        }
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getAssets().open(str)));
            if (J(buffer).booleanValue()) {
                return E(context, new ZipInputStream(buffer.inputStream()), str2);
            }
            if (H(buffer).booleanValue()) {
                return q(new GZIPInputStream(buffer.inputStream()), str2);
            }
            return s(c.z(buffer), str2);
        } catch (IOException e10) {
            return new s0((Throwable) e10);
        }
    }

    public static u0 p(InputStream inputStream, String str) {
        return j(str, new l(inputStream, str), new m(inputStream));
    }

    public static s0 q(InputStream inputStream, String str) {
        return r(inputStream, str, true);
    }

    public static s0 r(InputStream inputStream, String str, boolean z10) {
        return v(Okio.source(inputStream), str, z10);
    }

    public static s0 s(c cVar, String str) {
        return t(cVar, str, true);
    }

    public static s0 t(c cVar, String str, boolean z10) {
        return u(cVar, str, z10);
    }

    private static s0 u(c cVar, String str, boolean z10) {
        j jVar;
        if (str == null) {
            jVar = null;
        } else {
            try {
                jVar = g.b().a(str);
            } catch (Exception e10) {
                s0 s0Var = new s0((Throwable) e10);
                if (z10) {
                    l.c(cVar);
                }
                return s0Var;
            } catch (Throwable th) {
                if (z10) {
                    l.c(cVar);
                }
                throw th;
            }
        }
        if (jVar != null) {
            s0 s0Var2 = new s0((Object) jVar);
            if (z10) {
                l.c(cVar);
            }
            return s0Var2;
        }
        j a10 = w.a(cVar);
        if (str != null) {
            g.b().c(str, a10);
        }
        s0 s0Var3 = new s0((Object) a10);
        if (z10) {
            l.c(cVar);
        }
        return s0Var3;
    }

    public static s0 v(Source source, String str, boolean z10) {
        return u(c.z(Okio.buffer(source)), str, z10);
    }

    public static u0 w(Context context, int i10) {
        return x(context, i10, V(context, i10));
    }

    public static u0 x(Context context, int i10, String str) {
        return j(str, new s(new WeakReference(context), context.getApplicationContext(), i10, str), (Runnable) null);
    }

    public static s0 y(Context context, int i10) {
        return z(context, i10, V(context, i10));
    }

    public static s0 z(Context context, int i10, String str) {
        j jVar;
        if (str == null) {
            jVar = null;
        } else {
            jVar = g.b().a(str);
        }
        if (jVar != null) {
            return new s0((Object) jVar);
        }
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i10)));
            if (J(buffer).booleanValue()) {
                return E(context, new ZipInputStream(buffer.inputStream()), str);
            }
            if (!H(buffer).booleanValue()) {
                return s(c.z(buffer), str);
            }
            try {
                return q(new GZIPInputStream(buffer.inputStream()), str);
            } catch (IOException e10) {
                return new s0((Throwable) e10);
            }
        } catch (Resources.NotFoundException e11) {
            return new s0((Throwable) e11);
        }
    }
}
