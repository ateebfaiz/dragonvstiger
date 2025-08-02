package j2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.o;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import org.json.JSONException;
import org.json.JSONObject;
import v5.a;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap f22183a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap f22184b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final String f22185c = o.f().getPackageName();

    /* renamed from: d  reason: collision with root package name */
    private static final SharedPreferences f22186d = o.f().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);

    /* renamed from: e  reason: collision with root package name */
    private static final SharedPreferences f22187e = o.f().getSharedPreferences("com.facebook.internal.PURCHASE", 0);

    /* renamed from: f  reason: collision with root package name */
    public static final d f22188f = new d();

    private d() {
    }

    public static final Object a(Context context, IBinder iBinder) {
        Class<d> cls = d.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(context, "context");
            return f22188f.n(context, "com.android.vending.billing.IInAppBillingService$Stub", "asInterface", (Object) null, new Object[]{iBinder});
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    public static final void b() {
        Class<d> cls = d.class;
        if (!a.d(cls)) {
            try {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                SharedPreferences sharedPreferences = f22186d;
                long j10 = sharedPreferences.getLong("LAST_CLEARED_TIME", 0);
                if (j10 == 0) {
                    sharedPreferences.edit().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
                } else if (currentTimeMillis - j10 > ((long) 604800)) {
                    sharedPreferences.edit().clear().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
                }
            } catch (Throwable th) {
                a.b(th, cls);
            }
        }
    }

    private final ArrayList c(ArrayList arrayList) {
        if (a.d(this)) {
            return null;
        }
        try {
            ArrayList arrayList2 = new ArrayList();
            SharedPreferences.Editor edit = f22187e.edit();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.getString("productId");
                    long j10 = jSONObject.getLong("purchaseTime");
                    String string2 = jSONObject.getString("purchaseToken");
                    if (currentTimeMillis - (j10 / 1000) <= ((long) 86400)) {
                        if (!m.b(f22187e.getString(string, ""), string2)) {
                            edit.putString(string, string2);
                            arrayList2.add(str);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            edit.apply();
            return arrayList2;
        } catch (Throwable th) {
            a.b(th, this);
            return null;
        }
    }

    private final Class d(Context context, String str) {
        Class<?> loadClass;
        if (a.d(this)) {
            return null;
        }
        try {
            HashMap hashMap = f22184b;
            Class cls = (Class) hashMap.get(str);
            if (cls != null) {
                return cls;
            }
            try {
                loadClass = context.getClassLoader().loadClass(str);
                m.e(loadClass, "classObj");
                hashMap.put(str, loadClass);
                return loadClass;
            } catch (ClassNotFoundException unused) {
                return loadClass;
            }
        } catch (Throwable th) {
            a.b(th, this);
            return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009d, code lost:
        if (r0 != null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009f, code lost:
        r13 = r13.getDeclaredMethod(r14, new java.lang.Class[]{null});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a7, code lost:
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a9, code lost:
        r13 = r13.getDeclaredMethod(r14, (java.lang.Class[]) java.util.Arrays.copyOf(r0, r0.length));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b5, code lost:
        r5.put(r14, r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.reflect.Method e(java.lang.Class r13, java.lang.String r14) {
        /*
            r12 = this;
            r0 = 4
            r1 = 3
            r2 = 2
            r3 = 1
            r4 = 0
            boolean r5 = v5.a.d(r12)
            r6 = 0
            if (r5 == 0) goto L_0x000d
            return r6
        L_0x000d:
            java.util.HashMap r5 = f22183a     // Catch:{ all -> 0x003f }
            java.lang.Object r7 = r5.get(r14)     // Catch:{ all -> 0x003f }
            java.lang.reflect.Method r7 = (java.lang.reflect.Method) r7     // Catch:{ all -> 0x003f }
            if (r7 == 0) goto L_0x0018
            return r7
        L_0x0018:
            int r8 = r14.hashCode()     // Catch:{ NoSuchMethodException -> 0x00b8 }
            java.lang.Class<android.os.Bundle> r9 = android.os.Bundle.class
            java.lang.String r10 = "Integer.TYPE"
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            switch(r8) {
                case -1801122596: goto L_0x0084;
                case -1450694211: goto L_0x006d;
                case -1123215065: goto L_0x005e;
                case -594356707: goto L_0x0042;
                case -573310373: goto L_0x0027;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x009c
        L_0x0027:
            java.lang.String r8 = "getSkuDetails"
            boolean r8 = r14.equals(r8)     // Catch:{ NoSuchMethodException -> 0x00b8 }
            if (r8 == 0) goto L_0x009c
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x00b8 }
            kotlin.jvm.internal.m.e(r8, r10)     // Catch:{ NoSuchMethodException -> 0x00b8 }
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r0[r4] = r8     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r0[r3] = r11     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r0[r2] = r11     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r0[r1] = r9     // Catch:{ NoSuchMethodException -> 0x00b8 }
            goto L_0x009d
        L_0x003f:
            r13 = move-exception
            goto L_0x00b9
        L_0x0042:
            java.lang.String r8 = "getPurchaseHistory"
            boolean r8 = r14.equals(r8)     // Catch:{ NoSuchMethodException -> 0x00b8 }
            if (r8 == 0) goto L_0x009c
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x00b8 }
            kotlin.jvm.internal.m.e(r8, r10)     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r10 = 5
            java.lang.Class[] r10 = new java.lang.Class[r10]     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r10[r4] = r8     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r10[r3] = r11     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r10[r2] = r11     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r10[r1] = r11     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r10[r0] = r9     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r0 = r10
            goto L_0x009d
        L_0x005e:
            java.lang.String r0 = "asInterface"
            boolean r0 = r14.equals(r0)     // Catch:{ NoSuchMethodException -> 0x00b8 }
            if (r0 == 0) goto L_0x009c
            java.lang.Class[] r0 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x00b8 }
            java.lang.Class<android.os.IBinder> r1 = android.os.IBinder.class
            r0[r4] = r1     // Catch:{ NoSuchMethodException -> 0x00b8 }
            goto L_0x009d
        L_0x006d:
            java.lang.String r0 = "isBillingSupported"
            boolean r0 = r14.equals(r0)     // Catch:{ NoSuchMethodException -> 0x00b8 }
            if (r0 == 0) goto L_0x009c
            java.lang.Class r0 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x00b8 }
            kotlin.jvm.internal.m.e(r0, r10)     // Catch:{ NoSuchMethodException -> 0x00b8 }
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r1[r4] = r0     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r1[r3] = r11     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r1[r2] = r11     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r0 = r1
            goto L_0x009d
        L_0x0084:
            java.lang.String r8 = "getPurchases"
            boolean r8 = r14.equals(r8)     // Catch:{ NoSuchMethodException -> 0x00b8 }
            if (r8 == 0) goto L_0x009c
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x00b8 }
            kotlin.jvm.internal.m.e(r8, r10)     // Catch:{ NoSuchMethodException -> 0x00b8 }
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r0[r4] = r8     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r0[r3] = r11     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r0[r2] = r11     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r0[r1] = r11     // Catch:{ NoSuchMethodException -> 0x00b8 }
            goto L_0x009d
        L_0x009c:
            r0 = r6
        L_0x009d:
            if (r0 != 0) goto L_0x00a9
            java.lang.Class[] r0 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r0[r4] = r6     // Catch:{ NoSuchMethodException -> 0x00b8 }
            java.lang.reflect.Method r13 = r13.getDeclaredMethod(r14, r0)     // Catch:{ NoSuchMethodException -> 0x00b8 }
        L_0x00a7:
            r7 = r13
            goto L_0x00b5
        L_0x00a9:
            int r1 = r0.length     // Catch:{ NoSuchMethodException -> 0x00b8 }
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)     // Catch:{ NoSuchMethodException -> 0x00b8 }
            java.lang.Class[] r0 = (java.lang.Class[]) r0     // Catch:{ NoSuchMethodException -> 0x00b8 }
            java.lang.reflect.Method r13 = r13.getDeclaredMethod(r14, r0)     // Catch:{ NoSuchMethodException -> 0x00b8 }
            goto L_0x00a7
        L_0x00b5:
            r5.put(r14, r7)     // Catch:{ NoSuchMethodException -> 0x00b8 }
        L_0x00b8:
            return r7
        L_0x00b9:
            v5.a.b(r13, r12)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.d.e(java.lang.Class, java.lang.String):java.lang.reflect.Method");
    }

    private final ArrayList f(Context context, Object obj, String str) {
        ArrayList<String> stringArrayList;
        if (a.d(this)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (o(context, obj, str)) {
                int i10 = 0;
                boolean z10 = false;
                String str2 = null;
                do {
                    Object n10 = n(context, "com.android.vending.billing.IInAppBillingService", "getPurchaseHistory", obj, new Object[]{6, f22185c, str, str2, new Bundle()});
                    if (n10 != null) {
                        long j10 = 1000;
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        Bundle bundle = (Bundle) n10;
                        if (bundle.getInt("RESPONSE_CODE") == 0 && (stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST")) != null) {
                            m.e(stringArrayList, "purchaseDetails.getStrin…SE_DATA_LIST) ?: continue");
                            Iterator<String> it = stringArrayList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                String next = it.next();
                                try {
                                    if (currentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / j10) > ((long) 1200)) {
                                        z10 = true;
                                        break;
                                    }
                                    arrayList.add(next);
                                    i10++;
                                    j10 = 1000;
                                } catch (JSONException unused) {
                                }
                            }
                            str2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                            if (i10 >= 30 || str2 == null) {
                                break;
                            }
                        }
                    }
                    str2 = null;
                } while (!z10);
            }
            return arrayList;
        } catch (Throwable th) {
            a.b(th, this);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r3 = f22188f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.ArrayList g(android.content.Context r6, java.lang.Object r7) {
        /*
            java.lang.Class<j2.d> r0 = j2.d.class
            boolean r1 = v5.a.d(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.lang.String r1 = "context"
            kotlin.jvm.internal.m.f(r6, r1)     // Catch:{ all -> 0x0034 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0034 }
            r1.<init>()     // Catch:{ all -> 0x0034 }
            if (r7 != 0) goto L_0x0017
            return r1
        L_0x0017:
            j2.d r3 = f22188f     // Catch:{ all -> 0x0034 }
            java.lang.String r4 = "com.android.vending.billing.IInAppBillingService"
            java.lang.Class r4 = r3.d(r6, r4)     // Catch:{ all -> 0x0034 }
            if (r4 == 0) goto L_0x0036
            java.lang.String r5 = "getPurchaseHistory"
            java.lang.reflect.Method r4 = r3.e(r4, r5)     // Catch:{ all -> 0x0034 }
            if (r4 == 0) goto L_0x0036
            java.lang.String r1 = "inapp"
            java.util.ArrayList r6 = r3.f(r6, r7, r1)     // Catch:{ all -> 0x0034 }
            java.util.ArrayList r6 = r3.c(r6)     // Catch:{ all -> 0x0034 }
            return r6
        L_0x0034:
            r6 = move-exception
            goto L_0x0037
        L_0x0036:
            return r1
        L_0x0037:
            v5.a.b(r6, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.d.g(android.content.Context, java.lang.Object):java.util.ArrayList");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064 A[EDGE_INSN: B:25:0x0064->B:22:0x0064 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.ArrayList h(android.content.Context r12, java.lang.Object r13, java.lang.String r14) {
        /*
            r11 = this;
            r0 = 3
            r1 = 0
            boolean r2 = v5.a.d(r11)
            r3 = 0
            if (r2 == 0) goto L_0x000a
            return r3
        L_0x000a:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x005b }
            r2.<init>()     // Catch:{ all -> 0x005b }
            if (r13 != 0) goto L_0x0012
            return r2
        L_0x0012:
            boolean r4 = r11.o(r12, r13, r14)     // Catch:{ all -> 0x005b }
            if (r4 == 0) goto L_0x0064
            r10 = r1
            r4 = r3
        L_0x001a:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x005b }
            r6 = 4
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ all -> 0x005b }
            r9[r1] = r5     // Catch:{ all -> 0x005b }
            java.lang.String r5 = f22185c     // Catch:{ all -> 0x005b }
            r6 = 1
            r9[r6] = r5     // Catch:{ all -> 0x005b }
            r5 = 2
            r9[r5] = r14     // Catch:{ all -> 0x005b }
            r9[r0] = r4     // Catch:{ all -> 0x005b }
            java.lang.String r6 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r7 = "getPurchases"
            r4 = r11
            r5 = r12
            r8 = r13
            java.lang.Object r4 = r4.n(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x005b }
            if (r4 == 0) goto L_0x005d
            android.os.Bundle r4 = (android.os.Bundle) r4     // Catch:{ all -> 0x005b }
            java.lang.String r5 = "RESPONSE_CODE"
            int r5 = r4.getInt(r5)     // Catch:{ all -> 0x005b }
            if (r5 != 0) goto L_0x005d
            java.lang.String r5 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r5 = r4.getStringArrayList(r5)     // Catch:{ all -> 0x005b }
            if (r5 == 0) goto L_0x0064
            int r6 = r5.size()     // Catch:{ all -> 0x005b }
            int r10 = r10 + r6
            r2.addAll(r5)     // Catch:{ all -> 0x005b }
            java.lang.String r5 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r4 = r4.getString(r5)     // Catch:{ all -> 0x005b }
            goto L_0x005e
        L_0x005b:
            r0 = move-exception
            goto L_0x0065
        L_0x005d:
            r4 = r3
        L_0x005e:
            r5 = 30
            if (r10 >= r5) goto L_0x0064
            if (r4 != 0) goto L_0x001a
        L_0x0064:
            return r2
        L_0x0065:
            v5.a.b(r0, r11)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.d.h(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    public static final ArrayList i(Context context, Object obj) {
        Class<d> cls = d.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(context, "context");
            d dVar = f22188f;
            return dVar.c(dVar.h(context, obj, "inapp"));
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    public static final ArrayList j(Context context, Object obj) {
        Class<d> cls = d.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(context, "context");
            d dVar = f22188f;
            return dVar.c(dVar.h(context, obj, "subs"));
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    public static final Map k(Context context, ArrayList arrayList, Object obj, boolean z10) {
        Class<d> cls = d.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(context, "context");
            m.f(arrayList, "skuList");
            Map p10 = f22188f.p(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!p10.containsKey(str)) {
                    arrayList2.add(str);
                }
            }
            p10.putAll(f22188f.l(context, arrayList2, obj, z10));
            return p10;
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    private final Map l(Context context, ArrayList arrayList, Object obj, boolean z10) {
        String str;
        ArrayList arrayList2 = arrayList;
        if (a.d(this)) {
            return null;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (obj != null) {
                if (!arrayList.isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
                    if (z10) {
                        str = "subs";
                    } else {
                        str = "inapp";
                    }
                    Object n10 = n(context, "com.android.vending.billing.IInAppBillingService", "getSkuDetails", obj, new Object[]{3, f22185c, str, bundle});
                    if (n10 != null) {
                        Bundle bundle2 = (Bundle) n10;
                        if (bundle2.getInt("RESPONSE_CODE") == 0) {
                            ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                            if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                                int size = arrayList.size();
                                for (int i10 = 0; i10 < size; i10++) {
                                    Object obj2 = arrayList.get(i10);
                                    m.e(obj2, "skuList[i]");
                                    String str2 = stringArrayList.get(i10);
                                    m.e(str2, "skuDetailsList[i]");
                                    linkedHashMap.put(obj2, str2);
                                }
                            }
                            q(linkedHashMap);
                        }
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            a.b(th, this);
            return null;
        }
    }

    private final Object n(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method e10;
        if (a.d(this)) {
            return null;
        }
        try {
            Class d10 = d(context, str);
            if (!(d10 == null || (e10 = e(d10, str2)) == null)) {
                if (obj != null) {
                    obj = d10.cast(obj);
                }
                try {
                    return e10.invoke(obj, Arrays.copyOf(objArr, objArr.length));
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            a.b(th, this);
            return null;
        }
    }

    private final boolean o(Context context, Object obj, String str) {
        if (a.d(this) || obj == null) {
            return false;
        }
        try {
            Object n10 = n(context, "com.android.vending.billing.IInAppBillingService", "isBillingSupported", obj, new Object[]{3, f22185c, str});
            if (n10 == null || ((Integer) n10).intValue() != 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            a.b(th, this);
            return false;
        }
    }

    private final Map p(ArrayList arrayList) {
        if (a.d(this)) {
            return null;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                String string = f22186d.getString(str, (String) null);
                if (string != null) {
                    List v02 = j.v0(string, new String[]{";"}, false, 2, 2, (Object) null);
                    if (currentTimeMillis - Long.parseLong((String) v02.get(0)) < ((long) 43200)) {
                        m.e(str, "sku");
                        linkedHashMap.put(str, v02.get(1));
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            a.b(th, this);
            return null;
        }
    }

    private final void q(Map map) {
        if (!a.d(this)) {
            try {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                SharedPreferences.Editor edit = f22186d.edit();
                for (Map.Entry entry : map.entrySet()) {
                    edit.putString((String) entry.getKey(), currentTimeMillis + ';' + ((String) entry.getValue()));
                }
                edit.apply();
            } catch (Throwable th) {
                a.b(th, this);
            }
        }
    }

    public final boolean m(String str) {
        if (a.d(this)) {
            return false;
        }
        try {
            m.f(str, "skuDetail");
            try {
                String optString = new JSONObject(str).optString("freeTrialPeriod");
                if (optString == null || optString.length() <= 0) {
                    return false;
                }
                return true;
            } catch (JSONException unused) {
                return false;
            }
        } catch (Throwable th) {
            a.b(th, this);
            return false;
        }
    }
}
