package androidx.core.util;

import android.util.AtomicFile;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.text.d;

public final class AtomicFileKt {
    public static final byte[] readBytes(AtomicFile atomicFile) {
        return atomicFile.readFully();
    }

    public static final String readText(AtomicFile atomicFile, Charset charset) {
        return new String(atomicFile.readFully(), charset);
    }

    public static /* synthetic */ String readText$default(AtomicFile atomicFile, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = d.f797b;
        }
        return readText(atomicFile, charset);
    }

    public static final void tryWrite(AtomicFile atomicFile, Function1<? super FileOutputStream, Unit> function1) {
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            function1.invoke(startWrite);
            k.b(1);
            atomicFile.finishWrite(startWrite);
            k.a(1);
        } catch (Throwable th) {
            k.b(1);
            atomicFile.failWrite(startWrite);
            k.a(1);
            throw th;
        }
    }

    public static final void writeBytes(AtomicFile atomicFile, byte[] bArr) {
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            startWrite.write(bArr);
            atomicFile.finishWrite(startWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(startWrite);
            throw th;
        }
    }

    public static final void writeText(AtomicFile atomicFile, String str, Charset charset) {
        byte[] bytes = str.getBytes(charset);
        m.e(bytes, "this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(AtomicFile atomicFile, String str, Charset charset, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            charset = d.f797b;
        }
        writeText(atomicFile, str, charset);
    }
}
