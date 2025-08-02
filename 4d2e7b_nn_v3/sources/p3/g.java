package p3;

import android.content.res.Resources;
import java.util.concurrent.Executor;
import s3.a;
import x4.x;
import y2.f;
import y2.o;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private Resources f23125a;

    /* renamed from: b  reason: collision with root package name */
    private a f23126b;

    /* renamed from: c  reason: collision with root package name */
    private d5.a f23127c;

    /* renamed from: d  reason: collision with root package name */
    private Executor f23128d;

    /* renamed from: e  reason: collision with root package name */
    private x f23129e;

    /* renamed from: f  reason: collision with root package name */
    private f f23130f;

    /* renamed from: g  reason: collision with root package name */
    private o f23131g;

    public void a(Resources resources, a aVar, d5.a aVar2, Executor executor, x xVar, f fVar, o oVar) {
        this.f23125a = resources;
        this.f23126b = aVar;
        this.f23127c = aVar2;
        this.f23128d = executor;
        this.f23129e = xVar;
        this.f23130f = fVar;
        this.f23131g = oVar;
    }

    /* access modifiers changed from: protected */
    public d b(Resources resources, a aVar, d5.a aVar2, Executor executor, x xVar, f fVar) {
        return new d(resources, aVar, aVar2, executor, xVar, fVar);
    }

    public d c() {
        d b10 = b(this.f23125a, this.f23126b, this.f23127c, this.f23128d, this.f23129e, this.f23130f);
        o oVar = this.f23131g;
        if (oVar != null) {
            b10.y0(((Boolean) oVar.get()).booleanValue());
        }
        return b10;
    }
}
