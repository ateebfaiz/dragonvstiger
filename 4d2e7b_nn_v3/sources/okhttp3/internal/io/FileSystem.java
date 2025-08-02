package okhttp3.internal.io;

import com.google.firebase.messaging.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okio.Okio;
import okio.Sink;
import okio.Source;

public interface FileSystem {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final FileSystem SYSTEM = new Companion.SystemFileSystem();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        private static final class SystemFileSystem implements FileSystem {
            public Sink appendingSink(File file) throws FileNotFoundException {
                m.f(file, "file");
                try {
                    return Okio.appendingSink(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio.appendingSink(file);
                }
            }

            public void delete(File file) throws IOException {
                m.f(file, "file");
                if (!file.delete() && file.exists()) {
                    throw new IOException("failed to delete " + file);
                }
            }

            public void deleteContents(File file) throws IOException {
                m.f(file, "directory");
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    int length = listFiles.length;
                    int i10 = 0;
                    while (i10 < length) {
                        File file2 = listFiles[i10];
                        m.e(file2, "file");
                        if (file2.isDirectory()) {
                            deleteContents(file2);
                        }
                        if (file2.delete()) {
                            i10++;
                        } else {
                            throw new IOException("failed to delete " + file2);
                        }
                    }
                    return;
                }
                throw new IOException("not a readable directory: " + file);
            }

            public boolean exists(File file) {
                m.f(file, "file");
                return file.exists();
            }

            public void rename(File file, File file2) throws IOException {
                m.f(file, Constants.MessagePayloadKeys.FROM);
                m.f(file2, "to");
                delete(file2);
                if (!file.renameTo(file2)) {
                    throw new IOException("failed to rename " + file + " to " + file2);
                }
            }

            public Sink sink(File file) throws FileNotFoundException {
                m.f(file, "file");
                try {
                    return Okio__JvmOkioKt.sink$default(file, false, 1, (Object) null);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio__JvmOkioKt.sink$default(file, false, 1, (Object) null);
                }
            }

            public long size(File file) {
                m.f(file, "file");
                return file.length();
            }

            public Source source(File file) throws FileNotFoundException {
                m.f(file, "file");
                return Okio.source(file);
            }

            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    Sink appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    Sink sink(File file) throws FileNotFoundException;

    long size(File file);

    Source source(File file) throws FileNotFoundException;
}
