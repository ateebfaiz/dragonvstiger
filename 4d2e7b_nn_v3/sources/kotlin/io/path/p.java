package kotlin.io.path;

import com.reactnativecommunity.asyncstorage.d;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import kotlin.jvm.internal.m;

public abstract class p {
    /* access modifiers changed from: private */
    public static final boolean c(i iVar) {
        for (i c10 = iVar.c(); c10 != null; c10 = c10.c()) {
            if (c10.b() == null || iVar.b() == null) {
                try {
                    if (Files.isSameFile(c10.d(), iVar.d())) {
                        return true;
                    }
                } catch (IOException | SecurityException unused) {
                    continue;
                }
            } else if (m.b(c10.b(), iVar.b())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final Object d(Path path, LinkOption[] linkOptionArr) {
        try {
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length);
            BasicFileAttributes a10 = Files.readAttributes(path, d.a(), (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length));
            m.e(a10, "readAttributes(...)");
            return a10.fileKey();
        } catch (Throwable unused) {
            return null;
        }
    }
}
