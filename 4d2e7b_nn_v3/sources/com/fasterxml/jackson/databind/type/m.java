package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.n;
import i8.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import q8.g;

public abstract class m extends j implements n {

    /* renamed from: j  reason: collision with root package name */
    private static final n f5629j = n.i();

    /* renamed from: w  reason: collision with root package name */
    private static final j[] f5630w = new j[0];

    /* renamed from: f  reason: collision with root package name */
    protected final j f5631f;

    /* renamed from: g  reason: collision with root package name */
    protected final j[] f5632g;

    /* renamed from: h  reason: collision with root package name */
    protected final n f5633h;

    /* renamed from: i  reason: collision with root package name */
    volatile transient String f5634i;

    protected m(Class cls, n nVar, j jVar, j[] jVarArr, int i10, Object obj, Object obj2, boolean z10) {
        super(cls, i10, obj, obj2, z10);
        this.f5633h = nVar == null ? f5629j : nVar;
        this.f5631f = jVar;
        this.f5632g = jVarArr;
    }

    protected static StringBuilder V(Class cls, StringBuilder sb2, boolean z10) {
        if (!cls.isPrimitive()) {
            sb2.append('L');
            String name = cls.getName();
            int length = name.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = name.charAt(i10);
                if (charAt == '.') {
                    charAt = '/';
                }
                sb2.append(charAt);
            }
            if (z10) {
                sb2.append(';');
            }
        } else if (cls == Boolean.TYPE) {
            sb2.append('Z');
        } else if (cls == Byte.TYPE) {
            sb2.append('B');
        } else if (cls == Short.TYPE) {
            sb2.append('S');
        } else if (cls == Character.TYPE) {
            sb2.append('C');
        } else if (cls == Integer.TYPE) {
            sb2.append('I');
        } else if (cls == Long.TYPE) {
            sb2.append('J');
        } else if (cls == Float.TYPE) {
            sb2.append('F');
        } else if (cls == Double.TYPE) {
            sb2.append('D');
        } else if (cls == Void.TYPE) {
            sb2.append('V');
        } else {
            throw new IllegalStateException("Unrecognized primitive type: " + cls.getName());
        }
        return sb2;
    }

    /* access modifiers changed from: protected */
    public boolean W(int i10) {
        if (this.f5439a.getTypeParameters().length == i10) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public String X() {
        return this.f5439a.getName();
    }

    public void a(f fVar, b0 b0Var) {
        fVar.s0(e());
    }

    public void c(f fVar, b0 b0Var, g gVar) {
        b bVar = new b(this, k.VALUE_STRING);
        gVar.g(fVar, bVar);
        a(fVar, b0Var);
        gVar.h(fVar, bVar);
    }

    public String e() {
        String str = this.f5634i;
        if (str == null) {
            return X();
        }
        return str;
    }

    public j f(int i10) {
        return this.f5633h.k(i10);
    }

    public int h() {
        return this.f5633h.o();
    }

    public final j j(Class cls) {
        j j10;
        j[] jVarArr;
        if (cls == this.f5439a) {
            return this;
        }
        if (cls.isInterface() && (jVarArr = this.f5632g) != null) {
            int length = jVarArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                j j11 = this.f5632g[i10].j(cls);
                if (j11 != null) {
                    return j11;
                }
            }
        }
        j jVar = this.f5631f;
        if (jVar == null || (j10 = jVar.j(cls)) == null) {
            return null;
        }
        return j10;
    }

    public n k() {
        return this.f5633h;
    }

    public List p() {
        j[] jVarArr = this.f5632g;
        if (jVarArr == null) {
            return Collections.emptyList();
        }
        int length = jVarArr.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        if (length != 1) {
            return Arrays.asList(jVarArr);
        }
        return Collections.singletonList(jVarArr[0]);
    }

    public j u() {
        return this.f5631f;
    }
}
