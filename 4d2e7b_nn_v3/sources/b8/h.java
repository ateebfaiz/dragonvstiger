package b8;

import com.facebook.soloader.a0;
import com.facebook.soloader.c;
import com.facebook.soloader.m;
import com.facebook.soloader.x;
import com.facebook.soloader.y;

public class h implements f {
    public boolean a(UnsatisfiedLinkError unsatisfiedLinkError, a0[] a0VarArr) {
        y yVar;
        String message;
        String str;
        if (!(unsatisfiedLinkError instanceof y) || (unsatisfiedLinkError instanceof x) || (message = yVar.getMessage()) == null || (!message.contains("/app/") && !message.contains("/mnt/"))) {
            return false;
        }
        String a10 = (yVar = (y) unsatisfiedLinkError).a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Reunpacking BackupSoSources due to ");
        sb2.append(unsatisfiedLinkError);
        if (a10 == null) {
            str = "";
        } else {
            str = ", retrying for specific library " + a10;
        }
        sb2.append(str);
        m.b("SoLoader", sb2.toString());
        for (c cVar : a0VarArr) {
            if (cVar instanceof c) {
                c cVar2 = cVar;
                try {
                    m.b("SoLoader", "Runpacking BackupSoSource " + cVar2.c());
                    cVar2.p();
                } catch (Exception e10) {
                    m.c("SoLoader", "Encountered an exception while reunpacking BackupSoSource " + cVar2.c() + " for library " + a10 + ": ", e10);
                    return false;
                }
            }
        }
        return true;
    }
}
