package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;

public abstract class StateVerifier {
    private static final boolean DEBUG = false;

    private static class DebugStateVerifier extends StateVerifier {
        private volatile RuntimeException recycledAtStackTraceException;

        DebugStateVerifier() {
            super();
        }

        /* access modifiers changed from: package-private */
        public void setRecycled(boolean z10) {
            if (z10) {
                this.recycledAtStackTraceException = new RuntimeException("Released");
            } else {
                this.recycledAtStackTraceException = null;
            }
        }

        public void throwIfRecycled() {
            if (this.recycledAtStackTraceException != null) {
                throw new IllegalStateException("Already released", this.recycledAtStackTraceException);
            }
        }
    }

    private static class DefaultStateVerifier extends StateVerifier {
        private volatile boolean isReleased;

        DefaultStateVerifier() {
            super();
        }

        public void setRecycled(boolean z10) {
            this.isReleased = z10;
        }

        public void throwIfRecycled() {
            if (this.isReleased) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    private StateVerifier() {
    }

    @NonNull
    public static StateVerifier newInstance() {
        return new DefaultStateVerifier();
    }

    /* access modifiers changed from: package-private */
    public abstract void setRecycled(boolean z10);

    public abstract void throwIfRecycled();
}
