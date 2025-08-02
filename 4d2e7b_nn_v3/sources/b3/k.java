package b3;

import java.io.IOException;
import java.io.OutputStream;
import y2.q;

public abstract class k extends OutputStream {
    public abstract h a();

    public void close() {
        try {
            super.close();
        } catch (IOException e10) {
            q.a(e10);
        }
    }

    public abstract int size();
}
