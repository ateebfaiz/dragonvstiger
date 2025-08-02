package com.fasterxml.jackson.databind.type;

public class j extends l {
    protected final com.fasterxml.jackson.databind.j C;
    protected final com.fasterxml.jackson.databind.j X;

    /* JADX WARNING: type inference failed for: r16v0, types: [com.fasterxml.jackson.databind.j] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected j(java.lang.Class r11, com.fasterxml.jackson.databind.type.n r12, com.fasterxml.jackson.databind.j r13, com.fasterxml.jackson.databind.j[] r14, com.fasterxml.jackson.databind.j r15, com.fasterxml.jackson.databind.j r16, java.lang.Object r17, java.lang.Object r18, boolean r19) {
        /*
            r10 = this;
            r9 = r10
            int r5 = java.util.Objects.hashCode(r15)
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r6 = r17
            r7 = r18
            r8 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r15
            r9.C = r0
            if (r16 != 0) goto L_0x001a
            r0 = r9
            goto L_0x001c
        L_0x001a:
            r0 = r16
        L_0x001c:
            r9.X = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.type.j.<init>(java.lang.Class, com.fasterxml.jackson.databind.type.n, com.fasterxml.jackson.databind.j, com.fasterxml.jackson.databind.j[], com.fasterxml.jackson.databind.j, com.fasterxml.jackson.databind.j, java.lang.Object, java.lang.Object, boolean):void");
    }

    public static j c0(Class cls, n nVar, com.fasterxml.jackson.databind.j jVar, com.fasterxml.jackson.databind.j[] jVarArr, com.fasterxml.jackson.databind.j jVar2) {
        return new j(cls, nVar, jVar, jVarArr, jVar2, (com.fasterxml.jackson.databind.j) null, (Object) null, (Object) null, false);
    }

    public com.fasterxml.jackson.databind.j N(Class cls, n nVar, com.fasterxml.jackson.databind.j jVar, com.fasterxml.jackson.databind.j[] jVarArr) {
        return new j(cls, this.f5633h, jVar, jVarArr, this.C, this.X, this.f5441c, this.f5442d, this.f5443e);
    }

    public com.fasterxml.jackson.databind.j P(com.fasterxml.jackson.databind.j jVar) {
        if (this.C == jVar) {
            return this;
        }
        return new j(this.f5439a, this.f5633h, this.f5631f, this.f5632g, jVar, this.X, this.f5441c, this.f5442d, this.f5443e);
    }

    /* access modifiers changed from: protected */
    public String X() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f5439a.getName());
        if (this.C != null && W(1)) {
            sb2.append('<');
            sb2.append(this.C.e());
            sb2.append('>');
        }
        return sb2.toString();
    }

    public boolean d() {
        return true;
    }

    /* renamed from: d0 */
    public j Q(Object obj) {
        if (obj == this.C.v()) {
            return this;
        }
        return new j(this.f5439a, this.f5633h, this.f5631f, this.f5632g, this.C.T(obj), this.X, this.f5441c, this.f5442d, this.f5443e);
    }

    /* renamed from: e0 */
    public j Z() {
        if (this.f5443e) {
            return this;
        }
        return new j(this.f5439a, this.f5633h, this.f5631f, this.f5632g, this.C.S(), this.X, this.f5441c, this.f5442d, true);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (jVar.f5439a != this.f5439a) {
            return false;
        }
        return this.C.equals(jVar.C);
    }

    /* renamed from: f0 */
    public j a0(Object obj) {
        if (obj == this.f5442d) {
            return this;
        }
        return new j(this.f5439a, this.f5633h, this.f5631f, this.f5632g, this.C, this.X, this.f5441c, obj, this.f5443e);
    }

    /* renamed from: g0 */
    public j b0(Object obj) {
        if (obj == this.f5441c) {
            return this;
        }
        return new j(this.f5439a, this.f5633h, this.f5631f, this.f5632g, this.C, this.X, obj, this.f5442d, this.f5443e);
    }

    public com.fasterxml.jackson.databind.j l() {
        return this.C;
    }

    public StringBuilder m(StringBuilder sb2) {
        return m.V(this.f5439a, sb2, true);
    }

    public StringBuilder o(StringBuilder sb2) {
        m.V(this.f5439a, sb2, false);
        sb2.append('<');
        StringBuilder o10 = this.C.o(sb2);
        o10.append(">;");
        return o10;
    }

    /* renamed from: t */
    public com.fasterxml.jackson.databind.j b() {
        return this.C;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("[reference type, class ");
        sb2.append(X());
        sb2.append('<');
        sb2.append(this.C);
        sb2.append('>');
        sb2.append(']');
        return sb2.toString();
    }
}
