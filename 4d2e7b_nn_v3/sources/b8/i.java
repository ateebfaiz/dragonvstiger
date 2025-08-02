package b8;

import com.facebook.soloader.a0;
import com.facebook.soloader.c;
import com.facebook.soloader.c0;
import com.facebook.soloader.m;
import com.facebook.soloader.x;
import com.facebook.soloader.y;

public class i implements f {
    public boolean a(UnsatisfiedLinkError unsatisfiedLinkError, a0[] a0VarArr) {
        String str;
        if (!(unsatisfiedLinkError instanceof y) || (unsatisfiedLinkError instanceof x)) {
            return false;
        }
        String a10 = ((y) unsatisfiedLinkError).a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Reunpacking NonApk UnpackingSoSources due to ");
        sb2.append(unsatisfiedLinkError);
        if (a10 == null) {
            str = "";
        } else {
            str = ", retrying for specific library " + a10;
        }
        sb2.append(str);
        m.b("SoLoader", sb2.toString());
        for (c0 c0Var : a0VarArr) {
            if (c0Var instanceof c0) {
                c0 c0Var2 = c0Var;
                if (!(c0Var2 instanceof c)) {
                    try {
                        m.b("SoLoader", "Runpacking " + c0Var2.c());
                        c0Var2.p();
                    } catch (Exception e10) {
                        m.c("SoLoader", "Encountered an exception while reunpacking " + c0Var2.c() + " for library " + a10 + ": ", e10);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
