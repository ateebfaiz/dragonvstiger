package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MethodCallsLogger {
    private final Map<String, Integer> calledMethods = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(String str, int i10) {
        int i11;
        m.f(str, "name");
        Integer num = this.calledMethods.get(str);
        boolean z10 = false;
        if (num != null) {
            i11 = num.intValue();
        } else {
            i11 = 0;
        }
        if ((i11 & i10) != 0) {
            z10 = true;
        }
        this.calledMethods.put(str, Integer.valueOf(i10 | i11));
        return !z10;
    }
}
