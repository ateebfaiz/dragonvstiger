package tb;

import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class n extends f {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(File file, File file2, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i10 & 2) != 0 ? null : file2, (i10 & 4) != 0 ? null : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(File file, File file2, String str) {
        super(file, file2, str);
        m.f(file, "file");
    }
}
