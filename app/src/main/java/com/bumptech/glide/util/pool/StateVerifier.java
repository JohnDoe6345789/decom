package com.bumptech.glide.util.pool;

/* loaded from: classes.dex */
public abstract class StateVerifier {
    private static final boolean DEBUG = false;

    private static class DebugStateVerifier extends StateVerifier {
        private volatile RuntimeException recycledAtStackTraceException;

        DebugStateVerifier() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        void setRecycled(boolean z2) {
            if (z2) {
                this.recycledAtStackTraceException = new RuntimeException("Released");
            } else {
                this.recycledAtStackTraceException = null;
            }
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
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

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean z2) {
            this.isReleased = z2;
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.isReleased) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public static StateVerifier newInstance() {
        return new DefaultStateVerifier();
    }

    abstract void setRecycled(boolean z2);

    public abstract void throwIfRecycled();

    private StateVerifier() {
    }
}
