package t8;

import com.fasterxml.jackson.annotation.i0;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.n;
import com.fasterxml.jackson.databind.b0;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final i0 f13120a;

    /* renamed from: b  reason: collision with root package name */
    public Object f13121b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f13122c = false;

    public t(i0 i0Var) {
        this.f13120a = i0Var;
    }

    public Object a(Object obj) {
        if (this.f13121b == null) {
            this.f13121b = this.f13120a.c(obj);
        }
        return this.f13121b;
    }

    public void b(f fVar, b0 b0Var, i iVar) {
        String str;
        this.f13122c = true;
        if (fVar.m()) {
            Object obj = this.f13121b;
            if (obj == null) {
                str = null;
            } else {
                str = String.valueOf(obj);
            }
            fVar.d0(str);
            return;
        }
        n nVar = iVar.f13085b;
        if (nVar != null) {
            fVar.S(nVar);
            iVar.f13087d.f(this.f13121b, fVar, b0Var);
        }
    }

    public boolean c(f fVar, b0 b0Var, i iVar) {
        if (this.f13121b == null) {
            return false;
        }
        if (!this.f13122c && !iVar.f13088e) {
            return false;
        }
        if (fVar.m()) {
            fVar.e0(String.valueOf(this.f13121b));
            return true;
        }
        iVar.f13087d.f(this.f13121b, fVar, b0Var);
        return true;
    }
}
