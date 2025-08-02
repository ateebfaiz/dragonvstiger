package tb;

import java.io.File;
import kotlin.io.FileWalkDirection;
import kotlin.jvm.internal.m;

class k extends j {
    public static final g i(File file, FileWalkDirection fileWalkDirection) {
        m.f(file, "<this>");
        m.f(fileWalkDirection, "direction");
        return new g(file, fileWalkDirection);
    }

    public static final g j(File file) {
        m.f(file, "<this>");
        return i(file, FileWalkDirection.BOTTOM_UP);
    }
}
