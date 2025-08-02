package kotlin.jvm.internal;

import zb.b;
import zb.e;

public abstract class i extends c implements h, e {
    private final int arity;
    private final int flags;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i(int r9, java.lang.Object r10, java.lang.Class r11, java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r8 = this;
            r0 = r14 & 1
            r1 = 1
            if (r0 != r1) goto L_0x0007
            r7 = r1
            goto L_0x0009
        L_0x0007:
            r0 = 0
            r7 = r0
        L_0x0009:
            r2 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r2.<init>(r3, r4, r5, r6, r7)
            r8.arity = r9
            int r9 = r14 >> 1
            r8.flags = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.i.<init>(int, java.lang.Object, java.lang.Class, java.lang.String, java.lang.String, int):void");
    }

    /* access modifiers changed from: protected */
    public b computeReflected() {
        return z.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (!getName().equals(iVar.getName()) || !getSignature().equals(iVar.getSignature()) || this.flags != iVar.flags || this.arity != iVar.arity || !m.b(getBoundReceiver(), iVar.getBoundReceiver()) || !m.b(getOwner(), iVar.getOwner())) {
                return false;
            }
            return true;
        } else if (obj instanceof e) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        int i10;
        if (getOwner() == null) {
            i10 = 0;
        } else {
            i10 = getOwner().hashCode() * 31;
        }
        return ((i10 + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public boolean isExternal() {
        return getReflected().isExternal();
    }

    public boolean isInfix() {
        return getReflected().isInfix();
    }

    public boolean isInline() {
        return getReflected().isInline();
    }

    public boolean isOperator() {
        return getReflected().isOperator();
    }

    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    /* access modifiers changed from: protected */
    public e getReflected() {
        return (e) super.getReflected();
    }
}
