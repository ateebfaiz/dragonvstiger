package l8;

import com.fasterxml.jackson.databind.type.f;
import java.io.Serializable;
import java.util.Map;

public class d implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    private static final int f12679e = f.values().length;

    /* renamed from: a  reason: collision with root package name */
    protected b f12680a;

    /* renamed from: b  reason: collision with root package name */
    protected final n f12681b;

    /* renamed from: c  reason: collision with root package name */
    protected n[] f12682c;

    /* renamed from: d  reason: collision with root package name */
    protected Map f12683d;

    public d() {
        this(b.TryConvert, new n(), (n[]) null, (Map) null);
    }

    protected d(b bVar, n nVar, n[] nVarArr, Map map) {
        this.f12681b = nVar;
        this.f12680a = bVar;
        this.f12682c = nVarArr;
        this.f12683d = map;
    }
}
