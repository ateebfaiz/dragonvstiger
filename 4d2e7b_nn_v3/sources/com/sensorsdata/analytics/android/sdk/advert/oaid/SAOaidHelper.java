package com.sensorsdata.analytics.android.sdk.advert.oaid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDFactory;
import com.sensorsdata.analytics.android.sdk.core.business.SAPropertyManager;
import com.sensorsdata.analytics.android.sdk.internal.beans.LimitKey;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class SAOaidHelper {
    private static final String TAG = "SA.SAOaidHelper";
    private static Class<?> jLibrary = null;
    /* access modifiers changed from: private */
    public static CountDownLatch mCountDownLatch = null;
    /* access modifiers changed from: private */
    public static Class<?> mIdSupplier = null;
    private static Class<?> mIdentifyListener = null;
    private static final List<String> mLoadLibrary = new LinkedList<String>() {
        {
            add("msaoaidsec");
            add("nllvm1632808251147706677");
            add("nllvm1630571663641560568");
            add("nllvm1623827671");
        }
    };
    private static Class<?> mMidSDKHelper = null;
    /* access modifiers changed from: private */
    public static String mOAID = "";
    private static String mOidCertFilePath = null;
    private static String mReflectionOAID = "";

    static class IdentifyListenerHandler implements InvocationHandler {
        IdentifyListenerHandler() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("OnSupport".equalsIgnoreCase(method.getName())) {
                    Method declaredMethod = SAOaidHelper.mIdSupplier.getDeclaredMethod("getOAID", (Class[]) null);
                    if (objArr.length == 1) {
                        String unused = SAOaidHelper.mOAID = (String) declaredMethod.invoke(objArr[0], (Object[]) null);
                    } else {
                        String unused2 = SAOaidHelper.mOAID = (String) declaredMethod.invoke(objArr[1], (Object[]) null);
                    }
                    SALog.i(SAOaidHelper.TAG, "oaid:" + SAOaidHelper.mOAID);
                    SAOaidHelper.mCountDownLatch.countDown();
                }
            } catch (Throwable unused3) {
                SAOaidHelper.mCountDownLatch.countDown();
            }
            return null;
        }
    }

    static {
        initSDKLibrary();
    }

    private static boolean allZero(String str) {
        String replace = str.replace("-", "").replace("#", "").replace("_", "");
        for (int i10 = 0; i10 < replace.length(); i10++) {
            if (replace.charAt(i10) != '0') {
                return false;
            }
        }
        return true;
    }

    private static String getMSAOAID(Context context) {
        try {
            mCountDownLatch = new CountDownLatch(1);
            initInvokeListener();
            if (!(mMidSDKHelper == null || mIdentifyListener == null)) {
                if (mIdSupplier != null) {
                    if (!TextUtils.isEmpty(mOAID)) {
                        return mOAID;
                    }
                    getOAIDReflect(context, 2);
                    mCountDownLatch.await();
                    SALog.i(TAG, "CountDownLatch await");
                    return mOAID;
                }
            }
            SALog.i(TAG, "OAID class create failed");
            return "";
        } catch (InterruptedException e10) {
            SALog.printStackTrace(e10);
        } catch (Throwable th) {
            SALog.i(TAG, th.getMessage());
            return "";
        }
    }

    private static void getOAIDReflect(Context context, int i10) {
        if (i10 != 0) {
            try {
                initPemCert(context);
                Class<?> cls = jLibrary;
                Class<Context> cls2 = Context.class;
                if (cls != null) {
                    cls.getDeclaredMethod("InitEntry", new Class[]{cls2}).invoke((Object) null, new Object[]{context});
                }
                int intValue = ((Integer) mMidSDKHelper.getDeclaredMethod("InitSdk", new Class[]{cls2, Boolean.TYPE, mIdentifyListener}).invoke((Object) null, new Object[]{context, Boolean.TRUE, Proxy.newProxyInstance(context.getClassLoader(), new Class[]{mIdentifyListener}, new IdentifyListenerHandler())})).intValue();
                SALog.i(TAG, "MdidSdkHelper ErrorCode : " + intValue);
                if (!(intValue == 1008614 || intValue == 1008610)) {
                    int i11 = i10 - 1;
                    getOAIDReflect(context, i11);
                    if (i11 == 0) {
                        mCountDownLatch.countDown();
                    }
                }
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException unused) {
                        }
                        SAOaidHelper.mCountDownLatch.countDown();
                    }
                }).start();
            } catch (Throwable th) {
                SALog.i(TAG, th.getMessage());
                int i12 = i10 - 1;
                getOAIDReflect(context, i12);
                if (i12 == 0) {
                    mCountDownLatch.countDown();
                }
            }
        }
    }

    public static synchronized String getOpenAdIdentifier(Context context) {
        synchronized (SAOaidHelper.class) {
            if (!SensorsDataUtils.isOAIDEnabled()) {
                SALog.i(TAG, "Sensors getOAID disabled");
                return "";
            } else if (SAPropertyManager.getInstance().isLimitKey(LimitKey.OAID)) {
                String limitValue = SAPropertyManager.getInstance().getLimitValue(LimitKey.OAID);
                return limitValue;
            } else if (Looper.getMainLooper() == Looper.myLooper()) {
                SALog.i(TAG, "function can not be called on main thread");
                return "";
            } else if (!TextUtils.isEmpty(mOAID)) {
                String str = mOAID;
                return str;
            } else {
                mOAID = getMSAOAID(context);
                SALog.i(TAG, "MSA OAID is " + mOAID);
                if (TextUtils.isEmpty(mOAID) || allZero(mOAID)) {
                    String romoaid = getROMOAID(context);
                    mReflectionOAID = romoaid;
                    if (TextUtils.isEmpty(romoaid) || allZero(mReflectionOAID)) {
                        mReflectionOAID = "";
                    }
                    mOAID = mReflectionOAID;
                    SALog.i(TAG, "Rom OAID is" + mOAID);
                }
                String str2 = mOAID;
                return str2;
            }
        }
    }

    public static String getOpenAdIdentifierByReflection(Context context) {
        if (!SensorsDataUtils.isOAIDEnabled()) {
            SALog.i(TAG, "Sensors getOAIDReflection disabled");
            return "";
        }
        if (TextUtils.isEmpty(mOAID)) {
            getOpenAdIdentifier(context);
        }
        return mReflectionOAID;
    }

    private static String getROMOAID(Context context) {
        return OAIDFactory.create(context).getRomOAID();
    }

    private static void initInvokeListener() {
        try {
            mMidSDKHelper = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            try {
                mIdentifyListener = Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
                mIdSupplier = Class.forName("com.bun.miitmdid.interfaces.IdSupplier");
            } catch (Exception unused) {
                try {
                    mIdentifyListener = Class.forName("com.bun.supplier.IIdentifierListener");
                    mIdSupplier = Class.forName("com.bun.supplier.IdSupplier");
                    jLibrary = Class.forName("com.bun.miitmdid.core.JLibrary");
                } catch (Exception unused2) {
                    try {
                        mIdentifyListener = Class.forName("com.bun.miitmdid.core.IIdentifierListener");
                        mIdSupplier = Class.forName("com.bun.miitmdid.supplier.IdSupplier");
                        jLibrary = Class.forName("com.bun.miitmdid.core.JLibrary");
                    } catch (Exception unused3) {
                    }
                }
            }
        } catch (ClassNotFoundException e10) {
            SALog.i(TAG, e10.getMessage());
        }
    }

    private static void initPemCert(Context context) {
        try {
            String loadPemFromAssetFile = loadPemFromAssetFile(context);
            if (!TextUtils.isEmpty(loadPemFromAssetFile)) {
                mMidSDKHelper.getDeclaredMethod("InitCert", new Class[]{Context.class, String.class}).invoke((Object) null, new Object[]{context, loadPemFromAssetFile});
            }
        } catch (Throwable th) {
            SALog.i(TAG, th.getMessage());
        }
    }

    private static void initSDKLibrary() {
        for (String loadLibrary : mLoadLibrary) {
            try {
                System.loadLibrary(loadLibrary);
                return;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r2 = r2.open(r0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String loadPemFromAssetFile(android.content.Context r2) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0054 }
            r0.<init>()     // Catch:{ IOException -> 0x0054 }
            java.lang.String r1 = r2.getPackageName()     // Catch:{ IOException -> 0x0054 }
            r0.append(r1)     // Catch:{ IOException -> 0x0054 }
            java.lang.String r1 = ".cert.pem"
            r0.append(r1)     // Catch:{ IOException -> 0x0054 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0054 }
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ IOException -> 0x0054 }
            java.lang.String r1 = mOidCertFilePath     // Catch:{ IOException -> 0x0054 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ IOException -> 0x0054 }
            if (r1 != 0) goto L_0x002d
            java.lang.String r1 = mOidCertFilePath     // Catch:{ IOException -> 0x0028 }
            java.io.InputStream r2 = r2.open(r1)     // Catch:{ IOException -> 0x0028 }
            goto L_0x0031
        L_0x0028:
            java.io.InputStream r2 = r2.open(r0)     // Catch:{ IOException -> 0x0054 }
            goto L_0x0031
        L_0x002d:
            java.io.InputStream r2 = r2.open(r0)     // Catch:{ IOException -> 0x0054 }
        L_0x0031:
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0054 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0054 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0054 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0054 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0054 }
            r2.<init>()     // Catch:{ IOException -> 0x0054 }
        L_0x0040:
            java.lang.String r1 = r0.readLine()     // Catch:{ IOException -> 0x0054 }
            if (r1 == 0) goto L_0x004f
            r2.append(r1)     // Catch:{ IOException -> 0x0054 }
            r1 = 10
            r2.append(r1)     // Catch:{ IOException -> 0x0054 }
            goto L_0x0040
        L_0x004f:
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0054 }
            return r2
        L_0x0054:
            java.lang.String r2 = "SA.SAOaidHelper"
            java.lang.String r0 = "loadPemFromAssetFile failed"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r0)
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.loadPemFromAssetFile(android.content.Context):java.lang.String");
    }

    public static void setOaidCertFilePath(String str) {
        mOidCertFilePath = str;
    }
}
