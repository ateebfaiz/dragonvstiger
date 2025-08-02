package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.onesignal.b4;
import com.onesignal.o3;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class s4 {
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static int f11039i = -99;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static Class f11040j;

    /* renamed from: a  reason: collision with root package name */
    private ServiceConnection f11041a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Object f11042b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Method f11043c;

    /* renamed from: d  reason: collision with root package name */
    private Method f11044d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Context f11045e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ArrayList f11046f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f11047g = true;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f11048h;

    class a implements ServiceConnection {
        a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Method h10 = s4.q(Class.forName("com.android.vending.billing.IInAppBillingService$Stub"));
                h10.setAccessible(true);
                Object unused = s4.this.f11042b = h10.invoke((Object) null, new Object[]{iBinder});
                s4.this.b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            int unused = s4.f11039i = -99;
            Object unused2 = s4.this.f11042b = null;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            boolean unused = s4.this.f11048h = true;
            try {
                if (s4.this.f11043c == null) {
                    Method unused2 = s4.this.f11043c = s4.r(s4.f11040j);
                    s4.this.f11043c.setAccessible(true);
                }
                Bundle bundle = (Bundle) s4.this.f11043c.invoke(s4.this.f11042b, new Object[]{3, s4.this.f11045e.getPackageName(), "inapp", null});
                if (bundle.getInt("RESPONSE_CODE") == 0) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    for (int i10 = 0; i10 < stringArrayList2.size(); i10++) {
                        String str = stringArrayList.get(i10);
                        String string = new JSONObject(stringArrayList2.get(i10)).getString("purchaseToken");
                        if (!s4.this.f11046f.contains(string) && !arrayList2.contains(string)) {
                            arrayList2.add(string);
                            arrayList.add(str);
                        }
                    }
                    if (arrayList.size() > 0) {
                        s4.this.t(arrayList, arrayList2);
                    } else if (stringArrayList2.size() == 0) {
                        boolean unused3 = s4.this.f11047g = false;
                        z3.j("GTPlayerPurchases", "ExistingPurchases", false);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            boolean unused4 = s4.this.f11048h = false;
        }
    }

    class c extends b4.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f11051a;

        c(ArrayList arrayList) {
            this.f11051a = arrayList;
        }

        public void b(String str) {
            s4.this.f11046f.addAll(this.f11051a);
            z3.m("GTPlayerPurchases", "purchaseTokens", s4.this.f11046f.toString());
            z3.j("GTPlayerPurchases", "ExistingPurchases", true);
            boolean unused = s4.this.f11047g = false;
            boolean unused2 = s4.this.f11048h = false;
        }
    }

    s4(Context context) {
        boolean z10 = false;
        this.f11048h = false;
        this.f11045e = context;
        this.f11046f = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(z3.f("GTPlayerPurchases", "purchaseTokens", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                this.f11046f.add(jSONArray.get(i10).toString());
            }
            z10 = jSONArray.length() == 0 ? true : z10;
            this.f11047g = z10;
            if (z10) {
                this.f11047g = z3.b("GTPlayerPurchases", "ExistingPurchases", true);
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        u();
    }

    static boolean a(Context context) {
        if (f11039i == -99) {
            f11039i = context.checkCallingOrSelfPermission("com.android.vending.BILLING");
        }
        try {
            if (f11039i == 0) {
                f11040j = Class.forName("com.android.vending.billing.IInAppBillingService");
            }
            if (f11039i == 0) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            f11039i = 0;
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        if (!this.f11048h) {
            new Thread(new b()).start();
        }
    }

    /* access modifiers changed from: private */
    public static Method q(Class cls) {
        for (Method method : cls.getMethods()) {
            Class<IBinder>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0] == IBinder.class) {
                return method;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static Method r(Class cls) {
        Class cls2;
        for (Method method : cls.getMethods()) {
            Class<String>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 4 && parameterTypes[0] == Integer.TYPE && parameterTypes[1] == (cls2 = String.class) && parameterTypes[2] == cls2 && parameterTypes[3] == cls2) {
                return method;
            }
        }
        return null;
    }

    private static Method s(Class cls) {
        Class cls2;
        Class cls3;
        for (Method method : cls.getMethods()) {
            Class<Bundle>[] parameterTypes = method.getParameterTypes();
            Class<?> returnType = method.getReturnType();
            if (parameterTypes.length == 4 && parameterTypes[0] == Integer.TYPE && parameterTypes[1] == (cls2 = String.class) && parameterTypes[2] == cls2 && parameterTypes[3] == (cls3 = Bundle.class) && returnType == cls3) {
                return method;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void t(ArrayList arrayList, ArrayList arrayList2) {
        try {
            if (this.f11044d == null) {
                Method s10 = s(f11040j);
                this.f11044d = s10;
                s10.setAccessible(true);
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            Bundle bundle2 = (Bundle) this.f11044d.invoke(this.f11042b, new Object[]{3, this.f11045e.getPackageName(), "inapp", bundle});
            if (bundle2.getInt("RESPONSE_CODE") == 0) {
                ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                HashMap hashMap = new HashMap();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject = new JSONObject(it.next());
                    String string = jSONObject.getString("productId");
                    BigDecimal divide = new BigDecimal(jSONObject.getString("price_amount_micros")).divide(new BigDecimal(1000000));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sku", string);
                    jSONObject2.put("iso", jSONObject.getString("price_currency_code"));
                    jSONObject2.put("amount", divide.toString());
                    hashMap.put(string, jSONObject2);
                }
                JSONArray jSONArray = new JSONArray();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (hashMap.containsKey(str)) {
                        jSONArray.put(hashMap.get(str));
                    }
                }
                if (jSONArray.length() > 0) {
                    o3.A1(jSONArray, this.f11047g, new c(arrayList2));
                }
            }
        } catch (Throwable th) {
            o3.b(o3.v.WARN, "Failed to track IAP purchases", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void u() {
        if (this.f11041a == null) {
            this.f11041a = new a();
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            this.f11045e.bindService(intent, this.f11041a, 1);
        } else if (this.f11042b != null) {
            b();
        }
    }
}
