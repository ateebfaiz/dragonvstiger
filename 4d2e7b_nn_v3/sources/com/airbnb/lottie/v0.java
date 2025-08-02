package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import c.d;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import y0.j;

public class v0 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f17785a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Set f17786b = new ArraySet();

    /* renamed from: c  reason: collision with root package name */
    private final Map f17787c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Comparator f17788d = new a();

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(Pair pair, Pair pair2) {
            float floatValue = ((Float) pair.second).floatValue();
            float floatValue2 = ((Float) pair2.second).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            if (floatValue > floatValue2) {
                return -1;
            }
            return 0;
        }
    }

    public void a(String str, float f10) {
        if (this.f17785a) {
            j jVar = (j) this.f17787c.get(str);
            if (jVar == null) {
                jVar = new j();
                this.f17787c.put(str, jVar);
            }
            jVar.a(f10);
            if (str.equals("__container")) {
                Iterator it = this.f17786b.iterator();
                if (it.hasNext()) {
                    d.a(it.next());
                    throw null;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z10) {
        this.f17785a = z10;
    }
}
