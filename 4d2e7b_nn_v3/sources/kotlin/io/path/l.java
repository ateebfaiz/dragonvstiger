package kotlin.io.path;

import java.nio.file.FileSystemLoopException;

public abstract /* synthetic */ class l {
    public static /* synthetic */ FileSystemLoopException a(String str) {
        return new FileSystemLoopException(str);
    }
}
