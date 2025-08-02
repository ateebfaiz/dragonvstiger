package tb;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.m;

public class f extends IOException {

    /* renamed from: a  reason: collision with root package name */
    private final File f2064a;

    /* renamed from: b  reason: collision with root package name */
    private final File f2065b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2066c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(File file, File file2, String str) {
        super(d.b(file, file2, str));
        m.f(file, "file");
        this.f2064a = file;
        this.f2065b = file2;
        this.f2066c = str;
    }
}
