package b8;

import com.facebook.soloader.a0;
import com.facebook.soloader.b;
import com.facebook.soloader.m;
import com.facebook.soloader.y;

public class j implements f {
    public boolean a(UnsatisfiedLinkError unsatisfiedLinkError, a0[] a0VarArr) {
        String str;
        String str2;
        if (unsatisfiedLinkError instanceof y) {
            str = ((y) unsatisfiedLinkError).a();
        } else {
            str = null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Waiting on SoSources due to ");
        sb2.append(unsatisfiedLinkError);
        if (str == null) {
            str2 = "";
        } else {
            str2 = ", retrying for specific library " + str;
        }
        sb2.append(str2);
        m.b("SoLoader", sb2.toString());
        for (a0 a0Var : a0VarArr) {
            if (a0Var instanceof b) {
                m.b("SoLoader", "Waiting on SoSource " + a0Var.c());
                ((b) a0Var).a();
            }
        }
        return true;
    }
}
