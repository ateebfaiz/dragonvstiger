package b8;

import com.facebook.soloader.a0;

public class c implements f {

    /* renamed from: a  reason: collision with root package name */
    private final f[] f2504a;

    /* renamed from: b  reason: collision with root package name */
    private int f2505b = 0;

    public c(f... fVarArr) {
        this.f2504a = fVarArr;
    }

    public boolean a(UnsatisfiedLinkError unsatisfiedLinkError, a0[] a0VarArr) {
        int i10;
        f[] fVarArr;
        do {
            i10 = this.f2505b;
            fVarArr = this.f2504a;
            if (i10 >= fVarArr.length) {
                return false;
            }
            this.f2505b = i10 + 1;
        } while (!fVarArr[i10].a(unsatisfiedLinkError, a0VarArr));
        return true;
    }
}
