package h;

import android.util.SparseArray;
import h.a;
import java.util.List;
import org.json.JSONObject;
import w.d;

public class g {
    public static final String W = d.f("");
    public final String A;
    public final String B;
    public final String C;
    public final String D;
    public final e E;
    public final d F;
    public final h G;
    public final h H;
    public final i I;
    public final List J;
    public final List K;
    public final SparseArray L;
    public final boolean M;
    public final boolean N;
    public final boolean O;
    public final String P;
    public final boolean Q;
    public final int R;
    public final String S;
    public final String T;
    public final boolean U;
    public final boolean V;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f21775a;

    /* renamed from: b  reason: collision with root package name */
    public final String f21776b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f21777c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f21778d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f21779e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f21780f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f21781g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f21782h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f21783i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f21784j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f21785k;

    /* renamed from: l  reason: collision with root package name */
    public final long f21786l;

    /* renamed from: m  reason: collision with root package name */
    public final int f21787m;

    /* renamed from: n  reason: collision with root package name */
    public final int f21788n;

    /* renamed from: o  reason: collision with root package name */
    public final int f21789o;

    /* renamed from: p  reason: collision with root package name */
    public final int f21790p;

    /* renamed from: q  reason: collision with root package name */
    public final int f21791q;

    /* renamed from: r  reason: collision with root package name */
    public final int f21792r;

    /* renamed from: s  reason: collision with root package name */
    public final int f21793s;

    /* renamed from: t  reason: collision with root package name */
    public final String f21794t;

    /* renamed from: u  reason: collision with root package name */
    public final String f21795u;

    /* renamed from: v  reason: collision with root package name */
    public final String f21796v;

    /* renamed from: w  reason: collision with root package name */
    public final String f21797w;

    /* renamed from: x  reason: collision with root package name */
    public final String f21798x;

    /* renamed from: y  reason: collision with root package name */
    public final String f21799y;

    /* renamed from: z  reason: collision with root package name */
    public final String f21800z;

    public static class a {
        public String A = "";
        public String B = "";
        public String C = "";
        public String D = "";
        public e E = new e();
        public d F = null;
        public i G = new i(3, 1.6f, 120);
        public h H = null;
        public h I = null;
        public List J = null;
        public List K = null;
        public SparseArray L = e();
        public boolean M = true;
        public boolean N = false;
        public boolean O = false;
        public String P = "0/-1";
        public boolean Q = false;
        public int R = 0;
        public String S = "";
        public String T = "";
        public boolean U = false;
        public boolean V = true;

        /* renamed from: a  reason: collision with root package name */
        public boolean f21801a = true;

        /* renamed from: b  reason: collision with root package name */
        public String f21802b = "";

        /* renamed from: c  reason: collision with root package name */
        public boolean f21803c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f21804d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f21805e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f21806f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f21807g = true;

        /* renamed from: h  reason: collision with root package name */
        public boolean f21808h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f21809i = true;

        /* renamed from: j  reason: collision with root package name */
        public boolean f21810j = false;

        /* renamed from: k  reason: collision with root package name */
        public boolean f21811k = true;

        /* renamed from: l  reason: collision with root package name */
        public long f21812l = 0;

        /* renamed from: m  reason: collision with root package name */
        public int f21813m = 0;

        /* renamed from: n  reason: collision with root package name */
        public int f21814n = 60;

        /* renamed from: o  reason: collision with root package name */
        public int f21815o = -1;

        /* renamed from: p  reason: collision with root package name */
        public final int f21816p = 1;

        /* renamed from: q  reason: collision with root package name */
        public int f21817q = 2;

        /* renamed from: r  reason: collision with root package name */
        public int f21818r = 2;

        /* renamed from: s  reason: collision with root package name */
        public int f21819s = 60;

        /* renamed from: t  reason: collision with root package name */
        public String f21820t = "";

        /* renamed from: u  reason: collision with root package name */
        public String f21821u = "";

        /* renamed from: v  reason: collision with root package name */
        public String f21822v = null;

        /* renamed from: w  reason: collision with root package name */
        public String f21823w = "";

        /* renamed from: x  reason: collision with root package name */
        public String f21824x = "";

        /* renamed from: y  reason: collision with root package name */
        public String f21825y = "";

        /* renamed from: z  reason: collision with root package name */
        public String f21826z = "";

        public static SparseArray e() {
            SparseArray sparseArray = new SparseArray();
            a aVar = new a(new a.C0284a(2));
            sparseArray.put(aVar.f21744f, aVar);
            a aVar2 = new a(new a.C0284a(3));
            sparseArray.put(aVar2.f21744f, aVar2);
            a aVar3 = new a(new a.C0284a(4));
            sparseArray.put(aVar3.f21744f, aVar3);
            a aVar4 = new a(new a.C0284a(5));
            sparseArray.put(aVar4.f21744f, aVar4);
            a aVar5 = new a(new a.C0284a(6));
            sparseArray.put(aVar5.f21744f, aVar5);
            return sparseArray;
        }

        public void a(SparseArray sparseArray) {
            this.L = sparseArray;
        }

        public void b(e eVar) {
            this.E = eVar;
        }

        public void c(h hVar) {
            this.I = hVar;
        }

        public void d(List list) {
            this.J = list;
        }

        public void f(h hVar) {
            this.H = hVar;
        }

        public void g(List list) {
            this.K = list;
        }
    }

    public g(a aVar) {
        this.f21775a = aVar.f21801a;
        this.f21776b = aVar.f21802b;
        this.f21786l = aVar.f21812l;
        this.f21787m = aVar.f21813m;
        this.f21777c = aVar.f21808h;
        this.E = aVar.E;
        this.f21788n = aVar.f21814n;
        this.f21794t = aVar.f21820t;
        this.f21791q = aVar.f21817q;
        this.f21795u = aVar.f21821u;
        this.f21792r = aVar.f21818r;
        this.f21790p = aVar.f21815o;
        this.f21778d = aVar.f21809i;
        this.B = aVar.A;
        this.L = aVar.L;
        this.C = aVar.B;
        this.f21796v = aVar.f21824x;
        this.f21797w = aVar.f21825y;
        this.D = aVar.C;
        this.f21789o = aVar.f21816p;
        this.f21798x = aVar.D;
        this.G = aVar.H;
        this.H = aVar.I;
        this.f21781g = aVar.f21803c;
        this.f21782h = aVar.f21804d;
        this.J = aVar.J;
        this.K = aVar.K;
        this.F = aVar.F;
        this.f21779e = aVar.f21805e;
        this.f21799y = aVar.f21822v;
        this.f21780f = aVar.f21806f;
        this.f21800z = aVar.f21823w;
        this.f21783i = aVar.f21807g;
        this.I = aVar.G;
        this.f21793s = aVar.f21819s;
        this.A = aVar.f21826z;
        this.f21784j = aVar.f21810j;
        this.f21785k = aVar.f21811k;
        this.M = aVar.M;
        this.N = aVar.N;
        this.O = aVar.O;
        this.P = aVar.P;
        this.Q = aVar.Q;
        this.R = aVar.R;
        this.S = aVar.S;
        this.T = aVar.T;
        this.U = aVar.U;
        this.V = aVar.V;
    }

    public static g a(JSONObject jSONObject) {
        return new f().j(jSONObject);
    }

    public a b(int i10) {
        a aVar = (a) this.L.get(i10);
        if (aVar == null) {
            return (a) this.L.get(5);
        }
        return aVar;
    }

    public boolean c() {
        return this.f21779e;
    }

    public String d() {
        return this.E.d();
    }
}
