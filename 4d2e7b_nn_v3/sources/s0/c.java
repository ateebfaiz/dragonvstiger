package s0;

import java.util.Arrays;
import java.util.List;
import o0.e;
import t0.d;
import z0.a;

public class c extends p {
    public c(List list) {
        super(e(list));
    }

    private static a d(a aVar) {
        d dVar = (d) aVar.f24970b;
        d dVar2 = (d) aVar.f24971c;
        if (dVar == null || dVar2 == null || dVar.e().length == dVar2.e().length) {
            return aVar;
        }
        float[] f10 = f(dVar.e(), dVar2.e());
        return aVar.b(dVar.b(f10), dVar2.b(f10));
    }

    private static List e(List list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            list.set(i10, d((a) list.get(i10)));
        }
        return list;
    }

    static float[] f(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f10 = Float.NaN;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            float f11 = fArr3[i11];
            if (f11 != f10) {
                fArr3[i10] = f11;
                i10++;
                f10 = fArr3[i11];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i10);
    }

    public o0.a a() {
        return new e(this.f23753a);
    }

    public /* bridge */ /* synthetic */ List b() {
        return super.b();
    }

    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
