package com.mah.ndk;

import android.content.Context;
import android.text.TextUtils;
import b.b;
import i.i;
import i.u;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import k.a;
import w.d;

public class MahxServer extends Thread {
    public static final int OooO = 0;
    public static final String OooO0O0 = d.f("");
    public static final int OooO0OO = 2;
    public static final int OooO0Oo = 4;
    public static final int OooO0o = 0;

    /* renamed from: OooO0o0  reason: collision with root package name */
    public static final int f10149OooO0o0 = 5;
    public static final int OooO0oO = -1;
    public static final int OooO0oo = 6;
    public static final int OooOO0 = 1;
    public static final int OooOO0O = 2;
    public static final int OooOO0o = 3;
    public static final int OooOOO = 5;
    public static final int OooOOO0 = 4;
    public static final int OooOOOO = 6;
    public static final int OooOOOo = 7;
    public static final int OooOOo = 9;
    public static final int OooOOo0 = 8;
    public static final int OooOOoo = 10;

    /* renamed from: OooOo  reason: collision with root package name */
    public static final String f10150OooOo = "Thread-Mahx";
    public static b OooOo0 = null;
    public static boolean OooOo00 = false;
    public static AtomicInteger OooOo0O = null;
    public static final AtomicBoolean OooOo0o = new AtomicBoolean(false);
    public static long OooOoO = 0;

    /* renamed from: OooOoO0  reason: collision with root package name */
    public static CountDownLatch f10151OooOoO0 = null;
    public static String OooOoOO = "";
    public static final String OooOoo0 = "libmahjni.so";
    public OooO0O0 OooO00o;

    public MahxServer(b bVar) {
        super(f10150OooOo);
        OooOo0 = bVar;
        OooOo0O = new AtomicInteger(-1);
    }

    public static boolean OooO() {
        if (OooOo0o.get()) {
            return true;
        }
        return false;
    }

    public static String OooO00o() {
        if (!OooOo00) {
            return "";
        }
        return akm();
    }

    public static String OooO0O0() throws i {
        try {
            return abi();
        } catch (Throwable th) {
            throw new i("abi", th);
        }
    }

    public static String OooO0OO() {
        return dmi();
    }

    public static String OooO0Oo() throws i {
        try {
            return gv();
        } catch (Throwable th) {
            throw new i("gv", th);
        }
    }

    public static String OooO0o() {
        if (!OooOo00) {
            return "";
        }
        return psk();
    }

    public static String OooO0o0() {
        if (!OooOo00) {
            return "";
        }
        return nsk();
    }

    public static int OooO0oO() {
        return OooOo0.g() ? 1 : 0;
    }

    public static void OooOOO() {
        CountDownLatch countDownLatch = f10151OooOoO0;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    private static native String abi();

    private static native String akm();

    private static native String dmi();

    private static native String gv();

    private static native int ii(int i10, String str, String str2, String str3, boolean z10);

    private native int nnc(byte[] bArr);

    private static native String nsk();

    private native int nus(byte[] bArr);

    public static int onCallback(int i10, int i11, int i12, String str, String str2) {
        if (i10 == 0) {
            return OooO00o(str, str2);
        }
        if (i10 == 2) {
            return OooO0OO(str);
        }
        if (i10 == 4) {
            OooOo0.c(i11);
            return 0;
        } else if (i10 == 6) {
            return OooO00o(i11);
        } else {
            switch (i10) {
                case 8:
                    a.f().l();
                    return 0;
                case 9:
                    OooOo0.b(str);
                    return 0;
                case 10:
                    return OooOo0.g() ? 1 : 0;
                default:
                    return 0;
            }
        }
    }

    private static native String psk();

    private static native String rt(String str);

    private native void sbrp(boolean z10);

    private native void shd(String[] strArr);

    private static native void shrr(String str, String str2, int i10);

    private native int sps();

    private native int sts(byte[] bArr);

    public final void OooO0oo() {
        OooOoO = System.currentTimeMillis();
    }

    public boolean OooOO0() {
        if (OooOo0O.get() == 0) {
            return true;
        }
        return false;
    }

    public boolean OooOO0O() throws i {
        byte[] OooO00o2;
        if (OooO() || (OooO00o2 = this.OooO00o.OooO00o()) == null) {
            return false;
        }
        try {
            if (nnc(OooO00o2) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw new i("nnc", th);
        }
    }

    public boolean OooOO0o() throws i {
        byte[] OooO00o2;
        if (OooO() || (OooO00o2 = this.OooO00o.OooO00o()) == null) {
            return false;
        }
        try {
            if (nus(OooO00o2) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw new i("nus", th);
        }
    }

    public void OooOOO0() throws i {
        if (OooOo00 && OooOO0() && !OooO()) {
            OooOo0O.set(6);
            try {
                sps();
            } catch (Throwable th) {
                throw new i("sps", th);
            }
        }
    }

    public void run() {
        String str = OooO0O0;
        byte[] OooO00o2 = this.OooO00o.OooO00o();
        if (OooO00o2 == null) {
            d.h(str, "settings is null 0");
            return;
        }
        try {
            int sts = sts(OooO00o2);
            d.m(str, "MAHX sts, rv=" + sts);
            if (sts == 0) {
                OooOo0O.set(-1);
            }
            OooOo0.p(sts);
        } catch (Throwable th) {
            OooOOO();
            throw th;
        }
        OooOOO();
    }

    public static int OooO0OO(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        u.b(new q9.a(str));
        return 0;
    }

    public static int OooO0Oo(String str) {
        OooOo0.b(str);
        return 0;
    }

    public static int OooO00o(Context context) {
        try {
            OooOoOO = b.a.d(context, "mahjni");
            OooOo00 = true;
            return 0;
        } catch (UnsatisfiedLinkError e10) {
            d.g(OooO0O0, "unable to load library libmahjni.so", e10);
            return -1;
        } catch (Throwable th) {
            d.g(OooO0O0, "unable to load library libmahjni.so", th);
            return -2;
        }
    }

    public static int OooO0O0(int i10) {
        OooOo0.c(i10);
        return 0;
    }

    public int OooO0O0(OooO0O0 oooO0O0) {
        if (OooO()) {
            return 5;
        }
        if (OooOo0O.get() != -1) {
            d.k(OooO0O0, "startSync: already started");
            return OooOo0O.get();
        }
        OooOoO = System.currentTimeMillis();
        this.OooO00o = oooO0O0;
        f10151OooOoO0 = new CountDownLatch(1);
        start();
        try {
            f10151OooOoO0.await();
        } catch (InterruptedException unused) {
            OooOo0O.set(2);
        }
        return OooOo0O.get();
    }

    public static int OooO00o(Context context, String str, boolean z10) throws i {
        if (OooO()) {
            return -1;
        }
        if (!OooOo00) {
            return -2;
        }
        try {
            return ii(5, OooOoOO, context.getFilesDir().getAbsolutePath(), str, z10);
        } catch (Throwable th) {
            d.g(OooO0O0, "Mah native init error", th);
            throw new i("ii", th);
        }
    }

    public static String OooO00o(String str) {
        return rt(str);
    }

    public static void OooO00o(String str, String str2, int i10) {
        shrr(str, str2, i10);
    }

    public static int OooO00o(int i10) {
        if (OooOo0o.compareAndSet(false, true)) {
            OooOo0.a(i10);
        }
        return 0;
    }

    public static int OooO00o(String str, String str2) {
        String[] split = str2.split(":");
        if (split.length == 3) {
            OooOo0.w(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), str, OooOoO);
            OooOo0O.set(0);
        }
        OooOOO();
        return 0;
    }

    public int OooO00o(OooO0O0 oooO0O0) {
        if (OooO()) {
            return 5;
        }
        if (OooOo0O.get() != -1) {
            return OooOo0O.get();
        }
        OooOoO = System.currentTimeMillis();
        this.OooO00o = oooO0O0;
        start();
        OooOo0O.set(0);
        return OooOo0O.get();
    }

    public void OooO00o(String[] strArr) throws i {
        if (OooOo00 && !OooO() && OooOO0()) {
            try {
                shd(strArr);
            } catch (Throwable th) {
                throw new i("shd", th);
            }
        }
    }
}
