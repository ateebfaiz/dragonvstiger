package p3;

import android.content.Context;
import java.util.Set;
import m4.g;
import s3.a;
import w2.i;
import y2.o;
import z4.k;

public class f implements o {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23120a;

    /* renamed from: b  reason: collision with root package name */
    private final k f23121b;

    /* renamed from: c  reason: collision with root package name */
    private final g f23122c;

    /* renamed from: d  reason: collision with root package name */
    private final Set f23123d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f23124e;

    public f(Context context, b bVar) {
        this(context, z4.o.n(), bVar);
    }

    /* renamed from: a */
    public e get() {
        return new e(this.f23120a, this.f23122c, this.f23121b, this.f23123d, this.f23124e).M((g) null);
    }

    public f(Context context, z4.o oVar, b bVar) {
        this(context, oVar, (Set) null, (Set) null, bVar);
    }

    public f(Context context, z4.o oVar, Set set, Set set2, b bVar) {
        this.f23120a = context;
        k l10 = oVar.l();
        this.f23121b = l10;
        g gVar = new g();
        this.f23122c = gVar;
        gVar.a(context.getResources(), a.b(), oVar.b(context), i.g(), l10.m(), (y2.f) null, (o) null);
        this.f23123d = set;
        this.f23124e = set2;
    }
}
