package com.fasterxml.jackson.databind.type;

import com.alibaba.pdns.model.DomainUhfReportModel;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.util.f;
import java.io.Serializable;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class n implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f5635e;

    /* renamed from: f  reason: collision with root package name */
    private static final j[] f5636f;

    /* renamed from: g  reason: collision with root package name */
    private static final n f5637g;

    /* renamed from: a  reason: collision with root package name */
    private final String[] f5638a;

    /* renamed from: b  reason: collision with root package name */
    private final j[] f5639b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f5640c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5641d;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Class f5642a;

        /* renamed from: b  reason: collision with root package name */
        private final j[] f5643b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5644c;

        public a(Class cls, j[] jVarArr, int i10) {
            this.f5642a = cls;
            this.f5643b = jVarArr;
            this.f5644c = i10;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f5644c == aVar.f5644c && this.f5642a == aVar.f5642a) {
                j[] jVarArr = aVar.f5643b;
                int length = this.f5643b.length;
                if (length == jVarArr.length) {
                    for (int i10 = 0; i10 < length; i10++) {
                        if (!this.f5643b[i10].equals(jVarArr[i10])) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f5644c;
        }

        public String toString() {
            return this.f5642a.getName() + "<>";
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final TypeVariable[] f5645a = AbstractList.class.getTypeParameters();

        /* renamed from: b  reason: collision with root package name */
        private static final TypeVariable[] f5646b = Collection.class.getTypeParameters();

        /* renamed from: c  reason: collision with root package name */
        private static final TypeVariable[] f5647c = Iterable.class.getTypeParameters();

        /* renamed from: d  reason: collision with root package name */
        private static final TypeVariable[] f5648d = List.class.getTypeParameters();

        /* renamed from: e  reason: collision with root package name */
        private static final TypeVariable[] f5649e = ArrayList.class.getTypeParameters();

        /* renamed from: f  reason: collision with root package name */
        private static final TypeVariable[] f5650f = Map.class.getTypeParameters();

        /* renamed from: g  reason: collision with root package name */
        private static final TypeVariable[] f5651g = HashMap.class.getTypeParameters();

        /* renamed from: h  reason: collision with root package name */
        private static final TypeVariable[] f5652h = LinkedHashMap.class.getTypeParameters();

        public static TypeVariable[] a(Class cls) {
            if (cls == Collection.class) {
                return f5646b;
            }
            if (cls == List.class) {
                return f5648d;
            }
            if (cls == ArrayList.class) {
                return f5649e;
            }
            if (cls == AbstractList.class) {
                return f5645a;
            }
            if (cls == Iterable.class) {
                return f5647c;
            }
            return cls.getTypeParameters();
        }

        public static TypeVariable[] b(Class cls) {
            if (cls == Map.class) {
                return f5650f;
            }
            if (cls == HashMap.class) {
                return f5651g;
            }
            if (cls == LinkedHashMap.class) {
                return f5652h;
            }
            return cls.getTypeParameters();
        }
    }

    static {
        String[] strArr = new String[0];
        f5635e = strArr;
        j[] jVarArr = new j[0];
        f5636f = jVarArr;
        f5637g = new n(strArr, jVarArr, (String[]) null);
    }

    private n(String[] strArr, j[] jVarArr, String[] strArr2) {
        strArr = strArr == null ? f5635e : strArr;
        this.f5638a = strArr;
        jVarArr = jVarArr == null ? f5636f : jVarArr;
        this.f5639b = jVarArr;
        if (strArr.length == jVarArr.length) {
            int length = jVarArr.length;
            int i10 = 1;
            for (int i11 = 0; i11 < length; i11++) {
                i10 += this.f5639b[i11].hashCode();
            }
            this.f5640c = strArr2;
            this.f5641d = i10;
            return;
        }
        throw new IllegalArgumentException("Mismatching names (" + strArr.length + "), types (" + jVarArr.length + ")");
    }

    public static n b(Class cls, j jVar) {
        int i10;
        TypeVariable[] a10 = b.a(cls);
        if (a10 == null) {
            i10 = 0;
        } else {
            i10 = a10.length;
        }
        if (i10 == 1) {
            return new n(new String[]{a10[0].getName()}, new j[]{jVar}, (String[]) null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 1 type parameter: class expects " + i10);
    }

    public static n c(Class cls, j jVar, j jVar2) {
        int i10;
        TypeVariable[] b10 = b.b(cls);
        if (b10 == null) {
            i10 = 0;
        } else {
            i10 = b10.length;
        }
        if (i10 == 2) {
            return new n(new String[]{b10[0].getName(), b10[1].getName()}, new j[]{jVar, jVar2}, (String[]) null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 2 type parameters: class expects " + i10);
    }

    public static n d(Class cls, j[] jVarArr) {
        String[] strArr;
        String str;
        if (jVarArr == null) {
            jVarArr = f5636f;
        } else {
            int length = jVarArr.length;
            if (length == 1) {
                return b(cls, jVarArr[0]);
            }
            if (length == 2) {
                return c(cls, jVarArr[0], jVarArr[1]);
            }
        }
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length == 0) {
            strArr = f5635e;
        } else {
            int length2 = typeParameters.length;
            strArr = new String[length2];
            for (int i10 = 0; i10 < length2; i10++) {
                strArr[i10] = typeParameters[i10].getName();
            }
        }
        if (strArr.length == jVarArr.length) {
            return new n(strArr, jVarArr, (String[]) null);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot create TypeBindings for class ");
        sb2.append(cls.getName());
        sb2.append(" with ");
        sb2.append(jVarArr.length);
        sb2.append(" type parameter");
        if (jVarArr.length == 1) {
            str = "";
        } else {
            str = DomainUhfReportModel.SCENE;
        }
        sb2.append(str);
        sb2.append(": class expects ");
        sb2.append(strArr.length);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static n e(List list, List list2) {
        if (list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return f5637g;
        }
        return new n((String[]) list.toArray(f5635e), (j[]) list2.toArray(f5636f), (String[]) null);
    }

    public static n f(Class cls, j jVar) {
        int i10;
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null) {
            i10 = 0;
        } else {
            i10 = typeParameters.length;
        }
        if (i10 == 0) {
            return f5637g;
        }
        if (i10 == 1) {
            return new n(new String[]{typeParameters[0].getName()}, new j[]{jVar}, (String[]) null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 1 type parameter: class expects " + i10);
    }

    public static n h(Class cls, j[] jVarArr) {
        String str;
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length == 0) {
            return f5637g;
        }
        if (jVarArr == null) {
            jVarArr = f5636f;
        }
        int length = typeParameters.length;
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            strArr[i10] = typeParameters[i10].getName();
        }
        if (length == jVarArr.length) {
            return new n(strArr, jVarArr, (String[]) null);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot create TypeBindings for class ");
        sb2.append(cls.getName());
        sb2.append(" with ");
        sb2.append(jVarArr.length);
        sb2.append(" type parameter");
        if (jVarArr.length == 1) {
            str = "";
        } else {
            str = DomainUhfReportModel.SCENE;
        }
        sb2.append(str);
        sb2.append(": class expects ");
        sb2.append(length);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static n i() {
        return f5637g;
    }

    public Object a(Class cls) {
        return new a(cls, this.f5639b, this.f5641d);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!f.D(obj, getClass())) {
            return false;
        }
        n nVar = (n) obj;
        int length = this.f5639b.length;
        if (length != nVar.o()) {
            return false;
        }
        j[] jVarArr = nVar.f5639b;
        for (int i10 = 0; i10 < length; i10++) {
            if (!jVarArr[i10].equals(this.f5639b[i10])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f5641d;
    }

    public j j(String str) {
        j Y;
        int length = this.f5638a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(this.f5638a[i10])) {
                j jVar = this.f5639b[i10];
                if (!(jVar instanceof k) || (Y = ((k) jVar).Y()) == null) {
                    return jVar;
                }
                return Y;
            }
        }
        return null;
    }

    public j k(int i10) {
        if (i10 < 0) {
            return null;
        }
        j[] jVarArr = this.f5639b;
        if (i10 >= jVarArr.length) {
            return null;
        }
        return jVarArr[i10];
    }

    public List l() {
        j[] jVarArr = this.f5639b;
        if (jVarArr.length == 0) {
            return Collections.emptyList();
        }
        return Arrays.asList(jVarArr);
    }

    public boolean m(String str) {
        String[] strArr = this.f5640c;
        if (strArr == null) {
            return false;
        }
        int length = strArr.length;
        do {
            length--;
            if (length < 0) {
                return false;
            }
        } while (!str.equals(this.f5640c[length]));
        return true;
    }

    public boolean n() {
        if (this.f5639b.length == 0) {
            return true;
        }
        return false;
    }

    public int o() {
        return this.f5639b.length;
    }

    /* access modifiers changed from: protected */
    public j[] p() {
        return this.f5639b;
    }

    public n q(String str) {
        int i10;
        String[] strArr;
        String[] strArr2 = this.f5640c;
        if (strArr2 == null) {
            i10 = 0;
        } else {
            i10 = strArr2.length;
        }
        if (i10 == 0) {
            strArr = new String[1];
        } else {
            strArr = (String[]) Arrays.copyOf(strArr2, i10 + 1);
        }
        strArr[i10] = str;
        return new n(this.f5638a, this.f5639b, strArr);
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        String[] strArr = this.f5638a;
        if (strArr == null || strArr.length == 0) {
            return f5637g;
        }
        return this;
    }

    public String toString() {
        if (this.f5639b.length == 0) {
            return "<>";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('<');
        int length = this.f5639b.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 > 0) {
                sb2.append(',');
            }
            sb2.append(this.f5639b[i10].n());
        }
        sb2.append('>');
        return sb2.toString();
    }
}
