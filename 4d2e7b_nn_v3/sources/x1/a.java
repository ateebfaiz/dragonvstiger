package x1;

import android.content.Context;
import android.text.TextUtils;
import com.engagelab.privates.core.api.Address;
import g1.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static Address f24704a = null;

    /* renamed from: b  reason: collision with root package name */
    private static long f24705b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f24706c = -1;

    /* renamed from: d  reason: collision with root package name */
    private static long f24707d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static String f24708e = null;

    /* renamed from: f  reason: collision with root package name */
    private static String f24709f = null;

    /* renamed from: g  reason: collision with root package name */
    private static int f24710g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static int f24711h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static long f24712i = 0;

    /* renamed from: j  reason: collision with root package name */
    private static long f24713j = 290000;

    /* renamed from: k  reason: collision with root package name */
    private static int f24714k = 3;

    public static Address a() {
        if (f24704a == null) {
            synchronized (a.class) {
                try {
                    if (f24704a == null) {
                        if (p1.a.f23052a) {
                            Address address = new Address();
                            address.l("sis.push.theengagelab.com", "sis.push.engageforce.net", "sis.push.engage7.com");
                            address.m("159.138.85.252", "114.119.186.57");
                            address.n(19000);
                            address.h("conn.push.theengagelab.com");
                            address.i("159.138.90.61");
                            address.j(3000);
                            address.k("https://pushstat.api.engagelab.cc");
                            f24704a = address;
                        } else {
                            f24704a = new Address();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f24704a;
    }

    public static int b() {
        return f24714k;
    }

    public static long c() {
        return f24713j;
    }

    public static List d(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(e(context));
        Collections.shuffle(arrayList);
        return arrayList;
    }

    private static Set e(Context context) {
        Set q10 = n.q(context);
        Address a10 = a();
        if (a10 == null) {
            return q10;
        }
        String d10 = a10.d();
        if (!TextUtils.isEmpty(d10)) {
            q10.add(d10);
        }
        return q10;
    }

    public static byte f(Context context) {
        return n.w(context);
    }

    public static String g(Context context) {
        if (TextUtils.isEmpty(f24708e)) {
            f24708e = n.y(context);
        }
        return f24708e;
    }

    public static long h() {
        long j10 = f24705b;
        long j11 = 2;
        if (j10 % 2 == 0) {
            j11 = 1;
        }
        long j12 = (j10 + j11) % 32767;
        f24705b = j12;
        return j12;
    }

    public static void i(int i10) {
        f24710g = i10;
    }

    public static void j(String str) {
        f24709f = str;
    }

    public static void k(Context context, byte b10) {
        n.b(context, b10);
    }

    public static void l(int i10) {
        f24706c = i10;
    }

    public static void m(String str) {
        f24708e = str;
    }

    public static void n(int i10) {
        f24711h = i10;
    }

    public static void o(long j10) {
        f24712i = j10;
    }

    public static void p(long j10) {
        f24707d = j10;
    }
}
