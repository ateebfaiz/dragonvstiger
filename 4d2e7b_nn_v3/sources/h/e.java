package h;

import android.text.TextUtils;
import w.d;

public class e {

    /* renamed from: e  reason: collision with root package name */
    public static final String f21767e = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final int f21768a;

    /* renamed from: b  reason: collision with root package name */
    public final int f21769b;

    /* renamed from: c  reason: collision with root package name */
    public final String f21770c;

    /* renamed from: d  reason: collision with root package name */
    public final a f21771d;

    public e() {
        this(10, 100, "https://rep.relrzreport.com/sce/upload", new a());
    }

    public a a() {
        return this.f21771d;
    }

    public boolean b(e eVar) {
        if (this.f21768a != eVar.f21768a || this.f21769b != eVar.f21769b || !TextUtils.equals(this.f21770c, eVar.f21770c) || !this.f21771d.b(eVar.a())) {
            return false;
        }
        return true;
    }

    public int c() {
        return this.f21768a;
    }

    public String d() {
        return this.f21770c;
    }

    public boolean e() {
        if (this.f21769b == -1) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.f21769b;
    }

    public boolean g() {
        a aVar = this.f21771d;
        if (aVar.f21772a != aVar.f21773b) {
            return true;
        }
        return false;
    }

    public e(int i10, int i11, String str, a aVar) {
        this.f21768a = i10;
        this.f21769b = i11;
        this.f21770c = str;
        this.f21771d = aVar;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f21772a;

        /* renamed from: b  reason: collision with root package name */
        public final int f21773b;

        public a() {
            this.f21772a = 1;
            this.f21773b = 1;
        }

        public int a() {
            return this.f21773b;
        }

        public boolean b(a aVar) {
            if (this.f21772a == aVar.f21772a && this.f21773b == aVar.f21773b) {
                return true;
            }
            return false;
        }

        public a(int i10, int i11) {
            this.f21772a = i10;
            this.f21773b = i11;
        }
    }
}
