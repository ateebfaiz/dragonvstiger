package e5;

import z2.a;

public abstract class h extends a {
    /* access modifiers changed from: protected */
    public void finalize() {
        if (!isClosed()) {
            a.I("CloseableImage", "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }
}
