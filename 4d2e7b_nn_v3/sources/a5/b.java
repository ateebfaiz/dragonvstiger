package a5;

import android.graphics.Bitmap;
import c3.a;
import e5.d;
import i3.c;

public abstract class b extends i3.b {
    public void f(c cVar) {
        Bitmap bitmap;
        if (cVar.b()) {
            a aVar = (a) cVar.getResult();
            if (aVar == null || !(aVar.p() instanceof d)) {
                bitmap = null;
            } else {
                bitmap = ((d) aVar.p()).x();
            }
            try {
                g(bitmap);
            } finally {
                a.m(aVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void g(Bitmap bitmap);
}
