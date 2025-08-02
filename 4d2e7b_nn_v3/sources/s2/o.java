package s2;

import java.io.IOException;
import r2.b;
import r2.c;
import r2.d;

public class o implements b {

    /* renamed from: i  reason: collision with root package name */
    private static final Object f23836i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static o f23837j;

    /* renamed from: k  reason: collision with root package name */
    private static int f23838k;

    /* renamed from: a  reason: collision with root package name */
    private d f23839a;

    /* renamed from: b  reason: collision with root package name */
    private String f23840b;

    /* renamed from: c  reason: collision with root package name */
    private long f23841c;

    /* renamed from: d  reason: collision with root package name */
    private long f23842d;

    /* renamed from: e  reason: collision with root package name */
    private long f23843e;

    /* renamed from: f  reason: collision with root package name */
    private IOException f23844f;

    /* renamed from: g  reason: collision with root package name */
    private c.a f23845g;

    /* renamed from: h  reason: collision with root package name */
    private o f23846h;

    private o() {
    }

    public static o a() {
        synchronized (f23836i) {
            try {
                o oVar = f23837j;
                if (oVar == null) {
                    return new o();
                }
                f23837j = oVar.f23846h;
                oVar.f23846h = null;
                f23838k--;
                return oVar;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private void c() {
        this.f23839a = null;
        this.f23840b = null;
        this.f23841c = 0;
        this.f23842d = 0;
        this.f23843e = 0;
        this.f23844f = null;
        this.f23845g = null;
    }

    public void b() {
        synchronized (f23836i) {
            try {
                if (f23838k < 5) {
                    c();
                    f23838k++;
                    o oVar = f23837j;
                    if (oVar != null) {
                        this.f23846h = oVar;
                    }
                    f23837j = this;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public o d(d dVar) {
        this.f23839a = dVar;
        return this;
    }

    public o e(long j10) {
        this.f23842d = j10;
        return this;
    }

    public o f(long j10) {
        this.f23843e = j10;
        return this;
    }

    public o g(c.a aVar) {
        this.f23845g = aVar;
        return this;
    }

    public o h(IOException iOException) {
        this.f23844f = iOException;
        return this;
    }

    public o i(long j10) {
        this.f23841c = j10;
        return this;
    }

    public o j(String str) {
        this.f23840b = str;
        return this;
    }
}
