package xc;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;
import zd.f;

public class b extends BasicPermission {

    /* renamed from: a  reason: collision with root package name */
    private final String f2197a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2198b;

    public b(String str, String str2) {
        super(str, str2);
        this.f2197a = str2;
        this.f2198b = a(str2);
    }

    private int a(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(f.d(str), " ,");
        int i10 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.equals("threadlocalecimplicitlyca")) {
                i10 |= 1;
            } else if (nextToken.equals("ecimplicitlyca")) {
                i10 |= 2;
            } else if (nextToken.equals("threadlocaldhdefaultparams")) {
                i10 |= 4;
            } else if (nextToken.equals("dhdefaultparams")) {
                i10 |= 8;
            } else if (nextToken.equals("acceptableeccurves")) {
                i10 |= 16;
            } else if (nextToken.equals("additionalecparameters")) {
                i10 |= 32;
            } else if (nextToken.equals("all")) {
                i10 = 63;
            }
        }
        if (i10 != 0) {
            return i10;
        }
        throw new IllegalArgumentException("unknown permissions passed to mask");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f2198b != bVar.f2198b || !getName().equals(bVar.getName())) {
            return false;
        }
        return true;
    }

    public String getActions() {
        return this.f2197a;
    }

    public int hashCode() {
        return getName().hashCode() + this.f2198b;
    }

    public boolean implies(Permission permission) {
        if (!(permission instanceof b) || !getName().equals(permission.getName())) {
            return false;
        }
        int i10 = this.f2198b;
        int i11 = ((b) permission).f2198b;
        if ((i10 & i11) == i11) {
            return true;
        }
        return false;
    }
}
