package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.collections.i;
import kotlin.jvm.internal.m;

final class e extends SimpleFileVisitor {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f695a;

    /* renamed from: b  reason: collision with root package name */
    private i f696b;

    /* renamed from: c  reason: collision with root package name */
    private i f697c = new i();

    public e(boolean z10) {
        this.f695a = z10;
    }

    public FileVisitResult a(Path path, BasicFileAttributes basicFileAttributes) {
        m.f(path, "dir");
        m.f(basicFileAttributes, "attrs");
        this.f697c.add(new i(path, basicFileAttributes.fileKey(), this.f696b));
        FileVisitResult preVisitDirectory = super.preVisitDirectory(path, basicFileAttributes);
        m.e(preVisitDirectory, "preVisitDirectory(...)");
        return preVisitDirectory;
    }

    public final List b(i iVar) {
        m.f(iVar, "directoryNode");
        this.f696b = iVar;
        Path unused = Files.walkFileTree(iVar.d(), h.f698a.a(this.f695a), 1, b.a(this));
        this.f697c.removeFirst();
        i iVar2 = this.f697c;
        this.f697c = new i();
        return iVar2;
    }

    public FileVisitResult c(Path path, BasicFileAttributes basicFileAttributes) {
        m.f(path, "file");
        m.f(basicFileAttributes, "attrs");
        this.f697c.add(new i(path, (Object) null, this.f696b));
        FileVisitResult visitFile = super.visitFile(path, basicFileAttributes);
        m.e(visitFile, "visitFile(...)");
        return visitFile;
    }

    public /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes basicFileAttributes) {
        return a(a.a(obj), basicFileAttributes);
    }

    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes) {
        return c(a.a(obj), basicFileAttributes);
    }
}
